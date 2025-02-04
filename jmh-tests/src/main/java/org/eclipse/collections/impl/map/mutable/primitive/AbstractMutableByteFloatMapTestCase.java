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
import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteFloatMapTestCase extends AbstractByteFloatMapTestCase {

    @Override
    protected abstract MutableByteFloatMap classUnderTest();

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1);

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2);

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3);

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3, byte key4, float value4);

    @Override
    protected abstract MutableByteFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.get((byte) 0), 0.0);
        map1.put((byte) 0, 0.0f);
        Assert.assertEquals(0.0f, map1.get((byte) 0), 0.0);
        map1.put((byte) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.get((byte) 5), 0.0);
        map1.put((byte) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.get((byte) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((byte) 0), 0.0);
        map1.put((byte) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((byte) 1), 0.0);
        map1.put((byte) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow((byte) 5), 0.0);
        map1.put((byte) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow((byte) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals(5.0f, map1.getIfAbsent((byte) 0, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((byte) 1, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((byte) 33, 6.0f), 0.0);
        map1.put((byte) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((byte) 0, 5.0f), 0.0);
        map1.put((byte) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((byte) 1, 5.0f), 0.0);
        map1.put((byte) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent((byte) 5, 6.0f), 0.0);
        map1.put((byte) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent((byte) 35, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0.0f, map1.get((byte) 0), 0.0);
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0.0f, map1.get((byte) 0), 0.0);
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals(0.0f, map1.get((byte) 1), 0.0);
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals(0.0f, map1.get((byte) 31), 0.0);
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals(0.0f, map1.get((byte) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteFloatMap hashMap1 = this.newWithKeysValues((byte) 1, 1.0f, (byte) 0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteFloatMap hashMap = this.newWithKeysValues((byte) 6, 6.0f, (byte) 5, 5.0f);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteFloatHashMap(), map1);
        map1.put((byte) 1, 0.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ByteFloatHashMap(), map1);
        map1.put((byte) 33, 0.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ByteFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteFloatMap map0 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteFloatHashMap(), map0);
        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteFloatHashMap(), map1);
        MutableByteFloatMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableByteFloatMap map0 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteFloatHashMap(), map0);
        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteFloatHashMap(), map1);
        MutableByteFloatMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteFloatMap map0 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        MutableByteFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 5, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 50, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent((byte) 31, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent((byte) 32, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 31, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 32, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1.0f);
        map1.put((byte) 31, 32.0f);
        map1.put((byte) 32, 33.0f);
        ByteFloatHashMap expected = ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f, (byte) 31, 32.0f, (byte) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, 2.0f);
        expected.put((byte) 1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, 34.0f);
        expected.put((byte) 33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, 31.0f);
        expected.put((byte) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((byte) 0, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut((byte) 0, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut((byte) 10, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 25.0f, 30.0f), 0.0);
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, 1.0f));
        map1.putPair(PrimitiveTuples.pair((byte) 31, 32.0f));
        map1.putPair(PrimitiveTuples.pair((byte) 32, 33.0f));
        ByteFloatHashMap expected = ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f, (byte) 31, 32.0f, (byte) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, 2.0f));
        expected.put((byte) 1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, 34.0f));
        expected.put((byte) 33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, 31.0f));
        expected.put((byte) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 11.0f, (byte) 1, 12.0f, (byte) 2, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableByteFloatMap expected1 = this.newWithKeysValues((byte) 0, 11.0f, (byte) 1, 12.0f, (byte) 2, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableByteFloatMap map2 = this.newWithKeysValues((byte) 0, 11.0f, (byte) 1, 12.0f, (byte) 2, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableByteFloatMap expected2 = this.newWithKeysValues((byte) 0, 12.0f, (byte) 1, 13.0f, (byte) 2, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableByteFloatMap map3 = this.newWithKeysValues((byte) 0, 11.0f, (byte) 1, 12.0f, (byte) 2, 13.0f);
        map3.updateValues((k, v) -> k == (byte) 0 ? 10.0f : v);
        MutableByteFloatMap expected3 = this.newWithKeysValues((byte) 0, 10.0f, (byte) 1, 12.0f, (byte) 2, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((byte) 0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((byte) 31, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((byte) 1, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((byte) 0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((byte) 1, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((byte) 31, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((byte) 32, 33.0f), 0.0);
        ByteFloatHashMap expected = ByteFloatHashMap.newWithKeysValues((byte) 0, 11.0f, (byte) 1, 12.0f, (byte) 31, 37.0f, (byte) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5.0, map1.addToValue((byte) 31, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((byte) 31, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((byte) 32, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((byte) 1, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((byte) 0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((byte) 1, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((byte) 0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableByteFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((byte) i), 0.0);
            hashMap.put((byte) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((byte) i), 0.0);
            hashMap.remove((byte) i);
            Assert.assertEquals(0.0f, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteFloatMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteFloatMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteFloatMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteFloatMapTestCase.generateCollisions().get(3);
        MutableByteFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableByteFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableByteFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 50.0f, (byte) 1, 50.0f), map1);
        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 50.0f, (byte) 1, 50.0f), map2);
        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((byte) 32, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((byte) 32, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 50.0f), map3);
        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((byte) 33, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((byte) 33, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 0, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 1, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 100.0f, (byte) 1, 100.0f), map1);
        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 1, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 0, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 100.0f, (byte) 1, 100.0f), map2);
        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((byte) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((byte) 32, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 100.0f), map3);
        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((byte) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((byte) 33, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 9.0f, (byte) 1, 9.0f), map1);
        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 9.0f, (byte) 1, 9.0f), map2);
        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 9.0f), map3);
        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToFloatFunction function = (byte byteParameter) -> (float) byteParameter;
        ByteToFloatFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((byte) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((byte) 0, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((byte) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((byte) 1, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f), map1);
        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((byte) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((byte) 1, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((byte) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((byte) 0, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f), map2);
        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((byte) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((byte) 32, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map3);
        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((byte) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((byte) 33, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f, (byte) 1, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f, (byte) 1, 2.0f), map1);
        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f, (byte) 1, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f, (byte) 1, 2.0f), map2);
        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((byte) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue((byte) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableByteFloatMap mutableByteFloatMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteFloatMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteFloatMap.put((byte) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteFloatMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteFloatMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteFloatMap mutableByteFloatMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteFloatMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteFloatMapForClear.keySet().toArray());
        mutableByteFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 31, 31.0f, (byte) 32, 32.0f);
        MutableByteFloatMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 31, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 31, 31.0f, (byte) 32, 32.0f);
        MutableByteFloatMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 31, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, 1.0f), hashMap);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteFloatMap emptyMap = this.getEmptyMap();
        MutableByteFloatMap partialMap = this.newWithKeysValues((byte) 1, 1.0f, (byte) 3, 3.0f);
        MutableByteFloatMap completeMap = this.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        Iterable<ByteFloatPair> emptyIterable = Iterables.iList();
        Iterable<ByteFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1.0f), PrimitiveTuples.pair((byte) 3, 3.0f));
        Iterable<ByteFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1.0f), PrimitiveTuples.pair((byte) 2, 2.0f), PrimitiveTuples.pair((byte) 3, 3.0f), PrimitiveTuples.pair((byte) 4, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedByteFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableByteFloatMap mutableMap = this.classUnderTest();
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
        MutableByteFloatMap map = this.newWithKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(2.0f, (byte) 1, 3.0f, (byte) 2, 4.0f, (byte) 3, 5.0f, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f);
        MutableByteFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteFloatMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteFloatMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteFloatMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteFloatMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableByteFloatMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteFloatMapTestCase::collect;
            this.payloads.count = AbstractMutableByteFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteFloatMapTestCase::max;
            this.payloads.min = AbstractMutableByteFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteFloatMapTestCase::sum;
            this.payloads.average = AbstractMutableByteFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractMutableByteFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractMutableByteFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteFloatMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteFloatMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteFloatMapTestCase::contains;
            this.payloads.size = AbstractMutableByteFloatMapTestCase::size;
            this.payloads.clear = AbstractMutableByteFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteFloatMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteFloatMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteFloatMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteFloatMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteFloatMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteFloatMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteFloatMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteFloatMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteFloatMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteFloatMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteFloatMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteFloatMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteFloatMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteFloatMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteFloatMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteFloatMapTestCase::asUnmodifiable;
            this.payloads.floatIterator_with_remove = AbstractMutableByteFloatMapTestCase::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteFloatMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteFloatMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteFloatMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteFloatMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteFloatMapTestCase::serializeKeySet;
        }
    }
}
