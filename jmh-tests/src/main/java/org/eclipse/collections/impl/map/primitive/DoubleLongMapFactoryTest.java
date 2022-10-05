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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleLongMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class DoubleLongMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(DoubleLongMaps.immutable.of());
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L).toImmutable(), DoubleLongMaps.immutable.of(1.0, 1L));
    }

    @Test
    public void withAll() {
        ImmutableDoubleLongMap map = DoubleLongMaps.immutable.of();
        Assert.assertEquals(DoubleLongMaps.mutable.empty().toImmutable(), DoubleLongMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L), DoubleLongMaps.mutable.from(iterable, Double::valueOf, Long::valueOf));
        Assert.assertTrue(DoubleLongMaps.mutable.from(iterable, Double::valueOf, Long::valueOf) instanceof MutableDoubleLongMap);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L), DoubleLongMaps.immutable.from(iterable, Double::valueOf, Long::valueOf));
        Assert.assertTrue(DoubleLongMaps.immutable.from(iterable, Double::valueOf, Long::valueOf) instanceof ImmutableDoubleLongMap);
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

        private DoubleLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleLongMapFactoryTest();
        }

        @java.lang.Override
        public DoubleLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
