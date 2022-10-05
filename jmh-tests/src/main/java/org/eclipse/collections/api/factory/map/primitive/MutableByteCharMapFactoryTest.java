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

import org.eclipse.collections.api.factory.primitive.ByteCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableByteCharMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableByteCharMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ByteCharHashMap(), ByteCharMaps.mutable.with());
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2), ByteCharMaps.mutable.with((byte) 1, (char) 2));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2, (byte) 3, (char) 4), ByteCharMaps.mutable.with((byte) 1, (char) 2, (byte) 3, (char) 4));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6), ByteCharMaps.mutable.with((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6, (byte) 7, (char) 8), ByteCharMaps.mutable.with((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6, (byte) 7, (char) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ByteCharHashMap(), ByteCharMaps.mutable.of());
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2), ByteCharMaps.mutable.of((byte) 1, (char) 2));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2, (byte) 3, (char) 4), ByteCharMaps.mutable.of((byte) 1, (char) 2, (byte) 3, (char) 4));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6), ByteCharMaps.mutable.of((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6, (byte) 7, (char) 8), ByteCharMaps.mutable.of((byte) 1, (char) 2, (byte) 3, (char) 4, (byte) 5, (char) 6, (byte) 7, (char) 8));
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

        private MutableByteCharMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MutableByteCharMapFactoryTest();
        }

        @java.lang.Override
        public MutableByteCharMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
