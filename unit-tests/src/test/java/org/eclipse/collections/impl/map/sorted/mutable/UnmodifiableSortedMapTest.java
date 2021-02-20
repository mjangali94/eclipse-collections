/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.sorted.mutable;

import java.util.Map;
import java.util.TreeMap;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class UnmodifiableSortedMapTest {

    private final UnmodifiableSortedMap<Integer, String> map = new UnmodifiableSortedMap<>(new TreeMap<>(SortedMaps.mutable.of(1, "1", 2, "2", 3, "3", 4, "4")));

    private final UnmodifiableSortedMap<Integer, String> revMap = new UnmodifiableSortedMap<>(new TreeMap<>(SortedMaps.mutable.of(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3", 4, "4")));

    @Test
    public void comparator() {
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), this.revMap.comparator());
    }

    @Test
    public void subMap() {
        Verify.assertInstanceOf(UnmodifiableSortedMap.class, this.map.subMap(1, 3));
        this.checkMutability(this.map.subMap(1, 3));
    }

    @Test
    public void headMap() {
        Verify.assertInstanceOf(UnmodifiableSortedMap.class, this.map.headMap(3));
        this.checkMutability(this.map.headMap(3));
    }

    @Test
    public void tailMap() {
        Verify.assertInstanceOf(UnmodifiableSortedMap.class, this.map.tailMap(2));
        this.checkMutability(this.map.tailMap(2));
    }

    @Test
    public void firstKey() {
        Assert.assertEquals(1, this.map.firstKey().intValue());
        Assert.assertEquals(4, this.revMap.firstKey().intValue());
    }

    @Test
    public void lasKey() {
        Assert.assertEquals(4, this.map.lastKey().intValue());
        Assert.assertEquals(1, this.revMap.lastKey().intValue());
    }

    private void checkMutability(Map<Integer, String> map) {
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.put(3, "1"));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.putAll(SortedMaps.mutable.of(1, "1", 2, "2")));
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.remove(2));
        Assert.assertThrows(UnsupportedOperationException.class, map::clear);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::comparator, this.description("comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::subMap, this.description("subMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_headMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::headMap, this.description("headMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tailMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::tailMap, this.description("tailMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_firstKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::firstKey, this.description("firstKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lasKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lasKey, this.description("lasKey"));
        }

        private UnmodifiableSortedMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableSortedMapTest();
        }

        @java.lang.Override
        public UnmodifiableSortedMapTest implementation() {
            return this.implementation;
        }
    }
}
