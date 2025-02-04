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

import org.eclipse.collections.api.factory.primitive.CharFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableCharFloatMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableCharFloatMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new CharFloatHashMap(), CharFloatMaps.mutable.with());
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f), CharFloatMaps.mutable.with((char) 1, 2.0f));
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f), CharFloatMaps.mutable.with((char) 1, 2.0f, (char) 3, 4.0f));
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f), CharFloatMaps.mutable.with((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f));
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f, (char) 7, 8.0f), CharFloatMaps.mutable.with((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f, (char) 7, 8.0f));
    }

    @Test
    public void of() {
        Assert.assertEquals(new CharFloatHashMap(), CharFloatMaps.mutable.of());
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f), CharFloatMaps.mutable.of((char) 1, 2.0f));
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f), CharFloatMaps.mutable.of((char) 1, 2.0f, (char) 3, 4.0f));
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f), CharFloatMaps.mutable.of((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f));
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f, (char) 7, 8.0f), CharFloatMaps.mutable.of((char) 1, 2.0f, (char) 3, 4.0f, (char) 5, 6.0f, (char) 7, 8.0f));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableCharFloatMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableCharFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharFloatMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableCharFloatMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableCharFloatMapFactoryTest::with;
            this.payloads.of = MutableCharFloatMapFactoryTest::of;
        }
    }
}
