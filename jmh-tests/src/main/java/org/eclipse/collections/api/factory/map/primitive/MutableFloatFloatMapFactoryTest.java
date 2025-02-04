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

import org.eclipse.collections.api.factory.primitive.FloatFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableFloatFloatMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableFloatFloatMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new FloatFloatHashMap(), FloatFloatMaps.mutable.with());
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f), FloatFloatMaps.mutable.with(1.0f, 2.0f));
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f, 3.0f, 4.0f), FloatFloatMaps.mutable.with(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), FloatFloatMaps.mutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), FloatFloatMaps.mutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
    }

    @Test
    public void of() {
        Assert.assertEquals(new FloatFloatHashMap(), FloatFloatMaps.mutable.of());
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f), FloatFloatMaps.mutable.of(1.0f, 2.0f));
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f, 3.0f, 4.0f), FloatFloatMaps.mutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), FloatFloatMaps.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), FloatFloatMaps.mutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableFloatFloatMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableFloatFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatFloatMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatFloatMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableFloatFloatMapFactoryTest::with;
            this.payloads.of = MutableFloatFloatMapFactoryTest::of;
        }
    }
}
