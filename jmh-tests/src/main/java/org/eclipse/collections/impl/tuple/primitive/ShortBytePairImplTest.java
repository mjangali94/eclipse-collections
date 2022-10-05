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
 * JUnit test for {@link ShortBytePairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class ShortBytePairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((short) 1, (byte) 2), PrimitiveTuples.pair((short) 1, (byte) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair((short) 8, (byte) 2), PrimitiveTuples.pair((short) 1, (byte) 2));
        Assert.assertEquals(Tuples.pair((short) 1, (byte) 2).hashCode(), PrimitiveTuples.pair((short) 1, (byte) 2).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals((short) 1, PrimitiveTuples.pair((short) 1, (byte) 2).getOne(), (short) 0);
        Assert.assertEquals((short) 12, PrimitiveTuples.pair((short) 12, (byte) 2).getOne(), (short) 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals((byte) 2, PrimitiveTuples.pair((short) 1, (byte) 2).getTwo(), (short) 0);
        Assert.assertEquals((byte) 0, PrimitiveTuples.pair((short) 1, (byte) 0).getTwo(), (short) 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:2", PrimitiveTuples.pair((short) 1, (byte) 2).toString());
        Assert.assertEquals("2:8", PrimitiveTuples.pair((short) 2, (byte) 8).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair((short) 2, (byte) 2).compareTo(PrimitiveTuples.pair((short) 1, (byte) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair((short) 1, (byte) 2).compareTo(PrimitiveTuples.pair((short) 1, (byte) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((short) 1, (byte) 2).compareTo(PrimitiveTuples.pair((short) 1, (byte) 3)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortBytePairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBytePairImplTest> payload) throws java.lang.Throwable {
            this.instance = new ShortBytePairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBytePairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBytePairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBytePairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBytePairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBytePairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = ShortBytePairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = ShortBytePairImplTest::getOne;
            this.payloads.getTwo = ShortBytePairImplTest::getTwo;
            this.payloads.testToString = ShortBytePairImplTest::testToString;
            this.payloads.compareTo = ShortBytePairImplTest::compareTo;
        }
    }
}
