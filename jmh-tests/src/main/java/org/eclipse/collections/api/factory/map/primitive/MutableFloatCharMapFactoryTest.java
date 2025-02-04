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

import org.eclipse.collections.api.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MutableFloatCharMapFactory}
 * This file was automatically generated from template file primitivePrimitiveMutableMapFactoryTest.stg
 */
public class MutableFloatCharMapFactoryTest {

    @Test
    public void with() {
        Assert.assertEquals(new FloatCharHashMap(), FloatCharMaps.mutable.with());
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2), FloatCharMaps.mutable.with(1.0f, (char) 2));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2, 3.0f, (char) 4), FloatCharMaps.mutable.with(1.0f, (char) 2, 3.0f, (char) 4));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6), FloatCharMaps.mutable.with(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6, 7.0f, (char) 8), FloatCharMaps.mutable.with(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6, 7.0f, (char) 8));
    }

    @Test
    public void of() {
        Assert.assertEquals(new FloatCharHashMap(), FloatCharMaps.mutable.of());
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2), FloatCharMaps.mutable.of(1.0f, (char) 2));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2, 3.0f, (char) 4), FloatCharMaps.mutable.of(1.0f, (char) 2, 3.0f, (char) 4));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6), FloatCharMaps.mutable.of(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6, 7.0f, (char) 8), FloatCharMaps.mutable.of(1.0f, (char) 2, 3.0f, (char) 4, 5.0f, (char) 6, 7.0f, (char) 8));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableFloatCharMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new MutableFloatCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatCharMapFactoryTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableFloatCharMapFactoryTest> of;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.with = MutableFloatCharMapFactoryTest::with;
            this.payloads.of = MutableFloatCharMapFactoryTest::of;
        }
    }
}
