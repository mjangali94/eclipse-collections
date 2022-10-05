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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntIntMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKey, this.description("removeKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKeyIfAbsent, this.description("removeKeyIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put, this.description("put"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getAndPut, this.description("getAndPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putPair, this.description("putPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValues, this.description("updateValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addToValue, this.description("addToValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_every_slot, this.description("put_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putDuplicateWithRemovedSlot, this.description("putDuplicateWithRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_Function, this.description("getIfAbsentPut_Function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithKey, this.description("getIfAbsentPutWithKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue, this.description("updateValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::freeze, this.description("freeze"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutKey, this.description("withoutKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAllKeys, this.description("withoutAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAllKeyValues, this.description("withAllKeyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::intIterator_with_remove, this.description("intIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_invocation_of_remove_before_next, this.description("iterator_throws_on_invocation_of_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_consecutive_invocation_of_remove, this.description("iterator_throws_on_consecutive_invocation_of_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialize, this.description("serialize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serializeKeySet, this.description("serializeKeySet"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableIntIntMapTestCase implementation();
    }
}
