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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleIterableIterate}.
 * This file was automatically generated from template file primitiveIterableIterateTest.stg.
 */
public class DoubleIterableIterateTest {

    private final DoubleIterable iterable = DoubleArrayList.newListWith(1.0, 2.0, 3.0);

    @Test
    public void forEach() {
        double[] sum = new double[1];
        DoubleIterableIterate.forEach(this.iterable, (double each) -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void select_target() {
        Verify.assertSize(2, DoubleIterableIterate.select(this.iterable, DoublePredicates.greaterThan(1.0), new DoubleArrayList(2)));
        Verify.assertSize(1, DoubleIterableIterate.select(this.iterable, DoublePredicates.greaterThan(2.0), new DoubleArrayList(1)));
        Verify.assertEmpty(DoubleIterableIterate.select(this.iterable, DoublePredicates.lessThan(0.0), new DoubleArrayList(3)));
    }

    @Test
    public void reject_target() {
        Verify.assertSize(1, DoubleIterableIterate.reject(this.iterable, DoublePredicates.greaterThan(1.0), new DoubleArrayList(1)));
        Verify.assertEmpty(DoubleIterableIterate.reject(this.iterable, DoublePredicates.greaterThan(0.0), new DoubleArrayList(0)));
    }

    @Test
    public void collect_target() {
        Verify.assertIterableSize(3, DoubleIterableIterate.collect(this.iterable, String::valueOf, FastList.<String>newList()));
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

        private DoubleIterableIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleIterableIterateTest();
        }

        @java.lang.Override
        public DoubleIterableIterateTest implementation() {
            return this.implementation;
        }
    }
}
