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
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class IntIteratorIterateTest {

    private final IntIterable iterable = IntArrayList.newListWith(1, 2, 3);

    @Test
    public void select_target() {
        Verify.assertSize(2, IntIteratorIterate.select(this.iterable.intIterator(), IntPredicates.greaterThan(1), new IntArrayList(2)));
        Verify.assertSize(2, IntIteratorIterate.select(this.iterable.intIterator(), IntPredicates.greaterThan(1), new IntArrayList(3)));
        Verify.assertEmpty(IntIteratorIterate.select(this.iterable.intIterator(), IntPredicates.lessThan(0), new IntArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, IntIteratorIterate.reject(this.iterable.intIterator(), IntPredicates.greaterThan(1), new IntArrayList(1)));
        Verify.assertEmpty(IntIteratorIterate.reject(this.iterable.intIterator(), IntPredicates.greaterThan(0), new IntArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, IntIteratorIterate.collect(this.iterable.intIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, IntIteratorIterate.sum(this.iterable.intIterator()));
        Assert.assertEquals(0L, IntIteratorIterate.sum(new IntArrayList().intIterator()));
    }

    @Test
    public void min() {
        Assert.assertEquals(1, IntIteratorIterate.min(this.iterable.intIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> IntIteratorIterate.min(new IntArrayList().intIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals(1, IntIteratorIterate.min(this.iterable.intIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> IntIteratorIterate.max(new IntArrayList().intIterator()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntIteratorIterateTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> payload) throws java.lang.Throwable {
            this.instance = new IntIteratorIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntIteratorIterateTest> max;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.select_target = IntIteratorIterateTest::select_target;
            this.payloads.reject_target = IntIteratorIterateTest::reject_target;
            this.payloads.collect_target = IntIteratorIterateTest::collect_target;
            this.payloads.sum = IntIteratorIterateTest::sum;
            this.payloads.min = IntIteratorIterateTest::min;
            this.payloads.max = IntIteratorIterateTest::max;
        }
    }
}
