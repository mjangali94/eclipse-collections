/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.tuple.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link BooleanBooleanPairImpl}.
 */
public class BooleanBooleanPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, false), PrimitiveTuples.pair(true, false));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, true), PrimitiveTuples.pair(true, false));
        Assert.assertEquals(Tuples.pair(true, false).hashCode(), PrimitiveTuples.pair(true, false).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertTrue(PrimitiveTuples.pair(true, false).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, true).getOne());
    }

    @Test
    public void getTwo() {
        Assert.assertTrue(PrimitiveTuples.pair(false, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair(true, false).getTwo());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("true:false", PrimitiveTuples.pair(true, false).toString());
        Assert.assertEquals("true:true", PrimitiveTuples.pair(true, true).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, false).compareTo(PrimitiveTuples.pair(false, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, false).compareTo(PrimitiveTuples.pair(true, false)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, false).compareTo(PrimitiveTuples.pair(true, true)));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEqualsAndHashCode, this.description("testEqualsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOne() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOne, this.description("getOne"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getTwo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getTwo, this.description("getTwo"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::compareTo, this.description("compareTo"));
        }

        private BooleanBooleanPairImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanBooleanPairImplTest();
        }

        @java.lang.Override
        public BooleanBooleanPairImplTest implementation() {
            return this.implementation;
        }
    }
}
