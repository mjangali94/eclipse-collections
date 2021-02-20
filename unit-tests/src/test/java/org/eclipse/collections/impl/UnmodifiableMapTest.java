/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.List;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnmodifiableMapTest {

    private static final String ROCK_OUT = "Bands that Rock";

    private static final String NAP_TIME = "Bands than Don't";

    private static final MutableList<String> MASTERS_OF_ROCK = Lists.mutable.of("Nine Inch Nails", "Soundgarden", "White Zombie", "Radiohead");

    private MutableMap<String, List<String>> mutableMap;

    private UnmodifiableMap<String, List<String>> unmodifiableMap;

    @Before
    public void setUp() {
        this.mutableMap = Maps.mutable.of(ROCK_OUT, MASTERS_OF_ROCK, NAP_TIME, Lists.mutable.of("Metallica", "Bon Jovi", "Europe", "Scorpions"));
        this.unmodifiableMap = new UnmodifiableMap<>(this.mutableMap);
    }

    @Test
    public void testNullConstructorArgument() {
        Assert.assertThrows(NullPointerException.class, () -> new UnmodifiableMap<>(null));
    }

    @Test
    public void testSize() {
        Verify.assertSize(this.mutableMap.size(), this.unmodifiableMap);
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(this.mutableMap.isEmpty(), this.unmodifiableMap.isEmpty());
    }

    @Test
    public void testContainsKey() {
        Assert.assertTrue(this.unmodifiableMap.containsKey(ROCK_OUT));
    }

    @Test
    public void testContainsValue() {
        Assert.assertTrue(this.unmodifiableMap.containsValue(MASTERS_OF_ROCK));
    }

    @Test
    public void testGet() {
        Assert.assertEquals(MASTERS_OF_ROCK, this.unmodifiableMap.get(ROCK_OUT));
    }

    @Test
    public void testPut() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableMap.put("foo", Lists.mutable.of()));
    }

    @Test
    public void testRemove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableMap.remove(ROCK_OUT));
    }

    @Test
    public void testPutAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.unmodifiableMap.putAll(Maps.mutable.of()));
    }

    @Test
    public void testClear() {
        Assert.assertThrows(UnsupportedOperationException.class, this.unmodifiableMap::clear);
    }

    @Test
    public void testKeySet() {
        Assert.assertEquals(this.mutableMap.keySet(), this.unmodifiableMap.keySet());
    }

    @Test
    public void testValues() {
        Verify.assertContainsAll(this.mutableMap.values(), this.unmodifiableMap.values().toArray());
    }

    @Test
    public void testEntrySet() {
        Assert.assertEquals(this.mutableMap.entrySet(), this.unmodifiableMap.entrySet());
    }

    @Test
    public void testToString() {
        Assert.assertEquals(this.mutableMap.toString(), this.unmodifiableMap.toString());
    }

    @Test
    public void testMutableTransparency() {
        this.mutableMap.remove(NAP_TIME);
        Verify.assertSize(this.mutableMap.size(), this.unmodifiableMap);
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.mutableMap, this.unmodifiableMap);
    }

    @Test(expected = NullPointerException.class)
    public void notNull() {
        new UnmodifiableMap<>(null);
    }

    @Test
    public void entrySetsEqual() {
        Verify.assertEqualsAndHashCode(this.mutableMap.entrySet(), this.unmodifiableMap.entrySet());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNullConstructorArgument() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testNullConstructorArgument, this.description("testNullConstructorArgument"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testSize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testSize, this.description("testSize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testIsEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testIsEmpty, this.description("testIsEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testContainsKey, this.description("testContainsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testContainsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testContainsValue, this.description("testContainsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testGet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testGet, this.description("testGet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testPut, this.description("testPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testRemove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testRemove, this.description("testRemove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testPutAll, this.description("testPutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testClear, this.description("testClear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testKeySet, this.description("testKeySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testValues, this.description("testValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEntrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEntrySet, this.description("testEntrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testMutableTransparency() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testMutableTransparency, this.description("testMutableTransparency"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notNull() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::notNull, this.description("notNull"), java.lang.NullPointerException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySetsEqual() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::entrySetsEqual, this.description("entrySetsEqual"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        private UnmodifiableMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableMapTest();
        }

        @java.lang.Override
        public UnmodifiableMapTest implementation() {
            return this.implementation;
        }
    }
}
