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
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectLongIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectLongIterableTest {

    private final SelectLongIterable iterable = new SelectLongIterable(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), LongPredicates.lessThan(3L));

    @Test
    public void longIterator() {
        long sum = 0L;
        for (LongIterator iterator = this.iterable.longIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.iterable.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(3L, sum[0]);
    }

    @Test
    public void size() {
        Verify.assertSize(2, this.iterable);
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.iterable.notEmpty());
        Verify.assertNotEmpty(this.iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(1L, this.iterable.count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(0L, this.iterable.count(LongPredicates.lessThan(0L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.iterable.anySatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.lessThan(4L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.iterable.noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, this.iterable.select(LongPredicates.lessThan(0L)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, this.iterable.reject(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(0L, this.iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(2, this.iterable.collect(String::valueOf));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3L, this.iterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals(2L, this.iterable.max());
    }

    @Test
    public void min() {
        Assert.assertEquals(1L, this.iterable.min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1L, this.iterable.minIfEmpty(0L));
        Assert.assertEquals(0L, this.iterable.select(LongPredicates.lessThan(0L)).minIfEmpty(0L));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2L, this.iterable.maxIfEmpty(0L));
        Assert.assertEquals(0L, this.iterable.select(LongPredicates.lessThan(0L)).maxIfEmpty(0L));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new long[] { 1, 2 }, this.iterable.toArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(1L));
        Assert.assertTrue(this.iterable.contains(2L));
        Assert.assertFalse(this.iterable.contains(3L));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(1L));
        Assert.assertTrue(this.iterable.containsAll(2L));
        Assert.assertTrue(this.iterable.containsAll(1L, 2L));
        Assert.assertFalse(this.iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(this.iterable.containsAll(4L, 5L, 6L));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(2L)));
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertFalse(this.iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(this.iterable.containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new long[] { 1, 2 }, this.iterable.toSortedArray());
    }

    @Test
    public void toList() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableLong result = this.iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(3L), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectLongIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectLongIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectLongIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.longIterator = SelectLongIterableTest::longIterator;
            this.payloads.forEach = SelectLongIterableTest::forEach;
            this.payloads.size = SelectLongIterableTest::size;
            this.payloads.empty = SelectLongIterableTest::empty;
            this.payloads.count = SelectLongIterableTest::count;
            this.payloads.anySatisfy = SelectLongIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectLongIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SelectLongIterableTest::noneSatisfy;
            this.payloads.select = SelectLongIterableTest::select;
            this.payloads.reject = SelectLongIterableTest::reject;
            this.payloads.detectIfNone = SelectLongIterableTest::detectIfNone;
            this.payloads.collect = SelectLongIterableTest::collect;
            this.payloads.sum = SelectLongIterableTest::sum;
            this.payloads.max = SelectLongIterableTest::max;
            this.payloads.min = SelectLongIterableTest::min;
            this.payloads.minIfEmpty = SelectLongIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SelectLongIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectLongIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectLongIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SelectLongIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectLongIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SelectLongIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectLongIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SelectLongIterableTest::toArray;
            this.payloads.contains = SelectLongIterableTest::contains;
            this.payloads.containsAllArray = SelectLongIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SelectLongIterableTest::containsAllIterable;
            this.payloads.toSortedArray = SelectLongIterableTest::toSortedArray;
            this.payloads.toList = SelectLongIterableTest::toList;
            this.payloads.toSortedList = SelectLongIterableTest::toSortedList;
            this.payloads.toSet = SelectLongIterableTest::toSet;
            this.payloads.toBag = SelectLongIterableTest::toBag;
            this.payloads.asLazy = SelectLongIterableTest::asLazy;
            this.payloads.injectInto = SelectLongIterableTest::injectInto;
        }
    }
}
