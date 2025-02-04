/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectByteMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectByteHashMap(), ObjectByteMaps.mutable.of());
        Assert.assertEquals(ObjectByteMaps.mutable.of(), ObjectByteMaps.mutable.empty());
        Assert.assertEquals(ObjectByteMaps.mutable.of("2", (byte) 1), ObjectByteHashMap.newWithKeysValues("2", (byte) 1));
        Assert.assertEquals(ObjectByteMaps.mutable.of("2", (byte) 1, "4", (byte) 3), ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "4", (byte) 3));
        Assert.assertEquals(ObjectByteMaps.mutable.of("2", (byte) 1, "4", (byte) 3, "6", (byte) 5), ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "4", (byte) 3, "6", (byte) 5));
        Assert.assertEquals(ObjectByteMaps.mutable.of("2", (byte) 1, "4", (byte) 3, "6", (byte) 5, "8", (byte) 7), ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "4", (byte) 3, "6", (byte) 5, "8", (byte) 7));
        Assert.assertEquals(ObjectByteMaps.mutable.empty().toImmutable(), ObjectByteMaps.immutable.empty());
        Assert.assertEquals(ObjectByteMaps.mutable.empty().toImmutable(), ObjectByteMaps.immutable.of());
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 1).toImmutable(), ObjectByteMaps.immutable.of("2", (byte) 1));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectByteMaps.mutable.with(), ObjectByteMaps.mutable.empty());
        Assert.assertEquals(ObjectByteMaps.mutable.with("2", (byte) 1), ObjectByteHashMap.newWithKeysValues("2", (byte) 1));
        Assert.assertEquals(ObjectByteMaps.mutable.with("2", (byte) 1, "4", (byte) 3), ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "4", (byte) 3));
        Assert.assertEquals(ObjectByteMaps.mutable.with("2", (byte) 1, "4", (byte) 3, "6", (byte) 5), ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "4", (byte) 3, "6", (byte) 5));
        Assert.assertEquals(ObjectByteMaps.mutable.with("2", (byte) 1, "4", (byte) 3, "6", (byte) 5, "8", (byte) 7), ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "4", (byte) 3, "6", (byte) 5, "8", (byte) 7));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectByteMaps.mutable.empty(), ObjectByteMaps.mutable.ofAll(ObjectByteMaps.mutable.empty()));
        Assert.assertEquals(ObjectByteMaps.mutable.empty().toImmutable(), ObjectByteMaps.immutable.ofAll(ObjectByteMaps.mutable.empty()));
        Assert.assertSame(ObjectByteMaps.immutable.empty(), ObjectByteMaps.immutable.ofAll(ObjectByteMaps.immutable.empty()));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 1), ObjectByteMaps.mutable.ofAll(ObjectByteHashMap.newWithKeysValues("2", (byte) 1)));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 1).toImmutable(), ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newWithKeysValues("2", (byte) 1)));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "3", (byte) 3).toImmutable(), ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "3", (byte) 3)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2, "3", (byte) 3), ObjectByteMaps.mutable.from(iterable, each -> each, Byte::valueOf));
        Assert.assertTrue(ObjectByteMaps.mutable.from(iterable, each -> each, Byte::valueOf) instanceof MutableObjectByteMap);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2, "3", (byte) 3), ObjectByteMaps.immutable.from(iterable, each -> each, Byte::valueOf));
        Assert.assertTrue(ObjectByteMaps.immutable.from(iterable, each -> each, Byte::valueOf) instanceof ImmutableObjectByteMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectByteMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ObjectByteMapFactoryTest::of;
            this.payloads.with = ObjectByteMapFactoryTest::with;
            this.payloads.ofAll = ObjectByteMapFactoryTest::ofAll;
            this.payloads.from = ObjectByteMapFactoryTest::from;
        }
    }
}
