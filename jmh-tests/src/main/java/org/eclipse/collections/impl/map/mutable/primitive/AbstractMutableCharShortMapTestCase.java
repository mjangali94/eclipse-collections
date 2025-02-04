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
import org.eclipse.collections.api.block.function.primitive.CharToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableCharShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharShortMapTestCase extends AbstractCharShortMapTestCase {

    @Override
    protected abstract MutableCharShortMap classUnderTest();

    @Override
    protected abstract MutableCharShortMap newWithKeysValues(char key1, short value1);

    @Override
    protected abstract MutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2);

    @Override
    protected abstract MutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3);

    @Override
    protected abstract MutableCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3, char key4, short value4);

    @Override
    protected abstract MutableCharShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableCharShortMap map1 = this.classUnderTest();
        map1.put((char) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.get((char) 0));
        map1.put((char) 0, (short) 0);
        Assert.assertEquals((short) 0, map1.get((char) 0));
        map1.put((char) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.get((char) 5));
        map1.put((char) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableCharShortMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((char) 0));
        map1.put((char) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((char) 1));
        map1.put((char) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow((char) 5));
        map1.put((char) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableCharShortMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals((short) 5, map1.getIfAbsent((char) 0, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent((char) 1, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent((char) 33, (short) 6));
        map1.put((char) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((char) 0, (short) 5));
        map1.put((char) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((char) 1, (short) 5));
        map1.put((char) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent((char) 5, (short) 6));
        map1.put((char) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent((char) 35, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableCharShortMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals((short) 0, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals((short) 0, map1.get((char) 0));
        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals((short) 0, map1.get((char) 1));
        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals((short) 0, map1.get((char) 31));
        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals((short) 0, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableCharShortMap map1 = this.classUnderTest();
        map1.put((char) 35, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableCharShortMap map1 = this.classUnderTest();
        map1.put((char) 35, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharShortMap hashMap1 = this.newWithKeysValues((char) 1, (short) 1, (char) 0, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharShortMap hashMap = this.newWithKeysValues((char) 6, (short) 6, (char) 5, (short) 5);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharShortHashMap hashMap = new CharShortHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharShortHashMap(), map1);
        map1.put((char) 1, (short) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new CharShortHashMap(), map1);
        map1.put((char) 33, (short) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new CharShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableCharShortMap map0 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharShortHashMap(), map0);
        MutableCharShortMap map1 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharShortHashMap(), map1);
        MutableCharShortMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 31, (short) 31, (char) 32, (short) 32), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 32), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharShortHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableCharShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableCharShortMap map0 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
        map0.remove((char) 1);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharShortHashMap(), map0);
        MutableCharShortMap map1 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
        map1.remove((char) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharShortHashMap(), map1);
        MutableCharShortMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 31, (short) 31, (char) 32, (short) 32), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 32), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharShortHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableCharShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableCharShortMap map0 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent((char) 1, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent((char) 0, (short) 100));
        Assert.assertEquals(new CharShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((char) 1, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((char) 0, (short) 100));
        MutableCharShortMap map1 = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent((char) 0, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent((char) 1, (short) 100));
        Assert.assertEquals(new CharShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((char) 0, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((char) 1, (short) 100));
        MutableCharShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((char) 5, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((char) 50, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent((char) 0, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 31, (short) 31, (char) 32, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent((char) 31, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent((char) 32, (short) 100));
        Assert.assertEquals(new CharShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((char) 0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((char) 31, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((char) 32, (short) 100));
        Assert.assertEquals(new CharShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableCharShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableCharShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableCharShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableCharShortMap map1 = this.classUnderTest();
        map1.put((char) 0, (short) 1);
        map1.put((char) 31, (short) 32);
        map1.put((char) 32, (short) 33);
        CharShortHashMap expected = CharShortHashMap.newWithKeysValues((char) 0, (short) 1, (char) 31, (short) 32, (char) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put((char) 1, (short) 2);
        expected.put((char) 1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put((char) 33, (short) 34);
        expected.put((char) 33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put((char) 30, (short) 31);
        expected.put((char) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableCharShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((char) 0, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut((char) 0, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut((char) 0, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut((char) 10, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut((char) 10, (short) 25, (short) 30));
        map1.removeKey((char) 10);
        Assert.assertEquals(101, map1.getAndPut((char) 10, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut((char) 10, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableCharShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, (short) 1));
        map1.putPair(PrimitiveTuples.pair((char) 31, (short) 32));
        map1.putPair(PrimitiveTuples.pair((char) 32, (short) 33));
        CharShortHashMap expected = CharShortHashMap.newWithKeysValues((char) 0, (short) 1, (char) 31, (short) 32, (char) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 1, (short) 2));
        expected.put((char) 1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 33, (short) 34));
        expected.put((char) 33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 30, (short) 31));
        expected.put((char) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableCharShortMap map1 = this.newWithKeysValues((char) 0, (short) 11, (char) 1, (short) 12, (char) 2, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableCharShortMap expected1 = this.newWithKeysValues((char) 0, (short) 11, (char) 1, (short) 12, (char) 2, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableCharShortMap map2 = this.newWithKeysValues((char) 0, (short) 11, (char) 1, (short) 12, (char) 2, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableCharShortMap expected2 = this.newWithKeysValues((char) 0, (short) 12, (char) 1, (short) 13, (char) 2, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableCharShortMap map3 = this.newWithKeysValues((char) 0, (short) 11, (char) 1, (short) 12, (char) 2, (short) 13);
        map3.updateValues((k, v) -> k == (char) 0 ? (short) 10 : v);
        MutableCharShortMap expected3 = this.newWithKeysValues((char) 0, (short) 10, (char) 1, (short) 12, (char) 2, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableCharShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, (short) 1));
        Assert.assertEquals(32L, map1.addToValue((char) 31, (short) 32));
        Assert.assertEquals(3L, map1.addToValue((char) 1, (short) 3));
        Assert.assertEquals(11L, map1.addToValue((char) 0, (short) 10));
        Assert.assertEquals(12L, map1.addToValue((char) 1, (short) 9));
        Assert.assertEquals(37L, map1.addToValue((char) 31, (short) 5));
        Assert.assertEquals(33L, map1.addToValue((char) 32, (short) 33));
        CharShortHashMap expected = CharShortHashMap.newWithKeysValues((char) 0, (short) 11, (char) 1, (short) 12, (char) 31, (short) 37, (char) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, (short) 5));
        Assert.assertEquals(37L, map1.addToValue((char) 31, (short) 32));
        Assert.assertEquals(33L, map1.addToValue((char) 32, (short) 33));
        Assert.assertEquals(3L, map1.addToValue((char) 1, (short) 3));
        Assert.assertEquals(1L, map1.addToValue((char) 0, (short) 1));
        Assert.assertEquals(12L, map1.addToValue((char) 1, (short) 9));
        Assert.assertEquals(11L, map1.addToValue((char) 0, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableCharShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            char k = (char) each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        CharShortHashMap hashMap = new CharShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((char) i));
            hashMap.put((char) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals((short) 0, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharShortMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharShortMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharShortMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharShortMapTestCase.generateCollisions().get(3);
        MutableCharShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableCharShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableCharShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 50, (char) 1, (short) 50), map1);
        MutableCharShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 50, (char) 1, (short) 50), map2);
        MutableCharShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 50), map3);
        MutableCharShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, (short) 100));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 100, (char) 1, (short) 100), map1);
        MutableCharShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 100, (char) 1, (short) 100), map2);
        MutableCharShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 100), map3);
        MutableCharShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 9, (char) 1, (short) 9), map1);
        MutableCharShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 9, (char) 1, (short) 9), map2);
        MutableCharShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 9), map3);
        MutableCharShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToShortFunction function = (char charParameter) -> (short) charParameter;
        CharToShortFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1), map1);
        MutableCharShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1), map2);
        MutableCharShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 32, (short) 32), map3);
        MutableCharShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableCharShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 2, (char) 1, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 2, (char) 1, (short) 2), map1);
        MutableCharShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 1, (char) 1, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 2, (char) 1, (short) 2), map2);
        MutableCharShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, (short) 0, incrementFunction));
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 33, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableCharShortMap mutableCharShortMap = this.classUnderTest();
        CharSet frozenSet = mutableCharShortMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharShortMap.put((char) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharShortMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharShortMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharShortMap mutableCharShortMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharShortMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharShortMapForClear.keySet().toArray());
        mutableCharShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharShortMap map = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1, (char) 31, (short) 31, (char) 32, (short) 32);
        MutableCharShortMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1, (char) 31, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharShortMap map = this.newWithKeysValues((char) 0, (short) 0, (char) 1, (short) 1, (char) 31, (short) 31, (char) 32, (short) 32);
        MutableCharShortMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1, (char) 31, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, (short) 1), hashMap);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharShortMap emptyMap = this.getEmptyMap();
        MutableCharShortMap partialMap = this.newWithKeysValues((char) 1, (short) 1, (char) 3, (short) 3);
        MutableCharShortMap completeMap = this.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);
        Iterable<CharShortPair> emptyIterable = Iterables.iList();
        Iterable<CharShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, (short) 1), PrimitiveTuples.pair((char) 3, (short) 3));
        Iterable<CharShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, (short) 1), PrimitiveTuples.pair((char) 2, (short) 2), PrimitiveTuples.pair((char) 3, (short) 3), PrimitiveTuples.pair((char) 4, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedCharShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableCharShortMap mutableMap = this.classUnderTest();
        MutableShortIterator iterator = mutableMap.shortIterator();
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
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableCharShortMap map = this.newWithKeysValues((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4, (short) 5);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 2, (char) 1, (short) 3, (char) 2, (short) 4, (char) 3, (short) 5, (char) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableCharShortMap map = this.newWithKeysValues((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4, (short) 5);
        MutableCharShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableCharShortMap map = this.newWithKeysValues((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4, (short) 5);
        CharSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharShortMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharShortMapTestCase::values;
            this.payloads.containsAll = AbstractMutableCharShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableCharShortMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableCharShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharShortMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableCharShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharShortMapTestCase::select;
            this.payloads.reject = AbstractMutableCharShortMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharShortMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharShortMapTestCase::collect;
            this.payloads.count = AbstractMutableCharShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableCharShortMapTestCase::max;
            this.payloads.min = AbstractMutableCharShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharShortMapTestCase::sum;
            this.payloads.average = AbstractMutableCharShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableCharShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableCharShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractMutableCharShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractMutableCharShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableCharShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableCharShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableCharShortMapTestCase::chunk;
            this.payloads.get = AbstractMutableCharShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableCharShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableCharShortMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharShortMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharShortMapTestCase::contains;
            this.payloads.size = AbstractMutableCharShortMapTestCase::size;
            this.payloads.clear = AbstractMutableCharShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharShortMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharShortMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharShortMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableCharShortMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableCharShortMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableCharShortMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableCharShortMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableCharShortMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableCharShortMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharShortMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableCharShortMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharShortMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharShortMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharShortMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharShortMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharShortMapTestCase::asUnmodifiable;
            this.payloads.shortIterator_with_remove = AbstractMutableCharShortMapTestCase::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharShortMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharShortMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableCharShortMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableCharShortMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableCharShortMapTestCase::serializeKeySet;
        }
    }
}
