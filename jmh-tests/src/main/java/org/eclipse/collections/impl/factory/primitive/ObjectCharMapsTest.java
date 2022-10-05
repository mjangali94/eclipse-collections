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

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectCharMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectCharMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectCharMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectCharMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectCharMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectCharMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectCharMapFactory mapFactory) {
        Assert.assertEquals(ObjectCharHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectCharMap.class, mapFactory.of());
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1), mapFactory.of("1", (char) 1));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectCharMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectCharMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectCharMapFactory mapFactory) {
        Assert.assertEquals(ObjectCharHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectCharMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectCharHashMap.newMap(), ObjectCharMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectCharMap.class, ObjectCharMaps.immutable.with());
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1), ObjectCharMaps.immutable.with("1", (char) 1));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectCharHashMap.newMap(), ObjectCharMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectCharMap.class, ObjectCharMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectCharMaps.immutable.of());
        Verify.assertEmpty(ObjectCharMaps.immutable.empty());
        Assert.assertSame(ObjectCharMaps.immutable.of(), ObjectCharMaps.immutable.of());
        Assert.assertSame(ObjectCharMaps.immutable.empty(), ObjectCharMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectCharMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectCharMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectCharMaps.mutable.of());
        Verify.assertEmpty(ObjectCharMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectCharMap<String> map = ObjectCharMaps.immutable.of();
        Assert.assertEquals(map, ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", (char) 1), ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1)));
        Assert.assertEquals(map = map.newWithKeyValue("2", (char) 2), ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2)));
        Assert.assertEquals(map = map.newWithKeyValue("3", (char) 3), ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2, "3", (char) 3)));
        Assert.assertEquals(map = map.newWithKeyValue("4", (char) 4), ObjectCharMaps.immutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2, "3", (char) 3, "4", (char) 4)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectCharMap<String> map = ObjectCharMaps.mutable.of();
        Assert.assertEquals(map, ObjectCharMaps.mutable.ofAll(ObjectCharHashMap.newMap()));
        map.put("1", (char) 1);
        Assert.assertEquals(map, ObjectCharMaps.mutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1)));
        map.put("2", (char) 2);
        Assert.assertEquals(map, ObjectCharMaps.mutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2)));
        map.put("3", (char) 3);
        Assert.assertEquals(map, ObjectCharMaps.mutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2, "3", (char) 3)));
        map.put("4", (char) 4);
        Assert.assertEquals(map, ObjectCharMaps.mutable.ofAll(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2, "3", (char) 3, "4", (char) 4)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectCharMap<String> map = ObjectCharMaps.immutable.of();
        Assert.assertEquals(map, ObjectCharMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveChar()));
        Assert.assertEquals(map = map.newWithKeyValue("1", (char) 1), ObjectCharMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveChar()));
        Assert.assertEquals(map = map.newWithKeyValue("2", (char) 2), ObjectCharMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveChar()));
        Assert.assertEquals(map = map.newWithKeyValue("3", (char) 3), ObjectCharMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveChar()));
        Assert.assertEquals(map = map.newWithKeyValue("4", (char) 4), ObjectCharMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveChar()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectCharMap<String> map = ObjectCharMaps.mutable.of();
        Assert.assertEquals(map, ObjectCharMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveChar()));
        map.put("1", (char) 1);
        Assert.assertEquals(map, ObjectCharMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveChar()));
        map.put("2", (char) 2);
        Assert.assertEquals(map, ObjectCharMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveChar()));
        map.put("3", (char) 3);
        Assert.assertEquals(map, ObjectCharMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveChar()));
        map.put("4", (char) 4);
        Assert.assertEquals(map, ObjectCharMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveChar()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectCharMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharMapsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> mapWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> emptyMap_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> emptyMap_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> newMapOfAll_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> newMapOfAll_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> newMapFrom_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> newMapFrom_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ObjectCharMapsTest::immutables;
            this.payloads.mutables = ObjectCharMapsTest::mutables;
            this.payloads.mapWith_immutable = ObjectCharMapsTest::mapWith_immutable;
            this.payloads.mapWith_mutable = ObjectCharMapsTest::mapWith_mutable;
            this.payloads.emptyMap_immutable = ObjectCharMapsTest::emptyMap_immutable;
            this.payloads.emptyMap_mutable = ObjectCharMapsTest::emptyMap_mutable;
            this.payloads.newMapOfAll_immutable = ObjectCharMapsTest::newMapOfAll_immutable;
            this.payloads.newMapOfAll_mutable = ObjectCharMapsTest::newMapOfAll_mutable;
            this.payloads.newMapFrom_immutable = ObjectCharMapsTest::newMapFrom_immutable;
            this.payloads.newMapFrom_mutable = ObjectCharMapsTest::newMapFrom_mutable;
            this.payloads.classIsNonInstantiable = ObjectCharMapsTest::classIsNonInstantiable;
        }
    }
}
