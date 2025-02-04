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

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.DoubleList;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Abstract JUnit test for {@link MutableDoubleList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractDoubleListTestCase extends AbstractMutableDoubleCollectionTestCase {

    private static final DoubleList SORTED_LONGER_LIST = DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0);

    private static final DoubleList SORTED_SHORTER_LIST = DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0, 4.0, 5.0);

    @Override
    protected abstract MutableDoubleList classUnderTest();

    @Override
    protected abstract MutableDoubleList newWith(double... elements);

    @Override
    protected MutableDoubleList newMutableCollectionWith(double... elements) {
        return DoubleArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Double> newObjectCollectionWith(Double... elements) {
        return FastList.newListWith(elements);
    }

    @Test
    public void get() {
        MutableDoubleList list = this.classUnderTest();
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
        MutableDoubleList singleItemList = this.newWith(1.0);
        Assert.assertEquals(1.0, singleItemList.getFirst(), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getFirst(), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws() {
        this.newWith().getFirst();
    }

    @Test
    public void getLast() {
        MutableDoubleList singleItemList = this.newWith(1.0);
        Assert.assertEquals(1.0, singleItemList.getLast(), 0.0);
        Assert.assertEquals(3.0, this.classUnderTest().getLast(), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws() {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct() {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes() {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf() {
        MutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(0L, arrayList.indexOf(1.0));
        Assert.assertEquals(1L, arrayList.indexOf(2.0));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0));
    }

    @Test
    public void lastIndexOf() {
        MutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0));
    }

    @Test
    public void addAtIndex() {
        MutableDoubleList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0), emptyList);
        MutableDoubleList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0), arrayList);
        arrayList.addAtIndex(2, 5.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 5.0, 3.0, 4.0), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        this.newWith().addAtIndex(1, 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative() {
        this.classUnderTest().addAtIndex(-1, 4.0);
    }

    @Override
    @Test
    public void addAllArray() {
        super.addAllArray();
        MutableDoubleList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4.0, 5.0, 6.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5.0, 6.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 6.0), list);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        MutableDoubleList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(DoubleArrayList.newListWith(4.0, 5.0, 6.0)));
        Assert.assertTrue(list.addAll(DoubleArrayStack.newStackWith(8.0, 7.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), list);
        Assert.assertTrue(list.addAllAtIndex(4, DoubleArrayList.newListWith(5.0, 6.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 6.0, 7.0, 8.0), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, 5.0, 6.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, 5.0, 6.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative() {
        this.classUnderTest().addAllAtIndex(-1, DoubleArrayList.newListWith(1.0, 2.0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.classUnderTest().addAllAtIndex(5, DoubleArrayList.newListWith(1.0, 2.0));
    }

    @Test
    public void removeAtIndex() {
        MutableDoubleList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0), list);
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
        MutableDoubleList list = this.classUnderTest();
        list.set(1, 4.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 4.0, 3.0), list);
    }

    @Test
    public void swap() {
        MutableDoubleList list = this.classUnderTest();
        list.swap(1, 2);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0, 2.0), list);
        list.swap(1, 1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0, 2.0), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList() {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void doubleIterator() {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
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
        Assert.assertArrayEquals(new double[] { 1.0, 2.0, 4.0, 3.0 }, this.newWith(1.0, 2.0, 4.0, 3.0).toArray(), 0.0);
    }

    @Test
    public void reverseThis() {
        Assert.assertEquals(new DoubleArrayList(), this.newWith().reverseThis());
        MutableDoubleList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0), this.newWith(3.0).reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0), this.newWith(1.0, 3.0).reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0), this.newWith(7.0, 9.0, 1.0, 3.0).reverseThis());
        MutableDoubleList sameList = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0, 8.0), this.newWith(8.0, 7.0, 9.0, 1.0, 3.0).reverseThis());
        MutableDoubleList list1 = DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, DoubleArrayList.newListWith(1.0, 2.0, 3.0));
        Assert.assertEquals(list1.reverseThis(), DoubleArrayList.newListWith(3.0, 2.0, 1.0));
    }

    @Test
    public void sortThis() {
        Assert.assertEquals(new DoubleArrayList(), this.newWith().sortThis());
        MutableDoubleList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0), this.newWith(3.0).sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 3.0), this.newWith(3.0, 1.0).sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 3.0, 7.0, 9.0), this.newWith(3.0, 1.0, 9.0, 7.0).sortThis());
        MutableDoubleList sameList = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 3.0, 7.0, 8.0, 9.0), this.newWith(8.0, 1.0, 7.0, 3.0, 9.0).sortThis());
        MutableDoubleList list = this.newWith();
        list.add(2.0);
        list.add(1.0);
        list.sortThis();
        Assert.assertEquals(1.0, list.get(0), 0.0);
    }

    @Test
    public void sortWithPrimitiveComparator() {
        // sin: 0, 0.841, 0.909, 0.141, -0.757
        MutableDoubleList index = this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0);
        index.sortThis((i1, i2) -> Double.compare(Math.sin(i1), Math.sin(i2)));
        Assert.assertEquals(DoubleArrayList.newListWith(4.0, 0.0, 3.0, 1.0, 2.0), index);
    }

    @Test
    public void sortWithOddEvenComparator() {
        MutableDoubleList index = this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        index.sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 2.0, 4.0, 6.0, 8.0, 1.0, 3.0, 5.0, 7.0, 9.0), index);
    }

    @Test
    public void sortWithKeyExtractorNaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableDoubleList index = this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0);
        index.sortThisBy(i -> list.get((int) i));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 0.0, 4.0, 3.0), index);
    }

    @Test
    public void sortWithKeyExtractorUnnaturalComparator() {
        MutableList<String> list = Lists.mutable.of("Foo", "Bar", "Baz", "Waldo", "Qux");
        MutableDoubleList index = this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0);
        index.sortThisBy(i -> list.get((int) i), Comparators.naturalOrder().reversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 4.0, 0.0, 2.0, 1.0), index);
    }

    @Test
    public void sortShuffledInputWithDupes() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 1.0, 2.0, 3.0, 4.0), this.newMutableCollectionWith(3.0, 2.0, 1.0, 0.0, 1.0, 4.0).sortThis(Double::compare));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 2.0, 2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 15.0, 15.0, 17.0, 18.0, 19.0), this.newMutableCollectionWith(17.0, 1.0, 15.0, 12.0, 10.0, 4.0, 2.0, 19.0, 2.0, 8.0, 18.0, 15.0, 15.0, 13.0, 3.0, 11.0, 7.0, 2.0, 14.0, 6.0).sortThis(Double::compare));
    }

    @Test
    public void sortShuffledInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3.0, 2.0, 1.0, 0.0, 5.0, 4.0).sortThis(Double::compare));
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(3.0, 0.0, 1.0, 2.0, 5.0, 4.0).sortThis(Double::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(17.0, 1.0, 16.0, 12.0, 10.0, 4.0, 2.0, 19.0, 5.0, 8.0, 18.0, 15.0, 20.0, 13.0, 3.0, 11.0, 7.0, 9.0, 14.0, 6.0).sortThis(Double::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(12.0, 3.0, 17.0, 20.0, 5.0, 2.0, 4.0, 9.0, 16.0, 19.0, 10.0, 14.0, 6.0, 7.0, 15.0, 11.0, 13.0, 18.0, 8.0, 1.0).sortThis(Double::compare));
    }

    @Test
    public void sortSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0, 5.0).sortThis(Double::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0).sortThis(Double::compare));
    }

    @Test
    public void sortReversedSortedInput() {
        Assert.assertEquals(SORTED_SHORTER_LIST, this.newMutableCollectionWith(5.0, 4.0, 3.0, 2.0, 1.0, 0.0).sortThis(Double::compare));
        Assert.assertEquals(SORTED_LONGER_LIST, this.newMutableCollectionWith(20.0, 19.0, 18.0, 17.0, 16.0, 15.0, 14.0, 13.0, 12.0, 11.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0).sortThis(Double::compare));
    }

    @Test
    public void shuffleThis() {
        DoubleList checkList = this.newWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0).toImmutable();
        MutableDoubleList list = checkList.toList();
        DoubleList shuffleOne = list.shuffleThis().toImmutable();
        DoubleList shuffleTwo = list.shuffleThis().toImmutable();
        Assert.assertNotEquals(checkList, shuffleOne);
        Assert.assertNotEquals(checkList, shuffleTwo);
        Assert.assertNotEquals(shuffleOne, shuffleTwo);
        Assert.assertEquals(checkList, shuffleOne.toSortedList());
        Assert.assertEquals(checkList, shuffleTwo.toSortedList());
    }

    @Test
    public void binarySearch() {
        MutableDoubleList list = this.newWith(2.0, 3.0, 5.0, 6.0, 9.0);
        Assert.assertEquals(-1, list.binarySearch(1.0));
        Assert.assertEquals(0, list.binarySearch(2.0));
        Assert.assertEquals(1, list.binarySearch(3.0));
        Assert.assertEquals(-3, list.binarySearch(4.0));
        Assert.assertEquals(2, list.binarySearch(5.0));
        Assert.assertEquals(3, list.binarySearch(6.0));
        Assert.assertEquals(-5, list.binarySearch(7.0));
        Assert.assertEquals(-5, list.binarySearch(8.0));
        Assert.assertEquals(4, list.binarySearch(9.0));
        Assert.assertEquals(-6, list.binarySearch(10.0));
    }

    @Test
    public void toReversed() {
        Assert.assertEquals(new DoubleArrayList(), this.newWith().toReversed());
        MutableDoubleList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0), this.newWith(7.0, 9.0, 1.0, 3.0).toReversed());
        MutableDoubleList evenList = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0, 8.0), this.newWith(8.0, 7.0, 9.0, 1.0, 3.0).toReversed());
        MutableDoubleList oddList = this.newWith(3.0, 1.0, 9.0, 7.0, 8.0);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex() {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((double each, int index) -> sum[0] += each + index);
        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void forEachInBoth() {
        MutableDoubleList list1 = this.newWith(3.0, 1.0);
        MutableDoubleList list2 = this.newWith(7.0, 9.0);
        MutableList<DoubleDoublePair> result = Lists.mutable.empty();
        list1.forEachInBoth(list2, (one, two) -> result.add(PrimitiveTuples.pair(one, two)));
        MutableList<DoubleDoublePair> expected = Lists.mutable.with(PrimitiveTuples.pair(3.0, 7.0), PrimitiveTuples.pair(1.0, 9.0));
        Assert.assertEquals(expected, result);
        MutableDoubleList list3 = this.newWith(7.0, 9.0, 1.0);
        Assert.assertThrows(IllegalArgumentException.class, () -> list1.forEachInBoth(list3, (one, three) -> result.add(PrimitiveTuples.pair(one, three))));
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndex() {
        MutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        MutableDoubleList selected = list.selectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 9.0), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void selectWithIndexWithTarget() {
        MutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        MutableDoubleList selected = list.selectWithIndex((value, i) -> i % 2 == 0, DoubleLists.mutable.empty());
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 9.0), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndex() {
        MutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        MutableDoubleList selected = list.rejectWithIndex((value, i) -> i % 2 == 0);
        Assert.assertEquals(DoubleLists.mutable.with(1.0, 7.0), selected);
    }

    /**
     * @since 11.1.
     */
    @Test
    public void rejectWithIndexWithTarget() {
        MutableDoubleList list = this.newWith(3.0, 1.0, 9.0, 7.0);
        MutableDoubleList selected = list.rejectWithIndex((value, i) -> i % 2 == 0, DoubleLists.mutable.empty());
        Assert.assertEquals(DoubleLists.mutable.with(1.0, 7.0), selected);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0).collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 1.0, 9.0, 7.0), pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));
        Assert.assertEquals(IntSets.mutable.with(0, 1, 2, 3), pairs.collectInt(DoubleIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(DoubleSets.mutable.with(3.0, 1.0, 9.0, 7.0), pairs.collectDouble(DoubleIntPair::getOne, DoubleSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0).collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(IntLists.mutable.with(0, 1, 2, 3), pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 1.0, 9.0, 7.0), pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals() {
        super.testEquals();
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0, 4.0);
        MutableDoubleList list2 = this.newWith(4.0, 3.0, 2.0, 1.0);
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
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0).distinct();
        MutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0, 4.0);
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
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable() {
        ImmutableDoubleList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), immutable);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        DoubleArrayList arrayList = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        MutableDouble result = arrayList.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @Test
    public void injectIntoWithIndex() {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = list1.injectIntoWithIndex(new MutableDouble(0.0), (MutableDouble object, double value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableDouble(14.0), result);
    }

    @Test
    public void zipDouble() {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0);
        MutableList<DoubleDoublePair> zipSame = list1.zipDouble(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0), PrimitiveTuples.pair(3.0, 3.0)), zipSame);
        MutableList<DoubleDoublePair> zipSameLazy = list1.zipDouble(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0), PrimitiveTuples.pair(3.0, 3.0)), zipSameLazy);
        MutableList<DoubleDoublePair> zipLess = list1.zipDouble(list2);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0)), zipLess);
        MutableList<DoubleDoublePair> zipLessLazy = list1.zipDouble(list2.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0)), zipLessLazy);
        MutableList<DoubleDoublePair> zipMore = list2.zipDouble(list1);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0)), zipMore);
        MutableList<DoubleDoublePair> zipMoreLazy = list2.zipDouble(list1.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0)), zipMoreLazy);
        MutableList<DoubleDoublePair> zipEmpty = list1.zipDouble(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip() {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<DoubleObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2"), PrimitiveTuples.pair(3.0, "3")), zipSame);
        MutableList<DoubleObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2"), PrimitiveTuples.pair(3.0, "3")), zipSameLazy);
        MutableList<DoubleObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2")), zipLess);
        MutableList<DoubleObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2")), zipLessLazy);
        MutableList<DoubleObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2")), zipMore);
        MutableList<DoubleObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(Lists.mutable.with(PrimitiveTuples.pair(1.0, "1"), PrimitiveTuples.pair(2.0, "2")), zipMoreLazy);
        MutableList<DoubleObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void stream() {
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), DoubleArrayList.newListWith(1.0, 2.0, 3.0).primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), DoubleArrayList.newListWith(1.0, 2.0, 3.0).asSynchronized().primitiveStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), DoubleArrayList.newListWith(1.0, 2.0, 3.0).asUnmodifiable().primitiveStream().boxed().collect(Collectors.toList()));
    }

    @Test
    public void parallelStream() {
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), DoubleArrayList.newListWith(1.0, 2.0, 3.0).primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), DoubleArrayList.newListWith(1.0, 2.0, 3.0).asSynchronized().primitiveParallelStream().boxed().collect(Collectors.toList()));
        Assert.assertEquals(Arrays.asList(1.0, 2.0, 3.0), DoubleArrayList.newListWith(1.0, 2.0, 3.0).asUnmodifiable().primitiveParallelStream().boxed().collect(Collectors.toList()));
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleListTestCase instance;

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
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_zipDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipDouble);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleListTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> zipDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleListTestCase> parallelStream;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = AbstractDoubleListTestCase::newCollectionWith;
            this.payloads.newCollection = AbstractDoubleListTestCase::newCollection;
            this.payloads.isEmpty = AbstractDoubleListTestCase::isEmpty;
            this.payloads.notEmpty = AbstractDoubleListTestCase::notEmpty;
            this.payloads.tap = AbstractDoubleListTestCase::tap;
            this.payloads.contains_NaN = AbstractDoubleListTestCase::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = AbstractDoubleListTestCase::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = AbstractDoubleListTestCase::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = AbstractDoubleListTestCase::contains_zero;
            this.payloads.testEquals_NaN = AbstractDoubleListTestCase::testEquals_NaN;
            this.payloads.contains_different_NaNs = AbstractDoubleListTestCase::contains_different_NaNs;
            this.payloads.containsAllArray = AbstractDoubleListTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractDoubleListTestCase::containsAllIterable;
            this.payloads.containsAnyArray = AbstractDoubleListTestCase::containsAnyArray;
            this.payloads.containsAnyIterable = AbstractDoubleListTestCase::containsAnyIterable;
            this.payloads.containsNoneArray = AbstractDoubleListTestCase::containsNoneArray;
            this.payloads.containsNoneIterable = AbstractDoubleListTestCase::containsNoneIterable;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = AbstractDoubleListTestCase::forEach;
            this.payloads.size = AbstractDoubleListTestCase::size;
            this.payloads.count = AbstractDoubleListTestCase::count;
            this.payloads.anySatisfy = AbstractDoubleListTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractDoubleListTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractDoubleListTestCase::noneSatisfy;
            this.payloads.collect = AbstractDoubleListTestCase::collect;
            this.payloads.collectWithTarget = AbstractDoubleListTestCase::collectWithTarget;
            this.payloads.flatCollectWithTarget = AbstractDoubleListTestCase::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = AbstractDoubleListTestCase::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = AbstractDoubleListTestCase::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = AbstractDoubleListTestCase::collectPrimitivesToSets;
            this.payloads.select = AbstractDoubleListTestCase::select;
            this.payloads.selectWithTarget = AbstractDoubleListTestCase::selectWithTarget;
            this.payloads.reject = AbstractDoubleListTestCase::reject;
            this.payloads.rejectWithTarget = AbstractDoubleListTestCase::rejectWithTarget;
            this.payloads.detectIfNone = AbstractDoubleListTestCase::detectIfNone;
            this.payloads.max = AbstractDoubleListTestCase::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractDoubleListTestCase::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractDoubleListTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractDoubleListTestCase::maxIfEmpty;
            this.payloads.sum = AbstractDoubleListTestCase::sum;
            this.payloads.summaryStatistics = AbstractDoubleListTestCase::summaryStatistics;
            this.payloads.sumConsistentRounding = AbstractDoubleListTestCase::sumConsistentRounding;
            this.payloads.average = AbstractDoubleListTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = AbstractDoubleListTestCase::averageIfEmpty;
            this.payloads.median = AbstractDoubleListTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = AbstractDoubleListTestCase::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = AbstractDoubleListTestCase::toArrayWithTargetArray;
            this.payloads.toSortedArray = AbstractDoubleListTestCase::toSortedArray;
            this.payloads.testHashCode = AbstractDoubleListTestCase::testHashCode;
            this.payloads.toSortedList = AbstractDoubleListTestCase::toSortedList;
            this.payloads.toSortedListByComparator = AbstractDoubleListTestCase::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = AbstractDoubleListTestCase::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = AbstractDoubleListTestCase::toSortedListByFunctionWithComparator;
            this.payloads.toSet = AbstractDoubleListTestCase::toSet;
            this.payloads.toBag = AbstractDoubleListTestCase::toBag;
            this.payloads.asLazy = AbstractDoubleListTestCase::asLazy;
            this.payloads.injectIntoBoolean = AbstractDoubleListTestCase::injectIntoBoolean;
            this.payloads.injectIntoByte = AbstractDoubleListTestCase::injectIntoByte;
            this.payloads.injectIntoChar = AbstractDoubleListTestCase::injectIntoChar;
            this.payloads.injectIntoShort = AbstractDoubleListTestCase::injectIntoShort;
            this.payloads.injectIntoInt = AbstractDoubleListTestCase::injectIntoInt;
            this.payloads.injectIntoFloat = AbstractDoubleListTestCase::injectIntoFloat;
            this.payloads.injectIntoLong = AbstractDoubleListTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractDoubleListTestCase::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = AbstractDoubleListTestCase::reduce;
            this.payloads.reduceIfEmpty = AbstractDoubleListTestCase::reduceIfEmpty;
            this.payloads.chunk = AbstractDoubleListTestCase::chunk;
            this.payloads.clear = AbstractDoubleListTestCase::clear;
            this.payloads.contains = AbstractDoubleListTestCase::contains;
            this.payloads.add = AbstractDoubleListTestCase::add;
            this.payloads.remove = AbstractDoubleListTestCase::remove;
            this.payloads.removeIf = AbstractDoubleListTestCase::removeIf;
            this.payloads.removeAll = AbstractDoubleListTestCase::removeAll;
            this.payloads.removeAll_iterable = AbstractDoubleListTestCase::removeAll_iterable;
            this.payloads.retainAll = AbstractDoubleListTestCase::retainAll;
            this.payloads.retainAll_iterable = AbstractDoubleListTestCase::retainAll_iterable;
            this.payloads.with = AbstractDoubleListTestCase::with;
            this.payloads.withAll = AbstractDoubleListTestCase::withAll;
            this.payloads.without = AbstractDoubleListTestCase::without;
            this.payloads.withoutAll = AbstractDoubleListTestCase::withoutAll;
            this.payloads.asSynchronized = AbstractDoubleListTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractDoubleListTestCase::asUnmodifiable;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = AbstractDoubleListTestCase::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = AbstractDoubleListTestCase::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = AbstractDoubleListTestCase::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = AbstractDoubleListTestCase::newEmpty;
            this.payloads.get = AbstractDoubleListTestCase::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = AbstractDoubleListTestCase::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = AbstractDoubleListTestCase::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = AbstractDoubleListTestCase::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = AbstractDoubleListTestCase::indexOf;
            this.payloads.lastIndexOf = AbstractDoubleListTestCase::lastIndexOf;
            this.payloads.addAtIndex = AbstractDoubleListTestCase::addAtIndex;
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::addAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::addAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllArray = AbstractDoubleListTestCase::addAllArray;
            this.payloads.addAllIterable = AbstractDoubleListTestCase::addAllIterable;
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::addAll_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::addAll_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::addAllIterable_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::addAllIterable_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex = AbstractDoubleListTestCase::removeAtIndex;
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::removeAtIndex_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::removeAtIndex_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.set = AbstractDoubleListTestCase::set;
            this.payloads.swap = AbstractDoubleListTestCase::swap;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleListTestCase::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.doubleIterator = AbstractDoubleListTestCase::doubleIterator;
            this.payloads.toArray = AbstractDoubleListTestCase::toArray;
            this.payloads.reverseThis = AbstractDoubleListTestCase::reverseThis;
            this.payloads.sortThis = AbstractDoubleListTestCase::sortThis;
            this.payloads.sortWithPrimitiveComparator = AbstractDoubleListTestCase::sortWithPrimitiveComparator;
            this.payloads.sortWithOddEvenComparator = AbstractDoubleListTestCase::sortWithOddEvenComparator;
            this.payloads.sortWithKeyExtractorNaturalComparator = AbstractDoubleListTestCase::sortWithKeyExtractorNaturalComparator;
            this.payloads.sortWithKeyExtractorUnnaturalComparator = AbstractDoubleListTestCase::sortWithKeyExtractorUnnaturalComparator;
            this.payloads.sortShuffledInputWithDupes = AbstractDoubleListTestCase::sortShuffledInputWithDupes;
            this.payloads.sortShuffledInput = AbstractDoubleListTestCase::sortShuffledInput;
            this.payloads.sortSortedInput = AbstractDoubleListTestCase::sortSortedInput;
            this.payloads.sortReversedSortedInput = AbstractDoubleListTestCase::sortReversedSortedInput;
            this.payloads.shuffleThis = AbstractDoubleListTestCase::shuffleThis;
            this.payloads.binarySearch = AbstractDoubleListTestCase::binarySearch;
            this.payloads.toReversed = AbstractDoubleListTestCase::toReversed;
            this.payloads.forEachWithIndex = AbstractDoubleListTestCase::forEachWithIndex;
            this.payloads.forEachInBoth = AbstractDoubleListTestCase::forEachInBoth;
            this.payloads.selectWithIndex = AbstractDoubleListTestCase::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = AbstractDoubleListTestCase::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = AbstractDoubleListTestCase::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = AbstractDoubleListTestCase::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = AbstractDoubleListTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractDoubleListTestCase::collectWithIndexWithTarget;
            this.payloads.testEquals = AbstractDoubleListTestCase::testEquals;
            this.payloads.testToString = AbstractDoubleListTestCase::testToString;
            this.payloads.distinct = AbstractDoubleListTestCase::distinct;
            this.payloads.makeString = AbstractDoubleListTestCase::makeString;
            this.payloads.appendString = AbstractDoubleListTestCase::appendString;
            this.payloads.toList = AbstractDoubleListTestCase::toList;
            this.payloads.toImmutable = AbstractDoubleListTestCase::toImmutable;
            this.payloads.injectInto = AbstractDoubleListTestCase::injectInto;
            this.payloads.injectIntoWithIndex = AbstractDoubleListTestCase::injectIntoWithIndex;
            this.payloads.zipDouble = AbstractDoubleListTestCase::zipDouble;
            this.payloads.zip = AbstractDoubleListTestCase::zip;
            this.payloads.stream = AbstractDoubleListTestCase::stream;
            this.payloads.parallelStream = AbstractDoubleListTestCase::parallelStream;
        }
    }
}
