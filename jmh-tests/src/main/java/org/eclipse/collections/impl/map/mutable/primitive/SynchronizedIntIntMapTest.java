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
 * JUnit test for {@link SynchronizedIntIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntIntMapTest extends AbstractMutableIntIntMapTestCase {

    private final SynchronizedIntIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntIntMap classUnderTest() {
        return new SynchronizedIntIntMap(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32));
    }

    @Override
    protected SynchronizedIntIntMap newWithKeysValues(int key1, int value1) {
        return new SynchronizedIntIntMap(new IntIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2) {
        return new SynchronizedIntIntMap(new IntIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3) {
        return new SynchronizedIntIntMap(new IntIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4) {
        return new SynchronizedIntIntMap(new IntIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntIntMap getEmptyMap() {
        return new SynchronizedIntIntMap(new IntIntHashMap());
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

        private SynchronizedIntIntMapTest instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedIntIntMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntIntMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedIntIntMapTest::keySet;
            this.payloads.values = SynchronizedIntIntMapTest::values;
            this.payloads.containsAll = SynchronizedIntIntMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedIntIntMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedIntIntMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedIntIntMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedIntIntMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedIntIntMapTest::testHashCode;
            this.payloads.testToString = SynchronizedIntIntMapTest::testToString;
            this.payloads.forEach = SynchronizedIntIntMapTest::forEach;
            this.payloads.forEachValue = SynchronizedIntIntMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedIntIntMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedIntIntMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedIntIntMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedIntIntMapTest::makeString;
            this.payloads.appendString = SynchronizedIntIntMapTest::appendString;
            this.payloads.select = SynchronizedIntIntMapTest::select;
            this.payloads.reject = SynchronizedIntIntMapTest::reject;
            this.payloads.select_value = SynchronizedIntIntMapTest::select_value;
            this.payloads.reject_value = SynchronizedIntIntMapTest::reject_value;
            this.payloads.collect = SynchronizedIntIntMapTest::collect;
            this.payloads.count = SynchronizedIntIntMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedIntIntMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedIntIntMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedIntIntMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedIntIntMapTest::noneSatisfy;
            this.payloads.max = SynchronizedIntIntMapTest::max;
            this.payloads.min = SynchronizedIntIntMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntIntMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntIntMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedIntIntMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedIntIntMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedIntIntMapTest::sum;
            this.payloads.average = SynchronizedIntIntMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntIntMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedIntIntMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntIntMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedIntIntMapTest::toList;
            this.payloads.toSortedList = SynchronizedIntIntMapTest::toSortedList;
            this.payloads.toSet = SynchronizedIntIntMapTest::toSet;
            this.payloads.toBag = SynchronizedIntIntMapTest::toBag;
            this.payloads.intIterator = SynchronizedIntIntMapTest::intIterator;
            this.payloads.asLazy = SynchronizedIntIntMapTest::asLazy;
            this.payloads.keysView = SynchronizedIntIntMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedIntIntMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedIntIntMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedIntIntMapTest::toArray;
            this.payloads.toImmutable = SynchronizedIntIntMapTest::toImmutable;
            this.payloads.chunk = SynchronizedIntIntMapTest::chunk;
            this.payloads.get = SynchronizedIntIntMapTest::get;
            this.payloads.getOrThrow = SynchronizedIntIntMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedIntIntMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedIntIntMapTest::containsKey;
            this.payloads.containsValue = SynchronizedIntIntMapTest::containsValue;
            this.payloads.contains = SynchronizedIntIntMapTest::contains;
            this.payloads.size = SynchronizedIntIntMapTest::size;
            this.payloads.clear = SynchronizedIntIntMapTest::clear;
            this.payloads.removeKey = SynchronizedIntIntMapTest::removeKey;
            this.payloads.remove = SynchronizedIntIntMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedIntIntMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedIntIntMapTest::put;
            this.payloads.getAndPut = SynchronizedIntIntMapTest::getAndPut;
            this.payloads.putPair = SynchronizedIntIntMapTest::putPair;
            this.payloads.updateValues = SynchronizedIntIntMapTest::updateValues;
            this.payloads.addToValue = SynchronizedIntIntMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedIntIntMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedIntIntMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedIntIntMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedIntIntMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedIntIntMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedIntIntMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedIntIntMapTest::updateValue;
            this.payloads.freeze = SynchronizedIntIntMapTest::freeze;
            this.payloads.withoutKey = SynchronizedIntIntMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedIntIntMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedIntIntMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedIntIntMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedIntIntMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = SynchronizedIntIntMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedIntIntMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedIntIntMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedIntIntMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedIntIntMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedIntIntMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedIntIntMapTest::asSynchronized;
        }
    }
}
