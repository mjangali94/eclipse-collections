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

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectFloatMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectFloatMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectFloatMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectFloatMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectFloatMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectFloatMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectFloatMapFactory mapFactory) {
        Assert.assertEquals(ObjectFloatHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectFloatMap.class, mapFactory.of());
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f), mapFactory.of("1", 1.0f));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectFloatMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectFloatMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectFloatMapFactory mapFactory) {
        Assert.assertEquals(ObjectFloatHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectFloatMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectFloatHashMap.newMap(), ObjectFloatMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectFloatMap.class, ObjectFloatMaps.immutable.with());
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f), ObjectFloatMaps.immutable.with("1", 1.0f));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectFloatHashMap.newMap(), ObjectFloatMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectFloatMap.class, ObjectFloatMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectFloatMaps.immutable.of());
        Verify.assertEmpty(ObjectFloatMaps.immutable.empty());
        Assert.assertSame(ObjectFloatMaps.immutable.of(), ObjectFloatMaps.immutable.of());
        Assert.assertSame(ObjectFloatMaps.immutable.empty(), ObjectFloatMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectFloatMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectFloatMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectFloatMaps.mutable.of());
        Verify.assertEmpty(ObjectFloatMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectFloatMap<String> map = ObjectFloatMaps.immutable.of();
        Assert.assertEquals(map, ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1.0f), ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f)));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2.0f), ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f)));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3.0f), ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f, "3", 3.0f)));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4.0f), ObjectFloatMaps.immutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f, "3", 3.0f, "4", 4.0f)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectFloatMap<String> map = ObjectFloatMaps.mutable.of();
        Assert.assertEquals(map, ObjectFloatMaps.mutable.ofAll(ObjectFloatHashMap.newMap()));
        map.put("1", 1.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f)));
        map.put("2", 2.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f)));
        map.put("3", 3.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f, "3", 3.0f)));
        map.put("4", 4.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.ofAll(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f, "3", 3.0f, "4", 4.0f)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectFloatMap<String> map = ObjectFloatMaps.immutable.of();
        Assert.assertEquals(map, ObjectFloatMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveFloat()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1.0f), ObjectFloatMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveFloat()));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2.0f), ObjectFloatMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveFloat()));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3.0f), ObjectFloatMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveFloat()));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4.0f), ObjectFloatMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveFloat()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectFloatMap<String> map = ObjectFloatMaps.mutable.of();
        Assert.assertEquals(map, ObjectFloatMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveFloat()));
        map.put("1", 1.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveFloat()));
        map.put("2", 2.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveFloat()));
        map.put("3", 3.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveFloat()));
        map.put("4", 4.0f);
        Assert.assertEquals(map, ObjectFloatMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveFloat()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectFloatMaps.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatMapsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> mapWith_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> emptyMap_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> emptyMap_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> newMapOfAll_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> newMapOfAll_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> newMapFrom_immutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> newMapFrom_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ObjectFloatMapsTest::immutables;
            this.payloads.mutables = ObjectFloatMapsTest::mutables;
            this.payloads.mapWith_immutable = ObjectFloatMapsTest::mapWith_immutable;
            this.payloads.mapWith_mutable = ObjectFloatMapsTest::mapWith_mutable;
            this.payloads.emptyMap_immutable = ObjectFloatMapsTest::emptyMap_immutable;
            this.payloads.emptyMap_mutable = ObjectFloatMapsTest::emptyMap_mutable;
            this.payloads.newMapOfAll_immutable = ObjectFloatMapsTest::newMapOfAll_immutable;
            this.payloads.newMapOfAll_mutable = ObjectFloatMapsTest::newMapOfAll_mutable;
            this.payloads.newMapFrom_immutable = ObjectFloatMapsTest::newMapFrom_immutable;
            this.payloads.newMapFrom_mutable = ObjectFloatMapsTest::newMapFrom_mutable;
            this.payloads.classIsNonInstantiable = ObjectFloatMapsTest::classIsNonInstantiable;
        }
    }
*/
}
