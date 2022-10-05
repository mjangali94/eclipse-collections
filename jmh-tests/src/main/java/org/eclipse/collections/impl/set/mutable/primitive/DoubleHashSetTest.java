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
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class DoubleHashSetTest extends AbstractDoubleSetTestCase {

    @Override
    protected final DoubleHashSet classUnderTest() {
        return DoubleHashSet.newSetWith(1.0, 2.0, 3.0);
    }

    @Override
    protected DoubleHashSet newWith(double... elements) {
        return (DoubleHashSet) DoubleSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = DoubleHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        DoubleHashSet hashSet = new DoubleHashSet();
        Assert.assertEquals(16L, ((double[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = DoubleHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        DoubleHashSet hashSet = new DoubleHashSet(3);
        Assert.assertEquals(8L, ((double[]) table.get(hashSet)).length);
        DoubleHashSet hashSet2 = new DoubleHashSet(10);
        Assert.assertEquals(32L, ((double[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        DoubleHashSet set = DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        DoubleHashSet hashSetFromList = DoubleHashSet.newSet(DoubleArrayList.newListWith(0.0, 0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        DoubleHashSet hashSetFromSet = DoubleHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        DoubleHashSet hashSet = new DoubleHashSet();
        Assert.assertTrue(hashSet.add(14.0));
        Assert.assertFalse(hashSet.add(14.0));
        Assert.assertTrue(hashSet.add(2.0));
        Assert.assertFalse(hashSet.add(2.0));
        Assert.assertTrue(hashSet.add(35.0));
        Assert.assertFalse(hashSet.add(35.0));
        Assert.assertTrue(hashSet.add(31.0));
        Assert.assertFalse(hashSet.add(31.0));
        Assert.assertTrue(hashSet.add(32.0));
        Assert.assertFalse(hashSet.add(32.0));
        Assert.assertTrue(hashSet.add(0.0));
        Assert.assertFalse(hashSet.add(0.0));
        Assert.assertTrue(hashSet.add(1.0));
        Assert.assertFalse(hashSet.add(1.0));
        Field zeroToThirtyOne = DoubleHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(DoubleHashSet.newSetWith(14.0, 2.0, 31.0, 32.0, 35.0, 0.0, 1.0), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        DoubleHashSet hashSet = new DoubleHashSet();
        Assert.assertTrue(hashSet.addAll(32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0));
        Field table = DoubleHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) table.get(hashSet)).length);
        Field occupiedWithData = DoubleHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(DoubleHashSet.newSetWith(32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0), hashSet);
        hashSet.remove(32.0);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add(32.0);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add(43.0));
        Assert.assertEquals(32L, ((double[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        DoubleHashSet hashSet = new DoubleHashSet();
        Assert.assertTrue(hashSet.addAll(32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0));
        Field table = DoubleHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) table.get(hashSet)).length);
        Field occupiedWithData = DoubleHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = DoubleHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove(i + 32);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(DoubleHashSet.newSetWith(36.0, 37.0, 38.0, 39.0), hashSet);
        Assert.assertTrue(hashSet.remove(36.0));
        Assert.assertEquals(16L, ((double[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(36.0));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(1.0));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        DoubleHashSet setForCopyTable = DoubleHashSet.newSetWith(36.0, 37.0, 38.0, 39.0);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove(36.0));
    }

    @Test
    public void iterator_remove() {
        MutableDoubleSet set1 = DoubleSets.mutable.empty();
        int max = 100_000;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.doubleValue());
        }
        // set2 to verify copyTable()
        MutableDoubleSet set2 = DoubleSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableDoubleSet set, int max) {
        Verify.assertSize(max, set);
        MutableDoubleIterator iterator = set.doubleIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new DoubleHashSet());
        this.addAndRemoveData(new DoubleHashSet(4));
        this.addAndRemoveData(new DoubleHashSet(2));
        this.addAndRemoveData(new DoubleHashSet(1));
        this.addAndRemoveData(new DoubleHashSet(0));
    }

    private void addAndRemoveData(DoubleHashSet hashSet) {
        for (double i = 100.0; i < 200.0; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        double collision1 = AbstractDoubleSetTestCase.generateCollisions1().getFirst();
        double collision2 = AbstractDoubleSetTestCase.generateCollisions1().get(1);
        double collision3 = AbstractDoubleSetTestCase.generateCollisions1().get(2);
        double collision4 = AbstractDoubleSetTestCase.generateCollisions1().get(3);
        DoubleHashSet hashSet = new DoubleHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        DoubleHashSet hashSet2 = new DoubleHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        DoubleHashSet hashSet3 = new DoubleHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        DoubleHashSet hashSet = new DoubleHashSet();
        double collision1 = AbstractDoubleSetTestCase.generateCollisions1().getFirst();
        double collision2 = AbstractDoubleSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        double collision1 = AbstractDoubleSetTestCase.generateCollisions1().getFirst();
        double collision2 = AbstractDoubleSetTestCase.generateCollisions1().get(1);
        double collision3 = AbstractDoubleSetTestCase.generateCollisions1().get(2);
        double collision4 = AbstractDoubleSetTestCase.generateCollisions1().get(3);
        double collision5 = AbstractDoubleSetTestCase.generateCollisions1().get(4);
        DoubleHashSet hashSet = DoubleHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(DoubleHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        DoubleHashSet hashSet = DoubleHashSet.newSetWith();
        for (double i = 0.0; i <= 31.0; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (double i = 0.0; i <= 31.0; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (double i = 0.0; i <= 31.0; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new DoubleHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleSets.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleHashSetTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains_different_NaNs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains_different_NaNs);
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
        public void benchmark_sumConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumConsistentRounding);
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
        public void benchmark_doubleIterator_throws_non_empty_collection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_non_empty_collection);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws_for_consecutive_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws_for_consecutive_remove);
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
        public void benchmark_add_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NEGATIVE_INFINITY);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> doubleIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> doubleIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> doubleIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> doubleIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addWithCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addWithCollisionWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleHashSetTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = DoubleHashSetTest::newCollectionWith;
            this.payloads.tap = DoubleHashSetTest::tap;
            this.payloads.contains_NaN = DoubleHashSetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = DoubleHashSetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = DoubleHashSetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = DoubleHashSetTest::contains_zero;
            this.payloads.testEquals_NaN = DoubleHashSetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = DoubleHashSetTest::contains_different_NaNs;
            this.payloads.containsAllArray = DoubleHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = DoubleHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = DoubleHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = DoubleHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = DoubleHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = DoubleHashSetTest::containsNoneIterable;
            this.payloads.anySatisfy = DoubleHashSetTest::anySatisfy;
            this.payloads.allSatisfy = DoubleHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = DoubleHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = DoubleHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = DoubleHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = DoubleHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = DoubleHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = DoubleHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = DoubleHashSetTest::rejectWithTarget;
            this.payloads.max = DoubleHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = DoubleHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleHashSetTest::maxIfEmpty;
            this.payloads.sum = DoubleHashSetTest::sum;
            this.payloads.summaryStatistics = DoubleHashSetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = DoubleHashSetTest::sumConsistentRounding;
            this.payloads.average = DoubleHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = DoubleHashSetTest::averageIfEmpty;
            this.payloads.median = DoubleHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = DoubleHashSetTest::medianIfEmpty;
            this.payloads.toArray = DoubleHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = DoubleHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = DoubleHashSetTest::testToString;
            this.payloads.makeString = DoubleHashSetTest::makeString;
            this.payloads.appendString = DoubleHashSetTest::appendString;
            this.payloads.toList = DoubleHashSetTest::toList;
            this.payloads.toSortedList = DoubleHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = DoubleHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = DoubleHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = DoubleHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = DoubleHashSetTest::toSet;
            this.payloads.injectIntoBoolean = DoubleHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = DoubleHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = DoubleHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = DoubleHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = DoubleHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = DoubleHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = DoubleHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = DoubleHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = DoubleHashSetTest::reduce;
            this.payloads.reduceIfEmpty = DoubleHashSetTest::reduceIfEmpty;
            this.payloads.chunk = DoubleHashSetTest::chunk;
            this.payloads.contains = DoubleHashSetTest::contains;
            this.payloads.addAllArray = DoubleHashSetTest::addAllArray;
            this.payloads.removeIf = DoubleHashSetTest::removeIf;
            this.payloads.with = DoubleHashSetTest::with;
            this.payloads.withAll = DoubleHashSetTest::withAll;
            this.payloads.without = DoubleHashSetTest::without;
            this.payloads.withoutAll = DoubleHashSetTest::withoutAll;
            this.payloads.doubleIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::doubleIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.doubleIterator_with_remove = DoubleHashSetTest::doubleIterator_with_remove;
            this.payloads.doubleIterator_throws_for_remove_before_next = DoubleHashSetTest::doubleIterator_throws_for_remove_before_next;
            this.payloads.doubleIterator_throws_for_consecutive_remove = DoubleHashSetTest::doubleIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = DoubleHashSetTest::newEmpty;
            this.payloads.size = DoubleHashSetTest::size;
            this.payloads.isEmpty = DoubleHashSetTest::isEmpty;
            this.payloads.notEmpty = DoubleHashSetTest::notEmpty;
            this.payloads.clear = DoubleHashSetTest::clear;
            this.payloads.add = DoubleHashSetTest::add;
            this.payloads.add_NaN = DoubleHashSetTest::add_NaN;
            this.payloads.add_POSITIVE_INFINITY = DoubleHashSetTest::add_POSITIVE_INFINITY;
            this.payloads.add_NEGATIVE_INFINITY = DoubleHashSetTest::add_NEGATIVE_INFINITY;
            this.payloads.addAllIterable = DoubleHashSetTest::addAllIterable;
            this.payloads.testOfAllFactory = DoubleHashSetTest::testOfAllFactory;
            this.payloads.remove = DoubleHashSetTest::remove;
            this.payloads.removeAll = DoubleHashSetTest::removeAll;
            this.payloads.removeAll_iterable = DoubleHashSetTest::removeAll_iterable;
            this.payloads.retainAll = DoubleHashSetTest::retainAll;
            this.payloads.retainAll_iterable = DoubleHashSetTest::retainAll_iterable;
            this.payloads.doubleIterator = DoubleHashSetTest::doubleIterator;
            this.payloads.doubleIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::doubleIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = DoubleHashSetTest::injectInto;
            this.payloads.forEach = DoubleHashSetTest::forEach;
            this.payloads.count = DoubleHashSetTest::count;
            this.payloads.select = DoubleHashSetTest::select;
            this.payloads.reject = DoubleHashSetTest::reject;
            this.payloads.detectIfNone = DoubleHashSetTest::detectIfNone;
            this.payloads.collect = DoubleHashSetTest::collect;
            this.payloads.toSortedArray = DoubleHashSetTest::toSortedArray;
            this.payloads.testEquals = DoubleHashSetTest::testEquals;
            this.payloads.testHashCode = DoubleHashSetTest::testHashCode;
            this.payloads.toBag = DoubleHashSetTest::toBag;
            this.payloads.asLazy = DoubleHashSetTest::asLazy;
            this.payloads.asSynchronized = DoubleHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleHashSetTest::asUnmodifiable;
            this.payloads.union = DoubleHashSetTest::union;
            this.payloads.intersect = DoubleHashSetTest::intersect;
            this.payloads.difference = DoubleHashSetTest::difference;
            this.payloads.symmetricDifference = DoubleHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = DoubleHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = DoubleHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = DoubleHashSetTest::cartesianProduct;
            this.payloads.defaultInitialCapacity = DoubleHashSetTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleHashSetTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = DoubleHashSetTest::newCollection;
            this.payloads.addAndCheckField = DoubleHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = DoubleHashSetTest::addWithRehash;
            this.payloads.removeWithRehash = DoubleHashSetTest::removeWithRehash;
            this.payloads.iterator_remove = DoubleHashSetTest::iterator_remove;
            this.payloads.addEverySlot = DoubleHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = DoubleHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addWithCollision = DoubleHashSetTest::addWithCollision;
            this.payloads.addWithCollisionWithRemovedSlot = DoubleHashSetTest::addWithCollisionWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = DoubleHashSetTest::addZeroToThirtyOne;
            this.payloads.classIsNonInstantiable = DoubleHashSetTest::classIsNonInstantiable;
        }
    }
}
