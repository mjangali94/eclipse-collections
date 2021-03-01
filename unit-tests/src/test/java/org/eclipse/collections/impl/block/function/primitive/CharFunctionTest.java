/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function.primitive;

import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharFunction}.
 *
 * @deprecated in 6.2
 */
@Deprecated
public class CharFunctionTest {

    @Test
    public void toUppercase() {
        Assert.assertEquals('A', CharFunction.TO_UPPERCASE.valueOf('a'));
        Assert.assertEquals('A', CharFunction.TO_UPPERCASE.valueOf('A'));
        Assert.assertEquals('1', CharFunction.TO_UPPERCASE.valueOf('1'));
    }

    @Test
    public void toLowercase() {
        Assert.assertEquals('a', CharFunction.TO_LOWERCASE.valueOf('a'));
        Assert.assertEquals('a', CharFunction.TO_LOWERCASE.valueOf('A'));
        Assert.assertEquals('1', CharFunction.TO_LOWERCASE.valueOf('1'));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toUppercase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toUppercase, this.description("toUppercase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toLowercase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toLowercase, this.description("toLowercase"));
        }

        private CharFunctionTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharFunctionTest();
        }

        @java.lang.Override
        public CharFunctionTest implementation() {
            return this.implementation;
        }
    }
}
