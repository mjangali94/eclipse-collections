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
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.primitive.ShortList;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapShortIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapShortIterableTest {

    private final ShortList list = ShortLists.immutable.with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);

    @Test
    public void shortIterator() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        long sum = 0L;
        for (ShortIterator iterator = iterable.shortIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(15L, sum);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        long[] sum = new long[1];
        iterable.forEach((short each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.count(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.anySatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertTrue(iterable.anySatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void allSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(iterable.allSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(iterable.allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertFalse(iterable.allSatisfy(ShortPredicates.lessThan((short) 4)));
    }

    @Test
    public void noneSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(iterable.noneSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertTrue(iterable.noneSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertFalse(iterable.noneSatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void select() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Verify.assertSize(4, iterable.select(ShortPredicates.greaterThan((short) 1)));
        Verify.assertSize(0, iterable.select(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void reject() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Verify.assertSize(1, iterable.reject(ShortPredicates.greaterThan((short) 1)));
        Verify.assertSize(0, iterable.reject(ShortPredicates.greaterThan((short) 0)));
    }

    @Test
    public void detectIfNone() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(4L, iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
    }

    @Test
    public void collect() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals((short) 5, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals((short) 1, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals((short) 1, iterable.minIfEmpty((short) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals((short) 5, iterable.maxIfEmpty((short) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new TapShortIterable(new ShortArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new TapShortIterable(new ShortArrayList(), System.out::println).min();
    }

    @Test
    public void average() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new TapShortIterable(new ShortArrayList(), System.out::println).average();
    }

    @Test
    public void median() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new TapShortIterable(new ShortArrayList(), System.out::println).median();
    }

    @Test
    public void toArray() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertArrayEquals(new short[] { 1, 2, 3, 4, 5 }, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.contains((short) 1));
        Assert.assertTrue(iterable.contains((short) 2));
        Assert.assertFalse(iterable.contains((short) 6));
    }

    @Test
    public void containsAllArray() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll((short) 1));
        Assert.assertTrue(iterable.containsAll((short) 2));
        Assert.assertTrue(iterable.containsAll((short) 1, (short) 2));
        Assert.assertTrue(iterable.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(iterable.containsAll((short) 4, (short) 5, (short) 6));
    }

    @Test
    public void containsAllIterable() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 2)));
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2)));
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(iterable.containsAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
    }

    @Test
    public void toSortedArray() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertArrayEquals(new short[] { 1, 2, 3, 4, 5 }, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto() {
        StringBuilder builder = new StringBuilder();
        TapShortIterable iterable = new TapShortIterable(this.list, builder::append);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 15), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapShortIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapShortIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapShortIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.shortIterator = TapShortIterableTest::shortIterator;
            this.payloads.forEach = TapShortIterableTest::forEach;
            this.payloads.size = TapShortIterableTest::size;
            this.payloads.empty = TapShortIterableTest::empty;
            this.payloads.count = TapShortIterableTest::count;
            this.payloads.anySatisfy = TapShortIterableTest::anySatisfy;
            this.payloads.allSatisfy = TapShortIterableTest::allSatisfy;
            this.payloads.noneSatisfy = TapShortIterableTest::noneSatisfy;
            this.payloads.select = TapShortIterableTest::select;
            this.payloads.reject = TapShortIterableTest::reject;
            this.payloads.detectIfNone = TapShortIterableTest::detectIfNone;
            this.payloads.collect = TapShortIterableTest::collect;
            this.payloads.sum = TapShortIterableTest::sum;
            this.payloads.max = TapShortIterableTest::max;
            this.payloads.min = TapShortIterableTest::min;
            this.payloads.minIfEmpty = TapShortIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = TapShortIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapShortIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapShortIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = TapShortIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapShortIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = TapShortIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapShortIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = TapShortIterableTest::toArray;
            this.payloads.contains = TapShortIterableTest::contains;
            this.payloads.containsAllArray = TapShortIterableTest::containsAllArray;
            this.payloads.containsAllIterable = TapShortIterableTest::containsAllIterable;
            this.payloads.toSortedArray = TapShortIterableTest::toSortedArray;
            this.payloads.toList = TapShortIterableTest::toList;
            this.payloads.toSortedList = TapShortIterableTest::toSortedList;
            this.payloads.toSet = TapShortIterableTest::toSet;
            this.payloads.toBag = TapShortIterableTest::toBag;
            this.payloads.asLazy = TapShortIterableTest::asLazy;
            this.payloads.injectInto = TapShortIterableTest::injectInto;
        }
    }
}
