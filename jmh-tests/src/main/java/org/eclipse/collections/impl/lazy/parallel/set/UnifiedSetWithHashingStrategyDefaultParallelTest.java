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
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.junit.Test;

public class UnifiedSetWithHashingStrategyDefaultParallelTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), 1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        UnifiedSetWithHashingStrategy.newSetWith(HashingStrategies.defaultStrategy(), 1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(null, 2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnifiedSetWithHashingStrategyDefaultParallelTest instance;

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
        public void benchmark_asParallel_small_batch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_small_batch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_null_executorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_null_executorService);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> payload) throws java.lang.Throwable {
            this.instance = new UnifiedSetWithHashingStrategyDefaultParallelTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnifiedSetWithHashingStrategyDefaultParallelTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnifiedSetWithHashingStrategyDefaultParallelTest::toArray;
            this.payloads.toArray_array = UnifiedSetWithHashingStrategyDefaultParallelTest::toArray_array;
            this.payloads.forEach = UnifiedSetWithHashingStrategyDefaultParallelTest::forEach;
            this.payloads.forEachWith = UnifiedSetWithHashingStrategyDefaultParallelTest::forEachWith;
            this.payloads.select = UnifiedSetWithHashingStrategyDefaultParallelTest::select;
            this.payloads.selectWith = UnifiedSetWithHashingStrategyDefaultParallelTest::selectWith;
            this.payloads.reject = UnifiedSetWithHashingStrategyDefaultParallelTest::reject;
            this.payloads.rejectWith = UnifiedSetWithHashingStrategyDefaultParallelTest::rejectWith;
            this.payloads.selectInstancesOf = UnifiedSetWithHashingStrategyDefaultParallelTest::selectInstancesOf;
            this.payloads.collect = UnifiedSetWithHashingStrategyDefaultParallelTest::collect;
            this.payloads.collectWith = UnifiedSetWithHashingStrategyDefaultParallelTest::collectWith;
            this.payloads.collectIf = UnifiedSetWithHashingStrategyDefaultParallelTest::collectIf;
            this.payloads.flatCollect = UnifiedSetWithHashingStrategyDefaultParallelTest::flatCollect;
            this.payloads.detect = UnifiedSetWithHashingStrategyDefaultParallelTest::detect;
            this.payloads.detectIfNone = UnifiedSetWithHashingStrategyDefaultParallelTest::detectIfNone;
            this.payloads.detectWith = UnifiedSetWithHashingStrategyDefaultParallelTest::detectWith;
            this.payloads.detectWithIfNone = UnifiedSetWithHashingStrategyDefaultParallelTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = UnifiedSetWithHashingStrategyDefaultParallelTest::min;
            this.payloads.max = UnifiedSetWithHashingStrategyDefaultParallelTest::max;
            this.payloads.minBy = UnifiedSetWithHashingStrategyDefaultParallelTest::minBy;
            this.payloads.maxBy = UnifiedSetWithHashingStrategyDefaultParallelTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = UnifiedSetWithHashingStrategyDefaultParallelTest::min_without_comparator;
            this.payloads.max_without_comparator = UnifiedSetWithHashingStrategyDefaultParallelTest::max_without_comparator;
            this.payloads.anySatisfy = UnifiedSetWithHashingStrategyDefaultParallelTest::anySatisfy;
            this.payloads.anySatisfyWith = UnifiedSetWithHashingStrategyDefaultParallelTest::anySatisfyWith;
            this.payloads.allSatisfy = UnifiedSetWithHashingStrategyDefaultParallelTest::allSatisfy;
            this.payloads.allSatisfyWith = UnifiedSetWithHashingStrategyDefaultParallelTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnifiedSetWithHashingStrategyDefaultParallelTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnifiedSetWithHashingStrategyDefaultParallelTest::noneSatisfyWith;
            this.payloads.count = UnifiedSetWithHashingStrategyDefaultParallelTest::count;
            this.payloads.countWith = UnifiedSetWithHashingStrategyDefaultParallelTest::countWith;
            this.payloads.toList = UnifiedSetWithHashingStrategyDefaultParallelTest::toList;
            this.payloads.toSortedList = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedList;
            this.payloads.toSortedList_comparator = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedList_comparator;
            this.payloads.toSortedListBy = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedListBy;
            this.payloads.toSet = UnifiedSetWithHashingStrategyDefaultParallelTest::toSet;
            this.payloads.toSortedSet = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedSet;
            this.payloads.toSortedSet_comparator = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedSetBy;
            this.payloads.toSortedBag = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedBag;
            this.payloads.toSortedBag_comparator = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedBagBy;
            this.payloads.toMap = UnifiedSetWithHashingStrategyDefaultParallelTest::toMap;
            this.payloads.toSortedMap = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedMap;
            this.payloads.toSortedMap_comparator = UnifiedSetWithHashingStrategyDefaultParallelTest::toSortedMap_comparator;
            this.payloads.testToString = UnifiedSetWithHashingStrategyDefaultParallelTest::testToString;
            this.payloads.makeString = UnifiedSetWithHashingStrategyDefaultParallelTest::makeString;
            this.payloads.makeString_separator = UnifiedSetWithHashingStrategyDefaultParallelTest::makeString_separator;
            this.payloads.makeString_start_separator_end = UnifiedSetWithHashingStrategyDefaultParallelTest::makeString_start_separator_end;
            this.payloads.appendString = UnifiedSetWithHashingStrategyDefaultParallelTest::appendString;
            this.payloads.appendString_separator = UnifiedSetWithHashingStrategyDefaultParallelTest::appendString_separator;
            this.payloads.appendString_start_separator_end = UnifiedSetWithHashingStrategyDefaultParallelTest::appendString_start_separator_end;
            this.payloads.appendString_throws = UnifiedSetWithHashingStrategyDefaultParallelTest::appendString_throws;
            this.payloads.groupBy = UnifiedSetWithHashingStrategyDefaultParallelTest::groupBy;
            this.payloads.groupByEach = UnifiedSetWithHashingStrategyDefaultParallelTest::groupByEach;
            this.payloads.groupByUniqueKey = UnifiedSetWithHashingStrategyDefaultParallelTest::groupByUniqueKey;
            this.payloads.aggregateBy = UnifiedSetWithHashingStrategyDefaultParallelTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = UnifiedSetWithHashingStrategyDefaultParallelTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = UnifiedSetWithHashingStrategyDefaultParallelTest::sumOfInt;
            this.payloads.sumOfLong = UnifiedSetWithHashingStrategyDefaultParallelTest::sumOfLong;
            this.payloads.sumOfFloat = UnifiedSetWithHashingStrategyDefaultParallelTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = UnifiedSetWithHashingStrategyDefaultParallelTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = UnifiedSetWithHashingStrategyDefaultParallelTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = UnifiedSetWithHashingStrategyDefaultParallelTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = UnifiedSetWithHashingStrategyDefaultParallelTest::asUnique;
            this.payloads.forEach_executionException = UnifiedSetWithHashingStrategyDefaultParallelTest::forEach_executionException;
            this.payloads.collect_executionException = UnifiedSetWithHashingStrategyDefaultParallelTest::collect_executionException;
            this.payloads.anySatisfy_executionException = UnifiedSetWithHashingStrategyDefaultParallelTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = UnifiedSetWithHashingStrategyDefaultParallelTest::allSatisfy_executionException;
            this.payloads.detect_executionException = UnifiedSetWithHashingStrategyDefaultParallelTest::detect_executionException;
            this.payloads.forEach_interruptedException = UnifiedSetWithHashingStrategyDefaultParallelTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = UnifiedSetWithHashingStrategyDefaultParallelTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = UnifiedSetWithHashingStrategyDefaultParallelTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = UnifiedSetWithHashingStrategyDefaultParallelTest::detect_interruptedException;
            this.payloads.toString_interruptedException = UnifiedSetWithHashingStrategyDefaultParallelTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = UnifiedSetWithHashingStrategyDefaultParallelTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = UnifiedSetWithHashingStrategyDefaultParallelTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnifiedSetWithHashingStrategyDefaultParallelTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
*/
}
