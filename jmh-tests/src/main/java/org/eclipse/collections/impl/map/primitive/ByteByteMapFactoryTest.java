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

import org.eclipse.collections.api.map.primitive.ImmutableByteByteMap;
import org.eclipse.collections.api.map.primitive.MutableByteByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ByteByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ByteByteMaps.immutable.of());
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1).toImmutable(), ByteByteMaps.immutable.of((byte) 1, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableByteByteMap map = ByteByteMaps.immutable.of();
        Assert.assertEquals(ByteByteMaps.mutable.empty().toImmutable(), ByteByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3), ByteByteMaps.mutable.from(iterable, Byte::valueOf, Byte::valueOf));
        Assert.assertTrue(ByteByteMaps.mutable.from(iterable, Byte::valueOf, Byte::valueOf) instanceof MutableByteByteMap);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3), ByteByteMaps.immutable.from(iterable, Byte::valueOf, Byte::valueOf));
        Assert.assertTrue(ByteByteMaps.immutable.from(iterable, Byte::valueOf, Byte::valueOf) instanceof ImmutableByteByteMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAll, this.description("withAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_from() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::from, this.description("from"));
        }

        private ByteByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteByteMapFactoryTest();
        }

        @java.lang.Override
        public ByteByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
