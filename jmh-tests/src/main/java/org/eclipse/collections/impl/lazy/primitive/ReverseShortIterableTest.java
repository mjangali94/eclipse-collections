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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseShortIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseShortIterableTest {

    @Test
    public void isEmpty() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Verify.assertEmpty(new ShortArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertFalse(iterable.contains((short) 0));
        Assert.assertTrue(iterable.contains((short) 1));
    }

    @Test
    public void containsAllArray() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertTrue(iterable.containsAll((short) 1));
        Assert.assertTrue(iterable.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(iterable.containsAll((short) 1, (short) 2, (short) 3, (short) 4));
    }

    @Test
    public void containsAllIterable() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4)));
    }

    @Test
    public void iterator() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        ShortIterator iterator = iterable.shortIterator();
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
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        ShortIterator iterator = iterable.shortIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        long[] sum = new long[1];
        iterable.forEach((short each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Verify.assertSize(0, new ShortArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, ShortArrayList.newListWith((short) 1, (short) 0, (short) 2).asReversed().count(ShortPredicates.greaterThan((short) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(ShortArrayList.newListWith((short) 1, (short) -1, (short) 2).asReversed().anySatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(ShortArrayList.newListWith((short) 1, (short) -1, (short) 2).asReversed().anySatisfy(ShortPredicates.equal((short) 0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(ShortArrayList.newListWith((short) 1, (short) 0, (short) 2).asReversed().allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3).asReversed().allSatisfy(ShortPredicates.greaterThan((short) 0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(ShortArrayList.newListWith((short) 1, (short) 0, (short) 2).asReversed().noneSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3).asReversed().noneSatisfy(ShortPredicates.greaterThan((short) 3)));
    }

    @Test
    public void select() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Verify.assertSize(3, iterable.select(ShortPredicates.lessThan((short) 4)));
        Verify.assertSize(2, iterable.select(ShortPredicates.lessThan((short) 3)));
    }

    @Test
    public void reject() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Verify.assertSize(0, iterable.reject(ShortPredicates.lessThan((short) 4)));
        Verify.assertSize(1, iterable.reject(ShortPredicates.lessThan((short) 3)));
    }

    @Test
    public void detectIfNone() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertEquals(1L, iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(0L, iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
    }

    @Test
    public void collect() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith((short) 0, (short) 1, (short) 2), iterable.collect((short parameter) -> (short) (parameter - 1)));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, ShortArrayList.newListWith((short) 1, (short) 0, (short) 9, (short) 7).asReversed().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new ShortArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, ShortArrayList.newListWith((short) 1, (short) 0, (short) 9, (short) 7).asReversed().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new ShortArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, new ShortArrayList().asReversed().minIfEmpty((short) 5));
        Assert.assertEquals(0L, new ShortArrayList().asReversed().minIfEmpty((short) 0));
        Assert.assertEquals(0L, ShortArrayList.newListWith((short) 1, (short) 0, (short) 9, (short) 7).asReversed().minIfEmpty((short) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, new ShortArrayList().asReversed().maxIfEmpty((short) 5));
        Assert.assertEquals(0L, new ShortArrayList().asReversed().maxIfEmpty((short) 0));
        Assert.assertEquals(9L, ShortArrayList.newListWith((short) 1, (short) 0, (short) 9, (short) 7).asReversed().maxIfEmpty((short) 5));
    }

    @Test
    public void sum() {
        Assert.assertEquals(10L, ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4).asReversed().sum());
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new short[] { (short) 3, (short) 4, (short) 2, (short) 1 }, ShortArrayList.newListWith((short) 1, (short) 2, (short) 4, (short) 3).asReversed().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 3, (short) 7, (short) 9 }, ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7).asReversed().toSortedArray());
    }

    @Test
    public void testToString() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertEquals("[1, 2, 3]", iterable.toString());
        Assert.assertEquals("[]", new ShortArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        Assert.assertEquals("1, 2, 3", iterable.makeString());
        Assert.assertEquals("1", ShortArrayList.newListWith((short) 1).makeString("/"));
        Assert.assertEquals("1/2/3", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new ShortArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        ShortIterable iterable = ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed();
        StringBuilder appendable = new StringBuilder();
        new ShortArrayList().asReversed().appendString(appendable);
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
        Assert.assertEquals(ShortArrayList.newListWith((short) 2, (short) 1), ShortArrayList.newListWith((short) 1, (short) 2).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ShortArrayList.newListWith((short) 3, (short) 2, (short) 1).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ShortArrayList.newListWith((short) 2, (short) 3, (short) 1).asReversed().toSortedList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseShortIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseShortIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseShortIterableTest> toSortedList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseShortIterableTest::isEmpty;
            this.payloads.contains = ReverseShortIterableTest::contains;
            this.payloads.containsAllArray = ReverseShortIterableTest::containsAllArray;
            this.payloads.containsAllIterable = ReverseShortIterableTest::containsAllIterable;
            this.payloads.iterator = ReverseShortIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseShortIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseShortIterableTest::forEach;
            this.payloads.size = ReverseShortIterableTest::size;
            this.payloads.empty = ReverseShortIterableTest::empty;
            this.payloads.count = ReverseShortIterableTest::count;
            this.payloads.anySatisfy = ReverseShortIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseShortIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseShortIterableTest::noneSatisfy;
            this.payloads.select = ReverseShortIterableTest::select;
            this.payloads.reject = ReverseShortIterableTest::reject;
            this.payloads.detectIfNone = ReverseShortIterableTest::detectIfNone;
            this.payloads.collect = ReverseShortIterableTest::collect;
            this.payloads.max = ReverseShortIterableTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseShortIterableTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ReverseShortIterableTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseShortIterableTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ReverseShortIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = ReverseShortIterableTest::maxIfEmpty;
            this.payloads.sum = ReverseShortIterableTest::sum;
            this.payloads.average = ReverseShortIterableTest::average;
            this.payloads.median = ReverseShortIterableTest::median;
            this.payloads.toArray = ReverseShortIterableTest::toArray;
            this.payloads.toSortedArray = ReverseShortIterableTest::toSortedArray;
            this.payloads.testToString = ReverseShortIterableTest::testToString;
            this.payloads.makeString = ReverseShortIterableTest::makeString;
            this.payloads.appendString = ReverseShortIterableTest::appendString;
            this.payloads.toList = ReverseShortIterableTest::toList;
            this.payloads.toSet = ReverseShortIterableTest::toSet;
            this.payloads.toBag = ReverseShortIterableTest::toBag;
            this.payloads.asLazy = ReverseShortIterableTest::asLazy;
            this.payloads.toSortedList = ReverseShortIterableTest::toSortedList;
        }
    }
*/
}
