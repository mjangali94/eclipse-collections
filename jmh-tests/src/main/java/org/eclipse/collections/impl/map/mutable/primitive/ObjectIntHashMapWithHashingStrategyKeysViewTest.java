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
import org.eclipse.collections.impl.map.primitive.AbstractObjectIntMapKeysViewTestCase;

/**
 * JUnit test for {@link ObjectIntHashMapWithHashingStrategy#keysView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeysViewTest.stg.
 */
public class ObjectIntHashMapWithHashingStrategyKeysViewTest extends AbstractObjectIntMapKeysViewTestCase {

    @Override
    public <T> ObjectIntHashMapWithHashingStrategy<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3) {
        return ObjectIntHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectIntHashMapWithHashingStrategy<T> map = new ObjectIntHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()));
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntHashMapWithHashingStrategyKeysViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_takeWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.takeWhile_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dropWhile_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dropWhile_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIfWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIfWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_throws_when_multiple_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_throws_when_multiple_values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListNaturalOrdering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListNaturalOrdering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMapBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_zero_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_large_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntHashMapWithHashingStrategyKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapWithHashingStrategyKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ObjectIntHashMapWithHashingStrategyKeysViewTest::toArray;
            this.payloads.contains = ObjectIntHashMapWithHashingStrategyKeysViewTest::contains;
            this.payloads.containsAllIterable = ObjectIntHashMapWithHashingStrategyKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectIntHashMapWithHashingStrategyKeysViewTest::containsAllArray;
            this.payloads.select = ObjectIntHashMapWithHashingStrategyKeysViewTest::select;
            this.payloads.selectWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::selectWithTarget;
            this.payloads.reject = ObjectIntHashMapWithHashingStrategyKeysViewTest::reject;
            this.payloads.rejectWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::rejectWithTarget;
            this.payloads.partition = ObjectIntHashMapWithHashingStrategyKeysViewTest::partition;
            this.payloads.partitionWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ObjectIntHashMapWithHashingStrategyKeysViewTest::selectInstancesOf;
            this.payloads.collect = ObjectIntHashMapWithHashingStrategyKeysViewTest::collect;
            this.payloads.collectBoolean = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectWithTarget;
            this.payloads.take = ObjectIntHashMapWithHashingStrategyKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ObjectIntHashMapWithHashingStrategyKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ObjectIntHashMapWithHashingStrategyKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ObjectIntHashMapWithHashingStrategyKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ObjectIntHashMapWithHashingStrategyKeysViewTest::detect;
            this.payloads.detectWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::detectWith;
            this.payloads.detectOptional = ObjectIntHashMapWithHashingStrategyKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ObjectIntHashMapWithHashingStrategyKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ObjectIntHashMapWithHashingStrategyKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ObjectIntHashMapWithHashingStrategyKeysViewTest::min;
            this.payloads.max = ObjectIntHashMapWithHashingStrategyKeysViewTest::max;
            this.payloads.minBy = ObjectIntHashMapWithHashingStrategyKeysViewTest::minBy;
            this.payloads.maxBy = ObjectIntHashMapWithHashingStrategyKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ObjectIntHashMapWithHashingStrategyKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectIntHashMapWithHashingStrategyKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ObjectIntHashMapWithHashingStrategyKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ObjectIntHashMapWithHashingStrategyKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ObjectIntHashMapWithHashingStrategyKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectIntHashMapWithHashingStrategyKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::noneSatisfyWith;
            this.payloads.count = ObjectIntHashMapWithHashingStrategyKeysViewTest::count;
            this.payloads.collectIf = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ObjectIntHashMapWithHashingStrategyKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ObjectIntHashMapWithHashingStrategyKeysViewTest::getFirst;
            this.payloads.getLast = ObjectIntHashMapWithHashingStrategyKeysViewTest::getLast;
            this.payloads.getOnly = ObjectIntHashMapWithHashingStrategyKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ObjectIntHashMapWithHashingStrategyKeysViewTest::isEmpty;
            this.payloads.injectInto = ObjectIntHashMapWithHashingStrategyKeysViewTest::injectInto;
            this.payloads.toList = ObjectIntHashMapWithHashingStrategyKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSet;
            this.payloads.toMap = ObjectIntHashMapWithHashingStrategyKeysViewTest::toMap;
            this.payloads.toSortedMap = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectIntHashMapWithHashingStrategyKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectIntHashMapWithHashingStrategyKeysViewTest::testToString;
            this.payloads.makeString = ObjectIntHashMapWithHashingStrategyKeysViewTest::makeString;
            this.payloads.appendString = ObjectIntHashMapWithHashingStrategyKeysViewTest::appendString;
            this.payloads.groupBy = ObjectIntHashMapWithHashingStrategyKeysViewTest::groupBy;
            this.payloads.groupByEach = ObjectIntHashMapWithHashingStrategyKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ObjectIntHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ObjectIntHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ObjectIntHashMapWithHashingStrategyKeysViewTest::zip;
            this.payloads.zipWithIndex = ObjectIntHashMapWithHashingStrategyKeysViewTest::zipWithIndex;
            this.payloads.chunk = ObjectIntHashMapWithHashingStrategyKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapWithHashingStrategyKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectIntHashMapWithHashingStrategyKeysViewTest::chunk_large_size;
            this.payloads.tap = ObjectIntHashMapWithHashingStrategyKeysViewTest::tap;
            this.payloads.asLazy = ObjectIntHashMapWithHashingStrategyKeysViewTest::asLazy;
            this.payloads.flatCollect = ObjectIntHashMapWithHashingStrategyKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ObjectIntHashMapWithHashingStrategyKeysViewTest::flatCollectWith;
            this.payloads.distinct = ObjectIntHashMapWithHashingStrategyKeysViewTest::distinct;
            this.payloads.iterator = ObjectIntHashMapWithHashingStrategyKeysViewTest::iterator;
        }
    }
}
