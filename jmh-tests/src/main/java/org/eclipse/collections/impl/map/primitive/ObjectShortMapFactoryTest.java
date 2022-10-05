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

import org.eclipse.collections.api.map.primitive.ImmutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ObjectShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file objectPrimitiveMapFactoryTest.stg.
 */
public class ObjectShortMapFactoryTest {

    @Test
    public void of() {
        Assert.assertEquals(new ObjectShortHashMap(), ObjectShortMaps.mutable.of());
        Assert.assertEquals(ObjectShortMaps.mutable.of(), ObjectShortMaps.mutable.empty());
        Assert.assertEquals(ObjectShortMaps.mutable.of("2", (short) 1), ObjectShortHashMap.newWithKeysValues("2", (short) 1));
        Assert.assertEquals(ObjectShortMaps.mutable.of("2", (short) 1, "4", (short) 3), ObjectShortHashMap.newWithKeysValues("2", (short) 1, "4", (short) 3));
        Assert.assertEquals(ObjectShortMaps.mutable.of("2", (short) 1, "4", (short) 3, "6", (short) 5), ObjectShortHashMap.newWithKeysValues("2", (short) 1, "4", (short) 3, "6", (short) 5));
        Assert.assertEquals(ObjectShortMaps.mutable.of("2", (short) 1, "4", (short) 3, "6", (short) 5, "8", (short) 7), ObjectShortHashMap.newWithKeysValues("2", (short) 1, "4", (short) 3, "6", (short) 5, "8", (short) 7));
        Assert.assertEquals(ObjectShortMaps.mutable.empty().toImmutable(), ObjectShortMaps.immutable.empty());
        Assert.assertEquals(ObjectShortMaps.mutable.empty().toImmutable(), ObjectShortMaps.immutable.of());
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 1).toImmutable(), ObjectShortMaps.immutable.of("2", (short) 1));
    }

    @Test
    public void with() {
        Assert.assertEquals(ObjectShortMaps.mutable.with(), ObjectShortMaps.mutable.empty());
        Assert.assertEquals(ObjectShortMaps.mutable.with("2", (short) 1), ObjectShortHashMap.newWithKeysValues("2", (short) 1));
        Assert.assertEquals(ObjectShortMaps.mutable.with("2", (short) 1, "4", (short) 3), ObjectShortHashMap.newWithKeysValues("2", (short) 1, "4", (short) 3));
        Assert.assertEquals(ObjectShortMaps.mutable.with("2", (short) 1, "4", (short) 3, "6", (short) 5), ObjectShortHashMap.newWithKeysValues("2", (short) 1, "4", (short) 3, "6", (short) 5));
        Assert.assertEquals(ObjectShortMaps.mutable.with("2", (short) 1, "4", (short) 3, "6", (short) 5, "8", (short) 7), ObjectShortHashMap.newWithKeysValues("2", (short) 1, "4", (short) 3, "6", (short) 5, "8", (short) 7));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(ObjectShortMaps.mutable.empty(), ObjectShortMaps.mutable.ofAll(ObjectShortMaps.mutable.empty()));
        Assert.assertEquals(ObjectShortMaps.mutable.empty().toImmutable(), ObjectShortMaps.immutable.ofAll(ObjectShortMaps.mutable.empty()));
        Assert.assertSame(ObjectShortMaps.immutable.empty(), ObjectShortMaps.immutable.ofAll(ObjectShortMaps.immutable.empty()));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 1), ObjectShortMaps.mutable.ofAll(ObjectShortHashMap.newWithKeysValues("2", (short) 1)));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 1).toImmutable(), ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newWithKeysValues("2", (short) 1)));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 1, "3", (short) 3).toImmutable(), ObjectShortMaps.immutable.ofAll(ObjectShortHashMap.newWithKeysValues("2", (short) 1, "3", (short) 3)));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2, "3", (short) 3), ObjectShortMaps.mutable.from(iterable, each -> each, Short::valueOf));
        Assert.assertTrue(ObjectShortMaps.mutable.from(iterable, each -> each, Short::valueOf) instanceof MutableObjectShortMap);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2, "3", (short) 3), ObjectShortMaps.immutable.from(iterable, each -> each, Short::valueOf));
        Assert.assertTrue(ObjectShortMaps.immutable.from(iterable, each -> each, Short::valueOf) instanceof ImmutableObjectShortMap);
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

        private ObjectShortMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectShortMapFactoryTest();
        }

        @java.lang.Override
        public ObjectShortMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
