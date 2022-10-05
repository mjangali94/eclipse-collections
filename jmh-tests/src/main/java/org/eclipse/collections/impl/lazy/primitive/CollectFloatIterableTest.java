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
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectFloatIterableTest {

    private final FloatIterable floatIterable = Interval.oneTo(3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());

    @Test
    public void iterator() {
        double sum = 0.0;
        FloatIterator iterator = this.floatIterable.floatIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(6.0, sum, 0.0f);
    }

    @Test
    public void size() {
        Assert.assertEquals(3L, this.floatIterable.size());
    }

    @Test
    public void empty() {
        Assert.assertTrue(this.floatIterable.notEmpty());
        Assert.assertFalse(this.floatIterable.isEmpty());
    }

    @Test
    public void forEach() {
        double[] value = new double[1];
        this.floatIterable.forEach(each -> {
            value[0] += each;
        });
        Assert.assertEquals(6.0, value[0], 0.0f);
    }

    @Test
    public void count() {
        Assert.assertEquals(1, this.floatIterable.count(FloatPredicates.equal(1.0f)));
        Assert.assertEquals(3, this.floatIterable.count(FloatPredicates.lessThan(4.0f)));
        Assert.assertEquals(2, this.floatIterable.count(FloatPredicates.greaterThan(1.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.floatIterable.anySatisfy(FloatPredicates.greaterThan(1.0f)));
        Assert.assertTrue(this.floatIterable.anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(this.floatIterable.anySatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertFalse(this.floatIterable.noneSatisfy(FloatPredicates.greaterThan(2.0f)));
        Assert.assertTrue(this.floatIterable.noneSatisfy(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.floatIterable.allSatisfy(FloatPredicates.lessThan(4.0f)));
        Assert.assertFalse(this.floatIterable.allSatisfy(FloatPredicates.lessThan(3.0f)));
    }

    @Test
    public void select() {
        Assert.assertEquals(3L, this.floatIterable.select(FloatPredicates.lessThan(4.0f)).size());
        Assert.assertEquals(2L, this.floatIterable.select(FloatPredicates.lessThan(3.0f)).size());
    }

    @Test
    public void reject() {
        Assert.assertEquals(0L, this.floatIterable.reject(FloatPredicates.lessThan(4.0f)).size());
        Assert.assertEquals(1L, this.floatIterable.reject(FloatPredicates.lessThan(3.0f)).size());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(1.0f, this.floatIterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0f);
        Assert.assertEquals(0.0f, this.floatIterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0f);
    }

    @Test
    public void sum() {
        Assert.assertEquals(6.0, this.floatIterable.sum(), 0.0f);
    }

    @Test
    public void sumConsistentRounding() {
        FloatIterable iterable = Interval.oneTo(100_000).toList().shuffleThis().collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, iterable.sum(), 1.0e-15);
    }

    @Test
    public void max() {
        Assert.assertEquals(3.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).max(), 0.0f);
    }

    @Test
    public void min() {
        Assert.assertEquals(0.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).min(), 0.0f);
    }

    @Test
    public void minIfEmpty() {
        Assert.assertEquals(0.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).minIfEmpty(0.0f), 0.0f);
        Assert.assertEquals(0.0f, FastList.<Integer>newList().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).minIfEmpty(0.0f), 0.0f);
    }

    @Test
    public void maxIfEmpty() {
        Assert.assertEquals(3.0f, Interval.fromTo(0, 3).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).maxIfEmpty(0.0f), 0.0f);
        Assert.assertEquals(0.0f, FastList.<Integer>newList().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).maxIfEmpty(0.0f), 0.0f);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).min();
    }

    @Test
    public void average() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).average();
    }

    @Test
    public void median() {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty() {
        Lists.mutable.<Integer>of().asLazy().collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).median();
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }, Interval.oneTo(4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).toArray(), 0.0f);
    }

    @Test
    public void toSortedArray() {
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 4.0f }, Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat()).toSortedArray(), 0.0f);
    }

    @Test
    public void contains() {
        FloatIterable floatIterable = Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertTrue(floatIterable.contains(1.0f));
        Assert.assertTrue(floatIterable.contains(3.0f));
        Assert.assertTrue(floatIterable.contains(4.0f));
        Assert.assertFalse(floatIterable.contains(5.0f));
    }

    @Test
    public void containsAllArray() {
        FloatIterable floatIterable = Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertTrue(floatIterable.containsAll(1.0f));
        Assert.assertTrue(floatIterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertFalse(floatIterable.containsAll(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertFalse(floatIterable.containsAll(7.0f, 6.0f, 5.0f));
    }

    @Test
    public void containsAllIterable() {
        FloatIterable floatIterable = Interval.fromTo(4, 1).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertTrue(floatIterable.containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(floatIterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f)));
        Assert.assertFalse(floatIterable.containsAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f)));
        Assert.assertFalse(floatIterable.containsAll(FloatArrayList.newListWith(7.0f, 6.0f, 5.0f)));
    }

    @Test
    public void collect() {
        Assert.assertEquals(FastList.newListWith("1.0", "2.0", "3.0"), this.floatIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.floatIterable.toString());
    }

    @Test
    public void makeString() {
        Assert.assertEquals("1.0, 2.0, 3.0", this.floatIterable.makeString());
        Assert.assertEquals("1.0/2.0/3.0", this.floatIterable.makeString("/"));
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.floatIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        StringBuilder appendable = new StringBuilder();
        this.floatIterable.appendString(appendable);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.floatIterable.appendString(appendable2, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.floatIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.floatIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.floatIterable.toList());
    }

    @Test
    public void toSortedList() {
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.floatIterable.toSortedList());
    }

    @Test
    public void toSet() {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), this.floatIterable.toSet());
    }

    @Test
    public void toBag() {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.floatIterable.toBag());
    }

    @Test
    public void asLazy() {
        Assert.assertEquals(this.floatIterable.toSet(), this.floatIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, this.floatIterable.asLazy());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CollectFloatIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
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
        public void benchmark_maxThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> payload) throws java.lang.Throwable {
            this.instance = new CollectFloatIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CollectFloatIterableTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.iterator = CollectFloatIterableTest::iterator;
            this.payloads.size = CollectFloatIterableTest::size;
            this.payloads.empty = CollectFloatIterableTest::empty;
            this.payloads.forEach = CollectFloatIterableTest::forEach;
            this.payloads.count = CollectFloatIterableTest::count;
            this.payloads.anySatisfy = CollectFloatIterableTest::anySatisfy;
            this.payloads.noneSatisfy = CollectFloatIterableTest::noneSatisfy;
            this.payloads.allSatisfy = CollectFloatIterableTest::allSatisfy;
            this.payloads.select = CollectFloatIterableTest::select;
            this.payloads.reject = CollectFloatIterableTest::reject;
            this.payloads.detectIfNone = CollectFloatIterableTest::detectIfNone;
            this.payloads.sum = CollectFloatIterableTest::sum;
            this.payloads.sumConsistentRounding = CollectFloatIterableTest::sumConsistentRounding;
            this.payloads.max = CollectFloatIterableTest::max;
            this.payloads.min = CollectFloatIterableTest::min;
            this.payloads.minIfEmpty = CollectFloatIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = CollectFloatIterableTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectFloatIterableTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectFloatIterableTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = CollectFloatIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectFloatIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CollectFloatIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CollectFloatIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = CollectFloatIterableTest::toArray;
            this.payloads.toSortedArray = CollectFloatIterableTest::toSortedArray;
            this.payloads.contains = CollectFloatIterableTest::contains;
            this.payloads.containsAllArray = CollectFloatIterableTest::containsAllArray;
            this.payloads.containsAllIterable = CollectFloatIterableTest::containsAllIterable;
            this.payloads.collect = CollectFloatIterableTest::collect;
            this.payloads.testToString = CollectFloatIterableTest::testToString;
            this.payloads.makeString = CollectFloatIterableTest::makeString;
            this.payloads.appendString = CollectFloatIterableTest::appendString;
            this.payloads.toList = CollectFloatIterableTest::toList;
            this.payloads.toSortedList = CollectFloatIterableTest::toSortedList;
            this.payloads.toSet = CollectFloatIterableTest::toSet;
            this.payloads.toBag = CollectFloatIterableTest::toBag;
            this.payloads.asLazy = CollectFloatIterableTest::asLazy;
        }
    }
}
