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

import org.eclipse.collections.api.factory.primitive.CharIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableCharIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableCharIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new CharIntHashMap(), CharIntMaps.mutable.with());
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2), CharIntMaps.mutable.with((char) 1, 2));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2, (char) 3, 4), CharIntMaps.mutable.with((char) 1, 2, (char) 3, 4));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2, (char) 3, 4, (char) 5, 6), CharIntMaps.mutable.with((char) 1, 2, (char) 3, 4, (char) 5, 6));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2, (char) 3, 4, (char) 5, 6, (char) 7, 8), CharIntMaps.mutable.with((char) 1, 2, (char) 3, 4, (char) 5, 6, (char) 7, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new CharIntHashMap(), CharIntMaps.mutable.of());
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2), CharIntMaps.mutable.of((char) 1, 2));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2, (char) 3, 4), CharIntMaps.mutable.of((char) 1, 2, (char) 3, 4));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2, (char) 3, 4, (char) 5, 6), CharIntMaps.mutable.of((char) 1, 2, (char) 3, 4, (char) 5, 6));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2, (char) 3, 4, (char) 5, 6, (char) 7, 8), CharIntMaps.mutable.of((char) 1, 2, (char) 3, 4, (char) 5, 6, (char) 7, 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableCharIntMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharIntMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableCharIntMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharIntMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharIntMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableCharIntMapFactoryTest::with;
            this.payloads.of = MutableCharIntMapFactoryTest::of;
        }
    }
}
