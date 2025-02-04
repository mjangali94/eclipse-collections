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
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.primitive.ByteList;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapByteIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapByteIterableTest {

    private final ByteList list = ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);

    @Test
    public void byteIterator() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        long sum = 0L;
        for (ByteIterator iterator = iterable.byteIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(15L, sum);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        long[] sum = new long[1];
        iterable.forEach((byte each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.anySatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(iterable.anySatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void allSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(iterable.allSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(iterable.allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(iterable.allSatisfy(BytePredicates.lessThan((byte) 4)));
    }

    @Test
    public void noneSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(iterable.noneSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(iterable.noneSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(iterable.noneSatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void select() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Verify.assertSize(4, iterable.select(BytePredicates.greaterThan((byte) 1)));
        Verify.assertSize(0, iterable.select(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void reject() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Verify.assertSize(1, iterable.reject(BytePredicates.greaterThan((byte) 1)));
        Verify.assertSize(0, iterable.reject(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void detectIfNone() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals(4L, iterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
    }

    @Test
    public void collect() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals((byte) 5, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals((byte) 1, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals((byte) 1, iterable.minIfEmpty((byte) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals((byte) 5, iterable.maxIfEmpty((byte) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new TapByteIterable(new ByteArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new TapByteIterable(new ByteArrayList(), System.out::println).min();
    }

    @Test
    public void average() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new TapByteIterable(new ByteArrayList(), System.out::println).average();
    }

    @Test
    public void median() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new TapByteIterable(new ByteArrayList(), System.out::println).median();
    }

    @Test
    public void toArray() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.contains((byte) 1));
        Assert.assertTrue(iterable.contains((byte) 2));
        Assert.assertFalse(iterable.contains((byte) 6));
    }

    @Test
    public void containsAllArray() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll((byte) 1));
        Assert.assertTrue(iterable.containsAll((byte) 2));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(iterable.containsAll((byte) 4, (byte) 5, (byte) 6));
    }

    @Test
    public void containsAllIterable() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 2)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 4, (byte) 5, (byte) 6)));
    }

    @Test
    public void toSortedArray() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto() {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 15), result);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapByteIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapByteIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapByteIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.byteIterator = TapByteIterableTest::byteIterator;
            this.payloads.forEach = TapByteIterableTest::forEach;
            this.payloads.size = TapByteIterableTest::size;
            this.payloads.empty = TapByteIterableTest::empty;
            this.payloads.count = TapByteIterableTest::count;
            this.payloads.anySatisfy = TapByteIterableTest::anySatisfy;
            this.payloads.allSatisfy = TapByteIterableTest::allSatisfy;
            this.payloads.noneSatisfy = TapByteIterableTest::noneSatisfy;
            this.payloads.select = TapByteIterableTest::select;
            this.payloads.reject = TapByteIterableTest::reject;
            this.payloads.detectIfNone = TapByteIterableTest::detectIfNone;
            this.payloads.collect = TapByteIterableTest::collect;
            this.payloads.sum = TapByteIterableTest::sum;
            this.payloads.max = TapByteIterableTest::max;
            this.payloads.min = TapByteIterableTest::min;
            this.payloads.minIfEmpty = TapByteIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = TapByteIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapByteIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapByteIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = TapByteIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapByteIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = TapByteIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapByteIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = TapByteIterableTest::toArray;
            this.payloads.contains = TapByteIterableTest::contains;
            this.payloads.containsAllArray = TapByteIterableTest::containsAllArray;
            this.payloads.containsAllIterable = TapByteIterableTest::containsAllIterable;
            this.payloads.toSortedArray = TapByteIterableTest::toSortedArray;
            this.payloads.toList = TapByteIterableTest::toList;
            this.payloads.toSortedList = TapByteIterableTest::toSortedList;
            this.payloads.toSet = TapByteIterableTest::toSet;
            this.payloads.toBag = TapByteIterableTest::toBag;
            this.payloads.asLazy = TapByteIterableTest::asLazy;
            this.payloads.injectInto = TapByteIterableTest::injectInto;
        }
    }
*/
}
