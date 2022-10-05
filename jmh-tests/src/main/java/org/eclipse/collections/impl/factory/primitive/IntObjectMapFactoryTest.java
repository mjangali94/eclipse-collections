/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableIntObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class IntObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableIntObjectMapFactory(IntObjectMaps.immutable);
        this.assertImmutableIntObjectMapFactory(org.eclipse.collections.api.factory.primitive.IntObjectMaps.immutable);
    }

    private void assertImmutableIntObjectMapFactory(ImmutableIntObjectMapFactory mapFactory) {
        Assert.assertSame(IntObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(IntObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(IntObjectMaps.immutable.of(1, 1), IntObjectHashMap.newWithKeysValues(1, 1).toImmutable());
        IntObjectHashMap sourceMap = IntObjectHashMap.newWithKeysValues(1, 1, 2, 2);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableIntObjectMapFactory(IntObjectMaps.mutable);
        this.assertMutableIntObjectMapFactory(org.eclipse.collections.api.factory.primitive.IntObjectMaps.mutable);
    }

    private void assertMutableIntObjectMapFactory(MutableIntObjectMapFactory mapFactory) {
        Assert.assertEquals(IntObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(IntObjectHashMap.newMap(), mapFactory.of());
        IntObjectHashMap sourceMap = IntObjectHashMap.newWithKeysValues(1, 1, 2, 2);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntObjectMapFactoryTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new IntObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntObjectMapFactoryTest> immutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = IntObjectMapFactoryTest::immutables;
        }
    }
}
