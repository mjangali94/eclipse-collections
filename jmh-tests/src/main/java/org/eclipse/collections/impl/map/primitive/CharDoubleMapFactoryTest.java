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

import org.eclipse.collections.api.map.primitive.ImmutableCharDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class CharDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(CharDoubleMaps.immutable.of());
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0).toImmutable(), CharDoubleMaps.immutable.of((char) 1, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableCharDoubleMap map = CharDoubleMaps.immutable.of();
        Assert.assertEquals(CharDoubleMaps.mutable.empty().toImmutable(), CharDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues('1', 1.0, '2', 2.0, '3', 3.0), CharDoubleMaps.mutable.from(iterable, each -> each.charAt(0), Double::valueOf));
        Assert.assertTrue(CharDoubleMaps.mutable.from(iterable, each -> each.charAt(0), Double::valueOf) instanceof MutableCharDoubleMap);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues('1', 1.0, '2', 2.0, '3', 3.0), CharDoubleMaps.immutable.from(iterable, each -> each.charAt(0), Double::valueOf));
        Assert.assertTrue(CharDoubleMaps.immutable.from(iterable, each -> each.charAt(0), Double::valueOf) instanceof ImmutableCharDoubleMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharDoubleMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new CharDoubleMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = CharDoubleMapFactoryTest::of;
            this.payloads.withAll = CharDoubleMapFactoryTest::withAll;
            this.payloads.from = CharDoubleMapFactoryTest::from;
        }
    }
}
