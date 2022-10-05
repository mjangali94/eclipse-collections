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
 * Provides a set of common tests of predicates for byte values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class BytePredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(BytePredicates.equal((byte) 5).accept((byte) 5));
        Assert.assertFalse(BytePredicates.equal((byte) 5).accept((byte) 6));
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(BytePredicates.lessThan((byte) 5).accept((byte) 4));
        Assert.assertFalse(BytePredicates.lessThan((byte) 5).accept((byte) 6));
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(BytePredicates.greaterThan((byte) 5).accept((byte) 6));
        Assert.assertFalse(BytePredicates.greaterThan((byte) 5).accept((byte) 4));
    }

    @Test
    public void alwaysTrue() {
        Assert.assertTrue(BytePredicates.alwaysTrue().accept((byte) 5));
    }

    @Test
    public void alwaysFalse() {
        Assert.assertFalse(BytePredicates.alwaysFalse().accept((byte) 5));
    }

    @Test
    public void testIsOdd() {
        Assert.assertTrue(BytePredicates.isOdd().accept((byte) 5));
        Assert.assertFalse(BytePredicates.isOdd().accept((byte) 6));
    }

    @Test
    public void testIsEven() {
        Assert.assertTrue(BytePredicates.isEven().accept((byte) 6));
        Assert.assertFalse(BytePredicates.isEven().accept((byte) 5));
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(BytePredicates.and(BytePredicates.greaterThan((byte) 5), BytePredicates.lessThan((byte) 7)).accept((byte) 6));
        Assert.assertFalse(BytePredicates.and(BytePredicates.greaterThan((byte) 5), BytePredicates.lessThan((byte) 7)).accept((byte) 8));
        Assert.assertFalse(BytePredicates.and(BytePredicates.greaterThan((byte) 5), BytePredicates.lessThan((byte) 7)).accept((byte) 4));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(BytePredicates.or(BytePredicates.lessThan((byte) 5), BytePredicates.greaterThan((byte) 7)).accept((byte) 6));
        Assert.assertTrue(BytePredicates.or(BytePredicates.lessThan((byte) 5), BytePredicates.greaterThan((byte) 7)).accept((byte) 4));
        Assert.assertTrue(BytePredicates.or(BytePredicates.lessThan((byte) 5), BytePredicates.greaterThan((byte) 7)).accept((byte) 8));
    }

    @Test
    public void testNot() {
        Assert.assertFalse(BytePredicates.not(BytePredicates.equal((byte) 5)).accept((byte) 5));
        Assert.assertTrue(BytePredicates.not(BytePredicates.equal((byte) 5)).accept((byte) 6));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(BytePredicates.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BytePredicatesTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new BytePredicatesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testLessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testGreaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> alwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> alwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testIsOdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testIsEven;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> testNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BytePredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqual = BytePredicatesTest::testEqual;
            this.payloads.testLessThan = BytePredicatesTest::testLessThan;
            this.payloads.testGreaterThan = BytePredicatesTest::testGreaterThan;
            this.payloads.alwaysTrue = BytePredicatesTest::alwaysTrue;
            this.payloads.alwaysFalse = BytePredicatesTest::alwaysFalse;
            this.payloads.testIsOdd = BytePredicatesTest::testIsOdd;
            this.payloads.testIsEven = BytePredicatesTest::testIsEven;
            this.payloads.testAnd = BytePredicatesTest::testAnd;
            this.payloads.testOr = BytePredicatesTest::testOr;
            this.payloads.testNot = BytePredicatesTest::testNot;
            this.payloads.classIsNonInstantiable = BytePredicatesTest::classIsNonInstantiable;
        }
    }
}
