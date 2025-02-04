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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatIterableIterate}.
 * This file was automatically generated from template file primitiveIterableIterateTest.stg.
 */
public class FloatIterableIterateTest {

    private final FloatIterable iterable = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);

    @Test
    public void forEach() {
        double[] sum = new double[1];
        FloatIterableIterate.forEach(this.iterable, (float each) -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void select_target() {
        Verify.assertSize(2, FloatIterableIterate.select(this.iterable, FloatPredicates.greaterThan(1.0f), new FloatArrayList(2)));
        Verify.assertSize(1, FloatIterableIterate.select(this.iterable, FloatPredicates.greaterThan(2.0f), new FloatArrayList(1)));
        Verify.assertEmpty(FloatIterableIterate.select(this.iterable, FloatPredicates.lessThan(0.0f), new FloatArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, FloatIterableIterate.reject(this.iterable, FloatPredicates.greaterThan(1.0f), new FloatArrayList(1)));
        Verify.assertEmpty(FloatIterableIterate.reject(this.iterable, FloatPredicates.greaterThan(0.0f), new FloatArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, FloatIterableIterate.collect(this.iterable, String::valueOf, FastList.<String>newList()));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatIterableIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIterableIterateTest> payload) throws java.lang.Throwable {
            this.instance = new FloatIterableIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIterableIterateTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIterableIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIterableIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatIterableIterateTest> collect_target;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEach = FloatIterableIterateTest::forEach;
            this.payloads.select_target = FloatIterableIterateTest::select_target;
            this.payloads.reject_target = FloatIterableIterateTest::reject_target;
            this.payloads.collect_target = FloatIterableIterateTest::collect_target;
        }
    }
*/
}
