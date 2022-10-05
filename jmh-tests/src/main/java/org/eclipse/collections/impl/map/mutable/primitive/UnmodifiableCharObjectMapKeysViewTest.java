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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyCharIterableTestCase;

/**
 * JUnit test for {@link UnmodifiableCharObjectMap#keysView}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapKeysViewTest.stg.
 */
public class UnmodifiableCharObjectMapKeysViewTest extends AbstractLazyCharIterableTestCase {

    @Override
    protected LazyCharIterable classUnderTest() {
        return CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).asUnmodifiable().keysView();
    }

    @Override
    protected LazyCharIterable getEmptyIterable() {
        return CharObjectHashMap.newMap().asUnmodifiable().keysView();
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2) {
        return CharObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asUnmodifiable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableCharObjectMapKeysViewTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableCharObjectMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharObjectMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.charIterator = UnmodifiableCharObjectMapKeysViewTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableCharObjectMapKeysViewTest::forEach;
            this.payloads.size = UnmodifiableCharObjectMapKeysViewTest::size;
            this.payloads.isEmpty = UnmodifiableCharObjectMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableCharObjectMapKeysViewTest::notEmpty;
            this.payloads.count = UnmodifiableCharObjectMapKeysViewTest::count;
            this.payloads.anySatisfy = UnmodifiableCharObjectMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableCharObjectMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableCharObjectMapKeysViewTest::noneSatisfy;
            this.payloads.select = UnmodifiableCharObjectMapKeysViewTest::select;
            this.payloads.reject = UnmodifiableCharObjectMapKeysViewTest::reject;
            this.payloads.detectIfNone = UnmodifiableCharObjectMapKeysViewTest::detectIfNone;
            this.payloads.collect = UnmodifiableCharObjectMapKeysViewTest::collect;
            this.payloads.tap = UnmodifiableCharObjectMapKeysViewTest::tap;
            this.payloads.flatCollect = UnmodifiableCharObjectMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = UnmodifiableCharObjectMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = UnmodifiableCharObjectMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = UnmodifiableCharObjectMapKeysViewTest::max;
            this.payloads.min = UnmodifiableCharObjectMapKeysViewTest::min;
            this.payloads.minIfEmpty = UnmodifiableCharObjectMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableCharObjectMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = UnmodifiableCharObjectMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = UnmodifiableCharObjectMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharObjectMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = UnmodifiableCharObjectMapKeysViewTest::toArray;
            this.payloads.contains = UnmodifiableCharObjectMapKeysViewTest::contains;
            this.payloads.containsAllArray = UnmodifiableCharObjectMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableCharObjectMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = UnmodifiableCharObjectMapKeysViewTest::testToString;
            this.payloads.makeString = UnmodifiableCharObjectMapKeysViewTest::makeString;
            this.payloads.appendString = UnmodifiableCharObjectMapKeysViewTest::appendString;
            this.payloads.toList = UnmodifiableCharObjectMapKeysViewTest::toList;
            this.payloads.toSortedArray = UnmodifiableCharObjectMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = UnmodifiableCharObjectMapKeysViewTest::toSortedList;
            this.payloads.toSet = UnmodifiableCharObjectMapKeysViewTest::toSet;
            this.payloads.toBag = UnmodifiableCharObjectMapKeysViewTest::toBag;
            this.payloads.asLazy = UnmodifiableCharObjectMapKeysViewTest::asLazy;
        }
    }
}
