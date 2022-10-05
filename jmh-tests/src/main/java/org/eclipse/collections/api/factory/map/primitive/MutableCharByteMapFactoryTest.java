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

import org.eclipse.collections.api.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableCharByteMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableCharByteMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new CharByteHashMap(), CharByteMaps.mutable.with());
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2), CharByteMaps.mutable.with((char) 1, (byte) 2));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2, (char) 3, (byte) 4), CharByteMaps.mutable.with((char) 1, (byte) 2, (char) 3, (byte) 4));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6), CharByteMaps.mutable.with((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6, (char) 7, (byte) 8), CharByteMaps.mutable.with((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6, (char) 7, (byte) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new CharByteHashMap(), CharByteMaps.mutable.of());
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2), CharByteMaps.mutable.of((char) 1, (byte) 2));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2, (char) 3, (byte) 4), CharByteMaps.mutable.of((char) 1, (byte) 2, (char) 3, (byte) 4));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6), CharByteMaps.mutable.of((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6, (char) 7, (byte) 8), CharByteMaps.mutable.of((char) 1, (byte) 2, (char) 3, (byte) 4, (char) 5, (byte) 6, (char) 7, (byte) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableCharByteMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableCharByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharByteMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharByteMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableCharByteMapFactoryTest::with;
            this.payloads.of = MutableCharByteMapFactoryTest::of;
        }
    }
}
