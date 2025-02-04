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

import org.eclipse.collections.api.map.primitive.ImmutableFloatDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class FloatDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(FloatDoubleMaps.immutable.of());
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0).toImmutable(), FloatDoubleMaps.immutable.of(1.0f, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableFloatDoubleMap map = FloatDoubleMaps.immutable.of();
        Assert.assertEquals(FloatDoubleMaps.mutable.empty().toImmutable(), FloatDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0), FloatDoubleMaps.mutable.from(iterable, Float::valueOf, Double::valueOf));
        Assert.assertTrue(FloatDoubleMaps.mutable.from(iterable, Float::valueOf, Double::valueOf) instanceof MutableFloatDoubleMap);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0), FloatDoubleMaps.immutable.from(iterable, Float::valueOf, Double::valueOf));
        Assert.assertTrue(FloatDoubleMaps.immutable.from(iterable, Float::valueOf, Double::valueOf) instanceof ImmutableFloatDoubleMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatDoubleMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new FloatDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = FloatDoubleMapFactoryTest::of;
            this.payloads.withAll = FloatDoubleMapFactoryTest::withAll;
            this.payloads.from = FloatDoubleMapFactoryTest::from;
        }
    }
*/
}
