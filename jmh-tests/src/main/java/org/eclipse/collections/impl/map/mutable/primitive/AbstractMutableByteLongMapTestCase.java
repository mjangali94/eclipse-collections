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
import org.eclipse.collections.api.block.function.primitive.ByteToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableByteLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteLongMapTestCase extends AbstractByteLongMapTestCase {

    @Override
    protected abstract MutableByteLongMap classUnderTest();

    @Override
    protected abstract MutableByteLongMap newWithKeysValues(byte key1, long value1);

    @Override
    protected abstract MutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2);

    @Override
    protected abstract MutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3);

    @Override
    protected abstract MutableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3, byte key4, long value4);

    @Override
    protected abstract MutableByteLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteLongMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1L);
        Assert.assertEquals(1L, map1.get((byte) 0));
        map1.put((byte) 0, 0L);
        Assert.assertEquals(0L, map1.get((byte) 0));
        map1.put((byte) 5, 5L);
        Assert.assertEquals(5L, map1.get((byte) 5));
        map1.put((byte) 35, 35L);
        Assert.assertEquals(35L, map1.get((byte) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteLongMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((byte) 0));
        map1.put((byte) 1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((byte) 1));
        map1.put((byte) 5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow((byte) 5));
        map1.put((byte) 35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteLongMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals(5L, map1.getIfAbsent((byte) 0, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent((byte) 1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent((byte) 33, 6L));
        map1.put((byte) 0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((byte) 0, 5L));
        map1.put((byte) 1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((byte) 1, 5L));
        map1.put((byte) 5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent((byte) 5, 6L));
        map1.put((byte) 35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent((byte) 35, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteLongMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0L, map1.get((byte) 0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0L, map1.get((byte) 0));
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals(0L, map1.get((byte) 1));
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals(0L, map1.get((byte) 31));
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals(0L, map1.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteLongMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteLongMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteLongMap hashMap1 = this.newWithKeysValues((byte) 1, 1L, (byte) 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteLongMap hashMap = this.newWithKeysValues((byte) 6, 6L, (byte) 5, 5L);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteLongHashMap hashMap = new ByteLongHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteLongHashMap(), map1);
        map1.put((byte) 1, 0L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new ByteLongHashMap(), map1);
        map1.put((byte) 33, 0L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new ByteLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteLongMap map0 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteLongHashMap(), map0);
        MutableByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteLongHashMap(), map1);
        MutableByteLongMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 31, 31L, (byte) 32, 32L), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 32L), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteLongHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableByteLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableByteLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableByteLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableByteLongMap map0 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteLongHashMap(), map0);
        MutableByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteLongHashMap(), map1);
        MutableByteLongMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 31, 31L, (byte) 32, 32L), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 32L), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteLongHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableByteLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableByteLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableByteLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteLongMap map0 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent((byte) 1, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent((byte) 0, 100L));
        Assert.assertEquals(new ByteLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((byte) 1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((byte) 0, 100L));
        MutableByteLongMap map1 = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent((byte) 0, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent((byte) 1, 100L));
        Assert.assertEquals(new ByteLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((byte) 0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((byte) 1, 100L));
        MutableByteLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((byte) 5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((byte) 50, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent((byte) 0, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 31, 31L, (byte) 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent((byte) 31, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent((byte) 32, 100L));
        Assert.assertEquals(new ByteLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((byte) 0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((byte) 31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((byte) 32, 100L));
        Assert.assertEquals(new ByteLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableByteLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableByteLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableByteLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableByteLongMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1L);
        map1.put((byte) 31, 32L);
        map1.put((byte) 32, 33L);
        ByteLongHashMap expected = ByteLongHashMap.newWithKeysValues((byte) 0, 1L, (byte) 31, 32L, (byte) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, 2L);
        expected.put((byte) 1, 2L);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, 34L);
        expected.put((byte) 33, 34L);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, 31L);
        expected.put((byte) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut((byte) 0, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut((byte) 0, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut((byte) 10, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 25L, 30L));
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableByteLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, 1L));
        map1.putPair(PrimitiveTuples.pair((byte) 31, 32L));
        map1.putPair(PrimitiveTuples.pair((byte) 32, 33L));
        ByteLongHashMap expected = ByteLongHashMap.newWithKeysValues((byte) 0, 1L, (byte) 31, 32L, (byte) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, 2L));
        expected.put((byte) 1, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, 34L));
        expected.put((byte) 33, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, 31L));
        expected.put((byte) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteLongMap map1 = this.newWithKeysValues((byte) 0, 11L, (byte) 1, 12L, (byte) 2, 13L);
        map1.updateValues((k, v) -> v);
        MutableByteLongMap expected1 = this.newWithKeysValues((byte) 0, 11L, (byte) 1, 12L, (byte) 2, 13L);
        Assert.assertEquals(expected1, map1);
        MutableByteLongMap map2 = this.newWithKeysValues((byte) 0, 11L, (byte) 1, 12L, (byte) 2, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableByteLongMap expected2 = this.newWithKeysValues((byte) 0, 12L, (byte) 1, 13L, (byte) 2, 14L);
        Assert.assertEquals(expected2, map2);
        MutableByteLongMap map3 = this.newWithKeysValues((byte) 0, 11L, (byte) 1, 12L, (byte) 2, 13L);
        map3.updateValues((k, v) -> k == (byte) 0 ? 10L : v);
        MutableByteLongMap expected3 = this.newWithKeysValues((byte) 0, 10L, (byte) 1, 12L, (byte) 2, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((byte) 0, 1L));
        Assert.assertEquals(32L, map1.addToValue((byte) 31, 32L));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, 3L));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, 10L));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, 9L));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, 5L));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, 33L));
        ByteLongHashMap expected = ByteLongHashMap.newWithKeysValues((byte) 0, 11L, (byte) 1, 12L, (byte) 31, 37L, (byte) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5L, map1.addToValue((byte) 31, 5L));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, 32L));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, 33L));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, 3L));
        Assert.assertEquals(1L, map1.addToValue((byte) 0, 1L));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, 9L));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, 10L));
        Assert.assertEquals(expected, map1);
        MutableByteLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ByteLongHashMap hashMap = new ByteLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((byte) i));
            hashMap.put((byte) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((byte) i));
            hashMap.remove((byte) i);
            Assert.assertEquals(0L, hashMap.get((byte) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteLongMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteLongMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteLongMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteLongMapTestCase.generateCollisions().get(3);
        MutableByteLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableByteLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableByteLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 50L, (byte) 1, 50L), map1);
        MutableByteLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 50L, (byte) 1, 50L), map2);
        MutableByteLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 50L), map3);
        MutableByteLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, 100L));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 100L, (byte) 1, 100L), map1);
        MutableByteLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 100L, (byte) 1, 100L), map2);
        MutableByteLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 100L), map3);
        MutableByteLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 9L, (byte) 1, 9L), map1);
        MutableByteLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 9L, (byte) 1, 9L), map2);
        MutableByteLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 9L), map3);
        MutableByteLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToLongFunction function = (byte byteParameter) -> (long) byteParameter;
        ByteToLongFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L), map1);
        MutableByteLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L), map2);
        MutableByteLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 32, 32L), map3);
        MutableByteLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableByteLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((byte) 0, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 0, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue((byte) 1, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 2L, (byte) 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 1, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 2L, (byte) 1, 2L), map1);
        MutableByteLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((byte) 1, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 1, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue((byte) 0, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 1L, (byte) 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 0, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 2L, (byte) 1, 2L), map2);
        MutableByteLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((byte) 33, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue((byte) 33, 0L, incrementFunction));
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 33, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableByteLongMap mutableByteLongMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteLongMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteLongMap.put((byte) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteLongMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteLongMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteLongMap mutableByteLongMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteLongMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteLongMapForClear.keySet().toArray());
        mutableByteLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 31, 31L, (byte) 32, 32L);
        MutableByteLongMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteLongMap map = this.newWithKeysValues((byte) 0, 0L, (byte) 1, 1L, (byte) 31, 31L, (byte) 32, 32L);
        MutableByteLongMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L, (byte) 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, 1L), hashMap);
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteLongMap emptyMap = this.getEmptyMap();
        MutableByteLongMap partialMap = this.newWithKeysValues((byte) 1, 1L, (byte) 3, 3L);
        MutableByteLongMap completeMap = this.newWithKeysValues((byte) 1, 1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L);
        Iterable<ByteLongPair> emptyIterable = Iterables.iList();
        Iterable<ByteLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1L), PrimitiveTuples.pair((byte) 3, 3L));
        Iterable<ByteLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1L), PrimitiveTuples.pair((byte) 2, 2L), PrimitiveTuples.pair((byte) 3, 3L), PrimitiveTuples.pair((byte) 4, 4L));
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
        Verify.assertInstanceOf(SynchronizedByteLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableByteLongMap mutableMap = this.classUnderTest();
        MutableLongIterator iterator = mutableMap.longIterator();
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
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableByteLongMap map = this.newWithKeysValues((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4, 5L);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(2L, (byte) 1, 3L, (byte) 2, 4L, (byte) 3, 5L, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1L, (byte) 2, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteLongMap map = this.newWithKeysValues((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4, 5L);
        MutableByteLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteLongMap map = this.newWithKeysValues((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4, 5L);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteLongMapTestCase._Benchmark {

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
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::longIterator_with_remove, this.description("longIterator_with_remove"));
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
        public abstract AbstractMutableByteLongMapTestCase implementation();
    }
}
