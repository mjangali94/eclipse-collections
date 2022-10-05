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

import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortIntMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortIntMaps.immutable.of());
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1).toImmutable(), ShortIntMaps.immutable.of((short) 1, 1));
    }

    @Test
    public void withAll() {
        ImmutableShortIntMap map = ShortIntMaps.immutable.of();
        Assert.assertEquals(ShortIntMaps.mutable.empty().toImmutable(), ShortIntMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3), ShortIntMaps.mutable.from(iterable, Short::valueOf, Integer::valueOf));
        Assert.assertTrue(ShortIntMaps.mutable.from(iterable, Short::valueOf, Integer::valueOf) instanceof MutableShortIntMap);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3), ShortIntMaps.immutable.from(iterable, Short::valueOf, Integer::valueOf));
        Assert.assertTrue(ShortIntMaps.immutable.from(iterable, Short::valueOf, Integer::valueOf) instanceof ImmutableShortIntMap);
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

        private ShortIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortIntMapFactoryTest();
        }

        @java.lang.Override
        public ShortIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
