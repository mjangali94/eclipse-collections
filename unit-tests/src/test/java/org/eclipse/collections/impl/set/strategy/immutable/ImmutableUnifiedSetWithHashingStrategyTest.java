/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.strategy.immutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.math.SumProcedure;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.set.immutable.AbstractImmutableUnifiedSetTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableUnifiedSetWithHashingStrategy}.
 */
public class ImmutableUnifiedSetWithHashingStrategyTest extends AbstractImmutableUnifiedSetTestCase {

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
    public ImmutableSet<Integer> newSet(Integer... elements) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, elements);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int one, int two) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, one, two);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int one, int two, int three) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, one, two, three);
    }

    @Override
    public ImmutableSet<Integer> newSetWith(int... littleElements) {
        Integer[] bigElements = new Integer[littleElements.length];
        for (int i = 0; i < littleElements.length; i++) {
            bigElements[i] = littleElements[i];
        }
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(HASHING_STRATEGY, bigElements);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        ImmutableSet<Integer> set = ImmutableUnifiedSetWithHashingStrategy.newSet(HASHING_STRATEGY, UnifiedSet.newSet());
        Assert.assertTrue(set.isEmpty());
        Verify.assertSize(0, set);
    }

    @Test
    public void getBatchCount() {
        BatchIterable<Integer> integerBatchIterable = (BatchIterable<Integer>) this.newSet(1, 2, 3, 4, 5, 6);
        Assert.assertEquals(2, integerBatchIterable.getBatchCount(3));
    }

    @Test
    public void batchForEach() {
        Sum sum = new IntegerSum(0);
        BatchIterable<Integer> integerBatchIterable = (BatchIterable<Integer>) this.newSet(1, 2, 3, 4, 5);
        integerBatchIterable.batchForEach(new SumProcedure<>(sum), 0, 1);
        Assert.assertEquals(15, sum.getValue());
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableSet<Integer> deserialized = SerializeTestHelper.serializeDeserialize(this.newSet(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableUnifiedSetWithHashingStrategy.class, deserialized);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newCollection, this.description("newCollection"));
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::equalsAndHashCode, this.description("equalsAndHashCode"));
        }

        private ImmutableUnifiedSetWithHashingStrategyTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ImmutableUnifiedSetWithHashingStrategyTest();
        }

        @java.lang.Override
        public ImmutableUnifiedSetWithHashingStrategyTest implementation() {
            return this.implementation;
        }
    }
}
