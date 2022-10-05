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

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class IntObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(IntObjectMaps.immutable.with(), IntObjectMaps.immutable.empty());
        Assert.assertSame(IntObjectMaps.immutable.of(), IntObjectMaps.immutable.empty());
        Assert.assertEquals(IntObjectMaps.mutable.with(), IntObjectMaps.mutable.empty());
        Assert.assertEquals(IntObjectMaps.mutable.of(), IntObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(IntObjectMaps.mutable.with().toImmutable(), IntObjectMaps.immutable.of());
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1").toImmutable(), IntObjectMaps.immutable.of(1, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(IntObjectMaps.mutable.of(), IntObjectMaps.immutable.ofAll(IntObjectMaps.immutable.of()));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1"), IntObjectMaps.immutable.ofAll(IntObjectHashMap.newWithKeysValues(1, "1")));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1", 2, "2"), IntObjectMaps.immutable.ofAll(IntObjectHashMap.newWithKeysValues(1, "1", 2, "2")));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1", 2, "2"), IntObjectMaps.immutable.ofAll(IntObjectHashMap.newWithKeysValues(1, "1", 2, "2").toImmutable()));
        Assert.assertEquals(IntObjectMaps.mutable.empty(), IntObjectMaps.mutable.ofAll(IntObjectMaps.immutable.of()));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1"), IntObjectMaps.mutable.ofAll(IntObjectHashMap.newWithKeysValues(1, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), IntObjectMaps.mutable.from(iterable, Integer::valueOf, each -> each));
        Assert.assertTrue(IntObjectMaps.mutable.from(iterable, Integer::valueOf, each -> each) instanceof MutableIntObjectMap);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1", 2, "2", 3, "3"), IntObjectMaps.immutable.from(iterable, Integer::valueOf, each -> each));
        Assert.assertTrue(IntObjectMaps.immutable.from(iterable, Integer::valueOf, each -> each) instanceof ImmutableIntObjectMap);
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

        private IntObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntObjectMapFactoryTest();
        }

        @java.lang.Override
        public IntObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
