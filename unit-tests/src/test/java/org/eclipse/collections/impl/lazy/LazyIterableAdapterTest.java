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
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LazyIterableAdapterTest extends AbstractLazyIterableTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LazyIterableAdapterTest.class);

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return new LazyIterableAdapter<>(FastList.newListWith(elements));
    }

    @Test
    public void forEach() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(15, sum.getValue().intValue());
    }

    @Test
    public void into() {
        int sum = new LazyIterableAdapter<>(Interval.oneTo(5)).into(FastList.newList()).injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(15, sum);
    }

    @Test
    public void forEachWithIndex() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
            LOGGER.info("value={} index={}", object, index);
        });
        Assert.assertEquals(25, sum.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(15, sum.getValue().intValue());
    }

    @Test
    public void forEachWith() {
        LazyIterable<Integer> select = new LazyIterableAdapter<>(Interval.oneTo(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(15, sum.getValue().intValue());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        LazyIterable<Integer> iterable = new LazyIterableAdapter<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5));
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1, 5), iterable.distinct().toList());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_into() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::into, this.description("into"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        private LazyIterableAdapterTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LazyIterableAdapterTest();
        }

        @java.lang.Override
        public LazyIterableAdapterTest implementation() {
            return this.implementation;
        }
    }
}
