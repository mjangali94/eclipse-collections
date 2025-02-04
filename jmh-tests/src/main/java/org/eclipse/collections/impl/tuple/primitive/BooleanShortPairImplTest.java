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
 * JUnit test for {@link BooleanShortPairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanShortPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, (short) 1), PrimitiveTuples.pair(true, (short) 1));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, (short) 1), PrimitiveTuples.pair(true, (short) 1));
        Assert.assertEquals(Tuples.pair(true, (short) 1).hashCode(), PrimitiveTuples.pair(true, (short) 1).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertTrue(PrimitiveTuples.pair(true, (short) 1).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, (short) 5).getOne());
    }

    @Test
    public void getTwo() {
        Assert.assertEquals((short) 1, PrimitiveTuples.pair(true, (short) 1).getTwo(), (short) 0);
        Assert.assertEquals((short) 2, PrimitiveTuples.pair(true, (short) 2).getTwo(), (short) 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("true:1", PrimitiveTuples.pair(true, (short) 1).toString());
        Assert.assertEquals("false:2", PrimitiveTuples.pair(false, (short) 2).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, (short) 1).compareTo(PrimitiveTuples.pair(false, (short) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, (short) 1).compareTo(PrimitiveTuples.pair(true, (short) 1)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, (short) 1).compareTo(PrimitiveTuples.pair(true, (short) 2)));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private BooleanShortPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanShortPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new BooleanShortPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanShortPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanShortPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanShortPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanShortPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<BooleanShortPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = BooleanShortPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = BooleanShortPairImplTest::getOne;
            this.payloads.getTwo = BooleanShortPairImplTest::getTwo;
            this.payloads.testToString = BooleanShortPairImplTest::testToString;
            this.payloads.compareTo = BooleanShortPairImplTest::compareTo;
        }
    }
*/
}
