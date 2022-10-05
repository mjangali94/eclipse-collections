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

import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatList}.
 * This file was automatically generated from template file synchronizedPrimitiveListTest.stg.
 */
public class SynchronizedFloatListTest extends AbstractFloatListTestCase {

    @Override
    protected SynchronizedFloatList classUnderTest() {
        return new SynchronizedFloatList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected SynchronizedFloatList newWith(float... elements) {
        return new SynchronizedFloatList(FloatArrayList.newListWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedFloatList list = this.classUnderTest();
        MutableFloatList listWithLockObject = new SynchronizedFloatList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), new Object());
        Assert.assertEquals(list, listWithLockObject);
        Assert.assertSame(listWithLockObject, listWithLockObject.asSynchronized());
        Assert.assertSame(list, list.asSynchronized());
        Assert.assertEquals(list, list.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedFloatListTest instance;

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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_zipFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedFloatListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> zipFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedFloatListTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedFloatListTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedFloatListTest::newCollection;
            this.payloads.isEmpty = SynchronizedFloatListTest::isEmpty;
            this.payloads.notEmpty = SynchronizedFloatListTest::notEmpty;
            this.payloads.tap = SynchronizedFloatListTest::tap;
            this.payloads.contains_NaN = SynchronizedFloatListTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = SynchronizedFloatListTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = SynchronizedFloatListTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = SynchronizedFloatListTest::contains_zero;
            this.payloads.testEquals_NaN = SynchronizedFloatListTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = SynchronizedFloatListTest::contains_different_NaNs;
            this.payloads.containsAllArray = SynchronizedFloatListTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedFloatListTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedFloatListTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedFloatListTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedFloatListTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedFloatListTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedFloatListTest::forEach;
            this.payloads.size = SynchronizedFloatListTest::size;
            this.payloads.count = SynchronizedFloatListTest::count;
            this.payloads.anySatisfy = SynchronizedFloatListTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedFloatListTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedFloatListTest::noneSatisfy;
            this.payloads.collect = SynchronizedFloatListTest::collect;
            this.payloads.collectWithTarget = SynchronizedFloatListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedFloatListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedFloatListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedFloatListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedFloatListTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedFloatListTest::select;
            this.payloads.selectWithTarget = SynchronizedFloatListTest::selectWithTarget;
            this.payloads.reject = SynchronizedFloatListTest::reject;
            this.payloads.rejectWithTarget = SynchronizedFloatListTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedFloatListTest::detectIfNone;
            this.payloads.max = SynchronizedFloatListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedFloatListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedFloatListTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedFloatListTest::maxIfEmpty;
            this.payloads.sum = SynchronizedFloatListTest::sum;
            this.payloads.summaryStatistics = SynchronizedFloatListTest::summaryStatistics;
            this.payloads.sumConsistentRounding = SynchronizedFloatListTest::sumConsistentRounding;
            this.payloads.average = SynchronizedFloatListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedFloatListTest::averageIfEmpty;
            this.payloads.median = SynchronizedFloatListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedFloatListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = SynchronizedFloatListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedFloatListTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedFloatListTest::testHashCode;
            this.payloads.toSortedList = SynchronizedFloatListTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedFloatListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedFloatListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedFloatListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedFloatListTest::toSet;
            this.payloads.toBag = SynchronizedFloatListTest::toBag;
            this.payloads.asLazy = SynchronizedFloatListTest::asLazy;
            this.payloads.injectIntoBoolean = SynchronizedFloatListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedFloatListTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedFloatListTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedFloatListTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedFloatListTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedFloatListTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedFloatListTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedFloatListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedFloatListTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedFloatListTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedFloatListTest::chunk;
            this.payloads.clear = SynchronizedFloatListTest::clear;
            this.payloads.contains = SynchronizedFloatListTest::contains;
            this.payloads.add = SynchronizedFloatListTest::add;
            this.payloads.remove = SynchronizedFloatListTest::remove;
            this.payloads.removeIf = SynchronizedFloatListTest::removeIf;
            this.payloads.removeAll = SynchronizedFloatListTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedFloatListTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedFloatListTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedFloatListTest::retainAll_iterable;
            this.payloads.with = SynchronizedFloatListTest::with;
            this.payloads.withAll = SynchronizedFloatListTest::withAll;
            this.payloads.without = SynchronizedFloatListTest::without;
            this.payloads.withoutAll = SynchronizedFloatListTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedFloatListTest::asUnmodifiable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = SynchronizedFloatListTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = SynchronizedFloatListTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = SynchronizedFloatListTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedFloatListTest::newEmpty;
            this.payloads.get = SynchronizedFloatListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = SynchronizedFloatListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = SynchronizedFloatListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = SynchronizedFloatListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = SynchronizedFloatListTest::indexOf;
            this.payloads.lastIndexOf = SynchronizedFloatListTest::lastIndexOf;
            this.payloads.addAtIndex = SynchronizedFloatListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = SynchronizedFloatListTest::addAllArray;
            this.payloads.addAllIterable = SynchronizedFloatListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = SynchronizedFloatListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = SynchronizedFloatListTest::set;
            this.payloads.swap = SynchronizedFloatListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedFloatListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.floatIterator = SynchronizedFloatListTest::floatIterator;
            this.payloads.toArray = SynchronizedFloatListTest::toArray;
            this.payloads.reverseThis = SynchronizedFloatListTest::reverseThis;
            this.payloads.sortThis = SynchronizedFloatListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = SynchronizedFloatListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = SynchronizedFloatListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = SynchronizedFloatListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = SynchronizedFloatListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = SynchronizedFloatListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = SynchronizedFloatListTest::sortShuffledInput;
            this.payloads.sortSortedInput = SynchronizedFloatListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = SynchronizedFloatListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = SynchronizedFloatListTest::shuffleThis;
            this.payloads.binarySearch = SynchronizedFloatListTest::binarySearch;
            this.payloads.toReversed = SynchronizedFloatListTest::toReversed;
            this.payloads.forEachWithIndex = SynchronizedFloatListTest::forEachWithIndex;
            this.payloads.forEachInBoth = SynchronizedFloatListTest::forEachInBoth;
            this.payloads.selectWithIndex = SynchronizedFloatListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = SynchronizedFloatListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = SynchronizedFloatListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = SynchronizedFloatListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = SynchronizedFloatListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedFloatListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = SynchronizedFloatListTest::testEquals;
            this.payloads.testToString = SynchronizedFloatListTest::testToString;
            this.payloads.distinct = SynchronizedFloatListTest::distinct;
            this.payloads.makeString = SynchronizedFloatListTest::makeString;
            this.payloads.appendString = SynchronizedFloatListTest::appendString;
            this.payloads.toList = SynchronizedFloatListTest::toList;
            this.payloads.toImmutable = SynchronizedFloatListTest::toImmutable;
            this.payloads.injectInto = SynchronizedFloatListTest::injectInto;
            this.payloads.injectIntoWithIndex = SynchronizedFloatListTest::injectIntoWithIndex;
            this.payloads.zipFloat = SynchronizedFloatListTest::zipFloat;
            this.payloads.zip = SynchronizedFloatListTest::zip;
            this.payloads.asSynchronized = SynchronizedFloatListTest::asSynchronized;
        }
    }
}
