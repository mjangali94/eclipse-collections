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
 * JUnit test for {@link SynchronizedObjectCharMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectCharMapTest extends AbstractMutableObjectCharMapTestCase {

    private final SynchronizedObjectCharMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectCharMap<String> classUnderTest() {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1) {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2) {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3) {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4) {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> getEmptyMap() {
        return new SynchronizedObjectCharMap<>(new ObjectCharHashMap<>());
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

        private SynchronizedObjectCharMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedObjectCharMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedObjectCharMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedObjectCharMapTest::keySet;
            this.payloads.values = SynchronizedObjectCharMapTest::values;
            this.payloads.isEmpty = SynchronizedObjectCharMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedObjectCharMapTest::notEmpty;
            this.payloads.asLazy = SynchronizedObjectCharMapTest::asLazy;
            this.payloads.testEquals = SynchronizedObjectCharMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedObjectCharMapTest::testHashCode;
            this.payloads.testToString = SynchronizedObjectCharMapTest::testToString;
            this.payloads.charIterator = SynchronizedObjectCharMapTest::charIterator;
            this.payloads.forEach = SynchronizedObjectCharMapTest::forEach;
            this.payloads.forEachValue = SynchronizedObjectCharMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedObjectCharMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedObjectCharMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedObjectCharMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedObjectCharMapTest::makeString;
            this.payloads.appendString = SynchronizedObjectCharMapTest::appendString;
            this.payloads.select = SynchronizedObjectCharMapTest::select;
            this.payloads.reject = SynchronizedObjectCharMapTest::reject;
            this.payloads.tap = SynchronizedObjectCharMapTest::tap;
            this.payloads.count = SynchronizedObjectCharMapTest::count;
            this.payloads.anySatisfy = SynchronizedObjectCharMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedObjectCharMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedObjectCharMapTest::noneSatisfy;
            this.payloads.detectIfNone = SynchronizedObjectCharMapTest::detectIfNone;
            this.payloads.collect = SynchronizedObjectCharMapTest::collect;
            this.payloads.sum = SynchronizedObjectCharMapTest::sum;
            this.payloads.max = SynchronizedObjectCharMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectCharMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedObjectCharMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectCharMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = SynchronizedObjectCharMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = SynchronizedObjectCharMapTest::minIfEmpty;
            this.payloads.average = SynchronizedObjectCharMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectCharMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedObjectCharMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedObjectCharMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = SynchronizedObjectCharMapTest::toArray;
            this.payloads.toSortedArray = SynchronizedObjectCharMapTest::toSortedArray;
            this.payloads.containsAll = SynchronizedObjectCharMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedObjectCharMapTest::containsAll_Iterable;
            this.payloads.toList = SynchronizedObjectCharMapTest::toList;
            this.payloads.toSortedList = SynchronizedObjectCharMapTest::toSortedList;
            this.payloads.toSet = SynchronizedObjectCharMapTest::toSet;
            this.payloads.toBag = SynchronizedObjectCharMapTest::toBag;
            this.payloads.toImmutable = SynchronizedObjectCharMapTest::toImmutable;
            this.payloads.clear = SynchronizedObjectCharMapTest::clear;
            this.payloads.removeKey = SynchronizedObjectCharMapTest::removeKey;
            this.payloads.remove = SynchronizedObjectCharMapTest::remove;
            this.payloads.put = SynchronizedObjectCharMapTest::put;
            this.payloads.updateValues = SynchronizedObjectCharMapTest::updateValues;
            this.payloads.putPair = SynchronizedObjectCharMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedObjectCharMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = SynchronizedObjectCharMapTest::get;
            this.payloads.getOrThrow = SynchronizedObjectCharMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedObjectCharMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = SynchronizedObjectCharMapTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = SynchronizedObjectCharMapTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedObjectCharMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedObjectCharMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedObjectCharMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedObjectCharMapTest::updateValue;
            this.payloads.addToValue = SynchronizedObjectCharMapTest::addToValue;
            this.payloads.containsKey = SynchronizedObjectCharMapTest::containsKey;
            this.payloads.containsValue = SynchronizedObjectCharMapTest::containsValue;
            this.payloads.size = SynchronizedObjectCharMapTest::size;
            this.payloads.withKeysValues = SynchronizedObjectCharMapTest::withKeysValues;
            this.payloads.withoutKey = SynchronizedObjectCharMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedObjectCharMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = SynchronizedObjectCharMapTest::withAllKeyValues;
            this.payloads.contains = SynchronizedObjectCharMapTest::contains;
            this.payloads.asUnmodifiable = SynchronizedObjectCharMapTest::asUnmodifiable;
            this.payloads.flipUniqueValues = SynchronizedObjectCharMapTest::flipUniqueValues;
            this.payloads.asSynchronized = SynchronizedObjectCharMapTest::asSynchronized;
        }
    }
}
