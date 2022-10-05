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
import org.eclipse.collections.api.factory.map.primitive.MutableObjectIntHashingStrategyMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ObjectIntHashingStrategyMaps}
 * This file was automatically generated from template file objectPrimitiveHashingStrategyMapsTest.stg
 */
public class ObjectIntHashingStrategyMapsTest {

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
        this.assertMutableHashingStrategyMapFactory(ObjectIntHashingStrategyMaps.mutable);
        this.assertMutableHashingStrategyMapFactory(org.eclipse.collections.api.factory.primitive.ObjectIntHashingStrategyMaps.mutable);
    }

    private void assertMutableHashingStrategyMapFactory(MutableObjectIntHashingStrategyMapFactory mapFactory) {
        Assert.assertEquals(ObjectIntHashMap.newMap(), mapFactory.of(STRING_HASHING_STRATEGY));
        Verify.assertInstanceOf(MutableObjectIntMap.class, mapFactory.of(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapWith_mutable() {
        Assert.assertEquals(ObjectIntHashMap.newMap(), ObjectIntHashingStrategyMaps.mutable.with(STRING_HASHING_STRATEGY));
        Verify.assertInstanceOf(MutableObjectIntMap.class, ObjectIntHashingStrategyMaps.mutable.with(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapOf_mutable() {
        Verify.assertEmpty(ObjectIntHashingStrategyMaps.mutable.of(STRING_HASHING_STRATEGY));
    }

    @Test
    public void mapWithInitialCapacity_mutable() throws Exception {
        MutableObjectIntMap<String> map = ObjectIntHashingStrategyMaps.mutable.withInitialCapacity(STRING_HASHING_STRATEGY, 15);
        Assert.assertEquals(ObjectIntHashMap.newMap(), map);
        Verify.assertInstanceOf(MutableObjectIntMap.class, map);
        Field keys = map.getClass().getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = map.getClass().getDeclaredField("values");
        values.setAccessible(true);
        Assert.assertEquals(32L, ((Object[]) keys.get(map)).length);
        Assert.assertEquals(32L, ((int[]) values.get(map)).length);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectIntMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWith_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mapWith_mutable, this.description("mapWith_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapOf_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mapOf_mutable, this.description("mapOf_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mapWithInitialCapacity_mutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mapWithInitialCapacity_mutable, this.description("mapWithInitialCapacity_mutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private ObjectIntHashingStrategyMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntHashingStrategyMapsTest();
        }

        @java.lang.Override
        public ObjectIntHashingStrategyMapsTest implementation() {
            return this.implementation;
        }
    }
}
