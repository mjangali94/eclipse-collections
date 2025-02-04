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
import org.eclipse.collections.api.block.function.primitive.CharToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharFloatMapTestCase extends AbstractCharFloatMapTestCase {

    @Override
    protected abstract MutableCharFloatMap classUnderTest();

    @Override
    protected abstract MutableCharFloatMap newWithKeysValues(char key1, float value1);

    @Override
    protected abstract MutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2);

    @Override
    protected abstract MutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3);

    @Override
    protected abstract MutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4);

    @Override
    protected abstract MutableCharFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.put((char) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.get((char) 0), 0.0);
        map1.put((char) 0, 0.0f);
        Assert.assertEquals(0.0f, map1.get((char) 0), 0.0);
        map1.put((char) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.get((char) 5), 0.0);
        map1.put((char) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.get((char) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((char) 0), 0.0);
        map1.put((char) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((char) 1), 0.0);
        map1.put((char) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow((char) 5), 0.0);
        map1.put((char) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow((char) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5.0f, map1.getIfAbsent((char) 0, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((char) 1, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((char) 33, 6.0f), 0.0);
        map1.put((char) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((char) 0, 5.0f), 0.0);
        map1.put((char) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((char) 1, 5.0f), 0.0);
        map1.put((char) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent((char) 5, 6.0f), 0.0);
        map1.put((char) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent((char) 35, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0.0f, map1.get((char) 0), 0.0);
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0.0f, map1.get((char) 0), 0.0);
        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0.0f, map1.get((char) 1), 0.0);
        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0.0f, map1.get((char) 31), 0.0);
        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0.0f, map1.get((char) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.put((char) 35, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.put((char) 35, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharFloatMap hashMap1 = this.newWithKeysValues((char) 1, 1.0f, (char) 0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharFloatMap hashMap = this.newWithKeysValues((char) 6, 6.0f, (char) 5, 5.0f);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharFloatHashMap hashMap = new CharFloatHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharFloatHashMap(), map1);
        map1.put((char) 1, 0.0f);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new CharFloatHashMap(), map1);
        map1.put((char) 33, 0.0f);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new CharFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableCharFloatMap map0 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharFloatHashMap(), map0);
        MutableCharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharFloatHashMap(), map1);
        MutableCharFloatMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 31, 31.0f, (char) 32, 32.0f), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 32.0f), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharFloatHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableCharFloatMap map0 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        map0.remove((char) 1);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharFloatHashMap(), map0);
        MutableCharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        map1.remove((char) 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharFloatHashMap(), map1);
        MutableCharFloatMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 31, 31.0f, (char) 32, 32.0f), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 32.0f), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharFloatHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableCharFloatMap map0 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent((char) 1, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent((char) 0, 100.0f), 0.0);
        Assert.assertEquals(new CharFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((char) 1, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((char) 0, 100.0f), 0.0);
        MutableCharFloatMap map1 = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent((char) 0, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent((char) 1, 100.0f), 0.0);
        Assert.assertEquals(new CharFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((char) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((char) 1, 100.0f), 0.0);
        MutableCharFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((char) 5, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((char) 50, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent((char) 0, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 31, 31.0f, (char) 32, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent((char) 31, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent((char) 32, 100.0f), 0.0);
        Assert.assertEquals(new CharFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((char) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((char) 31, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((char) 32, 100.0f), 0.0);
        Assert.assertEquals(new CharFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.put((char) 0, 1.0f);
        map1.put((char) 31, 32.0f);
        map1.put((char) 32, 33.0f);
        CharFloatHashMap expected = CharFloatHashMap.newWithKeysValues((char) 0, 1.0f, (char) 31, 32.0f, (char) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put((char) 1, 2.0f);
        expected.put((char) 1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put((char) 33, 34.0f);
        expected.put((char) 33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put((char) 30, 31.0f);
        expected.put((char) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableCharFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((char) 0, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((char) 0, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut((char) 0, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut((char) 10, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((char) 10, 25.0f, 30.0f), 0.0);
        map1.removeKey((char) 10);
        Assert.assertEquals(101, map1.getAndPut((char) 10, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((char) 10, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableCharFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1.0f));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32.0f));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33.0f));
        CharFloatHashMap expected = CharFloatHashMap.newWithKeysValues((char) 0, 1.0f, (char) 31, 32.0f, (char) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 1, 2.0f));
        expected.put((char) 1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 33, 34.0f));
        expected.put((char) 33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 30, 31.0f));
        expected.put((char) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableCharFloatMap map1 = this.newWithKeysValues((char) 0, 11.0f, (char) 1, 12.0f, (char) 2, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableCharFloatMap expected1 = this.newWithKeysValues((char) 0, 11.0f, (char) 1, 12.0f, (char) 2, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableCharFloatMap map2 = this.newWithKeysValues((char) 0, 11.0f, (char) 1, 12.0f, (char) 2, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableCharFloatMap expected2 = this.newWithKeysValues((char) 0, 12.0f, (char) 1, 13.0f, (char) 2, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableCharFloatMap map3 = this.newWithKeysValues((char) 0, 11.0f, (char) 1, 12.0f, (char) 2, 13.0f);
        map3.updateValues((k, v) -> k == (char) 0 ? 10.0f : v);
        MutableCharFloatMap expected3 = this.newWithKeysValues((char) 0, 10.0f, (char) 1, 12.0f, (char) 2, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableCharFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((char) 0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((char) 31, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((char) 1, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((char) 0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((char) 1, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((char) 31, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((char) 32, 33.0f), 0.0);
        CharFloatHashMap expected = CharFloatHashMap.newWithKeysValues((char) 0, 11.0f, (char) 1, 12.0f, (char) 31, 37.0f, (char) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5.0, map1.addToValue((char) 31, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((char) 31, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((char) 32, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((char) 1, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((char) 0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((char) 1, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((char) 0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableCharFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            char k = (char) each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        CharFloatHashMap hashMap = new CharFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((char) i), 0.0);
            hashMap.put((char) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((char) i), 0.0);
            hashMap.remove((char) i);
            Assert.assertEquals(0.0f, hashMap.get((char) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharFloatMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharFloatMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharFloatMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharFloatMapTestCase.generateCollisions().get(3);
        MutableCharFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableCharFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableCharFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 0, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 1, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 50.0f, (char) 1, 50.0f), map1);
        MutableCharFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 1, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 0, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 50.0f, (char) 1, 50.0f), map2);
        MutableCharFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((char) 32, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((char) 32, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 50.0f), map3);
        MutableCharFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((char) 33, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((char) 33, 100.0f), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 0, factoryThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 1, factoryThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 100.0f, (char) 1, 100.0f), map1);
        MutableCharFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 1, factoryThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 0, factoryThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 100.0f, (char) 1, 100.0f), map2);
        MutableCharFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((char) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((char) 32, factoryThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 100.0f), map3);
        MutableCharFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((char) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((char) 33, factoryThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 9.0f, (char) 1, 9.0f), map1);
        MutableCharFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 9.0f, (char) 1, 9.0f), map2);
        MutableCharFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 9.0f), map3);
        MutableCharFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToFloatFunction function = (char charParameter) -> (float) charParameter;
        CharToFloatFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((char) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((char) 0, functionThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((char) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((char) 1, functionThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f), map1);
        MutableCharFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((char) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((char) 1, functionThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((char) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((char) 0, functionThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f), map2);
        MutableCharFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((char) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((char) 32, functionThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 32, 32.0f), map3);
        MutableCharFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((char) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((char) 33, functionThrows), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableCharFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((char) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((char) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue((char) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 2.0f, (char) 1, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((char) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 2.0f, (char) 1, 2.0f), map1);
        MutableCharFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((char) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((char) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue((char) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 1.0f, (char) 1, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((char) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 2.0f, (char) 1, 2.0f), map2);
        MutableCharFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((char) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue((char) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 33, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableCharFloatMap mutableCharFloatMap = this.classUnderTest();
        CharSet frozenSet = mutableCharFloatMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharFloatMap.put((char) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharFloatMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharFloatMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharFloatMap mutableCharFloatMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharFloatMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharFloatMapForClear.keySet().toArray());
        mutableCharFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 31, 31.0f, (char) 32, 32.0f);
        MutableCharFloatMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 31, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharFloatMap map = this.newWithKeysValues((char) 0, 0.0f, (char) 1, 1.0f, (char) 31, 31.0f, (char) 32, 32.0f);
        MutableCharFloatMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 31, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1.0f), hashMap);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharFloatMap emptyMap = this.getEmptyMap();
        MutableCharFloatMap partialMap = this.newWithKeysValues((char) 1, 1.0f, (char) 3, 3.0f);
        MutableCharFloatMap completeMap = this.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Iterable<CharFloatPair> emptyIterable = Iterables.iList();
        Iterable<CharFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1.0f), PrimitiveTuples.pair((char) 3, 3.0f));
        Iterable<CharFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1.0f), PrimitiveTuples.pair((char) 2, 2.0f), PrimitiveTuples.pair((char) 3, 3.0f), PrimitiveTuples.pair((char) 4, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedCharFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableCharFloatMap mutableMap = this.classUnderTest();
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
        MutableCharFloatMap map = this.newWithKeysValues((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4, 5.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(2.0f, (char) 1, 3.0f, (char) 2, 4.0f, (char) 3, 5.0f, (char) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1.0f, (char) 2, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableCharFloatMap map = this.newWithKeysValues((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4, 5.0f);
        MutableCharFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableCharFloatMap map = this.newWithKeysValues((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4, 5.0f);
        CharSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharFloatMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharFloatMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharFloatMapTestCase::values;
            this.payloads.containsAll = AbstractMutableCharFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableCharFloatMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableCharFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableCharFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableCharFloatMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharFloatMapTestCase::collect;
            this.payloads.count = AbstractMutableCharFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableCharFloatMapTestCase::max;
            this.payloads.min = AbstractMutableCharFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharFloatMapTestCase::sum;
            this.payloads.average = AbstractMutableCharFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableCharFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableCharFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractMutableCharFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractMutableCharFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableCharFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableCharFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableCharFloatMapTestCase::chunk;
            this.payloads.get = AbstractMutableCharFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableCharFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableCharFloatMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharFloatMapTestCase::contains;
            this.payloads.size = AbstractMutableCharFloatMapTestCase::size;
            this.payloads.clear = AbstractMutableCharFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharFloatMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharFloatMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharFloatMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableCharFloatMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableCharFloatMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableCharFloatMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableCharFloatMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableCharFloatMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableCharFloatMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharFloatMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableCharFloatMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharFloatMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharFloatMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharFloatMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharFloatMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharFloatMapTestCase::asUnmodifiable;
            this.payloads.floatIterator_with_remove = AbstractMutableCharFloatMapTestCase::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharFloatMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharFloatMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableCharFloatMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableCharFloatMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableCharFloatMapTestCase::serializeKeySet;
        }
    }
*/
}
