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

import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ByteList;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.stack.mutable.primitive.ByteArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableByteList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractByteListTestCase extends AbstractMutableByteCollectionTestCase {

    private static final ByteList SORTED_LONGER_LIST = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20);

    private static final ByteList SORTED_SHORTER_LIST = ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);

    @Override
    protected abstract MutableByteList classUnderTest();

    @Override
    protected abstract MutableByteList newWith(byte... elements);

    @Override
    protected MutableByteList newMutableCollectionWith(byte... elements) {
        return ByteArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Byte> newObjectCollectionWith(Byte... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableByteList list = this.classUnderTest();
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
        MutableByteList singleItemList = this.newWith((byte) 1);
        Assert.assertEquals(1L, singleItemList.getFirst());
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableByteList singleItemList = this.newWith((byte) 1);
        Assert.assertEquals(1L, singleItemList.getLast());
        Assert.assertEquals(3L, this.classUnderTest().getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByteList list2 = this.newWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableByteList arrayList = this.newWith((byte) 1, (byte) 2, (byte) 1);
        Assert.assertEquals(0L, arrayList.indexOf((byte) 1));
        Assert.assertEquals(1L, arrayList.indexOf((byte) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((byte) 9));
    }

    @Test
    public void lastIndexOf() {
        MutableByteList arrayList = this.newWith((byte) 1, (byte) 2, (byte) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((byte) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((byte) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((byte) 9));
    }

    @Test
    public void addAtIndex() {
        MutableByteList emptyList = this.newWith();
        emptyList.addAtIndex(0, (byte) 1);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1), emptyList);
        MutableByteList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, (byte) 4);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), arrayList);
        arrayList.addAtIndex(2, (byte) 5);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 5, (byte) 3, (byte) 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, (byte) 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, (byte) 4);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableByteList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll((byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, (byte) 5, (byte) 6));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 5, (byte) 6), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableByteList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(ByteArrayList.newListWith((byte) 4, (byte) 5, (byte) 6)));
        Assert.assertTrue(list.addAll(ByteArrayStack.newStackWith((byte) 8, (byte) 7)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, ByteArrayList.newListWith((byte) 5, (byte) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 7, (byte) 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, (byte) 5, (byte) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, (byte) 5, (byte) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, ByteArrayList.newListWith((byte) 1, (byte) 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, ByteArrayList.newListWith((byte) 1, (byte) 2));
    }

    @Test
    public void removeAtIndex() {
        MutableByteList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 3), list);
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
        MutableByteList list = this.classUnderTest();
        list.set(1, (byte) 4);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 4, (byte) 3), list);
    }

    @Test
    public void swap() {
        MutableByteList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 3, (byte) 2), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith((byte) 1, (byte) 3, (byte) 2), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void byteIterator() {
        ByteIterator iterator = this.classUnderTest().byteIterator();
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
        Assert.assertArrayEquals(new byte[] { (byte) 1, (byte) 2, (byte) 4, (byte) 3 }, this.newWith((byte) 1, (byte) 2, (byte) 4, (byte) 3).toArray());
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new ByteArrayList(), this.newWith().reverseThis());
        MutableByteList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3), this.newWith((byte) 3).reverseThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 1), this.newWith((byte) 1, (byte) 3).reverseThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7), this.newWith((byte) 7, (byte) 9, (byte) 1, (byte) 3).reverseThis());
        MutableByteList sameList = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7, (byte) 8), this.newWith((byte) 8, (byte) 7, (byte) 9, (byte) 1, (byte) 3).reverseThis());
        MutableByteList list1 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(list1.reverseThis(), ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new ByteArrayList(), this.newWith().sortThis());
        MutableByteList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3), this.newWith((byte) 3).sortThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 3), this.newWith((byte) 3, (byte) 1).sortThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 3, (byte) 7, (byte) 9), this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).sortThis());
        MutableByteList sameList = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 3, (byte) 7, (byte) 8, (byte) 9), this.newWith((byte) 8, (byte) 1, (byte) 7, (byte) 3, (byte) 9).sortThis());
        MutableByteList list = this.newWith();
        list.add((byte) 2);
        list.add((byte) 1);
        list.sortThis();
        Assert.assertEquals((byte) 1, list.get(0));
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableByteList index = this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 4, (byte) 0, (byte) 3, (byte) 1, (byte) 2), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableByteList index = this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 2, (byte) 4, (byte) 6, (byte) 8, (byte) 1, (byte) 3, (byte) 5, (byte) 7, (byte) 9), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableByteList index = this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 0, (byte) 4, (byte) 3), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableByteList index = this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 4, (byte) 0, (byte) 2, (byte) 1), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 3, (byte) 4), this.newMutableCollectionWith((byte) 3, (byte) 2, (byte) 1, (byte) 0, (byte) 1, (byte) 4).sortThis(Byte::compare));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 3, (byte) 4, (byte) 6, (byte) 7, (byte) 8, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 15, (byte) 15, (byte) 17, (byte) 18, (byte) 19), this.newMutableCollectionWith((byte) 17, (byte) 1, (byte) 15, (byte) 12, (byte) 10, (byte) 4, (byte) 2, (byte) 19, (byte) 2, (byte) 8, (byte) 18, (byte) 15, (byte) 15, (byte) 13, (byte) 3, (byte) 11, (byte) 7, (byte) 2, (byte) 14, (byte) 6).sortThis(Byte::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((byte) 3, (byte) 2, (byte) 1, (byte) 0, (byte) 5, (byte) 4).sortThis(Byte::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((byte) 3, (byte) 0, (byte) 1, (byte) 2, (byte) 5, (byte) 4).sortThis(Byte::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((byte) 17, (byte) 1, (byte) 16, (byte) 12, (byte) 10, (byte) 4, (byte) 2, (byte) 19, (byte) 5, (byte) 8, (byte) 18, (byte) 15, (byte) 20, (byte) 13, (byte) 3, (byte) 11, (byte) 7, (byte) 9, (byte) 14, (byte) 6).sortThis(Byte::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((byte) 12, (byte) 3, (byte) 17, (byte) 20, (byte) 5, (byte) 2, (byte) 4, (byte) 9, (byte) 16, (byte) 19, (byte) 10, (byte) 14, (byte) 6, (byte) 7, (byte) 15, (byte) 11, (byte) 13, (byte) 18, (byte) 8, (byte) 1).sortThis(Byte::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).sortThis(Byte::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20).sortThis(Byte::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith((byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 1, (byte) 0).sortThis(Byte::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith((byte) 20, (byte) 19, (byte) 18, (byte) 17, (byte) 16, (byte) 15, (byte) 14, (byte) 13, (byte) 12, (byte) 11, (byte) 10, (byte) 9, (byte) 8, (byte) 7, (byte) 6, (byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 1).sortThis(Byte::compare));
    }

    @Test
    public void shuffleThis() {
        ByteList checkList = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15).toImmutable();
        MutableByteList list = checkList.toList();
        ByteList shuffleOne = list.shuffleThis().toImmutable();
        ByteList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableByteList list = this.newWith((byte) 2, (byte) 3, (byte) 5, (byte) 6, (byte) 9);
        Assert.assertEquals(-1, list.binarySearch((byte) 1));
        Assert.assertEquals(0, list.binarySearch((byte) 2));
        Assert.assertEquals(1, list.binarySearch((byte) 3));
        Assert.assertEquals(-3, list.binarySearch((byte) 4));
        Assert.assertEquals(2, list.binarySearch((byte) 5));
        Assert.assertEquals(3, list.binarySearch((byte) 6));
        Assert.assertEquals(-5, list.binarySearch((byte) 7));
        Assert.assertEquals(-5, list.binarySearch((byte) 8));
        Assert.assertEquals(4, list.binarySearch((byte) 9));
        Assert.assertEquals(-6, list.binarySearch((byte) 10));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new ByteArrayList(), this.newWith().toReversed());
        MutableByteList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7), this.newWith((byte) 7, (byte) 9, (byte) 1, (byte) 3).toReversed());
        MutableByteList evenList = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 1, (byte) 9, (byte) 7, (byte) 8), this.newWith((byte) 8, (byte) 7, (byte) 9, (byte) 1, (byte) 3).toReversed());
        MutableByteList oddList = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7, (byte) 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((byte each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableByteList list1 = this.newWith((byte) 3, (byte) 1);
        MutableByteList list2 = this.newWith((byte) 7, (byte) 9);
        MutableList<ByteBytePair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<ByteBytePair> expected = Lists.mutable.with(PrimitiveTuples.pair((byte) 3, (byte) 7), PrimitiveTuples.pair((byte) 1, (byte) 9));
        Assert.assertEquals(expected, result);
        MutableByteList list3 = this.newWith((byte) 7, (byte) 9, (byte) 1);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        MutableByteList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        MutableByteList selected = list.selectWithIndex((value, i) -> i % 2 == 0, ByteLists.mutable.empty());
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 9), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        MutableByteList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(ByteLists.mutable.with((byte) 1, (byte) 7), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableByteList list = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7);
        MutableByteList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, ByteLists.mutable.empty());
        Assert.assertEquals(ByteLists.mutable.with((byte) 1, (byte) 7), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<ByteIntPair> pairs = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ByteIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 1, (byte) 9, (byte) 7), pairs.collectByte(ByteIntPair::getOne, ByteLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(ByteIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(ByteSets.mutable.with((byte) 3, (byte) 1, (byte) 9, (byte) 7), pairs.collectByte(ByteIntPair::getOne, ByteSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<ByteIntPair> pairs = this.newWith((byte) 3, (byte) 1, (byte) 9, (byte) 7).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(ByteIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(ByteLists.mutable.with((byte) 3, (byte) 1, (byte) 9, (byte) 7), pairs.collectByte(ByteIntPair::getOne, ByteLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        MutableByteList list2 = this.newWith((byte) 4, (byte) 3, (byte) 2, (byte) 1);
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
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 4, (byte) 4).distinct();
        MutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4);
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
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableByteList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        ByteArrayList arrayList = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = arrayList.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = list1.injectIntoWithIndex(new MutableByte((byte) 0), (MutableByte object, byte value, int index) -> object.add((byte) (value * list2.get(index))));
        Assert.assertEquals(new MutableByte((byte) 14), result);
    }

    @Test
    public void zipByte() {
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByteList list2 = this.newWith((byte) 1, (byte) 2);
        MutableList<ByteBytePair> zipSame = list1.zipByte(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 3)), zipSame);
        MutableList<ByteBytePair> zipSameLazy = list1.zipByte(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 3)), zipSameLazy);
        MutableList<ByteBytePair> zipLess = list1.zipByte(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2)), zipLess);
        MutableList<ByteBytePair> zipLessLazy = list1.zipByte(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2)), zipLessLazy);
        MutableList<ByteBytePair> zipMore = list2.zipByte(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2)), zipMore);
        MutableList<ByteBytePair> zipMoreLazy = list2.zipByte(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2)), zipMoreLazy);
        MutableList<ByteBytePair> zipEmpty = list1.zipByte(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableByteList list1 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByteList list2 = this.newWith((byte) 1, (byte) 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<ByteObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2"), PrimitiveTuples.pair((byte) 3, "3")), zipSame);
        MutableList<ByteObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2"), PrimitiveTuples.pair((byte) 3, "3")), zipSameLazy);
        MutableList<ByteObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2")), zipLess);
        MutableList<ByteObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2")), zipLessLazy);
        MutableList<ByteObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2")), zipMore);
        MutableList<ByteObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair((byte) 1, "1"), PrimitiveTuples.pair((byte) 2, "2")), zipMoreLazy);
        MutableList<ByteObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase._Benchmark {

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator, this.description("byteIterator"));
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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipByte, this.description("zipByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractByteListTestCase implementation();
    }
}
