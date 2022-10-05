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
import org.eclipse.collections.api.block.function.primitive.IntToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableIntByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntByteMapTestCase extends AbstractIntByteMapTestCase {

    @Override
    protected abstract MutableIntByteMap classUnderTest();

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1);

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2);

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3);

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3, int key4, byte value4);

    @Override
    protected abstract MutableIntByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.put(0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0));
        map1.put(0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0));
        map1.put(5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5));
        map1.put(35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0));
        map1.put(1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1));
        map1.put(5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5));
        map1.put(35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(1, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33, (byte) 6));
        map1.put(0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0, (byte) 5));
        map1.put(1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1, (byte) 5));
        map1.put(5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5, (byte) 6));
        map1.put(35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals((byte) 0, map1.get(0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals((byte) 0, map1.get(0));
        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals((byte) 0, map1.get(1));
        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals((byte) 0, map1.get(31));
        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals((byte) 0, map1.get(32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.put(35, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.put(35, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey(0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableIntByteMap hashMap1 = this.newWithKeysValues(1, (byte) 1, 0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntByteMap hashMap = this.newWithKeysValues(6, (byte) 6, 5, (byte) 5);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntByteHashMap hashMap = new IntByteHashMap();
        for (int each = 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntByteHashMap(), map1);
        map1.put(1, (byte) 0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new IntByteHashMap(), map1);
        map1.put(33, (byte) 0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new IntByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableIntByteMap map0 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map0.removeKey(1);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntByteHashMap(), map0);
        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map1.removeKey(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntByteHashMap(), map1);
        MutableIntByteMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(31, (byte) 31, 32, (byte) 32), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableIntByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableIntByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableIntByteMap map0 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map0.remove(1);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map0);
        map0.remove(0);
        Assert.assertEquals(new IntByteHashMap(), map0);
        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map1.remove(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map1);
        map1.remove(1);
        Assert.assertEquals(new IntByteHashMap(), map1);
        MutableIntByteMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32), map2);
        map2.remove(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(31, (byte) 31, 32, (byte) 32), map2);
        map2.remove(31);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map2);
        map2.remove(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableIntByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableIntByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableIntByteMap map0 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0, (byte) 100));
        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1, (byte) 100));
        MutableIntByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(31, (byte) 31, 32, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableIntByteMap map1 = this.classUnderTest();
        map1.put(0, (byte) 1);
        map1.put(31, (byte) 32);
        map1.put(32, (byte) 33);
        IntByteHashMap expected = IntByteHashMap.newWithKeysValues(0, (byte) 1, 31, (byte) 32, 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1, (byte) 2);
        expected.put(1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33, (byte) 34);
        expected.put(33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30, (byte) 31);
        expected.put(30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableIntByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut(0, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut(0, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut(10, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut(10, (byte) 25, (byte) 30));
        map1.removeKey(10);
        Assert.assertEquals(101, map1.getAndPut(10, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut(10, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableIntByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32, (byte) 33));
        IntByteHashMap expected = IntByteHashMap.newWithKeysValues(0, (byte) 1, 31, (byte) 32, 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1, (byte) 2));
        expected.put(1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33, (byte) 34));
        expected.put(33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30, (byte) 31));
        expected.put(30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 11, 1, (byte) 12, 2, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableIntByteMap expected1 = this.newWithKeysValues(0, (byte) 11, 1, (byte) 12, 2, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableIntByteMap map2 = this.newWithKeysValues(0, (byte) 11, 1, (byte) 12, 2, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableIntByteMap expected2 = this.newWithKeysValues(0, (byte) 12, 1, (byte) 13, 2, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableIntByteMap map3 = this.newWithKeysValues(0, (byte) 11, 1, (byte) 12, 2, (byte) 13);
        map3.updateValues((k, v) -> k == 0 ? (byte) 10 : v);
        MutableIntByteMap expected3 = this.newWithKeysValues(0, (byte) 10, 1, (byte) 12, 2, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32, (byte) 33));
        IntByteHashMap expected = IntByteHashMap.newWithKeysValues(0, (byte) 11, 1, (byte) 12, 31, (byte) 37, 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5L, map1.addToValue(31, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableIntByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            int k = (int) each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        IntByteHashMap hashMap = new IntByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get(i));
            hashMap.put(i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get(i));
            hashMap.remove(i);
            Assert.assertEquals((byte) 0, hashMap.get(i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntByteMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntByteMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntByteMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntByteMapTestCase.generateCollisions().get(3);
        MutableIntByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableIntByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableIntByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 50, 1, (byte) 50), map1);
        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 50, 1, (byte) 50), map2);
        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 50), map3);
        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 100, 1, (byte) 100), map1);
        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 100, 1, (byte) 100), map2);
        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 100), map3);
        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 9, 1, (byte) 9), map1);
        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 9, 1, (byte) 9), map2);
        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 9), map3);
        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToByteFunction function = (int intParameter) -> (byte) intParameter;
        IntToByteFunction functionThrows = (int intParameter) -> {
            throw new AssertionError();
        };
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1), map1);
        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1), map2);
        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map3);
        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 2), map1);
        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 1, 1, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 2), map2);
        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableIntByteMap mutableIntByteMap = this.classUnderTest();
        IntSet frozenSet = mutableIntByteMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntByteMap.put((int) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntByteMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntByteMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntByteMap mutableIntByteMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntByteMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntByteMapForClear.keySet().toArray());
        mutableIntByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntByteMap map = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 31, (byte) 31, 32, (byte) 32);
        MutableIntByteMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 31, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableIntByteMap map = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 31, (byte) 31, 32, (byte) 32);
        MutableIntByteMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1, 31, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableIntByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, (byte) 1), hashMap);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableIntByteMap emptyMap = this.getEmptyMap();
        MutableIntByteMap partialMap = this.newWithKeysValues(1, (byte) 1, 3, (byte) 3);
        MutableIntByteMap completeMap = this.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4);
        Iterable<IntBytePair> emptyIterable = Iterables.iList();
        Iterable<IntBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, (byte) 1), PrimitiveTuples.pair(3, (byte) 3));
        Iterable<IntBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, (byte) 1), PrimitiveTuples.pair(2, (byte) 2), PrimitiveTuples.pair(3, (byte) 3), PrimitiveTuples.pair(4, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedIntByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableIntByteMap mutableMap = this.classUnderTest();
        MutableByteIterator iterator = mutableMap.byteIterator();
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
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableIntByteMap map = this.newWithKeysValues(1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4, (byte) 5);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 2, 1, (byte) 3, 2, (byte) 4, 3, (byte) 5, 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, (byte) 1, 2, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableIntByteMap map = this.newWithKeysValues(1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4, (byte) 5);
        MutableIntByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableIntByteMap map = this.newWithKeysValues(1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4, (byte) 5);
        IntSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntByteMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
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
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableIntByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableIntByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableIntByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableIntByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableIntByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableIntByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableIntByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableIntByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableIntByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableIntByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableIntByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableIntByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableIntByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableIntByteMapTestCase::select;
            this.payloads.reject = AbstractMutableIntByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableIntByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableIntByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableIntByteMapTestCase::collect;
            this.payloads.count = AbstractMutableIntByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableIntByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableIntByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableIntByteMapTestCase::max;
            this.payloads.min = AbstractMutableIntByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableIntByteMapTestCase::sum;
            this.payloads.average = AbstractMutableIntByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableIntByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableIntByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableIntByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableIntByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableIntByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableIntByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableIntByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableIntByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableIntByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableIntByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableIntByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableIntByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableIntByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableIntByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableIntByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableIntByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableIntByteMapTestCase::contains;
            this.payloads.size = AbstractMutableIntByteMapTestCase::size;
            this.payloads.clear = AbstractMutableIntByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableIntByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableIntByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableIntByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableIntByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableIntByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableIntByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableIntByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableIntByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableIntByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableIntByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableIntByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableIntByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableIntByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableIntByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableIntByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableIntByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableIntByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableIntByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableIntByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableIntByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableIntByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableIntByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableIntByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableIntByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableIntByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableIntByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableIntByteMapTestCase::serializeKeySet;
        }
    }
}
