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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteIterableIterate}.
 * This file was automatically generated from template file primitiveIterableIterateTest.stg.
 */
public class ByteIterableIterateTest {

    private final ByteIterable iterable = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);

    @Test
    public void forEach() {
        long[] sum = new long[1];
        ByteIterableIterate.forEach(this.iterable, (byte each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void select_target() {
        Verify.assertSize(2, ByteIterableIterate.select(this.iterable, BytePredicates.greaterThan((byte) 1), new ByteArrayList(2)));
        Verify.assertSize(1, ByteIterableIterate.select(this.iterable, BytePredicates.greaterThan((byte) 2), new ByteArrayList(1)));
        Verify.assertEmpty(ByteIterableIterate.select(this.iterable, BytePredicates.lessThan((byte) 0), new ByteArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, ByteIterableIterate.reject(this.iterable, BytePredicates.greaterThan((byte) 1), new ByteArrayList(1)));
        Verify.assertEmpty(ByteIterableIterate.reject(this.iterable, BytePredicates.greaterThan((byte) 0), new ByteArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, ByteIterableIterate.collect(this.iterable, String::valueOf, FastList.<String>newList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select_target, this.description("select_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject_target, this.description("reject_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_target, this.description("collect_target"));
        }

        private ByteIterableIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteIterableIterateTest();
        }

        @java.lang.Override
        public ByteIterableIterateTest implementation() {
            return this.implementation;
        }
    }
}
