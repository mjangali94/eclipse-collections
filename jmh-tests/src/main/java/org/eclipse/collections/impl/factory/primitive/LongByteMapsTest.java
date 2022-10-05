/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongByteMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableLongByteMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.LongByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongByteMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class LongByteMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(LongByteMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.LongByteMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableLongByteMapFactory mapFactory) {
        Assert.assertSame(new LongByteHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new LongByteHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1).toImmutable(), mapFactory.of(1L, (byte) 1));
        LongByteHashMap sourceMap = LongByteHashMap.newWithKeysValues(1L, (byte) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(LongByteMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.LongByteMaps.mutable);
    }

    private void assertMutableMapFactory(MutableLongByteMapFactory mapFactory) {
        Assert.assertEquals(new LongByteHashMap(), mapFactory.with());
        Assert.assertEquals(new LongByteHashMap(), mapFactory.of());
        LongByteHashMap sourceMap = LongByteHashMap.newWithKeysValues(1L, (byte) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongByteMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteMapsTest> payload) throws java.lang.Throwable {
            this.instance = new LongByteMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = LongByteMapsTest::immutables;
            this.payloads.mutables = LongByteMapsTest::mutables;
        }
    }
}
