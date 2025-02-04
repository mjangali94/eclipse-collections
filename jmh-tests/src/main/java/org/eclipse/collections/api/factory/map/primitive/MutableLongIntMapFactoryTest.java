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

import org.eclipse.collections.api.factory.primitive.LongIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableLongIntMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableLongIntMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new LongIntHashMap(), LongIntMaps.mutable.with());
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2), LongIntMaps.mutable.with(1L, 2));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2, 3L, 4), LongIntMaps.mutable.with(1L, 2, 3L, 4));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2, 3L, 4, 5L, 6), LongIntMaps.mutable.with(1L, 2, 3L, 4, 5L, 6));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2, 3L, 4, 5L, 6, 7L, 8), LongIntMaps.mutable.with(1L, 2, 3L, 4, 5L, 6, 7L, 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new LongIntHashMap(), LongIntMaps.mutable.of());
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2), LongIntMaps.mutable.of(1L, 2));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2, 3L, 4), LongIntMaps.mutable.of(1L, 2, 3L, 4));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2, 3L, 4, 5L, 6), LongIntMaps.mutable.of(1L, 2, 3L, 4, 5L, 6));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2, 3L, 4, 5L, 6, 7L, 8), LongIntMaps.mutable.of(1L, 2, 3L, 4, 5L, 6, 7L, 8));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableLongIntMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongIntMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableLongIntMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongIntMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableLongIntMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableLongIntMapFactoryTest::with;
            this.payloads.of = MutableLongIntMapFactoryTest::of;
        }
    }
*/
}
