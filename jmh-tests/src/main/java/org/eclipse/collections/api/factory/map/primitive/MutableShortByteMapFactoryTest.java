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

import org.eclipse.collections.api.factory.primitive.ShortByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableShortByteMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableShortByteMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ShortByteHashMap(), ShortByteMaps.mutable.with());
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2), ShortByteMaps.mutable.with((short) 1, (byte) 2));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2, (short) 3, (byte) 4), ShortByteMaps.mutable.with((short) 1, (byte) 2, (short) 3, (byte) 4));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6), ShortByteMaps.mutable.with((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6, (short) 7, (byte) 8), ShortByteMaps.mutable.with((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6, (short) 7, (byte) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ShortByteHashMap(), ShortByteMaps.mutable.of());
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2), ShortByteMaps.mutable.of((short) 1, (byte) 2));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2, (short) 3, (byte) 4), ShortByteMaps.mutable.of((short) 1, (byte) 2, (short) 3, (byte) 4));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6), ShortByteMaps.mutable.of((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6, (short) 7, (byte) 8), ShortByteMaps.mutable.of((short) 1, (byte) 2, (short) 3, (byte) 4, (short) 5, (byte) 6, (short) 7, (byte) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableShortByteMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableShortByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortByteMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortByteMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableShortByteMapFactoryTest::with;
            this.payloads.of = MutableShortByteMapFactoryTest::of;
        }
    }
}
