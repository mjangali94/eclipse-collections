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

import org.eclipse.collections.api.set.sorted.ParallelSortedSetIterable;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.lazy.parallel.set.sorted.ParallelSortedSetIterableTestCase;

public class ImmutableTreeSetParallelSetIterableTest extends ParallelSortedSetIterableTestCase {

    @Override
    protected ParallelSortedSetIterable<Integer> classUnderTest() {
        return this.newWith(4, 3, 2, 1);
    }

    @Override
    protected ParallelSortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.reverseNaturalOrder(), littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Override
    protected SortedSetIterable<Integer> getExpectedWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.reverseNaturalOrder(), littleElements);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableTreeSetParallelSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableTreeSetParallelSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTreeSetParallelSetIterableTest> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableTreeSetParallelSetIterableTest::toArray;
            this.payloads.toArray_array = ImmutableTreeSetParallelSetIterableTest::toArray_array;
            this.payloads.forEach = ImmutableTreeSetParallelSetIterableTest::forEach;
            this.payloads.forEachWith = ImmutableTreeSetParallelSetIterableTest::forEachWith;
            this.payloads.select = ImmutableTreeSetParallelSetIterableTest::select;
            this.payloads.selectWith = ImmutableTreeSetParallelSetIterableTest::selectWith;
            this.payloads.reject = ImmutableTreeSetParallelSetIterableTest::reject;
            this.payloads.rejectWith = ImmutableTreeSetParallelSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ImmutableTreeSetParallelSetIterableTest::selectInstancesOf;
            this.payloads.collect = ImmutableTreeSetParallelSetIterableTest::collect;
            this.payloads.collectWith = ImmutableTreeSetParallelSetIterableTest::collectWith;
            this.payloads.collectIf = ImmutableTreeSetParallelSetIterableTest::collectIf;
            this.payloads.flatCollect = ImmutableTreeSetParallelSetIterableTest::flatCollect;
            this.payloads.detect = ImmutableTreeSetParallelSetIterableTest::detect;
            this.payloads.detectIfNone = ImmutableTreeSetParallelSetIterableTest::detectIfNone;
            this.payloads.detectWith = ImmutableTreeSetParallelSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableTreeSetParallelSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableTreeSetParallelSetIterableTest::min;
            this.payloads.max = ImmutableTreeSetParallelSetIterableTest::max;
            this.payloads.minBy = ImmutableTreeSetParallelSetIterableTest::minBy;
            this.payloads.maxBy = ImmutableTreeSetParallelSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ImmutableTreeSetParallelSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableTreeSetParallelSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ImmutableTreeSetParallelSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableTreeSetParallelSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableTreeSetParallelSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableTreeSetParallelSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableTreeSetParallelSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableTreeSetParallelSetIterableTest::noneSatisfyWith;
            this.payloads.count = ImmutableTreeSetParallelSetIterableTest::count;
            this.payloads.countWith = ImmutableTreeSetParallelSetIterableTest::countWith;
            this.payloads.toList = ImmutableTreeSetParallelSetIterableTest::toList;
            this.payloads.toSortedList = ImmutableTreeSetParallelSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ImmutableTreeSetParallelSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ImmutableTreeSetParallelSetIterableTest::toSortedListBy;
            this.payloads.toSet = ImmutableTreeSetParallelSetIterableTest::toSet;
            this.payloads.toSortedSet = ImmutableTreeSetParallelSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ImmutableTreeSetParallelSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ImmutableTreeSetParallelSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ImmutableTreeSetParallelSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ImmutableTreeSetParallelSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ImmutableTreeSetParallelSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ImmutableTreeSetParallelSetIterableTest::toMap;
            this.payloads.toSortedMap = ImmutableTreeSetParallelSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ImmutableTreeSetParallelSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ImmutableTreeSetParallelSetIterableTest::testToString;
            this.payloads.makeString = ImmutableTreeSetParallelSetIterableTest::makeString;
            this.payloads.makeString_separator = ImmutableTreeSetParallelSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ImmutableTreeSetParallelSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ImmutableTreeSetParallelSetIterableTest::appendString;
            this.payloads.appendString_separator = ImmutableTreeSetParallelSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ImmutableTreeSetParallelSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ImmutableTreeSetParallelSetIterableTest::appendString_throws;
            this.payloads.groupBy = ImmutableTreeSetParallelSetIterableTest::groupBy;
            this.payloads.groupByEach = ImmutableTreeSetParallelSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableTreeSetParallelSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ImmutableTreeSetParallelSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ImmutableTreeSetParallelSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ImmutableTreeSetParallelSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableTreeSetParallelSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ImmutableTreeSetParallelSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ImmutableTreeSetParallelSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ImmutableTreeSetParallelSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableTreeSetParallelSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ImmutableTreeSetParallelSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ImmutableTreeSetParallelSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ImmutableTreeSetParallelSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ImmutableTreeSetParallelSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ImmutableTreeSetParallelSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ImmutableTreeSetParallelSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ImmutableTreeSetParallelSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ImmutableTreeSetParallelSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ImmutableTreeSetParallelSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ImmutableTreeSetParallelSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ImmutableTreeSetParallelSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ImmutableTreeSetParallelSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ImmutableTreeSetParallelSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableTreeSetParallelSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
}
