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
 * JUnit test for {@link CharShortPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class CharShortPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((char) 1, (short) 2), PrimitiveTuples.pair((char) 1, (short) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair((char) 8, (short) 2), PrimitiveTuples.pair((char) 1, (short) 2));
        Assert.assertEquals(Tuples.pair((char) 1, (short) 2).hashCode(), PrimitiveTuples.pair((char) 1, (short) 2).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals((char) 1, PrimitiveTuples.pair((char) 1, (short) 2).getOne(), (char) 0);
        Assert.assertEquals((char) 12, PrimitiveTuples.pair((char) 12, (short) 2).getOne(), (char) 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals((short) 2, PrimitiveTuples.pair((char) 1, (short) 2).getTwo(), (char) 0);
        Assert.assertEquals((short) 0, PrimitiveTuples.pair((char) 1, (short) 0).getTwo(), (char) 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("\u0001:2", PrimitiveTuples.pair((char) 1, (short) 2).toString());
        Assert.assertEquals("\u0002:8", PrimitiveTuples.pair((char) 2, (short) 8).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair((char) 2, (short) 2).compareTo(PrimitiveTuples.pair((char) 1, (short) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair((char) 1, (short) 2).compareTo(PrimitiveTuples.pair((char) 1, (short) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((char) 1, (short) 2).compareTo(PrimitiveTuples.pair((char) 1, (short) 3)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharShortPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharShortPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new CharShortPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharShortPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharShortPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharShortPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharShortPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharShortPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = CharShortPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = CharShortPairImplTest::getOne;
            this.payloads.getTwo = CharShortPairImplTest::getTwo;
            this.payloads.testToString = CharShortPairImplTest::testToString;
            this.payloads.compareTo = CharShortPairImplTest::compareTo;
        }
    }
}
