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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class DoubleBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new DoubleBooleanHashMap().toImmutable(), DoubleBooleanMaps.immutable.of());
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, true).toImmutable(), DoubleBooleanMaps.immutable.of(1.0, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new DoubleBooleanHashMap().toImmutable(), DoubleBooleanMaps.immutable.ofAll(DoubleBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new DoubleBooleanHashMap().toImmutable(), DoubleBooleanMaps.immutable.withAll(DoubleBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 2.0, true, 3.0, false), DoubleBooleanMaps.mutable.from(iterable, Double::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(DoubleBooleanMaps.mutable.from(iterable, Double::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof MutableDoubleBooleanMap);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 2.0, true, 3.0, false), DoubleBooleanMaps.immutable.from(iterable, Double::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(DoubleBooleanMaps.immutable.from(iterable, Double::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableDoubleBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleBooleanMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleBooleanMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = DoubleBooleanMapFactoryTest::of;
            this.payloads.ofAll = DoubleBooleanMapFactoryTest::ofAll;
            this.payloads.withAll = DoubleBooleanMapFactoryTest::withAll;
            this.payloads.from = DoubleBooleanMapFactoryTest::from;
        }
    }
}
