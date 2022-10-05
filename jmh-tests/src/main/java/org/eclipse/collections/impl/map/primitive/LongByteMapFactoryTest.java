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

import org.eclipse.collections.api.map.primitive.ImmutableLongByteMap;
import org.eclipse.collections.api.map.primitive.MutableLongByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongByteMaps.immutable.of());
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1).toImmutable(), LongByteMaps.immutable.of(1L, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableLongByteMap map = LongByteMaps.immutable.of();
        Assert.assertEquals(LongByteMaps.mutable.empty().toImmutable(), LongByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3), LongByteMaps.mutable.from(iterable, Long::valueOf, Byte::valueOf));
        Assert.assertTrue(LongByteMaps.mutable.from(iterable, Long::valueOf, Byte::valueOf) instanceof MutableLongByteMap);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3), LongByteMaps.immutable.from(iterable, Long::valueOf, Byte::valueOf));
        Assert.assertTrue(LongByteMaps.immutable.from(iterable, Long::valueOf, Byte::valueOf) instanceof ImmutableLongByteMap);
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

        private LongByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongByteMapFactoryTest();
        }

        @java.lang.Override
        public LongByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
