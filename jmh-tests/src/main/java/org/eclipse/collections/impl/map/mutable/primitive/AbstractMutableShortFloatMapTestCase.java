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
import org.eclipse.collections.api.block.function.primitive.ShortToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableShortFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortFloatMapTestCase extends AbstractShortFloatMapTestCase {

    @Override
    protected abstract MutableShortFloatMap classUnderTest();

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1);

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2);

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3);

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4);

    @Override
    protected abstract MutableShortFloatMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.get((short) 0), 0.0);
        map1.put((short) 0, 0.0f);
        Assert.assertEquals(0.0f, map1.get((short) 0), 0.0);
        map1.put((short) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.get((short) 5), 0.0);
        map1.put((short) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.get((short) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((short) 0), 0.0);
        map1.put((short) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((short) 1), 0.0);
        map1.put((short) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow((short) 5), 0.0);
        map1.put((short) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow((short) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5.0f, map1.getIfAbsent((short) 0, 5.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((short) 1, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((short) 33, 6.0f), 0.0);
        map1.put((short) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((short) 0, 5.0f), 0.0);
        map1.put((short) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((short) 1, 5.0f), 0.0);
        map1.put((short) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent((short) 5, 6.0f), 0.0);
        map1.put((short) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent((short) 35, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0f, map1.get((short) 0), 0.0);
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0f, map1.get((short) 0), 0.0);
        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0.0f, map1.get((short) 1), 0.0);
        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0.0f, map1.get((short) 31), 0.0);
        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0.0f, map1.get((short) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.put((short) 35, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.put((short) 35, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableShortFloatMap hashMap1 = this.newWithKeysValues((short) 1, 1.0f, (short) 0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortFloatMap hashMap = this.newWithKeysValues((short) 6, 6.0f, (short) 5, 5.0f);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortFloatHashMap(), map1);
        map1.put((short) 1, 0.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ShortFloatHashMap(), map1);
        map1.put((short) 33, 0.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ShortFloatHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableShortFloatMap map0 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortFloatHashMap(), map0);
        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortFloatHashMap(), map1);
        MutableShortFloatMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableShortFloatMap map0 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map0.remove((short) 1);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortFloatHashMap(), map0);
        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map1.remove((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortFloatHashMap(), map1);
        MutableShortFloatMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableShortFloatMap map0 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        MutableShortFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 5, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 50, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 31, 31.0f, (short) 32, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent((short) 31, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent((short) 32, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 31, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 32, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0f);
        map1.put((short) 31, 32.0f);
        map1.put((short) 32, 33.0f);
        ShortFloatHashMap expected = ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f, (short) 31, 32.0f, (short) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.put((short) 1, 2.0f);
        expected.put((short) 1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.put((short) 33, 34.0f);
        expected.put((short) 33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.put((short) 30, 31.0f);
        expected.put((short) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableShortFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((short) 0, 25.0f, 50.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((short) 0, 35.0f, 50.0f), 0.0);
        Assert.assertEquals(35, map1.getAndPut((short) 0, 45.0f, 55.0f), 0.0);
        Assert.assertEquals(100, map1.getAndPut((short) 10, 25.0f, 100.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((short) 10, 25.0f, 30.0f), 0.0);
        map1.removeKey((short) 10);
        Assert.assertEquals(101, map1.getAndPut((short) 10, 25.0f, 101.0f), 0.0);
        Assert.assertEquals(25, map1.getAndPut((short) 10, 27.0f, 105.0f), 0.0);
    }

    @Test
    public void putPair() {
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1.0f));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32.0f));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33.0f));
        ShortFloatHashMap expected = ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f, (short) 31, 32.0f, (short) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 1, 2.0f));
        expected.put((short) 1, 2.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 33, 34.0f));
        expected.put((short) 33, 34.0f);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((short) 30, 31.0f));
        expected.put((short) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 11.0f, (short) 1, 12.0f, (short) 2, 13.0f);
        map1.updateValues((k, v) -> v);
        MutableShortFloatMap expected1 = this.newWithKeysValues((short) 0, 11.0f, (short) 1, 12.0f, (short) 2, 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableShortFloatMap map2 = this.newWithKeysValues((short) 0, 11.0f, (short) 1, 12.0f, (short) 2, 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableShortFloatMap expected2 = this.newWithKeysValues((short) 0, 12.0f, (short) 1, 13.0f, (short) 2, 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableShortFloatMap map3 = this.newWithKeysValues((short) 0, 11.0f, (short) 1, 12.0f, (short) 2, 13.0f);
        map3.updateValues((k, v) -> k == (short) 0 ? 10.0f : v);
        MutableShortFloatMap expected3 = this.newWithKeysValues((short) 0, 10.0f, (short) 1, 12.0f, (short) 2, 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((short) 31, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0f), 0.0);
        ShortFloatHashMap expected = ShortFloatHashMap.newWithKeysValues((short) 0, 11.0f, (short) 1, 12.0f, (short) 31, 37.0f, (short) 32, 33.0f);
        Assert.assertEquals(expected, map1);
        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5.0, map1.addToValue((short) 31, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);
        MutableShortFloatMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            short k = (short) each;
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((short) i), 0.0);
            hashMap.put((short) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((short) i), 0.0);
            hashMap.remove((short) i);
            Assert.assertEquals(0.0f, hashMap.get((short) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortFloatMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortFloatMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortFloatMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortFloatMapTestCase.generateCollisions().get(3);
        MutableShortFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableShortFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableShortFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 50.0f, (short) 1, 50.0f), map1);
        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 50.0f, (short) 1, 50.0f), map2);
        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 50.0f), map3);
        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 100.0f, (short) 1, 100.0f), map1);
        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 100.0f, (short) 1, 100.0f), map2);
        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 100.0f), map3);
        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 9.0f, (short) 1, 9.0f), map1);
        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 9.0f, (short) 1, 9.0f), map2);
        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 9.0f), map3);
        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToFloatFunction function = (short shortParameter) -> (float) shortParameter;
        ShortToFloatFunction functionThrows = (short shortParameter) -> {
            throw new AssertionError();
        };
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f), map1);
        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f), map2);
        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map3);
        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 33.0f), map4);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f, (short) 1, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f, (short) 1, 2.0f), map1);
        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f, (short) 1, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f, (short) 1, 2.0f), map2);
        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((short) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue((short) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 2.0f), map3);
    }

    @Test
    public void freeze() {
        MutableShortFloatMap mutableShortFloatMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortFloatMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortFloatMap.put((short) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortFloatMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortFloatMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortFloatMap mutableShortFloatMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortFloatMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortFloatMapForClear.keySet().toArray());
        mutableShortFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 31, 31.0f, (short) 32, 32.0f);
        MutableShortFloatMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 31, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 31, 31.0f, (short) 32, 32.0f);
        MutableShortFloatMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 31, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableShortFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1.0f), hashMap);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableShortFloatMap emptyMap = this.getEmptyMap();
        MutableShortFloatMap partialMap = this.newWithKeysValues((short) 1, 1.0f, (short) 3, 3.0f);
        MutableShortFloatMap completeMap = this.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Iterable<ShortFloatPair> emptyIterable = Iterables.iList();
        Iterable<ShortFloatPair> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1.0f), PrimitiveTuples.pair((short) 3, 3.0f));
        Iterable<ShortFloatPair> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, 1.0f), PrimitiveTuples.pair((short) 2, 2.0f), PrimitiveTuples.pair((short) 3, 3.0f), PrimitiveTuples.pair((short) 4, 4.0f));
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
        Verify.assertInstanceOf(SynchronizedShortFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove() {
        MutableShortFloatMap mutableMap = this.classUnderTest();
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
        MutableShortFloatMap map = this.newWithKeysValues((short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4, 5.0f);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(2.0f, (short) 1, 3.0f, (short) 2, 4.0f, (short) 3, 5.0f, (short) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1.0f, (short) 2, 1.0f).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableShortFloatMap map = this.newWithKeysValues((short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4, 5.0f);
        MutableShortFloatMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableShortFloatMap map = this.newWithKeysValues((short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4, 5.0f);
        ShortSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortFloatMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortFloatMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortFloatMapTestCase::values;
            this.payloads.containsAll = AbstractMutableShortFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableShortFloatMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableShortFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortFloatMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableShortFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortFloatMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableShortFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableShortFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableShortFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableShortFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableShortFloatMapTestCase::reject;
            this.payloads.select_value = AbstractMutableShortFloatMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableShortFloatMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableShortFloatMapTestCase::collect;
            this.payloads.count = AbstractMutableShortFloatMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableShortFloatMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableShortFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableShortFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableShortFloatMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableShortFloatMapTestCase::max;
            this.payloads.min = AbstractMutableShortFloatMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortFloatMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortFloatMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableShortFloatMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableShortFloatMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableShortFloatMapTestCase::sum;
            this.payloads.average = AbstractMutableShortFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableShortFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableShortFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableShortFloatMapTestCase::toBag;
            this.payloads.floatIterator = AbstractMutableShortFloatMapTestCase::floatIterator;
            this.payloads.asLazy = AbstractMutableShortFloatMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableShortFloatMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableShortFloatMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableShortFloatMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableShortFloatMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableShortFloatMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableShortFloatMapTestCase::chunk;
            this.payloads.get = AbstractMutableShortFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableShortFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableShortFloatMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortFloatMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableShortFloatMapTestCase::contains;
            this.payloads.size = AbstractMutableShortFloatMapTestCase::size;
            this.payloads.clear = AbstractMutableShortFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortFloatMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableShortFloatMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableShortFloatMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableShortFloatMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableShortFloatMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableShortFloatMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableShortFloatMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableShortFloatMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableShortFloatMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortFloatMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableShortFloatMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortFloatMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableShortFloatMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableShortFloatMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableShortFloatMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableShortFloatMapTestCase::asUnmodifiable;
            this.payloads.floatIterator_with_remove = AbstractMutableShortFloatMapTestCase::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableShortFloatMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableShortFloatMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableShortFloatMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableShortFloatMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableShortFloatMapTestCase::serializeKeySet;
        }
    }
*/
}
