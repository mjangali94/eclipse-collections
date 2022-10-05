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

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectIntMapTestCase extends AbstractObjectIntMapTestCase {

    private final MutableObjectIntMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectIntMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectIntMap<T> newWithKeysValues(T key1, int value1);

    @Override
    protected abstract <T> MutableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2);

    @Override
    protected abstract <T> MutableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3);

    @Override
    protected abstract <T> MutableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4);

    @Override
    protected abstract <T> MutableObjectIntMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectIntHashMap<String> hashMap = new ObjectIntHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", 0);
        hashMap.clear();
        Assert.assertEquals(ObjectIntHashMap.newMap(), hashMap);
        hashMap.put("1", 0);
        hashMap.clear();
        Assert.assertEquals(ObjectIntHashMap.newMap(), hashMap);
        hashMap.put(null, 0);
        hashMap.clear();
        Assert.assertEquals(ObjectIntHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectIntMap<String> map0 = this.newWithKeysValues("0", 0, "1", 1);
        map0.removeKey("1");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("0", 0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectIntHashMap.newMap(), map0);
        MutableObjectIntMap<String> map1 = this.newWithKeysValues("0", 0, "1", 1);
        map1.removeKey("0");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectIntHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1, "2", 2), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 2), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectIntHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectIntHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0), 1);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals(2, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, 3);
        Assert.assertEquals(3, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals(0, this.map.get(null));
    }

    @Test
    public void remove() {
        MutableObjectIntMap<String> map0 = this.newWithKeysValues("0", 0, "1", 1);
        map0.remove("1");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("0", 0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectIntHashMap.newMap(), map0);
        MutableObjectIntMap<String> map1 = this.newWithKeysValues("0", 0, "1", 1);
        map1.remove("0");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectIntHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1, "2", 2), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("1", 1, "2", 2), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 2), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectIntHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectIntHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0), 1);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals(2, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0, this.map.get(generateCollisions().get(1)));
        this.map.put(null, 3);
        Assert.assertEquals(3, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals(0, this.map.get(null));
    }

    @Test
    public void put() {
        this.map.put("0", 1);
        this.map.put("1", 2);
        this.map.put("2", 3);
        ObjectIntHashMap<String> expected = ObjectIntHashMap.newWithKeysValues("0", 1, "1", 2, "2", 3);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", 6);
        expected.put("5", 6);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, 7);
        expected.put(null, 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectIntMap<String> map1 = this.newWithKeysValues("0", 11, "1", 12, "2", 13);
        map1.updateValues((k, v) -> v);
        MutableObjectIntMap<String> expected1 = this.newWithKeysValues("0", 11, "1", 12, "2", 13);
        Assert.assertEquals(expected1, map1);
        MutableObjectIntMap<String> map2 = this.newWithKeysValues("0", 11, "1", 12, "2", 13);
        map2.updateValues((k, v) -> v + 1);
        MutableObjectIntMap<String> expected2 = this.newWithKeysValues("0", 12, "1", 13, "2", 14);
        Assert.assertEquals(expected2, map2);
        MutableObjectIntMap<String> map3 = this.newWithKeysValues("0", 11, "1", 12, "2", 13);
        map3.updateValues((k, v) -> k.equals("0") ? 10 : v);
        MutableObjectIntMap<String> expected3 = this.newWithKeysValues("0", 10, "1", 12, "2", 13);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", 1));
        this.map.putPair(PrimitiveTuples.pair("1", 2));
        this.map.putPair(PrimitiveTuples.pair("2", 3));
        ObjectIntHashMap<String> expected = ObjectIntHashMap.newWithKeysValues("0", 1, "1", 2, "2", 3);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", 6));
        expected.put("5", 6);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, 7));
        expected.put(null, 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectIntMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectIntMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectIntMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectIntMapTestCase.generateCollisions().get(3);
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);
        MutableObjectIntMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);
        MutableObjectIntMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
        MutableObjectIntMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, 1);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 1), hashMap3);
        hashMap3.put(null, 2);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 2), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals(0, this.map.get("5"));
        this.map.put("0", 1);
        Assert.assertEquals(1, this.map.get("0"));
        this.map.put("5", 5);
        Assert.assertEquals(5, this.map.get("5"));
        this.map.put(null, 6);
        Assert.assertEquals(6, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", 1);
        Assert.assertEquals(1, this.map.getOrThrow("0"));
        this.map.put("5", 5);
        Assert.assertEquals(5, this.map.getOrThrow("5"));
        this.map.put(null, 6);
        Assert.assertEquals(6, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals(1, this.map.getIfAbsent("0", 1));
        Assert.assertEquals(5, this.map.getIfAbsent("0", 5));
        this.map.put("0", 1);
        Assert.assertEquals(1, this.map.getIfAbsent("0", 5));
        this.map.put("5", 5);
        Assert.assertEquals(5, this.map.getIfAbsent("5", 0));
        this.map.put(null, 6);
        Assert.assertEquals(6, this.map.getIfAbsent(null, 5));
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(50, map1.getIfAbsentPut(0, 50));
        Assert.assertEquals(50, map1.getIfAbsentPut(0, 100));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 50), map1);
        Assert.assertEquals(50, map1.getIfAbsentPut(1, 50));
        Assert.assertEquals(50, map1.getIfAbsentPut(1, 100));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 50, 1, 50), map1);
        MutableObjectIntMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(50, map2.getIfAbsentPut(1, 50));
        Assert.assertEquals(50, map2.getIfAbsentPut(1, 100));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 50), map2);
        Assert.assertEquals(50, map2.getIfAbsentPut(0, 50));
        Assert.assertEquals(50, map2.getIfAbsentPut(0, 100));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 50, 1, 50), map2);
        MutableObjectIntMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(50, map3.getIfAbsentPut(null, 50));
        Assert.assertEquals(50, map3.getIfAbsentPut(null, 100));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 50), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(20, map1.getAndPut(Integer.valueOf(5), 100, 20));
        Assert.assertEquals(100, map1.get(Integer.valueOf(5)));
        Assert.assertEquals(100, map1.getAndPut(Integer.valueOf(5), 70, 50));
        Assert.assertEquals(70, map1.get(Integer.valueOf(5)));
        Assert.assertEquals(70, map1.getAndPut(Integer.valueOf(5), 77, 50));
        Assert.assertEquals(77, map1.get(Integer.valueOf(5)));
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals(20, map1.getAndPut(Integer.valueOf(5), 100, 20));
        Assert.assertEquals(100, map1.get(Integer.valueOf(5)));
    }

    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(100, map1.getIfAbsentPut(0, factory));
        IntFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals(100, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 100), map1);
        Assert.assertEquals(100, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 100, 1, 100), map1);
        MutableObjectIntMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(100, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 100), map2);
        Assert.assertEquals(100, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 100, 1, 100), map2);
        MutableObjectIntMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(100, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals(100, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 100), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> string.length();
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        IntFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 9, 1, 9), map1);
        MutableObjectIntMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 9, 1, 9), map2);
        MutableObjectIntMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 9), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        IntFunction<Integer> function = (Integer anObject) -> anObject == null ? 32 : anObject.intValue();
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(0, map1.getIfAbsentPutWithKey(0, function));
        IntFunction<Integer> functionThrows = (Integer intParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(0, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 0), map1);
        Assert.assertEquals(1, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 0, 1, 1), map1);
        MutableObjectIntMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 1), map2);
        Assert.assertEquals(0, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 0, 1, 1), map2);
        MutableObjectIntMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(32, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals(32, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 32), map3);
    }

    @Test
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1, map1.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 1), map1);
        Assert.assertEquals(2, map1.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 2), map1);
        Assert.assertEquals(1, map1.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 2, 1, 1), map1);
        Assert.assertEquals(2, map1.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 2, 1, 2), map1);
        MutableObjectIntMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1, map2.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 1), map2);
        Assert.assertEquals(2, map2.updateValue(1, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 2), map2);
        Assert.assertEquals(1, map2.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 1, 1, 2), map2);
        Assert.assertEquals(2, map2.updateValue(0, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 2, 1, 2), map2);
        MutableObjectIntMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(1, map3.updateValue(null, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 1), map3);
        Assert.assertEquals(2, map3.updateValue(null, 0, incrementFunction));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 2), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1, map1.addToValue(0, 1));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 1), map1);
        Assert.assertEquals(5, map1.addToValue(0, 4));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 5), map1);
        Assert.assertEquals(2, map1.addToValue(1, 2));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 5, 1, 2), map1);
        Assert.assertEquals(10, map1.addToValue(1, 8));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 5, 1, 10), map1);
        MutableObjectIntMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1, map2.addToValue(null, 1));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 1), map2);
        Assert.assertEquals(5, map2.addToValue(null, 4));
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(null, 5), map2);
        MutableObjectIntMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            int v = each + index;
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v));
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0, this.map.get("0"));
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals(0, this.map.get("1"));
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals(0, this.map.get("2"));
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals(0, this.map.get("3"));
        this.map.put(null, 5);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", 5);
        Assert.assertTrue(this.map.containsValue(5));
        this.map.put(null, 6);
        Assert.assertTrue(this.map.containsValue(6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue(0));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectIntMap<Integer> hashMap1 = this.newWithKeysValues(1, 1, 0, 0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectIntMap<Integer> hashMap = this.newWithKeysValues(6, 6, 5, 5);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectIntMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectIntMap<Integer> hashMap = emptyMap.withKeyValue(1, 1);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 1), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectIntMap<Integer> map = this.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3);
        MutableObjectIntMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(0, 0, 1, 1, 2, 2), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectIntMap<Integer> map = this.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3);
        MutableObjectIntMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues(1, 1, 2, 2), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectIntMap<String> emptyMap = this.getEmptyMap();
        MutableObjectIntMap<String> partialMap = this.newWithKeysValues("one", 1, "three", 3);
        MutableObjectIntMap<String> completeMap = this.newWithKeysValues("one", 1, "two", 2, "three", 3);
        Iterable<ObjectIntPair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectIntPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("three", 3));
        Iterable<ObjectIntPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3));
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
        this.map.put("5", 5);
        Assert.assertTrue(this.map.contains(5));
        this.map.put(null, 6);
        Assert.assertTrue(this.map.contains(6));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains(0));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectIntMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectIntMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectIntMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectIntMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectIntMap<String> map = this.newWithKeysValues("1", 2, "2", 3);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(2, "1", 3, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1, "2", 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends org.eclipse.collections.impl.map.primitive.AbstractObjectIntMapTestCase._Benchmark {

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
        public abstract AbstractMutableObjectIntMapTestCase implementation();
    }
}
