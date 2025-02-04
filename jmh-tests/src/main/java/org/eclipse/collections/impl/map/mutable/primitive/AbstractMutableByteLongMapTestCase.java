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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteLongMapTestCase::select;
            this.payloads.reject = AbstractMutableByteLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteLongMapTestCase::collect;
            this.payloads.count = AbstractMutableByteLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteLongMapTestCase::max;
            this.payloads.min = AbstractMutableByteLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteLongMapTestCase::sum;
            this.payloads.average = AbstractMutableByteLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableByteLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableByteLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteLongMapTestCase::contains;
            this.payloads.size = AbstractMutableByteLongMapTestCase::size;
            this.payloads.clear = AbstractMutableByteLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableByteLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteLongMapTestCase::serializeKeySet;
        }
    }
}
