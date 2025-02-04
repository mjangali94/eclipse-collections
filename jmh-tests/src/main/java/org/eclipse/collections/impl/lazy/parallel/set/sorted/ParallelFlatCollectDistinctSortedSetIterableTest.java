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

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.lazy.parallel.set.ParallelUnsortedSetIterableTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

public class ParallelFlatCollectDistinctSortedSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(4, 3, 2, 1);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.reverseNaturalOrder(), littleElements).asParallel(this.executorService, 2).flatCollect(i -> FastList.newListWith(9, 8, 7, 6, 5, 4, 3, 2, 1).select(j -> j <= i).collect(j -> i * 10 + j)).collect(i -> i / 10).asUnique();
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

        private ParallelFlatCollectDistinctSortedSetIterableTest instance;

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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelFlatCollectDistinctSortedSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectDistinctSortedSetIterableTest> groupByEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelFlatCollectDistinctSortedSetIterableTest::toArray;
            this.payloads.toArray_array = ParallelFlatCollectDistinctSortedSetIterableTest::toArray_array;
            this.payloads.forEach = ParallelFlatCollectDistinctSortedSetIterableTest::forEach;
            this.payloads.forEachWith = ParallelFlatCollectDistinctSortedSetIterableTest::forEachWith;
            this.payloads.select = ParallelFlatCollectDistinctSortedSetIterableTest::select;
            this.payloads.selectWith = ParallelFlatCollectDistinctSortedSetIterableTest::selectWith;
            this.payloads.reject = ParallelFlatCollectDistinctSortedSetIterableTest::reject;
            this.payloads.rejectWith = ParallelFlatCollectDistinctSortedSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelFlatCollectDistinctSortedSetIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelFlatCollectDistinctSortedSetIterableTest::collect;
            this.payloads.collectWith = ParallelFlatCollectDistinctSortedSetIterableTest::collectWith;
            this.payloads.collectIf = ParallelFlatCollectDistinctSortedSetIterableTest::collectIf;
            this.payloads.flatCollect = ParallelFlatCollectDistinctSortedSetIterableTest::flatCollect;
            this.payloads.detect = ParallelFlatCollectDistinctSortedSetIterableTest::detect;
            this.payloads.detectIfNone = ParallelFlatCollectDistinctSortedSetIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelFlatCollectDistinctSortedSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelFlatCollectDistinctSortedSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelFlatCollectDistinctSortedSetIterableTest::min;
            this.payloads.max = ParallelFlatCollectDistinctSortedSetIterableTest::max;
            this.payloads.minBy = ParallelFlatCollectDistinctSortedSetIterableTest::minBy;
            this.payloads.maxBy = ParallelFlatCollectDistinctSortedSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelFlatCollectDistinctSortedSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelFlatCollectDistinctSortedSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelFlatCollectDistinctSortedSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelFlatCollectDistinctSortedSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelFlatCollectDistinctSortedSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelFlatCollectDistinctSortedSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelFlatCollectDistinctSortedSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelFlatCollectDistinctSortedSetIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelFlatCollectDistinctSortedSetIterableTest::count;
            this.payloads.countWith = ParallelFlatCollectDistinctSortedSetIterableTest::countWith;
            this.payloads.toList = ParallelFlatCollectDistinctSortedSetIterableTest::toList;
            this.payloads.toSortedList = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelFlatCollectDistinctSortedSetIterableTest::toSet;
            this.payloads.toSortedSet = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelFlatCollectDistinctSortedSetIterableTest::toMap;
            this.payloads.toSortedMap = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelFlatCollectDistinctSortedSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelFlatCollectDistinctSortedSetIterableTest::testToString;
            this.payloads.makeString = ParallelFlatCollectDistinctSortedSetIterableTest::makeString;
            this.payloads.makeString_separator = ParallelFlatCollectDistinctSortedSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelFlatCollectDistinctSortedSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelFlatCollectDistinctSortedSetIterableTest::appendString;
            this.payloads.appendString_separator = ParallelFlatCollectDistinctSortedSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelFlatCollectDistinctSortedSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelFlatCollectDistinctSortedSetIterableTest::appendString_throws;
            this.payloads.groupByUniqueKey = ParallelFlatCollectDistinctSortedSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelFlatCollectDistinctSortedSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelFlatCollectDistinctSortedSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelFlatCollectDistinctSortedSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelFlatCollectDistinctSortedSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelFlatCollectDistinctSortedSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelFlatCollectDistinctSortedSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelFlatCollectDistinctSortedSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelFlatCollectDistinctSortedSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelFlatCollectDistinctSortedSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelFlatCollectDistinctSortedSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelFlatCollectDistinctSortedSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelFlatCollectDistinctSortedSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelFlatCollectDistinctSortedSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelFlatCollectDistinctSortedSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelFlatCollectDistinctSortedSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelFlatCollectDistinctSortedSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelFlatCollectDistinctSortedSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelFlatCollectDistinctSortedSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelFlatCollectDistinctSortedSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelFlatCollectDistinctSortedSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelFlatCollectDistinctSortedSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectDistinctSortedSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.groupBy = ParallelFlatCollectDistinctSortedSetIterableTest::groupBy;
            this.payloads.groupByEach = ParallelFlatCollectDistinctSortedSetIterableTest::groupByEach;
        }
    }
}
