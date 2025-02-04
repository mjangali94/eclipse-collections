/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanPredicatesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqual() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqual);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsTrue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIsFalse);
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
        public void benchmark_testAlwaysTrue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAlwaysTrue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testAlwaysFalse() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testAlwaysFalse);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanPredicatesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testEqual;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testIsTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testIsFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testAnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testOr;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testNot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testAlwaysTrue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> testAlwaysFalse;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanPredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqual = BooleanPredicatesTest::testEqual;
            this.payloads.testIsTrue = BooleanPredicatesTest::testIsTrue;
            this.payloads.testIsFalse = BooleanPredicatesTest::testIsFalse;
            this.payloads.testAnd = BooleanPredicatesTest::testAnd;
            this.payloads.testOr = BooleanPredicatesTest::testOr;
            this.payloads.testNot = BooleanPredicatesTest::testNot;
            this.payloads.testAlwaysTrue = BooleanPredicatesTest::testAlwaysTrue;
            this.payloads.testAlwaysFalse = BooleanPredicatesTest::testAlwaysFalse;
            this.payloads.classIsNonInstantiable = BooleanPredicatesTest::classIsNonInstantiable;
        }
    }
*/
}
