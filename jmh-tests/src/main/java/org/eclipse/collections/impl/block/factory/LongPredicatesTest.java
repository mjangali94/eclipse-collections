/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.factory;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class LongPredicatesTest {

    private static final Function<Long, Long> LONG_VALUE = Long::longValue;

    @Test
    public void isOdd() {
        Assert.assertTrue(LongPredicates.isOdd().accept(1L));
        Assert.assertFalse(LongPredicates.isOdd().accept(-2L));
    }

    @Test
    public void isEven() {
        Assert.assertTrue(LongPredicates.isEven().accept(-42L));
        Assert.assertTrue(LongPredicates.isEven().accept(0L));
        Assert.assertFalse(LongPredicates.isEven().accept(1L));
    }

    @Test
    public void attributeIsOdd() {
        Assert.assertTrue(LongPredicates.attributeIsOdd(LONG_VALUE).accept(1L));
        Assert.assertFalse(LongPredicates.attributeIsOdd(LONG_VALUE).accept(-2L));
    }

    @Test
    public void attributeIsEven() {
        Assert.assertTrue(LongPredicates.attributeIsEven(LONG_VALUE).accept(-42L));
        Assert.assertTrue(LongPredicates.attributeIsEven(LONG_VALUE).accept(0L));
        Assert.assertFalse(LongPredicates.attributeIsEven(LONG_VALUE).accept(1L));
    }

    @Test
    public void isZero() {
        Assert.assertTrue(LongPredicates.isZero().accept(0L));
        Assert.assertFalse(LongPredicates.isZero().accept(1L));
        Assert.assertFalse(LongPredicates.isZero().accept(-1L));
    }

    @Test
    public void isPositive() {
        Assert.assertFalse(LongPredicates.isPositive().accept(0L));
        Assert.assertTrue(LongPredicates.isPositive().accept(1L));
        Assert.assertFalse(LongPredicates.isPositive().accept(-1L));
    }

    @Test
    public void isNegative() {
        Assert.assertFalse(LongPredicates.isNegative().accept(0L));
        Assert.assertFalse(LongPredicates.isNegative().accept(1L));
        Assert.assertTrue(LongPredicates.isNegative().accept(-1L));
    }

    @Test
    public void attributeIsZero() {
        Assert.assertTrue(LongPredicates.attributeIsZero(Integer::longValue).accept(0));
        Assert.assertFalse(LongPredicates.attributeIsZero(Integer::longValue).accept(1));
    }

    @Test
    public void attributeIsPositive() {
        Assert.assertTrue(LongPredicates.attributeIsPositive(Integer::longValue).accept(1));
        Assert.assertFalse(LongPredicates.attributeIsPositive(Integer::longValue).accept(0));
        Assert.assertFalse(LongPredicates.attributeIsPositive(Integer::longValue).accept(-1));
    }

    @Test
    public void attributeIsNegative() {
        Assert.assertTrue(LongPredicates.attributeIsNegative(Integer::longValue).accept(-1));
        Assert.assertFalse(LongPredicates.attributeIsNegative(Integer::longValue).accept(0));
        Assert.assertFalse(LongPredicates.attributeIsNegative(Integer::longValue).accept(1));
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
        public void benchmark_isOdd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isOdd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEven() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEven);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsOdd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsOdd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsEven() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsEven);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isZero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isZero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isPositive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isPositive);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isNegative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsZero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsZero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsPositive() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsPositive);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsNegative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.attributeIsNegative);
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

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> isOdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> isEven;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> attributeIsOdd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> attributeIsEven;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> isZero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> isPositive;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> isNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> attributeIsZero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> attributeIsPositive;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> attributeIsNegative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongPredicatesTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isOdd = LongPredicatesTest::isOdd;
            this.payloads.isEven = LongPredicatesTest::isEven;
            this.payloads.attributeIsOdd = LongPredicatesTest::attributeIsOdd;
            this.payloads.attributeIsEven = LongPredicatesTest::attributeIsEven;
            this.payloads.isZero = LongPredicatesTest::isZero;
            this.payloads.isPositive = LongPredicatesTest::isPositive;
            this.payloads.isNegative = LongPredicatesTest::isNegative;
            this.payloads.attributeIsZero = LongPredicatesTest::attributeIsZero;
            this.payloads.attributeIsPositive = LongPredicatesTest::attributeIsPositive;
            this.payloads.attributeIsNegative = LongPredicatesTest::attributeIsNegative;
            this.payloads.classIsNonInstantiable = LongPredicatesTest::classIsNonInstantiable;
        }
    }
}
