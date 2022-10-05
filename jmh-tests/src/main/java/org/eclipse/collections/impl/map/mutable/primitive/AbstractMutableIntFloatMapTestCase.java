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
import org.eclipse.collections.api.block.function.primitive.IntToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableIntFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntFloatMapTestCase extends AbstractIntFloatMapTestCase {

    @Override
    protected abstract MutableIntFloatMap classUnderTest();

    @Override
    protected abstract MutableIntFloatMap newWithKeysValues(int key1, float value1);

    @Override
    protected abstract MutableIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2);

    @Override
    protected abstract MutableIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3);

    @Override
    protected abstract MutableIntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3, int key4, float value4);

    @Override
    protected abstract MutableIntFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.put(0, 1.0f);
        Assert.assertEquals(1.0f, map1.get(0), 0.0);
        map1.put(0, 0.0f);
        Assert.assertEquals(0.0f, map1.get(0), 0.0);
        map1.put(5, 5.0f);
        Assert.assertEquals(5.0f, map1.get(5), 0.0);
        map1.put(35, 35.0f);
        Assert.assertEquals(35.0f, map1.get(35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(0), 0.0);
        map1.put(1, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(1), 0.0);
        map1.put(5, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow(5), 0.0);
        map1.put(35, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow(35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals(5.0f, map1.getIfAbsent(0, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(1, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(33, 6.0f), 0.0);
        map1.put(0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(0, 5.0f), 0.0);
        map1.put(1, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(1, 5.0f), 0.0);
        map1.put(5, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(5, 6.0f), 0.0);
        map1.put(35, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent(35, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0.0f, map1.get(0), 0.0);
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0.0f, map1.get(0), 0.0);
        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals(0.0f, map1.get(1), 0.0);
        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals(0.0f, map1.get(31), 0.0);
        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals(0.0f, map1.get(32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.put(35, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.put(35, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey(0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableIntFloatMap hashMap1 = this.newWithKeysValues(1, 1.0f, 0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntFloatMap hashMap = this.newWithKeysValues(6, 6.0f, 5, 5.0f);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntFloatHashMap hashMap = new IntFloatHashMap();
        for (int each = 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntFloatHashMap(), map1);
        map1.put(1, 0.0f);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new IntFloatHashMap(), map1);
        map1.put(33, 0.0f);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new IntFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableIntFloatMap map0 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        map0.removeKey(1);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntFloatHashMap(), map0);
        MutableIntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        map1.removeKey(0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntFloatHashMap(), map1);
        MutableIntFloatMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(31, 31.0f, 32, 32.0f), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 32.0f), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntFloatHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableIntFloatMap map0 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        map0.remove(1);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f), map0);
        map0.remove(0);
        Assert.assertEquals(new IntFloatHashMap(), map0);
        MutableIntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        map1.remove(0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f), map1);
        map1.remove(1);
        Assert.assertEquals(new IntFloatHashMap(), map1);
        MutableIntFloatMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f), map2);
        map2.remove(0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(31, 31.0f, 32, 32.0f), map2);
        map2.remove(31);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 32.0f), map2);
        map2.remove(32);
        Assert.assertEquals(new IntFloatHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableIntFloatMap map0 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent(1, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent(0, 100.0f), 0.0);
        Assert.assertEquals(new IntFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(1, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(0, 100.0f), 0.0);
        MutableIntFloatMap map1 = this.newWithKeysValues(0, 0.0f, 1, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent(0, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent(1, 100.0f), 0.0);
        Assert.assertEquals(new IntFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(1, 100.0f), 0.0);
        MutableIntFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(5, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(50, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 31, 31.0f, 32, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent(0, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(31, 31.0f, 32, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent(31, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent(32, 100.0f), 0.0);
        Assert.assertEquals(new IntFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(31, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(32, 100.0f), 0.0);
        Assert.assertEquals(new IntFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.put(0, 1.0f);
        map1.put(31, 32.0f);
        map1.put(32, 33.0f);
        IntFloatHashMap expected = IntFloatHashMap.newWithKeysValues(0, 1.0f, 31, 32.0f, 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put(1, 2.0f);
        expected.put(1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put(33, 34.0f);
        expected.put(33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put(30, 31.0f);
        expected.put(30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableIntFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10, 25.0f, 30.0f), 0.0);
        map1.removeKey(10);
        Assert.assertEquals(101, map1.getAndPut(10, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableIntFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, 1.0f));
        map1.putPair(PrimitiveTuples.pair(31, 32.0f));
        map1.putPair(PrimitiveTuples.pair(32, 33.0f));
        IntFloatHashMap expected = IntFloatHashMap.newWithKeysValues(0, 1.0f, 31, 32.0f, 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1, 2.0f));
        expected.put(1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33, 34.0f));
        expected.put(33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30, 31.0f));
        expected.put(30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableIntFloatMap map1 = this.newWithKeysValues(0, 11.0f, 1, 12.0f, 2, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableIntFloatMap expected1 = this.newWithKeysValues(0, 11.0f, 1, 12.0f, 2, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableIntFloatMap map2 = this.newWithKeysValues(0, 11.0f, 1, 12.0f, 2, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableIntFloatMap expected2 = this.newWithKeysValues(0, 12.0f, 1, 13.0f, 2, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableIntFloatMap map3 = this.newWithKeysValues(0, 11.0f, 1, 12.0f, 2, 13.0f);
        map3.updateValues((k, v) -> k == 0 ? 10.0f : v);
        MutableIntFloatMap expected3 = this.newWithKeysValues(0, 10.0f, 1, 12.0f, 2, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableIntFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32, 33.0f), 0.0);
        IntFloatHashMap expected = IntFloatHashMap.newWithKeysValues(0, 11.0f, 1, 12.0f, 31, 37.0f, 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5.0, map1.addToValue(31, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableIntFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            int k = (int) each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        IntFloatHashMap hashMap = new IntFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get(i), 0.0);
            hashMap.put(i, (float) i);
            Assert.assertEquals((float) i, hashMap.get(i), 0.0);
            hashMap.remove(i);
            Assert.assertEquals(0.0f, hashMap.get(i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntFloatMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntFloatMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntFloatMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntFloatMapTestCase.generateCollisions().get(3);
        MutableIntFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableIntFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableIntFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableIntFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 50.0f, 1, 50.0f), map1);
        MutableIntFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 50.0f, 1, 50.0f), map2);
        MutableIntFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 50.0f), map3);
        MutableIntFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33, 100.0f), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableIntFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 100.0f, 1, 100.0f), map1);
        MutableIntFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 100.0f, 1, 100.0f), map2);
        MutableIntFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32, factoryThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 100.0f), map3);
        MutableIntFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33, factoryThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableIntFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 9.0f, 1, 9.0f), map1);
        MutableIntFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 9.0f, 1, 9.0f), map2);
        MutableIntFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 9.0f), map3);
        MutableIntFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToFloatFunction function = (int intParameter) -> (float) intParameter;
        IntToFloatFunction functionThrows = (int intParameter) -> {
            throw new AssertionError();
        };
        MutableIntFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 1, 1.0f), map1);
        MutableIntFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 1, 1.0f), map2);
        MutableIntFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32, functionThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(32, 32.0f), map3);
        MutableIntFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33, functionThrows), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableIntFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue(1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 2.0f, 1, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 2.0f, 1, 2.0f), map1);
        MutableIntFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue(0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 1.0f, 1, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 2.0f, 1, 2.0f), map2);
        MutableIntFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue(33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(33, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableIntFloatMap mutableIntFloatMap = this.classUnderTest();
        IntSet frozenSet = mutableIntFloatMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntFloatMap.put((int) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntFloatMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntFloatMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntFloatMap mutableIntFloatMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntFloatMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntFloatMapForClear.keySet().toArray());
        mutableIntFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 31, 31.0f, 32, 32.0f);
        MutableIntFloatMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(0, 0.0f, 1, 1.0f, 31, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableIntFloatMap map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 31, 31.0f, 32, 32.0f);
        MutableIntFloatMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f, 31, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableIntFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, 1.0f), hashMap);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableIntFloatMap emptyMap = this.getEmptyMap();
        MutableIntFloatMap partialMap = this.newWithKeysValues(1, 1.0f, 3, 3.0f);
        MutableIntFloatMap completeMap = this.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f, 4, 4.0f);
        Iterable<IntFloatPair> emptyIterable = Iterables.iList();
        Iterable<IntFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, 1.0f), PrimitiveTuples.pair(3, 3.0f));
        Iterable<IntFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, 1.0f), PrimitiveTuples.pair(2, 2.0f), PrimitiveTuples.pair(3, 3.0f), PrimitiveTuples.pair(4, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedIntFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableIntFloatMap mutableMap = this.classUnderTest();
        MutableFloatIterator iterator = mutableMap.floatIterator();
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
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableIntFloatMap map = this.newWithKeysValues(1, 2.0f, 2, 3.0f, 3, 4.0f, 4, 5.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(2.0f, 1, 3.0f, 2, 4.0f, 3, 5.0f, 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1.0f, 2, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableIntFloatMap map = this.newWithKeysValues(1, 2.0f, 2, 3.0f, 3, 4.0f, 4, 5.0f);
        MutableIntFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableIntFloatMap map = this.newWithKeysValues(1, 2.0f, 2, 3.0f, 3, 4.0f, 4, 5.0f);
        IntSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntFloatMapTestCase._Benchmark {

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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::floatIterator_with_remove, this.description("floatIterator_with_remove"));
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
        public abstract AbstractMutableIntFloatMapTestCase implementation();
    }
}
