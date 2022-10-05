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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractShortObjectMapTestCase._Benchmark {

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
        public abstract AbstractMutableShortObjectMapTestCase implementation();
    }
}
