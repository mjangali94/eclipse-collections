/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapKeysViewTestCase;

/**
 * JUnit test for {@link ImmutableObjectLongHashMap#keysView()}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapKeysViewTest.stg.
 */
public class ImmutableObjectLongHashMapKeysViewTest extends AbstractObjectLongMapKeysViewTestCase {

    @Override
    public <T> ImmutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectLongHashMap<T> map = new ObjectLongHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], i);
        }
        return map.toImmutable().keysView();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectLongHashMapKeysViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectLongHashMapKeysViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> take_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> drop_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> takeWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> dropWhile_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> collectIfWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> getOnly_throws_when_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> getOnly_throws_when_multiple_values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedListNaturalOrdering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> groupByUniqueKey_target_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectLongHashMapKeysViewTest> iterator;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableObjectLongHashMapKeysViewTest::toArray;
            this.payloads.contains = ImmutableObjectLongHashMapKeysViewTest::contains;
            this.payloads.containsAllIterable = ImmutableObjectLongHashMapKeysViewTest::containsAllIterable;
            this.payloads.containsAllArray = ImmutableObjectLongHashMapKeysViewTest::containsAllArray;
            this.payloads.select = ImmutableObjectLongHashMapKeysViewTest::select;
            this.payloads.selectWith = ImmutableObjectLongHashMapKeysViewTest::selectWith;
            this.payloads.selectWithTarget = ImmutableObjectLongHashMapKeysViewTest::selectWithTarget;
            this.payloads.reject = ImmutableObjectLongHashMapKeysViewTest::reject;
            this.payloads.rejectWith = ImmutableObjectLongHashMapKeysViewTest::rejectWith;
            this.payloads.rejectWithTarget = ImmutableObjectLongHashMapKeysViewTest::rejectWithTarget;
            this.payloads.partition = ImmutableObjectLongHashMapKeysViewTest::partition;
            this.payloads.partitionWith = ImmutableObjectLongHashMapKeysViewTest::partitionWith;
            this.payloads.selectInstancesOf = ImmutableObjectLongHashMapKeysViewTest::selectInstancesOf;
            this.payloads.collect = ImmutableObjectLongHashMapKeysViewTest::collect;
            this.payloads.collectBoolean = ImmutableObjectLongHashMapKeysViewTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectBooleanWithTarget;
            this.payloads.collectByte = ImmutableObjectLongHashMapKeysViewTest::collectByte;
            this.payloads.collectByteWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectByteWithTarget;
            this.payloads.collectChar = ImmutableObjectLongHashMapKeysViewTest::collectChar;
            this.payloads.collectCharWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectCharWithTarget;
            this.payloads.collectDouble = ImmutableObjectLongHashMapKeysViewTest::collectDouble;
            this.payloads.collectDoubleWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectDoubleWithTarget;
            this.payloads.collectFloat = ImmutableObjectLongHashMapKeysViewTest::collectFloat;
            this.payloads.collectFloatWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectFloatWithTarget;
            this.payloads.collectInt = ImmutableObjectLongHashMapKeysViewTest::collectInt;
            this.payloads.collectIntWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectIntWithTarget;
            this.payloads.collectLong = ImmutableObjectLongHashMapKeysViewTest::collectLong;
            this.payloads.collectLongWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectLongWithTarget;
            this.payloads.collectShort = ImmutableObjectLongHashMapKeysViewTest::collectShort;
            this.payloads.collectShortWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectShortWithTarget;
            this.payloads.collectWith = ImmutableObjectLongHashMapKeysViewTest::collectWith;
            this.payloads.collectWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectWithTarget;
            this.payloads.take = ImmutableObjectLongHashMapKeysViewTest::take;
            this.payloads.take_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::take_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = ImmutableObjectLongHashMapKeysViewTest::drop;
            this.payloads.drop_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::drop_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.takeWhile = ImmutableObjectLongHashMapKeysViewTest::takeWhile;
            this.payloads.takeWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::takeWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.dropWhile = ImmutableObjectLongHashMapKeysViewTest::dropWhile;
            this.payloads.dropWhile_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::dropWhile_null_throws, java.lang.IllegalStateException.class);
            this.payloads.detect = ImmutableObjectLongHashMapKeysViewTest::detect;
            this.payloads.detectWith = ImmutableObjectLongHashMapKeysViewTest::detectWith;
            this.payloads.detectOptional = ImmutableObjectLongHashMapKeysViewTest::detectOptional;
            this.payloads.detectWithOptional = ImmutableObjectLongHashMapKeysViewTest::detectWithOptional;
            this.payloads.detectWithIfNone = ImmutableObjectLongHashMapKeysViewTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = ImmutableObjectLongHashMapKeysViewTest::min;
            this.payloads.max = ImmutableObjectLongHashMapKeysViewTest::max;
            this.payloads.minBy = ImmutableObjectLongHashMapKeysViewTest::minBy;
            this.payloads.maxBy = ImmutableObjectLongHashMapKeysViewTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = ImmutableObjectLongHashMapKeysViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableObjectLongHashMapKeysViewTest::max_without_comparator;
            this.payloads.detectIfNone = ImmutableObjectLongHashMapKeysViewTest::detectIfNone;
            this.payloads.anySatisfy = ImmutableObjectLongHashMapKeysViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableObjectLongHashMapKeysViewTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableObjectLongHashMapKeysViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableObjectLongHashMapKeysViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableObjectLongHashMapKeysViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableObjectLongHashMapKeysViewTest::noneSatisfyWith;
            this.payloads.count = ImmutableObjectLongHashMapKeysViewTest::count;
            this.payloads.collectIf = ImmutableObjectLongHashMapKeysViewTest::collectIf;
            this.payloads.collectIfWithTarget = ImmutableObjectLongHashMapKeysViewTest::collectIfWithTarget;
            this.payloads.getFirst = ImmutableObjectLongHashMapKeysViewTest::getFirst;
            this.payloads.getLast = ImmutableObjectLongHashMapKeysViewTest::getLast;
            this.payloads.getOnly = ImmutableObjectLongHashMapKeysViewTest::getOnly;
            this.payloads.getOnly_throws_when_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::getOnly_throws_when_empty, java.lang.IllegalStateException.class);
            this.payloads.getOnly_throws_when_multiple_values = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::getOnly_throws_when_multiple_values, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = ImmutableObjectLongHashMapKeysViewTest::isEmpty;
            this.payloads.injectInto = ImmutableObjectLongHashMapKeysViewTest::injectInto;
            this.payloads.toList = ImmutableObjectLongHashMapKeysViewTest::toList;
            this.payloads.toSortedListNaturalOrdering = ImmutableObjectLongHashMapKeysViewTest::toSortedListNaturalOrdering;
            this.payloads.toSortedList = ImmutableObjectLongHashMapKeysViewTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableObjectLongHashMapKeysViewTest::toSortedListBy;
            this.payloads.toSortedSet = ImmutableObjectLongHashMapKeysViewTest::toSortedSet;
            this.payloads.toSortedSet_with_comparator = ImmutableObjectLongHashMapKeysViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableObjectLongHashMapKeysViewTest::toSortedSetBy;
            this.payloads.toSet = ImmutableObjectLongHashMapKeysViewTest::toSet;
            this.payloads.toMap = ImmutableObjectLongHashMapKeysViewTest::toMap;
            this.payloads.toSortedMap = ImmutableObjectLongHashMapKeysViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableObjectLongHashMapKeysViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableObjectLongHashMapKeysViewTest::toSortedMapBy;
            this.payloads.testToString = ImmutableObjectLongHashMapKeysViewTest::testToString;
            this.payloads.makeString = ImmutableObjectLongHashMapKeysViewTest::makeString;
            this.payloads.appendString = ImmutableObjectLongHashMapKeysViewTest::appendString;
            this.payloads.groupBy = ImmutableObjectLongHashMapKeysViewTest::groupBy;
            this.payloads.groupByEach = ImmutableObjectLongHashMapKeysViewTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableObjectLongHashMapKeysViewTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ImmutableObjectLongHashMapKeysViewTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::groupByUniqueKey_target_throws, java.lang.IllegalStateException.class);
            this.payloads.zip = ImmutableObjectLongHashMapKeysViewTest::zip;
            this.payloads.zipWithIndex = ImmutableObjectLongHashMapKeysViewTest::zipWithIndex;
            this.payloads.chunk = ImmutableObjectLongHashMapKeysViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectLongHashMapKeysViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableObjectLongHashMapKeysViewTest::chunk_large_size;
            this.payloads.tap = ImmutableObjectLongHashMapKeysViewTest::tap;
            this.payloads.asLazy = ImmutableObjectLongHashMapKeysViewTest::asLazy;
            this.payloads.flatCollect = ImmutableObjectLongHashMapKeysViewTest::flatCollect;
            this.payloads.flatCollectWith = ImmutableObjectLongHashMapKeysViewTest::flatCollectWith;
            this.payloads.distinct = ImmutableObjectLongHashMapKeysViewTest::distinct;
            this.payloads.iterator = ImmutableObjectLongHashMapKeysViewTest::iterator;
        }
    }
}
