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

import org.eclipse.collections.api.factory.primitive.ByteByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteByteMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteByteMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteByteHashMap(), ByteByteMaps.mutable.with());
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2), ByteByteMaps.mutable.with((byte) 1, (byte) 2));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4), ByteByteMaps.mutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), ByteByteMaps.mutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), ByteByteMaps.mutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteByteHashMap(), ByteByteMaps.mutable.of());
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2), ByteByteMaps.mutable.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4), ByteByteMaps.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), ByteByteMaps.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), ByteByteMaps.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableByteByteMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableByteByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteByteMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteByteMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableByteByteMapFactoryTest::with;
            this.payloads.of = MutableByteByteMapFactoryTest::of;
        }
    }
}
