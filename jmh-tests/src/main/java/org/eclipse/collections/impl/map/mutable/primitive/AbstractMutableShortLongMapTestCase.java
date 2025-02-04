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
import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortLongMapTestCase extends AbstractShortLongMapTestCase {

    @Override
    protected abstract MutableShortLongMap classUnderTest();

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1);

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2);

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3);

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4);

    @Override
    protected abstract MutableShortLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.put((short) 0, 1L);
        Assert.assertEquals(1L, map1.get((short) 0));
        map1.put((short) 0, 0L);
        Assert.assertEquals(0L, map1.get((short) 0));
        map1.put((short) 5, 5L);
        Assert.assertEquals(5L, map1.get((short) 5));
        map1.put((short) 35, 35L);
        Assert.assertEquals(35L, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((short) 0));
        map1.put((short) 1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((short) 1));
        map1.put((short) 5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow((short) 5));
        map1.put((short) 35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5L, map1.getIfAbsent((short) 0, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent((short) 1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent((short) 33, 6L));
        map1.put((short) 0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((short) 0, 5L));
        map1.put((short) 1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((short) 1, 5L));
        map1.put((short) 5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent((short) 5, 6L));
        map1.put((short) 35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent((short) 35, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0L, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0L, map1.get((short) 0));
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0L, map1.get((short) 1));
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0L, map1.get((short) 31));
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0L, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.put((short) 35, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.put((short) 35, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortLongMap hashMap1 = this.newWithKeysValues((short) 1, 1L, (short) 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortLongMap hashMap = this.newWithKeysValues((short) 6, 6L, (short) 5, 5L);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortLongHashMap(), map1);
        map1.put((short) 1, 0L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new ShortLongHashMap(), map1);
        map1.put((short) 33, 0L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new ShortLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortLongMap map0 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortLongHashMap(), map0);
        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortLongHashMap(), map1);
        MutableShortLongMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 31, 31L, (short) 32, 32L), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableShortLongMap map0 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map0.remove((short) 1);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortLongHashMap(), map0);
        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map1.remove((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortLongHashMap(), map1);
        MutableShortLongMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 31, 31L, (short) 32, 32L), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortLongMap map0 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent((short) 1, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((short) 1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((short) 0, 100L));
        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent((short) 1, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((short) 1, 100L));
        MutableShortLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 50, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 31, 31L, (short) 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent((short) 31, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent((short) 32, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 32, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableShortLongMap map1 = this.classUnderTest();
        map1.put((short) 0, 1L);
        map1.put((short) 31, 32L);
        map1.put((short) 32, 33L);
        ShortLongHashMap expected = ShortLongHashMap.newWithKeysValues((short) 0, 1L, (short) 31, 32L, (short) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, 2L);
        expected.put((short) 1, 2L);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, 34L);
        expected.put((short) 33, 34L);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, 31L);
        expected.put((short) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut((short) 0, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut((short) 0, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut((short) 10, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut((short) 10, 25L, 30L));
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut((short) 10, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableShortLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1L));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32L));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33L));
        ShortLongHashMap expected = ShortLongHashMap.newWithKeysValues((short) 0, 1L, (short) 31, 32L, (short) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, 2L));
        expected.put((short) 1, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, 34L));
        expected.put((short) 33, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, 31L));
        expected.put((short) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 11L, (short) 1, 12L, (short) 2, 13L);
        map1.updateValues((k, v) -> v);
        MutableShortLongMap expected1 = this.newWithKeysValues((short) 0, 11L, (short) 1, 12L, (short) 2, 13L);
        Assert.assertEquals(expected1, map1);
        MutableShortLongMap map2 = this.newWithKeysValues((short) 0, 11L, (short) 1, 12L, (short) 2, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableShortLongMap expected2 = this.newWithKeysValues((short) 0, 12L, (short) 1, 13L, (short) 2, 14L);
        Assert.assertEquals(expected2, map2);
        MutableShortLongMap map3 = this.newWithKeysValues((short) 0, 11L, (short) 1, 12L, (short) 2, 13L);
        map3.updateValues((k, v) -> k == (short) 0 ? 10L : v);
        MutableShortLongMap expected3 = this.newWithKeysValues((short) 0, 10L, (short) 1, 12L, (short) 2, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1L));
        Assert.assertEquals(32L, map1.addToValue((short) 31, 32L));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3L));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10L));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9L));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 5L));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33L));
        ShortLongHashMap expected = ShortLongHashMap.newWithKeysValues((short) 0, 11L, (short) 1, 12L, (short) 31, 37L, (short) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, 5L));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 32L));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33L));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3L));
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1L));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9L));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10L));
        Assert.assertEquals(expected, map1);
        MutableShortLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((short) i));
            hashMap.put((short) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals(0L, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortLongMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortLongMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortLongMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortLongMapTestCase.generateCollisions().get(3);
        MutableShortLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableShortLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableShortLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 50L, (short) 1, 50L), map1);
        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 50L, (short) 1, 50L), map2);
        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 50L), map3);
        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 100L, (short) 1, 100L), map1);
        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 100L, (short) 1, 100L), map2);
        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 100L), map3);
        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 9L, (short) 1, 9L), map1);
        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 9L, (short) 1, 9L), map2);
        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 9L), map3);
        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToLongFunction function = (short shortParameter) -> (long) shortParameter;
        ShortToLongFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L), map1);
        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L), map2);
        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map3);
        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L, (short) 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L, (short) 1, 2L), map1);
        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 1L, (short) 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L, (short) 1, 2L), map2);
        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableShortLongMap mutableShortLongMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortLongMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortLongMap.put((short) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortLongMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortLongMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortLongMap mutableShortLongMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortLongMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortLongMapForClear.keySet().toArray());
        mutableShortLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 31, 31L, (short) 32, 32L);
        MutableShortLongMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 31, 31L, (short) 32, 32L);
        MutableShortLongMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1L), hashMap);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortLongMap emptyMap = this.getEmptyMap();
        MutableShortLongMap partialMap = this.newWithKeysValues((short) 1, 1L, (short) 3, 3L);
        MutableShortLongMap completeMap = this.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Iterable<ShortLongPair> emptyIterable = Iterables.iList();
        Iterable<ShortLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1L), PrimitiveTuples.pair((short) 3, 3L));
        Iterable<ShortLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1L), PrimitiveTuples.pair((short) 2, 2L), PrimitiveTuples.pair((short) 3, 3L), PrimitiveTuples.pair((short) 4, 4L));
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
        Verify.assertInstanceOf(SynchronizedShortLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableShortLongMap mutableMap = this.classUnderTest();
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
        MutableShortLongMap map = this.newWithKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(2L, (short) 1, 3L, (short) 2, 4L, (short) 3, 5L, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1L, (short) 2, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortLongMap map = this.newWithKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L);
        MutableShortLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortLongMap map = this.newWithKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortLongMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortLongMapTestCase::select;
            this.payloads.reject = AbstractMutableShortLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortLongMapTestCase::collect;
            this.payloads.count = AbstractMutableShortLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortLongMapTestCase::max;
            this.payloads.min = AbstractMutableShortLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortLongMapTestCase::sum;
            this.payloads.average = AbstractMutableShortLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableShortLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableShortLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortLongMapTestCase::contains;
            this.payloads.size = AbstractMutableShortLongMapTestCase::size;
            this.payloads.clear = AbstractMutableShortLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableShortLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortLongMapTestCase::serializeKeySet;
        }
    }
}
