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
import org.eclipse.collections.api.factory.primitive.ShortObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortObjectHashMap;

/**
 * Junit test for {@link MutableShortObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableShortObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(ShortObjectHashMap.newMap(), ShortObjectMaps.mutable.with());
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), ShortObjectMaps.mutable.with((short) 1, "one"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two"), ShortObjectMaps.mutable.with((short) 1, "one", (short) 2, "two"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three"), ShortObjectMaps.mutable.with((short) 1, "one", (short) 2, "two", (short) 3, "three"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three", (short) 4, "four"), ShortObjectMaps.mutable.with((short) 1, "one", (short) 2, "two", (short) 3, "three", (short) 4, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(ShortObjectHashMap.newMap(), ShortObjectMaps.mutable.of());
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), ShortObjectMaps.mutable.of((short) 1, "one"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two"), ShortObjectMaps.mutable.of((short) 1, "one", (short) 2, "two"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three"), ShortObjectMaps.mutable.of((short) 1, "one", (short) 2, "two", (short) 3, "three"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three", (short) 4, "four"), ShortObjectMaps.mutable.of((short) 1, "one", (short) 2, "two", (short) 3, "three", (short) 4, "four"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableShortObjectMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableShortObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortObjectMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortObjectMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableShortObjectMapFactoryTest::with;
            this.payloads.of = MutableShortObjectMapFactoryTest::of;
        }
    }
}
