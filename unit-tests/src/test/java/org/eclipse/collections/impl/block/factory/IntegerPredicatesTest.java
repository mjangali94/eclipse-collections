/*
 * Copyright (c) 2015 Goldman Sachs.
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

public class IntegerPredicatesTest {

    private static final Function<Integer, Integer> INT_VALUE = integer -> integer;

    @Test
    public void isOdd() {
        Assert.assertTrue(IntegerPredicates.isOdd().accept(1));
        Assert.assertFalse(IntegerPredicates.isOdd().accept(-2));
    }

    @Test
    public void isEven() {
        Assert.assertTrue(IntegerPredicates.isEven().accept(-42));
        Assert.assertTrue(IntegerPredicates.isEven().accept(0));
        Assert.assertFalse(IntegerPredicates.isEven().accept(1));
    }

    @Test
    public void attributeIsOdd() {
        Assert.assertTrue(IntegerPredicates.attributeIsOdd(INT_VALUE).accept(1));
        Assert.assertFalse(IntegerPredicates.attributeIsOdd(INT_VALUE).accept(-2));
    }

    @Test
    public void attributeIsEven() {
        Assert.assertTrue(IntegerPredicates.attributeIsEven(INT_VALUE).accept(-42));
        Assert.assertTrue(IntegerPredicates.attributeIsEven(INT_VALUE).accept(0));
        Assert.assertFalse(IntegerPredicates.attributeIsEven(INT_VALUE).accept(1));
    }

    @Test
    public void attributeIsZero() {
        Assert.assertFalse(IntegerPredicates.attributeIsZero(INT_VALUE).accept(-42));
        Assert.assertTrue(IntegerPredicates.attributeIsZero(INT_VALUE).accept(0));
        Assert.assertFalse(IntegerPredicates.attributeIsZero(INT_VALUE).accept(1));
    }

    @Test
    public void attributeIsPositive() {
        Assert.assertFalse(IntegerPredicates.attributeIsPositive(INT_VALUE).accept(-42));
        Assert.assertFalse(IntegerPredicates.attributeIsPositive(INT_VALUE).accept(0));
        Assert.assertTrue(IntegerPredicates.attributeIsPositive(INT_VALUE).accept(1));
    }

    @Test
    public void attributeIsNegative() {
        Assert.assertTrue(IntegerPredicates.attributeIsNegative(INT_VALUE).accept(-42));
        Assert.assertFalse(IntegerPredicates.attributeIsNegative(INT_VALUE).accept(0));
        Assert.assertFalse(IntegerPredicates.attributeIsNegative(INT_VALUE).accept(1));
    }

    @Test
    public void isZero() {
        Assert.assertTrue(IntegerPredicates.isZero().accept(0));
        Assert.assertFalse(IntegerPredicates.isZero().accept(1));
        Assert.assertFalse(IntegerPredicates.isZero().accept(-1));
    }

    @Test
    public void isPositive() {
        Assert.assertFalse(IntegerPredicates.isPositive().accept(0));
        Assert.assertTrue(IntegerPredicates.isPositive().accept(1));
        Assert.assertFalse(IntegerPredicates.isPositive().accept(-1));
    }

    @Test
    public void isNegative() {
        Assert.assertFalse(IntegerPredicates.isNegative().accept(0));
        Assert.assertFalse(IntegerPredicates.isNegative().accept(1));
        Assert.assertTrue(IntegerPredicates.isNegative().accept(-1));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntegerPredicates.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isOdd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isOdd, this.description("isOdd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEven() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEven, this.description("isEven"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsOdd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::attributeIsOdd, this.description("attributeIsOdd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsEven() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::attributeIsEven, this.description("attributeIsEven"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsZero() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::attributeIsZero, this.description("attributeIsZero"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsPositive() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::attributeIsPositive, this.description("attributeIsPositive"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_attributeIsNegative() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::attributeIsNegative, this.description("attributeIsNegative"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isZero() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isZero, this.description("isZero"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isPositive() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isPositive, this.description("isPositive"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isNegative() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isNegative, this.description("isNegative"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private IntegerPredicatesTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntegerPredicatesTest();
        }

        @java.lang.Override
        public IntegerPredicatesTest implementation() {
            return this.implementation;
        }
    }
}
