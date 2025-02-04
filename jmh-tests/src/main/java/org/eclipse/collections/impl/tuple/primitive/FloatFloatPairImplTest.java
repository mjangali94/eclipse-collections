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
 * JUnit test for {@link FloatFloatPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class FloatFloatPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1.0f, 2.0f), PrimitiveTuples.pair(1.0f, 2.0f));
        Assert.assertNotEquals(PrimitiveTuples.pair(8.0f, 2.0f), PrimitiveTuples.pair(1.0f, 2.0f));
        Assert.assertEquals(Tuples.pair(1.0f, 2.0f).hashCode(), PrimitiveTuples.pair(1.0f, 2.0f).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1.0f, PrimitiveTuples.pair(1.0f, 2.0f).getOne(), 0.0f);
        Assert.assertEquals(12.0f, PrimitiveTuples.pair(12.0f, 2.0f).getOne(), 0.0f);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(2.0f, PrimitiveTuples.pair(1.0f, 2.0f).getTwo(), 0.0f);
        Assert.assertEquals(0.0f, PrimitiveTuples.pair(1.0f, 0.0f).getTwo(), 0.0f);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1.0:2.0", PrimitiveTuples.pair(1.0f, 2.0f).toString());
        Assert.assertEquals("2.0:8.0", PrimitiveTuples.pair(2.0f, 8.0f).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(2.0f, 2.0f).compareTo(PrimitiveTuples.pair(1.0f, 2.0f)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1.0f, 2.0f).compareTo(PrimitiveTuples.pair(1.0f, 2.0f)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1.0f, 2.0f).compareTo(PrimitiveTuples.pair(1.0f, 3.0f)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatFloatPairImplTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOne);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getTwo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getTwo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new FloatFloatPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = FloatFloatPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = FloatFloatPairImplTest::getOne;
            this.payloads.getTwo = FloatFloatPairImplTest::getTwo;
            this.payloads.testToString = FloatFloatPairImplTest::testToString;
            this.payloads.compareTo = FloatFloatPairImplTest::compareTo;
        }
    }
}
