/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.set;

import org.eclipse.collections.api.ParallelIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

public class ParallelCollectSelectSetIterableTest extends ParallelIterableTestCase {

    @Override
    protected ParallelIterable<Integer> classUnderTest() {
        return this.newWith(0, 11, 21, 22, 31, 32, 33, 41, 42, 43, 44, 50);
    }

    @Override
    protected ParallelIterable<Integer> newWith(Integer... littleElements) {
        return UnifiedSet.newSetWith(littleElements).asParallel(this.executorService, this.batchSize).collect(i -> i / 10).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @Override
    protected MutableBag<Integer> getExpected() {
        return HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected MutableBag<Integer> getExpectedWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).collect(i -> i / 10).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @Override
    protected boolean isOrdered() {
        return false;
    }

    @Override
    protected boolean isUnique() {
        return false;
    }

    @Test
    @Override
    public void groupBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Assert.assertEquals(this.getExpected().toBag().groupBy(isOddFunction), this.classUnderTest().groupBy(isOddFunction));
    }

    @Test
    @Override
    public void groupByEach() {
        Assert.assertEquals(this.getExpected().toBag().groupByEach(new NegativeIntervalFunction()), this.classUnderTest().groupByEach(new NegativeIntervalFunction()));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
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

        private ParallelCollectSelectSetIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ParallelCollectSelectSetIterableTest();
        }

        @java.lang.Override
        public ParallelCollectSelectSetIterableTest implementation() {
            return this.implementation;
        }
    }
}
