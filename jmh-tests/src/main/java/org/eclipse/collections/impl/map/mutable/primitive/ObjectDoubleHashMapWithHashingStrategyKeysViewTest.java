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
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapKeysViewTestCase;

/**
 * JUnit test for {@link ObjectDoubleHashMapWithHashingStrategy#keysView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeysViewTest.stg.
 */
public class ObjectDoubleHashMapWithHashingStrategyKeysViewTest extends AbstractObjectDoubleMapKeysViewTestCase {

    @Override
    public <T> ObjectDoubleHashMapWithHashingStrategy<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3) {
        return ObjectDoubleHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectDoubleHashMapWithHashingStrategy<T> map = new ObjectDoubleHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()));
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectDoubleHashMapWithHashingStrategyKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectDoubleHashMapWithHashingStrategyKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapWithHashingStrategyKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toArray;
            this.payloads.contains = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::contains;
            this.payloads.containsAllIterable = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::containsAllArray;
            this.payloads.select = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::select;
            this.payloads.selectWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::selectWithTarget;
            this.payloads.reject = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::reject;
            this.payloads.rejectWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::rejectWithTarget;
            this.payloads.partition = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::partition;
            this.payloads.partitionWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::selectInstancesOf;
            this.payloads.collect = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collect;
            this.payloads.collectBoolean = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectWithTarget;
            this.payloads.take = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::detect;
            this.payloads.detectWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::detectWith;
            this.payloads.detectOptional = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::min;
            this.payloads.max = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::max;
            this.payloads.minBy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::minBy;
            this.payloads.maxBy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::noneSatisfyWith;
            this.payloads.count = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::count;
            this.payloads.collectIf = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::getFirst;
            this.payloads.getLast = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::getLast;
            this.payloads.getOnly = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::isEmpty;
            this.payloads.injectInto = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::injectInto;
            this.payloads.toList = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSet;
            this.payloads.toMap = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toMap;
            this.payloads.toSortedMap = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::testToString;
            this.payloads.makeString = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::makeString;
            this.payloads.appendString = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::appendString;
            this.payloads.groupBy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::groupBy;
            this.payloads.groupByEach = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::zip;
            this.payloads.zipWithIndex = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::zipWithIndex;
            this.payloads.chunk = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapWithHashingStrategyKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::chunk_large_size;
            this.payloads.tap = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::tap;
            this.payloads.asLazy = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::asLazy;
            this.payloads.flatCollect = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::flatCollectWith;
            this.payloads.distinct = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::distinct;
            this.payloads.iterator = ObjectDoubleHashMapWithHashingStrategyKeysViewTest::iterator;
        }
    }
}
