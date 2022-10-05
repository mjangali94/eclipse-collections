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

import org.eclipse.collections.api.map.primitive.ImmutableIntByteMap;
import org.eclipse.collections.api.map.primitive.MutableIntByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class IntByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntByteMaps.immutable.of());
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1).toImmutable(), IntByteMaps.immutable.of(1, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableIntByteMap map = IntByteMaps.immutable.of();
        Assert.assertEquals(IntByteMaps.mutable.empty().toImmutable(), IntByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3), IntByteMaps.mutable.from(iterable, Integer::valueOf, Byte::valueOf));
        Assert.assertTrue(IntByteMaps.mutable.from(iterable, Integer::valueOf, Byte::valueOf) instanceof MutableIntByteMap);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3), IntByteMaps.immutable.from(iterable, Integer::valueOf, Byte::valueOf));
        Assert.assertTrue(IntByteMaps.immutable.from(iterable, Integer::valueOf, Byte::valueOf) instanceof ImmutableIntByteMap);
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

        private IntByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntByteMapFactoryTest();
        }

        @java.lang.Override
        public IntByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
