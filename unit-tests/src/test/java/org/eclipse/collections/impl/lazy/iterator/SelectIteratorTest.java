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
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

public class SelectIteratorTest {

    @Test
    public void iterator() {
        MutableList<Boolean> list = FastList.newListWith(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.TRUE, null);
        this.assertElements(new SelectIterator<>(list.iterator(), Boolean.TRUE::equals));
        this.assertElements(new SelectIterator<>(list, Boolean.TRUE::equals));
    }

    private void assertElements(Iterator<Boolean> newIterator) {
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(newIterator.hasNext());
            Assert.assertEquals(Boolean.TRUE, newIterator.next());
        }
        Assert.assertFalse(newIterator.hasNext());
    }

    @Test
    public void noSuchElementException() {
        Assert.assertThrows(NoSuchElementException.class, () -> new SelectIterator<>(Lists.fixedSize.of(), ignored -> true).next());
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> new SelectIterator<>(Lists.fixedSize.of(), ignored -> true).remove());
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
        public void benchmark_noSuchElementException() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noSuchElementException, this.description("noSuchElementException"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        private SelectIteratorTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SelectIteratorTest();
        }

        @java.lang.Override
        public SelectIteratorTest implementation() {
            return this.implementation;
        }
    }
}
