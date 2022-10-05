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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractFloatObjectMapTestCase._Benchmark {

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
        public void benchmark_put_NaN() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_NaN, this.description("put_NaN"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_POSITIVE_INFINITY, this.description("put_POSITIVE_INFINITY"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_NEGATIVE_INFINITY, this.description("put_NEGATIVE_INFINITY"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_zero() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_zero, this.description("put_zero"));
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
        public abstract AbstractMutableFloatObjectMapTestCase implementation();
    }
}
