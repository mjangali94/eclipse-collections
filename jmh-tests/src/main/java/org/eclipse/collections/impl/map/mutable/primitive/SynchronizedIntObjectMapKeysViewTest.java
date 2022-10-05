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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyIntIterableTestCase;

/**
 * JUnit test for {@link SynchronizedIntObjectMap#keysView}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapKeysViewTest.stg.
 */
public class SynchronizedIntObjectMapKeysViewTest extends AbstractLazyIntIterableTestCase {

    @Override
    protected LazyIntIterable classUnderTest() {
        return IntObjectHashMap.newWithKeysValues(1, 1, 2, 2, 3, 3).asSynchronized().keysView();
    }

    @Override
    protected LazyIntIterable getEmptyIterable() {
        return IntObjectHashMap.newMap().asSynchronized().keysView();
    }

    @Override
    protected LazyIntIterable newWith(int element1, int element2) {
        return IntObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asSynchronized().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedIntObjectMapKeysViewTest instance;

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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedIntObjectMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntObjectMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.intIterator = SynchronizedIntObjectMapKeysViewTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedIntObjectMapKeysViewTest::forEach;
            this.payloads.size = SynchronizedIntObjectMapKeysViewTest::size;
            this.payloads.isEmpty = SynchronizedIntObjectMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = SynchronizedIntObjectMapKeysViewTest::notEmpty;
            this.payloads.count = SynchronizedIntObjectMapKeysViewTest::count;
            this.payloads.anySatisfy = SynchronizedIntObjectMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedIntObjectMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedIntObjectMapKeysViewTest::noneSatisfy;
            this.payloads.select = SynchronizedIntObjectMapKeysViewTest::select;
            this.payloads.reject = SynchronizedIntObjectMapKeysViewTest::reject;
            this.payloads.detectIfNone = SynchronizedIntObjectMapKeysViewTest::detectIfNone;
            this.payloads.collect = SynchronizedIntObjectMapKeysViewTest::collect;
            this.payloads.tap = SynchronizedIntObjectMapKeysViewTest::tap;
            this.payloads.flatCollect = SynchronizedIntObjectMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = SynchronizedIntObjectMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = SynchronizedIntObjectMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = SynchronizedIntObjectMapKeysViewTest::max;
            this.payloads.min = SynchronizedIntObjectMapKeysViewTest::min;
            this.payloads.minIfEmpty = SynchronizedIntObjectMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedIntObjectMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SynchronizedIntObjectMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedIntObjectMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntObjectMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SynchronizedIntObjectMapKeysViewTest::toArray;
            this.payloads.contains = SynchronizedIntObjectMapKeysViewTest::contains;
            this.payloads.containsAllArray = SynchronizedIntObjectMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedIntObjectMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = SynchronizedIntObjectMapKeysViewTest::testToString;
            this.payloads.makeString = SynchronizedIntObjectMapKeysViewTest::makeString;
            this.payloads.appendString = SynchronizedIntObjectMapKeysViewTest::appendString;
            this.payloads.toList = SynchronizedIntObjectMapKeysViewTest::toList;
            this.payloads.toSortedArray = SynchronizedIntObjectMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = SynchronizedIntObjectMapKeysViewTest::toSortedList;
            this.payloads.toSet = SynchronizedIntObjectMapKeysViewTest::toSet;
            this.payloads.toBag = SynchronizedIntObjectMapKeysViewTest::toBag;
            this.payloads.asLazy = SynchronizedIntObjectMapKeysViewTest::asLazy;
        }
    }
}
