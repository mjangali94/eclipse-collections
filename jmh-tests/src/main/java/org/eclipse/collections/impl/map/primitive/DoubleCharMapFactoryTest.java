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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleCharMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleCharMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class DoubleCharMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(DoubleCharMaps.immutable.of());
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1).toImmutable(), DoubleCharMaps.immutable.of(1.0, (char) 1));
    }

    @Test
    public void withAll() {
        ImmutableDoubleCharMap map = DoubleCharMaps.immutable.of();
        Assert.assertEquals(DoubleCharMaps.mutable.empty().toImmutable(), DoubleCharMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, '1', 2.0, '2', 3.0, '3'), DoubleCharMaps.mutable.from(iterable, Double::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(DoubleCharMaps.mutable.from(iterable, Double::valueOf, each -> each.charAt(0)) instanceof MutableDoubleCharMap);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, '1', 2.0, '2', 3.0, '3'), DoubleCharMaps.immutable.from(iterable, Double::valueOf, each -> each.charAt(0)));
        Assert.assertTrue(DoubleCharMaps.immutable.from(iterable, Double::valueOf, each -> each.charAt(0)) instanceof ImmutableDoubleCharMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleCharMapFactoryTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleCharMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapFactoryTest> of;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapFactoryTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapFactoryTest> from;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.of = DoubleCharMapFactoryTest::of;
            this.payloads.withAll = DoubleCharMapFactoryTest::withAll;
            this.payloads.from = DoubleCharMapFactoryTest::from;
        }
    }
}
