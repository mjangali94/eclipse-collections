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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteCharMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteCharMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteCharMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteCharMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteCharMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteCharMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteCharMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteCharMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteCharMapTestCase::select;
            this.payloads.reject = AbstractMutableByteCharMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteCharMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteCharMapTestCase::collect;
            this.payloads.count = AbstractMutableByteCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteCharMapTestCase::max;
            this.payloads.min = AbstractMutableByteCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteCharMapTestCase::sum;
            this.payloads.average = AbstractMutableByteCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteCharMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractMutableByteCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractMutableByteCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteCharMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteCharMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteCharMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteCharMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteCharMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteCharMapTestCase::contains;
            this.payloads.size = AbstractMutableByteCharMapTestCase::size;
            this.payloads.clear = AbstractMutableByteCharMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteCharMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteCharMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteCharMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteCharMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteCharMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteCharMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteCharMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteCharMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteCharMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteCharMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteCharMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteCharMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteCharMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteCharMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteCharMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteCharMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteCharMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteCharMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteCharMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteCharMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteCharMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteCharMapTestCase::asUnmodifiable;
            this.payloads.charIterator_with_remove = AbstractMutableByteCharMapTestCase::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteCharMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteCharMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteCharMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteCharMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteCharMapTestCase::serializeKeySet;
        }
    }
}
