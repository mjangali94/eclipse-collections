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
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractShortSetTestCase._Benchmark {

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

        private ShortHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortHashSetTest();
        }

        @java.lang.Override
        public ShortHashSetTest implementation() {
            return this.implementation;
        }
    }
}
