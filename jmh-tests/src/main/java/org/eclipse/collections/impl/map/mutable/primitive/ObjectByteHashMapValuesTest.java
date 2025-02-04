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

import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;

/**
 * JUnit test for {@link ObjectByteHashMap#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTest.stg.
 */
public class ObjectByteHashMapValuesTest extends ObjectByteHashMapValuesTestCase {

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectByteHashMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3, String key4, byte value4) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectByteMap<String> newEmptyMap() {
        return ObjectByteHashMap.newMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectByteHashMapValuesTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
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
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
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
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
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
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectByteHashMapValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectByteHashMapValuesTest::newCollectionWith;
            this.payloads.newCollection = ObjectByteHashMapValuesTest::newCollection;
            this.payloads.isEmpty = ObjectByteHashMapValuesTest::isEmpty;
            this.payloads.notEmpty = ObjectByteHashMapValuesTest::notEmpty;
            this.payloads.tap = ObjectByteHashMapValuesTest::tap;
            this.payloads.containsAllArray = ObjectByteHashMapValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ObjectByteHashMapValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ObjectByteHashMapValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectByteHashMapValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectByteHashMapValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectByteHashMapValuesTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectByteHashMapValuesTest::forEach;
            this.payloads.size = ObjectByteHashMapValuesTest::size;
            this.payloads.count = ObjectByteHashMapValuesTest::count;
            this.payloads.anySatisfy = ObjectByteHashMapValuesTest::anySatisfy;
            this.payloads.allSatisfy = ObjectByteHashMapValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectByteHashMapValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ObjectByteHashMapValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectByteHashMapValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectByteHashMapValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectByteHashMapValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectByteHashMapValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectByteHashMapValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectByteHashMapValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ObjectByteHashMapValuesTest::detectIfNone;
            this.payloads.max = ObjectByteHashMapValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectByteHashMapValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectByteHashMapValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectByteHashMapValuesTest::maxIfEmpty;
            this.payloads.sum = ObjectByteHashMapValuesTest::sum;
            this.payloads.summaryStatistics = ObjectByteHashMapValuesTest::summaryStatistics;
            this.payloads.average = ObjectByteHashMapValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectByteHashMapValuesTest::averageIfEmpty;
            this.payloads.median = ObjectByteHashMapValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectByteHashMapValuesTest::medianIfEmpty;
            this.payloads.toArray = ObjectByteHashMapValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ObjectByteHashMapValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectByteHashMapValuesTest::toSortedArray;
            this.payloads.testHashCode = ObjectByteHashMapValuesTest::testHashCode;
            this.payloads.testToString = ObjectByteHashMapValuesTest::testToString;
            this.payloads.toList = ObjectByteHashMapValuesTest::toList;
            this.payloads.toSortedList = ObjectByteHashMapValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ObjectByteHashMapValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectByteHashMapValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectByteHashMapValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectByteHashMapValuesTest::toSet;
            this.payloads.toBag = ObjectByteHashMapValuesTest::toBag;
            this.payloads.asLazy = ObjectByteHashMapValuesTest::asLazy;
            this.payloads.injectInto = ObjectByteHashMapValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ObjectByteHashMapValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectByteHashMapValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ObjectByteHashMapValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ObjectByteHashMapValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ObjectByteHashMapValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectByteHashMapValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectByteHashMapValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectByteHashMapValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectByteHashMapValuesTest::reduce;
            this.payloads.reduceIfEmpty = ObjectByteHashMapValuesTest::reduceIfEmpty;
            this.payloads.testEquals = ObjectByteHashMapValuesTest::testEquals;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = ObjectByteHashMapValuesTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = ObjectByteHashMapValuesTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = ObjectByteHashMapValuesTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectByteHashMapValuesTest::newEmpty;
            this.payloads.byteIterator = ObjectByteHashMapValuesTest::byteIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectByteHashMapValuesTest::remove;
            this.payloads.removeIf = ObjectByteHashMapValuesTest::removeIf;
            this.payloads.removeAll = ObjectByteHashMapValuesTest::removeAll;
            this.payloads.removeAll_iterable = ObjectByteHashMapValuesTest::removeAll_iterable;
            this.payloads.retainAll = ObjectByteHashMapValuesTest::retainAll;
            this.payloads.retainAll_iterable = ObjectByteHashMapValuesTest::retainAll_iterable;
            this.payloads.clear = ObjectByteHashMapValuesTest::clear;
            this.payloads.contains = ObjectByteHashMapValuesTest::contains;
            this.payloads.reject = ObjectByteHashMapValuesTest::reject;
            this.payloads.select = ObjectByteHashMapValuesTest::select;
            this.payloads.collect = ObjectByteHashMapValuesTest::collect;
            this.payloads.makeString = ObjectByteHashMapValuesTest::makeString;
            this.payloads.appendString = ObjectByteHashMapValuesTest::appendString;
            this.payloads.asSynchronized = ObjectByteHashMapValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ObjectByteHashMapValuesTest::asUnmodifiable;
            this.payloads.chunk = ObjectByteHashMapValuesTest::chunk;
        }
    }
}
