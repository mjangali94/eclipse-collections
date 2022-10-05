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

import org.eclipse.collections.api.map.primitive.ImmutableLongLongMap;
import org.eclipse.collections.api.map.primitive.MutableLongLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongLongMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongLongMaps.immutable.of());
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L).toImmutable(), LongLongMaps.immutable.of(1L, 1L));
    }

    @Test
    public void withAll() {
        ImmutableLongLongMap map = LongLongMaps.immutable.of();
        Assert.assertEquals(LongLongMaps.mutable.empty().toImmutable(), LongLongMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L, 2L, 2L, 3L, 3L), LongLongMaps.mutable.from(iterable, Long::valueOf, Long::valueOf));
        Assert.assertTrue(LongLongMaps.mutable.from(iterable, Long::valueOf, Long::valueOf) instanceof MutableLongLongMap);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L, 2L, 2L, 3L, 3L), LongLongMaps.immutable.from(iterable, Long::valueOf, Long::valueOf));
        Assert.assertTrue(LongLongMaps.immutable.from(iterable, Long::valueOf, Long::valueOf) instanceof ImmutableLongLongMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongLongMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongLongMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new LongLongMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongLongMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongLongMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongLongMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = LongLongMapFactoryTest::of;
            this.payloads.withAll = LongLongMapFactoryTest::withAll;
            this.payloads.from = LongLongMapFactoryTest::from;
        }
    }
}
