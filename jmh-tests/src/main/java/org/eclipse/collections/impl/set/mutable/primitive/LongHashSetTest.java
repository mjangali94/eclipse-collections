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
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractLongSetTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::defaultInitialCapacity, this.description("defaultInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithInitialCapacity, this.description("newWithInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::newWithInitialCapacity_negative_throws, this.description("newWithInitialCapacity_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newCollection() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newCollection, this.description("newCollection"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAndCheckField() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addAndCheckField, this.description("addAndCheckField"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithRehash() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addWithRehash, this.description("addWithRehash"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithRehash() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeWithRehash, this.description("removeWithRehash"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_remove, this.description("iterator_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addEverySlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addEverySlot, this.description("addEverySlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addDuplicateWithRemovedSlot, this.description("addDuplicateWithRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithCollision() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addWithCollision, this.description("addWithCollision"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addWithCollisionWithRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addWithCollisionWithRemovedSlot, this.description("addWithCollisionWithRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addZeroToThirtyOne() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addZeroToThirtyOne, this.description("addZeroToThirtyOne"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        private LongHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongHashSetTest();
        }

        @java.lang.Override
        public LongHashSetTest implementation() {
            return this.implementation;
        }
    }
}
