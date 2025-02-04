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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatListTestCase instance;

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
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_floatIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws_for_consecutive_remove);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_zipFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> zipFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatListTestCase> zip;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractFloatListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractFloatListTestCase::newCollection;
            this.payloads.isEmpty = AbstractFloatListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractFloatListTestCase::notEmpty;
            this.payloads.tap = AbstractFloatListTestCase::tap;
            this.payloads.contains_NaN = AbstractFloatListTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractFloatListTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractFloatListTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractFloatListTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractFloatListTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractFloatListTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractFloatListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractFloatListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractFloatListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractFloatListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractFloatListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractFloatListTestCase::containsNoneIterable;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractFloatListTestCase::forEach;
            this.payloads.size = AbstractFloatListTestCase::size;
            this.payloads.count = AbstractFloatListTestCase::count;
            this.payloads.anySatisfy = AbstractFloatListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractFloatListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractFloatListTestCase::noneSatisfy;
            this.payloads.collect = AbstractFloatListTestCase::collect;
            this.payloads.collectWithTarget = AbstractFloatListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractFloatListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractFloatListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractFloatListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractFloatListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractFloatListTestCase::select;
            this.payloads.selectWithTarget = AbstractFloatListTestCase::selectWithTarget;
            this.payloads.reject = AbstractFloatListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractFloatListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractFloatListTestCase::detectIfNone;
            this.payloads.max = AbstractFloatListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractFloatListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractFloatListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractFloatListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractFloatListTestCase::sum;
            this.payloads.summaryStatistics = AbstractFloatListTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractFloatListTestCase::sumConsistentRounding;
            this.payloads.average = AbstractFloatListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractFloatListTestCase::averageIfEmpty;
            this.payloads.median = AbstractFloatListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractFloatListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractFloatListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractFloatListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractFloatListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractFloatListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractFloatListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractFloatListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractFloatListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractFloatListTestCase::toSet;
            this.payloads.toBag = AbstractFloatListTestCase::toBag;
            this.payloads.asLazy = AbstractFloatListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractFloatListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractFloatListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractFloatListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractFloatListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractFloatListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractFloatListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractFloatListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractFloatListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractFloatListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractFloatListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractFloatListTestCase::chunk;
            this.payloads.clear = AbstractFloatListTestCase::clear;
            this.payloads.contains = AbstractFloatListTestCase::contains;
            this.payloads.add = AbstractFloatListTestCase::add;
            this.payloads.remove = AbstractFloatListTestCase::remove;
            this.payloads.removeIf = AbstractFloatListTestCase::removeIf;
            this.payloads.removeAll = AbstractFloatListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractFloatListTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractFloatListTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractFloatListTestCase::retainAll_iterable;
            this.payloads.with = AbstractFloatListTestCase::with;
            this.payloads.withAll = AbstractFloatListTestCase::withAll;
            this.payloads.without = AbstractFloatListTestCase::without;
            this.payloads.withoutAll = AbstractFloatListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractFloatListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractFloatListTestCase::asUnmodifiable;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = AbstractFloatListTestCase::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = AbstractFloatListTestCase::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = AbstractFloatListTestCase::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractFloatListTestCase::newEmpty;
            this.payloads.get = AbstractFloatListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractFloatListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractFloatListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = AbstractFloatListTestCase::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = AbstractFloatListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractFloatListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractFloatListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractFloatListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractFloatListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = AbstractFloatListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractFloatListTestCase::set;
            this.payloads.swap = AbstractFloatListTestCase::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.floatIterator = AbstractFloatListTestCase::floatIterator;
            this.payloads.toArray = AbstractFloatListTestCase::toArray;
            this.payloads.reverseThis = AbstractFloatListTestCase::reverseThis;
            this.payloads.sortThis = AbstractFloatListTestCase::sortThis;
            this.payloads.sortWithPrimitiveComparator = AbstractFloatListTestCase::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = AbstractFloatListTestCase::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = AbstractFloatListTestCase::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = AbstractFloatListTestCase::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = AbstractFloatListTestCase::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = AbstractFloatListTestCase::sortShuffledInput;
            this.payloads.sortSortedInput = AbstractFloatListTestCase::sortSortedInput;
            this.payloads.sortReversedSortedInput = AbstractFloatListTestCase::sortReversedSortedInput;
            this.payloads.shuffleThis = AbstractFloatListTestCase::shuffleThis;
            this.payloads.binarySearch = AbstractFloatListTestCase::binarySearch;
            this.payloads.toReversed = AbstractFloatListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractFloatListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractFloatListTestCase::forEachInBoth;
            this.payloads.selectWithIndex = AbstractFloatListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractFloatListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractFloatListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractFloatListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractFloatListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractFloatListTestCase::collectWithIndexWithTarget;
            this.payloads.testEquals = AbstractFloatListTestCase::testEquals;
            this.payloads.testToString = AbstractFloatListTestCase::testToString;
            this.payloads.distinct = AbstractFloatListTestCase::distinct;
            this.payloads.makeString = AbstractFloatListTestCase::makeString;
            this.payloads.appendString = AbstractFloatListTestCase::appendString;
            this.payloads.toList = AbstractFloatListTestCase::toList;
            this.payloads.toImmutable = AbstractFloatListTestCase::toImmutable;
            this.payloads.injectInto = AbstractFloatListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractFloatListTestCase::injectIntoWithIndex;
            this.payloads.zipFloat = AbstractFloatListTestCase::zipFloat;
            this.payloads.zip = AbstractFloatListTestCase::zip;
        }
    }
*/
}
