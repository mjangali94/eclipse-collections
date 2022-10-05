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

import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableByteArrayListTest extends AbstractImmutableByteListTestCase {

    @Override
    protected ImmutableByteList classUnderTest() {
        return ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ImmutableByteArrayList.newList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty() {
        ImmutableByteArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single() {
        ImmutableByteArrayList.newListWith((byte) 42);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(3, ByteLists.immutable.ofAll(ImmutableByteArrayList.newList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3))));
    }

    @Test
    public void dotProduct() {
        ImmutableByteArrayList list1 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteArrayList list2 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableByteArrayList list1 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteArrayList list2 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch() {
        ImmutableByteArrayList list = ImmutableByteArrayList.newListWith((byte) 2, (byte) 3, (byte) 5, (byte) 6, (byte) 9);
        Assert.assertEquals(-1, list.binarySearch((byte) 1));
        Assert.assertEquals(0, list.binarySearch((byte) 2));
        Assert.assertEquals(1, list.binarySearch((byte) 3));
        Assert.assertEquals(-3, list.binarySearch((byte) 4));
        Assert.assertEquals(2, list.binarySearch((byte) 5));
        Assert.assertEquals(3, list.binarySearch((byte) 6));
        Assert.assertEquals(-5, list.binarySearch((byte) 7));
        Assert.assertEquals(-5, list.binarySearch((byte) 8));
        Assert.assertEquals(4, list.binarySearch((byte) 9));
        Assert.assertEquals(-6, list.binarySearch((byte) 10));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableByteArrayListTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipByte);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableByteArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> zipByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newCollection_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> newCollection_throws_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableByteArrayListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableByteArrayListTest::newCollectionWith;
            this.payloads.isEmpty = ImmutableByteArrayListTest::isEmpty;
            this.payloads.notEmpty = ImmutableByteArrayListTest::notEmpty;
            this.payloads.tap = ImmutableByteArrayListTest::tap;
            this.payloads.contains = ImmutableByteArrayListTest::contains;
            this.payloads.containsAllArray = ImmutableByteArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableByteArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableByteArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableByteArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableByteArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableByteArrayListTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableByteArrayListTest::forEach;
            this.payloads.count = ImmutableByteArrayListTest::count;
            this.payloads.anySatisfy = ImmutableByteArrayListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableByteArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableByteArrayListTest::noneSatisfy;
            this.payloads.collect = ImmutableByteArrayListTest::collect;
            this.payloads.collectWithTarget = ImmutableByteArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableByteArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableByteArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableByteArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableByteArrayListTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableByteArrayListTest::select;
            this.payloads.selectWithTarget = ImmutableByteArrayListTest::selectWithTarget;
            this.payloads.reject = ImmutableByteArrayListTest::reject;
            this.payloads.rejectWithTarget = ImmutableByteArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableByteArrayListTest::detectIfNone;
            this.payloads.max = ImmutableByteArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableByteArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableByteArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableByteArrayListTest::maxIfEmpty;
            this.payloads.sum = ImmutableByteArrayListTest::sum;
            this.payloads.summaryStatistics = ImmutableByteArrayListTest::summaryStatistics;
            this.payloads.average = ImmutableByteArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableByteArrayListTest::averageIfEmpty;
            this.payloads.median = ImmutableByteArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableByteArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ImmutableByteArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableByteArrayListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableByteArrayListTest::testHashCode;
            this.payloads.toSortedList = ImmutableByteArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableByteArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableByteArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableByteArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableByteArrayListTest::toSet;
            this.payloads.toBag = ImmutableByteArrayListTest::toBag;
            this.payloads.asLazy = ImmutableByteArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableByteArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableByteArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableByteArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableByteArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableByteArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableByteArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableByteArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableByteArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableByteArrayListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableByteArrayListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableByteArrayListTest::chunk;
            this.payloads.testNewWith = ImmutableByteArrayListTest::testNewWith;
            this.payloads.newWithAll = ImmutableByteArrayListTest::newWithAll;
            this.payloads.newWithout = ImmutableByteArrayListTest::newWithout;
            this.payloads.newWithoutAll = ImmutableByteArrayListTest::newWithoutAll;
            this.payloads.get = ImmutableByteArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ImmutableByteArrayListTest::getFirst;
            this.payloads.getLast = ImmutableByteArrayListTest::getLast;
            this.payloads.indexOf = ImmutableByteArrayListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableByteArrayListTest::lastIndexOf;
            this.payloads.byteIterator = ImmutableByteArrayListTest::byteIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableByteArrayListTest::toArray;
            this.payloads.injectInto = ImmutableByteArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableByteArrayListTest::injectIntoWithIndex;
            this.payloads.selectWithIndex = ImmutableByteArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableByteArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableByteArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableByteArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableByteArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableByteArrayListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableByteArrayListTest::distinct;
            this.payloads.toReversed = ImmutableByteArrayListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableByteArrayListTest::forEachWithIndex;
            this.payloads.testEquals = ImmutableByteArrayListTest::testEquals;
            this.payloads.testToString = ImmutableByteArrayListTest::testToString;
            this.payloads.makeString = ImmutableByteArrayListTest::makeString;
            this.payloads.appendString = ImmutableByteArrayListTest::appendString;
            this.payloads.toList = ImmutableByteArrayListTest::toList;
            this.payloads.zipByte = ImmutableByteArrayListTest::zipByte;
            this.payloads.zip = ImmutableByteArrayListTest::zip;
            this.payloads.newCollection = ImmutableByteArrayListTest::newCollection;
            this.payloads.newCollection_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::newCollection_throws_empty, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection_throws_single = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::newCollection_throws_single, java.lang.IllegalArgumentException.class);
            this.payloads.size = ImmutableByteArrayListTest::size;
            this.payloads.dotProduct = ImmutableByteArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableByteArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.binarySearch = ImmutableByteArrayListTest::binarySearch;
        }
    }
}
