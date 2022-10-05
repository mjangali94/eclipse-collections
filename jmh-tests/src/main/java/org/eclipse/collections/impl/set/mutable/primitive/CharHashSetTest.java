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
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharHashSet}.
 * This file was automatically generated from template file primitiveHashSetTest.stg.
 */
public class CharHashSetTest extends AbstractCharSetTestCase {

    @Override
    protected final CharHashSet classUnderTest() {
        return CharHashSet.newSetWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    protected CharHashSet newWith(char... elements) {
        return (CharHashSet) CharSets.mutable.of(elements);
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        CharHashSet hashSet = new CharHashSet();
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        CharHashSet hashSet = new CharHashSet(3);
        Assert.assertEquals(8L, ((char[]) table.get(hashSet)).length);
        CharHashSet hashSet2 = new CharHashSet(10);
        Assert.assertEquals(32L, ((char[]) table.get(hashSet2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharHashSet(-1);
    }

    @Override
    @Test
    public void newCollection() {
        super.newCollection();
        CharHashSet set = CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1));
        CharHashSet hashSetFromList = CharHashSet.newSet(CharArrayList.newListWith((char) 0, (char) 0, (char) 1, (char) 31, AbstractCharSetTestCase.generateCollisions1().getFirst(), AbstractCharSetTestCase.generateCollisions1().get(1)));
        CharHashSet hashSetFromSet = CharHashSet.newSet(set);
        Assert.assertEquals(set, hashSetFromList);
        Assert.assertEquals(set, hashSetFromSet);
    }

    @Test
    public void addAndCheckField() throws NoSuchFieldException, IllegalAccessException {
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.add((char) 14));
        Assert.assertFalse(hashSet.add((char) 14));
        Assert.assertTrue(hashSet.add((char) 2));
        Assert.assertFalse(hashSet.add((char) 2));
        Assert.assertTrue(hashSet.add((char) 35));
        Assert.assertFalse(hashSet.add((char) 35));
        Assert.assertTrue(hashSet.add((char) 31));
        Assert.assertFalse(hashSet.add((char) 31));
        Assert.assertTrue(hashSet.add((char) 32));
        Assert.assertFalse(hashSet.add((char) 32));
        Assert.assertTrue(hashSet.add((char) 0));
        Assert.assertFalse(hashSet.add((char) 0));
        Assert.assertTrue(hashSet.add((char) 1));
        Assert.assertFalse(hashSet.add((char) 1));
        Field zeroToThirtyOne = CharHashSet.class.getDeclaredField("zeroToThirtyOne");
        zeroToThirtyOne.setAccessible(true);
        Assert.assertEquals(-2147467257L, ((Integer) zeroToThirtyOne.get(hashSet)).longValue());
        Assert.assertEquals(CharHashSet.newSetWith((char) 14, (char) 2, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1), hashSet);
    }

    @Test
    public void addWithRehash() throws NoSuchFieldException, IllegalAccessException {
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.addAll((char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39));
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
        Field occupiedWithData = CharHashSet.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertEquals(CharHashSet.newSetWith((char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39), hashSet);
        hashSet.remove((char) 32);
        Assert.assertEquals(7, occupiedWithData.get(hashSet));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashSet));
        // adding to a REMOVED slot
        hashSet.add((char) 32);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        Assert.assertTrue(hashSet.add((char) 43));
        Assert.assertEquals(32L, ((char[]) table.get(hashSet)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashSet));
    }

