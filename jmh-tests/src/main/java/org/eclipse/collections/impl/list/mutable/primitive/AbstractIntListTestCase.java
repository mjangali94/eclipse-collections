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

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.tuple.primitive.IntObjectPair;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Abstract JUnit test for {@link MutableIntList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractIntListTestCase extends AbstractMutableIntCollectionTestCase {

    private static final IntList SORTED_LONGER_LIST = IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

    private static final IntList SORTED_SHORTER_LIST = IntArrayList.newListWith(0, 1, 2, 3, 4, 5);

    @Override
    protected abstract MutableIntList classUnderTest();

    @Override
    protected abstract MutableIntList newWith(int... elements);

    @Override
    protected MutableIntList newMutableCollectionWith(int... elements) {
        return IntArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Integer> newObjectCollectionWith(Integer... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableIntList list = this.classUnderTest();
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
        MutableIntList singleItemList = this.newWith(1);
        Assert.assertEquals(1L, singleItemList.getFirst());
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableIntList singleItemList = this.newWith(1);
        Assert.assertEquals(1L, singleItemList.getLast());
        Assert.assertEquals(3L, this.classUnderTest().getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2, 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableIntList arrayList = this.newWith(1, 2, 1);
        Assert.assertEquals(0L, arrayList.indexOf(1));
        Assert.assertEquals(1L, arrayList.indexOf(2));
        Assert.assertEquals(-1L, arrayList.indexOf(9));
    }

    @Test
    public void lastIndexOf() {
        MutableIntList arrayList = this.newWith(1, 2, 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9));
    }

    @Test
    public void addAtIndex() {
        MutableIntList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1);
        Assert.assertEquals(this.newMutableCollectionWith(1), emptyList);
        MutableIntList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4), arrayList);
        arrayList.addAtIndex(2, 5);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 5, 3, 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, 4);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableIntList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4, 5, 6));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5, 6));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 5, 6), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableIntList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(IntArrayList.newListWith(4, 5, 6)));
        Assert.assertTrue(list.addAll(IntArrayStack.newStackWith(8, 7)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 7, 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, IntArrayList.newListWith(5, 6)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 5, 6, 7, 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, 5, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, 5, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, IntArrayList.newListWith(1, 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, IntArrayList.newListWith(1, 2));
    }

    @Test
    public void removeAtIndex() {
        MutableIntList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1, 3), list);
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
        MutableIntList list = this.classUnderTest();
        list.set(1, 4);
        Assert.assertEquals(this.newMutableCollectionWith(1, 4, 3), list);
    }

    @Test
    public void swap() {
        MutableIntList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith(1, 3, 2), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith(1, 3, 2), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void intIterator() {
        IntIterator iterator = this.classUnderTest().intIterator();
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
        Assert.assertArrayEquals(new int[] { 1, 2, 4, 3 }, this.newWith(1, 2, 4, 3).toArray());
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new IntArrayList(), this.newWith().reverseThis());
        MutableIntList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3), this.newWith(3).reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3, 1), this.newWith(1, 3).reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7), this.newWith(7, 9, 1, 3).reverseThis());
        MutableIntList sameList = this.newWith(3, 1, 9, 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7, 8), this.newWith(8, 7, 9, 1, 3).reverseThis());
        MutableIntList list1 = IntArrayList.newListWith(1, 2, 3, 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, IntArrayList.newListWith(1, 2, 3));
        Assert.assertEquals(list1.reverseThis(), IntArrayList.newListWith(3, 2, 1));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new IntArrayList(), this.newWith().sortThis());
        MutableIntList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(IntArrayList.newListWith(3), this.newWith(3).sortThis());
        Assert.assertEquals(IntArrayList.newListWith(1, 3), this.newWith(3, 1).sortThis());
        Assert.assertEquals(IntArrayList.newListWith(1, 3, 7, 9), this.newWith(3, 1, 9, 7).sortThis());
        MutableIntList sameList = this.newWith(3, 1, 9, 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(IntArrayList.newListWith(1, 3, 7, 8, 9), this.newWith(8, 1, 7, 3, 9).sortThis());
        MutableIntList list = this.newWith();
        list.add(2);
        list.add(1);
        list.sortThis();
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableIntList index = this.newMutableCollectionWith(0, 1, 2, 3, 4);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(IntArrayList.newListWith(4, 0, 3, 1, 2), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableIntList index = this.newMutableCollectionWith(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(IntArrayList.newListWith(0, 2, 4, 6, 8, 1, 3, 5, 7, 9), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableIntList index = this.newMutableCollectionWith(0, 1, 2, 3, 4);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 0, 4, 3), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableIntList index = this.newMutableCollectionWith(0, 1, 2, 3, 4);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(IntArrayList.newListWith(3, 4, 0, 2, 1), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 1, 2, 3, 4), this.newMutableCollectionWith(3, 2, 1, 0, 1, 4).sortThis(Integer::compare));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 2, 2, 3, 4, 6, 7, 8, 10, 11, 12, 13, 14, 15, 15, 15, 17, 18, 19), this.newMutableCollectionWith(17, 1, 15, 12, 10, 4, 2, 19, 2, 8, 18, 15, 15, 13, 3, 11, 7, 2, 14, 6).sortThis(Integer::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3, 2, 1, 0, 5, 4).sortThis(Integer::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3, 0, 1, 2, 5, 4).sortThis(Integer::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(17, 1, 16, 12, 10, 4, 2, 19, 5, 8, 18, 15, 20, 13, 3, 11, 7, 9, 14, 6).sortThis(Integer::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(12, 3, 17, 20, 5, 2, 4, 9, 16, 19, 10, 14, 6, 7, 15, 11, 13, 18, 8, 1).sortThis(Integer::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(0, 1, 2, 3, 4, 5).sortThis(Integer::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20).sortThis(Integer::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(5, 4, 3, 2, 1, 0).sortThis(Integer::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1).sortThis(Integer::compare));
    }

    @Test
    public void shuffleThis() {
        IntList checkList = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).toImmutable();
        MutableIntList list = checkList.toList();
        IntList shuffleOne = list.shuffleThis().toImmutable();
        IntList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableIntList list = this.newWith(2, 3, 5, 6, 9);
        Assert.assertEquals(-1, list.binarySearch(1));
        Assert.assertEquals(0, list.binarySearch(2));
        Assert.assertEquals(1, list.binarySearch(3));
        Assert.assertEquals(-3, list.binarySearch(4));
        Assert.assertEquals(2, list.binarySearch(5));
        Assert.assertEquals(3, list.binarySearch(6));
        Assert.assertEquals(-5, list.binarySearch(7));
        Assert.assertEquals(-5, list.binarySearch(8));
        Assert.assertEquals(4, list.binarySearch(9));
        Assert.assertEquals(-6, list.binarySearch(10));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new IntArrayList(), this.newWith().toReversed());
        MutableIntList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7), this.newWith(7, 9, 1, 3).toReversed());
        MutableIntList evenList = this.newWith(3, 1, 9, 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7, 8), this.newWith(8, 7, 9, 1, 3).toReversed());
        MutableIntList oddList = this.newWith(3, 1, 9, 7, 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((int each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableIntList list1 = this.newWith(3, 1);
        MutableIntList list2 = this.newWith(7, 9);
        MutableList<IntIntPair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<IntIntPair> expected = Lists.mutable.with(PrimitiveTuples.pair(3, 7), PrimitiveTuples.pair(1, 9));
        Assert.assertEquals(expected, result);
        MutableIntList list3 = this.newWith(7, 9, 1);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableIntList list = this.newWith(3, 1, 9, 7);
        MutableIntList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(IntLists.mutable.with(3, 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableIntList list = this.newWith(3, 1, 9, 7);
        MutableIntList selected = list.selectWithIndex((value, i) -> i % 2 == 0, IntLists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(3, 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableIntList list = this.newWith(3, 1, 9, 7);
        MutableIntList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(IntLists.mutable.with(1, 7), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableIntList list = this.newWith(3, 1, 9, 7);
        MutableIntList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, IntLists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(1, 7), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<IntIntPair> pairs = this.newWith(3, 1, 9, 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(IntIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(IntLists.mutable.with(3, 1, 9, 7), pairs.collectInt(IntIntPair::getOne, IntLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(IntIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(3, 1, 9, 7), pairs.collectInt(IntIntPair::getOne, IntSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<IntIntPair> pairs = this.newWith(3, 1, 9, 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(IntIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(IntLists.mutable.with(3, 1, 9, 7), pairs.collectInt(IntIntPair::getOne, IntLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableIntList list1 = this.newWith(1, 2, 3, 4);
        MutableIntList list2 = this.newWith(4, 3, 2, 1);
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
        MutableIntList list1 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).distinct();
        MutableIntList list2 = this.newWith(1, 2, 3, 4);
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
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableIntList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        IntArrayList arrayList = IntArrayList.newListWith(1, 2, 3);
        MutableInteger result = arrayList.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2, 3);
        MutableInteger result = list1.injectIntoWithIndex(new MutableInteger(0), (MutableInteger object, int value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableInteger(14), result);
    }

    @Test
    public void zipInt() {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2);
        MutableList<IntIntPair> zipSame = list1.zipInt(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3)), zipSame);
        MutableList<IntIntPair> zipSameLazy = list1.zipInt(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3)), zipSameLazy);
        MutableList<IntIntPair> zipLess = list1.zipInt(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2)), zipLess);
        MutableList<IntIntPair> zipLessLazy = list1.zipInt(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2)), zipLessLazy);
        MutableList<IntIntPair> zipMore = list2.zipInt(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2)), zipMore);
        MutableList<IntIntPair> zipMoreLazy = list2.zipInt(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2)), zipMoreLazy);
        MutableList<IntIntPair> zipEmpty = list1.zipInt(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<IntObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, "1"), PrimitiveTuples.pair(2, "2"), PrimitiveTuples.pair(3, "3")), zipSame);
        MutableList<IntObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, "1"), PrimitiveTuples.pair(2, "2"), PrimitiveTuples.pair(3, "3")), zipSameLazy);
        MutableList<IntObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, "1"), PrimitiveTuples.pair(2, "2")), zipLess);
        MutableList<IntObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, "1"), PrimitiveTuples.pair(2, "2")), zipLessLazy);
        MutableList<IntObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, "1"), PrimitiveTuples.pair(2, "2")), zipMore);
        MutableList<IntObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1, "1"), PrimitiveTuples.pair(2, "2")), zipMoreLazy);
        MutableList<IntObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void stream() {
        Assert.assertEquals(Arrays.asList(1, 2, 3), IntArrayList.newListWith(1, 2, 3).primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1, 2, 3), IntArrayList.newListWith(1, 2, 3).asSynchronized().primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1, 2, 3), IntArrayList.newListWith(1, 2, 3).asUnmodifiable().primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void parallelStream() {
        Assert.assertEquals(Arrays.asList(1, 2, 3), IntArrayList.newListWith(1, 2, 3).primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1, 2, 3), IntArrayList.newListWith(1, 2, 3).asSynchronized().primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1, 2, 3), IntArrayList.newListWith(1, 2, 3).asUnmodifiable().primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase._Benchmark {

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator, this.description("intIterator"));
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
        public void benchmark_zipInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipInt, this.description("zipInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::stream, this.description("stream"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::parallelStream, this.description("parallelStream"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractIntListTestCase implementation();
    }
}
