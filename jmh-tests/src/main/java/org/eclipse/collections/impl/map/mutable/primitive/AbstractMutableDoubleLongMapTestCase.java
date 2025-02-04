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
import org.eclipse.collections.api.block.function.primitive.DoubleToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleLongMapTestCase extends AbstractDoubleLongMapTestCase {

    @Override
    protected abstract MutableDoubleLongMap classUnderTest();

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1);

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2);

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3);

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3, double key4, long value4);

    @Override
    protected abstract MutableDoubleLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.put(0.0, 1L);
        Assert.assertEquals(1L, map1.get(0.0));
        map1.put(0.0, 0L);
        Assert.assertEquals(0L, map1.get(0.0));
        map1.put(5.0, 5L);
        Assert.assertEquals(5L, map1.get(5.0));
        map1.put(35.0, 35L);
        Assert.assertEquals(35L, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0.0));
        map1.put(1.0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1.0));
        map1.put(5.0, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5.0));
        map1.put(35.0, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals(5L, map1.getIfAbsent(0.0, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent(1.0, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33.0, 6L));
        map1.put(0.0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0.0, 5L));
        map1.put(1.0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1.0, 5L));
        map1.put(5.0, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5.0, 6L));
        map1.put(35.0, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35.0, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0L, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0L, map1.get(0.0));
        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals(0L, map1.get(1.0));
        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals(0L, map1.get(31.0));
        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals(0L, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.put(35.0, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.put(35.0, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleLongMap hashMap1 = this.newWithKeysValues(1.0, 1L, 0.0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleLongMap hashMap = this.newWithKeysValues(6.0, 6L, 5.0, 5L);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleLongHashMap(), map1);
        map1.put(1.0, 0L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 0L), map1);
        map1.clear();
        Assert.assertEquals(new DoubleLongHashMap(), map1);
        map1.put(33.0, 0L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 0L), map1);
        map1.clear();
        Assert.assertEquals(new DoubleLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableDoubleLongMap map0 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleLongHashMap(), map0);
        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleLongHashMap(), map1);
        MutableDoubleLongMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(31.0, 31L, 32.0, 32L), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableDoubleLongMap map0 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map0.remove(1.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleLongHashMap(), map0);
        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map1.remove(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleLongHashMap(), map1);
        MutableDoubleLongMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(31.0, 31L, 32.0, 32L), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableDoubleLongMap map0 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1.0, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0.0, 100L));
        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1.0, 100L));
        MutableDoubleLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5.0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(31.0, 31L, 32.0, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31.0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.put(0.0, 1L);
        map1.put(31.0, 32L);
        map1.put(32.0, 33L);
        DoubleLongHashMap expected = DoubleLongHashMap.newWithKeysValues(0.0, 1L, 31.0, 32L, 32.0, 33L);
        Assert.assertEquals(expected, map1);
        map1.put(1.0, 2L);
        expected.put(1.0, 2L);
        Assert.assertEquals(expected, map1);
        map1.put(33.0, 34L);
        expected.put(33.0, 34L);
        Assert.assertEquals(expected, map1);
        map1.put(30.0, 31L);
        expected.put(30.0, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableDoubleLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut(0.0, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut(0.0, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut(10.0, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut(10.0, 25L, 30L));
        map1.removeKey(10.0);
        Assert.assertEquals(101, map1.getAndPut(10.0, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut(10.0, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, 1L));
        map1.putPair(PrimitiveTuples.pair(31.0, 32L));
        map1.putPair(PrimitiveTuples.pair(32.0, 33L));
        DoubleLongHashMap expected = DoubleLongHashMap.newWithKeysValues(0.0, 1L, 31.0, 32L, 32.0, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0, 2L));
        expected.put(1.0, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0, 34L));
        expected.put(33.0, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0, 31L));
        expected.put(30.0, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 11L, 1.0, 12L, 2.0, 13L);
        map1.updateValues((k, v) -> v);
        MutableDoubleLongMap expected1 = this.newWithKeysValues(0.0, 11L, 1.0, 12L, 2.0, 13L);
        Assert.assertEquals(expected1, map1);
        MutableDoubleLongMap map2 = this.newWithKeysValues(0.0, 11L, 1.0, 12L, 2.0, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableDoubleLongMap expected2 = this.newWithKeysValues(0.0, 12L, 1.0, 13L, 2.0, 14L);
        Assert.assertEquals(expected2, map2);
        MutableDoubleLongMap map3 = this.newWithKeysValues(0.0, 11L, 1.0, 12L, 2.0, 13L);
        map3.updateValues((k, v) -> k == 0.0 ? 10L : v);
        MutableDoubleLongMap expected3 = this.newWithKeysValues(0.0, 10L, 1.0, 12L, 2.0, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, 1L));
        Assert.assertEquals(32L, map1.addToValue(31.0, 32L));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3L));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10L));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9L));
        Assert.assertEquals(37L, map1.addToValue(31.0, 5L));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33L));
        DoubleLongHashMap expected = DoubleLongHashMap.newWithKeysValues(0.0, 11L, 1.0, 12L, 31.0, 37L, 32.0, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, 5L));
        Assert.assertEquals(37L, map1.addToValue(31.0, 32L));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33L));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3L));
        Assert.assertEquals(1L, map1.addToValue(0.0, 1L));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9L));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10L));
        Assert.assertEquals(expected, map1);
        MutableDoubleLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            double k = each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((double) i));
            hashMap.put((double) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals(0L, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleLongMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleLongMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleLongMapTestCase.generateCollisions().get(3);
        MutableDoubleLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableDoubleLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableDoubleLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 50L, 1.0, 50L), map1);
        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 50L, 1.0, 50L), map2);
        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 50L), map3);
        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 100L, 1.0, 100L), map1);
        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 100L, 1.0, 100L), map2);
        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 100L), map3);
        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 9L, 1.0, 9L), map1);
        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 9L, 1.0, 9L), map2);
        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 9L), map3);
        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToLongFunction function = (double doubleParameter) -> (long) doubleParameter;
        DoubleToLongFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 1.0, 1L), map1);
        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 1.0, 1L), map2);
        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map3);
        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L, 1.0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L, 1.0, 2L), map1);
        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 1L, 1.0, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L, 1.0, 2L), map2);
        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleLongMap mutableDoubleLongMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleLongMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleLongMap.put((double) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleLongMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleLongMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleLongMap mutableDoubleLongMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleLongMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleLongMapForClear.keySet().toArray());
        mutableDoubleLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleLongMap map = this.newWithKeysValues(0.0, 0L, 1.0, 1L, 31.0, 31L, 32.0, 32L);
        MutableDoubleLongMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 1.0, 1L, 31.0, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleLongMap map = this.newWithKeysValues(0.0, 0L, 1.0, 1L, 31.0, 31L, 32.0, 32L);
        MutableDoubleLongMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 31.0, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, 1L), hashMap);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleLongMap emptyMap = this.getEmptyMap();
        MutableDoubleLongMap partialMap = this.newWithKeysValues(1.0, 1L, 3.0, 3L);
        MutableDoubleLongMap completeMap = this.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L, 4.0, 4L);
        Iterable<DoubleLongPair> emptyIterable = Iterables.iList();
        Iterable<DoubleLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1L), PrimitiveTuples.pair(3.0, 3L));
        Iterable<DoubleLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1L), PrimitiveTuples.pair(2.0, 2L), PrimitiveTuples.pair(3.0, 3L), PrimitiveTuples.pair(4.0, 4L));
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
        Verify.assertInstanceOf(SynchronizedDoubleLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableDoubleLongMap mutableMap = this.classUnderTest();
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
        MutableDoubleLongMap map = this.newWithKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(2L, 1.0, 3L, 2.0, 4L, 3.0, 5L, 4.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1L, 2.0, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableDoubleLongMap map = this.newWithKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L);
        MutableDoubleLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableDoubleLongMap map = this.newWithKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L);
        DoubleSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleLongMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableDoubleLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableDoubleLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableDoubleLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableDoubleLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleLongMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleLongMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableDoubleLongMapTestCase::max;
            this.payloads.min = AbstractMutableDoubleLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleLongMapTestCase::sum;
            this.payloads.average = AbstractMutableDoubleLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableDoubleLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableDoubleLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableDoubleLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableDoubleLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableDoubleLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableDoubleLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableDoubleLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableDoubleLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableDoubleLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableDoubleLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleLongMapTestCase::contains;
            this.payloads.size = AbstractMutableDoubleLongMapTestCase::size;
            this.payloads.clear = AbstractMutableDoubleLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableDoubleLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableDoubleLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableDoubleLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableDoubleLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableDoubleLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableDoubleLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableDoubleLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableDoubleLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableDoubleLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableDoubleLongMapTestCase::serializeKeySet;
        }
    }
*/
}
