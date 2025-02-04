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
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectDoubleHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectDoubleHashMapWithHashingStrategyValuesTest extends ObjectDoubleHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectDoubleMap<String> newEmptyMap() {
        return ObjectDoubleHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectDoubleHashMapWithHashingStrategyValuesTest instance;

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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectDoubleHashMapWithHashingStrategyValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectDoubleHashMapWithHashingStrategyValuesTest::newCollectionWith;
            this.payloads.newCollection = ObjectDoubleHashMapWithHashingStrategyValuesTest::newCollection;
            this.payloads.isEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::isEmpty;
            this.payloads.notEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::notEmpty;
            this.payloads.tap = ObjectDoubleHashMapWithHashingStrategyValuesTest::tap;
            this.payloads.contains_NaN = ObjectDoubleHashMapWithHashingStrategyValuesTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ObjectDoubleHashMapWithHashingStrategyValuesTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ObjectDoubleHashMapWithHashingStrategyValuesTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ObjectDoubleHashMapWithHashingStrategyValuesTest::contains_zero;
            this.payloads.contains_different_NaNs = ObjectDoubleHashMapWithHashingStrategyValuesTest::contains_different_NaNs;
            this.payloads.containsAllArray = ObjectDoubleHashMapWithHashingStrategyValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ObjectDoubleHashMapWithHashingStrategyValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ObjectDoubleHashMapWithHashingStrategyValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectDoubleHashMapWithHashingStrategyValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectDoubleHashMapWithHashingStrategyValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectDoubleHashMapWithHashingStrategyValuesTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectDoubleHashMapWithHashingStrategyValuesTest::forEach;
            this.payloads.size = ObjectDoubleHashMapWithHashingStrategyValuesTest::size;
            this.payloads.count = ObjectDoubleHashMapWithHashingStrategyValuesTest::count;
            this.payloads.anySatisfy = ObjectDoubleHashMapWithHashingStrategyValuesTest::anySatisfy;
            this.payloads.allSatisfy = ObjectDoubleHashMapWithHashingStrategyValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectDoubleHashMapWithHashingStrategyValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ObjectDoubleHashMapWithHashingStrategyValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectDoubleHashMapWithHashingStrategyValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectDoubleHashMapWithHashingStrategyValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectDoubleHashMapWithHashingStrategyValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectDoubleHashMapWithHashingStrategyValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectDoubleHashMapWithHashingStrategyValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectDoubleHashMapWithHashingStrategyValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ObjectDoubleHashMapWithHashingStrategyValuesTest::detectIfNone;
            this.payloads.max = ObjectDoubleHashMapWithHashingStrategyValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectDoubleHashMapWithHashingStrategyValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::maxIfEmpty;
            this.payloads.sum = ObjectDoubleHashMapWithHashingStrategyValuesTest::sum;
            this.payloads.summaryStatistics = ObjectDoubleHashMapWithHashingStrategyValuesTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ObjectDoubleHashMapWithHashingStrategyValuesTest::sumConsistentRounding;
            this.payloads.average = ObjectDoubleHashMapWithHashingStrategyValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::averageIfEmpty;
            this.payloads.median = ObjectDoubleHashMapWithHashingStrategyValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::medianIfEmpty;
            this.payloads.toArray = ObjectDoubleHashMapWithHashingStrategyValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ObjectDoubleHashMapWithHashingStrategyValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectDoubleHashMapWithHashingStrategyValuesTest::toSortedArray;
            this.payloads.testHashCode = ObjectDoubleHashMapWithHashingStrategyValuesTest::testHashCode;
            this.payloads.testToString = ObjectDoubleHashMapWithHashingStrategyValuesTest::testToString;
            this.payloads.toList = ObjectDoubleHashMapWithHashingStrategyValuesTest::toList;
            this.payloads.toSortedList = ObjectDoubleHashMapWithHashingStrategyValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ObjectDoubleHashMapWithHashingStrategyValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectDoubleHashMapWithHashingStrategyValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectDoubleHashMapWithHashingStrategyValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectDoubleHashMapWithHashingStrategyValuesTest::toSet;
            this.payloads.toBag = ObjectDoubleHashMapWithHashingStrategyValuesTest::toBag;
            this.payloads.asLazy = ObjectDoubleHashMapWithHashingStrategyValuesTest::asLazy;
            this.payloads.injectInto = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectDoubleHashMapWithHashingStrategyValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectDoubleHashMapWithHashingStrategyValuesTest::reduce;
            this.payloads.reduceIfEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::reduceIfEmpty;
            this.payloads.testEquals = ObjectDoubleHashMapWithHashingStrategyValuesTest::testEquals;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = ObjectDoubleHashMapWithHashingStrategyValuesTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = ObjectDoubleHashMapWithHashingStrategyValuesTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = ObjectDoubleHashMapWithHashingStrategyValuesTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectDoubleHashMapWithHashingStrategyValuesTest::newEmpty;
            this.payloads.doubleIterator = ObjectDoubleHashMapWithHashingStrategyValuesTest::doubleIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.testEquals_NaN = ObjectDoubleHashMapWithHashingStrategyValuesTest::testEquals_NaN;
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectDoubleHashMapWithHashingStrategyValuesTest::remove;
            this.payloads.removeIf = ObjectDoubleHashMapWithHashingStrategyValuesTest::removeIf;
            this.payloads.removeAll = ObjectDoubleHashMapWithHashingStrategyValuesTest::removeAll;
            this.payloads.removeAll_iterable = ObjectDoubleHashMapWithHashingStrategyValuesTest::removeAll_iterable;
            this.payloads.retainAll = ObjectDoubleHashMapWithHashingStrategyValuesTest::retainAll;
            this.payloads.retainAll_iterable = ObjectDoubleHashMapWithHashingStrategyValuesTest::retainAll_iterable;
            this.payloads.clear = ObjectDoubleHashMapWithHashingStrategyValuesTest::clear;
            this.payloads.contains = ObjectDoubleHashMapWithHashingStrategyValuesTest::contains;
            this.payloads.reject = ObjectDoubleHashMapWithHashingStrategyValuesTest::reject;
            this.payloads.select = ObjectDoubleHashMapWithHashingStrategyValuesTest::select;
            this.payloads.collect = ObjectDoubleHashMapWithHashingStrategyValuesTest::collect;
            this.payloads.makeString = ObjectDoubleHashMapWithHashingStrategyValuesTest::makeString;
            this.payloads.appendString = ObjectDoubleHashMapWithHashingStrategyValuesTest::appendString;
            this.payloads.asSynchronized = ObjectDoubleHashMapWithHashingStrategyValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ObjectDoubleHashMapWithHashingStrategyValuesTest::asUnmodifiable;
            this.payloads.chunk = ObjectDoubleHashMapWithHashingStrategyValuesTest::chunk;
        }
    }
*/
}
