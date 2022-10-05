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
import org.eclipse.collections.api.block.function.primitive.ByteToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableByteCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteCharPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteCharMapTestCase extends AbstractByteCharMapTestCase {

    @Override
    protected abstract MutableByteCharMap classUnderTest();

    @Override
    protected abstract MutableByteCharMap newWithKeysValues(byte key1, char value1);

    @Override
    protected abstract MutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2);

    @Override
    protected abstract MutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3);

    @Override
    protected abstract MutableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3, byte key4, char value4);

    @Override
    protected abstract MutableByteCharMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteCharMap map1 = this.classUnderTest();
        map1.put((byte) 0, (char) 1);
        Assert.assertEquals((char) 1, map1.get((byte) 0));
        map1.put((byte) 0, (char) 0);
        Assert.assertEquals((char) 0, map1.get((byte) 0));
        map1.put((byte) 5, (char) 5);
        Assert.assertEquals((char) 5, map1.get((byte) 5));
        map1.put((byte) 35, (char) 35);
        Assert.assertEquals((char) 35, map1.get((byte) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteCharMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow((byte) 0));
        map1.put((byte) 1, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow((byte) 1));
        map1.put((byte) 5, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow((byte) 5));
        map1.put((byte) 35, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteCharMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals((char) 5, map1.getIfAbsent((byte) 0, (char) 5));
        Assert.assertEquals((char) 6, map1.getIfAbsent((byte) 1, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent((byte) 33, (char) 6));
        map1.put((byte) 0, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent((byte) 0, (char) 5));
        map1.put((byte) 1, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent((byte) 1, (char) 5));
        map1.put((byte) 5, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent((byte) 5, (char) 6));
        map1.put((byte) 35, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent((byte) 35, (char) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteCharMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals((char) 0, map1.get((byte) 0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals((char) 0, map1.get((byte) 0));
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals((char) 0, map1.get((byte) 1));
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals((char) 0, map1.get((byte) 31));
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals((char) 0, map1.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteCharMap map1 = this.classUnderTest();
        map1.put((byte) 35, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteCharMap map1 = this.classUnderTest();
        map1.put((byte) 35, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteCharMap hashMap1 = this.newWithKeysValues((byte) 1, (char) 1, (byte) 0, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteCharMap hashMap = this.newWithKeysValues((byte) 6, (char) 6, (byte) 5, (char) 5);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteCharHashMap hashMap = new ByteCharHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteCharHashMap(), map1);
        map1.put((byte) 1, (char) 0);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteCharHashMap(), map1);
        map1.put((byte) 33, (char) 0);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteCharHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteCharMap map0 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteCharHashMap(), map0);
        MutableByteCharMap map1 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteCharHashMap(), map1);
        MutableByteCharMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 31, (char) 31, (byte) 32, (char) 32), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 32), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteCharHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableByteCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableByteCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableByteCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableByteCharMap map0 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteCharHashMap(), map0);
        MutableByteCharMap map1 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteCharHashMap(), map1);
        MutableByteCharMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 31, (char) 31, (byte) 32, (char) 32), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 32), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteCharHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableByteCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableByteCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableByteCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteCharMap map0 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent((byte) 1, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent((byte) 0, (char) 100));
        Assert.assertEquals(new ByteCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent((byte) 1, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent((byte) 0, (char) 100));
        MutableByteCharMap map1 = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent((byte) 0, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent((byte) 1, (char) 100));
        Assert.assertEquals(new ByteCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent((byte) 0, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent((byte) 1, (char) 100));
        MutableByteCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((byte) 5, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((byte) 50, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent((byte) 0, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 31, (char) 31, (byte) 32, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent((byte) 31, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent((byte) 32, (char) 100));
        Assert.assertEquals(new ByteCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((byte) 0, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((byte) 31, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((byte) 32, (char) 100));
        Assert.assertEquals(new ByteCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableByteCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableByteCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableByteCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableByteCharMap map1 = this.classUnderTest();
        map1.put((byte) 0, (char) 1);
        map1.put((byte) 31, (char) 32);
        map1.put((byte) 32, (char) 33);
        ByteCharHashMap expected = ByteCharHashMap.newWithKeysValues((byte) 0, (char) 1, (byte) 31, (char) 32, (byte) 32, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, (char) 2);
        expected.put((byte) 1, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, (char) 34);
        expected.put((byte) 33, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, (char) 31);
        expected.put((byte) 30, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteCharMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, (char) 25, (char) 50));
        Assert.assertEquals(25, map1.getAndPut((byte) 0, (char) 35, (char) 50));
        Assert.assertEquals(35, map1.getAndPut((byte) 0, (char) 45, (char) 55));
        Assert.assertEquals(100, map1.getAndPut((byte) 10, (char) 25, (char) 100));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, (char) 25, (char) 30));
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, (char) 25, (char) 101));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, (char) 27, (char) 105));
    }

    @Test
    public void putPair() {
        MutableByteCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, (char) 1));
        map1.putPair(PrimitiveTuples.pair((byte) 31, (char) 32));
        map1.putPair(PrimitiveTuples.pair((byte) 32, (char) 33));
        ByteCharHashMap expected = ByteCharHashMap.newWithKeysValues((byte) 0, (char) 1, (byte) 31, (char) 32, (byte) 32, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, (char) 2));
        expected.put((byte) 1, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, (char) 34));
        expected.put((byte) 33, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, (char) 31));
        expected.put((byte) 30, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteCharMap map1 = this.newWithKeysValues((byte) 0, (char) 11, (byte) 1, (char) 12, (byte) 2, (char) 13);
        map1.updateValues((k, v) -> v);
        MutableByteCharMap expected1 = this.newWithKeysValues((byte) 0, (char) 11, (byte) 1, (char) 12, (byte) 2, (char) 13);
        Assert.assertEquals(expected1, map1);
        MutableByteCharMap map2 = this.newWithKeysValues((byte) 0, (char) 11, (byte) 1, (char) 12, (byte) 2, (char) 13);
        map2.updateValues((k, v) -> (char) (v + (char) 1));
        MutableByteCharMap expected2 = this.newWithKeysValues((byte) 0, (char) 12, (byte) 1, (char) 13, (byte) 2, (char) 14);
        Assert.assertEquals(expected2, map2);
        MutableByteCharMap map3 = this.newWithKeysValues((byte) 0, (char) 11, (byte) 1, (char) 12, (byte) 2, (char) 13);
        map3.updateValues((k, v) -> k == (byte) 0 ? (char) 10 : v);
        MutableByteCharMap expected3 = this.newWithKeysValues((byte) 0, (char) 10, (byte) 1, (char) 12, (byte) 2, (char) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((byte) 0, (char) 1));
        Assert.assertEquals(32L, map1.addToValue((byte) 31, (char) 32));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, (char) 3));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, (char) 10));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, (char) 9));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, (char) 5));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, (char) 33));
        ByteCharHashMap expected = ByteCharHashMap.newWithKeysValues((byte) 0, (char) 11, (byte) 1, (char) 12, (byte) 31, (char) 37, (byte) 32, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5L, map1.addToValue((byte) 31, (char) 5));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, (char) 32));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, (char) 33));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, (char) 3));
        Assert.assertEquals(1L, map1.addToValue((byte) 0, (char) 1));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, (char) 9));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, (char) 10));
        Assert.assertEquals(expected, map1);
        MutableByteCharMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ByteCharHashMap hashMap = new ByteCharHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((char) 0, hashMap.get((byte) i));
            hashMap.put((byte) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((byte) i));
            hashMap.remove((byte) i);
            Assert.assertEquals((char) 0, hashMap.get((byte) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteCharMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteCharMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteCharMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteCharMapTestCase.generateCollisions().get(3);
        MutableByteCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);
        MutableByteCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);
        MutableByteCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 50, (byte) 1, (char) 50), map1);
        MutableByteCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 50, (byte) 1, (char) 50), map2);
        MutableByteCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 50), map3);
        MutableByteCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, (char) 100));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 100, (byte) 1, (char) 100), map1);
        MutableByteCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 100, (byte) 1, (char) 100), map2);
        MutableByteCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 100), map3);
        MutableByteCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 9, (byte) 1, (char) 9), map1);
        MutableByteCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 9, (byte) 1, (char) 9), map2);
        MutableByteCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 9), map3);
        MutableByteCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToCharFunction function = (byte byteParameter) -> (char) byteParameter;
        ByteToCharFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1), map1);
        MutableByteCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1), map2);
        MutableByteCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 32, (char) 32), map3);
        MutableByteCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 33), map4);
    }

    @Test
    public void updateValue() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        MutableByteCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((byte) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((byte) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 2, (byte) 1, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 2, (byte) 1, (char) 2), map1);
        MutableByteCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((byte) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((byte) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 1, (byte) 1, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 2, (byte) 1, (char) 2), map2);
        MutableByteCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((byte) 33, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((byte) 33, (char) 0, incrementFunction));
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 33, (char) 2), map3);
    }

    @Test
    public void freeze() {
        MutableByteCharMap mutableByteCharMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteCharMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteCharMap.put((byte) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteCharMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteCharMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteCharMap mutableByteCharMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteCharMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteCharMapForClear.keySet().toArray());
        mutableByteCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteCharMap map = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1, (byte) 31, (char) 31, (byte) 32, (char) 32);
        MutableByteCharMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1, (byte) 31, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteCharMap map = this.newWithKeysValues((byte) 0, (char) 0, (byte) 1, (char) 1, (byte) 31, (char) 31, (byte) 32, (char) 32);
        MutableByteCharMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1, (byte) 31, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, (char) 1), hashMap);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteCharMap emptyMap = this.getEmptyMap();
        MutableByteCharMap partialMap = this.newWithKeysValues((byte) 1, (char) 1, (byte) 3, (char) 3);
        MutableByteCharMap completeMap = this.newWithKeysValues((byte) 1, (char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4);
        Iterable<ByteCharPair> emptyIterable = Iterables.iList();
        Iterable<ByteCharPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, (char) 1), PrimitiveTuples.pair((byte) 3, (char) 3));
        Iterable<ByteCharPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, (char) 1), PrimitiveTuples.pair((byte) 2, (char) 2), PrimitiveTuples.pair((byte) 3, (char) 3), PrimitiveTuples.pair((byte) 4, (char) 4));
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
        Verify.assertInstanceOf(SynchronizedByteCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove() {
        MutableByteCharMap mutableMap = this.classUnderTest();
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
        MutableByteCharMap map = this.newWithKeysValues((byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4, (char) 5);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 2, (byte) 1, (char) 3, (byte) 2, (char) 4, (byte) 3, (char) 5, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, (char) 1, (byte) 2, (char) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteCharMap map = this.newWithKeysValues((byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4, (char) 5);
        MutableByteCharMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteCharMap map = this.newWithKeysValues((byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4, (char) 5);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteCharMapTestCase._Benchmark {

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
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::charIterator_with_remove, this.description("charIterator_with_remove"));
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
        public abstract AbstractMutableByteCharMapTestCase implementation();
    }
}
