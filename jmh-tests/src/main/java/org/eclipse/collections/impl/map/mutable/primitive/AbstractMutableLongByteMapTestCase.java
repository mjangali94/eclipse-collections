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
import org.eclipse.collections.api.block.function.primitive.LongToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableLongByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongByteMapTestCase extends AbstractLongByteMapTestCase {

    @Override
    protected abstract MutableLongByteMap classUnderTest();

    @Override
    protected abstract MutableLongByteMap newWithKeysValues(long key1, byte value1);

    @Override
    protected abstract MutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2);

    @Override
    protected abstract MutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3);

    @Override
    protected abstract MutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3, long key4, byte value4);

    @Override
    protected abstract MutableLongByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableLongByteMap map1 = this.classUnderTest();
        map1.put(0L, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0L));
        map1.put(0L, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0L));
        map1.put(5L, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5L));
        map1.put(35L, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35L));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableLongByteMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0L));
        map1.put(1L, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1L));
        map1.put(5L, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5L));
        map1.put(35L, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35L));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableLongByteMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0L, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(1L, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33L, (byte) 6));
        map1.put(0L, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0L, (byte) 5));
        map1.put(1L, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1L, (byte) 5));
        map1.put(5L, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5L, (byte) 6));
        map1.put(35L, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35L, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableLongByteMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((byte) 0, map1.get(0L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((byte) 0, map1.get(0L));
        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals((byte) 0, map1.get(1L));
        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals((byte) 0, map1.get(31L));
        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals((byte) 0, map1.get(32L));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableLongByteMap map1 = this.classUnderTest();
        map1.put(35L, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableLongByteMap map1 = this.classUnderTest();
        map1.put(35L, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey(0L);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableLongByteMap hashMap1 = this.newWithKeysValues(1L, (byte) 1, 0L, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongByteMap hashMap = this.newWithKeysValues(6L, (byte) 6, 5L, (byte) 5);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongByteHashMap hashMap = new LongByteHashMap();
        for (long each = 2L; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongByteHashMap(), map1);
        map1.put(1L, (byte) 0);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongByteHashMap(), map1);
        map1.put(33L, (byte) 0);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableLongByteMap map0 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);
        map0.removeKey(1L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongByteHashMap(), map0);
        MutableLongByteMap map1 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);
        map1.removeKey(0L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongByteHashMap(), map1);
        MutableLongByteMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(31L, (byte) 31, 32L, (byte) 32), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 32), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongByteHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableLongByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableLongByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableLongByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableLongByteMap map0 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);
        map0.remove(1L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongByteHashMap(), map0);
        MutableLongByteMap map1 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);
        map1.remove(0L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongByteHashMap(), map1);
        MutableLongByteMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32), map2);
        map2.remove(0L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(31L, (byte) 31, 32L, (byte) 32), map2);
        map2.remove(31L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 32), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongByteHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableLongByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableLongByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableLongByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableLongByteMap map0 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0L, (byte) 100));
        Assert.assertEquals(new LongByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1L, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0L, (byte) 100));
        MutableLongByteMap map1 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1L, (byte) 100));
        Assert.assertEquals(new LongByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0L, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1L, (byte) 100));
        MutableLongByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5L, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(31L, (byte) 31, 32L, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32L, (byte) 100));
        Assert.assertEquals(new LongByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0L, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31L, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32L, (byte) 100));
        Assert.assertEquals(new LongByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableLongByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableLongByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableLongByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableLongByteMap map1 = this.classUnderTest();
        map1.put(0L, (byte) 1);
        map1.put(31L, (byte) 32);
        map1.put(32L, (byte) 33);
        LongByteHashMap expected = LongByteHashMap.newWithKeysValues(0L, (byte) 1, 31L, (byte) 32, 32L, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1L, (byte) 2);
        expected.put(1L, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33L, (byte) 34);
        expected.put(33L, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30L, (byte) 31);
        expected.put(30L, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableLongByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0L, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut(0L, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut(0L, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut(10L, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut(10L, (byte) 25, (byte) 30));
        map1.removeKey(10L);
        Assert.assertEquals(101, map1.getAndPut(10L, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut(10L, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableLongByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31L, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32L, (byte) 33));
        LongByteHashMap expected = LongByteHashMap.newWithKeysValues(0L, (byte) 1, 31L, (byte) 32, 32L, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1L, (byte) 2));
        expected.put(1L, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33L, (byte) 34));
        expected.put(33L, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30L, (byte) 31));
        expected.put(30L, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableLongByteMap map1 = this.newWithKeysValues(0L, (byte) 11, 1L, (byte) 12, 2L, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableLongByteMap expected1 = this.newWithKeysValues(0L, (byte) 11, 1L, (byte) 12, 2L, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableLongByteMap map2 = this.newWithKeysValues(0L, (byte) 11, 1L, (byte) 12, 2L, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableLongByteMap expected2 = this.newWithKeysValues(0L, (byte) 12, 1L, (byte) 13, 2L, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableLongByteMap map3 = this.newWithKeysValues(0L, (byte) 11, 1L, (byte) 12, 2L, (byte) 13);
        map3.updateValues((k, v) -> k == 0L ? (byte) 10 : v);
        MutableLongByteMap expected3 = this.newWithKeysValues(0L, (byte) 10, 1L, (byte) 12, 2L, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableLongByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0L, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31L, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1L, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0L, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1L, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31L, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32L, (byte) 33));
        LongByteHashMap expected = LongByteHashMap.newWithKeysValues(0L, (byte) 11, 1L, (byte) 12, 31L, (byte) 37, 32L, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5L, map1.addToValue(31L, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31L, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32L, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1L, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0L, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1L, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0L, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableLongByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            long k = each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        LongByteHashMap hashMap = new LongByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((long) i));
            hashMap.put((long) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((long) i));
            hashMap.remove((long) i);
            Assert.assertEquals((byte) 0, hashMap.get((long) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongByteMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongByteMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongByteMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongByteMapTestCase.generateCollisions().get(3);
        MutableLongByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableLongByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableLongByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableLongByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 50, 1L, (byte) 50), map1);
        MutableLongByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 50, 1L, (byte) 50), map2);
        MutableLongByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 50), map3);
        MutableLongByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (byte) 100));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableLongByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 100, 1L, (byte) 100), map1);
        MutableLongByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 100, 1L, (byte) 100), map2);
        MutableLongByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 100), map3);
        MutableLongByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableLongByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 9, 1L, (byte) 9), map1);
        MutableLongByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 9, 1L, (byte) 9), map2);
        MutableLongByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32L, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 9), map3);
        MutableLongByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33L, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToByteFunction function = (long longParameter) -> (byte) longParameter;
        LongToByteFunction functionThrows = (long longParameter) -> {
            throw new AssertionError();
        };
        MutableLongByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1), map1);
        MutableLongByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1), map2);
        MutableLongByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(32L, (byte) 32), map3);
        MutableLongByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableLongByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 2, 1L, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 2, 1L, (byte) 2), map1);
        MutableLongByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 1, 1L, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 2, 1L, (byte) 2), map2);
        MutableLongByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33L, (byte) 0, incrementFunction));
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(33L, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableLongByteMap mutableLongByteMap = this.classUnderTest();
        LongSet frozenSet = mutableLongByteMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongByteMap.put((long) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongByteMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongByteMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongByteMap mutableLongByteMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongByteMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongByteMapForClear.keySet().toArray());
        mutableLongByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongByteMap map = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1, 31L, (byte) 31, 32L, (byte) 32);
        MutableLongByteMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1, 31L, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableLongByteMap map = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1, 31L, (byte) 31, 32L, (byte) 32);
        MutableLongByteMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 31L, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableLongByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, (byte) 1), hashMap);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableLongByteMap emptyMap = this.getEmptyMap();
        MutableLongByteMap partialMap = this.newWithKeysValues(1L, (byte) 1, 3L, (byte) 3);
        MutableLongByteMap completeMap = this.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        Iterable<LongBytePair> emptyIterable = Iterables.iList();
        Iterable<LongBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, (byte) 1), PrimitiveTuples.pair(3L, (byte) 3));
        Iterable<LongBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, (byte) 1), PrimitiveTuples.pair(2L, (byte) 2), PrimitiveTuples.pair(3L, (byte) 3), PrimitiveTuples.pair(4L, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedLongByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableLongByteMap mutableMap = this.classUnderTest();
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
        MutableLongByteMap map = this.newWithKeysValues(1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L, (byte) 5);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 2, 1L, (byte) 3, 2L, (byte) 4, 3L, (byte) 5, 4L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, (byte) 1, 2L, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableLongByteMap map = this.newWithKeysValues(1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L, (byte) 5);
        MutableLongByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableLongByteMap map = this.newWithKeysValues(1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L, (byte) 5);
        LongSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongByteMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableLongByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableLongByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableLongByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableLongByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableLongByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableLongByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableLongByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableLongByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableLongByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableLongByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableLongByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableLongByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableLongByteMapTestCase::select;
            this.payloads.reject = AbstractMutableLongByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableLongByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableLongByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableLongByteMapTestCase::collect;
            this.payloads.count = AbstractMutableLongByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableLongByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableLongByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableLongByteMapTestCase::max;
            this.payloads.min = AbstractMutableLongByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongByteMapTestCase::sum;
            this.payloads.average = AbstractMutableLongByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableLongByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableLongByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableLongByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableLongByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableLongByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableLongByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableLongByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableLongByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableLongByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableLongByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableLongByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableLongByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableLongByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableLongByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableLongByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableLongByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableLongByteMapTestCase::contains;
            this.payloads.size = AbstractMutableLongByteMapTestCase::size;
            this.payloads.clear = AbstractMutableLongByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableLongByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableLongByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableLongByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableLongByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableLongByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableLongByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableLongByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableLongByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableLongByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableLongByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableLongByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableLongByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableLongByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableLongByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableLongByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableLongByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableLongByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableLongByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableLongByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableLongByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableLongByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableLongByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableLongByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableLongByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableLongByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableLongByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableLongByteMapTestCase::serializeKeySet;
        }
    }
*/
}
