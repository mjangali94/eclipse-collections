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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.api.tuple.primitive.ObjectFloatPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectFloatMapTestCase extends AbstractObjectFloatMapTestCase {

    private final MutableObjectFloatMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectFloatMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectFloatMap<T> newWithKeysValues(T key1, float value1);

    @Override
    protected abstract <T> MutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2);

    @Override
    protected abstract <T> MutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3);

    @Override
    protected abstract <T> MutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4);

    @Override
    protected abstract <T> MutableObjectFloatMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectFloatHashMap<String> hashMap = new ObjectFloatHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", 0.0f);
        hashMap.clear();
        Assert.assertEquals(ObjectFloatHashMap.newMap(), hashMap);
        hashMap.put("1", 0.0f);
        hashMap.clear();
        Assert.assertEquals(ObjectFloatHashMap.newMap(), hashMap);
        hashMap.put(null, 0.0f);
        hashMap.clear();
        Assert.assertEquals(ObjectFloatHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectFloatMap<String> map0 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        map0.removeKey("1");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("0", 0.0f), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), map0);
        MutableObjectFloatMap<String> map1 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        map1.removeKey("0");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 2.0f), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0), 1.0f);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, this.map.get(generateCollisions().get(0)), 0.0f);
        this.map.removeKey(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, this.map.get(generateCollisions().get(0)), 0.0f);
        Assert.assertEquals(2.0f, this.map.get(generateCollisions().get(1)), 0.0f);
        this.map.removeKey(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0f, this.map.get(generateCollisions().get(1)), 0.0f);
        this.map.put(null, 3.0f);
        Assert.assertEquals(3.0f, this.map.get(null), 0.0f);
        this.map.removeKey(null);
        Assert.assertEquals(0.0f, this.map.get(null), 0.0f);
    }

    @Test
    public void remove() {
        MutableObjectFloatMap<String> map0 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        map0.remove("1");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("0", 0.0f), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), map0);
        MutableObjectFloatMap<String> map1 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        map1.remove("0");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "2", 2.0f), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 2.0f), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectFloatHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0), 1.0f);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, this.map.get(generateCollisions().get(0)), 0.0f);
        this.map.remove(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, this.map.get(generateCollisions().get(0)), 0.0f);
        Assert.assertEquals(2.0f, this.map.get(generateCollisions().get(1)), 0.0f);
        this.map.remove(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0f, this.map.get(generateCollisions().get(1)), 0.0f);
        this.map.put(null, 3.0f);
        Assert.assertEquals(3.0f, this.map.get(null), 0.0f);
        this.map.remove(null);
        Assert.assertEquals(0.0f, this.map.get(null), 0.0f);
    }

    @Test
    public void put() {
        this.map.put("0", 1.0f);
        this.map.put("1", 2.0f);
        this.map.put("2", 3.0f);
        ObjectFloatHashMap<String> expected = ObjectFloatHashMap.newWithKeysValues("0", 1.0f, "1", 2.0f, "2", 3.0f);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", 6.0f);
        expected.put("5", 6.0f);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, 7.0f);
        expected.put(null, 7.0f);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectFloatMap<String> map1 = this.newWithKeysValues("0", 11.0f, "1", 12.0f, "2", 13.0f);
        map1.updateValues((k, v) -> v);
        MutableObjectFloatMap<String> expected1 = this.newWithKeysValues("0", 11.0f, "1", 12.0f, "2", 13.0f);
        Assert.assertEquals(expected1, map1);
        MutableObjectFloatMap<String> map2 = this.newWithKeysValues("0", 11.0f, "1", 12.0f, "2", 13.0f);
        map2.updateValues((k, v) -> v + 1.0f);
        MutableObjectFloatMap<String> expected2 = this.newWithKeysValues("0", 12.0f, "1", 13.0f, "2", 14.0f);
        Assert.assertEquals(expected2, map2);
        MutableObjectFloatMap<String> map3 = this.newWithKeysValues("0", 11.0f, "1", 12.0f, "2", 13.0f);
        map3.updateValues((k, v) -> k.equals("0") ? 10.0f : v);
        MutableObjectFloatMap<String> expected3 = this.newWithKeysValues("0", 10.0f, "1", 12.0f, "2", 13.0f);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", 1.0f));
        this.map.putPair(PrimitiveTuples.pair("1", 2.0f));
        this.map.putPair(PrimitiveTuples.pair("2", 3.0f));
        ObjectFloatHashMap<String> expected = ObjectFloatHashMap.newWithKeysValues("0", 1.0f, "1", 2.0f, "2", 3.0f);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", 6.0f));
        expected.put("5", 6.0f);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, 7.0f));
        expected.put(null, 7.0f);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectFloatMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectFloatMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectFloatMapTestCase.generateCollisions().get(3);
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0f, hashMap.get(collision2), 0.0f);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);
        MutableObjectFloatMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0f, hashMap1.get(collision1), 0.0f);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);
        MutableObjectFloatMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0f, hashMap2.get(collision3), 0.0f);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
        MutableObjectFloatMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, 1.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 1.0f), hashMap3);
        hashMap3.put(null, 2.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 2.0f), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals(0.0f, this.map.get("5"), 0.0f);
        this.map.put("0", 1.0f);
        Assert.assertEquals(1.0f, this.map.get("0"), 0.0f);
        this.map.put("5", 5.0f);
        Assert.assertEquals(5.0f, this.map.get("5"), 0.0f);
        this.map.put(null, 6.0f);
        Assert.assertEquals(6.0f, this.map.get(null), 0.0f);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", 1.0f);
        Assert.assertEquals(1.0f, this.map.getOrThrow("0"), 0.0f);
        this.map.put("5", 5.0f);
        Assert.assertEquals(5.0f, this.map.getOrThrow("5"), 0.0f);
        this.map.put(null, 6.0f);
        Assert.assertEquals(6.0f, this.map.getOrThrow(null), 0.0f);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals(1.0f, this.map.getIfAbsent("0", 1.0f), 0.0f);
        Assert.assertEquals(5.0f, this.map.getIfAbsent("0", 5.0f), 0.0f);
        this.map.put("0", 1.0f);
        Assert.assertEquals(1.0f, this.map.getIfAbsent("0", 5.0f), 0.0f);
        this.map.put("5", 5.0f);
        Assert.assertEquals(5.0f, this.map.getIfAbsent("5", 0.0f), 0.0f);
        this.map.put(null, 6.0f);
        Assert.assertEquals(6.0f, this.map.getIfAbsent(null, 5.0f), 0.0f);
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(50.0f, map1.getIfAbsentPut(0, 50.0f), 0.0f);
        Assert.assertEquals(50.0f, map1.getIfAbsentPut(0, 100.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 50.0f), map1);
        Assert.assertEquals(50.0f, map1.getIfAbsentPut(1, 50.0f), 0.0f);
        Assert.assertEquals(50.0f, map1.getIfAbsentPut(1, 100.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 50.0f, 1, 50.0f), map1);
        MutableObjectFloatMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(50.0f, map2.getIfAbsentPut(1, 50.0f), 0.0f);
        Assert.assertEquals(50.0f, map2.getIfAbsentPut(1, 100.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 50.0f), map2);
        Assert.assertEquals(50.0f, map2.getIfAbsentPut(0, 50.0f), 0.0f);
        Assert.assertEquals(50.0f, map2.getIfAbsentPut(0, 100.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 50.0f, 1, 50.0f), map2);
        MutableObjectFloatMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(50.0f, map3.getIfAbsentPut(null, 50.0f), 0.0f);
        Assert.assertEquals(50.0f, map3.getIfAbsentPut(null, 100.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 50.0f), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(20.0f, map1.getAndPut(Integer.valueOf(5), 100.0f, 20.0f), 0.0f);
        Assert.assertEquals(100.0f, map1.get(Integer.valueOf(5)), 0.0f);
        Assert.assertEquals(100.0f, map1.getAndPut(Integer.valueOf(5), 70.0f, 50.0f), 0.0f);
        Assert.assertEquals(70.0f, map1.get(Integer.valueOf(5)), 0.0f);
        Assert.assertEquals(70.0f, map1.getAndPut(Integer.valueOf(5), 77.0f, 50.0f), 0.0f);
        Assert.assertEquals(77.0f, map1.get(Integer.valueOf(5)), 0.0f);
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals(20.0f, map1.getAndPut(Integer.valueOf(5), 100.0f, 20.0f), 0.0f);
        Assert.assertEquals(100.0f, map1.get(Integer.valueOf(5)), 0.0f);
    }

    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(100.0f, map1.getIfAbsentPut(0, factory), 0.0f);
        FloatFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals(100.0f, map1.getIfAbsentPut(0, factoryThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 100.0f), map1);
        Assert.assertEquals(100.0f, map1.getIfAbsentPut(1, factory), 0.0f);
        Assert.assertEquals(100.0f, map1.getIfAbsentPut(1, factoryThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 100.0f, 1, 100.0f), map1);
        MutableObjectFloatMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(100.0f, map2.getIfAbsentPut(1, factory), 0.0f);
        Assert.assertEquals(100.0f, map2.getIfAbsentPut(1, factoryThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 100.0f), map2);
        Assert.assertEquals(100.0f, map2.getIfAbsentPut(0, factory), 0.0f);
        Assert.assertEquals(100.0f, map2.getIfAbsentPut(0, factoryThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 100.0f, 1, 100.0f), map2);
        MutableObjectFloatMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(100.0f, map3.getIfAbsentPut(null, factory), 0.0f);
        Assert.assertEquals(100.0f, map3.getIfAbsentPut(null, factoryThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 100.0f), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> string.length();
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0f);
        FloatFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0f);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 9.0f, 1, 9.0f), map1);
        MutableObjectFloatMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0f);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0f);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 9.0f, 1, 9.0f), map2);
        MutableObjectFloatMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(null, functionLength, "123456789"), 0.0f);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(null, functionThrows, "unused"), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 9.0f), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        FloatFunction<Integer> function = (Integer anObject) -> anObject == null ? 32.0f : anObject.intValue();
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(0.0f, map1.getIfAbsentPutWithKey(0, function), 0.0f);
        FloatFunction<Integer> functionThrows = (Integer floatParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(0.0f, map1.getIfAbsentPutWithKey(0, functionThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 0.0f), map1);
        Assert.assertEquals(1.0f, map1.getIfAbsentPutWithKey(1, function), 0.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsentPutWithKey(1, functionThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 0.0f, 1, 1.0f), map1);
        MutableObjectFloatMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0f, map2.getIfAbsentPutWithKey(1, function), 0.0f);
        Assert.assertEquals(1.0f, map2.getIfAbsentPutWithKey(1, functionThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 1.0f), map2);
        Assert.assertEquals(0.0f, map2.getIfAbsentPutWithKey(0, function), 0.0f);
        Assert.assertEquals(0.0f, map2.getIfAbsentPutWithKey(0, functionThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 0.0f, 1, 1.0f), map2);
        MutableObjectFloatMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(32.0f, map3.getIfAbsentPutWithKey(null, function), 0.0f);
        Assert.assertEquals(32.0f, map3.getIfAbsentPutWithKey(null, functionThrows), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 32.0f), map3);
    }

    @Test
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1;
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1.0f, map1.updateValue(0, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 1.0f), map1);
        Assert.assertEquals(2.0f, map1.updateValue(0, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 2.0f), map1);
        Assert.assertEquals(1.0f, map1.updateValue(1, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 2.0f, 1, 1.0f), map1);
        Assert.assertEquals(2.0f, map1.updateValue(1, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 2.0f, 1, 2.0f), map1);
        MutableObjectFloatMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0f, map2.updateValue(1, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 1.0f), map2);
        Assert.assertEquals(2.0f, map2.updateValue(1, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 2.0f), map2);
        Assert.assertEquals(1.0f, map2.updateValue(0, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 1.0f, 1, 2.0f), map2);
        Assert.assertEquals(2.0f, map2.updateValue(0, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 2.0f, 1, 2.0f), map2);
        MutableObjectFloatMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(1.0f, map3.updateValue(null, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 1.0f), map3);
        Assert.assertEquals(2.0f, map3.updateValue(null, 0.0f, incrementFunction), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 2.0f), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1.0f, map1.addToValue(0, 1.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 1.0f), map1);
        Assert.assertEquals(5.0f, map1.addToValue(0, 4.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 5.0f), map1);
        Assert.assertEquals(2.0f, map1.addToValue(1, 2.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 5.0f, 1, 2.0f), map1);
        Assert.assertEquals(10.0f, map1.addToValue(1, 8.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 5.0f, 1, 10.0f), map1);
        MutableObjectFloatMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0f, map2.addToValue(null, 1.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 1.0f), map2);
        Assert.assertEquals(5.0f, map2.addToValue(null, 4.0f), 0.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(null, 5.0f), map2);
        MutableObjectFloatMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            float v = each + index;
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v), 0.0f);
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0.0f, this.map.get("0"), 0.0f);
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0.0f, this.map.get("0"), 0.0f);
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals(0.0f, this.map.get("1"), 0.0f);
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals(0.0f, this.map.get("2"), 0.0f);
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals(0.0f, this.map.get("3"), 0.0f);
        this.map.put(null, 5.0f);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", 5.0f);
        Assert.assertTrue(this.map.containsValue(5.0f));
        this.map.put(null, 6.0f);
        Assert.assertTrue(this.map.containsValue(6.0f));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue(0.0f));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectFloatMap<Integer> hashMap1 = this.newWithKeysValues(1, 1.0f, 0, 0.0f);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectFloatMap<Integer> hashMap = this.newWithKeysValues(6, 6.0f, 5, 5.0f);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectFloatMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectFloatMap<Integer> hashMap = emptyMap.withKeyValue(1, 1.0f);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 1.0f), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectFloatMap<Integer> map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        MutableObjectFloatMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectFloatMap<Integer> map = this.newWithKeysValues(0, 0.0f, 1, 1.0f, 2, 2.0f, 3, 3.0f);
        MutableObjectFloatMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues(1, 1.0f, 2, 2.0f), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectFloatMap<String> emptyMap = this.getEmptyMap();
        MutableObjectFloatMap<String> partialMap = this.newWithKeysValues("one", 1.0f, "three", 3.0f);
        MutableObjectFloatMap<String> completeMap = this.newWithKeysValues("one", 1.0f, "two", 2.0f, "three", 3.0f);
        Iterable<ObjectFloatPair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectFloatPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", 1.0f), PrimitiveTuples.pair("three", 3.0f));
        Iterable<ObjectFloatPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", 1.0f), PrimitiveTuples.pair("two", 2.0f), PrimitiveTuples.pair("three", 3.0f));
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
        this.map.put("5", 5.0f);
        Assert.assertTrue(this.map.contains(5.0f));
        this.map.put(null, 6.0f);
        Assert.assertTrue(this.map.contains(6.0f));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains(0.0f));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectFloatMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectFloatMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectFloatMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectFloatMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectFloatMap<String> map = this.newWithKeysValues("1", 2.0f, "2", 3.0f);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(2.0f, "1", 3.0f, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1.0f, "2", 1.0f).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectFloatMapTestCase instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectFloatMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectFloatMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectFloatMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectFloatMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectFloatMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectFloatMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectFloatMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectFloatMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectFloatMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectFloatMapTestCase::testToString;
            this.payloads.floatIterator = AbstractMutableObjectFloatMapTestCase::floatIterator;
            this.payloads.forEach = AbstractMutableObjectFloatMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectFloatMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectFloatMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectFloatMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectFloatMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectFloatMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectFloatMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectFloatMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectFloatMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectFloatMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectFloatMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectFloatMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectFloatMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectFloatMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectFloatMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectFloatMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectFloatMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectFloatMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectFloatMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectFloatMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectFloatMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectFloatMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectFloatMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectFloatMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectFloatMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectFloatMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectFloatMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectFloatMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectFloatMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectFloatMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectFloatMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectFloatMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectFloatMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectFloatMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectFloatMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectFloatMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectFloatMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectFloatMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectFloatMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectFloatMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectFloatMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectFloatMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectFloatMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectFloatMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectFloatMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectFloatMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectFloatMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectFloatMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectFloatMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectFloatMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectFloatMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectFloatMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectFloatMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectFloatMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectFloatMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectFloatMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectFloatMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectFloatMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectFloatMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectFloatMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectFloatMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectFloatMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectFloatMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectFloatMapTestCase::flipUniqueValues;
        }
    }
}
