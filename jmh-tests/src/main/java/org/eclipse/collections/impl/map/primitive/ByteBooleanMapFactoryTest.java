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

import org.eclipse.collections.api.map.primitive.ImmutableByteBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableByteBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class ByteBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ByteBooleanHashMap().toImmutable(), ByteBooleanMaps.immutable.of());
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, true).toImmutable(), ByteBooleanMaps.immutable.of((byte) 1, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new ByteBooleanHashMap().toImmutable(), ByteBooleanMaps.immutable.ofAll(ByteBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new ByteBooleanHashMap().toImmutable(), ByteBooleanMaps.immutable.withAll(ByteBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false), ByteBooleanMaps.mutable.from(iterable, Byte::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(ByteBooleanMaps.mutable.from(iterable, Byte::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof MutableByteBooleanMap);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false), ByteBooleanMaps.immutable.from(iterable, Byte::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(ByteBooleanMaps.immutable.from(iterable, Byte::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableByteBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteBooleanMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ByteBooleanMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ByteBooleanMapFactoryTest::of;
            this.payloads.ofAll = ByteBooleanMapFactoryTest::ofAll;
            this.payloads.withAll = ByteBooleanMapFactoryTest::withAll;
            this.payloads.from = ByteBooleanMapFactoryTest::from;
        }
    }
}
