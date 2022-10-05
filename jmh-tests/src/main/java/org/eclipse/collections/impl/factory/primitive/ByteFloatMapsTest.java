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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteFloatMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableByteFloatMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteFloatMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ByteFloatMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ByteFloatMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteFloatMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableByteFloatMapFactory mapFactory) {
        Assert.assertSame(new ByteFloatHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ByteFloatHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f).toImmutable(), mapFactory.of((byte) 1, 1.0f));
        ByteFloatHashMap sourceMap = ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ByteFloatMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteFloatMaps.mutable);
    }

    private void assertMutableMapFactory(MutableByteFloatMapFactory mapFactory) {
        Assert.assertEquals(new ByteFloatHashMap(), mapFactory.with());
        Assert.assertEquals(new ByteFloatHashMap(), mapFactory.of());
        ByteFloatHashMap sourceMap = ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteFloatMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ByteFloatMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteFloatMapsTest::immutables;
            this.payloads.mutables = ByteFloatMapsTest::mutables;
        }
    }
}
