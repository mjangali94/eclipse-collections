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

import org.eclipse.collections.api.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableShortLongMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableShortLongMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ShortLongHashMap(), ShortLongMaps.mutable.with());
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L), ShortLongMaps.mutable.with((short) 1, 2L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L, (short) 3, 4L), ShortLongMaps.mutable.with((short) 1, 2L, (short) 3, 4L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L, (short) 3, 4L, (short) 5, 6L), ShortLongMaps.mutable.with((short) 1, 2L, (short) 3, 4L, (short) 5, 6L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L, (short) 3, 4L, (short) 5, 6L, (short) 7, 8L), ShortLongMaps.mutable.with((short) 1, 2L, (short) 3, 4L, (short) 5, 6L, (short) 7, 8L));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ShortLongHashMap(), ShortLongMaps.mutable.of());
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L), ShortLongMaps.mutable.of((short) 1, 2L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L, (short) 3, 4L), ShortLongMaps.mutable.of((short) 1, 2L, (short) 3, 4L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L, (short) 3, 4L, (short) 5, 6L), ShortLongMaps.mutable.of((short) 1, 2L, (short) 3, 4L, (short) 5, 6L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L, (short) 3, 4L, (short) 5, 6L, (short) 7, 8L), ShortLongMaps.mutable.of((short) 1, 2L, (short) 3, 4L, (short) 5, 6L, (short) 7, 8L));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableShortLongMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortLongMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableShortLongMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortLongMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortLongMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableShortLongMapFactoryTest::with;
            this.payloads.of = MutableShortLongMapFactoryTest::of;
        }
    }
}
