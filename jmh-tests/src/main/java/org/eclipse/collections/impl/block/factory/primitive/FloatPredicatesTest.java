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
 * Provides a set of common tests of predicates for float values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class FloatPredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(FloatPredicates.equal(5.0f).accept(5.0f));
        Assert.assertFalse(FloatPredicates.equal(5.0f).accept(6.0f));
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(FloatPredicates.lessThan(5.0f).accept(4.0f));
        Assert.assertFalse(FloatPredicates.lessThan(5.0f).accept(6.0f));
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(FloatPredicates.greaterThan(5.0f).accept(6.0f));
        Assert.assertFalse(FloatPredicates.greaterThan(5.0f).accept(4.0f));
    }

    @Test
    public void alwaysTrue() {
        Assert.assertTrue(FloatPredicates.alwaysTrue().accept(5.0f));
    }

    @Test
    public void alwaysFalse() {
        Assert.assertFalse(FloatPredicates.alwaysFalse().accept(5.0f));
    }

    @Test
    public void equalWithDelta() {
        Assert.assertFalse(FloatPredicates.not(FloatPredicates.equal(5.0f, Float.valueOf("1e-15"))).accept(5.0f));
        Assert.assertFalse(FloatPredicates.not(FloatPredicates.equal(5.0f, 2.0f)).accept(6.0f));
        Assert.assertTrue(FloatPredicates.not(FloatPredicates.equal(5.0f, Float.valueOf("1e-15"))).accept(6.0f));
        Assert.assertTrue(FloatPredicates.not(FloatPredicates.equal(5.0f, 1.0f)).accept(7.0f));
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(FloatPredicates.and(FloatPredicates.greaterThan(5.0f), FloatPredicates.lessThan(7.0f)).accept(6.0f));
        Assert.assertFalse(FloatPredicates.and(FloatPredicates.greaterThan(5.0f), FloatPredicates.lessThan(7.0f)).accept(8.0f));
        Assert.assertFalse(FloatPredicates.and(FloatPredicates.greaterThan(5.0f), FloatPredicates.lessThan(7.0f)).accept(4.0f));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(FloatPredicates.or(FloatPredicates.lessThan(5.0f), FloatPredicates.greaterThan(7.0f)).accept(6.0f));
        Assert.assertTrue(FloatPredicates.or(FloatPredicates.lessThan(5.0f), FloatPredicates.greaterThan(7.0f)).accept(4.0f));
        Assert.assertTrue(FloatPredicates.or(FloatPredicates.lessThan(5.0f), FloatPredicates.greaterThan(7.0f)).accept(8.0f));
    }

    @Test
    public void testNot() {
        Assert.assertFalse(FloatPredicates.not(FloatPredicates.equal(5.0f)).accept(5.0f));
        Assert.assertTrue(FloatPredicates.not(FloatPredicates.equal(5.0f)).accept(6.0f));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatPredicates.class);
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

        private FloatPredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatPredicatesTest();
        }

        @java.lang.Override
        public FloatPredicatesTest implementation() {
            return this.implementation;
        }
    }
}
