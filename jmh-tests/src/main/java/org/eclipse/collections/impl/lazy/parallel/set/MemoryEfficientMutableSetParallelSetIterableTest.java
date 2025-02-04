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
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.junit.Test;

public class MemoryEfficientMutableSetParallelSetIterableTest extends ParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 3, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return Sets.fixedSize.withAll(ArrayAdapter.adapt(littleElements)).asParallel(this.executorService, this.batchSize);
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return Sets.fixedSize.withAll(ArrayAdapter.adapt(littleElements));
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        Sets.fixedSize.with(1, 2, 3, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        Sets.fixedSize.with(1, 2, 3, 4).asParallel(null, 2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MemoryEfficientMutableSetParallelSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new MemoryEfficientMutableSetParallelSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MemoryEfficientMutableSetParallelSetIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = MemoryEfficientMutableSetParallelSetIterableTest::toArray;
            this.payloads.toArray_array = MemoryEfficientMutableSetParallelSetIterableTest::toArray_array;
            this.payloads.forEach = MemoryEfficientMutableSetParallelSetIterableTest::forEach;
            this.payloads.forEachWith = MemoryEfficientMutableSetParallelSetIterableTest::forEachWith;
            this.payloads.select = MemoryEfficientMutableSetParallelSetIterableTest::select;
            this.payloads.selectWith = MemoryEfficientMutableSetParallelSetIterableTest::selectWith;
            this.payloads.reject = MemoryEfficientMutableSetParallelSetIterableTest::reject;
            this.payloads.rejectWith = MemoryEfficientMutableSetParallelSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = MemoryEfficientMutableSetParallelSetIterableTest::selectInstancesOf;
            this.payloads.collect = MemoryEfficientMutableSetParallelSetIterableTest::collect;
            this.payloads.collectWith = MemoryEfficientMutableSetParallelSetIterableTest::collectWith;
            this.payloads.collectIf = MemoryEfficientMutableSetParallelSetIterableTest::collectIf;
            this.payloads.flatCollect = MemoryEfficientMutableSetParallelSetIterableTest::flatCollect;
            this.payloads.detect = MemoryEfficientMutableSetParallelSetIterableTest::detect;
            this.payloads.detectIfNone = MemoryEfficientMutableSetParallelSetIterableTest::detectIfNone;
            this.payloads.detectWith = MemoryEfficientMutableSetParallelSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = MemoryEfficientMutableSetParallelSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = MemoryEfficientMutableSetParallelSetIterableTest::min;
            this.payloads.max = MemoryEfficientMutableSetParallelSetIterableTest::max;
            this.payloads.minBy = MemoryEfficientMutableSetParallelSetIterableTest::minBy;
            this.payloads.maxBy = MemoryEfficientMutableSetParallelSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = MemoryEfficientMutableSetParallelSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = MemoryEfficientMutableSetParallelSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = MemoryEfficientMutableSetParallelSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = MemoryEfficientMutableSetParallelSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = MemoryEfficientMutableSetParallelSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = MemoryEfficientMutableSetParallelSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = MemoryEfficientMutableSetParallelSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MemoryEfficientMutableSetParallelSetIterableTest::noneSatisfyWith;
            this.payloads.count = MemoryEfficientMutableSetParallelSetIterableTest::count;
            this.payloads.countWith = MemoryEfficientMutableSetParallelSetIterableTest::countWith;
            this.payloads.toList = MemoryEfficientMutableSetParallelSetIterableTest::toList;
            this.payloads.toSortedList = MemoryEfficientMutableSetParallelSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = MemoryEfficientMutableSetParallelSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = MemoryEfficientMutableSetParallelSetIterableTest::toSortedListBy;
            this.payloads.toSet = MemoryEfficientMutableSetParallelSetIterableTest::toSet;
            this.payloads.toSortedSet = MemoryEfficientMutableSetParallelSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = MemoryEfficientMutableSetParallelSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = MemoryEfficientMutableSetParallelSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = MemoryEfficientMutableSetParallelSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = MemoryEfficientMutableSetParallelSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = MemoryEfficientMutableSetParallelSetIterableTest::toSortedBagBy;
            this.payloads.toMap = MemoryEfficientMutableSetParallelSetIterableTest::toMap;
            this.payloads.toSortedMap = MemoryEfficientMutableSetParallelSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = MemoryEfficientMutableSetParallelSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = MemoryEfficientMutableSetParallelSetIterableTest::testToString;
            this.payloads.makeString = MemoryEfficientMutableSetParallelSetIterableTest::makeString;
            this.payloads.makeString_separator = MemoryEfficientMutableSetParallelSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = MemoryEfficientMutableSetParallelSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = MemoryEfficientMutableSetParallelSetIterableTest::appendString;
            this.payloads.appendString_separator = MemoryEfficientMutableSetParallelSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = MemoryEfficientMutableSetParallelSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = MemoryEfficientMutableSetParallelSetIterableTest::appendString_throws;
            this.payloads.groupBy = MemoryEfficientMutableSetParallelSetIterableTest::groupBy;
            this.payloads.groupByEach = MemoryEfficientMutableSetParallelSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = MemoryEfficientMutableSetParallelSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = MemoryEfficientMutableSetParallelSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = MemoryEfficientMutableSetParallelSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = MemoryEfficientMutableSetParallelSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = MemoryEfficientMutableSetParallelSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = MemoryEfficientMutableSetParallelSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = MemoryEfficientMutableSetParallelSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = MemoryEfficientMutableSetParallelSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = MemoryEfficientMutableSetParallelSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = MemoryEfficientMutableSetParallelSetIterableTest::asUnique;
            this.payloads.forEach_executionException = MemoryEfficientMutableSetParallelSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = MemoryEfficientMutableSetParallelSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = MemoryEfficientMutableSetParallelSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = MemoryEfficientMutableSetParallelSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = MemoryEfficientMutableSetParallelSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = MemoryEfficientMutableSetParallelSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = MemoryEfficientMutableSetParallelSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = MemoryEfficientMutableSetParallelSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = MemoryEfficientMutableSetParallelSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = MemoryEfficientMutableSetParallelSetIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = MemoryEfficientMutableSetParallelSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = MemoryEfficientMutableSetParallelSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(MemoryEfficientMutableSetParallelSetIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
*/
}
