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
 * JUnit test for {@link SynchronizedCharLongMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharLongMapTest extends AbstractMutableCharLongMapTestCase {

    private final SynchronizedCharLongMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharLongMap classUnderTest() {
        return new SynchronizedCharLongMap(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L));
    }

    @Override
    protected SynchronizedCharLongMap newWithKeysValues(char key1, long value1) {
        return new SynchronizedCharLongMap(new CharLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2) {
        return new SynchronizedCharLongMap(new CharLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3) {
        return new SynchronizedCharLongMap(new CharLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4) {
        return new SynchronizedCharLongMap(new CharLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharLongMap getEmptyMap() {
        return new SynchronizedCharLongMap(new CharLongHashMap());
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

        private SynchronizedCharLongMapTest instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedCharLongMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedCharLongMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedCharLongMapTest::keySet;
            this.payloads.values = SynchronizedCharLongMapTest::values;
            this.payloads.containsAll = SynchronizedCharLongMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedCharLongMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedCharLongMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedCharLongMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedCharLongMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedCharLongMapTest::testHashCode;
            this.payloads.testToString = SynchronizedCharLongMapTest::testToString;
            this.payloads.forEach = SynchronizedCharLongMapTest::forEach;
            this.payloads.forEachValue = SynchronizedCharLongMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedCharLongMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedCharLongMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedCharLongMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedCharLongMapTest::makeString;
            this.payloads.appendString = SynchronizedCharLongMapTest::appendString;
            this.payloads.select = SynchronizedCharLongMapTest::select;
            this.payloads.reject = SynchronizedCharLongMapTest::reject;
            this.payloads.select_value = SynchronizedCharLongMapTest::select_value;
            this.payloads.reject_value = SynchronizedCharLongMapTest::reject_value;
            this.payloads.collect = SynchronizedCharLongMapTest::collect;
            this.payloads.count = SynchronizedCharLongMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedCharLongMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedCharLongMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedCharLongMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedCharLongMapTest::noneSatisfy;
            this.payloads.max = SynchronizedCharLongMapTest::max;
            this.payloads.min = SynchronizedCharLongMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharLongMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharLongMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedCharLongMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedCharLongMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedCharLongMapTest::sum;
            this.payloads.average = SynchronizedCharLongMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharLongMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedCharLongMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedCharLongMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedCharLongMapTest::toList;
            this.payloads.toSortedList = SynchronizedCharLongMapTest::toSortedList;
            this.payloads.toSet = SynchronizedCharLongMapTest::toSet;
            this.payloads.toBag = SynchronizedCharLongMapTest::toBag;
            this.payloads.longIterator = SynchronizedCharLongMapTest::longIterator;
            this.payloads.asLazy = SynchronizedCharLongMapTest::asLazy;
            this.payloads.keysView = SynchronizedCharLongMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedCharLongMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedCharLongMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedCharLongMapTest::toArray;
            this.payloads.toImmutable = SynchronizedCharLongMapTest::toImmutable;
            this.payloads.chunk = SynchronizedCharLongMapTest::chunk;
            this.payloads.get = SynchronizedCharLongMapTest::get;
            this.payloads.getOrThrow = SynchronizedCharLongMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedCharLongMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedCharLongMapTest::containsKey;
            this.payloads.containsValue = SynchronizedCharLongMapTest::containsValue;
            this.payloads.contains = SynchronizedCharLongMapTest::contains;
            this.payloads.size = SynchronizedCharLongMapTest::size;
            this.payloads.clear = SynchronizedCharLongMapTest::clear;
            this.payloads.removeKey = SynchronizedCharLongMapTest::removeKey;
            this.payloads.remove = SynchronizedCharLongMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedCharLongMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedCharLongMapTest::put;
            this.payloads.getAndPut = SynchronizedCharLongMapTest::getAndPut;
            this.payloads.putPair = SynchronizedCharLongMapTest::putPair;
            this.payloads.updateValues = SynchronizedCharLongMapTest::updateValues;
            this.payloads.addToValue = SynchronizedCharLongMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedCharLongMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedCharLongMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedCharLongMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedCharLongMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedCharLongMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedCharLongMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedCharLongMapTest::updateValue;
            this.payloads.freeze = SynchronizedCharLongMapTest::freeze;
            this.payloads.withoutKey = SynchronizedCharLongMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedCharLongMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedCharLongMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedCharLongMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedCharLongMapTest::asUnmodifiable;
            this.payloads.longIterator_with_remove = SynchronizedCharLongMapTest::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedCharLongMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedCharLongMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedCharLongMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedCharLongMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedCharLongMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedCharLongMapTest::asSynchronized;
        }
    }
}
