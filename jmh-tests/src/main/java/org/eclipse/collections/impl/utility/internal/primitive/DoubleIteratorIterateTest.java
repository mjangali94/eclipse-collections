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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumConsistentRounding, this.description("sumConsistentRounding"));
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

        private DoubleIteratorIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleIteratorIterateTest();
        }

        @java.lang.Override
        public DoubleIteratorIterateTest implementation() {
            return this.implementation;
        }
    }
}
