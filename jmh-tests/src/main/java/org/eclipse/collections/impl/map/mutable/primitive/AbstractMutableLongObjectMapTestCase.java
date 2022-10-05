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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractLongObjectMapTestCase._Benchmark {

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
        public abstract AbstractMutableLongObjectMapTestCase implementation();
    }
}
