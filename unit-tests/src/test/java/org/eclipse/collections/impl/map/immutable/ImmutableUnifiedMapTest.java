/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable;

import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableUnifiedMapTest extends ImmutableMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableUnifiedMap<>(Tuples.pair(1, "1"), Tuples.pair(2, "2"), Tuples.pair(3, "3"), Tuples.pair(4, "4"));
    }

    @Override
    protected int size() {
        return 4;
    }

    @Test
    @Override
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void getBatchCount() {
        BatchIterable<Integer> integerBatchIterable = (BatchIterable<Integer>) this.classUnderTest();
        Assert.assertEquals(5, integerBatchIterable.getBatchCount(3));
    }

    @Test
    public void batchForEach() {
        Sum sum = new IntegerSum(0);
        BatchIterable<String> integerBatchIterable = (BatchIterable<String>) this.classUnderTest();
        integerBatchIterable.batchForEach(each -> sum.add(Integer.valueOf(each)), 0, 1);
        Assert.assertEquals(10, sum.getValue());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getBatchCount() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getBatchCount, this.description("getBatchCount"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::batchForEach, this.description("batchForEach"));
        }

        private ImmutableUnifiedMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableUnifiedMapTest();
        }

        @java.lang.Override
        public ImmutableUnifiedMapTest implementation() {
            return this.implementation;
        }
    }
}
