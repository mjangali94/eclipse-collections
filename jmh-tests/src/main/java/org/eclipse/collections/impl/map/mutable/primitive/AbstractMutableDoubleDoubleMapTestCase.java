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
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleDoubleMapTestCase extends AbstractDoubleDoubleMapTestCase {

    @Override
    protected abstract MutableDoubleDoubleMap classUnderTest();

    @Override
    protected abstract MutableDoubleDoubleMap newWithKeysValues(double key1, double value1);

    @Override
    protected abstract MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2);

    @Override
    protected abstract MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3);

    @Override
    protected abstract MutableDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3, double key4, double value4);

    @Override
    protected abstract MutableDoubleDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.put(0.0, 1.0);
        Assert.assertEquals(1.0, map1.get(0.0), 0.0);
        map1.put(0.0, 0.0);
        Assert.assertEquals(0.0, map1.get(0.0), 0.0);
        map1.put(5.0, 5.0);
        Assert.assertEquals(5.0, map1.get(5.0), 0.0);
        map1.put(35.0, 35.0);
        Assert.assertEquals(35.0, map1.get(35.0), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0.0), 0.0);
        map1.put(1.0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1.0), 0.0);
        map1.put(5.0, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5.0), 0.0);
        map1.put(35.0, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35.0), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(0.0, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(1.0, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33.0, 6.0), 0.0);
        map1.put(0.0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0.0, 5.0), 0.0);
        map1.put(1.0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1.0, 5.0), 0.0);
        map1.put(5.0, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5.0, 6.0), 0.0);
        map1.put(35.0, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35.0, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0.0, map1.get(0.0), 0.0);
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0.0, map1.get(0.0), 0.0);
        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals(0.0, map1.get(1.0), 0.0);
        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals(0.0, map1.get(31.0), 0.0);
        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals(0.0, map1.get(32.0), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.put(35.0, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.put(35.0, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableDoubleDoubleMap hashMap1 = this.newWithKeysValues(1.0, 1.0, 0.0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleDoubleMap hashMap = this.newWithKeysValues(6.0, 6.0, 5.0, 5.0);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleDoubleHashMap(), map1);
        map1.put(1.0, 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleDoubleHashMap(), map1);
        map1.put(33.0, 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableDoubleDoubleMap map0 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map0);
        MutableDoubleDoubleMap map1 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map1);
        MutableDoubleDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(31.0, 31.0, 32.0, 32.0), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 32.0), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableDoubleDoubleMap map0 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
        map0.remove(1.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map0);
        MutableDoubleDoubleMap map1 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
        map1.remove(0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map1);
        MutableDoubleDoubleMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(31.0, 31.0, 32.0, 32.0), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 32.0), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableDoubleDoubleMap map0 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0.0, 100.0), 0.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1.0, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0.0, 100.0), 0.0);
        MutableDoubleDoubleMap map1 = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1.0, 100.0), 0.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0.0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1.0, 100.0), 0.0);
        MutableDoubleDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5.0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(31.0, 31.0, 32.0, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32.0, 100.0), 0.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0.0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31.0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32.0, 100.0), 0.0);
        Assert.assertEquals(new DoubleDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.put(0.0, 1.0);
        map1.put(31.0, 32.0);
        map1.put(32.0, 33.0);
        DoubleDoubleHashMap expected = DoubleDoubleHashMap.newWithKeysValues(0.0, 1.0, 31.0, 32.0, 32.0, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put(1.0, 2.0);
        expected.put(1.0, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put(33.0, 34.0);
        expected.put(33.0, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put(30.0, 31.0);
        expected.put(30.0, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut(0.0, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(0.0, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut(0.0, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut(10.0, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0, 25.0, 30.0), 0.0);
        map1.removeKey(10.0);
        Assert.assertEquals(101, map1.getAndPut(10.0, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut(10.0, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableDoubleDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, 1.0));
        map1.putPair(PrimitiveTuples.pair(31.0, 32.0));
        map1.putPair(PrimitiveTuples.pair(32.0, 33.0));
        DoubleDoubleHashMap expected = DoubleDoubleHashMap.newWithKeysValues(0.0, 1.0, 31.0, 32.0, 32.0, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(1.0, 2.0));
        expected.put(1.0, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(33.0, 34.0));
        expected.put(33.0, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair(30.0, 31.0));
        expected.put(30.0, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableDoubleDoubleMap map1 = this.newWithKeysValues(0.0, 11.0, 1.0, 12.0, 2.0, 13.0);
        map1.updateValues((k, v) -> v);
        MutableDoubleDoubleMap expected1 = this.newWithKeysValues(0.0, 11.0, 1.0, 12.0, 2.0, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableDoubleDoubleMap map2 = this.newWithKeysValues(0.0, 11.0, 1.0, 12.0, 2.0, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableDoubleDoubleMap expected2 = this.newWithKeysValues(0.0, 12.0, 1.0, 13.0, 2.0, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableDoubleDoubleMap map3 = this.newWithKeysValues(0.0, 11.0, 1.0, 12.0, 2.0, 13.0);
        map3.updateValues((k, v) -> k == 0.0 ? 10.0 : v);
        MutableDoubleDoubleMap expected3 = this.newWithKeysValues(0.0, 10.0, 1.0, 12.0, 2.0, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableDoubleDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0.0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31.0, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0, 33.0), 0.0);
        DoubleDoubleHashMap expected = DoubleDoubleHashMap.newWithKeysValues(0.0, 11.0, 1.0, 12.0, 31.0, 37.0, 32.0, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5.0, map1.addToValue(31.0, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0.0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableDoubleDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            double k = each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((double) i), 0.0);
            hashMap.put((double) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((double) i), 0.0);
            hashMap.remove((double) i);
            Assert.assertEquals(0.0, hashMap.get((double) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleDoubleMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleDoubleMapTestCase.generateCollisions().get(3);
        MutableDoubleDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableDoubleDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableDoubleDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableDoubleDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 50.0, 1.0, 50.0), map1);
        MutableDoubleDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 50.0, 1.0, 50.0), map2);
        MutableDoubleDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 50.0), map3);
        MutableDoubleDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0, 100.0), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableDoubleDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 100.0, 1.0, 100.0), map1);
        MutableDoubleDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 100.0, 1.0, 100.0), map2);
        MutableDoubleDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 100.0), map3);
        MutableDoubleDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0, factoryThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableDoubleDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 9.0, 1.0, 9.0), map1);
        MutableDoubleDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 9.0, 1.0, 9.0), map2);
        MutableDoubleDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 9.0), map3);
        MutableDoubleDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToDoubleFunction function = (double doubleParameter) -> (double) doubleParameter;
        DoubleToDoubleFunction functionThrows = (double doubleParameter) -> {
            throw new AssertionError();
        };
        MutableDoubleDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 1.0, 1.0), map1);
        MutableDoubleDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 1.0, 1.0), map2);
        MutableDoubleDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(32.0, 32.0), map3);
        MutableDoubleDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0, functionThrows), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableDoubleDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 2.0, 1.0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 2.0, 1.0, 2.0), map1);
        MutableDoubleDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 1.0, 1.0, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 2.0, 1.0, 2.0), map2);
        MutableDoubleDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33.0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(33.0, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleDoubleMap mutableDoubleDoubleMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleDoubleMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleDoubleMap.put((double) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleDoubleMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleDoubleMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleDoubleMap mutableDoubleDoubleMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleDoubleMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleDoubleMapForClear.keySet().toArray());
        mutableDoubleDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleDoubleMap map = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0, 31.0, 31.0, 32.0, 32.0);
        MutableDoubleDoubleMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 1.0, 1.0, 31.0, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleDoubleMap map = this.newWithKeysValues(0.0, 0.0, 1.0, 1.0, 31.0, 31.0, 32.0, 32.0);
        MutableDoubleDoubleMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 31.0, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableDoubleDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, 1.0), hashMap);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleDoubleMap emptyMap = this.getEmptyMap();
        MutableDoubleDoubleMap partialMap = this.newWithKeysValues(1.0, 1.0, 3.0, 3.0);
        MutableDoubleDoubleMap completeMap = this.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        Iterable<DoubleDoublePair> emptyIterable = Iterables.iList();
        Iterable<DoubleDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(3.0, 3.0));
        Iterable<DoubleDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, 1.0), PrimitiveTuples.pair(2.0, 2.0), PrimitiveTuples.pair(3.0, 3.0), PrimitiveTuples.pair(4.0, 4.0));
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
        Verify.assertInstanceOf(SynchronizedDoubleDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableDoubleDoubleMap mutableMap = this.classUnderTest();
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
        MutableDoubleDoubleMap map = this.newWithKeysValues(1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(2.0, 1.0, 3.0, 2.0, 4.0, 3.0, 5.0, 4.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, 1.0, 2.0, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableDoubleDoubleMap map = this.newWithKeysValues(1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0);
        MutableDoubleDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableDoubleDoubleMap map = this.newWithKeysValues(1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0);
        DoubleSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleDoubleMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsKey, this.description("containsKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::clear, this.description("clear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKey, this.description("removeKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::remove, this.description("remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeKeyIfAbsent, this.description("removeKeyIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put, this.description("put"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getAndPut, this.description("getAndPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putPair, this.description("putPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValues, this.description("updateValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addToValue, this.description("addToValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_every_slot, this.description("put_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putDuplicateWithRemovedSlot, this.description("putDuplicateWithRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_Function, this.description("getIfAbsentPut_Function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithKey, this.description("getIfAbsentPutWithKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue, this.description("updateValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::freeze, this.description("freeze"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutKey, this.description("withoutKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withoutAllKeys, this.description("withoutAllKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAllKeyValues, this.description("withAllKeyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::doubleIterator_with_remove, this.description("doubleIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_invocation_of_remove_before_next, this.description("iterator_throws_on_invocation_of_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_consecutive_invocation_of_remove, this.description("iterator_throws_on_consecutive_invocation_of_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serialize, this.description("serialize"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::serializeKeySet, this.description("serializeKeySet"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableDoubleDoubleMapTestCase implementation();
    }
}
