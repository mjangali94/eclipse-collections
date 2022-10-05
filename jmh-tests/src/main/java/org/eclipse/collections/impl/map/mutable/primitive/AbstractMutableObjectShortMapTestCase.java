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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.tuple.primitive.ObjectShortPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectShortMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectShortMapTestCase extends AbstractObjectShortMapTestCase {

    private final MutableObjectShortMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectShortMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1);

    @Override
    protected abstract <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2);

    @Override
    protected abstract <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3);

    @Override
    protected abstract <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3, T key4, short value4);

    @Override
    protected abstract <T> MutableObjectShortMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectShortHashMap<String> hashMap = new ObjectShortHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectShortMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", (short) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectShortHashMap.newMap(), hashMap);
        hashMap.put("1", (short) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectShortHashMap.newMap(), hashMap);
        hashMap.put(null, (short) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectShortHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectShortMap<String> map0 = this.newWithKeysValues("0", (short) 0, "1", (short) 1);
        map0.removeKey("1");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("0", (short) 0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectShortHashMap.newMap(), map0);
        MutableObjectShortMap<String> map1 = this.newWithKeysValues("0", (short) 0, "1", (short) 1);
        map1.removeKey("0");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectShortHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 2), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectShortHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectShortHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectShortMapTestCase.generateCollisions().get(0), (short) 1);
        this.map.put(AbstractMutableObjectShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals((short) 2, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((short) 0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, (short) 3);
        Assert.assertEquals((short) 3, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals((short) 0, this.map.get(null));
    }

    @Test
    public void remove() {
        MutableObjectShortMap<String> map0 = this.newWithKeysValues("0", (short) 0, "1", (short) 1);
        map0.remove("1");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("0", (short) 0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectShortHashMap.newMap(), map0);
        MutableObjectShortMap<String> map1 = this.newWithKeysValues("0", (short) 0, "1", (short) 1);
        map1.remove("0");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectShortHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("0", (short) 0, "1", (short) 1, "2", (short) 2), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("1", (short) 1, "2", (short) 2), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 2), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectShortHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectShortHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectShortMapTestCase.generateCollisions().get(0), (short) 1);
        this.map.put(AbstractMutableObjectShortMapTestCase.generateCollisions().get(1), (short) 2);
        Assert.assertEquals((short) 1, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals((short) 2, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((short) 0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, (short) 3);
        Assert.assertEquals((short) 3, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals((short) 0, this.map.get(null));
    }

    @Test
    public void put() {
        this.map.put("0", (short) 1);
        this.map.put("1", (short) 2);
        this.map.put("2", (short) 3);
        ObjectShortHashMap<String> expected = ObjectShortHashMap.newWithKeysValues("0", (short) 1, "1", (short) 2, "2", (short) 3);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", (short) 6);
        expected.put("5", (short) 6);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, (short) 7);
        expected.put(null, (short) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectShortMap<String> map1 = this.newWithKeysValues("0", (short) 11, "1", (short) 12, "2", (short) 13);
        map1.updateValues((k, v) -> v);
        MutableObjectShortMap<String> expected1 = this.newWithKeysValues("0", (short) 11, "1", (short) 12, "2", (short) 13);
        Assert.assertEquals(expected1, map1);
        MutableObjectShortMap<String> map2 = this.newWithKeysValues("0", (short) 11, "1", (short) 12, "2", (short) 13);
        map2.updateValues((k, v) -> (short) (v + (short) 1));
        MutableObjectShortMap<String> expected2 = this.newWithKeysValues("0", (short) 12, "1", (short) 13, "2", (short) 14);
        Assert.assertEquals(expected2, map2);
        MutableObjectShortMap<String> map3 = this.newWithKeysValues("0", (short) 11, "1", (short) 12, "2", (short) 13);
        map3.updateValues((k, v) -> k.equals("0") ? (short) 10 : v);
        MutableObjectShortMap<String> expected3 = this.newWithKeysValues("0", (short) 10, "1", (short) 12, "2", (short) 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", (short) 1));
        this.map.putPair(PrimitiveTuples.pair("1", (short) 2));
        this.map.putPair(PrimitiveTuples.pair("2", (short) 3));
        ObjectShortHashMap<String> expected = ObjectShortHashMap.newWithKeysValues("0", (short) 1, "1", (short) 2, "2", (short) 3);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", (short) 6));
        expected.put("5", (short) 6);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, (short) 7));
        expected.put(null, (short) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectShortMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectShortMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectShortMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectShortMapTestCase.generateCollisions().get(3);
        MutableObjectShortMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals((short) 2, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);
        MutableObjectShortMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals((short) 1, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);
        MutableObjectShortMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals((short) 3, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
        MutableObjectShortMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, (short) 1);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 1), hashMap3);
        hashMap3.put(null, (short) 2);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 2), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals((short) 0, this.map.get("5"));
        this.map.put("0", (short) 1);
        Assert.assertEquals((short) 1, this.map.get("0"));
        this.map.put("5", (short) 5);
        Assert.assertEquals((short) 5, this.map.get("5"));
        this.map.put(null, (short) 6);
        Assert.assertEquals((short) 6, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", (short) 1);
        Assert.assertEquals((short) 1, this.map.getOrThrow("0"));
        this.map.put("5", (short) 5);
        Assert.assertEquals((short) 5, this.map.getOrThrow("5"));
        this.map.put(null, (short) 6);
        Assert.assertEquals((short) 6, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals((short) 1, this.map.getIfAbsent("0", (short) 1));
        Assert.assertEquals((short) 5, this.map.getIfAbsent("0", (short) 5));
        this.map.put("0", (short) 1);
        Assert.assertEquals((short) 1, this.map.getIfAbsent("0", (short) 5));
        this.map.put("5", (short) 5);
        Assert.assertEquals((short) 5, this.map.getIfAbsent("5", (short) 0));
        this.map.put(null, (short) 6);
        Assert.assertEquals((short) 6, this.map.getIfAbsent(null, (short) 5));
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 50, map1.getIfAbsentPut(0, (short) 50));
        Assert.assertEquals((short) 50, map1.getIfAbsentPut(0, (short) 100));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 50), map1);
        Assert.assertEquals((short) 50, map1.getIfAbsentPut(1, (short) 50));
        Assert.assertEquals((short) 50, map1.getIfAbsentPut(1, (short) 100));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 50, 1, (short) 50), map1);
        MutableObjectShortMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((short) 50, map2.getIfAbsentPut(1, (short) 50));
        Assert.assertEquals((short) 50, map2.getIfAbsentPut(1, (short) 100));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 50), map2);
        Assert.assertEquals((short) 50, map2.getIfAbsentPut(0, (short) 50));
        Assert.assertEquals((short) 50, map2.getIfAbsentPut(0, (short) 100));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 50, 1, (short) 50), map2);
        MutableObjectShortMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((short) 50, map3.getIfAbsentPut(null, (short) 50));
        Assert.assertEquals((short) 50, map3.getIfAbsentPut(null, (short) 100));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 50), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 20, map1.getAndPut(Integer.valueOf(5), (short) 100, (short) 20));
        Assert.assertEquals((short) 100, map1.get(Integer.valueOf(5)));
        Assert.assertEquals((short) 100, map1.getAndPut(Integer.valueOf(5), (short) 70, (short) 50));
        Assert.assertEquals((short) 70, map1.get(Integer.valueOf(5)));
        Assert.assertEquals((short) 70, map1.getAndPut(Integer.valueOf(5), (short) 77, (short) 50));
        Assert.assertEquals((short) 77, map1.get(Integer.valueOf(5)));
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals((short) 20, map1.getAndPut(Integer.valueOf(5), (short) 100, (short) 20));
        Assert.assertEquals((short) 100, map1.get(Integer.valueOf(5)));
    }

    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 100, map1.getIfAbsentPut(0, factory));
        ShortFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals((short) 100, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 100), map1);
        Assert.assertEquals((short) 100, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals((short) 100, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 100, 1, (short) 100), map1);
        MutableObjectShortMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((short) 100, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals((short) 100, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 100), map2);
        Assert.assertEquals((short) 100, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals((short) 100, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 100, 1, (short) 100), map2);
        MutableObjectShortMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((short) 100, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals((short) 100, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 100), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        ShortFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 9, 1, (short) 9), map1);
        MutableObjectShortMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 9, 1, (short) 9), map2);
        MutableObjectShortMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 9), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        ShortFunction<Integer> function = (Integer anObject) -> anObject == null ? (short) 32 : (short) anObject.intValue();
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 0, map1.getIfAbsentPutWithKey(0, function));
        ShortFunction<Integer> functionThrows = (Integer shortParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals((short) 0, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 0), map1);
        Assert.assertEquals((short) 1, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((short) 1, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 0, 1, (short) 1), map1);
        MutableObjectShortMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((short) 1, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((short) 1, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 1), map2);
        Assert.assertEquals((short) 0, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals((short) 0, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 0, 1, (short) 1), map2);
        MutableObjectShortMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((short) 32, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals((short) 32, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 32), map3);
    }

    @Test
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + 1);
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 1, map1.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 1), map1);
        Assert.assertEquals((short) 2, map1.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 2), map1);
        Assert.assertEquals((short) 1, map1.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 2, 1, (short) 1), map1);
        Assert.assertEquals((short) 2, map1.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 2, 1, (short) 2), map1);
        MutableObjectShortMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((short) 1, map2.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 1), map2);
        Assert.assertEquals((short) 2, map2.updateValue(1, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 2), map2);
        Assert.assertEquals((short) 1, map2.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 1, 1, (short) 2), map2);
        Assert.assertEquals((short) 2, map2.updateValue(0, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 2, 1, (short) 2), map2);
        MutableObjectShortMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((short) 1, map3.updateValue(null, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 1), map3);
        Assert.assertEquals((short) 2, map3.updateValue(null, (short) 0, incrementFunction));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 2), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectShortMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((short) 1, map1.addToValue(0, (short) 1));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 1), map1);
        Assert.assertEquals((short) 5, map1.addToValue(0, (short) 4));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 5), map1);
        Assert.assertEquals((short) 2, map1.addToValue(1, (short) 2));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 5, 1, (short) 2), map1);
        Assert.assertEquals((short) 10, map1.addToValue(1, (short) 8));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 5, 1, (short) 10), map1);
        MutableObjectShortMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((short) 1, map2.addToValue(null, (short) 1));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 1), map2);
        Assert.assertEquals((short) 5, map2.addToValue(null, (short) 4));
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(null, (short) 5), map2);
        MutableObjectShortMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v));
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((short) 0, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((short) 0, this.map.get("0"));
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals((short) 0, this.map.get("1"));
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals((short) 0, this.map.get("2"));
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals((short) 0, this.map.get("3"));
        this.map.put(null, (short) 5);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", (short) 5);
        Assert.assertTrue(this.map.containsValue((short) 5));
        this.map.put(null, (short) 6);
        Assert.assertTrue(this.map.containsValue((short) 6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue((short) 0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectShortMap<Integer> hashMap1 = this.newWithKeysValues(1, (short) 1, 0, (short) 0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectShortMap<Integer> hashMap = this.newWithKeysValues(6, (short) 6, 5, (short) 5);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectShortMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectShortMap<Integer> hashMap = emptyMap.withKeyValue(1, (short) 1);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 1), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectShortMap<Integer> map = this.newWithKeysValues(0, (short) 0, 1, (short) 1, 2, (short) 2, 3, (short) 3);
        MutableObjectShortMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(0, (short) 0, 1, (short) 1, 2, (short) 2), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectShortMap<Integer> map = this.newWithKeysValues(0, (short) 0, 1, (short) 1, 2, (short) 2, 3, (short) 3);
        MutableObjectShortMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectShortMap<String> emptyMap = this.getEmptyMap();
        MutableObjectShortMap<String> partialMap = this.newWithKeysValues("one", (short) 1, "three", (short) 3);
        MutableObjectShortMap<String> completeMap = this.newWithKeysValues("one", (short) 1, "two", (short) 2, "three", (short) 3);
        Iterable<ObjectShortPair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectShortPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", (short) 1), PrimitiveTuples.pair("three", (short) 3));
        Iterable<ObjectShortPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", (short) 1), PrimitiveTuples.pair("two", (short) 2), PrimitiveTuples.pair("three", (short) 3));
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
        this.map.put("5", (short) 5);
        Assert.assertTrue(this.map.contains((short) 5));
        this.map.put(null, (short) 6);
        Assert.assertTrue(this.map.contains((short) 6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains((short) 0));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectShortMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectShortMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectShortMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectShortMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectShortMap<String> map = this.newWithKeysValues("1", (short) 2, "2", (short) 3);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 2, "1", (short) 3, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", (short) 1, "2", (short) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectShortMapTestCase._Benchmark {

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
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValues, this.description("updateValues"));
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
        public void benchmark_get() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::get, this.description("get"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrThrow, this.description("getOrThrow"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_Value, this.description("getIfAbsentPut_Value"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getAndPut, this.description("getAndPut"));
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
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::addToValue, this.description("addToValue"));
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
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::contains, this.description("contains"));
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
        public abstract AbstractMutableObjectShortMapTestCase implementation();
    }
}
