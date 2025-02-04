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

import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableIntBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class IntBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new IntBooleanHashMap().toImmutable(), IntBooleanMaps.immutable.of());
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, true).toImmutable(), IntBooleanMaps.immutable.of(1, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new IntBooleanHashMap().toImmutable(), IntBooleanMaps.immutable.ofAll(IntBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new IntBooleanHashMap().toImmutable(), IntBooleanMaps.immutable.withAll(IntBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 2, true, 3, false), IntBooleanMaps.mutable.from(iterable, Integer::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(IntBooleanMaps.mutable.from(iterable, Integer::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof MutableIntBooleanMap);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 2, true, 3, false), IntBooleanMaps.immutable.from(iterable, Integer::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(IntBooleanMaps.immutable.from(iterable, Integer::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableIntBooleanMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntBooleanMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new IntBooleanMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = IntBooleanMapFactoryTest::of;
            this.payloads.ofAll = IntBooleanMapFactoryTest::ofAll;
            this.payloads.withAll = IntBooleanMapFactoryTest::withAll;
            this.payloads.from = IntBooleanMapFactoryTest::from;
        }
    }
*/
}
