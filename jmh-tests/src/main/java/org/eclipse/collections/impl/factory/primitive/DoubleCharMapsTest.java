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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleCharMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableDoubleCharMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleCharMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class DoubleCharMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(DoubleCharMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.DoubleCharMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableDoubleCharMapFactory mapFactory) {
        Assert.assertSame(new DoubleCharHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new DoubleCharHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1).toImmutable(), mapFactory.of(1.0, (char) 1));
        DoubleCharHashMap sourceMap = DoubleCharHashMap.newWithKeysValues(1.0, (char) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(DoubleCharMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.DoubleCharMaps.mutable);
    }

    private void assertMutableMapFactory(MutableDoubleCharMapFactory mapFactory) {
        Assert.assertEquals(new DoubleCharHashMap(), mapFactory.with());
        Assert.assertEquals(new DoubleCharHashMap(), mapFactory.of());
        DoubleCharHashMap sourceMap = DoubleCharHashMap.newWithKeysValues(1.0, (char) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleCharMapsTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapsTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleCharMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleCharMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = DoubleCharMapsTest::immutables;
            this.payloads.mutables = DoubleCharMapsTest::mutables;
        }
    }
}
