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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntPredicatesTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new IntPredicatesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testLessThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testGreaterThan;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> alwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> alwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testIsOdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testIsEven;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> testNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntPredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqual = IntPredicatesTest::testEqual;
            this.payloads.testLessThan = IntPredicatesTest::testLessThan;
            this.payloads.testGreaterThan = IntPredicatesTest::testGreaterThan;
            this.payloads.alwaysTrue = IntPredicatesTest::alwaysTrue;
            this.payloads.alwaysFalse = IntPredicatesTest::alwaysFalse;
            this.payloads.testIsOdd = IntPredicatesTest::testIsOdd;
            this.payloads.testIsEven = IntPredicatesTest::testIsEven;
            this.payloads.testAnd = IntPredicatesTest::testAnd;
            this.payloads.testOr = IntPredicatesTest::testOr;
            this.payloads.testNot = IntPredicatesTest::testNot;
            this.payloads.classIsNonInstantiable = IntPredicatesTest::classIsNonInstantiable;
        }
    }
*/
}
