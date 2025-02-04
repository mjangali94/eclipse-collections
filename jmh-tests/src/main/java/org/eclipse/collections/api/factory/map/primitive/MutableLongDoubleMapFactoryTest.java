/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.factory.map.primitive;

import org.eclipse.collections.api.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongDoubleMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongDoubleMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongDoubleHashMap(), LongDoubleMaps.mutable.with());
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0), LongDoubleMaps.mutable.with(1L, 2.0));
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0, 3L, 4.0), LongDoubleMaps.mutable.with(1L, 2.0, 3L, 4.0));
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0, 3L, 4.0, 5L, 6.0), LongDoubleMaps.mutable.with(1L, 2.0, 3L, 4.0, 5L, 6.0));
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0, 3L, 4.0, 5L, 6.0, 7L, 8.0), LongDoubleMaps.mutable.with(1L, 2.0, 3L, 4.0, 5L, 6.0, 7L, 8.0));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongDoubleHashMap(), LongDoubleMaps.mutable.of());
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0), LongDoubleMaps.mutable.of(1L, 2.0));
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0, 3L, 4.0), LongDoubleMaps.mutable.of(1L, 2.0, 3L, 4.0));
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0, 3L, 4.0, 5L, 6.0), LongDoubleMaps.mutable.of(1L, 2.0, 3L, 4.0, 5L, 6.0));
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0, 3L, 4.0, 5L, 6.0, 7L, 8.0), LongDoubleMaps.mutable.of(1L, 2.0, 3L, 4.0, 5L, 6.0, 7L, 8.0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableLongDoubleMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableLongDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongDoubleMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongDoubleMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableLongDoubleMapFactoryTest::with;
            this.payloads.of = MutableLongDoubleMapFactoryTest::of;
        }
    }
}
