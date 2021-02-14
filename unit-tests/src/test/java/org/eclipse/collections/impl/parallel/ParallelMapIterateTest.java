/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.parallel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class ParallelMapIterateTest {

    @Test
    public void forEachKeyValueWithNoParameters() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three");
        ParallelMapIterate.forEachKeyValue(map, concurrentMap::put);
        Verify.assertMapsEqual(concurrentMap, map);
    }

    @Test
    public void forEachKeyValueWithExecutor() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three");
        ParallelMapIterate.forEachKeyValue(map, concurrentMap::put, Executors.newSingleThreadExecutor());
        Verify.assertMapsEqual(concurrentMap, map);
    }

    @Test
    public void forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three");
        ParallelMapIterate.forEachKeyValue(map, concurrentMap::put, 1, 3, Executors.newSingleThreadExecutor());
        Verify.assertMapsEqual(concurrentMap, map);
    }

    @Test
    public void forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three");
        ParallelMapIterate.forEachKeyValue(map, concurrentMap::put, 5, 3, Executors.newSingleThreadExecutor());
        Verify.assertMapsEqual(concurrentMap, map);
    }

    @Test
    public void forEachKeyValueWithMinForkSizeAndTaskCountParallel() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three");
        ParallelMapIterate.forEachKeyValue(map, concurrentMap::put, 1, 3);
        Verify.assertMapsEqual(concurrentMap, map);
    }

    @Test
    public void forEachKeyValueWithMinForkSizeAndTaskCountSerial() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        MutableMap<String, String> map = UnifiedMap.newWithKeysValues("1", "One", "2", "Two", "3", "Three");
        ParallelMapIterate.forEachKeyValue(map, concurrentMap::put, 5, 3);
        Verify.assertMapsEqual(concurrentMap, map);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ParallelMapIterate.class);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithNoParameters() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithNoParameters, this.description("forEachKeyValueWithNoParameters"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithExecutor() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithExecutor, this.description("forEachKeyValueWithExecutor"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel, this.description("forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial, this.description("forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeAndTaskCountParallel() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithMinForkSizeAndTaskCountParallel, this.description("forEachKeyValueWithMinForkSizeAndTaskCountParallel"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeAndTaskCountSerial() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValueWithMinForkSizeAndTaskCountSerial, this.description("forEachKeyValueWithMinForkSizeAndTaskCountSerial"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private ParallelMapIterateTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ParallelMapIterateTest();
        }

        @java.lang.Override
        public ParallelMapIterateTest implementation() {
            return this.implementation;
        }
    }
}
