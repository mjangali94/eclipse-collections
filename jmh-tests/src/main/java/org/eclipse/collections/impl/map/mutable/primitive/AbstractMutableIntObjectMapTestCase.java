/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Iterator;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.tuple.primitive.IntObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableIntObjectMapTestCase extends AbstractIntObjectMapTestCase {

    private final MutableIntObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableIntObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableIntObjectMap<T> newWithKeysValues(int key1, T value1);

    @Override
    protected abstract <T> MutableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2);

    @Override
    protected abstract <T> MutableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2, int key3, T value3);

    @Override
    protected abstract <T> MutableIntObjectMap<T> getEmptyMap();

    protected static IntArrayList generateCollisions() {
        IntArrayList collisions = new IntArrayList();
        IntObjectHashMap<?> hashMap = new IntObjectHashMap<>();
        for (int i = 2; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(2)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableIntObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put(0, new Object());
        hashMap.clear();
        Assert.assertEquals(new IntObjectHashMap<>(), hashMap);
        hashMap.put(1, new Object());
        hashMap.clear();
        Assert.assertEquals(new IntObjectHashMap<>(), hashMap);
        hashMap.put(33, new Object());
        hashMap.clear();
        Assert.assertEquals(new IntObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey(5));
        Assert.assertNull(this.map.removeKey(50));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(31, "thirtyOne", 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey(31));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32));
        Assert.assertEquals(new IntObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey(0));
        Assert.assertNull(this.map.removeKey(1));
        Assert.assertNull(this.map.removeKey(31));
        Assert.assertNull(this.map.removeKey(32));
        Assert.assertEquals(new IntObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableIntObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableIntObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst()));
        MutableIntObjectMap<String> map1 = this.newWithKeysValues(0, "zero", 1, "one");
        Assert.assertEquals("zero", map1.removeKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), map1);
        Assert.assertEquals("one", map1.removeKey(1));
        Assert.assertEquals(IntObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove(5));
        Assert.assertNull(this.map.remove(50));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(31, "thirtyOne", 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove(31));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove(32));
        Assert.assertEquals(new IntObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove(0));
        Assert.assertNull(this.map.remove(1));
        Assert.assertNull(this.map.remove(31));
        Assert.assertNull(this.map.remove(32));
        Assert.assertEquals(new IntObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableIntObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableIntObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst()));
        MutableIntObjectMap<String> map1 = this.newWithKeysValues(0, "zero", 1, "one");
        Assert.assertEquals("zero", map1.remove(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), map1);
        Assert.assertEquals("one", map1.remove(1));
        Assert.assertEquals(IntObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put(0, "one"));
        Assert.assertEquals("thirtyOne", this.map.put(31, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put(32, "thirtyThree"));
        IntObjectHashMap<String> expected = IntObjectHashMap.newWithKeysValues(0, "one", 31, "thirtyTwo", 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(1, "two"));
        Assert.assertEquals("two", this.map.put(1, "two"));
        expected.put(1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(33, "thirtyFour"));
        expected.put(33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(30, "thirtyOne"));
        expected.put(30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(5, null));
        expected.put(5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(50, null));
        expected.put(50, null);
        Assert.assertEquals(expected, this.map);
        MutableIntObjectMap<String> emptyMap = IntObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put(0, "zero"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero"), emptyMap);
        MutableIntObjectMap<String> emptyMap1 = IntObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put(1, "one"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put(0, "zero"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero", 1, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair(0, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair(31, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair(32, "thirtyThree")));
        IntObjectHashMap<String> expected = IntObjectHashMap.newWithKeysValues(0, "one", 31, "thirtyTwo", 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(1, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair(1, "two")));
        expected.put(1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(33, "thirtyFour")));
        expected.put(33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(30, "thirtyOne")));
        expected.put(30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(5, null)));
        expected.put(5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(50, null)));
        expected.put(50, null);
        Assert.assertEquals(expected, this.map);
        MutableIntObjectMap<String> emptyMap = IntObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair(0, "zero")));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero"), emptyMap);
        MutableIntObjectMap<String> emptyMap1 = IntObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(1, "one")));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(0, "zero")));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero", 1, "one"), emptyMap1);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntObjectMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntObjectMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntObjectMapTestCase.generateCollisions().get(3);
        MutableIntObjectMap<String> hashMap = IntObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableIntObjectMap<String> hashMap1 = IntObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableIntObjectMap<String> hashMap2 = IntObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableIntObjectMap<String> hashMap = this.getEmptyMap();
        MutableIntObjectMap<String> copyMap = IntObjectHashMap.newMap();
        for (int i = 1; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (int i = 1; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0, "zeroValue"));
        MutableIntObjectMap<String> expected = IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1, "oneValue"));
        expected.put(1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2, () -> null));
        expected.put(2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33, "thirtyThreeValue"));
        expected.put(33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34, () -> null));
        expected.put(34, null);
        Assert.assertEquals(expected, this.map);
        MutableIntObjectMap<String> emptyMap = IntObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0, "zeroValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1, "oneValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue", 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1, "twoValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue", 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0, "zeroValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue", 1, "oneValue"), emptyMap);
        MutableIntObjectMap<String> emptyMap1 = IntObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1, "oneValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0, () -> "zeroValue"));
        MutableIntObjectMap<String> expected = IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1, () -> "oneValue"));
        expected.put(1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2, () -> null));
        expected.put(2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33, () -> "thirtyThreeValue"));
        expected.put(33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34, () -> null));
        expected.put(34, null);
        Assert.assertEquals(expected, this.map);
        MutableIntObjectMap<String> emptyMap = IntObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0, () -> "zeroValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1, () -> "oneValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue", 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1, () -> "twoValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue", 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0, () -> "zeroValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zeroValue", 1, "oneValue"), emptyMap);
        MutableIntObjectMap<String> emptyMap1 = IntObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1, () -> "oneValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0, toUpperCase, "zeroValue"));
        IntObjectHashMap<String> expected = IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith(1, toUpperCase, "oneValue"));
        expected.put(1, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(2, string -> null, ""));
        expected.put(2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith(32, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith(33, toUpperCase, "thirtyThreeValue"));
        expected.put(33, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(34, string -> null, ""));
        expected.put(34, null);
        Assert.assertEquals(expected, this.map);
        MutableIntObjectMap<String> emptyMap = IntObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0, toUpperCase, "zeroValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1, toUpperCase, "oneValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "ZEROVALUE", 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1, toUpperCase, "twoValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "ZEROVALUE", 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0, toUpperCase, "zeroValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "ZEROVALUE", 1, "ONEVALUE"), emptyMap);
        MutableIntObjectMap<String> emptyMap1 = IntObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith(1, toUpperCase, "oneValue"));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0, toString));
        IntObjectHashMap<String> expected = IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("1", this.map.getIfAbsentPutWithKey(1, toString));
        expected.put(1, "1");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(2, (int intParameter) -> null));
        expected.put(2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey(32, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("33", this.map.getIfAbsentPutWithKey(33, toString));
        expected.put(33, "33");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(34, (int intParameter) -> null));
        expected.put(34, null);
        Assert.assertEquals(expected, this.map);
        MutableIntObjectMap<String> emptyMap = IntObjectHashMap.newMap();
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey(0, toString));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "0"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey(1, toString));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "0", 1, "1"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey(1, toString));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "0", 1, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.removeKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey(0, toString));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "0", 1, "1"), emptyMap);
        MutableIntObjectMap<String> emptyMap1 = IntObjectHashMap.newMap();
        Assert.assertEquals("1", emptyMap1.getIfAbsentPutWithKey(1, toString));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "1"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableIntObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(0, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(0, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(1, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2, 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(1, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2, 1, 2), map1);
        MutableIntObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(1, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(1, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(0, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 1, 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(0, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2, 1, 2), map2);
        MutableIntObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue(33, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue(33, zeroFactory, incrementFunction));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(33, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableIntObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2, 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2, 1, 2), map1);
        MutableIntObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 1, 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, 2, 1, 2), map2);
        MutableIntObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith(33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith(33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableIntObjectMap<String> mutableIntObjectMap = this.classUnderTest();
        IntSet frozenSet = mutableIntObjectMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntObjectMap.put((int) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        IntSet frozenSetForRemove = mutableIntObjectMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableIntObjectMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableIntObjectMap<String> mutableIntObjectMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntObjectMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntObjectMapForClear.keySet().toArray());
        mutableIntObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableIntObjectMap<String> actual = this.map.withoutKey(55);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo"), actual);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(31, "thirtyOne", 32, "thirtyTwo"), this.map.withoutKey(0));
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(32, "thirtyTwo"), this.map.withoutKey(31));
        Assert.assertEquals(IntObjectHashMap.newMap(), this.map.withoutKey(32));
        Assert.assertEquals(IntObjectHashMap.newMap(), this.map.withoutKey(1));
    }

    @Test
    public void withoutAllKeys() {
        MutableIntObjectMap<String> actual = this.map.withoutAllKeys(IntArrayList.newListWith(55, 1));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo"), actual);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(32, "thirtyTwo"), this.map.withoutAllKeys(IntArrayList.newListWith(0, 31)));
        Assert.assertEquals(IntObjectHashMap.newMap(), this.map.withoutAllKeys(IntArrayList.newListWith(31, 32)));
        Assert.assertEquals(IntObjectHashMap.newMap(), this.map.withoutAllKeys(IntArrayList.newListWith(1)));
    }

    @Test
    public void withAllKeyValues() {
        MutableIntObjectMap<String> emptyMap = this.getEmptyMap();
        MutableIntObjectMap<String> partialMap = this.newWithKeysValues(1, "one", 3, "three");
        MutableIntObjectMap<String> completeMap = this.newWithKeysValues(1, "one", 2, "two", 3, "three");
        Iterable<IntObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<IntObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair(1, "one"), PrimitiveTuples.pair(3, "three"));
        Iterable<IntObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair(1, "one"), PrimitiveTuples.pair(2, "two"), PrimitiveTuples.pair(3, "three"));
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

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals("zero", this.map.put(0, "one"));
        Assert.assertEquals("one", this.map.get(0));
        Assert.assertNull(this.map.put(5, "five"));
        Assert.assertEquals("five", this.map.get(5));
        Assert.assertNull(this.map.put(35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get(35));
        Assert.assertNull(this.map.put(6, null));
        Assert.assertNull(this.map.get(6));
        Assert.assertNull(this.map.put(36, null));
        Assert.assertNull(this.map.get(36));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put(0, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent(0, ifAbsent));
        Assert.assertNull(this.map.put(5, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent(5, ifAbsent));
        Assert.assertNull(this.map.put(35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent(35, ifAbsent));
        Assert.assertNull(this.map.put(6, null));
        Assert.assertNull(this.map.getIfAbsent(6, ifAbsent));
        Assert.assertNull(this.map.put(36, null));
        Assert.assertNull(this.map.getIfAbsent(36, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey(0));
        Assert.assertFalse(this.map.containsKey(0));
        Assert.assertEquals("thirtyOne", this.map.removeKey(31));
        Assert.assertFalse(this.map.containsKey(31));
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32));
        Assert.assertFalse(this.map.containsKey(32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put(5, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(5));
        Assert.assertNull(this.map.put(35, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(0, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(1, "one").size());
        MutableIntObjectMap<String> hashMap1 = this.newWithKeysValues(1, "one", 0, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());
        MutableIntObjectMap<String> hashMap = this.newWithKeysValues(6, "six", 5, "five");
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put(1, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey(5));
        Assert.assertNull(this.map.put(35, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableIntObjectMap<String> emptyMap = this.getEmptyMap();
        MutableIntObjectMap<String> hashMap = emptyMap.withKeyValue(1, "one");
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableIntObjectMap<String> map1 = this.newWithKeysValues(0, "zero", 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), IntObjectHashMap.newWithKeysValues(0, "zero").equals(map1) || IntObjectHashMap.newWithKeysValues(1, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(IntObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableIntObjectMap<String> map2 = this.newWithKeysValues(0, "zero", 9, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), IntObjectHashMap.newWithKeysValues(0, "zero").equals(map2) || IntObjectHashMap.newWithKeysValues(9, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(IntObjectHashMap.newMap(), map2);
        MutableIntObjectMap<String> map3 = this.newWithKeysValues(8, "eight", 9, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), IntObjectHashMap.newWithKeysValues(8, "eight").equals(map3) || IntObjectHashMap.newWithKeysValues(9, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(IntObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableIntObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedIntObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedIntObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableIntObjectMap<String> map = this.newWithKeysValues(1, "2", 2, "3");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1, "3", 2), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, "1", 2, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractIntObjectMapTestCase._Benchmark {

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
        public void benchmark_put() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put, this.description("put"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putPair, this.description("putPair"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putDuplicateWithRemovedSlot, this.description("putDuplicateWithRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putAll, this.description("putAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_Value, this.description("getIfAbsentPut_Value"));
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
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValueWith, this.description("updateValueWith"));
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withAllKeyValues, this.description("withAllKeyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
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
        public void benchmark_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::size, this.description("size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asSynchronized, this.description("asSynchronized"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractMutableIntObjectMapTestCase implementation();
    }
}
