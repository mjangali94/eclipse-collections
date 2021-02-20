/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.procedure;

import org.junit.Assert;
import org.junit.Test;

public class CollectIfProcedureTest {

    private static final int THE_ANSWER = 42;

    @Test
    public void constructorWithSize() {
        CollectIfProcedure<Integer, String> underTestTrue = new CollectIfProcedure<>(10, String::valueOf, ignored -> true);
        CollectIfProcedure<Integer, String> underTestFalse = new CollectIfProcedure<>(10, String::valueOf, ignored -> false);
        underTestTrue.value(THE_ANSWER);
        underTestFalse.value(THE_ANSWER);
        Assert.assertTrue(underTestTrue.getCollection().contains("42"));
        Assert.assertFalse(underTestFalse.getCollection().contains("42"));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_constructorWithSize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::constructorWithSize, this.description("constructorWithSize"));
        }

        private CollectIfProcedureTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectIfProcedureTest();
        }

        @java.lang.Override
        public CollectIfProcedureTest implementation() {
            return this.implementation;
        }
    }
}
