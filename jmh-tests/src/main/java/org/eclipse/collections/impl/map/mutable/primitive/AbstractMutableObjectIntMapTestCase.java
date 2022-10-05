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
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectIntMapTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectIntMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectIntMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectIntMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectIntMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectIntMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectIntMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectIntMapTestCase::testToString;
            this.payloads.intIterator = AbstractMutableObjectIntMapTestCase::intIterator;
            this.payloads.forEach = AbstractMutableObjectIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectIntMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectIntMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectIntMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectIntMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectIntMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectIntMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectIntMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectIntMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectIntMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectIntMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectIntMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectIntMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectIntMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectIntMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectIntMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectIntMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectIntMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectIntMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectIntMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectIntMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectIntMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectIntMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectIntMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectIntMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectIntMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectIntMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectIntMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectIntMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectIntMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectIntMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectIntMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectIntMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectIntMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectIntMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectIntMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectIntMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectIntMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectIntMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectIntMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectIntMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectIntMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectIntMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectIntMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectIntMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectIntMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectIntMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectIntMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectIntMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectIntMapTestCase::flipUniqueValues;
        }
    }
}
