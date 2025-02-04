/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.internal.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class DoubleIteratorIterateTest {

    private final DoubleIterable iterable = DoubleArrayList.newListWith(1.0, 2.0, 3.0);

    @Test
    public void select_target() {
        Verify.assertSize(2, DoubleIteratorIterate.select(this.iterable.doubleIterator(), DoublePredicates.greaterThan(1.0), new DoubleArrayList(2)));
        Verify.assertSize(2, DoubleIteratorIterate.select(this.iterable.doubleIterator(), DoublePredicates.greaterThan(1.0), new DoubleArrayList(3)));
        Verify.assertEmpty(DoubleIteratorIterate.select(this.iterable.doubleIterator(), DoublePredicates.lessThan(0.0), new DoubleArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, DoubleIteratorIterate.reject(this.iterable.doubleIterator(), DoublePredicates.greaterThan(1.0), new DoubleArrayList(1)));
        Verify.assertEmpty(DoubleIteratorIterate.reject(this.iterable.doubleIterator(), DoublePredicates.greaterThan(0.0), new DoubleArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, DoubleIteratorIterate.collect(this.iterable.doubleIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6.0, DoubleIteratorIterate.sum(this.iterable.doubleIterator()), 0.0);
        Assert.assertEquals(0.0, DoubleIteratorIterate.sum(new DoubleArrayList().doubleIterator()), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        DoubleIterable iterable = DoubleArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).toArray());
        Assert.assertEquals(1.082323233711138, iterable.sum(), 1.0e-15);
    }

    @Test
    public void min() {
        Assert.assertEquals(1.0, DoubleIteratorIterate.min(this.iterable.doubleIterator()), 0.0);
        Assert.assertThrows(NoSuchElementException.class, () -> DoubleIteratorIterate.min(new DoubleArrayList().doubleIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals(1.0, DoubleIteratorIterate.min(this.iterable.doubleIterator()), 0.0);
        Assert.assertThrows(NoSuchElementException.class, () -> DoubleIteratorIterate.max(new DoubleArrayList().doubleIterator()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleIteratorIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleIteratorIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIteratorIterateTest> max;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.select_target = DoubleIteratorIterateTest::select_target;
            this.payloads.reject_target = DoubleIteratorIterateTest::reject_target;
            this.payloads.collect_target = DoubleIteratorIterateTest::collect_target;
            this.payloads.sum = DoubleIteratorIterateTest::sum;
            this.payloads.sumConsistentRounding = DoubleIteratorIterateTest::sumConsistentRounding;
            this.payloads.min = DoubleIteratorIterateTest::min;
            this.payloads.max = DoubleIteratorIterateTest::max;
        }
    }
}
