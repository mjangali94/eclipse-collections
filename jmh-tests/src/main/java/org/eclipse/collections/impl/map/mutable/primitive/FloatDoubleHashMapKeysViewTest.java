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
 * JUnit test for {@link FloatDoubleHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class FloatDoubleHashMapKeysViewTest extends AbstractLazyFloatIterableTestCase {

    @Override
    protected LazyFloatIterable classUnderTest() {
        return FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0).keysView();
    }

    @Override
    protected LazyFloatIterable getEmptyIterable() {
        return new FloatDoubleHashMap().keysView();
    }

    @Override
    protected LazyFloatIterable newWith(float element1, float element2) {
        return FloatDoubleHashMap.newWithKeysValues(element1, 1.0, element2, 2.0).keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatDoubleHashMapKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new FloatDoubleHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatDoubleHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.floatIterator = FloatDoubleHashMapKeysViewTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FloatDoubleHashMapKeysViewTest::forEach;
            this.payloads.size = FloatDoubleHashMapKeysViewTest::size;
            this.payloads.isEmpty = FloatDoubleHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = FloatDoubleHashMapKeysViewTest::notEmpty;
            this.payloads.count = FloatDoubleHashMapKeysViewTest::count;
            this.payloads.anySatisfy = FloatDoubleHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = FloatDoubleHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = FloatDoubleHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = FloatDoubleHashMapKeysViewTest::select;
            this.payloads.reject = FloatDoubleHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = FloatDoubleHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = FloatDoubleHashMapKeysViewTest::collect;
            this.payloads.tap = FloatDoubleHashMapKeysViewTest::tap;
            this.payloads.flatCollect = FloatDoubleHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = FloatDoubleHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = FloatDoubleHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = FloatDoubleHashMapKeysViewTest::max;
            this.payloads.min = FloatDoubleHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = FloatDoubleHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatDoubleHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = FloatDoubleHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = FloatDoubleHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatDoubleHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = FloatDoubleHashMapKeysViewTest::toArray;
            this.payloads.contains = FloatDoubleHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = FloatDoubleHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = FloatDoubleHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = FloatDoubleHashMapKeysViewTest::testToString;
            this.payloads.makeString = FloatDoubleHashMapKeysViewTest::makeString;
            this.payloads.appendString = FloatDoubleHashMapKeysViewTest::appendString;
            this.payloads.toList = FloatDoubleHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = FloatDoubleHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = FloatDoubleHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = FloatDoubleHashMapKeysViewTest::toSet;
            this.payloads.toBag = FloatDoubleHashMapKeysViewTest::toBag;
            this.payloads.asLazy = FloatDoubleHashMapKeysViewTest::asLazy;
        }
    }
}
