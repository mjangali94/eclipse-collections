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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyByteIterableTestCase;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;

/**
 * JUnit test for {@link ImmutableByteObjectHashMap#keysView}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeysViewTest.stg.
 */
public class ImmutableByteObjectHashMapKeysViewTest extends AbstractLazyByteIterableTestCase {

    @Override
    protected LazyByteIterable classUnderTest() {
        return ByteObjectHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3).toImmutable().keysView();
    }

    @Override
    protected LazyByteIterable getEmptyIterable() {
        return ByteObjectHashMap.newMap().toImmutable().keysView();
    }

    @Override
    protected LazyByteIterable newWith(byte element1, byte element2) {
        return ByteObjectHashMap.newWithKeysValues(element1, 1, element2, 2).toImmutable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteObjectHashMapKeysViewTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteObjectHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> lazyCollectPrimitives;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> max_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> min_throws_emptyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> maxThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> minThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteObjectHashMapKeysViewTest> asLazy;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.byteIterator = ImmutableByteObjectHashMapKeysViewTest::byteIterator;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableByteObjectHashMapKeysViewTest::forEach;
            this.payloads.size = ImmutableByteObjectHashMapKeysViewTest::size;
            this.payloads.isEmpty = ImmutableByteObjectHashMapKeysViewTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteObjectHashMapKeysViewTest::notEmpty;
            this.payloads.count = ImmutableByteObjectHashMapKeysViewTest::count;
            this.payloads.anySatisfy = ImmutableByteObjectHashMapKeysViewTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteObjectHashMapKeysViewTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteObjectHashMapKeysViewTest::noneSatisfy;
            this.payloads.select = ImmutableByteObjectHashMapKeysViewTest::select;
            this.payloads.reject = ImmutableByteObjectHashMapKeysViewTest::reject;
            this.payloads.detectIfNone = ImmutableByteObjectHashMapKeysViewTest::detectIfNone;
            this.payloads.collect = ImmutableByteObjectHashMapKeysViewTest::collect;
            this.payloads.tap = ImmutableByteObjectHashMapKeysViewTest::tap;
            this.payloads.flatCollect = ImmutableByteObjectHashMapKeysViewTest::flatCollect;
            this.payloads.lazyCollectPrimitives = ImmutableByteObjectHashMapKeysViewTest::lazyCollectPrimitives;
            this.payloads.sum = ImmutableByteObjectHashMapKeysViewTest::sum;
            this.payloads.max_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::max_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.min_throws_emptyIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::min_throws_emptyIterable, java.util.NoSuchElementException.class);
            this.payloads.max = ImmutableByteObjectHashMapKeysViewTest::max;
            this.payloads.min = ImmutableByteObjectHashMapKeysViewTest::min;
            this.payloads.minIfEmpty = ImmutableByteObjectHashMapKeysViewTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteObjectHashMapKeysViewTest::maxIfEmpty;
            this.payloads.maxThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::maxThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.minThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::minThrowsOnEmpty, java.util.NoSuchElementException.class);
            this.payloads.average = ImmutableByteObjectHashMapKeysViewTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableByteObjectHashMapKeysViewTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteObjectHashMapKeysViewTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableByteObjectHashMapKeysViewTest::toArray;
            this.payloads.contains = ImmutableByteObjectHashMapKeysViewTest::contains;
            this.payloads.containsAllArray = ImmutableByteObjectHashMapKeysViewTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableByteObjectHashMapKeysViewTest::containsAllIterable;
            this.payloads.testToString = ImmutableByteObjectHashMapKeysViewTest::testToString;
            this.payloads.makeString = ImmutableByteObjectHashMapKeysViewTest::makeString;
            this.payloads.appendString = ImmutableByteObjectHashMapKeysViewTest::appendString;
            this.payloads.toList = ImmutableByteObjectHashMapKeysViewTest::toList;
            this.payloads.toSortedArray = ImmutableByteObjectHashMapKeysViewTest::toSortedArray;
            this.payloads.toSortedList = ImmutableByteObjectHashMapKeysViewTest::toSortedList;
            this.payloads.toSet = ImmutableByteObjectHashMapKeysViewTest::toSet;
            this.payloads.toBag = ImmutableByteObjectHashMapKeysViewTest::toBag;
            this.payloads.asLazy = ImmutableByteObjectHashMapKeysViewTest::asLazy;
        }
    }
}
