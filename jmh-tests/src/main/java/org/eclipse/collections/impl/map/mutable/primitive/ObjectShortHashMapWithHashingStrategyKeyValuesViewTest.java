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
import org.eclipse.collections.api.map.primitive.ObjectShortMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.primitive.AbstractObjectShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ObjectShortHashMapWithHashingStrategy#keyValuesView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ObjectShortHashMapWithHashingStrategyKeyValuesViewTest extends AbstractObjectShortMapKeyValuesViewTestCase {

    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    public <T> ObjectShortMap<T> newWithKeysValues(T key1, short value1) {
        return ObjectShortHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    public ObjectShortMap<Integer> newEmpty() {
        return ObjectShortHashMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectShortHashMapWithHashingStrategyKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectShortHashMapWithHashingStrategyKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectShortHashMapWithHashingStrategyKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::forEach;
            this.payloads.forEachWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::select;
            this.payloads.selectWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::selectWith_target;
            this.payloads.reject = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::reject;
            this.payloads.rejectWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collect;
            this.payloads.collectBoolean = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectByte;
            this.payloads.collectChar = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectInt;
            this.payloads.collectLong = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectLong;
            this.payloads.collectShort = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::flatCollect;
            this.payloads.detect = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::min;
            this.payloads.max = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::max;
            this.payloads.min_without_comparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::minBy;
            this.payloads.maxBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::maxBy;
            this.payloads.detectWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::count;
            this.payloads.countWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::countWith;
            this.payloads.collectIf = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectIf;
            this.payloads.collectWith = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::getFirst;
            this.payloads.getLast = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::getLast;
            this.payloads.isEmpty = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::isEmpty;
            this.payloads.iterator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::sumLong;
            this.payloads.toArray = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toArray;
            this.payloads.partition = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::partition;
            this.payloads.toList = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toList;
            this.payloads.toBag = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSet;
            this.payloads.toMap = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::testToString;
            this.payloads.makeString = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::groupByEach;
            this.payloads.zip = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::empty;
            this.payloads.notEmpty = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ObjectShortHashMapWithHashingStrategyKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
