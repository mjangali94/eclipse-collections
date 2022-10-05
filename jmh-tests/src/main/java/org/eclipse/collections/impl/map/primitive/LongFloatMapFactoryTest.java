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

import org.eclipse.collections.api.map.primitive.ImmutableLongFloatMap;
import org.eclipse.collections.api.map.primitive.MutableLongFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongFloatMaps.immutable.of());
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f).toImmutable(), LongFloatMaps.immutable.of(1L, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableLongFloatMap map = LongFloatMaps.immutable.of();
        Assert.assertEquals(LongFloatMaps.mutable.empty().toImmutable(), LongFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f), LongFloatMaps.mutable.from(iterable, Long::valueOf, Float::valueOf));
        Assert.assertTrue(LongFloatMaps.mutable.from(iterable, Long::valueOf, Float::valueOf) instanceof MutableLongFloatMap);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f), LongFloatMaps.immutable.from(iterable, Long::valueOf, Float::valueOf));
        Assert.assertTrue(LongFloatMaps.immutable.from(iterable, Long::valueOf, Float::valueOf) instanceof ImmutableLongFloatMap);
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

        private LongFloatMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongFloatMapFactoryTest();
        }

        @java.lang.Override
        public LongFloatMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
