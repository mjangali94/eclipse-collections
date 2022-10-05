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

import org.eclipse.collections.api.map.primitive.ImmutableCharFloatMap;
import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharFloatMaps.immutable.of());
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f).toImmutable(), CharFloatMaps.immutable.of((char) 1, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableCharFloatMap map = CharFloatMaps.immutable.of();
        Assert.assertEquals(CharFloatMaps.mutable.empty().toImmutable(), CharFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues('1', 1.0f, '2', 2.0f, '3', 3.0f), CharFloatMaps.mutable.from(iterable, each -> each.charAt(0), Float::valueOf));
        Assert.assertTrue(CharFloatMaps.mutable.from(iterable, each -> each.charAt(0), Float::valueOf) instanceof MutableCharFloatMap);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues('1', 1.0f, '2', 2.0f, '3', 3.0f), CharFloatMaps.immutable.from(iterable, each -> each.charAt(0), Float::valueOf));
        Assert.assertTrue(CharFloatMaps.immutable.from(iterable, each -> each.charAt(0), Float::valueOf) instanceof ImmutableCharFloatMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharFloatMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharFloatMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new CharFloatMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharFloatMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharFloatMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharFloatMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = CharFloatMapFactoryTest::of;
            this.payloads.withAll = CharFloatMapFactoryTest::withAll;
            this.payloads.from = CharFloatMapFactoryTest::from;
        }
    }
}
