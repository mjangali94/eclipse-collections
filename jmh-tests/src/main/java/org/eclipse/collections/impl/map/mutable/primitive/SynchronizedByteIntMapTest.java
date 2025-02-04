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
 * JUnit test for {@link SynchronizedByteIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteIntMapTest extends AbstractMutableByteIntMapTestCase {

    private final SynchronizedByteIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteIntMap classUnderTest() {
        return new SynchronizedByteIntMap(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32));
    }

    @Override
    protected SynchronizedByteIntMap newWithKeysValues(byte key1, int value1) {
        return new SynchronizedByteIntMap(new ByteIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2) {
        return new SynchronizedByteIntMap(new ByteIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3) {
        return new SynchronizedByteIntMap(new ByteIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3, byte key4, int value4) {
        return new SynchronizedByteIntMap(new ByteIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteIntMap getEmptyMap() {
        return new SynchronizedByteIntMap(new ByteIntHashMap());
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

        private SynchronizedByteIntMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteIntMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteIntMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedByteIntMapTest::keySet;
            this.payloads.values = SynchronizedByteIntMapTest::values;
            this.payloads.containsAll = SynchronizedByteIntMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedByteIntMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedByteIntMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteIntMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedByteIntMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedByteIntMapTest::testHashCode;
            this.payloads.testToString = SynchronizedByteIntMapTest::testToString;
            this.payloads.forEach = SynchronizedByteIntMapTest::forEach;
            this.payloads.forEachValue = SynchronizedByteIntMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedByteIntMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedByteIntMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedByteIntMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedByteIntMapTest::makeString;
            this.payloads.appendString = SynchronizedByteIntMapTest::appendString;
            this.payloads.select = SynchronizedByteIntMapTest::select;
            this.payloads.reject = SynchronizedByteIntMapTest::reject;
            this.payloads.select_value = SynchronizedByteIntMapTest::select_value;
            this.payloads.reject_value = SynchronizedByteIntMapTest::reject_value;
            this.payloads.collect = SynchronizedByteIntMapTest::collect;
            this.payloads.count = SynchronizedByteIntMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedByteIntMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedByteIntMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteIntMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteIntMapTest::noneSatisfy;
            this.payloads.max = SynchronizedByteIntMapTest::max;
            this.payloads.min = SynchronizedByteIntMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIntMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIntMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteIntMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteIntMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteIntMapTest::sum;
            this.payloads.average = SynchronizedByteIntMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIntMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedByteIntMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteIntMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedByteIntMapTest::toList;
            this.payloads.toSortedList = SynchronizedByteIntMapTest::toSortedList;
            this.payloads.toSet = SynchronizedByteIntMapTest::toSet;
            this.payloads.toBag = SynchronizedByteIntMapTest::toBag;
            this.payloads.intIterator = SynchronizedByteIntMapTest::intIterator;
            this.payloads.asLazy = SynchronizedByteIntMapTest::asLazy;
            this.payloads.keysView = SynchronizedByteIntMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedByteIntMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedByteIntMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedByteIntMapTest::toArray;
            this.payloads.toImmutable = SynchronizedByteIntMapTest::toImmutable;
            this.payloads.chunk = SynchronizedByteIntMapTest::chunk;
            this.payloads.get = SynchronizedByteIntMapTest::get;
            this.payloads.getOrThrow = SynchronizedByteIntMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedByteIntMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedByteIntMapTest::containsKey;
            this.payloads.containsValue = SynchronizedByteIntMapTest::containsValue;
            this.payloads.contains = SynchronizedByteIntMapTest::contains;
            this.payloads.size = SynchronizedByteIntMapTest::size;
            this.payloads.clear = SynchronizedByteIntMapTest::clear;
            this.payloads.removeKey = SynchronizedByteIntMapTest::removeKey;
            this.payloads.remove = SynchronizedByteIntMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedByteIntMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedByteIntMapTest::put;
            this.payloads.getAndPut = SynchronizedByteIntMapTest::getAndPut;
            this.payloads.putPair = SynchronizedByteIntMapTest::putPair;
            this.payloads.updateValues = SynchronizedByteIntMapTest::updateValues;
            this.payloads.addToValue = SynchronizedByteIntMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedByteIntMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedByteIntMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedByteIntMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedByteIntMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedByteIntMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedByteIntMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedByteIntMapTest::updateValue;
            this.payloads.freeze = SynchronizedByteIntMapTest::freeze;
            this.payloads.withoutKey = SynchronizedByteIntMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedByteIntMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedByteIntMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedByteIntMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedByteIntMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = SynchronizedByteIntMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedByteIntMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedByteIntMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedByteIntMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedByteIntMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedByteIntMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedByteIntMapTest::asSynchronized;
        }
    }
}
