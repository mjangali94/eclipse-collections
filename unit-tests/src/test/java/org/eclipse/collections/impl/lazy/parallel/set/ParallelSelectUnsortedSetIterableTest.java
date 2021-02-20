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

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

public class ParallelSelectUnsortedSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(-1, 1, -1, 2, -1, 2, -1, 3, -1, 3, -1, 3, 5, 4, 5, 4, 5, 4, 5, 4, 5);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return UnifiedSet.newSetWith(littleElements).asParallel(this.executorService, this.batchSize).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return UnifiedSet.newSetWith(littleElements).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private ParallelSelectUnsortedSetIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ParallelSelectUnsortedSetIterableTest();
        }

        @java.lang.Override
        public ParallelSelectUnsortedSetIterableTest implementation() {
            return this.implementation;
        }
    }
}
