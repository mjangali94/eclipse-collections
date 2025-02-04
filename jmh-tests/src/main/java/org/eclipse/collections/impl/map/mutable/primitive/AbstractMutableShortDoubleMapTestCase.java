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
import org.eclipse.collections.api.block.function.primitive.ShortToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableShortDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortDoubleMapTestCase extends AbstractShortDoubleMapTestCase {

    @Override
    protected abstract MutableShortDoubleMap classUnderTest();

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1);

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2);

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3);

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3, short key4, double value4);

    @Override
    protected abstract MutableShortDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0);
        Assert.assertEquals(1.0, map1.get((short) 0), 0.0);
        map1.put((short) 0, 0.0);
        Assert.assertEquals(0.0, map1.get((short) 0), 0.0);
        map1.put((short) 5, 5.0);
        Assert.assertEquals(5.0, map1.get((short) 5), 0.0);
        map1.put((short) 35, 35.0);
        Assert.assertEquals(35.0, map1.get((short) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((short) 0), 0.0);
        map1.put((short) 1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((short) 1), 0.0);
        map1.put((short) 5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow((short) 5), 0.0);
        map1.put((short) 35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow((short) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5.0, map1.getIfAbsent((short) 0, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((short) 1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((short) 33, 6.0), 0.0);
        map1.put((short) 0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((short) 0, 5.0), 0.0);
        map1.put((short) 1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((short) 1, 5.0), 0.0);
        map1.put((short) 5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent((short) 5, 6.0), 0.0);
        map1.put((short) 35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent((short) 35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0, map1.get((short) 0), 0.0);
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0, map1.get((short) 0), 0.0);
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0.0, map1.get((short) 1), 0.0);
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0.0, map1.get((short) 31), 0.0);
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0.0, map1.get((short) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.put((short) 35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.put((short) 35, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortDoubleMap hashMap1 = this.newWithKeysValues((short) 1, 1.0, (short) 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortDoubleMap hashMap = this.newWithKeysValues((short) 6, 6.0, (short) 5, 5.0);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
        map1.put((short) 1, 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
        map1.put((short) 33, 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortDoubleMap map0 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortDoubleHashMap(), map0);
        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
        MutableShortDoubleMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 31, 31.0, (short) 32, 32.0), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableShortDoubleMap map0 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map0.remove((short) 1);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortDoubleHashMap(), map0);
        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map1.remove((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
        MutableShortDoubleMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 31, 31.0, (short) 32, 32.0), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortDoubleMap map0 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        MutableShortDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 50, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 31, 31.0, (short) 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent((short) 31, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent((short) 32, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 32, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0);
        map1.put((short) 31, 32.0);
        map1.put((short) 32, 33.0);
        ShortDoubleHashMap expected = ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0, (short) 31, 32.0, (short) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, 2.0);
        expected.put((short) 1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, 34.0);
        expected.put((short) 33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, 31.0);
        expected.put((short) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((short) 0, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut((short) 0, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut((short) 10, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((short) 10, 25.0, 30.0), 0.0);
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((short) 10, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1.0));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32.0));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33.0));
        ShortDoubleHashMap expected = ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0, (short) 31, 32.0, (short) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, 2.0));
        expected.put((short) 1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, 34.0));
        expected.put((short) 33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, 31.0));
        expected.put((short) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 11.0, (short) 1, 12.0, (short) 2, 13.0);
        map1.updateValues((k, v) -> v);
        MutableShortDoubleMap expected1 = this.newWithKeysValues((short) 0, 11.0, (short) 1, 12.0, (short) 2, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableShortDoubleMap map2 = this.newWithKeysValues((short) 0, 11.0, (short) 1, 12.0, (short) 2, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableShortDoubleMap expected2 = this.newWithKeysValues((short) 0, 12.0, (short) 1, 13.0, (short) 2, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableShortDoubleMap map3 = this.newWithKeysValues((short) 0, 11.0, (short) 1, 12.0, (short) 2, 13.0);
        map3.updateValues((k, v) -> k == (short) 0 ? 10.0 : v);
        MutableShortDoubleMap expected3 = this.newWithKeysValues((short) 0, 10.0, (short) 1, 12.0, (short) 2, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((short) 31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0), 0.0);
        ShortDoubleHashMap expected = ShortDoubleHashMap.newWithKeysValues((short) 0, 11.0, (short) 1, 12.0, (short) 31, 37.0, (short) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5.0, map1.addToValue((short) 31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableShortDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((short) i), 0.0);
            hashMap.put((short) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((short) i), 0.0);
            hashMap.remove((short) i);
            Assert.assertEquals(0.0, hashMap.get((short) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortDoubleMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortDoubleMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortDoubleMapTestCase.generateCollisions().get(3);
        MutableShortDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableShortDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableShortDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 50.0, (short) 1, 50.0), map1);
        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 50.0, (short) 1, 50.0), map2);
        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 50.0), map3);
        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 100.0, (short) 1, 100.0), map1);
        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 100.0, (short) 1, 100.0), map2);
        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 100.0), map3);
        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 9.0, (short) 1, 9.0), map1);
        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 9.0, (short) 1, 9.0), map2);
        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 9.0), map3);
        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToDoubleFunction function = (short shortParameter) -> (double) shortParameter;
        ShortToDoubleFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0), map1);
        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0), map2);
        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map3);
        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0, (short) 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0, (short) 1, 2.0), map1);
        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0, (short) 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0, (short) 1, 2.0), map2);
        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((short) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue((short) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableShortDoubleMap mutableShortDoubleMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortDoubleMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortDoubleMap.put((short) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortDoubleMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortDoubleMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortDoubleMap mutableShortDoubleMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortDoubleMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortDoubleMapForClear.keySet().toArray());
        mutableShortDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortDoubleMap map = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 31, 31.0, (short) 32, 32.0);
        MutableShortDoubleMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortDoubleMap map = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 31, 31.0, (short) 32, 32.0);
        MutableShortDoubleMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1.0), hashMap);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortDoubleMap emptyMap = this.getEmptyMap();
        MutableShortDoubleMap partialMap = this.newWithKeysValues((short) 1, 1.0, (short) 3, 3.0);
        MutableShortDoubleMap completeMap = this.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);
        Iterable<ShortDoublePair> emptyIterable = Iterables.iList();
        Iterable<ShortDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1.0), PrimitiveTuples.pair((short) 3, 3.0));
        Iterable<ShortDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1.0), PrimitiveTuples.pair((short) 2, 2.0), PrimitiveTuples.pair((short) 3, 3.0), PrimitiveTuples.pair((short) 4, 4.0));
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
        Verify.assertInstanceOf(SynchronizedShortDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableShortDoubleMap mutableMap = this.classUnderTest();
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
        MutableShortDoubleMap map = this.newWithKeysValues((short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4, 5.0);
        Assert.assertEquals(DoubleShortHashMap.newWithKeysValues(2.0, (short) 1, 3.0, (short) 2, 4.0, (short) 3, 5.0, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1.0, (short) 2, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortDoubleMap map = this.newWithKeysValues((short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4, 5.0);
        MutableShortDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortDoubleMap map = this.newWithKeysValues((short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4, 5.0);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortDoubleMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableShortDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableShortDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableShortDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableShortDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableShortDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableShortDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableShortDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableShortDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableShortDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortDoubleMapTestCase::serializeKeySet;
        }
    }
}
