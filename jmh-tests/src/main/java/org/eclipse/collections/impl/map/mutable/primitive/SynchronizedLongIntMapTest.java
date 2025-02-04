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
 * JUnit test for {@link SynchronizedLongIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongIntMapTest extends AbstractMutableLongIntMapTestCase {

    private final SynchronizedLongIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongIntMap classUnderTest() {
        return new SynchronizedLongIntMap(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1) {
        return new SynchronizedLongIntMap(new LongIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2) {
        return new SynchronizedLongIntMap(new LongIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3) {
        return new SynchronizedLongIntMap(new LongIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4) {
        return new SynchronizedLongIntMap(new LongIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongIntMap getEmptyMap() {
        return new SynchronizedLongIntMap(new LongIntHashMap());
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

        private SynchronizedLongIntMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
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
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongIntMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIntMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedLongIntMapTest::keySet;
            this.payloads.values = SynchronizedLongIntMapTest::values;
            this.payloads.containsAll = SynchronizedLongIntMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedLongIntMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedLongIntMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedLongIntMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedLongIntMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedLongIntMapTest::testHashCode;
            this.payloads.testToString = SynchronizedLongIntMapTest::testToString;
            this.payloads.forEach = SynchronizedLongIntMapTest::forEach;
            this.payloads.forEachValue = SynchronizedLongIntMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedLongIntMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedLongIntMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedLongIntMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedLongIntMapTest::makeString;
            this.payloads.appendString = SynchronizedLongIntMapTest::appendString;
            this.payloads.select = SynchronizedLongIntMapTest::select;
            this.payloads.reject = SynchronizedLongIntMapTest::reject;
            this.payloads.select_value = SynchronizedLongIntMapTest::select_value;
            this.payloads.reject_value = SynchronizedLongIntMapTest::reject_value;
            this.payloads.collect = SynchronizedLongIntMapTest::collect;
            this.payloads.count = SynchronizedLongIntMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedLongIntMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedLongIntMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedLongIntMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedLongIntMapTest::noneSatisfy;
            this.payloads.max = SynchronizedLongIntMapTest::max;
            this.payloads.min = SynchronizedLongIntMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIntMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIntMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedLongIntMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedLongIntMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedLongIntMapTest::sum;
            this.payloads.average = SynchronizedLongIntMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIntMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedLongIntMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIntMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedLongIntMapTest::toList;
            this.payloads.toSortedList = SynchronizedLongIntMapTest::toSortedList;
            this.payloads.toSet = SynchronizedLongIntMapTest::toSet;
            this.payloads.toBag = SynchronizedLongIntMapTest::toBag;
            this.payloads.intIterator = SynchronizedLongIntMapTest::intIterator;
            this.payloads.asLazy = SynchronizedLongIntMapTest::asLazy;
            this.payloads.keysView = SynchronizedLongIntMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedLongIntMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedLongIntMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedLongIntMapTest::toArray;
            this.payloads.toImmutable = SynchronizedLongIntMapTest::toImmutable;
            this.payloads.chunk = SynchronizedLongIntMapTest::chunk;
            this.payloads.get = SynchronizedLongIntMapTest::get;
            this.payloads.getOrThrow = SynchronizedLongIntMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedLongIntMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedLongIntMapTest::containsKey;
            this.payloads.containsValue = SynchronizedLongIntMapTest::containsValue;
            this.payloads.contains = SynchronizedLongIntMapTest::contains;
            this.payloads.size = SynchronizedLongIntMapTest::size;
            this.payloads.clear = SynchronizedLongIntMapTest::clear;
            this.payloads.removeKey = SynchronizedLongIntMapTest::removeKey;
            this.payloads.remove = SynchronizedLongIntMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedLongIntMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedLongIntMapTest::put;
            this.payloads.getAndPut = SynchronizedLongIntMapTest::getAndPut;
            this.payloads.putPair = SynchronizedLongIntMapTest::putPair;
            this.payloads.updateValues = SynchronizedLongIntMapTest::updateValues;
            this.payloads.addToValue = SynchronizedLongIntMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedLongIntMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedLongIntMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedLongIntMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedLongIntMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedLongIntMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedLongIntMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedLongIntMapTest::updateValue;
            this.payloads.freeze = SynchronizedLongIntMapTest::freeze;
            this.payloads.withoutKey = SynchronizedLongIntMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedLongIntMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedLongIntMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedLongIntMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedLongIntMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = SynchronizedLongIntMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedLongIntMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedLongIntMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedLongIntMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedLongIntMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedLongIntMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedLongIntMapTest::asSynchronized;
        }
    }
}
