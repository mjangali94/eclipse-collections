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

import org.eclipse.collections.api.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableCharLongMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableCharLongMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new CharLongHashMap(), CharLongMaps.mutable.with());
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L), CharLongMaps.mutable.with((char) 1, 2L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L, (char) 3, 4L), CharLongMaps.mutable.with((char) 1, 2L, (char) 3, 4L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L, (char) 3, 4L, (char) 5, 6L), CharLongMaps.mutable.with((char) 1, 2L, (char) 3, 4L, (char) 5, 6L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L, (char) 3, 4L, (char) 5, 6L, (char) 7, 8L), CharLongMaps.mutable.with((char) 1, 2L, (char) 3, 4L, (char) 5, 6L, (char) 7, 8L));
    }

    @Test
    public void of() {
        Assert.assertEquals(new CharLongHashMap(), CharLongMaps.mutable.of());
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L), CharLongMaps.mutable.of((char) 1, 2L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L, (char) 3, 4L), CharLongMaps.mutable.of((char) 1, 2L, (char) 3, 4L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L, (char) 3, 4L, (char) 5, 6L), CharLongMaps.mutable.of((char) 1, 2L, (char) 3, 4L, (char) 5, 6L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L, (char) 3, 4L, (char) 5, 6L, (char) 7, 8L), CharLongMaps.mutable.of((char) 1, 2L, (char) 3, 4L, (char) 5, 6L, (char) 7, 8L));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableCharLongMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharLongMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableCharLongMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharLongMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharLongMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableCharLongMapFactoryTest::with;
            this.payloads.of = MutableCharLongMapFactoryTest::of;
        }
    }
}
