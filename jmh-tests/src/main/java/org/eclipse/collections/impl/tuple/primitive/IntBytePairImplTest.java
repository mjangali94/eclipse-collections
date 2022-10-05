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
 * JUnit test for {@link IntBytePairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class IntBytePairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(1, (byte) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair(8, (byte) 2), PrimitiveTuples.pair(1, (byte) 2));
        Assert.assertEquals(Tuples.pair(1, (byte) 2).hashCode(), PrimitiveTuples.pair(1, (byte) 2).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1, PrimitiveTuples.pair(1, (byte) 2).getOne(), 0);
        Assert.assertEquals(12, PrimitiveTuples.pair(12, (byte) 2).getOne(), 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals((byte) 2, PrimitiveTuples.pair(1, (byte) 2).getTwo(), 0);
        Assert.assertEquals((byte) 0, PrimitiveTuples.pair(1, (byte) 0).getTwo(), 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:2", PrimitiveTuples.pair(1, (byte) 2).toString());
        Assert.assertEquals("2:8", PrimitiveTuples.pair(2, (byte) 8).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(2, (byte) 2).compareTo(PrimitiveTuples.pair(1, (byte) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1, (byte) 2).compareTo(PrimitiveTuples.pair(1, (byte) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1, (byte) 2).compareTo(PrimitiveTuples.pair(1, (byte) 3)));
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

        private IntBytePairImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntBytePairImplTest();
        }

        @java.lang.Override
        public IntBytePairImplTest implementation() {
            return this.implementation;
        }
    }
}
