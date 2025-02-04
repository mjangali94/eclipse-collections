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
import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharLongMapTestCase extends AbstractCharLongMapTestCase {

    @Override
    protected abstract MutableCharLongMap classUnderTest();

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1);

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2);

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3);

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4);

    @Override
    protected abstract MutableCharLongMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.put((char) 0, 1L);
        Assert.assertEquals(1L, map1.get((char) 0));
        map1.put((char) 0, 0L);
        Assert.assertEquals(0L, map1.get((char) 0));
        map1.put((char) 5, 5L);
        Assert.assertEquals(5L, map1.get((char) 5));
        map1.put((char) 35, 35L);
        Assert.assertEquals(35L, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((char) 0));
        map1.put((char) 1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((char) 1));
        map1.put((char) 5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow((char) 5));
        map1.put((char) 35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5L, map1.getIfAbsent((char) 0, 5L));
        Assert.assertEquals(6L, map1.getIfAbsent((char) 1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent((char) 33, 6L));
        map1.put((char) 0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((char) 0, 5L));
        map1.put((char) 1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((char) 1, 5L));
        map1.put((char) 5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent((char) 5, 6L));
        map1.put((char) 35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent((char) 35, 5L));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0L, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0L, map1.get((char) 0));
        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0L, map1.get((char) 1));
        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0L, map1.get((char) 31));
        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0L, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.put((char) 35, 35L);
        Assert.assertTrue(map1.containsValue(35L));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.put((char) 35, 35L);
        Assert.assertTrue(map1.contains(35L));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharLongMap hashMap1 = this.newWithKeysValues((char) 1, 1L, (char) 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharLongMap hashMap = this.newWithKeysValues((char) 6, 6L, (char) 5, 5L);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharLongHashMap hashMap = new CharLongHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharLongHashMap(), map1);
        map1.put((char) 1, 0L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new CharLongHashMap(), map1);
        map1.put((char) 33, 0L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new CharLongHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableCharLongMap map0 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharLongHashMap(), map0);
        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharLongHashMap(), map1);
        MutableCharLongMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 31, 31L, (char) 32, 32L), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableCharLongMap map0 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map0.remove((char) 1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharLongHashMap(), map0);
        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map1.remove((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharLongHashMap(), map1);
        MutableCharLongMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 31, 31L, (char) 32, 32L), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableCharLongMap map0 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent((char) 1, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(new CharLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((char) 1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((char) 0, 100L));
        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent((char) 1, 100L));
        Assert.assertEquals(new CharLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((char) 1, 100L));
        MutableCharLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 50, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 31, 31L, (char) 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent((char) 31, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent((char) 32, 100L));
        Assert.assertEquals(new CharLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 32, 100L));
        Assert.assertEquals(new CharLongHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableCharLongMap map1 = this.classUnderTest();
        map1.put((char) 0, 1L);
        map1.put((char) 31, 32L);
        map1.put((char) 32, 33L);
        CharLongHashMap expected = CharLongHashMap.newWithKeysValues((char) 0, 1L, (char) 31, 32L, (char) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.put((char) 1, 2L);
        expected.put((char) 1, 2L);
        Assert.assertEquals(expected, map1);
        map1.put((char) 33, 34L);
        expected.put((char) 33, 34L);
        Assert.assertEquals(expected, map1);
        map1.put((char) 30, 31L);
        expected.put((char) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableCharLongMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((char) 0, 25L, 50L));
        Assert.assertEquals(25, map1.getAndPut((char) 0, 35L, 50L));
        Assert.assertEquals(35, map1.getAndPut((char) 0, 45L, 55L));
        Assert.assertEquals(100, map1.getAndPut((char) 10, 25L, 100L));
        Assert.assertEquals(25, map1.getAndPut((char) 10, 25L, 30L));
        map1.removeKey((char) 10);
        Assert.assertEquals(101, map1.getAndPut((char) 10, 25L, 101L));
        Assert.assertEquals(25, map1.getAndPut((char) 10, 27L, 105L));
    }

    @Test
    public void putPair() {
        MutableCharLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1L));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32L));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33L));
        CharLongHashMap expected = CharLongHashMap.newWithKeysValues((char) 0, 1L, (char) 31, 32L, (char) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 1, 2L));
        expected.put((char) 1, 2L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 33, 34L));
        expected.put((char) 33, 34L);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 30, 31L));
        expected.put((char) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 11L, (char) 1, 12L, (char) 2, 13L);
        map1.updateValues((k, v) -> v);
        MutableCharLongMap expected1 = this.newWithKeysValues((char) 0, 11L, (char) 1, 12L, (char) 2, 13L);
        Assert.assertEquals(expected1, map1);
        MutableCharLongMap map2 = this.newWithKeysValues((char) 0, 11L, (char) 1, 12L, (char) 2, 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableCharLongMap expected2 = this.newWithKeysValues((char) 0, 12L, (char) 1, 13L, (char) 2, 14L);
        Assert.assertEquals(expected2, map2);
        MutableCharLongMap map3 = this.newWithKeysValues((char) 0, 11L, (char) 1, 12L, (char) 2, 13L);
        map3.updateValues((k, v) -> k == (char) 0 ? 10L : v);
        MutableCharLongMap expected3 = this.newWithKeysValues((char) 0, 10L, (char) 1, 12L, (char) 2, 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1L));
        Assert.assertEquals(32L, map1.addToValue((char) 31, 32L));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3L));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10L));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9L));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 5L));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33L));
        CharLongHashMap expected = CharLongHashMap.newWithKeysValues((char) 0, 11L, (char) 1, 12L, (char) 31, 37L, (char) 32, 33L);
        Assert.assertEquals(expected, map1);
        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, 5L));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 32L));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33L));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3L));
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1L));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9L));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10L));
        Assert.assertEquals(expected, map1);
        MutableCharLongMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            char k = (char) each;
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        CharLongHashMap hashMap = new CharLongHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((char) i));
            hashMap.put((char) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals(0L, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharLongMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharLongMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharLongMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharLongMapTestCase.generateCollisions().get(3);
        MutableCharLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableCharLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableCharLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 50L, (char) 1, 50L), map1);
        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 50L, (char) 1, 50L), map2);
        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 50L), map3);
        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 100L, (char) 1, 100L), map1);
        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 100L, (char) 1, 100L), map2);
        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 100L), map3);
        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 9L, (char) 1, 9L), map1);
        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 9L, (char) 1, 9L), map2);
        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 9L), map3);
        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToLongFunction function = (char charParameter) -> (long) charParameter;
        CharToLongFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L), map1);
        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L), map2);
        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map3);
        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 33L), map4);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L, (char) 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L, (char) 1, 2L), map1);
        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 1L, (char) 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L, (char) 1, 2L), map2);
        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 2L), map3);
    }

    @Test
    public void freeze() {
        MutableCharLongMap mutableCharLongMap = this.classUnderTest();
        CharSet frozenSet = mutableCharLongMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharLongMap.put((char) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharLongMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharLongMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharLongMap mutableCharLongMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharLongMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharLongMapForClear.keySet().toArray());
        mutableCharLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 31, 31L, (char) 32, 32L);
        MutableCharLongMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 31, 31L, (char) 32, 32L);
        MutableCharLongMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1L), hashMap);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharLongMap emptyMap = this.getEmptyMap();
        MutableCharLongMap partialMap = this.newWithKeysValues((char) 1, 1L, (char) 3, 3L);
        MutableCharLongMap completeMap = this.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        Iterable<CharLongPair> emptyIterable = Iterables.iList();
        Iterable<CharLongPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1L), PrimitiveTuples.pair((char) 3, 3L));
        Iterable<CharLongPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1L), PrimitiveTuples.pair((char) 2, 2L), PrimitiveTuples.pair((char) 3, 3L), PrimitiveTuples.pair((char) 4, 4L));
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
        Verify.assertInstanceOf(SynchronizedCharLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove() {
        MutableCharLongMap mutableMap = this.classUnderTest();
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
        MutableCharLongMap map = this.newWithKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(2L, (char) 1, 3L, (char) 2, 4L, (char) 3, 5L, (char) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1L, (char) 2, 1L).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableCharLongMap map = this.newWithKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L);
        MutableCharLongMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableCharLongMap map = this.newWithKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L);
        CharSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharLongMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharLongMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharLongMapTestCase::values;
            this.payloads.containsAll = AbstractMutableCharLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableCharLongMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableCharLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharLongMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharLongMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableCharLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharLongMapTestCase::select;
            this.payloads.reject = AbstractMutableCharLongMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharLongMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharLongMapTestCase::collect;
            this.payloads.count = AbstractMutableCharLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableCharLongMapTestCase::max;
            this.payloads.min = AbstractMutableCharLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharLongMapTestCase::sum;
            this.payloads.average = AbstractMutableCharLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableCharLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableCharLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractMutableCharLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractMutableCharLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableCharLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableCharLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableCharLongMapTestCase::chunk;
            this.payloads.get = AbstractMutableCharLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableCharLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableCharLongMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharLongMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharLongMapTestCase::contains;
            this.payloads.size = AbstractMutableCharLongMapTestCase::size;
            this.payloads.clear = AbstractMutableCharLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharLongMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharLongMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharLongMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableCharLongMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableCharLongMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableCharLongMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableCharLongMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableCharLongMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableCharLongMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharLongMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableCharLongMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharLongMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharLongMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharLongMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharLongMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharLongMapTestCase::asUnmodifiable;
            this.payloads.longIterator_with_remove = AbstractMutableCharLongMapTestCase::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharLongMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharLongMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableCharLongMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableCharLongMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableCharLongMapTestCase::serializeKeySet;
        }
    }
*/
}
