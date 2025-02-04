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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongShortMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableLongShortMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongShortMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class LongShortMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(LongShortMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.LongShortMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableLongShortMapFactory mapFactory) {
        Assert.assertSame(new LongShortHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new LongShortHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1).toImmutable(), mapFactory.of(1L, (short) 1));
        LongShortHashMap sourceMap = LongShortHashMap.newWithKeysValues(1L, (short) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(LongShortMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.LongShortMaps.mutable);
    }

    private void assertMutableMapFactory(MutableLongShortMapFactory mapFactory) {
        Assert.assertEquals(new LongShortHashMap(), mapFactory.with());
        Assert.assertEquals(new LongShortHashMap(), mapFactory.of());
        LongShortHashMap sourceMap = LongShortHashMap.newWithKeysValues(1L, (short) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongShortMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapsTest> payload) throws java.lang.Throwable {
            this.instance = new LongShortMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongShortMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = LongShortMapsTest::immutables;
            this.payloads.mutables = LongShortMapsTest::mutables;
        }
    }
*/
}
