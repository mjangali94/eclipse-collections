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

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

public class ParallelFlatCollectDistinctSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(4, 3, 2, 1);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return (ParallelUnsortedSetIterable<Integer>) UnifiedSet.newSetWith(littleElements).asParallel(this.executorService, 2).flatCollect(i -> FastList.newListWith(9, 8, 7, 6, 5, 4, 3, 2, 1).select(j -> j <= i).collect(j -> i * 10 + j)).collect(i -> i / 10).asUnique();
    }

    @Test
    @Override
    public void groupBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Assert.assertEquals(this.getExpected().toSet().groupBy(isOddFunction), this.classUnderTest().groupBy(isOddFunction));
    }

    @Test
    @Override
    public void groupByEach() {
        Assert.assertEquals(this.getExpected().toSet().groupByEach(new NegativeIntervalFunction()), this.classUnderTest().groupByEach(new NegativeIntervalFunction()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelFlatCollectDistinctSetIterableTest instance;

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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelFlatCollectDistinctSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSetIterableTest> groupByEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelFlatCollectDistinctSetIterableTest::toArray;
            this.payloads.toArray_array = ParallelFlatCollectDistinctSetIterableTest::toArray_array;
            this.payloads.forEach = ParallelFlatCollectDistinctSetIterableTest::forEach;
            this.payloads.forEachWith = ParallelFlatCollectDistinctSetIterableTest::forEachWith;
            this.payloads.select = ParallelFlatCollectDistinctSetIterableTest::select;
            this.payloads.selectWith = ParallelFlatCollectDistinctSetIterableTest::selectWith;
            this.payloads.reject = ParallelFlatCollectDistinctSetIterableTest::reject;
            this.payloads.rejectWith = ParallelFlatCollectDistinctSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelFlatCollectDistinctSetIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelFlatCollectDistinctSetIterableTest::collect;
            this.payloads.collectWith = ParallelFlatCollectDistinctSetIterableTest::collectWith;
            this.payloads.collectIf = ParallelFlatCollectDistinctSetIterableTest::collectIf;
            this.payloads.flatCollect = ParallelFlatCollectDistinctSetIterableTest::flatCollect;
            this.payloads.detect = ParallelFlatCollectDistinctSetIterableTest::detect;
            this.payloads.detectIfNone = ParallelFlatCollectDistinctSetIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelFlatCollectDistinctSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelFlatCollectDistinctSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelFlatCollectDistinctSetIterableTest::min;
            this.payloads.max = ParallelFlatCollectDistinctSetIterableTest::max;
            this.payloads.minBy = ParallelFlatCollectDistinctSetIterableTest::minBy;
            this.payloads.maxBy = ParallelFlatCollectDistinctSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelFlatCollectDistinctSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelFlatCollectDistinctSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelFlatCollectDistinctSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelFlatCollectDistinctSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelFlatCollectDistinctSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelFlatCollectDistinctSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelFlatCollectDistinctSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelFlatCollectDistinctSetIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelFlatCollectDistinctSetIterableTest::count;
            this.payloads.countWith = ParallelFlatCollectDistinctSetIterableTest::countWith;
            this.payloads.toList = ParallelFlatCollectDistinctSetIterableTest::toList;
            this.payloads.toSortedList = ParallelFlatCollectDistinctSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelFlatCollectDistinctSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelFlatCollectDistinctSetIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelFlatCollectDistinctSetIterableTest::toSet;
            this.payloads.toSortedSet = ParallelFlatCollectDistinctSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelFlatCollectDistinctSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelFlatCollectDistinctSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelFlatCollectDistinctSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelFlatCollectDistinctSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelFlatCollectDistinctSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelFlatCollectDistinctSetIterableTest::toMap;
            this.payloads.toSortedMap = ParallelFlatCollectDistinctSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelFlatCollectDistinctSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelFlatCollectDistinctSetIterableTest::testToString;
            this.payloads.makeString = ParallelFlatCollectDistinctSetIterableTest::makeString;
            this.payloads.makeString_separator = ParallelFlatCollectDistinctSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelFlatCollectDistinctSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelFlatCollectDistinctSetIterableTest::appendString;
            this.payloads.appendString_separator = ParallelFlatCollectDistinctSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelFlatCollectDistinctSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelFlatCollectDistinctSetIterableTest::appendString_throws;
            this.payloads.groupByUniqueKey = ParallelFlatCollectDistinctSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelFlatCollectDistinctSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelFlatCollectDistinctSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelFlatCollectDistinctSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelFlatCollectDistinctSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelFlatCollectDistinctSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelFlatCollectDistinctSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelFlatCollectDistinctSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelFlatCollectDistinctSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelFlatCollectDistinctSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelFlatCollectDistinctSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelFlatCollectDistinctSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelFlatCollectDistinctSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelFlatCollectDistinctSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelFlatCollectDistinctSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelFlatCollectDistinctSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelFlatCollectDistinctSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelFlatCollectDistinctSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelFlatCollectDistinctSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelFlatCollectDistinctSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelFlatCollectDistinctSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelFlatCollectDistinctSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.groupBy = ParallelFlatCollectDistinctSetIterableTest::groupBy;
            this.payloads.groupByEach = ParallelFlatCollectDistinctSetIterableTest::groupByEach;
        }
    }
}
