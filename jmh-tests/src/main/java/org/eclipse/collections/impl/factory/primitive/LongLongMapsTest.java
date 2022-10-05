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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongLongMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableLongLongMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.LongLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongLongMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class LongLongMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(LongLongMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.LongLongMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableLongLongMapFactory mapFactory) {
        Assert.assertSame(new LongLongHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new LongLongHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L).toImmutable(), mapFactory.of(1L, 1L));
        LongLongHashMap sourceMap = LongLongHashMap.newWithKeysValues(1L, 1L);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(LongLongMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.LongLongMaps.mutable);
    }

    private void assertMutableMapFactory(MutableLongLongMapFactory mapFactory) {
        Assert.assertEquals(new LongLongHashMap(), mapFactory.with());
        Assert.assertEquals(new LongLongHashMap(), mapFactory.of());
        LongLongHashMap sourceMap = LongLongHashMap.newWithKeysValues(1L, 1L);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::mutables, this.description("mutables"));
        }

        private LongLongMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongLongMapsTest();
        }

        @java.lang.Override
        public LongLongMapsTest implementation() {
            return this.implementation;
        }
    }
}
