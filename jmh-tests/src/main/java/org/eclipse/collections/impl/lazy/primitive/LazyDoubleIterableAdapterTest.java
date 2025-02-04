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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyDoubleIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyDoubleIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyDoubleIterableAdapterTest extends AbstractLazyDoubleIterableTestCase {

    @Override
    protected LazyDoubleIterable classUnderTest() {
        return new LazyDoubleIterableAdapter(DoubleArrayList.newListWith(1.0, 2.0, 3.0));
    }

    @Override
    protected LazyDoubleIterable getEmptyIterable() {
        return new LazyDoubleIterableAdapter(new DoubleArrayList());
    }

    @Override
    protected LazyDoubleIterable newWith(double element1, double element2) {
        return new LazyDoubleIterableAdapter(DoubleArrayList.newListWith(element1, element2));
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1.0, 2.0, 3.0", this.classUnderTest().makeString());
        Assert.assertEquals("1.0/2.0/3.0", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertArrayEquals(new double[] { 1.0, 2.0, 3.0 }, this.classUnderTest().toArray(), 0.0);
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LazyDoubleIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyDoubleIterableAdapterTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lazyCollectPrimitives() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lazyCollectPrimitives);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyIterable);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new LazyDoubleIterableAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyDoubleIterableAdapterTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.doubleIterator = LazyDoubleIterableAdapterTest::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LazyDoubleIterableAdapterTest::forEach;
            this.payloads.size = LazyDoubleIterableAdapterTest::size;
            this.payloads.isEmpty = LazyDoubleIterableAdapterTest::isEmpty;
            this.payloads.notEmpty = LazyDoubleIterableAdapterTest::notEmpty;
            this.payloads.count = LazyDoubleIterableAdapterTest::count;
            this.payloads.anySatisfy = LazyDoubleIterableAdapterTest::anySatisfy;
            this.payloads.allSatisfy = LazyDoubleIterableAdapterTest::allSatisfy;
            this.payloads.noneSatisfy = LazyDoubleIterableAdapterTest::noneSatisfy;
            this.payloads.select = LazyDoubleIterableAdapterTest::select;
            this.payloads.reject = LazyDoubleIterableAdapterTest::reject;
            this.payloads.detectIfNone = LazyDoubleIterableAdapterTest::detectIfNone;
            this.payloads.collect = LazyDoubleIterableAdapterTest::collect;
            this.payloads.tap = LazyDoubleIterableAdapterTest::tap;
            this.payloads.flatCollect = LazyDoubleIterableAdapterTest::flatCollect;
            this.payloads.lazyCollectPrimitives = LazyDoubleIterableAdapterTest::lazyCollectPrimitives;
            this.payloads.sum = LazyDoubleIterableAdapterTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = LazyDoubleIterableAdapterTest::max;
            this.payloads.min = LazyDoubleIterableAdapterTest::min;
            this.payloads.minIfEmpty = LazyDoubleIterableAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = LazyDoubleIterableAdapterTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = LazyDoubleIterableAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LazyDoubleIterableAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyDoubleIterableAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.contains = LazyDoubleIterableAdapterTest::contains;
            this.payloads.containsAllArray = LazyDoubleIterableAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = LazyDoubleIterableAdapterTest::containsAllIterable;
            this.payloads.toSortedArray = LazyDoubleIterableAdapterTest::toSortedArray;
            this.payloads.toSortedList = LazyDoubleIterableAdapterTest::toSortedList;
            this.payloads.toSet = LazyDoubleIterableAdapterTest::toSet;
            this.payloads.toBag = LazyDoubleIterableAdapterTest::toBag;
            this.payloads.asLazy = LazyDoubleIterableAdapterTest::asLazy;
            this.payloads.testToString = LazyDoubleIterableAdapterTest::testToString;
            this.payloads.makeString = LazyDoubleIterableAdapterTest::makeString;
            this.payloads.appendString = LazyDoubleIterableAdapterTest::appendString;
            this.payloads.toArray = LazyDoubleIterableAdapterTest::toArray;
            this.payloads.toList = LazyDoubleIterableAdapterTest::toList;
            this.payloads.classIsNonInstantiable = LazyDoubleIterableAdapterTest::classIsNonInstantiable;
        }
    }
}
