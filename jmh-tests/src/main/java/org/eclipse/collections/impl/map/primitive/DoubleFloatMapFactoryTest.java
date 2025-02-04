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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleFloatMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class DoubleFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(DoubleFloatMaps.immutable.of());
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f).toImmutable(), DoubleFloatMaps.immutable.of(1.0, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableDoubleFloatMap map = DoubleFloatMaps.immutable.of();
        Assert.assertEquals(DoubleFloatMaps.mutable.empty().toImmutable(), DoubleFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f), DoubleFloatMaps.mutable.from(iterable, Double::valueOf, Float::valueOf));
        Assert.assertTrue(DoubleFloatMaps.mutable.from(iterable, Double::valueOf, Float::valueOf) instanceof MutableDoubleFloatMap);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f), DoubleFloatMaps.immutable.from(iterable, Double::valueOf, Float::valueOf));
        Assert.assertTrue(DoubleFloatMaps.immutable.from(iterable, Double::valueOf, Float::valueOf) instanceof ImmutableDoubleFloatMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleFloatMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = DoubleFloatMapFactoryTest::of;
            this.payloads.withAll = DoubleFloatMapFactoryTest::withAll;
            this.payloads.from = DoubleFloatMapFactoryTest::from;
        }
    }
}
