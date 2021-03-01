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
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

public class SelectInstancesOfIteratorTest {

    @Test
    public void iterator() {
        MutableList<Number> list = FastList.newListWith(null, 1, 2.0, null, 3, 4.0, 5, null);
        this.assertElements(new SelectInstancesOfIterator<>(list.iterator(), Integer.class));
        this.assertElements(new SelectInstancesOfIterator<>(list, Integer.class));
    }

    private void assertElements(Iterator<Integer> iterator) {
        MutableList<Integer> result = FastList.newList();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Assert.assertEquals(FastList.newListWith(1, 3, 5), result);
    }

    @Test
    public void noSuchElementException() {
        Assert.assertThrows(NoSuchElementException.class, () -> new SelectInstancesOfIterator<>(Lists.fixedSize.of(), Object.class).next());
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> new SelectInstancesOfIterator<>(Lists.fixedSize.of(), Object.class).remove());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
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
        public void benchmark_noSuchElementException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noSuchElementException, this.description("noSuchElementException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        private SelectInstancesOfIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SelectInstancesOfIteratorTest();
        }

        @java.lang.Override
        public SelectInstancesOfIteratorTest implementation() {
            return this.implementation;
        }
    }
}
