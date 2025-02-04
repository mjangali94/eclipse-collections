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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyCharIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyCharIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyCharIterableAdapterTest extends AbstractLazyCharIterableTestCase {

    @Override
    protected LazyCharIterable classUnderTest() {
        return new LazyCharIterableAdapter(CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected LazyCharIterable getEmptyIterable() {
        return new LazyCharIterableAdapter(new CharArrayList());
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2) {
        return new LazyCharIterableAdapter(CharArrayList.newListWith(element1, element2));
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("\u0001, \u0002, \u0003", this.classUnderTest().makeString());
        Assert.assertEquals("\u0001/\u0002/\u0003", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3 }, this.classUnderTest().toArray());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LazyCharIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyCharIterableAdapterTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new LazyCharIterableAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyCharIterableAdapterTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.charIterator = LazyCharIterableAdapterTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LazyCharIterableAdapterTest::forEach;
            this.payloads.size = LazyCharIterableAdapterTest::size;
            this.payloads.isEmpty = LazyCharIterableAdapterTest::isEmpty;
            this.payloads.notEmpty = LazyCharIterableAdapterTest::notEmpty;
            this.payloads.count = LazyCharIterableAdapterTest::count;
            this.payloads.anySatisfy = LazyCharIterableAdapterTest::anySatisfy;
            this.payloads.allSatisfy = LazyCharIterableAdapterTest::allSatisfy;
            this.payloads.noneSatisfy = LazyCharIterableAdapterTest::noneSatisfy;
            this.payloads.select = LazyCharIterableAdapterTest::select;
            this.payloads.reject = LazyCharIterableAdapterTest::reject;
            this.payloads.detectIfNone = LazyCharIterableAdapterTest::detectIfNone;
            this.payloads.collect = LazyCharIterableAdapterTest::collect;
            this.payloads.tap = LazyCharIterableAdapterTest::tap;
            this.payloads.flatCollect = LazyCharIterableAdapterTest::flatCollect;
            this.payloads.lazyCollectPrimitives = LazyCharIterableAdapterTest::lazyCollectPrimitives;
            this.payloads.sum = LazyCharIterableAdapterTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = LazyCharIterableAdapterTest::max;
            this.payloads.min = LazyCharIterableAdapterTest::min;
            this.payloads.minIfEmpty = LazyCharIterableAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = LazyCharIterableAdapterTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = LazyCharIterableAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LazyCharIterableAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyCharIterableAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.contains = LazyCharIterableAdapterTest::contains;
            this.payloads.containsAllArray = LazyCharIterableAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = LazyCharIterableAdapterTest::containsAllIterable;
            this.payloads.toSortedArray = LazyCharIterableAdapterTest::toSortedArray;
            this.payloads.toSortedList = LazyCharIterableAdapterTest::toSortedList;
            this.payloads.toSet = LazyCharIterableAdapterTest::toSet;
            this.payloads.toBag = LazyCharIterableAdapterTest::toBag;
            this.payloads.asLazy = LazyCharIterableAdapterTest::asLazy;
            this.payloads.testToString = LazyCharIterableAdapterTest::testToString;
            this.payloads.makeString = LazyCharIterableAdapterTest::makeString;
            this.payloads.appendString = LazyCharIterableAdapterTest::appendString;
            this.payloads.toArray = LazyCharIterableAdapterTest::toArray;
            this.payloads.toList = LazyCharIterableAdapterTest::toList;
            this.payloads.classIsNonInstantiable = LazyCharIterableAdapterTest::classIsNonInstantiable;
        }
    }
}
