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
 * JUnit test for {@link SynchronizedShortCharMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortCharMapTest extends AbstractMutableShortCharMapTestCase {

    private final SynchronizedShortCharMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortCharMap classUnderTest() {
        return new SynchronizedShortCharMap(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3, short key4, char value4) {
        return new SynchronizedShortCharMap(new ShortCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortCharMap getEmptyMap() {
        return new SynchronizedShortCharMap(new ShortCharHashMap());
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

        private SynchronizedShortCharMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
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
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
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
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortCharMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortCharMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedShortCharMapTest::keySet;
            this.payloads.values = SynchronizedShortCharMapTest::values;
            this.payloads.containsAll = SynchronizedShortCharMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedShortCharMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedShortCharMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortCharMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedShortCharMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedShortCharMapTest::testHashCode;
            this.payloads.testToString = SynchronizedShortCharMapTest::testToString;
            this.payloads.forEach = SynchronizedShortCharMapTest::forEach;
            this.payloads.forEachValue = SynchronizedShortCharMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedShortCharMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedShortCharMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedShortCharMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedShortCharMapTest::makeString;
            this.payloads.appendString = SynchronizedShortCharMapTest::appendString;
            this.payloads.select = SynchronizedShortCharMapTest::select;
            this.payloads.reject = SynchronizedShortCharMapTest::reject;
            this.payloads.select_value = SynchronizedShortCharMapTest::select_value;
            this.payloads.reject_value = SynchronizedShortCharMapTest::reject_value;
            this.payloads.collect = SynchronizedShortCharMapTest::collect;
            this.payloads.count = SynchronizedShortCharMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedShortCharMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedShortCharMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortCharMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedShortCharMapTest::noneSatisfy;
            this.payloads.max = SynchronizedShortCharMapTest::max;
            this.payloads.min = SynchronizedShortCharMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedShortCharMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedShortCharMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedShortCharMapTest::sum;
            this.payloads.average = SynchronizedShortCharMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedShortCharMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortCharMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedShortCharMapTest::toList;
            this.payloads.toSortedList = SynchronizedShortCharMapTest::toSortedList;
            this.payloads.toSet = SynchronizedShortCharMapTest::toSet;
            this.payloads.toBag = SynchronizedShortCharMapTest::toBag;
            this.payloads.charIterator = SynchronizedShortCharMapTest::charIterator;
            this.payloads.asLazy = SynchronizedShortCharMapTest::asLazy;
            this.payloads.keysView = SynchronizedShortCharMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedShortCharMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedShortCharMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedShortCharMapTest::toArray;
            this.payloads.toImmutable = SynchronizedShortCharMapTest::toImmutable;
            this.payloads.chunk = SynchronizedShortCharMapTest::chunk;
            this.payloads.get = SynchronizedShortCharMapTest::get;
            this.payloads.getOrThrow = SynchronizedShortCharMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedShortCharMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedShortCharMapTest::containsKey;
            this.payloads.containsValue = SynchronizedShortCharMapTest::containsValue;
            this.payloads.contains = SynchronizedShortCharMapTest::contains;
            this.payloads.size = SynchronizedShortCharMapTest::size;
            this.payloads.clear = SynchronizedShortCharMapTest::clear;
            this.payloads.removeKey = SynchronizedShortCharMapTest::removeKey;
            this.payloads.remove = SynchronizedShortCharMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedShortCharMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedShortCharMapTest::put;
            this.payloads.getAndPut = SynchronizedShortCharMapTest::getAndPut;
            this.payloads.putPair = SynchronizedShortCharMapTest::putPair;
            this.payloads.updateValues = SynchronizedShortCharMapTest::updateValues;
            this.payloads.addToValue = SynchronizedShortCharMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedShortCharMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedShortCharMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedShortCharMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedShortCharMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedShortCharMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedShortCharMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedShortCharMapTest::updateValue;
            this.payloads.freeze = SynchronizedShortCharMapTest::freeze;
            this.payloads.withoutKey = SynchronizedShortCharMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedShortCharMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedShortCharMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedShortCharMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedShortCharMapTest::asUnmodifiable;
            this.payloads.charIterator_with_remove = SynchronizedShortCharMapTest::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedShortCharMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedShortCharMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedShortCharMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedShortCharMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedShortCharMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedShortCharMapTest::asSynchronized;
        }
    }
}
