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
 * JUnit test for {@link DoubleBooleanPairImpl}.
 *
 * This file was automatically generated from template file primitiveBooleanPairImplTest.stg.
 */
public class DoubleBooleanPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1.0, true), PrimitiveTuples.pair(1.0, true));
        Assert.assertNotEquals(PrimitiveTuples.pair(1.0, false), PrimitiveTuples.pair(1.0, true));
        Assert.assertEquals(Tuples.pair(1.0, true).hashCode(), PrimitiveTuples.pair(1.0, true).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1.0, PrimitiveTuples.pair(1.0, true).getOne(), 0.0);
        Assert.assertEquals(3.0, PrimitiveTuples.pair(3.0, true).getOne(), 0.0);
    }

    @Test
    public void getTwo() {
        Assert.assertTrue(PrimitiveTuples.pair(1.0, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair(1.0, false).getTwo());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1.0:true", PrimitiveTuples.pair(1.0, true).toString());
        Assert.assertEquals("2.0:false", PrimitiveTuples.pair(2.0, false).toString());
        Assert.assertNotEquals("2.0, false", PrimitiveTuples.pair(2.0, false).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, PrimitiveTuples.pair(1.0, true).compareTo(PrimitiveTuples.pair(2.0, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1.0, true).compareTo(PrimitiveTuples.pair(1.0, true)));
        Assert.assertEquals(1, PrimitiveTuples.pair(1.0, true).compareTo(PrimitiveTuples.pair(1.0, false)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleBooleanPairImplTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOne);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getTwo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getTwo);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleBooleanPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = DoubleBooleanPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = DoubleBooleanPairImplTest::getOne;
            this.payloads.getTwo = DoubleBooleanPairImplTest::getTwo;
            this.payloads.testToString = DoubleBooleanPairImplTest::testToString;
            this.payloads.compareTo = DoubleBooleanPairImplTest::compareTo;
        }
    }
}
