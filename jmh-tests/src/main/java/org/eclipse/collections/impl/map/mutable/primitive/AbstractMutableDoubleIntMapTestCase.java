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
import org.eclipse.collections.api.block.function.primitive.DoubleToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleIntMapTestCase extends AbstractDoubleIntMapTestCase {

    @Override
    protected abstract MutableDoubleIntMap classUnderTest();

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1);

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2);

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3);

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3, double key4, int value4);

    @Override
    protected abstract MutableDoubleIntMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.put(0.0, 1);
        Assert.assertEquals(1, map1.get(0.0));
        map1.put(0.0, 0);
        Assert.assertEquals(0, map1.get(0.0));
        map1.put(5.0, 5);
        Assert.assertEquals(5, map1.get(5.0));
        map1.put(35.0, 35);
        Assert.assertEquals(35, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, 1);
        Assert.assertEquals(1, map1.getOrThrow(0.0));
        map1.put(1.0, 1);
        Assert.assertEquals(1, map1.getOrThrow(1.0));
        map1.put(5.0, 5);
        Assert.assertEquals(5, map1.getOrThrow(5.0));
        map1.put(35.0, 35);
        Assert.assertEquals(35, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals(5, map1.getIfAbsent(0.0, 5));
        Assert.assertEquals(6, map1.getIfAbsent(1.0, 6));
        Assert.assertEquals(6, map1.getIfAbsent(33.0, 6));
        map1.put(0.0, 1);
        Assert.assertEquals(1, map1.getIfAbsent(0.0, 5));
        map1.put(1.0, 1);
        Assert.assertEquals(1, map1.getIfAbsent(1.0, 5));
        map1.put(5.0, 5);
        Assert.assertEquals(5, map1.getIfAbsent(5.0, 6));
        map1.put(35.0, 35);
        Assert.assertEquals(35, map1.getIfAbsent(35.0, 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0, map1.get(0.0));
        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals(0, map1.get(1.0));
        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals(0, map1.get(31.0));
        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals(0, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.put(35.0, 35);
        Assert.assertTrue(map1.containsValue(35));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.put(35.0, 35);
        Assert.assertTrue(map1.contains(35));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleIntMap hashMap1 = this.newWithKeysValues(1.0, 1, 0.0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleIntMap hashMap = this.newWithKeysValues(6.0, 6, 5.0, 5);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleIntHashMap(), map1);
        map1.put(1.0, 0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleIntHashMap(), map1);
        map1.put(33.0, 0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleIntHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableDoubleIntMap map0 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleIntHashMap(), map0);
        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleIntHashMap(), map1);
        MutableDoubleIntMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(31.0, 31, 32.0, 32), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableDoubleIntMap map0 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map0.remove(1.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleIntHashMap(), map0);
        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map1.remove(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleIntHashMap(), map1);
        MutableDoubleIntMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(31.0, 31, 32.0, 32), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableDoubleIntMap map0 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent(1.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent(1.0, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent(0.0, 100));
        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent(1.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent(1.0, 100));
        MutableDoubleIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent(5.0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(50.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(31.0, 31, 32.0, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent(31.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent(32.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(31.0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(32.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.put(0.0, 1);
        map1.put(31.0, 32);
        map1.put(32.0, 33);
        DoubleIntHashMap expected = DoubleIntHashMap.newWithKeysValues(0.0, 1, 31.0, 32, 32.0, 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0, 2);
        expected.put(1.0, 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0, 34);
        expected.put(33.0, 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0, 31);
        expected.put(30.0, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableDoubleIntMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0, 25, 50));
        Assert.assertEquals(25, map1.getAndPut(0.0, 35, 50));
        Assert.assertEquals(35, map1.getAndPut(0.0, 45, 55));
        Assert.assertEquals(100, map1.getAndPut(10.0, 25, 100));
        Assert.assertEquals(25, map1.getAndPut(10.0, 25, 30));
        map1.removeKey(10.0);
        Assert.assertEquals(101, map1.getAndPut(10.0, 25, 101));
        Assert.assertEquals(25, map1.getAndPut(10.0, 27, 105));
    }

    @Test
    public void putPair() {
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, 1));
        map1.putPair(PrimitiveTuples.pair(31.0, 32));
        map1.putPair(PrimitiveTuples.pair(32.0, 33));
        DoubleIntHashMap expected = DoubleIntHashMap.newWithKeysValues(0.0, 1, 31.0, 32, 32.0, 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0, 2));
        expected.put(1.0, 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0, 34));
        expected.put(33.0, 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0, 31));
        expected.put(30.0, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 11, 1.0, 12, 2.0, 13);
        map1.updateValues((k, v) -> v);
        MutableDoubleIntMap expected1 = this.newWithKeysValues(0.0, 11, 1.0, 12, 2.0, 13);
        Assert.assertEquals(expected1, map1);
        MutableDoubleIntMap map2 = this.newWithKeysValues(0.0, 11, 1.0, 12, 2.0, 13);
        map2.updateValues((k, v) -> v + 1);
        MutableDoubleIntMap expected2 = this.newWithKeysValues(0.0, 12, 1.0, 13, 2.0, 14);
        Assert.assertEquals(expected2, map2);
        MutableDoubleIntMap map3 = this.newWithKeysValues(0.0, 11, 1.0, 12, 2.0, 13);
        map3.updateValues((k, v) -> k == 0.0 ? 10 : v);
        MutableDoubleIntMap expected3 = this.newWithKeysValues(0.0, 10, 1.0, 12, 2.0, 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, 1));
        Assert.assertEquals(32L, map1.addToValue(31.0, 32));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9));
        Assert.assertEquals(37L, map1.addToValue(31.0, 5));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33));
        DoubleIntHashMap expected = DoubleIntHashMap.newWithKeysValues(0.0, 11, 1.0, 12, 31.0, 37, 32.0, 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, 5));
        Assert.assertEquals(37L, map1.addToValue(31.0, 32));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3));
        Assert.assertEquals(1L, map1.addToValue(0.0, 1));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10));
        Assert.assertEquals(expected, map1);
        MutableDoubleIntMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            double k = each;
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((double) i));
            hashMap.put((double) i, i);
            Assert.assertEquals(i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals(0, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleIntMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleIntMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleIntMapTestCase.generateCollisions().get(3);
        MutableDoubleIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableDoubleIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableDoubleIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 50, 1.0, 50), map1);
        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 50, 1.0, 50), map2);
        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 50), map3);
        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 100, 1.0, 100), map1);
        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 100, 1.0, 100), map2);
        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 100), map3);
        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 9, 1.0, 9), map1);
        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 9, 1.0, 9), map2);
        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 9), map3);
        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToIntFunction function = (double doubleParameter) -> (int) doubleParameter;
        DoubleToIntFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 1.0, 1), map1);
        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 1.0, 1), map2);
        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map3);
        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 33), map4);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2, 1.0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map1);
        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 1, 1.0, 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map2);
        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 2), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleIntMap mutableDoubleIntMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleIntMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleIntMap.put((double) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleIntMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleIntMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleIntMap mutableDoubleIntMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleIntMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleIntMapForClear.keySet().toArray());
        mutableDoubleIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 31.0, 31, 32.0, 32);
        MutableDoubleIntMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 1.0, 1, 31.0, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 31.0, 31, 32.0, 32);
        MutableDoubleIntMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 31.0, 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, 1), hashMap);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleIntMap emptyMap = this.getEmptyMap();
        MutableDoubleIntMap partialMap = this.newWithKeysValues(1.0, 1, 3.0, 3);
        MutableDoubleIntMap completeMap = this.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 4.0, 4);
        Iterable<DoubleIntPair> emptyIterable = Iterables.iList();
        Iterable<DoubleIntPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1), PrimitiveTuples.pair(3.0, 3));
        Iterable<DoubleIntPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1), PrimitiveTuples.pair(2.0, 2), PrimitiveTuples.pair(3.0, 3), PrimitiveTuples.pair(4.0, 4));
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
        Verify.assertInstanceOf(SynchronizedDoubleIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove() {
        MutableDoubleIntMap mutableMap = this.classUnderTest();
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
        MutableDoubleIntMap map = this.newWithKeysValues(1.0, 2, 2.0, 3, 3.0, 4, 4.0, 5);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(2, 1.0, 3, 2.0, 4, 3.0, 5, 4.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1, 2.0, 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableDoubleIntMap map = this.newWithKeysValues(1.0, 2, 2.0, 3, 3.0, 4, 4.0, 5);
        MutableDoubleIntMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableDoubleIntMap map = this.newWithKeysValues(1.0, 2, 2.0, 3, 3.0, 4, 4.0, 5);
        DoubleSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleIntMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleIntMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleIntMapTestCase::values;
            this.payloads.containsAll = AbstractMutableDoubleIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableDoubleIntMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableDoubleIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleIntMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableDoubleIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleIntMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleIntMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleIntMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleIntMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableDoubleIntMapTestCase::max;
            this.payloads.min = AbstractMutableDoubleIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleIntMapTestCase::sum;
            this.payloads.average = AbstractMutableDoubleIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableDoubleIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableDoubleIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractMutableDoubleIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractMutableDoubleIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableDoubleIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableDoubleIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableDoubleIntMapTestCase::chunk;
            this.payloads.get = AbstractMutableDoubleIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableDoubleIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableDoubleIntMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleIntMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleIntMapTestCase::contains;
            this.payloads.size = AbstractMutableDoubleIntMapTestCase::size;
            this.payloads.clear = AbstractMutableDoubleIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleIntMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleIntMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleIntMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableDoubleIntMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableDoubleIntMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableDoubleIntMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableDoubleIntMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableDoubleIntMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleIntMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleIntMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableDoubleIntMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleIntMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleIntMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleIntMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleIntMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleIntMapTestCase::asUnmodifiable;
            this.payloads.intIterator_with_remove = AbstractMutableDoubleIntMapTestCase::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleIntMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleIntMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableDoubleIntMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableDoubleIntMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableDoubleIntMapTestCase::serializeKeySet;
        }
    }
*/
}
