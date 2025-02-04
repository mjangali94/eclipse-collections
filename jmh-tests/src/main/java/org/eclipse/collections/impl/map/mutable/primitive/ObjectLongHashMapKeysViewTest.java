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
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapKeysViewTestCase;

/**
 * JUnit test for {@link ObjectLongHashMap#keysView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeysViewTest.stg.
 */
public class ObjectLongHashMapKeysViewTest extends AbstractObjectLongMapKeysViewTestCase {

    @Override
    public <T> ObjectLongHashMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectLongHashMap<T> map = new ObjectLongHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectLongHashMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ObjectLongHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectLongHashMapKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ObjectLongHashMapKeysViewTest::toArray;
            this.payloads.contains = ObjectLongHashMapKeysViewTest::contains;
            this.payloads.containsAllIterable = ObjectLongHashMapKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ObjectLongHashMapKeysViewTest::containsAllArray;
            this.payloads.select = ObjectLongHashMapKeysViewTest::select;
            this.payloads.selectWith = ObjectLongHashMapKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ObjectLongHashMapKeysViewTest::selectWithTarget;
            this.payloads.reject = ObjectLongHashMapKeysViewTest::reject;
            this.payloads.rejectWith = ObjectLongHashMapKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ObjectLongHashMapKeysViewTest::rejectWithTarget;
            this.payloads.partition = ObjectLongHashMapKeysViewTest::partition;
            this.payloads.partitionWith = ObjectLongHashMapKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ObjectLongHashMapKeysViewTest::selectInstancesOf;
            this.payloads.collect = ObjectLongHashMapKeysViewTest::collect;
            this.payloads.collectBoolean = ObjectLongHashMapKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ObjectLongHashMapKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ObjectLongHashMapKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ObjectLongHashMapKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ObjectLongHashMapKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ObjectLongHashMapKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ObjectLongHashMapKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ObjectLongHashMapKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ObjectLongHashMapKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ObjectLongHashMapKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ObjectLongHashMapKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ObjectLongHashMapKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ObjectLongHashMapKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ObjectLongHashMapKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ObjectLongHashMapKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ObjectLongHashMapKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ObjectLongHashMapKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ObjectLongHashMapKeysViewTest::collectWithTarget;
            this.payloads.take = ObjectLongHashMapKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ObjectLongHashMapKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ObjectLongHashMapKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ObjectLongHashMapKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ObjectLongHashMapKeysViewTest::detect;
            this.payloads.detectWith = ObjectLongHashMapKeysViewTest::detectWith;
            this.payloads.detectOptional = ObjectLongHashMapKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ObjectLongHashMapKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ObjectLongHashMapKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ObjectLongHashMapKeysViewTest::min;
            this.payloads.max = ObjectLongHashMapKeysViewTest::max;
            this.payloads.minBy = ObjectLongHashMapKeysViewTest::minBy;
            this.payloads.maxBy = ObjectLongHashMapKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ObjectLongHashMapKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ObjectLongHashMapKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ObjectLongHashMapKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ObjectLongHashMapKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ObjectLongHashMapKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ObjectLongHashMapKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ObjectLongHashMapKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ObjectLongHashMapKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ObjectLongHashMapKeysViewTest::noneSatisfyWith;
            this.payloads.count = ObjectLongHashMapKeysViewTest::count;
            this.payloads.collectIf = ObjectLongHashMapKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ObjectLongHashMapKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ObjectLongHashMapKeysViewTest::getFirst;
            this.payloads.getLast = ObjectLongHashMapKeysViewTest::getLast;
            this.payloads.getOnly = ObjectLongHashMapKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ObjectLongHashMapKeysViewTest::isEmpty;
            this.payloads.injectInto = ObjectLongHashMapKeysViewTest::injectInto;
            this.payloads.toList = ObjectLongHashMapKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ObjectLongHashMapKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ObjectLongHashMapKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ObjectLongHashMapKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ObjectLongHashMapKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ObjectLongHashMapKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ObjectLongHashMapKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ObjectLongHashMapKeysViewTest::toSet;
            this.payloads.toMap = ObjectLongHashMapKeysViewTest::toMap;
            this.payloads.toSortedMap = ObjectLongHashMapKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ObjectLongHashMapKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ObjectLongHashMapKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ObjectLongHashMapKeysViewTest::testToString;
            this.payloads.makeString = ObjectLongHashMapKeysViewTest::makeString;
            this.payloads.appendString = ObjectLongHashMapKeysViewTest::appendString;
            this.payloads.groupBy = ObjectLongHashMapKeysViewTest::groupBy;
            this.payloads.groupByEach = ObjectLongHashMapKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ObjectLongHashMapKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ObjectLongHashMapKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ObjectLongHashMapKeysViewTest::zip;
            this.payloads.zipWithIndex = ObjectLongHashMapKeysViewTest::zipWithIndex;
            this.payloads.chunk = ObjectLongHashMapKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectLongHashMapKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ObjectLongHashMapKeysViewTest::chunk_large_size;
            this.payloads.tap = ObjectLongHashMapKeysViewTest::tap;
            this.payloads.asLazy = ObjectLongHashMapKeysViewTest::asLazy;
            this.payloads.flatCollect = ObjectLongHashMapKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ObjectLongHashMapKeysViewTest::flatCollectWith;
            this.payloads.distinct = ObjectLongHashMapKeysViewTest::distinct;
            this.payloads.iterator = ObjectLongHashMapKeysViewTest::iterator;
        }
    }
}
