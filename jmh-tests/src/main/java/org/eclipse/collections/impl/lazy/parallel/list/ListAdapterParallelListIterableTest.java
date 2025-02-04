/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.list;

import java.util.LinkedList;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.ListAdapter;

public class ListAdapterParallelListIterableTest extends NonParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return ListAdapter.adapt(new LinkedList<>(Lists.mutable.of(littleElements))).asParallel(null, this.batchSize);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ListAdapterParallelListIterableTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray_array() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray_array);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
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
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
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
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
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
        public void benchmark_toSortedMap_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_comparator);
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
        public void benchmark_makeString_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_separator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_start_separator_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_separator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_start_separator_end);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_throws);
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
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minWithEmptyBatch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minWithEmptyBatch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxWithEmptyBatch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxWithEmptyBatch);
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
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_executionException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_interruptedException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toString_interruptedException);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ListAdapterParallelListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ListAdapterParallelListIterableTest> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ListAdapterParallelListIterableTest::toArray;
            this.payloads.toArray_array = ListAdapterParallelListIterableTest::toArray_array;
            this.payloads.forEach = ListAdapterParallelListIterableTest::forEach;
            this.payloads.forEachWith = ListAdapterParallelListIterableTest::forEachWith;
            this.payloads.select = ListAdapterParallelListIterableTest::select;
            this.payloads.selectWith = ListAdapterParallelListIterableTest::selectWith;
            this.payloads.reject = ListAdapterParallelListIterableTest::reject;
            this.payloads.rejectWith = ListAdapterParallelListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ListAdapterParallelListIterableTest::selectInstancesOf;
            this.payloads.collect = ListAdapterParallelListIterableTest::collect;
            this.payloads.collectWith = ListAdapterParallelListIterableTest::collectWith;
            this.payloads.collectIf = ListAdapterParallelListIterableTest::collectIf;
            this.payloads.flatCollect = ListAdapterParallelListIterableTest::flatCollect;
            this.payloads.detect = ListAdapterParallelListIterableTest::detect;
            this.payloads.detectIfNone = ListAdapterParallelListIterableTest::detectIfNone;
            this.payloads.detectWith = ListAdapterParallelListIterableTest::detectWith;
            this.payloads.detectWithIfNone = ListAdapterParallelListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ListAdapterParallelListIterableTest::min;
            this.payloads.max = ListAdapterParallelListIterableTest::max;
            this.payloads.minBy = ListAdapterParallelListIterableTest::minBy;
            this.payloads.maxBy = ListAdapterParallelListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ListAdapterParallelListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ListAdapterParallelListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ListAdapterParallelListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ListAdapterParallelListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ListAdapterParallelListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ListAdapterParallelListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ListAdapterParallelListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ListAdapterParallelListIterableTest::noneSatisfyWith;
            this.payloads.count = ListAdapterParallelListIterableTest::count;
            this.payloads.countWith = ListAdapterParallelListIterableTest::countWith;
            this.payloads.toList = ListAdapterParallelListIterableTest::toList;
            this.payloads.toSortedList = ListAdapterParallelListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ListAdapterParallelListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ListAdapterParallelListIterableTest::toSortedListBy;
            this.payloads.toSet = ListAdapterParallelListIterableTest::toSet;
            this.payloads.toSortedSet = ListAdapterParallelListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ListAdapterParallelListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ListAdapterParallelListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ListAdapterParallelListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ListAdapterParallelListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ListAdapterParallelListIterableTest::toSortedBagBy;
            this.payloads.toMap = ListAdapterParallelListIterableTest::toMap;
            this.payloads.toSortedMap = ListAdapterParallelListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ListAdapterParallelListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ListAdapterParallelListIterableTest::testToString;
            this.payloads.makeString = ListAdapterParallelListIterableTest::makeString;
            this.payloads.makeString_separator = ListAdapterParallelListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ListAdapterParallelListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ListAdapterParallelListIterableTest::appendString;
            this.payloads.appendString_separator = ListAdapterParallelListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ListAdapterParallelListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ListAdapterParallelListIterableTest::appendString_throws;
            this.payloads.groupBy = ListAdapterParallelListIterableTest::groupBy;
            this.payloads.groupByEach = ListAdapterParallelListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ListAdapterParallelListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ListAdapterParallelListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ListAdapterParallelListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ListAdapterParallelListIterableTest::sumOfInt;
            this.payloads.sumOfLong = ListAdapterParallelListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ListAdapterParallelListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ListAdapterParallelListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ListAdapterParallelListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ListAdapterParallelListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ListAdapterParallelListIterableTest::asUnique;
            this.payloads.minWithEmptyBatch = ListAdapterParallelListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ListAdapterParallelListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ListAdapterParallelListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEach_executionException = ListAdapterParallelListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ListAdapterParallelListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ListAdapterParallelListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ListAdapterParallelListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ListAdapterParallelListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ListAdapterParallelListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ListAdapterParallelListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ListAdapterParallelListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ListAdapterParallelListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ListAdapterParallelListIterableTest::toString_interruptedException;
        }
    }
}
