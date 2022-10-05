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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleObjectMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleObjectMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveObjectMapFactoryTest.stg.
 */
public class DoubleObjectMapFactoryTest {

    @Test
    public void empty() {
        Assert.assertSame(DoubleObjectMaps.immutable.with(), DoubleObjectMaps.immutable.empty());
        Assert.assertSame(DoubleObjectMaps.immutable.of(), DoubleObjectMaps.immutable.empty());
        Assert.assertEquals(DoubleObjectMaps.mutable.with(), DoubleObjectMaps.mutable.empty());
        Assert.assertEquals(DoubleObjectMaps.mutable.of(), DoubleObjectMaps.mutable.empty());
    }

    @Test
    public void of() {
        Assert.assertEquals(DoubleObjectMaps.mutable.with().toImmutable(), DoubleObjectMaps.immutable.of());
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1").toImmutable(), DoubleObjectMaps.immutable.of(1.0, "1"));
    }

    @Test
    public void ofAll() {
        Assert.assertEquals(DoubleObjectMaps.mutable.of(), DoubleObjectMaps.immutable.ofAll(DoubleObjectMaps.immutable.of()));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1"), DoubleObjectMaps.immutable.ofAll(DoubleObjectHashMap.newWithKeysValues(1.0, "1")));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1", 2.0, "2"), DoubleObjectMaps.immutable.ofAll(DoubleObjectHashMap.newWithKeysValues(1.0, "1", 2.0, "2")));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1", 2.0, "2"), DoubleObjectMaps.immutable.ofAll(DoubleObjectHashMap.newWithKeysValues(1.0, "1", 2.0, "2").toImmutable()));
        Assert.assertEquals(DoubleObjectMaps.mutable.empty(), DoubleObjectMaps.mutable.ofAll(DoubleObjectMaps.immutable.of()));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1"), DoubleObjectMaps.mutable.ofAll(DoubleObjectHashMap.newWithKeysValues(1.0, "1")));
    }

    @Test
    public void from() {
        Iterable<String> iterable = Lists.mutable.with("1", "2", "3");
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1", 2.0, "2", 3.0, "3"), DoubleObjectMaps.mutable.from(iterable, Double::valueOf, each -> each));
        Assert.assertTrue(DoubleObjectMaps.mutable.from(iterable, Double::valueOf, each -> each) instanceof MutableDoubleObjectMap);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1", 2.0, "2", 3.0, "3"), DoubleObjectMaps.immutable.from(iterable, Double::valueOf, each -> each));
        Assert.assertTrue(DoubleObjectMaps.immutable.from(iterable, Double::valueOf, each -> each) instanceof ImmutableDoubleObjectMap);
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

        private DoubleObjectMapFactoryTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleObjectMapFactoryTest();
        }

        @java.lang.Override
        public DoubleObjectMapFactoryTest implementation() {
            return this.implementation;
        }
    }
}
