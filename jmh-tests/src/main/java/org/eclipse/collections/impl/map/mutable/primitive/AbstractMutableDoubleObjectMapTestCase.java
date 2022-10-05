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
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableDoubleObjectMap;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleObjectMapTestCase extends AbstractDoubleObjectMapTestCase {

    private final MutableDoubleObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableDoubleObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableDoubleObjectMap<T> newWithKeysValues(double key1, T value1);

    @Override
    protected abstract <T> MutableDoubleObjectMap<T> newWithKeysValues(double key1, T value1, double key2, T value2);

    @Override
    protected abstract <T> MutableDoubleObjectMap<T> newWithKeysValues(double key1, T value1, double key2, T value2, double key3, T value3);

    @Override
    protected abstract <T> MutableDoubleObjectMap<T> getEmptyMap();

    protected static DoubleArrayList generateCollisions() {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleObjectHashMap<?> hashMap = new DoubleObjectHashMap<>();
        for (double i = 2.0; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(2.0)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableDoubleObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put(0.0, new Object());
        hashMap.clear();
        Assert.assertEquals(new DoubleObjectHashMap<>(), hashMap);
        hashMap.put(1.0, new Object());
        hashMap.clear();
        Assert.assertEquals(new DoubleObjectHashMap<>(), hashMap);
        hashMap.put(33.0, new Object());
        hashMap.clear();
        Assert.assertEquals(new DoubleObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey(5.0));
        Assert.assertNull(this.map.removeKey(50.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(31.0, "thirtyOne", 32.0, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey(31.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(32.0, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32.0));
        Assert.assertEquals(new DoubleObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey(0.0));
        Assert.assertNull(this.map.removeKey(1.0));
        Assert.assertNull(this.map.removeKey(31.0));
        Assert.assertNull(this.map.removeKey(32.0));
        Assert.assertEquals(new DoubleObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(1.0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(0.0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(35.0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableDoubleObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableDoubleObjectMapTestCase.generateCollisions().getFirst()));
        MutableDoubleObjectMap<String> map1 = this.newWithKeysValues(0.0, "zero", 1.0, "one");
        Assert.assertEquals("zero", map1.removeKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), map1);
        Assert.assertEquals("one", map1.removeKey(1.0));
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove(5.0));
        Assert.assertNull(this.map.remove(50.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(31.0, "thirtyOne", 32.0, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove(31.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(32.0, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove(32.0));
        Assert.assertEquals(new DoubleObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove(0.0));
        Assert.assertNull(this.map.remove(1.0));
        Assert.assertNull(this.map.remove(31.0));
        Assert.assertNull(this.map.remove(32.0));
        Assert.assertEquals(new DoubleObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(1.0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(0.0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(35.0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableDoubleObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableDoubleObjectMapTestCase.generateCollisions().getFirst()));
        MutableDoubleObjectMap<String> map1 = this.newWithKeysValues(0.0, "zero", 1.0, "one");
        Assert.assertEquals("zero", map1.remove(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), map1);
        Assert.assertEquals("one", map1.remove(1.0));
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put(0.0, "one"));
        Assert.assertEquals("thirtyOne", this.map.put(31.0, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put(32.0, "thirtyThree"));
        DoubleObjectHashMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "one", 31.0, "thirtyTwo", 32.0, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(1.0, "two"));
        Assert.assertEquals("two", this.map.put(1.0, "two"));
        expected.put(1.0, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(33.0, "thirtyFour"));
        expected.put(33.0, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(30.0, "thirtyOne"));
        expected.put(30.0, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(5.0, null));
        expected.put(5.0, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(50.0, null));
        expected.put(50.0, null);
        Assert.assertEquals(expected, this.map);
        MutableDoubleObjectMap<String> emptyMap = DoubleObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put(0.0, "zero"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero"), emptyMap);
        MutableDoubleObjectMap<String> emptyMap1 = DoubleObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put(1.0, "one"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put(0.0, "zero"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 1.0, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair(0.0, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair(31.0, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair(32.0, "thirtyThree")));
        DoubleObjectHashMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "one", 31.0, "thirtyTwo", 32.0, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(1.0, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair(1.0, "two")));
        expected.put(1.0, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(33.0, "thirtyFour")));
        expected.put(33.0, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(30.0, "thirtyOne")));
        expected.put(30.0, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(5.0, null)));
        expected.put(5.0, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(50.0, null)));
        expected.put(50.0, null);
        Assert.assertEquals(expected, this.map);
        MutableDoubleObjectMap<String> emptyMap = DoubleObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair(0.0, "zero")));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero"), emptyMap);
        MutableDoubleObjectMap<String> emptyMap1 = DoubleObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(1.0, "one")));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(0.0, "zero")));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 1.0, "one"), emptyMap1);
    }

    @Test
    public void put_NaN() {
        MutableDoubleObjectMap<String> map = this.newWithKeysValues(Double.NaN, "one");
        Map<Double, String> hashmap = new HashMap<>();
        hashmap.put(Double.NaN, "one");
        Assert.assertTrue(hashmap.containsKey(Double.NaN));
        Assert.assertTrue(map.containsKey(Double.NaN));
        Assert.assertEquals("one", hashmap.get(Double.NaN));
        Assert.assertEquals("one", map.get(Double.NaN));
        Assert.assertEquals("one", hashmap.put(Double.NaN, "two"));
        Assert.assertEquals("one", map.put(Double.NaN, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void put_POSITIVE_INFINITY() {
        MutableDoubleObjectMap<String> map = this.newWithKeysValues(Double.POSITIVE_INFINITY, "one");
        Map<Double, String> hashmap = new HashMap<>();
        hashmap.put(Double.POSITIVE_INFINITY, "one");
        Assert.assertTrue(hashmap.containsKey(Double.POSITIVE_INFINITY));
        Assert.assertTrue(map.containsKey(Double.POSITIVE_INFINITY));
        Assert.assertEquals("one", hashmap.get(Double.POSITIVE_INFINITY));
        Assert.assertEquals("one", map.get(Double.POSITIVE_INFINITY));
        Assert.assertEquals("one", hashmap.put(Double.POSITIVE_INFINITY, "two"));
        Assert.assertEquals("one", map.put(Double.POSITIVE_INFINITY, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void put_NEGATIVE_INFINITY() {
        MutableDoubleObjectMap<String> map = this.newWithKeysValues(Double.NEGATIVE_INFINITY, "one");
        Map<Double, String> hashmap = new HashMap<>();
        hashmap.put(Double.NEGATIVE_INFINITY, "one");
        Assert.assertTrue(hashmap.containsKey(Double.NEGATIVE_INFINITY));
        Assert.assertTrue(map.containsKey(Double.NEGATIVE_INFINITY));
        Assert.assertEquals("one", hashmap.get(Double.NEGATIVE_INFINITY));
        Assert.assertEquals("one", map.get(Double.NEGATIVE_INFINITY));
        Assert.assertEquals("one", hashmap.put(Double.NEGATIVE_INFINITY, "two"));
        Assert.assertEquals("one", map.put(Double.NEGATIVE_INFINITY, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void put_zero() {
        MutableDoubleObjectMap<String> map = this.newWithKeysValues(0.0, "one");
        Map<Double, String> hashmap = new HashMap<>();
        hashmap.put(0.0, "one");
        Assert.assertTrue(hashmap.containsKey(0.0));
        Assert.assertFalse(hashmap.containsKey(-0.0));
        Assert.assertTrue(map.containsKey(0.0));
        Assert.assertFalse(map.containsKey(-0.0));
        Assert.assertEquals("one", hashmap.get(0.0));
        Assert.assertNull(hashmap.get(-0.0));
        Assert.assertEquals("one", map.get(0.0));
        Assert.assertNull(map.get(-0.0));
        Assert.assertEquals("one", hashmap.put(0.0, "two"));
        Assert.assertNull(hashmap.put(-0.0, "two"));
        Assert.assertEquals("one", map.put(0.0, "two"));
        Assert.assertNull(map.put(-0.0, "two"));
        Verify.assertIterableSize(hashmap.size(), map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleObjectMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleObjectMapTestCase.generateCollisions().get(3);
        MutableDoubleObjectMap<String> hashMap = DoubleObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableDoubleObjectMap<String> hashMap1 = DoubleObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableDoubleObjectMap<String> hashMap2 = DoubleObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableDoubleObjectMap<String> hashMap = this.getEmptyMap();
        MutableDoubleObjectMap<String> copyMap = DoubleObjectHashMap.newMap();
        for (double i = 1.0; i < 10.0; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (double i = 1.0; i < 10.0; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0.0, "zeroValue"));
        MutableDoubleObjectMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1.0, "oneValue"));
        expected.put(1.0, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2.0, () -> null));
        expected.put(2.0, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32.0, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33.0, "thirtyThreeValue"));
        expected.put(33.0, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34.0, () -> null));
        expected.put(34.0, null);
        Assert.assertEquals(expected, this.map);
        MutableDoubleObjectMap<String> emptyMap = DoubleObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0, "zeroValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0, "oneValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue", 1.0, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0, "twoValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue", 1.0, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0, "zeroValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue", 1.0, "oneValue"), emptyMap);
        MutableDoubleObjectMap<String> emptyMap1 = DoubleObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1.0, "oneValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0.0, () -> "zeroValue"));
        MutableDoubleObjectMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1.0, () -> "oneValue"));
        expected.put(1.0, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2.0, () -> null));
        expected.put(2.0, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32.0, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33.0, () -> "thirtyThreeValue"));
        expected.put(33.0, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34.0, () -> null));
        expected.put(34.0, null);
        Assert.assertEquals(expected, this.map);
        MutableDoubleObjectMap<String> emptyMap = DoubleObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0, () -> "zeroValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0, () -> "oneValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue", 1.0, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1.0, () -> "twoValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue", 1.0, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0.0, () -> "zeroValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zeroValue", 1.0, "oneValue"), emptyMap);
        MutableDoubleObjectMap<String> emptyMap1 = DoubleObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1.0, () -> "oneValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0.0, toUpperCase, "zeroValue"));
        DoubleObjectHashMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith(1.0, toUpperCase, "oneValue"));
        expected.put(1.0, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(2.0, string -> null, ""));
        expected.put(2.0, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith(32.0, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith(33.0, toUpperCase, "thirtyThreeValue"));
        expected.put(33.0, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(34.0, string -> null, ""));
        expected.put(34.0, null);
        Assert.assertEquals(expected, this.map);
        MutableDoubleObjectMap<String> emptyMap = DoubleObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0.0, toUpperCase, "zeroValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1.0, toUpperCase, "oneValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "ZEROVALUE", 1.0, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1.0, toUpperCase, "twoValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "ZEROVALUE", 1.0, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0.0, toUpperCase, "zeroValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "ZEROVALUE", 1.0, "ONEVALUE"), emptyMap);
        MutableDoubleObjectMap<String> emptyMap1 = DoubleObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith(1.0, toUpperCase, "oneValue"));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0.0, toString));
        DoubleObjectHashMap<String> expected = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("1.0", this.map.getIfAbsentPutWithKey(1.0, toString));
        expected.put(1.0, "1.0");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(2.0, (double doubleParameter) -> null));
        expected.put(2.0, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey(32.0, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("33.0", this.map.getIfAbsentPutWithKey(33.0, toString));
        expected.put(33.0, "33.0");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(34.0, (double doubleParameter) -> null));
        expected.put(34.0, null);
        Assert.assertEquals(expected, this.map);
        MutableDoubleObjectMap<String> emptyMap = DoubleObjectHashMap.newMap();
        Assert.assertEquals("0.0", emptyMap.getIfAbsentPutWithKey(0.0, toString));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "0.0"), emptyMap);
        Assert.assertEquals("1.0", emptyMap.getIfAbsentPutWithKey(1.0, toString));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "0.0", 1.0, "1.0"), emptyMap);
        Assert.assertEquals("1.0", emptyMap.getIfAbsentPutWithKey(1.0, toString));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "0.0", 1.0, "1.0"), emptyMap);
        Assert.assertEquals("0.0", emptyMap.removeKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1.0"), emptyMap);
        Assert.assertEquals("0.0", emptyMap.getIfAbsentPutWithKey(0.0, toString));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "0.0", 1.0, "1.0"), emptyMap);
        MutableDoubleObjectMap<String> emptyMap1 = DoubleObjectHashMap.newMap();
        Assert.assertEquals("1.0", emptyMap1.getIfAbsentPutWithKey(1.0, toString));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "1.0"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableDoubleObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(0.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(0.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(1.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2, 1.0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(1.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map1);
        MutableDoubleObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(1.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(1.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(0.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 1, 1.0, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(0.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map2);
        MutableDoubleObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue(33.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(33.0, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue(33.0, zeroFactory, incrementFunction));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(33.0, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableDoubleObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(0.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(0.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(1.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2, 1.0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(1.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map1);
        MutableDoubleObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(1.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(1.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(0.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 1, 1.0, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(0.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map2);
        MutableDoubleObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith(33.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(33.0, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith(33.0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(33.0, 2), map3);
    }

    @Test
    public void freeze() {
        MutableDoubleObjectMap<String> mutableDoubleObjectMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleObjectMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleObjectMap.put((double) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        DoubleSet frozenSetForRemove = mutableDoubleObjectMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableDoubleObjectMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableDoubleObjectMap<String> mutableDoubleObjectMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleObjectMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleObjectMapForClear.keySet().toArray());
        mutableDoubleObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableDoubleObjectMap<String> actual = this.map.withoutKey(55.0);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo"), actual);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(31.0, "thirtyOne", 32.0, "thirtyTwo"), this.map.withoutKey(0.0));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(32.0, "thirtyTwo"), this.map.withoutKey(31.0));
        Assert.assertEquals(DoubleObjectHashMap.newMap(), this.map.withoutKey(32.0));
        Assert.assertEquals(DoubleObjectHashMap.newMap(), this.map.withoutKey(1.0));
    }

    @Test
    public void withoutAllKeys() {
        MutableDoubleObjectMap<String> actual = this.map.withoutAllKeys(DoubleArrayList.newListWith(55.0, 1.0));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo"), actual);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(32.0, "thirtyTwo"), this.map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 31.0)));
        Assert.assertEquals(DoubleObjectHashMap.newMap(), this.map.withoutAllKeys(DoubleArrayList.newListWith(31.0, 32.0)));
        Assert.assertEquals(DoubleObjectHashMap.newMap(), this.map.withoutAllKeys(DoubleArrayList.newListWith(1.0)));
    }

    @Test
    public void withAllKeyValues() {
        MutableDoubleObjectMap<String> emptyMap = this.getEmptyMap();
        MutableDoubleObjectMap<String> partialMap = this.newWithKeysValues(1.0, "one", 3.0, "three");
        MutableDoubleObjectMap<String> completeMap = this.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three");
        Iterable<DoubleObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<DoubleObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair(1.0, "one"), PrimitiveTuples.pair(3.0, "three"));
        Iterable<DoubleObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair(1.0, "one"), PrimitiveTuples.pair(2.0, "two"), PrimitiveTuples.pair(3.0, "three"));
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
        Assert.assertEquals("zero", this.map.put(0.0, "one"));
        Assert.assertEquals("one", this.map.get(0.0));
        Assert.assertNull(this.map.put(5.0, "five"));
        Assert.assertEquals("five", this.map.get(5.0));
        Assert.assertNull(this.map.put(35.0, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get(35.0));
        Assert.assertNull(this.map.put(6.0, null));
        Assert.assertNull(this.map.get(6.0));
        Assert.assertNull(this.map.put(36.0, null));
        Assert.assertNull(this.map.get(36.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put(0.0, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent(0.0, ifAbsent));
        Assert.assertNull(this.map.put(5.0, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent(5.0, ifAbsent));
        Assert.assertNull(this.map.put(35.0, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent(35.0, ifAbsent));
        Assert.assertNull(this.map.put(6.0, null));
        Assert.assertNull(this.map.getIfAbsent(6.0, ifAbsent));
        Assert.assertNull(this.map.put(36.0, null));
        Assert.assertNull(this.map.getIfAbsent(36.0, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey(0.0));
        Assert.assertFalse(this.map.containsKey(0.0));
        Assert.assertEquals("thirtyOne", this.map.removeKey(31.0));
        Assert.assertFalse(this.map.containsKey(31.0));
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32.0));
        Assert.assertFalse(this.map.containsKey(32.0));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put(5.0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(5.0));
        Assert.assertNull(this.map.put(35.0, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(0.0, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(1.0, "one").size());
        MutableDoubleObjectMap<String> hashMap1 = this.newWithKeysValues(1.0, "one", 0.0, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());
        MutableDoubleObjectMap<String> hashMap = this.newWithKeysValues(6.0, "six", 5.0, "five");
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put(1.0, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey(5.0));
        Assert.assertNull(this.map.put(35.0, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableDoubleObjectMap<String> emptyMap = this.getEmptyMap();
        MutableDoubleObjectMap<String> hashMap = emptyMap.withKeyValue(1.0, "one");
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableDoubleObjectMap<String> map1 = this.newWithKeysValues(0.0, "zero", 1.0, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), DoubleObjectHashMap.newWithKeysValues(0.0, "zero").equals(map1) || DoubleObjectHashMap.newWithKeysValues(1.0, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableDoubleObjectMap<String> map2 = this.newWithKeysValues(0.0, "zero", 9.0, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), DoubleObjectHashMap.newWithKeysValues(0.0, "zero").equals(map2) || DoubleObjectHashMap.newWithKeysValues(9.0, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map2);
        MutableDoubleObjectMap<String> map3 = this.newWithKeysValues(8.0, "eight", 9.0, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), DoubleObjectHashMap.newWithKeysValues(8.0, "eight").equals(map3) || DoubleObjectHashMap.newWithKeysValues(9.0, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableDoubleObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedDoubleObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableDoubleObjectMap<String> map = this.newWithKeysValues(1.0, "2", 2.0, "3");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 1.0, "3", 2.0), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, "1", 2.0, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractDoubleObjectMapTestCase._Benchmark {

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
        public abstract AbstractMutableDoubleObjectMapTestCase implementation();
    }
}
