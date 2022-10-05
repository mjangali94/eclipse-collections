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

import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.api.factory.primitive.LongObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;

/**
 * Junit test for {@link MutableLongObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableLongObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(LongObjectHashMap.newMap(), LongObjectMaps.mutable.with());
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), LongObjectMaps.mutable.with(1L, "one"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two"), LongObjectMaps.mutable.with(1L, "one", 2L, "two"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two", 3L, "three"), LongObjectMaps.mutable.with(1L, "one", 2L, "two", 3L, "three"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two", 3L, "three", 4L, "four"), LongObjectMaps.mutable.with(1L, "one", 2L, "two", 3L, "three", 4L, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(LongObjectHashMap.newMap(), LongObjectMaps.mutable.of());
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), LongObjectMaps.mutable.of(1L, "one"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two"), LongObjectMaps.mutable.of(1L, "one", 2L, "two"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two", 3L, "three"), LongObjectMaps.mutable.of(1L, "one", 2L, "two", 3L, "three"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two", 3L, "three", 4L, "four"), LongObjectMaps.mutable.of(1L, "one", 2L, "two", 3L, "three", 4L, "four"));
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

        private MutableLongObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableLongObjectMapFactoryTest();
        }

        @java.lang.Override
        public MutableLongObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
