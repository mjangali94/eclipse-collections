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
import org.eclipse.collections.api.block.function.primitive.FloatToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatIntMapTestCase extends AbstractFloatIntMapTestCase {

    @Override
    protected abstract MutableFloatIntMap classUnderTest();

    @Override
    protected abstract MutableFloatIntMap newWithKeysValues(float key1, int value1);

    @Override
    protected abstract MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2);

    @Override
    protected abstract MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3);

    @Override
    protected abstract MutableFloatIntMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4);

    @Override
    protected abstract MutableFloatIntMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.put(0.0f, 1);
        Assert.assertEquals(1, map1.get(0.0f));
        map1.put(0.0f, 0);
        Assert.assertEquals(0, map1.get(0.0f));
        map1.put(5.0f, 5);
        Assert.assertEquals(5, map1.get(5.0f));
        map1.put(35.0f, 35);
        Assert.assertEquals(35, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1);
        Assert.assertEquals(1, map1.getOrThrow(0.0f));
        map1.put(1.0f, 1);
        Assert.assertEquals(1, map1.getOrThrow(1.0f));
        map1.put(5.0f, 5);
        Assert.assertEquals(5, map1.getOrThrow(5.0f));
        map1.put(35.0f, 35);
        Assert.assertEquals(35, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5, map1.getIfAbsent(0.0f, 5));
        Assert.assertEquals(6, map1.getIfAbsent(1.0f, 6));
        Assert.assertEquals(6, map1.getIfAbsent(33.0f, 6));
        map1.put(0.0f, 1);
        Assert.assertEquals(1, map1.getIfAbsent(0.0f, 5));
        map1.put(1.0f, 1);
        Assert.assertEquals(1, map1.getIfAbsent(1.0f, 5));
        map1.put(5.0f, 5);
        Assert.assertEquals(5, map1.getIfAbsent(5.0f, 6));
        map1.put(35.0f, 35);
        Assert.assertEquals(35, map1.getIfAbsent(35.0f, 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0, map1.get(0.0f));
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0, map1.get(1.0f));
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0, map1.get(31.0f));
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.put(35.0f, 35);
        Assert.assertTrue(map1.containsValue(35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.put(35.0f, 35);
        Assert.assertTrue(map1.contains(35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatIntMap hashMap1 = this.newWithKeysValues(1.0f, 1, 0.0f, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatIntMap hashMap = this.newWithKeysValues(6.0f, 6, 5.0f, 5);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatIntHashMap hashMap = new FloatIntHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatIntHashMap(), map1);
        map1.put(1.0f, 0);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatIntHashMap(), map1);
        map1.put(33.0f, 0);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatIntHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatIntMap map0 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatIntHashMap(), map0);
        MutableFloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatIntHashMap(), map1);
        MutableFloatIntMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(31.0f, 31, 32.0f, 32), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 32), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatIntHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableFloatIntMap map0 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        map0.remove(1.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatIntHashMap(), map0);
        MutableFloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        map1.remove(0.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatIntHashMap(), map1);
        MutableFloatIntMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(31.0f, 31, 32.0f, 32), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 32), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatIntHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatIntMap map0 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent(1.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent(0.0f, 100));
        Assert.assertEquals(new FloatIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent(1.0f, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent(0.0f, 100));
        MutableFloatIntMap map1 = this.newWithKeysValues(0.0f, 0, 1.0f, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent(0.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent(1.0f, 100));
        Assert.assertEquals(new FloatIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent(0.0f, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent(1.0f, 100));
        MutableFloatIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent(5.0f, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(50.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent(0.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(31.0f, 31, 32.0f, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent(31.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent(32.0f, 100));
        Assert.assertEquals(new FloatIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent(0.0f, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(31.0f, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(32.0f, 100));
        Assert.assertEquals(new FloatIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.put(0.0f, 1);
        map1.put(31.0f, 32);
        map1.put(32.0f, 33);
        FloatIntHashMap expected = FloatIntHashMap.newWithKeysValues(0.0f, 1, 31.0f, 32, 32.0f, 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, 2);
        expected.put(1.0f, 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, 34);
        expected.put(33.0f, 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, 31);
        expected.put(30.0f, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatIntMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, 25, 50));
        Assert.assertEquals(25, map1.getAndPut(0.0f, 35, 50));
        Assert.assertEquals(35, map1.getAndPut(0.0f, 45, 55));
        Assert.assertEquals(100, map1.getAndPut(10.0f, 25, 100));
        Assert.assertEquals(25, map1.getAndPut(10.0f, 25, 30));
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, 25, 101));
        Assert.assertEquals(25, map1.getAndPut(10.0f, 27, 105));
    }

    @Test
    public void putPair() {
        MutableFloatIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33));
        FloatIntHashMap expected = FloatIntHashMap.newWithKeysValues(0.0f, 1, 31.0f, 32, 32.0f, 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, 2));
        expected.put(1.0f, 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, 34));
        expected.put(33.0f, 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, 31));
        expected.put(30.0f, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatIntMap map1 = this.newWithKeysValues(0.0f, 11, 1.0f, 12, 2.0f, 13);
        map1.updateValues((k, v) -> v);
        MutableFloatIntMap expected1 = this.newWithKeysValues(0.0f, 11, 1.0f, 12, 2.0f, 13);
        Assert.assertEquals(expected1, map1);
        MutableFloatIntMap map2 = this.newWithKeysValues(0.0f, 11, 1.0f, 12, 2.0f, 13);
        map2.updateValues((k, v) -> v + 1);
        MutableFloatIntMap expected2 = this.newWithKeysValues(0.0f, 12, 1.0f, 13, 2.0f, 14);
        Assert.assertEquals(expected2, map2);
        MutableFloatIntMap map3 = this.newWithKeysValues(0.0f, 11, 1.0f, 12, 2.0f, 13);
        map3.updateValues((k, v) -> k == 0.0f ? 10 : v);
        MutableFloatIntMap expected3 = this.newWithKeysValues(0.0f, 10, 1.0f, 12, 2.0f, 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, 1));
        Assert.assertEquals(32L, map1.addToValue(31.0f, 32));
        Assert.assertEquals(3L, map1.addToValue(1.0f, 3));
        Assert.assertEquals(11L, map1.addToValue(0.0f, 10));
        Assert.assertEquals(12L, map1.addToValue(1.0f, 9));
        Assert.assertEquals(37L, map1.addToValue(31.0f, 5));
        Assert.assertEquals(33L, map1.addToValue(32.0f, 33));
        FloatIntHashMap expected = FloatIntHashMap.newWithKeysValues(0.0f, 11, 1.0f, 12, 31.0f, 37, 32.0f, 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, 5));
        Assert.assertEquals(37L, map1.addToValue(31.0f, 32));
        Assert.assertEquals(33L, map1.addToValue(32.0f, 33));
        Assert.assertEquals(3L, map1.addToValue(1.0f, 3));
        Assert.assertEquals(1L, map1.addToValue(0.0f, 1));
        Assert.assertEquals(12L, map1.addToValue(1.0f, 9));
        Assert.assertEquals(11L, map1.addToValue(0.0f, 10));
        Assert.assertEquals(expected, map1);
        MutableFloatIntMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        FloatIntHashMap hashMap = new FloatIntHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((float) i));
            hashMap.put((float) i, i);
            Assert.assertEquals(i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals(0, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatIntMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatIntMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatIntMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatIntMapTestCase.generateCollisions().get(3);
        MutableFloatIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableFloatIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableFloatIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 50, 1.0f, 50), map1);
        MutableFloatIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 50, 1.0f, 50), map2);
        MutableFloatIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 50), map3);
        MutableFloatIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, 100));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 100, 1.0f, 100), map1);
        MutableFloatIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 100, 1.0f, 100), map2);
        MutableFloatIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 100), map3);
        MutableFloatIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 9, 1.0f, 9), map1);
        MutableFloatIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 9, 1.0f, 9), map2);
        MutableFloatIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 9), map3);
        MutableFloatIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToIntFunction function = (float floatParameter) -> (int) floatParameter;
        FloatToIntFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 1.0f, 1), map1);
        MutableFloatIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 1.0f, 1), map2);
        MutableFloatIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(32.0f, 32), map3);
        MutableFloatIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 33), map4);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableFloatIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 2, 1.0f, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 2, 1.0f, 2), map1);
        MutableFloatIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 1, 1.0f, 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 2, 1.0f, 2), map2);
        MutableFloatIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, 0, incrementFunction));
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(33.0f, 2), map3);
    }

    @Test
    public void freeze() {
        MutableFloatIntMap mutableFloatIntMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatIntMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatIntMap.put((float) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatIntMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatIntMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatIntMap mutableFloatIntMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatIntMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatIntMapForClear.keySet().toArray());
        mutableFloatIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 31.0f, 31, 32.0f, 32);
        MutableFloatIntMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0, 1.0f, 1, 31.0f, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatIntMap map = this.newWithKeysValues(0.0f, 0, 1.0f, 1, 31.0f, 31, 32.0f, 32);
        MutableFloatIntMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 31.0f, 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1), hashMap);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatIntMap emptyMap = this.getEmptyMap();
        MutableFloatIntMap partialMap = this.newWithKeysValues(1.0f, 1, 3.0f, 3);
        MutableFloatIntMap completeMap = this.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3, 4.0f, 4);
        Iterable<FloatIntPair> emptyIterable = Iterables.iList();
        Iterable<FloatIntPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1), PrimitiveTuples.pair(3.0f, 3));
        Iterable<FloatIntPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1), PrimitiveTuples.pair(2.0f, 2), PrimitiveTuples.pair(3.0f, 3), PrimitiveTuples.pair(4.0f, 4));
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
        Verify.assertInstanceOf(SynchronizedFloatIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove() {
        MutableFloatIntMap mutableMap = this.classUnderTest();
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
        MutableFloatIntMap map = this.newWithKeysValues(1.0f, 2, 2.0f, 3, 3.0f, 4, 4.0f, 5);
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(2, 1.0f, 3, 2.0f, 4, 3.0f, 5, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1, 2.0f, 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatIntMap map = this.newWithKeysValues(1.0f, 2, 2.0f, 3, 3.0f, 4, 4.0f, 5);
        MutableFloatIntMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatIntMap map = this.newWithKeysValues(1.0f, 2, 2.0f, 3, 3.0f, 4, 4.0f, 5);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatIntMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatIntMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatIntMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatIntMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatIntMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatIntMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatIntMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatIntMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatIntMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatIntMapTestCase::max;
            this.payloads.min = AbstractMutableFloatIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatIntMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractMutableFloatIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractMutableFloatIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatIntMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatIntMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatIntMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatIntMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatIntMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatIntMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatIntMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatIntMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatIntMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatIntMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatIntMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatIntMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatIntMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatIntMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatIntMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatIntMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatIntMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatIntMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatIntMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatIntMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatIntMapTestCase::asUnmodifiable;
            this.payloads.intIterator_with_remove = AbstractMutableFloatIntMapTestCase::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatIntMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatIntMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatIntMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatIntMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatIntMapTestCase::serializeKeySet;
        }
    }
}
