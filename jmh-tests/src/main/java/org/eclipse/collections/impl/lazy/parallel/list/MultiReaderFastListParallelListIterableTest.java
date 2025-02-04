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
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.eclipse.collections.impl.list.mutable.MultiReaderFastList;
import org.junit.Test;

public class MultiReaderFastListParallelListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return ListAdapter.adapt(MultiReaderFastList.newListWith(littleElements)).asParallel(this.executorService, this.batchSize);
    }

    @Override
    protected ListIterable<Integer> getExpectedWith(Integer... littleElements) {
        return ListAdapter.adapt(MultiReaderFastList.newListWith(littleElements));
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        ListAdapter.adapt(MultiReaderFastList.newListWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        ListAdapter.adapt(MultiReaderFastList.newListWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)).asParallel(null, 2);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MultiReaderFastListParallelListIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderFastListParallelListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderFastListParallelListIterableTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = MultiReaderFastListParallelListIterableTest::toArray;
            this.payloads.toArray_array = MultiReaderFastListParallelListIterableTest::toArray_array;
            this.payloads.forEach = MultiReaderFastListParallelListIterableTest::forEach;
            this.payloads.forEachWith = MultiReaderFastListParallelListIterableTest::forEachWith;
            this.payloads.select = MultiReaderFastListParallelListIterableTest::select;
            this.payloads.selectWith = MultiReaderFastListParallelListIterableTest::selectWith;
            this.payloads.reject = MultiReaderFastListParallelListIterableTest::reject;
            this.payloads.rejectWith = MultiReaderFastListParallelListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = MultiReaderFastListParallelListIterableTest::selectInstancesOf;
            this.payloads.collect = MultiReaderFastListParallelListIterableTest::collect;
            this.payloads.collectWith = MultiReaderFastListParallelListIterableTest::collectWith;
            this.payloads.collectIf = MultiReaderFastListParallelListIterableTest::collectIf;
            this.payloads.flatCollect = MultiReaderFastListParallelListIterableTest::flatCollect;
            this.payloads.detect = MultiReaderFastListParallelListIterableTest::detect;
            this.payloads.detectIfNone = MultiReaderFastListParallelListIterableTest::detectIfNone;
            this.payloads.detectWith = MultiReaderFastListParallelListIterableTest::detectWith;
            this.payloads.detectWithIfNone = MultiReaderFastListParallelListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = MultiReaderFastListParallelListIterableTest::min;
            this.payloads.max = MultiReaderFastListParallelListIterableTest::max;
            this.payloads.minBy = MultiReaderFastListParallelListIterableTest::minBy;
            this.payloads.maxBy = MultiReaderFastListParallelListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = MultiReaderFastListParallelListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderFastListParallelListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = MultiReaderFastListParallelListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = MultiReaderFastListParallelListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = MultiReaderFastListParallelListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = MultiReaderFastListParallelListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = MultiReaderFastListParallelListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderFastListParallelListIterableTest::noneSatisfyWith;
            this.payloads.count = MultiReaderFastListParallelListIterableTest::count;
            this.payloads.countWith = MultiReaderFastListParallelListIterableTest::countWith;
            this.payloads.toList = MultiReaderFastListParallelListIterableTest::toList;
            this.payloads.toSortedList = MultiReaderFastListParallelListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = MultiReaderFastListParallelListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = MultiReaderFastListParallelListIterableTest::toSortedListBy;
            this.payloads.toSet = MultiReaderFastListParallelListIterableTest::toSet;
            this.payloads.toSortedSet = MultiReaderFastListParallelListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = MultiReaderFastListParallelListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = MultiReaderFastListParallelListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = MultiReaderFastListParallelListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = MultiReaderFastListParallelListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = MultiReaderFastListParallelListIterableTest::toSortedBagBy;
            this.payloads.toMap = MultiReaderFastListParallelListIterableTest::toMap;
            this.payloads.toSortedMap = MultiReaderFastListParallelListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = MultiReaderFastListParallelListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = MultiReaderFastListParallelListIterableTest::testToString;
            this.payloads.makeString = MultiReaderFastListParallelListIterableTest::makeString;
            this.payloads.makeString_separator = MultiReaderFastListParallelListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = MultiReaderFastListParallelListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = MultiReaderFastListParallelListIterableTest::appendString;
            this.payloads.appendString_separator = MultiReaderFastListParallelListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = MultiReaderFastListParallelListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = MultiReaderFastListParallelListIterableTest::appendString_throws;
            this.payloads.groupBy = MultiReaderFastListParallelListIterableTest::groupBy;
            this.payloads.groupByEach = MultiReaderFastListParallelListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderFastListParallelListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = MultiReaderFastListParallelListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = MultiReaderFastListParallelListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = MultiReaderFastListParallelListIterableTest::sumOfInt;
            this.payloads.sumOfLong = MultiReaderFastListParallelListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = MultiReaderFastListParallelListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = MultiReaderFastListParallelListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = MultiReaderFastListParallelListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = MultiReaderFastListParallelListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = MultiReaderFastListParallelListIterableTest::asUnique;
            this.payloads.forEach_executionException = MultiReaderFastListParallelListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = MultiReaderFastListParallelListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = MultiReaderFastListParallelListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = MultiReaderFastListParallelListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = MultiReaderFastListParallelListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = MultiReaderFastListParallelListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = MultiReaderFastListParallelListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = MultiReaderFastListParallelListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = MultiReaderFastListParallelListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = MultiReaderFastListParallelListIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = MultiReaderFastListParallelListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = MultiReaderFastListParallelListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderFastListParallelListIterableTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
*/
}
