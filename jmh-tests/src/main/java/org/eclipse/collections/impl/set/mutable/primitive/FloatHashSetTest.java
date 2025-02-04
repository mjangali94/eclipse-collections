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
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class FloatHashSetTest extends AbstractFloatSetTestCase {

    @Override
    protected final FloatHashSet classUnderTest() {
        return FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected FloatHashSet newWith(float... elements) {
        return (FloatHashSet) FloatSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = FloatHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        FloatHashSet hashSet = new FloatHashSet();
        Assert.assertEquals(16L, ((float[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = FloatHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        FloatHashSet hashSet = new FloatHashSet(3);
        Assert.assertEquals(8L, ((float[]) table.get(hashSet)).length);
        FloatHashSet hashSet2 = new FloatHashSet(10);
        Assert.assertEquals(32L, ((float[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new FloatHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        FloatHashSet set = FloatHashSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1));
        FloatHashSet hashSetFromList = FloatHashSet.newSet(FloatArrayList.newListWith(0.0f, 0.0f, 1.0f, 31.0f, AbstractFloatSetTestCase.generateCollisions1().getFirst(), AbstractFloatSetTestCase.generateCollisions1().get(1)));
        FloatHashSet hashSetFromSet = FloatHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        FloatHashSet hashSet = new FloatHashSet();
        Assert.assertTrue(hashSet.add(14.0f));
        Assert.assertFalse(hashSet.add(14.0f));
        Assert.assertTrue(hashSet.add(2.0f));
        Assert.assertFalse(hashSet.add(2.0f));
        Assert.assertTrue(hashSet.add(35.0f));
        Assert.assertFalse(hashSet.add(35.0f));
        Assert.assertTrue(hashSet.add(31.0f));
        Assert.assertFalse(hashSet.add(31.0f));
        Assert.assertTrue(hashSet.add(32.0f));
        Assert.assertFalse(hashSet.add(32.0f));
        Assert.assertTrue(hashSet.add(0.0f));
        Assert.assertFalse(hashSet.add(0.0f));
        Assert.assertTrue(hashSet.add(1.0f));
        Assert.assertFalse(hashSet.add(1.0f));
        Field zeroToThirtyOne = FloatHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(FloatHashSet.newSetWith(14.0f, 2.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        FloatHashSet hashSet = new FloatHashSet();
        Assert.assertTrue(hashSet.addAll(32.0f, 33.0f, 34.0f, 35.0f, 36.0f, 37.0f, 38.0f, 39.0f));
        Field table = FloatHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) table.get(hashSet)).length);
        Field occupiedWithData = FloatHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(FloatHashSet.newSetWith(32.0f, 33.0f, 34.0f, 35.0f, 36.0f, 37.0f, 38.0f, 39.0f), hashSet);
        hashSet.remove(32.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add(32.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add(43.0f));
        Assert.assertEquals(32L, ((float[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        FloatHashSet hashSet = new FloatHashSet();
        Assert.assertTrue(hashSet.addAll(32.0f, 33.0f, 34.0f, 35.0f, 36.0f, 37.0f, 38.0f, 39.0f));
        Field table = FloatHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) table.get(hashSet)).length);
        Field occupiedWithData = FloatHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = FloatHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove(i + 32);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(FloatHashSet.newSetWith(36.0f, 37.0f, 38.0f, 39.0f), hashSet);
        Assert.assertTrue(hashSet.remove(36.0f));
        Assert.assertEquals(16L, ((float[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(36.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove(1.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        FloatHashSet setForCopyTable = FloatHashSet.newSetWith(36.0f, 37.0f, 38.0f, 39.0f);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove(36.0f));
    }

    @Test
    public void iterator_remove() {
        MutableFloatSet set1 = FloatSets.mutable.empty();
        int max = 100_000;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.floatValue());
        }
        // set2 to verify copyTable()
        MutableFloatSet set2 = FloatSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableFloatSet set, int max) {
        Verify.assertSize(max, set);
        MutableFloatIterator iterator = set.floatIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new FloatHashSet());
        this.addAndRemoveData(new FloatHashSet(4));
        this.addAndRemoveData(new FloatHashSet(2));
        this.addAndRemoveData(new FloatHashSet(1));
        this.addAndRemoveData(new FloatHashSet(0));
    }

    private void addAndRemoveData(FloatHashSet hashSet) {
        for (float i = 100.0f; i < 200.0f; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        float collision1 = AbstractFloatSetTestCase.generateCollisions1().getFirst();
        float collision2 = AbstractFloatSetTestCase.generateCollisions1().get(1);
        float collision3 = AbstractFloatSetTestCase.generateCollisions1().get(2);
        float collision4 = AbstractFloatSetTestCase.generateCollisions1().get(3);
        FloatHashSet hashSet = new FloatHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(FloatHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        FloatHashSet hashSet2 = new FloatHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(FloatHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        FloatHashSet hashSet3 = new FloatHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(FloatHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        FloatHashSet hashSet = new FloatHashSet();
        float collision1 = AbstractFloatSetTestCase.generateCollisions1().getFirst();
        float collision2 = AbstractFloatSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(FloatHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        float collision1 = AbstractFloatSetTestCase.generateCollisions1().getFirst();
        float collision2 = AbstractFloatSetTestCase.generateCollisions1().get(1);
        float collision3 = AbstractFloatSetTestCase.generateCollisions1().get(2);
        float collision4 = AbstractFloatSetTestCase.generateCollisions1().get(3);
        float collision5 = AbstractFloatSetTestCase.generateCollisions1().get(4);
        FloatHashSet hashSet = FloatHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(FloatHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(FloatHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(FloatHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        FloatHashSet hashSet = FloatHashSet.newSetWith();
        for (float i = 0.0f; i <= 31.0f; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (float i = 0.0f; i <= 31.0f; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (float i = 0.0f; i <= 31.0f; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new FloatHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatSets.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatHashSetTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollectionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newCollectionWith);
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
        public void benchmark_add_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add_NEGATIVE_INFINITY);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_throws);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> payload) throws java.lang.Throwable {
            this.instance = new FloatHashSetTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> newCollectionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> contains_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> contains_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> contains_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> contains_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> testEquals_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> contains_different_NaNs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> containsAnyArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> containsNoneArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> flatCollectIterableWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> collectPrimitivesToLists;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> collectPrimitivesToSets;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> selectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> rejectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> max_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> min_throws_emptyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> summaryStatistics;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> sumConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> averageIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> medianIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toArrayWithTargetArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toSortedListByComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toSortedListByFunctionNaturalOrder;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toSortedListByFunctionWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> reduceOnEmptyThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> reduce;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> reduceIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> floatIterator_throws_non_empty_collection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> floatIterator_throws_for_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> floatIterator_throws_for_consecutive_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> add_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> add_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> add_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> testOfAllFactory;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> removeAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> retainAll_iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> floatIterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> union;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> intersect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> difference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> symmetricDifference;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> isSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> isProperSubsetOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> cartesianProduct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> newCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addAndCheckField;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> iterator_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addEverySlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addWithCollision;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addWithCollisionWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> addZeroToThirtyOne;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatHashSetTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.newCollectionWith = FloatHashSetTest::newCollectionWith;
            this.payloads.tap = FloatHashSetTest::tap;
            this.payloads.contains_NaN = FloatHashSetTest::contains_NaN;
            this.payloads.contains_NEGATIVE_INFINITY = FloatHashSetTest::contains_NEGATIVE_INFINITY;
            this.payloads.contains_POSITIVE_INFINITY = FloatHashSetTest::contains_POSITIVE_INFINITY;
            this.payloads.contains_zero = FloatHashSetTest::contains_zero;
            this.payloads.testEquals_NaN = FloatHashSetTest::testEquals_NaN;
            this.payloads.contains_different_NaNs = FloatHashSetTest::contains_different_NaNs;
            this.payloads.containsAllArray = FloatHashSetTest::containsAllArray;
            this.payloads.containsAllIterable = FloatHashSetTest::containsAllIterable;
            this.payloads.containsAnyArray = FloatHashSetTest::containsAnyArray;
            this.payloads.containsAnyIterable = FloatHashSetTest::containsAnyIterable;
            this.payloads.containsNoneArray = FloatHashSetTest::containsNoneArray;
            this.payloads.containsNoneIterable = FloatHashSetTest::containsNoneIterable;
            this.payloads.anySatisfy = FloatHashSetTest::anySatisfy;
            this.payloads.allSatisfy = FloatHashSetTest::allSatisfy;
            this.payloads.noneSatisfy = FloatHashSetTest::noneSatisfy;
            this.payloads.collectWithTarget = FloatHashSetTest::collectWithTarget;
            this.payloads.flatCollectWithTarget = FloatHashSetTest::flatCollectWithTarget;
            this.payloads.flatCollectIterableWithTarget = FloatHashSetTest::flatCollectIterableWithTarget;
            this.payloads.collectPrimitivesToLists = FloatHashSetTest::collectPrimitivesToLists;
            this.payloads.collectPrimitivesToSets = FloatHashSetTest::collectPrimitivesToSets;
            this.payloads.selectWithTarget = FloatHashSetTest::selectWithTarget;
            this.payloads.rejectWithTarget = FloatHashSetTest::rejectWithTarget;
            this.payloads.max = FloatHashSetTest::max;
            this.payloads.max_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::max_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.min = FloatHashSetTest::min;
            this.payloads.min_throws_emptyCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::min_throws_emptyCollection, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatHashSetTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatHashSetTest::maxIfEmpty;
            this.payloads.sum = FloatHashSetTest::sum;
            this.payloads.summaryStatistics = FloatHashSetTest::summaryStatistics;
            this.payloads.sumConsistentRounding = FloatHashSetTest::sumConsistentRounding;
            this.payloads.average = FloatHashSetTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.averageIfEmpty = FloatHashSetTest::averageIfEmpty;
            this.payloads.median = FloatHashSetTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.medianIfEmpty = FloatHashSetTest::medianIfEmpty;
            this.payloads.toArray = FloatHashSetTest::toArray;
            this.payloads.toArrayWithTargetArray = FloatHashSetTest::toArrayWithTargetArray;
            this.payloads.testToString = FloatHashSetTest::testToString;
            this.payloads.makeString = FloatHashSetTest::makeString;
            this.payloads.appendString = FloatHashSetTest::appendString;
            this.payloads.toList = FloatHashSetTest::toList;
            this.payloads.toSortedList = FloatHashSetTest::toSortedList;
            this.payloads.toSortedListByComparator = FloatHashSetTest::toSortedListByComparator;
            this.payloads.toSortedListByFunctionNaturalOrder = FloatHashSetTest::toSortedListByFunctionNaturalOrder;
            this.payloads.toSortedListByFunctionWithComparator = FloatHashSetTest::toSortedListByFunctionWithComparator;
            this.payloads.toSet = FloatHashSetTest::toSet;
            this.payloads.injectIntoBoolean = FloatHashSetTest::injectIntoBoolean;
            this.payloads.injectIntoByte = FloatHashSetTest::injectIntoByte;
            this.payloads.injectIntoChar = FloatHashSetTest::injectIntoChar;
            this.payloads.injectIntoShort = FloatHashSetTest::injectIntoShort;
            this.payloads.injectIntoInt = FloatHashSetTest::injectIntoInt;
            this.payloads.injectIntoFloat = FloatHashSetTest::injectIntoFloat;
            this.payloads.injectIntoLong = FloatHashSetTest::injectIntoLong;
            this.payloads.injectIntoDouble = FloatHashSetTest::injectIntoDouble;
            this.payloads.reduceOnEmptyThrows = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::reduceOnEmptyThrows, java.util.NoSuchElementException.class);
            this.payloads.reduce = FloatHashSetTest::reduce;
            this.payloads.reduceIfEmpty = FloatHashSetTest::reduceIfEmpty;
            this.payloads.chunk = FloatHashSetTest::chunk;
            this.payloads.contains = FloatHashSetTest::contains;
            this.payloads.addAllArray = FloatHashSetTest::addAllArray;
            this.payloads.removeIf = FloatHashSetTest::removeIf;
            this.payloads.with = FloatHashSetTest::with;
            this.payloads.withAll = FloatHashSetTest::withAll;
            this.payloads.without = FloatHashSetTest::without;
            this.payloads.withoutAll = FloatHashSetTest::withoutAll;
            this.payloads.floatIterator_throws_non_empty_collection = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::floatIterator_throws_non_empty_collection, java.util.NoSuchElementException.class);
            this.payloads.floatIterator_with_remove = FloatHashSetTest::floatIterator_with_remove;
            this.payloads.floatIterator_throws_for_remove_before_next = FloatHashSetTest::floatIterator_throws_for_remove_before_next;
            this.payloads.floatIterator_throws_for_consecutive_remove = FloatHashSetTest::floatIterator_throws_for_consecutive_remove;
            this.payloads.newEmpty = FloatHashSetTest::newEmpty;
            this.payloads.size = FloatHashSetTest::size;
            this.payloads.isEmpty = FloatHashSetTest::isEmpty;
            this.payloads.notEmpty = FloatHashSetTest::notEmpty;
            this.payloads.clear = FloatHashSetTest::clear;
            this.payloads.add = FloatHashSetTest::add;
            this.payloads.add_NaN = FloatHashSetTest::add_NaN;
            this.payloads.add_POSITIVE_INFINITY = FloatHashSetTest::add_POSITIVE_INFINITY;
            this.payloads.add_NEGATIVE_INFINITY = FloatHashSetTest::add_NEGATIVE_INFINITY;
            this.payloads.addAllIterable = FloatHashSetTest::addAllIterable;
            this.payloads.testOfAllFactory = FloatHashSetTest::testOfAllFactory;
            this.payloads.remove = FloatHashSetTest::remove;
            this.payloads.removeAll = FloatHashSetTest::removeAll;
            this.payloads.removeAll_iterable = FloatHashSetTest::removeAll_iterable;
            this.payloads.retainAll = FloatHashSetTest::retainAll;
            this.payloads.retainAll_iterable = FloatHashSetTest::retainAll_iterable;
            this.payloads.floatIterator = FloatHashSetTest::floatIterator;
            this.payloads.floatIterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::floatIterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = FloatHashSetTest::injectInto;
            this.payloads.forEach = FloatHashSetTest::forEach;
            this.payloads.count = FloatHashSetTest::count;
            this.payloads.select = FloatHashSetTest::select;
            this.payloads.reject = FloatHashSetTest::reject;
            this.payloads.detectIfNone = FloatHashSetTest::detectIfNone;
            this.payloads.collect = FloatHashSetTest::collect;
            this.payloads.toSortedArray = FloatHashSetTest::toSortedArray;
            this.payloads.testEquals = FloatHashSetTest::testEquals;
            this.payloads.testHashCode = FloatHashSetTest::testHashCode;
            this.payloads.toBag = FloatHashSetTest::toBag;
            this.payloads.asLazy = FloatHashSetTest::asLazy;
            this.payloads.asSynchronized = FloatHashSetTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatHashSetTest::asUnmodifiable;
            this.payloads.union = FloatHashSetTest::union;
            this.payloads.intersect = FloatHashSetTest::intersect;
            this.payloads.difference = FloatHashSetTest::difference;
            this.payloads.symmetricDifference = FloatHashSetTest::symmetricDifference;
            this.payloads.isSubsetOf = FloatHashSetTest::isSubsetOf;
            this.payloads.isProperSubsetOf = FloatHashSetTest::isProperSubsetOf;
            this.payloads.cartesianProduct = FloatHashSetTest::cartesianProduct;
            this.payloads.defaultInitialCapacity = FloatHashSetTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = FloatHashSetTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatHashSetTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newCollection = FloatHashSetTest::newCollection;
            this.payloads.addAndCheckField = FloatHashSetTest::addAndCheckField;
            this.payloads.addWithRehash = FloatHashSetTest::addWithRehash;
            this.payloads.removeWithRehash = FloatHashSetTest::removeWithRehash;
            this.payloads.iterator_remove = FloatHashSetTest::iterator_remove;
            this.payloads.addEverySlot = FloatHashSetTest::addEverySlot;
            this.payloads.addDuplicateWithRemovedSlot = FloatHashSetTest::addDuplicateWithRemovedSlot;
            this.payloads.addWithCollision = FloatHashSetTest::addWithCollision;
            this.payloads.addWithCollisionWithRemovedSlot = FloatHashSetTest::addWithCollisionWithRemovedSlot;
            this.payloads.addZeroToThirtyOne = FloatHashSetTest::addZeroToThirtyOne;
            this.payloads.classIsNonInstantiable = FloatHashSetTest::classIsNonInstantiable;
        }
    }
}
