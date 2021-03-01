/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultiplyFunctionTest {

    @Test
    public void integerBlock() {
        Assert.assertEquals(Integer.valueOf(20), MultiplyFunction.INTEGER.value(2, 10));
    }

    @Test
    public void doubleBlock() {
        Assert.assertEquals(new Double(20), MultiplyFunction.DOUBLE.value(2.0, 10.0));
    }

    @Test
    public void longBlock() {
        Assert.assertEquals(Long.valueOf(20), MultiplyFunction.LONG.value(2L, 10L));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(MultiplyFunction.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_integerBlock() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::integerBlock, this.description("integerBlock"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleBlock() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleBlock, this.description("doubleBlock"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longBlock() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longBlock, this.description("longBlock"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private MultiplyFunctionTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MultiplyFunctionTest();
        }

        @java.lang.Override
        public MultiplyFunctionTest implementation() {
            return this.implementation;
        }
    }
}
