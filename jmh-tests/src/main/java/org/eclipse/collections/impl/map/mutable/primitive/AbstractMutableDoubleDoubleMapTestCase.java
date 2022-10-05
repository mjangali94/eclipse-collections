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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleDoubleMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableDoubleDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableDoubleDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableDoubleDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableDoubleDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableDoubleDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableDoubleDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableDoubleDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableDoubleDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableDoubleDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableDoubleDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableDoubleDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableDoubleDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableDoubleDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableDoubleDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableDoubleDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableDoubleDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableDoubleDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableDoubleDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableDoubleDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableDoubleDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableDoubleDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableDoubleDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableDoubleDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableDoubleDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableDoubleDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableDoubleDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableDoubleDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableDoubleDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableDoubleDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableDoubleDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableDoubleDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableDoubleDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableDoubleDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableDoubleDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableDoubleDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableDoubleDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableDoubleDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableDoubleDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableDoubleDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableDoubleDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableDoubleDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableDoubleDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableDoubleDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableDoubleDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableDoubleDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableDoubleDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableDoubleDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableDoubleDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableDoubleDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableDoubleDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableDoubleDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableDoubleDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableDoubleDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableDoubleDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableDoubleDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableDoubleDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableDoubleDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableDoubleDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableDoubleDoubleMapTestCase::serializeKeySet;
        }
    }
}
