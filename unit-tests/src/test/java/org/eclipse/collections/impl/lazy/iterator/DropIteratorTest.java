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
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DropIterator}.
 */
public class DropIteratorTest {

    @Test
    public void iterator() {
        Interval list = Interval.oneTo(5);
        Iterator<Integer> iterator1 = new DropIterator<>(list.iterator(), 2);
        assertElements(iterator1, 2, list.size());
        Iterator<Integer> iterator2 = new DropIterator<>(list, 5);
        assertElements(iterator2, 5, list.size());
        Iterator<Integer> iterator3 = new DropIterator<>(list, 10);
        assertElements(iterator3, 5, list.size());
        Iterator<Integer> iterator4 = new DropIterator<>(list, 0);
        assertElements(iterator4, 0, list.size());
        Iterator<Integer> iterator5 = new DropIterator<>(Lists.fixedSize.of(), 0);
        assertElements(iterator5, 0, Lists.fixedSize.<Integer>of().size());
    }

    private static void assertElements(Iterator<Integer> iterator, int count, int size) {
        for (int i = count; i < size; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(Integer.valueOf(i + 1), iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> new DropIterator<>(Lists.fixedSize.<Integer>of(), 0).remove());
    }

    @Test
    public void noSuchElementException() {
        Assert.assertThrows(NoSuchElementException.class, () -> new DropIterator<>(Lists.fixedSize.<Integer>of(), 0).next());
        Assert.assertThrows(NoSuchElementException.class, () -> new DropIterator<>(Lists.fixedSize.of(1, 2, 3), 4).next());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
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

        private DropIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DropIteratorTest();
        }

        @java.lang.Override
        public DropIteratorTest implementation() {
            return this.implementation;
        }
    }
}
