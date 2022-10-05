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
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class LongHashSetTest extends AbstractLongSetTestCase {

    @Override
    protected final LongHashSet classUnderTest() {
        return LongHashSet.newSetWith(1L, 2L, 3L);
    }

    @Override
    protected LongHashSet newWith(long... elements) {
        return (LongHashSet) LongSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = LongHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        LongHashSet hashSet = new LongHashSet();
        Assert.assertEquals(16L, ((long[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = LongHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        LongHashSet hashSet = new LongHashSet(3);
        Assert.assertEquals(8L, ((long[]) table.get(hashSet)).length);
        LongHashSet hashSet2 = new LongHashSet(10);
        Assert.assertEquals(32L, ((long[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new LongHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        LongHashSet set = LongHashSet.newSetWith(0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1));
        LongHashSet hashSetFromList = LongHashSet.newSet(LongArrayList.newListWith(0L, 0L, 1L, 31L, AbstractLongSetTestCase.generateCollisions1().getFirst(), AbstractLongSetTestCase.generateCollisions1().get(1)));
        LongHashSet hashSetFromSet = LongHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        LongHashSet hashSet = new LongHashSet();
        Assert.assertTrue(hashSet.add(14L));
        Assert.assertFalse(hashSet.add(14L));
        Assert.assertTrue(hashSet.add(2L));
        Assert.assertFalse(hashSet.add(2L));
        Assert.assertTrue(hashSet.add(35L));
        Assert.assertFalse(hashSet.add(35L));
        Assert.assertTrue(hashSet.add(31L));
        Assert.assertFalse(hashSet.add(31L));
        Assert.assertTrue(hashSet.add(32L));
        Assert.assertFalse(hashSet.add(32L));
        Assert.assertTrue(hashSet.add(0L));
        Assert.assertFalse(hashSet.add(0L));
        Assert.assertTrue(hashSet.add(1L));
        Assert.assertFalse(hashSet.add(1L));
        Field zeroToThirtyOne = LongHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(LongHashSet.newSetWith(14L, 2L, 31L, 32L, 35L, 0L, 1L), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        LongHashSet hashSet = new LongHashSet();
        Assert.assertTrue(hashSet.addAll(32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L));
        Field table = LongHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) table.get(hashSet)).length);
        Field occupiedWithData = LongHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(LongHashSet.newSetWith(32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L), hashSet);
        hashSet.remove(32L);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add(32L);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add(43L));
        Assert.assertEquals(32L, ((long[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        LongHashSet hashSet = new LongHashSet();
        Assert.assertTrue(hashSet.addAll(32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L));
        Field table = LongHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) table.get(hashSet)).length);
        Field occupiedWithData = LongHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = LongHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove(i + 32);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(LongHashSet.newSetWith(36L, 37L, 38L, 39L), hashSet);
        Assert.assertTrue(hashSet.remove(36L));
        Assert.assertEquals(16L, ((long[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(36L));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(1L));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        LongHashSet setForCopyTable = LongHashSet.newSetWith(36L, 37L, 38L, 39L);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove(36L));
    }

    @Test
    public void iterator_remove() {
        MutableLongSet set1 = LongSets.mutable.empty();
        int max = 100_000;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.longValue());
        }
        // set2 to verify copyTable()
        MutableLongSet set2 = LongSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableLongSet set, int max) {
        Verify.assertSize(max, set);
        MutableLongIterator iterator = set.longIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new LongHashSet());
        this.addAndRemoveData(new LongHashSet(4));
        this.addAndRemoveData(new LongHashSet(2));
        this.addAndRemoveData(new LongHashSet(1));
        this.addAndRemoveData(new LongHashSet(0));
    }

    private void addAndRemoveData(LongHashSet hashSet) {
        for (long i = 100L; i < 200L; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        long collision1 = AbstractLongSetTestCase.generateCollisions1().getFirst();
        long collision2 = AbstractLongSetTestCase.generateCollisions1().get(1);
        long collision3 = AbstractLongSetTestCase.generateCollisions1().get(2);
        long collision4 = AbstractLongSetTestCase.generateCollisions1().get(3);
        LongHashSet hashSet = new LongHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(LongHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        LongHashSet hashSet2 = new LongHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(LongHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        LongHashSet hashSet3 = new LongHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(LongHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        LongHashSet hashSet = new LongHashSet();
        long collision1 = AbstractLongSetTestCase.generateCollisions1().getFirst();
        long collision2 = AbstractLongSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(LongHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        long collision1 = AbstractLongSetTestCase.generateCollisions1().getFirst();
        long collision2 = AbstractLongSetTestCase.generateCollisions1().get(1);
        long collision3 = AbstractLongSetTestCase.generateCollisions1().get(2);
        long collision4 = AbstractLongSetTestCase.generateCollisions1().get(3);
        long collision5 = AbstractLongSetTestCase.generateCollisions1().get(4);
        LongHashSet hashSet = LongHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(LongHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(LongHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(LongHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        LongHashSet hashSet = LongHashSet.newSetWith();
        for (long i = 0L; i <= 31L; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (long i = 0L; i <= 31L; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (long i = 0L; i <= 31L; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new LongHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongSets.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongHashSetTest instance;

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
        public void benchmark_longIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws_for_consecutive_remove);
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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new LongHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> longIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> longIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> longIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> longIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addWithCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addWithCollisionWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongHashSetTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = LongHashSetTest::newCollectionWith;
            this.payloads.tap = LongHashSetTest::tap;
            this.payloads.containsAllArray = LongHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = LongHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = LongHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = LongHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = LongHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = LongHashSetTest::containsNoneIterable;
            this.payloads.anySatisfy = LongHashSetTest::anySatisfy;
            this.payloads.allSatisfy = LongHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = LongHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = LongHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = LongHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = LongHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = LongHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = LongHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = LongHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = LongHashSetTest::rejectWithTarget;
            this.payloads.max = LongHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = LongHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongHashSetTest::maxIfEmpty;
            this.payloads.sum = LongHashSetTest::sum;
            this.payloads.summaryStatistics = LongHashSetTest::summaryStatistics;
            this.payloads.average = LongHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = LongHashSetTest::averageIfEmpty;
            this.payloads.median = LongHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = LongHashSetTest::medianIfEmpty;
            this.payloads.toArray = LongHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = LongHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = LongHashSetTest::testToString;
            this.payloads.makeString = LongHashSetTest::makeString;
            this.payloads.appendString = LongHashSetTest::appendString;
            this.payloads.toList = LongHashSetTest::toList;
            this.payloads.toSortedList = LongHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = LongHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = LongHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = LongHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = LongHashSetTest::toSet;
            this.payloads.injectIntoBoolean = LongHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = LongHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = LongHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = LongHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = LongHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = LongHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = LongHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = LongHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = LongHashSetTest::reduce;
            this.payloads.reduceIfEmpty = LongHashSetTest::reduceIfEmpty;
            this.payloads.chunk = LongHashSetTest::chunk;
            this.payloads.contains = LongHashSetTest::contains;
            this.payloads.addAllArray = LongHashSetTest::addAllArray;
            this.payloads.removeIf = LongHashSetTest::removeIf;
            this.payloads.with = LongHashSetTest::with;
            this.payloads.withAll = LongHashSetTest::withAll;
            this.payloads.without = LongHashSetTest::without;
            this.payloads.withoutAll = LongHashSetTest::withoutAll;
            this.payloads.longIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::longIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.longIterator_with_remove = LongHashSetTest::longIterator_with_remove;
            this.payloads.longIterator_throws_for_remove_before_next = LongHashSetTest::longIterator_throws_for_remove_before_next;
            this.payloads.longIterator_throws_for_consecutive_remove = LongHashSetTest::longIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = LongHashSetTest::newEmpty;
            this.payloads.size = LongHashSetTest::size;
            this.payloads.isEmpty = LongHashSetTest::isEmpty;
            this.payloads.notEmpty = LongHashSetTest::notEmpty;
            this.payloads.clear = LongHashSetTest::clear;
            this.payloads.add = LongHashSetTest::add;
            this.payloads.addAllIterable = LongHashSetTest::addAllIterable;
            this.payloads.testOfAllFactory = LongHashSetTest::testOfAllFactory;
            this.payloads.remove = LongHashSetTest::remove;
            this.payloads.removeAll = LongHashSetTest::removeAll;
            this.payloads.removeAll_iterable = LongHashSetTest::removeAll_iterable;
            this.payloads.retainAll = LongHashSetTest::retainAll;
            this.payloads.retainAll_iterable = LongHashSetTest::retainAll_iterable;
            this.payloads.longIterator = LongHashSetTest::longIterator;
            this.payloads.longIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::longIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = LongHashSetTest::injectInto;
            this.payloads.forEach = LongHashSetTest::forEach;
            this.payloads.count = LongHashSetTest::count;
            this.payloads.select = LongHashSetTest::select;
            this.payloads.reject = LongHashSetTest::reject;
            this.payloads.detectIfNone = LongHashSetTest::detectIfNone;
            this.payloads.collect = LongHashSetTest::collect;
            this.payloads.toSortedArray = LongHashSetTest::toSortedArray;
            this.payloads.testEquals = LongHashSetTest::testEquals;
            this.payloads.testHashCode = LongHashSetTest::testHashCode;
            this.payloads.toBag = LongHashSetTest::toBag;
            this.payloads.asLazy = LongHashSetTest::asLazy;
            this.payloads.asSynchronized = LongHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = LongHashSetTest::asUnmodifiable;
            this.payloads.union = LongHashSetTest::union;
            this.payloads.intersect = LongHashSetTest::intersect;
            this.payloads.difference = LongHashSetTest::difference;
            this.payloads.symmetricDifference = LongHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = LongHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = LongHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = LongHashSetTest::cartesianProduct;
            this.payloads.defaultInitialCapacity = LongHashSetTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = LongHashSetTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = LongHashSetTest::newCollection;
            this.payloads.addAndCheckField = LongHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = LongHashSetTest::addWithRehash;
            this.payloads.removeWithRehash = LongHashSetTest::removeWithRehash;
            this.payloads.iterator_remove = LongHashSetTest::iterator_remove;
            this.payloads.addEverySlot = LongHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = LongHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addWithCollision = LongHashSetTest::addWithCollision;
            this.payloads.addWithCollisionWithRemovedSlot = LongHashSetTest::addWithCollisionWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = LongHashSetTest::addZeroToThirtyOne;
            this.payloads.classIsNonInstantiable = LongHashSetTest::classIsNonInstantiable;
        }
    }
}
