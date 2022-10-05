/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedDoubleList}.
 * This file was automatically generated from template file synchronizedPrimitiveListTest.stg.
 */
public class SynchronizedDoubleListTest extends AbstractDoubleListTestCase {

    @Override
    protected SynchronizedDoubleList classUnderTest() {
        return new SynchronizedDoubleList(DoubleArrayList.newListWith(1.0, 2.0, 3.0));
    }

    @Override
    protected SynchronizedDoubleList newWith(double... elements) {
        return new SynchronizedDoubleList(DoubleArrayList.newListWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedDoubleList list = this.classUnderTest();
        MutableDoubleList listWithLockObject = new SynchronizedDoubleList(DoubleArrayList.newListWith(1.0, 2.0, 3.0), new Object());
        Assert.assertEquals(list, listWithLockObject);
        Assert.assertSame(listWithLockObject, listWithLockObject.asSynchronized());
        Assert.assertSame(list, list.asSynchronized());
        Assert.assertEquals(list, list.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedDoubleListTest instance;

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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast_emptyList_throws);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_swap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.swap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithPrimitiveComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithPrimitiveComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithOddEvenComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithOddEvenComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorNaturalComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithKeyExtractorNaturalComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorUnnaturalComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithKeyExtractorUnnaturalComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInputWithDupes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortShuffledInputWithDupes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortShuffledInput);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortSortedInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortSortedInput);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortReversedSortedInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortReversedSortedInput);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shuffleThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shuffleThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
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
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_zipDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipDouble);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedDoubleListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> zipDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedDoubleListTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedDoubleListTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedDoubleListTest::newCollection;
            this.payloads.isEmpty = SynchronizedDoubleListTest::isEmpty;
            this.payloads.notEmpty = SynchronizedDoubleListTest::notEmpty;
            this.payloads.tap = SynchronizedDoubleListTest::tap;
            this.payloads.contains_NaN = SynchronizedDoubleListTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedDoubleListTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedDoubleListTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedDoubleListTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedDoubleListTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedDoubleListTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedDoubleListTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedDoubleListTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedDoubleListTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedDoubleListTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedDoubleListTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedDoubleListTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedDoubleListTest::forEach;
            this.payloads.size = SynchronizedDoubleListTest::size;
            this.payloads.count = SynchronizedDoubleListTest::count;
            this.payloads.anySatisfy = SynchronizedDoubleListTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedDoubleListTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedDoubleListTest::noneSatisfy;
            this.payloads.collect = SynchronizedDoubleListTest::collect;
            this.payloads.collectWithTarget = SynchronizedDoubleListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedDoubleListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedDoubleListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedDoubleListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedDoubleListTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedDoubleListTest::select;
            this.payloads.selectWithTarget = SynchronizedDoubleListTest::selectWithTarget;
            this.payloads.reject = SynchronizedDoubleListTest::reject;
            this.payloads.rejectWithTarget = SynchronizedDoubleListTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedDoubleListTest::detectIfNone;
            this.payloads.max = SynchronizedDoubleListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedDoubleListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedDoubleListTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedDoubleListTest::maxIfEmpty;
            this.payloads.sum = SynchronizedDoubleListTest::sum;
            this.payloads.summaryStatistics = SynchronizedDoubleListTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedDoubleListTest::sumConsistentRounding;
            this.payloads.average = SynchronizedDoubleListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedDoubleListTest::averageIfEmpty;
            this.payloads.median = SynchronizedDoubleListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedDoubleListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = SynchronizedDoubleListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedDoubleListTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedDoubleListTest::testHashCode;
            this.payloads.toSortedList = SynchronizedDoubleListTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedDoubleListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedDoubleListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedDoubleListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedDoubleListTest::toSet;
            this.payloads.toBag = SynchronizedDoubleListTest::toBag;
            this.payloads.asLazy = SynchronizedDoubleListTest::asLazy;
            this.payloads.injectIntoBoolean = SynchronizedDoubleListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedDoubleListTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedDoubleListTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedDoubleListTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedDoubleListTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedDoubleListTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedDoubleListTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedDoubleListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedDoubleListTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedDoubleListTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedDoubleListTest::chunk;
            this.payloads.clear = SynchronizedDoubleListTest::clear;
            this.payloads.contains = SynchronizedDoubleListTest::contains;
            this.payloads.add = SynchronizedDoubleListTest::add;
            this.payloads.remove = SynchronizedDoubleListTest::remove;
            this.payloads.removeIf = SynchronizedDoubleListTest::removeIf;
            this.payloads.removeAll = SynchronizedDoubleListTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedDoubleListTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedDoubleListTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedDoubleListTest::retainAll_iterable;
            this.payloads.with = SynchronizedDoubleListTest::with;
            this.payloads.withAll = SynchronizedDoubleListTest::withAll;
            this.payloads.without = SynchronizedDoubleListTest::without;
            this.payloads.withoutAll = SynchronizedDoubleListTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedDoubleListTest::asUnmodifiable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = SynchronizedDoubleListTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = SynchronizedDoubleListTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = SynchronizedDoubleListTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedDoubleListTest::newEmpty;
            this.payloads.get = SynchronizedDoubleListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = SynchronizedDoubleListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = SynchronizedDoubleListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = SynchronizedDoubleListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = SynchronizedDoubleListTest::indexOf;
            this.payloads.lastIndexOf = SynchronizedDoubleListTest::lastIndexOf;
            this.payloads.addAtIndex = SynchronizedDoubleListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = SynchronizedDoubleListTest::addAllArray;
            this.payloads.addAllIterable = SynchronizedDoubleListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = SynchronizedDoubleListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = SynchronizedDoubleListTest::set;
            this.payloads.swap = SynchronizedDoubleListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedDoubleListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.doubleIterator = SynchronizedDoubleListTest::doubleIterator;
            this.payloads.toArray = SynchronizedDoubleListTest::toArray;
            this.payloads.reverseThis = SynchronizedDoubleListTest::reverseThis;
            this.payloads.sortThis = SynchronizedDoubleListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = SynchronizedDoubleListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = SynchronizedDoubleListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = SynchronizedDoubleListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = SynchronizedDoubleListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = SynchronizedDoubleListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = SynchronizedDoubleListTest::sortShuffledInput;
            this.payloads.sortSortedInput = SynchronizedDoubleListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = SynchronizedDoubleListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = SynchronizedDoubleListTest::shuffleThis;
            this.payloads.binarySearch = SynchronizedDoubleListTest::binarySearch;
            this.payloads.toReversed = SynchronizedDoubleListTest::toReversed;
            this.payloads.forEachWithIndex = SynchronizedDoubleListTest::forEachWithIndex;
            this.payloads.forEachInBoth = SynchronizedDoubleListTest::forEachInBoth;
            this.payloads.selectWithIndex = SynchronizedDoubleListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = SynchronizedDoubleListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = SynchronizedDoubleListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = SynchronizedDoubleListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = SynchronizedDoubleListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedDoubleListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = SynchronizedDoubleListTest::testEquals;
            this.payloads.testToString = SynchronizedDoubleListTest::testToString;
            this.payloads.distinct = SynchronizedDoubleListTest::distinct;
            this.payloads.makeString = SynchronizedDoubleListTest::makeString;
            this.payloads.appendString = SynchronizedDoubleListTest::appendString;
            this.payloads.toList = SynchronizedDoubleListTest::toList;
            this.payloads.toImmutable = SynchronizedDoubleListTest::toImmutable;
            this.payloads.injectInto = SynchronizedDoubleListTest::injectInto;
            this.payloads.injectIntoWithIndex = SynchronizedDoubleListTest::injectIntoWithIndex;
            this.payloads.zipDouble = SynchronizedDoubleListTest::zipDouble;
            this.payloads.zip = SynchronizedDoubleListTest::zip;
            this.payloads.stream = SynchronizedDoubleListTest::stream;
            this.payloads.parallelStream = SynchronizedDoubleListTest::parallelStream;
            this.payloads.asSynchronized = SynchronizedDoubleListTest::asSynchronized;
        }
    }
}
