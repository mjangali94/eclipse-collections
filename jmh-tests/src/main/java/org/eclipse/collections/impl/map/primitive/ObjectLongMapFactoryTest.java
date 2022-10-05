/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectLongMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectLongHashMap(), ObjectLongMaps.mutable.of());
        Assert.assertEquals(ObjectLongMaps.mutable.of(), ObjectLongMaps.mutable.empty());
        Assert.assertEquals(ObjectLongMaps.mutable.of("2", 1L), ObjectLongHashMap.newWithKeysValues("2", 1L));
        Assert.assertEquals(ObjectLongMaps.mutable.of("2", 1L, "4", 3L), ObjectLongHashMap.newWithKeysValues("2", 1L, "4", 3L));
        Assert.assertEquals(ObjectLongMaps.mutable.of("2", 1L, "4", 3L, "6", 5L), ObjectLongHashMap.newWithKeysValues("2", 1L, "4", 3L, "6", 5L));
        Assert.assertEquals(ObjectLongMaps.mutable.of("2", 1L, "4", 3L, "6", 5L, "8", 7L), ObjectLongHashMap.newWithKeysValues("2", 1L, "4", 3L, "6", 5L, "8", 7L));
        Assert.assertEquals(ObjectLongMaps.mutable.empty().toImmutable(), ObjectLongMaps.immutable.empty());
        Assert.assertEquals(ObjectLongMaps.mutable.empty().toImmutable(), ObjectLongMaps.immutable.of());
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L).toImmutable(), ObjectLongMaps.immutable.of("2", 1L));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectLongMaps.mutable.with(), ObjectLongMaps.mutable.empty());
        Assert.assertEquals(ObjectLongMaps.mutable.with("2", 1L), ObjectLongHashMap.newWithKeysValues("2", 1L));
        Assert.assertEquals(ObjectLongMaps.mutable.with("2", 1L, "4", 3L), ObjectLongHashMap.newWithKeysValues("2", 1L, "4", 3L));
        Assert.assertEquals(ObjectLongMaps.mutable.with("2", 1L, "4", 3L, "6", 5L), ObjectLongHashMap.newWithKeysValues("2", 1L, "4", 3L, "6", 5L));
        Assert.assertEquals(ObjectLongMaps.mutable.with("2", 1L, "4", 3L, "6", 5L, "8", 7L), ObjectLongHashMap.newWithKeysValues("2", 1L, "4", 3L, "6", 5L, "8", 7L));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectLongMaps.mutable.empty(), ObjectLongMaps.mutable.ofAll(ObjectLongMaps.mutable.empty()));
        Assert.assertEquals(ObjectLongMaps.mutable.empty().toImmutable(), ObjectLongMaps.immutable.ofAll(ObjectLongMaps.mutable.empty()));
        Assert.assertSame(ObjectLongMaps.immutable.empty(), ObjectLongMaps.immutable.ofAll(ObjectLongMaps.immutable.empty()));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L), ObjectLongMaps.mutable.ofAll(ObjectLongHashMap.newWithKeysValues("2", 1L)));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L).toImmutable(), ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newWithKeysValues("2", 1L)));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L, "3", 3L).toImmutable(), ObjectLongMaps.immutable.ofAll(ObjectLongHashMap.newWithKeysValues("2", 1L, "3", 3L)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L, "3", 3L), ObjectLongMaps.mutable.from(iterable, each -> each, Long::valueOf));
        Assert.assertTrue(ObjectLongMaps.mutable.from(iterable, each -> each, Long::valueOf) instanceof MutableObjectLongMap);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L, "3", 3L), ObjectLongMaps.immutable.from(iterable, each -> each, Long::valueOf));
        Assert.assertTrue(ObjectLongMaps.immutable.from(iterable, each -> each, Long::valueOf) instanceof ImmutableObjectLongMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_of() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::of, this.description("of"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::with, this.description("with"));
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

        private ObjectLongMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectLongMapFactoryTest();
        }

        @java.lang.Override
        public ObjectLongMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
