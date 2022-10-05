/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedLongIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedLongIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedLongIterableTest extends AbstractLongIterableTestCase {

    @Override
    protected LongIterable classUnderTest() {
        return SynchronizedLongIterable.of(LongArrayList.newListWith(1L, 2L, 3L));
    }

    @Override
    protected LongIterable newWith(long... elements) {
        return SynchronizedLongIterable.of(LongArrayList.newListWith(elements));
    }

    @Override
    protected LongIterable newMutableCollectionWith(long... elements) {
        return LongArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Long> newObjectCollectionWith(Long... elements) {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws() {
        SynchronizedLongIterable.of(null);
    }

    @Override
    @Test
    public void longIterator() {
        LongIterable iterable = this.newWith(0L, 1L, 2L, 3L);
        LongArrayList list = LongArrayList.newListWith(0L, 1L, 2L, 3L);
        LongIterator iterator = iterable.longIterator();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void testEquals() {
        // Testing equals() is not applicable.
    }

    @Override
    public void testHashCode() {
        // Testing hashCode() is not applicable.
    }

    @Override
    public void newCollection() {
        // Testing newCollection() is not applicable.
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedLongIterableTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_null_iterable_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.null_iterable_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedLongIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> null_iterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedLongIterableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedLongIterableTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedLongIterableTest::newCollection;
            this.payloads.isEmpty = SynchronizedLongIterableTest::isEmpty;
            this.payloads.notEmpty = SynchronizedLongIterableTest::notEmpty;
            this.payloads.tap = SynchronizedLongIterableTest::tap;
            this.payloads.contains = SynchronizedLongIterableTest::contains;
            this.payloads.containsAllArray = SynchronizedLongIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedLongIterableTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedLongIterableTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedLongIterableTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedLongIterableTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedLongIterableTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedLongIterableTest::forEach;
            this.payloads.size = SynchronizedLongIterableTest::size;
            this.payloads.count = SynchronizedLongIterableTest::count;
            this.payloads.anySatisfy = SynchronizedLongIterableTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedLongIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedLongIterableTest::noneSatisfy;
            this.payloads.collect = SynchronizedLongIterableTest::collect;
            this.payloads.collectWithTarget = SynchronizedLongIterableTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedLongIterableTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedLongIterableTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedLongIterableTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedLongIterableTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedLongIterableTest::select;
            this.payloads.selectWithTarget = SynchronizedLongIterableTest::selectWithTarget;
            this.payloads.reject = SynchronizedLongIterableTest::reject;
            this.payloads.rejectWithTarget = SynchronizedLongIterableTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedLongIterableTest::detectIfNone;
            this.payloads.max = SynchronizedLongIterableTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedLongIterableTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedLongIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedLongIterableTest::maxIfEmpty;
            this.payloads.sum = SynchronizedLongIterableTest::sum;
            this.payloads.summaryStatistics = SynchronizedLongIterableTest::summaryStatistics;
            this.payloads.average = SynchronizedLongIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedLongIterableTest::averageIfEmpty;
            this.payloads.median = SynchronizedLongIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedLongIterableTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedLongIterableTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedLongIterableTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedLongIterableTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedLongIterableTest::testHashCode;
            this.payloads.testToString = SynchronizedLongIterableTest::testToString;
            this.payloads.makeString = SynchronizedLongIterableTest::makeString;
            this.payloads.appendString = SynchronizedLongIterableTest::appendString;
            this.payloads.toList = SynchronizedLongIterableTest::toList;
            this.payloads.toSortedList = SynchronizedLongIterableTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedLongIterableTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedLongIterableTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedLongIterableTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedLongIterableTest::toSet;
            this.payloads.toBag = SynchronizedLongIterableTest::toBag;
            this.payloads.asLazy = SynchronizedLongIterableTest::asLazy;
            this.payloads.injectInto = SynchronizedLongIterableTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedLongIterableTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedLongIterableTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedLongIterableTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedLongIterableTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedLongIterableTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedLongIterableTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedLongIterableTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedLongIterableTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedLongIterableTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedLongIterableTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedLongIterableTest::chunk;
            this.payloads.null_iterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedLongIterableTest::null_iterable_throws, java.lang.IllegalArgumentException.class);
            this.payloads.longIterator = SynchronizedLongIterableTest::longIterator;
            this.payloads.testEquals = SynchronizedLongIterableTest::testEquals;
        }
    }
}
