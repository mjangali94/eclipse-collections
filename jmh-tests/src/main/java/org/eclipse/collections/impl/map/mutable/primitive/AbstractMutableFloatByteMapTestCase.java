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
import org.eclipse.collections.api.block.function.primitive.FloatToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatByteMapTestCase extends AbstractFloatByteMapTestCase {

    @Override
    protected abstract MutableFloatByteMap classUnderTest();

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1);

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2);

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3);

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3, float key4, byte value4);

    @Override
    protected abstract MutableFloatByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.put(0.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0.0f));
        map1.put(0.0f, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0.0f));
        map1.put(5.0f, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5.0f));
        map1.put(35.0f, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0.0f));
        map1.put(1.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1.0f));
        map1.put(5.0f, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5.0f));
        map1.put(35.0f, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0.0f, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(1.0f, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33.0f, (byte) 6));
        map1.put(0.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0.0f, (byte) 5));
        map1.put(1.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1.0f, (byte) 5));
        map1.put(5.0f, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5.0f, (byte) 6));
        map1.put(35.0f, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35.0f, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((byte) 0, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((byte) 0, map1.get(0.0f));
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals((byte) 0, map1.get(1.0f));
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals((byte) 0, map1.get(31.0f));
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals((byte) 0, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.put(35.0f, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.put(35.0f, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatByteMap hashMap1 = this.newWithKeysValues(1.0f, (byte) 1, 0.0f, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatByteMap hashMap = this.newWithKeysValues(6.0f, (byte) 6, 5.0f, (byte) 5);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatByteHashMap hashMap = new FloatByteHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatByteHashMap(), map1);
        map1.put(1.0f, (byte) 0);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatByteHashMap(), map1);
        map1.put(33.0f, (byte) 0);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatByteMap map0 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatByteHashMap(), map0);
        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatByteHashMap(), map1);
        MutableFloatByteMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableFloatByteMap map0 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map0.remove(1.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatByteHashMap(), map0);
        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map1.remove(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatByteHashMap(), map1);
        MutableFloatByteMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatByteMap map0 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0.0f, (byte) 100));
        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1.0f, (byte) 100));
        MutableFloatByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.put(0.0f, (byte) 1);
        map1.put(31.0f, (byte) 32);
        map1.put(32.0f, (byte) 33);
        FloatByteHashMap expected = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1, 31.0f, (byte) 32, 32.0f, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, (byte) 2);
        expected.put(1.0f, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, (byte) 34);
        expected.put(33.0f, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, (byte) 31);
        expected.put(30.0f, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut(0.0f, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut(0.0f, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut(10.0f, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut(10.0f, (byte) 25, (byte) 30));
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut(10.0f, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31.0f, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32.0f, (byte) 33));
        FloatByteHashMap expected = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1, 31.0f, (byte) 32, 32.0f, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, (byte) 2));
        expected.put(1.0f, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, (byte) 34));
        expected.put(33.0f, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, (byte) 31));
        expected.put(30.0f, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 11, 1.0f, (byte) 12, 2.0f, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableFloatByteMap expected1 = this.newWithKeysValues(0.0f, (byte) 11, 1.0f, (byte) 12, 2.0f, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableFloatByteMap map2 = this.newWithKeysValues(0.0f, (byte) 11, 1.0f, (byte) 12, 2.0f, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableFloatByteMap expected2 = this.newWithKeysValues(0.0f, (byte) 12, 1.0f, (byte) 13, 2.0f, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableFloatByteMap map3 = this.newWithKeysValues(0.0f, (byte) 11, 1.0f, (byte) 12, 2.0f, (byte) 13);
        map3.updateValues((k, v) -> k == 0.0f ? (byte) 10 : v);
        MutableFloatByteMap expected3 = this.newWithKeysValues(0.0f, (byte) 10, 1.0f, (byte) 12, 2.0f, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0f, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (byte) 33));
        FloatByteHashMap expected = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 11, 1.0f, (byte) 12, 31.0f, (byte) 37, 32.0f, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0f, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableFloatByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        FloatByteHashMap hashMap = new FloatByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((float) i));
            hashMap.put((float) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals((byte) 0, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatByteMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatByteMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatByteMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatByteMapTestCase.generateCollisions().get(3);
        MutableFloatByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableFloatByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableFloatByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 50, 1.0f, (byte) 50), map1);
        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 50, 1.0f, (byte) 50), map2);
        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 50), map3);
        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 100, 1.0f, (byte) 100), map1);
        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 100, 1.0f, (byte) 100), map2);
        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 100), map3);
        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 9, 1.0f, (byte) 9), map1);
        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 9, 1.0f, (byte) 9), map2);
        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 9), map3);
        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToByteFunction function = (float floatParameter) -> (byte) floatParameter;
        FloatToByteFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1), map1);
        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1), map2);
        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map3);
        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2, 1.0f, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2, 1.0f, (byte) 2), map1);
        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1, 1.0f, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2, 1.0f, (byte) 2), map2);
        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableFloatByteMap mutableFloatByteMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatByteMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatByteMap.put((float) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatByteMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatByteMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatByteMap mutableFloatByteMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatByteMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatByteMapForClear.keySet().toArray());
        mutableFloatByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatByteMap map = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 31.0f, (byte) 31, 32.0f, (byte) 32);
        MutableFloatByteMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 31.0f, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatByteMap map = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 31.0f, (byte) 31, 32.0f, (byte) 32);
        MutableFloatByteMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 31.0f, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, (byte) 1), hashMap);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatByteMap emptyMap = this.getEmptyMap();
        MutableFloatByteMap partialMap = this.newWithKeysValues(1.0f, (byte) 1, 3.0f, (byte) 3);
        MutableFloatByteMap completeMap = this.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        Iterable<FloatBytePair> emptyIterable = Iterables.iList();
        Iterable<FloatBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, (byte) 1), PrimitiveTuples.pair(3.0f, (byte) 3));
        Iterable<FloatBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, (byte) 1), PrimitiveTuples.pair(2.0f, (byte) 2), PrimitiveTuples.pair(3.0f, (byte) 3), PrimitiveTuples.pair(4.0f, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedFloatByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableFloatByteMap mutableMap = this.classUnderTest();
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
        MutableFloatByteMap map = this.newWithKeysValues(1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f, (byte) 5);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 2, 1.0f, (byte) 3, 2.0f, (byte) 4, 3.0f, (byte) 5, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatByteMap map = this.newWithKeysValues(1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f, (byte) 5);
        MutableFloatByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatByteMap map = this.newWithKeysValues(1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f, (byte) 5);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatByteMapTestCase instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatByteMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatByteMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatByteMapTestCase::max;
            this.payloads.min = AbstractMutableFloatByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatByteMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableFloatByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableFloatByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatByteMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatByteMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableFloatByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatByteMapTestCase::serializeKeySet;
        }
    }
*/
}
