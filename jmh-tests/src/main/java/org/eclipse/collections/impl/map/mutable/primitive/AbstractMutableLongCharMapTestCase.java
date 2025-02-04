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
import org.eclipse.collections.api.block.function.primitive.LongToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongCharPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongCharMapTestCase extends AbstractLongCharMapTestCase {

    @Override
    protected abstract MutableLongCharMap classUnderTest();

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1);

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2);

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3);

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4);

    @Override
    protected abstract MutableLongCharMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.put(0L, (char) 1);
        Assert.assertEquals((char) 1, map1.get(0L));
        map1.put(0L, (char) 0);
        Assert.assertEquals((char) 0, map1.get(0L));
        map1.put(5L, (char) 5);
        Assert.assertEquals((char) 5, map1.get(5L));
        map1.put(35L, (char) 35);
        Assert.assertEquals((char) 35, map1.get(35L));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(0L));
        map1.put(1L, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(1L));
        map1.put(5L, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow(5L));
        map1.put(35L, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow(35L));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals((char) 5, map1.getIfAbsent(0L, (char) 5));
        Assert.assertEquals((char) 6, map1.getIfAbsent(1L, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent(33L, (char) 6));
        map1.put(0L, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(0L, (char) 5));
        map1.put(1L, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(1L, (char) 5));
        map1.put(5L, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent(5L, (char) 6));
        map1.put(35L, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent(35L, (char) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((char) 0, map1.get(0L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((char) 0, map1.get(0L));
        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals((char) 0, map1.get(1L));
        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals((char) 0, map1.get(31L));
        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals((char) 0, map1.get(32L));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.put(35L, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.put(35L, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));
        map1.removeKey(0L);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableLongCharMap hashMap1 = this.newWithKeysValues(1L, (char) 1, 0L, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongCharMap hashMap = this.newWithKeysValues(6L, (char) 6, 5L, (char) 5);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongCharHashMap hashMap = new LongCharHashMap();
        for (long each = 2L; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongCharHashMap(), map1);
        map1.put(1L, (char) 0);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongCharHashMap(), map1);
        map1.put(33L, (char) 0);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongCharHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableLongCharMap map0 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map0.removeKey(1L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongCharHashMap(), map0);
        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map1.removeKey(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongCharHashMap(), map1);
        MutableLongCharMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(31L, (char) 31, 32L, (char) 32), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableLongCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableLongCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableLongCharMap map0 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map0.remove(1L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongCharHashMap(), map0);
        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map1.remove(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongCharHashMap(), map1);
        MutableLongCharMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32), map2);
        map2.remove(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(31L, (char) 31, 32L, (char) 32), map2);
        map2.remove(31L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableLongCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableLongCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableLongCharMap map0 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent(1L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(1L, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(0L, (char) 100));
        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent(1L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(1L, (char) 100));
        MutableLongCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(5L, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(50L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(31L, (char) 31, 32L, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent(31L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent(32L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(31L, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(32L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableLongCharMap map1 = this.classUnderTest();
        map1.put(0L, (char) 1);
        map1.put(31L, (char) 32);
        map1.put(32L, (char) 33);
        LongCharHashMap expected = LongCharHashMap.newWithKeysValues(0L, (char) 1, 31L, (char) 32, 32L, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1L, (char) 2);
        expected.put(1L, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33L, (char) 34);
        expected.put(33L, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30L, (char) 31);
        expected.put(30L, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableLongCharMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0L, (char) 25, (char) 50));
        Assert.assertEquals(25, map1.getAndPut(0L, (char) 35, (char) 50));
        Assert.assertEquals(35, map1.getAndPut(0L, (char) 45, (char) 55));
        Assert.assertEquals(100, map1.getAndPut(10L, (char) 25, (char) 100));
        Assert.assertEquals(25, map1.getAndPut(10L, (char) 25, (char) 30));
        map1.removeKey(10L);
        Assert.assertEquals(101, map1.getAndPut(10L, (char) 25, (char) 101));
        Assert.assertEquals(25, map1.getAndPut(10L, (char) 27, (char) 105));
    }

    @Test
    public void putPair() {
        MutableLongCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, (char) 1));
        map1.putPair(PrimitiveTuples.pair(31L, (char) 32));
        map1.putPair(PrimitiveTuples.pair(32L, (char) 33));
        LongCharHashMap expected = LongCharHashMap.newWithKeysValues(0L, (char) 1, 31L, (char) 32, 32L, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1L, (char) 2));
        expected.put(1L, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33L, (char) 34));
        expected.put(33L, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30L, (char) 31));
        expected.put(30L, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 11, 1L, (char) 12, 2L, (char) 13);
        map1.updateValues((k, v) -> v);
        MutableLongCharMap expected1 = this.newWithKeysValues(0L, (char) 11, 1L, (char) 12, 2L, (char) 13);
        Assert.assertEquals(expected1, map1);
        MutableLongCharMap map2 = this.newWithKeysValues(0L, (char) 11, 1L, (char) 12, 2L, (char) 13);
        map2.updateValues((k, v) -> (char) (v + (char) 1));
        MutableLongCharMap expected2 = this.newWithKeysValues(0L, (char) 12, 1L, (char) 13, 2L, (char) 14);
        Assert.assertEquals(expected2, map2);
        MutableLongCharMap map3 = this.newWithKeysValues(0L, (char) 11, 1L, (char) 12, 2L, (char) 13);
        map3.updateValues((k, v) -> k == 0L ? (char) 10 : v);
        MutableLongCharMap expected3 = this.newWithKeysValues(0L, (char) 10, 1L, (char) 12, 2L, (char) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0L, (char) 1));
        Assert.assertEquals(32L, map1.addToValue(31L, (char) 32));
        Assert.assertEquals(3L, map1.addToValue(1L, (char) 3));
        Assert.assertEquals(11L, map1.addToValue(0L, (char) 10));
        Assert.assertEquals(12L, map1.addToValue(1L, (char) 9));
        Assert.assertEquals(37L, map1.addToValue(31L, (char) 5));
        Assert.assertEquals(33L, map1.addToValue(32L, (char) 33));
        LongCharHashMap expected = LongCharHashMap.newWithKeysValues(0L, (char) 11, 1L, (char) 12, 31L, (char) 37, 32L, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5L, map1.addToValue(31L, (char) 5));
        Assert.assertEquals(37L, map1.addToValue(31L, (char) 32));
        Assert.assertEquals(33L, map1.addToValue(32L, (char) 33));
        Assert.assertEquals(3L, map1.addToValue(1L, (char) 3));
        Assert.assertEquals(1L, map1.addToValue(0L, (char) 1));
        Assert.assertEquals(12L, map1.addToValue(1L, (char) 9));
        Assert.assertEquals(11L, map1.addToValue(0L, (char) 10));
        Assert.assertEquals(expected, map1);
        MutableLongCharMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            long k = each;
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        LongCharHashMap hashMap = new LongCharHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((char) 0, hashMap.get((long) i));
            hashMap.put((long) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((long) i));
            hashMap.remove((long) i);
            Assert.assertEquals((char) 0, hashMap.get((long) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongCharMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongCharMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongCharMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongCharMapTestCase.generateCollisions().get(3);
        MutableLongCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);
        MutableLongCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);
        MutableLongCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 50, 1L, (char) 50), map1);
        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 50, 1L, (char) 50), map2);
        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 50), map3);
        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 100, 1L, (char) 100), map1);
        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 100, 1L, (char) 100), map2);
        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 100), map3);
        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 9, 1L, (char) 9), map1);
        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 9, 1L, (char) 9), map2);
        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 9), map3);
        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToCharFunction function = (long longParameter) -> (char) longParameter;
        LongToCharFunction functionThrows = (long longParameter) -> {
            throw new AssertionError();
        };
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1), map1);
        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1), map2);
        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map3);
        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 33), map4);
    }

    @Test
    public void updateValue() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2, 1L, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2, 1L, (char) 2), map1);
        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 1, 1L, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2, 1L, (char) 2), map2);
        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 2), map3);
    }

    @Test
    public void freeze() {
        MutableLongCharMap mutableLongCharMap = this.classUnderTest();
        LongSet frozenSet = mutableLongCharMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongCharMap.put((long) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongCharMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongCharMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongCharMap mutableLongCharMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongCharMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongCharMapForClear.keySet().toArray());
        mutableLongCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 31L, (char) 31, 32L, (char) 32);
        MutableLongCharMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 31L, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableLongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 31L, (char) 31, 32L, (char) 32);
        MutableLongCharMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 31L, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableLongCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, (char) 1), hashMap);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableLongCharMap emptyMap = this.getEmptyMap();
        MutableLongCharMap partialMap = this.newWithKeysValues(1L, (char) 1, 3L, (char) 3);
        MutableLongCharMap completeMap = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Iterable<LongCharPair> emptyIterable = Iterables.iList();
        Iterable<LongCharPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, (char) 1), PrimitiveTuples.pair(3L, (char) 3));
        Iterable<LongCharPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, (char) 1), PrimitiveTuples.pair(2L, (char) 2), PrimitiveTuples.pair(3L, (char) 3), PrimitiveTuples.pair(4L, (char) 4));
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
        Verify.assertInstanceOf(SynchronizedLongCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove() {
        MutableLongCharMap mutableMap = this.classUnderTest();
        MutableCharIterator iterator = mutableMap.charIterator();
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
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableLongCharMap map = this.newWithKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 2, 1L, (char) 3, 2L, (char) 4, 3L, (char) 5, 4L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, (char) 1, 2L, (char) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableLongCharMap map = this.newWithKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5);
        MutableLongCharMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableLongCharMap map = this.newWithKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5);
        LongSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongCharMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableLongCharMapTestCase::keySet;
            this.payloads.values = AbstractMutableLongCharMapTestCase::values;
            this.payloads.containsAll = AbstractMutableLongCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableLongCharMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableLongCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongCharMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableLongCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongCharMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableLongCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableLongCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableLongCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableLongCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableLongCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableLongCharMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongCharMapTestCase::appendString;
            this.payloads.select = AbstractMutableLongCharMapTestCase::select;
            this.payloads.reject = AbstractMutableLongCharMapTestCase::reject;
            this.payloads.select_value = AbstractMutableLongCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableLongCharMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableLongCharMapTestCase::collect;
            this.payloads.count = AbstractMutableLongCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableLongCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableLongCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableLongCharMapTestCase::max;
            this.payloads.min = AbstractMutableLongCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongCharMapTestCase::sum;
            this.payloads.average = AbstractMutableLongCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableLongCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableLongCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableLongCharMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractMutableLongCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractMutableLongCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableLongCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableLongCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableLongCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableLongCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableLongCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableLongCharMapTestCase::chunk;
            this.payloads.get = AbstractMutableLongCharMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableLongCharMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableLongCharMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableLongCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableLongCharMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableLongCharMapTestCase::contains;
            this.payloads.size = AbstractMutableLongCharMapTestCase::size;
            this.payloads.clear = AbstractMutableLongCharMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableLongCharMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableLongCharMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableLongCharMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableLongCharMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableLongCharMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableLongCharMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableLongCharMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableLongCharMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableLongCharMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableLongCharMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableLongCharMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableLongCharMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableLongCharMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableLongCharMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableLongCharMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableLongCharMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableLongCharMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableLongCharMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableLongCharMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableLongCharMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableLongCharMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongCharMapTestCase::asUnmodifiable;
            this.payloads.charIterator_with_remove = AbstractMutableLongCharMapTestCase::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableLongCharMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableLongCharMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableLongCharMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableLongCharMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableLongCharMapTestCase::serializeKeySet;
        }
    }
*/
}
