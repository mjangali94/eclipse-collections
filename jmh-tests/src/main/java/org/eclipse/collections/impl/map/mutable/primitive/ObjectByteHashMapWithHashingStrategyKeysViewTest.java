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
import org.eclipse.collections.impl.map.primitive.AbstractObjectByteMapKeysViewTestCase;

/**
 * JUnit test for {@link ObjectByteHashMapWithHashingStrategy#keysView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeysViewTest.stg.
 */
public class ObjectByteHashMapWithHashingStrategyKeysViewTest extends AbstractObjectByteMapKeysViewTestCase {

    @Override
    public <T> ObjectByteHashMapWithHashingStrategy<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectByteHashMapWithHashingStrategy<T> map = new ObjectByteHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()));
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (byte) i);
        }
        return map.keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectByteHashMapWithHashingStrategyKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectByteHashMapWithHashingStrategyKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapWithHashingStrategyKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ObjectByteHashMapWithHashingStrategyKeysViewTest::toArray;
            this.payloads.contains = ObjectByteHashMapWithHashingStrategyKeysViewTest::contains;
            this.payloads.containsAllIterable = ObjectByteHashMapWithHashingStrategyKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectByteHashMapWithHashingStrategyKeysViewTest::containsAllArray;
            this.payloads.select = ObjectByteHashMapWithHashingStrategyKeysViewTest::select;
            this.payloads.selectWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::selectWithTarget;
            this.payloads.reject = ObjectByteHashMapWithHashingStrategyKeysViewTest::reject;
            this.payloads.rejectWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::rejectWithTarget;
            this.payloads.partition = ObjectByteHashMapWithHashingStrategyKeysViewTest::partition;
            this.payloads.partitionWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ObjectByteHashMapWithHashingStrategyKeysViewTest::selectInstancesOf;
            this.payloads.collect = ObjectByteHashMapWithHashingStrategyKeysViewTest::collect;
            this.payloads.collectBoolean = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectWithTarget;
            this.payloads.take = ObjectByteHashMapWithHashingStrategyKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ObjectByteHashMapWithHashingStrategyKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ObjectByteHashMapWithHashingStrategyKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ObjectByteHashMapWithHashingStrategyKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ObjectByteHashMapWithHashingStrategyKeysViewTest::detect;
            this.payloads.detectWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::detectWith;
            this.payloads.detectOptional = ObjectByteHashMapWithHashingStrategyKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ObjectByteHashMapWithHashingStrategyKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ObjectByteHashMapWithHashingStrategyKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ObjectByteHashMapWithHashingStrategyKeysViewTest::min;
            this.payloads.max = ObjectByteHashMapWithHashingStrategyKeysViewTest::max;
            this.payloads.minBy = ObjectByteHashMapWithHashingStrategyKeysViewTest::minBy;
            this.payloads.maxBy = ObjectByteHashMapWithHashingStrategyKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ObjectByteHashMapWithHashingStrategyKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectByteHashMapWithHashingStrategyKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ObjectByteHashMapWithHashingStrategyKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ObjectByteHashMapWithHashingStrategyKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ObjectByteHashMapWithHashingStrategyKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectByteHashMapWithHashingStrategyKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::noneSatisfyWith;
            this.payloads.count = ObjectByteHashMapWithHashingStrategyKeysViewTest::count;
            this.payloads.collectIf = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ObjectByteHashMapWithHashingStrategyKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ObjectByteHashMapWithHashingStrategyKeysViewTest::getFirst;
            this.payloads.getLast = ObjectByteHashMapWithHashingStrategyKeysViewTest::getLast;
            this.payloads.getOnly = ObjectByteHashMapWithHashingStrategyKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ObjectByteHashMapWithHashingStrategyKeysViewTest::isEmpty;
            this.payloads.injectInto = ObjectByteHashMapWithHashingStrategyKeysViewTest::injectInto;
            this.payloads.toList = ObjectByteHashMapWithHashingStrategyKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSet;
            this.payloads.toMap = ObjectByteHashMapWithHashingStrategyKeysViewTest::toMap;
            this.payloads.toSortedMap = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectByteHashMapWithHashingStrategyKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectByteHashMapWithHashingStrategyKeysViewTest::testToString;
            this.payloads.makeString = ObjectByteHashMapWithHashingStrategyKeysViewTest::makeString;
            this.payloads.appendString = ObjectByteHashMapWithHashingStrategyKeysViewTest::appendString;
            this.payloads.groupBy = ObjectByteHashMapWithHashingStrategyKeysViewTest::groupBy;
            this.payloads.groupByEach = ObjectByteHashMapWithHashingStrategyKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ObjectByteHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ObjectByteHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ObjectByteHashMapWithHashingStrategyKeysViewTest::zip;
            this.payloads.zipWithIndex = ObjectByteHashMapWithHashingStrategyKeysViewTest::zipWithIndex;
            this.payloads.chunk = ObjectByteHashMapWithHashingStrategyKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapWithHashingStrategyKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectByteHashMapWithHashingStrategyKeysViewTest::chunk_large_size;
            this.payloads.tap = ObjectByteHashMapWithHashingStrategyKeysViewTest::tap;
            this.payloads.asLazy = ObjectByteHashMapWithHashingStrategyKeysViewTest::asLazy;
            this.payloads.flatCollect = ObjectByteHashMapWithHashingStrategyKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ObjectByteHashMapWithHashingStrategyKeysViewTest::flatCollectWith;
            this.payloads.distinct = ObjectByteHashMapWithHashingStrategyKeysViewTest::distinct;
            this.payloads.iterator = ObjectByteHashMapWithHashingStrategyKeysViewTest::iterator;
        }
    }
}
