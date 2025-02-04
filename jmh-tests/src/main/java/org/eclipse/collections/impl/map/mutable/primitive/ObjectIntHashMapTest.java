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

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;

/**
 * JUnit test for {@link ObjectIntHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectIntHashMapTest extends ObjectIntHashMapTestCase {

    @Override
    protected ObjectIntHashMap<String> classUnderTest() {
        return ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1, "2", 2);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1, T key2, int value2) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectIntHashMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4) {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectIntHashMap<T> getEmptyMap() {
        return new ObjectIntHashMap<>();
    }

    @Override
    protected MutableObjectIntMap newMapWithInitialCapacity(int size) {
        return new ObjectIntHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectIntHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntHashMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
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
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
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
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnClear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_iterator_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_iterator_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectIntHashMapTest::keySet;
            this.payloads.values = ObjectIntHashMapTest::values;
            this.payloads.isEmpty = ObjectIntHashMapTest::isEmpty;
            this.payloads.notEmpty = ObjectIntHashMapTest::notEmpty;
            this.payloads.asLazy = ObjectIntHashMapTest::asLazy;
            this.payloads.testEquals = ObjectIntHashMapTest::testEquals;
            this.payloads.testHashCode = ObjectIntHashMapTest::testHashCode;
            this.payloads.testToString = ObjectIntHashMapTest::testToString;
            this.payloads.intIterator = ObjectIntHashMapTest::intIterator;
            this.payloads.forEach = ObjectIntHashMapTest::forEach;
            this.payloads.forEachValue = ObjectIntHashMapTest::forEachValue;
            this.payloads.forEachKey = ObjectIntHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectIntHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectIntHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectIntHashMapTest::makeString;
            this.payloads.appendString = ObjectIntHashMapTest::appendString;
            this.payloads.select = ObjectIntHashMapTest::select;
            this.payloads.reject = ObjectIntHashMapTest::reject;
            this.payloads.tap = ObjectIntHashMapTest::tap;
            this.payloads.count = ObjectIntHashMapTest::count;
            this.payloads.anySatisfy = ObjectIntHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ObjectIntHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectIntHashMapTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectIntHashMapTest::detectIfNone;
            this.payloads.collect = ObjectIntHashMapTest::collect;
            this.payloads.sum = ObjectIntHashMapTest::sum;
            this.payloads.max = ObjectIntHashMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectIntHashMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectIntHashMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectIntHashMapTest::minIfEmpty;
            this.payloads.average = ObjectIntHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectIntHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectIntHashMapTest::toArray;
            this.payloads.toSortedArray = ObjectIntHashMapTest::toSortedArray;
            this.payloads.containsAll = ObjectIntHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectIntHashMapTest::containsAll_Iterable;
            this.payloads.toList = ObjectIntHashMapTest::toList;
            this.payloads.toSortedList = ObjectIntHashMapTest::toSortedList;
            this.payloads.toSet = ObjectIntHashMapTest::toSet;
            this.payloads.toBag = ObjectIntHashMapTest::toBag;
            this.payloads.toImmutable = ObjectIntHashMapTest::toImmutable;
            this.payloads.clear = ObjectIntHashMapTest::clear;
            this.payloads.removeKey = ObjectIntHashMapTest::removeKey;
            this.payloads.remove = ObjectIntHashMapTest::remove;
            this.payloads.put = ObjectIntHashMapTest::put;
            this.payloads.updateValues = ObjectIntHashMapTest::updateValues;
            this.payloads.putPair = ObjectIntHashMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectIntHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectIntHashMapTest::get;
            this.payloads.getOrThrow = ObjectIntHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectIntHashMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectIntHashMapTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectIntHashMapTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectIntHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectIntHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectIntHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectIntHashMapTest::updateValue;
            this.payloads.addToValue = ObjectIntHashMapTest::addToValue;
            this.payloads.containsKey = ObjectIntHashMapTest::containsKey;
            this.payloads.containsValue = ObjectIntHashMapTest::containsValue;
            this.payloads.size = ObjectIntHashMapTest::size;
            this.payloads.withKeysValues = ObjectIntHashMapTest::withKeysValues;
            this.payloads.withoutKey = ObjectIntHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectIntHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectIntHashMapTest::withAllKeyValues;
            this.payloads.contains = ObjectIntHashMapTest::contains;
            this.payloads.asUnmodifiable = ObjectIntHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectIntHashMapTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectIntHashMapTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectIntHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectIntHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectIntHashMapTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectIntHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectIntHashMapTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectIntHashMapTest::putWithRehash;
            this.payloads.testPutAll = ObjectIntHashMapTest::testPutAll;
            this.payloads.injectInto = ObjectIntHashMapTest::injectInto;
            this.payloads.put_every_slot = ObjectIntHashMapTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectIntHashMapTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectIntHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectIntHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectIntHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectIntHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectIntHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectIntHashMapTest::classIsNonInstantiable;
        }
    }
}
