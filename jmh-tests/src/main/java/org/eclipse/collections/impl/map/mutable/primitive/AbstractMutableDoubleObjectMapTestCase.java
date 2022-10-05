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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableDoubleObjectMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_NaN);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_POSITIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_NEGATIVE_INFINITY);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_zero);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
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
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
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
        public void benchmark_withAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableDoubleObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> put_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> put_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> put_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> put_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableDoubleObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableDoubleObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableDoubleObjectMapTestCase::values;
            this.payloads.select = AbstractMutableDoubleObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableDoubleObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableDoubleObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableDoubleObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableDoubleObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableDoubleObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableDoubleObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableDoubleObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableDoubleObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableDoubleObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableDoubleObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableDoubleObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableDoubleObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableDoubleObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableDoubleObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableDoubleObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableDoubleObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableDoubleObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableDoubleObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableDoubleObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableDoubleObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableDoubleObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableDoubleObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableDoubleObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableDoubleObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableDoubleObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableDoubleObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableDoubleObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableDoubleObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableDoubleObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableDoubleObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableDoubleObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableDoubleObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableDoubleObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableDoubleObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableDoubleObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableDoubleObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableDoubleObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableDoubleObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableDoubleObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableDoubleObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableDoubleObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableDoubleObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableDoubleObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableDoubleObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableDoubleObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableDoubleObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableDoubleObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableDoubleObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableDoubleObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableDoubleObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableDoubleObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableDoubleObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableDoubleObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableDoubleObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableDoubleObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableDoubleObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableDoubleObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableDoubleObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableDoubleObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableDoubleObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableDoubleObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableDoubleObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableDoubleObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableDoubleObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableDoubleObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableDoubleObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableDoubleObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableDoubleObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableDoubleObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableDoubleObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableDoubleObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableDoubleObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableDoubleObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableDoubleObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableDoubleObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableDoubleObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableDoubleObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableDoubleObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableDoubleObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableDoubleObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableDoubleObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableDoubleObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableDoubleObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableDoubleObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableDoubleObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableDoubleObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableDoubleObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableDoubleObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableDoubleObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableDoubleObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableDoubleObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableDoubleObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableDoubleObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableDoubleObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableDoubleObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableDoubleObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableDoubleObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableDoubleObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableDoubleObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableDoubleObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableDoubleObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableDoubleObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableDoubleObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableDoubleObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableDoubleObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableDoubleObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableDoubleObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableDoubleObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableDoubleObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableDoubleObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableDoubleObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableDoubleObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableDoubleObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableDoubleObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableDoubleObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableDoubleObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableDoubleObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableDoubleObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableDoubleObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableDoubleObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableDoubleObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableDoubleObjectMapTestCase::putPair;
            this.payloads.put_NaN = AbstractMutableDoubleObjectMapTestCase::put_NaN;
            this.payloads.put_POSITIVE_INFINITY = AbstractMutableDoubleObjectMapTestCase::put_POSITIVE_INFINITY;
            this.payloads.put_NEGATIVE_INFINITY = AbstractMutableDoubleObjectMapTestCase::put_NEGATIVE_INFINITY;
            this.payloads.put_zero = AbstractMutableDoubleObjectMapTestCase::put_zero;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableDoubleObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableDoubleObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableDoubleObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableDoubleObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableDoubleObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableDoubleObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableDoubleObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableDoubleObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableDoubleObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableDoubleObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableDoubleObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableDoubleObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableDoubleObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableDoubleObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableDoubleObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableDoubleObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableDoubleObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableDoubleObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableDoubleObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableDoubleObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableDoubleObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableDoubleObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableDoubleObjectMapTestCase::flipUniqueValues;
        }
    }
}
