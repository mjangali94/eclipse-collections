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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteObjectMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableByteObjectMapFactory;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapsTest.stg.
 */
public class ByteObjectMapFactoryTest {

    @Test
    public void immutables() {
        this.assertImmutableByteObjectMapFactory(ByteObjectMaps.immutable);
        this.assertImmutableByteObjectMapFactory(org.eclipse.collections.api.factory.primitive.ByteObjectMaps.immutable);
    }

    private void assertImmutableByteObjectMapFactory(ImmutableByteObjectMapFactory mapFactory) {
        Assert.assertSame(ByteObjectHashMap.newMap().toImmutable(), mapFactory.with());
        Assert.assertSame(ByteObjectHashMap.newMap().toImmutable(), mapFactory.of());
        Assert.assertEquals(ByteObjectMaps.immutable.of((byte) 1, (byte) 1), ByteObjectHashMap.newWithKeysValues((byte) 1, (byte) 1).toImmutable());
        ByteObjectHashMap sourceMap = ByteObjectHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2);
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap.toImmutable(), mapFactory.withAll(sourceMap));
    }

    public void mutables() {
        this.assertMutableByteObjectMapFactory(ByteObjectMaps.mutable);
        this.assertMutableByteObjectMapFactory(org.eclipse.collections.api.factory.primitive.ByteObjectMaps.mutable);
    }

    private void assertMutableByteObjectMapFactory(MutableByteObjectMapFactory mapFactory) {
        Assert.assertEquals(ByteObjectHashMap.newMap(), mapFactory.with());
        Assert.assertEquals(ByteObjectHashMap.newMap(), mapFactory.of());
        ByteObjectHashMap sourceMap = ByteObjectHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2);
        Assert.assertEquals(sourceMap, mapFactory.ofAll(sourceMap));
        Assert.assertEquals(sourceMap, mapFactory.withAll(sourceMap));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteObjectMapFactoryTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_immutables() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.immutables);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> payload) throws java.lang.Throwable {
            this.instance = new ByteObjectMapFactoryTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteObjectMapFactoryTest> immutables;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.immutables = ByteObjectMapFactoryTest::immutables;
        }
    }
*/
}
