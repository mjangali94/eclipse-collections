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

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.FloatList;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableFloatList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractFloatListTestCase extends AbstractMutableFloatCollectionTestCase {

    private static final FloatList SORTED_LONGER_LIST = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f, 17.0f, 18.0f, 19.0f, 20.0f);

    private static final FloatList SORTED_SHORTER_LIST = FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f);

    @Override
    protected abstract MutableFloatList classUnderTest();

    @Override
    protected abstract MutableFloatList newWith(float... elements);

    @Override
    protected MutableFloatList newMutableCollectionWith(float... elements) {
        return FloatArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Float> newObjectCollectionWith(Float... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableFloatList list = this.classUnderTest();
        Assert.assertEquals(1.0, list.get(0), 0.0);
        Assert.assertEquals(2.0, list.get(1), 0.0);
        Assert.assertEquals(3.0, list.get(2), 0.0);
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
        MutableFloatList singleItemList = this.newWith(1.0f);
        Assert.assertEquals(1.0, singleItemList.getFirst(), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getFirst(), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableFloatList singleItemList = this.newWith(1.0f);
        Assert.assertEquals(1.0, singleItemList.getLast(), 0.0);
        Assert.assertEquals(3.0, this.classUnderTest().getLast(), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableFloatList arrayList = this.newWith(1.0f, 2.0f, 1.0f);
        Assert.assertEquals(0L, arrayList.indexOf(1.0f));
        Assert.assertEquals(1L, arrayList.indexOf(2.0f));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0f));
    }

    @Test
    public void lastIndexOf() {
        MutableFloatList arrayList = this.newWith(1.0f, 2.0f, 1.0f);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0f));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0f));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0f));
    }

    @Test
    public void addAtIndex() {
        MutableFloatList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), emptyList);
        MutableFloatList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f), arrayList);
        arrayList.addAtIndex(2, 5.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 5.0f, 3.0f, 4.0f), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, 0.0f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, 4.0f);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableFloatList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4.0f, 5.0f, 6.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5.0f, 6.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 5.0f, 6.0f), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableFloatList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(FloatArrayList.newListWith(4.0f, 5.0f, 6.0f)));
        Assert.assertTrue(list.addAll(FloatArrayStack.newStackWith(8.0f, 7.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), list);
        Assert.assertTrue(list.addAllAtIndex(4, FloatArrayList.newListWith(5.0f, 6.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 5.0f, 6.0f, 7.0f, 8.0f), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, 5.0f, 6.0f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, 5.0f, 6.0f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, FloatArrayList.newListWith(1.0f, 2.0f));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, FloatArrayList.newListWith(1.0f, 2.0f));
    }

    @Test
    public void removeAtIndex() {
        MutableFloatList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f), list);
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
        MutableFloatList list = this.classUnderTest();
        list.set(1, 4.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 4.0f, 3.0f), list);
    }

    @Test
    public void swap() {
        MutableFloatList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f, 2.0f), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f, 2.0f), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void floatIterator() {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 4.0f, 3.0f }, this.newWith(1.0f, 2.0f, 4.0f, 3.0f).toArray(), 0.0f);
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new FloatArrayList(), this.newWith().reverseThis());
        MutableFloatList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f), this.newWith(3.0f).reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f), this.newWith(1.0f, 3.0f).reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f), this.newWith(7.0f, 9.0f, 1.0f, 3.0f).reverseThis());
        MutableFloatList sameList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f), this.newWith(8.0f, 7.0f, 9.0f, 1.0f, 3.0f).reverseThis());
        MutableFloatList list1 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(list1.reverseThis(), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new FloatArrayList(), this.newWith().sortThis());
        MutableFloatList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f), this.newWith(3.0f).sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 3.0f), this.newWith(3.0f, 1.0f).sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 3.0f, 7.0f, 9.0f), this.newWith(3.0f, 1.0f, 9.0f, 7.0f).sortThis());
        MutableFloatList sameList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 3.0f, 7.0f, 8.0f, 9.0f), this.newWith(8.0f, 1.0f, 7.0f, 3.0f, 9.0f).sortThis());
        MutableFloatList list = this.newWith();
        list.add(2.0f);
        list.add(1.0f);
        list.sortThis();
        Assert.assertEquals(1.0f, list.get(0), 0.0);
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableFloatList index = this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(FloatArrayList.newListWith(4.0f, 0.0f, 3.0f, 1.0f, 2.0f), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableFloatList index = this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 2.0f, 4.0f, 6.0f, 8.0f, 1.0f, 3.0f, 5.0f, 7.0f, 9.0f), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableFloatList index = this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 0.0f, 4.0f, 3.0f), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableFloatList index = this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 4.0f, 0.0f, 2.0f, 1.0f), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 1.0f, 2.0f, 3.0f, 4.0f), this.newMutableCollectionWith(3.0f, 2.0f, 1.0f, 0.0f, 1.0f, 4.0f).sortThis(Float::compare));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 2.0f, 2.0f, 3.0f, 4.0f, 6.0f, 7.0f, 8.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 15.0f, 15.0f, 17.0f, 18.0f, 19.0f), this.newMutableCollectionWith(17.0f, 1.0f, 15.0f, 12.0f, 10.0f, 4.0f, 2.0f, 19.0f, 2.0f, 8.0f, 18.0f, 15.0f, 15.0f, 13.0f, 3.0f, 11.0f, 7.0f, 2.0f, 14.0f, 6.0f).sortThis(Float::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3.0f, 2.0f, 1.0f, 0.0f, 5.0f, 4.0f).sortThis(Float::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3.0f, 0.0f, 1.0f, 2.0f, 5.0f, 4.0f).sortThis(Float::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(17.0f, 1.0f, 16.0f, 12.0f, 10.0f, 4.0f, 2.0f, 19.0f, 5.0f, 8.0f, 18.0f, 15.0f, 20.0f, 13.0f, 3.0f, 11.0f, 7.0f, 9.0f, 14.0f, 6.0f).sortThis(Float::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(12.0f, 3.0f, 17.0f, 20.0f, 5.0f, 2.0f, 4.0f, 9.0f, 16.0f, 19.0f, 10.0f, 14.0f, 6.0f, 7.0f, 15.0f, 11.0f, 13.0f, 18.0f, 8.0f, 1.0f).sortThis(Float::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f).sortThis(Float::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f, 17.0f, 18.0f, 19.0f, 20.0f).sortThis(Float::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(5.0f, 4.0f, 3.0f, 2.0f, 1.0f, 0.0f).sortThis(Float::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(20.0f, 19.0f, 18.0f, 17.0f, 16.0f, 15.0f, 14.0f, 13.0f, 12.0f, 11.0f, 10.0f, 9.0f, 8.0f, 7.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.0f).sortThis(Float::compare));
    }

    @Test
    public void shuffleThis() {
        FloatList checkList = this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f).toImmutable();
        MutableFloatList list = checkList.toList();
        FloatList shuffleOne = list.shuffleThis().toImmutable();
        FloatList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableFloatList list = this.newWith(2.0f, 3.0f, 5.0f, 6.0f, 9.0f);
        Assert.assertEquals(-1, list.binarySearch(1.0f));
        Assert.assertEquals(0, list.binarySearch(2.0f));
        Assert.assertEquals(1, list.binarySearch(3.0f));
        Assert.assertEquals(-3, list.binarySearch(4.0f));
        Assert.assertEquals(2, list.binarySearch(5.0f));
        Assert.assertEquals(3, list.binarySearch(6.0f));
        Assert.assertEquals(-5, list.binarySearch(7.0f));
        Assert.assertEquals(-5, list.binarySearch(8.0f));
        Assert.assertEquals(4, list.binarySearch(9.0f));
        Assert.assertEquals(-6, list.binarySearch(10.0f));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new FloatArrayList(), this.newWith().toReversed());
        MutableFloatList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f), this.newWith(7.0f, 9.0f, 1.0f, 3.0f).toReversed());
        MutableFloatList evenList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f), this.newWith(8.0f, 7.0f, 9.0f, 1.0f, 3.0f).toReversed());
        MutableFloatList oddList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((float each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableFloatList list1 = this.newWith(3.0f, 1.0f);
        MutableFloatList list2 = this.newWith(7.0f, 9.0f);
        MutableList<FloatFloatPair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<FloatFloatPair> expected = Lists.mutable.with(PrimitiveTuples.pair(3.0f, 7.0f), PrimitiveTuples.pair(1.0f, 9.0f));
        Assert.assertEquals(expected, result);
        MutableFloatList list3 = this.newWith(7.0f, 9.0f, 1.0f);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 9.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList selected = list.selectWithIndex((value, i) -> i % 2 == 0, FloatLists.mutable.empty());
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 9.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(FloatLists.mutable.with(1.0f, 7.0f), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableFloatList list = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        MutableFloatList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, FloatLists.mutable.empty());
        Assert.assertEquals(FloatLists.mutable.with(1.0f, 7.0f), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(FloatSets.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(FloatLists.mutable.with(3.0f, 1.0f, 9.0f, 7.0f), pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        MutableFloatList list2 = this.newWith(4.0f, 3.0f, 2.0f, 1.0f);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.classUnderTest().toString());
    }

    @Test
    public void distinct() {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 4.0f, 4.0f, 4.0f, 4.0f).distinct();
        MutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        Assert.assertEquals(list1, list2);
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("1.0, 2.0, 3.0", this.classUnderTest().makeString());
        Assert.assertEquals("1.0/2.0/3.0", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableFloatList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        FloatArrayList arrayList = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = arrayList.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = list1.injectIntoWithIndex(new MutableFloat(0.0f), (MutableFloat object, float value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableFloat(14.0f), result);
    }

    @Test
    public void zipFloat() {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f);
        MutableList<FloatFloatPair> zipSame = list1.zipFloat(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f), PrimitiveTuples.pair(3.0f, 3.0f)), zipSame);
        MutableList<FloatFloatPair> zipSameLazy = list1.zipFloat(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f), PrimitiveTuples.pair(3.0f, 3.0f)), zipSameLazy);
        MutableList<FloatFloatPair> zipLess = list1.zipFloat(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f)), zipLess);
        MutableList<FloatFloatPair> zipLessLazy = list1.zipFloat(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f)), zipLessLazy);
        MutableList<FloatFloatPair> zipMore = list2.zipFloat(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f)), zipMore);
        MutableList<FloatFloatPair> zipMoreLazy = list2.zipFloat(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f)), zipMoreLazy);
        MutableList<FloatFloatPair> zipEmpty = list1.zipFloat(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<FloatObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2"), PrimitiveTuples.pair(3.0f, "3")), zipSame);
        MutableList<FloatObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2"), PrimitiveTuples.pair(3.0f, "3")), zipSameLazy);
        MutableList<FloatObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2")), zipLess);
        MutableList<FloatObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2")), zipLessLazy);
        MutableList<FloatObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2")), zipMore);
        MutableList<FloatObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0f, "1"), PrimitiveTuples.pair(2.0f, "2")), zipMoreLazy);
        MutableList<FloatObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase._Benchmark {

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator, this.description("floatIterator"));
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
        public void benchmark_zipFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipFloat, this.description("zipFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractFloatListTestCase implementation();
    }
}
