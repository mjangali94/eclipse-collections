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

import org.eclipse.collections.api.map.primitive.ImmutableByteObjectMap;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class ByteObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(ByteObjectMaps.immutable.with(), ByteObjectMaps.immutable.empty());
        Assert.assertSame(ByteObjectMaps.immutable.of(), ByteObjectMaps.immutable.empty());
        Assert.assertEquals(ByteObjectMaps.mutable.with(), ByteObjectMaps.mutable.empty());
        Assert.assertEquals(ByteObjectMaps.mutable.of(), ByteObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(ByteObjectMaps.mutable.with().toImmutable(), ByteObjectMaps.immutable.of());
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1").toImmutable(), ByteObjectMaps.immutable.of((byte) 1, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ByteObjectMaps.mutable.of(), ByteObjectMaps.immutable.ofAll(ByteObjectMaps.immutable.of()));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1"), ByteObjectMaps.immutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2"), ByteObjectMaps.immutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2"), ByteObjectMaps.immutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2").toImmutable()));
        Assert.assertEquals(ByteObjectMaps.mutable.empty(), ByteObjectMaps.mutable.ofAll(ByteObjectMaps.immutable.of()));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1"), ByteObjectMaps.mutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2", (byte) 3, "3"), ByteObjectMaps.mutable.from(iterable, Byte::valueOf, each -> each));
        Assert.assertTrue(ByteObjectMaps.mutable.from(iterable, Byte::valueOf, each -> each) instanceof MutableByteObjectMap);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2", (byte) 3, "3"), ByteObjectMaps.immutable.from(iterable, Byte::valueOf, each -> each));
        Assert.assertTrue(ByteObjectMaps.immutable.from(iterable, Byte::valueOf, each -> each) instanceof ImmutableByteObjectMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteObjectMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ByteObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.empty = ByteObjectMapFactoryTest::empty;
            this.payloads.of = ByteObjectMapFactoryTest::of;
            this.payloads.ofAll = ByteObjectMapFactoryTest::ofAll;
            this.payloads.from = ByteObjectMapFactoryTest::from;
        }
    }
}
