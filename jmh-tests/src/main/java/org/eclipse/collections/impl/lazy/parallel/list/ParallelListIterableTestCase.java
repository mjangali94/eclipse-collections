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
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.eclipse.collections.impl.list.mutable.FastList;

public abstract class ParallelListIterableTestCase extends ParallelIterableTestCase {

    @Override
    protected abstract ParallelListIterable<Integer> classUnderTest();

    @Override
    protected abstract ParallelListIterable<Integer> newWith(Integer... littleElements);

    @Override
    protected MutableList<Integer> getExpected() {
        return FastList.newListWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected ListIterable<Integer> getExpectedWith(Integer... littleElements) {
        return FastList.newListWith(littleElements);
    }

    @Override
    protected boolean isOrdered() {
        return true;
    }

    @Override
    protected boolean isUnique() {
        return false;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelListIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new ParallelListIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelListIterableTestCase> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelListIterableTestCase::toArray;
            this.payloads.toArray_array = ParallelListIterableTestCase::toArray_array;
            this.payloads.forEach = ParallelListIterableTestCase::forEach;
            this.payloads.forEachWith = ParallelListIterableTestCase::forEachWith;
            this.payloads.select = ParallelListIterableTestCase::select;
            this.payloads.selectWith = ParallelListIterableTestCase::selectWith;
            this.payloads.reject = ParallelListIterableTestCase::reject;
            this.payloads.rejectWith = ParallelListIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = ParallelListIterableTestCase::selectInstancesOf;
            this.payloads.collect = ParallelListIterableTestCase::collect;
            this.payloads.collectWith = ParallelListIterableTestCase::collectWith;
            this.payloads.collectIf = ParallelListIterableTestCase::collectIf;
            this.payloads.flatCollect = ParallelListIterableTestCase::flatCollect;
            this.payloads.detect = ParallelListIterableTestCase::detect;
            this.payloads.detectIfNone = ParallelListIterableTestCase::detectIfNone;
            this.payloads.detectWith = ParallelListIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = ParallelListIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelListIterableTestCase::min;
            this.payloads.max = ParallelListIterableTestCase::max;
            this.payloads.minBy = ParallelListIterableTestCase::minBy;
            this.payloads.maxBy = ParallelListIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelListIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ParallelListIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = ParallelListIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ParallelListIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ParallelListIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ParallelListIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelListIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelListIterableTestCase::noneSatisfyWith;
            this.payloads.count = ParallelListIterableTestCase::count;
            this.payloads.countWith = ParallelListIterableTestCase::countWith;
            this.payloads.toList = ParallelListIterableTestCase::toList;
            this.payloads.toSortedList = ParallelListIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = ParallelListIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelListIterableTestCase::toSortedListBy;
            this.payloads.toSet = ParallelListIterableTestCase::toSet;
            this.payloads.toSortedSet = ParallelListIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelListIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelListIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = ParallelListIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelListIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelListIterableTestCase::toSortedBagBy;
            this.payloads.toMap = ParallelListIterableTestCase::toMap;
            this.payloads.toSortedMap = ParallelListIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelListIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = ParallelListIterableTestCase::testToString;
            this.payloads.makeString = ParallelListIterableTestCase::makeString;
            this.payloads.makeString_separator = ParallelListIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelListIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = ParallelListIterableTestCase::appendString;
            this.payloads.appendString_separator = ParallelListIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelListIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelListIterableTestCase::appendString_throws;
            this.payloads.groupBy = ParallelListIterableTestCase::groupBy;
            this.payloads.groupByEach = ParallelListIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ParallelListIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelListIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelListIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelListIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = ParallelListIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = ParallelListIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelListIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelListIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelListIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelListIterableTestCase::asUnique;
            this.payloads.forEach_executionException = ParallelListIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = ParallelListIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelListIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelListIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelListIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelListIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelListIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelListIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelListIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelListIterableTestCase::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelListIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelListIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelListIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
}
