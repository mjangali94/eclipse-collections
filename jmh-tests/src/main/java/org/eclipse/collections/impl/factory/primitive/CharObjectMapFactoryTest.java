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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableCharObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class CharObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableCharObjectMapFactory(CharObjectMaps.immutable);
        this.assertImmutableCharObjectMapFactory(org.eclipse.collections.api.factory.primitive.CharObjectMaps.immutable);
    }

    private void assertImmutableCharObjectMapFactory(ImmutableCharObjectMapFactory mapFactory) {
        Assert.assertSame(CharObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(CharObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(CharObjectMaps.immutable.of((char) 1, (char) 1), CharObjectHashMap.newWithKeysValues((char) 1, (char) 1).toImmutable());
        CharObjectHashMap sourceMap = CharObjectHashMap.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableCharObjectMapFactory(CharObjectMaps.mutable);
        this.assertMutableCharObjectMapFactory(org.eclipse.collections.api.factory.primitive.CharObjectMaps.mutable);
    }

    private void assertMutableCharObjectMapFactory(MutableCharObjectMapFactory mapFactory) {
        Assert.assertEquals(CharObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(CharObjectHashMap.newMap(), mapFactory.of());
        CharObjectHashMap sourceMap = CharObjectHashMap.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2);
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

        private CharObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharObjectMapFactoryTest();
        }

        @java.lang.Override
        public CharObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
