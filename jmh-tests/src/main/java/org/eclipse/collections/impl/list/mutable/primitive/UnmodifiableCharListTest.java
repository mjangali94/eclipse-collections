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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharList}.
 * This file was automatically generated from template file unmodifiablePrimitiveListTest.stg.
 */
public class UnmodifiableCharListTest extends AbstractCharListTestCase {

    private final UnmodifiableCharList list = this.classUnderTest();

    @Override
    protected final UnmodifiableCharList classUnderTest() {
        return new UnmodifiableCharList(CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected UnmodifiableCharList newWith(char... elements) {
        return new UnmodifiableCharList(CharArrayList.newListWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex() {
        new UnmodifiableCharList(new CharArrayList()).addAtIndex(0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_greater_than_size() {
        new UnmodifiableCharList(new CharArrayList()).addAtIndex(1, (char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_negative() {
        this.list.addAtIndex(-1, (char) 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_negative() {
        this.list.addAllAtIndex(-1, (char) 5, (char) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_greater_than_size() {
        this.list.addAllAtIndex(5, (char) 5, (char) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_negative() {
        this.list.addAllAtIndex(-1, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_greater_than_size() {
        this.list.addAllAtIndex(5, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAtIndex() {
        this.list.removeAtIndex(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAtIndex_throws_index_greater_than_size() {
        new UnmodifiableCharList(new CharArrayList()).removeAtIndex(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAtIndex_throws_index_negative() {
        this.list.removeAtIndex(-1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void set() {
        this.list.set(1, (char) 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void swap() {
        this.list.swap(0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newWith().add((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf() {
        this.classUnderTest().removeIf(CharPredicates.equal((char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.classUnderTest().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.newWith().with((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.newWith().withAll(this.newMutableCollectionWith((char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).without((char) 9);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).withoutAll(this.newMutableCollectionWith((char) 8, (char) 9));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseThis() {
        new UnmodifiableCharList(new CharArrayList()).reverseThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortThis() {
        new UnmodifiableCharList(new CharArrayList()).sortThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortWithPrimitiveComparator() {
        new UnmodifiableCharList(new CharArrayList()).sortThis(Character::compare);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortWithOddEvenComparator() {
        new UnmodifiableCharList(new CharArrayList()).sortThis((a, b) -> (int) ((int) ((int) a & 1) - ((int) b & 1)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortWithKeyExtractorNaturalComparator() {
        new UnmodifiableCharList(new CharArrayList()).sortThisBy(Character::toString);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortWithKeyExtractorUnnaturalComparator() {
        new UnmodifiableCharList(new CharArrayList()).sortThisBy(Character::toString, Comparators.naturalOrder().reversed());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortShuffledInputWithDupes() {
        new UnmodifiableCharList(new CharArrayList()).sortThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortShuffledInput() {
        new UnmodifiableCharList(new CharArrayList()).sortThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortSortedInput() {
        new UnmodifiableCharList(new CharArrayList()).sortThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortReversedSortedInput() {
        new UnmodifiableCharList(new CharArrayList()).sortThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void shuffleThis() {
        new UnmodifiableCharList(new CharArrayList()).shuffleThis();
    }

    @Override
    @Test
    public void contains() {
        UnmodifiableCharList collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
        char[] numbers = { (char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1 };
        for (char number : numbers) {
            Assert.assertTrue(collection.contains(number));
        }
        Assert.assertFalse(collection.contains((char) -1));
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));
        UnmodifiableCharList collection1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(collection1.contains((char) 0));
        Assert.assertTrue(collection1.contains((char) 1));
        Assert.assertTrue(collection1.contains((char) 2));
        Assert.assertFalse(collection1.contains((char) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws_non_empty_collection() {
        UnmodifiableCharList collection = this.newWith((char) 1, (char) 2, (char) 3);
        CharIterator iterator = collection.charIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Assert.assertSame(this.list, this.list.asUnmodifiable());
        Assert.assertEquals(this.list, this.list.asUnmodifiable());
    }

    @Override
    @Test
    public void charIterator_with_remove() {
        UnmodifiableCharList unmodifiableCharList = this.classUnderTest();
        MutableCharIterator iterator = unmodifiableCharList.charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_remove_before_next() {
        UnmodifiableCharList unmodifiableCharList = this.classUnderTest();
        MutableCharIterator iterator = unmodifiableCharList.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_consecutive_remove() {
        // Not applicable for Unmodifiable*
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableCharListTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectIterableWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectIterableWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToLists() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToLists);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectPrimitivesToSets() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectPrimitivesToSets);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summaryStatistics() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summaryStatistics);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionNaturalOrder() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionNaturalOrder);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListByFunctionWithComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListByFunctionWithComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOnEmptyThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOnEmptyThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduce() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduce);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast_emptyList_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast_emptyList_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_dotProduct_throwsOnListsOfDifferentSizes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.dotProduct_throwsOnListsOfDifferentSizes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_lastIndexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.lastIndexOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_subList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.subList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_binarySearch() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.binarySearch);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toReversed() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toReversed);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachInBoth() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachInBoth);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithIndexWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithIndexWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAtIndex_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_greater_than_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_greater_than_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAtIndex_throws_index_negative() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAtIndex_throws_index_negative);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_set() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.set);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_swap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.swap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll_iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reverseThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reverseThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithPrimitiveComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithPrimitiveComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithOddEvenComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithOddEvenComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorNaturalComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithKeyExtractorNaturalComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortWithKeyExtractorUnnaturalComparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortWithKeyExtractorUnnaturalComparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInputWithDupes() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortShuffledInputWithDupes);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortShuffledInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortShuffledInput);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortSortedInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortSortedInput);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sortReversedSortedInput() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sortReversedSortedInput);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shuffleThis() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shuffleThis);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_for_consecutive_remove);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableCharListTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> get_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> get_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> getFirst_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> getLast_emptyList_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> dotProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> dotProduct_throwsOnListsOfDifferentSizes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> lastIndexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> subList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> binarySearch;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toReversed;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> forEachInBoth;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> selectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> selectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> rejectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> rejectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> injectIntoWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> zipChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAll_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAll_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAllIterable_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAllIterable_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> removeAtIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> removeAtIndex_throws_index_greater_than_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> removeAtIndex_throws_index_negative;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> set;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> swap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> reverseThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortWithPrimitiveComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortWithOddEvenComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortWithKeyExtractorNaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortWithKeyExtractorUnnaturalComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortShuffledInputWithDupes;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortShuffledInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> sortReversedSortedInput;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> shuffleThis;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharListTest> charIterator_throws_for_consecutive_remove;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = UnmodifiableCharListTest::newCollectionWith;
            this.payloads.newCollection = UnmodifiableCharListTest::newCollection;
            this.payloads.isEmpty = UnmodifiableCharListTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableCharListTest::notEmpty;
            this.payloads.tap = UnmodifiableCharListTest::tap;
            this.payloads.containsAllArray = UnmodifiableCharListTest::containsAllArray;
            this.payloads.containsAllIterable = UnmodifiableCharListTest::containsAllIterable;
            this.payloads.containsAnyArray = UnmodifiableCharListTest::containsAnyArray;
            this.payloads.containsAnyIterable = UnmodifiableCharListTest::containsAnyIterable;
            this.payloads.containsNoneArray = UnmodifiableCharListTest::containsNoneArray;
            this.payloads.containsNoneIterable = UnmodifiableCharListTest::containsNoneIterable;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.forEach = UnmodifiableCharListTest::forEach;
            this.payloads.size = UnmodifiableCharListTest::size;
            this.payloads.count = UnmodifiableCharListTest::count;
            this.payloads.anySatisfy = UnmodifiableCharListTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableCharListTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableCharListTest::noneSatisfy;
            this.payloads.collect = UnmodifiableCharListTest::collect;
            this.payloads.collectWithTarget = UnmodifiableCharListTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = UnmodifiableCharListTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = UnmodifiableCharListTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = UnmodifiableCharListTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = UnmodifiableCharListTest::collectPrimitivesToSets;
            this.payloads.select = UnmodifiableCharListTest::select;
            this.payloads.selectWithTarget = UnmodifiableCharListTest::selectWithTarget;
            this.payloads.reject = UnmodifiableCharListTest::reject;
            this.payloads.rejectWithTarget = UnmodifiableCharListTest::rejectWithTarget;
            this.payloads.detectIfNone = UnmodifiableCharListTest::detectIfNone;
            this.payloads.max = UnmodifiableCharListTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = UnmodifiableCharListTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableCharListTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableCharListTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableCharListTest::sum;
            this.payloads.summaryStatistics = UnmodifiableCharListTest::summaryStatistics;
            this.payloads.average = UnmodifiableCharListTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = UnmodifiableCharListTest::averageIfEmpty;
            this.payloads.median = UnmodifiableCharListTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = UnmodifiableCharListTest::medianIfEmpty;
            this.payloads.toArrayWithTargetArray = UnmodifiableCharListTest::toArrayWithTargetArray;
            this.payloads.toSortedArray = UnmodifiableCharListTest::toSortedArray;
            this.payloads.testHashCode = UnmodifiableCharListTest::testHashCode;
            this.payloads.toSortedList = UnmodifiableCharListTest::toSortedList;
            this.payloads.toSortedListByComparator = UnmodifiableCharListTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = UnmodifiableCharListTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = UnmodifiableCharListTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = UnmodifiableCharListTest::toSet;
            this.payloads.toBag = UnmodifiableCharListTest::toBag;
            this.payloads.asLazy = UnmodifiableCharListTest::asLazy;
            this.payloads.injectIntoBoolean = UnmodifiableCharListTest::injectIntoBoolean;
            this.payloads.injectIntoByte = UnmodifiableCharListTest::injectIntoByte;
            this.payloads.injectIntoChar = UnmodifiableCharListTest::injectIntoChar;
            this.payloads.injectIntoShort = UnmodifiableCharListTest::injectIntoShort;
            this.payloads.injectIntoInt = UnmodifiableCharListTest::injectIntoInt;
            this.payloads.injectIntoFloat = UnmodifiableCharListTest::injectIntoFloat;
            this.payloads.injectIntoLong = UnmodifiableCharListTest::injectIntoLong;
            this.payloads.injectIntoDouble = UnmodifiableCharListTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = UnmodifiableCharListTest::reduce;
            this.payloads.reduceIfEmpty = UnmodifiableCharListTest::reduceIfEmpty;
            this.payloads.chunk = UnmodifiableCharListTest::chunk;
            this.payloads.asSynchronized = UnmodifiableCharListTest::asSynchronized;
            this.payloads.newEmpty = UnmodifiableCharListTest::newEmpty;
            this.payloads.get = UnmodifiableCharListTest::get;
            this.payloads.get_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::get_throws_index_greater_than_size, java.lang.IndexOutOfBoundsException.class);
            this.payloads.get_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::get_throws_index_negative, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getFirst = UnmodifiableCharListTest::getFirst;
            this.payloads.getFirst_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::getFirst_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.getLast = UnmodifiableCharListTest::getLast;
            this.payloads.getLast_emptyList_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::getLast_emptyList_throws, java.lang.IndexOutOfBoundsException.class);
            this.payloads.dotProduct = UnmodifiableCharListTest::dotProduct;
            this.payloads.dotProduct_throwsOnListsOfDifferentSizes = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::dotProduct_throwsOnListsOfDifferentSizes, java.lang.IllegalArgumentException.class);
            this.payloads.indexOf = UnmodifiableCharListTest::indexOf;
            this.payloads.lastIndexOf = UnmodifiableCharListTest::lastIndexOf;
            this.payloads.subList = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::subList, java.lang.UnsupportedOperationException.class);
            this.payloads.charIterator = UnmodifiableCharListTest::charIterator;
            this.payloads.toArray = UnmodifiableCharListTest::toArray;
            this.payloads.binarySearch = UnmodifiableCharListTest::binarySearch;
            this.payloads.toReversed = UnmodifiableCharListTest::toReversed;
            this.payloads.forEachWithIndex = UnmodifiableCharListTest::forEachWithIndex;
            this.payloads.forEachInBoth = UnmodifiableCharListTest::forEachInBoth;
            this.payloads.selectWithIndex = UnmodifiableCharListTest::selectWithIndex;
            this.payloads.selectWithIndexWithTarget = UnmodifiableCharListTest::selectWithIndexWithTarget;
            this.payloads.rejectWithIndex = UnmodifiableCharListTest::rejectWithIndex;
            this.payloads.rejectWithIndexWithTarget = UnmodifiableCharListTest::rejectWithIndexWithTarget;
            this.payloads.collectWithIndex = UnmodifiableCharListTest::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = UnmodifiableCharListTest::collectWithIndexWithTarget;
            this.payloads.testEquals = UnmodifiableCharListTest::testEquals;
            this.payloads.testToString = UnmodifiableCharListTest::testToString;
            this.payloads.distinct = UnmodifiableCharListTest::distinct;
            this.payloads.makeString = UnmodifiableCharListTest::makeString;
            this.payloads.appendString = UnmodifiableCharListTest::appendString;
            this.payloads.toList = UnmodifiableCharListTest::toList;
            this.payloads.toImmutable = UnmodifiableCharListTest::toImmutable;
            this.payloads.injectInto = UnmodifiableCharListTest::injectInto;
            this.payloads.injectIntoWithIndex = UnmodifiableCharListTest::injectIntoWithIndex;
            this.payloads.zipChar = UnmodifiableCharListTest::zipChar;
            this.payloads.zip = UnmodifiableCharListTest::zip;
            this.payloads.addAtIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAtIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.addAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAtIndex_throws_index_greater_than_size, java.lang.UnsupportedOperationException.class);
            this.payloads.addAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAtIndex_throws_index_negative, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAll_throws_index_negative, java.lang.UnsupportedOperationException.class);
            this.payloads.addAll_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAll_throws_index_greater_than_size, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAllIterable_throws_index_negative, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAllIterable_throws_index_greater_than_size, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAtIndex = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::removeAtIndex, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAtIndex_throws_index_greater_than_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::removeAtIndex_throws_index_greater_than_size, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAtIndex_throws_index_negative = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::removeAtIndex_throws_index_negative, java.lang.UnsupportedOperationException.class);
            this.payloads.set = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::set, java.lang.UnsupportedOperationException.class);
            this.payloads.swap = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::swap, java.lang.UnsupportedOperationException.class);
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.add = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::add, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllArray = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAllArray, java.lang.UnsupportedOperationException.class);
            this.payloads.addAllIterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::addAllIterable, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::removeIf, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::removeAll, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::removeAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::retainAll, java.lang.UnsupportedOperationException.class);
            this.payloads.retainAll_iterable = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::retainAll_iterable, java.lang.UnsupportedOperationException.class);
            this.payloads.with = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::with, java.lang.UnsupportedOperationException.class);
            this.payloads.withAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::withAll, java.lang.UnsupportedOperationException.class);
            this.payloads.without = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::without, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAll = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::withoutAll, java.lang.UnsupportedOperationException.class);
            this.payloads.reverseThis = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::reverseThis, java.lang.UnsupportedOperationException.class);
            this.payloads.sortThis = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortThis, java.lang.UnsupportedOperationException.class);
            this.payloads.sortWithPrimitiveComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortWithPrimitiveComparator, java.lang.UnsupportedOperationException.class);
            this.payloads.sortWithOddEvenComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortWithOddEvenComparator, java.lang.UnsupportedOperationException.class);
            this.payloads.sortWithKeyExtractorNaturalComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortWithKeyExtractorNaturalComparator, java.lang.UnsupportedOperationException.class);
            this.payloads.sortWithKeyExtractorUnnaturalComparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortWithKeyExtractorUnnaturalComparator, java.lang.UnsupportedOperationException.class);
            this.payloads.sortShuffledInputWithDupes = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortShuffledInputWithDupes, java.lang.UnsupportedOperationException.class);
            this.payloads.sortShuffledInput = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortShuffledInput, java.lang.UnsupportedOperationException.class);
            this.payloads.sortSortedInput = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortSortedInput, java.lang.UnsupportedOperationException.class);
            this.payloads.sortReversedSortedInput = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::sortReversedSortedInput, java.lang.UnsupportedOperationException.class);
            this.payloads.shuffleThis = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::shuffleThis, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableCharListTest::contains;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharListTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.asUnmodifiable = UnmodifiableCharListTest::asUnmodifiable;
            this.payloads.charIterator_with_remove = UnmodifiableCharListTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = UnmodifiableCharListTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = UnmodifiableCharListTest::charIterator_throws_for_consecutive_remove;
        }
    }
}
