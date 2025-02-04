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
 * JUnit test for {@link ShortBooleanPairImpl}.
 *
 * This file was automatically generated from template file primitiveBooleanPairImplTest.stg.
 */
public class ShortBooleanPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((short) 1, true), PrimitiveTuples.pair((short) 1, true));
        Assert.assertNotEquals(PrimitiveTuples.pair((short) 1, false), PrimitiveTuples.pair((short) 1, true));
        Assert.assertEquals(Tuples.pair((short) 1, true).hashCode(), PrimitiveTuples.pair((short) 1, true).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals((short) 1, PrimitiveTuples.pair((short) 1, true).getOne(), (short) 0);
        Assert.assertEquals((short) 3, PrimitiveTuples.pair((short) 3, true).getOne(), (short) 0);
    }

    @Test
    public void getTwo() {
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair((short) 1, false).getTwo());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:true", PrimitiveTuples.pair((short) 1, true).toString());
        Assert.assertEquals("2:false", PrimitiveTuples.pair((short) 2, false).toString());
        Assert.assertNotEquals("2, false", PrimitiveTuples.pair((short) 2, false).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, PrimitiveTuples.pair((short) 1, true).compareTo(PrimitiveTuples.pair((short) 2, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair((short) 1, true).compareTo(PrimitiveTuples.pair((short) 1, true)));
        Assert.assertEquals(1, PrimitiveTuples.pair((short) 1, true).compareTo(PrimitiveTuples.pair((short) 1, false)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortBooleanPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new ShortBooleanPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = ShortBooleanPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = ShortBooleanPairImplTest::getOne;
            this.payloads.getTwo = ShortBooleanPairImplTest::getTwo;
            this.payloads.testToString = ShortBooleanPairImplTest::testToString;
            this.payloads.compareTo = ShortBooleanPairImplTest::compareTo;
        }
    }
}
