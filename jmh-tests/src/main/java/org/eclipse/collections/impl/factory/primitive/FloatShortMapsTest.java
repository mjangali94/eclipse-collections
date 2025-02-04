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

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatShortMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableFloatShortMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link FloatShortMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class FloatShortMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(FloatShortMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.FloatShortMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableFloatShortMapFactory mapFactory) {
        Assert.assertSame(new FloatShortHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new FloatShortHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1).toImmutable(), mapFactory.of(1.0f, (short) 1));
        FloatShortHashMap sourceMap = FloatShortHashMap.newWithKeysValues(1.0f, (short) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(FloatShortMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.FloatShortMaps.mutable);
    }

    private void assertMutableMapFactory(MutableFloatShortMapFactory mapFactory) {
        Assert.assertEquals(new FloatShortHashMap(), mapFactory.with());
        Assert.assertEquals(new FloatShortHashMap(), mapFactory.of());
        FloatShortHashMap sourceMap = FloatShortHashMap.newWithKeysValues(1.0f, (short) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatShortMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapsTest> payload) throws java.lang.Throwable {
            this.instance = new FloatShortMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = FloatShortMapsTest::immutables;
            this.payloads.mutables = FloatShortMapsTest::mutables;
        }
    }
*/
}
