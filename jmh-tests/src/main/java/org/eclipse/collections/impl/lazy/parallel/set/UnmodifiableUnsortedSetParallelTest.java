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
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Test;

public class UnmodifiableUnsortedSetParallelTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return UnifiedSet.newSetWith(littleElements).asUnmodifiable().asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        UnifiedSet.newSetWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asUnmodifiable().asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        UnifiedSet.newSetWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asUnmodifiable().asParallel(null, 2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableUnsortedSetParallelTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableUnsortedSetParallelTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableUnsortedSetParallelTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = UnmodifiableUnsortedSetParallelTest::toArray;
            this.payloads.toArray_array = UnmodifiableUnsortedSetParallelTest::toArray_array;
            this.payloads.forEach = UnmodifiableUnsortedSetParallelTest::forEach;
            this.payloads.forEachWith = UnmodifiableUnsortedSetParallelTest::forEachWith;
            this.payloads.select = UnmodifiableUnsortedSetParallelTest::select;
            this.payloads.selectWith = UnmodifiableUnsortedSetParallelTest::selectWith;
            this.payloads.reject = UnmodifiableUnsortedSetParallelTest::reject;
            this.payloads.rejectWith = UnmodifiableUnsortedSetParallelTest::rejectWith;
            this.payloads.selectInstancesOf = UnmodifiableUnsortedSetParallelTest::selectInstancesOf;
            this.payloads.collect = UnmodifiableUnsortedSetParallelTest::collect;
            this.payloads.collectWith = UnmodifiableUnsortedSetParallelTest::collectWith;
            this.payloads.collectIf = UnmodifiableUnsortedSetParallelTest::collectIf;
            this.payloads.flatCollect = UnmodifiableUnsortedSetParallelTest::flatCollect;
            this.payloads.detect = UnmodifiableUnsortedSetParallelTest::detect;
            this.payloads.detectIfNone = UnmodifiableUnsortedSetParallelTest::detectIfNone;
            this.payloads.detectWith = UnmodifiableUnsortedSetParallelTest::detectWith;
            this.payloads.detectWithIfNone = UnmodifiableUnsortedSetParallelTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableUnsortedSetParallelTest::min;
            this.payloads.max = UnmodifiableUnsortedSetParallelTest::max;
            this.payloads.minBy = UnmodifiableUnsortedSetParallelTest::minBy;
            this.payloads.maxBy = UnmodifiableUnsortedSetParallelTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = UnmodifiableUnsortedSetParallelTest::min_without_comparator;
            this.payloads.max_without_comparator = UnmodifiableUnsortedSetParallelTest::max_without_comparator;
            this.payloads.anySatisfy = UnmodifiableUnsortedSetParallelTest::anySatisfy;
            this.payloads.anySatisfyWith = UnmodifiableUnsortedSetParallelTest::anySatisfyWith;
            this.payloads.allSatisfy = UnmodifiableUnsortedSetParallelTest::allSatisfy;
            this.payloads.allSatisfyWith = UnmodifiableUnsortedSetParallelTest::allSatisfyWith;
            this.payloads.noneSatisfy = UnmodifiableUnsortedSetParallelTest::noneSatisfy;
            this.payloads.noneSatisfyWith = UnmodifiableUnsortedSetParallelTest::noneSatisfyWith;
            this.payloads.count = UnmodifiableUnsortedSetParallelTest::count;
            this.payloads.countWith = UnmodifiableUnsortedSetParallelTest::countWith;
            this.payloads.toList = UnmodifiableUnsortedSetParallelTest::toList;
            this.payloads.toSortedList = UnmodifiableUnsortedSetParallelTest::toSortedList;
            this.payloads.toSortedList_comparator = UnmodifiableUnsortedSetParallelTest::toSortedList_comparator;
            this.payloads.toSortedListBy = UnmodifiableUnsortedSetParallelTest::toSortedListBy;
            this.payloads.toSet = UnmodifiableUnsortedSetParallelTest::toSet;
            this.payloads.toSortedSet = UnmodifiableUnsortedSetParallelTest::toSortedSet;
            this.payloads.toSortedSet_comparator = UnmodifiableUnsortedSetParallelTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = UnmodifiableUnsortedSetParallelTest::toSortedSetBy;
            this.payloads.toSortedBag = UnmodifiableUnsortedSetParallelTest::toSortedBag;
            this.payloads.toSortedBag_comparator = UnmodifiableUnsortedSetParallelTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = UnmodifiableUnsortedSetParallelTest::toSortedBagBy;
            this.payloads.toMap = UnmodifiableUnsortedSetParallelTest::toMap;
            this.payloads.toSortedMap = UnmodifiableUnsortedSetParallelTest::toSortedMap;
            this.payloads.toSortedMap_comparator = UnmodifiableUnsortedSetParallelTest::toSortedMap_comparator;
            this.payloads.testToString = UnmodifiableUnsortedSetParallelTest::testToString;
            this.payloads.makeString = UnmodifiableUnsortedSetParallelTest::makeString;
            this.payloads.makeString_separator = UnmodifiableUnsortedSetParallelTest::makeString_separator;
            this.payloads.makeString_start_separator_end = UnmodifiableUnsortedSetParallelTest::makeString_start_separator_end;
            this.payloads.appendString = UnmodifiableUnsortedSetParallelTest::appendString;
            this.payloads.appendString_separator = UnmodifiableUnsortedSetParallelTest::appendString_separator;
            this.payloads.appendString_start_separator_end = UnmodifiableUnsortedSetParallelTest::appendString_start_separator_end;
            this.payloads.appendString_throws = UnmodifiableUnsortedSetParallelTest::appendString_throws;
            this.payloads.groupBy = UnmodifiableUnsortedSetParallelTest::groupBy;
            this.payloads.groupByEach = UnmodifiableUnsortedSetParallelTest::groupByEach;
            this.payloads.groupByUniqueKey = UnmodifiableUnsortedSetParallelTest::groupByUniqueKey;
            this.payloads.aggregateBy = UnmodifiableUnsortedSetParallelTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = UnmodifiableUnsortedSetParallelTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = UnmodifiableUnsortedSetParallelTest::sumOfInt;
            this.payloads.sumOfLong = UnmodifiableUnsortedSetParallelTest::sumOfLong;
            this.payloads.sumOfFloat = UnmodifiableUnsortedSetParallelTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = UnmodifiableUnsortedSetParallelTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = UnmodifiableUnsortedSetParallelTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = UnmodifiableUnsortedSetParallelTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = UnmodifiableUnsortedSetParallelTest::asUnique;
            this.payloads.forEach_executionException = UnmodifiableUnsortedSetParallelTest::forEach_executionException;
            this.payloads.collect_executionException = UnmodifiableUnsortedSetParallelTest::collect_executionException;
            this.payloads.anySatisfy_executionException = UnmodifiableUnsortedSetParallelTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = UnmodifiableUnsortedSetParallelTest::allSatisfy_executionException;
            this.payloads.detect_executionException = UnmodifiableUnsortedSetParallelTest::detect_executionException;
            this.payloads.forEach_interruptedException = UnmodifiableUnsortedSetParallelTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = UnmodifiableUnsortedSetParallelTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = UnmodifiableUnsortedSetParallelTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = UnmodifiableUnsortedSetParallelTest::detect_interruptedException;
            this.payloads.toString_interruptedException = UnmodifiableUnsortedSetParallelTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = UnmodifiableUnsortedSetParallelTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = UnmodifiableUnsortedSetParallelTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableUnsortedSetParallelTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
*/
}
