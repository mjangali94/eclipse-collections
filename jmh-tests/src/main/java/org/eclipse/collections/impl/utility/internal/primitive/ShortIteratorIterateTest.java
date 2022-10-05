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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class ShortIteratorIterateTest {

    private final ShortIterable iterable = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);

    @Test
    public void select_target() {
        Verify.assertSize(2, ShortIteratorIterate.select(this.iterable.shortIterator(), ShortPredicates.greaterThan((short) 1), new ShortArrayList(2)));
        Verify.assertSize(2, ShortIteratorIterate.select(this.iterable.shortIterator(), ShortPredicates.greaterThan((short) 1), new ShortArrayList(3)));
        Verify.assertEmpty(ShortIteratorIterate.select(this.iterable.shortIterator(), ShortPredicates.lessThan((short) 0), new ShortArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, ShortIteratorIterate.reject(this.iterable.shortIterator(), ShortPredicates.greaterThan((short) 1), new ShortArrayList(1)));
        Verify.assertEmpty(ShortIteratorIterate.reject(this.iterable.shortIterator(), ShortPredicates.greaterThan((short) 0), new ShortArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, ShortIteratorIterate.collect(this.iterable.shortIterator(), String::valueOf, FastList.newList()));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, ShortIteratorIterate.sum(this.iterable.shortIterator()));
        Assert.assertEquals(0L, ShortIteratorIterate.sum(new ShortArrayList().shortIterator()));
    }

    @Test
    public void min() {
        Assert.assertEquals((short) 1, ShortIteratorIterate.min(this.iterable.shortIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> ShortIteratorIterate.min(new ShortArrayList().shortIterator()));
    }

    @Test
    public void max() {
        Assert.assertEquals((short) 1, ShortIteratorIterate.min(this.iterable.shortIterator()));
        Assert.assertThrows(NoSuchElementException.class, () -> ShortIteratorIterate.max(new ShortArrayList().shortIterator()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        private ShortIteratorIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortIteratorIterateTest();
        }

        @java.lang.Override
        public ShortIteratorIterateTest implementation() {
            return this.implementation;
        }
    }
}
