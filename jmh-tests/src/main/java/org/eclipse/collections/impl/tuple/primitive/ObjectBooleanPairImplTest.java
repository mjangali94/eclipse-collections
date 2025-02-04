/*
 * Copyright (c) 2021 Goldman Sachs.
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
 * JUnit test for {@link ObjectBooleanPairImpl}.
 */
public class ObjectBooleanPairImplTest {

    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair("true", false), PrimitiveTuples.pair("true", false));
        Assert.assertNotEquals(PrimitiveTuples.pair("false", true), PrimitiveTuples.pair("true", false));
        Assert.assertEquals(Tuples.pair("true", false).hashCode(), PrimitiveTuples.pair("true", false).hashCode());
    }

    @Test
    public void getOne() {
        Assert.assertEquals("true", PrimitiveTuples.pair("true", false).getOne());
        Assert.assertEquals("false", PrimitiveTuples.pair("false", true).getOne());
    }

    @Test
    public void getTwo() {
        Assert.assertTrue(PrimitiveTuples.pair("false", true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair("true", false).getTwo());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("true:false", PrimitiveTuples.pair("true", false).toString());
        Assert.assertEquals("true:true", PrimitiveTuples.pair("true", true).toString());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(1, PrimitiveTuples.pair("true", true).compareTo(PrimitiveTuples.pair("true", false)));
        Assert.assertEquals(0, PrimitiveTuples.pair("true", false).compareTo(PrimitiveTuples.pair("true", false)));
        Assert.assertEquals(-1, PrimitiveTuples.pair("true", false).compareTo(PrimitiveTuples.pair("true", true)));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectBooleanPairImplTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanPairImplTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectBooleanPairImplTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanPairImplTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanPairImplTest> getOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanPairImplTest> getTwo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanPairImplTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectBooleanPairImplTest> compareTo;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testEqualsAndHashCode = ObjectBooleanPairImplTest::testEqualsAndHashCode;
            this.payloads.getOne = ObjectBooleanPairImplTest::getOne;
            this.payloads.getTwo = ObjectBooleanPairImplTest::getTwo;
            this.payloads.testToString = ObjectBooleanPairImplTest::testToString;
            this.payloads.compareTo = ObjectBooleanPairImplTest::compareTo;
        }
    }
}
