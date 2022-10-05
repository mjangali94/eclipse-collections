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
 * JUnit test for {@link FloatBooleanPairImpl}.
 *
 * This file was automatically generated from template file primitiveBooleanPairImplTest.stg.
 */
public class FloatBooleanPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1.0f, true), PrimitiveTuples.pair(1.0f, true));
        Assert.assertNotEquals(PrimitiveTuples.pair(1.0f, false), PrimitiveTuples.pair(1.0f, true));
        Assert.assertEquals(Tuples.pair(1.0f, true).hashCode(), PrimitiveTuples.pair(1.0f, true).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1.0f, PrimitiveTuples.pair(1.0f, true).getOne(), 0.0f);
        Assert.assertEquals(3.0f, PrimitiveTuples.pair(3.0f, true).getOne(), 0.0f);
    }

    @Test
    public void getTwo() {
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair(1.0f, false).getTwo());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1.0:true", PrimitiveTuples.pair(1.0f, true).toString());
        Assert.assertEquals("2.0:false", PrimitiveTuples.pair(2.0f, false).toString());
        Assert.assertNotEquals("2.0, false", PrimitiveTuples.pair(2.0f, false).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, PrimitiveTuples.pair(1.0f, true).compareTo(PrimitiveTuples.pair(2.0f, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1.0f, true).compareTo(PrimitiveTuples.pair(1.0f, true)));
        Assert.assertEquals(1, PrimitiveTuples.pair(1.0f, true).compareTo(PrimitiveTuples.pair(1.0f, false)));
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

        private FloatBooleanPairImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatBooleanPairImplTest();
        }

        @java.lang.Override
        public FloatBooleanPairImplTest implementation() {
            return this.implementation;
        }
    }
}
