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
 * JUnit test for {@link SynchronizedByteCharMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteCharMapTest extends AbstractMutableByteCharMapTestCase {

    private final SynchronizedByteCharMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteCharMap classUnderTest() {
        return new SynchronizedByteCharMap(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32));
    }

    @Override
    protected SynchronizedByteCharMap newWithKeysValues(byte key1, char value1) {
        return new SynchronizedByteCharMap(new ByteCharHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2) {
        return new SynchronizedByteCharMap(new ByteCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3) {
        return new SynchronizedByteCharMap(new ByteCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3, byte key4, char value4) {
        return new SynchronizedByteCharMap(new ByteCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteCharMap getEmptyMap() {
        return new SynchronizedByteCharMap(new ByteCharHashMap());
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

        private SynchronizedByteCharMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteCharMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteCharMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedByteCharMapTest::keySet;
            this.payloads.values = SynchronizedByteCharMapTest::values;
            this.payloads.containsAll = SynchronizedByteCharMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedByteCharMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedByteCharMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteCharMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedByteCharMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedByteCharMapTest::testHashCode;
            this.payloads.testToString = SynchronizedByteCharMapTest::testToString;
            this.payloads.forEach = SynchronizedByteCharMapTest::forEach;
            this.payloads.forEachValue = SynchronizedByteCharMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedByteCharMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedByteCharMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedByteCharMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedByteCharMapTest::makeString;
            this.payloads.appendString = SynchronizedByteCharMapTest::appendString;
            this.payloads.select = SynchronizedByteCharMapTest::select;
            this.payloads.reject = SynchronizedByteCharMapTest::reject;
            this.payloads.select_value = SynchronizedByteCharMapTest::select_value;
            this.payloads.reject_value = SynchronizedByteCharMapTest::reject_value;
            this.payloads.collect = SynchronizedByteCharMapTest::collect;
            this.payloads.count = SynchronizedByteCharMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedByteCharMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedByteCharMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteCharMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteCharMapTest::noneSatisfy;
            this.payloads.max = SynchronizedByteCharMapTest::max;
            this.payloads.min = SynchronizedByteCharMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteCharMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteCharMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteCharMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteCharMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteCharMapTest::sum;
            this.payloads.average = SynchronizedByteCharMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteCharMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedByteCharMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteCharMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedByteCharMapTest::toList;
            this.payloads.toSortedList = SynchronizedByteCharMapTest::toSortedList;
            this.payloads.toSet = SynchronizedByteCharMapTest::toSet;
            this.payloads.toBag = SynchronizedByteCharMapTest::toBag;
            this.payloads.charIterator = SynchronizedByteCharMapTest::charIterator;
            this.payloads.asLazy = SynchronizedByteCharMapTest::asLazy;
            this.payloads.keysView = SynchronizedByteCharMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedByteCharMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedByteCharMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedByteCharMapTest::toArray;
            this.payloads.toImmutable = SynchronizedByteCharMapTest::toImmutable;
            this.payloads.chunk = SynchronizedByteCharMapTest::chunk;
            this.payloads.get = SynchronizedByteCharMapTest::get;
            this.payloads.getOrThrow = SynchronizedByteCharMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedByteCharMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedByteCharMapTest::containsKey;
            this.payloads.containsValue = SynchronizedByteCharMapTest::containsValue;
            this.payloads.contains = SynchronizedByteCharMapTest::contains;
            this.payloads.size = SynchronizedByteCharMapTest::size;
            this.payloads.clear = SynchronizedByteCharMapTest::clear;
            this.payloads.removeKey = SynchronizedByteCharMapTest::removeKey;
            this.payloads.remove = SynchronizedByteCharMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedByteCharMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedByteCharMapTest::put;
            this.payloads.getAndPut = SynchronizedByteCharMapTest::getAndPut;
            this.payloads.putPair = SynchronizedByteCharMapTest::putPair;
            this.payloads.updateValues = SynchronizedByteCharMapTest::updateValues;
            this.payloads.addToValue = SynchronizedByteCharMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedByteCharMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedByteCharMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedByteCharMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedByteCharMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedByteCharMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedByteCharMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedByteCharMapTest::updateValue;
            this.payloads.freeze = SynchronizedByteCharMapTest::freeze;
            this.payloads.withoutKey = SynchronizedByteCharMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedByteCharMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedByteCharMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedByteCharMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedByteCharMapTest::asUnmodifiable;
            this.payloads.charIterator_with_remove = SynchronizedByteCharMapTest::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedByteCharMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedByteCharMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedByteCharMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedByteCharMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedByteCharMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedByteCharMapTest::asSynchronized;
        }
    }
}
