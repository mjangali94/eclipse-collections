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

import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedByteList}.
 * This file was automatically generated from template file synchronizedPrimitiveListTest.stg.
 */
public class SynchronizedByteListTest extends AbstractByteListTestCase {

    @Override
    protected SynchronizedByteList classUnderTest() {
        return new SynchronizedByteList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected SynchronizedByteList newWith(byte... elements) {
        return new SynchronizedByteList(ByteArrayList.newListWith(elements));
    }

    @Override
    @Test
    public void asSynchronized() {
        super.asSynchronized();
        SynchronizedByteList list = this.classUnderTest();
        MutableByteList listWithLockObject = new SynchronizedByteList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), new Object());
        Assert.assertEquals(list, listWithLockObject);
        Assert.assertSame(listWithLockObject, listWithLockObject.asSynchronized());
        Assert.assertSame(list, list.asSynchronized());
        Assert.assertEquals(list, list.asSynchronized());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SynchronizedByteListTest instance;

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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> payload) throws java.lang.Throwable {
            this.instance = new SynchronizedByteListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> zipByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SynchronizedByteListTest> asSynchronized;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = SynchronizedByteListTest::newCollectionWith;
            this.payloads.newCollection = SynchronizedByteListTest::newCollection;
            this.payloads.isEmpty = SynchronizedByteListTest::isEmpty;
            this.payloads.notEmpty = SynchronizedByteListTest::notEmpty;
            this.payloads.tap = SynchronizedByteListTest::tap;
            this.payloads.containsAllArray = SynchronizedByteListTest::containsAllArray;
            this.payloads.containsAllIterable = SynchronizedByteListTest::containsAllIterable;
            this.payloads.containsAnyArray = SynchronizedByteListTest::containsAnyArray;
            this.payloads.containsAnyIterable = SynchronizedByteListTest::containsAnyIterable;
            this.payloads.containsNoneArray = SynchronizedByteListTest::containsNoneArray;
            this.payloads.containsNoneIterable = SynchronizedByteListTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = SynchronizedByteListTest::forEach;
            this.payloads.size = SynchronizedByteListTest::size;
            this.payloads.count = SynchronizedByteListTest::count;
            this.payloads.anySatisfy = SynchronizedByteListTest::anySatisfy;
            this.payloads.allSatisfy = SynchronizedByteListTest::allSatisfy;
            this.payloads.noneSatisfy = SynchronizedByteListTest::noneSatisfy;
            this.payloads.collect = SynchronizedByteListTest::collect;
            this.payloads.collectWithTarget = SynchronizedByteListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = SynchronizedByteListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = SynchronizedByteListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = SynchronizedByteListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = SynchronizedByteListTest::collectPrimitivesToSets;
            this.payloads.select = SynchronizedByteListTest::select;
            this.payloads.selectWithTarget = SynchronizedByteListTest::selectWithTarget;
            this.payloads.reject = SynchronizedByteListTest::reject;
            this.payloads.rejectWithTarget = SynchronizedByteListTest::rejectWithTarget;
            this.payloads.detectIfNone = SynchronizedByteListTest::detectIfNone;
            this.payloads.max = SynchronizedByteListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = SynchronizedByteListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = SynchronizedByteListTest::minIfEmpty;
            this.payloads.maxIfEmpty = SynchronizedByteListTest::maxIfEmpty;
            this.payloads.sum = SynchronizedByteListTest::sum;
            this.payloads.summaryStatistics = SynchronizedByteListTest::summaryStatistics;
            this.payloads.average = SynchronizedByteListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = SynchronizedByteListTest::averageIfEmpty;
            this.payloads.median = SynchronizedByteListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = SynchronizedByteListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = SynchronizedByteListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = SynchronizedByteListTest::toSortedArray;
            this.payloads.testHashCode = SynchronizedByteListTest::testHashCode;
            this.payloads.toSortedList = SynchronizedByteListTest::toSortedList;
            this.payloads.toSortedListByComparator = SynchronizedByteListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = SynchronizedByteListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = SynchronizedByteListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = SynchronizedByteListTest::toSet;
            this.payloads.toBag = SynchronizedByteListTest::toBag;
            this.payloads.asLazy = SynchronizedByteListTest::asLazy;
            this.payloads.injectIntoBoolean = SynchronizedByteListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = SynchronizedByteListTest::injectIntoByte;
            this.payloads.injectIntoChar = SynchronizedByteListTest::injectIntoChar;
            this.payloads.injectIntoShort = SynchronizedByteListTest::injectIntoShort;
            this.payloads.injectIntoInt = SynchronizedByteListTest::injectIntoInt;
            this.payloads.injectIntoFloat = SynchronizedByteListTest::injectIntoFloat;
            this.payloads.injectIntoLong = SynchronizedByteListTest::injectIntoLong;
            this.payloads.injectIntoDouble = SynchronizedByteListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = SynchronizedByteListTest::reduce;
            this.payloads.reduceIfEmpty = SynchronizedByteListTest::reduceIfEmpty;
            this.payloads.chunk = SynchronizedByteListTest::chunk;
            this.payloads.clear = SynchronizedByteListTest::clear;
            this.payloads.contains = SynchronizedByteListTest::contains;
            this.payloads.add = SynchronizedByteListTest::add;
            this.payloads.remove = SynchronizedByteListTest::remove;
            this.payloads.removeIf = SynchronizedByteListTest::removeIf;
            this.payloads.removeAll = SynchronizedByteListTest::removeAll;
            this.payloads.removeAll_iterable = SynchronizedByteListTest::removeAll_iterable;
            this.payloads.retainAll = SynchronizedByteListTest::retainAll;
            this.payloads.retainAll_iterable = SynchronizedByteListTest::retainAll_iterable;
            this.payloads.with = SynchronizedByteListTest::with;
            this.payloads.withAll = SynchronizedByteListTest::withAll;
            this.payloads.without = SynchronizedByteListTest::without;
            this.payloads.withoutAll = SynchronizedByteListTest::withoutAll;
            this.payloads.asUnmodifiable = SynchronizedByteListTest::asUnmodifiable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = SynchronizedByteListTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = SynchronizedByteListTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = SynchronizedByteListTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = SynchronizedByteListTest::newEmpty;
            this.payloads.get = SynchronizedByteListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = SynchronizedByteListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = SynchronizedByteListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = SynchronizedByteListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = SynchronizedByteListTest::indexOf;
            this.payloads.lastIndexOf = SynchronizedByteListTest::lastIndexOf;
            this.payloads.addAtIndex = SynchronizedByteListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = SynchronizedByteListTest::addAllArray;
            this.payloads.addAllIterable = SynchronizedByteListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = SynchronizedByteListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = SynchronizedByteListTest::set;
            this.payloads.swap = SynchronizedByteListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(SynchronizedByteListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.byteIterator = SynchronizedByteListTest::byteIterator;
            this.payloads.toArray = SynchronizedByteListTest::toArray;
            this.payloads.reverseThis = SynchronizedByteListTest::reverseThis;
            this.payloads.sortThis = SynchronizedByteListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = SynchronizedByteListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = SynchronizedByteListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = SynchronizedByteListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = SynchronizedByteListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = SynchronizedByteListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = SynchronizedByteListTest::sortShuffledInput;
            this.payloads.sortSortedInput = SynchronizedByteListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = SynchronizedByteListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = SynchronizedByteListTest::shuffleThis;
            this.payloads.binarySearch = SynchronizedByteListTest::binarySearch;
            this.payloads.toReversed = SynchronizedByteListTest::toReversed;
            this.payloads.forEachWithIndex = SynchronizedByteListTest::forEachWithIndex;
            this.payloads.forEachInBoth = SynchronizedByteListTest::forEachInBoth;
            this.payloads.selectWithIndex = SynchronizedByteListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = SynchronizedByteListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = SynchronizedByteListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = SynchronizedByteListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = SynchronizedByteListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = SynchronizedByteListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = SynchronizedByteListTest::testEquals;
            this.payloads.testToString = SynchronizedByteListTest::testToString;
            this.payloads.distinct = SynchronizedByteListTest::distinct;
            this.payloads.makeString = SynchronizedByteListTest::makeString;
            this.payloads.appendString = SynchronizedByteListTest::appendString;
            this.payloads.toList = SynchronizedByteListTest::toList;
            this.payloads.toImmutable = SynchronizedByteListTest::toImmutable;
            this.payloads.injectInto = SynchronizedByteListTest::injectInto;
            this.payloads.injectIntoWithIndex = SynchronizedByteListTest::injectIntoWithIndex;
            this.payloads.zipByte = SynchronizedByteListTest::zipByte;
            this.payloads.zip = SynchronizedByteListTest::zip;
            this.payloads.asSynchronized = SynchronizedByteListTest::asSynchronized;
        }
    }
}
