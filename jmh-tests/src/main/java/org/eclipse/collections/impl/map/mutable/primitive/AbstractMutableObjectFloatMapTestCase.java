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
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectFloatMapTestCase._Benchmark {

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
        public abstract AbstractMutableObjectFloatMapTestCase implementation();
    }
}
