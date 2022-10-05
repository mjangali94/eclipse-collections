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

import org.eclipse.collections.api.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableShortCharMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableShortCharMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new ShortCharHashMap(), ShortCharMaps.mutable.with());
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2), ShortCharMaps.mutable.with((short) 1, (char) 2));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2, (short) 3, (char) 4), ShortCharMaps.mutable.with((short) 1, (char) 2, (short) 3, (char) 4));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6), ShortCharMaps.mutable.with((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6, (short) 7, (char) 8), ShortCharMaps.mutable.with((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6, (short) 7, (char) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new ShortCharHashMap(), ShortCharMaps.mutable.of());
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2), ShortCharMaps.mutable.of((short) 1, (char) 2));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2, (short) 3, (char) 4), ShortCharMaps.mutable.of((short) 1, (char) 2, (short) 3, (char) 4));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6), ShortCharMaps.mutable.of((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6, (short) 7, (char) 8), ShortCharMaps.mutable.of((short) 1, (char) 2, (short) 3, (char) 4, (short) 5, (char) 6, (short) 7, (char) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableShortCharMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableShortCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortCharMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableShortCharMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableShortCharMapFactoryTest::with;
            this.payloads.of = MutableShortCharMapFactoryTest::of;
        }
    }
}
