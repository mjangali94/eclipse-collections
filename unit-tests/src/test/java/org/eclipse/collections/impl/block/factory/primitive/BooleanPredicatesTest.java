/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.factory.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public final class BooleanPredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(BooleanPredicates.equal(true).accept(true));
        Assert.assertTrue(BooleanPredicates.equal(false).accept(false));
        Assert.assertFalse(BooleanPredicates.equal(true).accept(false));
        Assert.assertFalse(BooleanPredicates.equal(false).accept(true));
    }

    @Test
    public void testIsTrue() {
        Assert.assertTrue(BooleanPredicates.isTrue().accept(true));
        Assert.assertFalse(BooleanPredicates.isTrue().accept(false));
    }

    @Test
    public void testIsFalse() {
        Assert.assertTrue(BooleanPredicates.isFalse().accept(false));
        Assert.assertFalse(BooleanPredicates.isFalse().accept(true));
    }

    @Test
    public void testAnd() {
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.equal(true)).accept(false));
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.equal(false)).accept(false));
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.equal(true)).accept(false));
        Assert.assertTrue(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.equal(false)).accept(false));
        Assert.assertTrue(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.equal(true)).accept(true));
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.equal(false)).accept(false));
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.equal(true)).accept(true));
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isFalse(), BooleanPredicates.equal(false)).accept(true));
        Assert.assertFalse(BooleanPredicates.and(BooleanPredicates.isFalse(), value -> !value).accept(true));
        Assert.assertTrue(BooleanPredicates.and(BooleanPredicates.isFalse(), value -> !value).accept(false));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.equal(true)).accept(false));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.equal(false)).accept(false));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.equal(true)).accept(false));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.equal(false)).accept(false));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.equal(true)).accept(true));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.equal(false)).accept(true));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.equal(true)).accept(true));
        Assert.assertFalse(BooleanPredicates.or(BooleanPredicates.isFalse(), BooleanPredicates.equal(false)).accept(true));
        Assert.assertTrue(BooleanPredicates.or(BooleanPredicates.isFalse(), value -> !value).accept(false));
        Assert.assertFalse(BooleanPredicates.or(BooleanPredicates.isFalse(), value -> !value).accept(true));
    }

    @Test
    public void testNot() {
        Assert.assertTrue(BooleanPredicates.not(BooleanPredicates.isTrue()).accept(false));
        Assert.assertFalse(BooleanPredicates.not(BooleanPredicates.isTrue()).accept(true));
        Assert.assertTrue(BooleanPredicates.not(BooleanPredicates.isFalse()).accept(true));
        Assert.assertFalse(BooleanPredicates.not(BooleanPredicates.isFalse()).accept(false));
        Assert.assertTrue(BooleanPredicates.not(true).accept(false));
        Assert.assertFalse(BooleanPredicates.not(true).accept(true));
        Assert.assertTrue(BooleanPredicates.not(false).accept(true));
        Assert.assertFalse(BooleanPredicates.not(false).accept(false));
    }

    @Test
    public void testAlwaysTrue() {
        Assert.assertTrue(BooleanPredicates.alwaysTrue().accept(false));
        Assert.assertTrue(BooleanPredicates.alwaysTrue().accept(true));
    }

    @Test
    public void testAlwaysFalse() {
        Assert.assertFalse(BooleanPredicates.alwaysFalse().accept(false));
        Assert.assertFalse(BooleanPredicates.alwaysFalse().accept(true));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(BooleanPredicates.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqual() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEqual, this.description("testEqual"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsTrue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIsTrue, this.description("testIsTrue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsFalse() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIsFalse, this.description("testIsFalse"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAnd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAnd, this.description("testAnd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOr() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testOr, this.description("testOr"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNot, this.description("testNot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAlwaysTrue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAlwaysTrue, this.description("testAlwaysTrue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAlwaysFalse() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testAlwaysFalse, this.description("testAlwaysFalse"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private BooleanPredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanPredicatesTest();
        }

        @java.lang.Override
        public BooleanPredicatesTest implementation() {
            return this.implementation;
        }
    }
}
