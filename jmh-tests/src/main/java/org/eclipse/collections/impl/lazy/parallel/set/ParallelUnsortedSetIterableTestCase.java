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

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

public abstract class ParallelUnsortedSetIterableTestCase extends ParallelIterableTestCase {

    @Override
    protected abstract ParallelUnsortedSetIterable<Integer> classUnderTest();

    @Override
    protected abstract ParallelUnsortedSetIterable<Integer> newWith(Integer... littleElements);

    @Override
    protected MutableSet<Integer> getExpected() {
        return UnifiedSet.newSetWith(1, 2, 3, 4);
    }

    @Override
    protected MutableSet<Integer> getExpectedWith(Integer... littleElements) {
        return UnifiedSet.newSetWith(littleElements);
    }

    @Override
    protected RichIterable<Integer> getExpectedCollect() {
        return HashBag.newBagWith(1, 2, 3, 4);
    }

    @Override
    protected boolean isOrdered() {
        return false;
    }

    @Override
    protected boolean isUnique() {
        return true;
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelUnsortedSetIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new ParallelUnsortedSetIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelUnsortedSetIterableTestCase> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelUnsortedSetIterableTestCase::toArray;
            this.payloads.toArray_array = ParallelUnsortedSetIterableTestCase::toArray_array;
            this.payloads.forEach = ParallelUnsortedSetIterableTestCase::forEach;
            this.payloads.forEachWith = ParallelUnsortedSetIterableTestCase::forEachWith;
            this.payloads.select = ParallelUnsortedSetIterableTestCase::select;
            this.payloads.selectWith = ParallelUnsortedSetIterableTestCase::selectWith;
            this.payloads.reject = ParallelUnsortedSetIterableTestCase::reject;
            this.payloads.rejectWith = ParallelUnsortedSetIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = ParallelUnsortedSetIterableTestCase::selectInstancesOf;
            this.payloads.collect = ParallelUnsortedSetIterableTestCase::collect;
            this.payloads.collectWith = ParallelUnsortedSetIterableTestCase::collectWith;
            this.payloads.collectIf = ParallelUnsortedSetIterableTestCase::collectIf;
            this.payloads.flatCollect = ParallelUnsortedSetIterableTestCase::flatCollect;
            this.payloads.detect = ParallelUnsortedSetIterableTestCase::detect;
            this.payloads.detectIfNone = ParallelUnsortedSetIterableTestCase::detectIfNone;
            this.payloads.detectWith = ParallelUnsortedSetIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = ParallelUnsortedSetIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelUnsortedSetIterableTestCase::min;
            this.payloads.max = ParallelUnsortedSetIterableTestCase::max;
            this.payloads.minBy = ParallelUnsortedSetIterableTestCase::minBy;
            this.payloads.maxBy = ParallelUnsortedSetIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelUnsortedSetIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ParallelUnsortedSetIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = ParallelUnsortedSetIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ParallelUnsortedSetIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ParallelUnsortedSetIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ParallelUnsortedSetIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelUnsortedSetIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelUnsortedSetIterableTestCase::noneSatisfyWith;
            this.payloads.count = ParallelUnsortedSetIterableTestCase::count;
            this.payloads.countWith = ParallelUnsortedSetIterableTestCase::countWith;
            this.payloads.toList = ParallelUnsortedSetIterableTestCase::toList;
            this.payloads.toSortedList = ParallelUnsortedSetIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = ParallelUnsortedSetIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelUnsortedSetIterableTestCase::toSortedListBy;
            this.payloads.toSet = ParallelUnsortedSetIterableTestCase::toSet;
            this.payloads.toSortedSet = ParallelUnsortedSetIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelUnsortedSetIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelUnsortedSetIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = ParallelUnsortedSetIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelUnsortedSetIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelUnsortedSetIterableTestCase::toSortedBagBy;
            this.payloads.toMap = ParallelUnsortedSetIterableTestCase::toMap;
            this.payloads.toSortedMap = ParallelUnsortedSetIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelUnsortedSetIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = ParallelUnsortedSetIterableTestCase::testToString;
            this.payloads.makeString = ParallelUnsortedSetIterableTestCase::makeString;
            this.payloads.makeString_separator = ParallelUnsortedSetIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelUnsortedSetIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = ParallelUnsortedSetIterableTestCase::appendString;
            this.payloads.appendString_separator = ParallelUnsortedSetIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelUnsortedSetIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelUnsortedSetIterableTestCase::appendString_throws;
            this.payloads.groupBy = ParallelUnsortedSetIterableTestCase::groupBy;
            this.payloads.groupByEach = ParallelUnsortedSetIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ParallelUnsortedSetIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelUnsortedSetIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelUnsortedSetIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelUnsortedSetIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = ParallelUnsortedSetIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = ParallelUnsortedSetIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelUnsortedSetIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelUnsortedSetIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelUnsortedSetIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelUnsortedSetIterableTestCase::asUnique;
            this.payloads.forEach_executionException = ParallelUnsortedSetIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = ParallelUnsortedSetIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelUnsortedSetIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelUnsortedSetIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelUnsortedSetIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelUnsortedSetIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelUnsortedSetIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelUnsortedSetIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelUnsortedSetIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelUnsortedSetIterableTestCase::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelUnsortedSetIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelUnsortedSetIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelUnsortedSetIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
}
