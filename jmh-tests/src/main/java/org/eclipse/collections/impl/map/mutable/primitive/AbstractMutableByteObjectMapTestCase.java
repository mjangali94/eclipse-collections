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
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableByteObjectMapTestCase extends AbstractByteObjectMapTestCase {

    private final MutableByteObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableByteObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableByteObjectMap<T> newWithKeysValues(byte key1, T value1);

    @Override
    protected abstract <T> MutableByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2);

    @Override
    protected abstract <T> MutableByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2, byte key3, T value3);

    @Override
    protected abstract <T> MutableByteObjectMap<T> getEmptyMap();

    protected static ByteArrayList generateCollisions() {
        ByteArrayList collisions = new ByteArrayList();
        ByteObjectHashMap<?> hashMap = new ByteObjectHashMap<>();
        for (byte i = (byte) 2; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask((byte) 2)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableByteObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put((byte) 0, new Object());
        hashMap.clear();
        Assert.assertEquals(new ByteObjectHashMap<>(), hashMap);
        hashMap.put((byte) 1, new Object());
        hashMap.clear();
        Assert.assertEquals(new ByteObjectHashMap<>(), hashMap);
        hashMap.put((byte) 33, new Object());
        hashMap.clear();
        Assert.assertEquals(new ByteObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey((byte) 5));
        Assert.assertNull(this.map.removeKey((byte) 50));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey((byte) 31));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey((byte) 32));
        Assert.assertEquals(new ByteObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey((byte) 0));
        Assert.assertNull(this.map.removeKey((byte) 1));
        Assert.assertNull(this.map.removeKey((byte) 31));
        Assert.assertNull(this.map.removeKey((byte) 32));
        Assert.assertEquals(new ByteObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put((byte) 1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((byte) 1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((byte) 0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((byte) 0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((byte) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((byte) 35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableByteObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableByteObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst()));
        MutableByteObjectMap<String> map1 = this.newWithKeysValues((byte) 0, "zero", (byte) 1, "one");
        Assert.assertEquals("zero", map1.removeKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), map1);
        Assert.assertEquals("one", map1.removeKey((byte) 1));
        Assert.assertEquals(ByteObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove((byte) 5));
        Assert.assertNull(this.map.remove((byte) 50));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove((byte) 31));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove((byte) 32));
        Assert.assertEquals(new ByteObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove((byte) 0));
        Assert.assertNull(this.map.remove((byte) 1));
        Assert.assertNull(this.map.remove((byte) 31));
        Assert.assertNull(this.map.remove((byte) 32));
        Assert.assertEquals(new ByteObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put((byte) 1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((byte) 1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((byte) 0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((byte) 0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((byte) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((byte) 35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableByteObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableByteObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst()));
        MutableByteObjectMap<String> map1 = this.newWithKeysValues((byte) 0, "zero", (byte) 1, "one");
        Assert.assertEquals("zero", map1.remove((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), map1);
        Assert.assertEquals("one", map1.remove((byte) 1));
        Assert.assertEquals(ByteObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put((byte) 0, "one"));
        Assert.assertEquals("thirtyOne", this.map.put((byte) 31, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put((byte) 32, "thirtyThree"));
        ByteObjectHashMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "one", (byte) 31, "thirtyTwo", (byte) 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((byte) 1, "two"));
        Assert.assertEquals("two", this.map.put((byte) 1, "two"));
        expected.put((byte) 1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((byte) 33, "thirtyFour"));
        expected.put((byte) 33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((byte) 30, "thirtyOne"));
        expected.put((byte) 30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((byte) 5, null));
        expected.put((byte) 5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((byte) 50, null));
        expected.put((byte) 50, null);
        Assert.assertEquals(expected, this.map);
        MutableByteObjectMap<String> emptyMap = ByteObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put((byte) 0, "zero"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero"), emptyMap);
        MutableByteObjectMap<String> emptyMap1 = ByteObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put((byte) 1, "one"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put((byte) 0, "zero"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 1, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair((byte) 0, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair((byte) 31, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair((byte) 32, "thirtyThree")));
        ByteObjectHashMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "one", (byte) 31, "thirtyTwo", (byte) 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((byte) 1, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair((byte) 1, "two")));
        expected.put((byte) 1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((byte) 33, "thirtyFour")));
        expected.put((byte) 33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((byte) 30, "thirtyOne")));
        expected.put((byte) 30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((byte) 5, null)));
        expected.put((byte) 5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((byte) 50, null)));
        expected.put((byte) 50, null);
        Assert.assertEquals(expected, this.map);
        MutableByteObjectMap<String> emptyMap = ByteObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair((byte) 0, "zero")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero"), emptyMap);
        MutableByteObjectMap<String> emptyMap1 = ByteObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair((byte) 1, "one")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair((byte) 0, "zero")));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 1, "one"), emptyMap1);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        byte collision1 = AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteObjectMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteObjectMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteObjectMapTestCase.generateCollisions().get(3);
        MutableByteObjectMap<String> hashMap = ByteObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableByteObjectMap<String> hashMap1 = ByteObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableByteObjectMap<String> hashMap2 = ByteObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableByteObjectMap<String> hashMap = this.getEmptyMap();
        MutableByteObjectMap<String> copyMap = ByteObjectHashMap.newMap();
        for (byte i = (byte) 1; i < (byte) 10; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (byte i = (byte) 1; i < (byte) 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((byte) 0, "zeroValue"));
        MutableByteObjectMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut((byte) 1, "oneValue"));
        expected.put((byte) 1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((byte) 2, () -> null));
        expected.put((byte) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut((byte) 32, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut((byte) 33, "thirtyThreeValue"));
        expected.put((byte) 33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((byte) 34, () -> null));
        expected.put((byte) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableByteObjectMap<String> emptyMap = ByteObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((byte) 0, "zeroValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((byte) 1, "oneValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue", (byte) 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((byte) 1, "twoValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue", (byte) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((byte) 0, "zeroValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue", (byte) 1, "oneValue"), emptyMap);
        MutableByteObjectMap<String> emptyMap1 = ByteObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut((byte) 1, "oneValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((byte) 0, () -> "zeroValue"));
        MutableByteObjectMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut((byte) 1, () -> "oneValue"));
        expected.put((byte) 1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((byte) 2, () -> null));
        expected.put((byte) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut((byte) 32, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut((byte) 33, () -> "thirtyThreeValue"));
        expected.put((byte) 33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((byte) 34, () -> null));
        expected.put((byte) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableByteObjectMap<String> emptyMap = ByteObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((byte) 0, () -> "zeroValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((byte) 1, () -> "oneValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue", (byte) 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((byte) 1, () -> "twoValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue", (byte) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((byte) 0, () -> "zeroValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zeroValue", (byte) 1, "oneValue"), emptyMap);
        MutableByteObjectMap<String> emptyMap1 = ByteObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut((byte) 1, () -> "oneValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((byte) 0, toUpperCase, "zeroValue"));
        ByteObjectHashMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith((byte) 1, toUpperCase, "oneValue"));
        expected.put((byte) 1, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith((byte) 2, string -> null, ""));
        expected.put((byte) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith((byte) 32, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith((byte) 33, toUpperCase, "thirtyThreeValue"));
        expected.put((byte) 33, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith((byte) 34, string -> null, ""));
        expected.put((byte) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableByteObjectMap<String> emptyMap = ByteObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith((byte) 0, toUpperCase, "zeroValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith((byte) 1, toUpperCase, "oneValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "ZEROVALUE", (byte) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith((byte) 1, toUpperCase, "twoValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "ZEROVALUE", (byte) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith((byte) 0, toUpperCase, "zeroValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "ZEROVALUE", (byte) 1, "ONEVALUE"), emptyMap);
        MutableByteObjectMap<String> emptyMap1 = ByteObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith((byte) 1, toUpperCase, "oneValue"));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((byte) 0, toString));
        ByteObjectHashMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("1", this.map.getIfAbsentPutWithKey((byte) 1, toString));
        expected.put((byte) 1, "1");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey((byte) 2, (byte byteParameter) -> null));
        expected.put((byte) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey((byte) 32, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("33", this.map.getIfAbsentPutWithKey((byte) 33, toString));
        expected.put((byte) 33, "33");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey((byte) 34, (byte byteParameter) -> null));
        expected.put((byte) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableByteObjectMap<String> emptyMap = ByteObjectHashMap.newMap();
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey((byte) 0, toString));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "0"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey((byte) 1, toString));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "0", (byte) 1, "1"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey((byte) 1, toString));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "0", (byte) 1, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.removeKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey((byte) 0, toString));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "0", (byte) 1, "1"), emptyMap);
        MutableByteObjectMap<String> emptyMap1 = ByteObjectHashMap.newMap();
        Assert.assertEquals("1", emptyMap1.getIfAbsentPutWithKey((byte) 1, toString));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "1"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableByteObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue((byte) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue((byte) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue((byte) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue((byte) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map1);
        MutableByteObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue((byte) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue((byte) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue((byte) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 1, (byte) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue((byte) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map2);
        MutableByteObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue((byte) 33, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue((byte) 33, zeroFactory, incrementFunction));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 33, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableByteObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith((byte) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith((byte) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith((byte) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith((byte) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map1);
        MutableByteObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith((byte) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith((byte) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith((byte) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 1, (byte) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith((byte) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map2);
        MutableByteObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith((byte) 33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith((byte) 33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableByteObjectMap<String> mutableByteObjectMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteObjectMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteObjectMap.put((byte) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ByteSet frozenSetForRemove = mutableByteObjectMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableByteObjectMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableByteObjectMap<String> mutableByteObjectMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteObjectMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteObjectMapForClear.keySet().toArray());
        mutableByteObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableByteObjectMap<String> actual = this.map.withoutKey((byte) 55);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), actual);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), this.map.withoutKey((byte) 0));
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 32, "thirtyTwo"), this.map.withoutKey((byte) 31));
        Assert.assertEquals(ByteObjectHashMap.newMap(), this.map.withoutKey((byte) 32));
        Assert.assertEquals(ByteObjectHashMap.newMap(), this.map.withoutKey((byte) 1));
    }

    @Test
    public void withoutAllKeys() {
        MutableByteObjectMap<String> actual = this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 55, (byte) 1));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"), actual);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 32, "thirtyTwo"), this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 31)));
        Assert.assertEquals(ByteObjectHashMap.newMap(), this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 31, (byte) 32)));
        Assert.assertEquals(ByteObjectHashMap.newMap(), this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 1)));
    }

    @Test
    public void withAllKeyValues() {
        MutableByteObjectMap<String> emptyMap = this.getEmptyMap();
        MutableByteObjectMap<String> partialMap = this.newWithKeysValues((byte) 1, "one", (byte) 3, "three");
        MutableByteObjectMap<String> completeMap = this.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three");
        Iterable<ByteObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<ByteObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, "one"), PrimitiveTuples.pair((byte) 3, "three"));
        Iterable<ByteObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair((byte) 1, "one"), PrimitiveTuples.pair((byte) 2, "two"), PrimitiveTuples.pair((byte) 3, "three"));
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
        Assert.assertEquals("zero", this.map.put((byte) 0, "one"));
        Assert.assertEquals("one", this.map.get((byte) 0));
        Assert.assertNull(this.map.put((byte) 5, "five"));
        Assert.assertEquals("five", this.map.get((byte) 5));
        Assert.assertNull(this.map.put((byte) 35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get((byte) 35));
        Assert.assertNull(this.map.put((byte) 6, null));
        Assert.assertNull(this.map.get((byte) 6));
        Assert.assertNull(this.map.put((byte) 36, null));
        Assert.assertNull(this.map.get((byte) 36));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put((byte) 0, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent((byte) 0, ifAbsent));
        Assert.assertNull(this.map.put((byte) 5, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent((byte) 5, ifAbsent));
        Assert.assertNull(this.map.put((byte) 35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent((byte) 35, ifAbsent));
        Assert.assertNull(this.map.put((byte) 6, null));
        Assert.assertNull(this.map.getIfAbsent((byte) 6, ifAbsent));
        Assert.assertNull(this.map.put((byte) 36, null));
        Assert.assertNull(this.map.getIfAbsent((byte) 36, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey((byte) 0));
        Assert.assertFalse(this.map.containsKey((byte) 0));
        Assert.assertEquals("thirtyOne", this.map.removeKey((byte) 31));
        Assert.assertFalse(this.map.containsKey((byte) 31));
        Assert.assertEquals("thirtyTwo", this.map.removeKey((byte) 32));
        Assert.assertFalse(this.map.containsKey((byte) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put((byte) 5, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((byte) 5));
        Assert.assertNull(this.map.put((byte) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue((byte) 0, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue((byte) 1, "one").size());
        MutableByteObjectMap<String> hashMap1 = this.newWithKeysValues((byte) 1, "one", (byte) 0, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableByteObjectMap<String> hashMap = this.newWithKeysValues((byte) 6, "six", (byte) 5, "five");
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put((byte) 1, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey((byte) 5));
        Assert.assertNull(this.map.put((byte) 35, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableByteObjectMap<String> emptyMap = this.getEmptyMap();
        MutableByteObjectMap<String> hashMap = emptyMap.withKeyValue((byte) 1, "one");
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableByteObjectMap<String> map1 = this.newWithKeysValues((byte) 0, "zero", (byte) 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), ByteObjectHashMap.newWithKeysValues((byte) 0, "zero").equals(map1) || ByteObjectHashMap.newWithKeysValues((byte) 1, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(ByteObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableByteObjectMap<String> map2 = this.newWithKeysValues((byte) 0, "zero", (byte) 9, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), ByteObjectHashMap.newWithKeysValues((byte) 0, "zero").equals(map2) || ByteObjectHashMap.newWithKeysValues((byte) 9, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(ByteObjectHashMap.newMap(), map2);
        MutableByteObjectMap<String> map3 = this.newWithKeysValues((byte) 8, "eight", (byte) 9, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), ByteObjectHashMap.newWithKeysValues((byte) 8, "eight").equals(map3) || ByteObjectHashMap.newWithKeysValues((byte) 9, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(ByteObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableByteObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedByteObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedByteObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableByteObjectMap<String> map = this.newWithKeysValues((byte) 1, "2", (byte) 2, "3");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 1, "3", (byte) 2), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((byte) 1, "1", (byte) 2, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractByteObjectMapTestCase._Benchmark {

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
        public abstract AbstractMutableByteObjectMapTestCase implementation();
    }
}
