/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.bag;

import org.eclipse.collections.api.bag.ParallelBag;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.junit.Test;

public class ParallelBagTest extends ParallelBagTestCase {

    @Override
    protected ParallelBag<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelBag<Integer> newWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).asParallel(null, 2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelBagTest instance;

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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
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
        public void benchmark_asParallel_small_batch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_small_batch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_null_executorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_null_executorService);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelBagTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTest> asParallel_null_executorService;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelBagTest::toArray;
            this.payloads.toArray_array = ParallelBagTest::toArray_array;
            this.payloads.forEach = ParallelBagTest::forEach;
            this.payloads.forEachWith = ParallelBagTest::forEachWith;
            this.payloads.select = ParallelBagTest::select;
            this.payloads.selectWith = ParallelBagTest::selectWith;
            this.payloads.reject = ParallelBagTest::reject;
            this.payloads.rejectWith = ParallelBagTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelBagTest::selectInstancesOf;
            this.payloads.collect = ParallelBagTest::collect;
            this.payloads.collectWith = ParallelBagTest::collectWith;
            this.payloads.collectIf = ParallelBagTest::collectIf;
            this.payloads.flatCollect = ParallelBagTest::flatCollect;
            this.payloads.detect = ParallelBagTest::detect;
            this.payloads.detectIfNone = ParallelBagTest::detectIfNone;
            this.payloads.detectWith = ParallelBagTest::detectWith;
            this.payloads.detectWithIfNone = ParallelBagTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelBagTest::min;
            this.payloads.max = ParallelBagTest::max;
            this.payloads.minBy = ParallelBagTest::minBy;
            this.payloads.maxBy = ParallelBagTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelBagTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelBagTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelBagTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelBagTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelBagTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelBagTest::noneSatisfyWith;
            this.payloads.count = ParallelBagTest::count;
            this.payloads.countWith = ParallelBagTest::countWith;
            this.payloads.toList = ParallelBagTest::toList;
            this.payloads.toSortedList = ParallelBagTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelBagTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelBagTest::toSortedListBy;
            this.payloads.toSet = ParallelBagTest::toSet;
            this.payloads.toSortedSet = ParallelBagTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelBagTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelBagTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelBagTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelBagTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelBagTest::toSortedBagBy;
            this.payloads.toMap = ParallelBagTest::toMap;
            this.payloads.toSortedMap = ParallelBagTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelBagTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelBagTest::testToString;
            this.payloads.makeString = ParallelBagTest::makeString;
            this.payloads.makeString_separator = ParallelBagTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelBagTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelBagTest::appendString;
            this.payloads.appendString_separator = ParallelBagTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelBagTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelBagTest::appendString_throws;
            this.payloads.groupBy = ParallelBagTest::groupBy;
            this.payloads.groupByEach = ParallelBagTest::groupByEach;
            this.payloads.groupByUniqueKey = ParallelBagTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelBagTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelBagTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelBagTest::sumOfInt;
            this.payloads.sumOfLong = ParallelBagTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelBagTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelBagTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelBagTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelBagTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelBagTest::asUnique;
            this.payloads.minWithEmptyBatch = ParallelBagTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelBagTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEachWithOccurrences = ParallelBagTest::forEachWithOccurrences;
            this.payloads.forEach_executionException = ParallelBagTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelBagTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelBagTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelBagTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelBagTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelBagTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelBagTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelBagTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelBagTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelBagTest::toString_interruptedException;
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTest::asParallel_null_executorService, java.lang.NullPointerException.class);
        }
    }
}
