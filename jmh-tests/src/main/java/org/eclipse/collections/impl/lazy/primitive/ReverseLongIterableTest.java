/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseLongIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseLongIterableTest {

    @Test
    public void isEmpty() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Verify.assertEmpty(new LongArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertFalse(iterable.contains(0L));
        Assert.assertTrue(iterable.contains(1L));
    }

    @Test
    public void containsAllArray() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertTrue(iterable.containsAll(1L));
        Assert.assertTrue(iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(iterable.containsAll(1L, 2L, 3L, 4L));
    }

    @Test
    public void containsAllIterable() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L, 4L)));
    }

    @Test
    public void iterator() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        LongIterator iterator = iterable.longIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        LongIterator iterator = iterable.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        long[] sum = new long[1];
        iterable.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Verify.assertSize(0, new LongArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, LongArrayList.newListWith(1L, 0L, 2L).asReversed().count(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(LongArrayList.newListWith(1L, -1L, 2L).asReversed().anySatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(LongArrayList.newListWith(1L, -1L, 2L).asReversed().anySatisfy(LongPredicates.equal(0L)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(LongArrayList.newListWith(1L, 0L, 2L).asReversed().allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(LongArrayList.newListWith(1L, 2L, 3L).asReversed().allSatisfy(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(LongArrayList.newListWith(1L, 0L, 2L).asReversed().noneSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertTrue(LongArrayList.newListWith(1L, 2L, 3L).asReversed().noneSatisfy(LongPredicates.greaterThan(3L)));
    }

    @Test
    public void select() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Verify.assertSize(3, iterable.select(LongPredicates.lessThan(4L)));
        Verify.assertSize(2, iterable.select(LongPredicates.lessThan(3L)));
    }

    @Test
    public void reject() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Verify.assertSize(0, iterable.reject(LongPredicates.lessThan(4L)));
        Verify.assertSize(1, iterable.reject(LongPredicates.lessThan(3L)));
    }

    @Test
    public void detectIfNone() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertEquals(1L, iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(0L, iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
    }

    @Test
    public void collect() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0L, 1L, 2L), iterable.collect((long parameter) -> parameter - 1));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, LongArrayList.newListWith(1L, 0L, 9L, 7L).asReversed().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new LongArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, LongArrayList.newListWith(1L, 0L, 9L, 7L).asReversed().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new LongArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, new LongArrayList().asReversed().minIfEmpty(5L));
        Assert.assertEquals(0L, new LongArrayList().asReversed().minIfEmpty(0L));
        Assert.assertEquals(0L, LongArrayList.newListWith(1L, 0L, 9L, 7L).asReversed().minIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, new LongArrayList().asReversed().maxIfEmpty(5L));
        Assert.assertEquals(0L, new LongArrayList().asReversed().maxIfEmpty(0L));
        Assert.assertEquals(9L, LongArrayList.newListWith(1L, 0L, 9L, 7L).asReversed().maxIfEmpty(5L));
    }

    @Test
    public void sum() {
        Assert.assertEquals(10L, LongArrayList.newListWith(1L, 2L, 3L, 4L).asReversed().sum());
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, LongArrayList.newListWith(1L, 2L, 3L, 4L).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, LongArrayList.newListWith(1L, 2L, 3L, 4L).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new long[] { 3L, 4L, 2L, 1L }, LongArrayList.newListWith(1L, 2L, 4L, 3L).asReversed().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new long[] { 1L, 3L, 7L, 9L }, LongArrayList.newListWith(3L, 1L, 9L, 7L).asReversed().toSortedArray());
    }

    @Test
    public void testToString() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertEquals("[1, 2, 3]", iterable.toString());
        Assert.assertEquals("[]", new LongArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        Assert.assertEquals("1, 2, 3", iterable.makeString());
        Assert.assertEquals("1", LongArrayList.newListWith(1L).makeString("/"));
        Assert.assertEquals("1/2/3", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new LongArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        LongIterable iterable = LongArrayList.newListWith(3L, 2L, 1L).asReversed();
        StringBuilder appendable = new StringBuilder();
        new LongArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("1, 2, 3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("1/2/3", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(2L, 1L), LongArrayList.newListWith(1L, 2L).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), LongArrayList.newListWith(3L, 2L, 1L).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), LongArrayList.newListWith(3L, 2L, 1L).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), LongArrayList.newListWith(3L, 2L, 1L).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), LongArrayList.newListWith(2L, 3L, 1L).asReversed().toSortedList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::iterator_throws, this.description("iterator_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_throws_emptyList, this.description("max_throws_emptyList"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_throws_emptyList, this.description("min_throws_emptyList"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minIfEmpty, this.description("minIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxIfEmpty, this.description("maxIfEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sum, this.description("sum"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::average, this.description("average"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::median, this.description("median"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedArray, this.description("toSortedArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazy, this.description("asLazy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList, this.description("toSortedList"));
        }

        private ReverseLongIterableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ReverseLongIterableTest();
        }

        @java.lang.Override
        public ReverseLongIterableTest implementation() {
            return this.implementation;
        }
    }
}
