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
import org.eclipse.collections.api.block.function.primitive.CharToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharDoubleMapTestCase extends AbstractCharDoubleMapTestCase {

    @Override
    protected abstract MutableCharDoubleMap classUnderTest();

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1);

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2);

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3);

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4);

    @Override
    protected abstract MutableCharDoubleMap getEmptyMap();

    @Override
    @Test
    public void get() {
        super.get();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.put((char) 0, 1.0);
        Assert.assertEquals(1.0, map1.get((char) 0), 0.0);
        map1.put((char) 0, 0.0);
        Assert.assertEquals(0.0, map1.get((char) 0), 0.0);
        map1.put((char) 5, 5.0);
        Assert.assertEquals(5.0, map1.get((char) 5), 0.0);
        map1.put((char) 35, 35.0);
        Assert.assertEquals(35.0, map1.get((char) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((char) 0), 0.0);
        map1.put((char) 1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((char) 1), 0.0);
        map1.put((char) 5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow((char) 5), 0.0);
        map1.put((char) 35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow((char) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5.0, map1.getIfAbsent((char) 0, 5.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((char) 1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((char) 33, 6.0), 0.0);
        map1.put((char) 0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((char) 0, 5.0), 0.0);
        map1.put((char) 1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((char) 1, 5.0), 0.0);
        map1.put((char) 5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent((char) 5, 6.0), 0.0);
        map1.put((char) 35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent((char) 35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0.0, map1.get((char) 0), 0.0);
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0.0, map1.get((char) 0), 0.0);
        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0.0, map1.get((char) 1), 0.0);
        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0.0, map1.get((char) 31), 0.0);
        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0.0, map1.get((char) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.put((char) 35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.put((char) 35, 35.0);
        Assert.assertTrue(map1.contains(35.0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableCharDoubleMap hashMap1 = this.newWithKeysValues((char) 1, 1.0, (char) 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharDoubleMap hashMap = this.newWithKeysValues((char) 6, 6.0, (char) 5, 5.0);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++) {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharDoubleHashMap(), map1);
        map1.put((char) 1, 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new CharDoubleHashMap(), map1);
        map1.put((char) 33, 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new CharDoubleHashMap(), map1);
    }

    @Test
    public void removeKey() {
        MutableCharDoubleMap map0 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharDoubleHashMap(), map0);
        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharDoubleHashMap(), map1);
        MutableCharDoubleMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 31, 31.0, (char) 32, 32.0), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove() {
        MutableCharDoubleMap map0 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map0.remove((char) 1);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharDoubleHashMap(), map0);
        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map1.remove((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharDoubleHashMap(), map1);
        MutableCharDoubleMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 31, 31.0, (char) 32, 32.0), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableCharDoubleMap map0 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        MutableCharDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 50, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 31, 31.0, (char) 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent((char) 31, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent((char) 32, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 32, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Verify.assertEmpty(map2);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put() {
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.put((char) 0, 1.0);
        map1.put((char) 31, 32.0);
        map1.put((char) 32, 33.0);
        CharDoubleHashMap expected = CharDoubleHashMap.newWithKeysValues((char) 0, 1.0, (char) 31, 32.0, (char) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.put((char) 1, 2.0);
        expected.put((char) 1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.put((char) 33, 34.0);
        expected.put((char) 33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.put((char) 30, 31.0);
        expected.put((char) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void getAndPut() {
        MutableCharDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(0, map1.getAndPut((char) 0, 25.0, 50.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((char) 0, 35.0, 50.0), 0.0);
        Assert.assertEquals(35, map1.getAndPut((char) 0, 45.0, 55.0), 0.0);
        Assert.assertEquals(100, map1.getAndPut((char) 10, 25.0, 100.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((char) 10, 25.0, 30.0), 0.0);
        map1.removeKey((char) 10);
        Assert.assertEquals(101, map1.getAndPut((char) 10, 25.0, 101.0), 0.0);
        Assert.assertEquals(25, map1.getAndPut((char) 10, 27.0, 105.0), 0.0);
    }

    @Test
    public void putPair() {
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1.0));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32.0));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33.0));
        CharDoubleHashMap expected = CharDoubleHashMap.newWithKeysValues((char) 0, 1.0, (char) 31, 32.0, (char) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 1, 2.0));
        expected.put((char) 1, 2.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 33, 34.0));
        expected.put((char) 33, 34.0);
        Assert.assertEquals(expected, map1);
        map1.putPair(PrimitiveTuples.pair((char) 30, 31.0));
        expected.put((char) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void updateValues() {
        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 11.0, (char) 1, 12.0, (char) 2, 13.0);
        map1.updateValues((k, v) -> v);
        MutableCharDoubleMap expected1 = this.newWithKeysValues((char) 0, 11.0, (char) 1, 12.0, (char) 2, 13.0);
        Assert.assertEquals(expected1, map1);
        MutableCharDoubleMap map2 = this.newWithKeysValues((char) 0, 11.0, (char) 1, 12.0, (char) 2, 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableCharDoubleMap expected2 = this.newWithKeysValues((char) 0, 12.0, (char) 1, 13.0, (char) 2, 14.0);
        Assert.assertEquals(expected2, map2);
        MutableCharDoubleMap map3 = this.newWithKeysValues((char) 0, 11.0, (char) 1, 12.0, (char) 2, 13.0);
        map3.updateValues((k, v) -> k == (char) 0 ? 10.0 : v);
        MutableCharDoubleMap expected3 = this.newWithKeysValues((char) 0, 10.0, (char) 1, 12.0, (char) 2, 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void addToValue() {
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((char) 0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((char) 31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((char) 1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((char) 0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((char) 1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((char) 31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((char) 32, 33.0), 0.0);
        CharDoubleHashMap expected = CharDoubleHashMap.newWithKeysValues((char) 0, 11.0, (char) 1, 12.0, (char) 31, 37.0, (char) 32, 33.0);
        Assert.assertEquals(expected, map1);
        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5.0, map1.addToValue((char) 31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((char) 31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((char) 32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((char) 1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((char) 0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((char) 1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((char) 0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);
        MutableCharDoubleMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(936628237L, 4889384619L, 8733915902L, 2377747912L, 277382636L, 593670575L, 296725141L, 7131901003L, 9986389012L);
        list.forEachWithIndex((each, index) -> {
            char k = (char) each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot() {
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((char) i), 0.0);
            hashMap.put((char) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((char) i), 0.0);
            hashMap.remove((char) i);
            Assert.assertEquals(0.0, hashMap.get((char) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharDoubleMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharDoubleMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharDoubleMapTestCase.generateCollisions().get(3);
        MutableCharDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableCharDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableCharDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut() {
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 1, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 50.0, (char) 1, 50.0), map1);
        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 1, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 50.0, (char) 1, 50.0), map2);
        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((char) 32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((char) 32, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 50.0), map3);
        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((char) 33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((char) 33, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 0, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 1, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 100.0, (char) 1, 100.0), map1);
        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 1, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 0, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 100.0, (char) 1, 100.0), map2);
        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((char) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((char) 32, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 100.0), map3);
        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((char) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((char) 33, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> {
            throw new AssertionError();
        };
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 9.0, (char) 1, 9.0), map1);
        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 9.0, (char) 1, 9.0), map2);
        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 9.0), map3);
        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToDoubleFunction function = (char charParameter) -> (double) charParameter;
        CharToDoubleFunction functionThrows = (char charParameter) -> {
            throw new AssertionError();
        };
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((char) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((char) 0, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((char) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((char) 1, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0), map1);
        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((char) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((char) 1, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((char) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((char) 0, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0), map2);
        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((char) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((char) 32, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map3);
        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((char) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((char) 33, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 33.0), map4);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0, (char) 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0, (char) 1, 2.0), map1);
        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 1.0, (char) 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0, (char) 1, 2.0), map2);
        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((char) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue((char) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 2.0), map3);
    }

    @Test
    public void freeze() {
        MutableCharDoubleMap mutableCharDoubleMap = this.classUnderTest();
        CharSet frozenSet = mutableCharDoubleMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharDoubleMap.put((char) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharDoubleMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharDoubleMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharDoubleMap mutableCharDoubleMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharDoubleMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharDoubleMapForClear.keySet().toArray());
        mutableCharDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 31, 31.0, (char) 32, 32.0);
        MutableCharDoubleMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 31, 31.0, (char) 32, 32.0);
        MutableCharDoubleMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues() {
        MutableCharDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1.0), hashMap);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), hashMap);
    }

    @Test
    public void withAllKeyValues() {
        MutableCharDoubleMap emptyMap = this.getEmptyMap();
        MutableCharDoubleMap partialMap = this.newWithKeysValues((char) 1, 1.0, (char) 3, 3.0);
        MutableCharDoubleMap completeMap = this.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);
        Iterable<CharDoublePair> emptyIterable = Iterables.iList();
        Iterable<CharDoublePair> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1.0), PrimitiveTuples.pair((char) 3, 3.0));
        Iterable<CharDoublePair> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, 1.0), PrimitiveTuples.pair((char) 2, 2.0), PrimitiveTuples.pair((char) 3, 3.0), PrimitiveTuples.pair((char) 4, 4.0));
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
        Verify.assertInstanceOf(SynchronizedCharDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove() {
        MutableCharDoubleMap mutableMap = this.classUnderTest();
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
        MutableCharDoubleMap map = this.newWithKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(2.0, (char) 1, 3.0, (char) 2, 4.0, (char) 3, 5.0, (char) 4), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1.0, (char) 2, 1.0).flipUniqueValues());
    }

    @Test
    public void serialize() {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0);
        MutableCharDoubleMap map2 = SerializeTestHelper.serializeDeserialize(map);
        Assert.assertEquals(map, map2);
    }

    @Test
    public void serializeKeySet() {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0);
        CharSet set = SerializeTestHelper.serializeDeserialize(map.keySet());
        Assert.assertEquals(map.keySet(), set);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharDoubleMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharDoubleMapTestCase> serializeKeySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharDoubleMapTestCase::values;
            this.payloads.containsAll = AbstractMutableCharDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableCharDoubleMapTestCase::containsAll_Iterable;
            this.payloads.isEmpty = AbstractMutableCharDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharDoubleMapTestCase::notEmpty;
            this.payloads.testEquals = AbstractMutableCharDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractMutableCharDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableCharDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableCharDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableCharDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableCharDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractMutableCharDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractMutableCharDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractMutableCharDoubleMapTestCase::collect;
            this.payloads.count = AbstractMutableCharDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractMutableCharDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractMutableCharDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableCharDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableCharDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractMutableCharDoubleMapTestCase::max;
            this.payloads.min = AbstractMutableCharDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractMutableCharDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractMutableCharDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractMutableCharDoubleMapTestCase::sum;
            this.payloads.average = AbstractMutableCharDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableCharDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractMutableCharDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableCharDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractMutableCharDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractMutableCharDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractMutableCharDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractMutableCharDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractMutableCharDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractMutableCharDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractMutableCharDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractMutableCharDoubleMapTestCase::chunk;
            this.payloads.get = AbstractMutableCharDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableCharDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableCharDoubleMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractMutableCharDoubleMapTestCase::contains;
            this.payloads.size = AbstractMutableCharDoubleMapTestCase::size;
            this.payloads.clear = AbstractMutableCharDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharDoubleMapTestCase::remove;
            this.payloads.removeKeyIfAbsent = AbstractMutableCharDoubleMapTestCase::removeKeyIfAbsent;
            this.payloads.put = AbstractMutableCharDoubleMapTestCase::put;
            this.payloads.getAndPut = AbstractMutableCharDoubleMapTestCase::getAndPut;
            this.payloads.putPair = AbstractMutableCharDoubleMapTestCase::putPair;
            this.payloads.updateValues = AbstractMutableCharDoubleMapTestCase::updateValues;
            this.payloads.addToValue = AbstractMutableCharDoubleMapTestCase::addToValue;
            this.payloads.put_every_slot = AbstractMutableCharDoubleMapTestCase::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = AbstractMutableCharDoubleMapTestCase::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharDoubleMapTestCase::updateValue;
            this.payloads.freeze = AbstractMutableCharDoubleMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharDoubleMapTestCase::withoutAllKeys;
            this.payloads.withKeysValues = AbstractMutableCharDoubleMapTestCase::withKeysValues;
            this.payloads.withAllKeyValues = AbstractMutableCharDoubleMapTestCase::withAllKeyValues;
            this.payloads.asSynchronized = AbstractMutableCharDoubleMapTestCase::asSynchronized;
            this.payloads.asUnmodifiable = AbstractMutableCharDoubleMapTestCase::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = AbstractMutableCharDoubleMapTestCase::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = AbstractMutableCharDoubleMapTestCase::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = AbstractMutableCharDoubleMapTestCase::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = AbstractMutableCharDoubleMapTestCase::flipUniqueValues;
            this.payloads.serialize = AbstractMutableCharDoubleMapTestCase::serialize;
            this.payloads.serializeKeySet = AbstractMutableCharDoubleMapTestCase::serializeKeySet;
        }
    }
*/
}
