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

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TakeWhileIterator}.
 */
public class TakeWhileIteratorTest {

    @Test
    public void iterator() {
        Interval list = Interval.oneTo(5);
        Iterator<Integer> iterator1 = new TakeWhileIterator<>(list.iterator(), each -> each <= 2);
        assertElements(iterator1, 2);
        Iterator<Integer> iterator2 = new TakeWhileIterator<>(list, each -> each <= 5);
        assertElements(iterator2, 5);
        Iterator<Integer> iterator3 = new TakeWhileIterator<>(list, Predicates.alwaysTrue());
        assertElements(iterator3, 5);
        Iterator<Integer> iterator4 = new TakeWhileIterator<>(list, Predicates.alwaysFalse());
        assertElements(iterator4, 0);
        Iterator<Integer> iterator5 = new TakeWhileIterator<>(Lists.fixedSize.of(), Predicates.alwaysFalse());
        assertElements(iterator5, 0);
    }

    private static void assertElements(Iterator<Integer> iterator, int count) {
        for (int i = 0; i < count; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(Integer.valueOf(i + 1), iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void hasNext() {
        Interval list = Interval.oneTo(5);
        Iterator<Integer> iterator1 = new TakeWhileIterator<>(list.iterator(), each -> each <= 1);
        Assert.assertTrue(iterator1.hasNext());
        Assert.assertTrue(iterator1.hasNext());
        iterator1.next();
        Assert.assertFalse(iterator1.hasNext());
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> new TakeWhileIterator<>(Lists.fixedSize.<Integer>of(), Predicates.alwaysTrue()).remove());
    }

    @Test
    public void noSuchElementException() {
        Assert.assertThrows(NoSuchElementException.class, () -> new TakeWhileIterator<>(Lists.fixedSize.<Integer>of(), Predicates.alwaysTrue()).next());
        Assert.assertThrows(NoSuchElementException.class, () -> new TakeWhileIterator<>(Lists.fixedSize.of(1, 2, 3), Predicates.alwaysFalse()).next());
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
        public void benchmark_hasNext() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::hasNext, this.description("hasNext"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noSuchElementException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noSuchElementException, this.description("noSuchElementException"));
        }

        private TakeWhileIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new TakeWhileIteratorTest();
        }

        @java.lang.Override
        public TakeWhileIteratorTest implementation() {
            return this.implementation;
        }
    }
}
