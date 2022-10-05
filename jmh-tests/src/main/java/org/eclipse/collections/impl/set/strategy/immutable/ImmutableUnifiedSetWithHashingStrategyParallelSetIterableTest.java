/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.strategy.immutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.lazy.parallel.set.ParallelUnsortedSetIterableTestCase;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.junit.Test;

public class ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    private static final HashingStrategy<Integer> INTEGER_TO_STRING_HASHING_STRATEGY = HashingStrategies.fromFunction(Integer::valueOf);

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return ImmutableUnifiedSetWithHashingStrategy.newSetWith(INTEGER_TO_STRING_HASHING_STRATEGY, littleElements).asParallel(this.executorService, 2);
    }

    @Override
    protected MutableSet<Integer> getExpected() {
        return UnifiedSetWithHashingStrategy.newSetWith(INTEGER_TO_STRING_HASHING_STRATEGY, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return UnifiedSetWithHashingStrategy.newSetWith(INTEGER_TO_STRING_HASHING_STRATEGY, littleElements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        ImmutableUnifiedSetWithHashingStrategy.newSetWith(INTEGER_TO_STRING_HASHING_STRATEGY, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        ImmutableUnifiedSetWithHashingStrategy.newSetWith(INTEGER_TO_STRING_HASHING_STRATEGY, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toArray;
            this.payloads.toArray_array = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toArray_array;
            this.payloads.forEach = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::forEach;
            this.payloads.forEachWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::forEachWith;
            this.payloads.select = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::select;
            this.payloads.selectWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::selectWith;
            this.payloads.reject = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::reject;
            this.payloads.rejectWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::selectInstancesOf;
            this.payloads.collect = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::collect;
            this.payloads.collectWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::collectWith;
            this.payloads.collectIf = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::collectIf;
            this.payloads.flatCollect = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::flatCollect;
            this.payloads.detect = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::detect;
            this.payloads.detectIfNone = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::detectIfNone;
            this.payloads.detectWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::min;
            this.payloads.max = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::max;
            this.payloads.minBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::minBy;
            this.payloads.maxBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::noneSatisfyWith;
            this.payloads.count = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::count;
            this.payloads.countWith = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::countWith;
            this.payloads.toList = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toList;
            this.payloads.toSortedList = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedListBy;
            this.payloads.toSet = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSet;
            this.payloads.toSortedSet = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toMap;
            this.payloads.toSortedMap = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::testToString;
            this.payloads.makeString = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::makeString;
            this.payloads.makeString_separator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::appendString;
            this.payloads.appendString_separator = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::appendString_throws;
            this.payloads.groupBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::groupBy;
            this.payloads.groupByEach = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetWithHashingStrategyParallelSetIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
