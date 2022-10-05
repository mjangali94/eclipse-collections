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

import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectIntMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectIntHashMap(), ObjectIntMaps.mutable.of());
        Assert.assertEquals(ObjectIntMaps.mutable.of(), ObjectIntMaps.mutable.empty());
        Assert.assertEquals(ObjectIntMaps.mutable.of("2", 1), ObjectIntHashMap.newWithKeysValues("2", 1));
        Assert.assertEquals(ObjectIntMaps.mutable.of("2", 1, "4", 3), ObjectIntHashMap.newWithKeysValues("2", 1, "4", 3));
        Assert.assertEquals(ObjectIntMaps.mutable.of("2", 1, "4", 3, "6", 5), ObjectIntHashMap.newWithKeysValues("2", 1, "4", 3, "6", 5));
        Assert.assertEquals(ObjectIntMaps.mutable.of("2", 1, "4", 3, "6", 5, "8", 7), ObjectIntHashMap.newWithKeysValues("2", 1, "4", 3, "6", 5, "8", 7));
        Assert.assertEquals(ObjectIntMaps.mutable.empty().toImmutable(), ObjectIntMaps.immutable.empty());
        Assert.assertEquals(ObjectIntMaps.mutable.empty().toImmutable(), ObjectIntMaps.immutable.of());
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1).toImmutable(), ObjectIntMaps.immutable.of("2", 1));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectIntMaps.mutable.with(), ObjectIntMaps.mutable.empty());
        Assert.assertEquals(ObjectIntMaps.mutable.with("2", 1), ObjectIntHashMap.newWithKeysValues("2", 1));
        Assert.assertEquals(ObjectIntMaps.mutable.with("2", 1, "4", 3), ObjectIntHashMap.newWithKeysValues("2", 1, "4", 3));
        Assert.assertEquals(ObjectIntMaps.mutable.with("2", 1, "4", 3, "6", 5), ObjectIntHashMap.newWithKeysValues("2", 1, "4", 3, "6", 5));
        Assert.assertEquals(ObjectIntMaps.mutable.with("2", 1, "4", 3, "6", 5, "8", 7), ObjectIntHashMap.newWithKeysValues("2", 1, "4", 3, "6", 5, "8", 7));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectIntMaps.mutable.empty(), ObjectIntMaps.mutable.ofAll(ObjectIntMaps.mutable.empty()));
        Assert.assertEquals(ObjectIntMaps.mutable.empty().toImmutable(), ObjectIntMaps.immutable.ofAll(ObjectIntMaps.mutable.empty()));
        Assert.assertSame(ObjectIntMaps.immutable.empty(), ObjectIntMaps.immutable.ofAll(ObjectIntMaps.immutable.empty()));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1), ObjectIntMaps.mutable.ofAll(ObjectIntHashMap.newWithKeysValues("2", 1)));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1).toImmutable(), ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newWithKeysValues("2", 1)));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1, "3", 3).toImmutable(), ObjectIntMaps.immutable.ofAll(ObjectIntHashMap.newWithKeysValues("2", 1, "3", 3)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2, "3", 3), ObjectIntMaps.mutable.from(iterable, each -> each, Integer::valueOf));
        Assert.assertTrue(ObjectIntMaps.mutable.from(iterable, each -> each, Integer::valueOf) instanceof MutableObjectIntMap);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2, "3", 3), ObjectIntMaps.immutable.from(iterable, each -> each, Integer::valueOf));
        Assert.assertTrue(ObjectIntMaps.immutable.from(iterable, each -> each, Integer::valueOf) instanceof ImmutableObjectIntMap);
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

        private ObjectIntMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectIntMapFactoryTest();
        }

        @java.lang.Override
        public ObjectIntMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
