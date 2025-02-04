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

import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortLongMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortLongMaps.immutable.of());
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L).toImmutable(), ShortLongMaps.immutable.of((short) 1, 1L));
    }

    @Test
    public void withAll() {
        ImmutableShortLongMap map = ShortLongMaps.immutable.of();
        Assert.assertEquals(ShortLongMaps.mutable.empty().toImmutable(), ShortLongMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L), ShortLongMaps.mutable.from(iterable, Short::valueOf, Long::valueOf));
        Assert.assertTrue(ShortLongMaps.mutable.from(iterable, Short::valueOf, Long::valueOf) instanceof MutableShortLongMap);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L), ShortLongMaps.immutable.from(iterable, Short::valueOf, Long::valueOf));
        Assert.assertTrue(ShortLongMaps.immutable.from(iterable, Short::valueOf, Long::valueOf) instanceof ImmutableShortLongMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortLongMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ShortLongMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ShortLongMapFactoryTest::of;
            this.payloads.withAll = ShortLongMapFactoryTest::withAll;
            this.payloads.from = ShortLongMapFactoryTest::from;
        }
    }
*/
}
