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
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

public class ParallelCollectDistinctSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(44, 43, 42, 41, 33, 32, 31, 22, 21, 11);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return (ParallelUnsortedSetIterable<Integer>) UnifiedSet.newSetWith(littleElements).asParallel(this.executorService, this.batchSize).collect(i -> i / 10).asUnique();
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).collect(i -> i / 10).toSet();
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

        private ParallelCollectDistinctSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelCollectDistinctSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectDistinctSetIterableTest> groupByEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelCollectDistinctSetIterableTest::toArray;
            this.payloads.toArray_array = ParallelCollectDistinctSetIterableTest::toArray_array;
            this.payloads.forEach = ParallelCollectDistinctSetIterableTest::forEach;
            this.payloads.forEachWith = ParallelCollectDistinctSetIterableTest::forEachWith;
            this.payloads.select = ParallelCollectDistinctSetIterableTest::select;
            this.payloads.selectWith = ParallelCollectDistinctSetIterableTest::selectWith;
            this.payloads.reject = ParallelCollectDistinctSetIterableTest::reject;
            this.payloads.rejectWith = ParallelCollectDistinctSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelCollectDistinctSetIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelCollectDistinctSetIterableTest::collect;
            this.payloads.collectWith = ParallelCollectDistinctSetIterableTest::collectWith;
            this.payloads.collectIf = ParallelCollectDistinctSetIterableTest::collectIf;
            this.payloads.flatCollect = ParallelCollectDistinctSetIterableTest::flatCollect;
            this.payloads.detect = ParallelCollectDistinctSetIterableTest::detect;
            this.payloads.detectIfNone = ParallelCollectDistinctSetIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelCollectDistinctSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelCollectDistinctSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelCollectDistinctSetIterableTest::min;
            this.payloads.max = ParallelCollectDistinctSetIterableTest::max;
            this.payloads.minBy = ParallelCollectDistinctSetIterableTest::minBy;
            this.payloads.maxBy = ParallelCollectDistinctSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelCollectDistinctSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelCollectDistinctSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelCollectDistinctSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelCollectDistinctSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelCollectDistinctSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelCollectDistinctSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelCollectDistinctSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelCollectDistinctSetIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelCollectDistinctSetIterableTest::count;
            this.payloads.countWith = ParallelCollectDistinctSetIterableTest::countWith;
            this.payloads.toList = ParallelCollectDistinctSetIterableTest::toList;
            this.payloads.toSortedList = ParallelCollectDistinctSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelCollectDistinctSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelCollectDistinctSetIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelCollectDistinctSetIterableTest::toSet;
            this.payloads.toSortedSet = ParallelCollectDistinctSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelCollectDistinctSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelCollectDistinctSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelCollectDistinctSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelCollectDistinctSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelCollectDistinctSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelCollectDistinctSetIterableTest::toMap;
            this.payloads.toSortedMap = ParallelCollectDistinctSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelCollectDistinctSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelCollectDistinctSetIterableTest::testToString;
            this.payloads.makeString = ParallelCollectDistinctSetIterableTest::makeString;
            this.payloads.makeString_separator = ParallelCollectDistinctSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelCollectDistinctSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelCollectDistinctSetIterableTest::appendString;
            this.payloads.appendString_separator = ParallelCollectDistinctSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelCollectDistinctSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelCollectDistinctSetIterableTest::appendString_throws;
            this.payloads.groupByUniqueKey = ParallelCollectDistinctSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelCollectDistinctSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelCollectDistinctSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelCollectDistinctSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelCollectDistinctSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelCollectDistinctSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelCollectDistinctSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelCollectDistinctSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelCollectDistinctSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelCollectDistinctSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelCollectDistinctSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelCollectDistinctSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelCollectDistinctSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelCollectDistinctSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelCollectDistinctSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelCollectDistinctSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelCollectDistinctSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelCollectDistinctSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelCollectDistinctSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelCollectDistinctSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelCollectDistinctSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelCollectDistinctSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectDistinctSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.groupBy = ParallelCollectDistinctSetIterableTest::groupBy;
            this.payloads.groupByEach = ParallelCollectDistinctSetIterableTest::groupByEach;
        }
    }
}
