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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectShortMapTestCase instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectShortMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectShortMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectShortMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectShortMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectShortMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectShortMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectShortMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectShortMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectShortMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectShortMapTestCase::testToString;
            this.payloads.shortIterator = AbstractMutableObjectShortMapTestCase::shortIterator;
            this.payloads.forEach = AbstractMutableObjectShortMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectShortMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectShortMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectShortMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectShortMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectShortMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectShortMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectShortMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectShortMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectShortMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectShortMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectShortMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectShortMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectShortMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectShortMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectShortMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectShortMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectShortMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectShortMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectShortMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectShortMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectShortMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectShortMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectShortMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectShortMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectShortMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectShortMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectShortMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectShortMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectShortMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectShortMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectShortMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectShortMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectShortMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectShortMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectShortMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectShortMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectShortMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectShortMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectShortMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectShortMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectShortMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectShortMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectShortMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectShortMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectShortMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectShortMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectShortMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectShortMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectShortMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectShortMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectShortMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectShortMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectShortMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectShortMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectShortMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectShortMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectShortMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectShortMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectShortMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectShortMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectShortMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectShortMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectShortMapTestCase::flipUniqueValues;
        }
    }
}
