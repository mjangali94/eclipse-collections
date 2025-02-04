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

import org.eclipse.collections.api.factory.primitive.ByteLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteLongMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteLongMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteLongHashMap(), ByteLongMaps.mutable.with());
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L), ByteLongMaps.mutable.with((byte) 1, 2L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L), ByteLongMaps.mutable.with((byte) 1, 2L, (byte) 3, 4L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L), ByteLongMaps.mutable.with((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L, (byte) 7, 8L), ByteLongMaps.mutable.with((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L, (byte) 7, 8L));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteLongHashMap(), ByteLongMaps.mutable.of());
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L), ByteLongMaps.mutable.of((byte) 1, 2L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L), ByteLongMaps.mutable.of((byte) 1, 2L, (byte) 3, 4L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L), ByteLongMaps.mutable.of((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L, (byte) 7, 8L), ByteLongMaps.mutable.of((byte) 1, 2L, (byte) 3, 4L, (byte) 5, 6L, (byte) 7, 8L));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableByteLongMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteLongMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableByteLongMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteLongMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableByteLongMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableByteLongMapFactoryTest::with;
            this.payloads.of = MutableByteLongMapFactoryTest::of;
        }
    }
}
