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
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractDoubleSetTestCase._Benchmark {

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

        private DoubleHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleHashSetTest();
        }

        @java.lang.Override
        public DoubleHashSetTest implementation() {
            return this.implementation;
        }
    }
}
