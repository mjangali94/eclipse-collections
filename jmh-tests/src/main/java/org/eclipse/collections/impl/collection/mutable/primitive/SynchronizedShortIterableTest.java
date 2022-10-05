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
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedShortIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedShortIterableTest extends AbstractShortIterableTestCase {

    @Override
    protected ShortIterable classUnderTest() {
        return SynchronizedShortIterable.of(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected ShortIterable newWith(short... elements) {
        return SynchronizedShortIterable.of(ShortArrayList.newListWith(elements));
    }

    @Override
    protected ShortIterable newMutableCollectionWith(short... elements) {
        return ShortArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Short> newObjectCollectionWith(Short... elements) {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws() {
        SynchronizedShortIterable.of(null);
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2, (short) 3);
        ShortArrayList list = ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3);
        ShortIterator iterator = iterable.shortIterator();
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

        private SynchronizedShortIterableTest instance;

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
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedShortIterableTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> null_iterable_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedShortIterableTest> testEquals;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedShortIterableTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedShortIterableTest::newCollection;
            this.payloads.isEmpty = SynchronizedShortIterableTest::isEmpty;
            this.payloads.notEmpty = SynchronizedShortIterableTest::notEmpty;
            this.payloads.tap = SynchronizedShortIterableTest::tap;
            this.payloads.contains = SynchronizedShortIterableTest::contains;
            this.payloads.containsAllArray = SynchronizedShortIterableTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedShortIterableTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedShortIterableTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedShortIterableTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedShortIterableTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedShortIterableTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedShortIterableTest::forEach;
            this.payloads.size = SynchronizedShortIterableTest::size;
            this.payloads.count = SynchronizedShortIterableTest::count;
            this.payloads.anySatisfy = SynchronizedShortIterableTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedShortIterableTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedShortIterableTest::noneSatisfy;
            this.payloads.collect = SynchronizedShortIterableTest::collect;
            this.payloads.collectWithTarget = SynchronizedShortIterableTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedShortIterableTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedShortIterableTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedShortIterableTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedShortIterableTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedShortIterableTest::select;
            this.payloads.selectWithTarget = SynchronizedShortIterableTest::selectWithTarget;
            this.payloads.reject = SynchronizedShortIterableTest::reject;
            this.payloads.rejectWithTarget = SynchronizedShortIterableTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedShortIterableTest::detectIfNone;
            this.payloads.max = SynchronizedShortIterableTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedShortIterableTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedShortIterableTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedShortIterableTest::maxIfEmpty;
            this.payloads.sum = SynchronizedShortIterableTest::sum;
            this.payloads.summaryStatistics = SynchronizedShortIterableTest::summaryStatistics;
            this.payloads.average = SynchronizedShortIterableTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedShortIterableTest::averageIfEmpty;
            this.payloads.median = SynchronizedShortIterableTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedShortIterableTest::medianIfEmpty;
            this.payloads.toArray = SynchronizedShortIterableTest::toArray;
            this.payloads.toArrayWithTargetArray = SynchronizedShortIterableTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedShortIterableTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedShortIterableTest::testHashCode;
            this.payloads.testToString = SynchronizedShortIterableTest::testToString;
            this.payloads.makeString = SynchronizedShortIterableTest::makeString;
            this.payloads.appendString = SynchronizedShortIterableTest::appendString;
            this.payloads.toList = SynchronizedShortIterableTest::toList;
            this.payloads.toSortedList = SynchronizedShortIterableTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedShortIterableTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedShortIterableTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedShortIterableTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedShortIterableTest::toSet;
            this.payloads.toBag = SynchronizedShortIterableTest::toBag;
            this.payloads.asLazy = SynchronizedShortIterableTest::asLazy;
            this.payloads.injectInto = SynchronizedShortIterableTest::injectInto;
            this.payloads.injectIntoBoolean = SynchronizedShortIterableTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedShortIterableTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedShortIterableTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedShortIterableTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedShortIterableTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedShortIterableTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedShortIterableTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedShortIterableTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedShortIterableTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedShortIterableTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedShortIterableTest::chunk;
            this.payloads.null_iterable_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedShortIterableTest::null_iterable_throws, java.lang.IllegalArgumentException.class);
            this.payloads.shortIterator = SynchronizedShortIterableTest::shortIterator;
            this.payloads.testEquals = SynchronizedShortIterableTest::testEquals;
        }
    }
}
