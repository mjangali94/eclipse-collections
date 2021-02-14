/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.list;

import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.CompositeFastList;

public class CompositeListParallelListIterableTest extends NonParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return new CompositeFastList<Integer>().withAll(Lists.mutable.of(littleElements)).asParallel(null, this.batchSize);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private CompositeListParallelListIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CompositeListParallelListIterableTest();
        }

        @java.lang.Override
        public CompositeListParallelListIterableTest implementation() {
            return this.implementation;
        }
    }
}
