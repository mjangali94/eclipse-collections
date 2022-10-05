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
 * JUnit test for {@link SynchronizedCharFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharFloatMapTest extends AbstractMutableCharFloatMapTestCase {

    private final SynchronizedCharFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharFloatMap classUnderTest() {
        return new SynchronizedCharFloatMap(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4) {
        return new SynchronizedCharFloatMap(new CharFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharFloatMap getEmptyMap() {
        return new SynchronizedCharFloatMap(new CharFloatHashMap());
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

        private SynchronizedCharFloatMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharFloatMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharFloatMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedCharFloatMapTest::keySet;
            this.payloads.values = SynchronizedCharFloatMapTest::values;
            this.payloads.containsAll = SynchronizedCharFloatMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedCharFloatMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedCharFloatMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharFloatMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedCharFloatMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedCharFloatMapTest::testHashCode;
            this.payloads.testToString = SynchronizedCharFloatMapTest::testToString;
            this.payloads.forEach = SynchronizedCharFloatMapTest::forEach;
            this.payloads.forEachValue = SynchronizedCharFloatMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedCharFloatMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedCharFloatMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedCharFloatMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedCharFloatMapTest::makeString;
            this.payloads.appendString = SynchronizedCharFloatMapTest::appendString;
            this.payloads.select = SynchronizedCharFloatMapTest::select;
            this.payloads.reject = SynchronizedCharFloatMapTest::reject;
            this.payloads.select_value = SynchronizedCharFloatMapTest::select_value;
            this.payloads.reject_value = SynchronizedCharFloatMapTest::reject_value;
            this.payloads.collect = SynchronizedCharFloatMapTest::collect;
            this.payloads.count = SynchronizedCharFloatMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedCharFloatMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedCharFloatMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedCharFloatMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedCharFloatMapTest::noneSatisfy;
            this.payloads.max = SynchronizedCharFloatMapTest::max;
            this.payloads.min = SynchronizedCharFloatMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedCharFloatMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedCharFloatMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedCharFloatMapTest::sum;
            this.payloads.average = SynchronizedCharFloatMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedCharFloatMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharFloatMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedCharFloatMapTest::toList;
            this.payloads.toSortedList = SynchronizedCharFloatMapTest::toSortedList;
            this.payloads.toSet = SynchronizedCharFloatMapTest::toSet;
            this.payloads.toBag = SynchronizedCharFloatMapTest::toBag;
            this.payloads.floatIterator = SynchronizedCharFloatMapTest::floatIterator;
            this.payloads.asLazy = SynchronizedCharFloatMapTest::asLazy;
            this.payloads.keysView = SynchronizedCharFloatMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedCharFloatMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedCharFloatMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedCharFloatMapTest::toArray;
            this.payloads.toImmutable = SynchronizedCharFloatMapTest::toImmutable;
            this.payloads.chunk = SynchronizedCharFloatMapTest::chunk;
            this.payloads.get = SynchronizedCharFloatMapTest::get;
            this.payloads.getOrThrow = SynchronizedCharFloatMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedCharFloatMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedCharFloatMapTest::containsKey;
            this.payloads.containsValue = SynchronizedCharFloatMapTest::containsValue;
            this.payloads.contains = SynchronizedCharFloatMapTest::contains;
            this.payloads.size = SynchronizedCharFloatMapTest::size;
            this.payloads.clear = SynchronizedCharFloatMapTest::clear;
            this.payloads.removeKey = SynchronizedCharFloatMapTest::removeKey;
            this.payloads.remove = SynchronizedCharFloatMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedCharFloatMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedCharFloatMapTest::put;
            this.payloads.getAndPut = SynchronizedCharFloatMapTest::getAndPut;
            this.payloads.putPair = SynchronizedCharFloatMapTest::putPair;
            this.payloads.updateValues = SynchronizedCharFloatMapTest::updateValues;
            this.payloads.addToValue = SynchronizedCharFloatMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedCharFloatMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedCharFloatMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedCharFloatMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedCharFloatMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedCharFloatMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedCharFloatMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedCharFloatMapTest::updateValue;
            this.payloads.freeze = SynchronizedCharFloatMapTest::freeze;
            this.payloads.withoutKey = SynchronizedCharFloatMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedCharFloatMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedCharFloatMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedCharFloatMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedCharFloatMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = SynchronizedCharFloatMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedCharFloatMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedCharFloatMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedCharFloatMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedCharFloatMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedCharFloatMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedCharFloatMapTest::asSynchronized;
        }
    }
}
