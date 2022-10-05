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
 * JUnit test for {@link SynchronizedCharShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharShortMapTest extends AbstractMutableCharShortMapTestCase {

    private final SynchronizedCharShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharShortMap classUnderTest() {
        return new SynchronizedCharShortMap(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1) {
        return new SynchronizedCharShortMap(new CharShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2) {
        return new SynchronizedCharShortMap(new CharShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3) {
        return new SynchronizedCharShortMap(new CharShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3, char key4, short value4) {
        return new SynchronizedCharShortMap(new CharShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharShortMap getEmptyMap() {
        return new SynchronizedCharShortMap(new CharShortHashMap());
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

        private SynchronizedCharShortMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharShortMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharShortMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedCharShortMapTest::keySet;
            this.payloads.values = SynchronizedCharShortMapTest::values;
            this.payloads.containsAll = SynchronizedCharShortMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedCharShortMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedCharShortMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharShortMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedCharShortMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedCharShortMapTest::testHashCode;
            this.payloads.testToString = SynchronizedCharShortMapTest::testToString;
            this.payloads.forEach = SynchronizedCharShortMapTest::forEach;
            this.payloads.forEachValue = SynchronizedCharShortMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedCharShortMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedCharShortMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedCharShortMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedCharShortMapTest::makeString;
            this.payloads.appendString = SynchronizedCharShortMapTest::appendString;
            this.payloads.select = SynchronizedCharShortMapTest::select;
            this.payloads.reject = SynchronizedCharShortMapTest::reject;
            this.payloads.select_value = SynchronizedCharShortMapTest::select_value;
            this.payloads.reject_value = SynchronizedCharShortMapTest::reject_value;
            this.payloads.collect = SynchronizedCharShortMapTest::collect;
            this.payloads.count = SynchronizedCharShortMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedCharShortMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedCharShortMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedCharShortMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedCharShortMapTest::noneSatisfy;
            this.payloads.max = SynchronizedCharShortMapTest::max;
            this.payloads.min = SynchronizedCharShortMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharShortMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharShortMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedCharShortMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedCharShortMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedCharShortMapTest::sum;
            this.payloads.average = SynchronizedCharShortMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharShortMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedCharShortMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharShortMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedCharShortMapTest::toList;
            this.payloads.toSortedList = SynchronizedCharShortMapTest::toSortedList;
            this.payloads.toSet = SynchronizedCharShortMapTest::toSet;
            this.payloads.toBag = SynchronizedCharShortMapTest::toBag;
            this.payloads.shortIterator = SynchronizedCharShortMapTest::shortIterator;
            this.payloads.asLazy = SynchronizedCharShortMapTest::asLazy;
            this.payloads.keysView = SynchronizedCharShortMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedCharShortMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedCharShortMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedCharShortMapTest::toArray;
            this.payloads.toImmutable = SynchronizedCharShortMapTest::toImmutable;
            this.payloads.chunk = SynchronizedCharShortMapTest::chunk;
            this.payloads.get = SynchronizedCharShortMapTest::get;
            this.payloads.getOrThrow = SynchronizedCharShortMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedCharShortMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedCharShortMapTest::containsKey;
            this.payloads.containsValue = SynchronizedCharShortMapTest::containsValue;
            this.payloads.contains = SynchronizedCharShortMapTest::contains;
            this.payloads.size = SynchronizedCharShortMapTest::size;
            this.payloads.clear = SynchronizedCharShortMapTest::clear;
            this.payloads.removeKey = SynchronizedCharShortMapTest::removeKey;
            this.payloads.remove = SynchronizedCharShortMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedCharShortMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedCharShortMapTest::put;
            this.payloads.getAndPut = SynchronizedCharShortMapTest::getAndPut;
            this.payloads.putPair = SynchronizedCharShortMapTest::putPair;
            this.payloads.updateValues = SynchronizedCharShortMapTest::updateValues;
            this.payloads.addToValue = SynchronizedCharShortMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedCharShortMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedCharShortMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedCharShortMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedCharShortMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedCharShortMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedCharShortMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedCharShortMapTest::updateValue;
            this.payloads.freeze = SynchronizedCharShortMapTest::freeze;
            this.payloads.withoutKey = SynchronizedCharShortMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedCharShortMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedCharShortMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedCharShortMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedCharShortMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = SynchronizedCharShortMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedCharShortMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedCharShortMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedCharShortMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedCharShortMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedCharShortMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedCharShortMapTest::asSynchronized;
        }
    }
}
