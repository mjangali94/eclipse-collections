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

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatLongMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableFloatLongMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link FloatLongMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class FloatLongMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(FloatLongMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.FloatLongMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableFloatLongMapFactory mapFactory) {
        Assert.assertSame(new FloatLongHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new FloatLongHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L).toImmutable(), mapFactory.of(1.0f, 1L));
        FloatLongHashMap sourceMap = FloatLongHashMap.newWithKeysValues(1.0f, 1L);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(FloatLongMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.FloatLongMaps.mutable);
    }

    private void assertMutableMapFactory(MutableFloatLongMapFactory mapFactory) {
        Assert.assertEquals(new FloatLongHashMap(), mapFactory.with());
        Assert.assertEquals(new FloatLongHashMap(), mapFactory.of());
        FloatLongHashMap sourceMap = FloatLongHashMap.newWithKeysValues(1.0f, 1L);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatLongMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatLongMapsTest> payload) throws java.lang.Throwable {
            this.instance = new FloatLongMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatLongMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatLongMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = FloatLongMapsTest::immutables;
            this.payloads.mutables = FloatLongMapsTest::mutables;
        }
    }
}
