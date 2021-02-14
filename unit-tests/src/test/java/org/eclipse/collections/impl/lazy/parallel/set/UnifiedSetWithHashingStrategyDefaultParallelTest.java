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

import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.junit.Test;

public class UnifiedSetWithHashingStrategyDefaultParallelTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), 1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), 1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(null, 2);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_small_batch() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::asParallel_small_batch, this.description("asParallel_small_batch"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_null_executorService() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::asParallel_null_executorService, this.description("asParallel_null_executorService"), java.lang.NullPointerException.class);
        }

        private UnifiedSetWithHashingStrategyDefaultParallelTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnifiedSetWithHashingStrategyDefaultParallelTest();
        }

        @java.lang.Override
        public UnifiedSetWithHashingStrategyDefaultParallelTest implementation() {
            return this.implementation;
        }
    }
}
