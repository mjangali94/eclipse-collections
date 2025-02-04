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
 * JUnit test for {@link SynchronizedIntFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntFloatMapTest extends AbstractMutableIntFloatMapTestCase {

    private final SynchronizedIntFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntFloatMap classUnderTest() {
        return new SynchronizedIntFloatMap(IntFloatHashMap.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3, int key4, float value4) {
        return new SynchronizedIntFloatMap(new IntFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntFloatMap getEmptyMap() {
        return new SynchronizedIntFloatMap(new IntFloatHashMap());
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

        private SynchronizedIntFloatMapTest instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedIntFloatMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedIntFloatMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedIntFloatMapTest::keySet;
            this.payloads.values = SynchronizedIntFloatMapTest::values;
            this.payloads.containsAll = SynchronizedIntFloatMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedIntFloatMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedIntFloatMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedIntFloatMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedIntFloatMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedIntFloatMapTest::testHashCode;
            this.payloads.testToString = SynchronizedIntFloatMapTest::testToString;
            this.payloads.forEach = SynchronizedIntFloatMapTest::forEach;
            this.payloads.forEachValue = SynchronizedIntFloatMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedIntFloatMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedIntFloatMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedIntFloatMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedIntFloatMapTest::makeString;
            this.payloads.appendString = SynchronizedIntFloatMapTest::appendString;
            this.payloads.select = SynchronizedIntFloatMapTest::select;
            this.payloads.reject = SynchronizedIntFloatMapTest::reject;
            this.payloads.select_value = SynchronizedIntFloatMapTest::select_value;
            this.payloads.reject_value = SynchronizedIntFloatMapTest::reject_value;
            this.payloads.collect = SynchronizedIntFloatMapTest::collect;
            this.payloads.count = SynchronizedIntFloatMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedIntFloatMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedIntFloatMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedIntFloatMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedIntFloatMapTest::noneSatisfy;
            this.payloads.max = SynchronizedIntFloatMapTest::max;
            this.payloads.min = SynchronizedIntFloatMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntFloatMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntFloatMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedIntFloatMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedIntFloatMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedIntFloatMapTest::sum;
            this.payloads.average = SynchronizedIntFloatMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntFloatMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedIntFloatMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedIntFloatMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedIntFloatMapTest::toList;
            this.payloads.toSortedList = SynchronizedIntFloatMapTest::toSortedList;
            this.payloads.toSet = SynchronizedIntFloatMapTest::toSet;
            this.payloads.toBag = SynchronizedIntFloatMapTest::toBag;
            this.payloads.floatIterator = SynchronizedIntFloatMapTest::floatIterator;
            this.payloads.asLazy = SynchronizedIntFloatMapTest::asLazy;
            this.payloads.keysView = SynchronizedIntFloatMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedIntFloatMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedIntFloatMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedIntFloatMapTest::toArray;
            this.payloads.toImmutable = SynchronizedIntFloatMapTest::toImmutable;
            this.payloads.chunk = SynchronizedIntFloatMapTest::chunk;
            this.payloads.get = SynchronizedIntFloatMapTest::get;
            this.payloads.getOrThrow = SynchronizedIntFloatMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedIntFloatMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedIntFloatMapTest::containsKey;
            this.payloads.containsValue = SynchronizedIntFloatMapTest::containsValue;
            this.payloads.contains = SynchronizedIntFloatMapTest::contains;
            this.payloads.size = SynchronizedIntFloatMapTest::size;
            this.payloads.clear = SynchronizedIntFloatMapTest::clear;
            this.payloads.removeKey = SynchronizedIntFloatMapTest::removeKey;
            this.payloads.remove = SynchronizedIntFloatMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedIntFloatMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedIntFloatMapTest::put;
            this.payloads.getAndPut = SynchronizedIntFloatMapTest::getAndPut;
            this.payloads.putPair = SynchronizedIntFloatMapTest::putPair;
            this.payloads.updateValues = SynchronizedIntFloatMapTest::updateValues;
            this.payloads.addToValue = SynchronizedIntFloatMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedIntFloatMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedIntFloatMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedIntFloatMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedIntFloatMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedIntFloatMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedIntFloatMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedIntFloatMapTest::updateValue;
            this.payloads.freeze = SynchronizedIntFloatMapTest::freeze;
            this.payloads.withoutKey = SynchronizedIntFloatMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedIntFloatMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedIntFloatMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedIntFloatMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedIntFloatMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = SynchronizedIntFloatMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedIntFloatMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedIntFloatMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedIntFloatMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedIntFloatMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedIntFloatMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedIntFloatMapTest::asSynchronized;
        }
    }
}
