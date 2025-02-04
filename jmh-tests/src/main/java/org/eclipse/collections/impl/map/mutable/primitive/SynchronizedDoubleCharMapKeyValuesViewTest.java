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

import org.eclipse.collections.api.map.primitive.MutableDoubleCharMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedDoubleCharMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedDoubleCharMapKeyValuesViewTest extends AbstractDoubleCharMapKeyValuesViewTestCase {

    @Override
    public MutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3) {
        return DoubleCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2) {
        return DoubleCharHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableDoubleCharMap newWithKeysValues(double key1, char value1) {
        return DoubleCharHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableDoubleCharMap newEmpty() {
        return new DoubleCharHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedDoubleCharMapKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedDoubleCharMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleCharMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = SynchronizedDoubleCharMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = SynchronizedDoubleCharMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = SynchronizedDoubleCharMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = SynchronizedDoubleCharMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedDoubleCharMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = SynchronizedDoubleCharMapKeyValuesViewTest::select;
            this.payloads.selectWith = SynchronizedDoubleCharMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = SynchronizedDoubleCharMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = SynchronizedDoubleCharMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = SynchronizedDoubleCharMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedDoubleCharMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedDoubleCharMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = SynchronizedDoubleCharMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = SynchronizedDoubleCharMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = SynchronizedDoubleCharMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = SynchronizedDoubleCharMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = SynchronizedDoubleCharMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = SynchronizedDoubleCharMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = SynchronizedDoubleCharMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = SynchronizedDoubleCharMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = SynchronizedDoubleCharMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = SynchronizedDoubleCharMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = SynchronizedDoubleCharMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleCharMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleCharMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedDoubleCharMapKeyValuesViewTest::min;
            this.payloads.max = SynchronizedDoubleCharMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = SynchronizedDoubleCharMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedDoubleCharMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = SynchronizedDoubleCharMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = SynchronizedDoubleCharMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = SynchronizedDoubleCharMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = SynchronizedDoubleCharMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedDoubleCharMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedDoubleCharMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedDoubleCharMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedDoubleCharMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedDoubleCharMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedDoubleCharMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedDoubleCharMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = SynchronizedDoubleCharMapKeyValuesViewTest::count;
            this.payloads.countWith = SynchronizedDoubleCharMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = SynchronizedDoubleCharMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = SynchronizedDoubleCharMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = SynchronizedDoubleCharMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = SynchronizedDoubleCharMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = SynchronizedDoubleCharMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = SynchronizedDoubleCharMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = SynchronizedDoubleCharMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = SynchronizedDoubleCharMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleCharMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleCharMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = SynchronizedDoubleCharMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedDoubleCharMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedDoubleCharMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedDoubleCharMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedDoubleCharMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedDoubleCharMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = SynchronizedDoubleCharMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = SynchronizedDoubleCharMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = SynchronizedDoubleCharMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = SynchronizedDoubleCharMapKeyValuesViewTest::toArray;
            this.payloads.partition = SynchronizedDoubleCharMapKeyValuesViewTest::partition;
            this.payloads.toList = SynchronizedDoubleCharMapKeyValuesViewTest::toList;
            this.payloads.toBag = SynchronizedDoubleCharMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = SynchronizedDoubleCharMapKeyValuesViewTest::toSet;
            this.payloads.toMap = SynchronizedDoubleCharMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedDoubleCharMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = SynchronizedDoubleCharMapKeyValuesViewTest::testToString;
            this.payloads.makeString = SynchronizedDoubleCharMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = SynchronizedDoubleCharMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedDoubleCharMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = SynchronizedDoubleCharMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = SynchronizedDoubleCharMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedDoubleCharMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = SynchronizedDoubleCharMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = SynchronizedDoubleCharMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = SynchronizedDoubleCharMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = SynchronizedDoubleCharMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = SynchronizedDoubleCharMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleCharMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedDoubleCharMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = SynchronizedDoubleCharMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = SynchronizedDoubleCharMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedDoubleCharMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedDoubleCharMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
