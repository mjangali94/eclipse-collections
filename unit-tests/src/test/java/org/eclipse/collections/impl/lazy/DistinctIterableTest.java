/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.InternalIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.lazy.iterator.DistinctIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.junit.Assert;
import org.junit.Test;

public class DistinctIterableTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        return LazyIterate.distinct(FastList.newListWith(elements));
    }

    @Test
    public void forEach() {
        InternalIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(3, 1, 2, 2, 3, 4));
        Appendable builder = new StringBuilder();
        Procedure<Integer> appendProcedure = Procedures.append(builder);
        distinct.forEach(appendProcedure);
        Assert.assertEquals("3124", builder.toString());
    }

    @Test
    public void forEachWithIndex() {
        InternalIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(1, 2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 6, 8, 7, 9));
        StringBuilder builder = new StringBuilder();
        distinct.forEachWithIndex((object, index) -> {
            builder.append(object);
            builder.append(index);
        });
        Assert.assertEquals("102132435465768798", builder.toString());
    }

    @Override
    @Test
    public void iterator() {
        InternalIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(3, 1, 2, 2, 3, 4, 2, 5));
        StringBuilder builder = new StringBuilder();
        for (Integer each : distinct) {
            builder.append(each);
        }
        Assert.assertEquals("31245", builder.toString());
    }

    @Test
    public void forEachWith() {
        InternalIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(1, 3, 3, 2, 5, 4, 2, 5, 4));
        StringBuilder builder = new StringBuilder();
        distinct.forEachWith((each, aBuilder) -> aBuilder.append(each), builder);
        Assert.assertEquals("13254", builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        new DistinctIterator<>(Lists.mutable.<Integer>of()).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        new DistinctIterator<>(Lists.mutable.<Integer>of()).remove();
    }

    @Override
    @Test
    public void distinct() {
        super.distinct();
        DistinctIterable<Integer> distinct = new DistinctIterable<>(FastList.newListWith(3, 2, 2, 4, 1, 3, 1, 5));
        LazyIterable<Integer> distinctDistinct = distinct.distinct();
        Assert.assertSame(distinctDistinct, distinct);
        Assert.assertEquals(FastList.newListWith(3, 2, 4, 1, 5), distinctDistinct.toList());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 10, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 30, time = 1, timeUnit = java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.SECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        private DistinctIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DistinctIterableTest();
        }

        @java.lang.Override
        public DistinctIterableTest implementation() {
            return this.implementation;
        }
    }
}
