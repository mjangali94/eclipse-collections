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
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectIntIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectIntIterableTest {

    private final SelectIntIterable iterable = new SelectIntIterable(IntArrayList.newListWith(1, 2, 3, 4, 5), IntPredicates.lessThan(3));

    @Test
    public void intIterator() {
        long sum = 0L;
        for (IntIterator iterator = this.iterable.intIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.iterable.forEach((int each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(IntPredicates.lessThan(2)));
        Assert.assertEquals(0L, this.iterable.count(IntPredicates.lessThan(0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.iterable.anySatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertTrue(this.iterable.allSatisfy(IntPredicates.lessThan(4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.iterable.noneSatisfy(IntPredicates.lessThan(2)));
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.lessThan(1)));
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(IntPredicates.greaterThan(1)));
        Verify.assertSize(0, this.iterable.select(IntPredicates.lessThan(0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(IntPredicates.greaterThan(1)));
        Verify.assertSize(0, this.iterable.reject(IntPredicates.greaterThan(0)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.iterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(IntPredicates.greaterThan(3), 0));
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
        Assert.assertEquals(2, this.iterable.max());
    }

    @Test
    public void min() {
        Assert.assertEquals(1, this.iterable.min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1, this.iterable.minIfEmpty(0));
        Assert.assertEquals(0, this.iterable.select(IntPredicates.lessThan(0)).minIfEmpty(0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2, this.iterable.maxIfEmpty(0));
        Assert.assertEquals(0, this.iterable.select(IntPredicates.lessThan(0)).maxIfEmpty(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new int[] { 1, 2 }, this.iterable.toArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(1));
        Assert.assertTrue(this.iterable.contains(2));
        Assert.assertFalse(this.iterable.contains(3));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(1));
        Assert.assertTrue(this.iterable.containsAll(2));
        Assert.assertTrue(this.iterable.containsAll(1, 2));
        Assert.assertFalse(this.iterable.containsAll(1, 2, 3));
        Assert.assertFalse(this.iterable.containsAll(4, 5, 6));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(this.iterable.containsAll(IntArrayList.newListWith(2)));
        Assert.assertTrue(this.iterable.containsAll(IntArrayList.newListWith(1, 2)));
        Assert.assertFalse(this.iterable.containsAll(IntArrayList.newListWith(1, 2, 3)));
        Assert.assertFalse(this.iterable.containsAll(IntArrayList.newListWith(4, 5, 6)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new int[] { 1, 2 }, this.iterable.toSortedArray());
    }

    @Test
    public void toList() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableInteger result = this.iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(3), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectIntIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectIntIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectIntIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.intIterator = SelectIntIterableTest::intIterator;
            this.payloads.forEach = SelectIntIterableTest::forEach;
            this.payloads.size = SelectIntIterableTest::size;
            this.payloads.empty = SelectIntIterableTest::empty;
            this.payloads.count = SelectIntIterableTest::count;
            this.payloads.anySatisfy = SelectIntIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectIntIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SelectIntIterableTest::noneSatisfy;
            this.payloads.select = SelectIntIterableTest::select;
            this.payloads.reject = SelectIntIterableTest::reject;
            this.payloads.detectIfNone = SelectIntIterableTest::detectIfNone;
            this.payloads.collect = SelectIntIterableTest::collect;
            this.payloads.sum = SelectIntIterableTest::sum;
            this.payloads.max = SelectIntIterableTest::max;
            this.payloads.min = SelectIntIterableTest::min;
            this.payloads.minIfEmpty = SelectIntIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SelectIntIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIntIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIntIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SelectIntIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIntIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SelectIntIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectIntIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SelectIntIterableTest::toArray;
            this.payloads.contains = SelectIntIterableTest::contains;
            this.payloads.containsAllArray = SelectIntIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SelectIntIterableTest::containsAllIterable;
            this.payloads.toSortedArray = SelectIntIterableTest::toSortedArray;
            this.payloads.toList = SelectIntIterableTest::toList;
            this.payloads.toSortedList = SelectIntIterableTest::toSortedList;
            this.payloads.toSet = SelectIntIterableTest::toSet;
            this.payloads.toBag = SelectIntIterableTest::toBag;
            this.payloads.asLazy = SelectIntIterableTest::asLazy;
            this.payloads.injectInto = SelectIntIterableTest::injectInto;
        }
    }
}
