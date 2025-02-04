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
 * Provides a set of common tests of predicates for short values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class ShortPredicatesTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(ShortPredicates.equal((short) 5).accept((short) 5));
        Assert.assertFalse(ShortPredicates.equal((short) 5).accept((short) 6));
    }

    @Test
    public void testLessThan() {
        Assert.assertTrue(ShortPredicates.lessThan((short) 5).accept((short) 4));
        Assert.assertFalse(ShortPredicates.lessThan((short) 5).accept((short) 6));
    }

    @Test
    public void testGreaterThan() {
        Assert.assertTrue(ShortPredicates.greaterThan((short) 5).accept((short) 6));
        Assert.assertFalse(ShortPredicates.greaterThan((short) 5).accept((short) 4));
    }

    @Test
    public void alwaysTrue() {
        Assert.assertTrue(ShortPredicates.alwaysTrue().accept((short) 5));
    }

    @Test
    public void alwaysFalse() {
        Assert.assertFalse(ShortPredicates.alwaysFalse().accept((short) 5));
    }

    @Test
    public void testIsOdd() {
        Assert.assertTrue(ShortPredicates.isOdd().accept((short) 5));
        Assert.assertFalse(ShortPredicates.isOdd().accept((short) 6));
    }

    @Test
    public void testIsEven() {
        Assert.assertTrue(ShortPredicates.isEven().accept((short) 6));
        Assert.assertFalse(ShortPredicates.isEven().accept((short) 5));
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(ShortPredicates.and(ShortPredicates.greaterThan((short) 5), ShortPredicates.lessThan((short) 7)).accept((short) 6));
        Assert.assertFalse(ShortPredicates.and(ShortPredicates.greaterThan((short) 5), ShortPredicates.lessThan((short) 7)).accept((short) 8));
        Assert.assertFalse(ShortPredicates.and(ShortPredicates.greaterThan((short) 5), ShortPredicates.lessThan((short) 7)).accept((short) 4));
    }

    @Test
    public void testOr() {
        Assert.assertFalse(ShortPredicates.or(ShortPredicates.lessThan((short) 5), ShortPredicates.greaterThan((short) 7)).accept((short) 6));
        Assert.assertTrue(ShortPredicates.or(ShortPredicates.lessThan((short) 5), ShortPredicates.greaterThan((short) 7)).accept((short) 4));
        Assert.assertTrue(ShortPredicates.or(ShortPredicates.lessThan((short) 5), ShortPredicates.greaterThan((short) 7)).accept((short) 8));
    }

    @Test
    public void testNot() {
        Assert.assertFalse(ShortPredicates.not(ShortPredicates.equal((short) 5)).accept((short) 5));
        Assert.assertTrue(ShortPredicates.not(ShortPredicates.equal((short) 5)).accept((short) 6));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortPredicates.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortPredicatesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqual);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testLessThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLessThan);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGreaterThan() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testGreaterThan);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.alwaysTrue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_alwaysFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.alwaysFalse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsOdd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsOdd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsEven() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsEven);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOr() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOr);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new ShortPredicatesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testLessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testGreaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> alwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> alwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testIsOdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testIsEven;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> testNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortPredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqual = ShortPredicatesTest::testEqual;
            this.payloads.testLessThan = ShortPredicatesTest::testLessThan;
            this.payloads.testGreaterThan = ShortPredicatesTest::testGreaterThan;
            this.payloads.alwaysTrue = ShortPredicatesTest::alwaysTrue;
            this.payloads.alwaysFalse = ShortPredicatesTest::alwaysFalse;
            this.payloads.testIsOdd = ShortPredicatesTest::testIsOdd;
            this.payloads.testIsEven = ShortPredicatesTest::testIsEven;
            this.payloads.testAnd = ShortPredicatesTest::testAnd;
            this.payloads.testOr = ShortPredicatesTest::testOr;
            this.payloads.testNot = ShortPredicatesTest::testNot;
            this.payloads.classIsNonInstantiable = ShortPredicatesTest::classIsNonInstantiable;
        }
    }
}
