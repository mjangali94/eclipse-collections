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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectFloatIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectFloatIterableTest {

    private final SelectFloatIterable iterable = new SelectFloatIterable(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), FloatPredicates.lessThan(3.0f));

    @Test
    public void floatIterator() {
        double sum = 0.0;
        for (FloatIterator iterator = this.iterable.floatIterator(); iterator.hasNext(); ) {
            sum += iterator.next();
        }
        Assert.assertEquals(3.0, sum, 0.0);
    }

    @Test
    public void forEach() {
        double[] sum = new double[1];
        this.iterable.forEach((float each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(0L, this.iterable.count(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.iterable.anySatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(this.iterable.anySatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.iterable.allSatisfy(FloatPredicates.greaterThan(0.0f)));
        Assert.assertFalse(this.iterable.allSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertFalse(this.iterable.allSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertTrue(this.iterable.allSatisfy(FloatPredicates.lessThan(4.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.iterable.noneSatisfy(FloatPredicates.lessThan(0.0f)));
        Assert.assertFalse(this.iterable.noneSatisfy(FloatPredicates.lessThan(2.0f)));
        Assert.assertTrue(this.iterable.noneSatisfy(FloatPredicates.lessThan(1.0f)));
        Assert.assertTrue(this.iterable.noneSatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void select() {
        Verify.assertSize(1, this.iterable.select(FloatPredicates.greaterThan(1.0f)));
        Verify.assertSize(0, this.iterable.select(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void reject() {
        Verify.assertSize(1, this.iterable.reject(FloatPredicates.greaterThan(1.0f)));
        Verify.assertSize(0, this.iterable.reject(FloatPredicates.greaterThan(0.0f)));
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1.0, this.iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(0.0, this.iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);
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
        FloatArrayList list = FloatArrayList.newListWith(Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())).toArray());
        SelectFloatIterable iterable = new SelectFloatIterable(list, FloatPredicates.alwaysTrue());
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void max() {
        Assert.assertEquals(2.0f, this.iterable.max(), 0.0);
    }

    @Test
    public void min() {
        Assert.assertEquals(1.0f, this.iterable.min(), 0.0);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(1.0f, this.iterable.minIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0f, this.iterable.select(FloatPredicates.lessThan(0.0f)).minIfEmpty(0.0f), 0.0);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(2.0f, this.iterable.maxIfEmpty(0.0f), 0.0);
        Assert.assertEquals(0.0f, this.iterable.select(FloatPredicates.lessThan(0.0f)).maxIfEmpty(0.0f), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        new SelectFloatIterable(new FloatArrayList(), FloatPredicates.lessThan(3.0f)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        new SelectFloatIterable(new FloatArrayList(), FloatPredicates.lessThan(3.0f)).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        new SelectFloatIterable(new FloatArrayList(), FloatPredicates.lessThan(3.0f)).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        new SelectFloatIterable(new FloatArrayList(), FloatPredicates.lessThan(3.0f)).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new float[] { 1, 2 }, this.iterable.toArray(), 0.0f);
    }

    @Test
    public void contains() {
        Assert.assertTrue(this.iterable.contains(1.0f));
        Assert.assertTrue(this.iterable.contains(2.0f));
        Assert.assertFalse(this.iterable.contains(3.0f));
    }

    @Test
    public void containsAllArray() {
        Assert.assertTrue(this.iterable.containsAll(1.0f));
        Assert.assertTrue(this.iterable.containsAll(2.0f));
        Assert.assertTrue(this.iterable.containsAll(1.0f, 2.0f));
        Assert.assertFalse(this.iterable.containsAll(1.0f, 2.0f, 3.0f));
        Assert.assertFalse(this.iterable.containsAll(4.0f, 5.0f, 6.0f));
    }

    @Test
    public void containsAllIterable() {
        Assert.assertTrue(this.iterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(this.iterable.containsAll(FloatArrayList.newListWith(2.0f)));
        Assert.assertTrue(this.iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f)));
        Assert.assertFalse(this.iterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Assert.assertFalse(this.iterable.containsAll(FloatArrayList.newListWith(4.0f, 5.0f, 6.0f)));
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 1, 2 }, this.iterable.toSortedArray(), 0.0f);
    }

    @Test
    public void toList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), this.iterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), this.iterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f), this.iterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), this.iterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto() {
        MutableFloat result = this.iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(3.0f), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SelectFloatIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SelectFloatIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SelectFloatIterableTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.floatIterator = SelectFloatIterableTest::floatIterator;
            this.payloads.forEach = SelectFloatIterableTest::forEach;
            this.payloads.size = SelectFloatIterableTest::size;
            this.payloads.empty = SelectFloatIterableTest::empty;
            this.payloads.count = SelectFloatIterableTest::count;
            this.payloads.anySatisfy = SelectFloatIterableTest::anySatisfy;
            this.payloads.allSatisfy = SelectFloatIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SelectFloatIterableTest::noneSatisfy;
            this.payloads.select = SelectFloatIterableTest::select;
            this.payloads.reject = SelectFloatIterableTest::reject;
            this.payloads.detectIfNone = SelectFloatIterableTest::detectIfNone;
            this.payloads.collect = SelectFloatIterableTest::collect;
            this.payloads.sum = SelectFloatIterableTest::sum;
            this.payloads.sumConsistentRounding = SelectFloatIterableTest::sumConsistentRounding;
            this.payloads.max = SelectFloatIterableTest::max;
            this.payloads.min = SelectFloatIterableTest::min;
            this.payloads.minIfEmpty = SelectFloatIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SelectFloatIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectFloatIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectFloatIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SelectFloatIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectFloatIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SelectFloatIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SelectFloatIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SelectFloatIterableTest::toArray;
            this.payloads.contains = SelectFloatIterableTest::contains;
            this.payloads.containsAllArray = SelectFloatIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SelectFloatIterableTest::containsAllIterable;
            this.payloads.toSortedArray = SelectFloatIterableTest::toSortedArray;
            this.payloads.toList = SelectFloatIterableTest::toList;
            this.payloads.toSortedList = SelectFloatIterableTest::toSortedList;
            this.payloads.toSet = SelectFloatIterableTest::toSet;
            this.payloads.toBag = SelectFloatIterableTest::toBag;
            this.payloads.asLazy = SelectFloatIterableTest::asLazy;
            this.payloads.injectInto = SelectFloatIterableTest::injectInto;
        }
    }
}
