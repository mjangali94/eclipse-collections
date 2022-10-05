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
 * JUnit test for {@link SynchronizedCharByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharByteMapTest extends AbstractMutableCharByteMapTestCase {

    private final SynchronizedCharByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharByteMap classUnderTest() {
        return new SynchronizedCharByteMap(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32));
    }

    @Override
    protected SynchronizedCharByteMap newWithKeysValues(char key1, byte value1) {
        return new SynchronizedCharByteMap(new CharByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2) {
        return new SynchronizedCharByteMap(new CharByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3) {
        return new SynchronizedCharByteMap(new CharByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3, char key4, byte value4) {
        return new SynchronizedCharByteMap(new CharByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharByteMap getEmptyMap() {
        return new SynchronizedCharByteMap(new CharByteHashMap());
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

        private SynchronizedCharByteMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharByteMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharByteMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedCharByteMapTest::keySet;
            this.payloads.values = SynchronizedCharByteMapTest::values;
            this.payloads.containsAll = SynchronizedCharByteMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedCharByteMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedCharByteMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharByteMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedCharByteMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedCharByteMapTest::testHashCode;
            this.payloads.testToString = SynchronizedCharByteMapTest::testToString;
            this.payloads.forEach = SynchronizedCharByteMapTest::forEach;
            this.payloads.forEachValue = SynchronizedCharByteMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedCharByteMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedCharByteMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedCharByteMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedCharByteMapTest::makeString;
            this.payloads.appendString = SynchronizedCharByteMapTest::appendString;
            this.payloads.select = SynchronizedCharByteMapTest::select;
            this.payloads.reject = SynchronizedCharByteMapTest::reject;
            this.payloads.select_value = SynchronizedCharByteMapTest::select_value;
            this.payloads.reject_value = SynchronizedCharByteMapTest::reject_value;
            this.payloads.collect = SynchronizedCharByteMapTest::collect;
            this.payloads.count = SynchronizedCharByteMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedCharByteMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedCharByteMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedCharByteMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedCharByteMapTest::noneSatisfy;
            this.payloads.max = SynchronizedCharByteMapTest::max;
            this.payloads.min = SynchronizedCharByteMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharByteMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharByteMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedCharByteMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedCharByteMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedCharByteMapTest::sum;
            this.payloads.average = SynchronizedCharByteMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharByteMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedCharByteMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharByteMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedCharByteMapTest::toList;
            this.payloads.toSortedList = SynchronizedCharByteMapTest::toSortedList;
            this.payloads.toSet = SynchronizedCharByteMapTest::toSet;
            this.payloads.toBag = SynchronizedCharByteMapTest::toBag;
            this.payloads.byteIterator = SynchronizedCharByteMapTest::byteIterator;
            this.payloads.asLazy = SynchronizedCharByteMapTest::asLazy;
            this.payloads.keysView = SynchronizedCharByteMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedCharByteMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedCharByteMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedCharByteMapTest::toArray;
            this.payloads.toImmutable = SynchronizedCharByteMapTest::toImmutable;
            this.payloads.chunk = SynchronizedCharByteMapTest::chunk;
            this.payloads.get = SynchronizedCharByteMapTest::get;
            this.payloads.getOrThrow = SynchronizedCharByteMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedCharByteMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedCharByteMapTest::containsKey;
            this.payloads.containsValue = SynchronizedCharByteMapTest::containsValue;
            this.payloads.contains = SynchronizedCharByteMapTest::contains;
            this.payloads.size = SynchronizedCharByteMapTest::size;
            this.payloads.clear = SynchronizedCharByteMapTest::clear;
            this.payloads.removeKey = SynchronizedCharByteMapTest::removeKey;
            this.payloads.remove = SynchronizedCharByteMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedCharByteMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedCharByteMapTest::put;
            this.payloads.getAndPut = SynchronizedCharByteMapTest::getAndPut;
            this.payloads.putPair = SynchronizedCharByteMapTest::putPair;
            this.payloads.updateValues = SynchronizedCharByteMapTest::updateValues;
            this.payloads.addToValue = SynchronizedCharByteMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedCharByteMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedCharByteMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedCharByteMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedCharByteMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedCharByteMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedCharByteMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedCharByteMapTest::updateValue;
            this.payloads.freeze = SynchronizedCharByteMapTest::freeze;
            this.payloads.withoutKey = SynchronizedCharByteMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedCharByteMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedCharByteMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedCharByteMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedCharByteMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = SynchronizedCharByteMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedCharByteMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedCharByteMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedCharByteMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedCharByteMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedCharByteMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedCharByteMapTest::asSynchronized;
        }
    }
}
