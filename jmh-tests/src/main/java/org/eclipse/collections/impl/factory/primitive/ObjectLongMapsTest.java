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

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectLongMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectLongMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectLongMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectLongMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectLongMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectLongMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectLongMapFactory mapFactory) {
        Assert.assertEquals(ObjectLongHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectLongMap.class, mapFactory.of());
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L), mapFactory.of("1", 1L));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectLongMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectLongMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectLongMapFactory mapFactory) {
        Assert.assertEquals(ObjectLongHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectLongMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectLongHashMap.newMap(), ObjectLongMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectLongMap.class, ObjectLongMaps.immutable.with());
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L), ObjectLongMaps.immutable.with("1", 1L));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectLongHashMap.newMap(), ObjectLongMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectLongMap.class, ObjectLongMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectLongMaps.immutable.of());
        Verify.assertEmpty(ObjectLongMaps.immutable.empty());
        Assert.assertSame(ObjectLongMaps.immutable.of(), ObjectLongMaps.immutable.of());
        Assert.assertSame(ObjectLongMaps.immutable.empty(), ObjectLongMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectLongMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectLongMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectLongMaps.mutable.of());
        Verify.assertEmpty(ObjectLongMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectLongMap<String> map = ObjectLongMaps.immutable.of();
        Assert.assertEquals(map, ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1L), ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L)));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2L), ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L)));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3L), ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L, "3", 3L)));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4L), ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L, "3", 3L, "4", 4L)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectLongMap<String> map = ObjectLongMaps.mutable.of();
        Assert.assertEquals(map, ObjectLongMaps.mutable.ofAll(ObjectLongHashMap.newMap()));
        map.put("1", 1L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L)));
        map.put("2", 2L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L)));
        map.put("3", 3L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L, "3", 3L)));
        map.put("4", 4L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.ofAll(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L, "3", 3L, "4", 4L)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectLongMap<String> map = ObjectLongMaps.immutable.of();
        Assert.assertEquals(map, ObjectLongMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveLong()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1L), ObjectLongMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveLong()));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2L), ObjectLongMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveLong()));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3L), ObjectLongMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveLong()));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4L), ObjectLongMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveLong()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectLongMap<String> map = ObjectLongMaps.mutable.of();
        Assert.assertEquals(map, ObjectLongMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveLong()));
        map.put("1", 1L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveLong()));
        map.put("2", 2L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveLong()));
        map.put("3", 3L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveLong()));
        map.put("4", 4L);
        Assert.assertEquals(map, ObjectLongMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveLong()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectLongMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectLongMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapWith_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapWith_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyMap_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyMap_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyMap_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.emptyMap_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapOfAll_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapOfAll_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapOfAll_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapOfAll_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapFrom_immutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapFrom_immutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapFrom_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapFrom_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectLongMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> mapWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> emptyMap_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> emptyMap_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> newMapOfAll_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> newMapOfAll_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> newMapFrom_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> newMapFrom_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ObjectLongMapsTest::immutables;
            this.payloads.mutables = ObjectLongMapsTest::mutables;
            this.payloads.mapWith_immutable = ObjectLongMapsTest::mapWith_immutable;
            this.payloads.mapWith_mutable = ObjectLongMapsTest::mapWith_mutable;
            this.payloads.emptyMap_immutable = ObjectLongMapsTest::emptyMap_immutable;
            this.payloads.emptyMap_mutable = ObjectLongMapsTest::emptyMap_mutable;
            this.payloads.newMapOfAll_immutable = ObjectLongMapsTest::newMapOfAll_immutable;
            this.payloads.newMapOfAll_mutable = ObjectLongMapsTest::newMapOfAll_mutable;
            this.payloads.newMapFrom_immutable = ObjectLongMapsTest::newMapFrom_immutable;
            this.payloads.newMapFrom_mutable = ObjectLongMapsTest::newMapFrom_mutable;
            this.payloads.classIsNonInstantiable = ObjectLongMapsTest::classIsNonInstantiable;
        }
    }
}
