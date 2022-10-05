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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableDoubleObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class DoubleObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableDoubleObjectMapFactory(DoubleObjectMaps.immutable);
        this.assertImmutableDoubleObjectMapFactory(org.eclipse.collections.api.factory.primitive.DoubleObjectMaps.immutable);
    }

    private void assertImmutableDoubleObjectMapFactory(ImmutableDoubleObjectMapFactory mapFactory) {
        Assert.assertSame(DoubleObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(DoubleObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(DoubleObjectMaps.immutable.of(1.0, 1.0), DoubleObjectHashMap.newWithKeysValues(1.0, 1.0).toImmutable());
        DoubleObjectHashMap sourceMap = DoubleObjectHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableDoubleObjectMapFactory(DoubleObjectMaps.mutable);
        this.assertMutableDoubleObjectMapFactory(org.eclipse.collections.api.factory.primitive.DoubleObjectMaps.mutable);
    }

    private void assertMutableDoubleObjectMapFactory(MutableDoubleObjectMapFactory mapFactory) {
        Assert.assertEquals(DoubleObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(DoubleObjectHashMap.newMap(), mapFactory.of());
        DoubleObjectHashMap sourceMap = DoubleObjectHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0);
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

        private DoubleObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleObjectMapFactoryTest();
        }

        @java.lang.Override
        public DoubleObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
