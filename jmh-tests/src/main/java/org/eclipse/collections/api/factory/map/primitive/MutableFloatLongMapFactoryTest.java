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

import org.eclipse.collections.api.factory.primitive.FloatLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableFloatLongMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableFloatLongMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new FloatLongHashMap(), FloatLongMaps.mutable.with());
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L), FloatLongMaps.mutable.with(1.0f, 2L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L, 3.0f, 4L), FloatLongMaps.mutable.with(1.0f, 2L, 3.0f, 4L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L, 3.0f, 4L, 5.0f, 6L), FloatLongMaps.mutable.with(1.0f, 2L, 3.0f, 4L, 5.0f, 6L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L, 3.0f, 4L, 5.0f, 6L, 7.0f, 8L), FloatLongMaps.mutable.with(1.0f, 2L, 3.0f, 4L, 5.0f, 6L, 7.0f, 8L));
    }

    @Test
    public void of() {
        Assert.assertEquals(new FloatLongHashMap(), FloatLongMaps.mutable.of());
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L), FloatLongMaps.mutable.of(1.0f, 2L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L, 3.0f, 4L), FloatLongMaps.mutable.of(1.0f, 2L, 3.0f, 4L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L, 3.0f, 4L, 5.0f, 6L), FloatLongMaps.mutable.of(1.0f, 2L, 3.0f, 4L, 5.0f, 6L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L, 3.0f, 4L, 5.0f, 6L, 7.0f, 8L), FloatLongMaps.mutable.of(1.0f, 2L, 3.0f, 4L, 5.0f, 6L, 7.0f, 8L));
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

        private MutableFloatLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableFloatLongMapFactoryTest();
        }

        @java.lang.Override
        public MutableFloatLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
