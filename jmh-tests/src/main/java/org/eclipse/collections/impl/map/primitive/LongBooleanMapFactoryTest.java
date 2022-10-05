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

import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.api.map.primitive.MutableLongBooleanMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveBooleanMapFactoryTest.stg.
 */
public class LongBooleanMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new LongBooleanHashMap().toImmutable(), LongBooleanMaps.immutable.of());
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, true).toImmutable(), LongBooleanMaps.immutable.of(1L, true));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(new LongBooleanHashMap().toImmutable(), LongBooleanMaps.immutable.ofAll(LongBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll() {
        Assert.assertEquals(new LongBooleanHashMap().toImmutable(), LongBooleanMaps.immutable.withAll(LongBooleanMaps.immutable.of()));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true, 3L, false), LongBooleanMaps.mutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(LongBooleanMaps.mutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof MutableLongBooleanMap);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true, 3L, false), LongBooleanMaps.immutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0));
        Assert.assertTrue(LongBooleanMaps.immutable.from(iterable, Long::valueOf, each -> Integer.valueOf(each) % 2 == 0) instanceof ImmutableLongBooleanMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ofAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ofAll, this.description("ofAll"));
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

        private LongBooleanMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongBooleanMapFactoryTest();
        }

        @java.lang.Override
        public LongBooleanMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
