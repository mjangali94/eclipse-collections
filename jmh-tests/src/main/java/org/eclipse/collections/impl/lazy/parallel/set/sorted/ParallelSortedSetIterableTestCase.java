/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.lazy.parallel.set.sorted;

import org.eclipse.collections.api.set.sorted.ParallelSortedSetIterable;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

public abstract class ParallelSortedSetIterableTestCase extends ParallelIterableTestCase {

    @Override
    protected abstract ParallelSortedSetIterable<Integer> classUnderTest();

    @Override
    protected SortedSetIterable<Integer> getExpected() {
        return TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 4, 3, 2, 1);
    }

    @Override
    protected SortedSetIterable<Integer> getExpectedWith(Integer... littleElements) {
        return TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), littleElements);
    }

    @Override
    protected boolean isOrdered() {
        return true;
    }

    @Override
    protected boolean isUnique() {
        return true;
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelSortedSetIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new ParallelSortedSetIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSortedSetIterableTestCase> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelSortedSetIterableTestCase::toArray;
            this.payloads.toArray_array = ParallelSortedSetIterableTestCase::toArray_array;
            this.payloads.forEach = ParallelSortedSetIterableTestCase::forEach;
            this.payloads.forEachWith = ParallelSortedSetIterableTestCase::forEachWith;
            this.payloads.select = ParallelSortedSetIterableTestCase::select;
            this.payloads.selectWith = ParallelSortedSetIterableTestCase::selectWith;
            this.payloads.reject = ParallelSortedSetIterableTestCase::reject;
            this.payloads.rejectWith = ParallelSortedSetIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = ParallelSortedSetIterableTestCase::selectInstancesOf;
            this.payloads.collect = ParallelSortedSetIterableTestCase::collect;
            this.payloads.collectWith = ParallelSortedSetIterableTestCase::collectWith;
            this.payloads.collectIf = ParallelSortedSetIterableTestCase::collectIf;
            this.payloads.flatCollect = ParallelSortedSetIterableTestCase::flatCollect;
            this.payloads.detect = ParallelSortedSetIterableTestCase::detect;
            this.payloads.detectIfNone = ParallelSortedSetIterableTestCase::detectIfNone;
            this.payloads.detectWith = ParallelSortedSetIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = ParallelSortedSetIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelSortedSetIterableTestCase::min;
            this.payloads.max = ParallelSortedSetIterableTestCase::max;
            this.payloads.minBy = ParallelSortedSetIterableTestCase::minBy;
            this.payloads.maxBy = ParallelSortedSetIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelSortedSetIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ParallelSortedSetIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = ParallelSortedSetIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ParallelSortedSetIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ParallelSortedSetIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ParallelSortedSetIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelSortedSetIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelSortedSetIterableTestCase::noneSatisfyWith;
            this.payloads.count = ParallelSortedSetIterableTestCase::count;
            this.payloads.countWith = ParallelSortedSetIterableTestCase::countWith;
            this.payloads.toList = ParallelSortedSetIterableTestCase::toList;
            this.payloads.toSortedList = ParallelSortedSetIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = ParallelSortedSetIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelSortedSetIterableTestCase::toSortedListBy;
            this.payloads.toSet = ParallelSortedSetIterableTestCase::toSet;
            this.payloads.toSortedSet = ParallelSortedSetIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelSortedSetIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelSortedSetIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = ParallelSortedSetIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelSortedSetIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelSortedSetIterableTestCase::toSortedBagBy;
            this.payloads.toMap = ParallelSortedSetIterableTestCase::toMap;
            this.payloads.toSortedMap = ParallelSortedSetIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelSortedSetIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = ParallelSortedSetIterableTestCase::testToString;
            this.payloads.makeString = ParallelSortedSetIterableTestCase::makeString;
            this.payloads.makeString_separator = ParallelSortedSetIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelSortedSetIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = ParallelSortedSetIterableTestCase::appendString;
            this.payloads.appendString_separator = ParallelSortedSetIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelSortedSetIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelSortedSetIterableTestCase::appendString_throws;
            this.payloads.groupBy = ParallelSortedSetIterableTestCase::groupBy;
            this.payloads.groupByEach = ParallelSortedSetIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ParallelSortedSetIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelSortedSetIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelSortedSetIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelSortedSetIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = ParallelSortedSetIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = ParallelSortedSetIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelSortedSetIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelSortedSetIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelSortedSetIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelSortedSetIterableTestCase::asUnique;
            this.payloads.forEach_executionException = ParallelSortedSetIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = ParallelSortedSetIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelSortedSetIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelSortedSetIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelSortedSetIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelSortedSetIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelSortedSetIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelSortedSetIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelSortedSetIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelSortedSetIterableTestCase::toString_interruptedException;
            this.payloads.minWithEmptyBatch = ParallelSortedSetIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelSortedSetIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSortedSetIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
        }
    }
*/
}
