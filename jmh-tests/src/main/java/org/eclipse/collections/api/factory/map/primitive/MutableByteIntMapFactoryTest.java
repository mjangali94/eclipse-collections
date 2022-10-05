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

import org.eclipse.collections.api.factory.primitive.ByteIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteIntHashMap(), ByteIntMaps.mutable.with());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2), ByteIntMaps.mutable.with((byte) 1, 2));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4), ByteIntMaps.mutable.with((byte) 1, 2, (byte) 3, 4));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6), ByteIntMaps.mutable.with((byte) 1, 2, (byte) 3, 4, (byte) 5, 6));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8), ByteIntMaps.mutable.with((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteIntHashMap(), ByteIntMaps.mutable.of());
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2), ByteIntMaps.mutable.of((byte) 1, 2));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4), ByteIntMaps.mutable.of((byte) 1, 2, (byte) 3, 4));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6), ByteIntMaps.mutable.of((byte) 1, 2, (byte) 3, 4, (byte) 5, 6));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8), ByteIntMaps.mutable.of((byte) 1, 2, (byte) 3, 4, (byte) 5, 6, (byte) 7, 8));
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

        private MutableByteIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableByteIntMapFactoryTest();
        }

        @java.lang.Override
        public MutableByteIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
