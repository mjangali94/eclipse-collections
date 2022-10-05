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
import org.eclipse.collections.api.map.primitive.ObjectByteMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.primitive.AbstractObjectByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ObjectByteHashMapWithHashingStrategy#keyValuesView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ObjectByteHashMapWithHashingStrategyKeyValuesViewTest extends AbstractObjectByteMapKeyValuesViewTestCase {

    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    public <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    public <T> ObjectByteMap<T> newWithKeysValues(T key1, byte value1) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    public ObjectByteMap<Integer> newEmpty() {
        return ObjectByteHashMapWithHashingStrategy.newMap(INTEGER_HASHING_STRATEGY);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectByteHashMapWithHashingStrategyKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectByteHashMapWithHashingStrategyKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::forEach;
            this.payloads.forEachWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::select;
            this.payloads.selectWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::selectWith_target;
            this.payloads.reject = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::reject;
            this.payloads.rejectWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collect;
            this.payloads.collectBoolean = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectByte;
            this.payloads.collectChar = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectInt;
            this.payloads.collectLong = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectLong;
            this.payloads.collectShort = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::flatCollect;
            this.payloads.detect = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::min;
            this.payloads.max = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::max;
            this.payloads.min_without_comparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::minBy;
            this.payloads.maxBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::maxBy;
            this.payloads.detectWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::count;
            this.payloads.countWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::countWith;
            this.payloads.collectIf = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectIf;
            this.payloads.collectWith = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::getFirst;
            this.payloads.getLast = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::getLast;
            this.payloads.isEmpty = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::isEmpty;
            this.payloads.iterator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::sumLong;
            this.payloads.toArray = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toArray;
            this.payloads.partition = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::partition;
            this.payloads.toList = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toList;
            this.payloads.toBag = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSet;
            this.payloads.toMap = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::testToString;
            this.payloads.makeString = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::groupByEach;
            this.payloads.zip = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::empty;
            this.payloads.notEmpty = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ObjectByteHashMapWithHashingStrategyKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
