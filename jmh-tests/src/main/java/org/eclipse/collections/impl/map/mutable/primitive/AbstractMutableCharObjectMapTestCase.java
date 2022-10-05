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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractCharObjectMapTestCase._Benchmark {

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
        public abstract AbstractMutableCharObjectMapTestCase implementation();
    }
}
