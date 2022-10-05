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
 * JUnit test for {@link CharBooleanPairImpl}.
 *
 * This file was automatically generated from template file primitiveBooleanPairImplTest.stg.
 */
public class CharBooleanPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((char) 1, true), PrimitiveTuples.pair((char) 1, true));
        Assert.assertNotEquals(PrimitiveTuples.pair((char) 1, false), PrimitiveTuples.pair((char) 1, true));
        Assert.assertEquals(Tuples.pair((char) 1, true).hashCode(), PrimitiveTuples.pair((char) 1, true).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals((char) 1, PrimitiveTuples.pair((char) 1, true).getOne(), (char) 0);
        Assert.assertEquals((char) 3, PrimitiveTuples.pair((char) 3, true).getOne(), (char) 0);
    }

    @Test
    public void getTwo() {
        Assert.assertTrue(PrimitiveTuples.pair((char) 1, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair((char) 1, false).getTwo());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("\u0001:true", PrimitiveTuples.pair((char) 1, true).toString());
        Assert.assertEquals("\u0002:false", PrimitiveTuples.pair((char) 2, false).toString());
        Assert.assertNotEquals("\u0002, false", PrimitiveTuples.pair((char) 2, false).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, PrimitiveTuples.pair((char) 1, true).compareTo(PrimitiveTuples.pair((char) 2, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair((char) 1, true).compareTo(PrimitiveTuples.pair((char) 1, true)));
        Assert.assertEquals(1, PrimitiveTuples.pair((char) 1, true).compareTo(PrimitiveTuples.pair((char) 1, false)));
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

        private CharBooleanPairImplTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharBooleanPairImplTest();
        }

        @java.lang.Override
        public CharBooleanPairImplTest implementation() {
            return this.implementation;
        }
    }
}
