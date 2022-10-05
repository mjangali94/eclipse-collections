/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableFloatObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class FloatObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableFloatObjectMapFactory(FloatObjectMaps.immutable);
        this.assertImmutableFloatObjectMapFactory(org.eclipse.collections.api.factory.primitive.FloatObjectMaps.immutable);
    }

    private void assertImmutableFloatObjectMapFactory(ImmutableFloatObjectMapFactory mapFactory) {
        Assert.assertSame(FloatObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(FloatObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(FloatObjectMaps.immutable.of(1.0f, 1.0f), FloatObjectHashMap.newWithKeysValues(1.0f, 1.0f).toImmutable());
        FloatObjectHashMap sourceMap = FloatObjectHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableFloatObjectMapFactory(FloatObjectMaps.mutable);
        this.assertMutableFloatObjectMapFactory(org.eclipse.collections.api.factory.primitive.FloatObjectMaps.mutable);
    }

    private void assertMutableFloatObjectMapFactory(MutableFloatObjectMapFactory mapFactory) {
        Assert.assertEquals(FloatObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(FloatObjectHashMap.newMap(), mapFactory.of());
        FloatObjectHashMap sourceMap = FloatObjectHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::immutables, this.description("immutables"));
        }

        private FloatObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatObjectMapFactoryTest();
        }

        @java.lang.Override
        public FloatObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
