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

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapKeysViewTestCase;

/**
 * JUnit test for {@link ObjectCharHashMapWithHashingStrategy#keysView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeysViewTest.stg.
 */
public class ObjectCharHashMapWithHashingStrategyKeysViewTest extends AbstractObjectCharMapKeysViewTestCase {

    @Override
    public <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3) {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectCharHashMapWithHashingStrategy<T> map = new ObjectCharHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()));
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (char) i);
        }
        return map.keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharHashMapWithHashingStrategyKeysViewTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
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
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
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
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListNaturalOrdering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListNaturalOrdering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharHashMapWithHashingStrategyKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapWithHashingStrategyKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ObjectCharHashMapWithHashingStrategyKeysViewTest::toArray;
            this.payloads.contains = ObjectCharHashMapWithHashingStrategyKeysViewTest::contains;
            this.payloads.containsAllIterable = ObjectCharHashMapWithHashingStrategyKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectCharHashMapWithHashingStrategyKeysViewTest::containsAllArray;
            this.payloads.select = ObjectCharHashMapWithHashingStrategyKeysViewTest::select;
            this.payloads.selectWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::selectWithTarget;
            this.payloads.reject = ObjectCharHashMapWithHashingStrategyKeysViewTest::reject;
            this.payloads.rejectWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::rejectWithTarget;
            this.payloads.partition = ObjectCharHashMapWithHashingStrategyKeysViewTest::partition;
            this.payloads.partitionWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ObjectCharHashMapWithHashingStrategyKeysViewTest::selectInstancesOf;
            this.payloads.collect = ObjectCharHashMapWithHashingStrategyKeysViewTest::collect;
            this.payloads.collectBoolean = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectWithTarget;
            this.payloads.take = ObjectCharHashMapWithHashingStrategyKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ObjectCharHashMapWithHashingStrategyKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ObjectCharHashMapWithHashingStrategyKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ObjectCharHashMapWithHashingStrategyKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ObjectCharHashMapWithHashingStrategyKeysViewTest::detect;
            this.payloads.detectWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::detectWith;
            this.payloads.detectOptional = ObjectCharHashMapWithHashingStrategyKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ObjectCharHashMapWithHashingStrategyKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ObjectCharHashMapWithHashingStrategyKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ObjectCharHashMapWithHashingStrategyKeysViewTest::min;
            this.payloads.max = ObjectCharHashMapWithHashingStrategyKeysViewTest::max;
            this.payloads.minBy = ObjectCharHashMapWithHashingStrategyKeysViewTest::minBy;
            this.payloads.maxBy = ObjectCharHashMapWithHashingStrategyKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ObjectCharHashMapWithHashingStrategyKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectCharHashMapWithHashingStrategyKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ObjectCharHashMapWithHashingStrategyKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ObjectCharHashMapWithHashingStrategyKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ObjectCharHashMapWithHashingStrategyKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectCharHashMapWithHashingStrategyKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::noneSatisfyWith;
            this.payloads.count = ObjectCharHashMapWithHashingStrategyKeysViewTest::count;
            this.payloads.collectIf = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ObjectCharHashMapWithHashingStrategyKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ObjectCharHashMapWithHashingStrategyKeysViewTest::getFirst;
            this.payloads.getLast = ObjectCharHashMapWithHashingStrategyKeysViewTest::getLast;
            this.payloads.getOnly = ObjectCharHashMapWithHashingStrategyKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ObjectCharHashMapWithHashingStrategyKeysViewTest::isEmpty;
            this.payloads.injectInto = ObjectCharHashMapWithHashingStrategyKeysViewTest::injectInto;
            this.payloads.toList = ObjectCharHashMapWithHashingStrategyKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSet;
            this.payloads.toMap = ObjectCharHashMapWithHashingStrategyKeysViewTest::toMap;
            this.payloads.toSortedMap = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectCharHashMapWithHashingStrategyKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectCharHashMapWithHashingStrategyKeysViewTest::testToString;
            this.payloads.makeString = ObjectCharHashMapWithHashingStrategyKeysViewTest::makeString;
            this.payloads.appendString = ObjectCharHashMapWithHashingStrategyKeysViewTest::appendString;
            this.payloads.groupBy = ObjectCharHashMapWithHashingStrategyKeysViewTest::groupBy;
            this.payloads.groupByEach = ObjectCharHashMapWithHashingStrategyKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ObjectCharHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ObjectCharHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ObjectCharHashMapWithHashingStrategyKeysViewTest::zip;
            this.payloads.zipWithIndex = ObjectCharHashMapWithHashingStrategyKeysViewTest::zipWithIndex;
            this.payloads.chunk = ObjectCharHashMapWithHashingStrategyKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapWithHashingStrategyKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectCharHashMapWithHashingStrategyKeysViewTest::chunk_large_size;
            this.payloads.tap = ObjectCharHashMapWithHashingStrategyKeysViewTest::tap;
            this.payloads.asLazy = ObjectCharHashMapWithHashingStrategyKeysViewTest::asLazy;
            this.payloads.flatCollect = ObjectCharHashMapWithHashingStrategyKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ObjectCharHashMapWithHashingStrategyKeysViewTest::flatCollectWith;
            this.payloads.distinct = ObjectCharHashMapWithHashingStrategyKeysViewTest::distinct;
            this.payloads.iterator = ObjectCharHashMapWithHashingStrategyKeysViewTest::iterator;
        }
    }
}
