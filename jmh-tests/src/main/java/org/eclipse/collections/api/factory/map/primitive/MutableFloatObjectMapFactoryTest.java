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
import org.eclipse.collections.api.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;

/**
 * Junit test for {@link MutableFloatObjectMapFactory}
 * This file was automatically generated from template file primitiveObjectMutableMapFactoryTest.stg
 */
public class MutableFloatObjectMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(FloatObjectHashMap.newMap(), FloatObjectMaps.mutable.with());
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), FloatObjectMaps.mutable.with(1.0f, "one"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two"), FloatObjectMaps.mutable.with(1.0f, "one", 2.0f, "two"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three"), FloatObjectMaps.mutable.with(1.0f, "one", 2.0f, "two", 3.0f, "three"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three", 4.0f, "four"), FloatObjectMaps.mutable.with(1.0f, "one", 2.0f, "two", 3.0f, "three", 4.0f, "four"));
    }

    @Test
    public void of() {
        Assert.assertEquals(FloatObjectHashMap.newMap(), FloatObjectMaps.mutable.of());
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), FloatObjectMaps.mutable.of(1.0f, "one"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two"), FloatObjectMaps.mutable.of(1.0f, "one", 2.0f, "two"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three"), FloatObjectMaps.mutable.of(1.0f, "one", 2.0f, "two", 3.0f, "three"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three", 4.0f, "four"), FloatObjectMaps.mutable.of(1.0f, "one", 2.0f, "two", 3.0f, "three", 4.0f, "four"));
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

        private MutableFloatObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableFloatObjectMapFactoryTest();
        }

        @java.lang.Override
        public MutableFloatObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
