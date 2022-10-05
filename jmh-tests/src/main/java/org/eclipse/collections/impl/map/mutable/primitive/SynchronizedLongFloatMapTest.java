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
 * JUnit test for {@link SynchronizedLongFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongFloatMapTest extends AbstractMutableLongFloatMapTestCase {

    private final SynchronizedLongFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongFloatMap classUnderTest() {
        return new SynchronizedLongFloatMap(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4) {
        return new SynchronizedLongFloatMap(new LongFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongFloatMap getEmptyMap() {
        return new SynchronizedLongFloatMap(new LongFloatHashMap());
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

        private SynchronizedLongFloatMapTest instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongFloatMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongFloatMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedLongFloatMapTest::keySet;
            this.payloads.values = SynchronizedLongFloatMapTest::values;
            this.payloads.containsAll = SynchronizedLongFloatMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedLongFloatMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedLongFloatMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedLongFloatMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedLongFloatMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedLongFloatMapTest::testHashCode;
            this.payloads.testToString = SynchronizedLongFloatMapTest::testToString;
            this.payloads.forEach = SynchronizedLongFloatMapTest::forEach;
            this.payloads.forEachValue = SynchronizedLongFloatMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedLongFloatMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedLongFloatMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedLongFloatMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedLongFloatMapTest::makeString;
            this.payloads.appendString = SynchronizedLongFloatMapTest::appendString;
            this.payloads.select = SynchronizedLongFloatMapTest::select;
            this.payloads.reject = SynchronizedLongFloatMapTest::reject;
            this.payloads.select_value = SynchronizedLongFloatMapTest::select_value;
            this.payloads.reject_value = SynchronizedLongFloatMapTest::reject_value;
            this.payloads.collect = SynchronizedLongFloatMapTest::collect;
            this.payloads.count = SynchronizedLongFloatMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedLongFloatMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedLongFloatMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedLongFloatMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedLongFloatMapTest::noneSatisfy;
            this.payloads.max = SynchronizedLongFloatMapTest::max;
            this.payloads.min = SynchronizedLongFloatMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongFloatMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongFloatMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedLongFloatMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedLongFloatMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedLongFloatMapTest::sum;
            this.payloads.average = SynchronizedLongFloatMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongFloatMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedLongFloatMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongFloatMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedLongFloatMapTest::toList;
            this.payloads.toSortedList = SynchronizedLongFloatMapTest::toSortedList;
            this.payloads.toSet = SynchronizedLongFloatMapTest::toSet;
            this.payloads.toBag = SynchronizedLongFloatMapTest::toBag;
            this.payloads.floatIterator = SynchronizedLongFloatMapTest::floatIterator;
            this.payloads.asLazy = SynchronizedLongFloatMapTest::asLazy;
            this.payloads.keysView = SynchronizedLongFloatMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedLongFloatMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedLongFloatMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedLongFloatMapTest::toArray;
            this.payloads.toImmutable = SynchronizedLongFloatMapTest::toImmutable;
            this.payloads.chunk = SynchronizedLongFloatMapTest::chunk;
            this.payloads.get = SynchronizedLongFloatMapTest::get;
            this.payloads.getOrThrow = SynchronizedLongFloatMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedLongFloatMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedLongFloatMapTest::containsKey;
            this.payloads.containsValue = SynchronizedLongFloatMapTest::containsValue;
            this.payloads.contains = SynchronizedLongFloatMapTest::contains;
            this.payloads.size = SynchronizedLongFloatMapTest::size;
            this.payloads.clear = SynchronizedLongFloatMapTest::clear;
            this.payloads.removeKey = SynchronizedLongFloatMapTest::removeKey;
            this.payloads.remove = SynchronizedLongFloatMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedLongFloatMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedLongFloatMapTest::put;
            this.payloads.getAndPut = SynchronizedLongFloatMapTest::getAndPut;
            this.payloads.putPair = SynchronizedLongFloatMapTest::putPair;
            this.payloads.updateValues = SynchronizedLongFloatMapTest::updateValues;
            this.payloads.addToValue = SynchronizedLongFloatMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedLongFloatMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedLongFloatMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedLongFloatMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedLongFloatMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedLongFloatMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedLongFloatMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedLongFloatMapTest::updateValue;
            this.payloads.freeze = SynchronizedLongFloatMapTest::freeze;
            this.payloads.withoutKey = SynchronizedLongFloatMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedLongFloatMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedLongFloatMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedLongFloatMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedLongFloatMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = SynchronizedLongFloatMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedLongFloatMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedLongFloatMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedLongFloatMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedLongFloatMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedLongFloatMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedLongFloatMapTest::asSynchronized;
        }
    }
}
