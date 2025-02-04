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

import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.api.map.primitive.MutableLongShortMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongShortMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongShortMaps.immutable.of());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1).toImmutable(), LongShortMaps.immutable.of(1L, (short) 1));
    }

    @Test
    public void withAll() {
        ImmutableLongShortMap map = LongShortMaps.immutable.of();
        Assert.assertEquals(LongShortMaps.mutable.empty().toImmutable(), LongShortMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3), LongShortMaps.mutable.from(iterable, Long::valueOf, Short::valueOf));
        Assert.assertTrue(LongShortMaps.mutable.from(iterable, Long::valueOf, Short::valueOf) instanceof MutableLongShortMap);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3), LongShortMaps.immutable.from(iterable, Long::valueOf, Short::valueOf));
        Assert.assertTrue(LongShortMaps.immutable.from(iterable, Long::valueOf, Short::valueOf) instanceof ImmutableLongShortMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongShortMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new LongShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = LongShortMapFactoryTest::of;
            this.payloads.withAll = LongShortMapFactoryTest::withAll;
            this.payloads.from = LongShortMapFactoryTest::from;
        }
    }
}
