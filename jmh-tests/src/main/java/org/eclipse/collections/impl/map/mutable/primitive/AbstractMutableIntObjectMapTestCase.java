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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableIntObjectMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
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
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableIntObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableIntObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableIntObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableIntObjectMapTestCase::values;
            this.payloads.select = AbstractMutableIntObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableIntObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableIntObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableIntObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableIntObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableIntObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableIntObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableIntObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableIntObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableIntObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableIntObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableIntObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableIntObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableIntObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableIntObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableIntObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableIntObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableIntObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableIntObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableIntObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableIntObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableIntObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableIntObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableIntObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableIntObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableIntObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableIntObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableIntObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableIntObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableIntObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableIntObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableIntObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableIntObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableIntObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableIntObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableIntObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableIntObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableIntObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableIntObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableIntObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableIntObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableIntObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableIntObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableIntObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableIntObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableIntObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableIntObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableIntObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableIntObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableIntObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableIntObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableIntObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableIntObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableIntObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableIntObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableIntObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableIntObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableIntObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableIntObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableIntObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableIntObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableIntObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableIntObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableIntObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableIntObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableIntObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableIntObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableIntObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableIntObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableIntObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableIntObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableIntObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableIntObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableIntObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableIntObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableIntObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableIntObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableIntObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableIntObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableIntObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableIntObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableIntObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableIntObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableIntObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableIntObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableIntObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableIntObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableIntObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableIntObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableIntObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableIntObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableIntObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableIntObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableIntObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableIntObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableIntObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableIntObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableIntObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableIntObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableIntObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableIntObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableIntObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableIntObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableIntObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableIntObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableIntObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableIntObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableIntObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableIntObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableIntObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableIntObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableIntObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableIntObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableIntObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableIntObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableIntObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableIntObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableIntObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableIntObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableIntObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableIntObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableIntObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableIntObjectMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableIntObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableIntObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableIntObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableIntObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableIntObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableIntObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableIntObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableIntObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableIntObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableIntObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableIntObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableIntObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableIntObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableIntObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableIntObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableIntObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableIntObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableIntObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableIntObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableIntObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableIntObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableIntObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableIntObjectMapTestCase::flipUniqueValues;
        }
    }
}
