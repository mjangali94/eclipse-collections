/*
 * Copyright (c) 2022 Goldman Sachs.
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

/**
 * Provides a set of common tests of predicates for double values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class DoublePredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(DoublePredicates.equal(5.0).accept(5.0));
        Assert.assertFalse(DoublePredicates.equal(5.0).accept(6.0));
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(DoublePredicates.lessThan(5.0).accept(4.0));
        Assert.assertFalse(DoublePredicates.lessThan(5.0).accept(6.0));
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(DoublePredicates.greaterThan(5.0).accept(6.0));
        Assert.assertFalse(DoublePredicates.greaterThan(5.0).accept(4.0));
    }

    @Test
    public void alwaysTrue() {
        Assert.assertTrue(DoublePredicates.alwaysTrue().accept(5.0));
    }

    @Test
    public void alwaysFalse() {
        Assert.assertFalse(DoublePredicates.alwaysFalse().accept(5.0));
    }

    @Test
    public void equalWithDelta() {
        Assert.assertFalse(DoublePredicates.not(DoublePredicates.equal(5.0, Double.valueOf("1e-15"))).accept(5.0));
        Assert.assertFalse(DoublePredicates.not(DoublePredicates.equal(5.0, 2.0)).accept(6.0));
        Assert.assertTrue(DoublePredicates.not(DoublePredicates.equal(5.0, Double.valueOf("1e-15"))).accept(6.0));
        Assert.assertTrue(DoublePredicates.not(DoublePredicates.equal(5.0, 1.0)).accept(7.0));
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(DoublePredicates.and(DoublePredicates.greaterThan(5.0), DoublePredicates.lessThan(7.0)).accept(6.0));
        Assert.assertFalse(DoublePredicates.and(DoublePredicates.greaterThan(5.0), DoublePredicates.lessThan(7.0)).accept(8.0));
        Assert.assertFalse(DoublePredicates.and(DoublePredicates.greaterThan(5.0), DoublePredicates.lessThan(7.0)).accept(4.0));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(DoublePredicates.or(DoublePredicates.lessThan(5.0), DoublePredicates.greaterThan(7.0)).accept(6.0));
        Assert.assertTrue(DoublePredicates.or(DoublePredicates.lessThan(5.0), DoublePredicates.greaterThan(7.0)).accept(4.0));
        Assert.assertTrue(DoublePredicates.or(DoublePredicates.lessThan(5.0), DoublePredicates.greaterThan(7.0)).accept(8.0));
    }

    @Test
    public void testNot() {
        Assert.assertFalse(DoublePredicates.not(DoublePredicates.equal(5.0)).accept(5.0));
        Assert.assertTrue(DoublePredicates.not(DoublePredicates.equal(5.0)).accept(6.0));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoublePredicates.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqual() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEqual, this.description("testEqual"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLessThan() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testLessThan, this.description("testLessThan"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGreaterThan() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGreaterThan, this.description("testGreaterThan"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysTrue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::alwaysTrue, this.description("alwaysTrue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysFalse() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::alwaysFalse, this.description("alwaysFalse"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalWithDelta() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalWithDelta, this.description("equalWithDelta"));
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
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private DoublePredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoublePredicatesTest();
        }

        @java.lang.Override
        public DoublePredicatesTest implementation() {
            return this.implementation;
        }
    }
}
