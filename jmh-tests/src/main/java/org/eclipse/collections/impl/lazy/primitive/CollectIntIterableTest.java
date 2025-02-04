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
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectIntIterableTest {

    private final IntIterable intIterable = Interval.oneTo(3).collectInt(PrimitiveFunctions.unboxIntegerToInt());

    @Test
    public void iterator() {
        long sum = 0L;
        IntIterator iterator = this.intIterable.intIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size() {
        Assert.assertEquals(3L, this.intIterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.intIterable.notEmpty());
        Assert.assertFalse(this.intIterable.isEmpty());
    }

    @Test
    public void forEach() {
        long[] value = new long[1];
        this.intIterable.forEach(each -> {
            value[0] += each;
        });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.intIterable.count(IntPredicates.equal(1)));
        Assert.assertEquals(3, this.intIterable.count(IntPredicates.lessThan(4)));
        Assert.assertEquals(2, this.intIterable.count(IntPredicates.greaterThan(1)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.intIterable.anySatisfy(IntPredicates.greaterThan(1)));
        Assert.assertTrue(this.intIterable.anySatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(this.intIterable.anySatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.intIterable.noneSatisfy(IntPredicates.greaterThan(2)));
        Assert.assertTrue(this.intIterable.noneSatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.intIterable.allSatisfy(IntPredicates.lessThan(4)));
        Assert.assertFalse(this.intIterable.allSatisfy(IntPredicates.lessThan(3)));
    }

    @Test
    public void select() {
        Assert.assertEquals(3L, this.intIterable.select(IntPredicates.lessThan(4)).size());
        Assert.assertEquals(2L, this.intIterable.select(IntPredicates.lessThan(3)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(0L, this.intIterable.reject(IntPredicates.lessThan(4)).size());
        Assert.assertEquals(1L, this.intIterable.reject(IntPredicates.lessThan(3)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1, this.intIterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(0, this.intIterable.detectIfNone(IntPredicates.greaterThan(3), 0));
    }

    @Test
    public void sum() {
        Assert.assertEquals(6L, this.intIterable.sum());
    }

    @Test
    public void max() {
        Assert.assertEquals(3, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).max());
    }

    @Test
    public void min() {
        Assert.assertEquals(0, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).min());
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(0, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).minIfEmpty(0));
        Assert.assertEquals(0, FastList.<Integer>newList().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).minIfEmpty(0));
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(3, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).maxIfEmpty(0));
        Assert.assertEquals(0, FastList.<Integer>newList().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).maxIfEmpty(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectInt(PrimitiveFunctions.unboxIntegerToInt()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectInt(PrimitiveFunctions.unboxIntegerToInt()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectInt(PrimitiveFunctions.unboxIntegerToInt()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, Interval.oneTo(4).collectInt(PrimitiveFunctions.unboxIntegerToInt()).toArray());
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt()).toSortedArray());
    }

    @Test
    public void contains() {
        IntIterable intIterable = Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertTrue(intIterable.contains(1));
        Assert.assertTrue(intIterable.contains(3));
        Assert.assertTrue(intIterable.contains(4));
        Assert.assertFalse(intIterable.contains(5));
    }

    @Test
    public void containsAllArray() {
        IntIterable intIterable = Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertTrue(intIterable.containsAll(1));
        Assert.assertTrue(intIterable.containsAll(1, 2, 3, 4));
        Assert.assertFalse(intIterable.containsAll(1, 2, 3, 4, 5));
        Assert.assertFalse(intIterable.containsAll(7, 6, 5));
    }

    @Test
    public void containsAllIterable() {
        IntIterable intIterable = Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertTrue(intIterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(intIterable.containsAll(IntArrayList.newListWith(1, 2, 3, 4)));
        Assert.assertFalse(intIterable.containsAll(IntArrayList.newListWith(1, 2, 3, 4, 5)));
        Assert.assertFalse(intIterable.containsAll(IntArrayList.newListWith(7, 6, 5)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.intIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[1, 2, 3]", this.intIterable.toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals("1, 2, 3", this.intIterable.makeString());
        Assert.assertEquals("1/2/3", this.intIterable.makeString("/"));
        Assert.assertEquals("[1, 2, 3]", this.intIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.intIterable.appendString(appendable);
        Assert.assertEquals("1, 2, 3", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.intIterable.appendString(appendable2, "/");
        Assert.assertEquals("1/2/3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.intIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.intIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.intIterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.intIterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), this.intIterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.intIterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.intIterable.toSet(), this.intIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, this.intIterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectIntIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectIntIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectIntIterableTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterator = CollectIntIterableTest::iterator;
            this.payloads.size = CollectIntIterableTest::size;
            this.payloads.empty = CollectIntIterableTest::empty;
            this.payloads.forEach = CollectIntIterableTest::forEach;
            this.payloads.count = CollectIntIterableTest::count;
            this.payloads.anySatisfy = CollectIntIterableTest::anySatisfy;
            this.payloads.noneSatisfy = CollectIntIterableTest::noneSatisfy;
            this.payloads.allSatisfy = CollectIntIterableTest::allSatisfy;
            this.payloads.select = CollectIntIterableTest::select;
            this.payloads.reject = CollectIntIterableTest::reject;
            this.payloads.detectIfNone = CollectIntIterableTest::detectIfNone;
            this.payloads.sum = CollectIntIterableTest::sum;
            this.payloads.max = CollectIntIterableTest::max;
            this.payloads.min = CollectIntIterableTest::min;
            this.payloads.minIfEmpty = CollectIntIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = CollectIntIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIntIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIntIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = CollectIntIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIntIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CollectIntIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectIntIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = CollectIntIterableTest::toArray;
            this.payloads.toSortedArray = CollectIntIterableTest::toSortedArray;
            this.payloads.contains = CollectIntIterableTest::contains;
            this.payloads.containsAllArray = CollectIntIterableTest::containsAllArray;
            this.payloads.containsAllIterable = CollectIntIterableTest::containsAllIterable;
            this.payloads.collect = CollectIntIterableTest::collect;
            this.payloads.testToString = CollectIntIterableTest::testToString;
            this.payloads.makeString = CollectIntIterableTest::makeString;
            this.payloads.appendString = CollectIntIterableTest::appendString;
            this.payloads.toList = CollectIntIterableTest::toList;
            this.payloads.toSortedList = CollectIntIterableTest::toSortedList;
            this.payloads.toSet = CollectIntIterableTest::toSet;
            this.payloads.toBag = CollectIntIterableTest::toBag;
            this.payloads.asLazy = CollectIntIterableTest::asLazy;
        }
    }
}
