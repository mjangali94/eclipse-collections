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

import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableShortArrayListTest extends AbstractImmutableShortListTestCase {

    @Override
    protected ImmutableShortList classUnderTest() {
        return ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ImmutableShortArrayList.newList(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty() {
        ImmutableShortArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single() {
        ImmutableShortArrayList.newListWith((short) 42);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, ShortLists.immutable.ofAll(ImmutableShortArrayList.newList(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3))));
    }

    @Test
    public void dotProduct() {
        ImmutableShortArrayList list1 = ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ImmutableShortArrayList list2 = ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableShortArrayList list1 = ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ImmutableShortArrayList list2 = ImmutableShortArrayList.newListWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch() {
        ImmutableShortArrayList list = ImmutableShortArrayList.newListWith((short) 2, (short) 3, (short) 5, (short) 6, (short) 9);
        Assert.assertEquals(-1, list.binarySearch((short) 1));
        Assert.assertEquals(0, list.binarySearch((short) 2));
        Assert.assertEquals(1, list.binarySearch((short) 3));
        Assert.assertEquals(-3, list.binarySearch((short) 4));
        Assert.assertEquals(2, list.binarySearch((short) 5));
        Assert.assertEquals(3, list.binarySearch((short) 6));
        Assert.assertEquals(-5, list.binarySearch((short) 7));
        Assert.assertEquals(-5, list.binarySearch((short) 8));
        Assert.assertEquals(4, list.binarySearch((short) 9));
        Assert.assertEquals(-6, list.binarySearch((short) 10));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortArrayListTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithout() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithout);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection_throws_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection_throws_single);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct_throwsOnListsOfDifferentSizes);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> zipShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newCollection_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> newCollection_throws_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortArrayListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableShortArrayListTest::newCollectionWith;
            this.payloads.isEmpty = ImmutableShortArrayListTest::isEmpty;
            this.payloads.notEmpty = ImmutableShortArrayListTest::notEmpty;
            this.payloads.tap = ImmutableShortArrayListTest::tap;
            this.payloads.contains = ImmutableShortArrayListTest::contains;
            this.payloads.containsAllArray = ImmutableShortArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableShortArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableShortArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableShortArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableShortArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableShortArrayListTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableShortArrayListTest::forEach;
            this.payloads.count = ImmutableShortArrayListTest::count;
            this.payloads.anySatisfy = ImmutableShortArrayListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableShortArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableShortArrayListTest::noneSatisfy;
            this.payloads.collect = ImmutableShortArrayListTest::collect;
            this.payloads.collectWithTarget = ImmutableShortArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableShortArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableShortArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableShortArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableShortArrayListTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableShortArrayListTest::select;
            this.payloads.selectWithTarget = ImmutableShortArrayListTest::selectWithTarget;
            this.payloads.reject = ImmutableShortArrayListTest::reject;
            this.payloads.rejectWithTarget = ImmutableShortArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableShortArrayListTest::detectIfNone;
            this.payloads.max = ImmutableShortArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableShortArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableShortArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableShortArrayListTest::maxIfEmpty;
            this.payloads.sum = ImmutableShortArrayListTest::sum;
            this.payloads.summaryStatistics = ImmutableShortArrayListTest::summaryStatistics;
            this.payloads.average = ImmutableShortArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableShortArrayListTest::averageIfEmpty;
            this.payloads.median = ImmutableShortArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableShortArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ImmutableShortArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableShortArrayListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableShortArrayListTest::testHashCode;
            this.payloads.toSortedList = ImmutableShortArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableShortArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableShortArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableShortArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableShortArrayListTest::toSet;
            this.payloads.toBag = ImmutableShortArrayListTest::toBag;
            this.payloads.asLazy = ImmutableShortArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableShortArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableShortArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableShortArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableShortArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableShortArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableShortArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableShortArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableShortArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableShortArrayListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableShortArrayListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableShortArrayListTest::chunk;
            this.payloads.testNewWith = ImmutableShortArrayListTest::testNewWith;
            this.payloads.newWithAll = ImmutableShortArrayListTest::newWithAll;
            this.payloads.newWithout = ImmutableShortArrayListTest::newWithout;
            this.payloads.newWithoutAll = ImmutableShortArrayListTest::newWithoutAll;
            this.payloads.get = ImmutableShortArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ImmutableShortArrayListTest::getFirst;
            this.payloads.getLast = ImmutableShortArrayListTest::getLast;
            this.payloads.indexOf = ImmutableShortArrayListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableShortArrayListTest::lastIndexOf;
            this.payloads.shortIterator = ImmutableShortArrayListTest::shortIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableShortArrayListTest::toArray;
            this.payloads.injectInto = ImmutableShortArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableShortArrayListTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = ImmutableShortArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableShortArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableShortArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableShortArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableShortArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableShortArrayListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableShortArrayListTest::distinct;
            this.payloads.toReversed = ImmutableShortArrayListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableShortArrayListTest::forEachWithIndex;
            this.payloads.testEquals = ImmutableShortArrayListTest::testEquals;
            this.payloads.testToString = ImmutableShortArrayListTest::testToString;
            this.payloads.makeString = ImmutableShortArrayListTest::makeString;
            this.payloads.appendString = ImmutableShortArrayListTest::appendString;
            this.payloads.toList = ImmutableShortArrayListTest::toList;
            this.payloads.zipShort = ImmutableShortArrayListTest::zipShort;
            this.payloads.zip = ImmutableShortArrayListTest::zip;
            this.payloads.newCollection = ImmutableShortArrayListTest::newCollection;
            this.payloads.newCollection_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::newCollection_throws_empty, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection_throws_single = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::newCollection_throws_single, java.lang.IllegalArgumentException.class);
            this.payloads.size = ImmutableShortArrayListTest::size;
            this.payloads.dotProduct = ImmutableShortArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.binarySearch = ImmutableShortArrayListTest::binarySearch;
        }
    }
}
