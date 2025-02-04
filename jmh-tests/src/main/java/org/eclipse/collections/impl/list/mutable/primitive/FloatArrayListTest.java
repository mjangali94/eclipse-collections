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
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.FloatIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.FloatIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class FloatArrayListTest extends AbstractFloatListTestCase {

    private final FloatArrayList list = this.classUnderTest();

    @Override
    protected final FloatArrayList classUnderTest() {
        return FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected FloatArrayList newWith(float... elements) {
        return FloatArrayList.newListWith(elements);
    }

    @Test
    public void testFloatArrayListWithInitialCapacity() throws Exception {
        FloatArrayList arrayList = new FloatArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = FloatArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((float[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        FloatArrayList newList = FloatArrayList.newWithNValues(5, 42.0f);
        Verify.assertSize(5, newList);
        Assert.assertEquals(FloatArrayList.newListWith(42.0f, 42.0f, 42.0f, 42.0f, 42.0f), newList);
        FloatArrayList newList2 = FloatArrayList.newWithNValues(0, 2.0f);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        FloatArrayList.newWithNValues(-5, 42.0f);
    }

    @Test
    public void wrapCopy() {
        float[] array = { 0.0f, 1.0f };
        FloatArrayList list = FloatArrayList.wrapCopy(array);
        array[0] = 1.0f;
        Assert.assertTrue(list.get(0) < 1.0f);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        FloatArrayList listWithCapacity = new FloatArrayList(4).with(1.0f, 2.0f, 3.0f, 4.0f);
        listWithCapacity.addAtIndex(3, 5.0f);
        Field items = FloatArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((float[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = FloatArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        FloatArrayList arrayList = new FloatArrayList().with(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(10L, ((float[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, (float[]) items.get(arrayList), 0.0f);
        arrayList.trimToSize();
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f }, (float[]) items.get(arrayList), 0.0f);
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new FloatArrayList());
        Verify.assertSize(3, FloatLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        FloatArrayList list1 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        FloatArrayList list2 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        FloatArrayList list1 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        FloatArrayList list2 = FloatArrayList.newListWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        FloatArrayList emptyList = new FloatArrayList();
        FloatArrayList arrayList = emptyList.with(1.0f);
        FloatArrayList arrayList0 = new FloatArrayList().with(1.0f, 2.0f);
        FloatArrayList arrayList1 = new FloatArrayList().with(1.0f, 2.0f, 3.0f);
        FloatArrayList arrayList2 = new FloatArrayList().with(1.0f, 2.0f, 3.0f, 4.0f);
        FloatArrayList arrayList3 = new FloatArrayList().with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), arrayList);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f), arrayList2);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatIterableIterate.class);
        Verify.assertClassNonInstantiable(FloatIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        FloatArrayList list = new FloatArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5.0f);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatArrayListTest instance;

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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_zipFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testFloatArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testFloatArrayListWithInitialCapacity);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new FloatArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> zipFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> testFloatArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FloatArrayListTest::newCollectionWith;
            this.payloads.newCollection = FloatArrayListTest::newCollection;
            this.payloads.isEmpty = FloatArrayListTest::isEmpty;
            this.payloads.notEmpty = FloatArrayListTest::notEmpty;
            this.payloads.tap = FloatArrayListTest::tap;
            this.payloads.contains_NaN = FloatArrayListTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = FloatArrayListTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = FloatArrayListTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = FloatArrayListTest::contains_zero;
            this.payloads.testEquals_NaN = FloatArrayListTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = FloatArrayListTest::contains_different_NaNs;
            this.payloads.containsAllArray = FloatArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = FloatArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = FloatArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = FloatArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = FloatArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = FloatArrayListTest::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = FloatArrayListTest::forEach;
            this.payloads.count = FloatArrayListTest::count;
            this.payloads.anySatisfy = FloatArrayListTest::anySatisfy;
            this.payloads.allSatisfy = FloatArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = FloatArrayListTest::noneSatisfy;
            this.payloads.collect = FloatArrayListTest::collect;
            this.payloads.collectWithTarget = FloatArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FloatArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FloatArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FloatArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FloatArrayListTest::collectPrimitivesToSets;
            this.payloads.select = FloatArrayListTest::select;
            this.payloads.selectWithTarget = FloatArrayListTest::selectWithTarget;
            this.payloads.reject = FloatArrayListTest::reject;
            this.payloads.rejectWithTarget = FloatArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = FloatArrayListTest::detectIfNone;
            this.payloads.max = FloatArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FloatArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatArrayListTest::maxIfEmpty;
            this.payloads.sum = FloatArrayListTest::sum;
            this.payloads.summaryStatistics = FloatArrayListTest::summaryStatistics;
            this.payloads.sumConsistentRounding = FloatArrayListTest::sumConsistentRounding;
            this.payloads.average = FloatArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FloatArrayListTest::averageIfEmpty;
            this.payloads.median = FloatArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FloatArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = FloatArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = FloatArrayListTest::toSortedArray;
            this.payloads.testHashCode = FloatArrayListTest::testHashCode;
            this.payloads.toSortedList = FloatArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = FloatArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FloatArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FloatArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FloatArrayListTest::toSet;
            this.payloads.toBag = FloatArrayListTest::toBag;
            this.payloads.asLazy = FloatArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = FloatArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FloatArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = FloatArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = FloatArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = FloatArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = FloatArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = FloatArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = FloatArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FloatArrayListTest::reduce;
            this.payloads.reduceIfEmpty = FloatArrayListTest::reduceIfEmpty;
            this.payloads.chunk = FloatArrayListTest::chunk;
            this.payloads.clear = FloatArrayListTest::clear;
            this.payloads.contains = FloatArrayListTest::contains;
            this.payloads.add = FloatArrayListTest::add;
            this.payloads.remove = FloatArrayListTest::remove;
            this.payloads.removeIf = FloatArrayListTest::removeIf;
            this.payloads.removeAll = FloatArrayListTest::removeAll;
            this.payloads.removeAll_iterable = FloatArrayListTest::removeAll_iterable;
            this.payloads.retainAll = FloatArrayListTest::retainAll;
            this.payloads.retainAll_iterable = FloatArrayListTest::retainAll_iterable;
            this.payloads.withAll = FloatArrayListTest::withAll;
            this.payloads.without = FloatArrayListTest::without;
            this.payloads.withoutAll = FloatArrayListTest::withoutAll;
            this.payloads.asSynchronized = FloatArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatArrayListTest::asUnmodifiable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = FloatArrayListTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = FloatArrayListTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = FloatArrayListTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = FloatArrayListTest::newEmpty;
            this.payloads.get = FloatArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = FloatArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = FloatArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = FloatArrayListTest::indexOf;
            this.payloads.lastIndexOf = FloatArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = FloatArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = FloatArrayListTest::addAllArray;
            this.payloads.addAllIterable = FloatArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = FloatArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = FloatArrayListTest::set;
            this.payloads.swap = FloatArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.floatIterator = FloatArrayListTest::floatIterator;
            this.payloads.toArray = FloatArrayListTest::toArray;
            this.payloads.reverseThis = FloatArrayListTest::reverseThis;
            this.payloads.sortThis = FloatArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = FloatArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = FloatArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = FloatArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = FloatArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = FloatArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = FloatArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = FloatArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = FloatArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = FloatArrayListTest::shuffleThis;
            this.payloads.binarySearch = FloatArrayListTest::binarySearch;
            this.payloads.toReversed = FloatArrayListTest::toReversed;
            this.payloads.forEachWithIndex = FloatArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = FloatArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = FloatArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = FloatArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = FloatArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = FloatArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = FloatArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = FloatArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = FloatArrayListTest::testEquals;
            this.payloads.testToString = FloatArrayListTest::testToString;
            this.payloads.distinct = FloatArrayListTest::distinct;
            this.payloads.makeString = FloatArrayListTest::makeString;
            this.payloads.appendString = FloatArrayListTest::appendString;
            this.payloads.toList = FloatArrayListTest::toList;
            this.payloads.injectInto = FloatArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = FloatArrayListTest::injectIntoWithIndex;
            this.payloads.zipFloat = FloatArrayListTest::zipFloat;
            this.payloads.zip = FloatArrayListTest::zip;
            this.payloads.testFloatArrayListWithInitialCapacity = FloatArrayListTest::testFloatArrayListWithInitialCapacity;
            this.payloads.newWithNValues = FloatArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = FloatArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = FloatArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = FloatArrayListTest::trimToSize;
            this.payloads.size = FloatArrayListTest::size;
            this.payloads.dotProduct = FloatArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = FloatArrayListTest::with;
            this.payloads.classIsNonInstantiable = FloatArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = FloatArrayListTest::toImmutable;
        }
    }
*/
}
