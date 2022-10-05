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
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectByteMapKeysViewTestCase;

/**
 * JUnit test for {@link UnmodifiableObjectByteMap#keysView()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeysViewTest.stg.
 */
public class UnmodifiableObjectByteMapKeysViewTest extends AbstractObjectByteMapKeysViewTestCase {

    @Override
    public <T> MutableObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3) {
        return ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        MutableObjectByteMap<T> map = ObjectByteHashMap.newMap();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (byte) i);
        }
        return map.asUnmodifiable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableObjectByteMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableObjectByteMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableObjectByteMapKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnmodifiableObjectByteMapKeysViewTest::toArray;
            this.payloads.contains = UnmodifiableObjectByteMapKeysViewTest::contains;
            this.payloads.containsAllIterable = UnmodifiableObjectByteMapKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableObjectByteMapKeysViewTest::containsAllArray;
            this.payloads.select = UnmodifiableObjectByteMapKeysViewTest::select;
            this.payloads.selectWith = UnmodifiableObjectByteMapKeysViewTest::selectWith;
            this.payloads.selectWithTarget = UnmodifiableObjectByteMapKeysViewTest::selectWithTarget;
            this.payloads.reject = UnmodifiableObjectByteMapKeysViewTest::reject;
            this.payloads.rejectWith = UnmodifiableObjectByteMapKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = UnmodifiableObjectByteMapKeysViewTest::rejectWithTarget;
            this.payloads.partition = UnmodifiableObjectByteMapKeysViewTest::partition;
            this.payloads.partitionWith = UnmodifiableObjectByteMapKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = UnmodifiableObjectByteMapKeysViewTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableObjectByteMapKeysViewTest::collect;
            this.payloads.collectBoolean = UnmodifiableObjectByteMapKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = UnmodifiableObjectByteMapKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = UnmodifiableObjectByteMapKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = UnmodifiableObjectByteMapKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = UnmodifiableObjectByteMapKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = UnmodifiableObjectByteMapKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = UnmodifiableObjectByteMapKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = UnmodifiableObjectByteMapKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = UnmodifiableObjectByteMapKeysViewTest::collectWith;
            this.payloads.collectWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectWithTarget;
            this.payloads.take = UnmodifiableObjectByteMapKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = UnmodifiableObjectByteMapKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = UnmodifiableObjectByteMapKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = UnmodifiableObjectByteMapKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = UnmodifiableObjectByteMapKeysViewTest::detect;
            this.payloads.detectWith = UnmodifiableObjectByteMapKeysViewTest::detectWith;
            this.payloads.detectOptional = UnmodifiableObjectByteMapKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = UnmodifiableObjectByteMapKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = UnmodifiableObjectByteMapKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = UnmodifiableObjectByteMapKeysViewTest::min;
            this.payloads.max = UnmodifiableObjectByteMapKeysViewTest::max;
            this.payloads.minBy = UnmodifiableObjectByteMapKeysViewTest::minBy;
            this.payloads.maxBy = UnmodifiableObjectByteMapKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = UnmodifiableObjectByteMapKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableObjectByteMapKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = UnmodifiableObjectByteMapKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = UnmodifiableObjectByteMapKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableObjectByteMapKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableObjectByteMapKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableObjectByteMapKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableObjectByteMapKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableObjectByteMapKeysViewTest::noneSatisfyWith;
            this.payloads.count = UnmodifiableObjectByteMapKeysViewTest::count;
            this.payloads.collectIf = UnmodifiableObjectByteMapKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = UnmodifiableObjectByteMapKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = UnmodifiableObjectByteMapKeysViewTest::getFirst;
            this.payloads.getLast = UnmodifiableObjectByteMapKeysViewTest::getLast;
            this.payloads.getOnly = UnmodifiableObjectByteMapKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = UnmodifiableObjectByteMapKeysViewTest::isEmpty;
            this.payloads.injectInto = UnmodifiableObjectByteMapKeysViewTest::injectInto;
            this.payloads.toList = UnmodifiableObjectByteMapKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = UnmodifiableObjectByteMapKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = UnmodifiableObjectByteMapKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = UnmodifiableObjectByteMapKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = UnmodifiableObjectByteMapKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = UnmodifiableObjectByteMapKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableObjectByteMapKeysViewTest::toSortedSetBy;
            this.payloads.toSet = UnmodifiableObjectByteMapKeysViewTest::toSet;
            this.payloads.toMap = UnmodifiableObjectByteMapKeysViewTest::toMap;
            this.payloads.toSortedMap = UnmodifiableObjectByteMapKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableObjectByteMapKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableObjectByteMapKeysViewTest::toSortedMapBy;
            this.payloads.testToString = UnmodifiableObjectByteMapKeysViewTest::testToString;
            this.payloads.makeString = UnmodifiableObjectByteMapKeysViewTest::makeString;
            this.payloads.appendString = UnmodifiableObjectByteMapKeysViewTest::appendString;
            this.payloads.groupBy = UnmodifiableObjectByteMapKeysViewTest::groupBy;
            this.payloads.groupByEach = UnmodifiableObjectByteMapKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableObjectByteMapKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = UnmodifiableObjectByteMapKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = UnmodifiableObjectByteMapKeysViewTest::zip;
            this.payloads.zipWithIndex = UnmodifiableObjectByteMapKeysViewTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableObjectByteMapKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableObjectByteMapKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableObjectByteMapKeysViewTest::chunk_large_size;
            this.payloads.tap = UnmodifiableObjectByteMapKeysViewTest::tap;
            this.payloads.asLazy = UnmodifiableObjectByteMapKeysViewTest::asLazy;
            this.payloads.flatCollect = UnmodifiableObjectByteMapKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = UnmodifiableObjectByteMapKeysViewTest::flatCollectWith;
            this.payloads.distinct = UnmodifiableObjectByteMapKeysViewTest::distinct;
            this.payloads.iterator = UnmodifiableObjectByteMapKeysViewTest::iterator;
        }
    }
}
