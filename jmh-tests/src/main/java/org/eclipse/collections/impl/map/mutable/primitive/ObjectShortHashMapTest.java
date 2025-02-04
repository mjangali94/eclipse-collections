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

import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;

/**
 * JUnit test for {@link ObjectShortHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectShortHashMapTest extends ObjectShortHashMapTestCase {

    @Override
    protected ObjectShortHashMap<String> classUnderTest() {
        return ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectShortHashMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4) {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectShortHashMap<T> getEmptyMap() {
        return new ObjectShortHashMap<>();
    }

    @Override
    protected MutableObjectShortMap newMapWithInitialCapacity(int size) {
        return new ObjectShortHashMap<>(size);
    }

    @Override
    protected Class getTargetClass() {
        return ObjectShortHashMap.class;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectShortHashMapTest::keySet;
            this.payloads.values = ObjectShortHashMapTest::values;
            this.payloads.isEmpty = ObjectShortHashMapTest::isEmpty;
            this.payloads.notEmpty = ObjectShortHashMapTest::notEmpty;
            this.payloads.asLazy = ObjectShortHashMapTest::asLazy;
            this.payloads.testEquals = ObjectShortHashMapTest::testEquals;
            this.payloads.testHashCode = ObjectShortHashMapTest::testHashCode;
            this.payloads.testToString = ObjectShortHashMapTest::testToString;
            this.payloads.shortIterator = ObjectShortHashMapTest::shortIterator;
            this.payloads.forEach = ObjectShortHashMapTest::forEach;
            this.payloads.forEachValue = ObjectShortHashMapTest::forEachValue;
            this.payloads.forEachKey = ObjectShortHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ObjectShortHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectShortHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ObjectShortHashMapTest::makeString;
            this.payloads.appendString = ObjectShortHashMapTest::appendString;
            this.payloads.select = ObjectShortHashMapTest::select;
            this.payloads.reject = ObjectShortHashMapTest::reject;
            this.payloads.tap = ObjectShortHashMapTest::tap;
            this.payloads.count = ObjectShortHashMapTest::count;
            this.payloads.anySatisfy = ObjectShortHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ObjectShortHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectShortHashMapTest::noneSatisfy;
            this.payloads.detectIfNone = ObjectShortHashMapTest::detectIfNone;
            this.payloads.collect = ObjectShortHashMapTest::collect;
            this.payloads.sum = ObjectShortHashMapTest::sum;
            this.payloads.max = ObjectShortHashMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectShortHashMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectShortHashMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectShortHashMapTest::minIfEmpty;
            this.payloads.average = ObjectShortHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectShortHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectShortHashMapTest::toArray;
            this.payloads.toSortedArray = ObjectShortHashMapTest::toSortedArray;
            this.payloads.containsAll = ObjectShortHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ObjectShortHashMapTest::containsAll_Iterable;
            this.payloads.toList = ObjectShortHashMapTest::toList;
            this.payloads.toSortedList = ObjectShortHashMapTest::toSortedList;
            this.payloads.toSet = ObjectShortHashMapTest::toSet;
            this.payloads.toBag = ObjectShortHashMapTest::toBag;
            this.payloads.toImmutable = ObjectShortHashMapTest::toImmutable;
            this.payloads.clear = ObjectShortHashMapTest::clear;
            this.payloads.removeKey = ObjectShortHashMapTest::removeKey;
            this.payloads.remove = ObjectShortHashMapTest::remove;
            this.payloads.put = ObjectShortHashMapTest::put;
            this.payloads.updateValues = ObjectShortHashMapTest::updateValues;
            this.payloads.putPair = ObjectShortHashMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectShortHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectShortHashMapTest::get;
            this.payloads.getOrThrow = ObjectShortHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ObjectShortHashMapTest::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectShortHashMapTest::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectShortHashMapTest::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectShortHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectShortHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectShortHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectShortHashMapTest::updateValue;
            this.payloads.addToValue = ObjectShortHashMapTest::addToValue;
            this.payloads.containsKey = ObjectShortHashMapTest::containsKey;
            this.payloads.containsValue = ObjectShortHashMapTest::containsValue;
            this.payloads.size = ObjectShortHashMapTest::size;
            this.payloads.withKeysValues = ObjectShortHashMapTest::withKeysValues;
            this.payloads.withoutKey = ObjectShortHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ObjectShortHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectShortHashMapTest::withAllKeyValues;
            this.payloads.contains = ObjectShortHashMapTest::contains;
            this.payloads.asUnmodifiable = ObjectShortHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = ObjectShortHashMapTest::asSynchronized;
            this.payloads.flipUniqueValues = ObjectShortHashMapTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectShortHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectShortHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectShortHashMapTest::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectShortHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectShortHashMapTest::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectShortHashMapTest::putWithRehash;
            this.payloads.testPutAll = ObjectShortHashMapTest::testPutAll;
            this.payloads.injectInto = ObjectShortHashMapTest::injectInto;
            this.payloads.put_every_slot = ObjectShortHashMapTest::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectShortHashMapTest::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectShortHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectShortHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectShortHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectShortHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectShortHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectShortHashMapTest::classIsNonInstantiable;
        }
    }
}
