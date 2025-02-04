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
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseByteIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseByteIterableTest {

    @Test
    public void isEmpty() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertEmpty(new ByteArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertFalse(iterable.contains((byte) 0));
        Assert.assertTrue(iterable.contains((byte) 1));
    }

    @Test
    public void containsAllArray() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertTrue(iterable.containsAll((byte) 1));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(iterable.containsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4));
    }

    @Test
    public void containsAllIterable() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4)));
    }

    @Test
    public void iterator() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        ByteIterator iterator = iterable.byteIterator();
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
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        ByteIterator iterator = iterable.byteIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        long[] sum = new long[1];
        iterable.forEach((byte each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertSize(0, new ByteArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 2).asReversed().count(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(ByteArrayList.newListWith((byte) 1, (byte) -1, (byte) 2).asReversed().anySatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(ByteArrayList.newListWith((byte) 1, (byte) -1, (byte) 2).asReversed().anySatisfy(BytePredicates.equal((byte) 0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 2).asReversed().allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3).asReversed().allSatisfy(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 2).asReversed().noneSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertTrue(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3).asReversed().noneSatisfy(BytePredicates.greaterThan((byte) 3)));
    }

    @Test
    public void select() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertSize(3, iterable.select(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(2, iterable.select(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void reject() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertSize(0, iterable.reject(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(1, iterable.reject(BytePredicates.lessThan((byte) 3)));
    }

    @Test
    public void detectIfNone() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertEquals(1L, iterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals(0L, iterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
    }

    @Test
    public void collect() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith((byte) 0, (byte) 1, (byte) 2), iterable.collect((byte parameter) -> (byte) (parameter - 1)));
    }

    @Test
    public void max() {
        Assert.assertEquals(9L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new ByteArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new ByteArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5L, new ByteArrayList().asReversed().minIfEmpty((byte) 5));
        Assert.assertEquals(0L, new ByteArrayList().asReversed().minIfEmpty((byte) 0));
        Assert.assertEquals(0L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().minIfEmpty((byte) 5));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5L, new ByteArrayList().asReversed().maxIfEmpty((byte) 5));
        Assert.assertEquals(0L, new ByteArrayList().asReversed().maxIfEmpty((byte) 0));
        Assert.assertEquals(9L, ByteArrayList.newListWith((byte) 1, (byte) 0, (byte) 9, (byte) 7).asReversed().maxIfEmpty((byte) 5));
    }

    @Test
    public void sum() {
        Assert.assertEquals(10L, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).asReversed().sum());
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 3, (byte) 4, (byte) 2, (byte) 1 }, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 4, (byte) 3).asReversed().toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 3, (byte) 7, (byte) 9 }, ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).asReversed().toSortedArray());
    }

    @Test
    public void testToString() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertEquals("[1, 2, 3]", iterable.toString());
        Assert.assertEquals("[]", new ByteArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        Assert.assertEquals("1, 2, 3", iterable.makeString());
        Assert.assertEquals("1", ByteArrayList.newListWith((byte) 1).makeString("/"));
        Assert.assertEquals("1/2/3", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new ByteArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        ByteIterable iterable = ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed();
        StringBuilder appendable = new StringBuilder();
        new ByteArrayList().asReversed().appendString(appendable);
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
        Assert.assertEquals(ByteArrayList.newListWith((byte) 2, (byte) 1), ByteArrayList.newListWith((byte) 1, (byte) 2).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteArrayList.newListWith((byte) 2, (byte) 3, (byte) 1).asReversed().toSortedList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseByteIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseByteIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseByteIterableTest> toSortedList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseByteIterableTest::isEmpty;
            this.payloads.contains = ReverseByteIterableTest::contains;
            this.payloads.containsAllArray = ReverseByteIterableTest::containsAllArray;
            this.payloads.containsAllIterable = ReverseByteIterableTest::containsAllIterable;
            this.payloads.iterator = ReverseByteIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseByteIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseByteIterableTest::forEach;
            this.payloads.size = ReverseByteIterableTest::size;
            this.payloads.empty = ReverseByteIterableTest::empty;
            this.payloads.count = ReverseByteIterableTest::count;
            this.payloads.anySatisfy = ReverseByteIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseByteIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseByteIterableTest::noneSatisfy;
            this.payloads.select = ReverseByteIterableTest::select;
            this.payloads.reject = ReverseByteIterableTest::reject;
            this.payloads.detectIfNone = ReverseByteIterableTest::detectIfNone;
            this.payloads.collect = ReverseByteIterableTest::collect;
            this.payloads.max = ReverseByteIterableTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseByteIterableTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ReverseByteIterableTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseByteIterableTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ReverseByteIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = ReverseByteIterableTest::maxIfEmpty;
            this.payloads.sum = ReverseByteIterableTest::sum;
            this.payloads.average = ReverseByteIterableTest::average;
            this.payloads.median = ReverseByteIterableTest::median;
            this.payloads.toArray = ReverseByteIterableTest::toArray;
            this.payloads.toSortedArray = ReverseByteIterableTest::toSortedArray;
            this.payloads.testToString = ReverseByteIterableTest::testToString;
            this.payloads.makeString = ReverseByteIterableTest::makeString;
            this.payloads.appendString = ReverseByteIterableTest::appendString;
            this.payloads.toList = ReverseByteIterableTest::toList;
            this.payloads.toSet = ReverseByteIterableTest::toSet;
            this.payloads.toBag = ReverseByteIterableTest::toBag;
            this.payloads.asLazy = ReverseByteIterableTest::asLazy;
            this.payloads.toSortedList = ReverseByteIterableTest::toSortedList;
        }
    }
*/
}
