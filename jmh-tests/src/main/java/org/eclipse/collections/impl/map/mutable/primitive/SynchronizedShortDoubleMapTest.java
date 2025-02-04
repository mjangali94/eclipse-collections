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
 * JUnit test for {@link SynchronizedShortDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortDoubleMapTest extends AbstractMutableShortDoubleMapTestCase {

    private final SynchronizedShortDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortDoubleMap classUnderTest() {
        return new SynchronizedShortDoubleMap(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0));
    }

    @Override
    protected SynchronizedShortDoubleMap newWithKeysValues(short key1, double value1) {
        return new SynchronizedShortDoubleMap(new ShortDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2) {
        return new SynchronizedShortDoubleMap(new ShortDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3) {
        return new SynchronizedShortDoubleMap(new ShortDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3, short key4, double value4) {
        return new SynchronizedShortDoubleMap(new ShortDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortDoubleMap getEmptyMap() {
        return new SynchronizedShortDoubleMap(new ShortDoubleHashMap());
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

        private SynchronizedShortDoubleMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortDoubleMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortDoubleMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedShortDoubleMapTest::keySet;
            this.payloads.values = SynchronizedShortDoubleMapTest::values;
            this.payloads.containsAll = SynchronizedShortDoubleMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedShortDoubleMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedShortDoubleMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortDoubleMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedShortDoubleMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedShortDoubleMapTest::testHashCode;
            this.payloads.testToString = SynchronizedShortDoubleMapTest::testToString;
            this.payloads.forEach = SynchronizedShortDoubleMapTest::forEach;
            this.payloads.forEachValue = SynchronizedShortDoubleMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedShortDoubleMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedShortDoubleMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedShortDoubleMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedShortDoubleMapTest::makeString;
            this.payloads.appendString = SynchronizedShortDoubleMapTest::appendString;
            this.payloads.select = SynchronizedShortDoubleMapTest::select;
            this.payloads.reject = SynchronizedShortDoubleMapTest::reject;
            this.payloads.select_value = SynchronizedShortDoubleMapTest::select_value;
            this.payloads.reject_value = SynchronizedShortDoubleMapTest::reject_value;
            this.payloads.collect = SynchronizedShortDoubleMapTest::collect;
            this.payloads.count = SynchronizedShortDoubleMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedShortDoubleMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedShortDoubleMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortDoubleMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedShortDoubleMapTest::noneSatisfy;
            this.payloads.max = SynchronizedShortDoubleMapTest::max;
            this.payloads.min = SynchronizedShortDoubleMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedShortDoubleMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedShortDoubleMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedShortDoubleMapTest::sum;
            this.payloads.average = SynchronizedShortDoubleMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedShortDoubleMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortDoubleMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedShortDoubleMapTest::toList;
            this.payloads.toSortedList = SynchronizedShortDoubleMapTest::toSortedList;
            this.payloads.toSet = SynchronizedShortDoubleMapTest::toSet;
            this.payloads.toBag = SynchronizedShortDoubleMapTest::toBag;
            this.payloads.doubleIterator = SynchronizedShortDoubleMapTest::doubleIterator;
            this.payloads.asLazy = SynchronizedShortDoubleMapTest::asLazy;
            this.payloads.keysView = SynchronizedShortDoubleMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedShortDoubleMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedShortDoubleMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedShortDoubleMapTest::toArray;
            this.payloads.toImmutable = SynchronizedShortDoubleMapTest::toImmutable;
            this.payloads.chunk = SynchronizedShortDoubleMapTest::chunk;
            this.payloads.get = SynchronizedShortDoubleMapTest::get;
            this.payloads.getOrThrow = SynchronizedShortDoubleMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedShortDoubleMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedShortDoubleMapTest::containsKey;
            this.payloads.containsValue = SynchronizedShortDoubleMapTest::containsValue;
            this.payloads.contains = SynchronizedShortDoubleMapTest::contains;
            this.payloads.size = SynchronizedShortDoubleMapTest::size;
            this.payloads.clear = SynchronizedShortDoubleMapTest::clear;
            this.payloads.removeKey = SynchronizedShortDoubleMapTest::removeKey;
            this.payloads.remove = SynchronizedShortDoubleMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedShortDoubleMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedShortDoubleMapTest::put;
            this.payloads.getAndPut = SynchronizedShortDoubleMapTest::getAndPut;
            this.payloads.putPair = SynchronizedShortDoubleMapTest::putPair;
            this.payloads.updateValues = SynchronizedShortDoubleMapTest::updateValues;
            this.payloads.addToValue = SynchronizedShortDoubleMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedShortDoubleMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedShortDoubleMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedShortDoubleMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedShortDoubleMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedShortDoubleMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedShortDoubleMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedShortDoubleMapTest::updateValue;
            this.payloads.freeze = SynchronizedShortDoubleMapTest::freeze;
            this.payloads.withoutKey = SynchronizedShortDoubleMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedShortDoubleMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedShortDoubleMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedShortDoubleMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedShortDoubleMapTest::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = SynchronizedShortDoubleMapTest::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedShortDoubleMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedShortDoubleMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedShortDoubleMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedShortDoubleMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedShortDoubleMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedShortDoubleMapTest::asSynchronized;
        }
    }
}
