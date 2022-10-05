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
 * JUnit test for {@link SynchronizedIntByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntByteMapTest extends AbstractMutableIntByteMapTestCase {

    private final SynchronizedIntByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntByteMap classUnderTest() {
        return new SynchronizedIntByteMap(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1) {
        return new SynchronizedIntByteMap(new IntByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2) {
        return new SynchronizedIntByteMap(new IntByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3) {
        return new SynchronizedIntByteMap(new IntByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3, int key4, byte value4) {
        return new SynchronizedIntByteMap(new IntByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntByteMap getEmptyMap() {
        return new SynchronizedIntByteMap(new IntByteHashMap());
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

        private SynchronizedIntByteMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedIntByteMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntByteMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedIntByteMapTest::keySet;
            this.payloads.values = SynchronizedIntByteMapTest::values;
            this.payloads.containsAll = SynchronizedIntByteMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedIntByteMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedIntByteMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedIntByteMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedIntByteMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedIntByteMapTest::testHashCode;
            this.payloads.testToString = SynchronizedIntByteMapTest::testToString;
            this.payloads.forEach = SynchronizedIntByteMapTest::forEach;
            this.payloads.forEachValue = SynchronizedIntByteMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedIntByteMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedIntByteMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedIntByteMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedIntByteMapTest::makeString;
            this.payloads.appendString = SynchronizedIntByteMapTest::appendString;
            this.payloads.select = SynchronizedIntByteMapTest::select;
            this.payloads.reject = SynchronizedIntByteMapTest::reject;
            this.payloads.select_value = SynchronizedIntByteMapTest::select_value;
            this.payloads.reject_value = SynchronizedIntByteMapTest::reject_value;
            this.payloads.collect = SynchronizedIntByteMapTest::collect;
            this.payloads.count = SynchronizedIntByteMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedIntByteMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedIntByteMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedIntByteMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedIntByteMapTest::noneSatisfy;
            this.payloads.max = SynchronizedIntByteMapTest::max;
            this.payloads.min = SynchronizedIntByteMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntByteMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntByteMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedIntByteMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedIntByteMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedIntByteMapTest::sum;
            this.payloads.average = SynchronizedIntByteMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntByteMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedIntByteMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntByteMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedIntByteMapTest::toList;
            this.payloads.toSortedList = SynchronizedIntByteMapTest::toSortedList;
            this.payloads.toSet = SynchronizedIntByteMapTest::toSet;
            this.payloads.toBag = SynchronizedIntByteMapTest::toBag;
            this.payloads.byteIterator = SynchronizedIntByteMapTest::byteIterator;
            this.payloads.asLazy = SynchronizedIntByteMapTest::asLazy;
            this.payloads.keysView = SynchronizedIntByteMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedIntByteMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedIntByteMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedIntByteMapTest::toArray;
            this.payloads.toImmutable = SynchronizedIntByteMapTest::toImmutable;
            this.payloads.chunk = SynchronizedIntByteMapTest::chunk;
            this.payloads.get = SynchronizedIntByteMapTest::get;
            this.payloads.getOrThrow = SynchronizedIntByteMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedIntByteMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedIntByteMapTest::containsKey;
            this.payloads.containsValue = SynchronizedIntByteMapTest::containsValue;
            this.payloads.contains = SynchronizedIntByteMapTest::contains;
            this.payloads.size = SynchronizedIntByteMapTest::size;
            this.payloads.clear = SynchronizedIntByteMapTest::clear;
            this.payloads.removeKey = SynchronizedIntByteMapTest::removeKey;
            this.payloads.remove = SynchronizedIntByteMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedIntByteMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedIntByteMapTest::put;
            this.payloads.getAndPut = SynchronizedIntByteMapTest::getAndPut;
            this.payloads.putPair = SynchronizedIntByteMapTest::putPair;
            this.payloads.updateValues = SynchronizedIntByteMapTest::updateValues;
            this.payloads.addToValue = SynchronizedIntByteMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedIntByteMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedIntByteMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedIntByteMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedIntByteMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedIntByteMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedIntByteMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedIntByteMapTest::updateValue;
            this.payloads.freeze = SynchronizedIntByteMapTest::freeze;
            this.payloads.withoutKey = SynchronizedIntByteMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedIntByteMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedIntByteMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedIntByteMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedIntByteMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = SynchronizedIntByteMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedIntByteMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedIntByteMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedIntByteMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedIntByteMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedIntByteMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedIntByteMapTest::asSynchronized;
        }
    }
}
