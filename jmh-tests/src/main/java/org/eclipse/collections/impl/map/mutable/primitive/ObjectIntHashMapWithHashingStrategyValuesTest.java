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
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;

/**
 * JUnit test for {@link ObjectIntHashMapWithHashingStrategyWithHashingStrategy#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyValuesTest.stg.
 */
public class ObjectIntHashMapWithHashingStrategyValuesTest extends ObjectIntHashMapValuesTestCase {

    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>() {

        public int computeHashCode(String object) {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectIntMap<String> newMapWithKeysValues(String key1, int value1, String key2, int value2, String key3, int value3, String key4, int value4) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectIntMap<String> newEmptyMap() {
        return ObjectIntHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntHashMapWithHashingStrategyValuesTest instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntHashMapWithHashingStrategyValuesTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyValuesTest> chunk;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ObjectIntHashMapWithHashingStrategyValuesTest::newCollectionWith;
            this.payloads.newCollection = ObjectIntHashMapWithHashingStrategyValuesTest::newCollection;
            this.payloads.isEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::isEmpty;
            this.payloads.notEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::notEmpty;
            this.payloads.tap = ObjectIntHashMapWithHashingStrategyValuesTest::tap;
            this.payloads.containsAllArray = ObjectIntHashMapWithHashingStrategyValuesTest::containsAllArray;
            this.payloads.containsAllIterable = ObjectIntHashMapWithHashingStrategyValuesTest::containsAllIterable;
            this.payloads.containsAnyArray = ObjectIntHashMapWithHashingStrategyValuesTest::containsAnyArray;
            this.payloads.containsAnyIterable = ObjectIntHashMapWithHashingStrategyValuesTest::containsAnyIterable;
            this.payloads.containsNoneArray = ObjectIntHashMapWithHashingStrategyValuesTest::containsNoneArray;
            this.payloads.containsNoneIterable = ObjectIntHashMapWithHashingStrategyValuesTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ObjectIntHashMapWithHashingStrategyValuesTest::forEach;
            this.payloads.size = ObjectIntHashMapWithHashingStrategyValuesTest::size;
            this.payloads.count = ObjectIntHashMapWithHashingStrategyValuesTest::count;
            this.payloads.anySatisfy = ObjectIntHashMapWithHashingStrategyValuesTest::anySatisfy;
            this.payloads.allSatisfy = ObjectIntHashMapWithHashingStrategyValuesTest::allSatisfy;
            this.payloads.noneSatisfy = ObjectIntHashMapWithHashingStrategyValuesTest::noneSatisfy;
            this.payloads.collectWithTarget = ObjectIntHashMapWithHashingStrategyValuesTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ObjectIntHashMapWithHashingStrategyValuesTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ObjectIntHashMapWithHashingStrategyValuesTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ObjectIntHashMapWithHashingStrategyValuesTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ObjectIntHashMapWithHashingStrategyValuesTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ObjectIntHashMapWithHashingStrategyValuesTest::selectWithTarget;
            this.payloads.rejectWithTarget = ObjectIntHashMapWithHashingStrategyValuesTest::rejectWithTarget;
            this.payloads.detectIfNone = ObjectIntHashMapWithHashingStrategyValuesTest::detectIfNone;
            this.payloads.max = ObjectIntHashMapWithHashingStrategyValuesTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectIntHashMapWithHashingStrategyValuesTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::minIfEmpty;
            this.payloads.maxIfEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::maxIfEmpty;
            this.payloads.sum = ObjectIntHashMapWithHashingStrategyValuesTest::sum;
            this.payloads.summaryStatistics = ObjectIntHashMapWithHashingStrategyValuesTest::summaryStatistics;
            this.payloads.average = ObjectIntHashMapWithHashingStrategyValuesTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::averageIfEmpty;
            this.payloads.median = ObjectIntHashMapWithHashingStrategyValuesTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::medianIfEmpty;
            this.payloads.toArray = ObjectIntHashMapWithHashingStrategyValuesTest::toArray;
            this.payloads.toArrayWithTargetArray = ObjectIntHashMapWithHashingStrategyValuesTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ObjectIntHashMapWithHashingStrategyValuesTest::toSortedArray;
            this.payloads.testHashCode = ObjectIntHashMapWithHashingStrategyValuesTest::testHashCode;
            this.payloads.testToString = ObjectIntHashMapWithHashingStrategyValuesTest::testToString;
            this.payloads.toList = ObjectIntHashMapWithHashingStrategyValuesTest::toList;
            this.payloads.toSortedList = ObjectIntHashMapWithHashingStrategyValuesTest::toSortedList;
            this.payloads.toSortedListByComparator = ObjectIntHashMapWithHashingStrategyValuesTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ObjectIntHashMapWithHashingStrategyValuesTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ObjectIntHashMapWithHashingStrategyValuesTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ObjectIntHashMapWithHashingStrategyValuesTest::toSet;
            this.payloads.toBag = ObjectIntHashMapWithHashingStrategyValuesTest::toBag;
            this.payloads.asLazy = ObjectIntHashMapWithHashingStrategyValuesTest::asLazy;
            this.payloads.injectInto = ObjectIntHashMapWithHashingStrategyValuesTest::injectInto;
            this.payloads.injectIntoBoolean = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoByte;
            this.payloads.injectIntoChar = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoChar;
            this.payloads.injectIntoShort = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoShort;
            this.payloads.injectIntoInt = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoInt;
            this.payloads.injectIntoFloat = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoFloat;
            this.payloads.injectIntoLong = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectIntHashMapWithHashingStrategyValuesTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ObjectIntHashMapWithHashingStrategyValuesTest::reduce;
            this.payloads.reduceIfEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::reduceIfEmpty;
            this.payloads.testEquals = ObjectIntHashMapWithHashingStrategyValuesTest::testEquals;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = ObjectIntHashMapWithHashingStrategyValuesTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = ObjectIntHashMapWithHashingStrategyValuesTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = ObjectIntHashMapWithHashingStrategyValuesTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ObjectIntHashMapWithHashingStrategyValuesTest::newEmpty;
            this.payloads.intIterator = ObjectIntHashMapWithHashingStrategyValuesTest::intIterator;
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyValuesTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = ObjectIntHashMapWithHashingStrategyValuesTest::remove;
            this.payloads.removeIf = ObjectIntHashMapWithHashingStrategyValuesTest::removeIf;
            this.payloads.removeAll = ObjectIntHashMapWithHashingStrategyValuesTest::removeAll;
            this.payloads.removeAll_iterable = ObjectIntHashMapWithHashingStrategyValuesTest::removeAll_iterable;
            this.payloads.retainAll = ObjectIntHashMapWithHashingStrategyValuesTest::retainAll;
            this.payloads.retainAll_iterable = ObjectIntHashMapWithHashingStrategyValuesTest::retainAll_iterable;
            this.payloads.clear = ObjectIntHashMapWithHashingStrategyValuesTest::clear;
            this.payloads.contains = ObjectIntHashMapWithHashingStrategyValuesTest::contains;
            this.payloads.reject = ObjectIntHashMapWithHashingStrategyValuesTest::reject;
            this.payloads.select = ObjectIntHashMapWithHashingStrategyValuesTest::select;
            this.payloads.collect = ObjectIntHashMapWithHashingStrategyValuesTest::collect;
            this.payloads.makeString = ObjectIntHashMapWithHashingStrategyValuesTest::makeString;
            this.payloads.appendString = ObjectIntHashMapWithHashingStrategyValuesTest::appendString;
            this.payloads.asSynchronized = ObjectIntHashMapWithHashingStrategyValuesTest::asSynchronized;
            this.payloads.asUnmodifiable = ObjectIntHashMapWithHashingStrategyValuesTest::asUnmodifiable;
            this.payloads.chunk = ObjectIntHashMapWithHashingStrategyValuesTest::chunk;
        }
    }
*/
}
