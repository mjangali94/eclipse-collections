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

import org.junit.Test;

public abstract class NonParallelUnsortedSetIterableTestCase extends ParallelUnsortedSetIterableTestCase {

    @Override
    @Test
    public void forEach_executionException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void collect_executionException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void anySatisfy_executionException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void allSatisfy_executionException() {
        // Not applicable
    }

    @Override
    @Test
    public void detect_executionException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void forEach_interruptedException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void anySatisfy_interruptedException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void allSatisfy_interruptedException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void detect_interruptedException() {
        // Not applicable in serial
    }

    @Override
    @Test
    public void toString_interruptedException() {
        // Not applicable in serial
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private NonParallelUnsortedSetIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new NonParallelUnsortedSetIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelUnsortedSetIterableTestCase> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = NonParallelUnsortedSetIterableTestCase::toArray;
            this.payloads.toArray_array = NonParallelUnsortedSetIterableTestCase::toArray_array;
            this.payloads.forEach = NonParallelUnsortedSetIterableTestCase::forEach;
            this.payloads.forEachWith = NonParallelUnsortedSetIterableTestCase::forEachWith;
            this.payloads.select = NonParallelUnsortedSetIterableTestCase::select;
            this.payloads.selectWith = NonParallelUnsortedSetIterableTestCase::selectWith;
            this.payloads.reject = NonParallelUnsortedSetIterableTestCase::reject;
            this.payloads.rejectWith = NonParallelUnsortedSetIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = NonParallelUnsortedSetIterableTestCase::selectInstancesOf;
            this.payloads.collect = NonParallelUnsortedSetIterableTestCase::collect;
            this.payloads.collectWith = NonParallelUnsortedSetIterableTestCase::collectWith;
            this.payloads.collectIf = NonParallelUnsortedSetIterableTestCase::collectIf;
            this.payloads.flatCollect = NonParallelUnsortedSetIterableTestCase::flatCollect;
            this.payloads.detect = NonParallelUnsortedSetIterableTestCase::detect;
            this.payloads.detectIfNone = NonParallelUnsortedSetIterableTestCase::detectIfNone;
            this.payloads.detectWith = NonParallelUnsortedSetIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = NonParallelUnsortedSetIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = NonParallelUnsortedSetIterableTestCase::min;
            this.payloads.max = NonParallelUnsortedSetIterableTestCase::max;
            this.payloads.minBy = NonParallelUnsortedSetIterableTestCase::minBy;
            this.payloads.maxBy = NonParallelUnsortedSetIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = NonParallelUnsortedSetIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = NonParallelUnsortedSetIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = NonParallelUnsortedSetIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = NonParallelUnsortedSetIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = NonParallelUnsortedSetIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = NonParallelUnsortedSetIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = NonParallelUnsortedSetIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = NonParallelUnsortedSetIterableTestCase::noneSatisfyWith;
            this.payloads.count = NonParallelUnsortedSetIterableTestCase::count;
            this.payloads.countWith = NonParallelUnsortedSetIterableTestCase::countWith;
            this.payloads.toList = NonParallelUnsortedSetIterableTestCase::toList;
            this.payloads.toSortedList = NonParallelUnsortedSetIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = NonParallelUnsortedSetIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = NonParallelUnsortedSetIterableTestCase::toSortedListBy;
            this.payloads.toSet = NonParallelUnsortedSetIterableTestCase::toSet;
            this.payloads.toSortedSet = NonParallelUnsortedSetIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = NonParallelUnsortedSetIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = NonParallelUnsortedSetIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = NonParallelUnsortedSetIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = NonParallelUnsortedSetIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = NonParallelUnsortedSetIterableTestCase::toSortedBagBy;
            this.payloads.toMap = NonParallelUnsortedSetIterableTestCase::toMap;
            this.payloads.toSortedMap = NonParallelUnsortedSetIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = NonParallelUnsortedSetIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = NonParallelUnsortedSetIterableTestCase::testToString;
            this.payloads.makeString = NonParallelUnsortedSetIterableTestCase::makeString;
            this.payloads.makeString_separator = NonParallelUnsortedSetIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = NonParallelUnsortedSetIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = NonParallelUnsortedSetIterableTestCase::appendString;
            this.payloads.appendString_separator = NonParallelUnsortedSetIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = NonParallelUnsortedSetIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = NonParallelUnsortedSetIterableTestCase::appendString_throws;
            this.payloads.groupBy = NonParallelUnsortedSetIterableTestCase::groupBy;
            this.payloads.groupByEach = NonParallelUnsortedSetIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = NonParallelUnsortedSetIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = NonParallelUnsortedSetIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = NonParallelUnsortedSetIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = NonParallelUnsortedSetIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = NonParallelUnsortedSetIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = NonParallelUnsortedSetIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = NonParallelUnsortedSetIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = NonParallelUnsortedSetIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = NonParallelUnsortedSetIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = NonParallelUnsortedSetIterableTestCase::asUnique;
            this.payloads.minWithEmptyBatch = NonParallelUnsortedSetIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = NonParallelUnsortedSetIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelUnsortedSetIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEach_executionException = NonParallelUnsortedSetIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = NonParallelUnsortedSetIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = NonParallelUnsortedSetIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = NonParallelUnsortedSetIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = NonParallelUnsortedSetIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = NonParallelUnsortedSetIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = NonParallelUnsortedSetIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = NonParallelUnsortedSetIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = NonParallelUnsortedSetIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = NonParallelUnsortedSetIterableTestCase::toString_interruptedException;
        }
    }
}
