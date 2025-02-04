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
 * JUnit test for {@link ByteCharPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class ByteCharPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((byte) 1, (char) 2), PrimitiveTuples.pair((byte) 1, (char) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair((byte) 8, (char) 2), PrimitiveTuples.pair((byte) 1, (char) 2));
        Assert.assertEquals(Tuples.pair((byte) 1, (char) 2).hashCode(), PrimitiveTuples.pair((byte) 1, (char) 2).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals((byte) 1, PrimitiveTuples.pair((byte) 1, (char) 2).getOne(), (byte) 0);
        Assert.assertEquals((byte) 12, PrimitiveTuples.pair((byte) 12, (char) 2).getOne(), (byte) 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals((char) 2, PrimitiveTuples.pair((byte) 1, (char) 2).getTwo(), (byte) 0);
        Assert.assertEquals((char) 0, PrimitiveTuples.pair((byte) 1, (char) 0).getTwo(), (byte) 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:\u0002", PrimitiveTuples.pair((byte) 1, (char) 2).toString());
        Assert.assertEquals("2:\u0008", PrimitiveTuples.pair((byte) 2, (char) 8).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair((byte) 2, (char) 2).compareTo(PrimitiveTuples.pair((byte) 1, (char) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair((byte) 1, (char) 2).compareTo(PrimitiveTuples.pair((byte) 1, (char) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((byte) 1, (char) 2).compareTo(PrimitiveTuples.pair((byte) 1, (char) 3)));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteCharPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new ByteCharPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = ByteCharPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = ByteCharPairImplTest::getOne;
            this.payloads.getTwo = ByteCharPairImplTest::getTwo;
            this.payloads.testToString = ByteCharPairImplTest::testToString;
            this.payloads.compareTo = ByteCharPairImplTest::compareTo;
        }
    }
*/
}
