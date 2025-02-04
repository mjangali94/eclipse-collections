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
import org.eclipse.collections.api.block.function.primitive.ByteToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableByteIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteIntMapTestCase extends AbstractByteIntMapTestCase {

    @Override
    protected abstract MutableByteIntMap classUnderTest();

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1);

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2);

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3);

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3, byte key4, int value4);

    @Override
    protected abstract MutableByteIntMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1);
        Assert.assertEquals(1, map1.get((byte) 0));
        map1.put((byte) 0, 0);
        Assert.assertEquals(0, map1.get((byte) 0));
        map1.put((byte) 5, 5);
        Assert.assertEquals(5, map1.get((byte) 5));
        map1.put((byte) 35, 35);
        Assert.assertEquals(35, map1.get((byte) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, 1);
        Assert.assertEquals(1, map1.getOrThrow((byte) 0));
        map1.put((byte) 1, 1);
        Assert.assertEquals(1, map1.getOrThrow((byte) 1));
        map1.put((byte) 5, 5);
        Assert.assertEquals(5, map1.getOrThrow((byte) 5));
        map1.put((byte) 35, 35);
        Assert.assertEquals(35, map1.getOrThrow((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals(5, map1.getIfAbsent((byte) 0, 5));
        Assert.assertEquals(6, map1.getIfAbsent((byte) 1, 6));
        Assert.assertEquals(6, map1.getIfAbsent((byte) 33, 6));
        map1.put((byte) 0, 1);
        Assert.assertEquals(1, map1.getIfAbsent((byte) 0, 5));
        map1.put((byte) 1, 1);
        Assert.assertEquals(1, map1.getIfAbsent((byte) 1, 5));
        map1.put((byte) 5, 5);
        Assert.assertEquals(5, map1.getIfAbsent((byte) 5, 6));
        map1.put((byte) 35, 35);
        Assert.assertEquals(35, map1.getIfAbsent((byte) 35, 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0, map1.get((byte) 0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0, map1.get((byte) 0));
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals(0, map1.get((byte) 1));
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals(0, map1.get((byte) 31));
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals(0, map1.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35);
        Assert.assertTrue(map1.containsValue(35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35);
        Assert.assertTrue(map1.contains(35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteIntMap hashMap1 = this.newWithKeysValues((byte) 1, 1, (byte) 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteIntMap hashMap = this.newWithKeysValues((byte) 6, 6, (byte) 5, 5);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteIntHashMap hashMap = new ByteIntHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteIntHashMap(), map1);
        map1.put((byte) 1, 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteIntHashMap(), map1);
        map1.put((byte) 33, 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteIntHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteIntMap map0 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteIntHashMap(), map0);
        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteIntHashMap(), map1);
        MutableByteIntMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 31, 31, (byte) 32, 32), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableByteIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableByteIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableByteIntMap map0 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteIntHashMap(), map0);
        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteIntHashMap(), map1);
        MutableByteIntMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 31, 31, (byte) 32, 32), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableByteIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableByteIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteIntMap map0 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent((byte) 1, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(new ByteIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent((byte) 1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent((byte) 0, 100));
        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent((byte) 1, 100));
        Assert.assertEquals(new ByteIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent((byte) 1, 100));
        MutableByteIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 50, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 31, 31, (byte) 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent((byte) 31, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent((byte) 32, 100));
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 32, 100));
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableByteIntMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1);
        map1.put((byte) 31, 32);
        map1.put((byte) 32, 33);
        ByteIntHashMap expected = ByteIntHashMap.newWithKeysValues((byte) 0, 1, (byte) 31, 32, (byte) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, 2);
        expected.put((byte) 1, 2);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, 34);
        expected.put((byte) 33, 34);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, 31);
        expected.put((byte) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteIntMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, 25, 50));
        Assert.assertEquals(25, map1.getAndPut((byte) 0, 35, 50));
        Assert.assertEquals(35, map1.getAndPut((byte) 0, 45, 55));
        Assert.assertEquals(100, map1.getAndPut((byte) 10, 25, 100));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 25, 30));
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, 25, 101));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 27, 105));
    }

    @Test
    public void putPair() {
        MutableByteIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, 1));
        map1.putPair(PrimitiveTuples.pair((byte) 31, 32));
        map1.putPair(PrimitiveTuples.pair((byte) 32, 33));
        ByteIntHashMap expected = ByteIntHashMap.newWithKeysValues((byte) 0, 1, (byte) 31, 32, (byte) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, 2));
        expected.put((byte) 1, 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, 34));
        expected.put((byte) 33, 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, 31));
        expected.put((byte) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 11, (byte) 1, 12, (byte) 2, 13);
        map1.updateValues((k, v) -> v);
        MutableByteIntMap expected1 = this.newWithKeysValues((byte) 0, 11, (byte) 1, 12, (byte) 2, 13);
        Assert.assertEquals(expected1, map1);
        MutableByteIntMap map2 = this.newWithKeysValues((byte) 0, 11, (byte) 1, 12, (byte) 2, 13);
        map2.updateValues((k, v) -> v + 1);
        MutableByteIntMap expected2 = this.newWithKeysValues((byte) 0, 12, (byte) 1, 13, (byte) 2, 14);
        Assert.assertEquals(expected2, map2);
        MutableByteIntMap map3 = this.newWithKeysValues((byte) 0, 11, (byte) 1, 12, (byte) 2, 13);
        map3.updateValues((k, v) -> k == (byte) 0 ? 10 : v);
        MutableByteIntMap expected3 = this.newWithKeysValues((byte) 0, 10, (byte) 1, 12, (byte) 2, 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((byte) 0, 1));
        Assert.assertEquals(32L, map1.addToValue((byte) 31, 32));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, 3));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, 10));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, 9));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, 5));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, 33));
        ByteIntHashMap expected = ByteIntHashMap.newWithKeysValues((byte) 0, 11, (byte) 1, 12, (byte) 31, 37, (byte) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5L, map1.addToValue((byte) 31, 5));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, 32));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, 33));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, 3));
        Assert.assertEquals(1L, map1.addToValue((byte) 0, 1));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, 9));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, 10));
        Assert.assertEquals(expected, map1);
        MutableByteIntMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ByteIntHashMap hashMap = new ByteIntHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((byte) i));
            hashMap.put((byte) i, i);
            Assert.assertEquals(i, hashMap.get((byte) i));
            hashMap.remove((byte) i);
            Assert.assertEquals(0, hashMap.get((byte) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteIntMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteIntMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteIntMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteIntMapTestCase.generateCollisions().get(3);
        MutableByteIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableByteIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableByteIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 50, (byte) 1, 50), map1);
        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 50, (byte) 1, 50), map2);
        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 50), map3);
        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 100, (byte) 1, 100), map1);
        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 100, (byte) 1, 100), map2);
        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 100), map3);
        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 9, (byte) 1, 9), map1);
        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 9, (byte) 1, 9), map2);
        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 9), map3);
        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToIntFunction function = (byte byteParameter) -> (int) byteParameter;
        ByteToIntFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 1, 1), map1);
        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 1, 1), map2);
        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map3);
        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 33), map4);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map1);
        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 1, (byte) 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map2);
        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((byte) 33, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue((byte) 33, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableByteIntMap mutableByteIntMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteIntMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteIntMap.put((byte) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteIntMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteIntMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteIntMap mutableByteIntMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteIntMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteIntMapForClear.keySet().toArray());
        mutableByteIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteIntMap map = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 31, 31, (byte) 32, 32);
        MutableByteIntMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteIntMap map = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 31, 31, (byte) 32, 32);
        MutableByteIntMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, 1), hashMap);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteIntMap emptyMap = this.getEmptyMap();
        MutableByteIntMap partialMap = this.newWithKeysValues((byte) 1, 1, (byte) 3, 3);
        MutableByteIntMap completeMap = this.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4);
        Iterable<ByteIntPair> emptyIterable = Iterables.iList();
        Iterable<ByteIntPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1), PrimitiveTuples.pair((byte) 3, 3));
        Iterable<ByteIntPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1), PrimitiveTuples.pair((byte) 2, 2), PrimitiveTuples.pair((byte) 3, 3), PrimitiveTuples.pair((byte) 4, 4));
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
        Verify.assertInstanceOf(SynchronizedByteIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove() {
        MutableByteIntMap mutableMap = this.classUnderTest();
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
        MutableByteIntMap map = this.newWithKeysValues((byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4, 5);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(2, (byte) 1, 3, (byte) 2, 4, (byte) 3, 5, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1, (byte) 2, 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteIntMap map = this.newWithKeysValues((byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4, 5);
        MutableByteIntMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteIntMap map = this.newWithKeysValues((byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4, 5);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteIntMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteIntMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteIntMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteIntMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteIntMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteIntMapTestCase::select;
            this.payloads.reject = AbstractMutableByteIntMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteIntMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteIntMapTestCase::collect;
            this.payloads.count = AbstractMutableByteIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteIntMapTestCase::max;
            this.payloads.min = AbstractMutableByteIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteIntMapTestCase::sum;
            this.payloads.average = AbstractMutableByteIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractMutableByteIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractMutableByteIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteIntMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteIntMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteIntMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteIntMapTestCase::contains;
            this.payloads.size = AbstractMutableByteIntMapTestCase::size;
            this.payloads.clear = AbstractMutableByteIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteIntMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteIntMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteIntMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteIntMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteIntMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteIntMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteIntMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteIntMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteIntMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteIntMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteIntMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteIntMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteIntMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteIntMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteIntMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteIntMapTestCase::asUnmodifiable;
            this.payloads.intIterator_with_remove = AbstractMutableByteIntMapTestCase::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteIntMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteIntMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteIntMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteIntMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteIntMapTestCase::serializeKeySet;
        }
    }
}
