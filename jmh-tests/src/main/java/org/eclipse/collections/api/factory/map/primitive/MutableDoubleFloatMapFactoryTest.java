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

import org.eclipse.collections.api.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableDoubleFloatMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableDoubleFloatMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new DoubleFloatHashMap(), DoubleFloatMaps.mutable.with());
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f), DoubleFloatMaps.mutable.with(1.0, 2.0f));
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f, 3.0, 4.0f), DoubleFloatMaps.mutable.with(1.0, 2.0f, 3.0, 4.0f));
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f), DoubleFloatMaps.mutable.with(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f));
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f, 7.0, 8.0f), DoubleFloatMaps.mutable.with(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f, 7.0, 8.0f));
    }

    @Test
    public void of() {
        Assert.assertEquals(new DoubleFloatHashMap(), DoubleFloatMaps.mutable.of());
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f), DoubleFloatMaps.mutable.of(1.0, 2.0f));
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f, 3.0, 4.0f), DoubleFloatMaps.mutable.of(1.0, 2.0f, 3.0, 4.0f));
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f), DoubleFloatMaps.mutable.of(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f));
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f, 7.0, 8.0f), DoubleFloatMaps.mutable.of(1.0, 2.0f, 3.0, 4.0f, 5.0, 6.0f, 7.0, 8.0f));
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

        private MutableDoubleFloatMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableDoubleFloatMapFactoryTest();
        }

        @java.lang.Override
        public MutableDoubleFloatMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
