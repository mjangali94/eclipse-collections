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

import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedDoubleDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedDoubleDoubleMapKeyValuesViewTest extends AbstractDoubleDoubleMapKeyValuesViewTestCase {

    @Override
    public MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3) {
        return DoubleDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2) {
        return DoubleDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableDoubleDoubleMap newWithKeysValues(double key1, double value1) {
        return DoubleDoubleHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableDoubleDoubleMap newEmpty() {
        return new DoubleDoubleHashMap().asSynchronized();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedDoubleDoubleMapKeyValuesViewTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedDoubleDoubleMapKeyValuesViewTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleDoubleMapKeyValuesViewTest> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = SynchronizedDoubleDoubleMapKeyValuesViewTest::containsAllIterable;
            this.payloads.containsAllArray = SynchronizedDoubleDoubleMapKeyValuesViewTest::containsAllArray;
            this.payloads.forEach = SynchronizedDoubleDoubleMapKeyValuesViewTest::forEach;
            this.payloads.forEachWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::forEachWith;
            this.payloads.forEachWithIndex = SynchronizedDoubleDoubleMapKeyValuesViewTest::forEachWithIndex;
            this.payloads.select = SynchronizedDoubleDoubleMapKeyValuesViewTest::select;
            this.payloads.selectWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::selectWith;
            this.payloads.selectWith_target = SynchronizedDoubleDoubleMapKeyValuesViewTest::selectWith_target;
            this.payloads.reject = SynchronizedDoubleDoubleMapKeyValuesViewTest::reject;
            this.payloads.rejectWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::rejectWith;
            this.payloads.rejectWith_target = SynchronizedDoubleDoubleMapKeyValuesViewTest::rejectWith_target;
            this.payloads.selectInstancesOf = SynchronizedDoubleDoubleMapKeyValuesViewTest::selectInstancesOf;
            this.payloads.collect = SynchronizedDoubleDoubleMapKeyValuesViewTest::collect;
            this.payloads.collectBoolean = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectBoolean;
            this.payloads.collectByte = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectByte;
            this.payloads.collectChar = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectChar;
            this.payloads.collectDouble = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectDouble;
            this.payloads.collectFloat = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectFloat;
            this.payloads.collectInt = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectInt;
            this.payloads.collectLong = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectLong;
            this.payloads.collectShort = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectShort;
            this.payloads.flatCollect = SynchronizedDoubleDoubleMapKeyValuesViewTest::flatCollect;
            this.payloads.detect = SynchronizedDoubleDoubleMapKeyValuesViewTest::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleDoubleMapKeyValuesViewTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleDoubleMapKeyValuesViewTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedDoubleDoubleMapKeyValuesViewTest::min;
            this.payloads.max = SynchronizedDoubleDoubleMapKeyValuesViewTest::max;
            this.payloads.min_without_comparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::min_without_comparator;
            this.payloads.max_without_comparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::max_without_comparator;
            this.payloads.minBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::minBy;
            this.payloads.maxBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::maxBy;
            this.payloads.detectWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::detectWith;
            this.payloads.detectIfNone = SynchronizedDoubleDoubleMapKeyValuesViewTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = SynchronizedDoubleDoubleMapKeyValuesViewTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = SynchronizedDoubleDoubleMapKeyValuesViewTest::allSatisfy;
            this.payloads.allSatisfyWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::allSatisfyWith;
            this.payloads.noneSatisfy = SynchronizedDoubleDoubleMapKeyValuesViewTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::noneSatisfyWith;
            this.payloads.anySatisfy = SynchronizedDoubleDoubleMapKeyValuesViewTest::anySatisfy;
            this.payloads.anySatisfyWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::anySatisfyWith;
            this.payloads.count = SynchronizedDoubleDoubleMapKeyValuesViewTest::count;
            this.payloads.countWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::countWith;
            this.payloads.collectIf = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectIf;
            this.payloads.collectWith = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectWith;
            this.payloads.collectWith_target = SynchronizedDoubleDoubleMapKeyValuesViewTest::collectWith_target;
            this.payloads.getFirst = SynchronizedDoubleDoubleMapKeyValuesViewTest::getFirst;
            this.payloads.getLast = SynchronizedDoubleDoubleMapKeyValuesViewTest::getLast;
            this.payloads.isEmpty = SynchronizedDoubleDoubleMapKeyValuesViewTest::isEmpty;
            this.payloads.iterator = SynchronizedDoubleDoubleMapKeyValuesViewTest::iterator;
            this.payloads.iterator_no_sentinels = SynchronizedDoubleDoubleMapKeyValuesViewTest::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleDoubleMapKeyValuesViewTest::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleDoubleMapKeyValuesViewTest::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = SynchronizedDoubleDoubleMapKeyValuesViewTest::injectInto;
            this.payloads.injectIntoInt = SynchronizedDoubleDoubleMapKeyValuesViewTest::injectIntoInt;
            this.payloads.injectIntoLong = SynchronizedDoubleDoubleMapKeyValuesViewTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedDoubleDoubleMapKeyValuesViewTest::injectIntoDouble;
            this.payloads.injectIntoFloat = SynchronizedDoubleDoubleMapKeyValuesViewTest::injectIntoFloat;
            this.payloads.sumFloat = SynchronizedDoubleDoubleMapKeyValuesViewTest::sumFloat;
            this.payloads.sumDouble = SynchronizedDoubleDoubleMapKeyValuesViewTest::sumDouble;
            this.payloads.sumInteger = SynchronizedDoubleDoubleMapKeyValuesViewTest::sumInteger;
            this.payloads.sumLong = SynchronizedDoubleDoubleMapKeyValuesViewTest::sumLong;
            this.payloads.toArray = SynchronizedDoubleDoubleMapKeyValuesViewTest::toArray;
            this.payloads.partition = SynchronizedDoubleDoubleMapKeyValuesViewTest::partition;
            this.payloads.toList = SynchronizedDoubleDoubleMapKeyValuesViewTest::toList;
            this.payloads.toBag = SynchronizedDoubleDoubleMapKeyValuesViewTest::toBag;
            this.payloads.toSortedList_natural_ordering = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedList_with_comparator;
            this.payloads.toSortedListBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedSetBy;
            this.payloads.toSet = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSet;
            this.payloads.toMap = SynchronizedDoubleDoubleMapKeyValuesViewTest::toMap;
            this.payloads.toSortedMap = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::toSortedMapBy;
            this.payloads.testToString = SynchronizedDoubleDoubleMapKeyValuesViewTest::testToString;
            this.payloads.makeString = SynchronizedDoubleDoubleMapKeyValuesViewTest::makeString;
            this.payloads.makeStringWithSeparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = SynchronizedDoubleDoubleMapKeyValuesViewTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = SynchronizedDoubleDoubleMapKeyValuesViewTest::appendString;
            this.payloads.appendStringWithSeparator = SynchronizedDoubleDoubleMapKeyValuesViewTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = SynchronizedDoubleDoubleMapKeyValuesViewTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = SynchronizedDoubleDoubleMapKeyValuesViewTest::groupBy;
            this.payloads.groupByEach = SynchronizedDoubleDoubleMapKeyValuesViewTest::groupByEach;
            this.payloads.zip = SynchronizedDoubleDoubleMapKeyValuesViewTest::zip;
            this.payloads.zipWithIndex = SynchronizedDoubleDoubleMapKeyValuesViewTest::zipWithIndex;
            this.payloads.chunk = SynchronizedDoubleDoubleMapKeyValuesViewTest::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleDoubleMapKeyValuesViewTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = SynchronizedDoubleDoubleMapKeyValuesViewTest::chunk_large_size;
            this.payloads.empty = SynchronizedDoubleDoubleMapKeyValuesViewTest::empty;
            this.payloads.notEmpty = SynchronizedDoubleDoubleMapKeyValuesViewTest::notEmpty;
            this.payloads.aggregateByMutating = SynchronizedDoubleDoubleMapKeyValuesViewTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = SynchronizedDoubleDoubleMapKeyValuesViewTest::aggregateByNonMutating;
        }
    }
}
