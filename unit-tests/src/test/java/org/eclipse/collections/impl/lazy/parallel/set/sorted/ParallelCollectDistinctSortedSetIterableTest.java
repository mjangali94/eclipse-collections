/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.set.sorted;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.lazy.parallel.set.ParallelUnsortedSetIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

public class ParallelCollectDistinctSortedSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(44, 43, 42, 41, 33, 32, 31, 22, 21, 11);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.reverseNaturalOrder(), littleElements).asParallel(this.executorService, this.batchSize).collect(i -> i / 10).asUnique();
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.reverseNaturalOrder(), littleElements).collect(i -> i / 10, SortedSets.mutable.of()).toSet();
    }

    @Test
    @Override
    public void groupBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Assert.assertEquals(this.getExpected().toSet().groupBy(isOddFunction), this.classUnderTest().groupBy(isOddFunction));
    }

    @Test
    @Override
    public void groupByEach() {
        Assert.assertEquals(this.getExpected().toSet().groupByEach(new NegativeIntervalFunction()), this.classUnderTest().groupByEach(new NegativeIntervalFunction()));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupBy, this.description("groupBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByEach, this.description("groupByEach"));
        }

        private ParallelCollectDistinctSortedSetIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ParallelCollectDistinctSortedSetIterableTest();
        }

        @java.lang.Override
        public ParallelCollectDistinctSortedSetIterableTest implementation() {
            return this.implementation;
        }
    }
}
