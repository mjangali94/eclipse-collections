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
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.junit.Assert;
import org.junit.Test;

public class UnifiedSetWithHashingStrategyParallelCollectDistinctTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(11, 21, 22, 31, 32, 33, 41, 42, 43, 44);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return (ParallelUnsortedSetIterable<Integer>) UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), littleElements).asParallel(this.executorService, this.batchSize).collect(i -> i / 10).asUnique();
    }

    @Override
    protected UnifiedSet<Integer> getExpectedWith(Integer... littleElements) {
        return UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), littleElements).collect(i -> i / 10);
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetWithHashingStrategyParallelCollectDistinctTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetWithHashingStrategyParallelCollectDistinctTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyParallelCollectDistinctTest> groupByEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toArray;
            this.payloads.toArray_array = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toArray_array;
            this.payloads.forEach = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::forEach;
            this.payloads.forEachWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::forEachWith;
            this.payloads.select = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::select;
            this.payloads.selectWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::selectWith;
            this.payloads.reject = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::reject;
            this.payloads.rejectWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::rejectWith;
            this.payloads.selectInstancesOf = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::selectInstancesOf;
            this.payloads.collect = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::collect;
            this.payloads.collectWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::collectWith;
            this.payloads.collectIf = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::collectIf;
            this.payloads.flatCollect = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::flatCollect;
            this.payloads.detect = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::detect;
            this.payloads.detectIfNone = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::detectIfNone;
            this.payloads.detectWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::detectWith;
            this.payloads.detectWithIfNone = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::min;
            this.payloads.max = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::max;
            this.payloads.minBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::minBy;
            this.payloads.maxBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::min_without_comparator;
            this.payloads.max_without_comparator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::max_without_comparator;
            this.payloads.anySatisfy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::noneSatisfyWith;
            this.payloads.count = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::count;
            this.payloads.countWith = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::countWith;
            this.payloads.toList = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toList;
            this.payloads.toSortedList = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedList;
            this.payloads.toSortedList_comparator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedList_comparator;
            this.payloads.toSortedListBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedListBy;
            this.payloads.toSet = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSet;
            this.payloads.toSortedSet = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedSet;
            this.payloads.toSortedSet_comparator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedSetBy;
            this.payloads.toSortedBag = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedBag;
            this.payloads.toSortedBag_comparator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedBagBy;
            this.payloads.toMap = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toMap;
            this.payloads.toSortedMap = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedMap;
            this.payloads.toSortedMap_comparator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toSortedMap_comparator;
            this.payloads.testToString = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::testToString;
            this.payloads.makeString = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::makeString;
            this.payloads.makeString_separator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::makeString_separator;
            this.payloads.makeString_start_separator_end = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::makeString_start_separator_end;
            this.payloads.appendString = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::appendString;
            this.payloads.appendString_separator = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::appendString_separator;
            this.payloads.appendString_start_separator_end = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::appendString_start_separator_end;
            this.payloads.appendString_throws = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::appendString_throws;
            this.payloads.groupByUniqueKey = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::groupByUniqueKey;
            this.payloads.aggregateBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::sumOfInt;
            this.payloads.sumOfLong = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::sumOfLong;
            this.payloads.sumOfFloat = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::asUnique;
            this.payloads.forEach_executionException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::forEach_executionException;
            this.payloads.collect_executionException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::collect_executionException;
            this.payloads.anySatisfy_executionException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::allSatisfy_executionException;
            this.payloads.detect_executionException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::detect_executionException;
            this.payloads.forEach_interruptedException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::detect_interruptedException;
            this.payloads.toString_interruptedException = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyParallelCollectDistinctTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.groupBy = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::groupBy;
            this.payloads.groupByEach = UnifiedSetWithHashingStrategyParallelCollectDistinctTest::groupByEach;
        }
    }
*/
}
