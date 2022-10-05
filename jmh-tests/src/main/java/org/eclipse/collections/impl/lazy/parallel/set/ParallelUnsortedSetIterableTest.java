/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.set;

import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Test;

public class ParallelUnsortedSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 3, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return UnifiedSet.newSetWith(littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        UnifiedSet.newSetWith(1, 2, 3, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        UnifiedSet.newSetWith(1, 2, 3, 4).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelUnsortedSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelUnsortedSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelUnsortedSetIterableTest::toArray;
            this.payloads.toArray_array = ParallelUnsortedSetIterableTest::toArray_array;
            this.payloads.forEach = ParallelUnsortedSetIterableTest::forEach;
            this.payloads.forEachWith = ParallelUnsortedSetIterableTest::forEachWith;
            this.payloads.select = ParallelUnsortedSetIterableTest::select;
            this.payloads.selectWith = ParallelUnsortedSetIterableTest::selectWith;
            this.payloads.reject = ParallelUnsortedSetIterableTest::reject;
            this.payloads.rejectWith = ParallelUnsortedSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelUnsortedSetIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelUnsortedSetIterableTest::collect;
            this.payloads.collectWith = ParallelUnsortedSetIterableTest::collectWith;
            this.payloads.collectIf = ParallelUnsortedSetIterableTest::collectIf;
            this.payloads.flatCollect = ParallelUnsortedSetIterableTest::flatCollect;
            this.payloads.detect = ParallelUnsortedSetIterableTest::detect;
            this.payloads.detectIfNone = ParallelUnsortedSetIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelUnsortedSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelUnsortedSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelUnsortedSetIterableTest::min;
            this.payloads.max = ParallelUnsortedSetIterableTest::max;
            this.payloads.minBy = ParallelUnsortedSetIterableTest::minBy;
            this.payloads.maxBy = ParallelUnsortedSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelUnsortedSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelUnsortedSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelUnsortedSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelUnsortedSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelUnsortedSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelUnsortedSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelUnsortedSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelUnsortedSetIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelUnsortedSetIterableTest::count;
            this.payloads.countWith = ParallelUnsortedSetIterableTest::countWith;
            this.payloads.toList = ParallelUnsortedSetIterableTest::toList;
            this.payloads.toSortedList = ParallelUnsortedSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelUnsortedSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelUnsortedSetIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelUnsortedSetIterableTest::toSet;
            this.payloads.toSortedSet = ParallelUnsortedSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelUnsortedSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelUnsortedSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelUnsortedSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelUnsortedSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelUnsortedSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelUnsortedSetIterableTest::toMap;
            this.payloads.toSortedMap = ParallelUnsortedSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelUnsortedSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelUnsortedSetIterableTest::testToString;
            this.payloads.makeString = ParallelUnsortedSetIterableTest::makeString;
            this.payloads.makeString_separator = ParallelUnsortedSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelUnsortedSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelUnsortedSetIterableTest::appendString;
            this.payloads.appendString_separator = ParallelUnsortedSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelUnsortedSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelUnsortedSetIterableTest::appendString_throws;
            this.payloads.groupBy = ParallelUnsortedSetIterableTest::groupBy;
            this.payloads.groupByEach = ParallelUnsortedSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ParallelUnsortedSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelUnsortedSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelUnsortedSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelUnsortedSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelUnsortedSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelUnsortedSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelUnsortedSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelUnsortedSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelUnsortedSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelUnsortedSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelUnsortedSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelUnsortedSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelUnsortedSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelUnsortedSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelUnsortedSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelUnsortedSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelUnsortedSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelUnsortedSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelUnsortedSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelUnsortedSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelUnsortedSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelUnsortedSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
