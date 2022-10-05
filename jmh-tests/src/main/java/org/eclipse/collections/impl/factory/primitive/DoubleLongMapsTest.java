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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleLongMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableDoubleLongMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleLongMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class DoubleLongMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(DoubleLongMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.DoubleLongMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableDoubleLongMapFactory mapFactory) {
        Assert.assertSame(new DoubleLongHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new DoubleLongHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L).toImmutable(), mapFactory.of(1.0, 1L));
        DoubleLongHashMap sourceMap = DoubleLongHashMap.newWithKeysValues(1.0, 1L);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(DoubleLongMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.DoubleLongMaps.mutable);
    }

    private void assertMutableMapFactory(MutableDoubleLongMapFactory mapFactory) {
        Assert.assertEquals(new DoubleLongHashMap(), mapFactory.with());
        Assert.assertEquals(new DoubleLongHashMap(), mapFactory.of());
        DoubleLongHashMap sourceMap = DoubleLongHashMap.newWithKeysValues(1.0, 1L);
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

        private DoubleLongMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleLongMapsTest();
        }

        @java.lang.Override
        public DoubleLongMapsTest implementation() {
            return this.implementation;
        }
    }
}