    @Test
    public void removeWithRehash() throws NoSuchFieldException, IllegalAccessException {
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.addAll((char) 32, (char) 33, (char) 34, (char) 35, (char) 36, (char) 37, (char) 38, (char) 39));
        Field table = CharHashSet.class.getDeclaredField("table");
        table.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
        Field occupiedWithData = CharHashSet.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashSet));
        Field occupiedWithSentinels = CharHashSet.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashSet));
        for (int i = 0; i < 4; i++) {
            hashSet.remove((char) (i + 32));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashSet));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashSet));
        }
        Assert.assertEquals(CharHashSet.newSetWith((char) 36, (char) 37, (char) 38, (char) 39), hashSet);
        Assert.assertTrue(hashSet.remove((char) 36));
        Assert.assertEquals(16L, ((char[]) table.get(hashSet)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove((char) 36));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        Assert.assertFalse(hashSet.remove((char) 1));
        Assert.assertEquals(3, occupiedWithData.get(hashSet));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashSet));
        CharHashSet setForCopyTable = CharHashSet.newSetWith((char) 36, (char) 37, (char) 38, (char) 39);
        setForCopyTable.freeze();
        Assert.assertTrue(setForCopyTable.remove((char) 36));
    }

    @Test
    public void iterator_remove() {
        MutableCharSet set1 = CharSets.mutable.empty();
        int max = 10;
        for (Integer i = 0; i < max; i++) {
            set1.add(i.toString().charAt(0));
        }
        // set2 to verify copyTable()
        MutableCharSet set2 = CharSets.mutable.withAll(set1);
        set2.freeze();
        this.assertIteratorRemove(set1, max);
        this.assertIteratorRemove(set2, max);
    }

    private void assertIteratorRemove(MutableCharSet set, int max) {
        Verify.assertSize(max, set);
        MutableCharIterator iterator = set.charIterator();
        Assert.assertThrows(IllegalStateException.class, () -> iterator.remove());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Verify.assertSize(--max, set);
        }
    }

    @Test
    public void addEverySlot() {
        this.addAndRemoveData(new CharHashSet());
        this.addAndRemoveData(new CharHashSet(4));
        this.addAndRemoveData(new CharHashSet(2));
        this.addAndRemoveData(new CharHashSet(1));
        this.addAndRemoveData(new CharHashSet(0));
    }

    private void addAndRemoveData(CharHashSet hashSet) {
        for (char i = (char) 100; i < (char) 200; i++) {
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertTrue(hashSet.add(i));
            Assert.assertTrue(hashSet.remove(i));
        }
    }

    @Test
    public void addDuplicateWithRemovedSlot() {
        char collision1 = AbstractCharSetTestCase.generateCollisions1().getFirst();
        char collision2 = AbstractCharSetTestCase.generateCollisions1().get(1);
        char collision3 = AbstractCharSetTestCase.generateCollisions1().get(2);
        char collision4 = AbstractCharSetTestCase.generateCollisions1().get(3);
        CharHashSet hashSet = new CharHashSet();
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision4));
        Assert.assertEquals(CharHashSet.newSetWith(collision1, collision3, collision4), hashSet);
        CharHashSet hashSet2 = new CharHashSet();
        Assert.assertTrue(hashSet2.add(collision1));
        Assert.assertTrue(hashSet2.add(collision2));
        Assert.assertTrue(hashSet2.add(collision3));
        Assert.assertTrue(hashSet2.remove(collision1));
        Assert.assertTrue(hashSet2.add(collision4));
        Assert.assertEquals(CharHashSet.newSetWith(collision2, collision3, collision4), hashSet2);
        CharHashSet hashSet3 = new CharHashSet();
        Assert.assertTrue(hashSet3.add(collision1));
        Assert.assertTrue(hashSet3.add(collision2));
        Assert.assertTrue(hashSet3.add(collision3));
        Assert.assertTrue(hashSet3.remove(collision3));
        Assert.assertTrue(hashSet3.add(collision4));
        Assert.assertEquals(CharHashSet.newSetWith(collision1, collision2, collision4), hashSet3);
    }

    @Test
    public void addWithCollision() {
        CharHashSet hashSet = new CharHashSet();
        char collision1 = AbstractCharSetTestCase.generateCollisions1().getFirst();
        char collision2 = AbstractCharSetTestCase.generateCollisions1().get(1);
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertTrue(hashSet.add(collision2));
        Assert.assertEquals(CharHashSet.newSetWith(collision1, collision2), hashSet);
    }

    @Test
    public void addWithCollisionWithRemovedSlot() {
        char collision1 = AbstractCharSetTestCase.generateCollisions1().getFirst();
        char collision2 = AbstractCharSetTestCase.generateCollisions1().get(1);
        char collision3 = AbstractCharSetTestCase.generateCollisions1().get(2);
        char collision4 = AbstractCharSetTestCase.generateCollisions1().get(3);
        char collision5 = AbstractCharSetTestCase.generateCollisions1().get(4);
        CharHashSet hashSet = CharHashSet.newSetWith(collision1, collision2, collision4);
        Assert.assertTrue(hashSet.remove(collision1));
        Assert.assertTrue(hashSet.add(collision3));
        Assert.assertEquals(CharHashSet.newSetWith(collision3, collision2, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision2));
        Assert.assertTrue(hashSet.add(collision5));
        Assert.assertEquals(CharHashSet.newSetWith(collision3, collision5, collision4), hashSet);
        Assert.assertTrue(hashSet.remove(collision4));
        Assert.assertTrue(hashSet.add(collision1));
        Assert.assertEquals(CharHashSet.newSetWith(collision3, collision5, collision1), hashSet);
    }

    @Test
    public void addZeroToThirtyOne() {
        CharHashSet hashSet = CharHashSet.newSetWith();
        for (char i = (char) 0; i <= (char) 31; i++) {
            Assert.assertTrue(hashSet.add(i));
            Assert.assertFalse(hashSet.add(i));
        }
        for (char i = (char) 0; i <= (char) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
        }
        for (char i = (char) 0; i <= (char) 31; i++) {
            Assert.assertTrue(hashSet.contains(i));
            Assert.assertTrue(hashSet.remove(i));
            Assert.assertFalse(hashSet.contains(i));
            Assert.assertFalse(hashSet.remove(i));
        }
        Assert.assertEquals(new CharHashSet(), hashSet);
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharSets.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.set.mutable.primitive.AbstractCharSetTestCase._Benchmark {

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

        private CharHashSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new CharHashSetTest();
        }

        @java.lang.Override
        public CharHashSetTest implementation() {
            return this.implementation;
        }
    }
}
