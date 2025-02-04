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

import org.eclipse.collections.api.map.primitive.ImmutableShortShortMap;
import org.eclipse.collections.api.map.primitive.MutableShortShortMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortShortMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortShortMaps.immutable.of());
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1).toImmutable(), ShortShortMaps.immutable.of((short) 1, (short) 1));
    }

    @Test
    public void withAll() {
        ImmutableShortShortMap map = ShortShortMaps.immutable.of();
        Assert.assertEquals(ShortShortMaps.mutable.empty().toImmutable(), ShortShortMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3), ShortShortMaps.mutable.from(iterable, Short::valueOf, Short::valueOf));
        Assert.assertTrue(ShortShortMaps.mutable.from(iterable, Short::valueOf, Short::valueOf) instanceof MutableShortShortMap);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3), ShortShortMaps.immutable.from(iterable, Short::valueOf, Short::valueOf));
        Assert.assertTrue(ShortShortMaps.immutable.from(iterable, Short::valueOf, Short::valueOf) instanceof ImmutableShortShortMap);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortShortMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ShortShortMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = ShortShortMapFactoryTest::of;
            this.payloads.withAll = ShortShortMapFactoryTest::withAll;
            this.payloads.from = ShortShortMapFactoryTest::from;
        }
    }
*/
}
