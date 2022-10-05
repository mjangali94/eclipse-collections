/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableLongArrayListTest extends AbstractImmutableLongListTestCase {

    @Override
    protected ImmutableLongList classUnderTest() {
        return ImmutableLongArrayList.newListWith(1L, 2L, 3L);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), ImmutableLongArrayList.newList(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty() {
        ImmutableLongArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single() {
        ImmutableLongArrayList.newListWith(42L);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, LongLists.immutable.ofAll(ImmutableLongArrayList.newList(LongArrayList.newListWith(1L, 2L, 3L))));
    }

    @Test
    public void dotProduct() {
        ImmutableLongArrayList list1 = ImmutableLongArrayList.newListWith(1L, 2L, 3L);
        ImmutableLongArrayList list2 = ImmutableLongArrayList.newListWith(1L, 2L, 3L);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableLongArrayList list1 = ImmutableLongArrayList.newListWith(1L, 2L, 3L);
        ImmutableLongArrayList list2 = ImmutableLongArrayList.newListWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch() {
        ImmutableLongArrayList list = ImmutableLongArrayList.newListWith(2L, 3L, 5L, 6L, 9L);
        Assert.assertEquals(-1, list.binarySearch(1L));
        Assert.assertEquals(0, list.binarySearch(2L));
        Assert.assertEquals(1, list.binarySearch(3L));
        Assert.assertEquals(-3, list.binarySearch(4L));
        Assert.assertEquals(2, list.binarySearch(5L));
        Assert.assertEquals(3, list.binarySearch(6L));
        Assert.assertEquals(-5, list.binarySearch(7L));
        Assert.assertEquals(-5, list.binarySearch(8L));
        Assert.assertEquals(4, list.binarySearch(9L));
        Assert.assertEquals(-6, list.binarySearch(10L));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongArrayListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_zipLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection_throws_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection_throws_single);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct_throwsOnListsOfDifferentSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> zipLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newCollection_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> newCollection_throws_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongArrayListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableLongArrayListTest::newCollectionWith;
            this.payloads.isEmpty = ImmutableLongArrayListTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongArrayListTest::notEmpty;
            this.payloads.tap = ImmutableLongArrayListTest::tap;
            this.payloads.contains = ImmutableLongArrayListTest::contains;
            this.payloads.containsAllArray = ImmutableLongArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableLongArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableLongArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableLongArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableLongArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableLongArrayListTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableLongArrayListTest::forEach;
            this.payloads.count = ImmutableLongArrayListTest::count;
            this.payloads.anySatisfy = ImmutableLongArrayListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableLongArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableLongArrayListTest::noneSatisfy;
            this.payloads.collect = ImmutableLongArrayListTest::collect;
            this.payloads.collectWithTarget = ImmutableLongArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableLongArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableLongArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableLongArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableLongArrayListTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableLongArrayListTest::select;
            this.payloads.selectWithTarget = ImmutableLongArrayListTest::selectWithTarget;
            this.payloads.reject = ImmutableLongArrayListTest::reject;
            this.payloads.rejectWithTarget = ImmutableLongArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableLongArrayListTest::detectIfNone;
            this.payloads.max = ImmutableLongArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableLongArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableLongArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableLongArrayListTest::maxIfEmpty;
            this.payloads.sum = ImmutableLongArrayListTest::sum;
            this.payloads.summaryStatistics = ImmutableLongArrayListTest::summaryStatistics;
            this.payloads.average = ImmutableLongArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableLongArrayListTest::averageIfEmpty;
            this.payloads.median = ImmutableLongArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableLongArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ImmutableLongArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableLongArrayListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableLongArrayListTest::testHashCode;
            this.payloads.toSortedList = ImmutableLongArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableLongArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableLongArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableLongArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableLongArrayListTest::toSet;
            this.payloads.toBag = ImmutableLongArrayListTest::toBag;
            this.payloads.asLazy = ImmutableLongArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableLongArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableLongArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableLongArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableLongArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableLongArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableLongArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableLongArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableLongArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableLongArrayListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableLongArrayListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableLongArrayListTest::chunk;
            this.payloads.testNewWith = ImmutableLongArrayListTest::testNewWith;
            this.payloads.newWithAll = ImmutableLongArrayListTest::newWithAll;
            this.payloads.newWithout = ImmutableLongArrayListTest::newWithout;
            this.payloads.newWithoutAll = ImmutableLongArrayListTest::newWithoutAll;
            this.payloads.get = ImmutableLongArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ImmutableLongArrayListTest::getFirst;
            this.payloads.getLast = ImmutableLongArrayListTest::getLast;
            this.payloads.indexOf = ImmutableLongArrayListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableLongArrayListTest::lastIndexOf;
            this.payloads.longIterator = ImmutableLongArrayListTest::longIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableLongArrayListTest::toArray;
            this.payloads.injectInto = ImmutableLongArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableLongArrayListTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = ImmutableLongArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableLongArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableLongArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableLongArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableLongArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableLongArrayListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableLongArrayListTest::distinct;
            this.payloads.toReversed = ImmutableLongArrayListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableLongArrayListTest::forEachWithIndex;
            this.payloads.testEquals = ImmutableLongArrayListTest::testEquals;
            this.payloads.testToString = ImmutableLongArrayListTest::testToString;
            this.payloads.makeString = ImmutableLongArrayListTest::makeString;
            this.payloads.appendString = ImmutableLongArrayListTest::appendString;
            this.payloads.toList = ImmutableLongArrayListTest::toList;
            this.payloads.zipLong = ImmutableLongArrayListTest::zipLong;
            this.payloads.zip = ImmutableLongArrayListTest::zip;
            this.payloads.stream = ImmutableLongArrayListTest::stream;
            this.payloads.parallelStream = ImmutableLongArrayListTest::parallelStream;
            this.payloads.newCollection = ImmutableLongArrayListTest::newCollection;
            this.payloads.newCollection_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::newCollection_throws_empty, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection_throws_single = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::newCollection_throws_single, java.lang.IllegalArgumentException.class);
            this.payloads.size = ImmutableLongArrayListTest::size;
            this.payloads.dotProduct = ImmutableLongArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.binarySearch = ImmutableLongArrayListTest::binarySearch;
        }
    }
}
