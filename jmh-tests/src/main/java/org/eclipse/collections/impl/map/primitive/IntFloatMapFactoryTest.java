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

import org.eclipse.collections.api.map.primitive.ImmutableIntFloatMap;
import org.eclipse.collections.api.map.primitive.MutableIntFloatMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class IntFloatMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntFloatMaps.immutable.of());
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f).toImmutable(), IntFloatMaps.immutable.of(1, 1.0f));
    }

    @Test
    public void withAll() {
        ImmutableIntFloatMap map = IntFloatMaps.immutable.of();
        Assert.assertEquals(IntFloatMaps.mutable.empty().toImmutable(), IntFloatMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f), IntFloatMaps.mutable.from(iterable, Integer::valueOf, Float::valueOf));
        Assert.assertTrue(IntFloatMaps.mutable.from(iterable, Integer::valueOf, Float::valueOf) instanceof MutableIntFloatMap);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f), IntFloatMaps.immutable.from(iterable, Integer::valueOf, Float::valueOf));
        Assert.assertTrue(IntFloatMaps.immutable.from(iterable, Integer::valueOf, Float::valueOf) instanceof ImmutableIntFloatMap);
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

        private IntFloatMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntFloatMapFactoryTest();
        }

        @java.lang.Override
        public IntFloatMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
