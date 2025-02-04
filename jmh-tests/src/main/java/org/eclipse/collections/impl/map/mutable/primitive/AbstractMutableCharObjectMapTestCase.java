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
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableCharObjectMapTestCase extends AbstractCharObjectMapTestCase {

    private final MutableCharObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableCharObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableCharObjectMap<T> newWithKeysValues(char key1, T value1);

    @Override
    protected abstract <T> MutableCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2);

    @Override
    protected abstract <T> MutableCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3);

    @Override
    protected abstract <T> MutableCharObjectMap<T> getEmptyMap();

    protected static CharArrayList generateCollisions() {
        CharArrayList collisions = new CharArrayList();
        CharObjectHashMap<?> hashMap = new CharObjectHashMap<>();
        for (char i = (char) 2; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask((char) 2)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableCharObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put((char) 0, new Object());
        hashMap.clear();
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);
        hashMap.put((char) 1, new Object());
        hashMap.clear();
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);
        hashMap.put((char) 33, new Object());
        hashMap.clear();
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey((char) 5));
        Assert.assertNull(this.map.removeKey((char) 50));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 31, "thirtyOne", (char) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey((char) 31));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey((char) 32));
        Assert.assertEquals(new CharObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey((char) 0));
        Assert.assertNull(this.map.removeKey((char) 1));
        Assert.assertNull(this.map.removeKey((char) 31));
        Assert.assertNull(this.map.removeKey((char) 32));
        Assert.assertEquals(new CharObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put((char) 1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((char) 1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((char) 0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((char) 0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((char) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((char) 35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableCharObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableCharObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableCharObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableCharObjectMapTestCase.generateCollisions().getFirst()));
        MutableCharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Assert.assertEquals("zero", map1.removeKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), map1);
        Assert.assertEquals("one", map1.removeKey((char) 1));
        Assert.assertEquals(CharObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove((char) 5));
        Assert.assertNull(this.map.remove((char) 50));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 31, "thirtyOne", (char) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove((char) 31));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove((char) 32));
        Assert.assertEquals(new CharObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove((char) 0));
        Assert.assertNull(this.map.remove((char) 1));
        Assert.assertNull(this.map.remove((char) 31));
        Assert.assertNull(this.map.remove((char) 32));
        Assert.assertEquals(new CharObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put((char) 1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((char) 1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((char) 0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((char) 0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((char) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((char) 35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableCharObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableCharObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableCharObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableCharObjectMapTestCase.generateCollisions().getFirst()));
        MutableCharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Assert.assertEquals("zero", map1.remove((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), map1);
        Assert.assertEquals("one", map1.remove((char) 1));
        Assert.assertEquals(CharObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put((char) 0, "one"));
        Assert.assertEquals("thirtyOne", this.map.put((char) 31, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put((char) 32, "thirtyThree"));
        CharObjectHashMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "one", (char) 31, "thirtyTwo", (char) 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((char) 1, "two"));
        Assert.assertEquals("two", this.map.put((char) 1, "two"));
        expected.put((char) 1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((char) 33, "thirtyFour"));
        expected.put((char) 33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((char) 30, "thirtyOne"));
        expected.put((char) 30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((char) 5, null));
        expected.put((char) 5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((char) 50, null));
        expected.put((char) 50, null);
        Assert.assertEquals(expected, this.map);
        MutableCharObjectMap<String> emptyMap = CharObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put((char) 0, "zero"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero"), emptyMap);
        MutableCharObjectMap<String> emptyMap1 = CharObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put((char) 1, "one"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put((char) 0, "zero"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 1, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair((char) 0, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair((char) 31, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair((char) 32, "thirtyThree")));
        CharObjectHashMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "one", (char) 31, "thirtyTwo", (char) 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((char) 1, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair((char) 1, "two")));
        expected.put((char) 1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((char) 33, "thirtyFour")));
        expected.put((char) 33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((char) 30, "thirtyOne")));
        expected.put((char) 30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((char) 5, null)));
        expected.put((char) 5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((char) 50, null)));
        expected.put((char) 50, null);
        Assert.assertEquals(expected, this.map);
        MutableCharObjectMap<String> emptyMap = CharObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair((char) 0, "zero")));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero"), emptyMap);
        MutableCharObjectMap<String> emptyMap1 = CharObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair((char) 1, "one")));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair((char) 0, "zero")));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 1, "one"), emptyMap1);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharObjectMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharObjectMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharObjectMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharObjectMapTestCase.generateCollisions().get(3);
        MutableCharObjectMap<String> hashMap = CharObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableCharObjectMap<String> hashMap1 = CharObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableCharObjectMap<String> hashMap2 = CharObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        MutableCharObjectMap<String> copyMap = CharObjectHashMap.newMap();
        for (char i = (char) 1; i < (char) 10; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (char i = (char) 1; i < (char) 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((char) 0, "zeroValue"));
        MutableCharObjectMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut((char) 1, "oneValue"));
        expected.put((char) 1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((char) 2, () -> null));
        expected.put((char) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut((char) 32, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut((char) 33, "thirtyThreeValue"));
        expected.put((char) 33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((char) 34, () -> null));
        expected.put((char) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableCharObjectMap<String> emptyMap = CharObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((char) 0, "zeroValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((char) 1, "oneValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue", (char) 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((char) 1, "twoValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue", (char) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((char) 0, "zeroValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue", (char) 1, "oneValue"), emptyMap);
        MutableCharObjectMap<String> emptyMap1 = CharObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut((char) 1, "oneValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((char) 0, () -> "zeroValue"));
        MutableCharObjectMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut((char) 1, () -> "oneValue"));
        expected.put((char) 1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((char) 2, () -> null));
        expected.put((char) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut((char) 32, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut((char) 33, () -> "thirtyThreeValue"));
        expected.put((char) 33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((char) 34, () -> null));
        expected.put((char) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableCharObjectMap<String> emptyMap = CharObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((char) 0, () -> "zeroValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((char) 1, () -> "oneValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue", (char) 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((char) 1, () -> "twoValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue", (char) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((char) 0, () -> "zeroValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zeroValue", (char) 1, "oneValue"), emptyMap);
        MutableCharObjectMap<String> emptyMap1 = CharObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut((char) 1, () -> "oneValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((char) 0, toUpperCase, "zeroValue"));
        CharObjectHashMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith((char) 1, toUpperCase, "oneValue"));
        expected.put((char) 1, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith((char) 2, string -> null, ""));
        expected.put((char) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith((char) 32, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith((char) 33, toUpperCase, "thirtyThreeValue"));
        expected.put((char) 33, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith((char) 34, string -> null, ""));
        expected.put((char) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableCharObjectMap<String> emptyMap = CharObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith((char) 0, toUpperCase, "zeroValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith((char) 1, toUpperCase, "oneValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "ZEROVALUE", (char) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith((char) 1, toUpperCase, "twoValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "ZEROVALUE", (char) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith((char) 0, toUpperCase, "zeroValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "ZEROVALUE", (char) 1, "ONEVALUE"), emptyMap);
        MutableCharObjectMap<String> emptyMap1 = CharObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith((char) 1, toUpperCase, "oneValue"));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((char) 0, toString));
        CharObjectHashMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("\u0001", this.map.getIfAbsentPutWithKey((char) 1, toString));
        expected.put((char) 1, "\u0001");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey((char) 2, (char charParameter) -> null));
        expected.put((char) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey((char) 32, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("\u0021", this.map.getIfAbsentPutWithKey((char) 33, toString));
        expected.put((char) 33, "\u0021");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey((char) 34, (char charParameter) -> null));
        expected.put((char) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableCharObjectMap<String> emptyMap = CharObjectHashMap.newMap();
        Assert.assertEquals("\u0000", emptyMap.getIfAbsentPutWithKey((char) 0, toString));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "\u0000"), emptyMap);
        Assert.assertEquals("\u0001", emptyMap.getIfAbsentPutWithKey((char) 1, toString));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "\u0000", (char) 1, "\u0001"), emptyMap);
        Assert.assertEquals("\u0001", emptyMap.getIfAbsentPutWithKey((char) 1, toString));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "\u0000", (char) 1, "\u0001"), emptyMap);
        Assert.assertEquals("\u0000", emptyMap.removeKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "\u0001"), emptyMap);
        Assert.assertEquals("\u0000", emptyMap.getIfAbsentPutWithKey((char) 0, toString));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "\u0000", (char) 1, "\u0001"), emptyMap);
        MutableCharObjectMap<String> emptyMap1 = CharObjectHashMap.newMap();
        Assert.assertEquals("\u0001", emptyMap1.getIfAbsentPutWithKey((char) 1, toString));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "\u0001"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableCharObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue((char) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue((char) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue((char) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2, (char) 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue((char) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map1);
        MutableCharObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue((char) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue((char) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue((char) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 1, (char) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue((char) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map2);
        MutableCharObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue((char) 33, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue((char) 33, zeroFactory, incrementFunction));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 33, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableCharObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith((char) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith((char) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith((char) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2, (char) 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith((char) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map1);
        MutableCharObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith((char) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith((char) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith((char) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 1, (char) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith((char) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map2);
        MutableCharObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith((char) 33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith((char) 33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableCharObjectMap<String> mutableCharObjectMap = this.classUnderTest();
        CharSet frozenSet = mutableCharObjectMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharObjectMap.put((char) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        CharSet frozenSetForRemove = mutableCharObjectMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableCharObjectMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableCharObjectMap<String> mutableCharObjectMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharObjectMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharObjectMapForClear.keySet().toArray());
        mutableCharObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableCharObjectMap<String> actual = this.map.withoutKey((char) 55);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"), actual);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 31, "thirtyOne", (char) 32, "thirtyTwo"), this.map.withoutKey((char) 0));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 32, "thirtyTwo"), this.map.withoutKey((char) 31));
        Assert.assertEquals(CharObjectHashMap.newMap(), this.map.withoutKey((char) 32));
        Assert.assertEquals(CharObjectHashMap.newMap(), this.map.withoutKey((char) 1));
    }

    @Test
    public void withoutAllKeys() {
        MutableCharObjectMap<String> actual = this.map.withoutAllKeys(CharArrayList.newListWith((char) 55, (char) 1));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"), actual);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 32, "thirtyTwo"), this.map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 31)));
        Assert.assertEquals(CharObjectHashMap.newMap(), this.map.withoutAllKeys(CharArrayList.newListWith((char) 31, (char) 32)));
        Assert.assertEquals(CharObjectHashMap.newMap(), this.map.withoutAllKeys(CharArrayList.newListWith((char) 1)));
    }

    @Test
    public void withAllKeyValues() {
        MutableCharObjectMap<String> emptyMap = this.getEmptyMap();
        MutableCharObjectMap<String> partialMap = this.newWithKeysValues((char) 1, "one", (char) 3, "three");
        MutableCharObjectMap<String> completeMap = this.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three");
        Iterable<CharObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<CharObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, "one"), PrimitiveTuples.pair((char) 3, "three"));
        Iterable<CharObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair((char) 1, "one"), PrimitiveTuples.pair((char) 2, "two"), PrimitiveTuples.pair((char) 3, "three"));
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
        Assert.assertEquals("zero", this.map.put((char) 0, "one"));
        Assert.assertEquals("one", this.map.get((char) 0));
        Assert.assertNull(this.map.put((char) 5, "five"));
        Assert.assertEquals("five", this.map.get((char) 5));
        Assert.assertNull(this.map.put((char) 35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get((char) 35));
        Assert.assertNull(this.map.put((char) 6, null));
        Assert.assertNull(this.map.get((char) 6));
        Assert.assertNull(this.map.put((char) 36, null));
        Assert.assertNull(this.map.get((char) 36));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put((char) 0, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent((char) 0, ifAbsent));
        Assert.assertNull(this.map.put((char) 5, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent((char) 5, ifAbsent));
        Assert.assertNull(this.map.put((char) 35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent((char) 35, ifAbsent));
        Assert.assertNull(this.map.put((char) 6, null));
        Assert.assertNull(this.map.getIfAbsent((char) 6, ifAbsent));
        Assert.assertNull(this.map.put((char) 36, null));
        Assert.assertNull(this.map.getIfAbsent((char) 36, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey((char) 0));
        Assert.assertFalse(this.map.containsKey((char) 0));
        Assert.assertEquals("thirtyOne", this.map.removeKey((char) 31));
        Assert.assertFalse(this.map.containsKey((char) 31));
        Assert.assertEquals("thirtyTwo", this.map.removeKey((char) 32));
        Assert.assertFalse(this.map.containsKey((char) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put((char) 5, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((char) 5));
        Assert.assertNull(this.map.put((char) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue((char) 0, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue((char) 1, "one").size());
        MutableCharObjectMap<String> hashMap1 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableCharObjectMap<String> hashMap = this.newWithKeysValues((char) 6, "six", (char) 5, "five");
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put((char) 1, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey((char) 5));
        Assert.assertNull(this.map.put((char) 35, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableCharObjectMap<String> emptyMap = this.getEmptyMap();
        MutableCharObjectMap<String> hashMap = emptyMap.withKeyValue((char) 1, "one");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableCharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), CharObjectHashMap.newWithKeysValues((char) 0, "zero").equals(map1) || CharObjectHashMap.newWithKeysValues((char) 1, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(CharObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableCharObjectMap<String> map2 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), CharObjectHashMap.newWithKeysValues((char) 0, "zero").equals(map2) || CharObjectHashMap.newWithKeysValues((char) 9, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(CharObjectHashMap.newMap(), map2);
        MutableCharObjectMap<String> map3 = this.newWithKeysValues((char) 8, "eight", (char) 9, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), CharObjectHashMap.newWithKeysValues((char) 8, "eight").equals(map3) || CharObjectHashMap.newWithKeysValues((char) 9, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(CharObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableCharObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedCharObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedCharObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableCharObjectMap<String> map = this.newWithKeysValues((char) 1, "2", (char) 2, "3");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1, "3", (char) 2), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, "1", (char) 2, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableCharObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableCharObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableCharObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableCharObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableCharObjectMapTestCase::values;
            this.payloads.select = AbstractMutableCharObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableCharObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableCharObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableCharObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableCharObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableCharObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableCharObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableCharObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableCharObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableCharObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableCharObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableCharObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableCharObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableCharObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableCharObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableCharObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableCharObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableCharObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableCharObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableCharObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableCharObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableCharObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableCharObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableCharObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableCharObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableCharObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableCharObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableCharObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableCharObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableCharObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableCharObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableCharObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableCharObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableCharObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableCharObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableCharObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableCharObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableCharObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableCharObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableCharObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableCharObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableCharObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableCharObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableCharObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableCharObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableCharObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableCharObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableCharObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableCharObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableCharObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableCharObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableCharObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableCharObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableCharObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableCharObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableCharObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableCharObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableCharObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableCharObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableCharObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableCharObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableCharObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableCharObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableCharObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableCharObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableCharObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableCharObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableCharObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableCharObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableCharObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableCharObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableCharObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableCharObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableCharObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableCharObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableCharObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableCharObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableCharObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableCharObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableCharObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableCharObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableCharObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableCharObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableCharObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableCharObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableCharObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableCharObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableCharObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableCharObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableCharObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableCharObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableCharObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableCharObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableCharObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableCharObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableCharObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableCharObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableCharObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableCharObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableCharObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableCharObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableCharObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableCharObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableCharObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableCharObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableCharObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableCharObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableCharObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableCharObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableCharObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableCharObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableCharObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableCharObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableCharObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableCharObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableCharObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableCharObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableCharObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableCharObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableCharObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableCharObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableCharObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableCharObjectMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableCharObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableCharObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableCharObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableCharObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableCharObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableCharObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableCharObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableCharObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableCharObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableCharObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableCharObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableCharObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableCharObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableCharObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableCharObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableCharObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableCharObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableCharObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableCharObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableCharObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableCharObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableCharObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableCharObjectMapTestCase::flipUniqueValues;
        }
    }
}
