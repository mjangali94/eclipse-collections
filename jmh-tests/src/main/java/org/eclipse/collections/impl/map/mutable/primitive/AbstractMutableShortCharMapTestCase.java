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
import org.eclipse.collections.api.block.function.primitive.ShortToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableShortCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortCharPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortCharMapTestCase extends AbstractShortCharMapTestCase {

    @Override
    protected abstract MutableShortCharMap classUnderTest();

    @Override
    protected abstract MutableShortCharMap newWithKeysValues(short key1, char value1);

    @Override
    protected abstract MutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2);

    @Override
    protected abstract MutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3);

    @Override
    protected abstract MutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3, short key4, char value4);

    @Override
    protected abstract MutableShortCharMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortCharMap map1 = this.classUnderTest();
        map1.put((short) 0, (char) 1);
        Assert.assertEquals((char) 1, map1.get((short) 0));
        map1.put((short) 0, (char) 0);
        Assert.assertEquals((char) 0, map1.get((short) 0));
        map1.put((short) 5, (char) 5);
        Assert.assertEquals((char) 5, map1.get((short) 5));
        map1.put((short) 35, (char) 35);
        Assert.assertEquals((char) 35, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortCharMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow((short) 0));
        map1.put((short) 1, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow((short) 1));
        map1.put((short) 5, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow((short) 5));
        map1.put((short) 35, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortCharMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals((char) 5, map1.getIfAbsent((short) 0, (char) 5));
        Assert.assertEquals((char) 6, map1.getIfAbsent((short) 1, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent((short) 33, (char) 6));
        map1.put((short) 0, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent((short) 0, (char) 5));
        map1.put((short) 1, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent((short) 1, (char) 5));
        map1.put((short) 5, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent((short) 5, (char) 6));
        map1.put((short) 35, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent((short) 35, (char) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortCharMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((char) 0, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((char) 0, map1.get((short) 0));
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals((char) 0, map1.get((short) 1));
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals((char) 0, map1.get((short) 31));
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals((char) 0, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortCharMap map1 = this.classUnderTest();
        map1.put((short) 35, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortCharMap map1 = this.classUnderTest();
        map1.put((short) 35, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortCharMap hashMap1 = this.newWithKeysValues((short) 1, (char) 1, (short) 0, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortCharMap hashMap = this.newWithKeysValues((short) 6, (char) 6, (short) 5, (char) 5);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortCharHashMap hashMap = new ShortCharHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortCharHashMap(), map1);
        map1.put((short) 1, (char) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortCharHashMap(), map1);
        map1.put((short) 33, (char) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortCharHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortCharMap map0 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortCharHashMap(), map0);
        MutableShortCharMap map1 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortCharHashMap(), map1);
        MutableShortCharMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 31, (char) 31, (short) 32, (char) 32), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 32), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortCharHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableShortCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableShortCharMap map0 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
        map0.remove((short) 1);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortCharHashMap(), map0);
        MutableShortCharMap map1 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
        map1.remove((short) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortCharHashMap(), map1);
        MutableShortCharMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 31, (char) 31, (short) 32, (char) 32), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 32), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortCharHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableShortCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortCharMap map0 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent((short) 1, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent((short) 0, (char) 100));
        Assert.assertEquals(new ShortCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent((short) 1, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent((short) 0, (char) 100));
        MutableShortCharMap map1 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent((short) 0, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent((short) 1, (char) 100));
        Assert.assertEquals(new ShortCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent((short) 0, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent((short) 1, (char) 100));
        MutableShortCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((short) 5, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((short) 50, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent((short) 0, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 31, (char) 31, (short) 32, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent((short) 31, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent((short) 32, (char) 100));
        Assert.assertEquals(new ShortCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((short) 0, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((short) 31, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent((short) 32, (char) 100));
        Assert.assertEquals(new ShortCharHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableShortCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableShortCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableShortCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableShortCharMap map1 = this.classUnderTest();
        map1.put((short) 0, (char) 1);
        map1.put((short) 31, (char) 32);
        map1.put((short) 32, (char) 33);
        ShortCharHashMap expected = ShortCharHashMap.newWithKeysValues((short) 0, (char) 1, (short) 31, (char) 32, (short) 32, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, (char) 2);
        expected.put((short) 1, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, (char) 34);
        expected.put((short) 33, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, (char) 31);
        expected.put((short) 30, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortCharMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, (char) 25, (char) 50));
        Assert.assertEquals(25, map1.getAndPut((short) 0, (char) 35, (char) 50));
        Assert.assertEquals(35, map1.getAndPut((short) 0, (char) 45, (char) 55));
        Assert.assertEquals(100, map1.getAndPut((short) 10, (char) 25, (char) 100));
        Assert.assertEquals(25, map1.getAndPut((short) 10, (char) 25, (char) 30));
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, (char) 25, (char) 101));
        Assert.assertEquals(25, map1.getAndPut((short) 10, (char) 27, (char) 105));
    }

    @Test
    public void putPair() {
        MutableShortCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, (char) 1));
        map1.putPair(PrimitiveTuples.pair((short) 31, (char) 32));
        map1.putPair(PrimitiveTuples.pair((short) 32, (char) 33));
        ShortCharHashMap expected = ShortCharHashMap.newWithKeysValues((short) 0, (char) 1, (short) 31, (char) 32, (short) 32, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, (char) 2));
        expected.put((short) 1, (char) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, (char) 34));
        expected.put((short) 33, (char) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, (char) 31));
        expected.put((short) 30, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortCharMap map1 = this.newWithKeysValues((short) 0, (char) 11, (short) 1, (char) 12, (short) 2, (char) 13);
        map1.updateValues((k, v) -> v);
        MutableShortCharMap expected1 = this.newWithKeysValues((short) 0, (char) 11, (short) 1, (char) 12, (short) 2, (char) 13);
        Assert.assertEquals(expected1, map1);
        MutableShortCharMap map2 = this.newWithKeysValues((short) 0, (char) 11, (short) 1, (char) 12, (short) 2, (char) 13);
        map2.updateValues((k, v) -> (char) (v + (char) 1));
        MutableShortCharMap expected2 = this.newWithKeysValues((short) 0, (char) 12, (short) 1, (char) 13, (short) 2, (char) 14);
        Assert.assertEquals(expected2, map2);
        MutableShortCharMap map3 = this.newWithKeysValues((short) 0, (char) 11, (short) 1, (char) 12, (short) 2, (char) 13);
        map3.updateValues((k, v) -> k == (short) 0 ? (char) 10 : v);
        MutableShortCharMap expected3 = this.newWithKeysValues((short) 0, (char) 10, (short) 1, (char) 12, (short) 2, (char) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, (char) 1));
        Assert.assertEquals(32L, map1.addToValue((short) 31, (char) 32));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (char) 3));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (char) 10));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (char) 9));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (char) 5));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (char) 33));
        ShortCharHashMap expected = ShortCharHashMap.newWithKeysValues((short) 0, (char) 11, (short) 1, (char) 12, (short) 31, (char) 37, (short) 32, (char) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, (char) 5));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (char) 32));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (char) 33));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (char) 3));
        Assert.assertEquals(1L, map1.addToValue((short) 0, (char) 1));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (char) 9));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (char) 10));
        Assert.assertEquals(expected, map1);
        MutableShortCharMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ShortCharHashMap hashMap = new ShortCharHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((char) 0, hashMap.get((short) i));
            hashMap.put((short) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals((char) 0, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortCharMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortCharMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortCharMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortCharMapTestCase.generateCollisions().get(3);
        MutableShortCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);
        MutableShortCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);
        MutableShortCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 50, (short) 1, (char) 50), map1);
        MutableShortCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 50, (short) 1, (char) 50), map2);
        MutableShortCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 50), map3);
        MutableShortCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (char) 100));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 100, (short) 1, (char) 100), map1);
        MutableShortCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 100, (short) 1, (char) 100), map2);
        MutableShortCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 100), map3);
        MutableShortCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 9, (short) 1, (char) 9), map1);
        MutableShortCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 9, (short) 1, (char) 9), map2);
        MutableShortCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 9), map3);
        MutableShortCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToCharFunction function = (short shortParameter) -> (char) shortParameter;
        ShortToCharFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1), map1);
        MutableShortCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1), map2);
        MutableShortCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 32, (char) 32), map3);
        MutableShortCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 33), map4);
    }

    @Test
    public void updateValue() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        MutableShortCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 2, (short) 1, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 2, (short) 1, (char) 2), map1);
        MutableShortCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 1, (short) 1, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 2, (short) 1, (char) 2), map2);
        MutableShortCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, (char) 0, incrementFunction));
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 33, (char) 2), map3);
    }

    @Test
    public void freeze() {
        MutableShortCharMap mutableShortCharMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortCharMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortCharMap.put((short) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortCharMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortCharMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortCharMap mutableShortCharMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortCharMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortCharMapForClear.keySet().toArray());
        mutableShortCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortCharMap map = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 31, (char) 31, (short) 32, (char) 32);
        MutableShortCharMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 31, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortCharMap map = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 31, (char) 31, (short) 32, (char) 32);
        MutableShortCharMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1, (short) 31, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, (char) 1), hashMap);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortCharMap emptyMap = this.getEmptyMap();
        MutableShortCharMap partialMap = this.newWithKeysValues((short) 1, (char) 1, (short) 3, (char) 3);
        MutableShortCharMap completeMap = this.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);
        Iterable<ShortCharPair> emptyIterable = Iterables.iList();
        Iterable<ShortCharPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, (char) 1), PrimitiveTuples.pair((short) 3, (char) 3));
        Iterable<ShortCharPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, (char) 1), PrimitiveTuples.pair((short) 2, (char) 2), PrimitiveTuples.pair((short) 3, (char) 3), PrimitiveTuples.pair((short) 4, (char) 4));
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
        Verify.assertInstanceOf(SynchronizedShortCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove() {
        MutableShortCharMap mutableMap = this.classUnderTest();
        MutableCharIterator iterator = mutableMap.charIterator();
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
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues() {
        MutableShortCharMap map = this.newWithKeysValues((short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4, (char) 5);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 2, (short) 1, (char) 3, (short) 2, (char) 4, (short) 3, (char) 5, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortCharMap map = this.newWithKeysValues((short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4, (char) 5);
        MutableShortCharMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortCharMap map = this.newWithKeysValues((short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4, (char) 5);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortCharMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortCharMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortCharMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortCharMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortCharMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortCharMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortCharMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortCharMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortCharMapTestCase::select;
            this.payloads.reject = AbstractMutableShortCharMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortCharMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortCharMapTestCase::collect;
            this.payloads.count = AbstractMutableShortCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortCharMapTestCase::max;
            this.payloads.min = AbstractMutableShortCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortCharMapTestCase::sum;
            this.payloads.average = AbstractMutableShortCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortCharMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractMutableShortCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractMutableShortCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortCharMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortCharMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortCharMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortCharMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortCharMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortCharMapTestCase::contains;
            this.payloads.size = AbstractMutableShortCharMapTestCase::size;
            this.payloads.clear = AbstractMutableShortCharMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortCharMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortCharMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortCharMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortCharMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortCharMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortCharMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortCharMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortCharMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortCharMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortCharMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortCharMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortCharMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortCharMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortCharMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortCharMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortCharMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortCharMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortCharMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortCharMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortCharMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortCharMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortCharMapTestCase::asUnmodifiable;
            this.payloads.charIterator_with_remove = AbstractMutableShortCharMapTestCase::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortCharMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortCharMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortCharMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortCharMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortCharMapTestCase::serializeKeySet;
        }
    }
}
