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

import java.lang.reflect.Field;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectLongHashingStrategyMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectLongHashingStrategyMaps}
 * This file was automatically generated from template file objectPrimitiveHashingStrategyMapsTest.stg
 */
public class ObjectLongHashingStrategyMapsTest {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Test
    public void mutables() {
        this.assertMutableHashingStrategyMapFactory(ObjectLongHashingStrategyMaps.mutable);
        this.assertMutableHashingStrategyMapFactory(org.eclipse.collections.api.factory.primitive.ObjectLongHashingStrategyMaps.mutable);
    }

    private void assertMutableHashingStrategyMapFactory(MutableObjectLongHashingStrategyMapFactory mapFactory) {
        Assert.assertEquals(ObjectLongHashMap.newMap(), mapFactory.of(STRING_HASHING_STRATEGY));
        Verify.assertInstanceOf(MutableObjectLongMap.class, mapFactory.of(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectLongHashMap.newMap(), ObjectLongHashingStrategyMaps.mutable.with(STRING_HASHING_STRATEGY));
        Verify.assertInstanceOf(MutableObjectLongMap.class, ObjectLongHashingStrategyMaps.mutable.with(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapOf_mutable() {
        Verify.assertEmpty(ObjectLongHashingStrategyMaps.mutable.of(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapWithInitialCapacity_mutable() throws Exception {
        MutableObjectLongMap<String> map = ObjectLongHashingStrategyMaps.mutable.withInitialCapacity(STRING_HASHING_STRATEGY, 15);
        Assert.assertEquals(ObjectLongHashMap.newMap(), map);
        Verify.assertInstanceOf(MutableObjectLongMap.class, map);
        Field keys = map.getClass().getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = map.getClass().getDeclaredField("values");
        values.setAccessible(true);
        Assert.assertEquals(32L, ((Object[]) keys.get(map)).length);
        Assert.assertEquals(32L, ((long[]) values.get(map)).length);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectLongMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectLongHashingStrategyMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapWith_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapOf_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapOf_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWithInitialCapacity_mutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mapWithInitialCapacity_mutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashingStrategyMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectLongHashingStrategyMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashingStrategyMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashingStrategyMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashingStrategyMapsTest> mapOf_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashingStrategyMapsTest> mapWithInitialCapacity_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashingStrategyMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.mutables = ObjectLongHashingStrategyMapsTest::mutables;
            this.payloads.mapWith_mutable = ObjectLongHashingStrategyMapsTest::mapWith_mutable;
            this.payloads.mapOf_mutable = ObjectLongHashingStrategyMapsTest::mapOf_mutable;
            this.payloads.mapWithInitialCapacity_mutable = ObjectLongHashingStrategyMapsTest::mapWithInitialCapacity_mutable;
            this.payloads.classIsNonInstantiable = ObjectLongHashingStrategyMapsTest::classIsNonInstantiable;
        }
    }
}
