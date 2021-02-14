/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.junit.Test;

public abstract class MultiReaderMutableCollectionTestCase extends AbstractCollectionTestCase {

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void iterator_throws() {
        this.newWith(1, 2, 3).iterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void spliterator_throws() {
        this.newWith(1, 2, 3).spliterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void stream_throws() {
        this.newWith(1, 2, 3).stream();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void parallelStream_throws() {
        this.newWith(1, 2, 3).parallelStream();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::iterator_throws, this.description("iterator_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_spliterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::spliterator_throws, this.description("spliterator_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::stream_throws, this.description("stream_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::parallelStream_throws, this.description("parallelStream_throws"), java.lang.UnsupportedOperationException.class);
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract MultiReaderMutableCollectionTestCase implementation();
    }
}
