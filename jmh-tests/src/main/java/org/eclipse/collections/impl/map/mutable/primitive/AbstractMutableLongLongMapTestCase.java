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
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableLongLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongLongMapTestCase extends AbstractLongLongMapTestCase {

    @Override
    protected abstract MutableLongLongMap classUnderTest();

    @Override
    protected abstract MutableLongLongMap newWithKeysValues(long key1, long value1);

    @Override
    protected abstract MutableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2);

    @Override
    protected abstract MutableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3);

    @Override
    protected abstract MutableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4);

    @Override
    protected abstract MutableLongLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableLongLongMap map1 = this.classUnderTest();
        map1.put(0L, 1L);
        Assert.assertEquals(1L, map1.get(0L));
        map1.put(0L, 0L);
        Assert.assertEquals(0L, map1.get(0L));
        map1.put(5L, 5L);
        Assert.assertEquals(5L, map1.get(5L));
        map1.put(35L, 35L);
        Assert.assertEquals(35L, map1.get(35L));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableLongLongMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0L));
        map1.put(1L, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1L));
        map1.put(5L, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5L));
        map1.put(35L, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35L));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableLongLongMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals(5L, map1.getIfAbsent(0L, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent(1L, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33L, 6L));
        map1.put(0L, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0L, 5L));
        map1.put(1L, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1L, 5L));
        map1.put(5L, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5L, 6L));
        map1.put(35L, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35L, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableLongLongMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0L, map1.get(0L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0L, map1.get(0L));
        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals(0L, map1.get(1L));
        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals(0L, map1.get(31L));
        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals(0L, map1.get(32L));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableLongLongMap map1 = this.classUnderTest();
        map1.put(35L, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableLongLongMap map1 = this.classUnderTest();
        map1.put(35L, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableLongLongMap hashMap1 = this.newWithKeysValues(1L, 1L, 0L, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongLongMap hashMap = this.newWithKeysValues(6L, 6L, 5L, 5L);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongLongHashMap hashMap = new LongLongHashMap();
        for (long each = 2L; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongLongHashMap(), map1);
        map1.put(1L, 0L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 0L), map1);
        map1.clear();
        Assert.assertEquals(new LongLongHashMap(), map1);
        map1.put(33L, 0L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 0L), map1);
        map1.clear();
        Assert.assertEquals(new LongLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableLongLongMap map0 = this.newWithKeysValues(0L, 0L, 1L, 1L);
        map0.removeKey(1L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongLongHashMap(), map0);
        MutableLongLongMap map1 = this.newWithKeysValues(0L, 0L, 1L, 1L);
        map1.removeKey(0L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongLongHashMap(), map1);
        MutableLongLongMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(31L, 31L, 32L, 32L), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 32L), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongLongHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableLongLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableLongLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableLongLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableLongLongMap map0 = this.newWithKeysValues(0L, 0L, 1L, 1L);
        map0.remove(1L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongLongHashMap(), map0);
        MutableLongLongMap map1 = this.newWithKeysValues(0L, 0L, 1L, 1L);
        map1.remove(0L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongLongHashMap(), map1);
        MutableLongLongMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L), map2);
        map2.remove(0L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(31L, 31L, 32L, 32L), map2);
        map2.remove(31L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 32L), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongLongHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableLongLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableLongLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableLongLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableLongLongMap map0 = this.newWithKeysValues(0L, 0L, 1L, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0L, 100L));
        Assert.assertEquals(new LongLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1L, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0L, 100L));
        MutableLongLongMap map1 = this.newWithKeysValues(0L, 0L, 1L, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1L, 100L));
        Assert.assertEquals(new LongLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0L, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1L, 100L));
        MutableLongLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5L, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(31L, 31L, 32L, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32L, 100L));
        Assert.assertEquals(new LongLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0L, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31L, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32L, 100L));
        Assert.assertEquals(new LongLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableLongLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableLongLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableLongLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableLongLongMap map1 = this.classUnderTest();
        map1.put(0L, 1L);
        map1.put(31L, 32L);
        map1.put(32L, 33L);
        LongLongHashMap expected = LongLongHashMap.newWithKeysValues(0L, 1L, 31L, 32L, 32L, 33L);
        Assert.assertEquals(expected, map1);
        map1.put(1L, 2L);
        expected.put(1L, 2L);
        Assert.assertEquals(expected, map1);
        map1.put(33L, 34L);
        expected.put(33L, 34L);
        Assert.assertEquals(expected, map1);
        map1.put(30L, 31L);
        expected.put(30L, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableLongLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0L, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut(0L, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut(0L, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut(10L, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut(10L, 25L, 30L));
        map1.removeKey(10L);
        Assert.assertEquals(101, map1.getAndPut(10L, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut(10L, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableLongLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, 1L));
        map1.putPair(PrimitiveTuples.pair(31L, 32L));
        map1.putPair(PrimitiveTuples.pair(32L, 33L));
        LongLongHashMap expected = LongLongHashMap.newWithKeysValues(0L, 1L, 31L, 32L, 32L, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1L, 2L));
        expected.put(1L, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33L, 34L));
        expected.put(33L, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30L, 31L));
        expected.put(30L, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableLongLongMap map1 = this.newWithKeysValues(0L, 11L, 1L, 12L, 2L, 13L);
        map1.updateValues((k, v) -> v);
        MutableLongLongMap expected1 = this.newWithKeysValues(0L, 11L, 1L, 12L, 2L, 13L);
        Assert.assertEquals(expected1, map1);
        MutableLongLongMap map2 = this.newWithKeysValues(0L, 11L, 1L, 12L, 2L, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableLongLongMap expected2 = this.newWithKeysValues(0L, 12L, 1L, 13L, 2L, 14L);
        Assert.assertEquals(expected2, map2);
        MutableLongLongMap map3 = this.newWithKeysValues(0L, 11L, 1L, 12L, 2L, 13L);
        map3.updateValues((k, v) -> k == 0L ? 10L : v);
        MutableLongLongMap expected3 = this.newWithKeysValues(0L, 10L, 1L, 12L, 2L, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableLongLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0L, 1L));
        Assert.assertEquals(32L, map1.addToValue(31L, 32L));
        Assert.assertEquals(3L, map1.addToValue(1L, 3L));
        Assert.assertEquals(11L, map1.addToValue(0L, 10L));
        Assert.assertEquals(12L, map1.addToValue(1L, 9L));
        Assert.assertEquals(37L, map1.addToValue(31L, 5L));
        Assert.assertEquals(33L, map1.addToValue(32L, 33L));
        LongLongHashMap expected = LongLongHashMap.newWithKeysValues(0L, 11L, 1L, 12L, 31L, 37L, 32L, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5L, map1.addToValue(31L, 5L));
        Assert.assertEquals(37L, map1.addToValue(31L, 32L));
        Assert.assertEquals(33L, map1.addToValue(32L, 33L));
        Assert.assertEquals(3L, map1.addToValue(1L, 3L));
        Assert.assertEquals(1L, map1.addToValue(0L, 1L));
        Assert.assertEquals(12L, map1.addToValue(1L, 9L));
        Assert.assertEquals(11L, map1.addToValue(0L, 10L));
        Assert.assertEquals(expected, map1);
        MutableLongLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            long k = each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        LongLongHashMap hashMap = new LongLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((long) i));
            hashMap.put((long) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((long) i));
            hashMap.remove((long) i);
            Assert.assertEquals(0L, hashMap.get((long) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongLongMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongLongMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongLongMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongLongMapTestCase.generateCollisions().get(3);
        MutableLongLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableLongLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableLongLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableLongLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 50L, 1L, 50L), map1);
        MutableLongLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 50L, 1L, 50L), map2);
        MutableLongLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 50L), map3);
        MutableLongLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, 100L));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableLongLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 100L, 1L, 100L), map1);
        MutableLongLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 100L, 1L, 100L), map2);
        MutableLongLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 100L), map3);
        MutableLongLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableLongLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 9L, 1L, 9L), map1);
        MutableLongLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 9L, 1L, 9L), map2);
        MutableLongLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32L, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 9L), map3);
        MutableLongLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33L, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToLongFunction function = (long longParameter) -> (long) longParameter;
        LongToLongFunction functionThrows = (long longParameter) -> {
            throw new AssertionError();
        };
        MutableLongLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L, 1L, 1L), map1);
        MutableLongLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L, 1L, 1L), map2);
        MutableLongLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(32L, 32L), map3);
        MutableLongLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableLongLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 2L, 1L, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 2L, 1L, 2L), map1);
        MutableLongLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 1L, 1L, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 2L, 1L, 2L), map2);
        MutableLongLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33L, 0L, incrementFunction));
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(33L, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableLongLongMap mutableLongLongMap = this.classUnderTest();
        LongSet frozenSet = mutableLongLongMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongLongMap.put((long) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongLongMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongLongMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongLongMap mutableLongLongMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongLongMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongLongMapForClear.keySet().toArray());
        mutableLongLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongLongMap map = this.newWithKeysValues(0L, 0L, 1L, 1L, 31L, 31L, 32L, 32L);
        MutableLongLongMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(0L, 0L, 1L, 1L, 31L, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableLongLongMap map = this.newWithKeysValues(0L, 0L, 1L, 1L, 31L, 31L, 32L, 32L);
        MutableLongLongMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L, 31L, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableLongLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, 1L), hashMap);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableLongLongMap emptyMap = this.getEmptyMap();
        MutableLongLongMap partialMap = this.newWithKeysValues(1L, 1L, 3L, 3L);
        MutableLongLongMap completeMap = this.newWithKeysValues(1L, 1L, 2L, 2L, 3L, 3L, 4L, 4L);
        Iterable<LongLongPair> emptyIterable = Iterables.iList();
        Iterable<LongLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(3L, 3L));
        Iterable<LongLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, 1L), PrimitiveTuples.pair(2L, 2L), PrimitiveTuples.pair(3L, 3L), PrimitiveTuples.pair(4L, 4L));
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
        Verify.assertInstanceOf(SynchronizedLongLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableLongLongMap mutableMap = this.classUnderTest();
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
        MutableLongLongMap map = this.newWithKeysValues(1L, 2L, 2L, 3L, 3L, 4L, 4L, 5L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(2L, 1L, 3L, 2L, 4L, 3L, 5L, 4L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1L, 2L, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableLongLongMap map = this.newWithKeysValues(1L, 2L, 2L, 3L, 3L, 4L, 4L, 5L);
        MutableLongLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableLongLongMap map = this.newWithKeysValues(1L, 2L, 2L, 3L, 3L, 4L, 4L, 5L);
        LongSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongLongMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableLongLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableLongLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableLongLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableLongLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableLongLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableLongLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableLongLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableLongLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableLongLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableLongLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableLongLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableLongLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableLongLongMapTestCase::select;
            this.payloads.reject = AbstractMutableLongLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableLongLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableLongLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableLongLongMapTestCase::collect;
            this.payloads.count = AbstractMutableLongLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableLongLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableLongLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableLongLongMapTestCase::max;
            this.payloads.min = AbstractMutableLongLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongLongMapTestCase::sum;
            this.payloads.average = AbstractMutableLongLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableLongLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableLongLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableLongLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableLongLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableLongLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableLongLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableLongLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableLongLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableLongLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableLongLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableLongLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableLongLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableLongLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableLongLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableLongLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableLongLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableLongLongMapTestCase::contains;
            this.payloads.size = AbstractMutableLongLongMapTestCase::size;
            this.payloads.clear = AbstractMutableLongLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableLongLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableLongLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableLongLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableLongLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableLongLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableLongLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableLongLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableLongLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableLongLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableLongLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableLongLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableLongLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableLongLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableLongLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableLongLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableLongLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableLongLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableLongLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableLongLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableLongLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableLongLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableLongLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableLongLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableLongLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableLongLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableLongLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableLongLongMapTestCase::serializeKeySet;
        }
    }
}
