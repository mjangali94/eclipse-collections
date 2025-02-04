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
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableLongSingletonListTest extends AbstractImmutableLongListTestCase {

    @Override
    protected ImmutableLongList classUnderTest() {
        return LongLists.immutable.of(1L);
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        Assert.assertNotEquals(this.newWith(1L), this.newWith());
    }

    @Test
    public void dotProduct() {
        ImmutableLongSingletonList list1 = new ImmutableLongSingletonList(3L);
        ImmutableLongSingletonList list2 = new ImmutableLongSingletonList(3L);
        Assert.assertEquals(9L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ImmutableLongArrayList list = ImmutableLongArrayList.newListWith(1L, 2L);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ImmutableLongSingletonList iterable = new ImmutableLongSingletonList(1L);
        MutableLong result = iterable.injectInto(new MutableLong(1L), MutableLong::add);
        Assert.assertEquals(new MutableLong(2L), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex() {
        ImmutableLongList list1 = this.newWith(1L);
        ImmutableLongList list2 = this.newWith(1L, 2L, 3L);
        MutableLong result = list1.injectIntoWithIndex(new MutableLong(0L), (MutableLong object, long value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableLong(1L), result);
    }

    @Override
    @Test
    public void toReversed() {
        Assert.assertEquals(LongLists.immutable.of(1L), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((long each, int index) -> sum[0] += each + index);
        Assert.assertEquals(1, sum[0], 0L);
    }

    @Test
    public void binarySearch() {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0L));
        Assert.assertEquals(0, this.classUnderTest().binarySearch(1L));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch(5L));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableLongSingletonListTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_zipLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
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
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableLongSingletonListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> zipLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableLongSingletonListTest> binarySearch;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ImmutableLongSingletonListTest::newCollectionWith;
            this.payloads.newCollection = ImmutableLongSingletonListTest::newCollection;
            this.payloads.isEmpty = ImmutableLongSingletonListTest::isEmpty;
            this.payloads.notEmpty = ImmutableLongSingletonListTest::notEmpty;
            this.payloads.tap = ImmutableLongSingletonListTest::tap;
            this.payloads.contains = ImmutableLongSingletonListTest::contains;
            this.payloads.containsAllArray = ImmutableLongSingletonListTest::containsAllArray;
            this.payloads.containsAllIterable = ImmutableLongSingletonListTest::containsAllIterable;
            this.payloads.containsAnyArray = ImmutableLongSingletonListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ImmutableLongSingletonListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ImmutableLongSingletonListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ImmutableLongSingletonListTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.forEach = ImmutableLongSingletonListTest::forEach;
            this.payloads.size = ImmutableLongSingletonListTest::size;
            this.payloads.count = ImmutableLongSingletonListTest::count;
            this.payloads.anySatisfy = ImmutableLongSingletonListTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableLongSingletonListTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableLongSingletonListTest::noneSatisfy;
            this.payloads.collect = ImmutableLongSingletonListTest::collect;
            this.payloads.collectWithTarget = ImmutableLongSingletonListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ImmutableLongSingletonListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ImmutableLongSingletonListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ImmutableLongSingletonListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ImmutableLongSingletonListTest::collectPrimitivesToSets;
            this.payloads.select = ImmutableLongSingletonListTest::select;
            this.payloads.selectWithTarget = ImmutableLongSingletonListTest::selectWithTarget;
            this.payloads.reject = ImmutableLongSingletonListTest::reject;
            this.payloads.rejectWithTarget = ImmutableLongSingletonListTest::rejectWithTarget;
            this.payloads.detectIfNone = ImmutableLongSingletonListTest::detectIfNone;
            this.payloads.max = ImmutableLongSingletonListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableLongSingletonListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableLongSingletonListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableLongSingletonListTest::maxIfEmpty;
            this.payloads.sum = ImmutableLongSingletonListTest::sum;
            this.payloads.summaryStatistics = ImmutableLongSingletonListTest::summaryStatistics;
            this.payloads.average = ImmutableLongSingletonListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ImmutableLongSingletonListTest::averageIfEmpty;
            this.payloads.median = ImmutableLongSingletonListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ImmutableLongSingletonListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ImmutableLongSingletonListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ImmutableLongSingletonListTest::toSortedArray;
            this.payloads.testHashCode = ImmutableLongSingletonListTest::testHashCode;
            this.payloads.toSortedList = ImmutableLongSingletonListTest::toSortedList;
            this.payloads.toSortedListByComparator = ImmutableLongSingletonListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ImmutableLongSingletonListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ImmutableLongSingletonListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ImmutableLongSingletonListTest::toSet;
            this.payloads.toBag = ImmutableLongSingletonListTest::toBag;
            this.payloads.asLazy = ImmutableLongSingletonListTest::asLazy;
            this.payloads.injectIntoBoolean = ImmutableLongSingletonListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ImmutableLongSingletonListTest::injectIntoByte;
            this.payloads.injectIntoChar = ImmutableLongSingletonListTest::injectIntoChar;
            this.payloads.injectIntoShort = ImmutableLongSingletonListTest::injectIntoShort;
            this.payloads.injectIntoInt = ImmutableLongSingletonListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ImmutableLongSingletonListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ImmutableLongSingletonListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ImmutableLongSingletonListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ImmutableLongSingletonListTest::reduce;
            this.payloads.reduceIfEmpty = ImmutableLongSingletonListTest::reduceIfEmpty;
            this.payloads.chunk = ImmutableLongSingletonListTest::chunk;
            this.payloads.testNewWith = ImmutableLongSingletonListTest::testNewWith;
            this.payloads.newWithAll = ImmutableLongSingletonListTest::newWithAll;
            this.payloads.newWithout = ImmutableLongSingletonListTest::newWithout;
            this.payloads.newWithoutAll = ImmutableLongSingletonListTest::newWithoutAll;
            this.payloads.get = ImmutableLongSingletonListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ImmutableLongSingletonListTest::getFirst;
            this.payloads.getLast = ImmutableLongSingletonListTest::getLast;
            this.payloads.indexOf = ImmutableLongSingletonListTest::indexOf;
            this.payloads.lastIndexOf = ImmutableLongSingletonListTest::lastIndexOf;
            this.payloads.longIterator = ImmutableLongSingletonListTest::longIterator;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.toArray = ImmutableLongSingletonListTest::toArray;
            this.payloads.selectWithIndex = ImmutableLongSingletonListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ImmutableLongSingletonListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ImmutableLongSingletonListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ImmutableLongSingletonListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ImmutableLongSingletonListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ImmutableLongSingletonListTest::collectWithIndexWithTarget;
            this.payloads.distinct = ImmutableLongSingletonListTest::distinct;
            this.payloads.testToString = ImmutableLongSingletonListTest::testToString;
            this.payloads.makeString = ImmutableLongSingletonListTest::makeString;
            this.payloads.appendString = ImmutableLongSingletonListTest::appendString;
            this.payloads.toList = ImmutableLongSingletonListTest::toList;
            this.payloads.zipLong = ImmutableLongSingletonListTest::zipLong;
            this.payloads.zip = ImmutableLongSingletonListTest::zip;
            this.payloads.stream = ImmutableLongSingletonListTest::stream;
            this.payloads.parallelStream = ImmutableLongSingletonListTest::parallelStream;
            this.payloads.testEquals = ImmutableLongSingletonListTest::testEquals;
            this.payloads.dotProduct = ImmutableLongSingletonListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableLongSingletonListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.injectInto = ImmutableLongSingletonListTest::injectInto;
            this.payloads.injectIntoWithIndex = ImmutableLongSingletonListTest::injectIntoWithIndex;
            this.payloads.toReversed = ImmutableLongSingletonListTest::toReversed;
            this.payloads.forEachWithIndex = ImmutableLongSingletonListTest::forEachWithIndex;
            this.payloads.binarySearch = ImmutableLongSingletonListTest::binarySearch;
        }
    }
}
