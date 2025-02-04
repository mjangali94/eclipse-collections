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

import org.eclipse.collections.api.map.primitive.MutableFloatLongMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableFloatLongMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableFloatLongMapKeyValuesViewTest extends AbstractFloatLongMapKeyValuesViewTestCase {

    @Override
    public MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3) {
        return FloatLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2) {
        return FloatLongHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableFloatLongMap newWithKeysValues(float key1, long value1) {
        return FloatLongHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableFloatLongMap newEmpty() {
        return new FloatLongHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableFloatLongMapKeyValuesViewTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_target);
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
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
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
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_no_sentinels);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_next_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumInteger);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
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
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableFloatLongMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatLongMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = UnmodifiableFloatLongMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableFloatLongMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = UnmodifiableFloatLongMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = UnmodifiableFloatLongMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableFloatLongMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = UnmodifiableFloatLongMapKeyValuesViewTest::select;
            this.payloads.selectWith = UnmodifiableFloatLongMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = UnmodifiableFloatLongMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = UnmodifiableFloatLongMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = UnmodifiableFloatLongMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = UnmodifiableFloatLongMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnmodifiableFloatLongMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableFloatLongMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = UnmodifiableFloatLongMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = UnmodifiableFloatLongMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = UnmodifiableFloatLongMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = UnmodifiableFloatLongMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = UnmodifiableFloatLongMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = UnmodifiableFloatLongMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = UnmodifiableFloatLongMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = UnmodifiableFloatLongMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = UnmodifiableFloatLongMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = UnmodifiableFloatLongMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatLongMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatLongMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableFloatLongMapKeyValuesViewTest::min;
            this.payloads.max = UnmodifiableFloatLongMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = UnmodifiableFloatLongMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableFloatLongMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = UnmodifiableFloatLongMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = UnmodifiableFloatLongMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = UnmodifiableFloatLongMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = UnmodifiableFloatLongMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnmodifiableFloatLongMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = UnmodifiableFloatLongMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableFloatLongMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableFloatLongMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableFloatLongMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = UnmodifiableFloatLongMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableFloatLongMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = UnmodifiableFloatLongMapKeyValuesViewTest::count;
            this.payloads.countWith = UnmodifiableFloatLongMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = UnmodifiableFloatLongMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = UnmodifiableFloatLongMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = UnmodifiableFloatLongMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = UnmodifiableFloatLongMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = UnmodifiableFloatLongMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = UnmodifiableFloatLongMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = UnmodifiableFloatLongMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = UnmodifiableFloatLongMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatLongMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatLongMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = UnmodifiableFloatLongMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableFloatLongMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableFloatLongMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableFloatLongMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableFloatLongMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableFloatLongMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = UnmodifiableFloatLongMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = UnmodifiableFloatLongMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = UnmodifiableFloatLongMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = UnmodifiableFloatLongMapKeyValuesViewTest::toArray;
            this.payloads.partition = UnmodifiableFloatLongMapKeyValuesViewTest::partition;
            this.payloads.toList = UnmodifiableFloatLongMapKeyValuesViewTest::toList;
            this.payloads.toBag = UnmodifiableFloatLongMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = UnmodifiableFloatLongMapKeyValuesViewTest::toSet;
            this.payloads.toMap = UnmodifiableFloatLongMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableFloatLongMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = UnmodifiableFloatLongMapKeyValuesViewTest::testToString;
            this.payloads.makeString = UnmodifiableFloatLongMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = UnmodifiableFloatLongMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableFloatLongMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = UnmodifiableFloatLongMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = UnmodifiableFloatLongMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableFloatLongMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = UnmodifiableFloatLongMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = UnmodifiableFloatLongMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = UnmodifiableFloatLongMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = UnmodifiableFloatLongMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableFloatLongMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatLongMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableFloatLongMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = UnmodifiableFloatLongMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = UnmodifiableFloatLongMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = UnmodifiableFloatLongMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableFloatLongMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
