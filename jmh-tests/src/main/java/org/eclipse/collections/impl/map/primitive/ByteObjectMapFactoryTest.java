/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableByteObjectMap;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class ByteObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(ByteObjectMaps.immutable.with(), ByteObjectMaps.immutable.empty());
        Assert.assertSame(ByteObjectMaps.immutable.of(), ByteObjectMaps.immutable.empty());
        Assert.assertEquals(ByteObjectMaps.mutable.with(), ByteObjectMaps.mutable.empty());
        Assert.assertEquals(ByteObjectMaps.mutable.of(), ByteObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(ByteObjectMaps.mutable.with().toImmutable(), ByteObjectMaps.immutable.of());
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1").toImmutable(), ByteObjectMaps.immutable.of((byte) 1, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ByteObjectMaps.mutable.of(), ByteObjectMaps.immutable.ofAll(ByteObjectMaps.immutable.of()));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1"), ByteObjectMaps.immutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2"), ByteObjectMaps.immutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2"), ByteObjectMaps.immutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2").toImmutable()));
        Assert.assertEquals(ByteObjectMaps.mutable.empty(), ByteObjectMaps.mutable.ofAll(ByteObjectMaps.immutable.of()));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1"), ByteObjectMaps.mutable.ofAll(ByteObjectHashMap.newWithKeysValues((byte) 1, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2", (byte) 3, "3"), ByteObjectMaps.mutable.from(iterable, Byte::valueOf, each -> each));
        Assert.assertTrue(ByteObjectMaps.mutable.from(iterable, Byte::valueOf, each -> each) instanceof MutableByteObjectMap);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1", (byte) 2, "2", (byte) 3, "3"), ByteObjectMaps.immutable.from(iterable, Byte::valueOf, each -> each));
        Assert.assertTrue(ByteObjectMaps.immutable.from(iterable, Byte::valueOf, each -> each) instanceof ImmutableByteObjectMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAll, this.description("ofAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::from, this.description("from"));
        }

        private ByteObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteObjectMapFactoryTest();
        }

        @java.lang.Override
        public ByteObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
