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
 * JUnit test for {@link SynchronizedLongByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongByteMapTest extends AbstractMutableLongByteMapTestCase {

    private final SynchronizedLongByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongByteMap classUnderTest() {
        return new SynchronizedLongByteMap(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1) {
        return new SynchronizedLongByteMap(new LongByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2) {
        return new SynchronizedLongByteMap(new LongByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3) {
        return new SynchronizedLongByteMap(new LongByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3, long key4, byte value4) {
        return new SynchronizedLongByteMap(new LongByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongByteMap getEmptyMap() {
        return new SynchronizedLongByteMap(new LongByteHashMap());
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

        private SynchronizedLongByteMapTest instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongByteMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongByteMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedLongByteMapTest::keySet;
            this.payloads.values = SynchronizedLongByteMapTest::values;
            this.payloads.containsAll = SynchronizedLongByteMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedLongByteMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedLongByteMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedLongByteMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedLongByteMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedLongByteMapTest::testHashCode;
            this.payloads.testToString = SynchronizedLongByteMapTest::testToString;
            this.payloads.forEach = SynchronizedLongByteMapTest::forEach;
            this.payloads.forEachValue = SynchronizedLongByteMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedLongByteMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedLongByteMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedLongByteMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedLongByteMapTest::makeString;
            this.payloads.appendString = SynchronizedLongByteMapTest::appendString;
            this.payloads.select = SynchronizedLongByteMapTest::select;
            this.payloads.reject = SynchronizedLongByteMapTest::reject;
            this.payloads.select_value = SynchronizedLongByteMapTest::select_value;
            this.payloads.reject_value = SynchronizedLongByteMapTest::reject_value;
            this.payloads.collect = SynchronizedLongByteMapTest::collect;
            this.payloads.count = SynchronizedLongByteMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedLongByteMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedLongByteMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedLongByteMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedLongByteMapTest::noneSatisfy;
            this.payloads.max = SynchronizedLongByteMapTest::max;
            this.payloads.min = SynchronizedLongByteMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongByteMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongByteMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedLongByteMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedLongByteMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedLongByteMapTest::sum;
            this.payloads.average = SynchronizedLongByteMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongByteMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedLongByteMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongByteMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedLongByteMapTest::toList;
            this.payloads.toSortedList = SynchronizedLongByteMapTest::toSortedList;
            this.payloads.toSet = SynchronizedLongByteMapTest::toSet;
            this.payloads.toBag = SynchronizedLongByteMapTest::toBag;
            this.payloads.byteIterator = SynchronizedLongByteMapTest::byteIterator;
            this.payloads.asLazy = SynchronizedLongByteMapTest::asLazy;
            this.payloads.keysView = SynchronizedLongByteMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedLongByteMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedLongByteMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedLongByteMapTest::toArray;
            this.payloads.toImmutable = SynchronizedLongByteMapTest::toImmutable;
            this.payloads.chunk = SynchronizedLongByteMapTest::chunk;
            this.payloads.get = SynchronizedLongByteMapTest::get;
            this.payloads.getOrThrow = SynchronizedLongByteMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedLongByteMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedLongByteMapTest::containsKey;
            this.payloads.containsValue = SynchronizedLongByteMapTest::containsValue;
            this.payloads.contains = SynchronizedLongByteMapTest::contains;
            this.payloads.size = SynchronizedLongByteMapTest::size;
            this.payloads.clear = SynchronizedLongByteMapTest::clear;
            this.payloads.removeKey = SynchronizedLongByteMapTest::removeKey;
            this.payloads.remove = SynchronizedLongByteMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedLongByteMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedLongByteMapTest::put;
            this.payloads.getAndPut = SynchronizedLongByteMapTest::getAndPut;
            this.payloads.putPair = SynchronizedLongByteMapTest::putPair;
            this.payloads.updateValues = SynchronizedLongByteMapTest::updateValues;
            this.payloads.addToValue = SynchronizedLongByteMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedLongByteMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedLongByteMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedLongByteMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedLongByteMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedLongByteMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedLongByteMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedLongByteMapTest::updateValue;
            this.payloads.freeze = SynchronizedLongByteMapTest::freeze;
            this.payloads.withoutKey = SynchronizedLongByteMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedLongByteMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedLongByteMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedLongByteMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedLongByteMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = SynchronizedLongByteMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedLongByteMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedLongByteMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedLongByteMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedLongByteMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedLongByteMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedLongByteMapTest::asSynchronized;
        }
    }
}
