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

import org.eclipse.collections.api.map.primitive.ImmutableIntByteMap;
import org.eclipse.collections.api.map.primitive.MutableIntByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class IntByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntByteMaps.immutable.of());
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1).toImmutable(), IntByteMaps.immutable.of(1, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableIntByteMap map = IntByteMaps.immutable.of();
        Assert.assertEquals(IntByteMaps.mutable.empty().toImmutable(), IntByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3), IntByteMaps.mutable.from(iterable, Integer::valueOf, Byte::valueOf));
        Assert.assertTrue(IntByteMaps.mutable.from(iterable, Integer::valueOf, Byte::valueOf) instanceof MutableIntByteMap);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3), IntByteMaps.immutable.from(iterable, Integer::valueOf, Byte::valueOf));
        Assert.assertTrue(IntByteMaps.immutable.from(iterable, Integer::valueOf, Byte::valueOf) instanceof ImmutableIntByteMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntByteMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new IntByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntByteMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntByteMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntByteMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = IntByteMapFactoryTest::of;
            this.payloads.withAll = IntByteMapFactoryTest::withAll;
            this.payloads.from = IntByteMapFactoryTest::from;
        }
    }
}
