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
import org.eclipse.collections.impl.list.mutable.FastList;

public class ParallelCollectListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return FastList.newListWith(littleElements).asParallel(this.executorService, this.batchSize).collect(String::valueOf).collect(string -> "null".equals(string) ? null : Integer.valueOf(string));
    }

    @Override
    protected ListIterable<Integer> getExpectedWith(Integer... littleElements) {
        return FastList.newListWith(littleElements).collect(String::valueOf).collect(string -> "null".equals(string) ? null : Integer.valueOf(string));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelCollectListIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelCollectListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectListIterableTest> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelCollectListIterableTest::toArray;
            this.payloads.toArray_array = ParallelCollectListIterableTest::toArray_array;
            this.payloads.forEach = ParallelCollectListIterableTest::forEach;
            this.payloads.forEachWith = ParallelCollectListIterableTest::forEachWith;
            this.payloads.select = ParallelCollectListIterableTest::select;
            this.payloads.selectWith = ParallelCollectListIterableTest::selectWith;
            this.payloads.reject = ParallelCollectListIterableTest::reject;
            this.payloads.rejectWith = ParallelCollectListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelCollectListIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelCollectListIterableTest::collect;
            this.payloads.collectWith = ParallelCollectListIterableTest::collectWith;
            this.payloads.collectIf = ParallelCollectListIterableTest::collectIf;
            this.payloads.flatCollect = ParallelCollectListIterableTest::flatCollect;
            this.payloads.detect = ParallelCollectListIterableTest::detect;
            this.payloads.detectIfNone = ParallelCollectListIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelCollectListIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelCollectListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelCollectListIterableTest::min;
            this.payloads.max = ParallelCollectListIterableTest::max;
            this.payloads.minBy = ParallelCollectListIterableTest::minBy;
            this.payloads.maxBy = ParallelCollectListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelCollectListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelCollectListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelCollectListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelCollectListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelCollectListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelCollectListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelCollectListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelCollectListIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelCollectListIterableTest::count;
            this.payloads.countWith = ParallelCollectListIterableTest::countWith;
            this.payloads.toList = ParallelCollectListIterableTest::toList;
            this.payloads.toSortedList = ParallelCollectListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelCollectListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelCollectListIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelCollectListIterableTest::toSet;
            this.payloads.toSortedSet = ParallelCollectListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelCollectListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelCollectListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelCollectListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelCollectListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelCollectListIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelCollectListIterableTest::toMap;
            this.payloads.toSortedMap = ParallelCollectListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelCollectListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelCollectListIterableTest::testToString;
            this.payloads.makeString = ParallelCollectListIterableTest::makeString;
            this.payloads.makeString_separator = ParallelCollectListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelCollectListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelCollectListIterableTest::appendString;
            this.payloads.appendString_separator = ParallelCollectListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelCollectListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelCollectListIterableTest::appendString_throws;
            this.payloads.groupBy = ParallelCollectListIterableTest::groupBy;
            this.payloads.groupByEach = ParallelCollectListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ParallelCollectListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelCollectListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelCollectListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelCollectListIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelCollectListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelCollectListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelCollectListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelCollectListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelCollectListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelCollectListIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelCollectListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelCollectListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelCollectListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelCollectListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelCollectListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelCollectListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelCollectListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelCollectListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelCollectListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelCollectListIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelCollectListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelCollectListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
}
