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
 * JUnit test for {@link SynchronizedLongDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongDoubleMapTest extends AbstractMutableLongDoubleMapTestCase {

    private final SynchronizedLongDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongDoubleMap classUnderTest() {
        return new SynchronizedLongDoubleMap(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0));
    }

    @Override
    protected SynchronizedLongDoubleMap newWithKeysValues(long key1, double value1) {
        return new SynchronizedLongDoubleMap(new LongDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2) {
        return new SynchronizedLongDoubleMap(new LongDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3) {
        return new SynchronizedLongDoubleMap(new LongDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3, long key4, double value4) {
        return new SynchronizedLongDoubleMap(new LongDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongDoubleMap getEmptyMap() {
        return new SynchronizedLongDoubleMap(new LongDoubleHashMap());
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

        private SynchronizedLongDoubleMapTest instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongDoubleMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongDoubleMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedLongDoubleMapTest::keySet;
            this.payloads.values = SynchronizedLongDoubleMapTest::values;
            this.payloads.containsAll = SynchronizedLongDoubleMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedLongDoubleMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedLongDoubleMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedLongDoubleMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedLongDoubleMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedLongDoubleMapTest::testHashCode;
            this.payloads.testToString = SynchronizedLongDoubleMapTest::testToString;
            this.payloads.forEach = SynchronizedLongDoubleMapTest::forEach;
            this.payloads.forEachValue = SynchronizedLongDoubleMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedLongDoubleMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedLongDoubleMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedLongDoubleMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedLongDoubleMapTest::makeString;
            this.payloads.appendString = SynchronizedLongDoubleMapTest::appendString;
            this.payloads.select = SynchronizedLongDoubleMapTest::select;
            this.payloads.reject = SynchronizedLongDoubleMapTest::reject;
            this.payloads.select_value = SynchronizedLongDoubleMapTest::select_value;
            this.payloads.reject_value = SynchronizedLongDoubleMapTest::reject_value;
            this.payloads.collect = SynchronizedLongDoubleMapTest::collect;
            this.payloads.count = SynchronizedLongDoubleMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedLongDoubleMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedLongDoubleMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedLongDoubleMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedLongDoubleMapTest::noneSatisfy;
            this.payloads.max = SynchronizedLongDoubleMapTest::max;
            this.payloads.min = SynchronizedLongDoubleMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongDoubleMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongDoubleMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedLongDoubleMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedLongDoubleMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedLongDoubleMapTest::sum;
            this.payloads.average = SynchronizedLongDoubleMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongDoubleMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedLongDoubleMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongDoubleMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedLongDoubleMapTest::toList;
            this.payloads.toSortedList = SynchronizedLongDoubleMapTest::toSortedList;
            this.payloads.toSet = SynchronizedLongDoubleMapTest::toSet;
            this.payloads.toBag = SynchronizedLongDoubleMapTest::toBag;
            this.payloads.doubleIterator = SynchronizedLongDoubleMapTest::doubleIterator;
            this.payloads.asLazy = SynchronizedLongDoubleMapTest::asLazy;
            this.payloads.keysView = SynchronizedLongDoubleMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedLongDoubleMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedLongDoubleMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedLongDoubleMapTest::toArray;
            this.payloads.toImmutable = SynchronizedLongDoubleMapTest::toImmutable;
            this.payloads.chunk = SynchronizedLongDoubleMapTest::chunk;
            this.payloads.get = SynchronizedLongDoubleMapTest::get;
            this.payloads.getOrThrow = SynchronizedLongDoubleMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedLongDoubleMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedLongDoubleMapTest::containsKey;
            this.payloads.containsValue = SynchronizedLongDoubleMapTest::containsValue;
            this.payloads.contains = SynchronizedLongDoubleMapTest::contains;
            this.payloads.size = SynchronizedLongDoubleMapTest::size;
            this.payloads.clear = SynchronizedLongDoubleMapTest::clear;
            this.payloads.removeKey = SynchronizedLongDoubleMapTest::removeKey;
            this.payloads.remove = SynchronizedLongDoubleMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedLongDoubleMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedLongDoubleMapTest::put;
            this.payloads.getAndPut = SynchronizedLongDoubleMapTest::getAndPut;
            this.payloads.putPair = SynchronizedLongDoubleMapTest::putPair;
            this.payloads.updateValues = SynchronizedLongDoubleMapTest::updateValues;
            this.payloads.addToValue = SynchronizedLongDoubleMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedLongDoubleMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedLongDoubleMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedLongDoubleMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedLongDoubleMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedLongDoubleMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedLongDoubleMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedLongDoubleMapTest::updateValue;
            this.payloads.freeze = SynchronizedLongDoubleMapTest::freeze;
            this.payloads.withoutKey = SynchronizedLongDoubleMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedLongDoubleMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedLongDoubleMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedLongDoubleMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedLongDoubleMapTest::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = SynchronizedLongDoubleMapTest::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedLongDoubleMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedLongDoubleMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedLongDoubleMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedLongDoubleMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedLongDoubleMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedLongDoubleMapTest::asSynchronized;
        }
    }
}
