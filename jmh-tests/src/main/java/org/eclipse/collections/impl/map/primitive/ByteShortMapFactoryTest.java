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

import org.eclipse.collections.api.map.primitive.ImmutableByteShortMap;
import org.eclipse.collections.api.map.primitive.MutableByteShortMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ByteShortMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteShortMaps.immutable.of());
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1).toImmutable(), ByteShortMaps.immutable.of((byte) 1, (short) 1));
    }

    @Test
    public void withAll() {
        ImmutableByteShortMap map = ByteShortMaps.immutable.of();
        Assert.assertEquals(ByteShortMaps.mutable.empty().toImmutable(), ByteShortMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3), ByteShortMaps.mutable.from(iterable, Byte::valueOf, Short::valueOf));
        Assert.assertTrue(ByteShortMaps.mutable.from(iterable, Byte::valueOf, Short::valueOf) instanceof MutableByteShortMap);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3), ByteShortMaps.immutable.from(iterable, Byte::valueOf, Short::valueOf));
        Assert.assertTrue(ByteShortMaps.immutable.from(iterable, Byte::valueOf, Short::valueOf) instanceof ImmutableByteShortMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteShortMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ByteShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ByteShortMapFactoryTest::of;
            this.payloads.withAll = ByteShortMapFactoryTest::withAll;
            this.payloads.from = ByteShortMapFactoryTest::from;
        }
    }
}
