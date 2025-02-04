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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase;

/**
 * JUnit test for {@link LongObjectHashMap#keysView}.
 * This file was automatically generated from template file primitiveObjectHashMapKeysViewTest.stg.
 */
public class LongObjectHashMapKeysViewTest extends AbstractLazyLongIterableTestCase {

    @Override
    protected LazyLongIterable classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3).keysView();
    }

    @Override
    protected LazyLongIterable getEmptyIterable() {
        return LongObjectHashMap.newMap().keysView();
    }

    @Override
    protected LazyLongIterable newWith(long element1, long element2) {
        return LongObjectHashMap.newWithKeysValues(element1, 1, element2, 2).keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongObjectHashMapKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new LongObjectHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.longIterator = LongObjectHashMapKeysViewTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LongObjectHashMapKeysViewTest::forEach;
            this.payloads.size = LongObjectHashMapKeysViewTest::size;
            this.payloads.isEmpty = LongObjectHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = LongObjectHashMapKeysViewTest::notEmpty;
            this.payloads.count = LongObjectHashMapKeysViewTest::count;
            this.payloads.anySatisfy = LongObjectHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = LongObjectHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = LongObjectHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = LongObjectHashMapKeysViewTest::select;
            this.payloads.reject = LongObjectHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = LongObjectHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = LongObjectHashMapKeysViewTest::collect;
            this.payloads.tap = LongObjectHashMapKeysViewTest::tap;
            this.payloads.flatCollect = LongObjectHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = LongObjectHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = LongObjectHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = LongObjectHashMapKeysViewTest::max;
            this.payloads.min = LongObjectHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = LongObjectHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongObjectHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = LongObjectHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LongObjectHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = LongObjectHashMapKeysViewTest::toArray;
            this.payloads.contains = LongObjectHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = LongObjectHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = LongObjectHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = LongObjectHashMapKeysViewTest::testToString;
            this.payloads.makeString = LongObjectHashMapKeysViewTest::makeString;
            this.payloads.appendString = LongObjectHashMapKeysViewTest::appendString;
            this.payloads.toList = LongObjectHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = LongObjectHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = LongObjectHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = LongObjectHashMapKeysViewTest::toSet;
            this.payloads.toBag = LongObjectHashMapKeysViewTest::toBag;
            this.payloads.asLazy = LongObjectHashMapKeysViewTest::asLazy;
        }
    }
}
