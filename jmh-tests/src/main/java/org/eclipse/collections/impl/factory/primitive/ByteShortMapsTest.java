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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteShortMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableByteShortMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ByteShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteShortMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ByteShortMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ByteShortMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteShortMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableByteShortMapFactory mapFactory) {
        Assert.assertSame(new ByteShortHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ByteShortHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1).toImmutable(), mapFactory.of((byte) 1, (short) 1));
        ByteShortHashMap sourceMap = ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ByteShortMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteShortMaps.mutable);
    }

    private void assertMutableMapFactory(MutableByteShortMapFactory mapFactory) {
        Assert.assertEquals(new ByteShortHashMap(), mapFactory.with());
        Assert.assertEquals(new ByteShortHashMap(), mapFactory.of());
        ByteShortHashMap sourceMap = ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteShortMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ByteShortMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteShortMapsTest::immutables;
            this.payloads.mutables = ByteShortMapsTest::mutables;
        }
    }
}
