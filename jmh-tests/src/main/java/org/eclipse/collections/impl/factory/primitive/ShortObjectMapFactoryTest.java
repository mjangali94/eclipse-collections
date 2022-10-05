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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableShortObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ShortObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class ShortObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableShortObjectMapFactory(ShortObjectMaps.immutable);
        this.assertImmutableShortObjectMapFactory(org.eclipse.collections.api.factory.primitive.ShortObjectMaps.immutable);
    }

    private void assertImmutableShortObjectMapFactory(ImmutableShortObjectMapFactory mapFactory) {
        Assert.assertSame(ShortObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(ShortObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ShortObjectMaps.immutable.of((short) 1, (short) 1), ShortObjectHashMap.newWithKeysValues((short) 1, (short) 1).toImmutable());
        ShortObjectHashMap sourceMap = ShortObjectHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableShortObjectMapFactory(ShortObjectMaps.mutable);
        this.assertMutableShortObjectMapFactory(org.eclipse.collections.api.factory.primitive.ShortObjectMaps.mutable);
    }

    private void assertMutableShortObjectMapFactory(MutableShortObjectMapFactory mapFactory) {
        Assert.assertEquals(ShortObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(ShortObjectHashMap.newMap(), mapFactory.of());
        ShortObjectHashMap sourceMap = ShortObjectHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2);
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

        private ShortObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortObjectMapFactoryTest();
        }

        @java.lang.Override
        public ShortObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
