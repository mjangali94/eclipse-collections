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
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatFloatMapTestCase extends AbstractFloatFloatMapTestCase {

    @Override
    protected abstract MutableFloatFloatMap classUnderTest();

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1);

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2);

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3);

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4);

    @Override
    protected abstract MutableFloatFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.get(0.0f), 0.0);
        map1.put(0.0f, 0.0f);
        Assert.assertEquals(0.0f, map1.get(0.0f), 0.0);
        map1.put(5.0f, 5.0f);
        Assert.assertEquals(5.0f, map1.get(5.0f), 0.0);
        map1.put(35.0f, 35.0f);
        Assert.assertEquals(35.0f, map1.get(35.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(0.0f), 0.0);
        map1.put(1.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(1.0f), 0.0);
        map1.put(5.0f, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow(5.0f), 0.0);
        map1.put(35.0f, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow(35.0f), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(0.0f, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(1.0f, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(33.0f, 6.0f), 0.0);
        map1.put(0.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(0.0f, 5.0f), 0.0);
        map1.put(1.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(1.0f, 5.0f), 0.0);
        map1.put(5.0f, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(5.0f, 6.0f), 0.0);
        map1.put(35.0f, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent(35.0f, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0f, map1.get(0.0f), 0.0);
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0f, map1.get(0.0f), 0.0);
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0.0f, map1.get(1.0f), 0.0);
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0.0f, map1.get(31.0f), 0.0);
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0.0f, map1.get(32.0f), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.put(35.0f, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.put(35.0f, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatFloatMap hashMap1 = this.newWithKeysValues(1.0f, 1.0f, 0.0f, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatFloatMap hashMap = this.newWithKeysValues(6.0f, 6.0f, 5.0f, 5.0f);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatFloatHashMap(), map1);
        map1.put(1.0f, 0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new FloatFloatHashMap(), map1);
        map1.put(33.0f, 0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new FloatFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatFloatMap map0 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map0);
        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map1);
        MutableFloatFloatMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableFloatFloatMap map0 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map0.remove(1.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map0);
        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map1.remove(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map1);
        MutableFloatFloatMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatFloatMap map0 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        MutableFloatFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(5.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(50.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(31.0f, 31.0f, 32.0f, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent(31.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent(32.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(31.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(32.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0f);
        map1.put(31.0f, 32.0f);
        map1.put(32.0f, 33.0f);
        FloatFloatHashMap expected = FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f, 31.0f, 32.0f, 32.0f, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, 2.0f);
        expected.put(1.0f, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, 34.0f);
        expected.put(33.0f, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, 31.0f);
        expected.put(30.0f, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0.0f, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0.0f, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10.0f, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0f, 25.0f, 30.0f), 0.0);
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0f, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1.0f));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32.0f));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33.0f));
        FloatFloatHashMap expected = FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f, 31.0f, 32.0f, 32.0f, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, 2.0f));
        expected.put(1.0f, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, 34.0f));
        expected.put(33.0f, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, 31.0f));
        expected.put(30.0f, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 11.0f, 1.0f, 12.0f, 2.0f, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableFloatFloatMap expected1 = this.newWithKeysValues(0.0f, 11.0f, 1.0f, 12.0f, 2.0f, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableFloatFloatMap map2 = this.newWithKeysValues(0.0f, 11.0f, 1.0f, 12.0f, 2.0f, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableFloatFloatMap expected2 = this.newWithKeysValues(0.0f, 12.0f, 1.0f, 13.0f, 2.0f, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableFloatFloatMap map3 = this.newWithKeysValues(0.0f, 11.0f, 1.0f, 12.0f, 2.0f, 13.0f);
        map3.updateValues((k, v) -> k == 0.0f ? 10.0f : v);
        MutableFloatFloatMap expected3 = this.newWithKeysValues(0.0f, 10.0f, 1.0f, 12.0f, 2.0f, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31.0f, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0f), 0.0);
        FloatFloatHashMap expected = FloatFloatHashMap.newWithKeysValues(0.0f, 11.0f, 1.0f, 12.0f, 31.0f, 37.0f, 32.0f, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5.0, map1.addToValue(31.0f, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableFloatFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((float) i), 0.0);
            hashMap.put((float) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((float) i), 0.0);
            hashMap.remove((float) i);
            Assert.assertEquals(0.0f, hashMap.get((float) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatFloatMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatFloatMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatFloatMapTestCase.generateCollisions().get(3);
        MutableFloatFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableFloatFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableFloatFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 50.0f, 1.0f, 50.0f), map1);
        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 50.0f, 1.0f, 50.0f), map2);
        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 50.0f), map3);
        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 100.0f, 1.0f, 100.0f), map1);
        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 100.0f, 1.0f, 100.0f), map2);
        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 100.0f), map3);
        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 9.0f, 1.0f, 9.0f), map1);
        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 9.0f, 1.0f, 9.0f), map2);
        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 9.0f), map3);
        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToFloatFunction function = (float floatParameter) -> (float) floatParameter;
        FloatToFloatFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f), map1);
        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f), map2);
        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map3);
        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f, 1.0f, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f, 1.0f, 2.0f), map1);
        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f, 1.0f, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f, 1.0f, 2.0f), map2);
        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue(33.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableFloatFloatMap mutableFloatFloatMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatFloatMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatFloatMap.put((float) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatFloatMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatFloatMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatFloatMap mutableFloatFloatMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatFloatMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatFloatMapForClear.keySet().toArray());
        mutableFloatFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatFloatMap map = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 31.0f, 31.0f, 32.0f, 32.0f);
        MutableFloatFloatMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 31.0f, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatFloatMap map = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 31.0f, 31.0f, 32.0f, 32.0f);
        MutableFloatFloatMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 31.0f, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1.0f), hashMap);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatFloatMap emptyMap = this.getEmptyMap();
        MutableFloatFloatMap partialMap = this.newWithKeysValues(1.0f, 1.0f, 3.0f, 3.0f);
        MutableFloatFloatMap completeMap = this.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        Iterable<FloatFloatPair> emptyIterable = Iterables.iList();
        Iterable<FloatFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(3.0f, 3.0f));
        Iterable<FloatFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1.0f), PrimitiveTuples.pair(2.0f, 2.0f), PrimitiveTuples.pair(3.0f, 3.0f), PrimitiveTuples.pair(4.0f, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedFloatFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableFloatFloatMap mutableMap = this.classUnderTest();
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
        MutableFloatFloatMap map = this.newWithKeysValues(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f, 5.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(2.0f, 1.0f, 3.0f, 2.0f, 4.0f, 3.0f, 5.0f, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1.0f, 2.0f, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatFloatMap map = this.newWithKeysValues(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f, 5.0f);
        MutableFloatFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatFloatMap map = this.newWithKeysValues(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f, 5.0f);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatFloatMapTestCase instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatFloatMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatFloatMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatFloatMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatFloatMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatFloatMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatFloatMapTestCase::max;
            this.payloads.min = AbstractMutableFloatFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatFloatMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractMutableFloatFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractMutableFloatFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatFloatMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatFloatMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatFloatMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatFloatMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatFloatMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatFloatMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatFloatMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatFloatMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatFloatMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatFloatMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatFloatMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatFloatMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatFloatMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatFloatMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatFloatMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatFloatMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatFloatMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatFloatMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatFloatMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatFloatMapTestCase::asUnmodifiable;
            this.payloads.floatIterator_with_remove = AbstractMutableFloatFloatMapTestCase::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatFloatMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatFloatMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatFloatMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatFloatMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatFloatMapTestCase::serializeKeySet;
        }
    }
}
