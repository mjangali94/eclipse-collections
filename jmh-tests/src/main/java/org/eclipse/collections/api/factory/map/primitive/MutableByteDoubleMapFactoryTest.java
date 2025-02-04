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

import org.eclipse.collections.api.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteDoubleMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteDoubleMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteDoubleHashMap(), ByteDoubleMaps.mutable.with());
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0, (byte) 3, 4.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteDoubleHashMap(), ByteDoubleMaps.mutable.of());
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0, (byte) 3, 4.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableByteDoubleMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableByteDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteDoubleMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteDoubleMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableByteDoubleMapFactoryTest::with;
            this.payloads.of = MutableByteDoubleMapFactoryTest::of;
        }
    }
}
