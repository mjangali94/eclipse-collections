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

import org.eclipse.collections.api.ParallelIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.MultiReaderHashBag;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.MultiReaderUnifiedSet;
import org.junit.Assert;
import org.junit.Test;

public class ParallelFlatCollectMultiReaderSetIterableTest extends ParallelIterableTestCase {

    @Override
    protected ParallelIterable<Integer> classUnderTest() {
        return this.newWith(4, 3, 2, 1);
    }

    @Override
    protected ParallelIterable<Integer> newWith(Integer... littleElements) {
        return MultiReaderUnifiedSet.newSetWith(littleElements).asParallel(this.executorService, 2).flatCollect(i -> FastList.newListWith(9, 8, 7, 6, 5, 4, 3, 2, 1).select(j -> j <= i).collect(j -> i * 10 + j)).collect(i -> i / 10);
    }

    @Override
    protected MutableBag<Integer> getExpected() {
        return HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected MutableBag<Integer> getExpectedWith(Integer... littleElements) {
        return MultiReaderHashBag.newBagWith(littleElements).flatCollect(i -> FastList.newListWith(9, 8, 7, 6, 5, 4, 3, 2, 1).select(j -> j <= i).collect(j -> i * 10 + j)).collect(i -> i / 10);
    }

    @Override
    protected boolean isOrdered() {
        return false;
    }

    @Override
    protected boolean isUnique() {
        return false;
    }

    @Test
    @Override
    public void groupBy() {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        Assert.assertEquals(this.getExpected().toBag().groupBy(isOddFunction), this.classUnderTest().groupBy(isOddFunction));
    }

    @Test
    @Override
    public void groupByEach() {
        Assert.assertEquals(this.getExpected().toBag().groupByEach(new NegativeIntervalFunction()), this.classUnderTest().groupByEach(new NegativeIntervalFunction()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelFlatCollectMultiReaderSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelFlatCollectMultiReaderSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelFlatCollectMultiReaderSetIterableTest> groupByEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelFlatCollectMultiReaderSetIterableTest::toArray;
            this.payloads.toArray_array = ParallelFlatCollectMultiReaderSetIterableTest::toArray_array;
            this.payloads.forEach = ParallelFlatCollectMultiReaderSetIterableTest::forEach;
            this.payloads.forEachWith = ParallelFlatCollectMultiReaderSetIterableTest::forEachWith;
            this.payloads.select = ParallelFlatCollectMultiReaderSetIterableTest::select;
            this.payloads.selectWith = ParallelFlatCollectMultiReaderSetIterableTest::selectWith;
            this.payloads.reject = ParallelFlatCollectMultiReaderSetIterableTest::reject;
            this.payloads.rejectWith = ParallelFlatCollectMultiReaderSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelFlatCollectMultiReaderSetIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelFlatCollectMultiReaderSetIterableTest::collect;
            this.payloads.collectWith = ParallelFlatCollectMultiReaderSetIterableTest::collectWith;
            this.payloads.collectIf = ParallelFlatCollectMultiReaderSetIterableTest::collectIf;
            this.payloads.flatCollect = ParallelFlatCollectMultiReaderSetIterableTest::flatCollect;
            this.payloads.detect = ParallelFlatCollectMultiReaderSetIterableTest::detect;
            this.payloads.detectIfNone = ParallelFlatCollectMultiReaderSetIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelFlatCollectMultiReaderSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelFlatCollectMultiReaderSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelFlatCollectMultiReaderSetIterableTest::min;
            this.payloads.max = ParallelFlatCollectMultiReaderSetIterableTest::max;
            this.payloads.minBy = ParallelFlatCollectMultiReaderSetIterableTest::minBy;
            this.payloads.maxBy = ParallelFlatCollectMultiReaderSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelFlatCollectMultiReaderSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelFlatCollectMultiReaderSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelFlatCollectMultiReaderSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelFlatCollectMultiReaderSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelFlatCollectMultiReaderSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelFlatCollectMultiReaderSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelFlatCollectMultiReaderSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelFlatCollectMultiReaderSetIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelFlatCollectMultiReaderSetIterableTest::count;
            this.payloads.countWith = ParallelFlatCollectMultiReaderSetIterableTest::countWith;
            this.payloads.toList = ParallelFlatCollectMultiReaderSetIterableTest::toList;
            this.payloads.toSortedList = ParallelFlatCollectMultiReaderSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelFlatCollectMultiReaderSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelFlatCollectMultiReaderSetIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelFlatCollectMultiReaderSetIterableTest::toSet;
            this.payloads.toSortedSet = ParallelFlatCollectMultiReaderSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelFlatCollectMultiReaderSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelFlatCollectMultiReaderSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelFlatCollectMultiReaderSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelFlatCollectMultiReaderSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelFlatCollectMultiReaderSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelFlatCollectMultiReaderSetIterableTest::toMap;
            this.payloads.toSortedMap = ParallelFlatCollectMultiReaderSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelFlatCollectMultiReaderSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelFlatCollectMultiReaderSetIterableTest::testToString;
            this.payloads.makeString = ParallelFlatCollectMultiReaderSetIterableTest::makeString;
            this.payloads.makeString_separator = ParallelFlatCollectMultiReaderSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelFlatCollectMultiReaderSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelFlatCollectMultiReaderSetIterableTest::appendString;
            this.payloads.appendString_separator = ParallelFlatCollectMultiReaderSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelFlatCollectMultiReaderSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelFlatCollectMultiReaderSetIterableTest::appendString_throws;
            this.payloads.groupByUniqueKey = ParallelFlatCollectMultiReaderSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelFlatCollectMultiReaderSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelFlatCollectMultiReaderSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelFlatCollectMultiReaderSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelFlatCollectMultiReaderSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelFlatCollectMultiReaderSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelFlatCollectMultiReaderSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelFlatCollectMultiReaderSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelFlatCollectMultiReaderSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelFlatCollectMultiReaderSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelFlatCollectMultiReaderSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelFlatCollectMultiReaderSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelFlatCollectMultiReaderSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelFlatCollectMultiReaderSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelFlatCollectMultiReaderSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelFlatCollectMultiReaderSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelFlatCollectMultiReaderSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelFlatCollectMultiReaderSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelFlatCollectMultiReaderSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelFlatCollectMultiReaderSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelFlatCollectMultiReaderSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelFlatCollectMultiReaderSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelFlatCollectMultiReaderSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.groupBy = ParallelFlatCollectMultiReaderSetIterableTest::groupBy;
            this.payloads.groupByEach = ParallelFlatCollectMultiReaderSetIterableTest::groupByEach;
        }
    }
}
