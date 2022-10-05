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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortDoubleMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableShortDoubleMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortDoubleMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ShortDoubleMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ShortDoubleMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortDoubleMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableShortDoubleMapFactory mapFactory) {
        Assert.assertSame(new ShortDoubleHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ShortDoubleHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0).toImmutable(), mapFactory.of((short) 1, 1.0));
        ShortDoubleHashMap sourceMap = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ShortDoubleMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortDoubleMaps.mutable);
    }

    private void assertMutableMapFactory(MutableShortDoubleMapFactory mapFactory) {
        Assert.assertEquals(new ShortDoubleHashMap(), mapFactory.with());
        Assert.assertEquals(new ShortDoubleHashMap(), mapFactory.of());
        ShortDoubleHashMap sourceMap = ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortDoubleMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortDoubleMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ShortDoubleMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortDoubleMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortDoubleMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortDoubleMapsTest::immutables;
            this.payloads.mutables = ShortDoubleMapsTest::mutables;
        }
    }
}
