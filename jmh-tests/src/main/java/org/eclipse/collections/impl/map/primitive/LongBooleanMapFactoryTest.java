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

import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableLongBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class LongBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new LongBooleanHashMap().toImmutable(), LongBooleanMaps.immutable.of());
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, true).toImmutable(), LongBooleanMaps.immutable.of(1L, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new LongBooleanHashMap().toImmutable(), LongBooleanMaps.immutable.ofAll(LongBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new LongBooleanHashMap().toImmutable(), LongBooleanMaps.immutable.withAll(LongBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true, 3L, false), LongBooleanMaps.mutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(LongBooleanMaps.mutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof MutableLongBooleanMap);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true, 3L, false), LongBooleanMaps.immutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(LongBooleanMaps.immutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableLongBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongBooleanMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new LongBooleanMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongBooleanMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = LongBooleanMapFactoryTest::of;
            this.payloads.ofAll = LongBooleanMapFactoryTest::ofAll;
            this.payloads.withAll = LongBooleanMapFactoryTest::withAll;
            this.payloads.from = LongBooleanMapFactoryTest::from;
        }
    }
}
