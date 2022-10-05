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
import org.eclipse.collections.api.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

/**
 * Junit test for {@link MutableIntObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableIntObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(IntObjectHashMap.newMap(), IntObjectMaps.mutable.with());
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), IntObjectMaps.mutable.with(1, "one"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two"), IntObjectMaps.mutable.with(1, "one", 2, "two"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two", 3, "three"), IntObjectMaps.mutable.with(1, "one", 2, "two", 3, "three"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two", 3, "three", 4, "four"), IntObjectMaps.mutable.with(1, "one", 2, "two", 3, "three", 4, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(IntObjectHashMap.newMap(), IntObjectMaps.mutable.of());
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), IntObjectMaps.mutable.of(1, "one"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two"), IntObjectMaps.mutable.of(1, "one", 2, "two"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two", 3, "three"), IntObjectMaps.mutable.of(1, "one", 2, "two", 3, "three"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two", 3, "three", 4, "four"), IntObjectMaps.mutable.of(1, "one", 2, "two", 3, "three", 4, "four"));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableIntObjectMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableIntObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntObjectMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableIntObjectMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableIntObjectMapFactoryTest::with;
            this.payloads.of = MutableIntObjectMapFactoryTest::of;
        }
    }
}
