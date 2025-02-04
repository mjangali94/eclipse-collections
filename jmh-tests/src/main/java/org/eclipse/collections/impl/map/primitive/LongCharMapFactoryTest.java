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

import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;
import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongCharMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongCharMaps.immutable.of());
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1).toImmutable(), LongCharMaps.immutable.of(1L, (char) 1));
    }

    @Test
    public void withAll() {
        ImmutableLongCharMap map = LongCharMaps.immutable.of();
        Assert.assertEquals(LongCharMaps.mutable.empty().toImmutable(), LongCharMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, '1', 2L, '2', 3L, '3'), LongCharMaps.mutable.from(iterable, Long::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(LongCharMaps.mutable.from(iterable, Long::valueOf, each -> each.charAt(0)) instanceof MutableLongCharMap);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, '1', 2L, '2', 3L, '3'), LongCharMaps.immutable.from(iterable, Long::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(LongCharMaps.immutable.from(iterable, Long::valueOf, each -> each.charAt(0)) instanceof ImmutableLongCharMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongCharMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new LongCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = LongCharMapFactoryTest::of;
            this.payloads.withAll = LongCharMapFactoryTest::withAll;
            this.payloads.from = LongCharMapFactoryTest::from;
        }
    }
}
