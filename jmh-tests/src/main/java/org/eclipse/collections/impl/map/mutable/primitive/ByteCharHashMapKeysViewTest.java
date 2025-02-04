/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyByteIterableTestCase;

/**
 * JUnit test for {@link ByteCharHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class ByteCharHashMapKeysViewTest extends AbstractLazyByteIterableTestCase {

    @Override
    protected LazyByteIterable classUnderTest() {
        return ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3).keysView();
    }

    @Override
    protected LazyByteIterable getEmptyIterable() {
        return new ByteCharHashMap().keysView();
    }

    @Override
    protected LazyByteIterable newWith(byte element1, byte element2) {
        return ByteCharHashMap.newWithKeysValues(element1, (char) 1, element2, (char) 2).keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteCharHashMapKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ByteCharHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteCharHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.byteIterator = ByteCharHashMapKeysViewTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteCharHashMapKeysViewTest::forEach;
            this.payloads.size = ByteCharHashMapKeysViewTest::size;
            this.payloads.isEmpty = ByteCharHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = ByteCharHashMapKeysViewTest::notEmpty;
            this.payloads.count = ByteCharHashMapKeysViewTest::count;
            this.payloads.anySatisfy = ByteCharHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = ByteCharHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = ByteCharHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = ByteCharHashMapKeysViewTest::select;
            this.payloads.reject = ByteCharHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = ByteCharHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = ByteCharHashMapKeysViewTest::collect;
            this.payloads.tap = ByteCharHashMapKeysViewTest::tap;
            this.payloads.flatCollect = ByteCharHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = ByteCharHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = ByteCharHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = ByteCharHashMapKeysViewTest::max;
            this.payloads.min = ByteCharHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = ByteCharHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteCharHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = ByteCharHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ByteCharHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteCharHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ByteCharHashMapKeysViewTest::toArray;
            this.payloads.contains = ByteCharHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = ByteCharHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = ByteCharHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = ByteCharHashMapKeysViewTest::testToString;
            this.payloads.makeString = ByteCharHashMapKeysViewTest::makeString;
            this.payloads.appendString = ByteCharHashMapKeysViewTest::appendString;
            this.payloads.toList = ByteCharHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = ByteCharHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = ByteCharHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = ByteCharHashMapKeysViewTest::toSet;
            this.payloads.toBag = ByteCharHashMapKeysViewTest::toBag;
            this.payloads.asLazy = ByteCharHashMapKeysViewTest::asLazy;
        }
    }
}
