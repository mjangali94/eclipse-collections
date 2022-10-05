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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongByteMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKey, this.description("removeKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKeyIfAbsent, this.description("removeKeyIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put, this.description("put"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getAndPut, this.description("getAndPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putPair, this.description("putPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValues, this.description("updateValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addToValue, this.description("addToValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_every_slot, this.description("put_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putDuplicateWithRemovedSlot, this.description("putDuplicateWithRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_Function, this.description("getIfAbsentPut_Function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithKey, this.description("getIfAbsentPutWithKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue, this.description("updateValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::freeze, this.description("freeze"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutKey, this.description("withoutKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAllKeys, this.description("withoutAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAllKeyValues, this.description("withAllKeyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::byteIterator_with_remove, this.description("byteIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_invocation_of_remove_before_next, this.description("iterator_throws_on_invocation_of_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_consecutive_invocation_of_remove, this.description("iterator_throws_on_consecutive_invocation_of_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialize, this.description("serialize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serializeKeySet, this.description("serializeKeySet"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableLongByteMapTestCase implementation();
    }
}
