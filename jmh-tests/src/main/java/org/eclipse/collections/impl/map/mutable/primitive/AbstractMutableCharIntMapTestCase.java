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
import org.eclipse.collections.api.block.function.primitive.CharToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharIntMapTestCase extends AbstractCharIntMapTestCase {

    @Override
    protected abstract MutableCharIntMap classUnderTest();

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1);

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2);

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3);

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3, char key4, int value4);

    @Override
    protected abstract MutableCharIntMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.put((char) 0, 1);
        Assert.assertEquals(1, map1.get((char) 0));
        map1.put((char) 0, 0);
        Assert.assertEquals(0, map1.get((char) 0));
        map1.put((char) 5, 5);
        Assert.assertEquals(5, map1.get((char) 5));
        map1.put((char) 35, 35);
        Assert.assertEquals(35, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1);
        Assert.assertEquals(1, map1.getOrThrow((char) 0));
        map1.put((char) 1, 1);
        Assert.assertEquals(1, map1.getOrThrow((char) 1));
        map1.put((char) 5, 5);
        Assert.assertEquals(5, map1.getOrThrow((char) 5));
        map1.put((char) 35, 35);
        Assert.assertEquals(35, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5, map1.getIfAbsent((char) 0, 5));
        Assert.assertEquals(6, map1.getIfAbsent((char) 1, 6));
        Assert.assertEquals(6, map1.getIfAbsent((char) 33, 6));
        map1.put((char) 0, 1);
        Assert.assertEquals(1, map1.getIfAbsent((char) 0, 5));
        map1.put((char) 1, 1);
        Assert.assertEquals(1, map1.getIfAbsent((char) 1, 5));
        map1.put((char) 5, 5);
        Assert.assertEquals(5, map1.getIfAbsent((char) 5, 6));
        map1.put((char) 35, 35);
        Assert.assertEquals(35, map1.getIfAbsent((char) 35, 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0, map1.get((char) 0));
        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0, map1.get((char) 1));
        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0, map1.get((char) 31));
        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.put((char) 35, 35);
        Assert.assertTrue(map1.containsValue(35));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.put((char) 35, 35);
        Assert.assertTrue(map1.contains(35));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharIntMap hashMap1 = this.newWithKeysValues((char) 1, 1, (char) 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharIntMap hashMap = this.newWithKeysValues((char) 6, 6, (char) 5, 5);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharIntHashMap hashMap = new CharIntHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharIntHashMap(), map1);
        map1.put((char) 1, 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 0), map1);
        map1.clear();
        Assert.assertEquals(new CharIntHashMap(), map1);
        map1.put((char) 33, 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 0), map1);
        map1.clear();
        Assert.assertEquals(new CharIntHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableCharIntMap map0 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharIntHashMap(), map0);
        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharIntHashMap(), map1);
        MutableCharIntMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 31, 31, (char) 32, 32), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableCharIntMap map0 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map0.remove((char) 1);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharIntHashMap(), map0);
        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map1.remove((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharIntHashMap(), map1);
        MutableCharIntMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 31, 31, (char) 32, 32), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableCharIntMap map0 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent((char) 1, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(new CharIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent((char) 1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent((char) 0, 100));
        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent((char) 1, 100));
        Assert.assertEquals(new CharIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent((char) 1, 100));
        MutableCharIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 50, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 31, 31, (char) 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent((char) 31, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent((char) 32, 100));
        Assert.assertEquals(new CharIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 32, 100));
        Assert.assertEquals(new CharIntHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableCharIntMap map1 = this.classUnderTest();
        map1.put((char) 0, 1);
        map1.put((char) 31, 32);
        map1.put((char) 32, 33);
        CharIntHashMap expected = CharIntHashMap.newWithKeysValues((char) 0, 1, (char) 31, 32, (char) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.put((char) 1, 2);
        expected.put((char) 1, 2);
        Assert.assertEquals(expected, map1);
        map1.put((char) 33, 34);
        expected.put((char) 33, 34);
        Assert.assertEquals(expected, map1);
        map1.put((char) 30, 31);
        expected.put((char) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableCharIntMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((char) 0, 25, 50));
        Assert.assertEquals(25, map1.getAndPut((char) 0, 35, 50));
        Assert.assertEquals(35, map1.getAndPut((char) 0, 45, 55));
        Assert.assertEquals(100, map1.getAndPut((char) 10, 25, 100));
        Assert.assertEquals(25, map1.getAndPut((char) 10, 25, 30));
        map1.removeKey((char) 10);
        Assert.assertEquals(101, map1.getAndPut((char) 10, 25, 101));
        Assert.assertEquals(25, map1.getAndPut((char) 10, 27, 105));
    }

    @Test
    public void putPair() {
        MutableCharIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33));
        CharIntHashMap expected = CharIntHashMap.newWithKeysValues((char) 0, 1, (char) 31, 32, (char) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 1, 2));
        expected.put((char) 1, 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 33, 34));
        expected.put((char) 33, 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 30, 31));
        expected.put((char) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 11, (char) 1, 12, (char) 2, 13);
        map1.updateValues((k, v) -> v);
        MutableCharIntMap expected1 = this.newWithKeysValues((char) 0, 11, (char) 1, 12, (char) 2, 13);
        Assert.assertEquals(expected1, map1);
        MutableCharIntMap map2 = this.newWithKeysValues((char) 0, 11, (char) 1, 12, (char) 2, 13);
        map2.updateValues((k, v) -> v + 1);
        MutableCharIntMap expected2 = this.newWithKeysValues((char) 0, 12, (char) 1, 13, (char) 2, 14);
        Assert.assertEquals(expected2, map2);
        MutableCharIntMap map3 = this.newWithKeysValues((char) 0, 11, (char) 1, 12, (char) 2, 13);
        map3.updateValues((k, v) -> k == (char) 0 ? 10 : v);
        MutableCharIntMap expected3 = this.newWithKeysValues((char) 0, 10, (char) 1, 12, (char) 2, 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1));
        Assert.assertEquals(32L, map1.addToValue((char) 31, 32));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 5));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33));
        CharIntHashMap expected = CharIntHashMap.newWithKeysValues((char) 0, 11, (char) 1, 12, (char) 31, 37, (char) 32, 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, 5));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 32));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3));
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10));
        Assert.assertEquals(expected, map1);
        MutableCharIntMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            char k = (char) each;
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        CharIntHashMap hashMap = new CharIntHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((char) i));
            hashMap.put((char) i, i);
            Assert.assertEquals(i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals(0, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharIntMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharIntMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharIntMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharIntMapTestCase.generateCollisions().get(3);
        MutableCharIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableCharIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableCharIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 50, (char) 1, 50), map1);
        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 50, (char) 1, 50), map2);
        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 50), map3);
        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 100, (char) 1, 100), map1);
        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 100, (char) 1, 100), map2);
        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 100), map3);
        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 9, (char) 1, 9), map1);
        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 9, (char) 1, 9), map2);
        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 9), map3);
        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToIntFunction function = (char charParameter) -> (int) charParameter;
        CharToIntFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1), map1);
        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1), map2);
        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map3);
        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 33), map4);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2, (char) 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map1);
        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 1, (char) 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map2);
        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableCharIntMap mutableCharIntMap = this.classUnderTest();
        CharSet frozenSet = mutableCharIntMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharIntMap.put((char) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharIntMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharIntMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharIntMap mutableCharIntMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharIntMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharIntMapForClear.keySet().toArray());
        mutableCharIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharIntMap map = this.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 31, 31, (char) 32, 32);
        MutableCharIntMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharIntMap map = this.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 31, 31, (char) 32, 32);
        MutableCharIntMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1), hashMap);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharIntMap emptyMap = this.getEmptyMap();
        MutableCharIntMap partialMap = this.newWithKeysValues((char) 1, 1, (char) 3, 3);
        MutableCharIntMap completeMap = this.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3, (char) 4, 4);
        Iterable<CharIntPair> emptyIterable = Iterables.iList();
        Iterable<CharIntPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1), PrimitiveTuples.pair((char) 3, 3));
        Iterable<CharIntPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1), PrimitiveTuples.pair((char) 2, 2), PrimitiveTuples.pair((char) 3, 3), PrimitiveTuples.pair((char) 4, 4));
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
        Verify.assertInstanceOf(SynchronizedCharIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove() {
        MutableCharIntMap mutableMap = this.classUnderTest();
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
        MutableCharIntMap map = this.newWithKeysValues((char) 1, 2, (char) 2, 3, (char) 3, 4, (char) 4, 5);
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(2, (char) 1, 3, (char) 2, 4, (char) 3, 5, (char) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1, (char) 2, 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableCharIntMap map = this.newWithKeysValues((char) 1, 2, (char) 2, 3, (char) 3, 4, (char) 4, 5);
        MutableCharIntMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableCharIntMap map = this.newWithKeysValues((char) 1, 2, (char) 2, 3, (char) 3, 4, (char) 4, 5);
        CharSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharIntMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharIntMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharIntMapTestCase::values;
            this.payloads.containsAll = AbstractMutableCharIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableCharIntMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableCharIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharIntMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharIntMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableCharIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharIntMapTestCase::select;
            this.payloads.reject = AbstractMutableCharIntMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharIntMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharIntMapTestCase::collect;
            this.payloads.count = AbstractMutableCharIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableCharIntMapTestCase::max;
            this.payloads.min = AbstractMutableCharIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharIntMapTestCase::sum;
            this.payloads.average = AbstractMutableCharIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableCharIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableCharIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractMutableCharIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractMutableCharIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableCharIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableCharIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableCharIntMapTestCase::chunk;
            this.payloads.get = AbstractMutableCharIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableCharIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableCharIntMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharIntMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharIntMapTestCase::contains;
            this.payloads.size = AbstractMutableCharIntMapTestCase::size;
            this.payloads.clear = AbstractMutableCharIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharIntMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharIntMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharIntMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableCharIntMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableCharIntMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableCharIntMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableCharIntMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableCharIntMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableCharIntMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharIntMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableCharIntMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharIntMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharIntMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharIntMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharIntMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharIntMapTestCase::asUnmodifiable;
            this.payloads.intIterator_with_remove = AbstractMutableCharIntMapTestCase::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharIntMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharIntMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableCharIntMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableCharIntMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableCharIntMapTestCase::serializeKeySet;
        }
    }
}
