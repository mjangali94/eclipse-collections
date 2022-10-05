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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyByteIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyByteIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyByteIterableAdapterTest extends AbstractLazyByteIterableTestCase {

    @Override
    protected LazyByteIterable classUnderTest() {
        return new LazyByteIterableAdapter(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected LazyByteIterable getEmptyIterable() {
        return new LazyByteIterableAdapter(new ByteArrayList());
    }

    @Override
    protected LazyByteIterable newWith(byte element1, byte element2) {
        return new LazyByteIterableAdapter(ByteArrayList.newListWith(element1, element2));
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
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 2, (byte) 3 }, this.classUnderTest().toArray());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LazyByteIterate.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LazyByteIterableAdapterTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> payload) throws java.lang.Throwable {
            this.instance = new LazyByteIterableAdapterTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LazyByteIterableAdapterTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.byteIterator = LazyByteIterableAdapterTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LazyByteIterableAdapterTest::forEach;
            this.payloads.size = LazyByteIterableAdapterTest::size;
            this.payloads.isEmpty = LazyByteIterableAdapterTest::isEmpty;
            this.payloads.notEmpty = LazyByteIterableAdapterTest::notEmpty;
            this.payloads.count = LazyByteIterableAdapterTest::count;
            this.payloads.anySatisfy = LazyByteIterableAdapterTest::anySatisfy;
            this.payloads.allSatisfy = LazyByteIterableAdapterTest::allSatisfy;
            this.payloads.noneSatisfy = LazyByteIterableAdapterTest::noneSatisfy;
            this.payloads.select = LazyByteIterableAdapterTest::select;
            this.payloads.reject = LazyByteIterableAdapterTest::reject;
            this.payloads.detectIfNone = LazyByteIterableAdapterTest::detectIfNone;
            this.payloads.collect = LazyByteIterableAdapterTest::collect;
            this.payloads.tap = LazyByteIterableAdapterTest::tap;
            this.payloads.flatCollect = LazyByteIterableAdapterTest::flatCollect;
            this.payloads.lazyCollectPrimitives = LazyByteIterableAdapterTest::lazyCollectPrimitives;
            this.payloads.sum = LazyByteIterableAdapterTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = LazyByteIterableAdapterTest::max;
            this.payloads.min = LazyByteIterableAdapterTest::min;
            this.payloads.minIfEmpty = LazyByteIterableAdapterTest::minIfEmpty;
            this.payloads.maxIfEmpty = LazyByteIterableAdapterTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = LazyByteIterableAdapterTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LazyByteIterableAdapterTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LazyByteIterableAdapterTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.contains = LazyByteIterableAdapterTest::contains;
            this.payloads.containsAllArray = LazyByteIterableAdapterTest::containsAllArray;
            this.payloads.containsAllIterable = LazyByteIterableAdapterTest::containsAllIterable;
            this.payloads.toSortedArray = LazyByteIterableAdapterTest::toSortedArray;
            this.payloads.toSortedList = LazyByteIterableAdapterTest::toSortedList;
            this.payloads.toSet = LazyByteIterableAdapterTest::toSet;
            this.payloads.toBag = LazyByteIterableAdapterTest::toBag;
            this.payloads.asLazy = LazyByteIterableAdapterTest::asLazy;
            this.payloads.testToString = LazyByteIterableAdapterTest::testToString;
            this.payloads.makeString = LazyByteIterableAdapterTest::makeString;
            this.payloads.appendString = LazyByteIterableAdapterTest::appendString;
            this.payloads.toArray = LazyByteIterableAdapterTest::toArray;
            this.payloads.toList = LazyByteIterableAdapterTest::toList;
            this.payloads.classIsNonInstantiable = LazyByteIterableAdapterTest::classIsNonInstantiable;
        }
    }
}
