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
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseFloatIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseFloatIterableTest {

    @Test
    public void isEmpty() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertEmpty(new FloatArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertFalse(iterable.contains(0.0f));
        Assert.assertTrue(iterable.contains(1.0f));
    }

    @Test
    public void containsAllArray() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertTrue(iterable.containsAll(1.0f));
        Assert.assertTrue(iterable.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(iterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f));
    }

    @Test
    public void containsAllIterable() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f)));
    }

    @Test
    public void iterator() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        FloatIterator iterator = iterable.floatIterator();
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
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        FloatIterator iterator = iterable.floatIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        double[] sum = new double[1];
        iterable.forEach((float each) -> sum[0] += each);
        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void size() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertSize(0, new FloatArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count() {
        Assert.assertEquals(2L, FloatArrayList.newListWith(1.0f, 0.0f, 2.0f).asReversed().count(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(FloatArrayList.newListWith(1.0f, -1.0f, 2.0f).asReversed().anySatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(FloatArrayList.newListWith(1.0f, -1.0f, 2.0f).asReversed().anySatisfy(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertFalse(FloatArrayList.newListWith(1.0f, 0.0f, 2.0f).asReversed().allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f).asReversed().allSatisfy(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(FloatArrayList.newListWith(1.0f, 0.0f, 2.0f).asReversed().noneSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertTrue(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f).asReversed().noneSatisfy(FloatPredicates.greaterThan(3.0f)));
    }

    @Test
    public void select() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertSize(3, iterable.select(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(2, iterable.select(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void reject() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertSize(0, iterable.reject(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(1, iterable.reject(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void detectIfNone() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertEquals(1.0, iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(0.0, iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
    }

    @Test
    public void collect() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0.0f, 1.0f, 2.0f), iterable.collect((float parameter) -> parameter - 1));
    }

    @Test
    public void max() {
        Assert.assertEquals(9.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList() {
        new FloatArrayList().asReversed().max();
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList() {
        new FloatArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(5.0, new FloatArrayList().asReversed().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, new FloatArrayList().asReversed().minIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().minIfEmpty(5.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(5.0, new FloatArrayList().asReversed().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, new FloatArrayList().asReversed().maxIfEmpty(0.0f), 0.0);
        Assert.assertEquals(9.0, FloatArrayList.newListWith(1.0f, 0.0f, 9.0f, 7.0f).asReversed().maxIfEmpty(5.0f), 0.0);
    }

    @Test
    public void sum() {
        Assert.assertEquals(10.0, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f).asReversed().sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = FloatArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())).asReversed().toArray());
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f).asReversed().average(), 0.0);
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).asReversed().median(), 0.0);
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new float[] { 3.0f, 4.0f, 2.0f, 1.0f }, FloatArrayList.newListWith(1.0f, 2.0f, 4.0f, 3.0f).asReversed().toArray(), 0.0f);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 1.0f, 3.0f, 7.0f, 9.0f }, FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f).asReversed().toSortedArray(), 0.0f);
    }

    @Test
    public void testToString() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertEquals("[1.0, 2.0, 3.0]", iterable.toString());
        Assert.assertEquals("[]", new FloatArrayList().asReversed().toString());
    }

    @Test
    public void makeString() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        Assert.assertEquals("1.0, 2.0, 3.0", iterable.makeString());
        Assert.assertEquals("1.0", FloatArrayList.newListWith(1.0f).makeString("/"));
        Assert.assertEquals("1.0/2.0/3.0", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new FloatArrayList().asReversed().makeString());
    }

    @Test
    public void appendString() {
        FloatIterable iterable = FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed();
        StringBuilder appendable = new StringBuilder();
        new FloatArrayList().asReversed().appendString(appendable);
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
        Assert.assertEquals(FloatArrayList.newListWith(2.0f, 1.0f), FloatArrayList.newListWith(1.0f, 2.0f).asReversed().toList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed().toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed().toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatArrayList.newListWith(2.0f, 3.0f, 1.0f).asReversed().toSortedList());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ReverseFloatIterableTest instance;

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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ReverseFloatIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ReverseFloatIterableTest> toSortedList;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ReverseFloatIterableTest::isEmpty;
            this.payloads.contains = ReverseFloatIterableTest::contains;
            this.payloads.containsAllArray = ReverseFloatIterableTest::containsAllArray;
            this.payloads.containsAllIterable = ReverseFloatIterableTest::containsAllIterable;
            this.payloads.iterator = ReverseFloatIterableTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseFloatIterableTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ReverseFloatIterableTest::forEach;
            this.payloads.size = ReverseFloatIterableTest::size;
            this.payloads.empty = ReverseFloatIterableTest::empty;
            this.payloads.count = ReverseFloatIterableTest::count;
            this.payloads.anySatisfy = ReverseFloatIterableTest::anySatisfy;
            this.payloads.allSatisfy = ReverseFloatIterableTest::allSatisfy;
            this.payloads.noneSatisfy = ReverseFloatIterableTest::noneSatisfy;
            this.payloads.select = ReverseFloatIterableTest::select;
            this.payloads.reject = ReverseFloatIterableTest::reject;
            this.payloads.detectIfNone = ReverseFloatIterableTest::detectIfNone;
            this.payloads.collect = ReverseFloatIterableTest::collect;
            this.payloads.max = ReverseFloatIterableTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseFloatIterableTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ReverseFloatIterableTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ReverseFloatIterableTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ReverseFloatIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = ReverseFloatIterableTest::maxIfEmpty;
            this.payloads.sum = ReverseFloatIterableTest::sum;
            this.payloads.sumConsistentRounding = ReverseFloatIterableTest::sumConsistentRounding;
            this.payloads.average = ReverseFloatIterableTest::average;
            this.payloads.median = ReverseFloatIterableTest::median;
            this.payloads.toArray = ReverseFloatIterableTest::toArray;
            this.payloads.toSortedArray = ReverseFloatIterableTest::toSortedArray;
            this.payloads.testToString = ReverseFloatIterableTest::testToString;
            this.payloads.makeString = ReverseFloatIterableTest::makeString;
            this.payloads.appendString = ReverseFloatIterableTest::appendString;
            this.payloads.toList = ReverseFloatIterableTest::toList;
            this.payloads.toSet = ReverseFloatIterableTest::toSet;
            this.payloads.toBag = ReverseFloatIterableTest::toBag;
            this.payloads.asLazy = ReverseFloatIterableTest::asLazy;
            this.payloads.toSortedList = ReverseFloatIterableTest::toSortedList;
        }
    }
}
