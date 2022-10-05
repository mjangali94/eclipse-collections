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

import org.junit.Test;

public abstract class NonParallelListIterableTestCase extends ParallelListIterableTestCase {

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

        private NonParallelListIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new NonParallelListIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelListIterableTestCase> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = NonParallelListIterableTestCase::toArray;
            this.payloads.toArray_array = NonParallelListIterableTestCase::toArray_array;
            this.payloads.forEach = NonParallelListIterableTestCase::forEach;
            this.payloads.forEachWith = NonParallelListIterableTestCase::forEachWith;
            this.payloads.select = NonParallelListIterableTestCase::select;
            this.payloads.selectWith = NonParallelListIterableTestCase::selectWith;
            this.payloads.reject = NonParallelListIterableTestCase::reject;
            this.payloads.rejectWith = NonParallelListIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = NonParallelListIterableTestCase::selectInstancesOf;
            this.payloads.collect = NonParallelListIterableTestCase::collect;
            this.payloads.collectWith = NonParallelListIterableTestCase::collectWith;
            this.payloads.collectIf = NonParallelListIterableTestCase::collectIf;
            this.payloads.flatCollect = NonParallelListIterableTestCase::flatCollect;
            this.payloads.detect = NonParallelListIterableTestCase::detect;
            this.payloads.detectIfNone = NonParallelListIterableTestCase::detectIfNone;
            this.payloads.detectWith = NonParallelListIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = NonParallelListIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = NonParallelListIterableTestCase::min;
            this.payloads.max = NonParallelListIterableTestCase::max;
            this.payloads.minBy = NonParallelListIterableTestCase::minBy;
            this.payloads.maxBy = NonParallelListIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = NonParallelListIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = NonParallelListIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = NonParallelListIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = NonParallelListIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = NonParallelListIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = NonParallelListIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = NonParallelListIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = NonParallelListIterableTestCase::noneSatisfyWith;
            this.payloads.count = NonParallelListIterableTestCase::count;
            this.payloads.countWith = NonParallelListIterableTestCase::countWith;
            this.payloads.toList = NonParallelListIterableTestCase::toList;
            this.payloads.toSortedList = NonParallelListIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = NonParallelListIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = NonParallelListIterableTestCase::toSortedListBy;
            this.payloads.toSet = NonParallelListIterableTestCase::toSet;
            this.payloads.toSortedSet = NonParallelListIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = NonParallelListIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = NonParallelListIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = NonParallelListIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = NonParallelListIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = NonParallelListIterableTestCase::toSortedBagBy;
            this.payloads.toMap = NonParallelListIterableTestCase::toMap;
            this.payloads.toSortedMap = NonParallelListIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = NonParallelListIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = NonParallelListIterableTestCase::testToString;
            this.payloads.makeString = NonParallelListIterableTestCase::makeString;
            this.payloads.makeString_separator = NonParallelListIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = NonParallelListIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = NonParallelListIterableTestCase::appendString;
            this.payloads.appendString_separator = NonParallelListIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = NonParallelListIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = NonParallelListIterableTestCase::appendString_throws;
            this.payloads.groupBy = NonParallelListIterableTestCase::groupBy;
            this.payloads.groupByEach = NonParallelListIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = NonParallelListIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = NonParallelListIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = NonParallelListIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = NonParallelListIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = NonParallelListIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = NonParallelListIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = NonParallelListIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = NonParallelListIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = NonParallelListIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = NonParallelListIterableTestCase::asUnique;
            this.payloads.minWithEmptyBatch = NonParallelListIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = NonParallelListIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelListIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEach_executionException = NonParallelListIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = NonParallelListIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = NonParallelListIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = NonParallelListIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = NonParallelListIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = NonParallelListIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = NonParallelListIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = NonParallelListIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = NonParallelListIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = NonParallelListIterableTestCase::toString_interruptedException;
        }
    }
}
