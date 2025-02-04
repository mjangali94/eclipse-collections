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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableFloatObjectMap;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableFloatObjectMapTestCase extends AbstractFloatObjectMapTestCase {

    private final MutableFloatObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableFloatObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableFloatObjectMap<T> newWithKeysValues(float key1, T value1);

    @Override
    protected abstract <T> MutableFloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2);

    @Override
    protected abstract <T> MutableFloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2, float key3, T value3);

    @Override
    protected abstract <T> MutableFloatObjectMap<T> getEmptyMap();

    protected static FloatArrayList generateCollisions() {
        FloatArrayList collisions = new FloatArrayList();
        FloatObjectHashMap<?> hashMap = new FloatObjectHashMap<>();
        for (float i = 2.0f; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(2.0f)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableFloatObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put(0.0f, new Object());
        hashMap.clear();
        Assert.assertEquals(new FloatObjectHashMap<>(), hashMap);
        hashMap.put(1.0f, new Object());
        hashMap.clear();
        Assert.assertEquals(new FloatObjectHashMap<>(), hashMap);
        hashMap.put(33.0f, new Object());
        hashMap.clear();
        Assert.assertEquals(new FloatObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey(5.0f));
        Assert.assertNull(this.map.removeKey(50.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(31.0f, "thirtyOne", 32.0f, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey(31.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(32.0f, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32.0f));
        Assert.assertEquals(new FloatObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey(0.0f));
        Assert.assertNull(this.map.removeKey(1.0f));
        Assert.assertNull(this.map.removeKey(31.0f));
        Assert.assertNull(this.map.removeKey(32.0f));
        Assert.assertEquals(new FloatObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(1.0f));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(0.0f));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(35.0f));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableFloatObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableFloatObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableFloatObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableFloatObjectMapTestCase.generateCollisions().getFirst()));
        MutableFloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Assert.assertEquals("zero", map1.removeKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), map1);
        Assert.assertEquals("one", map1.removeKey(1.0f));
        Assert.assertEquals(FloatObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove(5.0f));
        Assert.assertNull(this.map.remove(50.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(31.0f, "thirtyOne", 32.0f, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove(31.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(32.0f, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove(32.0f));
        Assert.assertEquals(new FloatObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove(0.0f));
        Assert.assertNull(this.map.remove(1.0f));
        Assert.assertNull(this.map.remove(31.0f));
        Assert.assertNull(this.map.remove(32.0f));
        Assert.assertEquals(new FloatObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(1.0f));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(0.0f));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(35.0f));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableFloatObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableFloatObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableFloatObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableFloatObjectMapTestCase.generateCollisions().getFirst()));
        MutableFloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Assert.assertEquals("zero", map1.remove(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), map1);
        Assert.assertEquals("one", map1.remove(1.0f));
        Assert.assertEquals(FloatObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put(0.0f, "one"));
        Assert.assertEquals("thirtyOne", this.map.put(31.0f, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put(32.0f, "thirtyThree"));
        FloatObjectHashMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "one", 31.0f, "thirtyTwo", 32.0f, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(1.0f, "two"));
        Assert.assertEquals("two", this.map.put(1.0f, "two"));
        expected.put(1.0f, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(33.0f, "thirtyFour"));
        expected.put(33.0f, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(30.0f, "thirtyOne"));
        expected.put(30.0f, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(5.0f, null));
        expected.put(5.0f, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(50.0f, null));
        expected.put(50.0f, null);
        Assert.assertEquals(expected, this.map);
        MutableFloatObjectMap<String> emptyMap = FloatObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put(0.0f, "zero"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero"), emptyMap);
        MutableFloatObjectMap<String> emptyMap1 = FloatObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put(1.0f, "one"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put(0.0f, "zero"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 1.0f, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair(0.0f, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair(31.0f, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair(32.0f, "thirtyThree")));
        FloatObjectHashMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "one", 31.0f, "thirtyTwo", 32.0f, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(1.0f, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair(1.0f, "two")));
        expected.put(1.0f, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(33.0f, "thirtyFour")));
        expected.put(33.0f, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(30.0f, "thirtyOne")));
        expected.put(30.0f, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(5.0f, null)));
        expected.put(5.0f, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(50.0f, null)));
        expected.put(50.0f, null);
        Assert.assertEquals(expected, this.map);
        MutableFloatObjectMap<String> emptyMap = FloatObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair(0.0f, "zero")));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero"), emptyMap);
        MutableFloatObjectMap<String> emptyMap1 = FloatObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(1.0f, "one")));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(0.0f, "zero")));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 1.0f, "one"), emptyMap1);
    }

    @Test
    public void put_NaN() {
        MutableFloatObjectMap<String> map = this.newWithKeysValues(Float.NaN, "one");
        Map<Float, String> hashmap = new HashMap<>();
        hashmap.put(Float.NaN, "one");
        Assert.assertTrue(hashmap.containsKey(Float.NaN));
        Assert.assertTrue(map.containsKey(Float.NaN));
        Assert.assertEquals("one", hashmap.get(Float.NaN));
        Assert.assertEquals("one", map.get(Float.NaN));
        Assert.assertEquals("one", hashmap.put(Float.NaN, "two"));
        Assert.assertEquals("one", map.put(Float.NaN, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void put_POSITIVE_INFINITY() {
        MutableFloatObjectMap<String> map = this.newWithKeysValues(Float.POSITIVE_INFINITY, "one");
        Map<Float, String> hashmap = new HashMap<>();
        hashmap.put(Float.POSITIVE_INFINITY, "one");
        Assert.assertTrue(hashmap.containsKey(Float.POSITIVE_INFINITY));
        Assert.assertTrue(map.containsKey(Float.POSITIVE_INFINITY));
        Assert.assertEquals("one", hashmap.get(Float.POSITIVE_INFINITY));
        Assert.assertEquals("one", map.get(Float.POSITIVE_INFINITY));
        Assert.assertEquals("one", hashmap.put(Float.POSITIVE_INFINITY, "two"));
        Assert.assertEquals("one", map.put(Float.POSITIVE_INFINITY, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void put_NEGATIVE_INFINITY() {
        MutableFloatObjectMap<String> map = this.newWithKeysValues(Float.NEGATIVE_INFINITY, "one");
        Map<Float, String> hashmap = new HashMap<>();
        hashmap.put(Float.NEGATIVE_INFINITY, "one");
        Assert.assertTrue(hashmap.containsKey(Float.NEGATIVE_INFINITY));
        Assert.assertTrue(map.containsKey(Float.NEGATIVE_INFINITY));
        Assert.assertEquals("one", hashmap.get(Float.NEGATIVE_INFINITY));
        Assert.assertEquals("one", map.get(Float.NEGATIVE_INFINITY));
        Assert.assertEquals("one", hashmap.put(Float.NEGATIVE_INFINITY, "two"));
        Assert.assertEquals("one", map.put(Float.NEGATIVE_INFINITY, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void put_zero() {
        MutableFloatObjectMap<String> map = this.newWithKeysValues(0.0f, "one");
        Map<Float, String> hashmap = new HashMap<>();
        hashmap.put(0.0f, "one");
        Assert.assertTrue(hashmap.containsKey(0.0f));
        Assert.assertFalse(hashmap.containsKey(-0.0f));
        Assert.assertTrue(map.containsKey(0.0f));
        Assert.assertFalse(map.containsKey(-0.0f));
        Assert.assertEquals("one", hashmap.get(0.0f));
        Assert.assertNull(hashmap.get(-0.0f));
        Assert.assertEquals("one", map.get(0.0f));
        Assert.assertNull(map.get(-0.0f));
        Assert.assertEquals("one", hashmap.put(0.0f, "two"));
        Assert.assertNull(hashmap.put(-0.0f, "two"));
        Assert.assertEquals("one", map.put(0.0f, "two"));
        Assert.assertNull(map.put(-0.0f, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatObjectMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatObjectMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatObjectMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatObjectMapTestCase.generateCollisions().get(3);
        MutableFloatObjectMap<String> hashMap = FloatObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableFloatObjectMap<String> hashMap1 = FloatObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableFloatObjectMap<String> hashMap2 = FloatObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableFloatObjectMap<String> hashMap = this.getEmptyMap();
        MutableFloatObjectMap<String> copyMap = FloatObjectHashMap.newMap();
        for (float i = 1.0f; i < 10.0f; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (float i = 1.0f; i < 10.0f; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0.0f, "zeroValue"));
        MutableFloatObjectMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1.0f, "oneValue"));
        expected.put(1.0f, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2.0f, () -> null));
        expected.put(2.0f, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32.0f, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33.0f, "thirtyThreeValue"));
        expected.put(33.0f, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34.0f, () -> null));
        expected.put(34.0f, null);
        Assert.assertEquals(expected, this.map);
        MutableFloatObjectMap<String> emptyMap = FloatObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0f, "zeroValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0f, "oneValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue", 1.0f, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0f, "twoValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue", 1.0f, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0f, "zeroValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue", 1.0f, "oneValue"), emptyMap);
        MutableFloatObjectMap<String> emptyMap1 = FloatObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1.0f, "oneValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0.0f, () -> "zeroValue"));
        MutableFloatObjectMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1.0f, () -> "oneValue"));
        expected.put(1.0f, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2.0f, () -> null));
        expected.put(2.0f, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32.0f, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33.0f, () -> "thirtyThreeValue"));
        expected.put(33.0f, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34.0f, () -> null));
        expected.put(34.0f, null);
        Assert.assertEquals(expected, this.map);
        MutableFloatObjectMap<String> emptyMap = FloatObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0f, () -> "zeroValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0f, () -> "oneValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue", 1.0f, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0f, () -> "twoValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue", 1.0f, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0f, () -> "zeroValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zeroValue", 1.0f, "oneValue"), emptyMap);
        MutableFloatObjectMap<String> emptyMap1 = FloatObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1.0f, () -> "oneValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0.0f, toUpperCase, "zeroValue"));
        FloatObjectHashMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith(1.0f, toUpperCase, "oneValue"));
        expected.put(1.0f, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(2.0f, string -> null, ""));
        expected.put(2.0f, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith(32.0f, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith(33.0f, toUpperCase, "thirtyThreeValue"));
        expected.put(33.0f, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(34.0f, string -> null, ""));
        expected.put(34.0f, null);
        Assert.assertEquals(expected, this.map);
        MutableFloatObjectMap<String> emptyMap = FloatObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0.0f, toUpperCase, "zeroValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1.0f, toUpperCase, "oneValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "ZEROVALUE", 1.0f, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1.0f, toUpperCase, "twoValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "ZEROVALUE", 1.0f, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0.0f, toUpperCase, "zeroValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "ZEROVALUE", 1.0f, "ONEVALUE"), emptyMap);
        MutableFloatObjectMap<String> emptyMap1 = FloatObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith(1.0f, toUpperCase, "oneValue"));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0.0f, toString));
        FloatObjectHashMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("1.0", this.map.getIfAbsentPutWithKey(1.0f, toString));
        expected.put(1.0f, "1.0");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(2.0f, (float floatParameter) -> null));
        expected.put(2.0f, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey(32.0f, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("33.0", this.map.getIfAbsentPutWithKey(33.0f, toString));
        expected.put(33.0f, "33.0");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(34.0f, (float floatParameter) -> null));
        expected.put(34.0f, null);
        Assert.assertEquals(expected, this.map);
        MutableFloatObjectMap<String> emptyMap = FloatObjectHashMap.newMap();
        Assert.assertEquals("0.0", emptyMap.getIfAbsentPutWithKey(0.0f, toString));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "0.0"), emptyMap);
        Assert.assertEquals("1.0", emptyMap.getIfAbsentPutWithKey(1.0f, toString));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "0.0", 1.0f, "1.0"), emptyMap);
        Assert.assertEquals("1.0", emptyMap.getIfAbsentPutWithKey(1.0f, toString));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "0.0", 1.0f, "1.0"), emptyMap);
        Assert.assertEquals("0.0", emptyMap.removeKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1.0"), emptyMap);
        Assert.assertEquals("0.0", emptyMap.getIfAbsentPutWithKey(0.0f, toString));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "0.0", 1.0f, "1.0"), emptyMap);
        MutableFloatObjectMap<String> emptyMap1 = FloatObjectHashMap.newMap();
        Assert.assertEquals("1.0", emptyMap1.getIfAbsentPutWithKey(1.0f, toString));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "1.0"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableFloatObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(0.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(0.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(1.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2, 1.0f, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(1.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2, 1.0f, 2), map1);
        MutableFloatObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(1.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(1.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(0.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 1, 1.0f, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(0.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2, 1.0f, 2), map2);
        MutableFloatObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue(33.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(33.0f, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue(33.0f, zeroFactory, incrementFunction));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(33.0f, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableFloatObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(0.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(0.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(1.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2, 1.0f, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(1.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2, 1.0f, 2), map1);
        MutableFloatObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(1.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(1.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(0.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 1, 1.0f, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(0.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, 2, 1.0f, 2), map2);
        MutableFloatObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith(33.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(33.0f, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith(33.0f, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(33.0f, 2), map3);
    }

    @Test
    public void freeze() {
        MutableFloatObjectMap<String> mutableFloatObjectMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatObjectMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatObjectMap.put((float) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        FloatSet frozenSetForRemove = mutableFloatObjectMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableFloatObjectMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableFloatObjectMap<String> mutableFloatObjectMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatObjectMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatObjectMapForClear.keySet().toArray());
        mutableFloatObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableFloatObjectMap<String> actual = this.map.withoutKey(55.0f);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo"), actual);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(31.0f, "thirtyOne", 32.0f, "thirtyTwo"), this.map.withoutKey(0.0f));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(32.0f, "thirtyTwo"), this.map.withoutKey(31.0f));
        Assert.assertEquals(FloatObjectHashMap.newMap(), this.map.withoutKey(32.0f));
        Assert.assertEquals(FloatObjectHashMap.newMap(), this.map.withoutKey(1.0f));
    }

    @Test
    public void withoutAllKeys() {
        MutableFloatObjectMap<String> actual = this.map.withoutAllKeys(FloatArrayList.newListWith(55.0f, 1.0f));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo"), actual);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(32.0f, "thirtyTwo"), this.map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 31.0f)));
        Assert.assertEquals(FloatObjectHashMap.newMap(), this.map.withoutAllKeys(FloatArrayList.newListWith(31.0f, 32.0f)));
        Assert.assertEquals(FloatObjectHashMap.newMap(), this.map.withoutAllKeys(FloatArrayList.newListWith(1.0f)));
    }

    @Test
    public void withAllKeyValues() {
        MutableFloatObjectMap<String> emptyMap = this.getEmptyMap();
        MutableFloatObjectMap<String> partialMap = this.newWithKeysValues(1.0f, "one", 3.0f, "three");
        MutableFloatObjectMap<String> completeMap = this.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three");
        Iterable<FloatObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<FloatObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, "one"), PrimitiveTuples.pair(3.0f, "three"));
        Iterable<FloatObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0f, "one"), PrimitiveTuples.pair(2.0f, "two"), PrimitiveTuples.pair(3.0f, "three"));
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
        Assert.assertEquals("zero", this.map.put(0.0f, "one"));
        Assert.assertEquals("one", this.map.get(0.0f));
        Assert.assertNull(this.map.put(5.0f, "five"));
        Assert.assertEquals("five", this.map.get(5.0f));
        Assert.assertNull(this.map.put(35.0f, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get(35.0f));
        Assert.assertNull(this.map.put(6.0f, null));
        Assert.assertNull(this.map.get(6.0f));
        Assert.assertNull(this.map.put(36.0f, null));
        Assert.assertNull(this.map.get(36.0f));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put(0.0f, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent(0.0f, ifAbsent));
        Assert.assertNull(this.map.put(5.0f, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent(5.0f, ifAbsent));
        Assert.assertNull(this.map.put(35.0f, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent(35.0f, ifAbsent));
        Assert.assertNull(this.map.put(6.0f, null));
        Assert.assertNull(this.map.getIfAbsent(6.0f, ifAbsent));
        Assert.assertNull(this.map.put(36.0f, null));
        Assert.assertNull(this.map.getIfAbsent(36.0f, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey(0.0f));
        Assert.assertFalse(this.map.containsKey(0.0f));
        Assert.assertEquals("thirtyOne", this.map.removeKey(31.0f));
        Assert.assertFalse(this.map.containsKey(31.0f));
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32.0f));
        Assert.assertFalse(this.map.containsKey(32.0f));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put(5.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(5.0f));
        Assert.assertNull(this.map.put(35.0f, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(0.0f, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(1.0f, "one").size());
        MutableFloatObjectMap<String> hashMap1 = this.newWithKeysValues(1.0f, "one", 0.0f, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());
        MutableFloatObjectMap<String> hashMap = this.newWithKeysValues(6.0f, "six", 5.0f, "five");
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put(1.0f, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey(5.0f));
        Assert.assertNull(this.map.put(35.0f, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableFloatObjectMap<String> emptyMap = this.getEmptyMap();
        MutableFloatObjectMap<String> hashMap = emptyMap.withKeyValue(1.0f, "one");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableFloatObjectMap<String> map1 = this.newWithKeysValues(0.0f, "zero", 1.0f, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), FloatObjectHashMap.newWithKeysValues(0.0f, "zero").equals(map1) || FloatObjectHashMap.newWithKeysValues(1.0f, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(FloatObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableFloatObjectMap<String> map2 = this.newWithKeysValues(0.0f, "zero", 9.0f, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), FloatObjectHashMap.newWithKeysValues(0.0f, "zero").equals(map2) || FloatObjectHashMap.newWithKeysValues(9.0f, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(FloatObjectHashMap.newMap(), map2);
        MutableFloatObjectMap<String> map3 = this.newWithKeysValues(8.0f, "eight", 9.0f, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), FloatObjectHashMap.newWithKeysValues(8.0f, "eight").equals(map3) || FloatObjectHashMap.newWithKeysValues(9.0f, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(FloatObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableFloatObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedFloatObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedFloatObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableFloatObjectMap<String> map = this.newWithKeysValues(1.0f, "2", 2.0f, "3");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "3", 2.0f), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, "1", 2.0f, "1").flipUniqueValues());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableFloatObjectMapTestCase instance;

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
        public void benchmark_put_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_zero);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableFloatObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> put_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> put_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> put_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> put_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableFloatObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableFloatObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableFloatObjectMapTestCase::values;
            this.payloads.select = AbstractMutableFloatObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableFloatObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableFloatObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableFloatObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableFloatObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableFloatObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableFloatObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableFloatObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableFloatObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableFloatObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableFloatObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableFloatObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableFloatObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableFloatObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableFloatObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableFloatObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableFloatObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableFloatObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableFloatObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableFloatObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableFloatObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableFloatObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableFloatObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableFloatObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableFloatObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableFloatObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableFloatObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableFloatObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableFloatObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableFloatObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableFloatObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableFloatObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableFloatObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableFloatObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableFloatObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableFloatObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableFloatObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableFloatObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableFloatObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableFloatObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableFloatObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableFloatObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableFloatObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableFloatObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableFloatObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableFloatObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableFloatObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableFloatObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableFloatObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableFloatObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableFloatObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableFloatObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableFloatObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableFloatObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableFloatObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableFloatObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableFloatObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableFloatObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableFloatObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableFloatObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableFloatObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableFloatObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableFloatObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableFloatObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableFloatObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableFloatObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableFloatObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableFloatObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableFloatObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableFloatObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableFloatObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableFloatObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableFloatObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableFloatObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableFloatObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableFloatObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableFloatObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableFloatObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableFloatObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableFloatObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableFloatObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableFloatObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableFloatObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableFloatObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableFloatObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableFloatObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableFloatObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableFloatObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableFloatObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableFloatObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableFloatObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableFloatObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableFloatObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableFloatObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableFloatObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableFloatObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableFloatObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableFloatObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableFloatObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableFloatObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableFloatObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableFloatObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableFloatObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableFloatObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableFloatObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableFloatObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableFloatObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableFloatObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableFloatObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableFloatObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableFloatObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableFloatObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableFloatObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableFloatObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableFloatObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableFloatObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableFloatObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableFloatObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableFloatObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableFloatObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableFloatObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableFloatObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableFloatObjectMapTestCase::putPair;
            this.payloads.put_NaN = AbstractMutableFloatObjectMapTestCase::put_NaN;
            this.payloads.put_POSITIVE_INFINITY = AbstractMutableFloatObjectMapTestCase::put_POSITIVE_INFINITY;
            this.payloads.put_NEGATIVE_INFINITY = AbstractMutableFloatObjectMapTestCase::put_NEGATIVE_INFINITY;
            this.payloads.put_zero = AbstractMutableFloatObjectMapTestCase::put_zero;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableFloatObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableFloatObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableFloatObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableFloatObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableFloatObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableFloatObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableFloatObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableFloatObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableFloatObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableFloatObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableFloatObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableFloatObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableFloatObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableFloatObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableFloatObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableFloatObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableFloatObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableFloatObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableFloatObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableFloatObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableFloatObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableFloatObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableFloatObjectMapTestCase::flipUniqueValues;
        }
    }
*/
}
