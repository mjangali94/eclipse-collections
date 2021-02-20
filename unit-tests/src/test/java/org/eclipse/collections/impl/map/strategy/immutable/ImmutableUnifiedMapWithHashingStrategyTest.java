/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.strategy.immutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.immutable.ImmutableMapTestCase;
import org.eclipse.collections.impl.map.strategy.mutable.UnifiedMapWithHashingStrategy;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableUnifiedMapWithHashingStrategyTest extends ImmutableMapTestCase {

    // Not using the static factor method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableMap<Integer, String> deserialized = SerializeTestHelper.serializeDeserialize(this.classUnderTest());
        Verify.assertInstanceOf(ImmutableUnifiedMapWithHashingStrategy.class, deserialized);
    }

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return UnifiedMapWithHashingStrategy.newWithKeysValues(HASHING_STRATEGY, 1, "1", 2, "2", 3, "3", 4, "4").toImmutable();
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
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

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

        private ImmutableUnifiedMapWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableUnifiedMapWithHashingStrategyTest();
        }

        @java.lang.Override
        public ImmutableUnifiedMapWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
