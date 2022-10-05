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

import org.eclipse.collections.api.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongShortHashMap(), LongShortMaps.mutable.with());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2), LongShortMaps.mutable.with(1L, (short) 2));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4), LongShortMaps.mutable.with(1L, (short) 2, 3L, (short) 4));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6), LongShortMaps.mutable.with(1L, (short) 2, 3L, (short) 4, 5L, (short) 6));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8), LongShortMaps.mutable.with(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongShortHashMap(), LongShortMaps.mutable.of());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2), LongShortMaps.mutable.of(1L, (short) 2));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4), LongShortMaps.mutable.of(1L, (short) 2, 3L, (short) 4));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6), LongShortMaps.mutable.of(1L, (short) 2, 3L, (short) 4, 5L, (short) 6));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8), LongShortMaps.mutable.of(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8));
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

        private MutableLongShortMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableLongShortMapFactoryTest();
        }

        @java.lang.Override
        public MutableLongShortMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
