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

import org.eclipse.collections.api.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteDoubleMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteDoubleMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteDoubleHashMap(), ByteDoubleMaps.mutable.with());
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0, (byte) 3, 4.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0), ByteDoubleMaps.mutable.with((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteDoubleHashMap(), ByteDoubleMaps.mutable.of());
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0, (byte) 3, 4.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0));
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0), ByteDoubleMaps.mutable.of((byte) 1, 2.0, (byte) 3, 4.0, (byte) 5, 6.0, (byte) 7, 8.0));
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

        private MutableByteDoubleMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableByteDoubleMapFactoryTest();
        }

        @java.lang.Override
        public MutableByteDoubleMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
