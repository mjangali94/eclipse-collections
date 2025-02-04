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
import org.eclipse.collections.api.block.function.primitive.ShortToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortIntMapTestCase extends AbstractShortIntMapTestCase {

    @Override
    protected abstract MutableShortIntMap classUnderTest();

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1);

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2);

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3);

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4);

    @Override
    protected abstract MutableShortIntMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.put((short) 0, 1);
        Assert.assertEquals(1, map1.get((short) 0));
        map1.put((short) 0, 0);
        Assert.assertEquals(0, map1.get((short) 0));
        map1.put((short) 5, 5);
        Assert.assertEquals(5, map1.get((short) 5));
        map1.put((short) 35, 35);
        Assert.assertEquals(35, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1);
        Assert.assertEquals(1, map1.getOrThrow((short) 0));
        map1.put((short) 1, 1);
        Assert.assertEquals(1, map1.getOrThrow((short) 1));
        map1.put((short) 5, 5);
        Assert.assertEquals(5, map1.getOrThrow((short) 5));
        map1.put((short) 35, 35);
        Assert.assertEquals(35, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5, map1.getIfAbsent((short) 0, 5));
        Assert.assertEquals(6, map1.getIfAbsent((short) 1, 6));
        Assert.assertEquals(6, map1.getIfAbsent((short) 33, 6));
        map1.put((short) 0, 1);
        Assert.assertEquals(1, map1.getIfAbsent((short) 0, 5));
        map1.put((short) 1, 1);
        Assert.assertEquals(1, map1.getIfAbsent((short) 1, 5));
        map1.put((short) 5, 5);
        Assert.assertEquals(5, map1.getIfAbsent((short) 5, 6));
        map1.put((short) 35, 35);
        Assert.assertEquals(35, map1.getIfAbsent((short) 35, 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0, map1.get((short) 0));
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0, map1.get((short) 1));
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0, map1.get((short) 31));
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.put((short) 35, 35);
        Assert.assertTrue(map1.containsValue(35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.put((short) 35, 35);
        Assert.assertTrue(map1.contains(35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortIntMap hashMap1 = this.newWithKeysValues((short) 1, 1, (short) 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortIntMap hashMap = this.newWithKeysValues((short) 6, 6, (short) 5, 5);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortIntHashMap hashMap = new ShortIntHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortIntHashMap(), map1);
        map1.put((short) 1, 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortIntHashMap(), map1);
        map1.put((short) 33, 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortIntHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortIntMap map0 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortIntHashMap(), map0);
        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortIntHashMap(), map1);
        MutableShortIntMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 31, 31, (short) 32, 32), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableShortIntMap map0 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map0.remove((short) 1);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortIntHashMap(), map0);
        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map1.remove((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortIntHashMap(), map1);
        MutableShortIntMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 31, 31, (short) 32, 32), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortIntMap map0 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent((short) 1, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(new ShortIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent((short) 1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent((short) 0, 100));
        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent((short) 1, 100));
        Assert.assertEquals(new ShortIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent((short) 1, 100));
        MutableShortIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 50, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 31, 31, (short) 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent((short) 31, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent((short) 32, 100));
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 32, 100));
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableShortIntMap map1 = this.classUnderTest();
        map1.put((short) 0, 1);
        map1.put((short) 31, 32);
        map1.put((short) 32, 33);
        ShortIntHashMap expected = ShortIntHashMap.newWithKeysValues((short) 0, 1, (short) 31, 32, (short) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, 2);
        expected.put((short) 1, 2);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, 34);
        expected.put((short) 33, 34);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, 31);
        expected.put((short) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortIntMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, 25, 50));
        Assert.assertEquals(25, map1.getAndPut((short) 0, 35, 50));
        Assert.assertEquals(35, map1.getAndPut((short) 0, 45, 55));
        Assert.assertEquals(100, map1.getAndPut((short) 10, 25, 100));
        Assert.assertEquals(25, map1.getAndPut((short) 10, 25, 30));
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, 25, 101));
        Assert.assertEquals(25, map1.getAndPut((short) 10, 27, 105));
    }

    @Test
    public void putPair() {
        MutableShortIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33));
        ShortIntHashMap expected = ShortIntHashMap.newWithKeysValues((short) 0, 1, (short) 31, 32, (short) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, 2));
        expected.put((short) 1, 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, 34));
        expected.put((short) 33, 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, 31));
        expected.put((short) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 11, (short) 1, 12, (short) 2, 13);
        map1.updateValues((k, v) -> v);
        MutableShortIntMap expected1 = this.newWithKeysValues((short) 0, 11, (short) 1, 12, (short) 2, 13);
        Assert.assertEquals(expected1, map1);
        MutableShortIntMap map2 = this.newWithKeysValues((short) 0, 11, (short) 1, 12, (short) 2, 13);
        map2.updateValues((k, v) -> v + 1);
        MutableShortIntMap expected2 = this.newWithKeysValues((short) 0, 12, (short) 1, 13, (short) 2, 14);
        Assert.assertEquals(expected2, map2);
        MutableShortIntMap map3 = this.newWithKeysValues((short) 0, 11, (short) 1, 12, (short) 2, 13);
        map3.updateValues((k, v) -> k == (short) 0 ? 10 : v);
        MutableShortIntMap expected3 = this.newWithKeysValues((short) 0, 10, (short) 1, 12, (short) 2, 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1));
        Assert.assertEquals(32L, map1.addToValue((short) 31, 32));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 5));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33));
        ShortIntHashMap expected = ShortIntHashMap.newWithKeysValues((short) 0, 11, (short) 1, 12, (short) 31, 37, (short) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, 5));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 32));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3));
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10));
        Assert.assertEquals(expected, map1);
        MutableShortIntMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ShortIntHashMap hashMap = new ShortIntHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((short) i));
            hashMap.put((short) i, i);
            Assert.assertEquals(i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals(0, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortIntMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortIntMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortIntMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortIntMapTestCase.generateCollisions().get(3);
        MutableShortIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableShortIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableShortIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 50, (short) 1, 50), map1);
        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 50, (short) 1, 50), map2);
        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 50), map3);
        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 100, (short) 1, 100), map1);
        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 100, (short) 1, 100), map2);
        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 100), map3);
        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 9, (short) 1, 9), map1);
        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 9, (short) 1, 9), map2);
        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 9), map3);
        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToIntFunction function = (short shortParameter) -> (int) shortParameter;
        ShortToIntFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 1, 1), map1);
        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 1, 1), map2);
        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map3);
        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 33), map4);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2, (short) 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map1);
        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 1, (short) 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map2);
        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableShortIntMap mutableShortIntMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortIntMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortIntMap.put((short) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortIntMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortIntMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortIntMap mutableShortIntMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortIntMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortIntMapForClear.keySet().toArray());
        mutableShortIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 31, 31, (short) 32, 32);
        MutableShortIntMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 31, 31, (short) 32, 32);
        MutableShortIntMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1), hashMap);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortIntMap emptyMap = this.getEmptyMap();
        MutableShortIntMap partialMap = this.newWithKeysValues((short) 1, 1, (short) 3, 3);
        MutableShortIntMap completeMap = this.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3, (short) 4, 4);
        Iterable<ShortIntPair> emptyIterable = Iterables.iList();
        Iterable<ShortIntPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1), PrimitiveTuples.pair((short) 3, 3));
        Iterable<ShortIntPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1), PrimitiveTuples.pair((short) 2, 2), PrimitiveTuples.pair((short) 3, 3), PrimitiveTuples.pair((short) 4, 4));
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
        Verify.assertInstanceOf(SynchronizedShortIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove() {
        MutableShortIntMap mutableMap = this.classUnderTest();
        MutableIntIterator iterator = mutableMap.intIterator();
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
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableShortIntMap map = this.newWithKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(2, (short) 1, 3, (short) 2, 4, (short) 3, 5, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1, (short) 2, 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortIntMap map = this.newWithKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5);
        MutableShortIntMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortIntMap map = this.newWithKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortIntMapTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortIntMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortIntMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortIntMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortIntMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortIntMapTestCase::select;
            this.payloads.reject = AbstractMutableShortIntMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortIntMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortIntMapTestCase::collect;
            this.payloads.count = AbstractMutableShortIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortIntMapTestCase::max;
            this.payloads.min = AbstractMutableShortIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortIntMapTestCase::sum;
            this.payloads.average = AbstractMutableShortIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractMutableShortIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractMutableShortIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortIntMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortIntMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortIntMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortIntMapTestCase::contains;
            this.payloads.size = AbstractMutableShortIntMapTestCase::size;
            this.payloads.clear = AbstractMutableShortIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortIntMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortIntMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortIntMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortIntMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortIntMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortIntMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortIntMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortIntMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortIntMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortIntMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortIntMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortIntMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortIntMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortIntMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortIntMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortIntMapTestCase::asUnmodifiable;
            this.payloads.intIterator_with_remove = AbstractMutableShortIntMapTestCase::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortIntMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortIntMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortIntMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortIntMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortIntMapTestCase::serializeKeySet;
        }
    }
}
