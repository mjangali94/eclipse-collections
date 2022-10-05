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

import org.eclipse.collections.api.factory.primitive.ByteIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteIntHashMap(), ByteIntMaps.mutable.with());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2), ByteIntMaps.mutable.with((byte) 1, 2));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4), ByteIntMaps.mutable.with((byte) 1, 2, (byte) 3, 4));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6), ByteIntMaps.mutable.with((byte) 1, 2, (byte) 3, 4, (byte) 5, 6));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8), ByteIntMaps.mutable.with((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteIntHashMap(), ByteIntMaps.mutable.of());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2), ByteIntMaps.mutable.of((byte) 1, 2));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4), ByteIntMaps.mutable.of((byte) 1, 2, (byte) 3, 4));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6), ByteIntMaps.mutable.of((byte) 1, 2, (byte) 3, 4, (byte) 5, 6));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8), ByteIntMaps.mutable.of((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableByteIntMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteIntMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableByteIntMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteIntMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteIntMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableByteIntMapFactoryTest::with;
            this.payloads.of = MutableByteIntMapFactoryTest::of;
        }
    }
}
