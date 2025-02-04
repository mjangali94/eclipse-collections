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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleDoubleMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableDoubleDoubleMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleDoubleMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class DoubleDoubleMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(DoubleDoubleMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.DoubleDoubleMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableDoubleDoubleMapFactory mapFactory) {
        Assert.assertSame(new DoubleDoubleHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new DoubleDoubleHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0).toImmutable(), mapFactory.of(1.0, 1.0));
        DoubleDoubleHashMap sourceMap = DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(DoubleDoubleMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.DoubleDoubleMaps.mutable);
    }

    private void assertMutableMapFactory(MutableDoubleDoubleMapFactory mapFactory) {
        Assert.assertEquals(new DoubleDoubleHashMap(), mapFactory.with());
        Assert.assertEquals(new DoubleDoubleHashMap(), mapFactory.of());
        DoubleDoubleHashMap sourceMap = DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleDoubleMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleMapsTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleDoubleMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = DoubleDoubleMapsTest::immutables;
            this.payloads.mutables = DoubleDoubleMapsTest::mutables;
        }
    }
*/
}
