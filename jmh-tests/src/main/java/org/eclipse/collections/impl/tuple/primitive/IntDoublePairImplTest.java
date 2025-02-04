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
 * JUnit test for {@link IntDoublePairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class IntDoublePairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1, 2.0), PrimitiveTuples.pair(1, 2.0));
        Assert.assertNotEquals(PrimitiveTuples.pair(8, 2.0), PrimitiveTuples.pair(1, 2.0));
        Assert.assertEquals(Tuples.pair(1, 2.0).hashCode(), PrimitiveTuples.pair(1, 2.0).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals(1, PrimitiveTuples.pair(1, 2.0).getOne(), 0);
        Assert.assertEquals(12, PrimitiveTuples.pair(12, 2.0).getOne(), 0);
    }

    @Test
    public void getTwo() {
        Assert.assertEquals(2.0, PrimitiveTuples.pair(1, 2.0).getTwo(), 0);
        Assert.assertEquals(0.0, PrimitiveTuples.pair(1, 0.0).getTwo(), 0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("1:2.0", PrimitiveTuples.pair(1, 2.0).toString());
        Assert.assertEquals("2:8.0", PrimitiveTuples.pair(2, 8.0).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair(2, 2.0).compareTo(PrimitiveTuples.pair(1, 2.0)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1, 2.0).compareTo(PrimitiveTuples.pair(1, 2.0)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1, 2.0).compareTo(PrimitiveTuples.pair(1, 3.0)));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntDoublePairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoublePairImplTest> payload) throws java.lang.Throwable {
            this.instance = new IntDoublePairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoublePairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoublePairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoublePairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoublePairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoublePairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = IntDoublePairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = IntDoublePairImplTest::getOne;
            this.payloads.getTwo = IntDoublePairImplTest::getTwo;
            this.payloads.testToString = IntDoublePairImplTest::testToString;
            this.payloads.compareTo = IntDoublePairImplTest::compareTo;
        }
    }
*/
}
