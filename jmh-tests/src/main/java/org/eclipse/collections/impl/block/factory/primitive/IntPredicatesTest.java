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
 * Provides a set of common tests of predicates for int values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class IntPredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(IntPredicates.equal(5).accept(5));
        Assert.assertFalse(IntPredicates.equal(5).accept(6));
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(IntPredicates.lessThan(5).accept(4));
        Assert.assertFalse(IntPredicates.lessThan(5).accept(6));
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(IntPredicates.greaterThan(5).accept(6));
        Assert.assertFalse(IntPredicates.greaterThan(5).accept(4));
    }

    @Test
    public void alwaysTrue() {
        Assert.assertTrue(IntPredicates.alwaysTrue().accept(5));
    }

    @Test
    public void alwaysFalse() {
        Assert.assertFalse(IntPredicates.alwaysFalse().accept(5));
    }

    @Test
    public void testIsOdd() {
        Assert.assertTrue(IntPredicates.isOdd().accept(5));
        Assert.assertFalse(IntPredicates.isOdd().accept(6));
    }

    @Test
    public void testIsEven() {
        Assert.assertTrue(IntPredicates.isEven().accept(6));
        Assert.assertFalse(IntPredicates.isEven().accept(5));
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(IntPredicates.and(IntPredicates.greaterThan(5), IntPredicates.lessThan(7)).accept(6));
        Assert.assertFalse(IntPredicates.and(IntPredicates.greaterThan(5), IntPredicates.lessThan(7)).accept(8));
        Assert.assertFalse(IntPredicates.and(IntPredicates.greaterThan(5), IntPredicates.lessThan(7)).accept(4));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(IntPredicates.or(IntPredicates.lessThan(5), IntPredicates.greaterThan(7)).accept(6));
        Assert.assertTrue(IntPredicates.or(IntPredicates.lessThan(5), IntPredicates.greaterThan(7)).accept(4));
        Assert.assertTrue(IntPredicates.or(IntPredicates.lessThan(5), IntPredicates.greaterThan(7)).accept(8));
    }

    @Test
    public void testNot() {
        Assert.assertFalse(IntPredicates.not(IntPredicates.equal(5)).accept(5));
        Assert.assertTrue(IntPredicates.not(IntPredicates.equal(5)).accept(6));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntPredicates.class);
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

        private IntPredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntPredicatesTest();
        }

        @java.lang.Override
        public IntPredicatesTest implementation() {
            return this.implementation;
        }
    }
}
