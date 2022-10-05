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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteIntMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableByteIntMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteIntMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ByteIntMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ByteIntMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteIntMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableByteIntMapFactory mapFactory) {
        Assert.assertSame(new ByteIntHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ByteIntHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1).toImmutable(), mapFactory.of((byte) 1, 1));
        ByteIntHashMap sourceMap = ByteIntHashMap.newWithKeysValues((byte) 1, 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ByteIntMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteIntMaps.mutable);
    }

    private void assertMutableMapFactory(MutableByteIntMapFactory mapFactory) {
        Assert.assertEquals(new ByteIntHashMap(), mapFactory.with());
        Assert.assertEquals(new ByteIntHashMap(), mapFactory.of());
        ByteIntHashMap sourceMap = ByteIntHashMap.newWithKeysValues((byte) 1, 1);
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

        private ByteIntMapsTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteIntMapsTest();
        }

        @java.lang.Override
        public ByteIntMapsTest implementation() {
            return this.implementation;
        }
    }
}
