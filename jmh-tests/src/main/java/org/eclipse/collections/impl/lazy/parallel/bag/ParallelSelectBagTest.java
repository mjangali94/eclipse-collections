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
import org.eclipse.collections.impl.block.factory.Predicates;

public class ParallelSelectBagTest extends ParallelBagTestCase {

    @Override
    protected ParallelBag<Integer> classUnderTest() {
        return this.newWith(-1, 1, -1, 2, -1, 2, -1, 3, -1, 3, -1, 3, 5, 4, 5, 4, 5, 4, 5, 4, 5);
    }

    @Override
    protected ParallelBag<Integer> newWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).asParallel(this.executorService, this.batchSize).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @Override
    protected MutableBag<Integer> getExpectedWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements).select(Predicates.greaterThan(0)).select(Predicates.lessThan(5));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ParallelSelectBagTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> payload) throws java.lang.Throwable {
            this.instance = new ParallelSelectBagTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelSelectBagTest> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelSelectBagTest::toArray;
            this.payloads.toArray_array = ParallelSelectBagTest::toArray_array;
            this.payloads.forEach = ParallelSelectBagTest::forEach;
            this.payloads.forEachWith = ParallelSelectBagTest::forEachWith;
            this.payloads.select = ParallelSelectBagTest::select;
            this.payloads.selectWith = ParallelSelectBagTest::selectWith;
            this.payloads.reject = ParallelSelectBagTest::reject;
            this.payloads.rejectWith = ParallelSelectBagTest::rejectWith;
            this.payloads.selectInstancesOf = ParallelSelectBagTest::selectInstancesOf;
            this.payloads.collect = ParallelSelectBagTest::collect;
            this.payloads.collectWith = ParallelSelectBagTest::collectWith;
            this.payloads.collectIf = ParallelSelectBagTest::collectIf;
            this.payloads.flatCollect = ParallelSelectBagTest::flatCollect;
            this.payloads.detect = ParallelSelectBagTest::detect;
            this.payloads.detectIfNone = ParallelSelectBagTest::detectIfNone;
            this.payloads.detectWith = ParallelSelectBagTest::detectWith;
            this.payloads.detectWithIfNone = ParallelSelectBagTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelSelectBagTest::min;
            this.payloads.max = ParallelSelectBagTest::max;
            this.payloads.minBy = ParallelSelectBagTest::minBy;
            this.payloads.maxBy = ParallelSelectBagTest::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelSelectBagTest::min_without_comparator;
            this.payloads.max_without_comparator = ParallelSelectBagTest::max_without_comparator;
            this.payloads.anySatisfy = ParallelSelectBagTest::anySatisfy;
            this.payloads.anySatisfyWith = ParallelSelectBagTest::anySatisfyWith;
            this.payloads.allSatisfy = ParallelSelectBagTest::allSatisfy;
            this.payloads.allSatisfyWith = ParallelSelectBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelSelectBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelSelectBagTest::noneSatisfyWith;
            this.payloads.count = ParallelSelectBagTest::count;
            this.payloads.countWith = ParallelSelectBagTest::countWith;
            this.payloads.toList = ParallelSelectBagTest::toList;
            this.payloads.toSortedList = ParallelSelectBagTest::toSortedList;
            this.payloads.toSortedList_comparator = ParallelSelectBagTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelSelectBagTest::toSortedListBy;
            this.payloads.toSet = ParallelSelectBagTest::toSet;
            this.payloads.toSortedSet = ParallelSelectBagTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelSelectBagTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelSelectBagTest::toSortedSetBy;
            this.payloads.toSortedBag = ParallelSelectBagTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelSelectBagTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelSelectBagTest::toSortedBagBy;
            this.payloads.toMap = ParallelSelectBagTest::toMap;
            this.payloads.toSortedMap = ParallelSelectBagTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelSelectBagTest::toSortedMap_comparator;
            this.payloads.testToString = ParallelSelectBagTest::testToString;
            this.payloads.makeString = ParallelSelectBagTest::makeString;
            this.payloads.makeString_separator = ParallelSelectBagTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelSelectBagTest::makeString_start_separator_end;
            this.payloads.appendString = ParallelSelectBagTest::appendString;
            this.payloads.appendString_separator = ParallelSelectBagTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelSelectBagTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelSelectBagTest::appendString_throws;
            this.payloads.groupBy = ParallelSelectBagTest::groupBy;
            this.payloads.groupByEach = ParallelSelectBagTest::groupByEach;
            this.payloads.groupByUniqueKey = ParallelSelectBagTest::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelSelectBagTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelSelectBagTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelSelectBagTest::sumOfInt;
            this.payloads.sumOfLong = ParallelSelectBagTest::sumOfLong;
            this.payloads.sumOfFloat = ParallelSelectBagTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelSelectBagTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelSelectBagTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelSelectBagTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelSelectBagTest::asUnique;
            this.payloads.minWithEmptyBatch = ParallelSelectBagTest::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelSelectBagTest::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelSelectBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEachWithOccurrences = ParallelSelectBagTest::forEachWithOccurrences;
            this.payloads.forEach_executionException = ParallelSelectBagTest::forEach_executionException;
            this.payloads.collect_executionException = ParallelSelectBagTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelSelectBagTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelSelectBagTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelSelectBagTest::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelSelectBagTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelSelectBagTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelSelectBagTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelSelectBagTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelSelectBagTest::toString_interruptedException;
        }
    }
}
