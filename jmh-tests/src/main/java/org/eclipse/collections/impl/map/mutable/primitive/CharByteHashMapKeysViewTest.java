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
 * JUnit test for {@link CharByteHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class CharByteHashMapKeysViewTest extends AbstractLazyCharIterableTestCase {

    @Override
    protected LazyCharIterable classUnderTest() {
        return CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3).keysView();
    }

    @Override
    protected LazyCharIterable getEmptyIterable() {
        return new CharByteHashMap().keysView();
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2) {
        return CharByteHashMap.newWithKeysValues(element1, (byte) 1, element2, (byte) 2).keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharByteHashMapKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new CharByteHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.charIterator = CharByteHashMapKeysViewTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = CharByteHashMapKeysViewTest::forEach;
            this.payloads.size = CharByteHashMapKeysViewTest::size;
            this.payloads.isEmpty = CharByteHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = CharByteHashMapKeysViewTest::notEmpty;
            this.payloads.count = CharByteHashMapKeysViewTest::count;
            this.payloads.anySatisfy = CharByteHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = CharByteHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = CharByteHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = CharByteHashMapKeysViewTest::select;
            this.payloads.reject = CharByteHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = CharByteHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = CharByteHashMapKeysViewTest::collect;
            this.payloads.tap = CharByteHashMapKeysViewTest::tap;
            this.payloads.flatCollect = CharByteHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = CharByteHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = CharByteHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = CharByteHashMapKeysViewTest::max;
            this.payloads.min = CharByteHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = CharByteHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharByteHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = CharByteHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CharByteHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = CharByteHashMapKeysViewTest::toArray;
            this.payloads.contains = CharByteHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = CharByteHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = CharByteHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = CharByteHashMapKeysViewTest::testToString;
            this.payloads.makeString = CharByteHashMapKeysViewTest::makeString;
            this.payloads.appendString = CharByteHashMapKeysViewTest::appendString;
            this.payloads.toList = CharByteHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = CharByteHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = CharByteHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = CharByteHashMapKeysViewTest::toSet;
            this.payloads.toBag = CharByteHashMapKeysViewTest::toBag;
            this.payloads.asLazy = CharByteHashMapKeysViewTest::asLazy;
        }
    }
}
