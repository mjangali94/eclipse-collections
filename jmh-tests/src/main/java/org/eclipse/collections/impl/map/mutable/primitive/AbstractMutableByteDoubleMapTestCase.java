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
import org.eclipse.collections.api.block.function.primitive.ByteToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableByteDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteDoubleMapTestCase extends AbstractByteDoubleMapTestCase {

    @Override
    protected abstract MutableByteDoubleMap classUnderTest();

    @Override
    protected abstract MutableByteDoubleMap newWithKeysValues(byte key1, double value1);

    @Override
    protected abstract MutableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2);

    @Override
    protected abstract MutableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3);

    @Override
    protected abstract MutableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4);

    @Override
    protected abstract MutableByteDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1.0);
        Assert.assertEquals(1.0, map1.get((byte) 0), 0.0);
        map1.put((byte) 0, 0.0);
        Assert.assertEquals(0.0, map1.get((byte) 0), 0.0);
        map1.put((byte) 5, 5.0);
        Assert.assertEquals(5.0, map1.get((byte) 5), 0.0);
        map1.put((byte) 35, 35.0);
        Assert.assertEquals(35.0, map1.get((byte) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((byte) 0), 0.0);
        map1.put((byte) 1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((byte) 1), 0.0);
        map1.put((byte) 5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow((byte) 5), 0.0);
        map1.put((byte) 35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow((byte) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals(5.0, map1.getIfAbsent((byte) 0, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((byte) 1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((byte) 33, 6.0), 0.0);
        map1.put((byte) 0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((byte) 0, 5.0), 0.0);
        map1.put((byte) 1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((byte) 1, 5.0), 0.0);
        map1.put((byte) 5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent((byte) 5, 6.0), 0.0);
        map1.put((byte) 35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent((byte) 35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0.0, map1.get((byte) 0), 0.0);
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0.0, map1.get((byte) 0), 0.0);
        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals(0.0, map1.get((byte) 1), 0.0);
        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals(0.0, map1.get((byte) 31), 0.0);
        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals(0.0, map1.get((byte) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.put((byte) 35, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableByteDoubleMap hashMap1 = this.newWithKeysValues((byte) 1, 1.0, (byte) 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteDoubleMap hashMap = this.newWithKeysValues((byte) 6, 6.0, (byte) 5, 5.0);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteDoubleHashMap(), map1);
        map1.put((byte) 1, 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new ByteDoubleHashMap(), map1);
        map1.put((byte) 33, 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new ByteDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteDoubleHashMap(), map0);
        MutableByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteDoubleHashMap(), map1);
        MutableByteDoubleMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 31, 31.0, (byte) 32, 32.0), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 32.0), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteDoubleHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteDoubleHashMap(), map0);
        MutableByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteDoubleHashMap(), map1);
        MutableByteDoubleMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 31, 31.0, (byte) 32, 32.0), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 32.0), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteDoubleHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableByteDoubleMap map0 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent((byte) 1, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent((byte) 0, 100.0), 0.0);
        Assert.assertEquals(new ByteDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((byte) 1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((byte) 0, 100.0), 0.0);
        MutableByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent((byte) 0, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent((byte) 1, 100.0), 0.0);
        Assert.assertEquals(new ByteDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((byte) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((byte) 1, 100.0), 0.0);
        MutableByteDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((byte) 5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((byte) 50, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent((byte) 0, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 31, 31.0, (byte) 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent((byte) 31, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent((byte) 32, 100.0), 0.0);
        Assert.assertEquals(new ByteDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((byte) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((byte) 31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((byte) 32, 100.0), 0.0);
        Assert.assertEquals(new ByteDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1.0);
        map1.put((byte) 31, 32.0);
        map1.put((byte) 32, 33.0);
        ByteDoubleHashMap expected = ByteDoubleHashMap.newWithKeysValues((byte) 0, 1.0, (byte) 31, 32.0, (byte) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 1, 2.0);
        expected.put((byte) 1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 33, 34.0);
        expected.put((byte) 33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put((byte) 30, 31.0);
        expected.put((byte) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableByteDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((byte) 0, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((byte) 0, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut((byte) 0, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut((byte) 10, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 25.0, 30.0), 0.0);
        map1.removeKey((byte) 10);
        Assert.assertEquals(101, map1.getAndPut((byte) 10, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((byte) 10, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableByteDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, 1.0));
        map1.putPair(PrimitiveTuples.pair((byte) 31, 32.0));
        map1.putPair(PrimitiveTuples.pair((byte) 32, 33.0));
        ByteDoubleHashMap expected = ByteDoubleHashMap.newWithKeysValues((byte) 0, 1.0, (byte) 31, 32.0, (byte) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 1, 2.0));
        expected.put((byte) 1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 33, 34.0));
        expected.put((byte) 33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((byte) 30, 31.0));
        expected.put((byte) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableByteDoubleMap map1 = this.newWithKeysValues((byte) 0, 11.0, (byte) 1, 12.0, (byte) 2, 13.0);
        map1.updateValues((k, v) -> v);
        MutableByteDoubleMap expected1 = this.newWithKeysValues((byte) 0, 11.0, (byte) 1, 12.0, (byte) 2, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableByteDoubleMap map2 = this.newWithKeysValues((byte) 0, 11.0, (byte) 1, 12.0, (byte) 2, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableByteDoubleMap expected2 = this.newWithKeysValues((byte) 0, 12.0, (byte) 1, 13.0, (byte) 2, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableByteDoubleMap map3 = this.newWithKeysValues((byte) 0, 11.0, (byte) 1, 12.0, (byte) 2, 13.0);
        map3.updateValues((k, v) -> k == (byte) 0 ? 10.0 : v);
        MutableByteDoubleMap expected3 = this.newWithKeysValues((byte) 0, 10.0, (byte) 1, 12.0, (byte) 2, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableByteDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((byte) 0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((byte) 31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((byte) 1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((byte) 0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((byte) 1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((byte) 31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((byte) 32, 33.0), 0.0);
        ByteDoubleHashMap expected = ByteDoubleHashMap.newWithKeysValues((byte) 0, 11.0, (byte) 1, 12.0, (byte) 31, 37.0, (byte) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5.0, map1.addToValue((byte) 31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((byte) 31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((byte) 32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((byte) 1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((byte) 0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((byte) 1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((byte) 0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableByteDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            byte k = (byte) each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((byte) i), 0.0);
            hashMap.put((byte) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((byte) i), 0.0);
            hashMap.remove((byte) i);
            Assert.assertEquals(0.0, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteDoubleMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteDoubleMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteDoubleMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteDoubleMapTestCase.generateCollisions().get(3);
        MutableByteDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableByteDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableByteDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableByteDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 0, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 1, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 50.0, (byte) 1, 50.0), map1);
        MutableByteDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 1, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 0, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 50.0, (byte) 1, 50.0), map2);
        MutableByteDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((byte) 32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((byte) 32, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 50.0), map3);
        MutableByteDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((byte) 33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((byte) 33, 100.0), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableByteDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 0, factoryThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 1, factoryThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 100.0, (byte) 1, 100.0), map1);
        MutableByteDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 1, factoryThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 0, factoryThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 100.0, (byte) 1, 100.0), map2);
        MutableByteDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((byte) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((byte) 32, factoryThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 100.0), map3);
        MutableByteDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((byte) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((byte) 33, factoryThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableByteDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 9.0, (byte) 1, 9.0), map1);
        MutableByteDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 9.0, (byte) 1, 9.0), map2);
        MutableByteDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 9.0), map3);
        MutableByteDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToDoubleFunction function = (byte byteParameter) -> (double) byteParameter;
        ByteToDoubleFunction functionThrows = (byte byteParameter) -> {
            throw new AssertionError();
        };
        MutableByteDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((byte) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((byte) 0, functionThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((byte) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((byte) 1, functionThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0), map1);
        MutableByteDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((byte) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((byte) 1, functionThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((byte) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((byte) 0, functionThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0), map2);
        MutableByteDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((byte) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((byte) 32, functionThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 32, 32.0), map3);
        MutableByteDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((byte) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((byte) 33, functionThrows), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableByteDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((byte) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((byte) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue((byte) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 2.0, (byte) 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((byte) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 2.0, (byte) 1, 2.0), map1);
        MutableByteDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((byte) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((byte) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue((byte) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 1.0, (byte) 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((byte) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 2.0, (byte) 1, 2.0), map2);
        MutableByteDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((byte) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue((byte) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 33, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableByteDoubleMap mutableByteDoubleMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteDoubleMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteDoubleMap.put((byte) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteDoubleMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteDoubleMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteDoubleMap mutableByteDoubleMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteDoubleMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteDoubleMapForClear.keySet().toArray());
        mutableByteDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 31, 31.0, (byte) 32, 32.0);
        MutableByteDoubleMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableByteDoubleMap map = this.newWithKeysValues((byte) 0, 0.0, (byte) 1, 1.0, (byte) 31, 31.0, (byte) 32, 32.0);
        MutableByteDoubleMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableByteDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, 1.0), hashMap);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableByteDoubleMap emptyMap = this.getEmptyMap();
        MutableByteDoubleMap partialMap = this.newWithKeysValues((byte) 1, 1.0, (byte) 3, 3.0);
        MutableByteDoubleMap completeMap = this.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        Iterable<ByteDoublePair> emptyIterable = Iterables.iList();
        Iterable<ByteDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1.0), PrimitiveTuples.pair((byte) 3, 3.0));
        Iterable<ByteDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, 1.0), PrimitiveTuples.pair((byte) 2, 2.0), PrimitiveTuples.pair((byte) 3, 3.0), PrimitiveTuples.pair((byte) 4, 4.0));
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
        Verify.assertInstanceOf(SynchronizedByteDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableByteDoubleMap mutableMap = this.classUnderTest();
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
        MutableByteDoubleMap map = this.newWithKeysValues((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4, 5.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(2.0, (byte) 1, 3.0, (byte) 2, 4.0, (byte) 3, 5.0, (byte) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, 1.0, (byte) 2, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableByteDoubleMap map = this.newWithKeysValues((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4, 5.0);
        MutableByteDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableByteDoubleMap map = this.newWithKeysValues((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4, 5.0);
        ByteSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteDoubleMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableByteDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableByteDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableByteDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableByteDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableByteDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableByteDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableByteDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableByteDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableByteDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableByteDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableByteDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableByteDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableByteDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableByteDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableByteDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableByteDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableByteDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableByteDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableByteDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableByteDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableByteDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableByteDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableByteDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableByteDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableByteDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableByteDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableByteDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableByteDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableByteDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableByteDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableByteDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableByteDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableByteDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableByteDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableByteDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableByteDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableByteDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableByteDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableByteDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableByteDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableByteDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableByteDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableByteDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableByteDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableByteDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableByteDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableByteDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableByteDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableByteDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableByteDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableByteDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableByteDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableByteDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableByteDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableByteDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableByteDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableByteDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableByteDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableByteDoubleMapTestCase::serializeKeySet;
        }
    }
*/
}
