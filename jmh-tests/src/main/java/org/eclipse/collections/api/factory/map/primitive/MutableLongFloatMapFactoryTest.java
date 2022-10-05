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

import org.eclipse.collections.api.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongFloatMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongFloatMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongFloatHashMap(), LongFloatMaps.mutable.with());
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f), LongFloatMaps.mutable.with(1L, 2.0f));
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f, 3L, 4.0f), LongFloatMaps.mutable.with(1L, 2.0f, 3L, 4.0f));
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f, 3L, 4.0f, 5L, 6.0f), LongFloatMaps.mutable.with(1L, 2.0f, 3L, 4.0f, 5L, 6.0f));
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f, 3L, 4.0f, 5L, 6.0f, 7L, 8.0f), LongFloatMaps.mutable.with(1L, 2.0f, 3L, 4.0f, 5L, 6.0f, 7L, 8.0f));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongFloatHashMap(), LongFloatMaps.mutable.of());
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f), LongFloatMaps.mutable.of(1L, 2.0f));
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f, 3L, 4.0f), LongFloatMaps.mutable.of(1L, 2.0f, 3L, 4.0f));
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f, 3L, 4.0f, 5L, 6.0f), LongFloatMaps.mutable.of(1L, 2.0f, 3L, 4.0f, 5L, 6.0f));
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f, 3L, 4.0f, 5L, 6.0f, 7L, 8.0f), LongFloatMaps.mutable.of(1L, 2.0f, 3L, 4.0f, 5L, 6.0f, 7L, 8.0f));
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

        private MutableLongFloatMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableLongFloatMapFactoryTest();
        }

        @java.lang.Override
        public MutableLongFloatMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
