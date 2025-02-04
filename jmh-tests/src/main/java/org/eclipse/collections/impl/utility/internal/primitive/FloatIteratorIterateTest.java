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
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class FloatIteratorIterateTest {

    private final FloatIterable iterable = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);

    @Test
    public void select_target() {
        Verify.assertSize(2, FloatIteratorIterate.select(this.iterable.floatIterator(), FloatPredicates.greaterThan(1.0f), new FloatArrayList(2)));
        Verify.assertSize(2, FloatIteratorIterate.select(this.iterable.floatIterator(), FloatPredicates.greaterThan(1.0f), new FloatArrayList(3)));
        Verify.assertEmpty(FloatIteratorIterate.select(this.iterable.floatIterator(), FloatPredicates.lessThan(0.0f), new FloatArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, FloatIteratorIterate.reject(this.iterable.floatIterator(), FloatPredicates.greaterThan(1.0f), new FloatArrayList(1)));
        Verify.assertEmpty(FloatIteratorIterate.reject(this.iterable.floatIterator(), FloatPredicates.greaterThan(0.0f), new FloatArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, FloatIteratorIterate.collect(this.iterable.floatIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6.0, FloatIteratorIterate.sum(this.iterable.floatIterator()), 0.0);
        Assert.assertEquals(0.0, FloatIteratorIterate.sum(new FloatArrayList().floatIterator()), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = FloatArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())).toArray());
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void min() {
        Assert.assertEquals(1.0f, FloatIteratorIterate.min(this.iterable.floatIterator()), 0.0);
        Assert.assertThrows(NoSuchElementException.class, () -> FloatIteratorIterate.min(new FloatArrayList().floatIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals(1.0f, FloatIteratorIterate.min(this.iterable.floatIterator()), 0.0);
        Assert.assertThrows(NoSuchElementException.class, () -> FloatIteratorIterate.max(new FloatArrayList().floatIterator()));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatIteratorIterateTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> payload) throws java.lang.Throwable {
            this.instance = new FloatIteratorIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIteratorIterateTest> max;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.select_target = FloatIteratorIterateTest::select_target;
            this.payloads.reject_target = FloatIteratorIterateTest::reject_target;
            this.payloads.collect_target = FloatIteratorIterateTest::collect_target;
            this.payloads.sum = FloatIteratorIterateTest::sum;
            this.payloads.sumConsistentRounding = FloatIteratorIterateTest::sumConsistentRounding;
            this.payloads.min = FloatIteratorIterateTest::min;
            this.payloads.max = FloatIteratorIterateTest::max;
        }
    }
*/
}
