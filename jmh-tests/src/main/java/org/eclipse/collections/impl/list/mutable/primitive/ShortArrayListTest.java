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
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.ShortIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.ShortIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class ShortArrayListTest extends AbstractShortListTestCase {

    private final ShortArrayList list = this.classUnderTest();

    @Override
    protected final ShortArrayList classUnderTest() {
        return ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    protected ShortArrayList newWith(short... elements) {
        return ShortArrayList.newListWith(elements);
    }

    @Test
    public void testShortArrayListWithInitialCapacity() throws Exception {
        ShortArrayList arrayList = new ShortArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = ShortArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((short[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        ShortArrayList newList = ShortArrayList.newWithNValues(5, (short) 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(ShortArrayList.newListWith((short) 42, (short) 42, (short) 42, (short) 42, (short) 42), newList);
        ShortArrayList newList2 = ShortArrayList.newWithNValues(0, (short) 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        ShortArrayList.newWithNValues(-5, (short) 42);
    }

    @Test
    public void wrapCopy() {
        short[] array = { (short) 0, (short) 1 };
        ShortArrayList list = ShortArrayList.wrapCopy(array);
        array[0] = (short) 1;
        Assert.assertTrue(list.get(0) < (short) 1);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        ShortArrayList listWithCapacity = new ShortArrayList(4).with((short) 1, (short) 2, (short) 3, (short) 4);
        listWithCapacity.addAtIndex(3, (short) 5);
        Field items = ShortArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((short[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = ShortArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        ShortArrayList arrayList = new ShortArrayList().with((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(10L, ((short[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 2, (short) 3, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0 }, (short[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 2, (short) 3 }, (short[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new ShortArrayList());
        Verify.assertSize(3, ShortLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        ShortArrayList list1 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ShortArrayList list2 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ShortArrayList list1 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ShortArrayList list2 = ShortArrayList.newListWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        ShortArrayList emptyList = new ShortArrayList();
        ShortArrayList arrayList = emptyList.with((short) 1);
        ShortArrayList arrayList0 = new ShortArrayList().with((short) 1, (short) 2);
        ShortArrayList arrayList1 = new ShortArrayList().with((short) 1, (short) 2, (short) 3);
        ShortArrayList arrayList2 = new ShortArrayList().with((short) 1, (short) 2, (short) 3, (short) 4);
        ShortArrayList arrayList3 = new ShortArrayList().with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), arrayList);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4), arrayList2);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortIterableIterate.class);
        Verify.assertClassNonInstantiable(ShortIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ShortArrayList list = new ShortArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add((short) 5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortArrayListTest instance;

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
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_zipShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testShortArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testShortArrayListWithInitialCapacity);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ShortArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> zipShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> testShortArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ShortArrayListTest::newCollectionWith;
            this.payloads.newCollection = ShortArrayListTest::newCollection;
            this.payloads.isEmpty = ShortArrayListTest::isEmpty;
            this.payloads.notEmpty = ShortArrayListTest::notEmpty;
            this.payloads.tap = ShortArrayListTest::tap;
            this.payloads.containsAllArray = ShortArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ShortArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = ShortArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ShortArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ShortArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ShortArrayListTest::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ShortArrayListTest::forEach;
            this.payloads.count = ShortArrayListTest::count;
            this.payloads.anySatisfy = ShortArrayListTest::anySatisfy;
            this.payloads.allSatisfy = ShortArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = ShortArrayListTest::noneSatisfy;
            this.payloads.collect = ShortArrayListTest::collect;
            this.payloads.collectWithTarget = ShortArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ShortArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ShortArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ShortArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ShortArrayListTest::collectPrimitivesToSets;
            this.payloads.select = ShortArrayListTest::select;
            this.payloads.selectWithTarget = ShortArrayListTest::selectWithTarget;
            this.payloads.reject = ShortArrayListTest::reject;
            this.payloads.rejectWithTarget = ShortArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = ShortArrayListTest::detectIfNone;
            this.payloads.max = ShortArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ShortArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ShortArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ShortArrayListTest::maxIfEmpty;
            this.payloads.sum = ShortArrayListTest::sum;
            this.payloads.summaryStatistics = ShortArrayListTest::summaryStatistics;
            this.payloads.average = ShortArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ShortArrayListTest::averageIfEmpty;
            this.payloads.median = ShortArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ShortArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ShortArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ShortArrayListTest::toSortedArray;
            this.payloads.testHashCode = ShortArrayListTest::testHashCode;
            this.payloads.toSortedList = ShortArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = ShortArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ShortArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ShortArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ShortArrayListTest::toSet;
            this.payloads.toBag = ShortArrayListTest::toBag;
            this.payloads.asLazy = ShortArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = ShortArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ShortArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = ShortArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = ShortArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = ShortArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ShortArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ShortArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ShortArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ShortArrayListTest::reduce;
            this.payloads.reduceIfEmpty = ShortArrayListTest::reduceIfEmpty;
            this.payloads.chunk = ShortArrayListTest::chunk;
            this.payloads.clear = ShortArrayListTest::clear;
            this.payloads.contains = ShortArrayListTest::contains;
            this.payloads.add = ShortArrayListTest::add;
            this.payloads.remove = ShortArrayListTest::remove;
            this.payloads.removeIf = ShortArrayListTest::removeIf;
            this.payloads.removeAll = ShortArrayListTest::removeAll;
            this.payloads.removeAll_iterable = ShortArrayListTest::removeAll_iterable;
            this.payloads.retainAll = ShortArrayListTest::retainAll;
            this.payloads.retainAll_iterable = ShortArrayListTest::retainAll_iterable;
            this.payloads.withAll = ShortArrayListTest::withAll;
            this.payloads.without = ShortArrayListTest::without;
            this.payloads.withoutAll = ShortArrayListTest::withoutAll;
            this.payloads.asSynchronized = ShortArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortArrayListTest::asUnmodifiable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = ShortArrayListTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = ShortArrayListTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = ShortArrayListTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ShortArrayListTest::newEmpty;
            this.payloads.get = ShortArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ShortArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = ShortArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = ShortArrayListTest::indexOf;
            this.payloads.lastIndexOf = ShortArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = ShortArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = ShortArrayListTest::addAllArray;
            this.payloads.addAllIterable = ShortArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = ShortArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = ShortArrayListTest::set;
            this.payloads.swap = ShortArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.shortIterator = ShortArrayListTest::shortIterator;
            this.payloads.toArray = ShortArrayListTest::toArray;
            this.payloads.reverseThis = ShortArrayListTest::reverseThis;
            this.payloads.sortThis = ShortArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = ShortArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = ShortArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = ShortArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = ShortArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = ShortArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = ShortArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = ShortArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = ShortArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = ShortArrayListTest::shuffleThis;
            this.payloads.binarySearch = ShortArrayListTest::binarySearch;
            this.payloads.toReversed = ShortArrayListTest::toReversed;
            this.payloads.forEachWithIndex = ShortArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = ShortArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = ShortArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ShortArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ShortArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ShortArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ShortArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ShortArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = ShortArrayListTest::testEquals;
            this.payloads.testToString = ShortArrayListTest::testToString;
            this.payloads.distinct = ShortArrayListTest::distinct;
            this.payloads.makeString = ShortArrayListTest::makeString;
            this.payloads.appendString = ShortArrayListTest::appendString;
            this.payloads.toList = ShortArrayListTest::toList;
            this.payloads.injectInto = ShortArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = ShortArrayListTest::injectIntoWithIndex;
            this.payloads.zipShort = ShortArrayListTest::zipShort;
            this.payloads.zip = ShortArrayListTest::zip;
            this.payloads.testShortArrayListWithInitialCapacity = ShortArrayListTest::testShortArrayListWithInitialCapacity;
            this.payloads.newWithNValues = ShortArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = ShortArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = ShortArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = ShortArrayListTest::trimToSize;
            this.payloads.size = ShortArrayListTest::size;
            this.payloads.dotProduct = ShortArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = ShortArrayListTest::with;
            this.payloads.classIsNonInstantiable = ShortArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = ShortArrayListTest::toImmutable;
        }
    }
}
