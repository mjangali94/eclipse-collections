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

import org.eclipse.collections.api.InternalIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class RejectIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.reject(FastList.newListWith(elements), ignored -> false);
    }

    @Test
    public void forEach() {
        InternalIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEach(new SumProcedure<>(sum));
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(2).or(Predicates.greaterThan(3)));
        Sum sum = new IntegerSum(0);
        select.forEachWithIndex((object, index) -> {
            sum.add(object);
            sum.add(index);
        });
        Assert.assertEquals(6, sum.getValue().intValue());
    }

    @Override
    @Test
    public void iterator() {
        InternalIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        for (Integer each : select) {
            sum.add(each);
        }
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Test
    public void forEachWith() {
        InternalIterable<Integer> select = new RejectIterable<>(Interval.oneTo(5), Predicates.lessThan(5));
        Sum sum = new IntegerSum(0);
        select.forEachWith((each, aSum) -> aSum.add(each), sum);
        Assert.assertEquals(5, sum.getValue().intValue());
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        RejectIterable<Integer> iterable = new RejectIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5), Predicates.lessThan(2));
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 5), iterable.distinct().toList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

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

        private RejectIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new RejectIterableTest();
        }

        @java.lang.Override
        public RejectIterableTest implementation() {
            return this.implementation;
        }
    }
}
