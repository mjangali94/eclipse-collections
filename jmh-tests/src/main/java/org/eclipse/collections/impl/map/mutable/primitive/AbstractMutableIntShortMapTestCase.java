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
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableIntShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntShortMapTestCase extends AbstractIntShortMapTestCase {

    @Override
    protected abstract MutableIntShortMap classUnderTest();

    @Override
    protected abstract MutableIntShortMap newWithKeysValues(int key1, short value1);

    @Override
    protected abstract MutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2);

    @Override
    protected abstract MutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3);

    @Override
    protected abstract MutableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3, int key4, short value4);

    @Override
    protected abstract MutableIntShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableIntShortMap map1 = this.classUnderTest();
        map1.put(0, (short) 1);
        Assert.assertEquals((short) 1, map1.get(0));
        map1.put(0, (short) 0);
        Assert.assertEquals((short) 0, map1.get(0));
        map1.put(5, (short) 5);
        Assert.assertEquals((short) 5, map1.get(5));
        map1.put(35, (short) 35);
        Assert.assertEquals((short) 35, map1.get(35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableIntShortMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(0));
        map1.put(1, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(1));
        map1.put(5, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow(5));
        map1.put(35, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow(35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableIntShortMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals((short) 5, map1.getIfAbsent(0, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent(1, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent(33, (short) 6));
        map1.put(0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(0, (short) 5));
        map1.put(1, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(1, (short) 5));
        map1.put(5, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent(5, (short) 6));
        map1.put(35, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent(35, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableIntShortMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals((short) 0, map1.get(0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals((short) 0, map1.get(0));
        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals((short) 0, map1.get(1));
        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals((short) 0, map1.get(31));
        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals((short) 0, map1.get(32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableIntShortMap map1 = this.classUnderTest();
        map1.put(35, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableIntShortMap map1 = this.classUnderTest();
        map1.put(35, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey(0);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableIntShortMap hashMap1 = this.newWithKeysValues(1, (short) 1, 0, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntShortMap hashMap = this.newWithKeysValues(6, (short) 6, 5, (short) 5);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntShortHashMap hashMap = new IntShortHashMap();
        for (int each = 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntShortHashMap(), map1);
        map1.put(1, (short) 0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new IntShortHashMap(), map1);
        map1.put(33, (short) 0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new IntShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableIntShortMap map0 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        map0.removeKey(1);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntShortHashMap(), map0);
        MutableIntShortMap map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        map1.removeKey(0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntShortHashMap(), map1);
        MutableIntShortMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(31, (short) 31, 32, (short) 32), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 32), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntShortHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableIntShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableIntShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableIntShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableIntShortMap map0 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        map0.remove(1);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0), map0);
        map0.remove(0);
        Assert.assertEquals(new IntShortHashMap(), map0);
        MutableIntShortMap map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        map1.remove(0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1), map1);
        map1.remove(1);
        Assert.assertEquals(new IntShortHashMap(), map1);
        MutableIntShortMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32), map2);
        map2.remove(0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(31, (short) 31, 32, (short) 32), map2);
        map2.remove(31);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 32), map2);
        map2.remove(32);
        Assert.assertEquals(new IntShortHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableIntShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableIntShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableIntShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableIntShortMap map0 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent(1, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent(0, (short) 100));
        Assert.assertEquals(new IntShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(1, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(0, (short) 100));
        MutableIntShortMap map1 = this.newWithKeysValues(0, (short) 0, 1, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent(0, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent(1, (short) 100));
        Assert.assertEquals(new IntShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(0, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(1, (short) 100));
        MutableIntShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(5, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(50, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent(0, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(31, (short) 31, 32, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent(31, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent(32, (short) 100));
        Assert.assertEquals(new IntShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(31, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(32, (short) 100));
        Assert.assertEquals(new IntShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableIntShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableIntShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableIntShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableIntShortMap map1 = this.classUnderTest();
        map1.put(0, (short) 1);
        map1.put(31, (short) 32);
        map1.put(32, (short) 33);
        IntShortHashMap expected = IntShortHashMap.newWithKeysValues(0, (short) 1, 31, (short) 32, 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1, (short) 2);
        expected.put(1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33, (short) 34);
        expected.put(33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30, (short) 31);
        expected.put(30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableIntShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut(0, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut(0, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut(10, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut(10, (short) 25, (short) 30));
        map1.removeKey(10);
        Assert.assertEquals(101, map1.getAndPut(10, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut(10, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableIntShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, (short) 1));
        map1.putPair(PrimitiveTuples.pair(31, (short) 32));
        map1.putPair(PrimitiveTuples.pair(32, (short) 33));
        IntShortHashMap expected = IntShortHashMap.newWithKeysValues(0, (short) 1, 31, (short) 32, 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1, (short) 2));
        expected.put(1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33, (short) 34));
        expected.put(33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30, (short) 31));
        expected.put(30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableIntShortMap map1 = this.newWithKeysValues(0, (short) 11, 1, (short) 12, 2, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableIntShortMap expected1 = this.newWithKeysValues(0, (short) 11, 1, (short) 12, 2, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableIntShortMap map2 = this.newWithKeysValues(0, (short) 11, 1, (short) 12, 2, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableIntShortMap expected2 = this.newWithKeysValues(0, (short) 12, 1, (short) 13, 2, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableIntShortMap map3 = this.newWithKeysValues(0, (short) 11, 1, (short) 12, 2, (short) 13);
        map3.updateValues((k, v) -> k == 0 ? (short) 10 : v);
        MutableIntShortMap expected3 = this.newWithKeysValues(0, (short) 10, 1, (short) 12, 2, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableIntShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, (short) 1));
        Assert.assertEquals(32L, map1.addToValue(31, (short) 32));
        Assert.assertEquals(3L, map1.addToValue(1, (short) 3));
        Assert.assertEquals(11L, map1.addToValue(0, (short) 10));
        Assert.assertEquals(12L, map1.addToValue(1, (short) 9));
        Assert.assertEquals(37L, map1.addToValue(31, (short) 5));
        Assert.assertEquals(33L, map1.addToValue(32, (short) 33));
        IntShortHashMap expected = IntShortHashMap.newWithKeysValues(0, (short) 11, 1, (short) 12, 31, (short) 37, 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5L, map1.addToValue(31, (short) 5));
        Assert.assertEquals(37L, map1.addToValue(31, (short) 32));
        Assert.assertEquals(33L, map1.addToValue(32, (short) 33));
        Assert.assertEquals(3L, map1.addToValue(1, (short) 3));
        Assert.assertEquals(1L, map1.addToValue(0, (short) 1));
        Assert.assertEquals(12L, map1.addToValue(1, (short) 9));
        Assert.assertEquals(11L, map1.addToValue(0, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableIntShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            int k = (int) each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        IntShortHashMap hashMap = new IntShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get(i));
            hashMap.put(i, (short) i);
            Assert.assertEquals((short) i, hashMap.get(i));
            hashMap.remove(i);
            Assert.assertEquals((short) 0, hashMap.get(i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntShortMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntShortMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntShortMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntShortMapTestCase.generateCollisions().get(3);
        MutableIntShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableIntShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableIntShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableIntShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 50, 1, (short) 50), map1);
        MutableIntShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 50, 1, (short) 50), map2);
        MutableIntShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 50), map3);
        MutableIntShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, (short) 100));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableIntShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 100, 1, (short) 100), map1);
        MutableIntShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 100, 1, (short) 100), map2);
        MutableIntShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factoryThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 100), map3);
        MutableIntShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factoryThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableIntShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 9, 1, (short) 9), map1);
        MutableIntShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 9, 1, (short) 9), map2);
        MutableIntShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32, functionThrows, "unused"));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 9), map3);
        MutableIntShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33, functionThrows, "unused"));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToShortFunction function = (int intParameter) -> (short) intParameter;
        IntToShortFunction functionThrows = (int intParameter) -> {
            throw new AssertionError();
        };
        MutableIntShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0, 1, (short) 1), map1);
        MutableIntShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0, 1, (short) 1), map2);
        MutableIntShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, functionThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(32, (short) 32), map3);
        MutableIntShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, functionThrows));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableIntShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 2, 1, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 2, 1, (short) 2), map1);
        MutableIntShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 1, 1, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 2, 1, (short) 2), map2);
        MutableIntShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33, (short) 0, incrementFunction));
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(33, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableIntShortMap mutableIntShortMap = this.classUnderTest();
        IntSet frozenSet = mutableIntShortMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntShortMap.put((int) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntShortMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntShortMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntShortMap mutableIntShortMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntShortMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntShortMapForClear.keySet().toArray());
        mutableIntShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntShortMap map = this.newWithKeysValues(0, (short) 0, 1, (short) 1, 31, (short) 31, 32, (short) 32);
        MutableIntShortMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(0, (short) 0, 1, (short) 1, 31, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableIntShortMap map = this.newWithKeysValues(0, (short) 0, 1, (short) 1, 31, (short) 31, 32, (short) 32);
        MutableIntShortMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 31, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableIntShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, (short) 1), hashMap);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableIntShortMap emptyMap = this.getEmptyMap();
        MutableIntShortMap partialMap = this.newWithKeysValues(1, (short) 1, 3, (short) 3);
        MutableIntShortMap completeMap = this.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4);
        Iterable<IntShortPair> emptyIterable = Iterables.iList();
        Iterable<IntShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, (short) 1), PrimitiveTuples.pair(3, (short) 3));
        Iterable<IntShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, (short) 1), PrimitiveTuples.pair(2, (short) 2), PrimitiveTuples.pair(3, (short) 3), PrimitiveTuples.pair(4, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedIntShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableIntShortMap mutableMap = this.classUnderTest();
        MutableShortIterator iterator = mutableMap.shortIterator();
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
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableIntShortMap map = this.newWithKeysValues(1, (short) 2, 2, (short) 3, 3, (short) 4, 4, (short) 5);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 2, 1, (short) 3, 2, (short) 4, 3, (short) 5, 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, (short) 1, 2, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableIntShortMap map = this.newWithKeysValues(1, (short) 2, 2, (short) 3, 3, (short) 4, 4, (short) 5);
        MutableIntShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableIntShortMap map = this.newWithKeysValues(1, (short) 2, 2, (short) 3, 3, (short) 4, 4, (short) 5);
        IntSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntShortMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableIntShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableIntShortMapTestCase::values;
            this.payloads.containsAll = AbstractMutableIntShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableIntShortMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableIntShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableIntShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableIntShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntShortMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableIntShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableIntShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableIntShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableIntShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableIntShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableIntShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableIntShortMapTestCase::select;
            this.payloads.reject = AbstractMutableIntShortMapTestCase::reject;
            this.payloads.select_value = AbstractMutableIntShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableIntShortMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableIntShortMapTestCase::collect;
            this.payloads.count = AbstractMutableIntShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableIntShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableIntShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableIntShortMapTestCase::max;
            this.payloads.min = AbstractMutableIntShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableIntShortMapTestCase::sum;
            this.payloads.average = AbstractMutableIntShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableIntShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableIntShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableIntShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractMutableIntShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractMutableIntShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableIntShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableIntShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableIntShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableIntShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableIntShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableIntShortMapTestCase::chunk;
            this.payloads.get = AbstractMutableIntShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableIntShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableIntShortMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableIntShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableIntShortMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableIntShortMapTestCase::contains;
            this.payloads.size = AbstractMutableIntShortMapTestCase::size;
            this.payloads.clear = AbstractMutableIntShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableIntShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableIntShortMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableIntShortMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableIntShortMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableIntShortMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableIntShortMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableIntShortMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableIntShortMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableIntShortMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableIntShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableIntShortMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableIntShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableIntShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableIntShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableIntShortMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableIntShortMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableIntShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableIntShortMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableIntShortMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableIntShortMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableIntShortMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntShortMapTestCase::asUnmodifiable;
            this.payloads.shortIterator_with_remove = AbstractMutableIntShortMapTestCase::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableIntShortMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableIntShortMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableIntShortMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableIntShortMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableIntShortMapTestCase::serializeKeySet;
        }
    }
*/
}
