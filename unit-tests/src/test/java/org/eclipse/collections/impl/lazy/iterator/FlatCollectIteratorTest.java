/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.iterator;

import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class FlatCollectIteratorTest {

    @Test(expected = NoSuchElementException.class)
    public void nextIfDoesntHaveAnything() {
        new FlatCollectIterator<>(Lists.immutable.of(), object -> null).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIsUnsupported() {
        new FlatCollectIterator<>(Lists.immutable.of().iterator(), object -> null).remove();
    }

    @Test
    public void nextAfterEmptyIterable() {
        Object expected = new Object();
        FlatCollectIterator<List<Object>, Object> flattenIterator = new FlatCollectIterator<>(Lists.fixedSize.of(Lists.fixedSize.of(), Lists.fixedSize.of(expected)), Functions.getPassThru());
        Assert.assertSame(expected, flattenIterator.next());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nextIfDoesntHaveAnything() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::nextIfDoesntHaveAnything, this.description("nextIfDoesntHaveAnything"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIsUnsupported() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeIsUnsupported, this.description("removeIsUnsupported"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nextAfterEmptyIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::nextAfterEmptyIterable, this.description("nextAfterEmptyIterable"));
        }

        private FlatCollectIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FlatCollectIteratorTest();
        }

        @java.lang.Override
        public FlatCollectIteratorTest implementation() {
            return this.implementation;
        }
    }
}
