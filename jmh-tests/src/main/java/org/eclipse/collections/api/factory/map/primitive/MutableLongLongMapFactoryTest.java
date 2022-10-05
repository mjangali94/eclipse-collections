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

import org.eclipse.collections.api.factory.primitive.LongLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongLongMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongLongMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongLongHashMap(), LongLongMaps.mutable.with());
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L), LongLongMaps.mutable.with(1L, 2L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L, 3L, 4L), LongLongMaps.mutable.with(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L, 3L, 4L, 5L, 6L), LongLongMaps.mutable.with(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), LongLongMaps.mutable.with(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongLongHashMap(), LongLongMaps.mutable.of());
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L), LongLongMaps.mutable.of(1L, 2L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L, 3L, 4L), LongLongMaps.mutable.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L, 3L, 4L, 5L, 6L), LongLongMaps.mutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), LongLongMaps.mutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
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

        private MutableLongLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableLongLongMapFactoryTest();
        }

        @java.lang.Override
        public MutableLongLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
