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
 * JUnit test for {@link SynchronizedFloatDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedFloatDoubleMapTest extends AbstractMutableFloatDoubleMapTestCase {

    private final SynchronizedFloatDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedFloatDoubleMap classUnderTest() {
        return new SynchronizedFloatDoubleMap(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4) {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatDoubleMap getEmptyMap() {
        return new SynchronizedFloatDoubleMap(new FloatDoubleHashMap());
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

        private SynchronizedFloatDoubleMapTest instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatDoubleMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatDoubleMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedFloatDoubleMapTest::keySet;
            this.payloads.values = SynchronizedFloatDoubleMapTest::values;
            this.payloads.containsAll = SynchronizedFloatDoubleMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedFloatDoubleMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedFloatDoubleMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatDoubleMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedFloatDoubleMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedFloatDoubleMapTest::testHashCode;
            this.payloads.testToString = SynchronizedFloatDoubleMapTest::testToString;
            this.payloads.forEach = SynchronizedFloatDoubleMapTest::forEach;
            this.payloads.forEachValue = SynchronizedFloatDoubleMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedFloatDoubleMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedFloatDoubleMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedFloatDoubleMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedFloatDoubleMapTest::makeString;
            this.payloads.appendString = SynchronizedFloatDoubleMapTest::appendString;
            this.payloads.select = SynchronizedFloatDoubleMapTest::select;
            this.payloads.reject = SynchronizedFloatDoubleMapTest::reject;
            this.payloads.select_value = SynchronizedFloatDoubleMapTest::select_value;
            this.payloads.reject_value = SynchronizedFloatDoubleMapTest::reject_value;
            this.payloads.collect = SynchronizedFloatDoubleMapTest::collect;
            this.payloads.count = SynchronizedFloatDoubleMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedFloatDoubleMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedFloatDoubleMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatDoubleMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedFloatDoubleMapTest::noneSatisfy;
            this.payloads.max = SynchronizedFloatDoubleMapTest::max;
            this.payloads.min = SynchronizedFloatDoubleMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatDoubleMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatDoubleMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedFloatDoubleMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatDoubleMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedFloatDoubleMapTest::sum;
            this.payloads.average = SynchronizedFloatDoubleMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatDoubleMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedFloatDoubleMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatDoubleMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedFloatDoubleMapTest::toList;
            this.payloads.toSortedList = SynchronizedFloatDoubleMapTest::toSortedList;
            this.payloads.toSet = SynchronizedFloatDoubleMapTest::toSet;
            this.payloads.toBag = SynchronizedFloatDoubleMapTest::toBag;
            this.payloads.doubleIterator = SynchronizedFloatDoubleMapTest::doubleIterator;
            this.payloads.asLazy = SynchronizedFloatDoubleMapTest::asLazy;
            this.payloads.keysView = SynchronizedFloatDoubleMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedFloatDoubleMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedFloatDoubleMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedFloatDoubleMapTest::toArray;
            this.payloads.toImmutable = SynchronizedFloatDoubleMapTest::toImmutable;
            this.payloads.chunk = SynchronizedFloatDoubleMapTest::chunk;
            this.payloads.get = SynchronizedFloatDoubleMapTest::get;
            this.payloads.getOrThrow = SynchronizedFloatDoubleMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedFloatDoubleMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedFloatDoubleMapTest::containsKey;
            this.payloads.containsValue = SynchronizedFloatDoubleMapTest::containsValue;
            this.payloads.contains = SynchronizedFloatDoubleMapTest::contains;
            this.payloads.size = SynchronizedFloatDoubleMapTest::size;
            this.payloads.clear = SynchronizedFloatDoubleMapTest::clear;
            this.payloads.removeKey = SynchronizedFloatDoubleMapTest::removeKey;
            this.payloads.remove = SynchronizedFloatDoubleMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedFloatDoubleMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedFloatDoubleMapTest::put;
            this.payloads.getAndPut = SynchronizedFloatDoubleMapTest::getAndPut;
            this.payloads.putPair = SynchronizedFloatDoubleMapTest::putPair;
            this.payloads.updateValues = SynchronizedFloatDoubleMapTest::updateValues;
            this.payloads.addToValue = SynchronizedFloatDoubleMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedFloatDoubleMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedFloatDoubleMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedFloatDoubleMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedFloatDoubleMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedFloatDoubleMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedFloatDoubleMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedFloatDoubleMapTest::updateValue;
            this.payloads.freeze = SynchronizedFloatDoubleMapTest::freeze;
            this.payloads.withoutKey = SynchronizedFloatDoubleMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedFloatDoubleMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedFloatDoubleMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedFloatDoubleMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedFloatDoubleMapTest::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = SynchronizedFloatDoubleMapTest::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedFloatDoubleMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedFloatDoubleMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedFloatDoubleMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedFloatDoubleMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedFloatDoubleMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedFloatDoubleMapTest::asSynchronized;
        }
    }
}
