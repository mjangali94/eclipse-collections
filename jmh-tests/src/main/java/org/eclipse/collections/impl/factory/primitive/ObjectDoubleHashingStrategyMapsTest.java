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
import org.eclipse.collections.api.factory.map.primitive.MutableObjectDoubleHashingStrategyMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectDoubleHashingStrategyMaps}
 * This file was automatically generated from template file objectPrimitiveHashingStrategyMapsTest.stg
 */
public class ObjectDoubleHashingStrategyMapsTest {

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
        this.assertMutableHashingStrategyMapFactory(ObjectDoubleHashingStrategyMaps.mutable);
        this.assertMutableHashingStrategyMapFactory(org.eclipse.collections.api.factory.primitive.ObjectDoubleHashingStrategyMaps.mutable);
    }

    private void assertMutableHashingStrategyMapFactory(MutableObjectDoubleHashingStrategyMapFactory mapFactory) {
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), mapFactory.of(STRING_HASHING_STRATEGY));
        Verify.assertInstanceOf(MutableObjectDoubleMap.class, mapFactory.of(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), ObjectDoubleHashingStrategyMaps.mutable.with(STRING_HASHING_STRATEGY));
        Verify.assertInstanceOf(MutableObjectDoubleMap.class, ObjectDoubleHashingStrategyMaps.mutable.with(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapOf_mutable() {
        Verify.assertEmpty(ObjectDoubleHashingStrategyMaps.mutable.of(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapWithInitialCapacity_mutable() throws Exception {
        MutableObjectDoubleMap<String> map = ObjectDoubleHashingStrategyMaps.mutable.withInitialCapacity(STRING_HASHING_STRATEGY, 15);
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map);
        Verify.assertInstanceOf(MutableObjectDoubleMap.class, map);
        Field keys = map.getClass().getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = map.getClass().getDeclaredField("values");
        values.setAccessible(true);
        Assert.assertEquals(32L, ((Object[]) keys.get(map)).length);
        Assert.assertEquals(32L, ((double[]) values.get(map)).length);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectDoubleMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectDoubleHashingStrategyMapsTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashingStrategyMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectDoubleHashingStrategyMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashingStrategyMapsTest> mutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashingStrategyMapsTest> mapWith_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashingStrategyMapsTest> mapOf_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashingStrategyMapsTest> mapWithInitialCapacity_mutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashingStrategyMapsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.mutables = ObjectDoubleHashingStrategyMapsTest::mutables;
            this.payloads.mapWith_mutable = ObjectDoubleHashingStrategyMapsTest::mapWith_mutable;
            this.payloads.mapOf_mutable = ObjectDoubleHashingStrategyMapsTest::mapOf_mutable;
            this.payloads.mapWithInitialCapacity_mutable = ObjectDoubleHashingStrategyMapsTest::mapWithInitialCapacity_mutable;
            this.payloads.classIsNonInstantiable = ObjectDoubleHashingStrategyMapsTest::classIsNonInstantiable;
        }
    }
}
