/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.primitive.LongList;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapLongIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapLongIterableTest {

    private final LongList list = LongLists.immutable.with(1L, 2L, 3L, 4L, 5L);

    @Test
    public void longIterator() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        long sum = 0L;
        for (LongIterator iterator = iterable.longIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(15L, sum);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        long[] sum = new long[1];
        iterable.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(iterable.anySatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void allSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(iterable.allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(iterable.allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(iterable.allSatisfy(LongPredicates.lessThan(4L)));
    }

    @Test
    public void noneSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(iterable.noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(iterable.noneSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(iterable.noneSatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void select() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Verify.assertSize(4, iterable.select(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, iterable.select(LongPredicates.lessThan(0L)));
    }

    @Test
    public void reject() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Verify.assertSize(1, iterable.reject(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, iterable.reject(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void detectIfNone() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(4L, iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
    }

    @Test
    public void collect() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(5L, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.minIfEmpty(0L));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(5L, iterable.maxIfEmpty(0L));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new TapLongIterable(new LongArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new TapLongIterable(new LongArrayList(), System.out::println).min();
    }

    @Test
    public void average() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new TapLongIterable(new LongArrayList(), System.out::println).average();
    }

    @Test
    public void median() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new TapLongIterable(new LongArrayList(), System.out::println).median();
    }

    @Test
    public void toArray() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertArrayEquals(new long[] { 1, 2, 3, 4, 5 }, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.contains(1L));
        Assert.assertTrue(iterable.contains(2L));
        Assert.assertFalse(iterable.contains(6L));
    }

    @Test
    public void containsAllArray() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(1L));
        Assert.assertTrue(iterable.containsAll(2L));
        Assert.assertTrue(iterable.containsAll(1L, 2L));
        Assert.assertTrue(iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(iterable.containsAll(4L, 5L, 6L));
    }

    @Test
    public void containsAllIterable() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(2L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(iterable.containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
    }

    @Test
    public void toSortedArray() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertArrayEquals(new long[] { 1, 2, 3, 4, 5 }, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto() {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(15L), result);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapLongIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
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
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapLongIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapLongIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.longIterator = TapLongIterableTest::longIterator;
            this.payloads.forEach = TapLongIterableTest::forEach;
            this.payloads.size = TapLongIterableTest::size;
            this.payloads.empty = TapLongIterableTest::empty;
            this.payloads.count = TapLongIterableTest::count;
            this.payloads.anySatisfy = TapLongIterableTest::anySatisfy;
            this.payloads.allSatisfy = TapLongIterableTest::allSatisfy;
            this.payloads.noneSatisfy = TapLongIterableTest::noneSatisfy;
            this.payloads.select = TapLongIterableTest::select;
            this.payloads.reject = TapLongIterableTest::reject;
            this.payloads.detectIfNone = TapLongIterableTest::detectIfNone;
            this.payloads.collect = TapLongIterableTest::collect;
            this.payloads.sum = TapLongIterableTest::sum;
            this.payloads.max = TapLongIterableTest::max;
            this.payloads.min = TapLongIterableTest::min;
            this.payloads.minIfEmpty = TapLongIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = TapLongIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapLongIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapLongIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = TapLongIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapLongIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = TapLongIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapLongIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = TapLongIterableTest::toArray;
            this.payloads.contains = TapLongIterableTest::contains;
            this.payloads.containsAllArray = TapLongIterableTest::containsAllArray;
            this.payloads.containsAllIterable = TapLongIterableTest::containsAllIterable;
            this.payloads.toSortedArray = TapLongIterableTest::toSortedArray;
            this.payloads.toList = TapLongIterableTest::toList;
            this.payloads.toSortedList = TapLongIterableTest::toSortedList;
            this.payloads.toSet = TapLongIterableTest::toSet;
            this.payloads.toBag = TapLongIterableTest::toBag;
            this.payloads.asLazy = TapLongIterableTest::asLazy;
            this.payloads.injectInto = TapLongIterableTest::injectInto;
        }
    }
*/
}
