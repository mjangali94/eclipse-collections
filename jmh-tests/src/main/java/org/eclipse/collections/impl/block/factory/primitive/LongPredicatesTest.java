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
    public static class _Benchmark {

        private _Payloads payloads;

        private LongPredicatesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqual);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLessThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLessThan);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGreaterThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGreaterThan);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.alwaysTrue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.alwaysFalse);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsOdd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsOdd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsEven() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsEven);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOr() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOr);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new LongPredicatesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testLessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testGreaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> alwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> alwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testIsOdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testIsEven;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> testNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqual = LongPredicatesTest::testEqual;
            this.payloads.testLessThan = LongPredicatesTest::testLessThan;
            this.payloads.testGreaterThan = LongPredicatesTest::testGreaterThan;
            this.payloads.alwaysTrue = LongPredicatesTest::alwaysTrue;
            this.payloads.alwaysFalse = LongPredicatesTest::alwaysFalse;
            this.payloads.testIsOdd = LongPredicatesTest::testIsOdd;
            this.payloads.testIsEven = LongPredicatesTest::testIsEven;
            this.payloads.testAnd = LongPredicatesTest::testAnd;
            this.payloads.testOr = LongPredicatesTest::testOr;
            this.payloads.testNot = LongPredicatesTest::testNot;
            this.payloads.classIsNonInstantiable = LongPredicatesTest::classIsNonInstantiable;
        }
    }
}
