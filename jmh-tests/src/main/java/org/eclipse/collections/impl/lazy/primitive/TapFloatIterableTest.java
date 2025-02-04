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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.primitive.FloatList;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapFloatIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapFloatIterableTest {

    private final FloatList list = FloatLists.immutable.with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);

    @Test
    public void floatIterator() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        double sum = 0.0;
        for (FloatIterator iterator = iterable.floatIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(15.0, sum, 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        double[] sum = new double[1];
        iterable.forEach((float each) -> sum[0] += each);
        Assert.assertEquals(15.0, sum[0], 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(1L, iterable.count(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.anySatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertTrue(iterable.anySatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void allSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(iterable.allSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(iterable.allSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertFalse(iterable.allSatisfy(FloatPredicates.lessThan(4.0f)));
    }

    @Test
    public void noneSatisfy() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.noneSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(iterable.noneSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertTrue(iterable.noneSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertFalse(iterable.noneSatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void select() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Verify.assertSize(4, iterable.select(FloatPredicates.greaterThan(1.0f)));
        Verify.assertSize(0, iterable.select(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void reject() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Verify.assertSize(1, iterable.reject(FloatPredicates.greaterThan(1.0f)));
        Verify.assertSize(0, iterable.reject(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void detectIfNone() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(1.0, iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(4.0, iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
    }

    @Test
    public void collect() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(15.0, iterable.sum(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(5.0f, iterable.max(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(1.0f, iterable.min(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(1.0f, iterable.minIfEmpty(0.0f), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(5.0f, iterable.maxIfEmpty(0.0f), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new TapFloatIterable(new FloatArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new TapFloatIterable(new FloatArrayList(), System.out::println).min();
    }

    @Test
    public void average() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new TapFloatIterable(new FloatArrayList(), System.out::println).average();
    }

    @Test
    public void median() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new TapFloatIterable(new FloatArrayList(), System.out::println).median();
    }

    @Test
    public void toArray() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertArrayEquals(new float[] { 1, 2, 3, 4, 5 }, iterable.toArray(), 0.0f);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.contains(1.0f));
        Assert.assertTrue(iterable.contains(2.0f));
        Assert.assertFalse(iterable.contains(6.0f));
    }

    @Test
    public void containsAllArray() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(1.0f));
        Assert.assertTrue(iterable.containsAll(2.0f));
        Assert.assertTrue(iterable.containsAll(1.0f, 2.0f));
        Assert.assertTrue(iterable.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(iterable.containsAll(4.0f, 5.0f, 6.0f));
    }

    @Test
    public void containsAllIterable() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(2.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(iterable.containsAll(FloatArrayList.newListWith(4.0f, 5.0f, 6.0f)));
    }

    @Test
    public void toSortedArray() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertArrayEquals(new float[] { 1, 2, 3, 4, 5 }, iterable.toSortedArray(), 0.0f);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto() {
        StringBuilder builder = new StringBuilder();
        TapFloatIterable iterable = new TapFloatIterable(this.list, builder::append);
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(15.0f), result);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private TapFloatIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> payload) throws java.lang.Throwable {
            this.instance = new TapFloatIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<TapFloatIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.floatIterator = TapFloatIterableTest::floatIterator;
            this.payloads.forEach = TapFloatIterableTest::forEach;
            this.payloads.size = TapFloatIterableTest::size;
            this.payloads.empty = TapFloatIterableTest::empty;
            this.payloads.count = TapFloatIterableTest::count;
            this.payloads.anySatisfy = TapFloatIterableTest::anySatisfy;
            this.payloads.allSatisfy = TapFloatIterableTest::allSatisfy;
            this.payloads.noneSatisfy = TapFloatIterableTest::noneSatisfy;
            this.payloads.select = TapFloatIterableTest::select;
            this.payloads.reject = TapFloatIterableTest::reject;
            this.payloads.detectIfNone = TapFloatIterableTest::detectIfNone;
            this.payloads.collect = TapFloatIterableTest::collect;
            this.payloads.sum = TapFloatIterableTest::sum;
            this.payloads.max = TapFloatIterableTest::max;
            this.payloads.min = TapFloatIterableTest::min;
            this.payloads.minIfEmpty = TapFloatIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = TapFloatIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapFloatIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapFloatIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = TapFloatIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapFloatIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = TapFloatIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(TapFloatIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = TapFloatIterableTest::toArray;
            this.payloads.contains = TapFloatIterableTest::contains;
            this.payloads.containsAllArray = TapFloatIterableTest::containsAllArray;
            this.payloads.containsAllIterable = TapFloatIterableTest::containsAllIterable;
            this.payloads.toSortedArray = TapFloatIterableTest::toSortedArray;
            this.payloads.toList = TapFloatIterableTest::toList;
            this.payloads.toSortedList = TapFloatIterableTest::toSortedList;
            this.payloads.toSet = TapFloatIterableTest::toSet;
            this.payloads.toBag = TapFloatIterableTest::toBag;
            this.payloads.asLazy = TapFloatIterableTest::asLazy;
            this.payloads.injectInto = TapFloatIterableTest::injectInto;
        }
    }
*/
}
