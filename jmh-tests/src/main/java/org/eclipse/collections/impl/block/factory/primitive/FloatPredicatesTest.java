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
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatPredicatesTest instance;

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
        public void benchmark_equalWithDelta() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalWithDelta);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new FloatPredicatesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> testEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> testLessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> testGreaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> alwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> alwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> equalWithDelta;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> testAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> testOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> testNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatPredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqual = FloatPredicatesTest::testEqual;
            this.payloads.testLessThan = FloatPredicatesTest::testLessThan;
            this.payloads.testGreaterThan = FloatPredicatesTest::testGreaterThan;
            this.payloads.alwaysTrue = FloatPredicatesTest::alwaysTrue;
            this.payloads.alwaysFalse = FloatPredicatesTest::alwaysFalse;
            this.payloads.equalWithDelta = FloatPredicatesTest::equalWithDelta;
            this.payloads.testAnd = FloatPredicatesTest::testAnd;
            this.payloads.testOr = FloatPredicatesTest::testOr;
            this.payloads.testNot = FloatPredicatesTest::testNot;
            this.payloads.classIsNonInstantiable = FloatPredicatesTest::classIsNonInstantiable;
        }
    }
}
