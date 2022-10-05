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
import org.eclipse.collections.api.block.function.primitive.ByteToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableByteShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteShortMapTestCase extends AbstractByteShortMapTestCase {

    @Override
    protected abstract MutableByteShortMap classUnderTest();

    @Override
    protected abstract MutableByteShortMap newWithKeysValues(byte key1, short value1);

    @Override
    protected abstract MutableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2);

    @Override
    protected abstract MutableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3);

    @Override
    protected abstract MutableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4);

    @Override
    protected abstract MutableByteShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteShortMap map1 = this.classUnderTest();
        map1.put((byte) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.get((byte) 0));
        map1.put((byte) 0, (short) 0);
        Assert.assertEquals((short) 0, map1.get((byte) 0));
        map1.put((byte) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.get((byte) 5));
        map1.put((byte) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.get((byte) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteShortMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((byte) 0));
        map1.put((byte) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((byte) 1));
        map1.put((byte) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow((byte) 5));
        map1.put((byte) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteShortMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals((short) 5, map1.getIfAbsent((byte) 0, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent((byte) 1, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent((byte) 33, (short) 6));
        map1.put((byte) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((byte) 0, (short) 5));
        map1.put((byte) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((byte) 1, (short) 5));
        map1.put((byte) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent((byte) 5, (short) 6));
        map1.put((byte) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent((byte) 35, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteShortMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals((short) 0, map1.get((byte) 0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals((short) 0, map1.get((byte) 0));
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals((short) 0, map1.get((byte) 1));
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals((short) 0, map1.get((byte) 31));
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals((short) 0, map1.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteShortMap map1 = this.classUnderTest();
        map1.put((byte) 35, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteShortMap map1 = this.classUnderTest();
        map1.put((byte) 35, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteShortMap hashMap1 = this.newWithKeysValues((byte) 1, (short) 1, (byte) 0, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteShortMap hashMap = this.newWithKeysValues((byte) 6, (short) 6, (byte) 5, (short) 5);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteShortHashMap hashMap = new ByteShortHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteShortHashMap(), map1);
        map1.put((byte) 1, (short) 0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteShortHashMap(), map1);
        map1.put((byte) 33, (short) 0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteShortMap map0 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteShortHashMap(), map0);
        MutableByteShortMap map1 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteShortHashMap(), map1);
        MutableByteShortMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 31, (short) 31, (byte) 32, (short) 32), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 32), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteShortHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableByteShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableByteShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableByteShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableByteShortMap map0 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteShortHashMap(), map0);
        MutableByteShortMap map1 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteShortHashMap(), map1);
        MutableByteShortMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 31, (short) 31, (byte) 32, (short) 32), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 32), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteShortHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableByteShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableByteShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableByteShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteShortMap map0 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent((byte) 1, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent((byte) 0, (short) 100));
        Assert.assertEquals(new ByteShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((byte) 1, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((byte) 0, (short) 100));
        MutableByteShortMap map1 = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent((byte) 0, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent((byte) 1, (short) 100));
        Assert.assertEquals(new ByteShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((byte) 0, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((byte) 1, (short) 100));
        MutableByteShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((byte) 5, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((byte) 50, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent((byte) 0, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 31, (short) 31, (byte) 32, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent((byte) 31, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent((byte) 32, (short) 100));
        Assert.assertEquals(new ByteShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((byte) 0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((byte) 31, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((byte) 32, (short) 100));
        Assert.assertEquals(new ByteShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableByteShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableByteShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableByteShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableByteShortMap map1 = this.classUnderTest();
        map1.put((byte) 0, (short) 1);
        map1.put((byte) 31, (short) 32);
        map1.put((byte) 32, (short) 33);
        ByteShortHashMap expected = ByteShortHashMap.newWithKeysValues((byte) 0, (short) 1, (byte) 31, (short) 32, (byte) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, (short) 2);
        expected.put((byte) 1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, (short) 34);
        expected.put((byte) 33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, (short) 31);
        expected.put((byte) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut((byte) 0, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut((byte) 0, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut((byte) 10, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, (short) 25, (short) 30));
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableByteShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, (short) 1));
        map1.putPair(PrimitiveTuples.pair((byte) 31, (short) 32));
        map1.putPair(PrimitiveTuples.pair((byte) 32, (short) 33));
        ByteShortHashMap expected = ByteShortHashMap.newWithKeysValues((byte) 0, (short) 1, (byte) 31, (short) 32, (byte) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, (short) 2));
        expected.put((byte) 1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, (short) 34));
        expected.put((byte) 33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, (short) 31));
        expected.put((byte) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteShortMap map1 = this.newWithKeysValues((byte) 0, (short) 11, (byte) 1, (short) 12, (byte) 2, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableByteShortMap expected1 = this.newWithKeysValues((byte) 0, (short) 11, (byte) 1, (short) 12, (byte) 2, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableByteShortMap map2 = this.newWithKeysValues((byte) 0, (short) 11, (byte) 1, (short) 12, (byte) 2, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableByteShortMap expected2 = this.newWithKeysValues((byte) 0, (short) 12, (byte) 1, (short) 13, (byte) 2, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableByteShortMap map3 = this.newWithKeysValues((byte) 0, (short) 11, (byte) 1, (short) 12, (byte) 2, (short) 13);
        map3.updateValues((k, v) -> k == (byte) 0 ? (short) 10 : v);
        MutableByteShortMap expected3 = this.newWithKeysValues((byte) 0, (short) 10, (byte) 1, (short) 12, (byte) 2, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((byte) 0, (short) 1));
        Assert.assertEquals(32L, map1.addToValue((byte) 31, (short) 32));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, (short) 3));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, (short) 10));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, (short) 9));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, (short) 5));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, (short) 33));
        ByteShortHashMap expected = ByteShortHashMap.newWithKeysValues((byte) 0, (short) 11, (byte) 1, (short) 12, (byte) 31, (short) 37, (byte) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5L, map1.addToValue((byte) 31, (short) 5));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, (short) 32));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, (short) 33));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, (short) 3));
        Assert.assertEquals(1L, map1.addToValue((byte) 0, (short) 1));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, (short) 9));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableByteShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ByteShortHashMap hashMap = new ByteShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((byte) i));
            hashMap.put((byte) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((byte) i));
            hashMap.remove((byte) i);
            Assert.assertEquals((short) 0, hashMap.get((byte) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteShortMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteShortMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteShortMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteShortMapTestCase.generateCollisions().get(3);
        MutableByteShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableByteShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableByteShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 50, (byte) 1, (short) 50), map1);
        MutableByteShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 50, (byte) 1, (short) 50), map2);
        MutableByteShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 50), map3);
        MutableByteShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, (short) 100));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 100, (byte) 1, (short) 100), map1);
        MutableByteShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 100, (byte) 1, (short) 100), map2);
        MutableByteShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 100), map3);
        MutableByteShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 9, (byte) 1, (short) 9), map1);
        MutableByteShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 9, (byte) 1, (short) 9), map2);
        MutableByteShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 9), map3);
        MutableByteShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToShortFunction function = (byte byteParameter) -> (short) byteParameter;
        ByteToShortFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1), map1);
        MutableByteShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1), map2);
        MutableByteShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 32, (short) 32), map3);
        MutableByteShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableByteShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((byte) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((byte) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 2, (byte) 1, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 2, (byte) 1, (short) 2), map1);
        MutableByteShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((byte) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((byte) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 1, (byte) 1, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 2, (byte) 1, (short) 2), map2);
        MutableByteShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((byte) 33, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((byte) 33, (short) 0, incrementFunction));
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 33, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableByteShortMap mutableByteShortMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteShortMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteShortMap.put((byte) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteShortMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteShortMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteShortMap mutableByteShortMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteShortMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteShortMapForClear.keySet().toArray());
        mutableByteShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteShortMap map = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1, (byte) 31, (short) 31, (byte) 32, (short) 32);
        MutableByteShortMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1, (byte) 31, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteShortMap map = this.newWithKeysValues((byte) 0, (short) 0, (byte) 1, (short) 1, (byte) 31, (short) 31, (byte) 32, (short) 32);
        MutableByteShortMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 31, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, (short) 1), hashMap);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteShortMap emptyMap = this.getEmptyMap();
        MutableByteShortMap partialMap = this.newWithKeysValues((byte) 1, (short) 1, (byte) 3, (short) 3);
        MutableByteShortMap completeMap = this.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        Iterable<ByteShortPair> emptyIterable = Iterables.iList();
        Iterable<ByteShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, (short) 1), PrimitiveTuples.pair((byte) 3, (short) 3));
        Iterable<ByteShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, (short) 1), PrimitiveTuples.pair((byte) 2, (short) 2), PrimitiveTuples.pair((byte) 3, (short) 3), PrimitiveTuples.pair((byte) 4, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedByteShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableByteShortMap mutableMap = this.classUnderTest();
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
        MutableByteShortMap map = this.newWithKeysValues((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4, (short) 5);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 2, (byte) 1, (short) 3, (byte) 2, (short) 4, (byte) 3, (short) 5, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteShortMap map = this.newWithKeysValues((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4, (short) 5);
        MutableByteShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteShortMap map = this.newWithKeysValues((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4, (short) 5);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteShortMapTestCase._Benchmark {

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
        public abstract AbstractMutableByteShortMapTestCase implementation();
    }
}
