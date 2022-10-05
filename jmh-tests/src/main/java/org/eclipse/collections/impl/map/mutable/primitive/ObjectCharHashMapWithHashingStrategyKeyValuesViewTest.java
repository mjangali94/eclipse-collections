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
import org.eclipse.collections.api.map.primitive.ObjectCharMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ObjectCharHashMapWithHashingStrategy#keyValuesView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ObjectCharHashMapWithHashingStrategyKeyValuesViewTest extends AbstractObjectCharMapKeyValuesViewTestCase {

    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    public <T> ObjectCharMap<T> newWithKeysValues(T key1, char value1) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    public ObjectCharMap<Integer> newEmpty() {
        return ObjectCharHashMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharHashMapWithHashingStrategyKeyValuesViewTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
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
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharHashMapWithHashingStrategyKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::forEach;
            this.payloads.forEachWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::select;
            this.payloads.selectWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::selectWith_target;
            this.payloads.reject = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::reject;
            this.payloads.rejectWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collect;
            this.payloads.collectBoolean = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectByte;
            this.payloads.collectChar = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectInt;
            this.payloads.collectLong = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectLong;
            this.payloads.collectShort = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::flatCollect;
            this.payloads.detect = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::min;
            this.payloads.max = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::max;
            this.payloads.min_without_comparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::minBy;
            this.payloads.maxBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::maxBy;
            this.payloads.detectWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::count;
            this.payloads.countWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::countWith;
            this.payloads.collectIf = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectIf;
            this.payloads.collectWith = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::getFirst;
            this.payloads.getLast = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::getLast;
            this.payloads.isEmpty = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::isEmpty;
            this.payloads.iterator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::sumLong;
            this.payloads.toArray = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toArray;
            this.payloads.partition = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::partition;
            this.payloads.toList = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toList;
            this.payloads.toBag = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSet;
            this.payloads.toMap = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::testToString;
            this.payloads.makeString = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::groupByEach;
            this.payloads.zip = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::empty;
            this.payloads.notEmpty = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ObjectCharHashMapWithHashingStrategyKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
