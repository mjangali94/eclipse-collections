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
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectFloatMapKeysViewTestCase;

/**
 * JUnit test for {@link UnmodifiableObjectFloatMap#keysView()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeysViewTest.stg.
 */
public class UnmodifiableObjectFloatMapKeysViewTest extends AbstractObjectFloatMapKeysViewTestCase {

    @Override
    public <T> MutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3) {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        MutableObjectFloatMap<T> map = ObjectFloatHashMap.newMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asUnmodifiable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableObjectFloatMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableObjectFloatMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectFloatMapKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnmodifiableObjectFloatMapKeysViewTest::toArray;
            this.payloads.contains = UnmodifiableObjectFloatMapKeysViewTest::contains;
            this.payloads.containsAllIterable = UnmodifiableObjectFloatMapKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableObjectFloatMapKeysViewTest::containsAllArray;
            this.payloads.select = UnmodifiableObjectFloatMapKeysViewTest::select;
            this.payloads.selectWith = UnmodifiableObjectFloatMapKeysViewTest::selectWith;
            this.payloads.selectWithTarget = UnmodifiableObjectFloatMapKeysViewTest::selectWithTarget;
            this.payloads.reject = UnmodifiableObjectFloatMapKeysViewTest::reject;
            this.payloads.rejectWith = UnmodifiableObjectFloatMapKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = UnmodifiableObjectFloatMapKeysViewTest::rejectWithTarget;
            this.payloads.partition = UnmodifiableObjectFloatMapKeysViewTest::partition;
            this.payloads.partitionWith = UnmodifiableObjectFloatMapKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = UnmodifiableObjectFloatMapKeysViewTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableObjectFloatMapKeysViewTest::collect;
            this.payloads.collectBoolean = UnmodifiableObjectFloatMapKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnmodifiableObjectFloatMapKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = UnmodifiableObjectFloatMapKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = UnmodifiableObjectFloatMapKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnmodifiableObjectFloatMapKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = UnmodifiableObjectFloatMapKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = UnmodifiableObjectFloatMapKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = UnmodifiableObjectFloatMapKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = UnmodifiableObjectFloatMapKeysViewTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectWithTarget;
            this.payloads.take = UnmodifiableObjectFloatMapKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = UnmodifiableObjectFloatMapKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = UnmodifiableObjectFloatMapKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = UnmodifiableObjectFloatMapKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = UnmodifiableObjectFloatMapKeysViewTest::detect;
            this.payloads.detectWith = UnmodifiableObjectFloatMapKeysViewTest::detectWith;
            this.payloads.detectOptional = UnmodifiableObjectFloatMapKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = UnmodifiableObjectFloatMapKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = UnmodifiableObjectFloatMapKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnmodifiableObjectFloatMapKeysViewTest::min;
            this.payloads.max = UnmodifiableObjectFloatMapKeysViewTest::max;
            this.payloads.minBy = UnmodifiableObjectFloatMapKeysViewTest::minBy;
            this.payloads.maxBy = UnmodifiableObjectFloatMapKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableObjectFloatMapKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableObjectFloatMapKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = UnmodifiableObjectFloatMapKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = UnmodifiableObjectFloatMapKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableObjectFloatMapKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableObjectFloatMapKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableObjectFloatMapKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableObjectFloatMapKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableObjectFloatMapKeysViewTest::noneSatisfyWith;
            this.payloads.count = UnmodifiableObjectFloatMapKeysViewTest::count;
            this.payloads.collectIf = UnmodifiableObjectFloatMapKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = UnmodifiableObjectFloatMapKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = UnmodifiableObjectFloatMapKeysViewTest::getFirst;
            this.payloads.getLast = UnmodifiableObjectFloatMapKeysViewTest::getLast;
            this.payloads.getOnly = UnmodifiableObjectFloatMapKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableObjectFloatMapKeysViewTest::isEmpty;
            this.payloads.injectInto = UnmodifiableObjectFloatMapKeysViewTest::injectInto;
            this.payloads.toList = UnmodifiableObjectFloatMapKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = UnmodifiableObjectFloatMapKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = UnmodifiableObjectFloatMapKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = UnmodifiableObjectFloatMapKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = UnmodifiableObjectFloatMapKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = UnmodifiableObjectFloatMapKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableObjectFloatMapKeysViewTest::toSortedSetBy;
            this.payloads.toSet = UnmodifiableObjectFloatMapKeysViewTest::toSet;
            this.payloads.toMap = UnmodifiableObjectFloatMapKeysViewTest::toMap;
            this.payloads.toSortedMap = UnmodifiableObjectFloatMapKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableObjectFloatMapKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableObjectFloatMapKeysViewTest::toSortedMapBy;
            this.payloads.testToString = UnmodifiableObjectFloatMapKeysViewTest::testToString;
            this.payloads.makeString = UnmodifiableObjectFloatMapKeysViewTest::makeString;
            this.payloads.appendString = UnmodifiableObjectFloatMapKeysViewTest::appendString;
            this.payloads.groupBy = UnmodifiableObjectFloatMapKeysViewTest::groupBy;
            this.payloads.groupByEach = UnmodifiableObjectFloatMapKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableObjectFloatMapKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableObjectFloatMapKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = UnmodifiableObjectFloatMapKeysViewTest::zip;
            this.payloads.zipWithIndex = UnmodifiableObjectFloatMapKeysViewTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableObjectFloatMapKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectFloatMapKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableObjectFloatMapKeysViewTest::chunk_large_size;
            this.payloads.tap = UnmodifiableObjectFloatMapKeysViewTest::tap;
            this.payloads.asLazy = UnmodifiableObjectFloatMapKeysViewTest::asLazy;
            this.payloads.flatCollect = UnmodifiableObjectFloatMapKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableObjectFloatMapKeysViewTest::flatCollectWith;
            this.payloads.distinct = UnmodifiableObjectFloatMapKeysViewTest::distinct;
            this.payloads.iterator = UnmodifiableObjectFloatMapKeysViewTest::iterator;
        }
    }
}
