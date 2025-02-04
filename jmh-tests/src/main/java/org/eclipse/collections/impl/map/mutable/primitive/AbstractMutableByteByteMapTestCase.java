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
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableByteByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteByteMapTestCase extends AbstractByteByteMapTestCase {

    @Override
    protected abstract MutableByteByteMap classUnderTest();

    @Override
    protected abstract MutableByteByteMap newWithKeysValues(byte key1, byte value1);

    @Override
    protected abstract MutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2);

    @Override
    protected abstract MutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3);

    @Override
    protected abstract MutableByteByteMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3, byte key4, byte value4);

    @Override
    protected abstract MutableByteByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteByteMap map1 = this.classUnderTest();
        map1.put((byte) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get((byte) 0));
        map1.put((byte) 0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get((byte) 0));
        map1.put((byte) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get((byte) 5));
        map1.put((byte) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get((byte) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteByteMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((byte) 0));
        map1.put((byte) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((byte) 1));
        map1.put((byte) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow((byte) 5));
        map1.put((byte) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteByteMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((byte) 0, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((byte) 1, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((byte) 33, (byte) 6));
        map1.put((byte) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((byte) 0, (byte) 5));
        map1.put((byte) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((byte) 1, (byte) 5));
        map1.put((byte) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((byte) 5, (byte) 6));
        map1.put((byte) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent((byte) 35, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteByteMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals((byte) 0, map1.get((byte) 0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals((byte) 0, map1.get((byte) 0));
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals((byte) 0, map1.get((byte) 1));
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals((byte) 0, map1.get((byte) 31));
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals((byte) 0, map1.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteByteMap map1 = this.classUnderTest();
        map1.put((byte) 35, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteByteMap map1 = this.classUnderTest();
        map1.put((byte) 35, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteByteMap hashMap1 = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteByteMap hashMap = this.newWithKeysValues((byte) 6, (byte) 6, (byte) 5, (byte) 5);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteByteHashMap hashMap = new ByteByteHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteByteHashMap(), map1);
        map1.put((byte) 1, (byte) 0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteByteHashMap(), map1);
        map1.put((byte) 33, (byte) 0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteByteHashMap(), map0);
        MutableByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteByteHashMap(), map1);
        MutableByteByteMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 31, (byte) 31, (byte) 32, (byte) 32), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 32), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteByteHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableByteByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableByteByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableByteByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteByteHashMap(), map0);
        MutableByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteByteHashMap(), map1);
        MutableByteByteMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 31, (byte) 31, (byte) 32, (byte) 32), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 32), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteByteHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableByteByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableByteByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableByteByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteByteMap map0 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent((byte) 1, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent((byte) 0, (byte) 100));
        Assert.assertEquals(new ByteByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((byte) 1, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((byte) 0, (byte) 100));
        MutableByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent((byte) 0, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent((byte) 1, (byte) 100));
        Assert.assertEquals(new ByteByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((byte) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((byte) 1, (byte) 100));
        MutableByteByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((byte) 5, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((byte) 50, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent((byte) 0, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 31, (byte) 31, (byte) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent((byte) 31, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent((byte) 32, (byte) 100));
        Assert.assertEquals(new ByteByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((byte) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((byte) 31, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((byte) 32, (byte) 100));
        Assert.assertEquals(new ByteByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableByteByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableByteByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableByteByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableByteByteMap map1 = this.classUnderTest();
        map1.put((byte) 0, (byte) 1);
        map1.put((byte) 31, (byte) 32);
        map1.put((byte) 32, (byte) 33);
        ByteByteHashMap expected = ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 1, (byte) 31, (byte) 32, (byte) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, (byte) 2);
        expected.put((byte) 1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, (byte) 34);
        expected.put((byte) 33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, (byte) 31);
        expected.put((byte) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut((byte) 0, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut((byte) 0, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut((byte) 10, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, (byte) 25, (byte) 30));
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableByteByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair((byte) 31, (byte) 32));
        map1.putPair(PrimitiveTuples.pair((byte) 32, (byte) 33));
        ByteByteHashMap expected = ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 1, (byte) 31, (byte) 32, (byte) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, (byte) 2));
        expected.put((byte) 1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, (byte) 34));
        expected.put((byte) 33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, (byte) 31));
        expected.put((byte) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteByteMap map1 = this.newWithKeysValues((byte) 0, (byte) 11, (byte) 1, (byte) 12, (byte) 2, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableByteByteMap expected1 = this.newWithKeysValues((byte) 0, (byte) 11, (byte) 1, (byte) 12, (byte) 2, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableByteByteMap map2 = this.newWithKeysValues((byte) 0, (byte) 11, (byte) 1, (byte) 12, (byte) 2, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableByteByteMap expected2 = this.newWithKeysValues((byte) 0, (byte) 12, (byte) 1, (byte) 13, (byte) 2, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableByteByteMap map3 = this.newWithKeysValues((byte) 0, (byte) 11, (byte) 1, (byte) 12, (byte) 2, (byte) 13);
        map3.updateValues((k, v) -> k == (byte) 0 ? (byte) 10 : v);
        MutableByteByteMap expected3 = this.newWithKeysValues((byte) 0, (byte) 10, (byte) 1, (byte) 12, (byte) 2, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((byte) 0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue((byte) 31, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, (byte) 33));
        ByteByteHashMap expected = ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 11, (byte) 1, (byte) 12, (byte) 31, (byte) 37, (byte) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5L, map1.addToValue((byte) 31, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue((byte) 0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableByteByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ByteByteHashMap hashMap = new ByteByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((byte) i));
            hashMap.put((byte) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((byte) i));
            hashMap.remove((byte) i);
            Assert.assertEquals((byte) 0, hashMap.get((byte) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteByteMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteByteMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteByteMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteByteMapTestCase.generateCollisions().get(3);
        MutableByteByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableByteByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableByteByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 50, (byte) 1, (byte) 50), map1);
        MutableByteByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 50, (byte) 1, (byte) 50), map2);
        MutableByteByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 50), map3);
        MutableByteByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, (byte) 100));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 100, (byte) 1, (byte) 100), map1);
        MutableByteByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 100, (byte) 1, (byte) 100), map2);
        MutableByteByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 100), map3);
        MutableByteByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 9, (byte) 1, (byte) 9), map1);
        MutableByteByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 9, (byte) 1, (byte) 9), map2);
        MutableByteByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 9), map3);
        MutableByteByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToByteFunction function = (byte byteParameter) -> (byte) byteParameter;
        ByteToByteFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1), map1);
        MutableByteByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1), map2);
        MutableByteByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 32, (byte) 32), map3);
        MutableByteByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableByteByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((byte) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((byte) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 2, (byte) 1, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 2, (byte) 1, (byte) 2), map1);
        MutableByteByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((byte) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((byte) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 1, (byte) 1, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 2, (byte) 1, (byte) 2), map2);
        MutableByteByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((byte) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((byte) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 33, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableByteByteMap mutableByteByteMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteByteMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteByteMap.put((byte) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteByteMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteByteMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteByteMap mutableByteByteMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteByteMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteByteMapForClear.keySet().toArray());
        mutableByteByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 31, (byte) 31, (byte) 32, (byte) 32);
        MutableByteByteMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteByteMap map = this.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 31, (byte) 31, (byte) 32, (byte) 32);
        MutableByteByteMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, (byte) 1), hashMap);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteByteMap emptyMap = this.getEmptyMap();
        MutableByteByteMap partialMap = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 3, (byte) 3);
        MutableByteByteMap completeMap = this.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        Iterable<ByteBytePair> emptyIterable = Iterables.iList();
        Iterable<ByteBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 3, (byte) 3));
        Iterable<ByteBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, (byte) 1), PrimitiveTuples.pair((byte) 2, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 3), PrimitiveTuples.pair((byte) 4, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedByteByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableByteByteMap mutableMap = this.classUnderTest();
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
        MutableByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 5);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 1, (byte) 3, (byte) 2, (byte) 4, (byte) 3, (byte) 5, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 5);
        MutableByteByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteByteMap map = this.newWithKeysValues((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 5);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteByteMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteByteMapTestCase::select;
            this.payloads.reject = AbstractMutableByteByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteByteMapTestCase::collect;
            this.payloads.count = AbstractMutableByteByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteByteMapTestCase::max;
            this.payloads.min = AbstractMutableByteByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteByteMapTestCase::sum;
            this.payloads.average = AbstractMutableByteByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableByteByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableByteByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteByteMapTestCase::contains;
            this.payloads.size = AbstractMutableByteByteMapTestCase::size;
            this.payloads.clear = AbstractMutableByteByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableByteByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteByteMapTestCase::serializeKeySet;
        }
    }
}
