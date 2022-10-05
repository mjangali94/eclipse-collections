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
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapKeysViewTestCase;

/**
 * JUnit test for {@link UnmodifiableObjectDoubleMap#keysView()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeysViewTest.stg.
 */
public class UnmodifiableObjectDoubleMapKeysViewTest extends AbstractObjectDoubleMapKeysViewTestCase {

    @Override
    public <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        MutableObjectDoubleMap<T> map = ObjectDoubleHashMap.newMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.asUnmodifiable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableObjectDoubleMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableObjectDoubleMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectDoubleMapKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnmodifiableObjectDoubleMapKeysViewTest::toArray;
            this.payloads.contains = UnmodifiableObjectDoubleMapKeysViewTest::contains;
            this.payloads.containsAllIterable = UnmodifiableObjectDoubleMapKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableObjectDoubleMapKeysViewTest::containsAllArray;
            this.payloads.select = UnmodifiableObjectDoubleMapKeysViewTest::select;
            this.payloads.selectWith = UnmodifiableObjectDoubleMapKeysViewTest::selectWith;
            this.payloads.selectWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::selectWithTarget;
            this.payloads.reject = UnmodifiableObjectDoubleMapKeysViewTest::reject;
            this.payloads.rejectWith = UnmodifiableObjectDoubleMapKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::rejectWithTarget;
            this.payloads.partition = UnmodifiableObjectDoubleMapKeysViewTest::partition;
            this.payloads.partitionWith = UnmodifiableObjectDoubleMapKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = UnmodifiableObjectDoubleMapKeysViewTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableObjectDoubleMapKeysViewTest::collect;
            this.payloads.collectBoolean = UnmodifiableObjectDoubleMapKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnmodifiableObjectDoubleMapKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = UnmodifiableObjectDoubleMapKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = UnmodifiableObjectDoubleMapKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnmodifiableObjectDoubleMapKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = UnmodifiableObjectDoubleMapKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = UnmodifiableObjectDoubleMapKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = UnmodifiableObjectDoubleMapKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = UnmodifiableObjectDoubleMapKeysViewTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectWithTarget;
            this.payloads.take = UnmodifiableObjectDoubleMapKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = UnmodifiableObjectDoubleMapKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = UnmodifiableObjectDoubleMapKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = UnmodifiableObjectDoubleMapKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = UnmodifiableObjectDoubleMapKeysViewTest::detect;
            this.payloads.detectWith = UnmodifiableObjectDoubleMapKeysViewTest::detectWith;
            this.payloads.detectOptional = UnmodifiableObjectDoubleMapKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = UnmodifiableObjectDoubleMapKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = UnmodifiableObjectDoubleMapKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnmodifiableObjectDoubleMapKeysViewTest::min;
            this.payloads.max = UnmodifiableObjectDoubleMapKeysViewTest::max;
            this.payloads.minBy = UnmodifiableObjectDoubleMapKeysViewTest::minBy;
            this.payloads.maxBy = UnmodifiableObjectDoubleMapKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableObjectDoubleMapKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableObjectDoubleMapKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = UnmodifiableObjectDoubleMapKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = UnmodifiableObjectDoubleMapKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableObjectDoubleMapKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableObjectDoubleMapKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableObjectDoubleMapKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableObjectDoubleMapKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableObjectDoubleMapKeysViewTest::noneSatisfyWith;
            this.payloads.count = UnmodifiableObjectDoubleMapKeysViewTest::count;
            this.payloads.collectIf = UnmodifiableObjectDoubleMapKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = UnmodifiableObjectDoubleMapKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = UnmodifiableObjectDoubleMapKeysViewTest::getFirst;
            this.payloads.getLast = UnmodifiableObjectDoubleMapKeysViewTest::getLast;
            this.payloads.getOnly = UnmodifiableObjectDoubleMapKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableObjectDoubleMapKeysViewTest::isEmpty;
            this.payloads.injectInto = UnmodifiableObjectDoubleMapKeysViewTest::injectInto;
            this.payloads.toList = UnmodifiableObjectDoubleMapKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = UnmodifiableObjectDoubleMapKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = UnmodifiableObjectDoubleMapKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = UnmodifiableObjectDoubleMapKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = UnmodifiableObjectDoubleMapKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = UnmodifiableObjectDoubleMapKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableObjectDoubleMapKeysViewTest::toSortedSetBy;
            this.payloads.toSet = UnmodifiableObjectDoubleMapKeysViewTest::toSet;
            this.payloads.toMap = UnmodifiableObjectDoubleMapKeysViewTest::toMap;
            this.payloads.toSortedMap = UnmodifiableObjectDoubleMapKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableObjectDoubleMapKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableObjectDoubleMapKeysViewTest::toSortedMapBy;
            this.payloads.testToString = UnmodifiableObjectDoubleMapKeysViewTest::testToString;
            this.payloads.makeString = UnmodifiableObjectDoubleMapKeysViewTest::makeString;
            this.payloads.appendString = UnmodifiableObjectDoubleMapKeysViewTest::appendString;
            this.payloads.groupBy = UnmodifiableObjectDoubleMapKeysViewTest::groupBy;
            this.payloads.groupByEach = UnmodifiableObjectDoubleMapKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableObjectDoubleMapKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableObjectDoubleMapKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = UnmodifiableObjectDoubleMapKeysViewTest::zip;
            this.payloads.zipWithIndex = UnmodifiableObjectDoubleMapKeysViewTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableObjectDoubleMapKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectDoubleMapKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableObjectDoubleMapKeysViewTest::chunk_large_size;
            this.payloads.tap = UnmodifiableObjectDoubleMapKeysViewTest::tap;
            this.payloads.asLazy = UnmodifiableObjectDoubleMapKeysViewTest::asLazy;
            this.payloads.flatCollect = UnmodifiableObjectDoubleMapKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableObjectDoubleMapKeysViewTest::flatCollectWith;
            this.payloads.distinct = UnmodifiableObjectDoubleMapKeysViewTest::distinct;
            this.payloads.iterator = UnmodifiableObjectDoubleMapKeysViewTest::iterator;
        }
    }
}
