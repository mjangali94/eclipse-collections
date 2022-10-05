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

import org.eclipse.collections.api.map.primitive.ImmutableFloatLongMap;
import org.eclipse.collections.api.map.primitive.MutableFloatLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class FloatLongMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(FloatLongMaps.immutable.of());
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L).toImmutable(), FloatLongMaps.immutable.of(1.0f, 1L));
    }

    @Test
    public void withAll() {
        ImmutableFloatLongMap map = FloatLongMaps.immutable.of();
        Assert.assertEquals(FloatLongMaps.mutable.empty().toImmutable(), FloatLongMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L, 2.0f, 2L, 3.0f, 3L), FloatLongMaps.mutable.from(iterable, Float::valueOf, Long::valueOf));
        Assert.assertTrue(FloatLongMaps.mutable.from(iterable, Float::valueOf, Long::valueOf) instanceof MutableFloatLongMap);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L, 2.0f, 2L, 3.0f, 3L), FloatLongMaps.immutable.from(iterable, Float::valueOf, Long::valueOf));
        Assert.assertTrue(FloatLongMaps.immutable.from(iterable, Float::valueOf, Long::valueOf) instanceof ImmutableFloatLongMap);
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

        private FloatLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatLongMapFactoryTest();
        }

        @java.lang.Override
        public FloatLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
