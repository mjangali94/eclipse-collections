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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableByteObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableByteObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableByteObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableByteObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableByteObjectMapTestCase::values;
            this.payloads.select = AbstractMutableByteObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableByteObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableByteObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableByteObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableByteObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableByteObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableByteObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableByteObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableByteObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableByteObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableByteObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableByteObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableByteObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableByteObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableByteObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableByteObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableByteObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableByteObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableByteObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableByteObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableByteObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableByteObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableByteObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableByteObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableByteObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableByteObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableByteObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableByteObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableByteObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableByteObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableByteObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableByteObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableByteObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableByteObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableByteObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableByteObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableByteObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableByteObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableByteObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableByteObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableByteObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableByteObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableByteObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableByteObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableByteObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableByteObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableByteObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableByteObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableByteObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableByteObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableByteObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableByteObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableByteObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableByteObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableByteObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableByteObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableByteObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableByteObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableByteObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableByteObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableByteObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableByteObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableByteObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableByteObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableByteObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableByteObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableByteObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableByteObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableByteObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableByteObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableByteObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableByteObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableByteObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableByteObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableByteObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableByteObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableByteObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableByteObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableByteObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableByteObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableByteObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableByteObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableByteObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableByteObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableByteObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableByteObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableByteObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableByteObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableByteObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableByteObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableByteObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableByteObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableByteObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableByteObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableByteObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableByteObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableByteObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableByteObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableByteObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableByteObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableByteObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableByteObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableByteObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableByteObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableByteObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableByteObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableByteObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableByteObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableByteObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableByteObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableByteObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableByteObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableByteObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableByteObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableByteObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableByteObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableByteObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableByteObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableByteObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableByteObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableByteObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableByteObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableByteObjectMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableByteObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableByteObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableByteObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableByteObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableByteObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableByteObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableByteObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableByteObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableByteObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableByteObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableByteObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableByteObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableByteObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableByteObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableByteObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableByteObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableByteObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableByteObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableByteObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableByteObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableByteObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableByteObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableByteObjectMapTestCase::flipUniqueValues;
        }
    }
}
