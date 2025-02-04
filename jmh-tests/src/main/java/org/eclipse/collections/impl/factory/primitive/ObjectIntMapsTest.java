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

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectIntMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectIntMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectIntMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectIntMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectIntMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectIntMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectIntMapFactory mapFactory) {
        Assert.assertEquals(ObjectIntHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectIntMap.class, mapFactory.of());
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1), mapFactory.of("1", 1));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectIntMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectIntMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectIntMapFactory mapFactory) {
        Assert.assertEquals(ObjectIntHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectIntMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectIntHashMap.newMap(), ObjectIntMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectIntMap.class, ObjectIntMaps.immutable.with());
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1), ObjectIntMaps.immutable.with("1", 1));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectIntHashMap.newMap(), ObjectIntMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectIntMap.class, ObjectIntMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectIntMaps.immutable.of());
        Verify.assertEmpty(ObjectIntMaps.immutable.empty());
        Assert.assertSame(ObjectIntMaps.immutable.of(), ObjectIntMaps.immutable.of());
        Assert.assertSame(ObjectIntMaps.immutable.empty(), ObjectIntMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectIntMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectIntMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectIntMaps.mutable.of());
        Verify.assertEmpty(ObjectIntMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectIntMap<String> map = ObjectIntMaps.immutable.of();
        Assert.assertEquals(map, ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1), ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1)));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2), ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2)));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3), ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2, "3", 3)));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4), ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectIntMap<String> map = ObjectIntMaps.mutable.of();
        Assert.assertEquals(map, ObjectIntMaps.mutable.ofAll(ObjectIntHashMap.newMap()));
        map.put("1", 1);
        Assert.assertEquals(map, ObjectIntMaps.mutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1)));
        map.put("2", 2);
        Assert.assertEquals(map, ObjectIntMaps.mutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2)));
        map.put("3", 3);
        Assert.assertEquals(map, ObjectIntMaps.mutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2, "3", 3)));
        map.put("4", 4);
        Assert.assertEquals(map, ObjectIntMaps.mutable.ofAll(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectIntMap<String> map = ObjectIntMaps.immutable.of();
        Assert.assertEquals(map, ObjectIntMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveInt()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1), ObjectIntMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveInt()));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2), ObjectIntMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveInt()));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3), ObjectIntMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveInt()));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4), ObjectIntMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveInt()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectIntMap<String> map = ObjectIntMaps.mutable.of();
        Assert.assertEquals(map, ObjectIntMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveInt()));
        map.put("1", 1);
        Assert.assertEquals(map, ObjectIntMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveInt()));
        map.put("2", 2);
        Assert.assertEquals(map, ObjectIntMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveInt()));
        map.put("3", 3);
        Assert.assertEquals(map, ObjectIntMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveInt()));
        map.put("4", 4);
        Assert.assertEquals(map, ObjectIntMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveInt()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectIntMaps.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntMapsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> mapWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> emptyMap_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> emptyMap_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> newMapOfAll_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> newMapOfAll_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> newMapFrom_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> newMapFrom_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ObjectIntMapsTest::immutables;
            this.payloads.mutables = ObjectIntMapsTest::mutables;
            this.payloads.mapWith_immutable = ObjectIntMapsTest::mapWith_immutable;
            this.payloads.mapWith_mutable = ObjectIntMapsTest::mapWith_mutable;
            this.payloads.emptyMap_immutable = ObjectIntMapsTest::emptyMap_immutable;
            this.payloads.emptyMap_mutable = ObjectIntMapsTest::emptyMap_mutable;
            this.payloads.newMapOfAll_immutable = ObjectIntMapsTest::newMapOfAll_immutable;
            this.payloads.newMapOfAll_mutable = ObjectIntMapsTest::newMapOfAll_mutable;
            this.payloads.newMapFrom_immutable = ObjectIntMapsTest::newMapFrom_immutable;
            this.payloads.newMapFrom_mutable = ObjectIntMapsTest::newMapFrom_mutable;
            this.payloads.classIsNonInstantiable = ObjectIntMapsTest::classIsNonInstantiable;
        }
    }
*/
}
