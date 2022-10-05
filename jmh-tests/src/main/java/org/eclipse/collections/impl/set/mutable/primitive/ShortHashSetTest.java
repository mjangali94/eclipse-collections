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
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class ShortHashSetTest extends AbstractShortSetTestCase {

    @Override
    protected final ShortHashSet classUnderTest() {
        return ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    protected ShortHashSet newWith(short... elements) {
        return (ShortHashSet) ShortSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = ShortHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        ShortHashSet hashSet = new ShortHashSet();
        Assert.assertEquals(16L, ((short[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = ShortHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        ShortHashSet hashSet = new ShortHashSet(3);
        Assert.assertEquals(8L, ((short[]) table.get(hashSet)).length);
        ShortHashSet hashSet2 = new ShortHashSet(10);
        Assert.assertEquals(32L, ((short[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ShortHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        ShortHashSet set = ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        ShortHashSet hashSetFromList = ShortHashSet.newSet(ShortArrayList.newListWith((short) 0, (short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
        ShortHashSet hashSetFromSet = ShortHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        ShortHashSet hashSet = new ShortHashSet();
        Assert.assertTrue(hashSet.add((short) 14));
        Assert.assertFalse(hashSet.add((short) 14));
        Assert.assertTrue(hashSet.add((short) 2));
        Assert.assertFalse(hashSet.add((short) 2));
        Assert.assertTrue(hashSet.add((short) 35));
        Assert.assertFalse(hashSet.add((short) 35));
        Assert.assertTrue(hashSet.add((short) 31));
        Assert.assertFalse(hashSet.add((short) 31));
        Assert.assertTrue(hashSet.add((short) 32));
        Assert.assertFalse(hashSet.add((short) 32));
        Assert.assertTrue(hashSet.add((short) 0));
        Assert.assertFalse(hashSet.add((short) 0));
        Assert.assertTrue(hashSet.add((short) 1));
        Assert.assertFalse(hashSet.add((short) 1));
        Field zeroToThirtyOne = ShortHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 14, (short) 2, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        ShortHashSet hashSet = new ShortHashSet();
        Assert.assertTrue(hashSet.addAll((short) 32, (short) 33, (short) 34, (short) 35, (short) 36, (short) 37, (short) 38, (short) 39));
        Field table = ShortHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) table.get(hashSet)).length);
        Field occupiedWithData = ShortHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 32, (short) 33, (short) 34, (short) 35, (short) 36, (short) 37, (short) 38, (short) 39), hashSet);
        hashSet.remove((short) 32);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add((short) 32);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add((short) 43));
        Assert.assertEquals(32L, ((short[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        ShortHashSet hashSet = new ShortHashSet();
        Assert.assertTrue(hashSet.addAll((short) 32, (short) 33, (short) 34, (short) 35, (short) 36, (short) 37, (short) 38, (short) 39));
        Field table = ShortHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) table.get(hashSet)).length);
        Field occupiedWithData = ShortHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = ShortHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove((short) (i + 32));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(ShortHashSet.newSetWith((short) 36, (short) 37, (short) 38, (short) 39), hashSet);
        Assert.assertTrue(hashSet.remove((short) 36));
        Assert.assertEquals(16L, ((short[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove((short) 36));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove((short) 1));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        ShortHashSet setForCopyTable = ShortHashSet.newSetWith((short) 36, (short) 37, (short) 38, (short) 39);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove((short) 36));
    }

    @Test
    public void iterator_remove() {
        MutableShortSet set1 = ShortSets.mutable.empty();
        int max = 65_536;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.shortValue());
        }
        // set2 to verify copyTable()
        MutableShortSet set2 = ShortSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableShortSet set, int max) {
        Verify.assertSize(max, set);
        MutableShortIterator iterator = set.shortIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new ShortHashSet());
        this.addAndRemoveData(new ShortHashSet(4));
        this.addAndRemoveData(new ShortHashSet(2));
        this.addAndRemoveData(new ShortHashSet(1));
        this.addAndRemoveData(new ShortHashSet(0));
    }

    private void addAndRemoveData(ShortHashSet hashSet) {
        for (short i = (short) 100; i < (short) 200; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        short collision1 = AbstractShortSetTestCase.generateCollisions1().getFirst();
        short collision2 = AbstractShortSetTestCase.generateCollisions1().get(1);
        short collision3 = AbstractShortSetTestCase.generateCollisions1().get(2);
        short collision4 = AbstractShortSetTestCase.generateCollisions1().get(3);
        ShortHashSet hashSet = new ShortHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(ShortHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        ShortHashSet hashSet2 = new ShortHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(ShortHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        ShortHashSet hashSet3 = new ShortHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(ShortHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        ShortHashSet hashSet = new ShortHashSet();
        short collision1 = AbstractShortSetTestCase.generateCollisions1().getFirst();
        short collision2 = AbstractShortSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(ShortHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        short collision1 = AbstractShortSetTestCase.generateCollisions1().getFirst();
        short collision2 = AbstractShortSetTestCase.generateCollisions1().get(1);
        short collision3 = AbstractShortSetTestCase.generateCollisions1().get(2);
        short collision4 = AbstractShortSetTestCase.generateCollisions1().get(3);
        short collision5 = AbstractShortSetTestCase.generateCollisions1().get(4);
        ShortHashSet hashSet = ShortHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(ShortHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(ShortHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(ShortHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        ShortHashSet hashSet = ShortHashSet.newSetWith();
        for (short i = (short) 0; i <= (short) 31; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (short i = (short) 0; i <= (short) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (short i = (short) 0; i <= (short) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new ShortHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortSets.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortHashSetTest instance;

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
        public void benchmark_shortIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws_for_consecutive_remove);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new ShortHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> shortIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> shortIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> shortIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> shortIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addWithCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addWithCollisionWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortHashSetTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = ShortHashSetTest::newCollectionWith;
            this.payloads.tap = ShortHashSetTest::tap;
            this.payloads.containsAllArray = ShortHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = ShortHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = ShortHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = ShortHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = ShortHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = ShortHashSetTest::containsNoneIterable;
            this.payloads.anySatisfy = ShortHashSetTest::anySatisfy;
            this.payloads.allSatisfy = ShortHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = ShortHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = ShortHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = ShortHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = ShortHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = ShortHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = ShortHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = ShortHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = ShortHashSetTest::rejectWithTarget;
            this.payloads.max = ShortHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = ShortHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ShortHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = ShortHashSetTest::maxIfEmpty;
            this.payloads.sum = ShortHashSetTest::sum;
            this.payloads.summaryStatistics = ShortHashSetTest::summaryStatistics;
            this.payloads.average = ShortHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = ShortHashSetTest::averageIfEmpty;
            this.payloads.median = ShortHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = ShortHashSetTest::medianIfEmpty;
            this.payloads.toArray = ShortHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = ShortHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = ShortHashSetTest::testToString;
            this.payloads.makeString = ShortHashSetTest::makeString;
            this.payloads.appendString = ShortHashSetTest::appendString;
            this.payloads.toList = ShortHashSetTest::toList;
            this.payloads.toSortedList = ShortHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = ShortHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = ShortHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = ShortHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = ShortHashSetTest::toSet;
            this.payloads.injectIntoBoolean = ShortHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = ShortHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = ShortHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = ShortHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = ShortHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = ShortHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = ShortHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = ShortHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = ShortHashSetTest::reduce;
            this.payloads.reduceIfEmpty = ShortHashSetTest::reduceIfEmpty;
            this.payloads.chunk = ShortHashSetTest::chunk;
            this.payloads.contains = ShortHashSetTest::contains;
            this.payloads.addAllArray = ShortHashSetTest::addAllArray;
            this.payloads.removeIf = ShortHashSetTest::removeIf;
            this.payloads.with = ShortHashSetTest::with;
            this.payloads.withAll = ShortHashSetTest::withAll;
            this.payloads.without = ShortHashSetTest::without;
            this.payloads.withoutAll = ShortHashSetTest::withoutAll;
            this.payloads.shortIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::shortIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.shortIterator_with_remove = ShortHashSetTest::shortIterator_with_remove;
            this.payloads.shortIterator_throws_for_remove_before_next = ShortHashSetTest::shortIterator_throws_for_remove_before_next;
            this.payloads.shortIterator_throws_for_consecutive_remove = ShortHashSetTest::shortIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = ShortHashSetTest::newEmpty;
            this.payloads.size = ShortHashSetTest::size;
            this.payloads.isEmpty = ShortHashSetTest::isEmpty;
            this.payloads.notEmpty = ShortHashSetTest::notEmpty;
            this.payloads.clear = ShortHashSetTest::clear;
            this.payloads.add = ShortHashSetTest::add;
            this.payloads.addAllIterable = ShortHashSetTest::addAllIterable;
            this.payloads.testOfAllFactory = ShortHashSetTest::testOfAllFactory;
            this.payloads.remove = ShortHashSetTest::remove;
            this.payloads.removeAll = ShortHashSetTest::removeAll;
            this.payloads.removeAll_iterable = ShortHashSetTest::removeAll_iterable;
            this.payloads.retainAll = ShortHashSetTest::retainAll;
            this.payloads.retainAll_iterable = ShortHashSetTest::retainAll_iterable;
            this.payloads.shortIterator = ShortHashSetTest::shortIterator;
            this.payloads.shortIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::shortIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = ShortHashSetTest::injectInto;
            this.payloads.forEach = ShortHashSetTest::forEach;
            this.payloads.count = ShortHashSetTest::count;
            this.payloads.select = ShortHashSetTest::select;
            this.payloads.reject = ShortHashSetTest::reject;
            this.payloads.detectIfNone = ShortHashSetTest::detectIfNone;
            this.payloads.collect = ShortHashSetTest::collect;
            this.payloads.toSortedArray = ShortHashSetTest::toSortedArray;
            this.payloads.testEquals = ShortHashSetTest::testEquals;
            this.payloads.testHashCode = ShortHashSetTest::testHashCode;
            this.payloads.toBag = ShortHashSetTest::toBag;
            this.payloads.asLazy = ShortHashSetTest::asLazy;
            this.payloads.asSynchronized = ShortHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortHashSetTest::asUnmodifiable;
            this.payloads.union = ShortHashSetTest::union;
            this.payloads.intersect = ShortHashSetTest::intersect;
            this.payloads.difference = ShortHashSetTest::difference;
            this.payloads.symmetricDifference = ShortHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = ShortHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = ShortHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = ShortHashSetTest::cartesianProduct;
            this.payloads.defaultInitialCapacity = ShortHashSetTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ShortHashSetTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = ShortHashSetTest::newCollection;
            this.payloads.addAndCheckField = ShortHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = ShortHashSetTest::addWithRehash;
            this.payloads.removeWithRehash = ShortHashSetTest::removeWithRehash;
            this.payloads.iterator_remove = ShortHashSetTest::iterator_remove;
            this.payloads.addEverySlot = ShortHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = ShortHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addWithCollision = ShortHashSetTest::addWithCollision;
            this.payloads.addWithCollisionWithRemovedSlot = ShortHashSetTest::addWithCollisionWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = ShortHashSetTest::addZeroToThirtyOne;
            this.payloads.classIsNonInstantiable = ShortHashSetTest::classIsNonInstantiable;
        }
    }
}
