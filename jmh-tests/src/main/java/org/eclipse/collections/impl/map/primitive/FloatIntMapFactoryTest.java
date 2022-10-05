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

import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.api.map.primitive.MutableFloatIntMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class FloatIntMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(FloatIntMaps.immutable.of());
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1).toImmutable(), FloatIntMaps.immutable.of(1.0f, 1));
    }

    @Test
    public void withAll() {
        ImmutableFloatIntMap map = FloatIntMaps.immutable.of();
        Assert.assertEquals(FloatIntMaps.mutable.empty().toImmutable(), FloatIntMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3), FloatIntMaps.mutable.from(iterable, Float::valueOf, Integer::valueOf));
        Assert.assertTrue(FloatIntMaps.mutable.from(iterable, Float::valueOf, Integer::valueOf) instanceof MutableFloatIntMap);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3), FloatIntMaps.immutable.from(iterable, Float::valueOf, Integer::valueOf));
        Assert.assertTrue(FloatIntMaps.immutable.from(iterable, Float::valueOf, Integer::valueOf) instanceof ImmutableFloatIntMap);
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

        private FloatIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatIntMapFactoryTest();
        }

        @java.lang.Override
        public FloatIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
