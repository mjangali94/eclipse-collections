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

import org.eclipse.collections.api.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableFloatIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableFloatIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new FloatIntHashMap(), FloatIntMaps.mutable.with());
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2), FloatIntMaps.mutable.with(1.0f, 2));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2, 3.0f, 4), FloatIntMaps.mutable.with(1.0f, 2, 3.0f, 4));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2, 3.0f, 4, 5.0f, 6), FloatIntMaps.mutable.with(1.0f, 2, 3.0f, 4, 5.0f, 6));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2, 3.0f, 4, 5.0f, 6, 7.0f, 8), FloatIntMaps.mutable.with(1.0f, 2, 3.0f, 4, 5.0f, 6, 7.0f, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new FloatIntHashMap(), FloatIntMaps.mutable.of());
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2), FloatIntMaps.mutable.of(1.0f, 2));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2, 3.0f, 4), FloatIntMaps.mutable.of(1.0f, 2, 3.0f, 4));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2, 3.0f, 4, 5.0f, 6), FloatIntMaps.mutable.of(1.0f, 2, 3.0f, 4, 5.0f, 6));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2, 3.0f, 4, 5.0f, 6, 7.0f, 8), FloatIntMaps.mutable.of(1.0f, 2, 3.0f, 4, 5.0f, 6, 7.0f, 8));
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

        private MutableFloatIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableFloatIntMapFactoryTest();
        }

        @java.lang.Override
        public MutableFloatIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
