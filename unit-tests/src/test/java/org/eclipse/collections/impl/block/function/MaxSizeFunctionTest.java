/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MaxSizeFunction}.
 */
public class MaxSizeFunctionTest {

    @Test
    public void maxSizeCollection() {
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.COLLECTION.value(2, FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.COLLECTION.value(3, FastList.newListWith(1, 2)));
    }

    @Test
    public void maxSizeMap() {
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.MAP.value(2, Maps.mutable.of(1, 1, 2, 2, 3, 3)));
        Assert.assertEquals(Integer.valueOf(3), MaxSizeFunction.MAP.value(3, Maps.mutable.of(1, 1, 2, 2)));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxSizeCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxSizeCollection, this.description("maxSizeCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxSizeMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxSizeMap, this.description("maxSizeMap"));
        }

        private MaxSizeFunctionTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new MaxSizeFunctionTest();
        }

        @java.lang.Override
        public MaxSizeFunctionTest implementation() {
            return this.implementation;
        }
    }
}
