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

import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableFloatArrayListTest extends AbstractImmutableFloatListTestCase {

    @Override
    protected ImmutableFloatList classUnderTest() {
        return ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), ImmutableFloatArrayList.newList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty() {
        ImmutableFloatArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single() {
        ImmutableFloatArrayList.newListWith(42.0f);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, FloatLists.immutable.ofAll(ImmutableFloatArrayList.newList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f))));
    }

    @Test
    public void dotProduct() {
        ImmutableFloatArrayList list1 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatArrayList list2 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableFloatArrayList list1 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        ImmutableFloatArrayList list2 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch() {
        ImmutableFloatArrayList list = ImmutableFloatArrayList.newListWith(2.0f, 3.0f, 5.0f, 6.0f, 9.0f);
        Assert.assertEquals(-1, list.binarySearch(1.0f));
        Assert.assertEquals(0, list.binarySearch(2.0f));
        Assert.assertEquals(1, list.binarySearch(3.0f));
        Assert.assertEquals(-3, list.binarySearch(4.0f));
        Assert.assertEquals(2, list.binarySearch(5.0f));
        Assert.assertEquals(3, list.binarySearch(6.0f));
        Assert.assertEquals(-5, list.binarySearch(7.0f));
        Assert.assertEquals(-5, list.binarySearch(8.0f));
        Assert.assertEquals(4, list.binarySearch(9.0f));
        Assert.assertEquals(-6, list.binarySearch(10.0f));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableFloatArrayListTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_zipFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableFloatArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> zipFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newCollection_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> newCollection_throws_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableFloatArrayListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableFloatArrayListTest::newCollectionWith;
            this.payloads.isEmpty = ImmutableFloatArrayListTest::isEmpty;
            this.payloads.notEmpty = ImmutableFloatArrayListTest::notEmpty;
            this.payloads.tap = ImmutableFloatArrayListTest::tap;
            this.payloads.contains = ImmutableFloatArrayListTest::contains;
            this.payloads.contains_NaN = ImmutableFloatArrayListTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = ImmutableFloatArrayListTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = ImmutableFloatArrayListTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = ImmutableFloatArrayListTest::contains_zero;
            this.payloads.testEquals_NaN = ImmutableFloatArrayListTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = ImmutableFloatArrayListTest::contains_different_NaNs;
            this.payloads.containsAllArray = ImmutableFloatArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableFloatArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableFloatArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableFloatArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableFloatArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableFloatArrayListTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableFloatArrayListTest::forEach;
            this.payloads.count = ImmutableFloatArrayListTest::count;
            this.payloads.anySatisfy = ImmutableFloatArrayListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableFloatArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableFloatArrayListTest::noneSatisfy;
            this.payloads.collect = ImmutableFloatArrayListTest::collect;
            this.payloads.collectWithTarget = ImmutableFloatArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableFloatArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableFloatArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableFloatArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableFloatArrayListTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableFloatArrayListTest::select;
            this.payloads.selectWithTarget = ImmutableFloatArrayListTest::selectWithTarget;
            this.payloads.reject = ImmutableFloatArrayListTest::reject;
            this.payloads.rejectWithTarget = ImmutableFloatArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableFloatArrayListTest::detectIfNone;
            this.payloads.max = ImmutableFloatArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableFloatArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableFloatArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableFloatArrayListTest::maxIfEmpty;
            this.payloads.sum = ImmutableFloatArrayListTest::sum;
            this.payloads.summaryStatistics = ImmutableFloatArrayListTest::summaryStatistics;
            this.payloads.sumConsistentRounding = ImmutableFloatArrayListTest::sumConsistentRounding;
            this.payloads.average = ImmutableFloatArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableFloatArrayListTest::averageIfEmpty;
            this.payloads.median = ImmutableFloatArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableFloatArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ImmutableFloatArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableFloatArrayListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableFloatArrayListTest::testHashCode;
            this.payloads.toSortedList = ImmutableFloatArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableFloatArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableFloatArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableFloatArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableFloatArrayListTest::toSet;
            this.payloads.toBag = ImmutableFloatArrayListTest::toBag;
            this.payloads.asLazy = ImmutableFloatArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableFloatArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableFloatArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableFloatArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableFloatArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableFloatArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableFloatArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableFloatArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableFloatArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableFloatArrayListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableFloatArrayListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableFloatArrayListTest::chunk;
            this.payloads.testNewWith = ImmutableFloatArrayListTest::testNewWith;
            this.payloads.newWithAll = ImmutableFloatArrayListTest::newWithAll;
            this.payloads.newWithout = ImmutableFloatArrayListTest::newWithout;
            this.payloads.newWithoutAll = ImmutableFloatArrayListTest::newWithoutAll;
            this.payloads.get = ImmutableFloatArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ImmutableFloatArrayListTest::getFirst;
            this.payloads.getLast = ImmutableFloatArrayListTest::getLast;
            this.payloads.indexOf = ImmutableFloatArrayListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableFloatArrayListTest::lastIndexOf;
            this.payloads.floatIterator = ImmutableFloatArrayListTest::floatIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableFloatArrayListTest::toArray;
            this.payloads.injectInto = ImmutableFloatArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableFloatArrayListTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = ImmutableFloatArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableFloatArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableFloatArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableFloatArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableFloatArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableFloatArrayListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableFloatArrayListTest::distinct;
            this.payloads.toReversed = ImmutableFloatArrayListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableFloatArrayListTest::forEachWithIndex;
            this.payloads.testEquals = ImmutableFloatArrayListTest::testEquals;
            this.payloads.testToString = ImmutableFloatArrayListTest::testToString;
            this.payloads.makeString = ImmutableFloatArrayListTest::makeString;
            this.payloads.appendString = ImmutableFloatArrayListTest::appendString;
            this.payloads.toList = ImmutableFloatArrayListTest::toList;
            this.payloads.zipFloat = ImmutableFloatArrayListTest::zipFloat;
            this.payloads.zip = ImmutableFloatArrayListTest::zip;
            this.payloads.newCollection = ImmutableFloatArrayListTest::newCollection;
            this.payloads.newCollection_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::newCollection_throws_empty, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection_throws_single = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::newCollection_throws_single, java.lang.IllegalArgumentException.class);
            this.payloads.size = ImmutableFloatArrayListTest::size;
            this.payloads.dotProduct = ImmutableFloatArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableFloatArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.binarySearch = ImmutableFloatArrayListTest::binarySearch;
        }
    }
}
