/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.tuple.primitive.ObjectCharPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectCharMapTestCase extends AbstractObjectCharMapTestCase {

    private final MutableObjectCharMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectCharMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1);

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2);

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3);

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4);

    @Override
    protected abstract <T> MutableObjectCharMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectCharHashMap<String> hashMap = new ObjectCharHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", (char) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectCharHashMap.newMap(), hashMap);
        hashMap.put("1", (char) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectCharHashMap.newMap(), hashMap);
        hashMap.put(null, (char) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectCharHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectCharMap<String> map0 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map0.removeKey("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map0);
        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map1.removeKey("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 2), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 1);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals((char) 2, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, (char) 3);
        Assert.assertEquals((char) 3, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals((char) 0, this.map.get(null));
    }

    @Test
    public void remove() {
        MutableObjectCharMap<String> map0 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map0.remove("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map0);
        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map1.remove("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 2), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 1);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals((char) 2, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, (char) 3);
        Assert.assertEquals((char) 3, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals((char) 0, this.map.get(null));
    }

    @Test
    public void put() {
        this.map.put("0", (char) 1);
        this.map.put("1", (char) 2);
        this.map.put("2", (char) 3);
        ObjectCharHashMap<String> expected = ObjectCharHashMap.newWithKeysValues("0", (char) 1, "1", (char) 2, "2", (char) 3);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", (char) 6);
        expected.put("5", (char) 6);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, (char) 7);
        expected.put(null, (char) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 11, "1", (char) 12, "2", (char) 13);
        map1.updateValues((k, v) -> v);
        MutableObjectCharMap<String> expected1 = this.newWithKeysValues("0", (char) 11, "1", (char) 12, "2", (char) 13);
        Assert.assertEquals(expected1, map1);
        MutableObjectCharMap<String> map2 = this.newWithKeysValues("0", (char) 11, "1", (char) 12, "2", (char) 13);
        map2.updateValues((k, v) -> (char) (v + (char) 1));
        MutableObjectCharMap<String> expected2 = this.newWithKeysValues("0", (char) 12, "1", (char) 13, "2", (char) 14);
        Assert.assertEquals(expected2, map2);
        MutableObjectCharMap<String> map3 = this.newWithKeysValues("0", (char) 11, "1", (char) 12, "2", (char) 13);
        map3.updateValues((k, v) -> k.equals("0") ? (char) 10 : v);
        MutableObjectCharMap<String> expected3 = this.newWithKeysValues("0", (char) 10, "1", (char) 12, "2", (char) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", (char) 1));
        this.map.putPair(PrimitiveTuples.pair("1", (char) 2));
        this.map.putPair(PrimitiveTuples.pair("2", (char) 3));
        ObjectCharHashMap<String> expected = ObjectCharHashMap.newWithKeysValues("0", (char) 1, "1", (char) 2, "2", (char) 3);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", (char) 6));
        expected.put("5", (char) 6);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, (char) 7));
        expected.put(null, (char) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectCharMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectCharMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectCharMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectCharMapTestCase.generateCollisions().get(3);
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals((char) 2, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);
        MutableObjectCharMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals((char) 1, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);
        MutableObjectCharMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals((char) 3, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
        MutableObjectCharMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, (char) 1);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 1), hashMap3);
        hashMap3.put(null, (char) 2);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 2), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals((char) 0, this.map.get("5"));
        this.map.put("0", (char) 1);
        Assert.assertEquals((char) 1, this.map.get("0"));
        this.map.put("5", (char) 5);
        Assert.assertEquals((char) 5, this.map.get("5"));
        this.map.put(null, (char) 6);
        Assert.assertEquals((char) 6, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", (char) 1);
        Assert.assertEquals((char) 1, this.map.getOrThrow("0"));
        this.map.put("5", (char) 5);
        Assert.assertEquals((char) 5, this.map.getOrThrow("5"));
        this.map.put(null, (char) 6);
        Assert.assertEquals((char) 6, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals((char) 1, this.map.getIfAbsent("0", (char) 1));
        Assert.assertEquals((char) 5, this.map.getIfAbsent("0", (char) 5));
        this.map.put("0", (char) 1);
        Assert.assertEquals((char) 1, this.map.getIfAbsent("0", (char) 5));
        this.map.put("5", (char) 5);
        Assert.assertEquals((char) 5, this.map.getIfAbsent("5", (char) 0));
        this.map.put(null, (char) 6);
        Assert.assertEquals((char) 6, this.map.getIfAbsent(null, (char) 5));
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(0, (char) 50));
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(0, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 50), map1);
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(1, (char) 50));
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(1, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 50, 1, (char) 50), map1);
        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(1, (char) 50));
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(1, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 50), map2);
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(0, (char) 50));
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(0, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 50, 1, (char) 50), map2);
        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 50, map3.getIfAbsentPut(null, (char) 50));
        Assert.assertEquals((char) 50, map3.getIfAbsentPut(null, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 50), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 20, map1.getAndPut(Integer.valueOf(5), (char) 100, (char) 20));
        Assert.assertEquals((char) 100, map1.get(Integer.valueOf(5)));
        Assert.assertEquals((char) 100, map1.getAndPut(Integer.valueOf(5), (char) 70, (char) 50));
        Assert.assertEquals((char) 70, map1.get(Integer.valueOf(5)));
        Assert.assertEquals((char) 70, map1.getAndPut(Integer.valueOf(5), (char) 77, (char) 50));
        Assert.assertEquals((char) 77, map1.get(Integer.valueOf(5)));
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals((char) 20, map1.getAndPut(Integer.valueOf(5), (char) 100, (char) 20));
        Assert.assertEquals((char) 100, map1.get(Integer.valueOf(5)));
    }

    @Test
    public void getIfAbsentPut_Function() {
        CharFunction0 factory = () -> (char) 100;
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(0, factory));
        CharFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 100), map1);
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 100, 1, (char) 100), map1);
        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 100), map2);
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 100, 1, (char) 100), map2);
        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 100, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals((char) 100, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 100), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        CharFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 9, 1, (char) 9), map1);
        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 9, 1, (char) 9), map2);
        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 9), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        CharFunction<Integer> function = (Integer anObject) -> anObject == null ? (char) 32 : (char) anObject.intValue();
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 0, map1.getIfAbsentPutWithKey(0, function));
        CharFunction<Integer> functionThrows = (Integer charParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals((char) 0, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0), map1);
        Assert.assertEquals((char) 1, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((char) 1, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0, 1, (char) 1), map1);
        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((char) 1, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1), map2);
        Assert.assertEquals((char) 0, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals((char) 0, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0, 1, (char) 1), map2);
        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 32, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals((char) 32, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 32), map3);
    }

    @Test
    public void updateValue() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + 1);
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map1.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 1), map1);
        Assert.assertEquals((char) 2, map1.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2), map1);
        Assert.assertEquals((char) 1, map1.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2, 1, (char) 1), map1);
        Assert.assertEquals((char) 2, map1.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2, 1, (char) 2), map1);
        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map2.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1), map2);
        Assert.assertEquals((char) 2, map2.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 2), map2);
        Assert.assertEquals((char) 1, map2.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 1, 1, (char) 2), map2);
        Assert.assertEquals((char) 2, map2.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2, 1, (char) 2), map2);
        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map3.updateValue(null, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 1), map3);
        Assert.assertEquals((char) 2, map3.updateValue(null, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 2), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map1.addToValue(0, (char) 1));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 1), map1);
        Assert.assertEquals((char) 5, map1.addToValue(0, (char) 4));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 5), map1);
        Assert.assertEquals((char) 2, map1.addToValue(1, (char) 2));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 5, 1, (char) 2), map1);
        Assert.assertEquals((char) 10, map1.addToValue(1, (char) 8));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 5, 1, (char) 10), map1);
        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map2.addToValue(null, (char) 1));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 1), map2);
        Assert.assertEquals((char) 5, map2.addToValue(null, (char) 4));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 5), map2);
        MutableObjectCharMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v));
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((char) 0, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((char) 0, this.map.get("0"));
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals((char) 0, this.map.get("1"));
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals((char) 0, this.map.get("2"));
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals((char) 0, this.map.get("3"));
        this.map.put(null, (char) 5);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", (char) 5);
        Assert.assertTrue(this.map.containsValue((char) 5));
        this.map.put(null, (char) 6);
        Assert.assertTrue(this.map.containsValue((char) 6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue((char) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectCharMap<Integer> hashMap1 = this.newWithKeysValues(1, (char) 1, 0, (char) 0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectCharMap<Integer> hashMap = this.newWithKeysValues(6, (char) 6, 5, (char) 5);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectCharMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectCharMap<Integer> hashMap = emptyMap.withKeyValue(1, (char) 1);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectCharMap<Integer> map = this.newWithKeysValues(0, (char) 0, 1, (char) 1, 2, (char) 2, 3, (char) 3);
        MutableObjectCharMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0, 1, (char) 1, 2, (char) 2), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectCharMap<Integer> map = this.newWithKeysValues(0, (char) 0, 1, (char) 1, 2, (char) 2, 3, (char) 3);
        MutableObjectCharMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1, 2, (char) 2), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectCharMap<String> emptyMap = this.getEmptyMap();
        MutableObjectCharMap<String> partialMap = this.newWithKeysValues("one", (char) 1, "three", (char) 3);
        MutableObjectCharMap<String> completeMap = this.newWithKeysValues("one", (char) 1, "two", (char) 2, "three", (char) 3);
        Iterable<ObjectCharPair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectCharPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", (char) 1), PrimitiveTuples.pair("three", (char) 3));
        Iterable<ObjectCharPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", (char) 1), PrimitiveTuples.pair("two", (char) 2), PrimitiveTuples.pair("three", (char) 3));
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
    public void contains() {
        super.contains();
        this.map.put("5", (char) 5);
        Assert.assertTrue(this.map.contains((char) 5));
        this.map.put(null, (char) 6);
        Assert.assertTrue(this.map.contains((char) 6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains((char) 0));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectCharMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectCharMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectCharMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectCharMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectCharMap<String> map = this.newWithKeysValues("1", (char) 2, "2", (char) 3);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 2, "1", (char) 3, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", (char) 1, "2", (char) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectCharMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
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
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectCharMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectCharMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectCharMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectCharMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectCharMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectCharMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectCharMapTestCase::testToString;
            this.payloads.charIterator = AbstractMutableObjectCharMapTestCase::charIterator;
            this.payloads.forEach = AbstractMutableObjectCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectCharMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectCharMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectCharMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectCharMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectCharMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectCharMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectCharMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectCharMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectCharMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectCharMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectCharMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectCharMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectCharMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectCharMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectCharMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectCharMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectCharMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectCharMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectCharMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectCharMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectCharMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectCharMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectCharMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectCharMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectCharMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectCharMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectCharMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectCharMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectCharMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectCharMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectCharMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectCharMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectCharMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectCharMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectCharMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectCharMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectCharMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectCharMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectCharMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectCharMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectCharMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectCharMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectCharMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectCharMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectCharMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectCharMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectCharMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectCharMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectCharMapTestCase::flipUniqueValues;
        }
    }
}
