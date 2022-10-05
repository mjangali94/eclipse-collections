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

import org.eclipse.collections.api.map.primitive.ImmutableIntLongMap;
import org.eclipse.collections.api.map.primitive.MutableIntLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class IntLongMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(IntLongMaps.immutable.of());
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L).toImmutable(), IntLongMaps.immutable.of(1, 1L));
    }

    @Test
    public void withAll() {
        ImmutableIntLongMap map = IntLongMaps.immutable.of();
        Assert.assertEquals(IntLongMaps.mutable.empty().toImmutable(), IntLongMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L), IntLongMaps.mutable.from(iterable, Integer::valueOf, Long::valueOf));
        Assert.assertTrue(IntLongMaps.mutable.from(iterable, Integer::valueOf, Long::valueOf) instanceof MutableIntLongMap);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L), IntLongMaps.immutable.from(iterable, Integer::valueOf, Long::valueOf));
        Assert.assertTrue(IntLongMaps.immutable.from(iterable, Integer::valueOf, Long::valueOf) instanceof ImmutableIntLongMap);
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

        private IntLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntLongMapFactoryTest();
        }

        @java.lang.Override
        public IntLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
