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
import org.eclipse.collections.api.block.function.primitive.DoubleToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleShortMapTestCase extends AbstractDoubleShortMapTestCase {

    @Override
    protected abstract MutableDoubleShortMap classUnderTest();

    @Override
    protected abstract MutableDoubleShortMap newWithKeysValues(double key1, short value1);

    @Override
    protected abstract MutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2);

    @Override
    protected abstract MutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3);

    @Override
    protected abstract MutableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3, double key4, short value4);

    @Override
    protected abstract MutableDoubleShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.put(0.0, (short) 1);
        Assert.assertEquals((short) 1, map1.get(0.0));
        map1.put(0.0, (short) 0);
        Assert.assertEquals((short) 0, map1.get(0.0));
        map1.put(5.0, (short) 5);
        Assert.assertEquals((short) 5, map1.get(5.0));
        map1.put(35.0, (short) 35);
        Assert.assertEquals((short) 35, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(0.0));
        map1.put(1.0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(1.0));
        map1.put(5.0, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow(5.0));
        map1.put(35.0, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals((short) 5, map1.getIfAbsent(0.0, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent(1.0, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent(33.0, (short) 6));
        map1.put(0.0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(0.0, (short) 5));
        map1.put(1.0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(1.0, (short) 5));
        map1.put(5.0, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent(5.0, (short) 6));
        map1.put(35.0, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent(35.0, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((short) 0, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((short) 0, map1.get(0.0));
        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals((short) 0, map1.get(1.0));
        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals((short) 0, map1.get(31.0));
        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals((short) 0, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.put(35.0, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.put(35.0, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleShortMap hashMap1 = this.newWithKeysValues(1.0, (short) 1, 0.0, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleShortMap hashMap = this.newWithKeysValues(6.0, (short) 6, 5.0, (short) 5);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleShortHashMap hashMap = new DoubleShortHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleShortHashMap(), map1);
        map1.put(1.0, (short) 0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleShortHashMap(), map1);
        map1.put(33.0, (short) 0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableDoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleShortHashMap(), map0);
        MutableDoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleShortHashMap(), map1);
        MutableDoubleShortMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(31.0, (short) 31, 32.0, (short) 32), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 32), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleShortHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableDoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        map0.remove(1.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleShortHashMap(), map0);
        MutableDoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        map1.remove(0.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleShortHashMap(), map1);
        MutableDoubleShortMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(31.0, (short) 31, 32.0, (short) 32), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 32), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleShortHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableDoubleShortMap map0 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent(1.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent(0.0, (short) 100));
        Assert.assertEquals(new DoubleShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(1.0, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(0.0, (short) 100));
        MutableDoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent(0.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent(1.0, (short) 100));
        Assert.assertEquals(new DoubleShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(0.0, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(1.0, (short) 100));
        MutableDoubleShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(5.0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(50.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent(0.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(31.0, (short) 31, 32.0, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent(31.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent(32.0, (short) 100));
        Assert.assertEquals(new DoubleShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(0.0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(31.0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(32.0, (short) 100));
        Assert.assertEquals(new DoubleShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.put(0.0, (short) 1);
        map1.put(31.0, (short) 32);
        map1.put(32.0, (short) 33);
        DoubleShortHashMap expected = DoubleShortHashMap.newWithKeysValues(0.0, (short) 1, 31.0, (short) 32, 32.0, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0, (short) 2);
        expected.put(1.0, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0, (short) 34);
        expected.put(33.0, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0, (short) 31);
        expected.put(30.0, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableDoubleShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut(0.0, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut(0.0, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut(10.0, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut(10.0, (short) 25, (short) 30));
        map1.removeKey(10.0);
        Assert.assertEquals(101, map1.getAndPut(10.0, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut(10.0, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableDoubleShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, (short) 1));
        map1.putPair(PrimitiveTuples.pair(31.0, (short) 32));
        map1.putPair(PrimitiveTuples.pair(32.0, (short) 33));
        DoubleShortHashMap expected = DoubleShortHashMap.newWithKeysValues(0.0, (short) 1, 31.0, (short) 32, 32.0, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0, (short) 2));
        expected.put(1.0, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0, (short) 34));
        expected.put(33.0, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0, (short) 31));
        expected.put(30.0, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableDoubleShortMap map1 = this.newWithKeysValues(0.0, (short) 11, 1.0, (short) 12, 2.0, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableDoubleShortMap expected1 = this.newWithKeysValues(0.0, (short) 11, 1.0, (short) 12, 2.0, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableDoubleShortMap map2 = this.newWithKeysValues(0.0, (short) 11, 1.0, (short) 12, 2.0, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableDoubleShortMap expected2 = this.newWithKeysValues(0.0, (short) 12, 1.0, (short) 13, 2.0, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableDoubleShortMap map3 = this.newWithKeysValues(0.0, (short) 11, 1.0, (short) 12, 2.0, (short) 13);
        map3.updateValues((k, v) -> k == 0.0 ? (short) 10 : v);
        MutableDoubleShortMap expected3 = this.newWithKeysValues(0.0, (short) 10, 1.0, (short) 12, 2.0, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableDoubleShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, (short) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0, (short) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0, (short) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0, (short) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0, (short) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0, (short) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0, (short) 33));
        DoubleShortHashMap expected = DoubleShortHashMap.newWithKeysValues(0.0, (short) 11, 1.0, (short) 12, 31.0, (short) 37, 32.0, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, (short) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0, (short) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0, (short) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0, (short) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0, (short) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0, (short) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableDoubleShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            double k = each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        DoubleShortHashMap hashMap = new DoubleShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((double) i));
            hashMap.put((double) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals((short) 0, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleShortMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleShortMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleShortMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleShortMapTestCase.generateCollisions().get(3);
        MutableDoubleShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableDoubleShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableDoubleShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 50, 1.0, (short) 50), map1);
        MutableDoubleShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 50, 1.0, (short) 50), map2);
        MutableDoubleShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 50), map3);
        MutableDoubleShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (short) 100));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 100, 1.0, (short) 100), map1);
        MutableDoubleShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 100, 1.0, (short) 100), map2);
        MutableDoubleShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 100), map3);
        MutableDoubleShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 9, 1.0, (short) 9), map1);
        MutableDoubleShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 9, 1.0, (short) 9), map2);
        MutableDoubleShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 9), map3);
        MutableDoubleShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToShortFunction function = (double doubleParameter) -> (short) doubleParameter;
        DoubleToShortFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1), map1);
        MutableDoubleShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1), map2);
        MutableDoubleShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(32.0, (short) 32), map3);
        MutableDoubleShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableDoubleShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 2, 1.0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 2, 1.0, (short) 2), map1);
        MutableDoubleShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 1, 1.0, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 2, 1.0, (short) 2), map2);
        MutableDoubleShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, (short) 0, incrementFunction));
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(33.0, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleShortMap mutableDoubleShortMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleShortMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleShortMap.put((double) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleShortMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleShortMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleShortMap mutableDoubleShortMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleShortMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleShortMapForClear.keySet().toArray());
        mutableDoubleShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 31.0, (short) 31, 32.0, (short) 32);
        MutableDoubleShortMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 31.0, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleShortMap map = this.newWithKeysValues(0.0, (short) 0, 1.0, (short) 1, 31.0, (short) 31, 32.0, (short) 32);
        MutableDoubleShortMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1, 31.0, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, (short) 1), hashMap);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleShortMap emptyMap = this.getEmptyMap();
        MutableDoubleShortMap partialMap = this.newWithKeysValues(1.0, (short) 1, 3.0, (short) 3);
        MutableDoubleShortMap completeMap = this.newWithKeysValues(1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4);
        Iterable<DoubleShortPair> emptyIterable = Iterables.iList();
        Iterable<DoubleShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, (short) 1), PrimitiveTuples.pair(3.0, (short) 3));
        Iterable<DoubleShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, (short) 1), PrimitiveTuples.pair(2.0, (short) 2), PrimitiveTuples.pair(3.0, (short) 3), PrimitiveTuples.pair(4.0, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedDoubleShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableDoubleShortMap mutableMap = this.classUnderTest();
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
        MutableDoubleShortMap map = this.newWithKeysValues(1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0, (short) 5);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 2, 1.0, (short) 3, 2.0, (short) 4, 3.0, (short) 5, 4.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, (short) 1, 2.0, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableDoubleShortMap map = this.newWithKeysValues(1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0, (short) 5);
        MutableDoubleShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableDoubleShortMap map = this.newWithKeysValues(1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0, (short) 5);
        DoubleSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleShortMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleShortMapTestCase::values;
            this.payloads.containsAll = AbstractMutableDoubleShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableDoubleShortMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableDoubleShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleShortMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableDoubleShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleShortMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleShortMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleShortMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleShortMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableDoubleShortMapTestCase::max;
            this.payloads.min = AbstractMutableDoubleShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleShortMapTestCase::sum;
            this.payloads.average = AbstractMutableDoubleShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableDoubleShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableDoubleShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractMutableDoubleShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractMutableDoubleShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableDoubleShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableDoubleShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableDoubleShortMapTestCase::chunk;
            this.payloads.get = AbstractMutableDoubleShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableDoubleShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableDoubleShortMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleShortMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleShortMapTestCase::contains;
            this.payloads.size = AbstractMutableDoubleShortMapTestCase::size;
            this.payloads.clear = AbstractMutableDoubleShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleShortMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleShortMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleShortMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableDoubleShortMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableDoubleShortMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableDoubleShortMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableDoubleShortMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableDoubleShortMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleShortMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleShortMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableDoubleShortMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleShortMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleShortMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleShortMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleShortMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleShortMapTestCase::asUnmodifiable;
            this.payloads.shortIterator_with_remove = AbstractMutableDoubleShortMapTestCase::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleShortMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleShortMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableDoubleShortMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableDoubleShortMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableDoubleShortMapTestCase::serializeKeySet;
        }
    }
}
