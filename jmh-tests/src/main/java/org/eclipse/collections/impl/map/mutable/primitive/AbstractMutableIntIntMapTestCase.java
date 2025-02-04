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
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableIntIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntIntMapTestCase extends AbstractIntIntMapTestCase {

    @Override
    protected abstract MutableIntIntMap classUnderTest();

    @Override
    protected abstract MutableIntIntMap newWithKeysValues(int key1, int value1);

    @Override
    protected abstract MutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2);

    @Override
    protected abstract MutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3);

    @Override
    protected abstract MutableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4);

    @Override
    protected abstract MutableIntIntMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableIntIntMap map1 = this.classUnderTest();
        map1.put(0, 1);
        Assert.assertEquals(1, map1.get(0));
        map1.put(0, 0);
        Assert.assertEquals(0, map1.get(0));
        map1.put(5, 5);
        Assert.assertEquals(5, map1.get(5));
        map1.put(35, 35);
        Assert.assertEquals(35, map1.get(35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableIntIntMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, 1);
        Assert.assertEquals(1, map1.getOrThrow(0));
        map1.put(1, 1);
        Assert.assertEquals(1, map1.getOrThrow(1));
        map1.put(5, 5);
        Assert.assertEquals(5, map1.getOrThrow(5));
        map1.put(35, 35);
        Assert.assertEquals(35, map1.getOrThrow(35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableIntIntMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals(5, map1.getIfAbsent(0, 5));
        Assert.assertEquals(6, map1.getIfAbsent(1, 6));
        Assert.assertEquals(6, map1.getIfAbsent(33, 6));
        map1.put(0, 1);
        Assert.assertEquals(1, map1.getIfAbsent(0, 5));
        map1.put(1, 1);
        Assert.assertEquals(1, map1.getIfAbsent(1, 5));
        map1.put(5, 5);
        Assert.assertEquals(5, map1.getIfAbsent(5, 6));
        map1.put(35, 35);
        Assert.assertEquals(35, map1.getIfAbsent(35, 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableIntIntMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0, map1.get(0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0, map1.get(0));
        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals(0, map1.get(1));
        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals(0, map1.get(31));
        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals(0, map1.get(32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableIntIntMap map1 = this.classUnderTest();
        map1.put(35, 35);
        Assert.assertTrue(map1.containsValue(35));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableIntIntMap map1 = this.classUnderTest();
        map1.put(35, 35);
        Assert.assertTrue(map1.contains(35));
        map1.removeKey(0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableIntIntMap hashMap1 = this.newWithKeysValues(1, 1, 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntIntMap hashMap = this.newWithKeysValues(6, 6, 5, 5);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntIntHashMap hashMap = new IntIntHashMap();
        for (int each = 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntIntHashMap(), map1);
        map1.put(1, 0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 0), map1);
        map1.clear();
        Assert.assertEquals(new IntIntHashMap(), map1);
        map1.put(33, 0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 0), map1);
        map1.clear();
        Assert.assertEquals(new IntIntHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableIntIntMap map0 = this.newWithKeysValues(0, 0, 1, 1);
        map0.removeKey(1);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntIntHashMap(), map0);
        MutableIntIntMap map1 = this.newWithKeysValues(0, 0, 1, 1);
        map1.removeKey(0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntIntHashMap(), map1);
        MutableIntIntMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(31, 31, 32, 32), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 32), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntIntHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableIntIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableIntIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableIntIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableIntIntMap map0 = this.newWithKeysValues(0, 0, 1, 1);
        map0.remove(1);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0), map0);
        map0.remove(0);
        Assert.assertEquals(new IntIntHashMap(), map0);
        MutableIntIntMap map1 = this.newWithKeysValues(0, 0, 1, 1);
        map1.remove(0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1), map1);
        map1.remove(1);
        Assert.assertEquals(new IntIntHashMap(), map1);
        MutableIntIntMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32), map2);
        map2.remove(0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(31, 31, 32, 32), map2);
        map2.remove(31);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 32), map2);
        map2.remove(32);
        Assert.assertEquals(new IntIntHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableIntIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableIntIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableIntIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableIntIntMap map0 = this.newWithKeysValues(0, 0, 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent(1, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent(0, 100));
        Assert.assertEquals(new IntIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent(1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent(0, 100));
        MutableIntIntMap map1 = this.newWithKeysValues(0, 0, 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent(0, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent(1, 100));
        Assert.assertEquals(new IntIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent(0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent(1, 100));
        MutableIntIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent(5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(50, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent(0, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(31, 31, 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent(31, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent(32, 100));
        Assert.assertEquals(new IntIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent(0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(32, 100));
        Assert.assertEquals(new IntIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableIntIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableIntIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableIntIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableIntIntMap map1 = this.classUnderTest();
        map1.put(0, 1);
        map1.put(31, 32);
        map1.put(32, 33);
        IntIntHashMap expected = IntIntHashMap.newWithKeysValues(0, 1, 31, 32, 32, 33);
        Assert.assertEquals(expected, map1);
        map1.put(1, 2);
        expected.put(1, 2);
        Assert.assertEquals(expected, map1);
        map1.put(33, 34);
        expected.put(33, 34);
        Assert.assertEquals(expected, map1);
        map1.put(30, 31);
        expected.put(30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableIntIntMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0, 25, 50));
        Assert.assertEquals(25, map1.getAndPut(0, 35, 50));
        Assert.assertEquals(35, map1.getAndPut(0, 45, 55));
        Assert.assertEquals(100, map1.getAndPut(10, 25, 100));
        Assert.assertEquals(25, map1.getAndPut(10, 25, 30));
        map1.removeKey(10);
        Assert.assertEquals(101, map1.getAndPut(10, 25, 101));
        Assert.assertEquals(25, map1.getAndPut(10, 27, 105));
    }

    @Test
    public void putPair() {
        MutableIntIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, 1));
        map1.putPair(PrimitiveTuples.pair(31, 32));
        map1.putPair(PrimitiveTuples.pair(32, 33));
        IntIntHashMap expected = IntIntHashMap.newWithKeysValues(0, 1, 31, 32, 32, 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1, 2));
        expected.put(1, 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33, 34));
        expected.put(33, 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30, 31));
        expected.put(30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableIntIntMap map1 = this.newWithKeysValues(0, 11, 1, 12, 2, 13);
        map1.updateValues((k, v) -> v);
        MutableIntIntMap expected1 = this.newWithKeysValues(0, 11, 1, 12, 2, 13);
        Assert.assertEquals(expected1, map1);
        MutableIntIntMap map2 = this.newWithKeysValues(0, 11, 1, 12, 2, 13);
        map2.updateValues((k, v) -> v + 1);
        MutableIntIntMap expected2 = this.newWithKeysValues(0, 12, 1, 13, 2, 14);
        Assert.assertEquals(expected2, map2);
        MutableIntIntMap map3 = this.newWithKeysValues(0, 11, 1, 12, 2, 13);
        map3.updateValues((k, v) -> k == 0 ? 10 : v);
        MutableIntIntMap expected3 = this.newWithKeysValues(0, 10, 1, 12, 2, 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableIntIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, 1));
        Assert.assertEquals(32L, map1.addToValue(31, 32));
        Assert.assertEquals(3L, map1.addToValue(1, 3));
        Assert.assertEquals(11L, map1.addToValue(0, 10));
        Assert.assertEquals(12L, map1.addToValue(1, 9));
        Assert.assertEquals(37L, map1.addToValue(31, 5));
        Assert.assertEquals(33L, map1.addToValue(32, 33));
        IntIntHashMap expected = IntIntHashMap.newWithKeysValues(0, 11, 1, 12, 31, 37, 32, 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5L, map1.addToValue(31, 5));
        Assert.assertEquals(37L, map1.addToValue(31, 32));
        Assert.assertEquals(33L, map1.addToValue(32, 33));
        Assert.assertEquals(3L, map1.addToValue(1, 3));
        Assert.assertEquals(1L, map1.addToValue(0, 1));
        Assert.assertEquals(12L, map1.addToValue(1, 9));
        Assert.assertEquals(11L, map1.addToValue(0, 10));
        Assert.assertEquals(expected, map1);
        MutableIntIntMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            int k = (int) each;
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        IntIntHashMap hashMap = new IntIntHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get(i));
            hashMap.put(i, i);
            Assert.assertEquals(i, hashMap.get(i));
            hashMap.remove(i);
            Assert.assertEquals(0, hashMap.get(i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntIntMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntIntMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntIntMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntIntMapTestCase.generateCollisions().get(3);
        MutableIntIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableIntIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableIntIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableIntIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 50, 1, 50), map1);
        MutableIntIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 50, 1, 50), map2);
        MutableIntIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 50), map3);
        MutableIntIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, 100));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableIntIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 100, 1, 100), map1);
        MutableIntIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 100, 1, 100), map2);
        MutableIntIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factoryThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 100), map3);
        MutableIntIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factoryThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableIntIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 9, 1, 9), map1);
        MutableIntIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 9, 1, 9), map2);
        MutableIntIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32, functionThrows, "unused"));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 9), map3);
        MutableIntIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33, functionThrows, "unused"));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToIntFunction function = (int intParameter) -> (int) intParameter;
        IntToIntFunction functionThrows = (int intParameter) -> {
            throw new AssertionError();
        };
        MutableIntIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0, 1, 1), map1);
        MutableIntIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0, 1, 1), map2);
        MutableIntIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, functionThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(32, 32), map3);
        MutableIntIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, functionThrows));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 33), map4);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableIntIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 2, 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 2, 1, 2), map1);
        MutableIntIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 1, 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 2, 1, 2), map2);
        MutableIntIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33, 0, incrementFunction));
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableIntIntMap mutableIntIntMap = this.classUnderTest();
        IntSet frozenSet = mutableIntIntMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntIntMap.put((int) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntIntMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntIntMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntIntMap mutableIntIntMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntIntMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntIntMapForClear.keySet().toArray());
        mutableIntIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntIntMap map = this.newWithKeysValues(0, 0, 1, 1, 31, 31, 32, 32);
        MutableIntIntMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0, 1, 1, 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableIntIntMap map = this.newWithKeysValues(0, 0, 1, 1, 31, 31, 32, 32);
        MutableIntIntMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1, 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableIntIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, 1), hashMap);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableIntIntMap emptyMap = this.getEmptyMap();
        MutableIntIntMap partialMap = this.newWithKeysValues(1, 1, 3, 3);
        MutableIntIntMap completeMap = this.newWithKeysValues(1, 1, 2, 2, 3, 3, 4, 4);
        Iterable<IntIntPair> emptyIterable = Iterables.iList();
        Iterable<IntIntPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(3, 3));
        Iterable<IntIntPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, 1), PrimitiveTuples.pair(2, 2), PrimitiveTuples.pair(3, 3), PrimitiveTuples.pair(4, 4));
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
        Verify.assertInstanceOf(SynchronizedIntIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove() {
        MutableIntIntMap mutableMap = this.classUnderTest();
        MutableIntIterator iterator = mutableMap.intIterator();
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
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableIntIntMap map = this.newWithKeysValues(1, 2, 2, 3, 3, 4, 4, 5);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(2, 1, 3, 2, 4, 3, 5, 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1, 2, 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableIntIntMap map = this.newWithKeysValues(1, 2, 2, 3, 3, 4, 4, 5);
        MutableIntIntMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableIntIntMap map = this.newWithKeysValues(1, 2, 2, 3, 3, 4, 4, 5);
        IntSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntIntMapTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntIntMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableIntIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableIntIntMapTestCase::values;
            this.payloads.containsAll = AbstractMutableIntIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableIntIntMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableIntIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableIntIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableIntIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntIntMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableIntIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableIntIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableIntIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableIntIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableIntIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableIntIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableIntIntMapTestCase::select;
            this.payloads.reject = AbstractMutableIntIntMapTestCase::reject;
            this.payloads.select_value = AbstractMutableIntIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableIntIntMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableIntIntMapTestCase::collect;
            this.payloads.count = AbstractMutableIntIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableIntIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableIntIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableIntIntMapTestCase::max;
            this.payloads.min = AbstractMutableIntIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableIntIntMapTestCase::sum;
            this.payloads.average = AbstractMutableIntIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableIntIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableIntIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableIntIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractMutableIntIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractMutableIntIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableIntIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableIntIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableIntIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableIntIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableIntIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableIntIntMapTestCase::chunk;
            this.payloads.get = AbstractMutableIntIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableIntIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableIntIntMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableIntIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableIntIntMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableIntIntMapTestCase::contains;
            this.payloads.size = AbstractMutableIntIntMapTestCase::size;
            this.payloads.clear = AbstractMutableIntIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableIntIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableIntIntMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableIntIntMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableIntIntMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableIntIntMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableIntIntMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableIntIntMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableIntIntMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableIntIntMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableIntIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableIntIntMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableIntIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableIntIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableIntIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableIntIntMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableIntIntMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableIntIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableIntIntMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableIntIntMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableIntIntMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableIntIntMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntIntMapTestCase::asUnmodifiable;
            this.payloads.intIterator_with_remove = AbstractMutableIntIntMapTestCase::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableIntIntMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableIntIntMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableIntIntMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableIntIntMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableIntIntMapTestCase::serializeKeySet;
        }
    }
}
