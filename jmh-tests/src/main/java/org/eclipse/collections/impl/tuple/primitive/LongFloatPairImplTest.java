/*
 * Copyright (c) 2022 Goldman Sachs.
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
 * JUnit test for {@link LongFloatPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class LongFloatPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(1L, 2.0f));
        Assert.assertNotEquals(PrimitiveTuples.pair(8L, 2.0f), PrimitiveTuples.pair(1L, 2.0f));
        Assert.assertEquals(Tuples.pair(1L, 2.0f).hashCode(), PrimitiveTuples.pair(1L, 2.0f).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1L, PrimitiveTuples.pair(1L, 2.0f).getOne(), 0L);
        Assert.assertEquals(12L, PrimitiveTuples.pair(12L, 2.0f).getOne(), 0L);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(2.0f, PrimitiveTuples.pair(1L, 2.0f).getTwo(), 0L);
        Assert.assertEquals(0.0f, PrimitiveTuples.pair(1L, 0.0f).getTwo(), 0L);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:2.0", PrimitiveTuples.pair(1L, 2.0f).toString());
        Assert.assertEquals("2:8.0", PrimitiveTuples.pair(2L, 8.0f).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(2L, 2.0f).compareTo(PrimitiveTuples.pair(1L, 2.0f)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1L, 2.0f).compareTo(PrimitiveTuples.pair(1L, 2.0f)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1L, 2.0f).compareTo(PrimitiveTuples.pair(1L, 3.0f)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
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

        private LongFloatPairImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongFloatPairImplTest();
        }

        @java.lang.Override
        public LongFloatPairImplTest implementation() {
            return this.implementation;
        }
    }
}
