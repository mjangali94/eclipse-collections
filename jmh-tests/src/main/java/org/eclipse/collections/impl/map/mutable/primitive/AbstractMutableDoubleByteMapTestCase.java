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
import org.eclipse.collections.api.block.function.primitive.DoubleToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleByteMapTestCase extends AbstractDoubleByteMapTestCase {

    @Override
    protected abstract MutableDoubleByteMap classUnderTest();

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1);

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2);

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3);

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3, double key4, byte value4);

    @Override
    protected abstract MutableDoubleByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.put(0.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0.0));
        map1.put(0.0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0.0));
        map1.put(5.0, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5.0));
        map1.put(35.0, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0.0));
        map1.put(1.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1.0));
        map1.put(5.0, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5.0));
        map1.put(35.0, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0.0, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(1.0, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33.0, (byte) 6));
        map1.put(0.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0.0, (byte) 5));
        map1.put(1.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1.0, (byte) 5));
        map1.put(5.0, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5.0, (byte) 6));
        map1.put(35.0, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35.0, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((byte) 0, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((byte) 0, map1.get(0.0));
        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals((byte) 0, map1.get(1.0));
        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals((byte) 0, map1.get(31.0));
        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals((byte) 0, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.put(35.0, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.put(35.0, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleByteMap hashMap1 = this.newWithKeysValues(1.0, (byte) 1, 0.0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleByteMap hashMap = this.newWithKeysValues(6.0, (byte) 6, 5.0, (byte) 5);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleByteHashMap(), map1);
        map1.put(1.0, (byte) 0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleByteHashMap(), map1);
        map1.put(33.0, (byte) 0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableDoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleByteHashMap(), map0);
        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleByteHashMap(), map1);
        MutableDoubleByteMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableDoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map0.remove(1.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleByteHashMap(), map0);
        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map1.remove(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleByteHashMap(), map1);
        MutableDoubleByteMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableDoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1.0, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0.0, (byte) 100));
        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1.0, (byte) 100));
        MutableDoubleByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5.0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(31.0, (byte) 31, 32.0, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31.0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.put(0.0, (byte) 1);
        map1.put(31.0, (byte) 32);
        map1.put(32.0, (byte) 33);
        DoubleByteHashMap expected = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1, 31.0, (byte) 32, 32.0, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1.0, (byte) 2);
        expected.put(1.0, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33.0, (byte) 34);
        expected.put(33.0, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30.0, (byte) 31);
        expected.put(30.0, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableDoubleByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut(0.0, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut(0.0, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut(10.0, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut(10.0, (byte) 25, (byte) 30));
        map1.removeKey(10.0);
        Assert.assertEquals(101, map1.getAndPut(10.0, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut(10.0, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31.0, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32.0, (byte) 33));
        DoubleByteHashMap expected = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1, 31.0, (byte) 32, 32.0, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0, (byte) 2));
        expected.put(1.0, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0, (byte) 34));
        expected.put(33.0, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0, (byte) 31));
        expected.put(30.0, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 11, 1.0, (byte) 12, 2.0, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableDoubleByteMap expected1 = this.newWithKeysValues(0.0, (byte) 11, 1.0, (byte) 12, 2.0, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableDoubleByteMap map2 = this.newWithKeysValues(0.0, (byte) 11, 1.0, (byte) 12, 2.0, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableDoubleByteMap expected2 = this.newWithKeysValues(0.0, (byte) 12, 1.0, (byte) 13, 2.0, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableDoubleByteMap map3 = this.newWithKeysValues(0.0, (byte) 11, 1.0, (byte) 12, 2.0, (byte) 13);
        map3.updateValues((k, v) -> k == 0.0 ? (byte) 10 : v);
        MutableDoubleByteMap expected3 = this.newWithKeysValues(0.0, (byte) 10, 1.0, (byte) 12, 2.0, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0, (byte) 33));
        DoubleByteHashMap expected = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 11, 1.0, (byte) 12, 31.0, (byte) 37, 32.0, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableDoubleByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            double k = each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((double) i));
            hashMap.put((double) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals((byte) 0, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleByteMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleByteMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleByteMapTestCase.generateCollisions().get(3);
        MutableDoubleByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableDoubleByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableDoubleByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 50, 1.0, (byte) 50), map1);
        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 50, 1.0, (byte) 50), map2);
        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 50), map3);
        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 100, 1.0, (byte) 100), map1);
        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 100, 1.0, (byte) 100), map2);
        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 100), map3);
        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 9, 1.0, (byte) 9), map1);
        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 9, 1.0, (byte) 9), map2);
        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 9), map3);
        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToByteFunction function = (double doubleParameter) -> (byte) doubleParameter;
        DoubleToByteFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1), map1);
        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1), map2);
        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map3);
        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2, 1.0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2, 1.0, (byte) 2), map1);
        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2, 1.0, (byte) 2), map2);
        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleByteMap mutableDoubleByteMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleByteMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleByteMap.put((double) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleByteMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleByteMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleByteMap mutableDoubleByteMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleByteMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleByteMapForClear.keySet().toArray());
        mutableDoubleByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 31.0, (byte) 31, 32.0, (byte) 32);
        MutableDoubleByteMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 31.0, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 31.0, (byte) 31, 32.0, (byte) 32);
        MutableDoubleByteMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 31.0, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, (byte) 1), hashMap);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleByteMap emptyMap = this.getEmptyMap();
        MutableDoubleByteMap partialMap = this.newWithKeysValues(1.0, (byte) 1, 3.0, (byte) 3);
        MutableDoubleByteMap completeMap = this.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);
        Iterable<DoubleBytePair> emptyIterable = Iterables.iList();
        Iterable<DoubleBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, (byte) 1), PrimitiveTuples.pair(3.0, (byte) 3));
        Iterable<DoubleBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, (byte) 1), PrimitiveTuples.pair(2.0, (byte) 2), PrimitiveTuples.pair(3.0, (byte) 3), PrimitiveTuples.pair(4.0, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedDoubleByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableDoubleByteMap mutableMap = this.classUnderTest();
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
        MutableDoubleByteMap map = this.newWithKeysValues(1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0, (byte) 5);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 2, 1.0, (byte) 3, 2.0, (byte) 4, 3.0, (byte) 5, 4.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableDoubleByteMap map = this.newWithKeysValues(1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0, (byte) 5);
        MutableDoubleByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableDoubleByteMap map = this.newWithKeysValues(1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0, (byte) 5);
        DoubleSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleByteMapTestCase instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableDoubleByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableDoubleByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableDoubleByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableDoubleByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleByteMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleByteMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableDoubleByteMapTestCase::max;
            this.payloads.min = AbstractMutableDoubleByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleByteMapTestCase::sum;
            this.payloads.average = AbstractMutableDoubleByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableDoubleByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableDoubleByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableDoubleByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableDoubleByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableDoubleByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableDoubleByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableDoubleByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableDoubleByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableDoubleByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableDoubleByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleByteMapTestCase::contains;
            this.payloads.size = AbstractMutableDoubleByteMapTestCase::size;
            this.payloads.clear = AbstractMutableDoubleByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableDoubleByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableDoubleByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableDoubleByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableDoubleByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableDoubleByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableDoubleByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableDoubleByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableDoubleByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableDoubleByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableDoubleByteMapTestCase::serializeKeySet;
        }
    }
}
