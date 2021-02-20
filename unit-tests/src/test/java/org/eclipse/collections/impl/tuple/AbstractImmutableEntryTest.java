/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.tuple;

import org.junit.Assert;
import org.junit.Test;

public class AbstractImmutableEntryTest {

    @Test
    public void getKeyFunction() {
        ImmutableEntry<String, Integer> entry = new ImmutableEntry<>("foo", 2);
        Assert.assertEquals("foo", AbstractImmutableEntry.<String>getKeyFunction().valueOf(entry));
    }

    @Test
    public void getValueFunction() {
        ImmutableEntry<String, Integer> entry = new ImmutableEntry<>("foo", 2);
        Assert.assertEquals(Integer.valueOf(2), AbstractImmutableEntry.<Integer>getValueFunction().valueOf(entry));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getKeyFunction() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getKeyFunction, this.description("getKeyFunction"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getValueFunction() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getValueFunction, this.description("getValueFunction"));
        }

        private AbstractImmutableEntryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new AbstractImmutableEntryTest();
        }

        @java.lang.Override
        public AbstractImmutableEntryTest implementation() {
            return this.implementation;
        }
    }
}
