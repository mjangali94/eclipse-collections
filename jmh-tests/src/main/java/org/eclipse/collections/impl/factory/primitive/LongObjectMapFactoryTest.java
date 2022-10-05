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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableLongObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class LongObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableLongObjectMapFactory(LongObjectMaps.immutable);
        this.assertImmutableLongObjectMapFactory(org.eclipse.collections.api.factory.primitive.LongObjectMaps.immutable);
    }

    private void assertImmutableLongObjectMapFactory(ImmutableLongObjectMapFactory mapFactory) {
        Assert.assertSame(LongObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(LongObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(LongObjectMaps.immutable.of(1L, 1L), LongObjectHashMap.newWithKeysValues(1L, 1L).toImmutable());
        LongObjectHashMap sourceMap = LongObjectHashMap.newWithKeysValues(1L, 1L, 2L, 2L);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableLongObjectMapFactory(LongObjectMaps.mutable);
        this.assertMutableLongObjectMapFactory(org.eclipse.collections.api.factory.primitive.LongObjectMaps.mutable);
    }

    private void assertMutableLongObjectMapFactory(MutableLongObjectMapFactory mapFactory) {
        Assert.assertEquals(LongObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(LongObjectHashMap.newMap(), mapFactory.of());
        LongObjectHashMap sourceMap = LongObjectHashMap.newWithKeysValues(1L, 1L, 2L, 2L);
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

        private LongObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongObjectMapFactoryTest();
        }

        @java.lang.Override
        public LongObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
