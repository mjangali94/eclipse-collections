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

import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongDoubleMaps.immutable.of());
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0).toImmutable(), LongDoubleMaps.immutable.of(1L, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableLongDoubleMap map = LongDoubleMaps.immutable.of();
        Assert.assertEquals(LongDoubleMaps.mutable.empty().toImmutable(), LongDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0), LongDoubleMaps.mutable.from(iterable, Long::valueOf, Double::valueOf));
        Assert.assertTrue(LongDoubleMaps.mutable.from(iterable, Long::valueOf, Double::valueOf) instanceof MutableLongDoubleMap);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0), LongDoubleMaps.immutable.from(iterable, Long::valueOf, Double::valueOf));
        Assert.assertTrue(LongDoubleMaps.immutable.from(iterable, Long::valueOf, Double::valueOf) instanceof ImmutableLongDoubleMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongDoubleMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new LongDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = LongDoubleMapFactoryTest::of;
            this.payloads.withAll = LongDoubleMapFactoryTest::withAll;
            this.payloads.from = LongDoubleMapFactoryTest::from;
        }
    }
}
