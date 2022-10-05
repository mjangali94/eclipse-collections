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
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortObjectMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractMutableShortObjectMapTestCase extends AbstractShortObjectMapTestCase {

    private final MutableShortObjectMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableShortObjectMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableShortObjectMap<T> newWithKeysValues(short key1, T value1);

    @Override
    protected abstract <T> MutableShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2);

    @Override
    protected abstract <T> MutableShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2, short key3, T value3);

    @Override
    protected abstract <T> MutableShortObjectMap<T> getEmptyMap();

    protected static ShortArrayList generateCollisions() {
        ShortArrayList collisions = new ShortArrayList();
        ShortObjectHashMap<?> hashMap = new ShortObjectHashMap<>();
        for (short i = (short) 2; collisions.size() <= 10; i++) {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask((short) 2)) {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableShortObjectMap<Object> hashMap = this.getEmptyMap();
        hashMap.put((short) 0, new Object());
        hashMap.clear();
        Assert.assertEquals(new ShortObjectHashMap<>(), hashMap);
        hashMap.put((short) 1, new Object());
        hashMap.clear();
        Assert.assertEquals(new ShortObjectHashMap<>(), hashMap);
        hashMap.put((short) 33, new Object());
        hashMap.clear();
        Assert.assertEquals(new ShortObjectHashMap<>(), hashMap);
    }

    @Test
    public void removeKey() {
        Assert.assertNull(this.map.removeKey((short) 5));
        Assert.assertNull(this.map.removeKey((short) 50));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.removeKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 31, "thirtyOne", (short) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.removeKey((short) 31));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.removeKey((short) 32));
        Assert.assertEquals(new ShortObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.removeKey((short) 0));
        Assert.assertNull(this.map.removeKey((short) 1));
        Assert.assertNull(this.map.removeKey((short) 31));
        Assert.assertNull(this.map.removeKey((short) 32));
        Assert.assertEquals(new ShortObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put((short) 1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((short) 1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((short) 0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((short) 0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((short) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((short) 35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableShortObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.removeKey(AbstractMutableShortObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.removeKey(AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst()));
        MutableShortObjectMap<String> map1 = this.newWithKeysValues((short) 0, "zero", (short) 1, "one");
        Assert.assertEquals("zero", map1.removeKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), map1);
        Assert.assertEquals("one", map1.removeKey((short) 1));
        Assert.assertEquals(ShortObjectHashMap.newMap(), map1);
    }

    @Test
    public void remove() {
        Assert.assertNull(this.map.remove((short) 5));
        Assert.assertNull(this.map.remove((short) 50));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("zero", this.map.remove((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 31, "thirtyOne", (short) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyOne", this.map.remove((short) 31));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 32, "thirtyTwo"), this.map);
        Assert.assertEquals("thirtyTwo", this.map.remove((short) 32));
        Assert.assertEquals(new ShortObjectHashMap<String>(), this.map);
        Assert.assertNull(this.map.remove((short) 0));
        Assert.assertNull(this.map.remove((short) 1));
        Assert.assertNull(this.map.remove((short) 31));
        Assert.assertNull(this.map.remove((short) 32));
        Assert.assertEquals(new ShortObjectHashMap<String>(), this.map);
        Assert.assertTrue(this.map.isEmpty());
        Assert.assertNull(this.map.put((short) 1, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((short) 1));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((short) 0, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((short) 0));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put((short) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.remove((short) 35));
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertNull(this.map.put(AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst(), "collision1"));
        Assert.assertNull(this.map.put(AbstractMutableShortObjectMapTestCase.generateCollisions().get(1), "collision2"));
        Assert.assertEquals("collision2", this.map.remove(AbstractMutableShortObjectMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals("collision1", this.map.remove(AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst()));
        MutableShortObjectMap<String> map1 = this.newWithKeysValues((short) 0, "zero", (short) 1, "one");
        Assert.assertEquals("zero", map1.remove((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), map1);
        Assert.assertEquals("one", map1.remove((short) 1));
        Assert.assertEquals(ShortObjectHashMap.newMap(), map1);
    }

    @Test
    public void put() {
        Assert.assertEquals("zero", this.map.put((short) 0, "one"));
        Assert.assertEquals("thirtyOne", this.map.put((short) 31, "thirtyTwo"));
        Assert.assertEquals("thirtyTwo", this.map.put((short) 32, "thirtyThree"));
        ShortObjectHashMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "one", (short) 31, "thirtyTwo", (short) 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((short) 1, "two"));
        Assert.assertEquals("two", this.map.put((short) 1, "two"));
        expected.put((short) 1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((short) 33, "thirtyFour"));
        expected.put((short) 33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((short) 30, "thirtyOne"));
        expected.put((short) 30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((short) 5, null));
        expected.put((short) 5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.put((short) 50, null));
        expected.put((short) 50, null);
        Assert.assertEquals(expected, this.map);
        MutableShortObjectMap<String> emptyMap = ShortObjectHashMap.newMap();
        Assert.assertNull(emptyMap.put((short) 0, "zero"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero"), emptyMap);
        MutableShortObjectMap<String> emptyMap1 = ShortObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.put((short) 1, "one"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.put((short) 0, "zero"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 1, "one"), emptyMap1);
    }

    @Test
    public void putPair() {
        Assert.assertEquals("zero", this.map.putPair(PrimitiveTuples.pair((short) 0, "one")));
        Assert.assertEquals("thirtyOne", this.map.putPair(PrimitiveTuples.pair((short) 31, "thirtyTwo")));
        Assert.assertEquals("thirtyTwo", this.map.putPair(PrimitiveTuples.pair((short) 32, "thirtyThree")));
        ShortObjectHashMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "one", (short) 31, "thirtyTwo", (short) 32, "thirtyThree");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((short) 1, "two")));
        Assert.assertEquals("two", this.map.putPair(PrimitiveTuples.pair((short) 1, "two")));
        expected.put((short) 1, "two");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((short) 33, "thirtyFour")));
        expected.put((short) 33, "thirtyFour");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((short) 30, "thirtyOne")));
        expected.put((short) 30, "thirtyOne");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((short) 5, null)));
        expected.put((short) 5, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.putPair(PrimitiveTuples.pair((short) 50, null)));
        expected.put((short) 50, null);
        Assert.assertEquals(expected, this.map);
        MutableShortObjectMap<String> emptyMap = ShortObjectHashMap.newMap();
        Assert.assertNull(emptyMap.putPair(PrimitiveTuples.pair((short) 0, "zero")));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero"), emptyMap);
        MutableShortObjectMap<String> emptyMap1 = ShortObjectHashMap.newMap();
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair((short) 1, "one")));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), emptyMap1);
        Assert.assertNull(emptyMap1.putPair(PrimitiveTuples.pair((short) 0, "zero")));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 1, "one"), emptyMap1);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        short collision1 = AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortObjectMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortObjectMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortObjectMapTestCase.generateCollisions().get(3);
        MutableShortObjectMap<String> hashMap = ShortObjectHashMap.newMap();
        Assert.assertNull(hashMap.put(collision1, "collision1"));
        Assert.assertNull(hashMap.put(collision2, "collision2"));
        Assert.assertNull(hashMap.put(collision3, "collision3"));
        Assert.assertEquals("collision2", hashMap.removeKey(collision2));
        Assert.assertNull(hashMap.put(collision4, "collision4"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues(collision1, "collision1", collision3, "collision3", collision4, "collision4"), hashMap);
        MutableShortObjectMap<String> hashMap1 = ShortObjectHashMap.newMap();
        Assert.assertNull(hashMap1.put(collision1, "collision1"));
        Assert.assertNull(hashMap1.put(collision2, "collision2"));
        Assert.assertNull(hashMap1.put(collision3, "collision3"));
        Assert.assertEquals("collision1", hashMap1.removeKey(collision1));
        Assert.assertNull(hashMap1.put(collision4, "collision4"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues(collision2, "collision2", collision3, "collision3", collision4, "collision4"), hashMap1);
        MutableShortObjectMap<String> hashMap2 = ShortObjectHashMap.newMap();
        Assert.assertNull(hashMap2.put(collision1, "collision1"));
        Assert.assertNull(hashMap2.put(collision2, "collision2"));
        Assert.assertNull(hashMap2.put(collision3, "collision3"));
        Assert.assertEquals("collision3", hashMap2.removeKey(collision3));
        Assert.assertNull(hashMap2.put(collision4, "collision4"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues(collision1, "collision1", collision2, "collision2", collision4, "collision4"), hashMap2);
    }

    @Test
    public void putAll() {
        MutableShortObjectMap<String> hashMap = this.getEmptyMap();
        MutableShortObjectMap<String> copyMap = ShortObjectHashMap.newMap();
        for (short i = (short) 1; i < (short) 10; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(9, copyMap.size());
        Assert.assertEquals(0, hashMap.size());
        hashMap.putAll(copyMap);
        Assert.assertEquals(9, hashMap.size());
        for (short i = (short) 1; i < (short) 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void getIfAbsentPut_Value() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((short) 0, "zeroValue"));
        MutableShortObjectMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut((short) 1, "oneValue"));
        expected.put((short) 1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((short) 2, () -> null));
        expected.put((short) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut((short) 32, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut((short) 33, "thirtyThreeValue"));
        expected.put((short) 33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((short) 34, () -> null));
        expected.put((short) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableShortObjectMap<String> emptyMap = ShortObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((short) 0, "zeroValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((short) 1, "oneValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue", (short) 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((short) 1, "twoValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue", (short) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((short) 0, "zeroValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue", (short) 1, "oneValue"), emptyMap);
        MutableShortObjectMap<String> emptyMap1 = ShortObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut((short) 1, "oneValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPut_Function() {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((short) 0, () -> "zeroValue"));
        MutableShortObjectMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("oneValue", this.map.getIfAbsentPut((short) 1, () -> "oneValue"));
        expected.put((short) 1, "oneValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((short) 2, () -> null));
        expected.put((short) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPut((short) 32, () -> "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyThreeValue", this.map.getIfAbsentPut((short) 33, () -> "thirtyThreeValue"));
        expected.put((short) 33, "thirtyThreeValue");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPut((short) 34, () -> null));
        expected.put((short) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableShortObjectMap<String> emptyMap = ShortObjectHashMap.newMap();
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((short) 0, () -> "zeroValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((short) 1, () -> "oneValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue", (short) 1, "oneValue"), emptyMap);
        Assert.assertEquals("oneValue", emptyMap.getIfAbsentPut((short) 1, () -> "twoValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue", (short) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.removeKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "oneValue"), emptyMap);
        Assert.assertEquals("zeroValue", emptyMap.getIfAbsentPut((short) 0, () -> "zeroValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zeroValue", (short) 1, "oneValue"), emptyMap);
        MutableShortObjectMap<String> emptyMap1 = ShortObjectHashMap.newMap();
        Assert.assertEquals("oneValue", emptyMap1.getIfAbsentPut((short) 1, () -> "oneValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "oneValue"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWith() {
        Function<String, String> toUpperCase = StringFunctions.toUpperCase();
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((short) 0, toUpperCase, "zeroValue"));
        ShortObjectHashMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("ONEVALUE", this.map.getIfAbsentPutWith((short) 1, toUpperCase, "oneValue"));
        expected.put((short) 1, "ONEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith((short) 2, string -> null, ""));
        expected.put((short) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWith((short) 32, toUpperCase, "thirtyTwoValue"));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("THIRTYTHREEVALUE", this.map.getIfAbsentPutWith((short) 33, toUpperCase, "thirtyThreeValue"));
        expected.put((short) 33, "THIRTYTHREEVALUE");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWith((short) 34, string -> null, ""));
        expected.put((short) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableShortObjectMap<String> emptyMap = ShortObjectHashMap.newMap();
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith((short) 0, toUpperCase, "zeroValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "ZEROVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith((short) 1, toUpperCase, "oneValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "ZEROVALUE", (short) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ONEVALUE", emptyMap.getIfAbsentPutWith((short) 1, toUpperCase, "twoValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "ZEROVALUE", (short) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.removeKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "ONEVALUE"), emptyMap);
        Assert.assertEquals("ZEROVALUE", emptyMap.getIfAbsentPutWith((short) 0, toUpperCase, "zeroValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "ZEROVALUE", (short) 1, "ONEVALUE"), emptyMap);
        MutableShortObjectMap<String> emptyMap1 = ShortObjectHashMap.newMap();
        Assert.assertEquals("ONEVALUE", emptyMap1.getIfAbsentPutWith((short) 1, toUpperCase, "oneValue"));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "ONEVALUE"), emptyMap1);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((short) 0, toString));
        ShortObjectHashMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo");
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("1", this.map.getIfAbsentPutWithKey((short) 1, toString));
        expected.put((short) 1, "1");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey((short) 2, (short shortParameter) -> null));
        expected.put((short) 2, null);
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsentPutWithKey((short) 32, toString));
        Assert.assertEquals(expected, this.map);
        Assert.assertEquals("33", this.map.getIfAbsentPutWithKey((short) 33, toString));
        expected.put((short) 33, "33");
        Assert.assertEquals(expected, this.map);
        Assert.assertNull(this.map.getIfAbsentPutWithKey((short) 34, (short shortParameter) -> null));
        expected.put((short) 34, null);
        Assert.assertEquals(expected, this.map);
        MutableShortObjectMap<String> emptyMap = ShortObjectHashMap.newMap();
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey((short) 0, toString));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "0"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey((short) 1, toString));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "0", (short) 1, "1"), emptyMap);
        Assert.assertEquals("1", emptyMap.getIfAbsentPutWithKey((short) 1, toString));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "0", (short) 1, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.removeKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1"), emptyMap);
        Assert.assertEquals("0", emptyMap.getIfAbsentPutWithKey((short) 0, toString));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "0", (short) 1, "1"), emptyMap);
        MutableShortObjectMap<String> emptyMap1 = ShortObjectHashMap.newMap();
        Assert.assertEquals("1", emptyMap1.getIfAbsentPutWithKey((short) 1, toString));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "1"), emptyMap1);
    }

    @Test
    public void updateValue() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableShortObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue((short) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue((short) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValue((short) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2, (short) 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValue((short) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map1);
        MutableShortObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue((short) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue((short) 1, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValue((short) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 1, (short) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValue((short) 0, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map2);
        MutableShortObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValue((short) 33, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValue((short) 33, zeroFactory, incrementFunction));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 33, 2), map3);
    }

    @Test
    public void updateValueWith() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);
        MutableShortObjectMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith((short) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith((short) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2), map1);
        Assert.assertEquals(Integer.valueOf(1), map1.updateValueWith((short) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2, (short) 1, 1), map1);
        Assert.assertEquals(Integer.valueOf(2), map1.updateValueWith((short) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map1);
        MutableShortObjectMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith((short) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 1), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith((short) 1, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(1), map2.updateValueWith((short) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 1, (short) 1, 2), map2);
        Assert.assertEquals(Integer.valueOf(2), map2.updateValueWith((short) 0, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map2);
        MutableShortObjectMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(Integer.valueOf(1), map3.updateValueWith((short) 33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 33, 1), map3);
        Assert.assertEquals(Integer.valueOf(2), map3.updateValueWith((short) 33, zeroFactory, incrementFunction, 1));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 33, 2), map3);
    }

    @Test
    public void freeze() {
        MutableShortObjectMap<String> mutableShortObjectMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortObjectMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortObjectMap.put((short) i, "!");
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }
        ShortSet frozenSetForRemove = mutableShortObjectMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortObjectMap.keySet().freeze());
        for (int i = 0; i < 32; i++) {
            mutableShortObjectMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }
        MutableShortObjectMap<String> mutableShortObjectMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortObjectMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortObjectMapForClear.keySet().toArray());
        mutableShortObjectMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey() {
        MutableShortObjectMap<String> actual = this.map.withoutKey((short) 55);
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"), actual);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 31, "thirtyOne", (short) 32, "thirtyTwo"), this.map.withoutKey((short) 0));
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 32, "thirtyTwo"), this.map.withoutKey((short) 31));
        Assert.assertEquals(ShortObjectHashMap.newMap(), this.map.withoutKey((short) 32));
        Assert.assertEquals(ShortObjectHashMap.newMap(), this.map.withoutKey((short) 1));
    }

    @Test
    public void withoutAllKeys() {
        MutableShortObjectMap<String> actual = this.map.withoutAllKeys(ShortArrayList.newListWith((short) 55, (short) 1));
        Assert.assertSame(this.map, actual);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"), actual);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 32, "thirtyTwo"), this.map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 31)));
        Assert.assertEquals(ShortObjectHashMap.newMap(), this.map.withoutAllKeys(ShortArrayList.newListWith((short) 31, (short) 32)));
        Assert.assertEquals(ShortObjectHashMap.newMap(), this.map.withoutAllKeys(ShortArrayList.newListWith((short) 1)));
    }

    @Test
    public void withAllKeyValues() {
        MutableShortObjectMap<String> emptyMap = this.getEmptyMap();
        MutableShortObjectMap<String> partialMap = this.newWithKeysValues((short) 1, "one", (short) 3, "three");
        MutableShortObjectMap<String> completeMap = this.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three");
        Iterable<ShortObjectPair<String>> emptyIterable = Iterables.iList();
        Iterable<ShortObjectPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, "one"), PrimitiveTuples.pair((short) 3, "three"));
        Iterable<ShortObjectPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair((short) 1, "one"), PrimitiveTuples.pair((short) 2, "two"), PrimitiveTuples.pair((short) 3, "three"));
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
        Assert.assertEquals("zero", this.map.put((short) 0, "one"));
        Assert.assertEquals("one", this.map.get((short) 0));
        Assert.assertNull(this.map.put((short) 5, "five"));
        Assert.assertEquals("five", this.map.get((short) 5));
        Assert.assertNull(this.map.put((short) 35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.get((short) 35));
        Assert.assertNull(this.map.put((short) 6, null));
        Assert.assertNull(this.map.get((short) 6));
        Assert.assertNull(this.map.put((short) 36, null));
        Assert.assertNull(this.map.get((short) 36));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        Function0<String> ifAbsent = () -> "ifAbsent";
        Assert.assertEquals("zero", this.map.put((short) 0, "one"));
        Assert.assertEquals("one", this.map.getIfAbsent((short) 0, ifAbsent));
        Assert.assertNull(this.map.put((short) 5, "five"));
        Assert.assertEquals("five", this.map.getIfAbsent((short) 5, ifAbsent));
        Assert.assertNull(this.map.put((short) 35, "thirtyFive"));
        Assert.assertEquals("thirtyFive", this.map.getIfAbsent((short) 35, ifAbsent));
        Assert.assertNull(this.map.put((short) 6, null));
        Assert.assertNull(this.map.getIfAbsent((short) 6, ifAbsent));
        Assert.assertNull(this.map.put((short) 36, null));
        Assert.assertNull(this.map.getIfAbsent((short) 36, ifAbsent));
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        Assert.assertEquals("zero", this.map.removeKey((short) 0));
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertEquals("thirtyOne", this.map.removeKey((short) 31));
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertEquals("thirtyTwo", this.map.removeKey((short) 32));
        Assert.assertFalse(this.map.containsKey((short) 32));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        Assert.assertNull(this.map.put((short) 5, null));
        Assert.assertTrue(this.map.containsValue(null));
        Assert.assertNull(this.map.removeKey((short) 5));
        Assert.assertNull(this.map.put((short) 35, null));
        Assert.assertTrue(this.map.containsValue(null));
    }

    @Override
    @Test
    public void size() {
        super.size();
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue((short) 0, "zero").size());
        Assert.assertEquals(1, this.getEmptyMap().withKeyValue((short) 1, "one").size());
        MutableShortObjectMap<String> hashMap1 = this.newWithKeysValues((short) 1, "one", (short) 0, "zero");
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());
        MutableShortObjectMap<String> hashMap = this.newWithKeysValues((short) 6, "six", (short) 5, "five");
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    @Override
    @Test
    public void contains() {
        super.contains();
        Assert.assertNull(this.map.put((short) 1, null));
        Assert.assertTrue(this.map.contains(null));
        Assert.assertNull(this.map.removeKey((short) 5));
        Assert.assertNull(this.map.put((short) 35, null));
        Assert.assertTrue(this.map.contains(null));
    }

    @Test
    public void withKeysValues() {
        MutableShortObjectMap<String> emptyMap = this.getEmptyMap();
        MutableShortObjectMap<String> hashMap = emptyMap.withKeyValue((short) 1, "one");
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableShortObjectMap<String> map1 = this.newWithKeysValues((short) 0, "zero", (short) 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), ShortObjectHashMap.newWithKeysValues((short) 0, "zero").equals(map1) || ShortObjectHashMap.newWithKeysValues((short) 1, "one").equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(ShortObjectHashMap.newMap(), map1);
        Assert.assertThrows(IllegalStateException.class, iterator1::remove);
        MutableShortObjectMap<String> map2 = this.newWithKeysValues((short) 0, "zero", (short) 9, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), ShortObjectHashMap.newWithKeysValues((short) 0, "zero").equals(map2) || ShortObjectHashMap.newWithKeysValues((short) 9, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(ShortObjectHashMap.newMap(), map2);
        MutableShortObjectMap<String> map3 = this.newWithKeysValues((short) 8, "eight", (short) 9, "nine");
        Iterator<String> iterator3 = map3.iterator();
        Assert.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), ShortObjectHashMap.newWithKeysValues((short) 8, "eight").equals(map3) || ShortObjectHashMap.newWithKeysValues((short) 9, "nine").equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(ShortObjectHashMap.newMap(), map3);
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableShortObjectMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortObjectMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedShortObjectMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedShortObjectMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableShortObjectMap<String> map = this.newWithKeysValues((short) 1, "2", (short) 2, "3");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 1, "3", (short) 2), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, "1", (short) 2, "1").flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableShortObjectMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableShortObjectMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableShortObjectMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableShortObjectMapTestCase::keySet;
            this.payloads.values = AbstractMutableShortObjectMapTestCase::values;
            this.payloads.select = AbstractMutableShortObjectMapTestCase::select;
            this.payloads.selectWith = AbstractMutableShortObjectMapTestCase::selectWith;
            this.payloads.selectWith_withTarget = AbstractMutableShortObjectMapTestCase::selectWith_withTarget;
            this.payloads.selectInstancesOf = AbstractMutableShortObjectMapTestCase::selectInstancesOf;
            this.payloads.collect = AbstractMutableShortObjectMapTestCase::collect;
            this.payloads.collectBoolean = AbstractMutableShortObjectMapTestCase::collectBoolean;
            this.payloads.collectBoolean_withTarget = AbstractMutableShortObjectMapTestCase::collectBoolean_withTarget;
            this.payloads.collectByte = AbstractMutableShortObjectMapTestCase::collectByte;
            this.payloads.collectByte_withTarget = AbstractMutableShortObjectMapTestCase::collectByte_withTarget;
            this.payloads.collectChar = AbstractMutableShortObjectMapTestCase::collectChar;
            this.payloads.collectChar_withTarget = AbstractMutableShortObjectMapTestCase::collectChar_withTarget;
            this.payloads.collectDouble = AbstractMutableShortObjectMapTestCase::collectDouble;
            this.payloads.collectDouble_withTarget = AbstractMutableShortObjectMapTestCase::collectDouble_withTarget;
            this.payloads.collectFloat = AbstractMutableShortObjectMapTestCase::collectFloat;
            this.payloads.collectFloat_withTarget = AbstractMutableShortObjectMapTestCase::collectFloat_withTarget;
            this.payloads.collectInt = AbstractMutableShortObjectMapTestCase::collectInt;
            this.payloads.collectInt_withTarget = AbstractMutableShortObjectMapTestCase::collectInt_withTarget;
            this.payloads.collectLong = AbstractMutableShortObjectMapTestCase::collectLong;
            this.payloads.collectLong_withTarget = AbstractMutableShortObjectMapTestCase::collectLong_withTarget;
            this.payloads.collectShort = AbstractMutableShortObjectMapTestCase::collectShort;
            this.payloads.collectShort_withTarget = AbstractMutableShortObjectMapTestCase::collectShort_withTarget;
            this.payloads.collectWith = AbstractMutableShortObjectMapTestCase::collectWith;
            this.payloads.collectWithTarget = AbstractMutableShortObjectMapTestCase::collectWithTarget;
            this.payloads.collectIf = AbstractMutableShortObjectMapTestCase::collectIf;
            this.payloads.flatCollect = AbstractMutableShortObjectMapTestCase::flatCollect;
            this.payloads.detect = AbstractMutableShortObjectMapTestCase::detect;
            this.payloads.detectWith = AbstractMutableShortObjectMapTestCase::detectWith;
            this.payloads.detectOptional = AbstractMutableShortObjectMapTestCase::detectOptional;
            this.payloads.detectWithOptional = AbstractMutableShortObjectMapTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractMutableShortObjectMapTestCase::detectIfNone;
            this.payloads.detectWithIfNone = AbstractMutableShortObjectMapTestCase::detectWithIfNone;
            this.payloads.count = AbstractMutableShortObjectMapTestCase::count;
            this.payloads.countWith = AbstractMutableShortObjectMapTestCase::countWith;
            this.payloads.anySatisfy = AbstractMutableShortObjectMapTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableShortObjectMapTestCase::anySatisfyWith;
            this.payloads.allSatisfy = AbstractMutableShortObjectMapTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableShortObjectMapTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableShortObjectMapTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableShortObjectMapTestCase::noneSatisfyWith;
            this.payloads.injectInto = AbstractMutableShortObjectMapTestCase::injectInto;
            this.payloads.intInjectInto = AbstractMutableShortObjectMapTestCase::intInjectInto;
            this.payloads.longInjectInto = AbstractMutableShortObjectMapTestCase::longInjectInto;
            this.payloads.floatInjectInto = AbstractMutableShortObjectMapTestCase::floatInjectInto;
            this.payloads.doubleInjectInto = AbstractMutableShortObjectMapTestCase::doubleInjectInto;
            this.payloads.toList = AbstractMutableShortObjectMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableShortObjectMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableShortObjectMapTestCase::toSet;
            this.payloads.toSortedSet = AbstractMutableShortObjectMapTestCase::toSortedSet;
            this.payloads.toBag = AbstractMutableShortObjectMapTestCase::toBag;
            this.payloads.toMap = AbstractMutableShortObjectMapTestCase::toMap;
            this.payloads.toMapTarget = AbstractMutableShortObjectMapTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractMutableShortObjectMapTestCase::toSortedMap;
            this.payloads.toImmutableList = AbstractMutableShortObjectMapTestCase::toImmutableList;
            this.payloads.toImmutableSortedList = AbstractMutableShortObjectMapTestCase::toImmutableSortedList;
            this.payloads.toImmutableSet = AbstractMutableShortObjectMapTestCase::toImmutableSet;
            this.payloads.toImmutableSortedSet = AbstractMutableShortObjectMapTestCase::toImmutableSortedSet;
            this.payloads.toImmutableBag = AbstractMutableShortObjectMapTestCase::toImmutableBag;
            this.payloads.toImmutableSortedBag = AbstractMutableShortObjectMapTestCase::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = AbstractMutableShortObjectMapTestCase::toImmutableSortedBagBy;
            this.payloads.toArray = AbstractMutableShortObjectMapTestCase::toArray;
            this.payloads.min = AbstractMutableShortObjectMapTestCase::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = AbstractMutableShortObjectMapTestCase::maxBy;
            this.payloads.max = AbstractMutableShortObjectMapTestCase::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = AbstractMutableShortObjectMapTestCase::minBy;
            this.payloads.sumOfInt = AbstractMutableShortObjectMapTestCase::sumOfInt;
            this.payloads.sumOfLong = AbstractMutableShortObjectMapTestCase::sumOfLong;
            this.payloads.sumOfDouble = AbstractMutableShortObjectMapTestCase::sumOfDouble;
            this.payloads.sumOfFloat = AbstractMutableShortObjectMapTestCase::sumOfFloat;
            this.payloads.sumByInt = AbstractMutableShortObjectMapTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableShortObjectMapTestCase::sumByFloat;
            this.payloads.sumByLong = AbstractMutableShortObjectMapTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableShortObjectMapTestCase::sumByDouble;
            this.payloads.keysView = AbstractMutableShortObjectMapTestCase::keysView;
            this.payloads.reject = AbstractMutableShortObjectMapTestCase::reject;
            this.payloads.rejectWith = AbstractMutableShortObjectMapTestCase::rejectWith;
            this.payloads.rejectWith_withTarget = AbstractMutableShortObjectMapTestCase::rejectWith_withTarget;
            this.payloads.partition = AbstractMutableShortObjectMapTestCase::partition;
            this.payloads.partitionWith = AbstractMutableShortObjectMapTestCase::partitionWith;
            this.payloads.forEachValue = AbstractMutableShortObjectMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableShortObjectMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableShortObjectMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableShortObjectMapTestCase::injectIntoKeyValue;
            this.payloads.isEmpty = AbstractMutableShortObjectMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableShortObjectMapTestCase::notEmpty;
            this.payloads.getFirst = AbstractMutableShortObjectMapTestCase::getFirst;
            this.payloads.getLast = AbstractMutableShortObjectMapTestCase::getLast;
            this.payloads.getOnly = AbstractMutableShortObjectMapTestCase::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = AbstractMutableShortObjectMapTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractMutableShortObjectMapTestCase::containsAll;
            this.payloads.containsAnyIterable = AbstractMutableShortObjectMapTestCase::containsAnyIterable;
            this.payloads.containsAny = AbstractMutableShortObjectMapTestCase::containsAny;
            this.payloads.containsNoneIterable = AbstractMutableShortObjectMapTestCase::containsNoneIterable;
            this.payloads.containsNone = AbstractMutableShortObjectMapTestCase::containsNone;
            this.payloads.containsAllArguments = AbstractMutableShortObjectMapTestCase::containsAllArguments;
            this.payloads.testEquals = AbstractMutableShortObjectMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableShortObjectMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableShortObjectMapTestCase::testToString;
            this.payloads.zip = AbstractMutableShortObjectMapTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableShortObjectMapTestCase::zipWithIndex;
            this.payloads.chunk = AbstractMutableShortObjectMapTestCase::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = AbstractMutableShortObjectMapTestCase::aggregateInPlaceBy;
            this.payloads.aggregateBy = AbstractMutableShortObjectMapTestCase::aggregateBy;
            this.payloads.groupBy = AbstractMutableShortObjectMapTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableShortObjectMapTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractMutableShortObjectMapTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableShortObjectMapTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableShortObjectMapTestCase::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = AbstractMutableShortObjectMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableShortObjectMapTestCase::appendString;
            this.payloads.tap = AbstractMutableShortObjectMapTestCase::tap;
            this.payloads.forEach = AbstractMutableShortObjectMapTestCase::forEach;
            this.payloads.forEachWithIndex = AbstractMutableShortObjectMapTestCase::forEachWithIndex;
            this.payloads.forEachWith = AbstractMutableShortObjectMapTestCase::forEachWith;
            this.payloads.toImmutable = AbstractMutableShortObjectMapTestCase::toImmutable;
            this.payloads.toSortedBag = AbstractMutableShortObjectMapTestCase::toSortedBag;
            this.payloads.toSortedBagBy = AbstractMutableShortObjectMapTestCase::toSortedBagBy;
            this.payloads.stream = AbstractMutableShortObjectMapTestCase::stream;
            this.payloads.parallelStream = AbstractMutableShortObjectMapTestCase::parallelStream;
            this.payloads.clear = AbstractMutableShortObjectMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableShortObjectMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableShortObjectMapTestCase::remove;
            this.payloads.put = AbstractMutableShortObjectMapTestCase::put;
            this.payloads.putPair = AbstractMutableShortObjectMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableShortObjectMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.putAll = AbstractMutableShortObjectMapTestCase::putAll;
            this.payloads.getIfAbsentPut_Value = AbstractMutableShortObjectMapTestCase::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = AbstractMutableShortObjectMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableShortObjectMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableShortObjectMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableShortObjectMapTestCase::updateValue;
            this.payloads.updateValueWith = AbstractMutableShortObjectMapTestCase::updateValueWith;
            this.payloads.freeze = AbstractMutableShortObjectMapTestCase::freeze;
            this.payloads.withoutKey = AbstractMutableShortObjectMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableShortObjectMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableShortObjectMapTestCase::withAllKeyValues;
            this.payloads.get = AbstractMutableShortObjectMapTestCase::get;
            this.payloads.getIfAbsent = AbstractMutableShortObjectMapTestCase::getIfAbsent;
            this.payloads.containsKey = AbstractMutableShortObjectMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableShortObjectMapTestCase::containsValue;
            this.payloads.size = AbstractMutableShortObjectMapTestCase::size;
            this.payloads.contains = AbstractMutableShortObjectMapTestCase::contains;
            this.payloads.withKeysValues = AbstractMutableShortObjectMapTestCase::withKeysValues;
            this.payloads.iterator = AbstractMutableShortObjectMapTestCase::iterator;
            this.payloads.asUnmodifiable = AbstractMutableShortObjectMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableShortObjectMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableShortObjectMapTestCase::flipUniqueValues;
        }
    }
}
