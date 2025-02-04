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

import org.eclipse.collections.api.map.primitive.ImmutableShortByteMap;
import org.eclipse.collections.api.map.primitive.MutableShortByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortByteMaps.immutable.of());
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1).toImmutable(), ShortByteMaps.immutable.of((short) 1, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableShortByteMap map = ShortByteMaps.immutable.of();
        Assert.assertEquals(ShortByteMaps.mutable.empty().toImmutable(), ShortByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3), ShortByteMaps.mutable.from(iterable, Short::valueOf, Byte::valueOf));
        Assert.assertTrue(ShortByteMaps.mutable.from(iterable, Short::valueOf, Byte::valueOf) instanceof MutableShortByteMap);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3), ShortByteMaps.immutable.from(iterable, Short::valueOf, Byte::valueOf));
        Assert.assertTrue(ShortByteMaps.immutable.from(iterable, Short::valueOf, Byte::valueOf) instanceof ImmutableShortByteMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortByteMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ShortByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ShortByteMapFactoryTest::of;
            this.payloads.withAll = ShortByteMapFactoryTest::withAll;
            this.payloads.from = ShortByteMapFactoryTest::from;
        }
    }
*/
}
