/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;

/**
 * JUnit test for {@link ImmutableLongObjectHashMap#keysView}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeysViewTest.stg.
 */
public class ImmutableLongObjectHashMapKeysViewTest extends AbstractLazyLongIterableTestCase {

    @Override
    protected LazyLongIterable classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3).toImmutable().keysView();
    }

    @Override
    protected LazyLongIterable getEmptyIterable() {
        return LongObjectHashMap.newMap().toImmutable().keysView();
    }

    @Override
    protected LazyLongIterable newWith(long element1, long element2) {
        return LongObjectHashMap.newWithKeysValues(element1, 1, element2, 2).toImmutable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongObjectHashMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongObjectHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongObjectHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.longIterator = ImmutableLongObjectHashMapKeysViewTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableLongObjectHashMapKeysViewTest::forEach;
            this.payloads.size = ImmutableLongObjectHashMapKeysViewTest::size;
            this.payloads.isEmpty = ImmutableLongObjectHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongObjectHashMapKeysViewTest::notEmpty;
            this.payloads.count = ImmutableLongObjectHashMapKeysViewTest::count;
            this.payloads.anySatisfy = ImmutableLongObjectHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableLongObjectHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableLongObjectHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = ImmutableLongObjectHashMapKeysViewTest::select;
            this.payloads.reject = ImmutableLongObjectHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = ImmutableLongObjectHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = ImmutableLongObjectHashMapKeysViewTest::collect;
            this.payloads.tap = ImmutableLongObjectHashMapKeysViewTest::tap;
            this.payloads.flatCollect = ImmutableLongObjectHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = ImmutableLongObjectHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = ImmutableLongObjectHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = ImmutableLongObjectHashMapKeysViewTest::max;
            this.payloads.min = ImmutableLongObjectHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = ImmutableLongObjectHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableLongObjectHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = ImmutableLongObjectHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableLongObjectHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongObjectHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableLongObjectHashMapKeysViewTest::toArray;
            this.payloads.contains = ImmutableLongObjectHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = ImmutableLongObjectHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableLongObjectHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = ImmutableLongObjectHashMapKeysViewTest::testToString;
            this.payloads.makeString = ImmutableLongObjectHashMapKeysViewTest::makeString;
            this.payloads.appendString = ImmutableLongObjectHashMapKeysViewTest::appendString;
            this.payloads.toList = ImmutableLongObjectHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = ImmutableLongObjectHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = ImmutableLongObjectHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = ImmutableLongObjectHashMapKeysViewTest::toSet;
            this.payloads.toBag = ImmutableLongObjectHashMapKeysViewTest::toBag;
            this.payloads.asLazy = ImmutableLongObjectHashMapKeysViewTest::asLazy;
        }
    }
}
