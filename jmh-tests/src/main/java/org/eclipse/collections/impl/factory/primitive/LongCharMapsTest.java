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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongCharMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableLongCharMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongCharMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class LongCharMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(LongCharMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.LongCharMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableLongCharMapFactory mapFactory) {
        Assert.assertSame(new LongCharHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new LongCharHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1).toImmutable(), mapFactory.of(1L, (char) 1));
        LongCharHashMap sourceMap = LongCharHashMap.newWithKeysValues(1L, (char) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(LongCharMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.LongCharMaps.mutable);
    }

    private void assertMutableMapFactory(MutableLongCharMapFactory mapFactory) {
        Assert.assertEquals(new LongCharHashMap(), mapFactory.with());
        Assert.assertEquals(new LongCharHashMap(), mapFactory.of());
        LongCharHashMap sourceMap = LongCharHashMap.newWithKeysValues(1L, (char) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongCharMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapsTest> payload) throws java.lang.Throwable {
            this.instance = new LongCharMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = LongCharMapsTest::immutables;
            this.payloads.mutables = LongCharMapsTest::mutables;
        }
    }
}
