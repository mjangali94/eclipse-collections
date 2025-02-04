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

import org.eclipse.collections.api.map.primitive.ImmutableIntCharMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableIntCharHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableIntCharHashMapKeyValuesViewTest extends AbstractIntCharMapKeyValuesViewTestCase {

    @Override
    public ImmutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2, int key3, char value3) {
        return IntCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2) {
        return IntCharHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableIntCharMap newWithKeysValues(int key1, char value1) {
        return IntCharHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableIntCharMap newEmpty() {
        return new IntCharHashMap().toImmutable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableIntCharHashMapKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableIntCharHashMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableIntCharHashMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = ImmutableIntCharHashMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = ImmutableIntCharHashMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = ImmutableIntCharHashMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = ImmutableIntCharHashMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableIntCharHashMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = ImmutableIntCharHashMapKeyValuesViewTest::select;
            this.payloads.selectWith = ImmutableIntCharHashMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = ImmutableIntCharHashMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = ImmutableIntCharHashMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = ImmutableIntCharHashMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = ImmutableIntCharHashMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = ImmutableIntCharHashMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = ImmutableIntCharHashMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = ImmutableIntCharHashMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = ImmutableIntCharHashMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = ImmutableIntCharHashMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = ImmutableIntCharHashMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = ImmutableIntCharHashMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = ImmutableIntCharHashMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = ImmutableIntCharHashMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = ImmutableIntCharHashMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = ImmutableIntCharHashMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = ImmutableIntCharHashMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntCharHashMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntCharHashMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableIntCharHashMapKeyValuesViewTest::min;
            this.payloads.max = ImmutableIntCharHashMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = ImmutableIntCharHashMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableIntCharHashMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = ImmutableIntCharHashMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = ImmutableIntCharHashMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = ImmutableIntCharHashMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = ImmutableIntCharHashMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = ImmutableIntCharHashMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = ImmutableIntCharHashMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableIntCharHashMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableIntCharHashMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableIntCharHashMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = ImmutableIntCharHashMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableIntCharHashMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = ImmutableIntCharHashMapKeyValuesViewTest::count;
            this.payloads.countWith = ImmutableIntCharHashMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = ImmutableIntCharHashMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = ImmutableIntCharHashMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = ImmutableIntCharHashMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = ImmutableIntCharHashMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = ImmutableIntCharHashMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = ImmutableIntCharHashMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = ImmutableIntCharHashMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = ImmutableIntCharHashMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntCharHashMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntCharHashMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = ImmutableIntCharHashMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = ImmutableIntCharHashMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = ImmutableIntCharHashMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableIntCharHashMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = ImmutableIntCharHashMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = ImmutableIntCharHashMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = ImmutableIntCharHashMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = ImmutableIntCharHashMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = ImmutableIntCharHashMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = ImmutableIntCharHashMapKeyValuesViewTest::toArray;
            this.payloads.partition = ImmutableIntCharHashMapKeyValuesViewTest::partition;
            this.payloads.toList = ImmutableIntCharHashMapKeyValuesViewTest::toList;
            this.payloads.toBag = ImmutableIntCharHashMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = ImmutableIntCharHashMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = ImmutableIntCharHashMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = ImmutableIntCharHashMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = ImmutableIntCharHashMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = ImmutableIntCharHashMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = ImmutableIntCharHashMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = ImmutableIntCharHashMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = ImmutableIntCharHashMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = ImmutableIntCharHashMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = ImmutableIntCharHashMapKeyValuesViewTest::toSet;
            this.payloads.toMap = ImmutableIntCharHashMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = ImmutableIntCharHashMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = ImmutableIntCharHashMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = ImmutableIntCharHashMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = ImmutableIntCharHashMapKeyValuesViewTest::testToString;
            this.payloads.makeString = ImmutableIntCharHashMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = ImmutableIntCharHashMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = ImmutableIntCharHashMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = ImmutableIntCharHashMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = ImmutableIntCharHashMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = ImmutableIntCharHashMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = ImmutableIntCharHashMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = ImmutableIntCharHashMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = ImmutableIntCharHashMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = ImmutableIntCharHashMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = ImmutableIntCharHashMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableIntCharHashMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = ImmutableIntCharHashMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = ImmutableIntCharHashMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = ImmutableIntCharHashMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = ImmutableIntCharHashMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = ImmutableIntCharHashMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
