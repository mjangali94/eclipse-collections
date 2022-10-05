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
 * JUnit test for {@link SynchronizedObjectLongMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectLongMapTest extends AbstractMutableObjectLongMapTestCase {

    private final SynchronizedObjectLongMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectLongMap<String> classUnderTest() {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4) {
        return new SynchronizedObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectLongMap<T> getEmptyMap() {
        return new SynchronizedObjectLongMap<>(new ObjectLongHashMap<>());
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

        private SynchronizedObjectLongMapTest instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedObjectLongMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectLongMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedObjectLongMapTest::keySet;
            this.payloads.values = SynchronizedObjectLongMapTest::values;
            this.payloads.isEmpty = SynchronizedObjectLongMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedObjectLongMapTest::notEmpty;
            this.payloads.asLazy = SynchronizedObjectLongMapTest::asLazy;
            this.payloads.testEquals = SynchronizedObjectLongMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedObjectLongMapTest::testHashCode;
            this.payloads.testToString = SynchronizedObjectLongMapTest::testToString;
            this.payloads.longIterator = SynchronizedObjectLongMapTest::longIterator;
            this.payloads.forEach = SynchronizedObjectLongMapTest::forEach;
            this.payloads.forEachValue = SynchronizedObjectLongMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedObjectLongMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedObjectLongMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedObjectLongMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedObjectLongMapTest::makeString;
            this.payloads.appendString = SynchronizedObjectLongMapTest::appendString;
            this.payloads.select = SynchronizedObjectLongMapTest::select;
            this.payloads.reject = SynchronizedObjectLongMapTest::reject;
            this.payloads.tap = SynchronizedObjectLongMapTest::tap;
            this.payloads.count = SynchronizedObjectLongMapTest::count;
            this.payloads.anySatisfy = SynchronizedObjectLongMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedObjectLongMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedObjectLongMapTest::noneSatisfy;
            this.payloads.detectIfNone = SynchronizedObjectLongMapTest::detectIfNone;
            this.payloads.collect = SynchronizedObjectLongMapTest::collect;
            this.payloads.sum = SynchronizedObjectLongMapTest::sum;
            this.payloads.max = SynchronizedObjectLongMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectLongMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedObjectLongMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectLongMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = SynchronizedObjectLongMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = SynchronizedObjectLongMapTest::minIfEmpty;
            this.payloads.average = SynchronizedObjectLongMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectLongMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedObjectLongMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectLongMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SynchronizedObjectLongMapTest::toArray;
            this.payloads.toSortedArray = SynchronizedObjectLongMapTest::toSortedArray;
            this.payloads.containsAll = SynchronizedObjectLongMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedObjectLongMapTest::containsAll_Iterable;
            this.payloads.toList = SynchronizedObjectLongMapTest::toList;
            this.payloads.toSortedList = SynchronizedObjectLongMapTest::toSortedList;
            this.payloads.toSet = SynchronizedObjectLongMapTest::toSet;
            this.payloads.toBag = SynchronizedObjectLongMapTest::toBag;
            this.payloads.toImmutable = SynchronizedObjectLongMapTest::toImmutable;
            this.payloads.clear = SynchronizedObjectLongMapTest::clear;
            this.payloads.removeKey = SynchronizedObjectLongMapTest::removeKey;
            this.payloads.remove = SynchronizedObjectLongMapTest::remove;
            this.payloads.put = SynchronizedObjectLongMapTest::put;
            this.payloads.updateValues = SynchronizedObjectLongMapTest::updateValues;
            this.payloads.putPair = SynchronizedObjectLongMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedObjectLongMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = SynchronizedObjectLongMapTest::get;
            this.payloads.getOrThrow = SynchronizedObjectLongMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedObjectLongMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = SynchronizedObjectLongMapTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = SynchronizedObjectLongMapTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedObjectLongMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedObjectLongMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedObjectLongMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedObjectLongMapTest::updateValue;
            this.payloads.addToValue = SynchronizedObjectLongMapTest::addToValue;
            this.payloads.containsKey = SynchronizedObjectLongMapTest::containsKey;
            this.payloads.containsValue = SynchronizedObjectLongMapTest::containsValue;
            this.payloads.size = SynchronizedObjectLongMapTest::size;
            this.payloads.withKeysValues = SynchronizedObjectLongMapTest::withKeysValues;
            this.payloads.withoutKey = SynchronizedObjectLongMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedObjectLongMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedObjectLongMapTest::withAllKeyValues;
            this.payloads.contains = SynchronizedObjectLongMapTest::contains;
            this.payloads.asUnmodifiable = SynchronizedObjectLongMapTest::asUnmodifiable;
            this.payloads.flipUniqueValues = SynchronizedObjectLongMapTest::flipUniqueValues;
            this.payloads.asSynchronized = SynchronizedObjectLongMapTest::asSynchronized;
        }
    }
}
