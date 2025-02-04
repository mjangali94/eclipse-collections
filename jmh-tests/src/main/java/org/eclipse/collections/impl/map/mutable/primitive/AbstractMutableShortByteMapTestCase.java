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
import org.eclipse.collections.api.block.function.primitive.ShortToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableShortByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortByteMapTestCase extends AbstractShortByteMapTestCase {

    @Override
    protected abstract MutableShortByteMap classUnderTest();

    @Override
    protected abstract MutableShortByteMap newWithKeysValues(short key1, byte value1);

    @Override
    protected abstract MutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2);

    @Override
    protected abstract MutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3);

    @Override
    protected abstract MutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3, short key4, byte value4);

    @Override
    protected abstract MutableShortByteMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortByteMap map1 = this.classUnderTest();
        map1.put((short) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get((short) 0));
        map1.put((short) 0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get((short) 0));
        map1.put((short) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get((short) 5));
        map1.put((short) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortByteMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((short) 0));
        map1.put((short) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((short) 1));
        map1.put((short) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow((short) 5));
        map1.put((short) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortByteMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((short) 0, (byte) 5));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((short) 1, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((short) 33, (byte) 6));
        map1.put((short) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((short) 0, (byte) 5));
        map1.put((short) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((short) 1, (byte) 5));
        map1.put((short) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((short) 5, (byte) 6));
        map1.put((short) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent((short) 35, (byte) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortByteMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((byte) 0, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((byte) 0, map1.get((short) 0));
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals((byte) 0, map1.get((short) 1));
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals((byte) 0, map1.get((short) 31));
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals((byte) 0, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortByteMap map1 = this.classUnderTest();
        map1.put((short) 35, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortByteMap map1 = this.classUnderTest();
        map1.put((short) 35, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortByteMap hashMap1 = this.newWithKeysValues((short) 1, (byte) 1, (short) 0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortByteMap hashMap = this.newWithKeysValues((short) 6, (byte) 6, (short) 5, (byte) 5);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortByteHashMap hashMap = new ShortByteHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortByteHashMap(), map1);
        map1.put((short) 1, (byte) 0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortByteHashMap(), map1);
        map1.put((short) 33, (byte) 0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortByteHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortByteMap map0 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortByteHashMap(), map0);
        MutableShortByteMap map1 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortByteHashMap(), map1);
        MutableShortByteMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 31, (byte) 31, (short) 32, (byte) 32), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 32), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortByteHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableShortByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableShortByteMap map0 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);
        map0.remove((short) 1);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortByteHashMap(), map0);
        MutableShortByteMap map1 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);
        map1.remove((short) 0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortByteHashMap(), map1);
        MutableShortByteMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 31, (byte) 31, (short) 32, (byte) 32), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 32), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortByteHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableShortByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortByteMap map0 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent((short) 1, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent((short) 0, (byte) 100));
        Assert.assertEquals(new ShortByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((short) 1, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((short) 0, (byte) 100));
        MutableShortByteMap map1 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent((short) 0, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent((short) 1, (byte) 100));
        Assert.assertEquals(new ShortByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((short) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((short) 1, (byte) 100));
        MutableShortByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((short) 5, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((short) 50, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent((short) 0, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 31, (byte) 31, (short) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent((short) 31, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent((short) 32, (byte) 100));
        Assert.assertEquals(new ShortByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((short) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((short) 31, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((short) 32, (byte) 100));
        Assert.assertEquals(new ShortByteHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableShortByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableShortByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableShortByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableShortByteMap map1 = this.classUnderTest();
        map1.put((short) 0, (byte) 1);
        map1.put((short) 31, (byte) 32);
        map1.put((short) 32, (byte) 33);
        ShortByteHashMap expected = ShortByteHashMap.newWithKeysValues((short) 0, (byte) 1, (short) 31, (byte) 32, (short) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, (byte) 2);
        expected.put((short) 1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, (byte) 34);
        expected.put((short) 33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, (byte) 31);
        expected.put((short) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortByteMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, (byte) 25, (byte) 50));
        Assert.assertEquals(25, map1.getAndPut((short) 0, (byte) 35, (byte) 50));
        Assert.assertEquals(35, map1.getAndPut((short) 0, (byte) 45, (byte) 55));
        Assert.assertEquals(100, map1.getAndPut((short) 10, (byte) 25, (byte) 100));
        Assert.assertEquals(25, map1.getAndPut((short) 10, (byte) 25, (byte) 30));
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, (byte) 25, (byte) 101));
        Assert.assertEquals(25, map1.getAndPut((short) 10, (byte) 27, (byte) 105));
    }

    @Test
    public void putPair() {
        MutableShortByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair((short) 31, (byte) 32));
        map1.putPair(PrimitiveTuples.pair((short) 32, (byte) 33));
        ShortByteHashMap expected = ShortByteHashMap.newWithKeysValues((short) 0, (byte) 1, (short) 31, (byte) 32, (short) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, (byte) 2));
        expected.put((short) 1, (byte) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, (byte) 34));
        expected.put((short) 33, (byte) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, (byte) 31));
        expected.put((short) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortByteMap map1 = this.newWithKeysValues((short) 0, (byte) 11, (short) 1, (byte) 12, (short) 2, (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableShortByteMap expected1 = this.newWithKeysValues((short) 0, (byte) 11, (short) 1, (byte) 12, (short) 2, (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableShortByteMap map2 = this.newWithKeysValues((short) 0, (byte) 11, (short) 1, (byte) 12, (short) 2, (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableShortByteMap expected2 = this.newWithKeysValues((short) 0, (byte) 12, (short) 1, (byte) 13, (short) 2, (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableShortByteMap map3 = this.newWithKeysValues((short) 0, (byte) 11, (short) 1, (byte) 12, (short) 2, (byte) 13);
        map3.updateValues((k, v) -> k == (short) 0 ? (byte) 10 : v);
        MutableShortByteMap expected3 = this.newWithKeysValues((short) 0, (byte) 10, (short) 1, (byte) 12, (short) 2, (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue((short) 31, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (byte) 33));
        ShortByteHashMap expected = ShortByteHashMap.newWithKeysValues((short) 0, (byte) 11, (short) 1, (byte) 12, (short) 31, (byte) 37, (short) 32, (byte) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue((short) 0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (byte) 10));
        Assert.assertEquals(expected, map1);
        MutableShortByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ShortByteHashMap hashMap = new ShortByteHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((short) i));
            hashMap.put((short) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals((byte) 0, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortByteMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortByteMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortByteMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortByteMapTestCase.generateCollisions().get(3);
        MutableShortByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableShortByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableShortByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 50, (short) 1, (byte) 50), map1);
        MutableShortByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 50, (short) 1, (byte) 50), map2);
        MutableShortByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 50), map3);
        MutableShortByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (byte) 100));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 100, (short) 1, (byte) 100), map1);
        MutableShortByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 100, (short) 1, (byte) 100), map2);
        MutableShortByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 100), map3);
        MutableShortByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 9, (short) 1, (byte) 9), map1);
        MutableShortByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 9, (short) 1, (byte) 9), map2);
        MutableShortByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 9), map3);
        MutableShortByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToByteFunction function = (short shortParameter) -> (byte) shortParameter;
        ShortToByteFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1), map1);
        MutableShortByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1), map2);
        MutableShortByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 32, (byte) 32), map3);
        MutableShortByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 33), map4);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableShortByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 2, (short) 1, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 2, (short) 1, (byte) 2), map1);
        MutableShortByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 1, (short) 1, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 2, (short) 1, (byte) 2), map2);
        MutableShortByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 33, (byte) 2), map3);
    }

    @Test
    public void freeze() {
        MutableShortByteMap mutableShortByteMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortByteMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortByteMap.put((short) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortByteMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortByteMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortByteMap mutableShortByteMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortByteMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortByteMapForClear.keySet().toArray());
        mutableShortByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortByteMap map = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1, (short) 31, (byte) 31, (short) 32, (byte) 32);
        MutableShortByteMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1, (short) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortByteMap map = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1, (short) 31, (byte) 31, (short) 32, (byte) 32);
        MutableShortByteMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, (byte) 1), hashMap);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortByteMap emptyMap = this.getEmptyMap();
        MutableShortByteMap partialMap = this.newWithKeysValues((short) 1, (byte) 1, (short) 3, (byte) 3);
        MutableShortByteMap completeMap = this.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        Iterable<ShortBytePair> emptyIterable = Iterables.iList();
        Iterable<ShortBytePair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, (byte) 1), PrimitiveTuples.pair((short) 3, (byte) 3));
        Iterable<ShortBytePair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, (byte) 1), PrimitiveTuples.pair((short) 2, (byte) 2), PrimitiveTuples.pair((short) 3, (byte) 3), PrimitiveTuples.pair((short) 4, (byte) 4));
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
        Verify.assertInstanceOf(SynchronizedShortByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove() {
        MutableShortByteMap mutableMap = this.classUnderTest();
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
        MutableShortByteMap map = this.newWithKeysValues((short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4, (byte) 5);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 2, (short) 1, (byte) 3, (short) 2, (byte) 4, (short) 3, (byte) 5, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortByteMap map = this.newWithKeysValues((short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4, (byte) 5);
        MutableShortByteMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortByteMap map = this.newWithKeysValues((short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4, (byte) 5);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortByteMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortByteMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortByteMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortByteMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortByteMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortByteMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortByteMapTestCase::select;
            this.payloads.reject = AbstractMutableShortByteMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortByteMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortByteMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortByteMapTestCase::collect;
            this.payloads.count = AbstractMutableShortByteMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortByteMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortByteMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortByteMapTestCase::max;
            this.payloads.min = AbstractMutableShortByteMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortByteMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortByteMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortByteMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortByteMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortByteMapTestCase::sum;
            this.payloads.average = AbstractMutableShortByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortByteMapTestCase::toBag;
            this.payloads.byteIterator = AbstractMutableShortByteMapTestCase::byteIterator;
            this.payloads.asLazy = AbstractMutableShortByteMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortByteMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortByteMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortByteMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortByteMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortByteMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortByteMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortByteMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortByteMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortByteMapTestCase::contains;
            this.payloads.size = AbstractMutableShortByteMapTestCase::size;
            this.payloads.clear = AbstractMutableShortByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortByteMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortByteMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortByteMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortByteMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortByteMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortByteMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortByteMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortByteMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortByteMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortByteMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortByteMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortByteMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortByteMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortByteMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortByteMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortByteMapTestCase::asUnmodifiable;
            this.payloads.byteIterator_with_remove = AbstractMutableShortByteMapTestCase::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortByteMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortByteMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortByteMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortByteMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortByteMapTestCase::serializeKeySet;
        }
    }
*/
}
