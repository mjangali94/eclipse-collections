/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.lazy.LazyIterableAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import static org.eclipse.collections.impl.factory.Iterables.iList;

public class SynchronizedRichIterableTest extends AbstractRichIterableTestCase {

    @Override
    protected <T> RichIterable<T> newWith(T... littleElements) {
        return SynchronizedRichIterable.of(Lists.mutable.of(littleElements));
    }

    @Override
    @Test
    public void chunk_large_size() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        Verify.assertIterablesEqual(collection, collection.chunk(10).getOnly());
    }

    @Override
    @Test
    public void partition() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionIterable<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionIterable<Integer> result = integers.partitionWith(Predicates2.in(), FastList.newListWith(-2, 0, 2, 4, 6, 8));
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Override
    public void equalsAndHashCode() {
        Assert.assertNotEquals(this.newWith(), this.newWith());
    }

    @Override
    @Test
    public void groupBy() {
        RichIterable<Integer> list = this.newWith(1, 2, 3, 4, 5, 6, 7);
        Multimap<Boolean, Integer> multimap = list.groupBy(object -> IntegerPredicates.isOdd().accept(object));
        Assert.assertEquals(FastList.newListWith(1, 3, 5, 7), multimap.get(Boolean.TRUE));
        Assert.assertEquals(FastList.newListWith(2, 4, 6), multimap.get(Boolean.FALSE));
    }

    @Test
    public void groupByWithTarget() {
        RichIterable<Integer> list = this.newWith(1, 2, 3, 4, 5, 6, 7);
        MutableMultimap<Boolean, Integer> multimap = new FastListMultimap<>();
        list.groupBy(object -> IntegerPredicates.isOdd().accept(object), multimap);
        Assert.assertEquals(FastList.newListWith(1, 3, 5, 7), multimap.get(Boolean.TRUE));
        Assert.assertEquals(FastList.newListWith(2, 4, 6), multimap.get(Boolean.FALSE));
    }

    @Test
    public void asLazy() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9).asLazy();
        Verify.assertInstanceOf(LazyIterableAdapter.class, integers);
        PartitionIterable<Integer> result = integers.partitionWith(Predicates2.in(), FastList.newListWith(-2, 0, 2, 4, 6, 8));
        Assert.assertEquals(iList(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(iList(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCheck() {
        SynchronizedRichIterable.of(null, null);
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partitionWith, this.description("partitionWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupBy, this.description("groupBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByWithTarget, this.description("groupByWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nullCheck() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::nullCheck, this.description("nullCheck"), java.lang.IllegalArgumentException.class);
        }

        private SynchronizedRichIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new SynchronizedRichIterableTest();
        }

        @java.lang.Override
        public SynchronizedRichIterableTest implementation() {
            return this.implementation;
        }
    }
}
