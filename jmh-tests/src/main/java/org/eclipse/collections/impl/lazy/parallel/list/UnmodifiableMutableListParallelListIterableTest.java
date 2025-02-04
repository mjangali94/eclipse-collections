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

import java.util.ArrayList;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.ArrayListAdapter;
import org.junit.Test;

public class UnmodifiableMutableListParallelListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return ArrayListAdapter.adapt(new ArrayList<>(Lists.mutable.of(littleElements))).asUnmodifiable().asParallel(this.executorService, this.batchSize);
    }

    @Override
    protected ListIterable<Integer> getExpectedWith(Integer... littleElements) {
        return ArrayListAdapter.adapt(new ArrayList<>(Lists.mutable.of(littleElements))).asUnmodifiable();
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        ArrayListAdapter.adapt(new ArrayList<>(Lists.mutable.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4))).asUnmodifiable().asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        Lists.mutable.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableMutableListParallelListIterableTest instance;

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
        public void benchmark_asParallel_small_batch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_small_batch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_null_executorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_null_executorService);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableMutableListParallelListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableMutableListParallelListIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnmodifiableMutableListParallelListIterableTest::toArray;
            this.payloads.toArray_array = UnmodifiableMutableListParallelListIterableTest::toArray_array;
            this.payloads.forEach = UnmodifiableMutableListParallelListIterableTest::forEach;
            this.payloads.forEachWith = UnmodifiableMutableListParallelListIterableTest::forEachWith;
            this.payloads.select = UnmodifiableMutableListParallelListIterableTest::select;
            this.payloads.selectWith = UnmodifiableMutableListParallelListIterableTest::selectWith;
            this.payloads.reject = UnmodifiableMutableListParallelListIterableTest::reject;
            this.payloads.rejectWith = UnmodifiableMutableListParallelListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = UnmodifiableMutableListParallelListIterableTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableMutableListParallelListIterableTest::collect;
            this.payloads.collectWith = UnmodifiableMutableListParallelListIterableTest::collectWith;
            this.payloads.collectIf = UnmodifiableMutableListParallelListIterableTest::collectIf;
            this.payloads.flatCollect = UnmodifiableMutableListParallelListIterableTest::flatCollect;
            this.payloads.detect = UnmodifiableMutableListParallelListIterableTest::detect;
            this.payloads.detectIfNone = UnmodifiableMutableListParallelListIterableTest::detectIfNone;
            this.payloads.detectWith = UnmodifiableMutableListParallelListIterableTest::detectWith;
            this.payloads.detectWithIfNone = UnmodifiableMutableListParallelListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableMutableListParallelListIterableTest::min;
            this.payloads.max = UnmodifiableMutableListParallelListIterableTest::max;
            this.payloads.minBy = UnmodifiableMutableListParallelListIterableTest::minBy;
            this.payloads.maxBy = UnmodifiableMutableListParallelListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = UnmodifiableMutableListParallelListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableMutableListParallelListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = UnmodifiableMutableListParallelListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableMutableListParallelListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableMutableListParallelListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableMutableListParallelListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableMutableListParallelListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableMutableListParallelListIterableTest::noneSatisfyWith;
            this.payloads.count = UnmodifiableMutableListParallelListIterableTest::count;
            this.payloads.countWith = UnmodifiableMutableListParallelListIterableTest::countWith;
            this.payloads.toList = UnmodifiableMutableListParallelListIterableTest::toList;
            this.payloads.toSortedList = UnmodifiableMutableListParallelListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = UnmodifiableMutableListParallelListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = UnmodifiableMutableListParallelListIterableTest::toSortedListBy;
            this.payloads.toSet = UnmodifiableMutableListParallelListIterableTest::toSet;
            this.payloads.toSortedSet = UnmodifiableMutableListParallelListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = UnmodifiableMutableListParallelListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = UnmodifiableMutableListParallelListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = UnmodifiableMutableListParallelListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = UnmodifiableMutableListParallelListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = UnmodifiableMutableListParallelListIterableTest::toSortedBagBy;
            this.payloads.toMap = UnmodifiableMutableListParallelListIterableTest::toMap;
            this.payloads.toSortedMap = UnmodifiableMutableListParallelListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = UnmodifiableMutableListParallelListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = UnmodifiableMutableListParallelListIterableTest::testToString;
            this.payloads.makeString = UnmodifiableMutableListParallelListIterableTest::makeString;
            this.payloads.makeString_separator = UnmodifiableMutableListParallelListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = UnmodifiableMutableListParallelListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = UnmodifiableMutableListParallelListIterableTest::appendString;
            this.payloads.appendString_separator = UnmodifiableMutableListParallelListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = UnmodifiableMutableListParallelListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = UnmodifiableMutableListParallelListIterableTest::appendString_throws;
            this.payloads.groupBy = UnmodifiableMutableListParallelListIterableTest::groupBy;
            this.payloads.groupByEach = UnmodifiableMutableListParallelListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableMutableListParallelListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = UnmodifiableMutableListParallelListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = UnmodifiableMutableListParallelListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = UnmodifiableMutableListParallelListIterableTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableMutableListParallelListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = UnmodifiableMutableListParallelListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = UnmodifiableMutableListParallelListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = UnmodifiableMutableListParallelListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = UnmodifiableMutableListParallelListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = UnmodifiableMutableListParallelListIterableTest::asUnique;
            this.payloads.forEach_executionException = UnmodifiableMutableListParallelListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = UnmodifiableMutableListParallelListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = UnmodifiableMutableListParallelListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = UnmodifiableMutableListParallelListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = UnmodifiableMutableListParallelListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = UnmodifiableMutableListParallelListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = UnmodifiableMutableListParallelListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = UnmodifiableMutableListParallelListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = UnmodifiableMutableListParallelListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = UnmodifiableMutableListParallelListIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = UnmodifiableMutableListParallelListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = UnmodifiableMutableListParallelListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableMutableListParallelListIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
