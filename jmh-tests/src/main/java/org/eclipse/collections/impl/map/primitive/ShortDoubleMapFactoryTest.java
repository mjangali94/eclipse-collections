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

import org.eclipse.collections.api.map.primitive.ImmutableShortDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableShortDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class ShortDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(ShortDoubleMaps.immutable.of());
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0).toImmutable(), ShortDoubleMaps.immutable.of((short) 1, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableShortDoubleMap map = ShortDoubleMaps.immutable.of();
        Assert.assertEquals(ShortDoubleMaps.mutable.empty().toImmutable(), ShortDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0), ShortDoubleMaps.mutable.from(iterable, Short::valueOf, Double::valueOf));
        Assert.assertTrue(ShortDoubleMaps.mutable.from(iterable, Short::valueOf, Double::valueOf) instanceof MutableShortDoubleMap);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0), ShortDoubleMaps.immutable.from(iterable, Short::valueOf, Double::valueOf));
        Assert.assertTrue(ShortDoubleMaps.immutable.from(iterable, Short::valueOf, Double::valueOf) instanceof ImmutableShortDoubleMap);
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

        private ShortDoubleMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortDoubleMapFactoryTest();
        }

        @java.lang.Override
        public ShortDoubleMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
