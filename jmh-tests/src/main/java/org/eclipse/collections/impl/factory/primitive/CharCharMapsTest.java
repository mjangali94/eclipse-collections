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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharCharMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableCharCharMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.CharCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharCharMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class CharCharMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(CharCharMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.CharCharMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableCharCharMapFactory mapFactory) {
        Assert.assertSame(new CharCharHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new CharCharHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(CharCharHashMap.newWithKeysValues((char) 1, (char) 1).toImmutable(), mapFactory.of((char) 1, (char) 1));
        CharCharHashMap sourceMap = CharCharHashMap.newWithKeysValues((char) 1, (char) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(CharCharMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.CharCharMaps.mutable);
    }

    private void assertMutableMapFactory(MutableCharCharMapFactory mapFactory) {
        Assert.assertEquals(new CharCharHashMap(), mapFactory.with());
        Assert.assertEquals(new CharCharHashMap(), mapFactory.of());
        CharCharHashMap sourceMap = CharCharHashMap.newWithKeysValues((char) 1, (char) 1);
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

        private CharCharMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharCharMapsTest();
        }

        @java.lang.Override
        public CharCharMapsTest implementation() {
            return this.implementation;
        }
    }
}
