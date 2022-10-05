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
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class ByteIteratorIterateTest {

    private final ByteIterable iterable = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);

    @Test
    public void select_target() {
        Verify.assertSize(2, ByteIteratorIterate.select(this.iterable.byteIterator(), BytePredicates.greaterThan((byte) 1), new ByteArrayList(2)));
        Verify.assertSize(2, ByteIteratorIterate.select(this.iterable.byteIterator(), BytePredicates.greaterThan((byte) 1), new ByteArrayList(3)));
        Verify.assertEmpty(ByteIteratorIterate.select(this.iterable.byteIterator(), BytePredicates.lessThan((byte) 0), new ByteArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, ByteIteratorIterate.reject(this.iterable.byteIterator(), BytePredicates.greaterThan((byte) 1), new ByteArrayList(1)));
        Verify.assertEmpty(ByteIteratorIterate.reject(this.iterable.byteIterator(), BytePredicates.greaterThan((byte) 0), new ByteArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, ByteIteratorIterate.collect(this.iterable.byteIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, ByteIteratorIterate.sum(this.iterable.byteIterator()));
        Assert.assertEquals(0L, ByteIteratorIterate.sum(new ByteArrayList().byteIterator()));
    }

    @Test
    public void min() {
        Assert.assertEquals((byte) 1, ByteIteratorIterate.min(this.iterable.byteIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> ByteIteratorIterate.min(new ByteArrayList().byteIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals((byte) 1, ByteIteratorIterate.min(this.iterable.byteIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> ByteIteratorIterate.max(new ByteArrayList().byteIterator()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteIteratorIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> payload) throws java.lang.Throwable {
            this.instance = new ByteIteratorIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteIteratorIterateTest> max;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.select_target = ByteIteratorIterateTest::select_target;
            this.payloads.reject_target = ByteIteratorIterateTest::reject_target;
            this.payloads.collect_target = ByteIteratorIterateTest::collect_target;
            this.payloads.sum = ByteIteratorIterateTest::sum;
            this.payloads.min = ByteIteratorIterateTest::min;
            this.payloads.max = ByteIteratorIterateTest::max;
        }
    }
}
