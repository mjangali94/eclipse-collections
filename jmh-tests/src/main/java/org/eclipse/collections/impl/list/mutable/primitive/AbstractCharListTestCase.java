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

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.CharList;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableCharList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractCharListTestCase extends AbstractMutableCharCollectionTestCase {

    private static final CharList SORTED_LONGER_LIST = CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11, (char) 12, (char) 13, (char) 14, (char) 15, (char) 16, (char) 17, (char) 18, (char) 19, (char) 20);

    private static final CharList SORTED_SHORTER_LIST = CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5);

    @Override
    protected abstract MutableCharList classUnderTest();

    @Override
    protected abstract MutableCharList newWith(char... elements);

    @Override
    protected MutableCharList newMutableCollectionWith(char... elements) {
        return CharArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Character> newObjectCollectionWith(Character... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableCharList list = this.classUnderTest();
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
        MutableCharList singleItemList = this.newWith((char) 1);
        Assert.assertEquals(1L, singleItemList.getFirst());
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableCharList singleItemList = this.newWith((char) 1);
        Assert.assertEquals(1L, singleItemList.getLast());
        Assert.assertEquals(3L, this.classUnderTest().getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableCharList arrayList = this.newWith((char) 1, (char) 2, (char) 1);
        Assert.assertEquals(0L, arrayList.indexOf((char) 1));
        Assert.assertEquals(1L, arrayList.indexOf((char) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((char) 9));
    }

    @Test
    public void lastIndexOf() {
        MutableCharList arrayList = this.newWith((char) 1, (char) 2, (char) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((char) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((char) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((char) 9));
    }

    @Test
    public void addAtIndex() {
        MutableCharList emptyList = this.newWith();
        emptyList.addAtIndex(0, (char) 1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), emptyList);
        MutableCharList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, (char) 4);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4), arrayList);
        arrayList.addAtIndex(2, (char) 5);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 5, (char) 3, (char) 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, (char) 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, (char) 4);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableCharList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll((char) 4, (char) 5, (char) 6));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, (char) 5, (char) 6));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 5, (char) 6), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableCharList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
        Assert.assertTrue(list.addAll(CharArrayStack.newStackWith((char) 8, (char) 7)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, CharArrayList.newListWith((char) 5, (char) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 5, (char) 6, (char) 7, (char) 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, (char) 5, (char) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, (char) 5, (char) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Test
    public void removeAtIndex() {
        MutableCharList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3), list);
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
        MutableCharList list = this.classUnderTest();
        list.set(1, (char) 4);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 4, (char) 3), list);
    }

    @Test
    public void swap() {
        MutableCharList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3, (char) 2), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3, (char) 2), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void charIterator() {
        CharIterator iterator = this.classUnderTest().charIterator();
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
        Assert.assertArrayEquals(new char[] { (char) 1, (char) 2, (char) 4, (char) 3 }, this.newWith((char) 1, (char) 2, (char) 4, (char) 3).toArray());
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new CharArrayList(), this.newWith().reverseThis());
        MutableCharList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3), this.newWith((char) 3).reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1), this.newWith((char) 1, (char) 3).reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7), this.newWith((char) 7, (char) 9, (char) 1, (char) 3).reverseThis());
        MutableCharList sameList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8), this.newWith((char) 8, (char) 7, (char) 9, (char) 1, (char) 3).reverseThis());
        MutableCharList list1 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(list1.reverseThis(), CharArrayList.newListWith((char) 3, (char) 2, (char) 1));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new CharArrayList(), this.newWith().sortThis());
        MutableCharList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3), this.newWith((char) 3).sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 3), this.newWith((char) 3, (char) 1).sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 3, (char) 7, (char) 9), this.newWith((char) 3, (char) 1, (char) 9, (char) 7).sortThis());
        MutableCharList sameList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 3, (char) 7, (char) 8, (char) 9), this.newWith((char) 8, (char) 1, (char) 7, (char) 3, (char) 9).sortThis());
        MutableCharList list = this.newWith();
        list.add((char) 2);
        list.add((char) 1);
        list.sortThis();
        Assert.assertEquals((char) 1, list.get(0));
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableCharList index = this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(CharArrayList.newListWith((char) 4, (char) 0, (char) 3, (char) 1, (char) 2), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableCharList index = this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 2, (char) 4, (char) 6, (char) 8, (char) 1, (char) 3, (char) 5, (char) 7, (char) 9), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableCharList index = this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 0, (char) 4, (char) 3), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableCharList index = this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 4, (char) 0, (char) 2, (char) 1), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 3, (char) 4), this.newMutableCollectionWith((char) 3, (char) 2, (char) 1, (char) 0, (char) 1, (char) 4).sortThis(Character::compare));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 2, (char) 2, (char) 3, (char) 4, (char) 6, (char) 7, (char) 8, (char) 10, (char) 11, (char) 12, (char) 13, (char) 14, (char) 15, (char) 15, (char) 15, (char) 17, (char) 18, (char) 19), this.newMutableCollectionWith((char) 17, (char) 1, (char) 15, (char) 12, (char) 10, (char) 4, (char) 2, (char) 19, (char) 2, (char) 8, (char) 18, (char) 15, (char) 15, (char) 13, (char) 3, (char) 11, (char) 7, (char) 2, (char) 14, (char) 6).sortThis(Character::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((char) 3, (char) 2, (char) 1, (char) 0, (char) 5, (char) 4).sortThis(Character::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((char) 3, (char) 0, (char) 1, (char) 2, (char) 5, (char) 4).sortThis(Character::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((char) 17, (char) 1, (char) 16, (char) 12, (char) 10, (char) 4, (char) 2, (char) 19, (char) 5, (char) 8, (char) 18, (char) 15, (char) 20, (char) 13, (char) 3, (char) 11, (char) 7, (char) 9, (char) 14, (char) 6).sortThis(Character::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((char) 12, (char) 3, (char) 17, (char) 20, (char) 5, (char) 2, (char) 4, (char) 9, (char) 16, (char) 19, (char) 10, (char) 14, (char) 6, (char) 7, (char) 15, (char) 11, (char) 13, (char) 18, (char) 8, (char) 1).sortThis(Character::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5).sortThis(Character::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11, (char) 12, (char) 13, (char) 14, (char) 15, (char) 16, (char) 17, (char) 18, (char) 19, (char) 20).sortThis(Character::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((char) 5, (char) 4, (char) 3, (char) 2, (char) 1, (char) 0).sortThis(Character::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((char) 20, (char) 19, (char) 18, (char) 17, (char) 16, (char) 15, (char) 14, (char) 13, (char) 12, (char) 11, (char) 10, (char) 9, (char) 8, (char) 7, (char) 6, (char) 5, (char) 4, (char) 3, (char) 2, (char) 1).sortThis(Character::compare));
    }

    @Test
    public void shuffleThis() {
        CharList checkList = this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11, (char) 12, (char) 13, (char) 14, (char) 15).toImmutable();
        MutableCharList list = checkList.toList();
        CharList shuffleOne = list.shuffleThis().toImmutable();
        CharList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableCharList list = this.newWith((char) 2, (char) 3, (char) 5, (char) 6, (char) 9);
        Assert.assertEquals(-1, list.binarySearch((char) 1));
        Assert.assertEquals(0, list.binarySearch((char) 2));
        Assert.assertEquals(1, list.binarySearch((char) 3));
        Assert.assertEquals(-3, list.binarySearch((char) 4));
        Assert.assertEquals(2, list.binarySearch((char) 5));
        Assert.assertEquals(3, list.binarySearch((char) 6));
        Assert.assertEquals(-5, list.binarySearch((char) 7));
        Assert.assertEquals(-5, list.binarySearch((char) 8));
        Assert.assertEquals(4, list.binarySearch((char) 9));
        Assert.assertEquals(-6, list.binarySearch((char) 10));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new CharArrayList(), this.newWith().toReversed());
        MutableCharList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7), this.newWith((char) 7, (char) 9, (char) 1, (char) 3).toReversed());
        MutableCharList evenList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8), this.newWith((char) 8, (char) 7, (char) 9, (char) 1, (char) 3).toReversed());
        MutableCharList oddList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((char each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableCharList list1 = this.newWith((char) 3, (char) 1);
        MutableCharList list2 = this.newWith((char) 7, (char) 9);
        MutableList<CharCharPair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<CharCharPair> expected = Lists.mutable.with(PrimitiveTuples.pair((char) 3, (char) 7), PrimitiveTuples.pair((char) 1, (char) 9));
        Assert.assertEquals(expected, result);
        MutableCharList list3 = this.newWith((char) 7, (char) 9, (char) 1);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        MutableCharList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        MutableCharList selected = list.selectWithIndex((value, i) -> i % 2 == 0, CharLists.mutable.empty());
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        MutableCharList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(CharLists.mutable.with((char) 1, (char) 7), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableCharList list = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        MutableCharList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, CharLists.mutable.empty());
        Assert.assertEquals(CharLists.mutable.with((char) 1, (char) 7), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 1, (char) 9, (char) 7), pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(CharIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(CharSets.mutable.with((char) 3, (char) 1, (char) 9, (char) 7), pairs.collectChar(CharIntPair::getOne, CharSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(CharLists.mutable.with((char) 3, (char) 1, (char) 9, (char) 7), pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        MutableCharList list2 = this.newWith((char) 4, (char) 3, (char) 2, (char) 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.classUnderTest().toString());
    }

    @Test
    public void distinct() {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3, (char) 4, (char) 4, (char) 4, (char) 4).distinct();
        MutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        Assert.assertEquals(list1, list2);
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("\u0001, \u0002, \u0003", this.classUnderTest().makeString());
        Assert.assertEquals("\u0001/\u0002/\u0003", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableCharList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        CharArrayList arrayList = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = arrayList.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = list1.injectIntoWithIndex(new MutableCharacter((char) 0), (MutableCharacter object, char value, int index) -> object.add((char) (value * list2.get(index))));
        Assert.assertEquals(new MutableCharacter((char) 14), result);
    }

    @Test
    public void zipChar() {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2);
        MutableList<CharCharPair> zipSame = list1.zipChar(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2), PrimitiveTuples.pair((char) 3, (char) 3)), zipSame);
        MutableList<CharCharPair> zipSameLazy = list1.zipChar(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2), PrimitiveTuples.pair((char) 3, (char) 3)), zipSameLazy);
        MutableList<CharCharPair> zipLess = list1.zipChar(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2)), zipLess);
        MutableList<CharCharPair> zipLessLazy = list1.zipChar(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2)), zipLessLazy);
        MutableList<CharCharPair> zipMore = list2.zipChar(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2)), zipMore);
        MutableList<CharCharPair> zipMoreLazy = list2.zipChar(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, (char) 1), PrimitiveTuples.pair((char) 2, (char) 2)), zipMoreLazy);
        MutableList<CharCharPair> zipEmpty = list1.zipChar(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<CharObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2"), PrimitiveTuples.pair((char) 3, "3")), zipSame);
        MutableList<CharObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2"), PrimitiveTuples.pair((char) 3, "3")), zipSameLazy);
        MutableList<CharObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2")), zipLess);
        MutableList<CharObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2")), zipLessLazy);
        MutableList<CharObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2")), zipMore);
        MutableList<CharObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((char) 1, "1"), PrimitiveTuples.pair((char) 2, "2")), zipMoreLazy);
        MutableList<CharObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractCharListTestCase instance;

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
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_zipChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractCharListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> zipChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractCharListTestCase> zip;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractCharListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractCharListTestCase::newCollection;
            this.payloads.isEmpty = AbstractCharListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractCharListTestCase::notEmpty;
            this.payloads.tap = AbstractCharListTestCase::tap;
            this.payloads.containsAllArray = AbstractCharListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractCharListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractCharListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractCharListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractCharListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractCharListTestCase::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractCharListTestCase::forEach;
            this.payloads.size = AbstractCharListTestCase::size;
            this.payloads.count = AbstractCharListTestCase::count;
            this.payloads.anySatisfy = AbstractCharListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractCharListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractCharListTestCase::noneSatisfy;
            this.payloads.collect = AbstractCharListTestCase::collect;
            this.payloads.collectWithTarget = AbstractCharListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractCharListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractCharListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractCharListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractCharListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractCharListTestCase::select;
            this.payloads.selectWithTarget = AbstractCharListTestCase::selectWithTarget;
            this.payloads.reject = AbstractCharListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractCharListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractCharListTestCase::detectIfNone;
            this.payloads.max = AbstractCharListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractCharListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractCharListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractCharListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractCharListTestCase::sum;
            this.payloads.summaryStatistics = AbstractCharListTestCase::summaryStatistics;
            this.payloads.average = AbstractCharListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractCharListTestCase::averageIfEmpty;
            this.payloads.median = AbstractCharListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractCharListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractCharListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractCharListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractCharListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractCharListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractCharListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractCharListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractCharListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractCharListTestCase::toSet;
            this.payloads.toBag = AbstractCharListTestCase::toBag;
            this.payloads.asLazy = AbstractCharListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractCharListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractCharListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractCharListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractCharListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractCharListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractCharListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractCharListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractCharListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractCharListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractCharListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractCharListTestCase::chunk;
            this.payloads.clear = AbstractCharListTestCase::clear;
            this.payloads.contains = AbstractCharListTestCase::contains;
            this.payloads.add = AbstractCharListTestCase::add;
            this.payloads.remove = AbstractCharListTestCase::remove;
            this.payloads.removeIf = AbstractCharListTestCase::removeIf;
            this.payloads.removeAll = AbstractCharListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractCharListTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractCharListTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractCharListTestCase::retainAll_iterable;
            this.payloads.with = AbstractCharListTestCase::with;
            this.payloads.withAll = AbstractCharListTestCase::withAll;
            this.payloads.without = AbstractCharListTestCase::without;
            this.payloads.withoutAll = AbstractCharListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractCharListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractCharListTestCase::asUnmodifiable;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = AbstractCharListTestCase::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = AbstractCharListTestCase::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = AbstractCharListTestCase::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractCharListTestCase::newEmpty;
            this.payloads.get = AbstractCharListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractCharListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractCharListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = AbstractCharListTestCase::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = AbstractCharListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractCharListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractCharListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractCharListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractCharListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = AbstractCharListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractCharListTestCase::set;
            this.payloads.swap = AbstractCharListTestCase::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractCharListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.charIterator = AbstractCharListTestCase::charIterator;
            this.payloads.toArray = AbstractCharListTestCase::toArray;
            this.payloads.reverseThis = AbstractCharListTestCase::reverseThis;
            this.payloads.sortThis = AbstractCharListTestCase::sortThis;
            this.payloads.sortWithPrimitiveComparator = AbstractCharListTestCase::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = AbstractCharListTestCase::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = AbstractCharListTestCase::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = AbstractCharListTestCase::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = AbstractCharListTestCase::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = AbstractCharListTestCase::sortShuffledInput;
            this.payloads.sortSortedInput = AbstractCharListTestCase::sortSortedInput;
            this.payloads.sortReversedSortedInput = AbstractCharListTestCase::sortReversedSortedInput;
            this.payloads.shuffleThis = AbstractCharListTestCase::shuffleThis;
            this.payloads.binarySearch = AbstractCharListTestCase::binarySearch;
            this.payloads.toReversed = AbstractCharListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractCharListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractCharListTestCase::forEachInBoth;
            this.payloads.selectWithIndex = AbstractCharListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractCharListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractCharListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractCharListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractCharListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractCharListTestCase::collectWithIndexWithTarget;
            this.payloads.testEquals = AbstractCharListTestCase::testEquals;
            this.payloads.testToString = AbstractCharListTestCase::testToString;
            this.payloads.distinct = AbstractCharListTestCase::distinct;
            this.payloads.makeString = AbstractCharListTestCase::makeString;
            this.payloads.appendString = AbstractCharListTestCase::appendString;
            this.payloads.toList = AbstractCharListTestCase::toList;
            this.payloads.toImmutable = AbstractCharListTestCase::toImmutable;
            this.payloads.injectInto = AbstractCharListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractCharListTestCase::injectIntoWithIndex;
            this.payloads.zipChar = AbstractCharListTestCase::zipChar;
            this.payloads.zip = AbstractCharListTestCase::zip;
        }
    }
}
