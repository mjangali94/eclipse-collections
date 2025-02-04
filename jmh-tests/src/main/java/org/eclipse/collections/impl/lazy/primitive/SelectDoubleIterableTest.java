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
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectDoubleIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectDoubleIterableTest {

    private final SelectDoubleIterable iterable = new SelectDoubleIterable(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), DoublePredicates.lessThan(3.0));

    @Test
    public void doubleIterator() {
        double sum = 0.0;
        for (DoubleIterator iterator = this.iterable.doubleIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3.0, sum, 0.0);
    }

    @Test
    public void forEach() {
        double[] sum = new double[1];
        this.iterable.forEach((double each) -> sum[0] += each);
        Assert.assertEquals(3.0, sum[0], 0.0);
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
        Assert.assertEquals(1L, this.iterable.count(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(0L, this.iterable.count(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(this.iterable.anySatisfy(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertTrue(this.iterable.allSatisfy(DoublePredicates.lessThan(4.0)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.lessThan(2.0)));
        Assert.assertTrue(this.iterable.noneSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertTrue(this.iterable.noneSatisfy(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(DoublePredicates.greaterThan(1.0)));
        Verify.assertSize(0, this.iterable.select(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(DoublePredicates.greaterThan(1.0)));
        Verify.assertSize(0, this.iterable.reject(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1.0, this.iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(0.0, this.iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
    }

    @Test
    public void collect() {
        Verify.assertIterableSize(2, this.iterable.collect(String::valueOf));
    }

    @Test
    public void sum() {
        Assert.assertEquals(3.0, this.iterable.sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding() {
        DoubleArrayList list = DoubleArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())).toArray());
        SelectDoubleIterable iterable = new SelectDoubleIterable(list, DoublePredicates.alwaysTrue());
        Assert.assertEquals(1.082323233711138, iterable.sum(), 1.0e-15);
    }

    @Test
    public void max() {
        Assert.assertEquals(2.0, this.iterable.max(), 0.0);
    }

    @Test
    public void min() {
        Assert.assertEquals(1.0, this.iterable.min(), 0.0);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1.0, this.iterable.minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.iterable.select(DoublePredicates.lessThan(0.0)).minIfEmpty(0.0), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2.0, this.iterable.maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.iterable.select(DoublePredicates.lessThan(0.0)).maxIfEmpty(0.0), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectDoubleIterable(new DoubleArrayList(), DoublePredicates.lessThan(3.0)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectDoubleIterable(new DoubleArrayList(), DoublePredicates.lessThan(3.0)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectDoubleIterable(new DoubleArrayList(), DoublePredicates.lessThan(3.0)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectDoubleIterable(new DoubleArrayList(), DoublePredicates.lessThan(3.0)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new double[] { 1, 2 }, this.iterable.toArray(), 0.0);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(1.0));
        Assert.assertTrue(this.iterable.contains(2.0));
        Assert.assertFalse(this.iterable.contains(3.0));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(1.0));
        Assert.assertTrue(this.iterable.containsAll(2.0));
        Assert.assertTrue(this.iterable.containsAll(1.0, 2.0));
        Assert.assertFalse(this.iterable.containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(this.iterable.containsAll(4.0, 5.0, 6.0));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(this.iterable.containsAll(DoubleArrayList.newListWith(2.0)));
        Assert.assertTrue(this.iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleArrayList.newListWith(4.0, 5.0, 6.0)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new double[] { 1, 2 }, this.iterable.toSortedArray(), 0.0);
    }

    @Test
    public void toList() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableDouble result = this.iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(3.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectDoubleIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectDoubleIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectDoubleIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.doubleIterator = SelectDoubleIterableTest::doubleIterator;
            this.payloads.forEach = SelectDoubleIterableTest::forEach;
            this.payloads.size = SelectDoubleIterableTest::size;
            this.payloads.empty = SelectDoubleIterableTest::empty;
            this.payloads.count = SelectDoubleIterableTest::count;
            this.payloads.anySatisfy = SelectDoubleIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectDoubleIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SelectDoubleIterableTest::noneSatisfy;
            this.payloads.select = SelectDoubleIterableTest::select;
            this.payloads.reject = SelectDoubleIterableTest::reject;
            this.payloads.detectIfNone = SelectDoubleIterableTest::detectIfNone;
            this.payloads.collect = SelectDoubleIterableTest::collect;
            this.payloads.sum = SelectDoubleIterableTest::sum;
            this.payloads.sumConsistentRounding = SelectDoubleIterableTest::sumConsistentRounding;
            this.payloads.max = SelectDoubleIterableTest::max;
            this.payloads.min = SelectDoubleIterableTest::min;
            this.payloads.minIfEmpty = SelectDoubleIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SelectDoubleIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectDoubleIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectDoubleIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SelectDoubleIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectDoubleIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SelectDoubleIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectDoubleIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SelectDoubleIterableTest::toArray;
            this.payloads.contains = SelectDoubleIterableTest::contains;
            this.payloads.containsAllArray = SelectDoubleIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SelectDoubleIterableTest::containsAllIterable;
            this.payloads.toSortedArray = SelectDoubleIterableTest::toSortedArray;
            this.payloads.toList = SelectDoubleIterableTest::toList;
            this.payloads.toSortedList = SelectDoubleIterableTest::toSortedList;
            this.payloads.toSet = SelectDoubleIterableTest::toSet;
            this.payloads.toBag = SelectDoubleIterableTest::toBag;
            this.payloads.asLazy = SelectDoubleIterableTest::asLazy;
            this.payloads.injectInto = SelectDoubleIterableTest::injectInto;
        }
    }
}
