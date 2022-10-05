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
 * JUnit test for {@link SynchronizedByteShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteShortMapTest extends AbstractMutableByteShortMapTestCase {

    private final SynchronizedByteShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteShortMap classUnderTest() {
        return new SynchronizedByteShortMap(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1) {
        return new SynchronizedByteShortMap(new ByteShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2) {
        return new SynchronizedByteShortMap(new ByteShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3) {
        return new SynchronizedByteShortMap(new ByteShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4) {
        return new SynchronizedByteShortMap(new ByteShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteShortMap getEmptyMap() {
        return new SynchronizedByteShortMap(new ByteShortHashMap());
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

        private SynchronizedByteShortMapTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteShortMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteShortMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedByteShortMapTest::keySet;
            this.payloads.values = SynchronizedByteShortMapTest::values;
            this.payloads.containsAll = SynchronizedByteShortMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedByteShortMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedByteShortMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteShortMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedByteShortMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedByteShortMapTest::testHashCode;
            this.payloads.testToString = SynchronizedByteShortMapTest::testToString;
            this.payloads.forEach = SynchronizedByteShortMapTest::forEach;
            this.payloads.forEachValue = SynchronizedByteShortMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedByteShortMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedByteShortMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedByteShortMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedByteShortMapTest::makeString;
            this.payloads.appendString = SynchronizedByteShortMapTest::appendString;
            this.payloads.select = SynchronizedByteShortMapTest::select;
            this.payloads.reject = SynchronizedByteShortMapTest::reject;
            this.payloads.select_value = SynchronizedByteShortMapTest::select_value;
            this.payloads.reject_value = SynchronizedByteShortMapTest::reject_value;
            this.payloads.collect = SynchronizedByteShortMapTest::collect;
            this.payloads.count = SynchronizedByteShortMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedByteShortMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedByteShortMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteShortMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteShortMapTest::noneSatisfy;
            this.payloads.max = SynchronizedByteShortMapTest::max;
            this.payloads.min = SynchronizedByteShortMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteShortMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteShortMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteShortMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteShortMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteShortMapTest::sum;
            this.payloads.average = SynchronizedByteShortMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteShortMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedByteShortMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteShortMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedByteShortMapTest::toList;
            this.payloads.toSortedList = SynchronizedByteShortMapTest::toSortedList;
            this.payloads.toSet = SynchronizedByteShortMapTest::toSet;
            this.payloads.toBag = SynchronizedByteShortMapTest::toBag;
            this.payloads.shortIterator = SynchronizedByteShortMapTest::shortIterator;
            this.payloads.asLazy = SynchronizedByteShortMapTest::asLazy;
            this.payloads.keysView = SynchronizedByteShortMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedByteShortMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedByteShortMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedByteShortMapTest::toArray;
            this.payloads.toImmutable = SynchronizedByteShortMapTest::toImmutable;
            this.payloads.chunk = SynchronizedByteShortMapTest::chunk;
            this.payloads.get = SynchronizedByteShortMapTest::get;
            this.payloads.getOrThrow = SynchronizedByteShortMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedByteShortMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedByteShortMapTest::containsKey;
            this.payloads.containsValue = SynchronizedByteShortMapTest::containsValue;
            this.payloads.contains = SynchronizedByteShortMapTest::contains;
            this.payloads.size = SynchronizedByteShortMapTest::size;
            this.payloads.clear = SynchronizedByteShortMapTest::clear;
            this.payloads.removeKey = SynchronizedByteShortMapTest::removeKey;
            this.payloads.remove = SynchronizedByteShortMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedByteShortMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedByteShortMapTest::put;
            this.payloads.getAndPut = SynchronizedByteShortMapTest::getAndPut;
            this.payloads.putPair = SynchronizedByteShortMapTest::putPair;
            this.payloads.updateValues = SynchronizedByteShortMapTest::updateValues;
            this.payloads.addToValue = SynchronizedByteShortMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedByteShortMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedByteShortMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedByteShortMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedByteShortMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedByteShortMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedByteShortMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedByteShortMapTest::updateValue;
            this.payloads.freeze = SynchronizedByteShortMapTest::freeze;
            this.payloads.withoutKey = SynchronizedByteShortMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedByteShortMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedByteShortMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedByteShortMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedByteShortMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = SynchronizedByteShortMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedByteShortMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedByteShortMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedByteShortMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedByteShortMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedByteShortMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedByteShortMapTest::asSynchronized;
        }
    }
}
