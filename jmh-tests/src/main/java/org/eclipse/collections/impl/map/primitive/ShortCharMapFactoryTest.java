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

import org.eclipse.collections.api.map.primitive.ImmutableShortCharMap;
import org.eclipse.collections.api.map.primitive.MutableShortCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortCharMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortCharMaps.immutable.of());
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1).toImmutable(), ShortCharMaps.immutable.of((short) 1, (char) 1));
    }

    @Test
    public void withAll() {
        ImmutableShortCharMap map = ShortCharMaps.immutable.of();
        Assert.assertEquals(ShortCharMaps.mutable.empty().toImmutable(), ShortCharMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, '1', (short) 2, '2', (short) 3, '3'), ShortCharMaps.mutable.from(iterable, Short::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(ShortCharMaps.mutable.from(iterable, Short::valueOf, each -> each.charAt(0)) instanceof MutableShortCharMap);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, '1', (short) 2, '2', (short) 3, '3'), ShortCharMaps.immutable.from(iterable, Short::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(ShortCharMaps.immutable.from(iterable, Short::valueOf, each -> each.charAt(0)) instanceof ImmutableShortCharMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortCharMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ShortCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortCharMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortCharMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortCharMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ShortCharMapFactoryTest::of;
            this.payloads.withAll = ShortCharMapFactoryTest::withAll;
            this.payloads.from = ShortCharMapFactoryTest::from;
        }
    }
}
