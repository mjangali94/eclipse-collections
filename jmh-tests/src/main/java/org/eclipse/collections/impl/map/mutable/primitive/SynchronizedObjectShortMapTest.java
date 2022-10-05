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

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedObjectShortMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectShortMapTest extends AbstractMutableObjectShortMapTestCase {

    private final SynchronizedObjectShortMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectShortMap<String> classUnderTest() {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4) {
        return new SynchronizedObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectShortMap<T> getEmptyMap() {
        return new SynchronizedObjectShortMap<>(new ObjectShortHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedObjectShortMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedObjectShortMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectShortMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedObjectShortMapTest::keySet;
            this.payloads.values = SynchronizedObjectShortMapTest::values;
            this.payloads.isEmpty = SynchronizedObjectShortMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedObjectShortMapTest::notEmpty;
            this.payloads.asLazy = SynchronizedObjectShortMapTest::asLazy;
            this.payloads.testEquals = SynchronizedObjectShortMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedObjectShortMapTest::testHashCode;
            this.payloads.testToString = SynchronizedObjectShortMapTest::testToString;
            this.payloads.shortIterator = SynchronizedObjectShortMapTest::shortIterator;
            this.payloads.forEach = SynchronizedObjectShortMapTest::forEach;
            this.payloads.forEachValue = SynchronizedObjectShortMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedObjectShortMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedObjectShortMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedObjectShortMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedObjectShortMapTest::makeString;
            this.payloads.appendString = SynchronizedObjectShortMapTest::appendString;
            this.payloads.select = SynchronizedObjectShortMapTest::select;
            this.payloads.reject = SynchronizedObjectShortMapTest::reject;
            this.payloads.tap = SynchronizedObjectShortMapTest::tap;
            this.payloads.count = SynchronizedObjectShortMapTest::count;
            this.payloads.anySatisfy = SynchronizedObjectShortMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedObjectShortMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedObjectShortMapTest::noneSatisfy;
            this.payloads.detectIfNone = SynchronizedObjectShortMapTest::detectIfNone;
            this.payloads.collect = SynchronizedObjectShortMapTest::collect;
            this.payloads.sum = SynchronizedObjectShortMapTest::sum;
            this.payloads.max = SynchronizedObjectShortMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedObjectShortMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = SynchronizedObjectShortMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = SynchronizedObjectShortMapTest::minIfEmpty;
            this.payloads.average = SynchronizedObjectShortMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedObjectShortMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectShortMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SynchronizedObjectShortMapTest::toArray;
            this.payloads.toSortedArray = SynchronizedObjectShortMapTest::toSortedArray;
            this.payloads.containsAll = SynchronizedObjectShortMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedObjectShortMapTest::containsAll_Iterable;
            this.payloads.toList = SynchronizedObjectShortMapTest::toList;
            this.payloads.toSortedList = SynchronizedObjectShortMapTest::toSortedList;
            this.payloads.toSet = SynchronizedObjectShortMapTest::toSet;
            this.payloads.toBag = SynchronizedObjectShortMapTest::toBag;
            this.payloads.toImmutable = SynchronizedObjectShortMapTest::toImmutable;
            this.payloads.clear = SynchronizedObjectShortMapTest::clear;
            this.payloads.removeKey = SynchronizedObjectShortMapTest::removeKey;
            this.payloads.remove = SynchronizedObjectShortMapTest::remove;
            this.payloads.put = SynchronizedObjectShortMapTest::put;
            this.payloads.updateValues = SynchronizedObjectShortMapTest::updateValues;
            this.payloads.putPair = SynchronizedObjectShortMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedObjectShortMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = SynchronizedObjectShortMapTest::get;
            this.payloads.getOrThrow = SynchronizedObjectShortMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedObjectShortMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = SynchronizedObjectShortMapTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = SynchronizedObjectShortMapTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedObjectShortMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedObjectShortMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedObjectShortMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedObjectShortMapTest::updateValue;
            this.payloads.addToValue = SynchronizedObjectShortMapTest::addToValue;
            this.payloads.containsKey = SynchronizedObjectShortMapTest::containsKey;
            this.payloads.containsValue = SynchronizedObjectShortMapTest::containsValue;
            this.payloads.size = SynchronizedObjectShortMapTest::size;
            this.payloads.withKeysValues = SynchronizedObjectShortMapTest::withKeysValues;
            this.payloads.withoutKey = SynchronizedObjectShortMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedObjectShortMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedObjectShortMapTest::withAllKeyValues;
            this.payloads.contains = SynchronizedObjectShortMapTest::contains;
            this.payloads.asUnmodifiable = SynchronizedObjectShortMapTest::asUnmodifiable;
            this.payloads.flipUniqueValues = SynchronizedObjectShortMapTest::flipUniqueValues;
            this.payloads.asSynchronized = SynchronizedObjectShortMapTest::asSynchronized;
        }
    }
}
