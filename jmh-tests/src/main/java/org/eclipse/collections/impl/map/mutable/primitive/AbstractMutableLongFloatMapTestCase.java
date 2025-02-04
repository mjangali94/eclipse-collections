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
import org.eclipse.collections.api.block.function.primitive.LongToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableLongFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongFloatMapTestCase extends AbstractLongFloatMapTestCase {

    @Override
    protected abstract MutableLongFloatMap classUnderTest();

    @Override
    protected abstract MutableLongFloatMap newWithKeysValues(long key1, float value1);

    @Override
    protected abstract MutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2);

    @Override
    protected abstract MutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3);

    @Override
    protected abstract MutableLongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4);

    @Override
    protected abstract MutableLongFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.put(0L, 1.0f);
        Assert.assertEquals(1.0f, map1.get(0L), 0.0);
        map1.put(0L, 0.0f);
        Assert.assertEquals(0.0f, map1.get(0L), 0.0);
        map1.put(5L, 5.0f);
        Assert.assertEquals(5.0f, map1.get(5L), 0.0);
        map1.put(35L, 35.0f);
        Assert.assertEquals(35.0f, map1.get(35L), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(0L), 0.0);
        map1.put(1L, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(1L), 0.0);
        map1.put(5L, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow(5L), 0.0);
        map1.put(35L, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow(35L), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals(5.0f, map1.getIfAbsent(0L, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(1L, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(33L, 6.0f), 0.0);
        map1.put(0L, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(0L, 5.0f), 0.0);
        map1.put(1L, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(1L, 5.0f), 0.0);
        map1.put(5L, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(5L, 6.0f), 0.0);
        map1.put(35L, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent(35L, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0.0f, map1.get(0L), 0.0);
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0.0f, map1.get(0L), 0.0);
        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals(0.0f, map1.get(1L), 0.0);
        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals(0.0f, map1.get(31L), 0.0);
        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals(0.0f, map1.get(32L), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.put(35L, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.put(35L, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey(0L);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableLongFloatMap hashMap1 = this.newWithKeysValues(1L, 1.0f, 0L, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongFloatMap hashMap = this.newWithKeysValues(6L, 6.0f, 5L, 5.0f);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongFloatHashMap hashMap = new LongFloatHashMap();
        for (long each = 2L; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongFloatHashMap(), map1);
        map1.put(1L, 0.0f);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new LongFloatHashMap(), map1);
        map1.put(33L, 0.0f);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new LongFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableLongFloatMap map0 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
        map0.removeKey(1L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongFloatHashMap(), map0);
        MutableLongFloatMap map1 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
        map1.removeKey(0L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongFloatHashMap(), map1);
        MutableLongFloatMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(31L, 31.0f, 32L, 32.0f), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 32.0f), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongFloatHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableLongFloatMap map0 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
        map0.remove(1L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongFloatHashMap(), map0);
        MutableLongFloatMap map1 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
        map1.remove(0L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongFloatHashMap(), map1);
        MutableLongFloatMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f), map2);
        map2.remove(0L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(31L, 31.0f, 32L, 32.0f), map2);
        map2.remove(31L);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 32.0f), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongFloatHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableLongFloatMap map0 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent(1L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent(0L, 100.0f), 0.0);
        Assert.assertEquals(new LongFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(1L, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(0L, 100.0f), 0.0);
        MutableLongFloatMap map1 = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent(0L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent(1L, 100.0f), 0.0);
        Assert.assertEquals(new LongFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(0L, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(1L, 100.0f), 0.0);
        MutableLongFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(5L, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(50L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent(0L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(31L, 31.0f, 32L, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent(31L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent(32L, 100.0f), 0.0);
        Assert.assertEquals(new LongFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(0L, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(31L, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(32L, 100.0f), 0.0);
        Assert.assertEquals(new LongFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.put(0L, 1.0f);
        map1.put(31L, 32.0f);
        map1.put(32L, 33.0f);
        LongFloatHashMap expected = LongFloatHashMap.newWithKeysValues(0L, 1.0f, 31L, 32.0f, 32L, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put(1L, 2.0f);
        expected.put(1L, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put(33L, 34.0f);
        expected.put(33L, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put(30L, 31.0f);
        expected.put(30L, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableLongFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0L, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0L, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0L, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10L, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10L, 25.0f, 30.0f), 0.0);
        map1.removeKey(10L);
        Assert.assertEquals(101, map1.getAndPut(10L, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10L, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableLongFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, 1.0f));
        map1.putPair(PrimitiveTuples.pair(31L, 32.0f));
        map1.putPair(PrimitiveTuples.pair(32L, 33.0f));
        LongFloatHashMap expected = LongFloatHashMap.newWithKeysValues(0L, 1.0f, 31L, 32.0f, 32L, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1L, 2.0f));
        expected.put(1L, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33L, 34.0f));
        expected.put(33L, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30L, 31.0f));
        expected.put(30L, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableLongFloatMap map1 = this.newWithKeysValues(0L, 11.0f, 1L, 12.0f, 2L, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableLongFloatMap expected1 = this.newWithKeysValues(0L, 11.0f, 1L, 12.0f, 2L, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableLongFloatMap map2 = this.newWithKeysValues(0L, 11.0f, 1L, 12.0f, 2L, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableLongFloatMap expected2 = this.newWithKeysValues(0L, 12.0f, 1L, 13.0f, 2L, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableLongFloatMap map3 = this.newWithKeysValues(0L, 11.0f, 1L, 12.0f, 2L, 13.0f);
        map3.updateValues((k, v) -> k == 0L ? 10.0f : v);
        MutableLongFloatMap expected3 = this.newWithKeysValues(0L, 10.0f, 1L, 12.0f, 2L, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableLongFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0L, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31L, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1L, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0L, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1L, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31L, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32L, 33.0f), 0.0);
        LongFloatHashMap expected = LongFloatHashMap.newWithKeysValues(0L, 11.0f, 1L, 12.0f, 31L, 37.0f, 32L, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5.0, map1.addToValue(31L, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31L, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32L, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1L, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0L, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1L, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0L, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableLongFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            long k = each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        LongFloatHashMap hashMap = new LongFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((long) i), 0.0);
            hashMap.put((long) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((long) i), 0.0);
            hashMap.remove((long) i);
            Assert.assertEquals(0.0f, hashMap.get((long) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongFloatMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongFloatMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongFloatMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongFloatMapTestCase.generateCollisions().get(3);
        MutableLongFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableLongFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableLongFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableLongFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0L, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1L, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 50.0f, 1L, 50.0f), map1);
        MutableLongFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1L, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0L, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 50.0f, 1L, 50.0f), map2);
        MutableLongFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32L, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 50.0f), map3);
        MutableLongFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33L, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33L, 100.0f), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableLongFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0L, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0L, factoryThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1L, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1L, factoryThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 100.0f, 1L, 100.0f), map1);
        MutableLongFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1L, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1L, factoryThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0L, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0L, factoryThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 100.0f, 1L, 100.0f), map2);
        MutableLongFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32L, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32L, factoryThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 100.0f), map3);
        MutableLongFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33L, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33L, factoryThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableLongFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 9.0f, 1L, 9.0f), map1);
        MutableLongFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 9.0f, 1L, 9.0f), map2);
        MutableLongFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 9.0f), map3);
        MutableLongFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToFloatFunction function = (long longParameter) -> (float) longParameter;
        LongToFloatFunction functionThrows = (long longParameter) -> {
            throw new AssertionError();
        };
        MutableLongFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0L, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0L, functionThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1L, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1L, functionThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 1L, 1.0f), map1);
        MutableLongFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1L, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1L, functionThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0L, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0L, functionThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 1L, 1.0f), map2);
        MutableLongFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32L, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32L, functionThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(32L, 32.0f), map3);
        MutableLongFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33L, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33L, functionThrows), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableLongFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(0L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue(1L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 2.0f, 1L, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(1L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 2.0f, 1L, 2.0f), map1);
        MutableLongFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(1L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue(0L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 1.0f, 1L, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(0L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 2.0f, 1L, 2.0f), map2);
        MutableLongFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue(33L, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(33L, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableLongFloatMap mutableLongFloatMap = this.classUnderTest();
        LongSet frozenSet = mutableLongFloatMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongFloatMap.put((long) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongFloatMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongFloatMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongFloatMap mutableLongFloatMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongFloatMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongFloatMapForClear.keySet().toArray());
        mutableLongFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongFloatMap map = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f, 31L, 31.0f, 32L, 32.0f);
        MutableLongFloatMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(0L, 0.0f, 1L, 1.0f, 31L, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableLongFloatMap map = this.newWithKeysValues(0L, 0.0f, 1L, 1.0f, 31L, 31.0f, 32L, 32.0f);
        MutableLongFloatMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f, 31L, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableLongFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, 1.0f), hashMap);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableLongFloatMap emptyMap = this.getEmptyMap();
        MutableLongFloatMap partialMap = this.newWithKeysValues(1L, 1.0f, 3L, 3.0f);
        MutableLongFloatMap completeMap = this.newWithKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Iterable<LongFloatPair> emptyIterable = Iterables.iList();
        Iterable<LongFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, 1.0f), PrimitiveTuples.pair(3L, 3.0f));
        Iterable<LongFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, 1.0f), PrimitiveTuples.pair(2L, 2.0f), PrimitiveTuples.pair(3L, 3.0f), PrimitiveTuples.pair(4L, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedLongFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableLongFloatMap mutableMap = this.classUnderTest();
        MutableFloatIterator iterator = mutableMap.floatIterator();
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
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableLongFloatMap map = this.newWithKeysValues(1L, 2.0f, 2L, 3.0f, 3L, 4.0f, 4L, 5.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(2.0f, 1L, 3.0f, 2L, 4.0f, 3L, 5.0f, 4L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1.0f, 2L, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableLongFloatMap map = this.newWithKeysValues(1L, 2.0f, 2L, 3.0f, 3L, 4.0f, 4L, 5.0f);
        MutableLongFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableLongFloatMap map = this.newWithKeysValues(1L, 2.0f, 2L, 3.0f, 3L, 4.0f, 4L, 5.0f);
        LongSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongFloatMapTestCase instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongFloatMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableLongFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableLongFloatMapTestCase::values;
            this.payloads.containsAll = AbstractMutableLongFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableLongFloatMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableLongFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableLongFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableLongFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableLongFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableLongFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableLongFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableLongFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableLongFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableLongFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableLongFloatMapTestCase::reject;
            this.payloads.select_value = AbstractMutableLongFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableLongFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableLongFloatMapTestCase::collect;
            this.payloads.count = AbstractMutableLongFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableLongFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableLongFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableLongFloatMapTestCase::max;
            this.payloads.min = AbstractMutableLongFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongFloatMapTestCase::sum;
            this.payloads.average = AbstractMutableLongFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableLongFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableLongFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableLongFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractMutableLongFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractMutableLongFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableLongFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableLongFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableLongFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableLongFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableLongFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableLongFloatMapTestCase::chunk;
            this.payloads.get = AbstractMutableLongFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableLongFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableLongFloatMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableLongFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableLongFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableLongFloatMapTestCase::contains;
            this.payloads.size = AbstractMutableLongFloatMapTestCase::size;
            this.payloads.clear = AbstractMutableLongFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableLongFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableLongFloatMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableLongFloatMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableLongFloatMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableLongFloatMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableLongFloatMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableLongFloatMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableLongFloatMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableLongFloatMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableLongFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableLongFloatMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableLongFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableLongFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableLongFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableLongFloatMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableLongFloatMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableLongFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableLongFloatMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableLongFloatMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableLongFloatMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableLongFloatMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongFloatMapTestCase::asUnmodifiable;
            this.payloads.floatIterator_with_remove = AbstractMutableLongFloatMapTestCase::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableLongFloatMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableLongFloatMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableLongFloatMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableLongFloatMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableLongFloatMapTestCase::serializeKeySet;
        }
    }
}
