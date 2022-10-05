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

import org.eclipse.collections.api.map.primitive.ImmutableFloatBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableFloatBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class FloatBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new FloatBooleanHashMap().toImmutable(), FloatBooleanMaps.immutable.of());
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, true).toImmutable(), FloatBooleanMaps.immutable.of(1.0f, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new FloatBooleanHashMap().toImmutable(), FloatBooleanMaps.immutable.ofAll(FloatBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new FloatBooleanHashMap().toImmutable(), FloatBooleanMaps.immutable.withAll(FloatBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true, 3.0f, false), FloatBooleanMaps.mutable.from(iterable, Float::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(FloatBooleanMaps.mutable.from(iterable, Float::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof MutableFloatBooleanMap);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true, 3.0f, false), FloatBooleanMaps.immutable.from(iterable, Float::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(FloatBooleanMaps.immutable.from(iterable, Float::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableFloatBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatBooleanMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new FloatBooleanMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = FloatBooleanMapFactoryTest::of;
            this.payloads.ofAll = FloatBooleanMapFactoryTest::ofAll;
            this.payloads.withAll = FloatBooleanMapFactoryTest::withAll;
            this.payloads.from = FloatBooleanMapFactoryTest::from;
        }
    }
}
