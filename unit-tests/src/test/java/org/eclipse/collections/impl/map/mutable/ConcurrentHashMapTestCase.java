/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ConcurrentMutableMap;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class ConcurrentHashMapTestCase extends MutableMapTestCase {

    protected ExecutorService executor;

    @Before
    public void setUp() {
        this.executor = Executors.newFixedThreadPool(20);
    }

    @After
    public void tearDown() {
        this.executor.shutdown();
    }

    @Override
    protected abstract <K, V> ConcurrentMutableMap<K, V> newMap();

    @Override
    @Test
    public void updateValue() {
        super.updateValue();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> map.updateValue(each % 10, () -> 0, integer -> integer + 1), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(9).toSet(), map.keySet());
        Assert.assertEquals(FastList.newList(Collections.nCopies(10, 10)), FastList.newList(map.values()));
    }

    @Override
    @Test
    public void updateValue_collisions() {
        super.updateValue_collisions();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        MutableList<Integer> list = Interval.oneTo(100).toList().shuffleThis();
        ParallelIterate.forEach(list, each -> map.updateValue(each % 50, () -> 0, integer -> integer + 1), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(49).toSet(), map.keySet());
        Assert.assertEquals(HashBag.newBag(map.values()).toStringOfItemToCount(), FastList.newList(Collections.nCopies(50, 2)), FastList.newList(map.values()));
    }

    @Override
    @Test
    public void updateValueWith() {
        super.updateValueWith();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        ParallelIterate.forEach(Interval.oneTo(100), each -> map.updateValueWith(each % 10, () -> 0, (integer, parameter) -> {
            Assert.assertEquals("test", parameter);
            return integer + 1;
        }, "test"), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(9).toSet(), map.keySet());
        Assert.assertEquals(FastList.newList(Collections.nCopies(10, 10)), FastList.newList(map.values()));
    }

    @Override
    @Test
    public void updateValueWith_collisions() {
        super.updateValueWith_collisions();
        ConcurrentMutableMap<Integer, Integer> map = this.newMap();
        MutableList<Integer> list = Interval.oneTo(200).toList().shuffleThis();
        ParallelIterate.forEach(list, each -> map.updateValueWith(each % 100, () -> 0, (integer, parameter) -> {
            Assert.assertEquals("test", parameter);
            return integer + 1;
        }, "test"), 1, this.executor);
        Assert.assertEquals(Interval.zeroTo(99).toSet(), map.keySet());
        Assert.assertEquals(HashBag.newBag(map.values()).toStringOfItemToCount(), FastList.newList(Collections.nCopies(100, 2)), FastList.newList(map.values()));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue, this.description("updateValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_collisions() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue_collisions, this.description("updateValue_collisions"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValueWith, this.description("updateValueWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_collisions() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValueWith_collisions, this.description("updateValueWith_collisions"));
        }

        @java.lang.Override
        public void before() throws java.lang.Throwable {
            super.before();
            this.implementation().setUp();
        }

        @java.lang.Override
        public void after() throws java.lang.Throwable {
            this.implementation().tearDown();
            super.after();
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract ConcurrentHashMapTestCase implementation();
    }
}
