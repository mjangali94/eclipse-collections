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

import org.eclipse.collections.api.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableDoubleIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableDoubleIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new DoubleIntHashMap(), DoubleIntMaps.mutable.with());
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2), DoubleIntMaps.mutable.with(1.0, 2));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2, 3.0, 4), DoubleIntMaps.mutable.with(1.0, 2, 3.0, 4));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2, 3.0, 4, 5.0, 6), DoubleIntMaps.mutable.with(1.0, 2, 3.0, 4, 5.0, 6));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2, 3.0, 4, 5.0, 6, 7.0, 8), DoubleIntMaps.mutable.with(1.0, 2, 3.0, 4, 5.0, 6, 7.0, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new DoubleIntHashMap(), DoubleIntMaps.mutable.of());
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2), DoubleIntMaps.mutable.of(1.0, 2));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2, 3.0, 4), DoubleIntMaps.mutable.of(1.0, 2, 3.0, 4));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2, 3.0, 4, 5.0, 6), DoubleIntMaps.mutable.of(1.0, 2, 3.0, 4, 5.0, 6));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2, 3.0, 4, 5.0, 6, 7.0, 8), DoubleIntMaps.mutable.of(1.0, 2, 3.0, 4, 5.0, 6, 7.0, 8));
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

        private MutableDoubleIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableDoubleIntMapFactoryTest();
        }

        @java.lang.Override
        public MutableDoubleIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
