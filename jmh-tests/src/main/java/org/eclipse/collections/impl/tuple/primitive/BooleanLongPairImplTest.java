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
 * JUnit test for {@link BooleanLongPairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanLongPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, 1L), PrimitiveTuples.pair(true, 1L));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, 1L), PrimitiveTuples.pair(true, 1L));
        Assert.assertEquals(Tuples.pair(true, 1L).hashCode(), PrimitiveTuples.pair(true, 1L).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertTrue(PrimitiveTuples.pair(true, 1L).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, 5L).getOne());
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(1L, PrimitiveTuples.pair(true, 1L).getTwo(), 0L);
        Assert.assertEquals(2L, PrimitiveTuples.pair(true, 2L).getTwo(), 0L);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("true:1", PrimitiveTuples.pair(true, 1L).toString());
        Assert.assertEquals("false:2", PrimitiveTuples.pair(false, 2L).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1L).compareTo(PrimitiveTuples.pair(false, 2L)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, 1L).compareTo(PrimitiveTuples.pair(true, 1L)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, 1L).compareTo(PrimitiveTuples.pair(true, 2L)));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanLongPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanLongPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanLongPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanLongPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanLongPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanLongPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanLongPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanLongPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = BooleanLongPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = BooleanLongPairImplTest::getOne;
            this.payloads.getTwo = BooleanLongPairImplTest::getTwo;
            this.payloads.testToString = BooleanLongPairImplTest::testToString;
            this.payloads.compareTo = BooleanLongPairImplTest::compareTo;
        }
    }
*/
}
