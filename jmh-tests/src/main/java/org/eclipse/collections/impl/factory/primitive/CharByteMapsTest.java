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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharByteMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableCharByteMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.CharByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharByteMaps}
 * This file was automatically generated from template file primitivePrimitiveMapsTest.stg
 */
public class CharByteMapsTest {

    @Test
    public void immutables() {
        this.assertImmutableMapFactory(CharByteMaps.immutable);
        this.assertImmutableMapFactory(org.eclipse.collections.api.factory.primitive.CharByteMaps.immutable);
    }

    private void assertImmutableMapFactory(ImmutableCharByteMapFactory mapFactory) {
        Assert.assertSame(new CharByteHashMap().toImmutable(), mapFactory.with());
        Assert.assertSame(new CharByteHashMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1).toImmutable(), mapFactory.of((char) 1, (byte) 1));
        CharByteHashMap sourceMap = CharByteHashMap.newWithKeysValues((char) 1, (byte) 1);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    @Test
    public void mutables() {
        this.assertMutableMapFactory(CharByteMaps.mutable);
        this.assertMutableMapFactory(org.eclipse.collections.api.factory.primitive.CharByteMaps.mutable);
    }

    private void assertMutableMapFactory(MutableCharByteMapFactory mapFactory) {
        Assert.assertEquals(new CharByteHashMap(), mapFactory.with());
        Assert.assertEquals(new CharByteHashMap(), mapFactory.of());
        CharByteHashMap sourceMap = CharByteHashMap.newWithKeysValues((char) 1, (byte) 1);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharByteMapsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_mutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.mutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteMapsTest> payload) throws java.lang.Throwable {
            this.instance = new CharByteMapsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteMapsTest> immutables;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteMapsTest> mutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = CharByteMapsTest::immutables;
            this.payloads.mutables = CharByteMapsTest::mutables;
        }
    }
*/
}
