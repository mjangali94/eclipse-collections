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
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.DoubleIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.DoubleIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class DoubleArrayListTest extends AbstractDoubleListTestCase {

    private final DoubleArrayList list = this.classUnderTest();

    @Override
    protected final DoubleArrayList classUnderTest() {
        return DoubleArrayList.newListWith(1.0, 2.0, 3.0);
    }

    @Override
    protected DoubleArrayList newWith(double... elements) {
        return DoubleArrayList.newListWith(elements);
    }

    @Test
    public void testDoubleArrayListWithInitialCapacity() throws Exception {
        DoubleArrayList arrayList = new DoubleArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = DoubleArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((double[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        DoubleArrayList newList = DoubleArrayList.newWithNValues(5, 42.0);
        Verify.assertSize(5, newList);
        Assert.assertEquals(DoubleArrayList.newListWith(42.0, 42.0, 42.0, 42.0, 42.0), newList);
        DoubleArrayList newList2 = DoubleArrayList.newWithNValues(0, 2.0);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        DoubleArrayList.newWithNValues(-5, 42.0);
    }

    @Test
    public void wrapCopy() {
        double[] array = { 0.0, 1.0 };
        DoubleArrayList list = DoubleArrayList.wrapCopy(array);
        array[0] = 1.0;
        Assert.assertTrue(list.get(0) < 1.0);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        DoubleArrayList listWithCapacity = new DoubleArrayList(4).with(1.0, 2.0, 3.0, 4.0);
        listWithCapacity.addAtIndex(3, 5.0);
        Field items = DoubleArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((double[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = DoubleArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        DoubleArrayList arrayList = new DoubleArrayList().with(1.0, 2.0, 3.0);
        Assert.assertEquals(10L, ((double[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new double[] { 1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, (double[]) items.get(arrayList), 0.0);
        arrayList.trimToSize();
        Assert.assertArrayEquals(new double[] { 1.0, 2.0, 3.0 }, (double[]) items.get(arrayList), 0.0);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new DoubleArrayList());
        Verify.assertSize(3, DoubleLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        DoubleArrayList list1 = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        DoubleArrayList list2 = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        DoubleArrayList list1 = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        DoubleArrayList list2 = DoubleArrayList.newListWith(1.0, 2.0);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        DoubleArrayList emptyList = new DoubleArrayList();
        DoubleArrayList arrayList = emptyList.with(1.0);
        DoubleArrayList arrayList0 = new DoubleArrayList().with(1.0, 2.0);
        DoubleArrayList arrayList1 = new DoubleArrayList().with(1.0, 2.0, 3.0);
        DoubleArrayList arrayList2 = new DoubleArrayList().with(1.0, 2.0, 3.0, 4.0);
        DoubleArrayList arrayList3 = new DoubleArrayList().with(1.0, 2.0, 3.0, 4.0, 5.0);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), arrayList);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0), arrayList2);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleIterableIterate.class);
        Verify.assertClassNonInstantiable(DoubleIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        DoubleArrayList list = new DoubleArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5.0);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleArrayListTest instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_zipDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipDouble);
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
        public void benchmark_testDoubleArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testDoubleArrayListWithInitialCapacity);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> zipDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> testDoubleArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = DoubleArrayListTest::newCollectionWith;
            this.payloads.newCollection = DoubleArrayListTest::newCollection;
            this.payloads.isEmpty = DoubleArrayListTest::isEmpty;
            this.payloads.notEmpty = DoubleArrayListTest::notEmpty;
            this.payloads.tap = DoubleArrayListTest::tap;
            this.payloads.contains_NaN = DoubleArrayListTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = DoubleArrayListTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = DoubleArrayListTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = DoubleArrayListTest::contains_zero;
            this.payloads.testEquals_NaN = DoubleArrayListTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = DoubleArrayListTest::contains_different_NaNs;
            this.payloads.containsAllArray = DoubleArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = DoubleArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = DoubleArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = DoubleArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = DoubleArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = DoubleArrayListTest::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = DoubleArrayListTest::forEach;
            this.payloads.count = DoubleArrayListTest::count;
            this.payloads.anySatisfy = DoubleArrayListTest::anySatisfy;
            this.payloads.allSatisfy = DoubleArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleArrayListTest::noneSatisfy;
            this.payloads.collect = DoubleArrayListTest::collect;
            this.payloads.collectWithTarget = DoubleArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = DoubleArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = DoubleArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = DoubleArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = DoubleArrayListTest::collectPrimitivesToSets;
            this.payloads.select = DoubleArrayListTest::select;
            this.payloads.selectWithTarget = DoubleArrayListTest::selectWithTarget;
            this.payloads.reject = DoubleArrayListTest::reject;
            this.payloads.rejectWithTarget = DoubleArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = DoubleArrayListTest::detectIfNone;
            this.payloads.max = DoubleArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = DoubleArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleArrayListTest::maxIfEmpty;
            this.payloads.sum = DoubleArrayListTest::sum;
            this.payloads.summaryStatistics = DoubleArrayListTest::summaryStatistics;
            this.payloads.sumConsistentRounding = DoubleArrayListTest::sumConsistentRounding;
            this.payloads.average = DoubleArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = DoubleArrayListTest::averageIfEmpty;
            this.payloads.median = DoubleArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = DoubleArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = DoubleArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = DoubleArrayListTest::toSortedArray;
            this.payloads.testHashCode = DoubleArrayListTest::testHashCode;
            this.payloads.toSortedList = DoubleArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = DoubleArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = DoubleArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = DoubleArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = DoubleArrayListTest::toSet;
            this.payloads.toBag = DoubleArrayListTest::toBag;
            this.payloads.asLazy = DoubleArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = DoubleArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = DoubleArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = DoubleArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = DoubleArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = DoubleArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = DoubleArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = DoubleArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = DoubleArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = DoubleArrayListTest::reduce;
            this.payloads.reduceIfEmpty = DoubleArrayListTest::reduceIfEmpty;
            this.payloads.chunk = DoubleArrayListTest::chunk;
            this.payloads.clear = DoubleArrayListTest::clear;
            this.payloads.contains = DoubleArrayListTest::contains;
            this.payloads.add = DoubleArrayListTest::add;
            this.payloads.remove = DoubleArrayListTest::remove;
            this.payloads.removeIf = DoubleArrayListTest::removeIf;
            this.payloads.removeAll = DoubleArrayListTest::removeAll;
            this.payloads.removeAll_iterable = DoubleArrayListTest::removeAll_iterable;
            this.payloads.retainAll = DoubleArrayListTest::retainAll;
            this.payloads.retainAll_iterable = DoubleArrayListTest::retainAll_iterable;
            this.payloads.withAll = DoubleArrayListTest::withAll;
            this.payloads.without = DoubleArrayListTest::without;
            this.payloads.withoutAll = DoubleArrayListTest::withoutAll;
            this.payloads.asSynchronized = DoubleArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleArrayListTest::asUnmodifiable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = DoubleArrayListTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = DoubleArrayListTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = DoubleArrayListTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = DoubleArrayListTest::newEmpty;
            this.payloads.get = DoubleArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = DoubleArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = DoubleArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = DoubleArrayListTest::indexOf;
            this.payloads.lastIndexOf = DoubleArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = DoubleArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = DoubleArrayListTest::addAllArray;
            this.payloads.addAllIterable = DoubleArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = DoubleArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = DoubleArrayListTest::set;
            this.payloads.swap = DoubleArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.doubleIterator = DoubleArrayListTest::doubleIterator;
            this.payloads.toArray = DoubleArrayListTest::toArray;
            this.payloads.reverseThis = DoubleArrayListTest::reverseThis;
            this.payloads.sortThis = DoubleArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = DoubleArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = DoubleArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = DoubleArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = DoubleArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = DoubleArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = DoubleArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = DoubleArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = DoubleArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = DoubleArrayListTest::shuffleThis;
            this.payloads.binarySearch = DoubleArrayListTest::binarySearch;
            this.payloads.toReversed = DoubleArrayListTest::toReversed;
            this.payloads.forEachWithIndex = DoubleArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = DoubleArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = DoubleArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = DoubleArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = DoubleArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = DoubleArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = DoubleArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = DoubleArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = DoubleArrayListTest::testEquals;
            this.payloads.testToString = DoubleArrayListTest::testToString;
            this.payloads.distinct = DoubleArrayListTest::distinct;
            this.payloads.makeString = DoubleArrayListTest::makeString;
            this.payloads.appendString = DoubleArrayListTest::appendString;
            this.payloads.toList = DoubleArrayListTest::toList;
            this.payloads.injectInto = DoubleArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = DoubleArrayListTest::injectIntoWithIndex;
            this.payloads.zipDouble = DoubleArrayListTest::zipDouble;
            this.payloads.zip = DoubleArrayListTest::zip;
            this.payloads.stream = DoubleArrayListTest::stream;
            this.payloads.parallelStream = DoubleArrayListTest::parallelStream;
            this.payloads.testDoubleArrayListWithInitialCapacity = DoubleArrayListTest::testDoubleArrayListWithInitialCapacity;
            this.payloads.newWithNValues = DoubleArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = DoubleArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = DoubleArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = DoubleArrayListTest::trimToSize;
            this.payloads.size = DoubleArrayListTest::size;
            this.payloads.dotProduct = DoubleArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = DoubleArrayListTest::with;
            this.payloads.classIsNonInstantiable = DoubleArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = DoubleArrayListTest::toImmutable;
        }
    }
}
