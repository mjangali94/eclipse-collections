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
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.mutable.FastList;

public class ParallelSelectListIterableTest extends ParallelListIterableTestCase {

    @Override
    protected ParallelListIterable<Integer> classUnderTest() {
        return this.newWith(-1, 1, -1, 2, -1, 2, -1, 3, -1, 3, -1, 3, 5, 4, 5, 4, 5, 4, 5, 4, 5);
    }

    @Override
    protected ParallelListIterable<Integer> newWith(Integer... littleElements) {
        return FastList.newListWith(littleElements).asParallel(this.executorService, this.batchSize).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @Override
    protected ListIterable<Integer> getExpectedWith(Integer... littleElements) {
        return FastList.newListWith(littleElements).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelSelectListIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelSelectListIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectListIterableTest> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelSelectListIterableTest::toArray;
            this.payloads.toArray_array = ParallelSelectListIterableTest::toArray_array;
            this.payloads.forEach = ParallelSelectListIterableTest::forEach;
            this.payloads.forEachWith = ParallelSelectListIterableTest::forEachWith;
            this.payloads.select = ParallelSelectListIterableTest::select;
            this.payloads.selectWith = ParallelSelectListIterableTest::selectWith;
            this.payloads.reject = ParallelSelectListIterableTest::reject;
            this.payloads.rejectWith = ParallelSelectListIterableTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelSelectListIterableTest::selectInstancesOf;
            this.payloads.collect = ParallelSelectListIterableTest::collect;
            this.payloads.collectWith = ParallelSelectListIterableTest::collectWith;
            this.payloads.collectIf = ParallelSelectListIterableTest::collectIf;
            this.payloads.flatCollect = ParallelSelectListIterableTest::flatCollect;
            this.payloads.detect = ParallelSelectListIterableTest::detect;
            this.payloads.detectIfNone = ParallelSelectListIterableTest::detectIfNone;
            this.payloads.detectWith = ParallelSelectListIterableTest::detectWith;
            this.payloads.detectWithIfNone = ParallelSelectListIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelSelectListIterableTest::min;
            this.payloads.max = ParallelSelectListIterableTest::max;
            this.payloads.minBy = ParallelSelectListIterableTest::minBy;
            this.payloads.maxBy = ParallelSelectListIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelSelectListIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelSelectListIterableTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelSelectListIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelSelectListIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelSelectListIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelSelectListIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelSelectListIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelSelectListIterableTest::noneSatisfyWith;
            this.payloads.count = ParallelSelectListIterableTest::count;
            this.payloads.countWith = ParallelSelectListIterableTest::countWith;
            this.payloads.toList = ParallelSelectListIterableTest::toList;
            this.payloads.toSortedList = ParallelSelectListIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelSelectListIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelSelectListIterableTest::toSortedListBy;
            this.payloads.toSet = ParallelSelectListIterableTest::toSet;
            this.payloads.toSortedSet = ParallelSelectListIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelSelectListIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelSelectListIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelSelectListIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelSelectListIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelSelectListIterableTest::toSortedBagBy;
            this.payloads.toMap = ParallelSelectListIterableTest::toMap;
            this.payloads.toSortedMap = ParallelSelectListIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelSelectListIterableTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelSelectListIterableTest::testToString;
            this.payloads.makeString = ParallelSelectListIterableTest::makeString;
            this.payloads.makeString_separator = ParallelSelectListIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelSelectListIterableTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelSelectListIterableTest::appendString;
            this.payloads.appendString_separator = ParallelSelectListIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelSelectListIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelSelectListIterableTest::appendString_throws;
            this.payloads.groupBy = ParallelSelectListIterableTest::groupBy;
            this.payloads.groupByEach = ParallelSelectListIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = ParallelSelectListIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelSelectListIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelSelectListIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelSelectListIterableTest::sumOfInt;
            this.payloads.sumOfLong = ParallelSelectListIterableTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelSelectListIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelSelectListIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelSelectListIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelSelectListIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelSelectListIterableTest::asUnique;
            this.payloads.forEach_executionException = ParallelSelectListIterableTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelSelectListIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelSelectListIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelSelectListIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelSelectListIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelSelectListIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelSelectListIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelSelectListIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelSelectListIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelSelectListIterableTest::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelSelectListIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelSelectListIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectListIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
}
