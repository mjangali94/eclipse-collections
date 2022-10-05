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
 * JUnit test for {@link BooleanIntPairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanIntPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, 1), PrimitiveTuples.pair(true, 1));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, 1), PrimitiveTuples.pair(true, 1));
        Assert.assertEquals(Tuples.pair(true, 1).hashCode(), PrimitiveTuples.pair(true, 1).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertTrue(PrimitiveTuples.pair(true, 1).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, 5).getOne());
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1).getTwo(), 0);
        Assert.assertEquals(2, PrimitiveTuples.pair(true, 2).getTwo(), 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("true:1", PrimitiveTuples.pair(true, 1).toString());
        Assert.assertEquals("false:2", PrimitiveTuples.pair(false, 2).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1).compareTo(PrimitiveTuples.pair(false, 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, 1).compareTo(PrimitiveTuples.pair(true, 1)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, 1).compareTo(PrimitiveTuples.pair(true, 2)));
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

        private BooleanIntPairImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new BooleanIntPairImplTest();
        }

        @java.lang.Override
        public BooleanIntPairImplTest implementation() {
            return this.implementation;
        }
    }
}
