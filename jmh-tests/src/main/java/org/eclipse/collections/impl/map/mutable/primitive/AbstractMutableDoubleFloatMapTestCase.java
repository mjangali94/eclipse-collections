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
import org.eclipse.collections.api.block.function.primitive.DoubleToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleFloatMapTestCase extends AbstractDoubleFloatMapTestCase {

    @Override
    protected abstract MutableDoubleFloatMap classUnderTest();

    @Override
    protected abstract MutableDoubleFloatMap newWithKeysValues(double key1, float value1);

    @Override
    protected abstract MutableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2);

    @Override
    protected abstract MutableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3);

    @Override
    protected abstract MutableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3, double key4, float value4);

    @Override
    protected abstract MutableDoubleFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.put(0.0, 1.0f);
        Assert.assertEquals(1.0f, map1.get(0.0), 0.0);
        map1.put(0.0, 0.0f);
        Assert.assertEquals(0.0f, map1.get(0.0), 0.0);
        map1.put(5.0, 5.0f);
        Assert.assertEquals(5.0f, map1.get(5.0), 0.0);
        map1.put(35.0, 35.0f);
        Assert.assertEquals(35.0f, map1.get(35.0), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(0.0), 0.0);
        map1.put(1.0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(1.0), 0.0);
        map1.put(5.0, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow(5.0), 0.0);
        map1.put(35.0, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow(35.0), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals(5.0f, map1.getIfAbsent(0.0, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(1.0, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(33.0, 6.0f), 0.0);
        map1.put(0.0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(0.0, 5.0f), 0.0);
        map1.put(1.0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(1.0, 5.0f), 0.0);
        map1.put(5.0, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(5.0, 6.0f), 0.0);
        map1.put(35.0, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent(35.0, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0.0f, map1.get(0.0), 0.0);
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0.0f, map1.get(0.0), 0.0);
        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals(0.0f, map1.get(1.0), 0.0);
        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals(0.0f, map1.get(31.0), 0.0);
        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals(0.0f, map1.get(32.0), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.put(35.0, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.put(35.0, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleFloatMap hashMap1 = this.newWithKeysValues(1.0, 1.0f, 0.0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleFloatMap hashMap = this.newWithKeysValues(6.0, 6.0f, 5.0, 5.0f);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleFloatHashMap(), map1);
        map1.put(1.0, 0.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new DoubleFloatHashMap(), map1);
        map1.put(33.0, 0.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new DoubleFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableDoubleFloatMap map0 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map0);
        MutableDoubleFloatMap map1 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map1);
        MutableDoubleFloatMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(31.0, 31.0f, 32.0, 32.0f), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 32.0f), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableDoubleFloatMap map0 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
        map0.remove(1.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map0);
        MutableDoubleFloatMap map1 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
        map1.remove(0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map1);
        MutableDoubleFloatMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(31.0, 31.0f, 32.0, 32.0f), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 32.0f), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableDoubleFloatMap map0 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent(1.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent(0.0, 100.0f), 0.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(1.0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(0.0, 100.0f), 0.0);
        MutableDoubleFloatMap map1 = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent(0.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent(1.0, 100.0f), 0.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(0.0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(1.0, 100.0f), 0.0);
        MutableDoubleFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(5.0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(50.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent(0.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(31.0, 31.0f, 32.0, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent(31.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent(32.0, 100.0f), 0.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(0.0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(31.0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(32.0, 100.0f), 0.0);
        Assert.assertEquals(new DoubleFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.put(0.0, 1.0f);
        map1.put(31.0, 32.0f);
        map1.put(32.0, 33.0f);
        DoubleFloatHashMap expected = DoubleFloatHashMap.newWithKeysValues(0.0, 1.0f, 31.0, 32.0f, 32.0, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put(1.0, 2.0f);
        expected.put(1.0, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put(33.0, 34.0f);
        expected.put(33.0, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put(30.0, 31.0f);
        expected.put(30.0, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableDoubleFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0.0, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0.0, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10.0, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0, 25.0f, 30.0f), 0.0);
        map1.removeKey(10.0);
        Assert.assertEquals(101, map1.getAndPut(10.0, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableDoubleFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, 1.0f));
        map1.putPair(PrimitiveTuples.pair(31.0, 32.0f));
        map1.putPair(PrimitiveTuples.pair(32.0, 33.0f));
        DoubleFloatHashMap expected = DoubleFloatHashMap.newWithKeysValues(0.0, 1.0f, 31.0, 32.0f, 32.0, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0, 2.0f));
        expected.put(1.0, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0, 34.0f));
        expected.put(33.0, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0, 31.0f));
        expected.put(30.0, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableDoubleFloatMap map1 = this.newWithKeysValues(0.0, 11.0f, 1.0, 12.0f, 2.0, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableDoubleFloatMap expected1 = this.newWithKeysValues(0.0, 11.0f, 1.0, 12.0f, 2.0, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableDoubleFloatMap map2 = this.newWithKeysValues(0.0, 11.0f, 1.0, 12.0f, 2.0, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableDoubleFloatMap expected2 = this.newWithKeysValues(0.0, 12.0f, 1.0, 13.0f, 2.0, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableDoubleFloatMap map3 = this.newWithKeysValues(0.0, 11.0f, 1.0, 12.0f, 2.0, 13.0f);
        map3.updateValues((k, v) -> k == 0.0 ? 10.0f : v);
        MutableDoubleFloatMap expected3 = this.newWithKeysValues(0.0, 10.0f, 1.0, 12.0f, 2.0, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableDoubleFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0.0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31.0, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0, 33.0f), 0.0);
        DoubleFloatHashMap expected = DoubleFloatHashMap.newWithKeysValues(0.0, 11.0f, 1.0, 12.0f, 31.0, 37.0f, 32.0, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5.0, map1.addToValue(31.0, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0.0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableDoubleFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            double k = each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((double) i), 0.0);
            hashMap.put((double) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((double) i), 0.0);
            hashMap.remove((double) i);
            Assert.assertEquals(0.0f, hashMap.get((double) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleFloatMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleFloatMapTestCase.generateCollisions().get(3);
        MutableDoubleFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableDoubleFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableDoubleFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 50.0f, 1.0, 50.0f), map1);
        MutableDoubleFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 50.0f, 1.0, 50.0f), map2);
        MutableDoubleFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 50.0f), map3);
        MutableDoubleFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0, 100.0f), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 100.0f, 1.0, 100.0f), map1);
        MutableDoubleFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 100.0f, 1.0, 100.0f), map2);
        MutableDoubleFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 100.0f), map3);
        MutableDoubleFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 9.0f, 1.0, 9.0f), map1);
        MutableDoubleFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 9.0f, 1.0, 9.0f), map2);
        MutableDoubleFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 9.0f), map3);
        MutableDoubleFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToFloatFunction function = (double doubleParameter) -> (float) doubleParameter;
        DoubleToFloatFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f), map1);
        MutableDoubleFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f), map2);
        MutableDoubleFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(32.0, 32.0f), map3);
        MutableDoubleFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableDoubleFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(0.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue(1.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 2.0f, 1.0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(1.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 2.0f, 1.0, 2.0f), map1);
        MutableDoubleFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(1.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue(0.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 1.0f, 1.0, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(0.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 2.0f, 1.0, 2.0f), map2);
        MutableDoubleFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue(33.0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(33.0, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleFloatMap mutableDoubleFloatMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleFloatMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleFloatMap.put((double) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleFloatMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleFloatMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleFloatMap mutableDoubleFloatMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleFloatMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleFloatMapForClear.keySet().toArray());
        mutableDoubleFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleFloatMap map = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f, 31.0, 31.0f, 32.0, 32.0f);
        MutableDoubleFloatMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f, 31.0, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleFloatMap map = this.newWithKeysValues(0.0, 0.0f, 1.0, 1.0f, 31.0, 31.0f, 32.0, 32.0f);
        MutableDoubleFloatMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 31.0, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, 1.0f), hashMap);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleFloatMap emptyMap = this.getEmptyMap();
        MutableDoubleFloatMap partialMap = this.newWithKeysValues(1.0, 1.0f, 3.0, 3.0f);
        MutableDoubleFloatMap completeMap = this.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Iterable<DoubleFloatPair> emptyIterable = Iterables.iList();
        Iterable<DoubleFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1.0f), PrimitiveTuples.pair(3.0, 3.0f));
        Iterable<DoubleFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1.0f), PrimitiveTuples.pair(2.0, 2.0f), PrimitiveTuples.pair(3.0, 3.0f), PrimitiveTuples.pair(4.0, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedDoubleFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableDoubleFloatMap mutableMap = this.classUnderTest();
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
        MutableDoubleFloatMap map = this.newWithKeysValues(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0, 5.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(2.0f, 1.0, 3.0f, 2.0, 4.0f, 3.0, 5.0f, 4.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1.0f, 2.0, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableDoubleFloatMap map = this.newWithKeysValues(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0, 5.0f);
        MutableDoubleFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableDoubleFloatMap map = this.newWithKeysValues(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0, 5.0f);
        DoubleSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleFloatMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleFloatMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleFloatMapTestCase::values;
            this.payloads.containsAll = AbstractMutableDoubleFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableDoubleFloatMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableDoubleFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableDoubleFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleFloatMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleFloatMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableDoubleFloatMapTestCase::max;
            this.payloads.min = AbstractMutableDoubleFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleFloatMapTestCase::sum;
            this.payloads.average = AbstractMutableDoubleFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableDoubleFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableDoubleFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractMutableDoubleFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractMutableDoubleFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableDoubleFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableDoubleFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableDoubleFloatMapTestCase::chunk;
            this.payloads.get = AbstractMutableDoubleFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableDoubleFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableDoubleFloatMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleFloatMapTestCase::contains;
            this.payloads.size = AbstractMutableDoubleFloatMapTestCase::size;
            this.payloads.clear = AbstractMutableDoubleFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleFloatMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleFloatMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleFloatMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableDoubleFloatMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableDoubleFloatMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableDoubleFloatMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableDoubleFloatMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableDoubleFloatMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleFloatMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleFloatMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableDoubleFloatMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleFloatMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleFloatMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleFloatMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleFloatMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleFloatMapTestCase::asUnmodifiable;
            this.payloads.floatIterator_with_remove = AbstractMutableDoubleFloatMapTestCase::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleFloatMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleFloatMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableDoubleFloatMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableDoubleFloatMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableDoubleFloatMapTestCase::serializeKeySet;
        }
    }
}
