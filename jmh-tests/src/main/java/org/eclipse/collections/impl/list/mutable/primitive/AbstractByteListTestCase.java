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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteListTestCase instance;

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
        public void benchmark_zipByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> byteIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> byteIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> byteIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> byteIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> zipByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteListTestCase> zip;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractByteListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractByteListTestCase::newCollection;
            this.payloads.isEmpty = AbstractByteListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractByteListTestCase::notEmpty;
            this.payloads.tap = AbstractByteListTestCase::tap;
            this.payloads.containsAllArray = AbstractByteListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractByteListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractByteListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractByteListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractByteListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractByteListTestCase::containsNoneIterable;
            this.payloads.byteIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::byteIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractByteListTestCase::forEach;
            this.payloads.size = AbstractByteListTestCase::size;
            this.payloads.count = AbstractByteListTestCase::count;
            this.payloads.anySatisfy = AbstractByteListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractByteListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractByteListTestCase::noneSatisfy;
            this.payloads.collect = AbstractByteListTestCase::collect;
            this.payloads.collectWithTarget = AbstractByteListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractByteListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractByteListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractByteListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractByteListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractByteListTestCase::select;
            this.payloads.selectWithTarget = AbstractByteListTestCase::selectWithTarget;
            this.payloads.reject = AbstractByteListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractByteListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractByteListTestCase::detectIfNone;
            this.payloads.max = AbstractByteListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractByteListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractByteListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractByteListTestCase::sum;
            this.payloads.summaryStatistics = AbstractByteListTestCase::summaryStatistics;
            this.payloads.average = AbstractByteListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractByteListTestCase::averageIfEmpty;
            this.payloads.median = AbstractByteListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractByteListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractByteListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractByteListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractByteListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractByteListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractByteListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractByteListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractByteListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractByteListTestCase::toSet;
            this.payloads.toBag = AbstractByteListTestCase::toBag;
            this.payloads.asLazy = AbstractByteListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractByteListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractByteListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractByteListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractByteListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractByteListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractByteListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractByteListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractByteListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractByteListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractByteListTestCase::chunk;
            this.payloads.clear = AbstractByteListTestCase::clear;
            this.payloads.contains = AbstractByteListTestCase::contains;
            this.payloads.add = AbstractByteListTestCase::add;
            this.payloads.remove = AbstractByteListTestCase::remove;
            this.payloads.removeIf = AbstractByteListTestCase::removeIf;
            this.payloads.removeAll = AbstractByteListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractByteListTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractByteListTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractByteListTestCase::retainAll_iterable;
            this.payloads.with = AbstractByteListTestCase::with;
            this.payloads.withAll = AbstractByteListTestCase::withAll;
            this.payloads.without = AbstractByteListTestCase::without;
            this.payloads.withoutAll = AbstractByteListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractByteListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractByteListTestCase::asUnmodifiable;
            this.payloads.byteIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::byteIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.byteIterator_with_remove = AbstractByteListTestCase::byteIterator_with_remove;
            this.payloads.byteIterator_throws_for_remove_before_next = AbstractByteListTestCase::byteIterator_throws_for_remove_before_next;
            this.payloads.byteIterator_throws_for_consecutive_remove = AbstractByteListTestCase::byteIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractByteListTestCase::newEmpty;
            this.payloads.get = AbstractByteListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractByteListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractByteListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = AbstractByteListTestCase::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = AbstractByteListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractByteListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractByteListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractByteListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractByteListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = AbstractByteListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractByteListTestCase::set;
            this.payloads.swap = AbstractByteListTestCase::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.byteIterator = AbstractByteListTestCase::byteIterator;
            this.payloads.toArray = AbstractByteListTestCase::toArray;
            this.payloads.reverseThis = AbstractByteListTestCase::reverseThis;
            this.payloads.sortThis = AbstractByteListTestCase::sortThis;
            this.payloads.sortWithPrimitiveComparator = AbstractByteListTestCase::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = AbstractByteListTestCase::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = AbstractByteListTestCase::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = AbstractByteListTestCase::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = AbstractByteListTestCase::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = AbstractByteListTestCase::sortShuffledInput;
            this.payloads.sortSortedInput = AbstractByteListTestCase::sortSortedInput;
            this.payloads.sortReversedSortedInput = AbstractByteListTestCase::sortReversedSortedInput;
            this.payloads.shuffleThis = AbstractByteListTestCase::shuffleThis;
            this.payloads.binarySearch = AbstractByteListTestCase::binarySearch;
            this.payloads.toReversed = AbstractByteListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractByteListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractByteListTestCase::forEachInBoth;
            this.payloads.selectWithIndex = AbstractByteListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractByteListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractByteListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractByteListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractByteListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractByteListTestCase::collectWithIndexWithTarget;
            this.payloads.testEquals = AbstractByteListTestCase::testEquals;
            this.payloads.testToString = AbstractByteListTestCase::testToString;
            this.payloads.distinct = AbstractByteListTestCase::distinct;
            this.payloads.makeString = AbstractByteListTestCase::makeString;
            this.payloads.appendString = AbstractByteListTestCase::appendString;
            this.payloads.toList = AbstractByteListTestCase::toList;
            this.payloads.toImmutable = AbstractByteListTestCase::toImmutable;
            this.payloads.injectInto = AbstractByteListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractByteListTestCase::injectIntoWithIndex;
            this.payloads.zipByte = AbstractByteListTestCase::zipByte;
            this.payloads.zip = AbstractByteListTestCase::zip;
        }
    }
*/
}
