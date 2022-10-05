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

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectShortHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectShortHashMapWithHashingStrategyValuesTest extends ObjectShortHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectShortMap<String> newEmptyMap() {
        return ObjectShortHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapWithHashingStrategyValuesTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
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
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
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
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
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
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapWithHashingStrategyValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectShortHashMapWithHashingStrategyValuesTest::newCollectionWith;
            this.payloads.newCollection = ObjectShortHashMapWithHashingStrategyValuesTest::newCollection;
            this.payloads.isEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::isEmpty;
            this.payloads.notEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::notEmpty;
            this.payloads.tap = ObjectShortHashMapWithHashingStrategyValuesTest::tap;
            this.payloads.containsAllArray = ObjectShortHashMapWithHashingStrategyValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ObjectShortHashMapWithHashingStrategyValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ObjectShortHashMapWithHashingStrategyValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectShortHashMapWithHashingStrategyValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectShortHashMapWithHashingStrategyValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectShortHashMapWithHashingStrategyValuesTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectShortHashMapWithHashingStrategyValuesTest::forEach;
            this.payloads.size = ObjectShortHashMapWithHashingStrategyValuesTest::size;
            this.payloads.count = ObjectShortHashMapWithHashingStrategyValuesTest::count;
            this.payloads.anySatisfy = ObjectShortHashMapWithHashingStrategyValuesTest::anySatisfy;
            this.payloads.allSatisfy = ObjectShortHashMapWithHashingStrategyValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectShortHashMapWithHashingStrategyValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ObjectShortHashMapWithHashingStrategyValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectShortHashMapWithHashingStrategyValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectShortHashMapWithHashingStrategyValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectShortHashMapWithHashingStrategyValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectShortHashMapWithHashingStrategyValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectShortHashMapWithHashingStrategyValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectShortHashMapWithHashingStrategyValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ObjectShortHashMapWithHashingStrategyValuesTest::detectIfNone;
            this.payloads.max = ObjectShortHashMapWithHashingStrategyValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectShortHashMapWithHashingStrategyValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::maxIfEmpty;
            this.payloads.sum = ObjectShortHashMapWithHashingStrategyValuesTest::sum;
            this.payloads.summaryStatistics = ObjectShortHashMapWithHashingStrategyValuesTest::summaryStatistics;
            this.payloads.average = ObjectShortHashMapWithHashingStrategyValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::averageIfEmpty;
            this.payloads.median = ObjectShortHashMapWithHashingStrategyValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::medianIfEmpty;
            this.payloads.toArray = ObjectShortHashMapWithHashingStrategyValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ObjectShortHashMapWithHashingStrategyValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectShortHashMapWithHashingStrategyValuesTest::toSortedArray;
            this.payloads.testHashCode = ObjectShortHashMapWithHashingStrategyValuesTest::testHashCode;
            this.payloads.testToString = ObjectShortHashMapWithHashingStrategyValuesTest::testToString;
            this.payloads.toList = ObjectShortHashMapWithHashingStrategyValuesTest::toList;
            this.payloads.toSortedList = ObjectShortHashMapWithHashingStrategyValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ObjectShortHashMapWithHashingStrategyValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectShortHashMapWithHashingStrategyValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectShortHashMapWithHashingStrategyValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectShortHashMapWithHashingStrategyValuesTest::toSet;
            this.payloads.toBag = ObjectShortHashMapWithHashingStrategyValuesTest::toBag;
            this.payloads.asLazy = ObjectShortHashMapWithHashingStrategyValuesTest::asLazy;
            this.payloads.injectInto = ObjectShortHashMapWithHashingStrategyValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectShortHashMapWithHashingStrategyValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectShortHashMapWithHashingStrategyValuesTest::reduce;
            this.payloads.reduceIfEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::reduceIfEmpty;
            this.payloads.testEquals = ObjectShortHashMapWithHashingStrategyValuesTest::testEquals;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = ObjectShortHashMapWithHashingStrategyValuesTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = ObjectShortHashMapWithHashingStrategyValuesTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = ObjectShortHashMapWithHashingStrategyValuesTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectShortHashMapWithHashingStrategyValuesTest::newEmpty;
            this.payloads.shortIterator = ObjectShortHashMapWithHashingStrategyValuesTest::shortIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectShortHashMapWithHashingStrategyValuesTest::remove;
            this.payloads.removeIf = ObjectShortHashMapWithHashingStrategyValuesTest::removeIf;
            this.payloads.removeAll = ObjectShortHashMapWithHashingStrategyValuesTest::removeAll;
            this.payloads.removeAll_iterable = ObjectShortHashMapWithHashingStrategyValuesTest::removeAll_iterable;
            this.payloads.retainAll = ObjectShortHashMapWithHashingStrategyValuesTest::retainAll;
            this.payloads.retainAll_iterable = ObjectShortHashMapWithHashingStrategyValuesTest::retainAll_iterable;
            this.payloads.clear = ObjectShortHashMapWithHashingStrategyValuesTest::clear;
            this.payloads.contains = ObjectShortHashMapWithHashingStrategyValuesTest::contains;
            this.payloads.reject = ObjectShortHashMapWithHashingStrategyValuesTest::reject;
            this.payloads.select = ObjectShortHashMapWithHashingStrategyValuesTest::select;
            this.payloads.collect = ObjectShortHashMapWithHashingStrategyValuesTest::collect;
            this.payloads.makeString = ObjectShortHashMapWithHashingStrategyValuesTest::makeString;
            this.payloads.appendString = ObjectShortHashMapWithHashingStrategyValuesTest::appendString;
            this.payloads.asSynchronized = ObjectShortHashMapWithHashingStrategyValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ObjectShortHashMapWithHashingStrategyValuesTest::asUnmodifiable;
            this.payloads.chunk = ObjectShortHashMapWithHashingStrategyValuesTest::chunk;
        }
    }
}
