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

import java.util.TreeSet;
import org.eclipse.collections.api.set.sorted.ParallelSortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.set.sorted.mutable.SortedSetAdapter;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

public class SortedSetAdapterParallelSetIterableTest extends NonParallelSortedSetIterableTestCase {

    @Override
    protected ParallelSortedSetIterable<Integer> classUnderTest() {
        return this.newWith(4, 3, 2, 1);
    }

    @Override
    protected ParallelSortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SortedSetAdapter.adapt(new TreeSet<>(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), littleElements))).asParallel(this.executorService, this.batchSize);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SortedSetAdapterParallelSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SortedSetAdapterParallelSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SortedSetAdapterParallelSetIterableTest> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = SortedSetAdapterParallelSetIterableTest::toArray;
            this.payloads.toArray_array = SortedSetAdapterParallelSetIterableTest::toArray_array;
            this.payloads.forEach = SortedSetAdapterParallelSetIterableTest::forEach;
            this.payloads.forEachWith = SortedSetAdapterParallelSetIterableTest::forEachWith;
            this.payloads.select = SortedSetAdapterParallelSetIterableTest::select;
            this.payloads.selectWith = SortedSetAdapterParallelSetIterableTest::selectWith;
            this.payloads.reject = SortedSetAdapterParallelSetIterableTest::reject;
            this.payloads.rejectWith = SortedSetAdapterParallelSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = SortedSetAdapterParallelSetIterableTest::selectInstancesOf;
            this.payloads.collect = SortedSetAdapterParallelSetIterableTest::collect;
            this.payloads.collectWith = SortedSetAdapterParallelSetIterableTest::collectWith;
            this.payloads.collectIf = SortedSetAdapterParallelSetIterableTest::collectIf;
            this.payloads.flatCollect = SortedSetAdapterParallelSetIterableTest::flatCollect;
            this.payloads.detect = SortedSetAdapterParallelSetIterableTest::detect;
            this.payloads.detectIfNone = SortedSetAdapterParallelSetIterableTest::detectIfNone;
            this.payloads.detectWith = SortedSetAdapterParallelSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = SortedSetAdapterParallelSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = SortedSetAdapterParallelSetIterableTest::min;
            this.payloads.max = SortedSetAdapterParallelSetIterableTest::max;
            this.payloads.minBy = SortedSetAdapterParallelSetIterableTest::minBy;
            this.payloads.maxBy = SortedSetAdapterParallelSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = SortedSetAdapterParallelSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = SortedSetAdapterParallelSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = SortedSetAdapterParallelSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = SortedSetAdapterParallelSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = SortedSetAdapterParallelSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = SortedSetAdapterParallelSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = SortedSetAdapterParallelSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SortedSetAdapterParallelSetIterableTest::noneSatisfyWith;
            this.payloads.count = SortedSetAdapterParallelSetIterableTest::count;
            this.payloads.countWith = SortedSetAdapterParallelSetIterableTest::countWith;
            this.payloads.toList = SortedSetAdapterParallelSetIterableTest::toList;
            this.payloads.toSortedList = SortedSetAdapterParallelSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = SortedSetAdapterParallelSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = SortedSetAdapterParallelSetIterableTest::toSortedListBy;
            this.payloads.toSet = SortedSetAdapterParallelSetIterableTest::toSet;
            this.payloads.toSortedSet = SortedSetAdapterParallelSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = SortedSetAdapterParallelSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = SortedSetAdapterParallelSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = SortedSetAdapterParallelSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = SortedSetAdapterParallelSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = SortedSetAdapterParallelSetIterableTest::toSortedBagBy;
            this.payloads.toMap = SortedSetAdapterParallelSetIterableTest::toMap;
            this.payloads.toSortedMap = SortedSetAdapterParallelSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = SortedSetAdapterParallelSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = SortedSetAdapterParallelSetIterableTest::testToString;
            this.payloads.makeString = SortedSetAdapterParallelSetIterableTest::makeString;
            this.payloads.makeString_separator = SortedSetAdapterParallelSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = SortedSetAdapterParallelSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = SortedSetAdapterParallelSetIterableTest::appendString;
            this.payloads.appendString_separator = SortedSetAdapterParallelSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = SortedSetAdapterParallelSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = SortedSetAdapterParallelSetIterableTest::appendString_throws;
            this.payloads.groupBy = SortedSetAdapterParallelSetIterableTest::groupBy;
            this.payloads.groupByEach = SortedSetAdapterParallelSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = SortedSetAdapterParallelSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = SortedSetAdapterParallelSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = SortedSetAdapterParallelSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = SortedSetAdapterParallelSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = SortedSetAdapterParallelSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = SortedSetAdapterParallelSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = SortedSetAdapterParallelSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = SortedSetAdapterParallelSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = SortedSetAdapterParallelSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = SortedSetAdapterParallelSetIterableTest::asUnique;
            this.payloads.minWithEmptyBatch = SortedSetAdapterParallelSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = SortedSetAdapterParallelSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SortedSetAdapterParallelSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEach_executionException = SortedSetAdapterParallelSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = SortedSetAdapterParallelSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = SortedSetAdapterParallelSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = SortedSetAdapterParallelSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = SortedSetAdapterParallelSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = SortedSetAdapterParallelSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = SortedSetAdapterParallelSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = SortedSetAdapterParallelSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = SortedSetAdapterParallelSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = SortedSetAdapterParallelSetIterableTest::toString_interruptedException;
        }
    }
}
