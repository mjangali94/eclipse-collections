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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractIntSetTestCase._Benchmark {

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

        private IntHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new IntHashSetTest();
        }

        @java.lang.Override
        public IntHashSetTest implementation() {
            return this.implementation;
        }
    }
}
