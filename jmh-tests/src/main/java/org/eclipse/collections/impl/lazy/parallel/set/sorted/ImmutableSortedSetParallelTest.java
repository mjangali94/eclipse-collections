/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.set.sorted;

import org.eclipse.collections.api.set.sorted.ParallelSortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.SortedSets;
import org.junit.Test;

public class ImmutableSortedSetParallelTest extends ParallelSortedSetIterableTestCase {

    @Override
    protected ParallelSortedSetIterable<Integer> classUnderTest() {
        return this.newWith(4, 3, 2, 1);
    }

    @Override
    protected ParallelSortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.reverseNaturalOrder(), littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        SortedSets.immutable.with(Comparators.reverseNaturalOrder(), 4, 3, 2, 1).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        SortedSets.immutable.with(Comparators.reverseNaturalOrder(), 4, 3, 2, 1).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableSortedSetParallelTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSortedSetParallelTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSortedSetParallelTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableSortedSetParallelTest::toArray;
            this.payloads.toArray_array = ImmutableSortedSetParallelTest::toArray_array;
            this.payloads.forEach = ImmutableSortedSetParallelTest::forEach;
            this.payloads.forEachWith = ImmutableSortedSetParallelTest::forEachWith;
            this.payloads.select = ImmutableSortedSetParallelTest::select;
            this.payloads.selectWith = ImmutableSortedSetParallelTest::selectWith;
            this.payloads.reject = ImmutableSortedSetParallelTest::reject;
            this.payloads.rejectWith = ImmutableSortedSetParallelTest::rejectWith;
            this.payloads.selectInstancesOf = ImmutableSortedSetParallelTest::selectInstancesOf;
            this.payloads.collect = ImmutableSortedSetParallelTest::collect;
            this.payloads.collectWith = ImmutableSortedSetParallelTest::collectWith;
            this.payloads.collectIf = ImmutableSortedSetParallelTest::collectIf;
            this.payloads.flatCollect = ImmutableSortedSetParallelTest::flatCollect;
            this.payloads.detect = ImmutableSortedSetParallelTest::detect;
            this.payloads.detectIfNone = ImmutableSortedSetParallelTest::detectIfNone;
            this.payloads.detectWith = ImmutableSortedSetParallelTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableSortedSetParallelTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableSortedSetParallelTest::min;
            this.payloads.max = ImmutableSortedSetParallelTest::max;
            this.payloads.minBy = ImmutableSortedSetParallelTest::minBy;
            this.payloads.maxBy = ImmutableSortedSetParallelTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ImmutableSortedSetParallelTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableSortedSetParallelTest::max_without_comparator;
            this.payloads.anySatisfy = ImmutableSortedSetParallelTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableSortedSetParallelTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableSortedSetParallelTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableSortedSetParallelTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableSortedSetParallelTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableSortedSetParallelTest::noneSatisfyWith;
            this.payloads.count = ImmutableSortedSetParallelTest::count;
            this.payloads.countWith = ImmutableSortedSetParallelTest::countWith;
            this.payloads.toList = ImmutableSortedSetParallelTest::toList;
            this.payloads.toSortedList = ImmutableSortedSetParallelTest::toSortedList;
            this.payloads.toSortedList_comparator = ImmutableSortedSetParallelTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ImmutableSortedSetParallelTest::toSortedListBy;
            this.payloads.toSet = ImmutableSortedSetParallelTest::toSet;
            this.payloads.toSortedSet = ImmutableSortedSetParallelTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ImmutableSortedSetParallelTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ImmutableSortedSetParallelTest::toSortedSetBy;
            this.payloads.toSortedBag = ImmutableSortedSetParallelTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ImmutableSortedSetParallelTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ImmutableSortedSetParallelTest::toSortedBagBy;
            this.payloads.toMap = ImmutableSortedSetParallelTest::toMap;
            this.payloads.toSortedMap = ImmutableSortedSetParallelTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ImmutableSortedSetParallelTest::toSortedMap_comparator;
            this.payloads.testToString = ImmutableSortedSetParallelTest::testToString;
            this.payloads.makeString = ImmutableSortedSetParallelTest::makeString;
            this.payloads.makeString_separator = ImmutableSortedSetParallelTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ImmutableSortedSetParallelTest::makeString_start_separator_end;
            this.payloads.appendString = ImmutableSortedSetParallelTest::appendString;
            this.payloads.appendString_separator = ImmutableSortedSetParallelTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ImmutableSortedSetParallelTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ImmutableSortedSetParallelTest::appendString_throws;
            this.payloads.groupBy = ImmutableSortedSetParallelTest::groupBy;
            this.payloads.groupByEach = ImmutableSortedSetParallelTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableSortedSetParallelTest::groupByUniqueKey;
            this.payloads.aggregateBy = ImmutableSortedSetParallelTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ImmutableSortedSetParallelTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ImmutableSortedSetParallelTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableSortedSetParallelTest::sumOfLong;
            this.payloads.sumOfFloat = ImmutableSortedSetParallelTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ImmutableSortedSetParallelTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ImmutableSortedSetParallelTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableSortedSetParallelTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ImmutableSortedSetParallelTest::asUnique;
            this.payloads.forEach_executionException = ImmutableSortedSetParallelTest::forEach_executionException;
            this.payloads.collect_executionException = ImmutableSortedSetParallelTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ImmutableSortedSetParallelTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ImmutableSortedSetParallelTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ImmutableSortedSetParallelTest::detect_executionException;
            this.payloads.forEach_interruptedException = ImmutableSortedSetParallelTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ImmutableSortedSetParallelTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ImmutableSortedSetParallelTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ImmutableSortedSetParallelTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ImmutableSortedSetParallelTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ImmutableSortedSetParallelTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ImmutableSortedSetParallelTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableSortedSetParallelTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
