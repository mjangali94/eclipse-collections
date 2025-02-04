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
import org.eclipse.collections.api.block.function.primitive.CharToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableCharByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharByteMapTestCase extends AbstractCharByteMapTestCase {

    @Override
    protected abstract MutableCharByteMap classUnderTest();

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1);

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2);

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3);

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3, char key4, byte value4);

    @Override
    protected abstract MutableCharByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.put((char) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get((char) 0));
        map1.put((char) 0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get((char) 0));
        map1.put((char) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get((char) 5));
        map1.put((char) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((char) 0));
        map1.put((char) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((char) 1));
        map1.put((char) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow((char) 5));
        map1.put((char) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((char) 0, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((char) 1, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((char) 33, (byte) 6));
        map1.put((char) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((char) 0, (byte) 5));
        map1.put((char) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((char) 1, (byte) 5));
        map1.put((char) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((char) 5, (byte) 6));
        map1.put((char) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent((char) 35, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals((byte) 0, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals((byte) 0, map1.get((char) 0));
        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals((byte) 0, map1.get((char) 1));
        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals((byte) 0, map1.get((char) 31));
        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals((byte) 0, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.put((char) 35, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.put((char) 35, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharByteMap hashMap1 = this.newWithKeysValues((char) 1, (byte) 1, (char) 0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharByteMap hashMap = this.newWithKeysValues((char) 6, (byte) 6, (char) 5, (byte) 5);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharByteHashMap hashMap = new CharByteHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharByteHashMap(), map1);
        map1.put((char) 1, (byte) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new CharByteHashMap(), map1);
        map1.put((char) 33, (byte) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new CharByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableCharByteMap map0 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharByteHashMap(), map0);
        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharByteHashMap(), map1);
        MutableCharByteMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableCharByteMap map0 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map0.remove((char) 1);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharByteHashMap(), map0);
        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map1.remove((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharByteHashMap(), map1);
        MutableCharByteMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableCharByteMap map0 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent((char) 1, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((char) 1, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((char) 0, (byte) 100));
        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent((char) 1, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((char) 1, (byte) 100));
        MutableCharByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 5, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 50, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent((char) 31, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent((char) 32, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 31, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 32, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableCharByteMap map1 = this.classUnderTest();
        map1.put((char) 0, (byte) 1);
        map1.put((char) 31, (byte) 32);
        map1.put((char) 32, (byte) 33);
        CharByteHashMap expected = CharByteHashMap.newWithKeysValues((char) 0, (byte) 1, (char) 31, (byte) 32, (char) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put((char) 1, (byte) 2);
        expected.put((char) 1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put((char) 33, (byte) 34);
        expected.put((char) 33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put((char) 30, (byte) 31);
        expected.put((char) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableCharByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((char) 0, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut((char) 0, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut((char) 0, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut((char) 10, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut((char) 10, (byte) 25, (byte) 30));
        map1.removeKey((char) 10);
        Assert.assertEquals(101, map1.getAndPut((char) 10, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut((char) 10, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableCharByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair((char) 31, (byte) 32));
        map1.putPair(PrimitiveTuples.pair((char) 32, (byte) 33));
        CharByteHashMap expected = CharByteHashMap.newWithKeysValues((char) 0, (byte) 1, (char) 31, (byte) 32, (char) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 1, (byte) 2));
        expected.put((char) 1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 33, (byte) 34));
        expected.put((char) 33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 30, (byte) 31));
        expected.put((char) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 11, (char) 1, (byte) 12, (char) 2, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableCharByteMap expected1 = this.newWithKeysValues((char) 0, (byte) 11, (char) 1, (byte) 12, (char) 2, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableCharByteMap map2 = this.newWithKeysValues((char) 0, (byte) 11, (char) 1, (byte) 12, (char) 2, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableCharByteMap expected2 = this.newWithKeysValues((char) 0, (byte) 12, (char) 1, (byte) 13, (char) 2, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableCharByteMap map3 = this.newWithKeysValues((char) 0, (byte) 11, (char) 1, (byte) 12, (char) 2, (byte) 13);
        map3.updateValues((k, v) -> k == (char) 0 ? (byte) 10 : v);
        MutableCharByteMap expected3 = this.newWithKeysValues((char) 0, (byte) 10, (char) 1, (byte) 12, (char) 2, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue((char) 31, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue((char) 1, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue((char) 0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue((char) 1, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue((char) 31, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue((char) 32, (byte) 33));
        CharByteHashMap expected = CharByteHashMap.newWithKeysValues((char) 0, (byte) 11, (char) 1, (byte) 12, (char) 31, (byte) 37, (char) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue((char) 31, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue((char) 32, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue((char) 1, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue((char) 0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue((char) 1, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue((char) 0, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableCharByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            char k = (char) each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        CharByteHashMap hashMap = new CharByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((char) i));
            hashMap.put((char) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals((byte) 0, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharByteMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharByteMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharByteMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharByteMapTestCase.generateCollisions().get(3);
        MutableCharByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableCharByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableCharByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 50, (char) 1, (byte) 50), map1);
        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 50, (char) 1, (byte) 50), map2);
        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 50), map3);
        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 100, (char) 1, (byte) 100), map1);
        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 100, (char) 1, (byte) 100), map2);
        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 100), map3);
        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 9, (char) 1, (byte) 9), map1);
        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 9, (char) 1, (byte) 9), map2);
        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 9), map3);
        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToByteFunction function = (char charParameter) -> (byte) charParameter;
        CharToByteFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1), map1);
        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1), map2);
        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map3);
        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2, (char) 1, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2, (char) 1, (byte) 2), map1);
        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 1, (char) 1, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2, (char) 1, (byte) 2), map2);
        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableCharByteMap mutableCharByteMap = this.classUnderTest();
        CharSet frozenSet = mutableCharByteMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharByteMap.put((char) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharByteMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharByteMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharByteMap mutableCharByteMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharByteMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharByteMapForClear.keySet().toArray());
        mutableCharByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharByteMap map = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 31, (byte) 31, (char) 32, (byte) 32);
        MutableCharByteMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharByteMap map = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 31, (byte) 31, (char) 32, (byte) 32);
        MutableCharByteMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, (byte) 1), hashMap);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharByteMap emptyMap = this.getEmptyMap();
        MutableCharByteMap partialMap = this.newWithKeysValues((char) 1, (byte) 1, (char) 3, (byte) 3);
        MutableCharByteMap completeMap = this.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        Iterable<CharBytePair> emptyIterable = Iterables.iList();
        Iterable<CharBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, (byte) 1), PrimitiveTuples.pair((char) 3, (byte) 3));
        Iterable<CharBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, (byte) 1), PrimitiveTuples.pair((char) 2, (byte) 2), PrimitiveTuples.pair((char) 3, (byte) 3), PrimitiveTuples.pair((char) 4, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedCharByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableCharByteMap mutableMap = this.classUnderTest();
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
        MutableCharByteMap map = this.newWithKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5);
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 2, (char) 1, (byte) 3, (char) 2, (byte) 4, (char) 3, (byte) 5, (char) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableCharByteMap map = this.newWithKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5);
        MutableCharByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableCharByteMap map = this.newWithKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5);
        CharSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharByteMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableCharByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableCharByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableCharByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableCharByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharByteMapTestCase::select;
            this.payloads.reject = AbstractMutableCharByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharByteMapTestCase::collect;
            this.payloads.count = AbstractMutableCharByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableCharByteMapTestCase::max;
            this.payloads.min = AbstractMutableCharByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharByteMapTestCase::sum;
            this.payloads.average = AbstractMutableCharByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableCharByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableCharByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableCharByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableCharByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableCharByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableCharByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableCharByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableCharByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableCharByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableCharByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharByteMapTestCase::contains;
            this.payloads.size = AbstractMutableCharByteMapTestCase::size;
            this.payloads.clear = AbstractMutableCharByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableCharByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableCharByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableCharByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableCharByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableCharByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableCharByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableCharByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableCharByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableCharByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableCharByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableCharByteMapTestCase::serializeKeySet;
        }
    }
}
