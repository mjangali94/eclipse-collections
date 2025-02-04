/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ShortList;
import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableShortList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractShortListTestCase extends AbstractMutableShortCollectionTestCase {

    private static final ShortList SORTED_LONGER_LIST = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11, (short) 12, (short) 13, (short) 14, (short) 15, (short) 16, (short) 17, (short) 18, (short) 19, (short) 20);

    private static final ShortList SORTED_SHORTER_LIST = ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5);

    @Override
    protected abstract MutableShortList classUnderTest();

    @Override
    protected abstract MutableShortList newWith(short... elements);

    @Override
    protected MutableShortList newMutableCollectionWith(short... elements) {
        return ShortArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Short> newObjectCollectionWith(Short... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableShortList list = this.classUnderTest();
        Assert.assertEquals(1L, list.get(0));
        Assert.assertEquals(2L, list.get(1));
        Assert.assertEquals(3L, list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size() {
        this.classUnderTest().get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative() {
        this.classUnderTest().get(-1);
    }

    @Test
    public void getFirst() {
        MutableShortList singleItemList = this.newWith((short) 1);
        Assert.assertEquals(1L, singleItemList.getFirst());
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableShortList singleItemList = this.newWith((short) 1);
        Assert.assertEquals(1L, singleItemList.getLast());
        Assert.assertEquals(3L, this.classUnderTest().getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableShortList arrayList = this.newWith((short) 1, (short) 2, (short) 1);
        Assert.assertEquals(0L, arrayList.indexOf((short) 1));
        Assert.assertEquals(1L, arrayList.indexOf((short) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((short) 9));
    }

    @Test
    public void lastIndexOf() {
        MutableShortList arrayList = this.newWith((short) 1, (short) 2, (short) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((short) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((short) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((short) 9));
    }

    @Test
    public void addAtIndex() {
        MutableShortList emptyList = this.newWith();
        emptyList.addAtIndex(0, (short) 1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), emptyList);
        MutableShortList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, (short) 4);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4), arrayList);
        arrayList.addAtIndex(2, (short) 5);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 5, (short) 3, (short) 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, (short) 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, (short) 4);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableShortList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll((short) 4, (short) 5, (short) 6));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, (short) 5, (short) 6));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 5, (short) 6), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableShortList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
        Assert.assertTrue(list.addAll(ShortArrayStack.newStackWith((short) 8, (short) 7)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, ShortArrayList.newListWith((short) 5, (short) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 5, (short) 6, (short) 7, (short) 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, (short) 5, (short) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, (short) 5, (short) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, ShortArrayList.newListWith((short) 1, (short) 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, ShortArrayList.newListWith((short) 1, (short) 2));
    }

    @Test
    public void removeAtIndex() {
        MutableShortList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndex_throws_index_greater_than_size() {
        this.newWith().removeAtIndex(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndex_throws_index_negative() {
        this.classUnderTest().removeAtIndex(-1);
    }

    @Test
    public void set() {
        MutableShortList list = this.classUnderTest();
        list.set(1, (short) 4);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 4, (short) 3), list);
    }

    @Test
    public void swap() {
        MutableShortList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3, (short) 2), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3, (short) 2), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void shortIterator() {
        ShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertArrayEquals(new short[] { (short) 1, (short) 2, (short) 4, (short) 3 }, this.newWith((short) 1, (short) 2, (short) 4, (short) 3).toArray());
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new ShortArrayList(), this.newWith().reverseThis());
        MutableShortList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3), this.newWith((short) 3).reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1), this.newWith((short) 1, (short) 3).reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7), this.newWith((short) 7, (short) 9, (short) 1, (short) 3).reverseThis());
        MutableShortList sameList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8), this.newWith((short) 8, (short) 7, (short) 9, (short) 1, (short) 3).reverseThis());
        MutableShortList list1 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, ShortArrayList.newListWith((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(list1.reverseThis(), ShortArrayList.newListWith((short) 3, (short) 2, (short) 1));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new ShortArrayList(), this.newWith().sortThis());
        MutableShortList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3), this.newWith((short) 3).sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 3), this.newWith((short) 3, (short) 1).sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 3, (short) 7, (short) 9), this.newWith((short) 3, (short) 1, (short) 9, (short) 7).sortThis());
        MutableShortList sameList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 3, (short) 7, (short) 8, (short) 9), this.newWith((short) 8, (short) 1, (short) 7, (short) 3, (short) 9).sortThis());
        MutableShortList list = this.newWith();
        list.add((short) 2);
        list.add((short) 1);
        list.sortThis();
        Assert.assertEquals((short) 1, list.get(0));
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableShortList index = this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 4, (short) 0, (short) 3, (short) 1, (short) 2), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableShortList index = this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 2, (short) 4, (short) 6, (short) 8, (short) 1, (short) 3, (short) 5, (short) 7, (short) 9), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableShortList index = this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 0, (short) 4, (short) 3), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableShortList index = this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 4, (short) 0, (short) 2, (short) 1), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 3, (short) 4), this.newMutableCollectionWith((short) 3, (short) 2, (short) 1, (short) 0, (short) 1, (short) 4).sortThis(Short::compare));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 2, (short) 2, (short) 3, (short) 4, (short) 6, (short) 7, (short) 8, (short) 10, (short) 11, (short) 12, (short) 13, (short) 14, (short) 15, (short) 15, (short) 15, (short) 17, (short) 18, (short) 19), this.newMutableCollectionWith((short) 17, (short) 1, (short) 15, (short) 12, (short) 10, (short) 4, (short) 2, (short) 19, (short) 2, (short) 8, (short) 18, (short) 15, (short) 15, (short) 13, (short) 3, (short) 11, (short) 7, (short) 2, (short) 14, (short) 6).sortThis(Short::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((short) 3, (short) 2, (short) 1, (short) 0, (short) 5, (short) 4).sortThis(Short::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((short) 3, (short) 0, (short) 1, (short) 2, (short) 5, (short) 4).sortThis(Short::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((short) 17, (short) 1, (short) 16, (short) 12, (short) 10, (short) 4, (short) 2, (short) 19, (short) 5, (short) 8, (short) 18, (short) 15, (short) 20, (short) 13, (short) 3, (short) 11, (short) 7, (short) 9, (short) 14, (short) 6).sortThis(Short::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((short) 12, (short) 3, (short) 17, (short) 20, (short) 5, (short) 2, (short) 4, (short) 9, (short) 16, (short) 19, (short) 10, (short) 14, (short) 6, (short) 7, (short) 15, (short) 11, (short) 13, (short) 18, (short) 8, (short) 1).sortThis(Short::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5).sortThis(Short::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11, (short) 12, (short) 13, (short) 14, (short) 15, (short) 16, (short) 17, (short) 18, (short) 19, (short) 20).sortThis(Short::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((short) 5, (short) 4, (short) 3, (short) 2, (short) 1, (short) 0).sortThis(Short::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((short) 20, (short) 19, (short) 18, (short) 17, (short) 16, (short) 15, (short) 14, (short) 13, (short) 12, (short) 11, (short) 10, (short) 9, (short) 8, (short) 7, (short) 6, (short) 5, (short) 4, (short) 3, (short) 2, (short) 1).sortThis(Short::compare));
    }

    @Test
    public void shuffleThis() {
        ShortList checkList = this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11, (short) 12, (short) 13, (short) 14, (short) 15).toImmutable();
        MutableShortList list = checkList.toList();
        ShortList shuffleOne = list.shuffleThis().toImmutable();
        ShortList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableShortList list = this.newWith((short) 2, (short) 3, (short) 5, (short) 6, (short) 9);
        Assert.assertEquals(-1, list.binarySearch((short) 1));
        Assert.assertEquals(0, list.binarySearch((short) 2));
        Assert.assertEquals(1, list.binarySearch((short) 3));
        Assert.assertEquals(-3, list.binarySearch((short) 4));
        Assert.assertEquals(2, list.binarySearch((short) 5));
        Assert.assertEquals(3, list.binarySearch((short) 6));
        Assert.assertEquals(-5, list.binarySearch((short) 7));
        Assert.assertEquals(-5, list.binarySearch((short) 8));
        Assert.assertEquals(4, list.binarySearch((short) 9));
        Assert.assertEquals(-6, list.binarySearch((short) 10));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new ShortArrayList(), this.newWith().toReversed());
        MutableShortList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7), this.newWith((short) 7, (short) 9, (short) 1, (short) 3).toReversed());
        MutableShortList evenList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8), this.newWith((short) 8, (short) 7, (short) 9, (short) 1, (short) 3).toReversed());
        MutableShortList oddList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((short each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableShortList list1 = this.newWith((short) 3, (short) 1);
        MutableShortList list2 = this.newWith((short) 7, (short) 9);
        MutableList<ShortShortPair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<ShortShortPair> expected = Lists.mutable.with(PrimitiveTuples.pair((short) 3, (short) 7), PrimitiveTuples.pair((short) 1, (short) 9));
        Assert.assertEquals(expected, result);
        MutableShortList list3 = this.newWith((short) 7, (short) 9, (short) 1);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList selected = list.selectWithIndex((value, i) -> i % 2 == 0, ShortLists.mutable.empty());
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ShortLists.mutable.with((short) 1, (short) 7), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableShortList list = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        MutableShortList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, ShortLists.mutable.empty());
        Assert.assertEquals(ShortLists.mutable.with((short) 1, (short) 7), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(ShortSets.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ShortLists.mutable.with((short) 3, (short) 1, (short) 9, (short) 7), pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        MutableShortList list2 = this.newWith((short) 4, (short) 3, (short) 2, (short) 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1, 2, 3]", this.classUnderTest().toString());
    }

    @Test
    public void distinct() {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3, (short) 4, (short) 4, (short) 4, (short) 4).distinct();
        MutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        Assert.assertEquals(list1, list2);
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1, 2, 3", this.classUnderTest().makeString());
        Assert.assertEquals("1/2/3", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1, 2, 3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1/2/3", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableShortList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ShortArrayList arrayList = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        MutableShort result = arrayList.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShort result = list1.injectIntoWithIndex(new MutableShort((short) 0), (MutableShort object, short value, int index) -> object.add((short) (value * list2.get(index))));
        Assert.assertEquals(new MutableShort((short) 14), result);
    }

    @Test
    public void zipShort() {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2);
        MutableList<ShortShortPair> zipSame = list1.zipShort(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2), PrimitiveTuples.pair((short) 3, (short) 3)), zipSame);
        MutableList<ShortShortPair> zipSameLazy = list1.zipShort(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2), PrimitiveTuples.pair((short) 3, (short) 3)), zipSameLazy);
        MutableList<ShortShortPair> zipLess = list1.zipShort(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2)), zipLess);
        MutableList<ShortShortPair> zipLessLazy = list1.zipShort(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2)), zipLessLazy);
        MutableList<ShortShortPair> zipMore = list2.zipShort(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2)), zipMore);
        MutableList<ShortShortPair> zipMoreLazy = list2.zipShort(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2)), zipMoreLazy);
        MutableList<ShortShortPair> zipEmpty = list1.zipShort(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<ShortObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2"), PrimitiveTuples.pair((short) 3, "3")), zipSame);
        MutableList<ShortObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2"), PrimitiveTuples.pair((short) 3, "3")), zipSameLazy);
        MutableList<ShortObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2")), zipLess);
        MutableList<ShortObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2")), zipLessLazy);
        MutableList<ShortObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2")), zipMore);
        MutableList<ShortObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((short) 1, "1"), PrimitiveTuples.pair((short) 2, "2")), zipMoreLazy);
        MutableList<ShortObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortListTestCase instance;

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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
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
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct_throwsOnListsOfDifferentSizes);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> zipShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortListTestCase> zip;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractShortListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractShortListTestCase::newCollection;
            this.payloads.isEmpty = AbstractShortListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractShortListTestCase::notEmpty;
            this.payloads.tap = AbstractShortListTestCase::tap;
            this.payloads.containsAllArray = AbstractShortListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractShortListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractShortListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractShortListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractShortListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractShortListTestCase::containsNoneIterable;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractShortListTestCase::forEach;
            this.payloads.size = AbstractShortListTestCase::size;
            this.payloads.count = AbstractShortListTestCase::count;
            this.payloads.anySatisfy = AbstractShortListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractShortListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractShortListTestCase::noneSatisfy;
            this.payloads.collect = AbstractShortListTestCase::collect;
            this.payloads.collectWithTarget = AbstractShortListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractShortListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractShortListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractShortListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractShortListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractShortListTestCase::select;
            this.payloads.selectWithTarget = AbstractShortListTestCase::selectWithTarget;
            this.payloads.reject = AbstractShortListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractShortListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractShortListTestCase::detectIfNone;
            this.payloads.max = AbstractShortListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractShortListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractShortListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractShortListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractShortListTestCase::sum;
            this.payloads.summaryStatistics = AbstractShortListTestCase::summaryStatistics;
            this.payloads.average = AbstractShortListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractShortListTestCase::averageIfEmpty;
            this.payloads.median = AbstractShortListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractShortListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractShortListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractShortListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractShortListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractShortListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractShortListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractShortListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractShortListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractShortListTestCase::toSet;
            this.payloads.toBag = AbstractShortListTestCase::toBag;
            this.payloads.asLazy = AbstractShortListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractShortListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractShortListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractShortListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractShortListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractShortListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractShortListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractShortListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractShortListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractShortListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractShortListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractShortListTestCase::chunk;
            this.payloads.clear = AbstractShortListTestCase::clear;
            this.payloads.contains = AbstractShortListTestCase::contains;
            this.payloads.add = AbstractShortListTestCase::add;
            this.payloads.remove = AbstractShortListTestCase::remove;
            this.payloads.removeIf = AbstractShortListTestCase::removeIf;
            this.payloads.removeAll = AbstractShortListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractShortListTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractShortListTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractShortListTestCase::retainAll_iterable;
            this.payloads.with = AbstractShortListTestCase::with;
            this.payloads.withAll = AbstractShortListTestCase::withAll;
            this.payloads.without = AbstractShortListTestCase::without;
            this.payloads.withoutAll = AbstractShortListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractShortListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractShortListTestCase::asUnmodifiable;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = AbstractShortListTestCase::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = AbstractShortListTestCase::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = AbstractShortListTestCase::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractShortListTestCase::newEmpty;
            this.payloads.get = AbstractShortListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractShortListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractShortListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = AbstractShortListTestCase::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = AbstractShortListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractShortListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractShortListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractShortListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractShortListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = AbstractShortListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractShortListTestCase::set;
            this.payloads.swap = AbstractShortListTestCase::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.shortIterator = AbstractShortListTestCase::shortIterator;
            this.payloads.toArray = AbstractShortListTestCase::toArray;
            this.payloads.reverseThis = AbstractShortListTestCase::reverseThis;
            this.payloads.sortThis = AbstractShortListTestCase::sortThis;
            this.payloads.sortWithPrimitiveComparator = AbstractShortListTestCase::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = AbstractShortListTestCase::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = AbstractShortListTestCase::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = AbstractShortListTestCase::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = AbstractShortListTestCase::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = AbstractShortListTestCase::sortShuffledInput;
            this.payloads.sortSortedInput = AbstractShortListTestCase::sortSortedInput;
            this.payloads.sortReversedSortedInput = AbstractShortListTestCase::sortReversedSortedInput;
            this.payloads.shuffleThis = AbstractShortListTestCase::shuffleThis;
            this.payloads.binarySearch = AbstractShortListTestCase::binarySearch;
            this.payloads.toReversed = AbstractShortListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractShortListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractShortListTestCase::forEachInBoth;
            this.payloads.selectWithIndex = AbstractShortListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractShortListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractShortListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractShortListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractShortListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractShortListTestCase::collectWithIndexWithTarget;
            this.payloads.testEquals = AbstractShortListTestCase::testEquals;
            this.payloads.testToString = AbstractShortListTestCase::testToString;
            this.payloads.distinct = AbstractShortListTestCase::distinct;
            this.payloads.makeString = AbstractShortListTestCase::makeString;
            this.payloads.appendString = AbstractShortListTestCase::appendString;
            this.payloads.toList = AbstractShortListTestCase::toList;
            this.payloads.toImmutable = AbstractShortListTestCase::toImmutable;
            this.payloads.injectInto = AbstractShortListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractShortListTestCase::injectIntoWithIndex;
            this.payloads.zipShort = AbstractShortListTestCase::zipShort;
            this.payloads.zip = AbstractShortListTestCase::zip;
        }
    }
}
