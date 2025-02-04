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

import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.api.tuple.primitive.ObjectDoublePair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectDoubleMapTestCase extends AbstractObjectDoubleMapTestCase {

    private final MutableObjectDoubleMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectDoubleMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3, T key4, double value4);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectDoubleHashMap<String> hashMap = new ObjectDoubleHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", 0.0);
        hashMap.clear();
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), hashMap);
        hashMap.put("1", 0.0);
        hashMap.clear();
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), hashMap);
        hashMap.put(null, 0.0);
        hashMap.clear();
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectDoubleMap<String> map0 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map0.removeKey("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map0);
        MutableObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map1.removeKey("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 2.0), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0), 1.0);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, this.map.get(generateCollisions().get(0)), 0.0);
        this.map.removeKey(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, this.map.get(generateCollisions().get(1)), 0.0);
        this.map.removeKey(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(1)), 0.0);
        this.map.put(null, 3.0);
        Assert.assertEquals(3.0, this.map.get(null), 0.0);
        this.map.removeKey(null);
        Assert.assertEquals(0.0, this.map.get(null), 0.0);
    }

    @Test
    public void remove() {
        MutableObjectDoubleMap<String> map0 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map0.remove("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map0);
        MutableObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map1.remove("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 2.0), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0), 1.0);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, this.map.get(generateCollisions().get(0)), 0.0);
        this.map.remove(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, this.map.get(generateCollisions().get(1)), 0.0);
        this.map.remove(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(1)), 0.0);
        this.map.put(null, 3.0);
        Assert.assertEquals(3.0, this.map.get(null), 0.0);
        this.map.remove(null);
        Assert.assertEquals(0.0, this.map.get(null), 0.0);
    }

    @Test
    public void put() {
        this.map.put("0", 1.0);
        this.map.put("1", 2.0);
        this.map.put("2", 3.0);
        ObjectDoubleHashMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("0", 1.0, "1", 2.0, "2", 3.0);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", 6.0);
        expected.put("5", 6.0);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, 7.0);
        expected.put(null, 7.0);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 11.0, "1", 12.0, "2", 13.0);
        map1.updateValues((k, v) -> v);
        MutableObjectDoubleMap<String> expected1 = this.newWithKeysValues("0", 11.0, "1", 12.0, "2", 13.0);
        Assert.assertEquals(expected1, map1);
        MutableObjectDoubleMap<String> map2 = this.newWithKeysValues("0", 11.0, "1", 12.0, "2", 13.0);
        map2.updateValues((k, v) -> v + 1.0);
        MutableObjectDoubleMap<String> expected2 = this.newWithKeysValues("0", 12.0, "1", 13.0, "2", 14.0);
        Assert.assertEquals(expected2, map2);
        MutableObjectDoubleMap<String> map3 = this.newWithKeysValues("0", 11.0, "1", 12.0, "2", 13.0);
        map3.updateValues((k, v) -> k.equals("0") ? 10.0 : v);
        MutableObjectDoubleMap<String> expected3 = this.newWithKeysValues("0", 10.0, "1", 12.0, "2", 13.0);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", 1.0));
        this.map.putPair(PrimitiveTuples.pair("1", 2.0));
        this.map.putPair(PrimitiveTuples.pair("2", 3.0));
        ObjectDoubleHashMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("0", 1.0, "1", 2.0, "2", 3.0);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", 6.0));
        expected.put("5", 6.0);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, 7.0));
        expected.put(null, 7.0);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(3);
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);
        MutableObjectDoubleMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);
        MutableObjectDoubleMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
        MutableObjectDoubleMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, 1.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 1.0), hashMap3);
        hashMap3.put(null, 2.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 2.0), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals(0.0, this.map.get("5"), 0.0);
        this.map.put("0", 1.0);
        Assert.assertEquals(1.0, this.map.get("0"), 0.0);
        this.map.put("5", 5.0);
        Assert.assertEquals(5.0, this.map.get("5"), 0.0);
        this.map.put(null, 6.0);
        Assert.assertEquals(6.0, this.map.get(null), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", 1.0);
        Assert.assertEquals(1.0, this.map.getOrThrow("0"), 0.0);
        this.map.put("5", 5.0);
        Assert.assertEquals(5.0, this.map.getOrThrow("5"), 0.0);
        this.map.put(null, 6.0);
        Assert.assertEquals(6.0, this.map.getOrThrow(null), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals(1.0, this.map.getIfAbsent("0", 1.0), 0.0);
        Assert.assertEquals(5.0, this.map.getIfAbsent("0", 5.0), 0.0);
        this.map.put("0", 1.0);
        Assert.assertEquals(1.0, this.map.getIfAbsent("0", 5.0), 0.0);
        this.map.put("5", 5.0);
        Assert.assertEquals(5.0, this.map.getIfAbsent("5", 0.0), 0.0);
        this.map.put(null, 6.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent(null, 5.0), 0.0);
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map1);
        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map2);
        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(null, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(null, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 50.0), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(20.0, map1.getAndPut(Integer.valueOf(5), 100.0, 20.0), 0.0);
        Assert.assertEquals(100.0, map1.get(Integer.valueOf(5)), 0.0);
        Assert.assertEquals(100.0, map1.getAndPut(Integer.valueOf(5), 70.0, 50.0), 0.0);
        Assert.assertEquals(70.0, map1.get(Integer.valueOf(5)), 0.0);
        Assert.assertEquals(70.0, map1.getAndPut(Integer.valueOf(5), 77.0, 50.0), 0.0);
        Assert.assertEquals(77.0, map1.get(Integer.valueOf(5)), 0.0);
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals(20.0, map1.getAndPut(Integer.valueOf(5), 100.0, 20.0), 0.0);
        Assert.assertEquals(100.0, map1.get(Integer.valueOf(5)), 0.0);
    }

    @Test
    public void getIfAbsentPut_Function() {
        DoubleFunction0 factory = () -> 100.0;
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factory), 0.0);
        DoubleFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map1);
        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map2);
        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(null, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(null, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 100.0), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        DoubleFunction<String> functionLength = (String string) -> string.length();
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        DoubleFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map1);
        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map2);
        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(null, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(null, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 9.0), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        DoubleFunction<Integer> function = (Integer anObject) -> anObject == null ? 32.0 : anObject.intValue();
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, function), 0.0);
        DoubleFunction<Integer> functionThrows = (Integer doubleParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map1);
        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map2);
        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(null, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(null, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 32.0), map3);
    }

    @Test
    public void updateValue() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1;
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0, 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map1);
        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 1.0, 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map2);
        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(null, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(null, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 2.0), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 1.0), map1);
        Assert.assertEquals(5.0, map1.addToValue(0, 4.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 5.0), map1);
        Assert.assertEquals(2.0, map1.addToValue(1, 2.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 5.0, 1, 2.0), map1);
        Assert.assertEquals(10.0, map1.addToValue(1, 8.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 5.0, 1, 10.0), map1);
        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.addToValue(null, 1.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 1.0), map2);
        Assert.assertEquals(5.0, map2.addToValue(null, 4.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 5.0), map2);
        MutableObjectDoubleMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            double v = each + index;
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v), 0.0);
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0.0, this.map.get("0"), 0.0);
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0.0, this.map.get("0"), 0.0);
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals(0.0, this.map.get("1"), 0.0);
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals(0.0, this.map.get("2"), 0.0);
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals(0.0, this.map.get("3"), 0.0);
        this.map.put(null, 5.0);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", 5.0);
        Assert.assertTrue(this.map.containsValue(5.0));
        this.map.put(null, 6.0);
        Assert.assertTrue(this.map.containsValue(6.0));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue(0.0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectDoubleMap<Integer> hashMap1 = this.newWithKeysValues(1, 1.0, 0, 0.0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectDoubleMap<Integer> hashMap = this.newWithKeysValues(6, 6.0, 5, 5.0);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectDoubleMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectDoubleMap<Integer> hashMap = emptyMap.withKeyValue(1, 1.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectDoubleMap<Integer> map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        MutableObjectDoubleMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectDoubleMap<Integer> map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        MutableObjectDoubleMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectDoubleMap<String> emptyMap = this.getEmptyMap();
        MutableObjectDoubleMap<String> partialMap = this.newWithKeysValues("one", 1.0, "three", 3.0);
        MutableObjectDoubleMap<String> completeMap = this.newWithKeysValues("one", 1.0, "two", 2.0, "three", 3.0);
        Iterable<ObjectDoublePair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectDoublePair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", 1.0), PrimitiveTuples.pair("three", 3.0));
        Iterable<ObjectDoublePair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", 1.0), PrimitiveTuples.pair("two", 2.0), PrimitiveTuples.pair("three", 3.0));
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
        this.map.put("5", 5.0);
        Assert.assertTrue(this.map.contains(5.0));
        this.map.put(null, 6.0);
        Assert.assertTrue(this.map.contains(6.0));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains(0.0));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectDoubleMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectDoubleMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectDoubleMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectDoubleMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectDoubleMap<String> map = this.newWithKeysValues("1", 2.0, "2", 3.0);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(2.0, "1", 3.0, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1.0, "2", 1.0).flipUniqueValues());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectDoubleMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectDoubleMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectDoubleMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectDoubleMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectDoubleMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectDoubleMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectDoubleMapTestCase::testToString;
            this.payloads.doubleIterator = AbstractMutableObjectDoubleMapTestCase::doubleIterator;
            this.payloads.forEach = AbstractMutableObjectDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectDoubleMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectDoubleMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectDoubleMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectDoubleMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectDoubleMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectDoubleMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectDoubleMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectDoubleMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectDoubleMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectDoubleMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectDoubleMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectDoubleMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectDoubleMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectDoubleMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectDoubleMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectDoubleMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectDoubleMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectDoubleMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectDoubleMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectDoubleMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectDoubleMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectDoubleMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectDoubleMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectDoubleMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectDoubleMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectDoubleMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectDoubleMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectDoubleMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectDoubleMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectDoubleMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectDoubleMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectDoubleMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectDoubleMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectDoubleMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectDoubleMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectDoubleMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectDoubleMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectDoubleMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectDoubleMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectDoubleMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectDoubleMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectDoubleMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectDoubleMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectDoubleMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectDoubleMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectDoubleMapTestCase::flipUniqueValues;
        }
    }
*/
}
