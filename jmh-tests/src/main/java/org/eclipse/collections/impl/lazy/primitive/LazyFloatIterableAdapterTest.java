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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyFloatIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyFloatIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyFloatIterableAdapterTest extends AbstractLazyFloatIterableTestCase {

    @Override
    protected LazyFloatIterable classUnderTest() {
        return new LazyFloatIterableAdapter(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected LazyFloatIterable getEmptyIterable() {
        return new LazyFloatIterableAdapter(new FloatArrayList());
    }

    @Override
    protected LazyFloatIterable newWith(float element1, float element2) {
        return new LazyFloatIterableAdapter(FloatArrayList.newListWith(element1, element2));
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
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f }, this.classUnderTest().toArray(), 0.0f);
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LazyFloatIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyFloatIterableAdapterTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new LazyFloatIterableAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyFloatIterableAdapterTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.floatIterator = LazyFloatIterableAdapterTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LazyFloatIterableAdapterTest::forEach;
            this.payloads.size = LazyFloatIterableAdapterTest::size;
            this.payloads.isEmpty = LazyFloatIterableAdapterTest::isEmpty;
            this.payloads.notEmpty = LazyFloatIterableAdapterTest::notEmpty;
            this.payloads.count = LazyFloatIterableAdapterTest::count;
            this.payloads.anySatisfy = LazyFloatIterableAdapterTest::anySatisfy;
            this.payloads.allSatisfy = LazyFloatIterableAdapterTest::allSatisfy;
            this.payloads.noneSatisfy = LazyFloatIterableAdapterTest::noneSatisfy;
            this.payloads.select = LazyFloatIterableAdapterTest::select;
            this.payloads.reject = LazyFloatIterableAdapterTest::reject;
            this.payloads.detectIfNone = LazyFloatIterableAdapterTest::detectIfNone;
            this.payloads.collect = LazyFloatIterableAdapterTest::collect;
            this.payloads.tap = LazyFloatIterableAdapterTest::tap;
            this.payloads.flatCollect = LazyFloatIterableAdapterTest::flatCollect;
            this.payloads.lazyCollectPrimitives = LazyFloatIterableAdapterTest::lazyCollectPrimitives;
            this.payloads.sum = LazyFloatIterableAdapterTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = LazyFloatIterableAdapterTest::max;
            this.payloads.min = LazyFloatIterableAdapterTest::min;
            this.payloads.minIfEmpty = LazyFloatIterableAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = LazyFloatIterableAdapterTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = LazyFloatIterableAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LazyFloatIterableAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyFloatIterableAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.contains = LazyFloatIterableAdapterTest::contains;
            this.payloads.containsAllArray = LazyFloatIterableAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = LazyFloatIterableAdapterTest::containsAllIterable;
            this.payloads.toSortedArray = LazyFloatIterableAdapterTest::toSortedArray;
            this.payloads.toSortedList = LazyFloatIterableAdapterTest::toSortedList;
            this.payloads.toSet = LazyFloatIterableAdapterTest::toSet;
            this.payloads.toBag = LazyFloatIterableAdapterTest::toBag;
            this.payloads.asLazy = LazyFloatIterableAdapterTest::asLazy;
            this.payloads.testToString = LazyFloatIterableAdapterTest::testToString;
            this.payloads.makeString = LazyFloatIterableAdapterTest::makeString;
            this.payloads.appendString = LazyFloatIterableAdapterTest::appendString;
            this.payloads.toArray = LazyFloatIterableAdapterTest::toArray;
            this.payloads.toList = LazyFloatIterableAdapterTest::toList;
            this.payloads.classIsNonInstantiable = LazyFloatIterableAdapterTest::classIsNonInstantiable;
        }
    }
}
