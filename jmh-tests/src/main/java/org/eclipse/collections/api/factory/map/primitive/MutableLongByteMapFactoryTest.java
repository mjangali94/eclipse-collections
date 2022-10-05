/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.api.factory.map.primitive;

import org.eclipse.collections.api.factory.primitive.LongByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongByteMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongByteMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongByteHashMap(), LongByteMaps.mutable.with());
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2), LongByteMaps.mutable.with(1L, (byte) 2));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2, 3L, (byte) 4), LongByteMaps.mutable.with(1L, (byte) 2, 3L, (byte) 4));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6), LongByteMaps.mutable.with(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6, 7L, (byte) 8), LongByteMaps.mutable.with(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6, 7L, (byte) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongByteHashMap(), LongByteMaps.mutable.of());
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2), LongByteMaps.mutable.of(1L, (byte) 2));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2, 3L, (byte) 4), LongByteMaps.mutable.of(1L, (byte) 2, 3L, (byte) 4));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6), LongByteMaps.mutable.of(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6, 7L, (byte) 8), LongByteMaps.mutable.of(1L, (byte) 2, 3L, (byte) 4, 5L, (byte) 6, 7L, (byte) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        private MutableLongByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableLongByteMapFactoryTest();
        }

        @java.lang.Override
        public MutableLongByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
