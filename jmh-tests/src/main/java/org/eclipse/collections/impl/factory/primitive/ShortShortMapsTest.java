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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortShortMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableShortShortMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ShortShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortShortMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ShortShortMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ShortShortMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortShortMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableShortShortMapFactory mapFactory) {
        Assert.assertSame(new ShortShortHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ShortShortHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1).toImmutable(), mapFactory.of((short) 1, (short) 1));
        ShortShortHashMap sourceMap = ShortShortHashMap.newWithKeysValues((short) 1, (short) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ShortShortMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ShortShortMaps.mutable);
    }

    private void assertMutableMapFactory(MutableShortShortMapFactory mapFactory) {
        Assert.assertEquals(new ShortShortHashMap(), mapFactory.with());
        Assert.assertEquals(new ShortShortHashMap(), mapFactory.of());
        ShortShortHashMap sourceMap = ShortShortHashMap.newWithKeysValues((short) 1, (short) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortShortMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ShortShortMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortShortMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ShortShortMapsTest::immutables;
            this.payloads.mutables = ShortShortMapsTest::mutables;
        }
    }
*/
}
