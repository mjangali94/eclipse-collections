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
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.primitive.CharList;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapCharIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapCharIterableTest {

    private final CharList list = CharLists.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);

    @Test
    public void charIterator() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        long sum = 0L;
        for (CharIterator iterator = iterable.charIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(15L, sum);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        long[] sum = new long[1];
        iterable.forEach((char each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.anySatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(iterable.anySatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void allSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(iterable.allSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(iterable.allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(iterable.allSatisfy(CharPredicates.lessThan((char) 4)));
    }

    @Test
    public void noneSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(iterable.noneSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(iterable.noneSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(iterable.noneSatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void select() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Verify.assertSize(4, iterable.select(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, iterable.select(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void reject() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Verify.assertSize(1, iterable.reject(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, iterable.reject(CharPredicates.greaterThan((char) 0)));
    }

    @Test
    public void detectIfNone() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(4L, iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
    }

    @Test
    public void collect() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals((char) 5, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals((char) 1, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals((char) 1, iterable.minIfEmpty((char) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals((char) 5, iterable.maxIfEmpty((char) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new TapCharIterable(new CharArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new TapCharIterable(new CharArrayList(), System.out::println).min();
    }

    @Test
    public void average() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new TapCharIterable(new CharArrayList(), System.out::println).average();
    }

    @Test
    public void median() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new TapCharIterable(new CharArrayList(), System.out::println).median();
    }

    @Test
    public void toArray() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertArrayEquals(new char[] { 1, 2, 3, 4, 5 }, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.contains((char) 1));
        Assert.assertTrue(iterable.contains((char) 2));
        Assert.assertFalse(iterable.contains((char) 6));
    }

    @Test
    public void containsAllArray() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll((char) 1));
        Assert.assertTrue(iterable.containsAll((char) 2));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(iterable.containsAll((char) 4, (char) 5, (char) 6));
    }

    @Test
    public void containsAllIterable() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 2)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(iterable.containsAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
    }

    @Test
    public void toSortedArray() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertArrayEquals(new char[] { 1, 2, 3, 4, 5 }, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto() {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 15), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapCharIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapCharIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapCharIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.charIterator = TapCharIterableTest::charIterator;
            this.payloads.forEach = TapCharIterableTest::forEach;
            this.payloads.size = TapCharIterableTest::size;
            this.payloads.empty = TapCharIterableTest::empty;
            this.payloads.count = TapCharIterableTest::count;
            this.payloads.anySatisfy = TapCharIterableTest::anySatisfy;
            this.payloads.allSatisfy = TapCharIterableTest::allSatisfy;
            this.payloads.noneSatisfy = TapCharIterableTest::noneSatisfy;
            this.payloads.select = TapCharIterableTest::select;
            this.payloads.reject = TapCharIterableTest::reject;
            this.payloads.detectIfNone = TapCharIterableTest::detectIfNone;
            this.payloads.collect = TapCharIterableTest::collect;
            this.payloads.sum = TapCharIterableTest::sum;
            this.payloads.max = TapCharIterableTest::max;
            this.payloads.min = TapCharIterableTest::min;
            this.payloads.minIfEmpty = TapCharIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = TapCharIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapCharIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapCharIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = TapCharIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapCharIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = TapCharIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapCharIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = TapCharIterableTest::toArray;
            this.payloads.contains = TapCharIterableTest::contains;
            this.payloads.containsAllArray = TapCharIterableTest::containsAllArray;
            this.payloads.containsAllIterable = TapCharIterableTest::containsAllIterable;
            this.payloads.toSortedArray = TapCharIterableTest::toSortedArray;
            this.payloads.toList = TapCharIterableTest::toList;
            this.payloads.toSortedList = TapCharIterableTest::toSortedList;
            this.payloads.toSet = TapCharIterableTest::toSet;
            this.payloads.toBag = TapCharIterableTest::toBag;
            this.payloads.asLazy = TapCharIterableTest::asLazy;
            this.payloads.injectInto = TapCharIterableTest::injectInto;
        }
    }
}
