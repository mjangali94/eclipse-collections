/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.list;

import org.junit.Test;

public abstract class NonParallelListIterableTestCase extends ParallelListIterableTestCase {

    @Override
    @Test
    public void forEach_executionException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void collect_executionException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void anySatisfy_executionException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void allSatisfy_executionException() {
    // Not applicable
    }

    @Override
    @Test
    public void detect_executionException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void forEach_interruptedException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void anySatisfy_interruptedException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void allSatisfy_interruptedException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void detect_interruptedException() {
    // Not applicable in serial
    }

    @Override
    @Test
    public void toString_interruptedException() {
    // Not applicable in serial
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach_executionException, this.description("forEach_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect_executionException, this.description("collect_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy_executionException, this.description("anySatisfy_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy_executionException, this.description("allSatisfy_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_executionException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect_executionException, this.description("detect_executionException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach_interruptedException, this.description("forEach_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy_interruptedException, this.description("anySatisfy_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy_interruptedException, this.description("allSatisfy_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect_interruptedException, this.description("detect_interruptedException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_interruptedException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toString_interruptedException, this.description("toString_interruptedException"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract NonParallelListIterableTestCase implementation();
    }
}
