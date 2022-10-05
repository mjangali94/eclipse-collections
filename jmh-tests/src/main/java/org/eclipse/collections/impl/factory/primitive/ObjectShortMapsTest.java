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

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectShortMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectShortMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectShortMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectShortMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectShortMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectShortMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectShortMapFactory mapFactory) {
        Assert.assertEquals(ObjectShortHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectShortMap.class, mapFactory.of());
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1), mapFactory.of("1", (short) 1));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectShortMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectShortMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectShortMapFactory mapFactory) {
        Assert.assertEquals(ObjectShortHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectShortMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectShortHashMap.newMap(), ObjectShortMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectShortMap.class, ObjectShortMaps.immutable.with());
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1), ObjectShortMaps.immutable.with("1", (short) 1));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectShortHashMap.newMap(), ObjectShortMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectShortMap.class, ObjectShortMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectShortMaps.immutable.of());
        Verify.assertEmpty(ObjectShortMaps.immutable.empty());
        Assert.assertSame(ObjectShortMaps.immutable.of(), ObjectShortMaps.immutable.of());
        Assert.assertSame(ObjectShortMaps.immutable.empty(), ObjectShortMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectShortMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectShortMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectShortMaps.mutable.of());
        Verify.assertEmpty(ObjectShortMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectShortMap<String> map = ObjectShortMaps.immutable.of();
        Assert.assertEquals(map, ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", (short) 1), ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1)));
        Assert.assertEquals(map = map.newWithKeyValue("2", (short) 2), ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2)));
        Assert.assertEquals(map = map.newWithKeyValue("3", (short) 3), ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2, "3", (short) 3)));
        Assert.assertEquals(map = map.newWithKeyValue("4", (short) 4), ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2, "3", (short) 3, "4", (short) 4)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectShortMap<String> map = ObjectShortMaps.mutable.of();
        Assert.assertEquals(map, ObjectShortMaps.mutable.ofAll(ObjectShortHashMap.newMap()));
        map.put("1", (short) 1);
        Assert.assertEquals(map, ObjectShortMaps.mutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1)));
        map.put("2", (short) 2);
        Assert.assertEquals(map, ObjectShortMaps.mutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2)));
        map.put("3", (short) 3);
        Assert.assertEquals(map, ObjectShortMaps.mutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2, "3", (short) 3)));
        map.put("4", (short) 4);
        Assert.assertEquals(map, ObjectShortMaps.mutable.ofAll(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2, "3", (short) 3, "4", (short) 4)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectShortMap<String> map = ObjectShortMaps.immutable.of();
        Assert.assertEquals(map, ObjectShortMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveShort()));
        Assert.assertEquals(map = map.newWithKeyValue("1", (short) 1), ObjectShortMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveShort()));
        Assert.assertEquals(map = map.newWithKeyValue("2", (short) 2), ObjectShortMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveShort()));
        Assert.assertEquals(map = map.newWithKeyValue("3", (short) 3), ObjectShortMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveShort()));
        Assert.assertEquals(map = map.newWithKeyValue("4", (short) 4), ObjectShortMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveShort()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectShortMap<String> map = ObjectShortMaps.mutable.of();
        Assert.assertEquals(map, ObjectShortMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveShort()));
        map.put("1", (short) 1);
        Assert.assertEquals(map, ObjectShortMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveShort()));
        map.put("2", (short) 2);
        Assert.assertEquals(map, ObjectShortMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveShort()));
        map.put("3", (short) 3);
        Assert.assertEquals(map, ObjectShortMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveShort()));
        map.put("4", (short) 4);
        Assert.assertEquals(map, ObjectShortMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveShort()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectShortMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortMapsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> mapWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> emptyMap_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> emptyMap_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> newMapOfAll_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> newMapOfAll_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> newMapFrom_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> newMapFrom_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ObjectShortMapsTest::immutables;
            this.payloads.mutables = ObjectShortMapsTest::mutables;
            this.payloads.mapWith_immutable = ObjectShortMapsTest::mapWith_immutable;
            this.payloads.mapWith_mutable = ObjectShortMapsTest::mapWith_mutable;
            this.payloads.emptyMap_immutable = ObjectShortMapsTest::emptyMap_immutable;
            this.payloads.emptyMap_mutable = ObjectShortMapsTest::emptyMap_mutable;
            this.payloads.newMapOfAll_immutable = ObjectShortMapsTest::newMapOfAll_immutable;
            this.payloads.newMapOfAll_mutable = ObjectShortMapsTest::newMapOfAll_mutable;
            this.payloads.newMapFrom_immutable = ObjectShortMapsTest::newMapFrom_immutable;
            this.payloads.newMapFrom_mutable = ObjectShortMapsTest::newMapFrom_mutable;
            this.payloads.classIsNonInstantiable = ObjectShortMapsTest::classIsNonInstantiable;
        }
    }
}
