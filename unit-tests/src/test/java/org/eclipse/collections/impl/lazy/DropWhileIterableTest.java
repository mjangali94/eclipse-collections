/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DropWhileIterableTest extends AbstractLazyIterableTestCase {

    private DropWhileIterable<Integer> dropWhileIterable;

    private DropWhileIterable<Integer> emptyListDropWhileIterable;

    private DropWhileIterable<Integer> alwaysFalseDropWhileIterable;

    private DropWhileIterable<Integer> mostlyFalseDropWhileIterable;

    private DropWhileIterable<Integer> alwaysTrueDropWhileIterable;

    @Before
    public void setUp() {
        this.dropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), each -> each <= 2);
        this.emptyListDropWhileIterable = new DropWhileIterable<>(FastList.newList(), each -> each <= 2);
        this.alwaysFalseDropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), Predicates.alwaysFalse());
        this.mostlyFalseDropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), each -> each <= 4);
        this.alwaysTrueDropWhileIterable = new DropWhileIterable<>(Interval.oneTo(5), Predicates.alwaysTrue());
    }

    @Test
    public void basic() {
        Assert.assertEquals(3, this.dropWhileIterable.size());
        Assert.assertEquals(FastList.newListWith(3, 4, 5), this.dropWhileIterable.toList());
        Assert.assertEquals(0, this.emptyListDropWhileIterable.size());
        Assert.assertEquals(5, this.alwaysFalseDropWhileIterable.size());
        Assert.assertEquals(1, this.mostlyFalseDropWhileIterable.size());
        Assert.assertEquals(0, this.alwaysTrueDropWhileIterable.size());
    }

    @Test
    public void forEach() {
        Sum sum1 = new IntegerSum(0);
        this.dropWhileIterable.forEach(new SumProcedure<>(sum1));
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListDropWhileIterable.forEach(new SumProcedure<>(sum2));
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.alwaysFalseDropWhileIterable.forEach(new SumProcedure<>(sum3));
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.mostlyFalseDropWhileIterable.forEach(new SumProcedure<>(sum5));
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.alwaysTrueDropWhileIterable.forEach(new SumProcedure<>(sum6));
        Assert.assertEquals(0, sum6.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        Sum sum = new IntegerSum(0);
        FastList<Integer> indices = FastList.newList(5);
        ObjectIntProcedure<Integer> indexRecordingAndSumProcedure = (each, index) -> {
            indices.add(index);
            sum.add(each);
        };
        this.dropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2), indices);
        Assert.assertEquals(12, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.emptyListDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.alwaysFalseDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4), indices);
        Assert.assertEquals(15, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.mostlyFalseDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(FastList.newListWith(0), indices);
        Assert.assertEquals(5, sum.getValue().intValue());
        indices.clear();
        sum.add(sum.getValue().intValue() * -1);
        this.alwaysTrueDropWhileIterable.forEachWithIndex(indexRecordingAndSumProcedure);
        Assert.assertEquals(0, indices.size());
    }

    @Test
    public void forEachWith() {
        Procedure2<Integer, Sum> sumAdditionProcedure = (each, sum) -> sum.add(each);
        Sum sum1 = new IntegerSum(0);
        this.dropWhileIterable.forEachWith(sumAdditionProcedure, sum1);
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        this.emptyListDropWhileIterable.forEachWith(sumAdditionProcedure, sum2);
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        this.alwaysFalseDropWhileIterable.forEachWith(sumAdditionProcedure, sum3);
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        this.mostlyFalseDropWhileIterable.forEachWith(sumAdditionProcedure, sum5);
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        this.alwaysTrueDropWhileIterable.forEachWith(sumAdditionProcedure, sum6);
        Assert.assertEquals(0, sum6.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        Sum sum1 = new IntegerSum(0);
        for (Integer each : this.dropWhileIterable) {
            sum1.add(each);
        }
        Assert.assertEquals(12, sum1.getValue().intValue());
        Sum sum2 = new IntegerSum(0);
        for (Integer each : this.emptyListDropWhileIterable) {
            sum2.add(each);
        }
        Assert.assertEquals(0, sum2.getValue().intValue());
        Sum sum3 = new IntegerSum(0);
        for (Integer each : this.alwaysFalseDropWhileIterable) {
            sum3.add(each);
        }
        Assert.assertEquals(15, sum3.getValue().intValue());
        Sum sum5 = new IntegerSum(0);
        for (Integer each : this.mostlyFalseDropWhileIterable) {
            sum5.add(each);
        }
        Assert.assertEquals(5, sum5.getValue().intValue());
        Sum sum6 = new IntegerSum(0);
        for (Integer each : this.alwaysTrueDropWhileIterable) {
            sum6.add(each);
        }
        Assert.assertEquals(0, sum6.getValue().intValue());
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.dropWhile(FastList.newListWith(elements), Predicates.alwaysFalse());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        Assert.assertEquals(FastList.newListWith(2, 3, 4, 5), new DropWhileIterable<>(FastList.newListWith(1, 1, 2, 3, 3, 3, 4, 5), each -> each % 2 != 0).distinct().toList());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basic() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basic, this.description("basic"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private DropWhileIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DropWhileIterableTest();
        }

        @java.lang.Override
        public DropWhileIterableTest implementation() {
            return this.implementation;
        }
    }
}
