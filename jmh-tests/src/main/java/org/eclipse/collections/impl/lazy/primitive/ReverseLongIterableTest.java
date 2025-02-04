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
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseLongIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseLongIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseLongIterableTest> toSortedList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseLongIterableTest::isEmpty;
            this.payloads.contains = ReverseLongIterableTest::contains;
            this.payloads.containsAllArray = ReverseLongIterableTest::containsAllArray;
            this.payloads.containsAllIterable = ReverseLongIterableTest::containsAllIterable;
            this.payloads.iterator = ReverseLongIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseLongIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseLongIterableTest::forEach;
            this.payloads.size = ReverseLongIterableTest::size;
            this.payloads.empty = ReverseLongIterableTest::empty;
            this.payloads.count = ReverseLongIterableTest::count;
            this.payloads.anySatisfy = ReverseLongIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseLongIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseLongIterableTest::noneSatisfy;
            this.payloads.select = ReverseLongIterableTest::select;
            this.payloads.reject = ReverseLongIterableTest::reject;
            this.payloads.detectIfNone = ReverseLongIterableTest::detectIfNone;
            this.payloads.collect = ReverseLongIterableTest::collect;
            this.payloads.max = ReverseLongIterableTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseLongIterableTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ReverseLongIterableTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseLongIterableTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ReverseLongIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = ReverseLongIterableTest::maxIfEmpty;
            this.payloads.sum = ReverseLongIterableTest::sum;
            this.payloads.average = ReverseLongIterableTest::average;
            this.payloads.median = ReverseLongIterableTest::median;
            this.payloads.toArray = ReverseLongIterableTest::toArray;
            this.payloads.toSortedArray = ReverseLongIterableTest::toSortedArray;
            this.payloads.testToString = ReverseLongIterableTest::testToString;
            this.payloads.makeString = ReverseLongIterableTest::makeString;
            this.payloads.appendString = ReverseLongIterableTest::appendString;
            this.payloads.toList = ReverseLongIterableTest::toList;
            this.payloads.toSet = ReverseLongIterableTest::toSet;
            this.payloads.toBag = ReverseLongIterableTest::toBag;
            this.payloads.asLazy = ReverseLongIterableTest::asLazy;
            this.payloads.toSortedList = ReverseLongIterableTest::toSortedList;
        }
    }
}
