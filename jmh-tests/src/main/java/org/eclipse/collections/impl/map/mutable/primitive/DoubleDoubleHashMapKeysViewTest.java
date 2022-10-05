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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyDoubleIterableTestCase;

/**
 * JUnit test for {@link DoubleDoubleHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class DoubleDoubleHashMapKeysViewTest extends AbstractLazyDoubleIterableTestCase {

    @Override
    protected LazyDoubleIterable classUnderTest() {
        return DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0).keysView();
    }

    @Override
    protected LazyDoubleIterable getEmptyIterable() {
        return new DoubleDoubleHashMap().keysView();
    }

    @Override
    protected LazyDoubleIterable newWith(double element1, double element2) {
        return DoubleDoubleHashMap.newWithKeysValues(element1, 1.0, element2, 2.0).keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleDoubleHashMapKeysViewTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleDoubleHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.doubleIterator = DoubleDoubleHashMapKeysViewTest::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = DoubleDoubleHashMapKeysViewTest::forEach;
            this.payloads.size = DoubleDoubleHashMapKeysViewTest::size;
            this.payloads.isEmpty = DoubleDoubleHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = DoubleDoubleHashMapKeysViewTest::notEmpty;
            this.payloads.count = DoubleDoubleHashMapKeysViewTest::count;
            this.payloads.anySatisfy = DoubleDoubleHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = DoubleDoubleHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleDoubleHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = DoubleDoubleHashMapKeysViewTest::select;
            this.payloads.reject = DoubleDoubleHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = DoubleDoubleHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = DoubleDoubleHashMapKeysViewTest::collect;
            this.payloads.tap = DoubleDoubleHashMapKeysViewTest::tap;
            this.payloads.flatCollect = DoubleDoubleHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = DoubleDoubleHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = DoubleDoubleHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = DoubleDoubleHashMapKeysViewTest::max;
            this.payloads.min = DoubleDoubleHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = DoubleDoubleHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleDoubleHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = DoubleDoubleHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = DoubleDoubleHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = DoubleDoubleHashMapKeysViewTest::toArray;
            this.payloads.contains = DoubleDoubleHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = DoubleDoubleHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = DoubleDoubleHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = DoubleDoubleHashMapKeysViewTest::testToString;
            this.payloads.makeString = DoubleDoubleHashMapKeysViewTest::makeString;
            this.payloads.appendString = DoubleDoubleHashMapKeysViewTest::appendString;
            this.payloads.toList = DoubleDoubleHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = DoubleDoubleHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = DoubleDoubleHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = DoubleDoubleHashMapKeysViewTest::toSet;
            this.payloads.toBag = DoubleDoubleHashMapKeysViewTest::toBag;
            this.payloads.asLazy = DoubleDoubleHashMapKeysViewTest::asLazy;
        }
    }
}
