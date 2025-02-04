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
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.IntIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.IntIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class IntArrayListTest extends AbstractIntListTestCase {

    private final IntArrayList list = this.classUnderTest();

    @Override
    protected final IntArrayList classUnderTest() {
        return IntArrayList.newListWith(1, 2, 3);
    }

    @Override
    protected IntArrayList newWith(int... elements) {
        return IntArrayList.newListWith(elements);
    }

    @Test
    public void testIntArrayListWithInitialCapacity() throws Exception {
        IntArrayList arrayList = new IntArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = IntArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((int[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        IntArrayList newList = IntArrayList.newWithNValues(5, 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(IntArrayList.newListWith(42, 42, 42, 42, 42), newList);
        IntArrayList newList2 = IntArrayList.newWithNValues(0, 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        IntArrayList.newWithNValues(-5, 42);
    }

    @Test
    public void wrapCopy() {
        int[] array = { 0, 1 };
        IntArrayList list = IntArrayList.wrapCopy(array);
        array[0] = 1;
        Assert.assertTrue(list.get(0) < 1);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        IntArrayList listWithCapacity = new IntArrayList(4).with(1, 2, 3, 4);
        listWithCapacity.addAtIndex(3, 5);
        Field items = IntArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((int[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = IntArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        IntArrayList arrayList = new IntArrayList().with(1, 2, 3);
        Assert.assertEquals(10L, ((int[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 0, 0, 0, 0, 0, 0, 0 }, (int[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new int[] { 1, 2, 3 }, (int[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new IntArrayList());
        Verify.assertSize(3, IntLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        IntArrayList list1 = IntArrayList.newListWith(1, 2, 3);
        IntArrayList list2 = IntArrayList.newListWith(1, 2, 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        IntArrayList list1 = IntArrayList.newListWith(1, 2, 3);
        IntArrayList list2 = IntArrayList.newListWith(1, 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        IntArrayList emptyList = new IntArrayList();
        IntArrayList arrayList = emptyList.with(1);
        IntArrayList arrayList0 = new IntArrayList().with(1, 2);
        IntArrayList arrayList1 = new IntArrayList().with(1, 2, 3);
        IntArrayList arrayList2 = new IntArrayList().with(1, 2, 3, 4);
        IntArrayList arrayList3 = new IntArrayList().with(1, 2, 3, 4, 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(IntArrayList.newListWith(1), arrayList);
        Assert.assertEquals(IntArrayList.newListWith(1, 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4), arrayList2);
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntIterableIterate.class);
        Verify.assertClassNonInstantiable(IntIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        IntArrayList list = new IntArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntArrayListTest instance;

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
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_zipInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipInt);
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
        public void benchmark_testIntArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testIntArrayListWithInitialCapacity);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new IntArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> zipInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> testIntArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntArrayListTest::newCollectionWith;
            this.payloads.newCollection = IntArrayListTest::newCollection;
            this.payloads.isEmpty = IntArrayListTest::isEmpty;
            this.payloads.notEmpty = IntArrayListTest::notEmpty;
            this.payloads.tap = IntArrayListTest::tap;
            this.payloads.containsAllArray = IntArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = IntArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = IntArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntArrayListTest::containsNoneIterable;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = IntArrayListTest::forEach;
            this.payloads.count = IntArrayListTest::count;
            this.payloads.anySatisfy = IntArrayListTest::anySatisfy;
            this.payloads.allSatisfy = IntArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = IntArrayListTest::noneSatisfy;
            this.payloads.collect = IntArrayListTest::collect;
            this.payloads.collectWithTarget = IntArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntArrayListTest::collectPrimitivesToSets;
            this.payloads.select = IntArrayListTest::select;
            this.payloads.selectWithTarget = IntArrayListTest::selectWithTarget;
            this.payloads.reject = IntArrayListTest::reject;
            this.payloads.rejectWithTarget = IntArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = IntArrayListTest::detectIfNone;
            this.payloads.max = IntArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntArrayListTest::maxIfEmpty;
            this.payloads.sum = IntArrayListTest::sum;
            this.payloads.summaryStatistics = IntArrayListTest::summaryStatistics;
            this.payloads.average = IntArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntArrayListTest::averageIfEmpty;
            this.payloads.median = IntArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = IntArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = IntArrayListTest::toSortedArray;
            this.payloads.testHashCode = IntArrayListTest::testHashCode;
            this.payloads.toSortedList = IntArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = IntArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntArrayListTest::toSet;
            this.payloads.toBag = IntArrayListTest::toBag;
            this.payloads.asLazy = IntArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = IntArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = IntArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = IntArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = IntArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntArrayListTest::reduce;
            this.payloads.reduceIfEmpty = IntArrayListTest::reduceIfEmpty;
            this.payloads.chunk = IntArrayListTest::chunk;
            this.payloads.clear = IntArrayListTest::clear;
            this.payloads.contains = IntArrayListTest::contains;
            this.payloads.add = IntArrayListTest::add;
            this.payloads.remove = IntArrayListTest::remove;
            this.payloads.removeIf = IntArrayListTest::removeIf;
            this.payloads.removeAll = IntArrayListTest::removeAll;
            this.payloads.removeAll_iterable = IntArrayListTest::removeAll_iterable;
            this.payloads.retainAll = IntArrayListTest::retainAll;
            this.payloads.retainAll_iterable = IntArrayListTest::retainAll_iterable;
            this.payloads.withAll = IntArrayListTest::withAll;
            this.payloads.without = IntArrayListTest::without;
            this.payloads.withoutAll = IntArrayListTest::withoutAll;
            this.payloads.asSynchronized = IntArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = IntArrayListTest::asUnmodifiable;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = IntArrayListTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = IntArrayListTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = IntArrayListTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = IntArrayListTest::newEmpty;
            this.payloads.get = IntArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = IntArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = IntArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = IntArrayListTest::indexOf;
            this.payloads.lastIndexOf = IntArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = IntArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = IntArrayListTest::addAllArray;
            this.payloads.addAllIterable = IntArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = IntArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = IntArrayListTest::set;
            this.payloads.swap = IntArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.intIterator = IntArrayListTest::intIterator;
            this.payloads.toArray = IntArrayListTest::toArray;
            this.payloads.reverseThis = IntArrayListTest::reverseThis;
            this.payloads.sortThis = IntArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = IntArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = IntArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = IntArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = IntArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = IntArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = IntArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = IntArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = IntArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = IntArrayListTest::shuffleThis;
            this.payloads.binarySearch = IntArrayListTest::binarySearch;
            this.payloads.toReversed = IntArrayListTest::toReversed;
            this.payloads.forEachWithIndex = IntArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = IntArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = IntArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = IntArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = IntArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = IntArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = IntArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = IntArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = IntArrayListTest::testEquals;
            this.payloads.testToString = IntArrayListTest::testToString;
            this.payloads.distinct = IntArrayListTest::distinct;
            this.payloads.makeString = IntArrayListTest::makeString;
            this.payloads.appendString = IntArrayListTest::appendString;
            this.payloads.toList = IntArrayListTest::toList;
            this.payloads.injectInto = IntArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = IntArrayListTest::injectIntoWithIndex;
            this.payloads.zipInt = IntArrayListTest::zipInt;
            this.payloads.zip = IntArrayListTest::zip;
            this.payloads.stream = IntArrayListTest::stream;
            this.payloads.parallelStream = IntArrayListTest::parallelStream;
            this.payloads.testIntArrayListWithInitialCapacity = IntArrayListTest::testIntArrayListWithInitialCapacity;
            this.payloads.newWithNValues = IntArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = IntArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = IntArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = IntArrayListTest::trimToSize;
            this.payloads.size = IntArrayListTest::size;
            this.payloads.dotProduct = IntArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = IntArrayListTest::with;
            this.payloads.classIsNonInstantiable = IntArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = IntArrayListTest::toImmutable;
        }
    }
}
