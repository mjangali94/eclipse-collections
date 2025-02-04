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
 * JUnit test for {@link ShortLongPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class ShortLongPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 1, 2L));
        Assert.assertNotEquals(PrimitiveTuples.pair((short) 8, 2L), PrimitiveTuples.pair((short) 1, 2L));
        Assert.assertEquals(Tuples.pair((short) 1, 2L).hashCode(), PrimitiveTuples.pair((short) 1, 2L).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals((short) 1, PrimitiveTuples.pair((short) 1, 2L).getOne(), (short) 0);
        Assert.assertEquals((short) 12, PrimitiveTuples.pair((short) 12, 2L).getOne(), (short) 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(2L, PrimitiveTuples.pair((short) 1, 2L).getTwo(), (short) 0);
        Assert.assertEquals(0L, PrimitiveTuples.pair((short) 1, 0L).getTwo(), (short) 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:2", PrimitiveTuples.pair((short) 1, 2L).toString());
        Assert.assertEquals("2:8", PrimitiveTuples.pair((short) 2, 8L).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair((short) 2, 2L).compareTo(PrimitiveTuples.pair((short) 1, 2L)));
        Assert.assertEquals(0, PrimitiveTuples.pair((short) 1, 2L).compareTo(PrimitiveTuples.pair((short) 1, 2L)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((short) 1, 2L).compareTo(PrimitiveTuples.pair((short) 1, 3L)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortLongPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new ShortLongPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = ShortLongPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = ShortLongPairImplTest::getOne;
            this.payloads.getTwo = ShortLongPairImplTest::getTwo;
            this.payloads.testToString = ShortLongPairImplTest::testToString;
            this.payloads.compareTo = ShortLongPairImplTest::compareTo;
        }
    }
}
