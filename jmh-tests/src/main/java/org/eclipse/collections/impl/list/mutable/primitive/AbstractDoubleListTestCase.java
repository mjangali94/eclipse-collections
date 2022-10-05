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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase._Benchmark {

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator, this.description("doubleIterator"));
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
        public void benchmark_zipDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipDouble, this.description("zipDouble"));
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
        public abstract AbstractDoubleListTestCase implementation();
    }
}
