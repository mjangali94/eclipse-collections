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

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.api.tuple.primitive.ObjectBytePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectByteMapTestCase extends AbstractObjectByteMapTestCase {

    private final MutableObjectByteMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectByteMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectByteMap<T> newWithKeysValues(T key1, byte value1);

    @Override
    protected abstract <T> MutableObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2);

    @Override
    protected abstract <T> MutableObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3);

    @Override
    protected abstract <T> MutableObjectByteMap<T> newWithKeysValues(T key1, byte value1, T key2, byte value2, T key3, byte value3, T key4, byte value4);

    @Override
    protected abstract <T> MutableObjectByteMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectByteHashMap<String> hashMap = new ObjectByteHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", (byte) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectByteHashMap.newMap(), hashMap);
        hashMap.put("1", (byte) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectByteHashMap.newMap(), hashMap);
        hashMap.put(null, (byte) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectByteHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectByteMap<String> map0 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        map0.removeKey("1");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("0", (byte) 0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectByteHashMap.newMap(), map0);
        MutableObjectByteMap<String> map1 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        map1.removeKey("0");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectByteHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 2), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectByteHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectByteHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0), (byte) 1);
        this.map.put(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals((byte) 2, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((byte) 0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, (byte) 3);
        Assert.assertEquals((byte) 3, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals((byte) 0, this.map.get(null));
    }

    @Test
    public void remove() {
        MutableObjectByteMap<String> map0 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        map0.remove("1");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("0", (byte) 0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectByteHashMap.newMap(), map0);
        MutableObjectByteMap<String> map1 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        map1.remove("0");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectByteHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("1", (byte) 1, "2", (byte) 2), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 2), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectByteHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectByteHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0), (byte) 1);
        this.map.put(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals((byte) 2, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((byte) 0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, (byte) 3);
        Assert.assertEquals((byte) 3, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals((byte) 0, this.map.get(null));
    }

    @Test
    public void put() {
        this.map.put("0", (byte) 1);
        this.map.put("1", (byte) 2);
        this.map.put("2", (byte) 3);
        ObjectByteHashMap<String> expected = ObjectByteHashMap.newWithKeysValues("0", (byte) 1, "1", (byte) 2, "2", (byte) 3);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", (byte) 6);
        expected.put("5", (byte) 6);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, (byte) 7);
        expected.put(null, (byte) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectByteMap<String> map1 = this.newWithKeysValues("0", (byte) 11, "1", (byte) 12, "2", (byte) 13);
        map1.updateValues((k, v) -> v);
        MutableObjectByteMap<String> expected1 = this.newWithKeysValues("0", (byte) 11, "1", (byte) 12, "2", (byte) 13);
        Assert.assertEquals(expected1, map1);
        MutableObjectByteMap<String> map2 = this.newWithKeysValues("0", (byte) 11, "1", (byte) 12, "2", (byte) 13);
        map2.updateValues((k, v) -> (byte) (v + (byte) 1));
        MutableObjectByteMap<String> expected2 = this.newWithKeysValues("0", (byte) 12, "1", (byte) 13, "2", (byte) 14);
        Assert.assertEquals(expected2, map2);
        MutableObjectByteMap<String> map3 = this.newWithKeysValues("0", (byte) 11, "1", (byte) 12, "2", (byte) 13);
        map3.updateValues((k, v) -> k.equals("0") ? (byte) 10 : v);
        MutableObjectByteMap<String> expected3 = this.newWithKeysValues("0", (byte) 10, "1", (byte) 12, "2", (byte) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", (byte) 1));
        this.map.putPair(PrimitiveTuples.pair("1", (byte) 2));
        this.map.putPair(PrimitiveTuples.pair("2", (byte) 3));
        ObjectByteHashMap<String> expected = ObjectByteHashMap.newWithKeysValues("0", (byte) 1, "1", (byte) 2, "2", (byte) 3);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", (byte) 6));
        expected.put("5", (byte) 6);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, (byte) 7));
        expected.put(null, (byte) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectByteMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectByteMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectByteMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectByteMapTestCase.generateCollisions().get(3);
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals((byte) 2, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);
        MutableObjectByteMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals((byte) 1, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);
        MutableObjectByteMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals((byte) 3, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
        MutableObjectByteMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, (byte) 1);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 1), hashMap3);
        hashMap3.put(null, (byte) 2);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 2), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals((byte) 0, this.map.get("5"));
        this.map.put("0", (byte) 1);
        Assert.assertEquals((byte) 1, this.map.get("0"));
        this.map.put("5", (byte) 5);
        Assert.assertEquals((byte) 5, this.map.get("5"));
        this.map.put(null, (byte) 6);
        Assert.assertEquals((byte) 6, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", (byte) 1);
        Assert.assertEquals((byte) 1, this.map.getOrThrow("0"));
        this.map.put("5", (byte) 5);
        Assert.assertEquals((byte) 5, this.map.getOrThrow("5"));
        this.map.put(null, (byte) 6);
        Assert.assertEquals((byte) 6, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals((byte) 1, this.map.getIfAbsent("0", (byte) 1));
        Assert.assertEquals((byte) 5, this.map.getIfAbsent("0", (byte) 5));
        this.map.put("0", (byte) 1);
        Assert.assertEquals((byte) 1, this.map.getIfAbsent("0", (byte) 5));
        this.map.put("5", (byte) 5);
        Assert.assertEquals((byte) 5, this.map.getIfAbsent("5", (byte) 0));
        this.map.put(null, (byte) 6);
        Assert.assertEquals((byte) 6, this.map.getIfAbsent(null, (byte) 5));
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 50, map1.getIfAbsentPut(0, (byte) 50));
        Assert.assertEquals((byte) 50, map1.getIfAbsentPut(0, (byte) 100));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 50), map1);
        Assert.assertEquals((byte) 50, map1.getIfAbsentPut(1, (byte) 50));
        Assert.assertEquals((byte) 50, map1.getIfAbsentPut(1, (byte) 100));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 50, 1, (byte) 50), map1);
        MutableObjectByteMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 50, map2.getIfAbsentPut(1, (byte) 50));
        Assert.assertEquals((byte) 50, map2.getIfAbsentPut(1, (byte) 100));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 50), map2);
        Assert.assertEquals((byte) 50, map2.getIfAbsentPut(0, (byte) 50));
        Assert.assertEquals((byte) 50, map2.getIfAbsentPut(0, (byte) 100));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 50, 1, (byte) 50), map2);
        MutableObjectByteMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 50, map3.getIfAbsentPut(null, (byte) 50));
        Assert.assertEquals((byte) 50, map3.getIfAbsentPut(null, (byte) 100));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 50), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 20, map1.getAndPut(Integer.valueOf(5), (byte) 100, (byte) 20));
        Assert.assertEquals((byte) 100, map1.get(Integer.valueOf(5)));
        Assert.assertEquals((byte) 100, map1.getAndPut(Integer.valueOf(5), (byte) 70, (byte) 50));
        Assert.assertEquals((byte) 70, map1.get(Integer.valueOf(5)));
        Assert.assertEquals((byte) 70, map1.getAndPut(Integer.valueOf(5), (byte) 77, (byte) 50));
        Assert.assertEquals((byte) 77, map1.get(Integer.valueOf(5)));
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals((byte) 20, map1.getAndPut(Integer.valueOf(5), (byte) 100, (byte) 20));
        Assert.assertEquals((byte) 100, map1.get(Integer.valueOf(5)));
    }

    @Test
    public void getIfAbsentPut_Function() {
        ByteFunction0 factory = () -> (byte) 100;
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 100, map1.getIfAbsentPut(0, factory));
        ByteFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals((byte) 100, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 100), map1);
        Assert.assertEquals((byte) 100, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals((byte) 100, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 100, 1, (byte) 100), map1);
        MutableObjectByteMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 100, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals((byte) 100, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 100), map2);
        Assert.assertEquals((byte) 100, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals((byte) 100, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 100, 1, (byte) 100), map2);
        MutableObjectByteMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 100, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals((byte) 100, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 100), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        ByteFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 9, 1, (byte) 9), map1);
        MutableObjectByteMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 9, 1, (byte) 9), map2);
        MutableObjectByteMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 9), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ByteFunction<Integer> function = (Integer anObject) -> anObject == null ? (byte) 32 : (byte) anObject.intValue();
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 0, map1.getIfAbsentPutWithKey(0, function));
        ByteFunction<Integer> functionThrows = (Integer byteParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals((byte) 0, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 0), map1);
        Assert.assertEquals((byte) 1, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((byte) 1, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1), map1);
        MutableObjectByteMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 1, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((byte) 1, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 1), map2);
        Assert.assertEquals((byte) 0, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals((byte) 0, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1), map2);
        MutableObjectByteMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 32, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals((byte) 32, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 32), map3);
    }

    @Test
    public void updateValue() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + 1);
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 1, map1.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 1), map1);
        Assert.assertEquals((byte) 2, map1.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 2), map1);
        Assert.assertEquals((byte) 1, map1.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 1), map1);
        Assert.assertEquals((byte) 2, map1.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 2), map1);
        MutableObjectByteMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 1, map2.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 1), map2);
        Assert.assertEquals((byte) 2, map2.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 2), map2);
        Assert.assertEquals((byte) 1, map2.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 1, 1, (byte) 2), map2);
        Assert.assertEquals((byte) 2, map2.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 2), map2);
        MutableObjectByteMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 1, map3.updateValue(null, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 1), map3);
        Assert.assertEquals((byte) 2, map3.updateValue(null, (byte) 0, incrementFunction));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 2), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectByteMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 1, map1.addToValue(0, (byte) 1));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 1), map1);
        Assert.assertEquals((byte) 5, map1.addToValue(0, (byte) 4));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 5), map1);
        Assert.assertEquals((byte) 2, map1.addToValue(1, (byte) 2));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 5, 1, (byte) 2), map1);
        Assert.assertEquals((byte) 10, map1.addToValue(1, (byte) 8));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 5, 1, (byte) 10), map1);
        MutableObjectByteMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 1, map2.addToValue(null, (byte) 1));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 1), map2);
        Assert.assertEquals((byte) 5, map2.addToValue(null, (byte) 4));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(null, (byte) 5), map2);
        MutableObjectByteMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v));
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((byte) 0, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((byte) 0, this.map.get("0"));
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals((byte) 0, this.map.get("1"));
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals((byte) 0, this.map.get("2"));
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals((byte) 0, this.map.get("3"));
        this.map.put(null, (byte) 5);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", (byte) 5);
        Assert.assertTrue(this.map.containsValue((byte) 5));
        this.map.put(null, (byte) 6);
        Assert.assertTrue(this.map.containsValue((byte) 6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue((byte) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectByteMap<Integer> hashMap1 = this.newWithKeysValues(1, (byte) 1, 0, (byte) 0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectByteMap<Integer> hashMap = this.newWithKeysValues(6, (byte) 6, 5, (byte) 5);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectByteMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectByteMap<Integer> hashMap = emptyMap.withKeyValue(1, (byte) 1);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 1), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectByteMap<Integer> map = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 2, (byte) 2, 3, (byte) 3);
        MutableObjectByteMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 2, (byte) 2), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectByteMap<Integer> map = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 2, (byte) 2, 3, (byte) 3);
        MutableObjectByteMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectByteMap<String> emptyMap = this.getEmptyMap();
        MutableObjectByteMap<String> partialMap = this.newWithKeysValues("one", (byte) 1, "three", (byte) 3);
        MutableObjectByteMap<String> completeMap = this.newWithKeysValues("one", (byte) 1, "two", (byte) 2, "three", (byte) 3);
        Iterable<ObjectBytePair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectBytePair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", (byte) 1), PrimitiveTuples.pair("three", (byte) 3));
        Iterable<ObjectBytePair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", (byte) 1), PrimitiveTuples.pair("two", (byte) 2), PrimitiveTuples.pair("three", (byte) 3));
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
        this.map.put("5", (byte) 5);
        Assert.assertTrue(this.map.contains((byte) 5));
        this.map.put(null, (byte) 6);
        Assert.assertTrue(this.map.contains((byte) 6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains((byte) 0));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectByteMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectByteMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectByteMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectByteMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectByteMap<String> map = this.newWithKeysValues("1", (byte) 2, "2", (byte) 3);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 2, "1", (byte) 3, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", (byte) 1, "2", (byte) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectByteMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
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
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectByteMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectByteMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectByteMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectByteMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectByteMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectByteMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectByteMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectByteMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectByteMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectByteMapTestCase::testToString;
            this.payloads.byteIterator = AbstractMutableObjectByteMapTestCase::byteIterator;
            this.payloads.forEach = AbstractMutableObjectByteMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectByteMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectByteMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectByteMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectByteMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectByteMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectByteMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectByteMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectByteMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectByteMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectByteMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectByteMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectByteMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectByteMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectByteMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectByteMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectByteMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectByteMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectByteMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectByteMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectByteMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectByteMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectByteMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectByteMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectByteMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectByteMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectByteMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectByteMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectByteMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectByteMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectByteMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectByteMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectByteMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectByteMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectByteMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectByteMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectByteMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectByteMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectByteMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectByteMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectByteMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectByteMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectByteMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectByteMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectByteMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectByteMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectByteMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectByteMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectByteMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectByteMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectByteMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectByteMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectByteMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectByteMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectByteMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectByteMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectByteMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectByteMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectByteMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectByteMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectByteMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectByteMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectByteMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectByteMapTestCase::flipUniqueValues;
        }
    }
}
