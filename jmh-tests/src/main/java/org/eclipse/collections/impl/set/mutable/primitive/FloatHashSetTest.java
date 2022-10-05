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
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractFloatSetTestCase._Benchmark {

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

        private FloatHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new FloatHashSetTest();
        }

        @java.lang.Override
        public FloatHashSetTest implementation() {
            return this.implementation;
        }
    }
}
