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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.set.sorted.ParallelSortedSetIterable;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableEmptySortedSetParallelTest extends NonParallelSortedSetIterableTestCase {

    @Override
    protected SortedSetIterable<Integer> getExpected() {
        return TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder());
    }

    @Override
    protected SortedSetIterable<Integer> getExpectedWith(Integer... littleElements) {
        return TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder());
    }

    @Override
    protected ParallelSortedSetIterable<Integer> classUnderTest() {
        return this.newWith();
    }

    @Override
    protected ParallelSortedSetIterable<Integer> newWith(Integer... littleElements) {
        return SortedSets.immutable.with(Comparators.<Integer>reverseNaturalOrder()).asParallel(this.executorService, this.batchSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void asParallel_small_batch() {
        SortedSets.immutable.with(Comparators.reverseNaturalOrder()).asParallel(this.executorService, 0);
    }

    @Test(expected = NullPointerException.class)
    public void asParallel_null_executorService() {
        SortedSets.immutable.with(Comparators.reverseNaturalOrder()).asParallel(null, 2);
    }

    @Override
    public void allSatisfy() {
        Assert.assertTrue(this.classUnderTest().allSatisfy(Predicates.lessThan(0)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(Predicates.greaterThanOrEqualTo(0)));
    }

    @Override
    public void allSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(Predicates2.lessThan(), 0));
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(Predicates2.greaterThanOrEqualTo(), 0));
    }

    @Override
    public void anySatisfy() {
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.lessThan(0)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.greaterThanOrEqualTo(0)));
    }

    @Override
    public void anySatisfyWith() {
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.lessThan(), 0));
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Predicates2.greaterThanOrEqualTo(), 0));
    }

    @Override
    public void noneSatisfy() {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.lessThan(0)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.greaterThanOrEqualTo(0)));
    }

    @Override
    public void noneSatisfyWith() {
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.lessThan(), 0));
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(Predicates2.greaterThanOrEqualTo(), 0));
    }

    @Override
    public void appendString_throws() {
        // Not applicable for empty collections
    }

    @Override
    public void detect() {
        Assert.assertNull(this.classUnderTest().detect(Integer.valueOf(0)::equals));
    }

    @Override
    public void detectIfNone() {
        Assert.assertEquals(Integer.valueOf(10), this.classUnderTest().detectIfNone(Integer.valueOf(0)::equals, () -> 10));
    }

    @Override
    public void detectWith() {
        Assert.assertNull(this.classUnderTest().detectWith(Object::equals, Integer.valueOf(0)));
    }

    @Override
    public void detectWithIfNone() {
        Function0<Integer> function = new PassThruFunction0<>(Integer.valueOf(1000));
        Assert.assertEquals(Integer.valueOf(1000), this.classUnderTest().detectWithIfNone(Object::equals, Integer.valueOf(0), function));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        this.classUnderTest().min(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        this.classUnderTest().max(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        this.classUnderTest().minBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        this.classUnderTest().maxBy(String::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_without_comparator() {
        this.classUnderTest().min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_without_comparator() {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minWithEmptyBatch() {
        super.minWithEmptyBatch();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxWithEmptyBatch() {
        super.minWithEmptyBatch();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min_null_throws() {
        this.classUnderTest().min(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max_null_throws() {
        this.classUnderTest().max(Integer::compareTo);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy_null_throws() {
        this.classUnderTest().minBy(Integer::valueOf);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy_null_throws() {
        this.classUnderTest().maxBy(Integer::valueOf);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptySortedSetParallelTest instance;

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
        public void benchmark_min_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws_without_comparator);
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
        public void benchmark_asParallel_small_batch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_small_batch);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asParallel_null_executorService() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asParallel_null_executorService);
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
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_without_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_without_comparator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptySortedSetParallelTest();
            this.instance.setUp();
            try {
                payload.accept(this.instance);
            } finally {
                this.instance.tearDown();
            }
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toArray_array;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> min_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> max_empty_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedList_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedSet_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedBag_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toSortedMap_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> makeString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> makeString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> appendString_separator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> appendString_start_separator_end;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> appendString_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> sumOfDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> asUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> forEach_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> collect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> anySatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> allSatisfy_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> detect_executionException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> forEach_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> anySatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> allSatisfy_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> detect_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> toString_interruptedException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> asParallel_small_batch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> asParallel_null_executorService;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> minWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> maxWithEmptyBatch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptySortedSetParallelTest> maxBy_null_throws;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.toArray = ImmutableEmptySortedSetParallelTest::toArray;
            this.payloads.toArray_array = ImmutableEmptySortedSetParallelTest::toArray_array;
            this.payloads.forEach = ImmutableEmptySortedSetParallelTest::forEach;
            this.payloads.forEachWith = ImmutableEmptySortedSetParallelTest::forEachWith;
            this.payloads.select = ImmutableEmptySortedSetParallelTest::select;
            this.payloads.selectWith = ImmutableEmptySortedSetParallelTest::selectWith;
            this.payloads.reject = ImmutableEmptySortedSetParallelTest::reject;
            this.payloads.rejectWith = ImmutableEmptySortedSetParallelTest::rejectWith;
            this.payloads.selectInstancesOf = ImmutableEmptySortedSetParallelTest::selectInstancesOf;
            this.payloads.collect = ImmutableEmptySortedSetParallelTest::collect;
            this.payloads.collectWith = ImmutableEmptySortedSetParallelTest::collectWith;
            this.payloads.collectIf = ImmutableEmptySortedSetParallelTest::collectIf;
            this.payloads.flatCollect = ImmutableEmptySortedSetParallelTest::flatCollect;
            this.payloads.detect = ImmutableEmptySortedSetParallelTest::detect;
            this.payloads.detectIfNone = ImmutableEmptySortedSetParallelTest::detectIfNone;
            this.payloads.detectWith = ImmutableEmptySortedSetParallelTest::detectWith;
            this.payloads.detectWithIfNone = ImmutableEmptySortedSetParallelTest::detectWithIfNone;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::min_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::max_empty_throws_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.anySatisfy = ImmutableEmptySortedSetParallelTest::anySatisfy;
            this.payloads.anySatisfyWith = ImmutableEmptySortedSetParallelTest::anySatisfyWith;
            this.payloads.allSatisfy = ImmutableEmptySortedSetParallelTest::allSatisfy;
            this.payloads.allSatisfyWith = ImmutableEmptySortedSetParallelTest::allSatisfyWith;
            this.payloads.noneSatisfy = ImmutableEmptySortedSetParallelTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ImmutableEmptySortedSetParallelTest::noneSatisfyWith;
            this.payloads.count = ImmutableEmptySortedSetParallelTest::count;
            this.payloads.countWith = ImmutableEmptySortedSetParallelTest::countWith;
            this.payloads.toList = ImmutableEmptySortedSetParallelTest::toList;
            this.payloads.toSortedList = ImmutableEmptySortedSetParallelTest::toSortedList;
            this.payloads.toSortedList_comparator = ImmutableEmptySortedSetParallelTest::toSortedList_comparator;
            this.payloads.toSortedListBy = ImmutableEmptySortedSetParallelTest::toSortedListBy;
            this.payloads.toSet = ImmutableEmptySortedSetParallelTest::toSet;
            this.payloads.toSortedSet = ImmutableEmptySortedSetParallelTest::toSortedSet;
            this.payloads.toSortedSet_comparator = ImmutableEmptySortedSetParallelTest::toSortedSet_comparator;
            this.payloads.toSortedSetBy = ImmutableEmptySortedSetParallelTest::toSortedSetBy;
            this.payloads.toSortedBag = ImmutableEmptySortedSetParallelTest::toSortedBag;
            this.payloads.toSortedBag_comparator = ImmutableEmptySortedSetParallelTest::toSortedBag_comparator;
            this.payloads.toSortedBagBy = ImmutableEmptySortedSetParallelTest::toSortedBagBy;
            this.payloads.toMap = ImmutableEmptySortedSetParallelTest::toMap;
            this.payloads.toSortedMap = ImmutableEmptySortedSetParallelTest::toSortedMap;
            this.payloads.toSortedMap_comparator = ImmutableEmptySortedSetParallelTest::toSortedMap_comparator;
            this.payloads.testToString = ImmutableEmptySortedSetParallelTest::testToString;
            this.payloads.makeString = ImmutableEmptySortedSetParallelTest::makeString;
            this.payloads.makeString_separator = ImmutableEmptySortedSetParallelTest::makeString_separator;
            this.payloads.makeString_start_separator_end = ImmutableEmptySortedSetParallelTest::makeString_start_separator_end;
            this.payloads.appendString = ImmutableEmptySortedSetParallelTest::appendString;
            this.payloads.appendString_separator = ImmutableEmptySortedSetParallelTest::appendString_separator;
            this.payloads.appendString_start_separator_end = ImmutableEmptySortedSetParallelTest::appendString_start_separator_end;
            this.payloads.appendString_throws = ImmutableEmptySortedSetParallelTest::appendString_throws;
            this.payloads.groupBy = ImmutableEmptySortedSetParallelTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptySortedSetParallelTest::groupByEach;
            this.payloads.groupByUniqueKey = ImmutableEmptySortedSetParallelTest::groupByUniqueKey;
            this.payloads.aggregateBy = ImmutableEmptySortedSetParallelTest::aggregateBy;
            this.payloads.aggregateInPlaceBy = ImmutableEmptySortedSetParallelTest::aggregateInPlaceBy;
            this.payloads.sumOfInt = ImmutableEmptySortedSetParallelTest::sumOfInt;
            this.payloads.sumOfLong = ImmutableEmptySortedSetParallelTest::sumOfLong;
            this.payloads.sumOfFloat = ImmutableEmptySortedSetParallelTest::sumOfFloat;
            this.payloads.sumOfFloatConsistentRounding = ImmutableEmptySortedSetParallelTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDouble = ImmutableEmptySortedSetParallelTest::sumOfDouble;
            this.payloads.sumOfDoubleConsistentRounding = ImmutableEmptySortedSetParallelTest::sumOfDoubleConsistentRounding;
            this.payloads.asUnique = ImmutableEmptySortedSetParallelTest::asUnique;
            this.payloads.forEach_executionException = ImmutableEmptySortedSetParallelTest::forEach_executionException;
            this.payloads.collect_executionException = ImmutableEmptySortedSetParallelTest::collect_executionException;
            this.payloads.anySatisfy_executionException = ImmutableEmptySortedSetParallelTest::anySatisfy_executionException;
            this.payloads.allSatisfy_executionException = ImmutableEmptySortedSetParallelTest::allSatisfy_executionException;
            this.payloads.detect_executionException = ImmutableEmptySortedSetParallelTest::detect_executionException;
            this.payloads.forEach_interruptedException = ImmutableEmptySortedSetParallelTest::forEach_interruptedException;
            this.payloads.anySatisfy_interruptedException = ImmutableEmptySortedSetParallelTest::anySatisfy_interruptedException;
            this.payloads.allSatisfy_interruptedException = ImmutableEmptySortedSetParallelTest::allSatisfy_interruptedException;
            this.payloads.detect_interruptedException = ImmutableEmptySortedSetParallelTest::detect_interruptedException;
            this.payloads.toString_interruptedException = ImmutableEmptySortedSetParallelTest::toString_interruptedException;
            this.payloads.asParallel_small_batch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::asParallel_small_batch, java.lang.IllegalArgumentException.class);
            this.payloads.asParallel_null_executorService = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::asParallel_null_executorService, java.lang.NullPointerException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::min, java.util.NoSuchElementException.class);
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::max, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.min_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::min_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.max_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::max_without_comparator, java.util.NoSuchElementException.class);
            this.payloads.minWithEmptyBatch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::minWithEmptyBatch, java.util.NoSuchElementException.class);
            this.payloads.maxWithEmptyBatch = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::maxWithEmptyBatch, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::min_null_throws, java.util.NoSuchElementException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::max_null_throws, java.util.NoSuchElementException.class);
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::minBy_null_throws, java.util.NoSuchElementException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptySortedSetParallelTest::maxBy_null_throws, java.util.NoSuchElementException.class);
        }
    }
}
