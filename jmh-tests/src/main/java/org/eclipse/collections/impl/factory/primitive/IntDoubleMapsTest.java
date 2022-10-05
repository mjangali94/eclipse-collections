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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntDoubleMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableIntDoubleMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link IntDoubleMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class IntDoubleMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(IntDoubleMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.IntDoubleMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableIntDoubleMapFactory mapFactory) {
        Assert.assertSame(new IntDoubleHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new IntDoubleHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0).toImmutable(), mapFactory.of(1, 1.0));
        IntDoubleHashMap sourceMap = IntDoubleHashMap.newWithKeysValues(1, 1.0);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(IntDoubleMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.IntDoubleMaps.mutable);
    }

    private void assertMutableMapFactory(MutableIntDoubleMapFactory mapFactory) {
        Assert.assertEquals(new IntDoubleHashMap(), mapFactory.with());
        Assert.assertEquals(new IntDoubleHashMap(), mapFactory.of());
        IntDoubleHashMap sourceMap = IntDoubleHashMap.newWithKeysValues(1, 1.0);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntDoubleMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapsTest> payload) throws java.lang.Throwable {
            this.instance = new IntDoubleMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntDoubleMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = IntDoubleMapsTest::immutables;
            this.payloads.mutables = IntDoubleMapsTest::mutables;
        }
    }
}
