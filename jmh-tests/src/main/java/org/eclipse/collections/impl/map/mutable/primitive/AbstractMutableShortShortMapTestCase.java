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
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableShortShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortShortMapTestCase extends AbstractShortShortMapTestCase {

    @Override
    protected abstract MutableShortShortMap classUnderTest();

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1);

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2);

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3);

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3, short key4, short value4);

    @Override
    protected abstract MutableShortShortMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.put((short) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.get((short) 0));
        map1.put((short) 0, (short) 0);
        Assert.assertEquals((short) 0, map1.get((short) 0));
        map1.put((short) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.get((short) 5));
        map1.put((short) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((short) 0));
        map1.put((short) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((short) 1));
        map1.put((short) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow((short) 5));
        map1.put((short) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals((short) 5, map1.getIfAbsent((short) 0, (short) 5));
        Assert.assertEquals((short) 6, map1.getIfAbsent((short) 1, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent((short) 33, (short) 6));
        map1.put((short) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((short) 0, (short) 5));
        map1.put((short) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((short) 1, (short) 5));
        map1.put((short) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent((short) 5, (short) 6));
        map1.put((short) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent((short) 35, (short) 5));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((short) 0, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((short) 0, map1.get((short) 0));
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals((short) 0, map1.get((short) 1));
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals((short) 0, map1.get((short) 31));
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals((short) 0, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.put((short) 35, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.put((short) 35, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortShortMap hashMap1 = this.newWithKeysValues((short) 1, (short) 1, (short) 0, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortShortMap hashMap = this.newWithKeysValues((short) 6, (short) 6, (short) 5, (short) 5);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortShortHashMap hashMap = new ShortShortHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortShortHashMap(), map1);
        map1.put((short) 1, (short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortShortHashMap(), map1);
        map1.put((short) 33, (short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortShortHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortShortMap map0 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortShortHashMap(), map0);
        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortShortHashMap(), map1);
        MutableShortShortMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove() {
        MutableShortShortMap map0 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map0.remove((short) 1);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortShortHashMap(), map0);
        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map1.remove((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortShortHashMap(), map1);
        MutableShortShortMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortShortMap map0 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent((short) 1, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((short) 1, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((short) 0, (short) 100));
        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent((short) 1, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((short) 1, (short) 100));
        MutableShortShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 5, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 50, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 31, (short) 31, (short) 32, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent((short) 31, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent((short) 32, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 31, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 32, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals(1L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put() {
        MutableShortShortMap map1 = this.classUnderTest();
        map1.put((short) 0, (short) 1);
        map1.put((short) 31, (short) 32);
        map1.put((short) 32, (short) 33);
        ShortShortHashMap expected = ShortShortHashMap.newWithKeysValues((short) 0, (short) 1, (short) 31, (short) 32, (short) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, (short) 2);
        expected.put((short) 1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, (short) 34);
        expected.put((short) 33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, (short) 31);
        expected.put((short) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortShortMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, (short) 25, (short) 50));
        Assert.assertEquals(25, map1.getAndPut((short) 0, (short) 35, (short) 50));
        Assert.assertEquals(35, map1.getAndPut((short) 0, (short) 45, (short) 55));
        Assert.assertEquals(100, map1.getAndPut((short) 10, (short) 25, (short) 100));
        Assert.assertEquals(25, map1.getAndPut((short) 10, (short) 25, (short) 30));
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, (short) 25, (short) 101));
        Assert.assertEquals(25, map1.getAndPut((short) 10, (short) 27, (short) 105));
    }

    @Test
    public void putPair() {
        MutableShortShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, (short) 1));
        map1.putPair(PrimitiveTuples.pair((short) 31, (short) 32));
        map1.putPair(PrimitiveTuples.pair((short) 32, (short) 33));
        ShortShortHashMap expected = ShortShortHashMap.newWithKeysValues((short) 0, (short) 1, (short) 31, (short) 32, (short) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, (short) 2));
        expected.put((short) 1, (short) 2);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, (short) 34));
        expected.put((short) 33, (short) 34);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, (short) 31));
        expected.put((short) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 11, (short) 1, (short) 12, (short) 2, (short) 13);
        map1.updateValues((k, v) -> v);
        MutableShortShortMap expected1 = this.newWithKeysValues((short) 0, (short) 11, (short) 1, (short) 12, (short) 2, (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableShortShortMap map2 = this.newWithKeysValues((short) 0, (short) 11, (short) 1, (short) 12, (short) 2, (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableShortShortMap expected2 = this.newWithKeysValues((short) 0, (short) 12, (short) 1, (short) 13, (short) 2, (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableShortShortMap map3 = this.newWithKeysValues((short) 0, (short) 11, (short) 1, (short) 12, (short) 2, (short) 13);
        map3.updateValues((k, v) -> k == (short) 0 ? (short) 10 : v);
        MutableShortShortMap expected3 = this.newWithKeysValues((short) 0, (short) 10, (short) 1, (short) 12, (short) 2, (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, (short) 1));
        Assert.assertEquals(32L, map1.addToValue((short) 31, (short) 32));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (short) 3));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (short) 10));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (short) 9));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (short) 5));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (short) 33));
        ShortShortHashMap expected = ShortShortHashMap.newWithKeysValues((short) 0, (short) 11, (short) 1, (short) 12, (short) 31, (short) 37, (short) 32, (short) 33);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, (short) 5));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (short) 32));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (short) 33));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (short) 3));
        Assert.assertEquals(1L, map1.addToValue((short) 0, (short) 1));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (short) 9));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (short) 10));
        Assert.assertEquals(expected, map1);
        MutableShortShortMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot() {
        ShortShortHashMap hashMap = new ShortShortHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((short) i));
            hashMap.put((short) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals((short) 0, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortShortMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortShortMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortShortMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortShortMapTestCase.generateCollisions().get(3);
        MutableShortShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableShortShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableShortShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 50, (short) 1, (short) 50), map1);
        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 50, (short) 1, (short) 50), map2);
        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 50), map3);
        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 100, (short) 1, (short) 100), map1);
        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 100, (short) 1, (short) 100), map2);
        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 100), map3);
        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 9, (short) 1, (short) 9), map1);
        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 9, (short) 1, (short) 9), map2);
        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 9), map3);
        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToShortFunction function = (short shortParameter) -> (short) shortParameter;
        ShortToShortFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1), map1);
        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1), map2);
        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map3);
        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 33), map4);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2, (short) 1, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2, (short) 1, (short) 2), map1);
        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 1, (short) 1, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2, (short) 1, (short) 2), map2);
        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 2), map3);
    }

    @Test
    public void freeze() {
        MutableShortShortMap mutableShortShortMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortShortMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortShortMap.put((short) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortShortMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortShortMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortShortMap mutableShortShortMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortShortMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortShortMapForClear.keySet().toArray());
        mutableShortShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortShortMap map = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 31, (short) 31, (short) 32, (short) 32);
        MutableShortShortMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 31, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortShortMap map = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 31, (short) 31, (short) 32, (short) 32);
        MutableShortShortMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 31, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, (short) 1), hashMap);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortShortMap emptyMap = this.getEmptyMap();
        MutableShortShortMap partialMap = this.newWithKeysValues((short) 1, (short) 1, (short) 3, (short) 3);
        MutableShortShortMap completeMap = this.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);
        Iterable<ShortShortPair> emptyIterable = Iterables.iList();
        Iterable<ShortShortPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 3, (short) 3));
        Iterable<ShortShortPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, (short) 1), PrimitiveTuples.pair((short) 2, (short) 2), PrimitiveTuples.pair((short) 3, (short) 3), PrimitiveTuples.pair((short) 4, (short) 4));
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
        Verify.assertInstanceOf(SynchronizedShortShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove() {
        MutableShortShortMap mutableMap = this.classUnderTest();
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
        MutableShortShortMap map = this.newWithKeysValues((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4, (short) 5);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 2, (short) 1, (short) 3, (short) 2, (short) 4, (short) 3, (short) 5, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 1).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortShortMap map = this.newWithKeysValues((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4, (short) 5);
        MutableShortShortMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortShortMap map = this.newWithKeysValues((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4, (short) 5);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortShortMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortShortMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortShortMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortShortMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortShortMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortShortMapTestCase::select;
            this.payloads.reject = AbstractMutableShortShortMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortShortMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortShortMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortShortMapTestCase::collect;
            this.payloads.count = AbstractMutableShortShortMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortShortMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortShortMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortShortMapTestCase::max;
            this.payloads.min = AbstractMutableShortShortMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortShortMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortShortMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortShortMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortShortMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortShortMapTestCase::sum;
            this.payloads.average = AbstractMutableShortShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortShortMapTestCase::toBag;
            this.payloads.shortIterator = AbstractMutableShortShortMapTestCase::shortIterator;
            this.payloads.asLazy = AbstractMutableShortShortMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortShortMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortShortMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortShortMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortShortMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortShortMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortShortMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortShortMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortShortMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortShortMapTestCase::contains;
            this.payloads.size = AbstractMutableShortShortMapTestCase::size;
            this.payloads.clear = AbstractMutableShortShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortShortMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortShortMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortShortMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortShortMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortShortMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortShortMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortShortMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortShortMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortShortMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortShortMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortShortMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortShortMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortShortMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortShortMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortShortMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortShortMapTestCase::asUnmodifiable;
            this.payloads.shortIterator_with_remove = AbstractMutableShortShortMapTestCase::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortShortMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortShortMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortShortMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortShortMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortShortMapTestCase::serializeKeySet;
        }
    }
}
