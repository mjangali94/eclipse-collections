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
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableLongObjectMapTestCase extends AbstractLongObjectMapTestCase {

    private final MutableLongObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableLongObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableLongObjectMap<T> newWithKeysValues(long key1, T value1);

    @Override
    protected abstract <T> MutableLongObjectMap<T> newWithKeysValues(long key1, T value1, long key2, T value2);

    @Override
    protected abstract <T> MutableLongObjectMap<T> newWithKeysValues(long key1, T value1, long key2, T value2, long key3, T value3);

    @Override
    protected abstract <T> MutableLongObjectMap<T> getEmptyMap();

    protected static LongArrayList generateCollisions() {
        LongArrayList collisions = new LongArrayList();
        LongObjectHashMap<?> hashMap = new LongObjectHashMap<>();
        for (long i = 2L; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(2L)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableLongObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put(0L, new Object());
        hashMap.clear();
        Assert.assertEquals(new LongObjectHashMap<>(), hashMap);
        hashMap.put(1L, new Object());
        hashMap.clear();
        Assert.assertEquals(new LongObjectHashMap<>(), hashMap);
        hashMap.put(33L, new Object());
        hashMap.clear();
        Assert.assertEquals(new LongObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey(5L));
        Assert.assertNull(this.map.removeKey(50L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(31L, "thirtyOne", 32L, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey(31L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(32L, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32L));
        Assert.assertEquals(new LongObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey(0L));
        Assert.assertNull(this.map.removeKey(1L));
        Assert.assertNull(this.map.removeKey(31L));
        Assert.assertNull(this.map.removeKey(32L));
        Assert.assertEquals(new LongObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(1L));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(0L));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(35L));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableLongObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableLongObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableLongObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableLongObjectMapTestCase.generateCollisions().getFirst()));
        MutableLongObjectMap<String> map1 = this.newWithKeysValues(0L, "zero", 1L, "one");
        Assert.assertEquals("zero", map1.removeKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), map1);
        Assert.assertEquals("one", map1.removeKey(1L));
        Assert.assertEquals(LongObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove(5L));
        Assert.assertNull(this.map.remove(50L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(31L, "thirtyOne", 32L, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove(31L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(32L, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove(32L));
        Assert.assertEquals(new LongObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove(0L));
        Assert.assertNull(this.map.remove(1L));
        Assert.assertNull(this.map.remove(31L));
        Assert.assertNull(this.map.remove(32L));
        Assert.assertEquals(new LongObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put(1L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(1L));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(0L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(0L));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(35L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove(35L));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableLongObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableLongObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableLongObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableLongObjectMapTestCase.generateCollisions().getFirst()));
        MutableLongObjectMap<String> map1 = this.newWithKeysValues(0L, "zero", 1L, "one");
        Assert.assertEquals("zero", map1.remove(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), map1);
        Assert.assertEquals("one", map1.remove(1L));
        Assert.assertEquals(LongObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put(0L, "one"));
        Assert.assertEquals("thirtyOne", this.map.put(31L, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put(32L, "thirtyThree"));
        LongObjectHashMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "one", 31L, "thirtyTwo", 32L, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(1L, "two"));
        Assert.assertEquals("two", this.map.put(1L, "two"));
        expected.put(1L, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(33L, "thirtyFour"));
        expected.put(33L, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(30L, "thirtyOne"));
        expected.put(30L, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(5L, null));
        expected.put(5L, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put(50L, null));
        expected.put(50L, null);
        Assert.assertEquals(expected, this.map);
        MutableLongObjectMap<String> emptyMap = LongObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put(0L, "zero"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero"), emptyMap);
        MutableLongObjectMap<String> emptyMap1 = LongObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put(1L, "one"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put(0L, "zero"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero", 1L, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair(0L, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair(31L, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair(32L, "thirtyThree")));
        LongObjectHashMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "one", 31L, "thirtyTwo", 32L, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(1L, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair(1L, "two")));
        expected.put(1L, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(33L, "thirtyFour")));
        expected.put(33L, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(30L, "thirtyOne")));
        expected.put(30L, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(5L, null)));
        expected.put(5L, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair(50L, null)));
        expected.put(50L, null);
        Assert.assertEquals(expected, this.map);
        MutableLongObjectMap<String> emptyMap = LongObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair(0L, "zero")));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero"), emptyMap);
        MutableLongObjectMap<String> emptyMap1 = LongObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(1L, "one")));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair(0L, "zero")));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero", 1L, "one"), emptyMap1);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        long collision1 = AbstractMutableLongObjectMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongObjectMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongObjectMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongObjectMapTestCase.generateCollisions().get(3);
        MutableLongObjectMap<String> hashMap = LongObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableLongObjectMap<String> hashMap1 = LongObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableLongObjectMap<String> hashMap2 = LongObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableLongObjectMap<String> hashMap = this.getEmptyMap();
        MutableLongObjectMap<String> copyMap = LongObjectHashMap.newMap();
        for (long i = 1L; i < 10L; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (long i = 1L; i < 10L; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0L, "zeroValue"));
        MutableLongObjectMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1L, "oneValue"));
        expected.put(1L, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2L, () -> null));
        expected.put(2L, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32L, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33L, "thirtyThreeValue"));
        expected.put(33L, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34L, () -> null));
        expected.put(34L, null);
        Assert.assertEquals(expected, this.map);
        MutableLongObjectMap<String> emptyMap = LongObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0L, "zeroValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1L, "oneValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue", 1L, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1L, "twoValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue", 1L, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0L, "zeroValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue", 1L, "oneValue"), emptyMap);
        MutableLongObjectMap<String> emptyMap1 = LongObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1L, "oneValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0L, () -> "zeroValue"));
        MutableLongObjectMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut(1L, () -> "oneValue"));
        expected.put(1L, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(2L, () -> null));
        expected.put(2L, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut(32L, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut(33L, () -> "thirtyThreeValue"));
        expected.put(33L, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut(34L, () -> null));
        expected.put(34L, null);
        Assert.assertEquals(expected, this.map);
        MutableLongObjectMap<String> emptyMap = LongObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0L, () -> "zeroValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1L, () -> "oneValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue", 1L, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut(1L, () -> "twoValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue", 1L, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut(0L, () -> "zeroValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zeroValue", 1L, "oneValue"), emptyMap);
        MutableLongObjectMap<String> emptyMap1 = LongObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut(1L, () -> "oneValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0L, toUpperCase, "zeroValue"));
        LongObjectHashMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith(1L, toUpperCase, "oneValue"));
        expected.put(1L, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(2L, string -> null, ""));
        expected.put(2L, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith(32L, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith(33L, toUpperCase, "thirtyThreeValue"));
        expected.put(33L, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith(34L, string -> null, ""));
        expected.put(34L, null);
        Assert.assertEquals(expected, this.map);
        MutableLongObjectMap<String> emptyMap = LongObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0L, toUpperCase, "zeroValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1L, toUpperCase, "oneValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "ZEROVALUE", 1L, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith(1L, toUpperCase, "twoValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "ZEROVALUE", 1L, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith(0L, toUpperCase, "zeroValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "ZEROVALUE", 1L, "ONEVALUE"), emptyMap);
        MutableLongObjectMap<String> emptyMap1 = LongObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith(1L, toUpperCase, "oneValue"));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0L, toString));
        LongObjectHashMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("1", this.map.getIfAbsentPutWithKey(1L, toString));
        expected.put(1L, "1");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(2L, (long longParameter) -> null));
        expected.put(2L, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey(32L, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("33", this.map.getIfAbsentPutWithKey(33L, toString));
        expected.put(33L, "33");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey(34L, (long longParameter) -> null));
        expected.put(34L, null);
        Assert.assertEquals(expected, this.map);
        MutableLongObjectMap<String> emptyMap = LongObjectHashMap.newMap();
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey(0L, toString));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "0"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey(1L, toString));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "0", 1L, "1"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey(1L, toString));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "0", 1L, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.removeKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey(0L, toString));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "0", 1L, "1"), emptyMap);
        MutableLongObjectMap<String> emptyMap1 = LongObjectHashMap.newMap();
        Assert.assertEquals("1", emptyMap1.getIfAbsentPutWithKey(1L, toString));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "1"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableLongObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(0L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(0L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue(1L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2, 1L, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue(1L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2, 1L, 2), map1);
        MutableLongObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(1L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(1L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue(0L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 1, 1L, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue(0L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2, 1L, 2), map2);
        MutableLongObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue(33L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(33L, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue(33L, zeroFactory, incrementFunction));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(33L, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableLongObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(0L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(0L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith(1L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2, 1L, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith(1L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2, 1L, 2), map1);
        MutableLongObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(1L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(1L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith(0L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 1, 1L, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith(0L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, 2, 1L, 2), map2);
        MutableLongObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith(33L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(33L, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith(33L, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(33L, 2), map3);
    }

    @Test
    public void freeze() {
        MutableLongObjectMap<String> mutableLongObjectMap = this.classUnderTest();
        LongSet frozenSet = mutableLongObjectMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongObjectMap.put((long) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        LongSet frozenSetForRemove = mutableLongObjectMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableLongObjectMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableLongObjectMap<String> mutableLongObjectMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongObjectMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongObjectMapForClear.keySet().toArray());
        mutableLongObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableLongObjectMap<String> actual = this.map.withoutKey(55L);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo"), actual);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(31L, "thirtyOne", 32L, "thirtyTwo"), this.map.withoutKey(0L));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(32L, "thirtyTwo"), this.map.withoutKey(31L));
        Assert.assertEquals(LongObjectHashMap.newMap(), this.map.withoutKey(32L));
        Assert.assertEquals(LongObjectHashMap.newMap(), this.map.withoutKey(1L));
    }

    @Test
    public void withoutAllKeys() {
        MutableLongObjectMap<String> actual = this.map.withoutAllKeys(LongArrayList.newListWith(55L, 1L));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo"), actual);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(32L, "thirtyTwo"), this.map.withoutAllKeys(LongArrayList.newListWith(0L, 31L)));
        Assert.assertEquals(LongObjectHashMap.newMap(), this.map.withoutAllKeys(LongArrayList.newListWith(31L, 32L)));
        Assert.assertEquals(LongObjectHashMap.newMap(), this.map.withoutAllKeys(LongArrayList.newListWith(1L)));
    }

    @Test
    public void withAllKeyValues() {
        MutableLongObjectMap<String> emptyMap = this.getEmptyMap();
        MutableLongObjectMap<String> partialMap = this.newWithKeysValues(1L, "one", 3L, "three");
        MutableLongObjectMap<String> completeMap = this.newWithKeysValues(1L, "one", 2L, "two", 3L, "three");
        Iterable<LongObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<LongObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair(1L, "one"), PrimitiveTuples.pair(3L, "three"));
        Iterable<LongObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair(1L, "one"), PrimitiveTuples.pair(2L, "two"), PrimitiveTuples.pair(3L, "three"));
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
        Assert.assertEquals("zero", this.map.put(0L, "one"));
        Assert.assertEquals("one", this.map.get(0L));
        Assert.assertNull(this.map.put(5L, "five"));
        Assert.assertEquals("five", this.map.get(5L));
        Assert.assertNull(this.map.put(35L, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get(35L));
        Assert.assertNull(this.map.put(6L, null));
        Assert.assertNull(this.map.get(6L));
        Assert.assertNull(this.map.put(36L, null));
        Assert.assertNull(this.map.get(36L));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put(0L, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent(0L, ifAbsent));
        Assert.assertNull(this.map.put(5L, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent(5L, ifAbsent));
        Assert.assertNull(this.map.put(35L, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent(35L, ifAbsent));
        Assert.assertNull(this.map.put(6L, null));
        Assert.assertNull(this.map.getIfAbsent(6L, ifAbsent));
        Assert.assertNull(this.map.put(36L, null));
        Assert.assertNull(this.map.getIfAbsent(36L, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey(0L));
        Assert.assertFalse(this.map.containsKey(0L));
        Assert.assertEquals("thirtyOne", this.map.removeKey(31L));
        Assert.assertFalse(this.map.containsKey(31L));
        Assert.assertEquals("thirtyTwo", this.map.removeKey(32L));
        Assert.assertFalse(this.map.containsKey(32L));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put(5L, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey(5L));
        Assert.assertNull(this.map.put(35L, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(0L, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue(1L, "one").size());
        MutableLongObjectMap<String> hashMap1 = this.newWithKeysValues(1L, "one", 0L, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());
        MutableLongObjectMap<String> hashMap = this.newWithKeysValues(6L, "six", 5L, "five");
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put(1L, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey(5L));
        Assert.assertNull(this.map.put(35L, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableLongObjectMap<String> emptyMap = this.getEmptyMap();
        MutableLongObjectMap<String> hashMap = emptyMap.withKeyValue(1L, "one");
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableLongObjectMap<String> map1 = this.newWithKeysValues(0L, "zero", 1L, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), LongObjectHashMap.newWithKeysValues(0L, "zero").equals(map1) || LongObjectHashMap.newWithKeysValues(1L, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableLongObjectMap<String> map2 = this.newWithKeysValues(0L, "zero", 9L, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), LongObjectHashMap.newWithKeysValues(0L, "zero").equals(map2) || LongObjectHashMap.newWithKeysValues(9L, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map2);
        MutableLongObjectMap<String> map3 = this.newWithKeysValues(8L, "eight", 9L, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), LongObjectHashMap.newWithKeysValues(8L, "eight").equals(map3) || LongObjectHashMap.newWithKeysValues(9L, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableLongObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedLongObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedLongObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableLongObjectMap<String> map = this.newWithKeysValues(1L, "2", 2L, "3");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L, "3", 2L), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, "1", 2L, "1").flipUniqueValues());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableLongObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableLongObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableLongObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableLongObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableLongObjectMapTestCase::values;
            this.payloads.select = AbstractMutableLongObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableLongObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableLongObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableLongObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableLongObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableLongObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableLongObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableLongObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableLongObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableLongObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableLongObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableLongObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableLongObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableLongObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableLongObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableLongObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableLongObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableLongObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableLongObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableLongObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableLongObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableLongObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableLongObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableLongObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableLongObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableLongObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableLongObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableLongObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableLongObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableLongObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableLongObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableLongObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableLongObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableLongObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableLongObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableLongObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableLongObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableLongObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableLongObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableLongObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableLongObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableLongObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableLongObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableLongObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableLongObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableLongObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableLongObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableLongObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableLongObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableLongObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableLongObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableLongObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableLongObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableLongObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableLongObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableLongObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableLongObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableLongObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableLongObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableLongObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableLongObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableLongObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableLongObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableLongObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableLongObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableLongObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableLongObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableLongObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableLongObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableLongObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableLongObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableLongObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableLongObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableLongObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableLongObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableLongObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableLongObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableLongObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableLongObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableLongObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableLongObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableLongObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableLongObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableLongObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableLongObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableLongObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableLongObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableLongObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableLongObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableLongObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableLongObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableLongObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableLongObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableLongObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableLongObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableLongObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableLongObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableLongObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableLongObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableLongObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableLongObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableLongObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableLongObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableLongObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableLongObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableLongObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableLongObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableLongObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableLongObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableLongObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableLongObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableLongObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableLongObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableLongObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableLongObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableLongObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableLongObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableLongObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableLongObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableLongObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableLongObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableLongObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableLongObjectMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableLongObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableLongObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableLongObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableLongObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableLongObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableLongObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableLongObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableLongObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableLongObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableLongObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableLongObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableLongObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableLongObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableLongObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableLongObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableLongObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableLongObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableLongObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableLongObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableLongObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableLongObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableLongObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableLongObjectMapTestCase::flipUniqueValues;
        }
    }
*/
}
