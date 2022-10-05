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

import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Test;

public class ImmutableListParallelListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return Lists.immutable.with(littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        Lists.immutable.with(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        Lists.immutable.with(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableListParallelListIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray_array() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray_array);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_separator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_start_separator_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_separator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_separator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_start_separator_end() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_start_separator_end);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_executionException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_executionException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy_executionException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy_executionException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_executionException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_executionException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach_interruptedException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy_interruptedException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy_interruptedException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_interruptedException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_interruptedException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toString_interruptedException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minWithEmptyBatch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minWithEmptyBatch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxWithEmptyBatch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxWithEmptyBatch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_small_batch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_small_batch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_null_executorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_null_executorService);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableListParallelListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableListParallelListIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableListParallelListIterableTest::toArray;
            this.payloads.toArray_array = ImmutableListParallelListIterableTest::toArray_array;
            this.payloads.forEach = ImmutableListParallelListIterableTest::forEach;
            this.payloads.forEachWith = ImmutableListParallelListIterableTest::forEachWith;
            this.payloads.select = ImmutableListParallelListIterableTest::select;
            this.payloads.selectWith = ImmutableListParallelListIterableTest::selectWith;
            this.payloads.reject = ImmutableListParallelListIterableTest::reject;
            this.payloads.rejectWith = ImmutableListParallelListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ImmutableListParallelListIterableTest::selectInstancesOf;
            this.payloads.collect = ImmutableListParallelListIterableTest::collect;
            this.payloads.collectWith = ImmutableListParallelListIterableTest::collectWith;
            this.payloads.collectIf = ImmutableListParallelListIterableTest::collectIf;
            this.payloads.flatCollect = ImmutableListParallelListIterableTest::flatCollect;
            this.payloads.detect = ImmutableListParallelListIterableTest::detect;
            this.payloads.detectIfNone = ImmutableListParallelListIterableTest::detectIfNone;
            this.payloads.detectWith = ImmutableListParallelListIterableTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableListParallelListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableListParallelListIterableTest::min;
            this.payloads.max = ImmutableListParallelListIterableTest::max;
            this.payloads.minBy = ImmutableListParallelListIterableTest::minBy;
            this.payloads.maxBy = ImmutableListParallelListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ImmutableListParallelListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableListParallelListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ImmutableListParallelListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableListParallelListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableListParallelListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableListParallelListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableListParallelListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableListParallelListIterableTest::noneSatisfyWith;
            this.payloads.count = ImmutableListParallelListIterableTest::count;
            this.payloads.countWith = ImmutableListParallelListIterableTest::countWith;
            this.payloads.toList = ImmutableListParallelListIterableTest::toList;
            this.payloads.toSortedList = ImmutableListParallelListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ImmutableListParallelListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ImmutableListParallelListIterableTest::toSortedListBy;
            this.payloads.toSet = ImmutableListParallelListIterableTest::toSet;
            this.payloads.toSortedSet = ImmutableListParallelListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ImmutableListParallelListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ImmutableListParallelListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ImmutableListParallelListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ImmutableListParallelListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ImmutableListParallelListIterableTest::toSortedBagBy;
            this.payloads.toMap = ImmutableListParallelListIterableTest::toMap;
            this.payloads.toSortedMap = ImmutableListParallelListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ImmutableListParallelListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ImmutableListParallelListIterableTest::testToString;
            this.payloads.makeString = ImmutableListParallelListIterableTest::makeString;
            this.payloads.makeString_separator = ImmutableListParallelListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ImmutableListParallelListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ImmutableListParallelListIterableTest::appendString;
            this.payloads.appendString_separator = ImmutableListParallelListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ImmutableListParallelListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ImmutableListParallelListIterableTest::appendString_throws;
            this.payloads.groupBy = ImmutableListParallelListIterableTest::groupBy;
            this.payloads.groupByEach = ImmutableListParallelListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableListParallelListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ImmutableListParallelListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ImmutableListParallelListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ImmutableListParallelListIterableTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableListParallelListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ImmutableListParallelListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ImmutableListParallelListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ImmutableListParallelListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableListParallelListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ImmutableListParallelListIterableTest::asUnique;
            this.payloads.forEach_executionException = ImmutableListParallelListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ImmutableListParallelListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ImmutableListParallelListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ImmutableListParallelListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ImmutableListParallelListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ImmutableListParallelListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ImmutableListParallelListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ImmutableListParallelListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ImmutableListParallelListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ImmutableListParallelListIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ImmutableListParallelListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ImmutableListParallelListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableListParallelListIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
