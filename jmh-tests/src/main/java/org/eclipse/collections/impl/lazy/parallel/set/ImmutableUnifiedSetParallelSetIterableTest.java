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

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Test;

public class ImmutableUnifiedSetParallelSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return Sets.immutable.with(littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return Sets.immutable.with(littleElements).toSet();
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        Sets.immutable.with(1, 2, 3, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        Sets.immutable.with(1, 2, 3, 4).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedSetParallelSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedSetParallelSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedSetParallelSetIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableUnifiedSetParallelSetIterableTest::toArray;
            this.payloads.toArray_array = ImmutableUnifiedSetParallelSetIterableTest::toArray_array;
            this.payloads.forEach = ImmutableUnifiedSetParallelSetIterableTest::forEach;
            this.payloads.forEachWith = ImmutableUnifiedSetParallelSetIterableTest::forEachWith;
            this.payloads.select = ImmutableUnifiedSetParallelSetIterableTest::select;
            this.payloads.selectWith = ImmutableUnifiedSetParallelSetIterableTest::selectWith;
            this.payloads.reject = ImmutableUnifiedSetParallelSetIterableTest::reject;
            this.payloads.rejectWith = ImmutableUnifiedSetParallelSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ImmutableUnifiedSetParallelSetIterableTest::selectInstancesOf;
            this.payloads.collect = ImmutableUnifiedSetParallelSetIterableTest::collect;
            this.payloads.collectWith = ImmutableUnifiedSetParallelSetIterableTest::collectWith;
            this.payloads.collectIf = ImmutableUnifiedSetParallelSetIterableTest::collectIf;
            this.payloads.flatCollect = ImmutableUnifiedSetParallelSetIterableTest::flatCollect;
            this.payloads.detect = ImmutableUnifiedSetParallelSetIterableTest::detect;
            this.payloads.detectIfNone = ImmutableUnifiedSetParallelSetIterableTest::detectIfNone;
            this.payloads.detectWith = ImmutableUnifiedSetParallelSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableUnifiedSetParallelSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableUnifiedSetParallelSetIterableTest::min;
            this.payloads.max = ImmutableUnifiedSetParallelSetIterableTest::max;
            this.payloads.minBy = ImmutableUnifiedSetParallelSetIterableTest::minBy;
            this.payloads.maxBy = ImmutableUnifiedSetParallelSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ImmutableUnifiedSetParallelSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ImmutableUnifiedSetParallelSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ImmutableUnifiedSetParallelSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableUnifiedSetParallelSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableUnifiedSetParallelSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableUnifiedSetParallelSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableUnifiedSetParallelSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableUnifiedSetParallelSetIterableTest::noneSatisfyWith;
            this.payloads.count = ImmutableUnifiedSetParallelSetIterableTest::count;
            this.payloads.countWith = ImmutableUnifiedSetParallelSetIterableTest::countWith;
            this.payloads.toList = ImmutableUnifiedSetParallelSetIterableTest::toList;
            this.payloads.toSortedList = ImmutableUnifiedSetParallelSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ImmutableUnifiedSetParallelSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ImmutableUnifiedSetParallelSetIterableTest::toSortedListBy;
            this.payloads.toSet = ImmutableUnifiedSetParallelSetIterableTest::toSet;
            this.payloads.toSortedSet = ImmutableUnifiedSetParallelSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ImmutableUnifiedSetParallelSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ImmutableUnifiedSetParallelSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ImmutableUnifiedSetParallelSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ImmutableUnifiedSetParallelSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ImmutableUnifiedSetParallelSetIterableTest::toSortedBagBy;
            this.payloads.toMap = ImmutableUnifiedSetParallelSetIterableTest::toMap;
            this.payloads.toSortedMap = ImmutableUnifiedSetParallelSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ImmutableUnifiedSetParallelSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ImmutableUnifiedSetParallelSetIterableTest::testToString;
            this.payloads.makeString = ImmutableUnifiedSetParallelSetIterableTest::makeString;
            this.payloads.makeString_separator = ImmutableUnifiedSetParallelSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ImmutableUnifiedSetParallelSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ImmutableUnifiedSetParallelSetIterableTest::appendString;
            this.payloads.appendString_separator = ImmutableUnifiedSetParallelSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ImmutableUnifiedSetParallelSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ImmutableUnifiedSetParallelSetIterableTest::appendString_throws;
            this.payloads.groupBy = ImmutableUnifiedSetParallelSetIterableTest::groupBy;
            this.payloads.groupByEach = ImmutableUnifiedSetParallelSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableUnifiedSetParallelSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ImmutableUnifiedSetParallelSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ImmutableUnifiedSetParallelSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ImmutableUnifiedSetParallelSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableUnifiedSetParallelSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ImmutableUnifiedSetParallelSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ImmutableUnifiedSetParallelSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ImmutableUnifiedSetParallelSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableUnifiedSetParallelSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ImmutableUnifiedSetParallelSetIterableTest::asUnique;
            this.payloads.forEach_executionException = ImmutableUnifiedSetParallelSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ImmutableUnifiedSetParallelSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ImmutableUnifiedSetParallelSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ImmutableUnifiedSetParallelSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ImmutableUnifiedSetParallelSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ImmutableUnifiedSetParallelSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ImmutableUnifiedSetParallelSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ImmutableUnifiedSetParallelSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ImmutableUnifiedSetParallelSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ImmutableUnifiedSetParallelSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ImmutableUnifiedSetParallelSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ImmutableUnifiedSetParallelSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableUnifiedSetParallelSetIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
