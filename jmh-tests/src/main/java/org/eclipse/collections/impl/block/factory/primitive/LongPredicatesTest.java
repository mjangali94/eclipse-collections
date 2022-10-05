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
 * Provides a set of common tests of predicates for long values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class LongPredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(LongPredicates.equal(5L).accept(5L));
        Assert.assertFalse(LongPredicates.equal(5L).accept(6L));
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(LongPredicates.lessThan(5L).accept(4L));
        Assert.assertFalse(LongPredicates.lessThan(5L).accept(6L));
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(LongPredicates.greaterThan(5L).accept(6L));
        Assert.assertFalse(LongPredicates.greaterThan(5L).accept(4L));
    }

    @Test
    public void alwaysTrue() {
        Assert.assertTrue(LongPredicates.alwaysTrue().accept(5L));
    }

    @Test
    public void alwaysFalse() {
        Assert.assertFalse(LongPredicates.alwaysFalse().accept(5L));
    }

    @Test
    public void testIsOdd() {
        Assert.assertTrue(LongPredicates.isOdd().accept(5L));
        Assert.assertFalse(LongPredicates.isOdd().accept(6L));
    }

    @Test
    public void testIsEven() {
        Assert.assertTrue(LongPredicates.isEven().accept(6L));
        Assert.assertFalse(LongPredicates.isEven().accept(5L));
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(LongPredicates.and(LongPredicates.greaterThan(5L), LongPredicates.lessThan(7L)).accept(6L));
        Assert.assertFalse(LongPredicates.and(LongPredicates.greaterThan(5L), LongPredicates.lessThan(7L)).accept(8L));
        Assert.assertFalse(LongPredicates.and(LongPredicates.greaterThan(5L), LongPredicates.lessThan(7L)).accept(4L));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(LongPredicates.or(LongPredicates.lessThan(5L), LongPredicates.greaterThan(7L)).accept(6L));
        Assert.assertTrue(LongPredicates.or(LongPredicates.lessThan(5L), LongPredicates.greaterThan(7L)).accept(4L));
        Assert.assertTrue(LongPredicates.or(LongPredicates.lessThan(5L), LongPredicates.greaterThan(7L)).accept(8L));
    }

    @Test
    public void testNot() {
        Assert.assertFalse(LongPredicates.not(LongPredicates.equal(5L)).accept(5L));
        Assert.assertTrue(LongPredicates.not(LongPredicates.equal(5L)).accept(6L));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongPredicates.class);
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
        public void benchmark_testIsOdd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIsOdd, this.description("testIsOdd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsEven() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIsEven, this.description("testIsEven"));
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

        private LongPredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongPredicatesTest();
        }

        @java.lang.Override
        public LongPredicatesTest implementation() {
            return this.implementation;
        }
    }
}
