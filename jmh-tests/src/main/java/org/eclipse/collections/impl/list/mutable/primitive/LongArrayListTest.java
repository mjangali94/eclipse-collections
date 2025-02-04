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

import java.lang.reflect.Field;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.LongIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.LongIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class LongArrayListTest extends AbstractLongListTestCase {

    private final LongArrayList list = this.classUnderTest();

    @Override
    protected final LongArrayList classUnderTest() {
        return LongArrayList.newListWith(1L, 2L, 3L);
    }

    @Override
    protected LongArrayList newWith(long... elements) {
        return LongArrayList.newListWith(elements);
    }

    @Test
    public void testLongArrayListWithInitialCapacity() throws Exception {
        LongArrayList arrayList = new LongArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = LongArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((long[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        LongArrayList newList = LongArrayList.newWithNValues(5, 42L);
        Verify.assertSize(5, newList);
        Assert.assertEquals(LongArrayList.newListWith(42L, 42L, 42L, 42L, 42L), newList);
        LongArrayList newList2 = LongArrayList.newWithNValues(0, 2L);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        LongArrayList.newWithNValues(-5, 42L);
    }

    @Test
    public void wrapCopy() {
        long[] array = { 0L, 1L };
        LongArrayList list = LongArrayList.wrapCopy(array);
        array[0] = 1L;
        Assert.assertTrue(list.get(0) < 1L);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        LongArrayList listWithCapacity = new LongArrayList(4).with(1L, 2L, 3L, 4L);
        listWithCapacity.addAtIndex(3, 5L);
        Field items = LongArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((long[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = LongArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        LongArrayList arrayList = new LongArrayList().with(1L, 2L, 3L);
        Assert.assertEquals(10L, ((long[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new long[] { 1L, 2L, 3L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }, (long[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new long[] { 1L, 2L, 3L }, (long[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new LongArrayList());
        Verify.assertSize(3, LongLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        LongArrayList list1 = LongArrayList.newListWith(1L, 2L, 3L);
        LongArrayList list2 = LongArrayList.newListWith(1L, 2L, 3L);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        LongArrayList list1 = LongArrayList.newListWith(1L, 2L, 3L);
        LongArrayList list2 = LongArrayList.newListWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        LongArrayList emptyList = new LongArrayList();
        LongArrayList arrayList = emptyList.with(1L);
        LongArrayList arrayList0 = new LongArrayList().with(1L, 2L);
        LongArrayList arrayList1 = new LongArrayList().with(1L, 2L, 3L);
        LongArrayList arrayList2 = new LongArrayList().with(1L, 2L, 3L, 4L);
        LongArrayList arrayList3 = new LongArrayList().with(1L, 2L, 3L, 4L, 5L);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(LongArrayList.newListWith(1L), arrayList);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L), arrayList2);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongIterableIterate.class);
        Verify.assertClassNonInstantiable(LongIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        LongArrayList list = new LongArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5L);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongArrayListTest instance;

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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst_emptyList_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast_emptyList_throws);
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
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_greater_than_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_negative);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_swap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.swap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithPrimitiveComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithPrimitiveComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithOddEvenComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithOddEvenComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorNaturalComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithKeyExtractorNaturalComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorUnnaturalComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithKeyExtractorUnnaturalComparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInputWithDupes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortShuffledInputWithDupes);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortShuffledInput);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortSortedInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortSortedInput);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortReversedSortedInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortReversedSortedInput);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shuffleThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shuffleThis);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
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
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
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
        public void benchmark_testLongArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testLongArrayListWithInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues_throws_negative_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapCopy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndexAtCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndexAtCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new LongArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> zipLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> testLongArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = LongArrayListTest::newCollectionWith;
            this.payloads.newCollection = LongArrayListTest::newCollection;
            this.payloads.isEmpty = LongArrayListTest::isEmpty;
            this.payloads.notEmpty = LongArrayListTest::notEmpty;
            this.payloads.tap = LongArrayListTest::tap;
            this.payloads.containsAllArray = LongArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = LongArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = LongArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = LongArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = LongArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = LongArrayListTest::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = LongArrayListTest::forEach;
            this.payloads.count = LongArrayListTest::count;
            this.payloads.anySatisfy = LongArrayListTest::anySatisfy;
            this.payloads.allSatisfy = LongArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = LongArrayListTest::noneSatisfy;
            this.payloads.collect = LongArrayListTest::collect;
            this.payloads.collectWithTarget = LongArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = LongArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = LongArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = LongArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = LongArrayListTest::collectPrimitivesToSets;
            this.payloads.select = LongArrayListTest::select;
            this.payloads.selectWithTarget = LongArrayListTest::selectWithTarget;
            this.payloads.reject = LongArrayListTest::reject;
            this.payloads.rejectWithTarget = LongArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = LongArrayListTest::detectIfNone;
            this.payloads.max = LongArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = LongArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongArrayListTest::maxIfEmpty;
            this.payloads.sum = LongArrayListTest::sum;
            this.payloads.summaryStatistics = LongArrayListTest::summaryStatistics;
            this.payloads.average = LongArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = LongArrayListTest::averageIfEmpty;
            this.payloads.median = LongArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = LongArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = LongArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = LongArrayListTest::toSortedArray;
            this.payloads.testHashCode = LongArrayListTest::testHashCode;
            this.payloads.toSortedList = LongArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = LongArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = LongArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = LongArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = LongArrayListTest::toSet;
            this.payloads.toBag = LongArrayListTest::toBag;
            this.payloads.asLazy = LongArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = LongArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = LongArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = LongArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = LongArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = LongArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = LongArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = LongArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = LongArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = LongArrayListTest::reduce;
            this.payloads.reduceIfEmpty = LongArrayListTest::reduceIfEmpty;
            this.payloads.chunk = LongArrayListTest::chunk;
            this.payloads.clear = LongArrayListTest::clear;
            this.payloads.contains = LongArrayListTest::contains;
            this.payloads.add = LongArrayListTest::add;
            this.payloads.remove = LongArrayListTest::remove;
            this.payloads.removeIf = LongArrayListTest::removeIf;
            this.payloads.removeAll = LongArrayListTest::removeAll;
            this.payloads.removeAll_iterable = LongArrayListTest::removeAll_iterable;
            this.payloads.retainAll = LongArrayListTest::retainAll;
            this.payloads.retainAll_iterable = LongArrayListTest::retainAll_iterable;
            this.payloads.withAll = LongArrayListTest::withAll;
            this.payloads.without = LongArrayListTest::without;
            this.payloads.withoutAll = LongArrayListTest::withoutAll;
            this.payloads.asSynchronized = LongArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = LongArrayListTest::asUnmodifiable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = LongArrayListTest::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = LongArrayListTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = LongArrayListTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = LongArrayListTest::newEmpty;
            this.payloads.get = LongArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = LongArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = LongArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = LongArrayListTest::indexOf;
            this.payloads.lastIndexOf = LongArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = LongArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = LongArrayListTest::addAllArray;
            this.payloads.addAllIterable = LongArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = LongArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = LongArrayListTest::set;
            this.payloads.swap = LongArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.longIterator = LongArrayListTest::longIterator;
            this.payloads.toArray = LongArrayListTest::toArray;
            this.payloads.reverseThis = LongArrayListTest::reverseThis;
            this.payloads.sortThis = LongArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = LongArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = LongArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = LongArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = LongArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = LongArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = LongArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = LongArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = LongArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = LongArrayListTest::shuffleThis;
            this.payloads.binarySearch = LongArrayListTest::binarySearch;
            this.payloads.toReversed = LongArrayListTest::toReversed;
            this.payloads.forEachWithIndex = LongArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = LongArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = LongArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = LongArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = LongArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = LongArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = LongArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = LongArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = LongArrayListTest::testEquals;
            this.payloads.testToString = LongArrayListTest::testToString;
            this.payloads.distinct = LongArrayListTest::distinct;
            this.payloads.makeString = LongArrayListTest::makeString;
            this.payloads.appendString = LongArrayListTest::appendString;
            this.payloads.toList = LongArrayListTest::toList;
            this.payloads.injectInto = LongArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = LongArrayListTest::injectIntoWithIndex;
            this.payloads.zipLong = LongArrayListTest::zipLong;
            this.payloads.zip = LongArrayListTest::zip;
            this.payloads.stream = LongArrayListTest::stream;
            this.payloads.parallelStream = LongArrayListTest::parallelStream;
            this.payloads.testLongArrayListWithInitialCapacity = LongArrayListTest::testLongArrayListWithInitialCapacity;
            this.payloads.newWithNValues = LongArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = LongArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = LongArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = LongArrayListTest::trimToSize;
            this.payloads.size = LongArrayListTest::size;
            this.payloads.dotProduct = LongArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = LongArrayListTest::with;
            this.payloads.classIsNonInstantiable = LongArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = LongArrayListTest::toImmutable;
        }
    }
*/
}
