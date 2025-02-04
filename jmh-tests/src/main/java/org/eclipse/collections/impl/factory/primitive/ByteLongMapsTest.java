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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteLongMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableByteLongMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ByteLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteLongMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class ByteLongMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(ByteLongMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteLongMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableByteLongMapFactory mapFactory) {
        Assert.assertSame(new ByteLongHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new ByteLongHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L).toImmutable(), mapFactory.of((byte) 1, 1L));
        ByteLongHashMap sourceMap = ByteLongHashMap.newWithKeysValues((byte) 1, 1L);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(ByteLongMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.ByteLongMaps.mutable);
    }

    private void assertMutableMapFactory(MutableByteLongMapFactory mapFactory) {
        Assert.assertEquals(new ByteLongHashMap(), mapFactory.with());
        Assert.assertEquals(new ByteLongHashMap(), mapFactory.of());
        ByteLongHashMap sourceMap = ByteLongHashMap.newWithKeysValues((byte) 1, 1L);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteLongMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongMapsTest> payload) throws java.lang.Throwable {
            this.instance = new ByteLongMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteLongMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteLongMapsTest::immutables;
            this.payloads.mutables = ByteLongMapsTest::mutables;
        }
    }
*/
}
