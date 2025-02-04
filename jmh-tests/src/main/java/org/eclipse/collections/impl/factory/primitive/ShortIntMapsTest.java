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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortIntMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableShortIntMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortIntMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ShortIntMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ShortIntMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortIntMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableShortIntMapFactory mapFactory) {
        Assert.assertSame(new ShortIntHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ShortIntHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1).toImmutable(), mapFactory.of((short) 1, 1));
        ShortIntHashMap sourceMap = ShortIntHashMap.newWithKeysValues((short) 1, 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ShortIntMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortIntMaps.mutable);
    }

    private void assertMutableMapFactory(MutableShortIntMapFactory mapFactory) {
        Assert.assertEquals(new ShortIntHashMap(), mapFactory.with());
        Assert.assertEquals(new ShortIntHashMap(), mapFactory.of());
        ShortIntHashMap sourceMap = ShortIntHashMap.newWithKeysValues((short) 1, 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortIntMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortIntMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ShortIntMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortIntMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortIntMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortIntMapsTest::immutables;
            this.payloads.mutables = ShortIntMapsTest::mutables;
        }
    }
}
