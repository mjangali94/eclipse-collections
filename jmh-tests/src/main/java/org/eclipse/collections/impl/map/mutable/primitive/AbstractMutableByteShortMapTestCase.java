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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteShortMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteShortMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteShortMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteShortMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteShortMapTestCase::select;
            this.payloads.reject = AbstractMutableByteShortMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteShortMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteShortMapTestCase::collect;
            this.payloads.count = AbstractMutableByteShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteShortMapTestCase::max;
            this.payloads.min = AbstractMutableByteShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteShortMapTestCase::sum;
            this.payloads.average = AbstractMutableByteShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractMutableByteShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractMutableByteShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteShortMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteShortMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteShortMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteShortMapTestCase::contains;
            this.payloads.size = AbstractMutableByteShortMapTestCase::size;
            this.payloads.clear = AbstractMutableByteShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteShortMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteShortMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteShortMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteShortMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteShortMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteShortMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteShortMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteShortMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteShortMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteShortMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteShortMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteShortMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteShortMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteShortMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteShortMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteShortMapTestCase::asUnmodifiable;
            this.payloads.shortIterator_with_remove = AbstractMutableByteShortMapTestCase::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteShortMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteShortMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteShortMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteShortMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteShortMapTestCase::serializeKeySet;
        }
    }
*/
}
