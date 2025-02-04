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
 * JUnit test for {@link IntCharHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class IntCharHashMapKeysViewTest extends AbstractLazyIntIterableTestCase {

    @Override
    protected LazyIntIterable classUnderTest() {
        return IntCharHashMap.newWithKeysValues(1, (char) 1, 2, (char) 2, 3, (char) 3).keysView();
    }

    @Override
    protected LazyIntIterable getEmptyIterable() {
        return new IntCharHashMap().keysView();
    }

    @Override
    protected LazyIntIterable newWith(int element1, int element2) {
        return IntCharHashMap.newWithKeysValues(element1, (char) 1, element2, (char) 2).keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntCharHashMapKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new IntCharHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntCharHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.intIterator = IntCharHashMapKeysViewTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = IntCharHashMapKeysViewTest::forEach;
            this.payloads.size = IntCharHashMapKeysViewTest::size;
            this.payloads.isEmpty = IntCharHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = IntCharHashMapKeysViewTest::notEmpty;
            this.payloads.count = IntCharHashMapKeysViewTest::count;
            this.payloads.anySatisfy = IntCharHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = IntCharHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = IntCharHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = IntCharHashMapKeysViewTest::select;
            this.payloads.reject = IntCharHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = IntCharHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = IntCharHashMapKeysViewTest::collect;
            this.payloads.tap = IntCharHashMapKeysViewTest::tap;
            this.payloads.flatCollect = IntCharHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = IntCharHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = IntCharHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = IntCharHashMapKeysViewTest::max;
            this.payloads.min = IntCharHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = IntCharHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntCharHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = IntCharHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = IntCharHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntCharHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = IntCharHashMapKeysViewTest::toArray;
            this.payloads.contains = IntCharHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = IntCharHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = IntCharHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = IntCharHashMapKeysViewTest::testToString;
            this.payloads.makeString = IntCharHashMapKeysViewTest::makeString;
            this.payloads.appendString = IntCharHashMapKeysViewTest::appendString;
            this.payloads.toList = IntCharHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = IntCharHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = IntCharHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = IntCharHashMapKeysViewTest::toSet;
            this.payloads.toBag = IntCharHashMapKeysViewTest::toBag;
            this.payloads.asLazy = IntCharHashMapKeysViewTest::asLazy;
        }
    }
}
