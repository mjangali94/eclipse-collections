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

import org.eclipse.collections.impl.map.primitive.AbstractDoubleShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link DoubleShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class DoubleShortHashMapKeyValuesViewTest extends AbstractDoubleShortMapKeyValuesViewTestCase {

    @Override
    public DoubleShortHashMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3) {
        return DoubleShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public DoubleShortHashMap newWithKeysValues(double key1, short value1, double key2, short value2) {
        return DoubleShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public DoubleShortHashMap newWithKeysValues(double key1, short value1) {
        return DoubleShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public DoubleShortHashMap newEmpty() {
        return new DoubleShortHashMap();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleShortHashMapKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleShortHashMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleShortHashMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = DoubleShortHashMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = DoubleShortHashMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = DoubleShortHashMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = DoubleShortHashMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = DoubleShortHashMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = DoubleShortHashMapKeyValuesViewTest::select;
            this.payloads.selectWith = DoubleShortHashMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = DoubleShortHashMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = DoubleShortHashMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = DoubleShortHashMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = DoubleShortHashMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = DoubleShortHashMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = DoubleShortHashMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = DoubleShortHashMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = DoubleShortHashMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = DoubleShortHashMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = DoubleShortHashMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = DoubleShortHashMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = DoubleShortHashMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = DoubleShortHashMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = DoubleShortHashMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = DoubleShortHashMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = DoubleShortHashMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleShortHashMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleShortHashMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = DoubleShortHashMapKeyValuesViewTest::min;
            this.payloads.max = DoubleShortHashMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = DoubleShortHashMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = DoubleShortHashMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = DoubleShortHashMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = DoubleShortHashMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = DoubleShortHashMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = DoubleShortHashMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = DoubleShortHashMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = DoubleShortHashMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = DoubleShortHashMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = DoubleShortHashMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = DoubleShortHashMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = DoubleShortHashMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = DoubleShortHashMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = DoubleShortHashMapKeyValuesViewTest::count;
            this.payloads.countWith = DoubleShortHashMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = DoubleShortHashMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = DoubleShortHashMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = DoubleShortHashMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = DoubleShortHashMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = DoubleShortHashMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = DoubleShortHashMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = DoubleShortHashMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = DoubleShortHashMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleShortHashMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleShortHashMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = DoubleShortHashMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = DoubleShortHashMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = DoubleShortHashMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = DoubleShortHashMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = DoubleShortHashMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = DoubleShortHashMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = DoubleShortHashMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = DoubleShortHashMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = DoubleShortHashMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = DoubleShortHashMapKeyValuesViewTest::toArray;
            this.payloads.partition = DoubleShortHashMapKeyValuesViewTest::partition;
            this.payloads.toList = DoubleShortHashMapKeyValuesViewTest::toList;
            this.payloads.toBag = DoubleShortHashMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = DoubleShortHashMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = DoubleShortHashMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = DoubleShortHashMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = DoubleShortHashMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = DoubleShortHashMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = DoubleShortHashMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = DoubleShortHashMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = DoubleShortHashMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = DoubleShortHashMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = DoubleShortHashMapKeyValuesViewTest::toSet;
            this.payloads.toMap = DoubleShortHashMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = DoubleShortHashMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = DoubleShortHashMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = DoubleShortHashMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = DoubleShortHashMapKeyValuesViewTest::testToString;
            this.payloads.makeString = DoubleShortHashMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = DoubleShortHashMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = DoubleShortHashMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = DoubleShortHashMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = DoubleShortHashMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = DoubleShortHashMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = DoubleShortHashMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = DoubleShortHashMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = DoubleShortHashMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = DoubleShortHashMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = DoubleShortHashMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleShortHashMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = DoubleShortHashMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = DoubleShortHashMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = DoubleShortHashMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = DoubleShortHashMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = DoubleShortHashMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
