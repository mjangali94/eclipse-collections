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

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.ParallelBag;
import org.eclipse.collections.impl.bag.mutable.HashBag;

public class ParallelCollectBagTest extends ParallelBagTestCase {

    @Override
    protected ParallelBag<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelBag<Integer> newWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).asParallel(this.executorService, this.batchSize).collect(String::valueOf).collect(string -> "null".equals(string) ? null : Integer.valueOf(string));
    }

    @Override
    protected MutableBag<Integer> getExpectedWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).collect(String::valueOf).collect(string -> "null".equals(string) ? null : Integer.valueOf(string));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelCollectBagTest instance;

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
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelCollectBagTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelCollectBagTest> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelCollectBagTest::toArray;
            this.payloads.toArray_array = ParallelCollectBagTest::toArray_array;
            this.payloads.forEach = ParallelCollectBagTest::forEach;
            this.payloads.forEachWith = ParallelCollectBagTest::forEachWith;
            this.payloads.select = ParallelCollectBagTest::select;
            this.payloads.selectWith = ParallelCollectBagTest::selectWith;
            this.payloads.reject = ParallelCollectBagTest::reject;
            this.payloads.rejectWith = ParallelCollectBagTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelCollectBagTest::selectInstancesOf;
            this.payloads.collect = ParallelCollectBagTest::collect;
            this.payloads.collectWith = ParallelCollectBagTest::collectWith;
            this.payloads.collectIf = ParallelCollectBagTest::collectIf;
            this.payloads.flatCollect = ParallelCollectBagTest::flatCollect;
            this.payloads.detect = ParallelCollectBagTest::detect;
            this.payloads.detectIfNone = ParallelCollectBagTest::detectIfNone;
            this.payloads.detectWith = ParallelCollectBagTest::detectWith;
            this.payloads.detectWithIfNone = ParallelCollectBagTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelCollectBagTest::min;
            this.payloads.max = ParallelCollectBagTest::max;
            this.payloads.minBy = ParallelCollectBagTest::minBy;
            this.payloads.maxBy = ParallelCollectBagTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelCollectBagTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelCollectBagTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelCollectBagTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelCollectBagTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelCollectBagTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelCollectBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelCollectBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelCollectBagTest::noneSatisfyWith;
            this.payloads.count = ParallelCollectBagTest::count;
            this.payloads.countWith = ParallelCollectBagTest::countWith;
            this.payloads.toList = ParallelCollectBagTest::toList;
            this.payloads.toSortedList = ParallelCollectBagTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelCollectBagTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelCollectBagTest::toSortedListBy;
            this.payloads.toSet = ParallelCollectBagTest::toSet;
            this.payloads.toSortedSet = ParallelCollectBagTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelCollectBagTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelCollectBagTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelCollectBagTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelCollectBagTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelCollectBagTest::toSortedBagBy;
            this.payloads.toMap = ParallelCollectBagTest::toMap;
            this.payloads.toSortedMap = ParallelCollectBagTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelCollectBagTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelCollectBagTest::testToString;
            this.payloads.makeString = ParallelCollectBagTest::makeString;
            this.payloads.makeString_separator = ParallelCollectBagTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelCollectBagTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelCollectBagTest::appendString;
            this.payloads.appendString_separator = ParallelCollectBagTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelCollectBagTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelCollectBagTest::appendString_throws;
            this.payloads.groupBy = ParallelCollectBagTest::groupBy;
            this.payloads.groupByEach = ParallelCollectBagTest::groupByEach;
            this.payloads.groupByUniqueKey = ParallelCollectBagTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelCollectBagTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelCollectBagTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelCollectBagTest::sumOfInt;
            this.payloads.sumOfLong = ParallelCollectBagTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelCollectBagTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelCollectBagTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelCollectBagTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelCollectBagTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelCollectBagTest::asUnique;
            this.payloads.minWithEmptyBatch = ParallelCollectBagTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelCollectBagTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelCollectBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEachWithOccurrences = ParallelCollectBagTest::forEachWithOccurrences;
            this.payloads.forEach_executionException = ParallelCollectBagTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelCollectBagTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelCollectBagTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelCollectBagTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelCollectBagTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelCollectBagTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelCollectBagTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelCollectBagTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelCollectBagTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelCollectBagTest::toString_interruptedException;
        }
    }
}
