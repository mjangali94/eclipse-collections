/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import java.lang.reflect.Field;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class CharHashSetTest extends AbstractCharSetTestCase {

    @Override
    protected final CharHashSet classUnderTest() {
        return CharHashSet.newSetWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected CharHashSet newWith(char... elements) {
        return (CharHashSet) CharSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        CharHashSet hashSet = new CharHashSet();
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        CharHashSet hashSet = new CharHashSet(3);
        Assert.assertEquals(8L, ((char[]) table.get(hashSet)).length);
        CharHashSet hashSet2 = new CharHashSet(10);
        Assert.assertEquals(32L, ((char[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        CharHashSet set = CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        CharHashSet hashSetFromList = CharHashSet.newSet(CharArrayList.newListWith((char) 0, (char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)));
        CharHashSet hashSetFromSet = CharHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.add((char) 14));
        Assert.assertFalse(hashSet.add((char) 14));
        Assert.assertTrue(hashSet.add((char) 2));
        Assert.assertFalse(hashSet.add((char) 2));
        Assert.assertTrue(hashSet.add((char) 35));
        Assert.assertFalse(hashSet.add((char) 35));
        Assert.assertTrue(hashSet.add((char) 31));
        Assert.assertFalse(hashSet.add((char) 31));
        Assert.assertTrue(hashSet.add((char) 32));
        Assert.assertFalse(hashSet.add((char) 32));
        Assert.assertTrue(hashSet.add((char) 0));
        Assert.assertFalse(hashSet.add((char) 0));
        Assert.assertTrue(hashSet.add((char) 1));
        Assert.assertFalse(hashSet.add((char) 1));
        Field zeroToThirtyOne = CharHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(CharHashSet.newSetWith((char) 14, (char) 2, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.addAll((char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39));
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
        Field occupiedWithData = CharHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(CharHashSet.newSetWith((char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39), hashSet);
        hashSet.remove((char) 32);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add((char) 32);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add((char) 43));
        Assert.assertEquals(32L, ((char[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.addAll((char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39));
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
        Field occupiedWithData = CharHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = CharHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove((char) (i + 32));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(CharHashSet.newSetWith((char) 36, (char) 37, (char) 38, (char) 39), hashSet);
        Assert.assertTrue(hashSet.remove((char) 36));
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove((char) 36));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove((char) 1));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        CharHashSet setForCopyTable = CharHashSet.newSetWith((char) 36, (char) 37, (char) 38, (char) 39);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove((char) 36));
    }

    @Test
    public void iterator_remove() {
        MutableCharSet set1 = CharSets.mutable.empty();
        int max = 10;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.toString().charAt(0));
        }
        // set2 to verify copyTable()
        MutableCharSet set2 = CharSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableCharSet set, int max) {
        Verify.assertSize(max, set);
        MutableCharIterator iterator = set.charIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new CharHashSet());
        this.addAndRemoveData(new CharHashSet(4));
        this.addAndRemoveData(new CharHashSet(2));
        this.addAndRemoveData(new CharHashSet(1));
        this.addAndRemoveData(new CharHashSet(0));
    }

    private void addAndRemoveData(CharHashSet hashSet) {
        for (char i = (char) 100; i < (char) 200; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        char collision1 = AbstractCharSetTestCase.generateCollisions1().getFirst();
        char collision2 = AbstractCharSetTestCase.generateCollisions1().get(1);
        char collision3 = AbstractCharSetTestCase.generateCollisions1().get(2);
        char collision4 = AbstractCharSetTestCase.generateCollisions1().get(3);
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(CharHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        CharHashSet hashSet2 = new CharHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(CharHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        CharHashSet hashSet3 = new CharHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(CharHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        CharHashSet hashSet = new CharHashSet();
        char collision1 = AbstractCharSetTestCase.generateCollisions1().getFirst();
        char collision2 = AbstractCharSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(CharHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        char collision1 = AbstractCharSetTestCase.generateCollisions1().getFirst();
        char collision2 = AbstractCharSetTestCase.generateCollisions1().get(1);
        char collision3 = AbstractCharSetTestCase.generateCollisions1().get(2);
        char collision4 = AbstractCharSetTestCase.generateCollisions1().get(3);
        char collision5 = AbstractCharSetTestCase.generateCollisions1().get(4);
        CharHashSet hashSet = CharHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(CharHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(CharHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(CharHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        CharHashSet hashSet = CharHashSet.newSetWith();
        for (char i = (char) 0; i <= (char) 31; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (char i = (char) 0; i <= (char) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (char i = (char) 0; i <= (char) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new CharHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharSets.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharHashSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_charIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws_non_empty_collection);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndCheckField() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAndCheckField);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addEverySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addEverySlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithCollision);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithCollisionWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithCollisionWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addZeroToThirtyOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addZeroToThirtyOne);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new CharHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> charIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> charIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> charIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> charIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addWithCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addWithCollisionWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharHashSetTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = CharHashSetTest::newCollectionWith;
            this.payloads.tap = CharHashSetTest::tap;
            this.payloads.containsAllArray = CharHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = CharHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = CharHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = CharHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = CharHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = CharHashSetTest::containsNoneIterable;
            this.payloads.anySatisfy = CharHashSetTest::anySatisfy;
            this.payloads.allSatisfy = CharHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = CharHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = CharHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = CharHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = CharHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = CharHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = CharHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = CharHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = CharHashSetTest::rejectWithTarget;
            this.payloads.max = CharHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = CharHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharHashSetTest::maxIfEmpty;
            this.payloads.sum = CharHashSetTest::sum;
            this.payloads.summaryStatistics = CharHashSetTest::summaryStatistics;
            this.payloads.average = CharHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = CharHashSetTest::averageIfEmpty;
            this.payloads.median = CharHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = CharHashSetTest::medianIfEmpty;
            this.payloads.toArray = CharHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = CharHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = CharHashSetTest::testToString;
            this.payloads.makeString = CharHashSetTest::makeString;
            this.payloads.appendString = CharHashSetTest::appendString;
            this.payloads.toList = CharHashSetTest::toList;
            this.payloads.toSortedList = CharHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = CharHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = CharHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = CharHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = CharHashSetTest::toSet;
            this.payloads.injectIntoBoolean = CharHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = CharHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = CharHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = CharHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = CharHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = CharHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = CharHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = CharHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = CharHashSetTest::reduce;
            this.payloads.reduceIfEmpty = CharHashSetTest::reduceIfEmpty;
            this.payloads.chunk = CharHashSetTest::chunk;
            this.payloads.contains = CharHashSetTest::contains;
            this.payloads.addAllArray = CharHashSetTest::addAllArray;
            this.payloads.removeIf = CharHashSetTest::removeIf;
            this.payloads.with = CharHashSetTest::with;
            this.payloads.withAll = CharHashSetTest::withAll;
            this.payloads.without = CharHashSetTest::without;
            this.payloads.withoutAll = CharHashSetTest::withoutAll;
            this.payloads.charIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::charIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.charIterator_with_remove = CharHashSetTest::charIterator_with_remove;
            this.payloads.charIterator_throws_for_remove_before_next = CharHashSetTest::charIterator_throws_for_remove_before_next;
            this.payloads.charIterator_throws_for_consecutive_remove = CharHashSetTest::charIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = CharHashSetTest::newEmpty;
            this.payloads.size = CharHashSetTest::size;
            this.payloads.isEmpty = CharHashSetTest::isEmpty;
            this.payloads.notEmpty = CharHashSetTest::notEmpty;
            this.payloads.clear = CharHashSetTest::clear;
            this.payloads.add = CharHashSetTest::add;
            this.payloads.addAllIterable = CharHashSetTest::addAllIterable;
            this.payloads.testOfAllFactory = CharHashSetTest::testOfAllFactory;
            this.payloads.remove = CharHashSetTest::remove;
            this.payloads.removeAll = CharHashSetTest::removeAll;
            this.payloads.removeAll_iterable = CharHashSetTest::removeAll_iterable;
            this.payloads.retainAll = CharHashSetTest::retainAll;
            this.payloads.retainAll_iterable = CharHashSetTest::retainAll_iterable;
            this.payloads.charIterator = CharHashSetTest::charIterator;
            this.payloads.charIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::charIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = CharHashSetTest::injectInto;
            this.payloads.forEach = CharHashSetTest::forEach;
            this.payloads.count = CharHashSetTest::count;
            this.payloads.select = CharHashSetTest::select;
            this.payloads.reject = CharHashSetTest::reject;
            this.payloads.detectIfNone = CharHashSetTest::detectIfNone;
            this.payloads.collect = CharHashSetTest::collect;
            this.payloads.toSortedArray = CharHashSetTest::toSortedArray;
            this.payloads.testEquals = CharHashSetTest::testEquals;
            this.payloads.testHashCode = CharHashSetTest::testHashCode;
            this.payloads.toBag = CharHashSetTest::toBag;
            this.payloads.asLazy = CharHashSetTest::asLazy;
            this.payloads.asSynchronized = CharHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = CharHashSetTest::asUnmodifiable;
            this.payloads.union = CharHashSetTest::union;
            this.payloads.intersect = CharHashSetTest::intersect;
            this.payloads.difference = CharHashSetTest::difference;
            this.payloads.symmetricDifference = CharHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = CharHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = CharHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = CharHashSetTest::cartesianProduct;
            this.payloads.defaultInitialCapacity = CharHashSetTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = CharHashSetTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = CharHashSetTest::newCollection;
            this.payloads.addAndCheckField = CharHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = CharHashSetTest::addWithRehash;
            this.payloads.removeWithRehash = CharHashSetTest::removeWithRehash;
            this.payloads.iterator_remove = CharHashSetTest::iterator_remove;
            this.payloads.addEverySlot = CharHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = CharHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addWithCollision = CharHashSetTest::addWithCollision;
            this.payloads.addWithCollisionWithRemovedSlot = CharHashSetTest::addWithCollisionWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = CharHashSetTest::addZeroToThirtyOne;
            this.payloads.classIsNonInstantiable = CharHashSetTest::classIsNonInstantiable;
        }
    }
}
