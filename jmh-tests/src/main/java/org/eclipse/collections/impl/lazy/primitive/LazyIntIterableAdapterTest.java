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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyIntIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyIntIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyIntIterableAdapterTest extends AbstractLazyIntIterableTestCase {

    @Override
    protected LazyIntIterable classUnderTest() {
        return new LazyIntIterableAdapter(IntArrayList.newListWith(1, 2, 3));
    }

    @Override
    protected LazyIntIterable getEmptyIterable() {
        return new LazyIntIterableAdapter(new IntArrayList());
    }

    @Override
    protected LazyIntIterable newWith(int element1, int element2) {
        return new LazyIntIterableAdapter(IntArrayList.newListWith(element1, element2));
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1, 2, 3]", this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1, 2, 3", this.classUnderTest().makeString());
        Assert.assertEquals("1/2/3", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1, 2, 3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1/2/3", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertArrayEquals(new int[] { 1, 2, 3 }, this.classUnderTest().toArray());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LazyIntIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyIntIterableAdapterTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectPrimitives() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyCollectPrimitives);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyIterable);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new LazyIntIterableAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyIntIterableAdapterTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.intIterator = LazyIntIterableAdapterTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LazyIntIterableAdapterTest::forEach;
            this.payloads.size = LazyIntIterableAdapterTest::size;
            this.payloads.isEmpty = LazyIntIterableAdapterTest::isEmpty;
            this.payloads.notEmpty = LazyIntIterableAdapterTest::notEmpty;
            this.payloads.count = LazyIntIterableAdapterTest::count;
            this.payloads.anySatisfy = LazyIntIterableAdapterTest::anySatisfy;
            this.payloads.allSatisfy = LazyIntIterableAdapterTest::allSatisfy;
            this.payloads.noneSatisfy = LazyIntIterableAdapterTest::noneSatisfy;
            this.payloads.select = LazyIntIterableAdapterTest::select;
            this.payloads.reject = LazyIntIterableAdapterTest::reject;
            this.payloads.detectIfNone = LazyIntIterableAdapterTest::detectIfNone;
            this.payloads.collect = LazyIntIterableAdapterTest::collect;
            this.payloads.tap = LazyIntIterableAdapterTest::tap;
            this.payloads.flatCollect = LazyIntIterableAdapterTest::flatCollect;
            this.payloads.lazyCollectPrimitives = LazyIntIterableAdapterTest::lazyCollectPrimitives;
            this.payloads.sum = LazyIntIterableAdapterTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = LazyIntIterableAdapterTest::max;
            this.payloads.min = LazyIntIterableAdapterTest::min;
            this.payloads.minIfEmpty = LazyIntIterableAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = LazyIntIterableAdapterTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = LazyIntIterableAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LazyIntIterableAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyIntIterableAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.contains = LazyIntIterableAdapterTest::contains;
            this.payloads.containsAllArray = LazyIntIterableAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = LazyIntIterableAdapterTest::containsAllIterable;
            this.payloads.toSortedArray = LazyIntIterableAdapterTest::toSortedArray;
            this.payloads.toSortedList = LazyIntIterableAdapterTest::toSortedList;
            this.payloads.toSet = LazyIntIterableAdapterTest::toSet;
            this.payloads.toBag = LazyIntIterableAdapterTest::toBag;
            this.payloads.asLazy = LazyIntIterableAdapterTest::asLazy;
            this.payloads.testToString = LazyIntIterableAdapterTest::testToString;
            this.payloads.makeString = LazyIntIterableAdapterTest::makeString;
            this.payloads.appendString = LazyIntIterableAdapterTest::appendString;
            this.payloads.toArray = LazyIntIterableAdapterTest::toArray;
            this.payloads.toList = LazyIntIterableAdapterTest::toList;
            this.payloads.classIsNonInstantiable = LazyIntIterableAdapterTest::classIsNonInstantiable;
        }
    }
}
