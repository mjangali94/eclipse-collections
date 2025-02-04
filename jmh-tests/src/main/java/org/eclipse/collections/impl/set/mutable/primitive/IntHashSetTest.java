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
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class IntHashSetTest extends AbstractIntSetTestCase {

    @Override
    protected final IntHashSet classUnderTest() {
        return IntHashSet.newSetWith(1, 2, 3);
    }

    @Override
    protected IntHashSet newWith(int... elements) {
        return (IntHashSet) IntSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = IntHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        IntHashSet hashSet = new IntHashSet();
        Assert.assertEquals(16L, ((int[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = IntHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        IntHashSet hashSet = new IntHashSet(3);
        Assert.assertEquals(8L, ((int[]) table.get(hashSet)).length);
        IntHashSet hashSet2 = new IntHashSet(10);
        Assert.assertEquals(32L, ((int[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new IntHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        IntHashSet set = IntHashSet.newSetWith(0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1));
        IntHashSet hashSetFromList = IntHashSet.newSet(IntArrayList.newListWith(0, 0, 1, 31, AbstractIntSetTestCase.generateCollisions1().getFirst(), AbstractIntSetTestCase.generateCollisions1().get(1)));
        IntHashSet hashSetFromSet = IntHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        IntHashSet hashSet = new IntHashSet();
        Assert.assertTrue(hashSet.add(14));
        Assert.assertFalse(hashSet.add(14));
        Assert.assertTrue(hashSet.add(2));
        Assert.assertFalse(hashSet.add(2));
        Assert.assertTrue(hashSet.add(35));
        Assert.assertFalse(hashSet.add(35));
        Assert.assertTrue(hashSet.add(31));
        Assert.assertFalse(hashSet.add(31));
        Assert.assertTrue(hashSet.add(32));
        Assert.assertFalse(hashSet.add(32));
        Assert.assertTrue(hashSet.add(0));
        Assert.assertFalse(hashSet.add(0));
        Assert.assertTrue(hashSet.add(1));
        Assert.assertFalse(hashSet.add(1));
        Field zeroToThirtyOne = IntHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(IntHashSet.newSetWith(14, 2, 31, 32, 35, 0, 1), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        IntHashSet hashSet = new IntHashSet();
        Assert.assertTrue(hashSet.addAll(32, 33, 34, 35, 36, 37, 38, 39));
        Field table = IntHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) table.get(hashSet)).length);
        Field occupiedWithData = IntHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(IntHashSet.newSetWith(32, 33, 34, 35, 36, 37, 38, 39), hashSet);
        hashSet.remove(32);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add(32);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add(43));
        Assert.assertEquals(32L, ((int[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        IntHashSet hashSet = new IntHashSet();
        Assert.assertTrue(hashSet.addAll(32, 33, 34, 35, 36, 37, 38, 39));
        Field table = IntHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) table.get(hashSet)).length);
        Field occupiedWithData = IntHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = IntHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove(i + 32);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(IntHashSet.newSetWith(36, 37, 38, 39), hashSet);
        Assert.assertTrue(hashSet.remove(36));
        Assert.assertEquals(16L, ((int[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(36));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(1));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        IntHashSet setForCopyTable = IntHashSet.newSetWith(36, 37, 38, 39);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove(36));
    }

    @Test
    public void iterator_remove() {
        MutableIntSet set1 = IntSets.mutable.empty();
        int max = 100_000;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.intValue());
        }
        // set2 to verify copyTable()
        MutableIntSet set2 = IntSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableIntSet set, int max) {
        Verify.assertSize(max, set);
        MutableIntIterator iterator = set.intIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new IntHashSet());
        this.addAndRemoveData(new IntHashSet(4));
        this.addAndRemoveData(new IntHashSet(2));
        this.addAndRemoveData(new IntHashSet(1));
        this.addAndRemoveData(new IntHashSet(0));
    }

    private void addAndRemoveData(IntHashSet hashSet) {
        for (int i = 100; i < 200; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        int collision1 = AbstractIntSetTestCase.generateCollisions1().getFirst();
        int collision2 = AbstractIntSetTestCase.generateCollisions1().get(1);
        int collision3 = AbstractIntSetTestCase.generateCollisions1().get(2);
        int collision4 = AbstractIntSetTestCase.generateCollisions1().get(3);
        IntHashSet hashSet = new IntHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(IntHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        IntHashSet hashSet2 = new IntHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(IntHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        IntHashSet hashSet3 = new IntHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(IntHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        IntHashSet hashSet = new IntHashSet();
        int collision1 = AbstractIntSetTestCase.generateCollisions1().getFirst();
        int collision2 = AbstractIntSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(IntHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        int collision1 = AbstractIntSetTestCase.generateCollisions1().getFirst();
        int collision2 = AbstractIntSetTestCase.generateCollisions1().get(1);
        int collision3 = AbstractIntSetTestCase.generateCollisions1().get(2);
        int collision4 = AbstractIntSetTestCase.generateCollisions1().get(3);
        int collision5 = AbstractIntSetTestCase.generateCollisions1().get(4);
        IntHashSet hashSet = IntHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(IntHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(IntHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(IntHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        IntHashSet hashSet = IntHashSet.newSetWith();
        for (int i = 0; i <= 31; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (int i = 0; i <= 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (int i = 0; i <= 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new IntHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntSets.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntHashSetTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_selectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWithTarget);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArrayWithTargetArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArrayWithTargetArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
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
        public void benchmark_intIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_non_empty_collection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws_for_consecutive_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testOfAllFactory() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testOfAllFactory);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_union() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.union);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intersect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intersect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_difference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.difference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_symmetricDifference() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.symmetricDifference);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isProperSubsetOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isProperSubsetOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_cartesianProduct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.cartesianProduct);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndCheckField() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAndCheckField);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addEverySlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addEverySlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithCollision() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithCollision);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithCollisionWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addWithCollisionWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addZeroToThirtyOne() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addZeroToThirtyOne);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new IntHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addWithCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addWithCollisionWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntHashSetTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = IntHashSetTest::newCollectionWith;
            this.payloads.tap = IntHashSetTest::tap;
            this.payloads.containsAllArray = IntHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = IntHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = IntHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = IntHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = IntHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = IntHashSetTest::containsNoneIterable;
            this.payloads.anySatisfy = IntHashSetTest::anySatisfy;
            this.payloads.allSatisfy = IntHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = IntHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = IntHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = IntHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = IntHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = IntHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = IntHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = IntHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = IntHashSetTest::rejectWithTarget;
            this.payloads.max = IntHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = IntHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntHashSetTest::maxIfEmpty;
            this.payloads.sum = IntHashSetTest::sum;
            this.payloads.summaryStatistics = IntHashSetTest::summaryStatistics;
            this.payloads.average = IntHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = IntHashSetTest::averageIfEmpty;
            this.payloads.median = IntHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = IntHashSetTest::medianIfEmpty;
            this.payloads.toArray = IntHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = IntHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = IntHashSetTest::testToString;
            this.payloads.makeString = IntHashSetTest::makeString;
            this.payloads.appendString = IntHashSetTest::appendString;
            this.payloads.toList = IntHashSetTest::toList;
            this.payloads.toSortedList = IntHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = IntHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = IntHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = IntHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = IntHashSetTest::toSet;
            this.payloads.injectIntoBoolean = IntHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = IntHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = IntHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = IntHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = IntHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = IntHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = IntHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = IntHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = IntHashSetTest::reduce;
            this.payloads.reduceIfEmpty = IntHashSetTest::reduceIfEmpty;
            this.payloads.chunk = IntHashSetTest::chunk;
            this.payloads.contains = IntHashSetTest::contains;
            this.payloads.addAllArray = IntHashSetTest::addAllArray;
            this.payloads.removeIf = IntHashSetTest::removeIf;
            this.payloads.with = IntHashSetTest::with;
            this.payloads.withAll = IntHashSetTest::withAll;
            this.payloads.without = IntHashSetTest::without;
            this.payloads.withoutAll = IntHashSetTest::withoutAll;
            this.payloads.intIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::intIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.intIterator_with_remove = IntHashSetTest::intIterator_with_remove;
            this.payloads.intIterator_throws_for_remove_before_next = IntHashSetTest::intIterator_throws_for_remove_before_next;
            this.payloads.intIterator_throws_for_consecutive_remove = IntHashSetTest::intIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = IntHashSetTest::newEmpty;
            this.payloads.size = IntHashSetTest::size;
            this.payloads.isEmpty = IntHashSetTest::isEmpty;
            this.payloads.notEmpty = IntHashSetTest::notEmpty;
            this.payloads.clear = IntHashSetTest::clear;
            this.payloads.add = IntHashSetTest::add;
            this.payloads.addAllIterable = IntHashSetTest::addAllIterable;
            this.payloads.testOfAllFactory = IntHashSetTest::testOfAllFactory;
            this.payloads.remove = IntHashSetTest::remove;
            this.payloads.removeAll = IntHashSetTest::removeAll;
            this.payloads.removeAll_iterable = IntHashSetTest::removeAll_iterable;
            this.payloads.retainAll = IntHashSetTest::retainAll;
            this.payloads.retainAll_iterable = IntHashSetTest::retainAll_iterable;
            this.payloads.intIterator = IntHashSetTest::intIterator;
            this.payloads.intIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::intIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = IntHashSetTest::injectInto;
            this.payloads.forEach = IntHashSetTest::forEach;
            this.payloads.count = IntHashSetTest::count;
            this.payloads.select = IntHashSetTest::select;
            this.payloads.reject = IntHashSetTest::reject;
            this.payloads.detectIfNone = IntHashSetTest::detectIfNone;
            this.payloads.collect = IntHashSetTest::collect;
            this.payloads.toSortedArray = IntHashSetTest::toSortedArray;
            this.payloads.testEquals = IntHashSetTest::testEquals;
            this.payloads.testHashCode = IntHashSetTest::testHashCode;
            this.payloads.toBag = IntHashSetTest::toBag;
            this.payloads.asLazy = IntHashSetTest::asLazy;
            this.payloads.asSynchronized = IntHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = IntHashSetTest::asUnmodifiable;
            this.payloads.union = IntHashSetTest::union;
            this.payloads.intersect = IntHashSetTest::intersect;
            this.payloads.difference = IntHashSetTest::difference;
            this.payloads.symmetricDifference = IntHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = IntHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = IntHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = IntHashSetTest::cartesianProduct;
            this.payloads.defaultInitialCapacity = IntHashSetTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = IntHashSetTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = IntHashSetTest::newCollection;
            this.payloads.addAndCheckField = IntHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = IntHashSetTest::addWithRehash;
            this.payloads.removeWithRehash = IntHashSetTest::removeWithRehash;
            this.payloads.iterator_remove = IntHashSetTest::iterator_remove;
            this.payloads.addEverySlot = IntHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = IntHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addWithCollision = IntHashSetTest::addWithCollision;
            this.payloads.addWithCollisionWithRemovedSlot = IntHashSetTest::addWithCollisionWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = IntHashSetTest::addZeroToThirtyOne;
            this.payloads.classIsNonInstantiable = IntHashSetTest::classIsNonInstantiable;
        }
    }
*/
}
