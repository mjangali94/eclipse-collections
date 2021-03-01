/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.iterator;

import java.util.NoSuchElementException;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;

public class TapIteratorTest {

    @Test(expected = NoSuchElementException.class)
    public void nextIfDoesntHaveAnything() {
        new TapIterator<>(Lists.immutable.of(), object -> {
        }).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIsUnsupported() {
        new TapIterator<>(Lists.immutable.of().iterator(), object -> {
        }).remove();
    }

    @Test
    public void nextAfterEmptyIterable() {
        Object expected = new Object();
        TapIterator<Object> iterator = new TapIterator<>(Lists.fixedSize.of(expected), object -> {
        });
        Assert.assertSame(expected, iterator.next());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
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

        private TapIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TapIteratorTest();
        }

        @java.lang.Override
        public TapIteratorTest implementation() {
            return this.implementation;
        }
    }
}
