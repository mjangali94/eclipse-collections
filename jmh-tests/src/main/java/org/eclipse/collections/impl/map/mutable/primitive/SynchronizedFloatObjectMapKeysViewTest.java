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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyFloatIterableTestCase;

/**
 * JUnit test for {@link SynchronizedFloatObjectMap#keysView}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapKeysViewTest.stg.
 */
public class SynchronizedFloatObjectMapKeysViewTest extends AbstractLazyFloatIterableTestCase {

    @Override
    protected LazyFloatIterable classUnderTest() {
        return FloatObjectHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3).asSynchronized().keysView();
    }

    @Override
    protected LazyFloatIterable getEmptyIterable() {
        return FloatObjectHashMap.newMap().asSynchronized().keysView();
    }

    @Override
    protected LazyFloatIterable newWith(float element1, float element2) {
        return FloatObjectHashMap.newWithKeysValues(element1, 1, element2, 2).asSynchronized().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedFloatObjectMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatObjectMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatObjectMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.floatIterator = SynchronizedFloatObjectMapKeysViewTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedFloatObjectMapKeysViewTest::forEach;
            this.payloads.size = SynchronizedFloatObjectMapKeysViewTest::size;
            this.payloads.isEmpty = SynchronizedFloatObjectMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatObjectMapKeysViewTest::notEmpty;
            this.payloads.count = SynchronizedFloatObjectMapKeysViewTest::count;
            this.payloads.anySatisfy = SynchronizedFloatObjectMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatObjectMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedFloatObjectMapKeysViewTest::noneSatisfy;
            this.payloads.select = SynchronizedFloatObjectMapKeysViewTest::select;
            this.payloads.reject = SynchronizedFloatObjectMapKeysViewTest::reject;
            this.payloads.detectIfNone = SynchronizedFloatObjectMapKeysViewTest::detectIfNone;
            this.payloads.collect = SynchronizedFloatObjectMapKeysViewTest::collect;
            this.payloads.tap = SynchronizedFloatObjectMapKeysViewTest::tap;
            this.payloads.flatCollect = SynchronizedFloatObjectMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = SynchronizedFloatObjectMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = SynchronizedFloatObjectMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = SynchronizedFloatObjectMapKeysViewTest::max;
            this.payloads.min = SynchronizedFloatObjectMapKeysViewTest::min;
            this.payloads.minIfEmpty = SynchronizedFloatObjectMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatObjectMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = SynchronizedFloatObjectMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedFloatObjectMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatObjectMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SynchronizedFloatObjectMapKeysViewTest::toArray;
            this.payloads.contains = SynchronizedFloatObjectMapKeysViewTest::contains;
            this.payloads.containsAllArray = SynchronizedFloatObjectMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedFloatObjectMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = SynchronizedFloatObjectMapKeysViewTest::testToString;
            this.payloads.makeString = SynchronizedFloatObjectMapKeysViewTest::makeString;
            this.payloads.appendString = SynchronizedFloatObjectMapKeysViewTest::appendString;
            this.payloads.toList = SynchronizedFloatObjectMapKeysViewTest::toList;
            this.payloads.toSortedArray = SynchronizedFloatObjectMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = SynchronizedFloatObjectMapKeysViewTest::toSortedList;
            this.payloads.toSet = SynchronizedFloatObjectMapKeysViewTest::toSet;
            this.payloads.toBag = SynchronizedFloatObjectMapKeysViewTest::toBag;
            this.payloads.asLazy = SynchronizedFloatObjectMapKeysViewTest::asLazy;
        }
    }
}
