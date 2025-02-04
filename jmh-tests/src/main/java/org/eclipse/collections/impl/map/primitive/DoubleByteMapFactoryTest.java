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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleByteMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class DoubleByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(DoubleByteMaps.immutable.of());
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1).toImmutable(), DoubleByteMaps.immutable.of(1.0, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableDoubleByteMap map = DoubleByteMaps.immutable.of();
        Assert.assertEquals(DoubleByteMaps.mutable.empty().toImmutable(), DoubleByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3), DoubleByteMaps.mutable.from(iterable, Double::valueOf, Byte::valueOf));
        Assert.assertTrue(DoubleByteMaps.mutable.from(iterable, Double::valueOf, Byte::valueOf) instanceof MutableDoubleByteMap);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3), DoubleByteMaps.immutable.from(iterable, Double::valueOf, Byte::valueOf));
        Assert.assertTrue(DoubleByteMaps.immutable.from(iterable, Double::valueOf, Byte::valueOf) instanceof ImmutableDoubleByteMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleByteMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleByteMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleByteMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = DoubleByteMapFactoryTest::of;
            this.payloads.withAll = DoubleByteMapFactoryTest::withAll;
            this.payloads.from = DoubleByteMapFactoryTest::from;
        }
    }
}
