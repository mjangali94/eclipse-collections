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
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectFloatHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectFloatHashMapWithHashingStrategyValuesTest extends ObjectFloatHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectFloatMap<String> newMapWithKeysValues(String key1, float value1, String key2, float value2, String key3, float value3, String key4, float value4) {
        return ObjectFloatHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectFloatMap<String> newEmptyMap() {
        return ObjectFloatHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatHashMapWithHashingStrategyValuesTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatHashMapWithHashingStrategyValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapWithHashingStrategyValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectFloatHashMapWithHashingStrategyValuesTest::newCollectionWith;
            this.payloads.newCollection = ObjectFloatHashMapWithHashingStrategyValuesTest::newCollection;
            this.payloads.isEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::isEmpty;
            this.payloads.notEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::notEmpty;
            this.payloads.tap = ObjectFloatHashMapWithHashingStrategyValuesTest::tap;
            this.payloads.contains_NaN = ObjectFloatHashMapWithHashingStrategyValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ObjectFloatHashMapWithHashingStrategyValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ObjectFloatHashMapWithHashingStrategyValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ObjectFloatHashMapWithHashingStrategyValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = ObjectFloatHashMapWithHashingStrategyValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = ObjectFloatHashMapWithHashingStrategyValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ObjectFloatHashMapWithHashingStrategyValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ObjectFloatHashMapWithHashingStrategyValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectFloatHashMapWithHashingStrategyValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectFloatHashMapWithHashingStrategyValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectFloatHashMapWithHashingStrategyValuesTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectFloatHashMapWithHashingStrategyValuesTest::forEach;
            this.payloads.size = ObjectFloatHashMapWithHashingStrategyValuesTest::size;
            this.payloads.count = ObjectFloatHashMapWithHashingStrategyValuesTest::count;
            this.payloads.anySatisfy = ObjectFloatHashMapWithHashingStrategyValuesTest::anySatisfy;
            this.payloads.allSatisfy = ObjectFloatHashMapWithHashingStrategyValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectFloatHashMapWithHashingStrategyValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ObjectFloatHashMapWithHashingStrategyValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectFloatHashMapWithHashingStrategyValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectFloatHashMapWithHashingStrategyValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectFloatHashMapWithHashingStrategyValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectFloatHashMapWithHashingStrategyValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectFloatHashMapWithHashingStrategyValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectFloatHashMapWithHashingStrategyValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ObjectFloatHashMapWithHashingStrategyValuesTest::detectIfNone;
            this.payloads.max = ObjectFloatHashMapWithHashingStrategyValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectFloatHashMapWithHashingStrategyValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::maxIfEmpty;
            this.payloads.sum = ObjectFloatHashMapWithHashingStrategyValuesTest::sum;
            this.payloads.summaryStatistics = ObjectFloatHashMapWithHashingStrategyValuesTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ObjectFloatHashMapWithHashingStrategyValuesTest::sumConsistentRounding;
            this.payloads.average = ObjectFloatHashMapWithHashingStrategyValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::averageIfEmpty;
            this.payloads.median = ObjectFloatHashMapWithHashingStrategyValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::medianIfEmpty;
            this.payloads.toArray = ObjectFloatHashMapWithHashingStrategyValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ObjectFloatHashMapWithHashingStrategyValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectFloatHashMapWithHashingStrategyValuesTest::toSortedArray;
            this.payloads.testHashCode = ObjectFloatHashMapWithHashingStrategyValuesTest::testHashCode;
            this.payloads.testToString = ObjectFloatHashMapWithHashingStrategyValuesTest::testToString;
            this.payloads.toList = ObjectFloatHashMapWithHashingStrategyValuesTest::toList;
            this.payloads.toSortedList = ObjectFloatHashMapWithHashingStrategyValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ObjectFloatHashMapWithHashingStrategyValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectFloatHashMapWithHashingStrategyValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectFloatHashMapWithHashingStrategyValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectFloatHashMapWithHashingStrategyValuesTest::toSet;
            this.payloads.toBag = ObjectFloatHashMapWithHashingStrategyValuesTest::toBag;
            this.payloads.asLazy = ObjectFloatHashMapWithHashingStrategyValuesTest::asLazy;
            this.payloads.injectInto = ObjectFloatHashMapWithHashingStrategyValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectFloatHashMapWithHashingStrategyValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectFloatHashMapWithHashingStrategyValuesTest::reduce;
            this.payloads.reduceIfEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::reduceIfEmpty;
            this.payloads.testEquals = ObjectFloatHashMapWithHashingStrategyValuesTest::testEquals;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = ObjectFloatHashMapWithHashingStrategyValuesTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = ObjectFloatHashMapWithHashingStrategyValuesTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = ObjectFloatHashMapWithHashingStrategyValuesTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectFloatHashMapWithHashingStrategyValuesTest::newEmpty;
            this.payloads.floatIterator = ObjectFloatHashMapWithHashingStrategyValuesTest::floatIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = ObjectFloatHashMapWithHashingStrategyValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapWithHashingStrategyValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectFloatHashMapWithHashingStrategyValuesTest::remove;
            this.payloads.removeIf = ObjectFloatHashMapWithHashingStrategyValuesTest::removeIf;
            this.payloads.removeAll = ObjectFloatHashMapWithHashingStrategyValuesTest::removeAll;
            this.payloads.removeAll_iterable = ObjectFloatHashMapWithHashingStrategyValuesTest::removeAll_iterable;
            this.payloads.retainAll = ObjectFloatHashMapWithHashingStrategyValuesTest::retainAll;
            this.payloads.retainAll_iterable = ObjectFloatHashMapWithHashingStrategyValuesTest::retainAll_iterable;
            this.payloads.clear = ObjectFloatHashMapWithHashingStrategyValuesTest::clear;
            this.payloads.contains = ObjectFloatHashMapWithHashingStrategyValuesTest::contains;
            this.payloads.reject = ObjectFloatHashMapWithHashingStrategyValuesTest::reject;
            this.payloads.select = ObjectFloatHashMapWithHashingStrategyValuesTest::select;
            this.payloads.collect = ObjectFloatHashMapWithHashingStrategyValuesTest::collect;
            this.payloads.makeString = ObjectFloatHashMapWithHashingStrategyValuesTest::makeString;
            this.payloads.appendString = ObjectFloatHashMapWithHashingStrategyValuesTest::appendString;
            this.payloads.asSynchronized = ObjectFloatHashMapWithHashingStrategyValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ObjectFloatHashMapWithHashingStrategyValuesTest::asUnmodifiable;
            this.payloads.chunk = ObjectFloatHashMapWithHashingStrategyValuesTest::chunk;
        }
    }
*/
}
