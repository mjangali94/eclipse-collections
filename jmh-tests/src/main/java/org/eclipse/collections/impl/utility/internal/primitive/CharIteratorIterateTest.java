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
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class CharIteratorIterateTest {

    private final CharIterable iterable = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);

    @Test
    public void select_target() {
        Verify.assertSize(2, CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(2)));
        Verify.assertSize(2, CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(3)));
        Verify.assertEmpty(CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.lessThan((char) 0), new CharArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, CharIteratorIterate.reject(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(1)));
        Verify.assertEmpty(CharIteratorIterate.reject(this.iterable.charIterator(), CharPredicates.greaterThan((char) 0), new CharArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, CharIteratorIterate.collect(this.iterable.charIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, CharIteratorIterate.sum(this.iterable.charIterator()));
        Assert.assertEquals(0L, CharIteratorIterate.sum(new CharArrayList().charIterator()));
    }

    @Test
    public void min() {
        Assert.assertEquals((char) 1, CharIteratorIterate.min(this.iterable.charIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> CharIteratorIterate.min(new CharArrayList().charIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals((char) 1, CharIteratorIterate.min(this.iterable.charIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> CharIteratorIterate.max(new CharArrayList().charIterator()));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharIteratorIterateTest instance;

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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> payload) throws java.lang.Throwable {
            this.instance = new CharIteratorIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> select_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> reject_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIteratorIterateTest> max;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.select_target = CharIteratorIterateTest::select_target;
            this.payloads.reject_target = CharIteratorIterateTest::reject_target;
            this.payloads.collect_target = CharIteratorIterateTest::collect_target;
            this.payloads.sum = CharIteratorIterateTest::sum;
            this.payloads.min = CharIteratorIterateTest::min;
            this.payloads.max = CharIteratorIterateTest::max;
        }
    }
*/
}
