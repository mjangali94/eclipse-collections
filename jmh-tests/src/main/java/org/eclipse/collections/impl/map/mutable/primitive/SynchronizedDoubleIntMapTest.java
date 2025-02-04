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
 * JUnit test for {@link SynchronizedDoubleIntMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedDoubleIntMapTest extends AbstractMutableDoubleIntMapTestCase {

    private final SynchronizedDoubleIntMap map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleIntMap classUnderTest() {
        return new SynchronizedDoubleIntMap(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32));
    }

    @Override
    protected SynchronizedDoubleIntMap newWithKeysValues(double key1, int value1) {
        return new SynchronizedDoubleIntMap(new DoubleIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2) {
        return new SynchronizedDoubleIntMap(new DoubleIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3) {
        return new SynchronizedDoubleIntMap(new DoubleIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3, double key4, int value4) {
        return new SynchronizedDoubleIntMap(new DoubleIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleIntMap getEmptyMap() {
        return new SynchronizedDoubleIntMap(new DoubleIntHashMap());
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

        private SynchronizedDoubleIntMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedDoubleIntMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleIntMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedDoubleIntMapTest::keySet;
            this.payloads.values = SynchronizedDoubleIntMapTest::values;
            this.payloads.containsAll = SynchronizedDoubleIntMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedDoubleIntMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedDoubleIntMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedDoubleIntMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedDoubleIntMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedDoubleIntMapTest::testHashCode;
            this.payloads.testToString = SynchronizedDoubleIntMapTest::testToString;
            this.payloads.forEach = SynchronizedDoubleIntMapTest::forEach;
            this.payloads.forEachValue = SynchronizedDoubleIntMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedDoubleIntMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedDoubleIntMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedDoubleIntMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedDoubleIntMapTest::makeString;
            this.payloads.appendString = SynchronizedDoubleIntMapTest::appendString;
            this.payloads.select = SynchronizedDoubleIntMapTest::select;
            this.payloads.reject = SynchronizedDoubleIntMapTest::reject;
            this.payloads.select_value = SynchronizedDoubleIntMapTest::select_value;
            this.payloads.reject_value = SynchronizedDoubleIntMapTest::reject_value;
            this.payloads.collect = SynchronizedDoubleIntMapTest::collect;
            this.payloads.count = SynchronizedDoubleIntMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedDoubleIntMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedDoubleIntMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedDoubleIntMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedDoubleIntMapTest::noneSatisfy;
            this.payloads.max = SynchronizedDoubleIntMapTest::max;
            this.payloads.min = SynchronizedDoubleIntMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleIntMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleIntMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedDoubleIntMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedDoubleIntMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedDoubleIntMapTest::sum;
            this.payloads.average = SynchronizedDoubleIntMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleIntMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedDoubleIntMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleIntMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedDoubleIntMapTest::toList;
            this.payloads.toSortedList = SynchronizedDoubleIntMapTest::toSortedList;
            this.payloads.toSet = SynchronizedDoubleIntMapTest::toSet;
            this.payloads.toBag = SynchronizedDoubleIntMapTest::toBag;
            this.payloads.intIterator = SynchronizedDoubleIntMapTest::intIterator;
            this.payloads.asLazy = SynchronizedDoubleIntMapTest::asLazy;
            this.payloads.keysView = SynchronizedDoubleIntMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedDoubleIntMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedDoubleIntMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedDoubleIntMapTest::toArray;
            this.payloads.toImmutable = SynchronizedDoubleIntMapTest::toImmutable;
            this.payloads.chunk = SynchronizedDoubleIntMapTest::chunk;
            this.payloads.get = SynchronizedDoubleIntMapTest::get;
            this.payloads.getOrThrow = SynchronizedDoubleIntMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedDoubleIntMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedDoubleIntMapTest::containsKey;
            this.payloads.containsValue = SynchronizedDoubleIntMapTest::containsValue;
            this.payloads.contains = SynchronizedDoubleIntMapTest::contains;
            this.payloads.size = SynchronizedDoubleIntMapTest::size;
            this.payloads.clear = SynchronizedDoubleIntMapTest::clear;
            this.payloads.removeKey = SynchronizedDoubleIntMapTest::removeKey;
            this.payloads.remove = SynchronizedDoubleIntMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedDoubleIntMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedDoubleIntMapTest::put;
            this.payloads.getAndPut = SynchronizedDoubleIntMapTest::getAndPut;
            this.payloads.putPair = SynchronizedDoubleIntMapTest::putPair;
            this.payloads.updateValues = SynchronizedDoubleIntMapTest::updateValues;
            this.payloads.addToValue = SynchronizedDoubleIntMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedDoubleIntMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedDoubleIntMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedDoubleIntMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedDoubleIntMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedDoubleIntMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedDoubleIntMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedDoubleIntMapTest::updateValue;
            this.payloads.freeze = SynchronizedDoubleIntMapTest::freeze;
            this.payloads.withoutKey = SynchronizedDoubleIntMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedDoubleIntMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedDoubleIntMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedDoubleIntMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedDoubleIntMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = SynchronizedDoubleIntMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedDoubleIntMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedDoubleIntMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedDoubleIntMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedDoubleIntMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedDoubleIntMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedDoubleIntMapTest::asSynchronized;
        }
    }
}
