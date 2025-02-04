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

import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ByteFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteFloatMaps.immutable.of());
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f).toImmutable(), ByteFloatMaps.immutable.of((byte) 1, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableByteFloatMap map = ByteFloatMaps.immutable.of();
        Assert.assertEquals(ByteFloatMaps.mutable.empty().toImmutable(), ByteFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f), ByteFloatMaps.mutable.from(iterable, Byte::valueOf, Float::valueOf));
        Assert.assertTrue(ByteFloatMaps.mutable.from(iterable, Byte::valueOf, Float::valueOf) instanceof MutableByteFloatMap);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f), ByteFloatMaps.immutable.from(iterable, Byte::valueOf, Float::valueOf));
        Assert.assertTrue(ByteFloatMaps.immutable.from(iterable, Byte::valueOf, Float::valueOf) instanceof ImmutableByteFloatMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteFloatMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ByteFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ByteFloatMapFactoryTest::of;
            this.payloads.withAll = ByteFloatMapFactoryTest::withAll;
            this.payloads.from = ByteFloatMapFactoryTest::from;
        }
    }
}
