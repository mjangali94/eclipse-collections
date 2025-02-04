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
import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatCharPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatCharMapTestCase extends AbstractFloatCharMapTestCase {

    @Override
    protected abstract MutableFloatCharMap classUnderTest();

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1);

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2);

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3);

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4);

    @Override
    protected abstract MutableFloatCharMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.put(0.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.get(0.0f));
        map1.put(0.0f, (char) 0);
        Assert.assertEquals((char) 0, map1.get(0.0f));
        map1.put(5.0f, (char) 5);
        Assert.assertEquals((char) 5, map1.get(5.0f));
        map1.put(35.0f, (char) 35);
        Assert.assertEquals((char) 35, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(0.0f));
        map1.put(1.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(1.0f));
        map1.put(5.0f, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow(5.0f));
        map1.put(35.0f, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals((char) 5, map1.getIfAbsent(0.0f, (char) 5));
        Assert.assertEquals((char) 6, map1.getIfAbsent(1.0f, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent(33.0f, (char) 6));
        map1.put(0.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(0.0f, (char) 5));
        map1.put(1.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(1.0f, (char) 5));
        map1.put(5.0f, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent(5.0f, (char) 6));
        map1.put(35.0f, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent(35.0f, (char) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((char) 0, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((char) 0, map1.get(0.0f));
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals((char) 0, map1.get(1.0f));
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals((char) 0, map1.get(31.0f));
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals((char) 0, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.put(35.0f, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.put(35.0f, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatCharMap hashMap1 = this.newWithKeysValues(1.0f, (char) 1, 0.0f, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatCharMap hashMap = this.newWithKeysValues(6.0f, (char) 6, 5.0f, (char) 5);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatCharHashMap(), map1);
        map1.put(1.0f, (char) 0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatCharHashMap(), map1);
        map1.put(33.0f, (char) 0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatCharHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatCharMap map0 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatCharHashMap(), map0);
        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatCharHashMap(), map1);
        MutableFloatCharMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableFloatCharMap map0 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map0.remove(1.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatCharHashMap(), map0);
        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map1.remove(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatCharHashMap(), map1);
        MutableFloatCharMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatCharMap map0 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent(1.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(1.0f, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(0.0f, (char) 100));
        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent(1.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(1.0f, (char) 100));
        MutableFloatCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(5.0f, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(50.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(31.0f, (char) 31, 32.0f, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent(31.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent(32.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(31.0f, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(32.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.put(0.0f, (char) 1);
        map1.put(31.0f, (char) 32);
        map1.put(32.0f, (char) 33);
        FloatCharHashMap expected = FloatCharHashMap.newWithKeysValues(0.0f, (char) 1, 31.0f, (char) 32, 32.0f, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, (char) 2);
        expected.put(1.0f, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, (char) 34);
        expected.put(33.0f, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, (char) 31);
        expected.put(30.0f, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatCharMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, (char) 25, (char) 50));
        Assert.assertEquals(25, map1.getAndPut(0.0f, (char) 35, (char) 50));
        Assert.assertEquals(35, map1.getAndPut(0.0f, (char) 45, (char) 55));
        Assert.assertEquals(100, map1.getAndPut(10.0f, (char) 25, (char) 100));
        Assert.assertEquals(25, map1.getAndPut(10.0f, (char) 25, (char) 30));
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, (char) 25, (char) 101));
        Assert.assertEquals(25, map1.getAndPut(10.0f, (char) 27, (char) 105));
    }

    @Test
    public void putPair() {
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, (char) 1));
        map1.putPair(PrimitiveTuples.pair(31.0f, (char) 32));
        map1.putPair(PrimitiveTuples.pair(32.0f, (char) 33));
        FloatCharHashMap expected = FloatCharHashMap.newWithKeysValues(0.0f, (char) 1, 31.0f, (char) 32, 32.0f, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, (char) 2));
        expected.put(1.0f, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, (char) 34));
        expected.put(33.0f, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, (char) 31));
        expected.put(30.0f, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 11, 1.0f, (char) 12, 2.0f, (char) 13);
        map1.updateValues((k, v) -> v);
        MutableFloatCharMap expected1 = this.newWithKeysValues(0.0f, (char) 11, 1.0f, (char) 12, 2.0f, (char) 13);
        Assert.assertEquals(expected1, map1);
        MutableFloatCharMap map2 = this.newWithKeysValues(0.0f, (char) 11, 1.0f, (char) 12, 2.0f, (char) 13);
        map2.updateValues((k, v) -> (char) (v + (char) 1));
        MutableFloatCharMap expected2 = this.newWithKeysValues(0.0f, (char) 12, 1.0f, (char) 13, 2.0f, (char) 14);
        Assert.assertEquals(expected2, map2);
        MutableFloatCharMap map3 = this.newWithKeysValues(0.0f, (char) 11, 1.0f, (char) 12, 2.0f, (char) 13);
        map3.updateValues((k, v) -> k == 0.0f ? (char) 10 : v);
        MutableFloatCharMap expected3 = this.newWithKeysValues(0.0f, (char) 10, 1.0f, (char) 12, 2.0f, (char) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, (char) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0f, (char) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (char) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (char) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (char) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (char) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (char) 33));
        FloatCharHashMap expected = FloatCharHashMap.newWithKeysValues(0.0f, (char) 11, 1.0f, (char) 12, 31.0f, (char) 37, 32.0f, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, (char) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (char) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (char) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (char) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0f, (char) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (char) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (char) 10));
        Assert.assertEquals(expected, map1);
        MutableFloatCharMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((char) 0, hashMap.get((float) i));
            hashMap.put((float) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals((char) 0, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatCharMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatCharMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatCharMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatCharMapTestCase.generateCollisions().get(3);
        MutableFloatCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);
        MutableFloatCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);
        MutableFloatCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 50, 1.0f, (char) 50), map1);
        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 50, 1.0f, (char) 50), map2);
        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 50), map3);
        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 100, 1.0f, (char) 100), map1);
        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 100, 1.0f, (char) 100), map2);
        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 100), map3);
        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 9, 1.0f, (char) 9), map1);
        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 9, 1.0f, (char) 9), map2);
        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 9), map3);
        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToCharFunction function = (float floatParameter) -> (char) floatParameter;
        FloatToCharFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1), map1);
        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1), map2);
        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map3);
        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 33), map4);
    }

    @Test
    public void updateValue() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2, 1.0f, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2, 1.0f, (char) 2), map1);
        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 1, 1.0f, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2, 1.0f, (char) 2), map2);
        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 2), map3);
    }

    @Test
    public void freeze() {
        MutableFloatCharMap mutableFloatCharMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatCharMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatCharMap.put((float) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatCharMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatCharMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatCharMap mutableFloatCharMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatCharMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatCharMapForClear.keySet().toArray());
        mutableFloatCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatCharMap map = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 31.0f, (char) 31, 32.0f, (char) 32);
        MutableFloatCharMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 31.0f, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatCharMap map = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 31.0f, (char) 31, 32.0f, (char) 32);
        MutableFloatCharMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 31.0f, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, (char) 1), hashMap);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatCharMap emptyMap = this.getEmptyMap();
        MutableFloatCharMap partialMap = this.newWithKeysValues(1.0f, (char) 1, 3.0f, (char) 3);
        MutableFloatCharMap completeMap = this.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        Iterable<FloatCharPair> emptyIterable = Iterables.iList();
        Iterable<FloatCharPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, (char) 1), PrimitiveTuples.pair(3.0f, (char) 3));
        Iterable<FloatCharPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, (char) 1), PrimitiveTuples.pair(2.0f, (char) 2), PrimitiveTuples.pair(3.0f, (char) 3), PrimitiveTuples.pair(4.0f, (char) 4));
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
        Verify.assertInstanceOf(SynchronizedFloatCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove() {
        MutableFloatCharMap mutableMap = this.classUnderTest();
        MutableCharIterator iterator = mutableMap.charIterator();
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
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableFloatCharMap map = this.newWithKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 2, 1.0f, (char) 3, 2.0f, (char) 4, 3.0f, (char) 5, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatCharMap map = this.newWithKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5);
        MutableFloatCharMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatCharMap map = this.newWithKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatCharMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatCharMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatCharMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatCharMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatCharMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatCharMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatCharMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatCharMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatCharMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatCharMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatCharMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatCharMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatCharMapTestCase::max;
            this.payloads.min = AbstractMutableFloatCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatCharMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatCharMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractMutableFloatCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractMutableFloatCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatCharMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatCharMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatCharMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatCharMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatCharMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatCharMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatCharMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatCharMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatCharMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatCharMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatCharMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatCharMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatCharMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatCharMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatCharMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatCharMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatCharMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatCharMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatCharMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatCharMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatCharMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatCharMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatCharMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatCharMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatCharMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatCharMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatCharMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatCharMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatCharMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatCharMapTestCase::asUnmodifiable;
            this.payloads.charIterator_with_remove = AbstractMutableFloatCharMapTestCase::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatCharMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatCharMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatCharMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatCharMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatCharMapTestCase::serializeKeySet;
        }
    }
}
