/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.function.primitive.IntToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableIntLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntLongMapTestCase extends AbstractIntLongMapTestCase {

    @Override
    protected abstract MutableIntLongMap classUnderTest();

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1);

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2);

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3);

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3, int key4, long value4);

    @Override
    protected abstract MutableIntLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.put(0, 1L);
        Assert.assertEquals(1L, map1.get(0));
        map1.put(0, 0L);
        Assert.assertEquals(0L, map1.get(0));
        map1.put(5, 5L);
        Assert.assertEquals(5L, map1.get(5));
        map1.put(35, 35L);
        Assert.assertEquals(35L, map1.get(35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0));
        map1.put(1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1));
        map1.put(5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5));
        map1.put(35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals(5L, map1.getIfAbsent(0, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent(1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33, 6L));
        map1.put(0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0, 5L));
        map1.put(1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1, 5L));
        map1.put(5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5, 6L));
        map1.put(35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0L, map1.get(0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0L, map1.get(0));
        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals(0L, map1.get(1));
        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals(0L, map1.get(31));
        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals(0L, map1.get(32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.put(35, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.put(35, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey(0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableIntLongMap hashMap1 = this.newWithKeysValues(1, 1L, 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntLongMap hashMap = this.newWithKeysValues(6, 6L, 5, 5L);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntLongHashMap hashMap = new IntLongHashMap();
        for (int each = 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntLongHashMap(), map1);
        map1.put(1, 0L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new IntLongHashMap(), map1);
        map1.put(33, 0L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new IntLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableIntLongMap map0 = this.newWithKeysValues(0, 0L, 1, 1L);
        map0.removeKey(1);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntLongHashMap(), map0);
        MutableIntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        map1.removeKey(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntLongHashMap(), map1);
        MutableIntLongMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(31, 31L, 32, 32L), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableIntLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableIntLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableIntLongMap map0 = this.newWithKeysValues(0, 0L, 1, 1L);
        map0.remove(1);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map0);
        map0.remove(0);
        Assert.assertEquals(new IntLongHashMap(), map0);
        MutableIntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        map1.remove(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map1);
        map1.remove(1);
        Assert.assertEquals(new IntLongHashMap(), map1);
        MutableIntLongMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L), map2);
        map2.remove(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(31, 31L, 32, 32L), map2);
        map2.remove(31);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map2);
        map2.remove(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableIntLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableIntLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableIntLongMap map0 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(new IntLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0, 100L));
        MutableIntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1, 100L));
        Assert.assertEquals(new IntLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1, 100L));
        MutableIntLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(31, 31L, 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32, 100L));
        Assert.assertEquals(new IntLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32, 100L));
        Assert.assertEquals(new IntLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableIntLongMap map1 = this.classUnderTest();
        map1.put(0, 1L);
        map1.put(31, 32L);
        map1.put(32, 33L);
        IntLongHashMap expected = IntLongHashMap.newWithKeysValues(0, 1L, 31, 32L, 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.put(1, 2L);
        expected.put(1, 2L);
        Assert.assertEquals(expected, map1);
        map1.put(33, 34L);
        expected.put(33, 34L);
        Assert.assertEquals(expected, map1);
        map1.put(30, 31L);
        expected.put(30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableIntLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut(0, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut(0, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut(10, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut(10, 25L, 30L));
        map1.removeKey(10);
        Assert.assertEquals(101, map1.getAndPut(10, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut(10, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableIntLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, 1L));
        map1.putPair(PrimitiveTuples.pair(31, 32L));
        map1.putPair(PrimitiveTuples.pair(32, 33L));
        IntLongHashMap expected = IntLongHashMap.newWithKeysValues(0, 1L, 31, 32L, 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1, 2L));
        expected.put(1, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33, 34L));
        expected.put(33, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30, 31L));
        expected.put(30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableIntLongMap map1 = this.newWithKeysValues(0, 11L, 1, 12L, 2, 13L);
        map1.updateValues((k, v) -> v);
        MutableIntLongMap expected1 = this.newWithKeysValues(0, 11L, 1, 12L, 2, 13L);
        Assert.assertEquals(expected1, map1);
        MutableIntLongMap map2 = this.newWithKeysValues(0, 11L, 1, 12L, 2, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableIntLongMap expected2 = this.newWithKeysValues(0, 12L, 1, 13L, 2, 14L);
        Assert.assertEquals(expected2, map2);
        MutableIntLongMap map3 = this.newWithKeysValues(0, 11L, 1, 12L, 2, 13L);
        map3.updateValues((k, v) -> k == 0 ? 10L : v);
        MutableIntLongMap expected3 = this.newWithKeysValues(0, 10L, 1, 12L, 2, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, 1L));
        Assert.assertEquals(32L, map1.addToValue(31, 32L));
        Assert.assertEquals(3L, map1.addToValue(1, 3L));
        Assert.assertEquals(11L, map1.addToValue(0, 10L));
        Assert.assertEquals(12L, map1.addToValue(1, 9L));
        Assert.assertEquals(37L, map1.addToValue(31, 5L));
        Assert.assertEquals(33L, map1.addToValue(32, 33L));
        IntLongHashMap expected = IntLongHashMap.newWithKeysValues(0, 11L, 1, 12L, 31, 37L, 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5L, map1.addToValue(31, 5L));
        Assert.assertEquals(37L, map1.addToValue(31, 32L));
        Assert.assertEquals(33L, map1.addToValue(32, 33L));
        Assert.assertEquals(3L, map1.addToValue(1, 3L));
        Assert.assertEquals(1L, map1.addToValue(0, 1L));
        Assert.assertEquals(12L, map1.addToValue(1, 9L));
        Assert.assertEquals(11L, map1.addToValue(0, 10L));
        Assert.assertEquals(expected, map1);
        MutableIntLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            int k = (int) each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        IntLongHashMap hashMap = new IntLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get(i));
            hashMap.put(i, (long) i);
            Assert.assertEquals((long) i, hashMap.get(i));
            hashMap.remove(i);
            Assert.assertEquals(0L, hashMap.get(i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntLongMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntLongMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntLongMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntLongMapTestCase.generateCollisions().get(3);
        MutableIntLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableIntLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableIntLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map1);
        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map2);
        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 50L), map3);
        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map1);
        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map2);
        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 100L), map3);
        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map1);
        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map2);
        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 9L), map3);
        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToLongFunction function = (int intParameter) -> (long) intParameter;
        IntToLongFunction functionThrows = (int intParameter) -> {
            throw new AssertionError();
        };
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map1);
        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map2);
        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map3);
        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L, 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map1);
        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 1L, 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map2);
        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableIntLongMap mutableIntLongMap = this.classUnderTest();
        IntSet frozenSet = mutableIntLongMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntLongMap.put((int) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntLongMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntLongMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntLongMap mutableIntLongMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntLongMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntLongMapForClear.keySet().toArray());
        mutableIntLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 31, 31L, 32, 32L);
        MutableIntLongMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableIntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 31, 31L, 32, 32L);
        MutableIntLongMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L, 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableIntLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, 1L), hashMap);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableIntLongMap emptyMap = this.getEmptyMap();
        MutableIntLongMap partialMap = this.newWithKeysValues(1, 1L, 3, 3L);
        MutableIntLongMap completeMap = this.newWithKeysValues(1, 1L, 2, 2L, 3, 3L, 4, 4L);
        Iterable<IntLongPair> emptyIterable = Iterables.iList();
        Iterable<IntLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, 1L), PrimitiveTuples.pair(3, 3L));
        Iterable<IntLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, 1L), PrimitiveTuples.pair(2, 2L), PrimitiveTuples.pair(3, 3L), PrimitiveTuples.pair(4, 4L));
        Assert.assertEquals(emptyMap, emptyMap.withAllKeyValues(emptyIterable));
        Assert.assertEquals(partialMap, emptyMap.withAllKeyValues(partialIterable));
        Assert.assertEquals(completeMap, emptyMap.withAllKeyValues(completeIterable));
        Assert.assertEquals(partialMap, partialMap.withAllKeyValues(emptyIterable));
        Assert.assertEquals(partialMap, partialMap.withAllKeyValues(partialIterable));
        Assert.assertEquals(completeMap, partialMap.withAllKeyValues(completeIterable));
        Assert.assertEquals(completeMap, completeMap.withAllKeyValues(emptyIterable));
        Assert.assertEquals(completeMap, completeMap.withAllKeyValues(partialIterable));
        Assert.assertEquals(completeMap, completeMap.withAllKeyValues(completeIterable));
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedIntLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableIntLongMap mutableMap = this.classUnderTest();
        MutableLongIterator iterator = mutableMap.longIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        Assert.assertFalse(iterator.hasNext());
        Verify.assertEmpty(mutableMap);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableIntLongMap map = this.newWithKeysValues(1, 2L, 2, 3L, 3, 4L, 4, 5L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(2L, 1, 3L, 2, 4L, 3, 5L, 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1L, 2, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableIntLongMap map = this.newWithKeysValues(1, 2L, 2, 3L, 3, 4L, 4, 5L);
        MutableIntLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableIntLongMap map = this.newWithKeysValues(1, 2L, 2, 3L, 3, 4L, 4, 5L);
        IntSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntLongMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
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
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
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
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableIntLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableIntLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableIntLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableIntLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableIntLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableIntLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableIntLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableIntLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableIntLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableIntLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableIntLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableIntLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableIntLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableIntLongMapTestCase::select;
            this.payloads.reject = AbstractMutableIntLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableIntLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableIntLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableIntLongMapTestCase::collect;
            this.payloads.count = AbstractMutableIntLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableIntLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableIntLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableIntLongMapTestCase::max;
            this.payloads.min = AbstractMutableIntLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableIntLongMapTestCase::sum;
            this.payloads.average = AbstractMutableIntLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableIntLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableIntLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableIntLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableIntLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableIntLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableIntLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableIntLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableIntLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableIntLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableIntLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableIntLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableIntLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableIntLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableIntLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableIntLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableIntLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableIntLongMapTestCase::contains;
            this.payloads.size = AbstractMutableIntLongMapTestCase::size;
            this.payloads.clear = AbstractMutableIntLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableIntLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableIntLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableIntLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableIntLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableIntLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableIntLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableIntLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableIntLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableIntLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableIntLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableIntLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableIntLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableIntLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableIntLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableIntLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableIntLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableIntLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableIntLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableIntLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableIntLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableIntLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableIntLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableIntLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableIntLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableIntLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableIntLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableIntLongMapTestCase::serializeKeySet;
        }
    }
*/
}
