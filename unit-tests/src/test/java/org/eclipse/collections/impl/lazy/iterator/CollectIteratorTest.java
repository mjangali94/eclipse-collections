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

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public class CollectIteratorTest {

    @Test
    public void iterator() {
        Iterator<String> iterator = new CollectIterator<>(iList(Boolean.TRUE), String::valueOf);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("true", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorWithFunctionName() {
        Iterator<String> iterator = new CollectIterator<>(iList(Boolean.TRUE), String::valueOf);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("true", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorWithFunctionNameAndIterator() {
        Iterator<String> iterator = new CollectIterator<>(iList(Boolean.TRUE).iterator(), String::valueOf);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("true", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        new CollectIterator<>(Lists.mutable.<Boolean>of(), String::valueOf).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        new CollectIterator<>(Lists.mutable.<Boolean>of(), String::valueOf).remove();
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWithFunctionName() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iteratorWithFunctionName, this.description("iteratorWithFunctionName"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorWithFunctionNameAndIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iteratorWithFunctionNameAndIterator, this.description("iteratorWithFunctionNameAndIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSuchElementException() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::noSuchElementException, this.description("noSuchElementException"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::remove, this.description("remove"), java.lang.UnsupportedOperationException.class);
        }

        private CollectIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CollectIteratorTest();
        }

        @java.lang.Override
        public CollectIteratorTest implementation() {
            return this.implementation;
        }
    }
}
