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

import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableLongDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableLongDoubleMapKeyValuesViewTest extends AbstractLongDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableLongDoubleMap newWithKeysValues(long key1, double value1) {
        return LongDoubleHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableLongDoubleMap newEmpty() {
        return new LongDoubleHashMap().asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableLongDoubleMapKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableLongDoubleMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableLongDoubleMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = UnmodifiableLongDoubleMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = UnmodifiableLongDoubleMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = UnmodifiableLongDoubleMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = UnmodifiableLongDoubleMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = UnmodifiableLongDoubleMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = UnmodifiableLongDoubleMapKeyValuesViewTest::select;
            this.payloads.selectWith = UnmodifiableLongDoubleMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = UnmodifiableLongDoubleMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = UnmodifiableLongDoubleMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = UnmodifiableLongDoubleMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = UnmodifiableLongDoubleMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = UnmodifiableLongDoubleMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableLongDoubleMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = UnmodifiableLongDoubleMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = UnmodifiableLongDoubleMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = UnmodifiableLongDoubleMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = UnmodifiableLongDoubleMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = UnmodifiableLongDoubleMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = UnmodifiableLongDoubleMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = UnmodifiableLongDoubleMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = UnmodifiableLongDoubleMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = UnmodifiableLongDoubleMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = UnmodifiableLongDoubleMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongDoubleMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongDoubleMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableLongDoubleMapKeyValuesViewTest::min;
            this.payloads.max = UnmodifiableLongDoubleMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = UnmodifiableLongDoubleMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableLongDoubleMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = UnmodifiableLongDoubleMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = UnmodifiableLongDoubleMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = UnmodifiableLongDoubleMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = UnmodifiableLongDoubleMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = UnmodifiableLongDoubleMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = UnmodifiableLongDoubleMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableLongDoubleMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableLongDoubleMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableLongDoubleMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = UnmodifiableLongDoubleMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableLongDoubleMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = UnmodifiableLongDoubleMapKeyValuesViewTest::count;
            this.payloads.countWith = UnmodifiableLongDoubleMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = UnmodifiableLongDoubleMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = UnmodifiableLongDoubleMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = UnmodifiableLongDoubleMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = UnmodifiableLongDoubleMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = UnmodifiableLongDoubleMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = UnmodifiableLongDoubleMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = UnmodifiableLongDoubleMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = UnmodifiableLongDoubleMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongDoubleMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongDoubleMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = UnmodifiableLongDoubleMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = UnmodifiableLongDoubleMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = UnmodifiableLongDoubleMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableLongDoubleMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = UnmodifiableLongDoubleMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = UnmodifiableLongDoubleMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = UnmodifiableLongDoubleMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = UnmodifiableLongDoubleMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = UnmodifiableLongDoubleMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = UnmodifiableLongDoubleMapKeyValuesViewTest::toArray;
            this.payloads.partition = UnmodifiableLongDoubleMapKeyValuesViewTest::partition;
            this.payloads.toList = UnmodifiableLongDoubleMapKeyValuesViewTest::toList;
            this.payloads.toBag = UnmodifiableLongDoubleMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = UnmodifiableLongDoubleMapKeyValuesViewTest::toSet;
            this.payloads.toMap = UnmodifiableLongDoubleMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = UnmodifiableLongDoubleMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = UnmodifiableLongDoubleMapKeyValuesViewTest::testToString;
            this.payloads.makeString = UnmodifiableLongDoubleMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = UnmodifiableLongDoubleMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = UnmodifiableLongDoubleMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = UnmodifiableLongDoubleMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = UnmodifiableLongDoubleMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = UnmodifiableLongDoubleMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = UnmodifiableLongDoubleMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = UnmodifiableLongDoubleMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = UnmodifiableLongDoubleMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = UnmodifiableLongDoubleMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = UnmodifiableLongDoubleMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableLongDoubleMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = UnmodifiableLongDoubleMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = UnmodifiableLongDoubleMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = UnmodifiableLongDoubleMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = UnmodifiableLongDoubleMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = UnmodifiableLongDoubleMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
