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
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.ByteIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.ByteIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class ByteArrayListTest extends AbstractByteListTestCase {

    private final ByteArrayList list = this.classUnderTest();

    @Override
    protected final ByteArrayList classUnderTest() {
        return ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected ByteArrayList newWith(byte... elements) {
        return ByteArrayList.newListWith(elements);
    }

    @Test
    public void testByteArrayListWithInitialCapacity() throws Exception {
        ByteArrayList arrayList = new ByteArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = ByteArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((byte[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues() {
        ByteArrayList newList = ByteArrayList.newWithNValues(5, (byte) 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 42, (byte) 42, (byte) 42, (byte) 42, (byte) 42), newList);
        ByteArrayList newList2 = ByteArrayList.newWithNValues(0, (byte) 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size() {
        ByteArrayList.newWithNValues(-5, (byte) 42);
    }

    @Test
    public void wrapCopy() {
        byte[] array = { (byte) 0, (byte) 1 };
        ByteArrayList list = ByteArrayList.wrapCopy(array);
        array[0] = (byte) 1;
        Assert.assertTrue(list.get(0) < (byte) 1);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception {
        ByteArrayList listWithCapacity = new ByteArrayList(4).with((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        listWithCapacity.addAtIndex(3, (byte) 5);
        Field items = ByteArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((byte[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception {
        Field items = ByteArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        ByteArrayList arrayList = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(10L, ((byte[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 2, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 }, (byte[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 2, (byte) 3 }, (byte[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Verify.assertSize(0, new ByteArrayList());
        Verify.assertSize(3, ByteLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct() {
        ByteArrayList list1 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list2 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        ByteArrayList list1 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list2 = ByteArrayList.newListWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with() {
        super.with();
        ByteArrayList emptyList = new ByteArrayList();
        ByteArrayList arrayList = emptyList.with((byte) 1);
        ByteArrayList arrayList0 = new ByteArrayList().with((byte) 1, (byte) 2);
        ByteArrayList arrayList1 = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3);
        ByteArrayList arrayList2 = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        ByteArrayList arrayList3 = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), arrayList);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), arrayList2);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteIterableIterate.class);
        Verify.assertClassNonInstantiable(ByteIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ByteArrayList list = new ByteArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add((byte) 5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteArrayListTest instance;

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
        public void benchmark_byteIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws);
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
        public void benchmark_byteIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_throws_for_consecutive_remove);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testByteArrayListWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testByteArrayListWithInitialCapacity);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> payload) throws java.lang.Throwable {
            this.instance = new ByteArrayListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> zipByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> testByteArrayListWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> newWithNValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> newWithNValues_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> wrapCopy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> addAtIndexAtCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> trimToSize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteArrayListTest> toImmutable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ByteArrayListTest::newCollectionWith;
            this.payloads.newCollection = ByteArrayListTest::newCollection;
            this.payloads.isEmpty = ByteArrayListTest::isEmpty;
            this.payloads.notEmpty = ByteArrayListTest::notEmpty;
            this.payloads.tap = ByteArrayListTest::tap;
            this.payloads.containsAllArray = ByteArrayListTest::containsAllArray;
            this.payloads.containsAllIterable = ByteArrayListTest::containsAllIterable;
            this.payloads.containsAnyArray = ByteArrayListTest::containsAnyArray;
            this.payloads.containsAnyIterable = ByteArrayListTest::containsAnyIterable;
            this.payloads.containsNoneArray = ByteArrayListTest::containsNoneArray;
            this.payloads.containsNoneIterable = ByteArrayListTest::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = ByteArrayListTest::forEach;
            this.payloads.count = ByteArrayListTest::count;
            this.payloads.anySatisfy = ByteArrayListTest::anySatisfy;
            this.payloads.allSatisfy = ByteArrayListTest::allSatisfy;
            this.payloads.noneSatisfy = ByteArrayListTest::noneSatisfy;
            this.payloads.collect = ByteArrayListTest::collect;
            this.payloads.collectWithTarget = ByteArrayListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ByteArrayListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ByteArrayListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ByteArrayListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ByteArrayListTest::collectPrimitivesToSets;
            this.payloads.select = ByteArrayListTest::select;
            this.payloads.selectWithTarget = ByteArrayListTest::selectWithTarget;
            this.payloads.reject = ByteArrayListTest::reject;
            this.payloads.rejectWithTarget = ByteArrayListTest::rejectWithTarget;
            this.payloads.detectIfNone = ByteArrayListTest::detectIfNone;
            this.payloads.max = ByteArrayListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ByteArrayListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteArrayListTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteArrayListTest::maxIfEmpty;
            this.payloads.sum = ByteArrayListTest::sum;
            this.payloads.summaryStatistics = ByteArrayListTest::summaryStatistics;
            this.payloads.average = ByteArrayListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ByteArrayListTest::averageIfEmpty;
            this.payloads.median = ByteArrayListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ByteArrayListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = ByteArrayListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = ByteArrayListTest::toSortedArray;
            this.payloads.testHashCode = ByteArrayListTest::testHashCode;
            this.payloads.toSortedList = ByteArrayListTest::toSortedList;
            this.payloads.toSortedListByComparator = ByteArrayListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ByteArrayListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ByteArrayListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ByteArrayListTest::toSet;
            this.payloads.toBag = ByteArrayListTest::toBag;
            this.payloads.asLazy = ByteArrayListTest::asLazy;
            this.payloads.injectIntoBoolean = ByteArrayListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ByteArrayListTest::injectIntoByte;
            this.payloads.injectIntoChar = ByteArrayListTest::injectIntoChar;
            this.payloads.injectIntoShort = ByteArrayListTest::injectIntoShort;
            this.payloads.injectIntoInt = ByteArrayListTest::injectIntoInt;
            this.payloads.injectIntoFloat = ByteArrayListTest::injectIntoFloat;
            this.payloads.injectIntoLong = ByteArrayListTest::injectIntoLong;
            this.payloads.injectIntoDouble = ByteArrayListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ByteArrayListTest::reduce;
            this.payloads.reduceIfEmpty = ByteArrayListTest::reduceIfEmpty;
            this.payloads.chunk = ByteArrayListTest::chunk;
            this.payloads.clear = ByteArrayListTest::clear;
            this.payloads.contains = ByteArrayListTest::contains;
            this.payloads.add = ByteArrayListTest::add;
            this.payloads.remove = ByteArrayListTest::remove;
            this.payloads.removeIf = ByteArrayListTest::removeIf;
            this.payloads.removeAll = ByteArrayListTest::removeAll;
            this.payloads.removeAll_iterable = ByteArrayListTest::removeAll_iterable;
            this.payloads.retainAll = ByteArrayListTest::retainAll;
            this.payloads.retainAll_iterable = ByteArrayListTest::retainAll_iterable;
            this.payloads.withAll = ByteArrayListTest::withAll;
            this.payloads.without = ByteArrayListTest::without;
            this.payloads.withoutAll = ByteArrayListTest::withoutAll;
            this.payloads.asSynchronized = ByteArrayListTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteArrayListTest::asUnmodifiable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = ByteArrayListTest::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = ByteArrayListTest::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = ByteArrayListTest::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ByteArrayListTest::newEmpty;
            this.payloads.get = ByteArrayListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = ByteArrayListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = ByteArrayListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.indexOf = ByteArrayListTest::indexOf;
            this.payloads.lastIndexOf = ByteArrayListTest::lastIndexOf;
            this.payloads.addAtIndex = ByteArrayListTest::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = ByteArrayListTest::addAllArray;
            this.payloads.addAllIterable = ByteArrayListTest::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = ByteArrayListTest::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = ByteArrayListTest::set;
            this.payloads.swap = ByteArrayListTest::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.byteIterator = ByteArrayListTest::byteIterator;
            this.payloads.toArray = ByteArrayListTest::toArray;
            this.payloads.reverseThis = ByteArrayListTest::reverseThis;
            this.payloads.sortThis = ByteArrayListTest::sortThis;
            this.payloads.sortWithPrimitiveComparator = ByteArrayListTest::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = ByteArrayListTest::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = ByteArrayListTest::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = ByteArrayListTest::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = ByteArrayListTest::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = ByteArrayListTest::sortShuffledInput;
            this.payloads.sortSortedInput = ByteArrayListTest::sortSortedInput;
            this.payloads.sortReversedSortedInput = ByteArrayListTest::sortReversedSortedInput;
            this.payloads.shuffleThis = ByteArrayListTest::shuffleThis;
            this.payloads.binarySearch = ByteArrayListTest::binarySearch;
            this.payloads.toReversed = ByteArrayListTest::toReversed;
            this.payloads.forEachWithIndex = ByteArrayListTest::forEachWithIndex;
            this.payloads.forEachInBoth = ByteArrayListTest::forEachInBoth;
            this.payloads.selectWithIndex = ByteArrayListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = ByteArrayListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = ByteArrayListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = ByteArrayListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = ByteArrayListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = ByteArrayListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = ByteArrayListTest::testEquals;
            this.payloads.testToString = ByteArrayListTest::testToString;
            this.payloads.distinct = ByteArrayListTest::distinct;
            this.payloads.makeString = ByteArrayListTest::makeString;
            this.payloads.appendString = ByteArrayListTest::appendString;
            this.payloads.toList = ByteArrayListTest::toList;
            this.payloads.injectInto = ByteArrayListTest::injectInto;
            this.payloads.injectIntoWithIndex = ByteArrayListTest::injectIntoWithIndex;
            this.payloads.zipByte = ByteArrayListTest::zipByte;
            this.payloads.zip = ByteArrayListTest::zip;
            this.payloads.testByteArrayListWithInitialCapacity = ByteArrayListTest::testByteArrayListWithInitialCapacity;
            this.payloads.newWithNValues = ByteArrayListTest::newWithNValues;
            this.payloads.newWithNValues_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::newWithNValues_throws_negative_size, java.lang.NegativeArraySizeException.class);
            this.payloads.wrapCopy = ByteArrayListTest::wrapCopy;
            this.payloads.addAtIndexAtCapacity = ByteArrayListTest::addAtIndexAtCapacity;
            this.payloads.trimToSize = ByteArrayListTest::trimToSize;
            this.payloads.size = ByteArrayListTest::size;
            this.payloads.dotProduct = ByteArrayListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteArrayListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.with = ByteArrayListTest::with;
            this.payloads.classIsNonInstantiable = ByteArrayListTest::classIsNonInstantiable;
            this.payloads.toImmutable = ByteArrayListTest::toImmutable;
        }
    }
}
