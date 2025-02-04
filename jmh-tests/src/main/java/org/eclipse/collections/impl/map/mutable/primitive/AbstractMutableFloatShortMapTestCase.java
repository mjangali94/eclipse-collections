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
import org.eclipse.collections.api.block.function.primitive.FloatToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatShortMapTestCase extends AbstractFloatShortMapTestCase {

    @Override
    protected abstract MutableFloatShortMap classUnderTest();

    @Override
    protected abstract MutableFloatShortMap newWithKeysValues(float key1, short value1);

    @Override
    protected abstract MutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2);

    @Override
    protected abstract MutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3);

    @Override
    protected abstract MutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3, float key4, short value4);

    @Override
    protected abstract MutableFloatShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.put(0.0f, (short) 1);
        Assert.assertEquals((short) 1, map1.get(0.0f));
        map1.put(0.0f, (short) 0);
        Assert.assertEquals((short) 0, map1.get(0.0f));
        map1.put(5.0f, (short) 5);
        Assert.assertEquals((short) 5, map1.get(5.0f));
        map1.put(35.0f, (short) 35);
        Assert.assertEquals((short) 35, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(0.0f));
        map1.put(1.0f, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(1.0f));
        map1.put(5.0f, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow(5.0f));
        map1.put(35.0f, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals((short) 5, map1.getIfAbsent(0.0f, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent(1.0f, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent(33.0f, (short) 6));
        map1.put(0.0f, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(0.0f, (short) 5));
        map1.put(1.0f, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(1.0f, (short) 5));
        map1.put(5.0f, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent(5.0f, (short) 6));
        map1.put(35.0f, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent(35.0f, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((short) 0, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((short) 0, map1.get(0.0f));
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals((short) 0, map1.get(1.0f));
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals((short) 0, map1.get(31.0f));
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals((short) 0, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.put(35.0f, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.put(35.0f, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatShortMap hashMap1 = this.newWithKeysValues(1.0f, (short) 1, 0.0f, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatShortMap hashMap = this.newWithKeysValues(6.0f, (short) 6, 5.0f, (short) 5);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatShortHashMap hashMap = new FloatShortHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatShortHashMap(), map1);
        map1.put(1.0f, (short) 0);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatShortHashMap(), map1);
        map1.put(33.0f, (short) 0);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatShortHashMap(), map0);
        MutableFloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatShortHashMap(), map1);
        MutableFloatShortMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(31.0f, (short) 31, 32.0f, (short) 32), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 32), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatShortHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableFloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        map0.remove(1.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatShortHashMap(), map0);
        MutableFloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        map1.remove(0.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatShortHashMap(), map1);
        MutableFloatShortMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(31.0f, (short) 31, 32.0f, (short) 32), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 32), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatShortHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatShortMap map0 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent(1.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent(0.0f, (short) 100));
        Assert.assertEquals(new FloatShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(1.0f, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(0.0f, (short) 100));
        MutableFloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent(0.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent(1.0f, (short) 100));
        Assert.assertEquals(new FloatShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(0.0f, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(1.0f, (short) 100));
        MutableFloatShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(5.0f, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(50.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent(0.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(31.0f, (short) 31, 32.0f, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent(31.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent(32.0f, (short) 100));
        Assert.assertEquals(new FloatShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(0.0f, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(31.0f, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(32.0f, (short) 100));
        Assert.assertEquals(new FloatShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.put(0.0f, (short) 1);
        map1.put(31.0f, (short) 32);
        map1.put(32.0f, (short) 33);
        FloatShortHashMap expected = FloatShortHashMap.newWithKeysValues(0.0f, (short) 1, 31.0f, (short) 32, 32.0f, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, (short) 2);
        expected.put(1.0f, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, (short) 34);
        expected.put(33.0f, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, (short) 31);
        expected.put(30.0f, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut(0.0f, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut(0.0f, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut(10.0f, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut(10.0f, (short) 25, (short) 30));
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut(10.0f, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableFloatShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, (short) 1));
        map1.putPair(PrimitiveTuples.pair(31.0f, (short) 32));
        map1.putPair(PrimitiveTuples.pair(32.0f, (short) 33));
        FloatShortHashMap expected = FloatShortHashMap.newWithKeysValues(0.0f, (short) 1, 31.0f, (short) 32, 32.0f, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, (short) 2));
        expected.put(1.0f, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, (short) 34));
        expected.put(33.0f, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, (short) 31));
        expected.put(30.0f, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatShortMap map1 = this.newWithKeysValues(0.0f, (short) 11, 1.0f, (short) 12, 2.0f, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableFloatShortMap expected1 = this.newWithKeysValues(0.0f, (short) 11, 1.0f, (short) 12, 2.0f, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableFloatShortMap map2 = this.newWithKeysValues(0.0f, (short) 11, 1.0f, (short) 12, 2.0f, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableFloatShortMap expected2 = this.newWithKeysValues(0.0f, (short) 12, 1.0f, (short) 13, 2.0f, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableFloatShortMap map3 = this.newWithKeysValues(0.0f, (short) 11, 1.0f, (short) 12, 2.0f, (short) 13);
        map3.updateValues((k, v) -> k == 0.0f ? (short) 10 : v);
        MutableFloatShortMap expected3 = this.newWithKeysValues(0.0f, (short) 10, 1.0f, (short) 12, 2.0f, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, (short) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0f, (short) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (short) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (short) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (short) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (short) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (short) 33));
        FloatShortHashMap expected = FloatShortHashMap.newWithKeysValues(0.0f, (short) 11, 1.0f, (short) 12, 31.0f, (short) 37, 32.0f, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, (short) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (short) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (short) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (short) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0f, (short) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (short) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableFloatShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        FloatShortHashMap hashMap = new FloatShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((float) i));
            hashMap.put((float) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals((short) 0, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatShortMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatShortMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatShortMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatShortMapTestCase.generateCollisions().get(3);
        MutableFloatShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableFloatShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableFloatShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 50, 1.0f, (short) 50), map1);
        MutableFloatShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 50, 1.0f, (short) 50), map2);
        MutableFloatShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 50), map3);
        MutableFloatShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (short) 100));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 100, 1.0f, (short) 100), map1);
        MutableFloatShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 100, 1.0f, (short) 100), map2);
        MutableFloatShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 100), map3);
        MutableFloatShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 9, 1.0f, (short) 9), map1);
        MutableFloatShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 9, 1.0f, (short) 9), map2);
        MutableFloatShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 9), map3);
        MutableFloatShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToShortFunction function = (float floatParameter) -> (short) floatParameter;
        FloatToShortFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1), map1);
        MutableFloatShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1), map2);
        MutableFloatShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(32.0f, (short) 32), map3);
        MutableFloatShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableFloatShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 2, 1.0f, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 2, 1.0f, (short) 2), map1);
        MutableFloatShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 1, 1.0f, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 2, 1.0f, (short) 2), map2);
        MutableFloatShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, (short) 0, incrementFunction));
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(33.0f, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableFloatShortMap mutableFloatShortMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatShortMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatShortMap.put((float) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatShortMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatShortMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatShortMap mutableFloatShortMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatShortMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatShortMapForClear.keySet().toArray());
        mutableFloatShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 31.0f, (short) 31, 32.0f, (short) 32);
        MutableFloatShortMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 31.0f, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatShortMap map = this.newWithKeysValues(0.0f, (short) 0, 1.0f, (short) 1, 31.0f, (short) 31, 32.0f, (short) 32);
        MutableFloatShortMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 31.0f, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, (short) 1), hashMap);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatShortMap emptyMap = this.getEmptyMap();
        MutableFloatShortMap partialMap = this.newWithKeysValues(1.0f, (short) 1, 3.0f, (short) 3);
        MutableFloatShortMap completeMap = this.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        Iterable<FloatShortPair> emptyIterable = Iterables.iList();
        Iterable<FloatShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, (short) 1), PrimitiveTuples.pair(3.0f, (short) 3));
        Iterable<FloatShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, (short) 1), PrimitiveTuples.pair(2.0f, (short) 2), PrimitiveTuples.pair(3.0f, (short) 3), PrimitiveTuples.pair(4.0f, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedFloatShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableFloatShortMap mutableMap = this.classUnderTest();
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
        MutableFloatShortMap map = this.newWithKeysValues(1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f, (short) 5);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 2, 1.0f, (short) 3, 2.0f, (short) 4, 3.0f, (short) 5, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatShortMap map = this.newWithKeysValues(1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f, (short) 5);
        MutableFloatShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatShortMap map = this.newWithKeysValues(1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f, (short) 5);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatShortMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatShortMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatShortMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatShortMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatShortMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatShortMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatShortMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatShortMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatShortMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatShortMapTestCase::max;
            this.payloads.min = AbstractMutableFloatShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatShortMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractMutableFloatShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractMutableFloatShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatShortMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatShortMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatShortMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatShortMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatShortMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatShortMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatShortMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatShortMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatShortMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatShortMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatShortMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatShortMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatShortMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatShortMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatShortMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatShortMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatShortMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatShortMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatShortMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatShortMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatShortMapTestCase::asUnmodifiable;
            this.payloads.shortIterator_with_remove = AbstractMutableFloatShortMapTestCase::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatShortMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatShortMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatShortMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatShortMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatShortMapTestCase::serializeKeySet;
        }
    }
}
