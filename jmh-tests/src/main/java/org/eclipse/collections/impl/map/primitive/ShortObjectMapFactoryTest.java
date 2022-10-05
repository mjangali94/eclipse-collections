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

import org.eclipse.collections.api.map.primitive.ImmutableShortObjectMap;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class ShortObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(ShortObjectMaps.immutable.with(), ShortObjectMaps.immutable.empty());
        Assert.assertSame(ShortObjectMaps.immutable.of(), ShortObjectMaps.immutable.empty());
        Assert.assertEquals(ShortObjectMaps.mutable.with(), ShortObjectMaps.mutable.empty());
        Assert.assertEquals(ShortObjectMaps.mutable.of(), ShortObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(ShortObjectMaps.mutable.with().toImmutable(), ShortObjectMaps.immutable.of());
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1").toImmutable(), ShortObjectMaps.immutable.of((short) 1, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ShortObjectMaps.mutable.of(), ShortObjectMaps.immutable.ofAll(ShortObjectMaps.immutable.of()));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1"), ShortObjectMaps.immutable.ofAll(ShortObjectHashMap.newWithKeysValues((short) 1, "1")));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1", (short) 2, "2"), ShortObjectMaps.immutable.ofAll(ShortObjectHashMap.newWithKeysValues((short) 1, "1", (short) 2, "2")));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1", (short) 2, "2"), ShortObjectMaps.immutable.ofAll(ShortObjectHashMap.newWithKeysValues((short) 1, "1", (short) 2, "2").toImmutable()));
        Assert.assertEquals(ShortObjectMaps.mutable.empty(), ShortObjectMaps.mutable.ofAll(ShortObjectMaps.immutable.of()));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1"), ShortObjectMaps.mutable.ofAll(ShortObjectHashMap.newWithKeysValues((short) 1, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1", (short) 2, "2", (short) 3, "3"), ShortObjectMaps.mutable.from(iterable, Short::valueOf, each -> each));
        Assert.assertTrue(ShortObjectMaps.mutable.from(iterable, Short::valueOf, each -> each) instanceof MutableShortObjectMap);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1", (short) 2, "2", (short) 3, "3"), ShortObjectMaps.immutable.from(iterable, Short::valueOf, each -> each));
        Assert.assertTrue(ShortObjectMaps.immutable.from(iterable, Short::valueOf, each -> each) instanceof ImmutableShortObjectMap);
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

        private ShortObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortObjectMapFactoryTest();
        }

        @java.lang.Override
        public ShortObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
