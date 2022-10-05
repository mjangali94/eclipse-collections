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

import org.eclipse.collections.api.factory.primitive.DoubleByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableDoubleByteMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableDoubleByteMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new DoubleByteHashMap(), DoubleByteMaps.mutable.with());
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2), DoubleByteMaps.mutable.with(1.0, (byte) 2));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4), DoubleByteMaps.mutable.with(1.0, (byte) 2, 3.0, (byte) 4));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6), DoubleByteMaps.mutable.with(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6, 7.0, (byte) 8), DoubleByteMaps.mutable.with(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6, 7.0, (byte) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new DoubleByteHashMap(), DoubleByteMaps.mutable.of());
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2), DoubleByteMaps.mutable.of(1.0, (byte) 2));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4), DoubleByteMaps.mutable.of(1.0, (byte) 2, 3.0, (byte) 4));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6), DoubleByteMaps.mutable.of(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6, 7.0, (byte) 8), DoubleByteMaps.mutable.of(1.0, (byte) 2, 3.0, (byte) 4, 5.0, (byte) 6, 7.0, (byte) 8));
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

        private MutableDoubleByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableDoubleByteMapFactoryTest();
        }

        @java.lang.Override
        public MutableDoubleByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
