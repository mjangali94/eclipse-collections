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

import org.eclipse.collections.api.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongShortHashMap(), LongShortMaps.mutable.with());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2), LongShortMaps.mutable.with(1L, (short) 2));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4), LongShortMaps.mutable.with(1L, (short) 2, 3L, (short) 4));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6), LongShortMaps.mutable.with(1L, (short) 2, 3L, (short) 4, 5L, (short) 6));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8), LongShortMaps.mutable.with(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongShortHashMap(), LongShortMaps.mutable.of());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2), LongShortMaps.mutable.of(1L, (short) 2));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4), LongShortMaps.mutable.of(1L, (short) 2, 3L, (short) 4));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6), LongShortMaps.mutable.of(1L, (short) 2, 3L, (short) 4, 5L, (short) 6));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8), LongShortMaps.mutable.of(1L, (short) 2, 3L, (short) 4, 5L, (short) 6, 7L, (short) 8));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableLongShortMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableLongShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongShortMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongShortMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableLongShortMapFactoryTest::with;
            this.payloads.of = MutableLongShortMapFactoryTest::of;
        }
    }
*/
}
