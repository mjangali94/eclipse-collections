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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharLongMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableCharLongMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharLongMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class CharLongMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(CharLongMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.CharLongMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableCharLongMapFactory mapFactory) {
        Assert.assertSame(new CharLongHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new CharLongHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L).toImmutable(), mapFactory.of((char) 1, 1L));
        CharLongHashMap sourceMap = CharLongHashMap.newWithKeysValues((char) 1, 1L);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(CharLongMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.CharLongMaps.mutable);
    }

    private void assertMutableMapFactory(MutableCharLongMapFactory mapFactory) {
        Assert.assertEquals(new CharLongHashMap(), mapFactory.with());
        Assert.assertEquals(new CharLongHashMap(), mapFactory.of());
        CharLongHashMap sourceMap = CharLongHashMap.newWithKeysValues((char) 1, 1L);
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

        private CharLongMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharLongMapsTest();
        }

        @java.lang.Override
        public CharLongMapsTest implementation() {
            return this.implementation;
        }
    }
}
