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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntFloatMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableIntFloatMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link IntFloatMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class IntFloatMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(IntFloatMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.IntFloatMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableIntFloatMapFactory mapFactory) {
        Assert.assertSame(new IntFloatHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new IntFloatHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f).toImmutable(), mapFactory.of(1, 1.0f));
        IntFloatHashMap sourceMap = IntFloatHashMap.newWithKeysValues(1, 1.0f);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(IntFloatMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.IntFloatMaps.mutable);
    }

    private void assertMutableMapFactory(MutableIntFloatMapFactory mapFactory) {
        Assert.assertEquals(new IntFloatHashMap(), mapFactory.with());
        Assert.assertEquals(new IntFloatHashMap(), mapFactory.of());
        IntFloatHashMap sourceMap = IntFloatHashMap.newWithKeysValues(1, 1.0f);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntFloatMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatMapsTest> payload) throws java.lang.Throwable {
            this.instance = new IntFloatMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntFloatMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = IntFloatMapsTest::immutables;
            this.payloads.mutables = IntFloatMapsTest::mutables;
        }
    }
*/
}
