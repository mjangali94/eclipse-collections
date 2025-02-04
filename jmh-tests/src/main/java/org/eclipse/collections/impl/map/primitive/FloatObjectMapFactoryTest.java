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

import org.eclipse.collections.api.map.primitive.ImmutableFloatObjectMap;
import org.eclipse.collections.api.map.primitive.MutableFloatObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class FloatObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(FloatObjectMaps.immutable.with(), FloatObjectMaps.immutable.empty());
        Assert.assertSame(FloatObjectMaps.immutable.of(), FloatObjectMaps.immutable.empty());
        Assert.assertEquals(FloatObjectMaps.mutable.with(), FloatObjectMaps.mutable.empty());
        Assert.assertEquals(FloatObjectMaps.mutable.of(), FloatObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(FloatObjectMaps.mutable.with().toImmutable(), FloatObjectMaps.immutable.of());
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1").toImmutable(), FloatObjectMaps.immutable.of(1.0f, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(FloatObjectMaps.mutable.of(), FloatObjectMaps.immutable.ofAll(FloatObjectMaps.immutable.of()));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1"), FloatObjectMaps.immutable.ofAll(FloatObjectHashMap.newWithKeysValues(1.0f, "1")));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1", 2.0f, "2"), FloatObjectMaps.immutable.ofAll(FloatObjectHashMap.newWithKeysValues(1.0f, "1", 2.0f, "2")));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1", 2.0f, "2"), FloatObjectMaps.immutable.ofAll(FloatObjectHashMap.newWithKeysValues(1.0f, "1", 2.0f, "2").toImmutable()));
        Assert.assertEquals(FloatObjectMaps.mutable.empty(), FloatObjectMaps.mutable.ofAll(FloatObjectMaps.immutable.of()));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1"), FloatObjectMaps.mutable.ofAll(FloatObjectHashMap.newWithKeysValues(1.0f, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1", 2.0f, "2", 3.0f, "3"), FloatObjectMaps.mutable.from(iterable, Float::valueOf, each -> each));
        Assert.assertTrue(FloatObjectMaps.mutable.from(iterable, Float::valueOf, each -> each) instanceof MutableFloatObjectMap);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1", 2.0f, "2", 3.0f, "3"), FloatObjectMaps.immutable.from(iterable, Float::valueOf, each -> each));
        Assert.assertTrue(FloatObjectMaps.immutable.from(iterable, Float::valueOf, each -> each) instanceof ImmutableFloatObjectMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatObjectMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.of);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ofAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.from);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new FloatObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatObjectMapFactoryTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatObjectMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatObjectMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatObjectMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.empty = FloatObjectMapFactoryTest::empty;
            this.payloads.of = FloatObjectMapFactoryTest::of;
            this.payloads.ofAll = FloatObjectMapFactoryTest::ofAll;
            this.payloads.from = FloatObjectMapFactoryTest::from;
        }
    }
}
