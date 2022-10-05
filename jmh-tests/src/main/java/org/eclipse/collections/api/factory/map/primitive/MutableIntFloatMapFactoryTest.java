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

import org.eclipse.collections.api.factory.primitive.IntFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableIntFloatMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableIntFloatMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new IntFloatHashMap(), IntFloatMaps.mutable.with());
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f), IntFloatMaps.mutable.with(1, 2.0f));
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f, 3, 4.0f), IntFloatMaps.mutable.with(1, 2.0f, 3, 4.0f));
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f, 3, 4.0f, 5, 6.0f), IntFloatMaps.mutable.with(1, 2.0f, 3, 4.0f, 5, 6.0f));
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f, 3, 4.0f, 5, 6.0f, 7, 8.0f), IntFloatMaps.mutable.with(1, 2.0f, 3, 4.0f, 5, 6.0f, 7, 8.0f));
    }

    @Test
    public void of() {
        Assert.assertEquals(new IntFloatHashMap(), IntFloatMaps.mutable.of());
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f), IntFloatMaps.mutable.of(1, 2.0f));
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f, 3, 4.0f), IntFloatMaps.mutable.of(1, 2.0f, 3, 4.0f));
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f, 3, 4.0f, 5, 6.0f), IntFloatMaps.mutable.of(1, 2.0f, 3, 4.0f, 5, 6.0f));
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f, 3, 4.0f, 5, 6.0f, 7, 8.0f), IntFloatMaps.mutable.of(1, 2.0f, 3, 4.0f, 5, 6.0f, 7, 8.0f));
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

        private MutableIntFloatMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableIntFloatMapFactoryTest();
        }

        @java.lang.Override
        public MutableIntFloatMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
