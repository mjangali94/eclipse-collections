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
 * JUnit test for {@link BooleanDoublePairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanDoublePairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, 1.0), PrimitiveTuples.pair(true, 1.0));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, 1.0), PrimitiveTuples.pair(true, 1.0));
        Assert.assertEquals(Tuples.pair(true, 1.0).hashCode(), PrimitiveTuples.pair(true, 1.0).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertTrue(PrimitiveTuples.pair(true, 1.0).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, 5.0).getOne());
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(1.0, PrimitiveTuples.pair(true, 1.0).getTwo(), 0.0);
        Assert.assertEquals(2.0, PrimitiveTuples.pair(true, 2.0).getTwo(), 0.0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("true:1.0", PrimitiveTuples.pair(true, 1.0).toString());
        Assert.assertEquals("false:2.0", PrimitiveTuples.pair(false, 2.0).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1.0).compareTo(PrimitiveTuples.pair(false, 2.0)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, 1.0).compareTo(PrimitiveTuples.pair(true, 1.0)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, 1.0).compareTo(PrimitiveTuples.pair(true, 2.0)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanDoublePairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanDoublePairImplTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanDoublePairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanDoublePairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanDoublePairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanDoublePairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanDoublePairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanDoublePairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = BooleanDoublePairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = BooleanDoublePairImplTest::getOne;
            this.payloads.getTwo = BooleanDoublePairImplTest::getTwo;
            this.payloads.testToString = BooleanDoublePairImplTest::testToString;
            this.payloads.compareTo = BooleanDoublePairImplTest::compareTo;
        }
    }
}
