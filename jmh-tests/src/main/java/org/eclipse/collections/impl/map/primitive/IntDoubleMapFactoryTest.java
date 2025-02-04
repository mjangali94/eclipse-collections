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

import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class IntDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntDoubleMaps.immutable.of());
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0).toImmutable(), IntDoubleMaps.immutable.of(1, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableIntDoubleMap map = IntDoubleMaps.immutable.of();
        Assert.assertEquals(IntDoubleMaps.mutable.empty().toImmutable(), IntDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0), IntDoubleMaps.mutable.from(iterable, Integer::valueOf, Double::valueOf));
        Assert.assertTrue(IntDoubleMaps.mutable.from(iterable, Integer::valueOf, Double::valueOf) instanceof MutableIntDoubleMap);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0), IntDoubleMaps.immutable.from(iterable, Integer::valueOf, Double::valueOf));
        Assert.assertTrue(IntDoubleMaps.immutable.from(iterable, Integer::valueOf, Double::valueOf) instanceof ImmutableIntDoubleMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntDoubleMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new IntDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = IntDoubleMapFactoryTest::of;
            this.payloads.withAll = IntDoubleMapFactoryTest::withAll;
            this.payloads.from = IntDoubleMapFactoryTest::from;
        }
    }
}
