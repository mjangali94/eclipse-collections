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

import org.junit.Test;

public abstract class NonParallelSortedSetIterableTestCase extends ParallelSortedSetIterableTestCase {

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

        private NonParallelSortedSetIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new NonParallelSortedSetIterableTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<NonParallelSortedSetIterableTestCase> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = NonParallelSortedSetIterableTestCase::toArray;
            this.payloads.toArray_array = NonParallelSortedSetIterableTestCase::toArray_array;
            this.payloads.forEach = NonParallelSortedSetIterableTestCase::forEach;
            this.payloads.forEachWith = NonParallelSortedSetIterableTestCase::forEachWith;
            this.payloads.select = NonParallelSortedSetIterableTestCase::select;
            this.payloads.selectWith = NonParallelSortedSetIterableTestCase::selectWith;
            this.payloads.reject = NonParallelSortedSetIterableTestCase::reject;
            this.payloads.rejectWith = NonParallelSortedSetIterableTestCase::rejectWith;
            this.payloads.selectInstancesOf = NonParallelSortedSetIterableTestCase::selectInstancesOf;
            this.payloads.collect = NonParallelSortedSetIterableTestCase::collect;
            this.payloads.collectWith = NonParallelSortedSetIterableTestCase::collectWith;
            this.payloads.collectIf = NonParallelSortedSetIterableTestCase::collectIf;
            this.payloads.flatCollect = NonParallelSortedSetIterableTestCase::flatCollect;
            this.payloads.detect = NonParallelSortedSetIterableTestCase::detect;
            this.payloads.detectIfNone = NonParallelSortedSetIterableTestCase::detectIfNone;
            this.payloads.detectWith = NonParallelSortedSetIterableTestCase::detectWith;
            this.payloads.detectWithIfNone = NonParallelSortedSetIterableTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = NonParallelSortedSetIterableTestCase::min;
            this.payloads.max = NonParallelSortedSetIterableTestCase::max;
            this.payloads.minBy = NonParallelSortedSetIterableTestCase::minBy;
            this.payloads.maxBy = NonParallelSortedSetIterableTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = NonParallelSortedSetIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = NonParallelSortedSetIterableTestCase::max_without_comparator;
            this.payloads.anySatisfy = NonParallelSortedSetIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = NonParallelSortedSetIterableTestCase::anySatisfyWith;
            this.payloads.allSatisfy = NonParallelSortedSetIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = NonParallelSortedSetIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = NonParallelSortedSetIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = NonParallelSortedSetIterableTestCase::noneSatisfyWith;
            this.payloads.count = NonParallelSortedSetIterableTestCase::count;
            this.payloads.countWith = NonParallelSortedSetIterableTestCase::countWith;
            this.payloads.toList = NonParallelSortedSetIterableTestCase::toList;
            this.payloads.toSortedList = NonParallelSortedSetIterableTestCase::toSortedList;
            this.payloads.toSortedList_comparator = NonParallelSortedSetIterableTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = NonParallelSortedSetIterableTestCase::toSortedListBy;
            this.payloads.toSet = NonParallelSortedSetIterableTestCase::toSet;
            this.payloads.toSortedSet = NonParallelSortedSetIterableTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = NonParallelSortedSetIterableTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = NonParallelSortedSetIterableTestCase::toSortedSetBy;
            this.payloads.toSortedBag = NonParallelSortedSetIterableTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = NonParallelSortedSetIterableTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = NonParallelSortedSetIterableTestCase::toSortedBagBy;
            this.payloads.toMap = NonParallelSortedSetIterableTestCase::toMap;
            this.payloads.toSortedMap = NonParallelSortedSetIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = NonParallelSortedSetIterableTestCase::toSortedMap_comparator;
            this.payloads.testToString = NonParallelSortedSetIterableTestCase::testToString;
            this.payloads.makeString = NonParallelSortedSetIterableTestCase::makeString;
            this.payloads.makeString_separator = NonParallelSortedSetIterableTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = NonParallelSortedSetIterableTestCase::makeString_start_separator_end;
            this.payloads.appendString = NonParallelSortedSetIterableTestCase::appendString;
            this.payloads.appendString_separator = NonParallelSortedSetIterableTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = NonParallelSortedSetIterableTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = NonParallelSortedSetIterableTestCase::appendString_throws;
            this.payloads.groupBy = NonParallelSortedSetIterableTestCase::groupBy;
            this.payloads.groupByEach = NonParallelSortedSetIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = NonParallelSortedSetIterableTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = NonParallelSortedSetIterableTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = NonParallelSortedSetIterableTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = NonParallelSortedSetIterableTestCase::sumOfInt;
            this.payloads.sumOfLong = NonParallelSortedSetIterableTestCase::sumOfLong;
            this.payloads.sumOfFloat = NonParallelSortedSetIterableTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = NonParallelSortedSetIterableTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = NonParallelSortedSetIterableTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = NonParallelSortedSetIterableTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = NonParallelSortedSetIterableTestCase::asUnique;
            this.payloads.minWithEmptyBatch = NonParallelSortedSetIterableTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = NonParallelSortedSetIterableTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(NonParallelSortedSetIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEach_executionException = NonParallelSortedSetIterableTestCase::forEach_executionException;
            this.payloads.collect_executionException = NonParallelSortedSetIterableTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = NonParallelSortedSetIterableTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = NonParallelSortedSetIterableTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = NonParallelSortedSetIterableTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = NonParallelSortedSetIterableTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = NonParallelSortedSetIterableTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = NonParallelSortedSetIterableTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = NonParallelSortedSetIterableTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = NonParallelSortedSetIterableTestCase::toString_interruptedException;
        }
    }
}
