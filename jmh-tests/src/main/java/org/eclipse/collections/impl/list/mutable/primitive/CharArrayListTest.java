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
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.CharIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.CharIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class CharArrayListTest extends AbstractCharListTestCase {

    private final CharArrayList list = this.classUnderTest();

    @Override
    protected final CharArrayList classUnderTest() {
        return CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected CharArrayList newWith(char... elements) {
        return CharArrayList.newListWith(elements);
    }

    @Test
    public void testCharArrayListWithInitialCapacity() throws Exception {
        CharArrayList arrayList = new CharArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = CharArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((char[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        CharArrayList newList = CharArrayList.newWithNValues(5, (char) 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(CharArrayList.newListWith((char) 42, (char) 42, (char) 42, (char) 42, (char) 42), newList);
        CharArrayList newList2 = CharArrayList.newWithNValues(0, (char) 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        CharArrayList.newWithNValues(-5, (char) 42);
    }

    @Test
    public void wrapCopy() {
        char[] array = { (char) 0, (char) 1 };
        CharArrayList list = CharArrayList.wrapCopy(array);
        array[0] = (char) 1;
        Assert.assertTrue(list.get(0) < (char) 1);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        CharArrayList listWithCapacity = new CharArrayList(4).with((char) 1, (char) 2, (char) 3, (char) 4);
        listWithCapacity.addAtIndex(3, (char) 5);
        Field items = CharArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((char[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = CharArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        CharArrayList arrayList = new CharArrayList().with((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(10L, ((char[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3, (char) 0, (char) 0, (char) 0, (char) 0, (char) 0, (char) 0, (char) 0 }, (char[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 3 }, (char[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new CharArrayList());
        Verify.assertSize(3, CharLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        CharArrayList list1 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        CharArrayList list2 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        CharArrayList list1 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        CharArrayList list2 = CharArrayList.newListWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        CharArrayList emptyList = new CharArrayList();
        CharArrayList arrayList = emptyList.with((char) 1);
        CharArrayList arrayList0 = new CharArrayList().with((char) 1, (char) 2);
        CharArrayList arrayList1 = new CharArrayList().with((char) 1, (char) 2, (char) 3);
        CharArrayList arrayList2 = new CharArrayList().with((char) 1, (char) 2, (char) 3, (char) 4);
        CharArrayList arrayList3 = new CharArrayList().with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(CharArrayList.newListWith((char) 1), arrayList);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4), arrayList2);
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharIterableIterate.class);
        Verify.assertClassNonInstantiable(CharIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        CharArrayList list = new CharArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add((char) 5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharArrayListTest instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testCharArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testCharArrayListWithInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithNValues_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithNValues_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_wrapCopy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.wrapCopy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndexAtCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndexAtCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_trimToSize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.trimToSize);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new CharArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> zipChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> testCharArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CharArrayListTest::newCollectionWith;
            this.payloads.newCollection = CharArrayListTest::newCollection;
            this.payloads.isEmpty = CharArrayListTest::isEmpty;
            this.payloads.notEmpty = CharArrayListTest::notEmpty;
            this.payloads.tap = CharArrayListTest::tap;
            this.payloads.containsAllArray = CharArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = CharArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = CharArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = CharArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = CharArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = CharArrayListTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = CharArrayListTest::forEach;
            this.payloads.count = CharArrayListTest::count;
            this.payloads.anySatisfy = CharArrayListTest::anySatisfy;
            this.payloads.allSatisfy = CharArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = CharArrayListTest::noneSatisfy;
            this.payloads.collect = CharArrayListTest::collect;
            this.payloads.collectWithTarget = CharArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CharArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CharArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CharArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CharArrayListTest::collectPrimitivesToSets;
            this.payloads.select = CharArrayListTest::select;
            this.payloads.selectWithTarget = CharArrayListTest::selectWithTarget;
            this.payloads.reject = CharArrayListTest::reject;
            this.payloads.rejectWithTarget = CharArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = CharArrayListTest::detectIfNone;
            this.payloads.max = CharArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = CharArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharArrayListTest::maxIfEmpty;
            this.payloads.sum = CharArrayListTest::sum;
            this.payloads.summaryStatistics = CharArrayListTest::summaryStatistics;
            this.payloads.average = CharArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CharArrayListTest::averageIfEmpty;
            this.payloads.median = CharArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CharArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = CharArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = CharArrayListTest::toSortedArray;
            this.payloads.testHashCode = CharArrayListTest::testHashCode;
            this.payloads.toSortedList = CharArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = CharArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CharArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CharArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CharArrayListTest::toSet;
            this.payloads.toBag = CharArrayListTest::toBag;
            this.payloads.asLazy = CharArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = CharArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CharArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = CharArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = CharArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = CharArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = CharArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = CharArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = CharArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CharArrayListTest::reduce;
            this.payloads.reduceIfEmpty = CharArrayListTest::reduceIfEmpty;
            this.payloads.chunk = CharArrayListTest::chunk;
            this.payloads.clear = CharArrayListTest::clear;
            this.payloads.contains = CharArrayListTest::contains;
            this.payloads.add = CharArrayListTest::add;
            this.payloads.remove = CharArrayListTest::remove;
            this.payloads.removeIf = CharArrayListTest::removeIf;
            this.payloads.removeAll = CharArrayListTest::removeAll;
            this.payloads.removeAll_iterable = CharArrayListTest::removeAll_iterable;
            this.payloads.retainAll = CharArrayListTest::retainAll;
            this.payloads.retainAll_iterable = CharArrayListTest::retainAll_iterable;
            this.payloads.withAll = CharArrayListTest::withAll;
            this.payloads.without = CharArrayListTest::without;
            this.payloads.withoutAll = CharArrayListTest::withoutAll;
            this.payloads.asSynchronized = CharArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = CharArrayListTest::asUnmodifiable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = CharArrayListTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = CharArrayListTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = CharArrayListTest::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = CharArrayListTest::newEmpty;
            this.payloads.get = CharArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = CharArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = CharArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = CharArrayListTest::indexOf;
            this.payloads.lastIndexOf = CharArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = CharArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = CharArrayListTest::addAllArray;
            this.payloads.addAllIterable = CharArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = CharArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = CharArrayListTest::set;
            this.payloads.swap = CharArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.charIterator = CharArrayListTest::charIterator;
            this.payloads.toArray = CharArrayListTest::toArray;
            this.payloads.reverseThis = CharArrayListTest::reverseThis;
            this.payloads.sortThis = CharArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = CharArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = CharArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = CharArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = CharArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = CharArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = CharArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = CharArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = CharArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = CharArrayListTest::shuffleThis;
            this.payloads.binarySearch = CharArrayListTest::binarySearch;
            this.payloads.toReversed = CharArrayListTest::toReversed;
            this.payloads.forEachWithIndex = CharArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = CharArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = CharArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = CharArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = CharArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = CharArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = CharArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = CharArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = CharArrayListTest::testEquals;
            this.payloads.testToString = CharArrayListTest::testToString;
            this.payloads.distinct = CharArrayListTest::distinct;
            this.payloads.makeString = CharArrayListTest::makeString;
            this.payloads.appendString = CharArrayListTest::appendString;
            this.payloads.toList = CharArrayListTest::toList;
            this.payloads.injectInto = CharArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = CharArrayListTest::injectIntoWithIndex;
            this.payloads.zipChar = CharArrayListTest::zipChar;
            this.payloads.zip = CharArrayListTest::zip;
            this.payloads.testCharArrayListWithInitialCapacity = CharArrayListTest::testCharArrayListWithInitialCapacity;
            this.payloads.newWithNValues = CharArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = CharArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = CharArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = CharArrayListTest::trimToSize;
            this.payloads.size = CharArrayListTest::size;
            this.payloads.dotProduct = CharArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = CharArrayListTest::with;
            this.payloads.classIsNonInstantiable = CharArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = CharArrayListTest::toImmutable;
        }
    }
}
