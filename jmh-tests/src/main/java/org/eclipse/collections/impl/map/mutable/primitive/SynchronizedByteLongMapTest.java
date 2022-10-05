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
 * JUnit test for {@link SynchronizedByteLongMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteLongMapTest extends AbstractMutableByteLongMapTestCase {

    private final SynchronizedByteLongMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteLongMap classUnderTest() {
        return new SynchronizedByteLongMap(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L));
    }

    @Override
    protected SynchronizedByteLongMap newWithKeysValues(byte key1, long value1) {
        return new SynchronizedByteLongMap(new ByteLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2) {
        return new SynchronizedByteLongMap(new ByteLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3) {
        return new SynchronizedByteLongMap(new ByteLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3, byte key4, long value4) {
        return new SynchronizedByteLongMap(new ByteLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteLongMap getEmptyMap() {
        return new SynchronizedByteLongMap(new ByteLongHashMap());
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

        private SynchronizedByteLongMapTest instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteLongMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteLongMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedByteLongMapTest::keySet;
            this.payloads.values = SynchronizedByteLongMapTest::values;
            this.payloads.containsAll = SynchronizedByteLongMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedByteLongMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedByteLongMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteLongMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedByteLongMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedByteLongMapTest::testHashCode;
            this.payloads.testToString = SynchronizedByteLongMapTest::testToString;
            this.payloads.forEach = SynchronizedByteLongMapTest::forEach;
            this.payloads.forEachValue = SynchronizedByteLongMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedByteLongMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedByteLongMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedByteLongMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedByteLongMapTest::makeString;
            this.payloads.appendString = SynchronizedByteLongMapTest::appendString;
            this.payloads.select = SynchronizedByteLongMapTest::select;
            this.payloads.reject = SynchronizedByteLongMapTest::reject;
            this.payloads.select_value = SynchronizedByteLongMapTest::select_value;
            this.payloads.reject_value = SynchronizedByteLongMapTest::reject_value;
            this.payloads.collect = SynchronizedByteLongMapTest::collect;
            this.payloads.count = SynchronizedByteLongMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedByteLongMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedByteLongMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteLongMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteLongMapTest::noneSatisfy;
            this.payloads.max = SynchronizedByteLongMapTest::max;
            this.payloads.min = SynchronizedByteLongMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteLongMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteLongMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteLongMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteLongMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteLongMapTest::sum;
            this.payloads.average = SynchronizedByteLongMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteLongMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedByteLongMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteLongMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedByteLongMapTest::toList;
            this.payloads.toSortedList = SynchronizedByteLongMapTest::toSortedList;
            this.payloads.toSet = SynchronizedByteLongMapTest::toSet;
            this.payloads.toBag = SynchronizedByteLongMapTest::toBag;
            this.payloads.longIterator = SynchronizedByteLongMapTest::longIterator;
            this.payloads.asLazy = SynchronizedByteLongMapTest::asLazy;
            this.payloads.keysView = SynchronizedByteLongMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedByteLongMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedByteLongMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedByteLongMapTest::toArray;
            this.payloads.toImmutable = SynchronizedByteLongMapTest::toImmutable;
            this.payloads.chunk = SynchronizedByteLongMapTest::chunk;
            this.payloads.get = SynchronizedByteLongMapTest::get;
            this.payloads.getOrThrow = SynchronizedByteLongMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedByteLongMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedByteLongMapTest::containsKey;
            this.payloads.containsValue = SynchronizedByteLongMapTest::containsValue;
            this.payloads.contains = SynchronizedByteLongMapTest::contains;
            this.payloads.size = SynchronizedByteLongMapTest::size;
            this.payloads.clear = SynchronizedByteLongMapTest::clear;
            this.payloads.removeKey = SynchronizedByteLongMapTest::removeKey;
            this.payloads.remove = SynchronizedByteLongMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedByteLongMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedByteLongMapTest::put;
            this.payloads.getAndPut = SynchronizedByteLongMapTest::getAndPut;
            this.payloads.putPair = SynchronizedByteLongMapTest::putPair;
            this.payloads.updateValues = SynchronizedByteLongMapTest::updateValues;
            this.payloads.addToValue = SynchronizedByteLongMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedByteLongMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedByteLongMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedByteLongMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedByteLongMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedByteLongMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedByteLongMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedByteLongMapTest::updateValue;
            this.payloads.freeze = SynchronizedByteLongMapTest::freeze;
            this.payloads.withoutKey = SynchronizedByteLongMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedByteLongMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedByteLongMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedByteLongMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedByteLongMapTest::asUnmodifiable;
            this.payloads.longIterator_with_remove = SynchronizedByteLongMapTest::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedByteLongMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedByteLongMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedByteLongMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedByteLongMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedByteLongMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedByteLongMapTest::asSynchronized;
        }
    }
}
