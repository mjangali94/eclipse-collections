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
import org.eclipse.collections.api.block.function.primitive.LongToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongDoubleMapTestCase extends AbstractLongDoubleMapTestCase {

    @Override
    protected abstract MutableLongDoubleMap classUnderTest();

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1);

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2);

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3);

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3, long key4, double value4);

    @Override
    protected abstract MutableLongDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.put(0L, 1.0);
        Assert.assertEquals(1.0, map1.get(0L), 0.0);
        map1.put(0L, 0.0);
        Assert.assertEquals(0.0, map1.get(0L), 0.0);
        map1.put(5L, 5.0);
        Assert.assertEquals(5.0, map1.get(5L), 0.0);
        map1.put(35L, 35.0);
        Assert.assertEquals(35.0, map1.get(35L), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0L), 0.0);
        map1.put(1L, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1L), 0.0);
        map1.put(5L, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5L), 0.0);
        map1.put(35L, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35L), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals(5.0, map1.getIfAbsent(0L, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(1L, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33L, 6.0), 0.0);
        map1.put(0L, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0L, 5.0), 0.0);
        map1.put(1L, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1L, 5.0), 0.0);
        map1.put(5L, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5L, 6.0), 0.0);
        map1.put(35L, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35L, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0.0, map1.get(0L), 0.0);
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0.0, map1.get(0L), 0.0);
        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals(0.0, map1.get(1L), 0.0);
        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals(0.0, map1.get(31L), 0.0);
        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals(0.0, map1.get(32L), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.put(35L, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.put(35L, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey(0L);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableLongDoubleMap hashMap1 = this.newWithKeysValues(1L, 1.0, 0L, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongDoubleMap hashMap = this.newWithKeysValues(6L, 6.0, 5L, 5.0);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        for (long each = 2L; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongDoubleHashMap(), map1);
        map1.put(1L, 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new LongDoubleHashMap(), map1);
        map1.put(33L, 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new LongDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableLongDoubleMap map0 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map0.removeKey(1L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongDoubleHashMap(), map0);
        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map1.removeKey(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongDoubleHashMap(), map1);
        MutableLongDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(31L, 31.0, 32L, 32.0), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableLongDoubleMap map0 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map0.remove(1L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongDoubleHashMap(), map0);
        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map1.remove(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongDoubleHashMap(), map1);
        MutableLongDoubleMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0), map2);
        map2.remove(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(31L, 31.0, 32L, 32.0), map2);
        map2.remove(31L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableLongDoubleMap map0 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1L, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0L, 100.0), 0.0);
        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1L, 100.0), 0.0);
        MutableLongDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5L, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(31L, 31.0, 32L, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31L, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.put(0L, 1.0);
        map1.put(31L, 32.0);
        map1.put(32L, 33.0);
        LongDoubleHashMap expected = LongDoubleHashMap.newWithKeysValues(0L, 1.0, 31L, 32.0, 32L, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put(1L, 2.0);
        expected.put(1L, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put(33L, 34.0);
        expected.put(33L, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put(30L, 31.0);
        expected.put(30L, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableLongDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0L, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0L, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0L, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10L, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10L, 25.0, 30.0), 0.0);
        map1.removeKey(10L);
        Assert.assertEquals(101, map1.getAndPut(10L, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10L, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, 1.0));
        map1.putPair(PrimitiveTuples.pair(31L, 32.0));
        map1.putPair(PrimitiveTuples.pair(32L, 33.0));
        LongDoubleHashMap expected = LongDoubleHashMap.newWithKeysValues(0L, 1.0, 31L, 32.0, 32L, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1L, 2.0));
        expected.put(1L, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33L, 34.0));
        expected.put(33L, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30L, 31.0));
        expected.put(30L, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 11.0, 1L, 12.0, 2L, 13.0);
        map1.updateValues((k, v) -> v);
        MutableLongDoubleMap expected1 = this.newWithKeysValues(0L, 11.0, 1L, 12.0, 2L, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableLongDoubleMap map2 = this.newWithKeysValues(0L, 11.0, 1L, 12.0, 2L, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableLongDoubleMap expected2 = this.newWithKeysValues(0L, 12.0, 1L, 13.0, 2L, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableLongDoubleMap map3 = this.newWithKeysValues(0L, 11.0, 1L, 12.0, 2L, 13.0);
        map3.updateValues((k, v) -> k == 0L ? 10.0 : v);
        MutableLongDoubleMap expected3 = this.newWithKeysValues(0L, 10.0, 1L, 12.0, 2L, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0L, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31L, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1L, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0L, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1L, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31L, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32L, 33.0), 0.0);
        LongDoubleHashMap expected = LongDoubleHashMap.newWithKeysValues(0L, 11.0, 1L, 12.0, 31L, 37.0, 32L, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5.0, map1.addToValue(31L, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31L, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32L, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1L, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0L, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1L, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0L, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableLongDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            long k = each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((long) i), 0.0);
            hashMap.put((long) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((long) i), 0.0);
            hashMap.remove((long) i);
            Assert.assertEquals(0.0, hashMap.get((long) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongDoubleMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongDoubleMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongDoubleMapTestCase.generateCollisions().get(3);
        MutableLongDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableLongDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableLongDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0L, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1L, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 50.0, 1L, 50.0), map1);
        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1L, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0L, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 50.0, 1L, 50.0), map2);
        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32L, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 50.0), map3);
        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33L, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0L, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1L, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 100.0, 1L, 100.0), map1);
        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1L, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0L, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 100.0, 1L, 100.0), map2);
        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32L, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 100.0), map3);
        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33L, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 9.0, 1L, 9.0), map1);
        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 9.0, 1L, 9.0), map2);
        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 9.0), map3);
        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToDoubleFunction function = (long longParameter) -> (double) longParameter;
        LongToDoubleFunction functionThrows = (long longParameter) -> {
            throw new AssertionError();
        };
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0L, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1L, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 1L, 1.0), map1);
        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1L, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0L, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 1L, 1.0), map2);
        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32L, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map3);
        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33L, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0, 1L, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0, 1L, 2.0), map1);
        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 1.0, 1L, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0, 1L, 2.0), map2);
        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableLongDoubleMap mutableLongDoubleMap = this.classUnderTest();
        LongSet frozenSet = mutableLongDoubleMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongDoubleMap.put((long) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongDoubleMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongDoubleMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongDoubleMap mutableLongDoubleMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongDoubleMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongDoubleMapForClear.keySet().toArray());
        mutableLongDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongDoubleMap map = this.newWithKeysValues(0L, 0.0, 1L, 1.0, 31L, 31.0, 32L, 32.0);
        MutableLongDoubleMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 1L, 1.0, 31L, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableLongDoubleMap map = this.newWithKeysValues(0L, 0.0, 1L, 1.0, 31L, 31.0, 32L, 32.0);
        MutableLongDoubleMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 31L, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableLongDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, 1.0), hashMap);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableLongDoubleMap emptyMap = this.getEmptyMap();
        MutableLongDoubleMap partialMap = this.newWithKeysValues(1L, 1.0, 3L, 3.0);
        MutableLongDoubleMap completeMap = this.newWithKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0);
        Iterable<LongDoublePair> emptyIterable = Iterables.iList();
        Iterable<LongDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, 1.0), PrimitiveTuples.pair(3L, 3.0));
        Iterable<LongDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, 1.0), PrimitiveTuples.pair(2L, 2.0), PrimitiveTuples.pair(3L, 3.0), PrimitiveTuples.pair(4L, 4.0));
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
        Verify.assertInstanceOf(SynchronizedLongDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableLongDoubleMap mutableMap = this.classUnderTest();
        MutableDoubleIterator iterator = mutableMap.doubleIterator();
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
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableLongDoubleMap map = this.newWithKeysValues(1L, 2.0, 2L, 3.0, 3L, 4.0, 4L, 5.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(2.0, 1L, 3.0, 2L, 4.0, 3L, 5.0, 4L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, 1.0, 2L, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableLongDoubleMap map = this.newWithKeysValues(1L, 2.0, 2L, 3.0, 3L, 4.0, 4L, 5.0);
        MutableLongDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableLongDoubleMap map = this.newWithKeysValues(1L, 2.0, 2L, 3.0, 3L, 4.0, 4L, 5.0);
        LongSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongDoubleMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableLongDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableLongDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableLongDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableLongDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableLongDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableLongDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableLongDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableLongDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableLongDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableLongDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableLongDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableLongDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableLongDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableLongDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableLongDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableLongDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableLongDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableLongDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableLongDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableLongDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableLongDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableLongDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableLongDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableLongDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableLongDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableLongDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableLongDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableLongDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableLongDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableLongDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableLongDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableLongDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableLongDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableLongDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableLongDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableLongDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableLongDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableLongDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableLongDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableLongDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableLongDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableLongDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableLongDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableLongDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableLongDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableLongDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableLongDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableLongDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableLongDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableLongDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableLongDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableLongDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableLongDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableLongDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableLongDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableLongDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableLongDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableLongDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableLongDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableLongDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableLongDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableLongDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableLongDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableLongDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableLongDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableLongDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableLongDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableLongDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableLongDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableLongDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableLongDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableLongDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableLongDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableLongDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableLongDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableLongDoubleMapTestCase::serializeKeySet;
        }
    }
}
