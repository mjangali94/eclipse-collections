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
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

public abstract class ParallelBagTestCase extends ParallelIterableTestCase {

    @Override
    protected abstract ParallelBag<Integer> classUnderTest();

    @Override
    protected abstract ParallelBag<Integer> newWith(Integer... littleElements);

    @Override
    protected MutableBag<Integer> getExpected() {
        return HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected MutableBag<Integer> getExpectedWith(Integer... littleElements) {
        return HashBag.newBagWith(littleElements);
    }

    @Override
    protected boolean isOrdered() {
        return false;
    }

    @Override
    protected boolean isUnique() {
        return false;
    }

    @Test
    public void forEachWithOccurrences() {
        MutableBag<Integer> actual = HashBag.<Integer>newBag().asSynchronized();
        this.classUnderTest().forEachWithOccurrences(actual::addOccurrences);
        Assert.assertEquals(this.getExpected().toBag(), actual);
    }

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

        private ParallelBagTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new ParallelBagTestCase();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ParallelBagTestCase> toString_interruptedException;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ParallelBagTestCase::toArray;
            this.payloads.toArray_array = ParallelBagTestCase::toArray_array;
            this.payloads.forEach = ParallelBagTestCase::forEach;
            this.payloads.forEachWith = ParallelBagTestCase::forEachWith;
            this.payloads.select = ParallelBagTestCase::select;
            this.payloads.selectWith = ParallelBagTestCase::selectWith;
            this.payloads.reject = ParallelBagTestCase::reject;
            this.payloads.rejectWith = ParallelBagTestCase::rejectWith;
            this.payloads.selectInstancesOf = ParallelBagTestCase::selectInstancesOf;
            this.payloads.collect = ParallelBagTestCase::collect;
            this.payloads.collectWith = ParallelBagTestCase::collectWith;
            this.payloads.collectIf = ParallelBagTestCase::collectIf;
            this.payloads.flatCollect = ParallelBagTestCase::flatCollect;
            this.payloads.detect = ParallelBagTestCase::detect;
            this.payloads.detectIfNone = ParallelBagTestCase::detectIfNone;
            this.payloads.detectWith = ParallelBagTestCase::detectWith;
            this.payloads.detectWithIfNone = ParallelBagTestCase::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = ParallelBagTestCase::min;
            this.payloads.max = ParallelBagTestCase::max;
            this.payloads.minBy = ParallelBagTestCase::minBy;
            this.payloads.maxBy = ParallelBagTestCase::maxBy;
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = ParallelBagTestCase::min_without_comparator;
            this.payloads.max_without_comparator = ParallelBagTestCase::max_without_comparator;
            this.payloads.anySatisfy = ParallelBagTestCase::anySatisfy;
            this.payloads.anySatisfyWith = ParallelBagTestCase::anySatisfyWith;
            this.payloads.allSatisfy = ParallelBagTestCase::allSatisfy;
            this.payloads.allSatisfyWith = ParallelBagTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = ParallelBagTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = ParallelBagTestCase::noneSatisfyWith;
            this.payloads.count = ParallelBagTestCase::count;
            this.payloads.countWith = ParallelBagTestCase::countWith;
            this.payloads.toList = ParallelBagTestCase::toList;
            this.payloads.toSortedList = ParallelBagTestCase::toSortedList;
            this.payloads.toSortedList_comparator = ParallelBagTestCase::toSortedList_comparator;
            this.payloads.toSortedListBy = ParallelBagTestCase::toSortedListBy;
            this.payloads.toSet = ParallelBagTestCase::toSet;
            this.payloads.toSortedSet = ParallelBagTestCase::toSortedSet;
            this.payloads.toSortedSet_comparator = ParallelBagTestCase::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ParallelBagTestCase::toSortedSetBy;
            this.payloads.toSortedBag = ParallelBagTestCase::toSortedBag;
            this.payloads.toSortedBag_comparator = ParallelBagTestCase::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ParallelBagTestCase::toSortedBagBy;
            this.payloads.toMap = ParallelBagTestCase::toMap;
            this.payloads.toSortedMap = ParallelBagTestCase::toSortedMap;
            this.payloads.toSortedMap_comparator = ParallelBagTestCase::toSortedMap_comparator;
            this.payloads.testToString = ParallelBagTestCase::testToString;
            this.payloads.makeString = ParallelBagTestCase::makeString;
            this.payloads.makeString_separator = ParallelBagTestCase::makeString_separator;
            this.payloads.makeString_start_separator_end = ParallelBagTestCase::makeString_start_separator_end;
            this.payloads.appendString = ParallelBagTestCase::appendString;
            this.payloads.appendString_separator = ParallelBagTestCase::appendString_separator;
            this.payloads.appendString_start_separator_end = ParallelBagTestCase::appendString_start_separator_end;
            this.payloads.appendString_throws = ParallelBagTestCase::appendString_throws;
            this.payloads.groupBy = ParallelBagTestCase::groupBy;
            this.payloads.groupByEach = ParallelBagTestCase::groupByEach;
            this.payloads.groupByUniqueKey = ParallelBagTestCase::groupByUniqueKey;
            this.payloads.aggregateBy = ParallelBagTestCase::aggregateBy;
            this.payloads.aggregateInPlaceBy = ParallelBagTestCase::aggregateInPlaceBy;
            this.payloads.sumOfInt = ParallelBagTestCase::sumOfInt;
            this.payloads.sumOfLong = ParallelBagTestCase::sumOfLong;
            this.payloads.sumOfFloat = ParallelBagTestCase::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ParallelBagTestCase::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ParallelBagTestCase::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ParallelBagTestCase::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ParallelBagTestCase::asUnique;
            this.payloads.minWithEmptyBatch = ParallelBagTestCase::minWithEmptyBatch;
            this.payloads.maxWithEmptyBatch = ParallelBagTestCase::maxWithEmptyBatch;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ParallelBagTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.forEachWithOccurrences = ParallelBagTestCase::forEachWithOccurrences;
            this.payloads.forEach_executionException = ParallelBagTestCase::forEach_executionException;
            this.payloads.collect_executionException = ParallelBagTestCase::collect_executionException;
            this.payloads.anySatisfy_executionException = ParallelBagTestCase::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ParallelBagTestCase::allSatisfy_executionException;
            this.payloads.detect_executionException = ParallelBagTestCase::detect_executionException;
            this.payloads.forEach_interruptedException = ParallelBagTestCase::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ParallelBagTestCase::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ParallelBagTestCase::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ParallelBagTestCase::detect_interruptedException;
            this.payloads.toString_interruptedException = ParallelBagTestCase::toString_interruptedException;
        }
    }
}
