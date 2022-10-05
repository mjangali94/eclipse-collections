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

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectDoubleMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectDoubleMaps}
 * This file was automatically generated from template file objectPrimitiveMapsTest.stg
 */
public class ObjectDoubleMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ObjectDoubleMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectDoubleMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableObjectDoubleMapFactory mapFactory) {
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(ImmutableObjectDoubleMap.class, mapFactory.of());
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0), mapFactory.of("1", 1.0));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ObjectDoubleMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ObjectDoubleMaps.mutable);
    }

    private void assertMutableMapFactory(MutableObjectDoubleMapFactory mapFactory) {
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), mapFactory.of());
        Verify.assertInstanceOf(MutableObjectDoubleMap.class, mapFactory.of());
    }

    @Test
    public void mapWith_immutable() {
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), ObjectDoubleMaps.immutable.with());
        Verify.assertInstanceOf(ImmutableObjectDoubleMap.class, ObjectDoubleMaps.immutable.with());
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0), ObjectDoubleMaps.immutable.with("1", 1.0));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), ObjectDoubleMaps.mutable.with());
        Verify.assertInstanceOf(MutableObjectDoubleMap.class, ObjectDoubleMaps.mutable.with());
    }

    @Test
    public void emptyMap_immutable() {
        Verify.assertEmpty(ObjectDoubleMaps.immutable.of());
        Verify.assertEmpty(ObjectDoubleMaps.immutable.empty());
        Assert.assertSame(ObjectDoubleMaps.immutable.of(), ObjectDoubleMaps.immutable.of());
        Assert.assertSame(ObjectDoubleMaps.immutable.empty(), ObjectDoubleMaps.immutable.empty());
        Verify.assertPostSerializedIdentity(ObjectDoubleMaps.immutable.of());
        Verify.assertPostSerializedIdentity(ObjectDoubleMaps.immutable.empty());
    }

    @Test
    public void emptyMap_mutable() {
        Verify.assertEmpty(ObjectDoubleMaps.mutable.of());
        Verify.assertEmpty(ObjectDoubleMaps.mutable.empty());
    }

    @Test
    public void newMapOfAll_immutable() {
        ImmutableObjectDoubleMap<String> map = ObjectDoubleMaps.immutable.of();
        Assert.assertEquals(map, ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newMap()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1.0), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0)));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2.0), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0)));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3.0), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0, "3", 3.0)));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4.0), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0, "3", 3.0, "4", 4.0)));
    }

    @Test
    public void newMapOfAll_mutable() {
        MutableObjectDoubleMap<String> map = ObjectDoubleMaps.mutable.of();
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.ofAll(ObjectDoubleHashMap.newMap()));
        map.put("1", 1.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0)));
        map.put("2", 2.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0)));
        map.put("3", 3.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0, "3", 3.0)));
        map.put("4", 4.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.ofAll(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0, "3", 3.0, "4", 4.0)));
    }

    @Test
    public void newMapFrom_immutable() {
        ImmutableObjectDoubleMap<String> map = ObjectDoubleMaps.immutable.of();
        Assert.assertEquals(map, ObjectDoubleMaps.immutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveDouble()));
        Assert.assertEquals(map = map.newWithKeyValue("1", 1.0), ObjectDoubleMaps.immutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveDouble()));
        Assert.assertEquals(map = map.newWithKeyValue("2", 2.0), ObjectDoubleMaps.immutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveDouble()));
        Assert.assertEquals(map = map.newWithKeyValue("3", 3.0), ObjectDoubleMaps.immutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveDouble()));
        Assert.assertEquals(map = map.newWithKeyValue("4", 4.0), ObjectDoubleMaps.immutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveDouble()));
    }

    @Test
    public void newMapFrom_mutable() {
        MutableObjectDoubleMap<String> map = ObjectDoubleMaps.mutable.of();
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.from(Lists.mutable.<String>empty(), String::valueOf, StringFunctions.toPrimitiveDouble()));
        map.put("1", 1.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.from(Lists.mutable.of("1"), String::valueOf, StringFunctions.toPrimitiveDouble()));
        map.put("2", 2.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.from(Lists.mutable.of("1", "2"), String::valueOf, StringFunctions.toPrimitiveDouble()));
        map.put("3", 3.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.from(Lists.mutable.of("1", "2", "3"), String::valueOf, StringFunctions.toPrimitiveDouble()));
        map.put("4", 4.0);
        Assert.assertEquals(map, ObjectDoubleMaps.mutable.from(Lists.mutable.of("1", "2", "3", "4"), String::valueOf, StringFunctions.toPrimitiveDouble()));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectDoubleMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mapWith_immutable, this.description("mapWith_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mapWith_mutable, this.description("mapWith_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyMap_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyMap_immutable, this.description("emptyMap_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_emptyMap_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::emptyMap_mutable, this.description("emptyMap_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapOfAll_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMapOfAll_immutable, this.description("newMapOfAll_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapOfAll_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMapOfAll_mutable, this.description("newMapOfAll_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapFrom_immutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMapFrom_immutable, this.description("newMapFrom_immutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapFrom_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMapFrom_mutable, this.description("newMapFrom_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private ObjectDoubleMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectDoubleMapsTest();
        }

        @java.lang.Override
        public ObjectDoubleMapsTest implementation() {
            return this.implementation;
        }
    }
}
