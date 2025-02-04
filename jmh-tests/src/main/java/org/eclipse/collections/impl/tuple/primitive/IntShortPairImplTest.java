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
 * JUnit test for {@link IntShortPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class IntShortPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1, (short) 2), PrimitiveTuples.pair(1, (short) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair(8, (short) 2), PrimitiveTuples.pair(1, (short) 2));
        Assert.assertEquals(Tuples.pair(1, (short) 2).hashCode(), PrimitiveTuples.pair(1, (short) 2).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1, PrimitiveTuples.pair(1, (short) 2).getOne(), 0);
        Assert.assertEquals(12, PrimitiveTuples.pair(12, (short) 2).getOne(), 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals((short) 2, PrimitiveTuples.pair(1, (short) 2).getTwo(), 0);
        Assert.assertEquals((short) 0, PrimitiveTuples.pair(1, (short) 0).getTwo(), 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:2", PrimitiveTuples.pair(1, (short) 2).toString());
        Assert.assertEquals("2:8", PrimitiveTuples.pair(2, (short) 8).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(2, (short) 2).compareTo(PrimitiveTuples.pair(1, (short) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1, (short) 2).compareTo(PrimitiveTuples.pair(1, (short) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1, (short) 2).compareTo(PrimitiveTuples.pair(1, (short) 3)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntShortPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new IntShortPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = IntShortPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = IntShortPairImplTest::getOne;
            this.payloads.getTwo = IntShortPairImplTest::getTwo;
            this.payloads.testToString = IntShortPairImplTest::testToString;
            this.payloads.compareTo = IntShortPairImplTest::compareTo;
        }
    }
}
