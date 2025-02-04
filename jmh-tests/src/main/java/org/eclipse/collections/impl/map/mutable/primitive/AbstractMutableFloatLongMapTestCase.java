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
import org.eclipse.collections.api.block.function.primitive.FloatToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatLongMapTestCase extends AbstractFloatLongMapTestCase {

    @Override
    protected abstract MutableFloatLongMap classUnderTest();

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1);

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2);

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3);

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4);

    @Override
    protected abstract MutableFloatLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.put(0.0f, 1L);
        Assert.assertEquals(1L, map1.get(0.0f));
        map1.put(0.0f, 0L);
        Assert.assertEquals(0L, map1.get(0.0f));
        map1.put(5.0f, 5L);
        Assert.assertEquals(5L, map1.get(5.0f));
        map1.put(35.0f, 35L);
        Assert.assertEquals(35L, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0.0f));
        map1.put(1.0f, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1.0f));
        map1.put(5.0f, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5.0f));
        map1.put(35.0f, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5L, map1.getIfAbsent(0.0f, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent(1.0f, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33.0f, 6L));
        map1.put(0.0f, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0.0f, 5L));
        map1.put(1.0f, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1.0f, 5L));
        map1.put(5.0f, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5.0f, 6L));
        map1.put(35.0f, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35.0f, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0L, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0L, map1.get(0.0f));
        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0L, map1.get(1.0f));
        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0L, map1.get(31.0f));
        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0L, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.put(35.0f, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.put(35.0f, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableFloatLongMap hashMap1 = this.newWithKeysValues(1.0f, 1L, 0.0f, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatLongMap hashMap = this.newWithKeysValues(6.0f, 6L, 5.0f, 5L);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatLongHashMap hashMap = new FloatLongHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatLongHashMap(), map1);
        map1.put(1.0f, 0L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 0L), map1);
        map1.clear();
        Assert.assertEquals(new FloatLongHashMap(), map1);
        map1.put(33.0f, 0L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 0L), map1);
        map1.clear();
        Assert.assertEquals(new FloatLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableFloatLongMap map0 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatLongHashMap(), map0);
        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatLongHashMap(), map1);
        MutableFloatLongMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(31.0f, 31L, 32.0f, 32L), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableFloatLongMap map0 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map0.remove(1.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatLongHashMap(), map0);
        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map1.remove(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatLongHashMap(), map1);
        MutableFloatLongMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(31.0f, 31L, 32.0f, 32L), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableFloatLongMap map0 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1.0f, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0.0f, 100L));
        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1.0f, 100L));
        MutableFloatLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5.0f, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(31.0f, 31L, 32.0f, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31.0f, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.put(0.0f, 1L);
        map1.put(31.0f, 32L);
        map1.put(32.0f, 33L);
        FloatLongHashMap expected = FloatLongHashMap.newWithKeysValues(0.0f, 1L, 31.0f, 32L, 32.0f, 33L);
        Assert.assertEquals(expected, map1);
        map1.put(1.0f, 2L);
        expected.put(1.0f, 2L);
        Assert.assertEquals(expected, map1);
        map1.put(33.0f, 34L);
        expected.put(33.0f, 34L);
        Assert.assertEquals(expected, map1);
        map1.put(30.0f, 31L);
        expected.put(30.0f, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableFloatLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0f, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut(0.0f, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut(0.0f, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut(10.0f, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut(10.0f, 25L, 30L));
        map1.removeKey(10.0f);
        Assert.assertEquals(101, map1.getAndPut(10.0f, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut(10.0f, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1L));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32L));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33L));
        FloatLongHashMap expected = FloatLongHashMap.newWithKeysValues(0.0f, 1L, 31.0f, 32L, 32.0f, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0f, 2L));
        expected.put(1.0f, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0f, 34L));
        expected.put(33.0f, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0f, 31L));
        expected.put(30.0f, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 11L, 1.0f, 12L, 2.0f, 13L);
        map1.updateValues((k, v) -> v);
        MutableFloatLongMap expected1 = this.newWithKeysValues(0.0f, 11L, 1.0f, 12L, 2.0f, 13L);
        Assert.assertEquals(expected1, map1);
        MutableFloatLongMap map2 = this.newWithKeysValues(0.0f, 11L, 1.0f, 12L, 2.0f, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableFloatLongMap expected2 = this.newWithKeysValues(0.0f, 12L, 1.0f, 13L, 2.0f, 14L);
        Assert.assertEquals(expected2, map2);
        MutableFloatLongMap map3 = this.newWithKeysValues(0.0f, 11L, 1.0f, 12L, 2.0f, 13L);
        map3.updateValues((k, v) -> k == 0.0f ? 10L : v);
        MutableFloatLongMap expected3 = this.newWithKeysValues(0.0f, 10L, 1.0f, 12L, 2.0f, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, 1L));
        Assert.assertEquals(32L, map1.addToValue(31.0f, 32L));
        Assert.assertEquals(3L, map1.addToValue(1.0f, 3L));
        Assert.assertEquals(11L, map1.addToValue(0.0f, 10L));
        Assert.assertEquals(12L, map1.addToValue(1.0f, 9L));
        Assert.assertEquals(37L, map1.addToValue(31.0f, 5L));
        Assert.assertEquals(33L, map1.addToValue(32.0f, 33L));
        FloatLongHashMap expected = FloatLongHashMap.newWithKeysValues(0.0f, 11L, 1.0f, 12L, 31.0f, 37L, 32.0f, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, 5L));
        Assert.assertEquals(37L, map1.addToValue(31.0f, 32L));
        Assert.assertEquals(33L, map1.addToValue(32.0f, 33L));
        Assert.assertEquals(3L, map1.addToValue(1.0f, 3L));
        Assert.assertEquals(1L, map1.addToValue(0.0f, 1L));
        Assert.assertEquals(12L, map1.addToValue(1.0f, 9L));
        Assert.assertEquals(11L, map1.addToValue(0.0f, 10L));
        Assert.assertEquals(expected, map1);
        MutableFloatLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            float k = each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        FloatLongHashMap hashMap = new FloatLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((float) i));
            hashMap.put((float) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals(0L, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatLongMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatLongMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatLongMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatLongMapTestCase.generateCollisions().get(3);
        MutableFloatLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableFloatLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableFloatLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 50L, 1.0f, 50L), map1);
        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 50L, 1.0f, 50L), map2);
        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 50L), map3);
        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 100L, 1.0f, 100L), map1);
        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 100L, 1.0f, 100L), map2);
        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 100L), map3);
        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 9L, 1.0f, 9L), map1);
        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 9L, 1.0f, 9L), map2);
        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 9L), map3);
        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToLongFunction function = (float floatParameter) -> (long) floatParameter;
        FloatToLongFunction functionThrows = (float floatParameter) -> {
            throw new AssertionError();
        };
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 1.0f, 1L), map1);
        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 1.0f, 1L), map2);
        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map3);
        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L, 1.0f, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L, 1.0f, 2L), map1);
        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 1L, 1.0f, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L, 1.0f, 2L), map2);
        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableFloatLongMap mutableFloatLongMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatLongMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatLongMap.put((float) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatLongMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatLongMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatLongMap mutableFloatLongMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatLongMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatLongMapForClear.keySet().toArray());
        mutableFloatLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatLongMap map = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 31.0f, 31L, 32.0f, 32L);
        MutableFloatLongMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 31.0f, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatLongMap map = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 31.0f, 31L, 32.0f, 32L);
        MutableFloatLongMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L, 31.0f, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableFloatLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1L), hashMap);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatLongMap emptyMap = this.getEmptyMap();
        MutableFloatLongMap partialMap = this.newWithKeysValues(1.0f, 1L, 3.0f, 3L);
        MutableFloatLongMap completeMap = this.newWithKeysValues(1.0f, 1L, 2.0f, 2L, 3.0f, 3L, 4.0f, 4L);
        Iterable<FloatLongPair> emptyIterable = Iterables.iList();
        Iterable<FloatLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1L), PrimitiveTuples.pair(3.0f, 3L));
        Iterable<FloatLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, 1L), PrimitiveTuples.pair(2.0f, 2L), PrimitiveTuples.pair(3.0f, 3L), PrimitiveTuples.pair(4.0f, 4L));
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
        Verify.assertInstanceOf(SynchronizedFloatLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableFloatLongMap mutableMap = this.classUnderTest();
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
        MutableFloatLongMap map = this.newWithKeysValues(1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f, 5L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(2L, 1.0f, 3L, 2.0f, 4L, 3.0f, 5L, 4.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1L, 2.0f, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableFloatLongMap map = this.newWithKeysValues(1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f, 5L);
        MutableFloatLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableFloatLongMap map = this.newWithKeysValues(1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f, 5L);
        FloatSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatLongMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableFloatLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableFloatLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableFloatLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableFloatLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableFloatLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableFloatLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableFloatLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableFloatLongMapTestCase::select;
            this.payloads.reject = AbstractMutableFloatLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableFloatLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableFloatLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableFloatLongMapTestCase::collect;
            this.payloads.count = AbstractMutableFloatLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableFloatLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableFloatLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableFloatLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableFloatLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableFloatLongMapTestCase::max;
            this.payloads.min = AbstractMutableFloatLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableFloatLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableFloatLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableFloatLongMapTestCase::sum;
            this.payloads.average = AbstractMutableFloatLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableFloatLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableFloatLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableFloatLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableFloatLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableFloatLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableFloatLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableFloatLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableFloatLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableFloatLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableFloatLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableFloatLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableFloatLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableFloatLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableFloatLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableFloatLongMapTestCase::contains;
            this.payloads.size = AbstractMutableFloatLongMapTestCase::size;
            this.payloads.clear = AbstractMutableFloatLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableFloatLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableFloatLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableFloatLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableFloatLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableFloatLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableFloatLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableFloatLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableFloatLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableFloatLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableFloatLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableFloatLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableFloatLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableFloatLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableFloatLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableFloatLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableFloatLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableFloatLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableFloatLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableFloatLongMapTestCase::serializeKeySet;
        }
    }
}
