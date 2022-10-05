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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortShortMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableShortShortMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ShortShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortShortMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ShortShortMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ShortShortMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortShortMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableShortShortMapFactory mapFactory) {
        Assert.assertSame(new ShortShortHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ShortShortHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1).toImmutable(), mapFactory.of((short) 1, (short) 1));
        ShortShortHashMap sourceMap = ShortShortHashMap.newWithKeysValues((short) 1, (short) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ShortShortMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortShortMaps.mutable);
    }

    private void assertMutableMapFactory(MutableShortShortMapFactory mapFactory) {
        Assert.assertEquals(new ShortShortHashMap(), mapFactory.with());
        Assert.assertEquals(new ShortShortHashMap(), mapFactory.of());
        ShortShortHashMap sourceMap = ShortShortHashMap.newWithKeysValues((short) 1, (short) 1);
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

        private ShortShortMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortShortMapsTest();
        }

        @java.lang.Override
        public ShortShortMapsTest implementation() {
            return this.implementation;
        }
    }
}
