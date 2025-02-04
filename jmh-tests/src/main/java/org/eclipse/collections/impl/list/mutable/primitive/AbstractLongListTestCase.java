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

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.LongList;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Abstract JUnit test for {@link MutableLongList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractLongListTestCase extends AbstractMutableLongCollectionTestCase {

    private static final LongList SORTED_LONGER_LIST = LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L);

    private static final LongList SORTED_SHORTER_LIST = LongArrayList.newListWith(0L, 1L, 2L, 3L, 4L, 5L);

    @Override
    protected abstract MutableLongList classUnderTest();

    @Override
    protected abstract MutableLongList newWith(long... elements);

    @Override
    protected MutableLongList newMutableCollectionWith(long... elements) {
        return LongArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Long> newObjectCollectionWith(Long... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableLongList list = this.classUnderTest();
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
        MutableLongList singleItemList = this.newWith(1L);
        Assert.assertEquals(1L, singleItemList.getFirst());
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableLongList singleItemList = this.newWith(1L);
        Assert.assertEquals(1L, singleItemList.getLast());
        Assert.assertEquals(3L, this.classUnderTest().getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L, 3L);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableLongList arrayList = this.newWith(1L, 2L, 1L);
        Assert.assertEquals(0L, arrayList.indexOf(1L));
        Assert.assertEquals(1L, arrayList.indexOf(2L));
        Assert.assertEquals(-1L, arrayList.indexOf(9L));
    }

    @Test
    public void lastIndexOf() {
        MutableLongList arrayList = this.newWith(1L, 2L, 1L);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1L));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2L));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9L));
    }

    @Test
    public void addAtIndex() {
        MutableLongList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1L);
        Assert.assertEquals(this.newMutableCollectionWith(1L), emptyList);
        MutableLongList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4L);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L), arrayList);
        arrayList.addAtIndex(2, 5L);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 5L, 3L, 4L), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, 0L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, 4L);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableLongList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4L, 5L, 6L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5L, 6L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 5L, 6L), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableLongList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(LongArrayList.newListWith(4L, 5L, 6L)));
        Assert.assertTrue(list.addAll(LongArrayStack.newStackWith(8L, 7L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), list);
        Assert.assertTrue(list.addAllAtIndex(4, LongArrayList.newListWith(5L, 6L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 5L, 6L, 7L, 8L), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, 5L, 6L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, 5L, 6L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, LongArrayList.newListWith(1L, 2L));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, LongArrayList.newListWith(1L, 2L));
    }

    @Test
    public void removeAtIndex() {
        MutableLongList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L), list);
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
        MutableLongList list = this.classUnderTest();
        list.set(1, 4L);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 4L, 3L), list);
    }

    @Test
    public void swap() {
        MutableLongList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L, 2L), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L, 2L), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void longIterator() {
        LongIterator iterator = this.classUnderTest().longIterator();
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
        Assert.assertArrayEquals(new long[] { 1L, 2L, 4L, 3L }, this.newWith(1L, 2L, 4L, 3L).toArray());
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new LongArrayList(), this.newWith().reverseThis());
        MutableLongList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L), this.newWith(3L).reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L), this.newWith(1L, 3L).reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L), this.newWith(7L, 9L, 1L, 3L).reverseThis());
        MutableLongList sameList = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L, 8L), this.newWith(8L, 7L, 9L, 1L, 3L).reverseThis());
        MutableLongList list1 = LongArrayList.newListWith(1L, 2L, 3L, 4L);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, LongArrayList.newListWith(1L, 2L, 3L));
        Assert.assertEquals(list1.reverseThis(), LongArrayList.newListWith(3L, 2L, 1L));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new LongArrayList(), this.newWith().sortThis());
        MutableLongList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(LongArrayList.newListWith(3L), this.newWith(3L).sortThis());
        Assert.assertEquals(LongArrayList.newListWith(1L, 3L), this.newWith(3L, 1L).sortThis());
        Assert.assertEquals(LongArrayList.newListWith(1L, 3L, 7L, 9L), this.newWith(3L, 1L, 9L, 7L).sortThis());
        MutableLongList sameList = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(LongArrayList.newListWith(1L, 3L, 7L, 8L, 9L), this.newWith(8L, 1L, 7L, 3L, 9L).sortThis());
        MutableLongList list = this.newWith();
        list.add(2L);
        list.add(1L);
        list.sortThis();
        Assert.assertEquals(1L, list.get(0));
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableLongList index = this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(LongArrayList.newListWith(4L, 0L, 3L, 1L, 2L), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableLongList index = this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(LongArrayList.newListWith(0L, 2L, 4L, 6L, 8L, 1L, 3L, 5L, 7L, 9L), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableLongList index = this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 0L, 4L, 3L), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableLongList index = this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(LongArrayList.newListWith(3L, 4L, 0L, 2L, 1L), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 1L, 2L, 3L, 4L), this.newMutableCollectionWith(3L, 2L, 1L, 0L, 1L, 4L).sortThis(Long::compare));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 2L, 2L, 3L, 4L, 6L, 7L, 8L, 10L, 11L, 12L, 13L, 14L, 15L, 15L, 15L, 17L, 18L, 19L), this.newMutableCollectionWith(17L, 1L, 15L, 12L, 10L, 4L, 2L, 19L, 2L, 8L, 18L, 15L, 15L, 13L, 3L, 11L, 7L, 2L, 14L, 6L).sortThis(Long::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3L, 2L, 1L, 0L, 5L, 4L).sortThis(Long::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3L, 0L, 1L, 2L, 5L, 4L).sortThis(Long::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(17L, 1L, 16L, 12L, 10L, 4L, 2L, 19L, 5L, 8L, 18L, 15L, 20L, 13L, 3L, 11L, 7L, 9L, 14L, 6L).sortThis(Long::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(12L, 3L, 17L, 20L, 5L, 2L, 4L, 9L, 16L, 19L, 10L, 14L, 6L, 7L, 15L, 11L, 13L, 18L, 8L, 1L).sortThis(Long::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(0L, 1L, 2L, 3L, 4L, 5L).sortThis(Long::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L).sortThis(Long::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(5L, 4L, 3L, 2L, 1L, 0L).sortThis(Long::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(20L, 19L, 18L, 17L, 16L, 15L, 14L, 13L, 12L, 11L, 10L, 9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L).sortThis(Long::compare));
    }

    @Test
    public void shuffleThis() {
        LongList checkList = this.newWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L).toImmutable();
        MutableLongList list = checkList.toList();
        LongList shuffleOne = list.shuffleThis().toImmutable();
        LongList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableLongList list = this.newWith(2L, 3L, 5L, 6L, 9L);
        Assert.assertEquals(-1, list.binarySearch(1L));
        Assert.assertEquals(0, list.binarySearch(2L));
        Assert.assertEquals(1, list.binarySearch(3L));
        Assert.assertEquals(-3, list.binarySearch(4L));
        Assert.assertEquals(2, list.binarySearch(5L));
        Assert.assertEquals(3, list.binarySearch(6L));
        Assert.assertEquals(-5, list.binarySearch(7L));
        Assert.assertEquals(-5, list.binarySearch(8L));
        Assert.assertEquals(4, list.binarySearch(9L));
        Assert.assertEquals(-6, list.binarySearch(10L));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new LongArrayList(), this.newWith().toReversed());
        MutableLongList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L), this.newWith(7L, 9L, 1L, 3L).toReversed());
        MutableLongList evenList = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L, 8L), this.newWith(8L, 7L, 9L, 1L, 3L).toReversed());
        MutableLongList oddList = this.newWith(3L, 1L, 9L, 7L, 8L);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((long each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableLongList list1 = this.newWith(3L, 1L);
        MutableLongList list2 = this.newWith(7L, 9L);
        MutableList<LongLongPair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<LongLongPair> expected = Lists.mutable.with(PrimitiveTuples.pair(3L, 7L), PrimitiveTuples.pair(1L, 9L));
        Assert.assertEquals(expected, result);
        MutableLongList list3 = this.newWith(7L, 9L, 1L);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        MutableLongList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(LongLists.mutable.with(3L, 9L), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        MutableLongList selected = list.selectWithIndex((value, i) -> i % 2 == 0, LongLists.mutable.empty());
        Assert.assertEquals(LongLists.mutable.with(3L, 9L), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        MutableLongList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(LongLists.mutable.with(1L, 7L), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableLongList list = this.newWith(3L, 1L, 9L, 7L);
        MutableLongList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, LongLists.mutable.empty());
        Assert.assertEquals(LongLists.mutable.with(1L, 7L), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(LongLists.mutable.with(3L, 1L, 9L, 7L), pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(LongIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(LongSets.mutable.with(3L, 1L, 9L, 7L), pairs.collectLong(LongIntPair::getOne, LongSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(LongLists.mutable.with(3L, 1L, 9L, 7L), pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableLongList list1 = this.newWith(1L, 2L, 3L, 4L);
        MutableLongList list2 = this.newWith(4L, 3L, 2L, 1L);
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
        MutableLongList list1 = this.newWith(1L, 2L, 2L, 3L, 3L, 3L, 4L, 4L, 4L, 4L).distinct();
        MutableLongList list2 = this.newWith(1L, 2L, 3L, 4L);
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
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableLongList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        LongArrayList arrayList = LongArrayList.newListWith(1L, 2L, 3L);
        MutableLong result = arrayList.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L, 3L);
        MutableLong result = list1.injectIntoWithIndex(new MutableLong(0L), (MutableLong object, long value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableLong(14L), result);
    }

    @Test
    public void zipLong() {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L);
        MutableList<LongLongPair> zipSame = list1.zipLong(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L), PrimitiveTuples.pair(3L, 3L)), zipSame);
        MutableList<LongLongPair> zipSameLazy = list1.zipLong(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L), PrimitiveTuples.pair(3L, 3L)), zipSameLazy);
        MutableList<LongLongPair> zipLess = list1.zipLong(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L)), zipLess);
        MutableList<LongLongPair> zipLessLazy = list1.zipLong(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L)), zipLessLazy);
        MutableList<LongLongPair> zipMore = list2.zipLong(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L)), zipMore);
        MutableList<LongLongPair> zipMoreLazy = list2.zipLong(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L)), zipMoreLazy);
        MutableList<LongLongPair> zipEmpty = list1.zipLong(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<LongObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2"), PrimitiveTuples.pair(3L, "3")), zipSame);
        MutableList<LongObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2"), PrimitiveTuples.pair(3L, "3")), zipSameLazy);
        MutableList<LongObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2")), zipLess);
        MutableList<LongObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2")), zipLessLazy);
        MutableList<LongObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2")), zipMore);
        MutableList<LongObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1L, "1"), PrimitiveTuples.pair(2L, "2")), zipMoreLazy);
        MutableList<LongObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void stream() {
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), LongArrayList.newListWith(1L, 2L, 3L).primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), LongArrayList.newListWith(1L, 2L, 3L).asSynchronized().primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), LongArrayList.newListWith(1L, 2L, 3L).asUnmodifiable().primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void parallelStream() {
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), LongArrayList.newListWith(1L, 2L, 3L).primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), LongArrayList.newListWith(1L, 2L, 3L).asSynchronized().primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1L, 2L, 3L), LongArrayList.newListWith(1L, 2L, 3L).asUnmodifiable().primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongListTestCase instance;

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
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_zipLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipLong);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> zipLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongListTestCase> parallelStream;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractLongListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractLongListTestCase::newCollection;
            this.payloads.isEmpty = AbstractLongListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractLongListTestCase::notEmpty;
            this.payloads.tap = AbstractLongListTestCase::tap;
            this.payloads.containsAllArray = AbstractLongListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractLongListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractLongListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractLongListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractLongListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractLongListTestCase::containsNoneIterable;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractLongListTestCase::forEach;
            this.payloads.size = AbstractLongListTestCase::size;
            this.payloads.count = AbstractLongListTestCase::count;
            this.payloads.anySatisfy = AbstractLongListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractLongListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractLongListTestCase::noneSatisfy;
            this.payloads.collect = AbstractLongListTestCase::collect;
            this.payloads.collectWithTarget = AbstractLongListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractLongListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractLongListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractLongListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractLongListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractLongListTestCase::select;
            this.payloads.selectWithTarget = AbstractLongListTestCase::selectWithTarget;
            this.payloads.reject = AbstractLongListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractLongListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractLongListTestCase::detectIfNone;
            this.payloads.max = AbstractLongListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractLongListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractLongListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractLongListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractLongListTestCase::sum;
            this.payloads.summaryStatistics = AbstractLongListTestCase::summaryStatistics;
            this.payloads.average = AbstractLongListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractLongListTestCase::averageIfEmpty;
            this.payloads.median = AbstractLongListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractLongListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractLongListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractLongListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractLongListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractLongListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractLongListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractLongListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractLongListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractLongListTestCase::toSet;
            this.payloads.toBag = AbstractLongListTestCase::toBag;
            this.payloads.asLazy = AbstractLongListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractLongListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractLongListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractLongListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractLongListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractLongListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractLongListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractLongListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractLongListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractLongListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractLongListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractLongListTestCase::chunk;
            this.payloads.clear = AbstractLongListTestCase::clear;
            this.payloads.contains = AbstractLongListTestCase::contains;
            this.payloads.add = AbstractLongListTestCase::add;
            this.payloads.remove = AbstractLongListTestCase::remove;
            this.payloads.removeIf = AbstractLongListTestCase::removeIf;
            this.payloads.removeAll = AbstractLongListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractLongListTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractLongListTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractLongListTestCase::retainAll_iterable;
            this.payloads.with = AbstractLongListTestCase::with;
            this.payloads.withAll = AbstractLongListTestCase::withAll;
            this.payloads.without = AbstractLongListTestCase::without;
            this.payloads.withoutAll = AbstractLongListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractLongListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractLongListTestCase::asUnmodifiable;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = AbstractLongListTestCase::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = AbstractLongListTestCase::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = AbstractLongListTestCase::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractLongListTestCase::newEmpty;
            this.payloads.get = AbstractLongListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractLongListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractLongListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = AbstractLongListTestCase::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = AbstractLongListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractLongListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractLongListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractLongListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractLongListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = AbstractLongListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractLongListTestCase::set;
            this.payloads.swap = AbstractLongListTestCase::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.longIterator = AbstractLongListTestCase::longIterator;
            this.payloads.toArray = AbstractLongListTestCase::toArray;
            this.payloads.reverseThis = AbstractLongListTestCase::reverseThis;
            this.payloads.sortThis = AbstractLongListTestCase::sortThis;
            this.payloads.sortWithPrimitiveComparator = AbstractLongListTestCase::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = AbstractLongListTestCase::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = AbstractLongListTestCase::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = AbstractLongListTestCase::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = AbstractLongListTestCase::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = AbstractLongListTestCase::sortShuffledInput;
            this.payloads.sortSortedInput = AbstractLongListTestCase::sortSortedInput;
            this.payloads.sortReversedSortedInput = AbstractLongListTestCase::sortReversedSortedInput;
            this.payloads.shuffleThis = AbstractLongListTestCase::shuffleThis;
            this.payloads.binarySearch = AbstractLongListTestCase::binarySearch;
            this.payloads.toReversed = AbstractLongListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractLongListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractLongListTestCase::forEachInBoth;
            this.payloads.selectWithIndex = AbstractLongListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractLongListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractLongListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractLongListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractLongListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractLongListTestCase::collectWithIndexWithTarget;
            this.payloads.testEquals = AbstractLongListTestCase::testEquals;
            this.payloads.testToString = AbstractLongListTestCase::testToString;
            this.payloads.distinct = AbstractLongListTestCase::distinct;
            this.payloads.makeString = AbstractLongListTestCase::makeString;
            this.payloads.appendString = AbstractLongListTestCase::appendString;
            this.payloads.toList = AbstractLongListTestCase::toList;
            this.payloads.toImmutable = AbstractLongListTestCase::toImmutable;
            this.payloads.injectInto = AbstractLongListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractLongListTestCase::injectIntoWithIndex;
            this.payloads.zipLong = AbstractLongListTestCase::zipLong;
            this.payloads.zip = AbstractLongListTestCase::zip;
            this.payloads.stream = AbstractLongListTestCase::stream;
            this.payloads.parallelStream = AbstractLongListTestCase::parallelStream;
        }
    }
}
