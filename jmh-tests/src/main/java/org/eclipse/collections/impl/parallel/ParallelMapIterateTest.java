/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelMapIterateTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithNoParameters() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValueWithNoParameters);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithExecutor() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValueWithExecutor);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeAndTaskCountParallel() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValueWithMinForkSizeAndTaskCountParallel);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValueWithMinForkSizeAndTaskCountSerial() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValueWithMinForkSizeAndTaskCountSerial);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelMapIterateTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> forEachKeyValueWithNoParameters;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> forEachKeyValueWithExecutor;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> forEachKeyValueWithMinForkSizeAndTaskCountParallel;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> forEachKeyValueWithMinForkSizeAndTaskCountSerial;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelMapIterateTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEachKeyValueWithNoParameters = ParallelMapIterateTest::forEachKeyValueWithNoParameters;
            this.payloads.forEachKeyValueWithExecutor = ParallelMapIterateTest::forEachKeyValueWithExecutor;
            this.payloads.forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel = ParallelMapIterateTest::forEachKeyValueWithMinForkSizeTaskCountAndExecutorParallel;
            this.payloads.forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial = ParallelMapIterateTest::forEachKeyValueWithMinForkSizeTaskCountAndExecutorSerial;
            this.payloads.forEachKeyValueWithMinForkSizeAndTaskCountParallel = ParallelMapIterateTest::forEachKeyValueWithMinForkSizeAndTaskCountParallel;
            this.payloads.forEachKeyValueWithMinForkSizeAndTaskCountSerial = ParallelMapIterateTest::forEachKeyValueWithMinForkSizeAndTaskCountSerial;
            this.payloads.classIsNonInstantiable = ParallelMapIterateTest::classIsNonInstantiable;
        }
    }
*/
}
