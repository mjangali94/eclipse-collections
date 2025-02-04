/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.list;

import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.eclipse.collections.impl.list.mutable.RandomAccessListAdapter;
import org.junit.Test;

public class RandomAccessListAdapterParallelListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return RandomAccessListAdapter.adapt(Lists.mutable.of(littleElements)).asParallel(this.executorService, this.batchSize);
    }

    @Override
    protected ListIterable<Integer> getExpectedWith(Integer... littleElements) {
        return RandomAccessListAdapter.adapt(Lists.mutable.of(littleElements));
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        ListAdapter.adapt(Lists.mutable.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        ListAdapter.adapt(Lists.mutable.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)).asParallel(null, 2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private RandomAccessListAdapterParallelListIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new RandomAccessListAdapterParallelListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<RandomAccessListAdapterParallelListIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = RandomAccessListAdapterParallelListIterableTest::toArray;
            this.payloads.toArray_array = RandomAccessListAdapterParallelListIterableTest::toArray_array;
            this.payloads.forEach = RandomAccessListAdapterParallelListIterableTest::forEach;
            this.payloads.forEachWith = RandomAccessListAdapterParallelListIterableTest::forEachWith;
            this.payloads.select = RandomAccessListAdapterParallelListIterableTest::select;
            this.payloads.selectWith = RandomAccessListAdapterParallelListIterableTest::selectWith;
            this.payloads.reject = RandomAccessListAdapterParallelListIterableTest::reject;
            this.payloads.rejectWith = RandomAccessListAdapterParallelListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = RandomAccessListAdapterParallelListIterableTest::selectInstancesOf;
            this.payloads.collect = RandomAccessListAdapterParallelListIterableTest::collect;
            this.payloads.collectWith = RandomAccessListAdapterParallelListIterableTest::collectWith;
            this.payloads.collectIf = RandomAccessListAdapterParallelListIterableTest::collectIf;
            this.payloads.flatCollect = RandomAccessListAdapterParallelListIterableTest::flatCollect;
            this.payloads.detect = RandomAccessListAdapterParallelListIterableTest::detect;
            this.payloads.detectIfNone = RandomAccessListAdapterParallelListIterableTest::detectIfNone;
            this.payloads.detectWith = RandomAccessListAdapterParallelListIterableTest::detectWith;
            this.payloads.detectWithIfNone = RandomAccessListAdapterParallelListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = RandomAccessListAdapterParallelListIterableTest::min;
            this.payloads.max = RandomAccessListAdapterParallelListIterableTest::max;
            this.payloads.minBy = RandomAccessListAdapterParallelListIterableTest::minBy;
            this.payloads.maxBy = RandomAccessListAdapterParallelListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = RandomAccessListAdapterParallelListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = RandomAccessListAdapterParallelListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = RandomAccessListAdapterParallelListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = RandomAccessListAdapterParallelListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = RandomAccessListAdapterParallelListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = RandomAccessListAdapterParallelListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = RandomAccessListAdapterParallelListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = RandomAccessListAdapterParallelListIterableTest::noneSatisfyWith;
            this.payloads.count = RandomAccessListAdapterParallelListIterableTest::count;
            this.payloads.countWith = RandomAccessListAdapterParallelListIterableTest::countWith;
            this.payloads.toList = RandomAccessListAdapterParallelListIterableTest::toList;
            this.payloads.toSortedList = RandomAccessListAdapterParallelListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = RandomAccessListAdapterParallelListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = RandomAccessListAdapterParallelListIterableTest::toSortedListBy;
            this.payloads.toSet = RandomAccessListAdapterParallelListIterableTest::toSet;
            this.payloads.toSortedSet = RandomAccessListAdapterParallelListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = RandomAccessListAdapterParallelListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = RandomAccessListAdapterParallelListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = RandomAccessListAdapterParallelListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = RandomAccessListAdapterParallelListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = RandomAccessListAdapterParallelListIterableTest::toSortedBagBy;
            this.payloads.toMap = RandomAccessListAdapterParallelListIterableTest::toMap;
            this.payloads.toSortedMap = RandomAccessListAdapterParallelListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = RandomAccessListAdapterParallelListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = RandomAccessListAdapterParallelListIterableTest::testToString;
            this.payloads.makeString = RandomAccessListAdapterParallelListIterableTest::makeString;
            this.payloads.makeString_separator = RandomAccessListAdapterParallelListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = RandomAccessListAdapterParallelListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = RandomAccessListAdapterParallelListIterableTest::appendString;
            this.payloads.appendString_separator = RandomAccessListAdapterParallelListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = RandomAccessListAdapterParallelListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = RandomAccessListAdapterParallelListIterableTest::appendString_throws;
            this.payloads.groupBy = RandomAccessListAdapterParallelListIterableTest::groupBy;
            this.payloads.groupByEach = RandomAccessListAdapterParallelListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = RandomAccessListAdapterParallelListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = RandomAccessListAdapterParallelListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = RandomAccessListAdapterParallelListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = RandomAccessListAdapterParallelListIterableTest::sumOfInt;
            this.payloads.sumOfLong = RandomAccessListAdapterParallelListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = RandomAccessListAdapterParallelListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = RandomAccessListAdapterParallelListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = RandomAccessListAdapterParallelListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = RandomAccessListAdapterParallelListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = RandomAccessListAdapterParallelListIterableTest::asUnique;
            this.payloads.forEach_executionException = RandomAccessListAdapterParallelListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = RandomAccessListAdapterParallelListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = RandomAccessListAdapterParallelListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = RandomAccessListAdapterParallelListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = RandomAccessListAdapterParallelListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = RandomAccessListAdapterParallelListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = RandomAccessListAdapterParallelListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = RandomAccessListAdapterParallelListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = RandomAccessListAdapterParallelListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = RandomAccessListAdapterParallelListIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = RandomAccessListAdapterParallelListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = RandomAccessListAdapterParallelListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(RandomAccessListAdapterParallelListIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
*/
}
