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
 * JUnit test for {@link SynchronizedFloatShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedFloatShortMapTest extends AbstractMutableFloatShortMapTestCase {

    private final SynchronizedFloatShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedFloatShortMap classUnderTest() {
        return new SynchronizedFloatShortMap(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32));
    }

    @Override
    protected SynchronizedFloatShortMap newWithKeysValues(float key1, short value1) {
        return new SynchronizedFloatShortMap(new FloatShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2) {
        return new SynchronizedFloatShortMap(new FloatShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3) {
        return new SynchronizedFloatShortMap(new FloatShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3, float key4, short value4) {
        return new SynchronizedFloatShortMap(new FloatShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedFloatShortMap getEmptyMap() {
        return new SynchronizedFloatShortMap(new FloatShortHashMap());
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

        private SynchronizedFloatShortMapTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatShortMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatShortMapTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = SynchronizedFloatShortMapTest::keySet;
            this.payloads.values = SynchronizedFloatShortMapTest::values;
            this.payloads.containsAll = SynchronizedFloatShortMapTest::containsAll;
            this.payloads.containsAll_Iterable = SynchronizedFloatShortMapTest::containsAll_Iterable;
            this.payloads.isEmpty = SynchronizedFloatShortMapTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatShortMapTest::notEmpty;
            this.payloads.testEquals = SynchronizedFloatShortMapTest::testEquals;
            this.payloads.testHashCode = SynchronizedFloatShortMapTest::testHashCode;
            this.payloads.testToString = SynchronizedFloatShortMapTest::testToString;
            this.payloads.forEach = SynchronizedFloatShortMapTest::forEach;
            this.payloads.forEachValue = SynchronizedFloatShortMapTest::forEachValue;
            this.payloads.forEachKey = SynchronizedFloatShortMapTest::forEachKey;
            this.payloads.forEachKeyValue = SynchronizedFloatShortMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = SynchronizedFloatShortMapTest::injectIntoKeyValue;
            this.payloads.makeString = SynchronizedFloatShortMapTest::makeString;
            this.payloads.appendString = SynchronizedFloatShortMapTest::appendString;
            this.payloads.select = SynchronizedFloatShortMapTest::select;
            this.payloads.reject = SynchronizedFloatShortMapTest::reject;
            this.payloads.select_value = SynchronizedFloatShortMapTest::select_value;
            this.payloads.reject_value = SynchronizedFloatShortMapTest::reject_value;
            this.payloads.collect = SynchronizedFloatShortMapTest::collect;
            this.payloads.count = SynchronizedFloatShortMapTest::count;
            this.payloads.detectIfNone_value = SynchronizedFloatShortMapTest::detectIfNone_value;
            this.payloads.anySatisfy = SynchronizedFloatShortMapTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatShortMapTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedFloatShortMapTest::noneSatisfy;
            this.payloads.max = SynchronizedFloatShortMapTest::max;
            this.payloads.min = SynchronizedFloatShortMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatShortMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatShortMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedFloatShortMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatShortMapTest::maxIfEmpty;
            this.payloads.sum = SynchronizedFloatShortMapTest::sum;
            this.payloads.average = SynchronizedFloatShortMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatShortMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = SynchronizedFloatShortMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatShortMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = SynchronizedFloatShortMapTest::toList;
            this.payloads.toSortedList = SynchronizedFloatShortMapTest::toSortedList;
            this.payloads.toSet = SynchronizedFloatShortMapTest::toSet;
            this.payloads.toBag = SynchronizedFloatShortMapTest::toBag;
            this.payloads.shortIterator = SynchronizedFloatShortMapTest::shortIterator;
            this.payloads.asLazy = SynchronizedFloatShortMapTest::asLazy;
            this.payloads.keysView = SynchronizedFloatShortMapTest::keysView;
            this.payloads.keyValuesView = SynchronizedFloatShortMapTest::keyValuesView;
            this.payloads.toSortedArray = SynchronizedFloatShortMapTest::toSortedArray;
            this.payloads.toArray = SynchronizedFloatShortMapTest::toArray;
            this.payloads.toImmutable = SynchronizedFloatShortMapTest::toImmutable;
            this.payloads.chunk = SynchronizedFloatShortMapTest::chunk;
            this.payloads.get = SynchronizedFloatShortMapTest::get;
            this.payloads.getOrThrow = SynchronizedFloatShortMapTest::getOrThrow;
            this.payloads.getIfAbsent = SynchronizedFloatShortMapTest::getIfAbsent;
            this.payloads.containsKey = SynchronizedFloatShortMapTest::containsKey;
            this.payloads.containsValue = SynchronizedFloatShortMapTest::containsValue;
            this.payloads.contains = SynchronizedFloatShortMapTest::contains;
            this.payloads.size = SynchronizedFloatShortMapTest::size;
            this.payloads.clear = SynchronizedFloatShortMapTest::clear;
            this.payloads.removeKey = SynchronizedFloatShortMapTest::removeKey;
            this.payloads.remove = SynchronizedFloatShortMapTest::remove;
            this.payloads.removeKeyIfAbsent = SynchronizedFloatShortMapTest::removeKeyIfAbsent;
            this.payloads.put = SynchronizedFloatShortMapTest::put;
            this.payloads.getAndPut = SynchronizedFloatShortMapTest::getAndPut;
            this.payloads.putPair = SynchronizedFloatShortMapTest::putPair;
            this.payloads.updateValues = SynchronizedFloatShortMapTest::updateValues;
            this.payloads.addToValue = SynchronizedFloatShortMapTest::addToValue;
            this.payloads.put_every_slot = SynchronizedFloatShortMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = SynchronizedFloatShortMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = SynchronizedFloatShortMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = SynchronizedFloatShortMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = SynchronizedFloatShortMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = SynchronizedFloatShortMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = SynchronizedFloatShortMapTest::updateValue;
            this.payloads.freeze = SynchronizedFloatShortMapTest::freeze;
            this.payloads.withoutKey = SynchronizedFloatShortMapTest::withoutKey;
            this.payloads.withoutAllKeys = SynchronizedFloatShortMapTest::withoutAllKeys;
            this.payloads.withKeysValues = SynchronizedFloatShortMapTest::withKeysValues;
            this.payloads.withAllKeyValues = SynchronizedFloatShortMapTest::withAllKeyValues;
            this.payloads.asUnmodifiable = SynchronizedFloatShortMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = SynchronizedFloatShortMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = SynchronizedFloatShortMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = SynchronizedFloatShortMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = SynchronizedFloatShortMapTest::flipUniqueValues;
            this.payloads.serialize = SynchronizedFloatShortMapTest::serialize;
            this.payloads.serializeKeySet = SynchronizedFloatShortMapTest::serializeKeySet;
            this.payloads.asSynchronized = SynchronizedFloatShortMapTest::asSynchronized;
        }
    }
}
