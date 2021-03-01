/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.utility.internal.primitive;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BooleanIterableIterateTest {

    private final BooleanIterable iterable = BooleanArrayList.newListWith(true, false, true);

    @Test
    public void forEach() {
        String[] sum = new String[2];
        sum[0] = "";
        sum[1] = "";
        BooleanIterableIterate.forEach(this.iterable, each -> sum[0] += each + " ");
        Assert.assertEquals("true false true ", sum[0]);
    }

    @Test
    public void select_target() {
        Verify.assertSize(2, BooleanIterableIterate.select(this.iterable, BooleanPredicates.equal(true), new BooleanArrayList(2)));
        Verify.assertSize(1, BooleanIterableIterate.select(this.iterable, BooleanPredicates.equal(false), new BooleanArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, BooleanIterableIterate.reject(this.iterable, BooleanPredicates.equal(true), new BooleanArrayList(1)));
        Verify.assertSize(2, BooleanIterableIterate.reject(this.iterable, BooleanPredicates.equal(false), new BooleanArrayList(1)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, BooleanIterableIterate.collect(this.iterable, booleanParameter -> !booleanParameter, FastList.newList()));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(BooleanIterableIterate.isEmpty(this.iterable));
    }

    @Test
    public void notEmpty() {
        Assert.assertTrue(BooleanIterableIterate.notEmpty(this.iterable));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        private BooleanIterableIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanIterableIterateTest();
        }

        @java.lang.Override
        public BooleanIterableIterateTest implementation() {
            return this.implementation;
        }
    }
}
