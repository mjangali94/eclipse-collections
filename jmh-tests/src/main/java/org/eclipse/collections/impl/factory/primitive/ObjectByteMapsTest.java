/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectByteMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectByteMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectByteMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectByteMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectByteMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectByteMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectByteMapFactory mapFactory) {
        Assert.assertEquals(ObjectByteHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectByteMap.class, mapFactory.of());
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1), mapFactory.of("1", (byte) 1));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectByteMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectByteMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectByteMapFactory mapFactory) {
        Assert.assertEquals(ObjectByteHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectByteMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectByteHashMap.newMap(), ObjectByteMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectByteMap.class, ObjectByteMaps.immutable.with());
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1), ObjectByteMaps.immutable.with("1", (byte) 1));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectByteHashMap.newMap(), ObjectByteMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectByteMap.class, ObjectByteMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectByteMaps.immutable.of());
        Verify.assertEmpty(ObjectByteMaps.immutable.empty());
        Assert.assertSame(ObjectByteMaps.immutable.of(), ObjectByteMaps.immutable.of());
        Assert.assertSame(ObjectByteMaps.immutable.empty(), ObjectByteMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectByteMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectByteMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectByteMaps.mutable.of());
        Verify.assertEmpty(ObjectByteMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectByteMap<String> map = ObjectByteMaps.immutable.of();
        Assert.assertEquals(map, ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", (byte) 1), ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1)));
        Assert.assertEquals(map = map.newWithKeyValue("2", (byte) 2), ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2)));
        Assert.assertEquals(map = map.newWithKeyValue("3", (byte) 3), ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2, "3", (byte) 3)));
        Assert.assertEquals(map = map.newWithKeyValue("4", (byte) 4), ObjectByteMaps.immutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2, "3", (byte) 3, "4", (byte) 4)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectByteMap<String> map = ObjectByteMaps.mutable.of();
        Assert.assertEquals(map, ObjectByteMaps.mutable.ofAll(ObjectByteHashMap.newMap()));
        map.put("1", (byte) 1);
        Assert.assertEquals(map, ObjectByteMaps.mutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1)));
        map.put("2", (byte) 2);
        Assert.assertEquals(map, ObjectByteMaps.mutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2)));
        map.put("3", (byte) 3);
        Assert.assertEquals(map, ObjectByteMaps.mutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2, "3", (byte) 3)));
        map.put("4", (byte) 4);
        Assert.assertEquals(map, ObjectByteMaps.mutable.ofAll(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2, "3", (byte) 3, "4", (byte) 4)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectByteMap<String> map = ObjectByteMaps.immutable.of();
        Assert.assertEquals(map, ObjectByteMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveByte()));
        Assert.assertEquals(map = map.newWithKeyValue("1", (byte) 1), ObjectByteMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveByte()));
        Assert.assertEquals(map = map.newWithKeyValue("2", (byte) 2), ObjectByteMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveByte()));
        Assert.assertEquals(map = map.newWithKeyValue("3", (byte) 3), ObjectByteMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveByte()));
        Assert.assertEquals(map = map.newWithKeyValue("4", (byte) 4), ObjectByteMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveByte()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectByteMap<String> map = ObjectByteMaps.mutable.of();
        Assert.assertEquals(map, ObjectByteMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveByte()));
        map.put("1", (byte) 1);
        Assert.assertEquals(map, ObjectByteMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveByte()));
        map.put("2", (byte) 2);
        Assert.assertEquals(map, ObjectByteMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveByte()));
        map.put("3", (byte) 3);
        Assert.assertEquals(map, ObjectByteMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveByte()));
        map.put("4", (byte) 4);
        Assert.assertEquals(map, ObjectByteMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveByte()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectByteMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectByteMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapWith_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapWith_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyMap_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyMap_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyMap_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyMap_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapOfAll_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapOfAll_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapOfAll_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapOfAll_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapFrom_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapFrom_immutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapFrom_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapFrom_mutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectByteMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> mapWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> emptyMap_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> emptyMap_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> newMapOfAll_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> newMapOfAll_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> newMapFrom_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> newMapFrom_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ObjectByteMapsTest::immutables;
            this.payloads.mutables = ObjectByteMapsTest::mutables;
            this.payloads.mapWith_immutable = ObjectByteMapsTest::mapWith_immutable;
            this.payloads.mapWith_mutable = ObjectByteMapsTest::mapWith_mutable;
            this.payloads.emptyMap_immutable = ObjectByteMapsTest::emptyMap_immutable;
            this.payloads.emptyMap_mutable = ObjectByteMapsTest::emptyMap_mutable;
            this.payloads.newMapOfAll_immutable = ObjectByteMapsTest::newMapOfAll_immutable;
            this.payloads.newMapOfAll_mutable = ObjectByteMapsTest::newMapOfAll_mutable;
            this.payloads.newMapFrom_immutable = ObjectByteMapsTest::newMapFrom_immutable;
            this.payloads.newMapFrom_mutable = ObjectByteMapsTest::newMapFrom_mutable;
            this.payloads.classIsNonInstantiable = ObjectByteMapsTest::classIsNonInstantiable;
        }
    }
}
