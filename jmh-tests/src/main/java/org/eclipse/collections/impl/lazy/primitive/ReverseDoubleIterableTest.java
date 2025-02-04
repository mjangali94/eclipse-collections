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
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseDoubleIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseDoubleIterableTest {

    @Test
    public void isEmpty() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertEmpty(new DoubleArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertFalse(iterable.contains(0.0));
        Assert.assertTrue(iterable.contains(1.0));
    }

    @Test
    public void containsAllArray() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.containsAll(1.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(iterable.containsAll(1.0, 2.0, 3.0, 4.0));
    }

    @Test
    public void containsAllIterable() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0)));
    }

    @Test
    public void iterator() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        DoubleIterator iterator = iterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        DoubleIterator iterator = iterable.doubleIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        double[] sum = new double[1];
        iterable.forEach((double each) -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void size() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(0, new DoubleArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().count(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, -1.0, 2.0).asReversed().anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, -1.0, 2.0).asReversed().anySatisfy(DoublePredicates.equal(0.0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, 2.0, 3.0).asReversed().allSatisfy(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, 2.0, 3.0).asReversed().noneSatisfy(DoublePredicates.greaterThan(3.0)));
    }

    @Test
    public void select() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(3, iterable.select(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(2, iterable.select(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void reject() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(0, iterable.reject(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(1, iterable.reject(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void detectIfNone() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals(1.0, iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(0.0, iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
    }

    @Test
    public void collect() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0.0, 1.0, 2.0), iterable.collect((double parameter) -> parameter - 1));
    }

    @Test
    public void max() {
        Assert.assertEquals(9.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new DoubleArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new DoubleArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, new DoubleArrayList().asReversed().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleArrayList().asReversed().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().minIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, new DoubleArrayList().asReversed().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleArrayList().asReversed().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(9.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum() {
        Assert.assertEquals(10.0, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        DoubleIterable iterable = DoubleArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).asReversed().toArray());
        Assert.assertEquals(1.082323233711138, iterable.sum(), 1.0e-15);
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new double[] { 3.0, 4.0, 2.0, 1.0 }, DoubleArrayList.newListWith(1.0, 2.0, 4.0, 3.0).asReversed().toArray(), 0.0);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new double[] { 1.0, 3.0, 7.0, 9.0 }, DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0).asReversed().toSortedArray(), 0.0);
    }

    @Test
    public void testToString() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals("[1.0, 2.0, 3.0]", iterable.toString());
        Assert.assertEquals("[]", new DoubleArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals("1.0, 2.0, 3.0", iterable.makeString());
        Assert.assertEquals("1.0", DoubleArrayList.newListWith(1.0).makeString("/"));
        Assert.assertEquals("1.0/2.0/3.0", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new DoubleArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        StringBuilder appendable = new StringBuilder();
        new DoubleArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(DoubleArrayList.newListWith(2.0, 1.0), DoubleArrayList.newListWith(1.0, 2.0).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(2.0, 3.0, 1.0).asReversed().toSortedList());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseDoubleIterableTest instance;

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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseDoubleIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseDoubleIterableTest> toSortedList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseDoubleIterableTest::isEmpty;
            this.payloads.contains = ReverseDoubleIterableTest::contains;
            this.payloads.containsAllArray = ReverseDoubleIterableTest::containsAllArray;
            this.payloads.containsAllIterable = ReverseDoubleIterableTest::containsAllIterable;
            this.payloads.iterator = ReverseDoubleIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseDoubleIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseDoubleIterableTest::forEach;
            this.payloads.size = ReverseDoubleIterableTest::size;
            this.payloads.empty = ReverseDoubleIterableTest::empty;
            this.payloads.count = ReverseDoubleIterableTest::count;
            this.payloads.anySatisfy = ReverseDoubleIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseDoubleIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseDoubleIterableTest::noneSatisfy;
            this.payloads.select = ReverseDoubleIterableTest::select;
            this.payloads.reject = ReverseDoubleIterableTest::reject;
            this.payloads.detectIfNone = ReverseDoubleIterableTest::detectIfNone;
            this.payloads.collect = ReverseDoubleIterableTest::collect;
            this.payloads.max = ReverseDoubleIterableTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseDoubleIterableTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ReverseDoubleIterableTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseDoubleIterableTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ReverseDoubleIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = ReverseDoubleIterableTest::maxIfEmpty;
            this.payloads.sum = ReverseDoubleIterableTest::sum;
            this.payloads.sumConsistentRounding = ReverseDoubleIterableTest::sumConsistentRounding;
            this.payloads.average = ReverseDoubleIterableTest::average;
            this.payloads.median = ReverseDoubleIterableTest::median;
            this.payloads.toArray = ReverseDoubleIterableTest::toArray;
            this.payloads.toSortedArray = ReverseDoubleIterableTest::toSortedArray;
            this.payloads.testToString = ReverseDoubleIterableTest::testToString;
            this.payloads.makeString = ReverseDoubleIterableTest::makeString;
            this.payloads.appendString = ReverseDoubleIterableTest::appendString;
            this.payloads.toList = ReverseDoubleIterableTest::toList;
            this.payloads.toSet = ReverseDoubleIterableTest::toSet;
            this.payloads.toBag = ReverseDoubleIterableTest::toBag;
            this.payloads.asLazy = ReverseDoubleIterableTest::asLazy;
            this.payloads.toSortedList = ReverseDoubleIterableTest::toSortedList;
        }
    }
*/
}
