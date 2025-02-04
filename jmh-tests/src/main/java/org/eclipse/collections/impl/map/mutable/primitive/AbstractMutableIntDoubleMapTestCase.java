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
import org.eclipse.collections.api.block.function.primitive.IntToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntDoubleMapTestCase extends AbstractIntDoubleMapTestCase {

    @Override
    protected abstract MutableIntDoubleMap classUnderTest();

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1);

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2);

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3);

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3, int key4, double value4);

    @Override
    protected abstract MutableIntDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.put(0, 1.0);
        Assert.assertEquals(1.0, map1.get(0), 0.0);
        map1.put(0, 0.0);
        Assert.assertEquals(0.0, map1.get(0), 0.0);
        map1.put(5, 5.0);
        Assert.assertEquals(5.0, map1.get(5), 0.0);
        map1.put(35, 35.0);
        Assert.assertEquals(35.0, map1.get(35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0), 0.0);
        map1.put(1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1), 0.0);
        map1.put(5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5), 0.0);
        map1.put(35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals(5.0, map1.getIfAbsent(0, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33, 6.0), 0.0);
        map1.put(0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0, 5.0), 0.0);
        map1.put(1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1, 5.0), 0.0);
        map1.put(5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5, 6.0), 0.0);
        map1.put(35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0.0, map1.get(0), 0.0);
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0.0, map1.get(0), 0.0);
        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals(0.0, map1.get(1), 0.0);
        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals(0.0, map1.get(31), 0.0);
        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals(0.0, map1.get(32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.put(35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.put(35, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey(0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableIntDoubleMap hashMap1 = this.newWithKeysValues(1, 1.0, 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntDoubleMap hashMap = this.newWithKeysValues(6, 6.0, 5, 5.0);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        for (int each = 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntDoubleHashMap(), map1);
        map1.put(1, 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new IntDoubleHashMap(), map1);
        map1.put(33, 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new IntDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableIntDoubleMap map0 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map0.removeKey(1);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntDoubleHashMap(), map0);
        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map1.removeKey(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntDoubleHashMap(), map1);
        MutableIntDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(31, 31.0, 32, 32.0), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableIntDoubleMap map0 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map0.remove(1);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map0);
        map0.remove(0);
        Assert.assertEquals(new IntDoubleHashMap(), map0);
        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map1.remove(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map1);
        map1.remove(1);
        Assert.assertEquals(new IntDoubleHashMap(), map1);
        MutableIntDoubleMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0), map2);
        map2.remove(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(31, 31.0, 32, 32.0), map2);
        map2.remove(31);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map2);
        map2.remove(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableIntDoubleMap map0 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0, 100.0), 0.0);
        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1, 100.0), 0.0);
        MutableIntDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(31, 31.0, 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.put(0, 1.0);
        map1.put(31, 32.0);
        map1.put(32, 33.0);
        IntDoubleHashMap expected = IntDoubleHashMap.newWithKeysValues(0, 1.0, 31, 32.0, 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put(1, 2.0);
        expected.put(1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put(33, 34.0);
        expected.put(33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put(30, 31.0);
        expected.put(30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableIntDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10, 25.0, 30.0), 0.0);
        map1.removeKey(10);
        Assert.assertEquals(101, map1.getAndPut(10, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, 1.0));
        map1.putPair(PrimitiveTuples.pair(31, 32.0));
        map1.putPair(PrimitiveTuples.pair(32, 33.0));
        IntDoubleHashMap expected = IntDoubleHashMap.newWithKeysValues(0, 1.0, 31, 32.0, 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1, 2.0));
        expected.put(1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33, 34.0));
        expected.put(33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30, 31.0));
        expected.put(30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 11.0, 1, 12.0, 2, 13.0);
        map1.updateValues((k, v) -> v);
        MutableIntDoubleMap expected1 = this.newWithKeysValues(0, 11.0, 1, 12.0, 2, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableIntDoubleMap map2 = this.newWithKeysValues(0, 11.0, 1, 12.0, 2, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableIntDoubleMap expected2 = this.newWithKeysValues(0, 12.0, 1, 13.0, 2, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableIntDoubleMap map3 = this.newWithKeysValues(0, 11.0, 1, 12.0, 2, 13.0);
        map3.updateValues((k, v) -> k == 0 ? 10.0 : v);
        MutableIntDoubleMap expected3 = this.newWithKeysValues(0, 10.0, 1, 12.0, 2, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32, 33.0), 0.0);
        IntDoubleHashMap expected = IntDoubleHashMap.newWithKeysValues(0, 11.0, 1, 12.0, 31, 37.0, 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5.0, map1.addToValue(31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableIntDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            int k = (int) each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get(i), 0.0);
            hashMap.put(i, (double) i);
            Assert.assertEquals((double) i, hashMap.get(i), 0.0);
            hashMap.remove(i);
            Assert.assertEquals(0.0, hashMap.get(i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntDoubleMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntDoubleMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntDoubleMapTestCase.generateCollisions().get(3);
        MutableIntDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableIntDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableIntDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map1);
        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map2);
        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 50.0), map3);
        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map1);
        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map2);
        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 100.0), map3);
        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map1);
        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map2);
        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 9.0), map3);
        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToDoubleFunction function = (int intParameter) -> (double) intParameter;
        IntToDoubleFunction functionThrows = (int intParameter) -> {
            throw new AssertionError();
        };
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map1);
        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map2);
        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map3);
        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0, 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map1);
        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 1.0, 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map2);
        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableIntDoubleMap mutableIntDoubleMap = this.classUnderTest();
        IntSet frozenSet = mutableIntDoubleMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntDoubleMap.put((int) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntDoubleMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntDoubleMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntDoubleMap mutableIntDoubleMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntDoubleMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntDoubleMapForClear.keySet().toArray());
        mutableIntDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 31, 31.0, 32, 32.0);
        MutableIntDoubleMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0, 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableIntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 31, 31.0, 32, 32.0);
        MutableIntDoubleMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableIntDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, 1.0), hashMap);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableIntDoubleMap emptyMap = this.getEmptyMap();
        MutableIntDoubleMap partialMap = this.newWithKeysValues(1, 1.0, 3, 3.0);
        MutableIntDoubleMap completeMap = this.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0, 4, 4.0);
        Iterable<IntDoublePair> emptyIterable = Iterables.iList();
        Iterable<IntDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, 1.0), PrimitiveTuples.pair(3, 3.0));
        Iterable<IntDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, 1.0), PrimitiveTuples.pair(2, 2.0), PrimitiveTuples.pair(3, 3.0), PrimitiveTuples.pair(4, 4.0));
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
        Verify.assertInstanceOf(SynchronizedIntDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableIntDoubleMap mutableMap = this.classUnderTest();
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
        MutableIntDoubleMap map = this.newWithKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(2.0, 1, 3.0, 2, 4.0, 3, 5.0, 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, 1.0, 2, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableIntDoubleMap map = this.newWithKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0);
        MutableIntDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableIntDoubleMap map = this.newWithKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0);
        IntSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntDoubleMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableIntDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableIntDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableIntDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableIntDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableIntDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableIntDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableIntDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableIntDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableIntDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableIntDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableIntDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableIntDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableIntDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableIntDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableIntDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableIntDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableIntDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableIntDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableIntDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableIntDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableIntDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableIntDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableIntDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableIntDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableIntDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableIntDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableIntDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableIntDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableIntDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableIntDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableIntDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableIntDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableIntDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableIntDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableIntDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableIntDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableIntDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableIntDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableIntDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableIntDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableIntDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableIntDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableIntDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableIntDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableIntDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableIntDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableIntDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableIntDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableIntDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableIntDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableIntDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableIntDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableIntDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableIntDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableIntDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableIntDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableIntDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableIntDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableIntDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableIntDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableIntDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableIntDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableIntDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableIntDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableIntDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableIntDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableIntDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableIntDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableIntDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableIntDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableIntDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableIntDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableIntDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableIntDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableIntDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableIntDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableIntDoubleMapTestCase::serializeKeySet;
        }
    }
*/
}
