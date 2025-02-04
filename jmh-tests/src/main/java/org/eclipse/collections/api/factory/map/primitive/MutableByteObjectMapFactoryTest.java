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

import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.api.factory.primitive.ByteObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;

/**
 * Junit test for {@link MutableByteObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableByteObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(ByteObjectHashMap.newMap(), ByteObjectMaps.mutable.with());
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), ByteObjectMaps.mutable.with((byte) 1, "one"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two"), ByteObjectMaps.mutable.with((byte) 1, "one", (byte) 2, "two"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three"), ByteObjectMaps.mutable.with((byte) 1, "one", (byte) 2, "two", (byte) 3, "three"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three", (byte) 4, "four"), ByteObjectMaps.mutable.with((byte) 1, "one", (byte) 2, "two", (byte) 3, "three", (byte) 4, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(ByteObjectHashMap.newMap(), ByteObjectMaps.mutable.of());
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), ByteObjectMaps.mutable.of((byte) 1, "one"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two"), ByteObjectMaps.mutable.of((byte) 1, "one", (byte) 2, "two"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three"), ByteObjectMaps.mutable.of((byte) 1, "one", (byte) 2, "two", (byte) 3, "three"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three", (byte) 4, "four"), ByteObjectMaps.mutable.of((byte) 1, "one", (byte) 2, "two", (byte) 3, "three", (byte) 4, "four"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableByteObjectMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableByteObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteObjectMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteObjectMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableByteObjectMapFactoryTest::with;
            this.payloads.of = MutableByteObjectMapFactoryTest::of;
        }
    }
}
