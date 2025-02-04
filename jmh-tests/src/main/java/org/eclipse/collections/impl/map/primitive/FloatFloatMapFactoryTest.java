/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableFloatFloatMap;
import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class FloatFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(FloatFloatMaps.immutable.of());
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f).toImmutable(), FloatFloatMaps.immutable.of(1.0f, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableFloatFloatMap map = FloatFloatMaps.immutable.of();
        Assert.assertEquals(FloatFloatMaps.mutable.empty().toImmutable(), FloatFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f), FloatFloatMaps.mutable.from(iterable, Float::valueOf, Float::valueOf));
        Assert.assertTrue(FloatFloatMaps.mutable.from(iterable, Float::valueOf, Float::valueOf) instanceof MutableFloatFloatMap);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f), FloatFloatMaps.immutable.from(iterable, Float::valueOf, Float::valueOf));
        Assert.assertTrue(FloatFloatMaps.immutable.from(iterable, Float::valueOf, Float::valueOf) instanceof ImmutableFloatFloatMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatFloatMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new FloatFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = FloatFloatMapFactoryTest::of;
            this.payloads.withAll = FloatFloatMapFactoryTest::withAll;
            this.payloads.from = FloatFloatMapFactoryTest::from;
        }
    }
}
