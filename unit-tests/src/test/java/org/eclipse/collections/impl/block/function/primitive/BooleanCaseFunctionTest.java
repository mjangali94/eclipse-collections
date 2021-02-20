/*
 * Copyright (c) 2017 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class BooleanCaseFunctionTest {

    @Test
    public void noopCase() {
        BooleanCaseFunction<Boolean> function = new BooleanCaseFunction<>();
        Assert.assertNull(function.valueOf(true));
    }

    @Test
    public void basicCase() {
        BooleanCaseFunction<Boolean> function = new BooleanCaseFunction<>();
        function.addCase(value -> value, Boolean::valueOf);
        Assert.assertEquals(Boolean.valueOf(true), function.valueOf(true));
    }

    @Test
    public void defaultValue() {
        BooleanCaseFunction<String> function = new BooleanCaseFunction<>(e -> "Yow!").addCase(e -> e, e -> "Patience, grasshopper");
        Assert.assertEquals("Yow!", function.valueOf(false));
        function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertEquals("Patience, grasshopper", function.valueOf(true));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(false));
        Verify.assertContains("BooleanCaseFunction", function.toString());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noopCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noopCase, this.description("noopCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_basicCase() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::basicCase, this.description("basicCase"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::defaultValue, this.description("defaultValue"));
        }

        private BooleanCaseFunctionTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanCaseFunctionTest();
        }

        @java.lang.Override
        public BooleanCaseFunctionTest implementation() {
            return this.implementation;
        }
    }
}
