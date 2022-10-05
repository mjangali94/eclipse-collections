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
import org.eclipse.collections.api.block.function.primitive.LongToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableLongShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongShortMapTestCase extends AbstractLongShortMapTestCase {

    @Override
    protected abstract MutableLongShortMap classUnderTest();

    @Override
    protected abstract MutableLongShortMap newWithKeysValues(long key1, short value1);

    @Override
    protected abstract MutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2);

    @Override
    protected abstract MutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3);

    @Override
    protected abstract MutableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4);

    @Override
    protected abstract MutableLongShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableLongShortMap map1 = this.classUnderTest();
        map1.put(0L, (short) 1);
        Assert.assertEquals((short) 1, map1.get(0L));
        map1.put(0L, (short) 0);
        Assert.assertEquals((short) 0, map1.get(0L));
        map1.put(5L, (short) 5);
        Assert.assertEquals((short) 5, map1.get(5L));
        map1.put(35L, (short) 35);
        Assert.assertEquals((short) 35, map1.get(35L));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableLongShortMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(0L));
        map1.put(1L, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow(1L));
        map1.put(5L, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow(5L));
        map1.put(35L, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow(35L));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableLongShortMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals((short) 5, map1.getIfAbsent(0L, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent(1L, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent(33L, (short) 6));
        map1.put(0L, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(0L, (short) 5));
        map1.put(1L, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent(1L, (short) 5));
        map1.put(5L, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent(5L, (short) 6));
        map1.put(35L, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent(35L, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableLongShortMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((short) 0, map1.get(0L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((short) 0, map1.get(0L));
        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals((short) 0, map1.get(1L));
        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals((short) 0, map1.get(31L));
        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals((short) 0, map1.get(32L));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableLongShortMap map1 = this.classUnderTest();
        map1.put(35L, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableLongShortMap map1 = this.classUnderTest();
        map1.put(35L, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey(0L);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableLongShortMap hashMap1 = this.newWithKeysValues(1L, (short) 1, 0L, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongShortMap hashMap = this.newWithKeysValues(6L, (short) 6, 5L, (short) 5);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongShortHashMap hashMap = new LongShortHashMap();
        for (long each = 2L; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongShortHashMap(), map1);
        map1.put(1L, (short) 0);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongShortHashMap(), map1);
        map1.put(33L, (short) 0);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableLongShortMap map0 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        map0.removeKey(1L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongShortHashMap(), map0);
        MutableLongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        map1.removeKey(0L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongShortHashMap(), map1);
        MutableLongShortMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(31L, (short) 31, 32L, (short) 32), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 32), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongShortHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableLongShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableLongShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableLongShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableLongShortMap map0 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        map0.remove(1L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongShortHashMap(), map0);
        MutableLongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        map1.remove(0L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongShortHashMap(), map1);
        MutableLongShortMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32), map2);
        map2.remove(0L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(31L, (short) 31, 32L, (short) 32), map2);
        map2.remove(31L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 32), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongShortHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableLongShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableLongShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableLongShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableLongShortMap map0 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent(1L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent(0L, (short) 100));
        Assert.assertEquals(new LongShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(1L, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent(0L, (short) 100));
        MutableLongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent(0L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent(1L, (short) 100));
        Assert.assertEquals(new LongShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(0L, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent(1L, (short) 100));
        MutableLongShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(5L, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(50L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent(0L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(31L, (short) 31, 32L, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent(31L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent(32L, (short) 100));
        Assert.assertEquals(new LongShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(0L, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(31L, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent(32L, (short) 100));
        Assert.assertEquals(new LongShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableLongShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableLongShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableLongShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableLongShortMap map1 = this.classUnderTest();
        map1.put(0L, (short) 1);
        map1.put(31L, (short) 32);
        map1.put(32L, (short) 33);
        LongShortHashMap expected = LongShortHashMap.newWithKeysValues(0L, (short) 1, 31L, (short) 32, 32L, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put(1L, (short) 2);
        expected.put(1L, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put(33L, (short) 34);
        expected.put(33L, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put(30L, (short) 31);
        expected.put(30L, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableLongShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0L, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut(0L, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut(0L, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut(10L, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut(10L, (short) 25, (short) 30));
        map1.removeKey(10L);
        Assert.assertEquals(101, map1.getAndPut(10L, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut(10L, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableLongShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, (short) 1));
        map1.putPair(PrimitiveTuples.pair(31L, (short) 32));
        map1.putPair(PrimitiveTuples.pair(32L, (short) 33));
        LongShortHashMap expected = LongShortHashMap.newWithKeysValues(0L, (short) 1, 31L, (short) 32, 32L, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1L, (short) 2));
        expected.put(1L, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33L, (short) 34));
        expected.put(33L, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30L, (short) 31));
        expected.put(30L, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableLongShortMap map1 = this.newWithKeysValues(0L, (short) 11, 1L, (short) 12, 2L, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableLongShortMap expected1 = this.newWithKeysValues(0L, (short) 11, 1L, (short) 12, 2L, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableLongShortMap map2 = this.newWithKeysValues(0L, (short) 11, 1L, (short) 12, 2L, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableLongShortMap expected2 = this.newWithKeysValues(0L, (short) 12, 1L, (short) 13, 2L, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableLongShortMap map3 = this.newWithKeysValues(0L, (short) 11, 1L, (short) 12, 2L, (short) 13);
        map3.updateValues((k, v) -> k == 0L ? (short) 10 : v);
        MutableLongShortMap expected3 = this.newWithKeysValues(0L, (short) 10, 1L, (short) 12, 2L, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableLongShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0L, (short) 1));
        Assert.assertEquals(32L, map1.addToValue(31L, (short) 32));
        Assert.assertEquals(3L, map1.addToValue(1L, (short) 3));
        Assert.assertEquals(11L, map1.addToValue(0L, (short) 10));
        Assert.assertEquals(12L, map1.addToValue(1L, (short) 9));
        Assert.assertEquals(37L, map1.addToValue(31L, (short) 5));
        Assert.assertEquals(33L, map1.addToValue(32L, (short) 33));
        LongShortHashMap expected = LongShortHashMap.newWithKeysValues(0L, (short) 11, 1L, (short) 12, 31L, (short) 37, 32L, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5L, map1.addToValue(31L, (short) 5));
        Assert.assertEquals(37L, map1.addToValue(31L, (short) 32));
        Assert.assertEquals(33L, map1.addToValue(32L, (short) 33));
        Assert.assertEquals(3L, map1.addToValue(1L, (short) 3));
        Assert.assertEquals(1L, map1.addToValue(0L, (short) 1));
        Assert.assertEquals(12L, map1.addToValue(1L, (short) 9));
        Assert.assertEquals(11L, map1.addToValue(0L, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableLongShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            long k = each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        LongShortHashMap hashMap = new LongShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((long) i));
            hashMap.put((long) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((long) i));
            hashMap.remove((long) i);
            Assert.assertEquals((short) 0, hashMap.get((long) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongShortMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongShortMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongShortMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongShortMapTestCase.generateCollisions().get(3);
        MutableLongShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableLongShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableLongShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableLongShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 50, 1L, (short) 50), map1);
        MutableLongShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 50, 1L, (short) 50), map2);
        MutableLongShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 50), map3);
        MutableLongShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (short) 100));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableLongShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 100, 1L, (short) 100), map1);
        MutableLongShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 100, 1L, (short) 100), map2);
        MutableLongShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 100), map3);
        MutableLongShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableLongShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 9, 1L, (short) 9), map1);
        MutableLongShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 9, 1L, (short) 9), map2);
        MutableLongShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32L, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 9), map3);
        MutableLongShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33L, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToShortFunction function = (long longParameter) -> (short) longParameter;
        LongToShortFunction functionThrows = (long longParameter) -> {
            throw new AssertionError();
        };
        MutableLongShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 1L, (short) 1), map1);
        MutableLongShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 1L, (short) 1), map2);
        MutableLongShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(32L, (short) 32), map3);
        MutableLongShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableLongShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 2, 1L, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 2, 1L, (short) 2), map1);
        MutableLongShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 1, 1L, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 2, 1L, (short) 2), map2);
        MutableLongShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33L, (short) 0, incrementFunction));
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(33L, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableLongShortMap mutableLongShortMap = this.classUnderTest();
        LongSet frozenSet = mutableLongShortMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongShortMap.put((long) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongShortMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongShortMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongShortMap mutableLongShortMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongShortMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongShortMapForClear.keySet().toArray());
        mutableLongShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 31L, (short) 31, 32L, (short) 32);
        MutableLongShortMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 31L, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableLongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 31L, (short) 31, 32L, (short) 32);
        MutableLongShortMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 31L, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableLongShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, (short) 1), hashMap);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableLongShortMap emptyMap = this.getEmptyMap();
        MutableLongShortMap partialMap = this.newWithKeysValues(1L, (short) 1, 3L, (short) 3);
        MutableLongShortMap completeMap = this.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4);
        Iterable<LongShortPair> emptyIterable = Iterables.iList();
        Iterable<LongShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, (short) 1), PrimitiveTuples.pair(3L, (short) 3));
        Iterable<LongShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, (short) 1), PrimitiveTuples.pair(2L, (short) 2), PrimitiveTuples.pair(3L, (short) 3), PrimitiveTuples.pair(4L, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedLongShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableLongShortMap mutableMap = this.classUnderTest();
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
        MutableLongShortMap map = this.newWithKeysValues(1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L, (short) 5);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 2, 1L, (short) 3, 2L, (short) 4, 3L, (short) 5, 4L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, (short) 1, 2L, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableLongShortMap map = this.newWithKeysValues(1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L, (short) 5);
        MutableLongShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableLongShortMap map = this.newWithKeysValues(1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L, (short) 5);
        LongSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongShortMapTestCase._Benchmark {

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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::shortIterator_with_remove, this.description("shortIterator_with_remove"));
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
        public abstract AbstractMutableLongShortMapTestCase implementation();
    }
}
