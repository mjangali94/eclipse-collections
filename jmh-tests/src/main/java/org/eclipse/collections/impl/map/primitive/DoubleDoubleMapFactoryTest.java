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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitivePrimitiveMapFactoryTest.stg.
 */
public class DoubleDoubleMapFactoryTest {

    @Test
    public void of() {
        Verify.assertEmpty(DoubleDoubleMaps.immutable.of());
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0).toImmutable(), DoubleDoubleMaps.immutable.of(1.0, 1.0));
    }

    @Test
    public void withAll() {
        ImmutableDoubleDoubleMap map = DoubleDoubleMaps.immutable.of();
        Assert.assertEquals(DoubleDoubleMaps.mutable.empty().toImmutable(), DoubleDoubleMaps.immutable.withAll(map));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0), DoubleDoubleMaps.mutable.from(iterable, Double::valueOf, Double::valueOf));
        Assert.assertTrue(DoubleDoubleMaps.mutable.from(iterable, Double::valueOf, Double::valueOf) instanceof MutableDoubleDoubleMap);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0), DoubleDoubleMaps.immutable.from(iterable, Double::valueOf, Double::valueOf));
        Assert.assertTrue(DoubleDoubleMaps.immutable.from(iterable, Double::valueOf, Double::valueOf) instanceof ImmutableDoubleDoubleMap);
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

        private DoubleDoubleMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleDoubleMapFactoryTest();
        }

        @java.lang.Override
        public DoubleDoubleMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
