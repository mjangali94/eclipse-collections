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

import java.util.HashSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.set.mutable.SetAdapter;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

public class SetAdapterParallelSetIterableTest extends NonParallelUnsortedSetIterableTestCase {

    @Override
    protected ParallelUnsortedSetIterable<Integer> classUnderTest() {
        return this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SetAdapter.adapt(new HashSet<>(UnifiedSet.newSetWith(littleElements))).asParallel(this.executorService, this.batchSize);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SetAdapterParallelSetIterableTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SetAdapterParallelSetIterableTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SetAdapterParallelSetIterableTest> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = SetAdapterParallelSetIterableTest::toArray;
            this.payloads.toArray_array = SetAdapterParallelSetIterableTest::toArray_array;
            this.payloads.forEach = SetAdapterParallelSetIterableTest::forEach;
            this.payloads.forEachWith = SetAdapterParallelSetIterableTest::forEachWith;
            this.payloads.select = SetAdapterParallelSetIterableTest::select;
            this.payloads.selectWith = SetAdapterParallelSetIterableTest::selectWith;
            this.payloads.reject = SetAdapterParallelSetIterableTest::reject;
            this.payloads.rejectWith = SetAdapterParallelSetIterableTest::rejectWith;
            this.payloads.selectInstancesOf = SetAdapterParallelSetIterableTest::selectInstancesOf;
            this.payloads.collect = SetAdapterParallelSetIterableTest::collect;
            this.payloads.collectWith = SetAdapterParallelSetIterableTest::collectWith;
            this.payloads.collectIf = SetAdapterParallelSetIterableTest::collectIf;
            this.payloads.flatCollect = SetAdapterParallelSetIterableTest::flatCollect;
            this.payloads.detect = SetAdapterParallelSetIterableTest::detect;
            this.payloads.detectIfNone = SetAdapterParallelSetIterableTest::detectIfNone;
            this.payloads.detectWith = SetAdapterParallelSetIterableTest::detectWith;
            this.payloads.detectWithIfNone = SetAdapterParallelSetIterableTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = SetAdapterParallelSetIterableTest::min;
            this.payloads.max = SetAdapterParallelSetIterableTest::max;
            this.payloads.minBy = SetAdapterParallelSetIterableTest::minBy;
            this.payloads.maxBy = SetAdapterParallelSetIterableTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = SetAdapterParallelSetIterableTest::min_without_comparator;
            this.payloads.max_without_comparator = SetAdapterParallelSetIterableTest::max_without_comparator;
            this.payloads.anySatisfy = SetAdapterParallelSetIterableTest::anySatisfy;
            this.payloads.anySatisfyWith = SetAdapterParallelSetIterableTest::anySatisfyWith;
            this.payloads.allSatisfy = SetAdapterParallelSetIterableTest::allSatisfy;
            this.payloads.allSatisfyWith = SetAdapterParallelSetIterableTest::allSatisfyWith;
            this.payloads.noneSatisfy = SetAdapterParallelSetIterableTest::noneSatisfy;
            this.payloads.noneSatisfyWith = SetAdapterParallelSetIterableTest::noneSatisfyWith;
            this.payloads.count = SetAdapterParallelSetIterableTest::count;
            this.payloads.countWith = SetAdapterParallelSetIterableTest::countWith;
            this.payloads.toList = SetAdapterParallelSetIterableTest::toList;
            this.payloads.toSortedList = SetAdapterParallelSetIterableTest::toSortedList;
            this.payloads.toSortedList_comparator = SetAdapterParallelSetIterableTest::toSortedList_comparator;
            this.payloads.toSortedListBy = SetAdapterParallelSetIterableTest::toSortedListBy;
            this.payloads.toSet = SetAdapterParallelSetIterableTest::toSet;
            this.payloads.toSortedSet = SetAdapterParallelSetIterableTest::toSortedSet;
            this.payloads.toSortedSet_comparator = SetAdapterParallelSetIterableTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = SetAdapterParallelSetIterableTest::toSortedSetBy;
            this.payloads.toSortedBag = SetAdapterParallelSetIterableTest::toSortedBag;
            this.payloads.toSortedBag_comparator = SetAdapterParallelSetIterableTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = SetAdapterParallelSetIterableTest::toSortedBagBy;
            this.payloads.toMap = SetAdapterParallelSetIterableTest::toMap;
            this.payloads.toSortedMap = SetAdapterParallelSetIterableTest::toSortedMap;
            this.payloads.toSortedMap_comparator = SetAdapterParallelSetIterableTest::toSortedMap_comparator;
            this.payloads.testToString = SetAdapterParallelSetIterableTest::testToString;
            this.payloads.makeString = SetAdapterParallelSetIterableTest::makeString;
            this.payloads.makeString_separator = SetAdapterParallelSetIterableTest::makeString_separator;
            this.payloads.makeString_start_separator_end = SetAdapterParallelSetIterableTest::makeString_start_separator_end;
            this.payloads.appendString = SetAdapterParallelSetIterableTest::appendString;
            this.payloads.appendString_separator = SetAdapterParallelSetIterableTest::appendString_separator;
            this.payloads.appendString_start_separator_end = SetAdapterParallelSetIterableTest::appendString_start_separator_end;
            this.payloads.appendString_throws = SetAdapterParallelSetIterableTest::appendString_throws;
            this.payloads.groupBy = SetAdapterParallelSetIterableTest::groupBy;
            this.payloads.groupByEach = SetAdapterParallelSetIterableTest::groupByEach;
            this.payloads.groupByUniqueKey = SetAdapterParallelSetIterableTest::groupByUniqueKey;
            this.payloads.aggregateBy = SetAdapterParallelSetIterableTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = SetAdapterParallelSetIterableTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = SetAdapterParallelSetIterableTest::sumOfInt;
            this.payloads.sumOfLong = SetAdapterParallelSetIterableTest::sumOfLong;
            this.payloads.sumOfFloat = SetAdapterParallelSetIterableTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = SetAdapterParallelSetIterableTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = SetAdapterParallelSetIterableTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = SetAdapterParallelSetIterableTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = SetAdapterParallelSetIterableTest::asUnique;
            this.payloads.minWithEmptyBatch = SetAdapterParallelSetIterableTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = SetAdapterParallelSetIterableTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SetAdapterParallelSetIterableTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEach_executionException = SetAdapterParallelSetIterableTest::forEach_executionException;
            this.payloads.collect_executionException = SetAdapterParallelSetIterableTest::collect_executionException;
            this.payloads.anySatisfy_executionException = SetAdapterParallelSetIterableTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = SetAdapterParallelSetIterableTest::allSatisfy_executionException;
            this.payloads.detect_executionException = SetAdapterParallelSetIterableTest::detect_executionException;
            this.payloads.forEach_interruptedException = SetAdapterParallelSetIterableTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = SetAdapterParallelSetIterableTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = SetAdapterParallelSetIterableTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = SetAdapterParallelSetIterableTest::detect_interruptedException;
            this.payloads.toString_interruptedException = SetAdapterParallelSetIterableTest::toString_interruptedException;
        }
    }
*/
}
