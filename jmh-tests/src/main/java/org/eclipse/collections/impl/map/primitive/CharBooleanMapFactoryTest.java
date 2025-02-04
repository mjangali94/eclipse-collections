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

import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableCharBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class CharBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new CharBooleanHashMap().toImmutable(), CharBooleanMaps.immutable.of());
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, true).toImmutable(), CharBooleanMaps.immutable.of((char) 1, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new CharBooleanHashMap().toImmutable(), CharBooleanMaps.immutable.ofAll(CharBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new CharBooleanHashMap().toImmutable(), CharBooleanMaps.immutable.withAll(CharBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues('1', false, '2', true, '3', false), CharBooleanMaps.mutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(CharBooleanMaps.mutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0) instanceof MutableCharBooleanMap);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues('1', false, '2', true, '3', false), CharBooleanMaps.immutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(CharBooleanMaps.immutable.from(iterable, each -> each.charAt(0), each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableCharBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharBooleanMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new CharBooleanMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanMapFactoryTest> ofAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = CharBooleanMapFactoryTest::of;
            this.payloads.ofAll = CharBooleanMapFactoryTest::ofAll;
            this.payloads.withAll = CharBooleanMapFactoryTest::withAll;
            this.payloads.from = CharBooleanMapFactoryTest::from;
        }
    }
}
