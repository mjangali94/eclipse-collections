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
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectCharIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectCharIterableTest {

    private final SelectCharIterable iterable = new SelectCharIterable(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), CharPredicates.lessThan((char) 3));

    @Test
    public void charIterator() {
        long sum = 0L;
        for (CharIterator iterator = this.iterable.charIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach() {
        long[] sum = new long[1];
        this.iterable.forEach((char each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(0L, this.iterable.count(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.iterable.anySatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertTrue(this.iterable.allSatisfy(CharPredicates.lessThan((char) 4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, this.iterable.select(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, this.iterable.reject(CharPredicates.greaterThan((char) 0)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1L, this.iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
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
        Assert.assertEquals((char) 2, this.iterable.max());
    }

    @Test
    public void min() {
        Assert.assertEquals((char) 1, this.iterable.min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals((char) 1, this.iterable.minIfEmpty((char) 0));
        Assert.assertEquals((char) 0, this.iterable.select(CharPredicates.lessThan((char) 0)).minIfEmpty((char) 0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals((char) 2, this.iterable.maxIfEmpty((char) 0));
        Assert.assertEquals((char) 0, this.iterable.select(CharPredicates.lessThan((char) 0)).maxIfEmpty((char) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new char[] { 1, 2 }, this.iterable.toArray());
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains((char) 1));
        Assert.assertTrue(this.iterable.contains((char) 2));
        Assert.assertFalse(this.iterable.contains((char) 3));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll((char) 1));
        Assert.assertTrue(this.iterable.containsAll((char) 2));
        Assert.assertTrue(this.iterable.containsAll((char) 1, (char) 2));
        Assert.assertFalse(this.iterable.containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(this.iterable.containsAll((char) 4, (char) 5, (char) 6));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(this.iterable.containsAll(CharArrayList.newListWith((char) 2)));
        Assert.assertTrue(this.iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertFalse(this.iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(this.iterable.containsAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new char[] { 1, 2 }, this.iterable.toSortedArray());
    }

    @Test
    public void toList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableCharacter result = this.iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 3), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectCharIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectCharIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectCharIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.charIterator = SelectCharIterableTest::charIterator;
            this.payloads.forEach = SelectCharIterableTest::forEach;
            this.payloads.size = SelectCharIterableTest::size;
            this.payloads.empty = SelectCharIterableTest::empty;
            this.payloads.count = SelectCharIterableTest::count;
            this.payloads.anySatisfy = SelectCharIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectCharIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SelectCharIterableTest::noneSatisfy;
            this.payloads.select = SelectCharIterableTest::select;
            this.payloads.reject = SelectCharIterableTest::reject;
            this.payloads.detectIfNone = SelectCharIterableTest::detectIfNone;
            this.payloads.collect = SelectCharIterableTest::collect;
            this.payloads.sum = SelectCharIterableTest::sum;
            this.payloads.max = SelectCharIterableTest::max;
            this.payloads.min = SelectCharIterableTest::min;
            this.payloads.minIfEmpty = SelectCharIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SelectCharIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectCharIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectCharIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SelectCharIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectCharIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SelectCharIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectCharIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SelectCharIterableTest::toArray;
            this.payloads.contains = SelectCharIterableTest::contains;
            this.payloads.containsAllArray = SelectCharIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SelectCharIterableTest::containsAllIterable;
            this.payloads.toSortedArray = SelectCharIterableTest::toSortedArray;
            this.payloads.toList = SelectCharIterableTest::toList;
            this.payloads.toSortedList = SelectCharIterableTest::toSortedList;
            this.payloads.toSet = SelectCharIterableTest::toSet;
            this.payloads.toBag = SelectCharIterableTest::toBag;
            this.payloads.asLazy = SelectCharIterableTest::asLazy;
            this.payloads.injectInto = SelectCharIterableTest::injectInto;
        }
    }
}
