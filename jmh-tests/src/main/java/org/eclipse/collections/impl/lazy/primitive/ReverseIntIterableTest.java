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
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseIntIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseIntIterableTest {

    @Test
    public void isEmpty() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Verify.assertEmpty(new IntArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertFalse(iterable.contains(0));
        Assert.assertTrue(iterable.contains(1));
    }

    @Test
    public void containsAllArray() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertTrue(iterable.containsAll(1));
        Assert.assertTrue(iterable.containsAll(1, 2, 3));
        Assert.assertFalse(iterable.containsAll(1, 2, 3, 4));
    }

    @Test
    public void containsAllIterable() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1, 2, 3)));
        Assert.assertFalse(iterable.containsAll(IntArrayList.newListWith(1, 2, 3, 4)));
    }

    @Test
    public void iterator() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        IntIterator iterator = iterable.intIterator();
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
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        IntIterator iterator = iterable.intIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        long[] sum = new long[1];
        iterable.forEach((int each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Verify.assertSize(0, new IntArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, IntArrayList.newListWith(1, 0, 2).asReversed().count(IntPredicates.greaterThan(0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(IntArrayList.newListWith(1, -1, 2).asReversed().anySatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(IntArrayList.newListWith(1, -1, 2).asReversed().anySatisfy(IntPredicates.equal(0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(IntArrayList.newListWith(1, 0, 2).asReversed().allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(IntArrayList.newListWith(1, 2, 3).asReversed().allSatisfy(IntPredicates.greaterThan(0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(IntArrayList.newListWith(1, 0, 2).asReversed().noneSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertTrue(IntArrayList.newListWith(1, 2, 3).asReversed().noneSatisfy(IntPredicates.greaterThan(3)));
    }

    @Test
    public void select() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Verify.assertSize(3, iterable.select(IntPredicates.lessThan(4)));
        Verify.assertSize(2, iterable.select(IntPredicates.lessThan(3)));
    }

    @Test
    public void reject() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Verify.assertSize(0, iterable.reject(IntPredicates.lessThan(4)));
        Verify.assertSize(1, iterable.reject(IntPredicates.lessThan(3)));
    }

    @Test
    public void detectIfNone() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertEquals(1L, iterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(0L, iterable.detectIfNone(IntPredicates.greaterThan(3), 0));
    }

    @Test
    public void collect() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0, 1, 2), iterable.collect((int parameter) -> parameter - 1));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, IntArrayList.newListWith(1, 0, 9, 7).asReversed().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new IntArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, IntArrayList.newListWith(1, 0, 9, 7).asReversed().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new IntArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, new IntArrayList().asReversed().minIfEmpty(5));
        Assert.assertEquals(0L, new IntArrayList().asReversed().minIfEmpty(0));
        Assert.assertEquals(0L, IntArrayList.newListWith(1, 0, 9, 7).asReversed().minIfEmpty(5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, new IntArrayList().asReversed().maxIfEmpty(5));
        Assert.assertEquals(0L, new IntArrayList().asReversed().maxIfEmpty(0));
        Assert.assertEquals(9L, IntArrayList.newListWith(1, 0, 9, 7).asReversed().maxIfEmpty(5));
    }

    @Test
    public void sum() {
        Assert.assertEquals(10L, IntArrayList.newListWith(1, 2, 3, 4).asReversed().sum());
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, IntArrayList.newListWith(1, 2, 3, 4).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, IntArrayList.newListWith(1, 2, 3, 4).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, IntArrayList.newListWith(1, 2, 3, 4, 5).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new int[] { 3, 4, 2, 1 }, IntArrayList.newListWith(1, 2, 4, 3).asReversed().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new int[] { 1, 3, 7, 9 }, IntArrayList.newListWith(3, 1, 9, 7).asReversed().toSortedArray());
    }

    @Test
    public void testToString() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertEquals("[1, 2, 3]", iterable.toString());
        Assert.assertEquals("[]", new IntArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        Assert.assertEquals("1, 2, 3", iterable.makeString());
        Assert.assertEquals("1", IntArrayList.newListWith(1).makeString("/"));
        Assert.assertEquals("1/2/3", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new IntArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        IntIterable iterable = IntArrayList.newListWith(3, 2, 1).asReversed();
        StringBuilder appendable = new StringBuilder();
        new IntArrayList().asReversed().appendString(appendable);
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
        Assert.assertEquals(IntArrayList.newListWith(2, 1), IntArrayList.newListWith(1, 2).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), IntArrayList.newListWith(3, 2, 1).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), IntArrayList.newListWith(3, 2, 1).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), IntArrayList.newListWith(3, 2, 1).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), IntArrayList.newListWith(2, 3, 1).asReversed().toSortedList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseIntIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseIntIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseIntIterableTest> toSortedList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseIntIterableTest::isEmpty;
            this.payloads.contains = ReverseIntIterableTest::contains;
            this.payloads.containsAllArray = ReverseIntIterableTest::containsAllArray;
            this.payloads.containsAllIterable = ReverseIntIterableTest::containsAllIterable;
            this.payloads.iterator = ReverseIntIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseIntIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseIntIterableTest::forEach;
            this.payloads.size = ReverseIntIterableTest::size;
            this.payloads.empty = ReverseIntIterableTest::empty;
            this.payloads.count = ReverseIntIterableTest::count;
            this.payloads.anySatisfy = ReverseIntIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseIntIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseIntIterableTest::noneSatisfy;
            this.payloads.select = ReverseIntIterableTest::select;
            this.payloads.reject = ReverseIntIterableTest::reject;
            this.payloads.detectIfNone = ReverseIntIterableTest::detectIfNone;
            this.payloads.collect = ReverseIntIterableTest::collect;
            this.payloads.max = ReverseIntIterableTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseIntIterableTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ReverseIntIterableTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseIntIterableTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ReverseIntIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = ReverseIntIterableTest::maxIfEmpty;
            this.payloads.sum = ReverseIntIterableTest::sum;
            this.payloads.average = ReverseIntIterableTest::average;
            this.payloads.median = ReverseIntIterableTest::median;
            this.payloads.toArray = ReverseIntIterableTest::toArray;
            this.payloads.toSortedArray = ReverseIntIterableTest::toSortedArray;
            this.payloads.testToString = ReverseIntIterableTest::testToString;
            this.payloads.makeString = ReverseIntIterableTest::makeString;
            this.payloads.appendString = ReverseIntIterableTest::appendString;
            this.payloads.toList = ReverseIntIterableTest::toList;
            this.payloads.toSet = ReverseIntIterableTest::toSet;
            this.payloads.toBag = ReverseIntIterableTest::toBag;
            this.payloads.asLazy = ReverseIntIterableTest::asLazy;
            this.payloads.toSortedList = ReverseIntIterableTest::toSortedList;
        }
    }
}
