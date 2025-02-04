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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharDoubleMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableCharDoubleMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharDoubleMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class CharDoubleMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(CharDoubleMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.CharDoubleMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableCharDoubleMapFactory mapFactory) {
        Assert.assertSame(new CharDoubleHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new CharDoubleHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0).toImmutable(), mapFactory.of((char) 1, 1.0));
        CharDoubleHashMap sourceMap = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(CharDoubleMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.CharDoubleMaps.mutable);
    }

    private void assertMutableMapFactory(MutableCharDoubleMapFactory mapFactory) {
        Assert.assertEquals(new CharDoubleHashMap(), mapFactory.with());
        Assert.assertEquals(new CharDoubleHashMap(), mapFactory.of());
        CharDoubleHashMap sourceMap = CharDoubleHashMap.newWithKeysValues((char) 1, 1.0);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharDoubleMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapsTest> payload) throws java.lang.Throwable {
            this.instance = new CharDoubleMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharDoubleMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = CharDoubleMapsTest::immutables;
            this.payloads.mutables = CharDoubleMapsTest::mutables;
        }
    }
}
