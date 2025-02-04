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
import org.eclipse.collections.api.block.function.primitive.FloatToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatDoubleMapTestCase extends AbstractFloatDoubleMapTestCase {

    @Override
    protected abstract MutableFloatDoubleMap classUnderTest();

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1);

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2);

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3);

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4);

    @Override
    protected abstract MutableFloatDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0);
        Assert.assertEquals(1.0, map1.get(0.0f), 0.0);
        map1.put(0.0f, 0.0);
        Assert.assertEquals(0.0, map1.get(0.0f), 0.0);
        map1.put(5.0f, 5.0);
        Assert.assertEquals(5.0, map1.get(5.0f), 0.0);
        map1.put(35.0f, 35.0);
        Assert.assertEquals(35.0, map1.get(35.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0.0f), 0.0);
        map1.put(1.0f, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1.0f), 0.0);
        map1.put(5.0f, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5.0f), 0.0);
        map1.put(35.0f, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35.0f), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5.0, map1.getIfAbsent(0.0f, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(1.0f, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33.0f, 6.0), 0.0);
        map1.put(0.0f, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0.0f, 5.0), 0.0);
        map1.put(1.0f, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1.0f, 5.0), 0.0);
        map1.put(5.0f, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5.0f, 6.0), 0.0);
        map1.put(35.0f, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35.0f, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0, map1.get(0.0f), 0.0);
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0, map1.get(0.0f), 0.0);
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0.0, map1.get(1.0f), 0.0);
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0.0, map1.get(31.0f), 0.0);
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0.0, map1.get(32.0f), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.put(35.0f, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.put(35.0f, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatDoubleMap hashMap1 = this.newWithKeysValues(1.0f, 1.0, 0.0f, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatDoubleMap hashMap = this.newWithKeysValues(6.0f, 6.0, 5.0f, 5.0);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
        map1.put(1.0f, 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
        map1.put(33.0f, 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatDoubleMap map0 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map0);
        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
        MutableFloatDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(31.0f, 31.0, 32.0f, 32.0), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableFloatDoubleMap map0 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map0.remove(1.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map0);
        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map1.remove(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
        MutableFloatDoubleMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(31.0f, 31.0, 32.0f, 32.0), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatDoubleMap map0 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        MutableFloatDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(31.0f, 31.0, 32.0f, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0);
        map1.put(31.0f, 32.0);
        map1.put(32.0f, 33.0);
        FloatDoubleHashMap expected = FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0, 31.0f, 32.0, 32.0f, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, 2.0);
        expected.put(1.0f, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, 34.0);
        expected.put(33.0f, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, 31.0);
        expected.put(30.0f, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0.0f, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0.0f, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10.0f, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0f, 25.0, 30.0), 0.0);
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0f, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1.0));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32.0));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33.0));
        FloatDoubleHashMap expected = FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0, 31.0f, 32.0, 32.0f, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, 2.0));
        expected.put(1.0f, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, 34.0));
        expected.put(33.0f, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, 31.0));
        expected.put(30.0f, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 11.0, 1.0f, 12.0, 2.0f, 13.0);
        map1.updateValues((k, v) -> v);
        MutableFloatDoubleMap expected1 = this.newWithKeysValues(0.0f, 11.0, 1.0f, 12.0, 2.0f, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableFloatDoubleMap map2 = this.newWithKeysValues(0.0f, 11.0, 1.0f, 12.0, 2.0f, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableFloatDoubleMap expected2 = this.newWithKeysValues(0.0f, 12.0, 1.0f, 13.0, 2.0f, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableFloatDoubleMap map3 = this.newWithKeysValues(0.0f, 11.0, 1.0f, 12.0, 2.0f, 13.0);
        map3.updateValues((k, v) -> k == 0.0f ? 10.0 : v);
        MutableFloatDoubleMap expected3 = this.newWithKeysValues(0.0f, 10.0, 1.0f, 12.0, 2.0f, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31.0f, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0), 0.0);
        FloatDoubleHashMap expected = FloatDoubleHashMap.newWithKeysValues(0.0f, 11.0, 1.0f, 12.0, 31.0f, 37.0, 32.0f, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5.0, map1.addToValue(31.0f, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableFloatDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((float) i), 0.0);
            hashMap.put((float) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((float) i), 0.0);
            hashMap.remove((float) i);
            Assert.assertEquals(0.0, hashMap.get((float) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(3);
        MutableFloatDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableFloatDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableFloatDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 50.0, 1.0f, 50.0), map1);
        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 50.0, 1.0f, 50.0), map2);
        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 50.0), map3);
        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 100.0, 1.0f, 100.0), map1);
        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 100.0, 1.0f, 100.0), map2);
        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 100.0), map3);
        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 9.0, 1.0f, 9.0), map1);
        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 9.0, 1.0f, 9.0), map2);
        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 9.0), map3);
        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToDoubleFunction function = (float floatParameter) -> (double) floatParameter;
        FloatToDoubleFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0), map1);
        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0), map2);
        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map3);
        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0, 1.0f, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0, 1.0f, 2.0), map1);
        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0, 1.0f, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0, 1.0f, 2.0), map2);
        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableFloatDoubleMap mutableFloatDoubleMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatDoubleMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatDoubleMap.put((float) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatDoubleMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatDoubleMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatDoubleMap mutableFloatDoubleMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatDoubleMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatDoubleMapForClear.keySet().toArray());
        mutableFloatDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 31.0f, 31.0, 32.0f, 32.0);
        MutableFloatDoubleMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 31.0f, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 31.0f, 31.0, 32.0f, 32.0);
        MutableFloatDoubleMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 31.0f, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1.0), hashMap);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatDoubleMap emptyMap = this.getEmptyMap();
        MutableFloatDoubleMap partialMap = this.newWithKeysValues(1.0f, 1.0, 3.0f, 3.0);
        MutableFloatDoubleMap completeMap = this.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        Iterable<FloatDoublePair> emptyIterable = Iterables.iList();
        Iterable<FloatDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1.0), PrimitiveTuples.pair(3.0f, 3.0));
        Iterable<FloatDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1.0), PrimitiveTuples.pair(2.0f, 2.0), PrimitiveTuples.pair(3.0f, 3.0), PrimitiveTuples.pair(4.0f, 4.0));
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
        Verify.assertInstanceOf(SynchronizedFloatDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableFloatDoubleMap mutableMap = this.classUnderTest();
        MutableDoubleIterator iterator = mutableMap.doubleIterator();
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
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableFloatDoubleMap map = this.newWithKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(2.0, 1.0f, 3.0, 2.0f, 4.0, 3.0f, 5.0, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1.0, 2.0f, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatDoubleMap map = this.newWithKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0);
        MutableFloatDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatDoubleMap map = this.newWithKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatDoubleMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableFloatDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableFloatDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableFloatDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableFloatDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatDoubleMapTestCase::serializeKeySet;
        }
    }
}
