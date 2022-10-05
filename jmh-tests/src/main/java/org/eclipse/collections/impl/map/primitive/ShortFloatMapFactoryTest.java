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

import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.api.map.primitive.MutableShortFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortFloatMaps.immutable.of());
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f).toImmutable(), ShortFloatMaps.immutable.of((short) 1, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableShortFloatMap map = ShortFloatMaps.immutable.of();
        Assert.assertEquals(ShortFloatMaps.mutable.empty().toImmutable(), ShortFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f), ShortFloatMaps.mutable.from(iterable, Short::valueOf, Float::valueOf));
        Assert.assertTrue(ShortFloatMaps.mutable.from(iterable, Short::valueOf, Float::valueOf) instanceof MutableShortFloatMap);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f), ShortFloatMaps.immutable.from(iterable, Short::valueOf, Float::valueOf));
        Assert.assertTrue(ShortFloatMaps.immutable.from(iterable, Short::valueOf, Float::valueOf) instanceof ImmutableShortFloatMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortFloatMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ShortFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortFloatMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortFloatMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortFloatMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ShortFloatMapFactoryTest::of;
            this.payloads.withAll = ShortFloatMapFactoryTest::withAll;
            this.payloads.from = ShortFloatMapFactoryTest::from;
        }
    }
}
