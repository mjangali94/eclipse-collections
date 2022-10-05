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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::get_throws_index_greater_than_size, this.description("get_throws_index_greater_than_size"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::get_throws_index_negative, this.description("get_throws_index_negative"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getFirst_emptyList_throws, this.description("getFirst_emptyList_throws"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::getLast_emptyList_throws, this.description("getLast_emptyList_throws"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::dotProduct, this.description("dotProduct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::dotProduct_throwsOnListsOfDifferentSizes, this.description("dotProduct_throwsOnListsOfDifferentSizes"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::indexOf, this.description("indexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::lastIndexOf, this.description("lastIndexOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAtIndex, this.description("addAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAtIndex_throws_index_greater_than_size, this.description("addAtIndex_throws_index_greater_than_size"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAtIndex_throws_index_negative, this.description("addAtIndex_throws_index_negative"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllArray, this.description("addAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAll_throws_index_negative, this.description("addAll_throws_index_negative"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAll_throws_index_greater_than_size, this.description("addAll_throws_index_greater_than_size"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_negative() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAllIterable_throws_index_negative, this.description("addAllIterable_throws_index_negative"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_greater_than_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAllIterable_throws_index_greater_than_size, this.description("addAllIterable_throws_index_greater_than_size"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeAtIndex, this.description("removeAtIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAtIndex_throws_index_greater_than_size, this.description("removeAtIndex_throws_index_greater_than_size"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAtIndex_throws_index_negative, this.description("removeAtIndex_throws_index_negative"), java.lang.IndexOutOfBoundsException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::set, this.description("set"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_swap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::swap, this.description("swap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::subList, this.description("subList"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator, this.description("shortIterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reverseThis, this.description("reverseThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortThis, this.description("sortThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithPrimitiveComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortWithPrimitiveComparator, this.description("sortWithPrimitiveComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithOddEvenComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortWithOddEvenComparator, this.description("sortWithOddEvenComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorNaturalComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortWithKeyExtractorNaturalComparator, this.description("sortWithKeyExtractorNaturalComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorUnnaturalComparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortWithKeyExtractorUnnaturalComparator, this.description("sortWithKeyExtractorUnnaturalComparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInputWithDupes() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortShuffledInputWithDupes, this.description("sortShuffledInputWithDupes"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInput() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortShuffledInput, this.description("sortShuffledInput"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortSortedInput() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortSortedInput, this.description("sortSortedInput"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortReversedSortedInput() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sortReversedSortedInput, this.description("sortReversedSortedInput"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shuffleThis() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shuffleThis, this.description("shuffleThis"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::binarySearch, this.description("binarySearch"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toReversed, this.description("toReversed"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachInBoth, this.description("forEachInBoth"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithIndex, this.description("selectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWithIndexWithTarget, this.description("selectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWithIndex, this.description("rejectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWithIndexWithTarget, this.description("rejectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithIndex, this.description("collectWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWithIndexWithTarget, this.description("collectWithIndexWithTarget"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEquals, this.description("testEquals"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::distinct, this.description("distinct"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toImmutable, this.description("toImmutable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoWithIndex, this.description("injectIntoWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipShort, this.description("zipShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractShortListTestCase implementation();
    }
}
