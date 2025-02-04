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

import org.eclipse.collections.api.factory.primitive.FloatShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableFloatShortMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableFloatShortMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new FloatShortHashMap(), FloatShortMaps.mutable.with());
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2), FloatShortMaps.mutable.with(1.0f, (short) 2));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4), FloatShortMaps.mutable.with(1.0f, (short) 2, 3.0f, (short) 4));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6), FloatShortMaps.mutable.with(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6, 7.0f, (short) 8), FloatShortMaps.mutable.with(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6, 7.0f, (short) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new FloatShortHashMap(), FloatShortMaps.mutable.of());
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2), FloatShortMaps.mutable.of(1.0f, (short) 2));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4), FloatShortMaps.mutable.of(1.0f, (short) 2, 3.0f, (short) 4));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6), FloatShortMaps.mutable.of(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6, 7.0f, (short) 8), FloatShortMaps.mutable.of(1.0f, (short) 2, 3.0f, (short) 4, 5.0f, (short) 6, 7.0f, (short) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableFloatShortMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableFloatShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatShortMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatShortMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableFloatShortMapFactoryTest::with;
            this.payloads.of = MutableFloatShortMapFactoryTest::of;
        }
    }
}
