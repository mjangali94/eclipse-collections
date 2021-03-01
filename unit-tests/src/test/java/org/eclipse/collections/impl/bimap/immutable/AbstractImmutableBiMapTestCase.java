/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.immutable;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.map.immutable.ImmutableMapIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableBiMapTestCase extends ImmutableMapIterableTestCase {

    @Override
    protected abstract ImmutableBiMap<Integer, String> classUnderTest();

    protected abstract ImmutableBiMap<Integer, String> newEmpty();

    protected abstract ImmutableBiMap<Integer, String> newWithMap();

    protected abstract ImmutableBiMap<Integer, String> newWithHashBiMap();

    protected abstract ImmutableBiMap<Integer, String> newWithImmutableMap();

    @Override
    protected int size() {
        return 4;
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void testNewEmpty() {
        Assert.assertTrue(this.newEmpty().isEmpty());
    }

    @Test
    public void testNewWithMap() {
        Assert.assertEquals(this.classUnderTest(), this.newWithMap());
    }

    @Test
    public void testNewWithHashBiMap() {
        Assert.assertEquals(this.classUnderTest(), this.newWithHashBiMap());
    }

    @Test
    public void testNewWithImmutableMap() {
        Assert.assertEquals(this.classUnderTest(), this.newWithImmutableMap());
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey(1));
        Assert.assertFalse(this.classUnderTest().containsKey(5));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
    }

    @Test
    public void toMapTarget() {
        ImmutableBiMap<String, String> immutableBiMap = BiMaps.immutable.with("1", "1", "2", "2", "3", "3", "4", "4");
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("1", "1");
        expectedMap.put("2", "2");
        expectedMap.put("3", "3");
        expectedMap.put("4", "4");
        Map<String, String> actualMap = (Map<String, String>) immutableBiMap.toMap(Functions.getPassThru(), Functions.getPassThru(), expectedMap);
        Assert.assertEquals(expectedMap, actualMap);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewEmpty, this.description("testNewEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWithMap, this.description("testNewWithMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithHashBiMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWithHashBiMap, this.description("testNewWithHashBiMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithImmutableMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNewWithImmutableMap, this.description("testNewWithImmutableMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMapTarget, this.description("toMapTarget"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractImmutableBiMapTestCase implementation();
    }
}
