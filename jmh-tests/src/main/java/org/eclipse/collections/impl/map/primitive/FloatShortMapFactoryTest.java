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

import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.api.map.primitive.MutableFloatShortMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class FloatShortMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(FloatShortMaps.immutable.of());
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1).toImmutable(), FloatShortMaps.immutable.of(1.0f, (short) 1));
    }

    @Test
    public void withAll() {
        ImmutableFloatShortMap map = FloatShortMaps.immutable.of();
        Assert.assertEquals(FloatShortMaps.mutable.empty().toImmutable(), FloatShortMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3), FloatShortMaps.mutable.from(iterable, Float::valueOf, Short::valueOf));
        Assert.assertTrue(FloatShortMaps.mutable.from(iterable, Float::valueOf, Short::valueOf) instanceof MutableFloatShortMap);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3), FloatShortMaps.immutable.from(iterable, Float::valueOf, Short::valueOf));
        Assert.assertTrue(FloatShortMaps.immutable.from(iterable, Float::valueOf, Short::valueOf) instanceof ImmutableFloatShortMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatShortMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new FloatShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = FloatShortMapFactoryTest::of;
            this.payloads.withAll = FloatShortMapFactoryTest::withAll;
            this.payloads.from = FloatShortMapFactoryTest::from;
        }
    }
}
