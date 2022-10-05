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

import org.eclipse.collections.api.map.primitive.ImmutableLongIntMap;
import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class LongIntMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(LongIntMaps.immutable.of());
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1).toImmutable(), LongIntMaps.immutable.of(1L, 1));
    }

    @Test
    public void withAll() {
        ImmutableLongIntMap map = LongIntMaps.immutable.of();
        Assert.assertEquals(LongIntMaps.mutable.empty().toImmutable(), LongIntMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), LongIntMaps.mutable.from(iterable, Long::valueOf, Integer::valueOf));
        Assert.assertTrue(LongIntMaps.mutable.from(iterable, Long::valueOf, Integer::valueOf) instanceof MutableLongIntMap);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), LongIntMaps.immutable.from(iterable, Long::valueOf, Integer::valueOf));
        Assert.assertTrue(LongIntMaps.immutable.from(iterable, Long::valueOf, Integer::valueOf) instanceof ImmutableLongIntMap);
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

        private LongIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongIntMapFactoryTest();
        }

        @java.lang.Override
        public LongIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
