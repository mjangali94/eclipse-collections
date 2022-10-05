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

import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class LongObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(LongObjectMaps.immutable.with(), LongObjectMaps.immutable.empty());
        Assert.assertSame(LongObjectMaps.immutable.of(), LongObjectMaps.immutable.empty());
        Assert.assertEquals(LongObjectMaps.mutable.with(), LongObjectMaps.mutable.empty());
        Assert.assertEquals(LongObjectMaps.mutable.of(), LongObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(LongObjectMaps.mutable.with().toImmutable(), LongObjectMaps.immutable.of());
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1").toImmutable(), LongObjectMaps.immutable.of(1L, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(LongObjectMaps.mutable.of(), LongObjectMaps.immutable.ofAll(LongObjectMaps.immutable.of()));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1"), LongObjectMaps.immutable.ofAll(LongObjectHashMap.newWithKeysValues(1L, "1")));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1", 2L, "2"), LongObjectMaps.immutable.ofAll(LongObjectHashMap.newWithKeysValues(1L, "1", 2L, "2")));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1", 2L, "2"), LongObjectMaps.immutable.ofAll(LongObjectHashMap.newWithKeysValues(1L, "1", 2L, "2").toImmutable()));
        Assert.assertEquals(LongObjectMaps.mutable.empty(), LongObjectMaps.mutable.ofAll(LongObjectMaps.immutable.of()));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1"), LongObjectMaps.mutable.ofAll(LongObjectHashMap.newWithKeysValues(1L, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1", 2L, "2", 3L, "3"), LongObjectMaps.mutable.from(iterable, Long::valueOf, each -> each));
        Assert.assertTrue(LongObjectMaps.mutable.from(iterable, Long::valueOf, each -> each) instanceof MutableLongObjectMap);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1", 2L, "2", 3L, "3"), LongObjectMaps.immutable.from(iterable, Long::valueOf, each -> each));
        Assert.assertTrue(LongObjectMaps.immutable.from(iterable, Long::valueOf, each -> each) instanceof ImmutableLongObjectMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

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
        public void benchmark_from() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::from, this.description("from"));
        }

        private LongObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongObjectMapFactoryTest();
        }

        @java.lang.Override
        public LongObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
