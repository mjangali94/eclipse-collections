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

import org.eclipse.collections.api.map.primitive.ImmutableFloatByteMap;
import org.eclipse.collections.api.map.primitive.MutableFloatByteMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class FloatByteMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(FloatByteMaps.immutable.of());
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1).toImmutable(), FloatByteMaps.immutable.of(1.0f, (byte) 1));
    }

    @Test
    public void withAll() {
        ImmutableFloatByteMap map = FloatByteMaps.immutable.of();
        Assert.assertEquals(FloatByteMaps.mutable.empty().toImmutable(), FloatByteMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3), FloatByteMaps.mutable.from(iterable, Float::valueOf, Byte::valueOf));
        Assert.assertTrue(FloatByteMaps.mutable.from(iterable, Float::valueOf, Byte::valueOf) instanceof MutableFloatByteMap);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3), FloatByteMaps.immutable.from(iterable, Float::valueOf, Byte::valueOf));
        Assert.assertTrue(FloatByteMaps.immutable.from(iterable, Float::valueOf, Byte::valueOf) instanceof ImmutableFloatByteMap);
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

        private FloatByteMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatByteMapFactoryTest();
        }

        @java.lang.Override
        public FloatByteMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
