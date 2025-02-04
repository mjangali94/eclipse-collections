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

import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.tuple.primitive.ObjectLongPair;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectLongMapTestCase extends AbstractObjectLongMapTestCase {

    private final MutableObjectLongMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectLongMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1);

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2);

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3);

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4);

    @Override
    protected abstract <T> MutableObjectLongMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions() {
        MutableList<String> collisions = FastList.newList();
        ObjectLongHashMap<String> hashMap = new ObjectLongHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++) {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3))) {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear() {
        MutableObjectLongMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", 0L);
        hashMap.clear();
        Assert.assertEquals(ObjectLongHashMap.newMap(), hashMap);
        hashMap.put("1", 0L);
        hashMap.clear();
        Assert.assertEquals(ObjectLongHashMap.newMap(), hashMap);
        hashMap.put(null, 0L);
        hashMap.clear();
        Assert.assertEquals(ObjectLongHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey() {
        MutableObjectLongMap<String> map0 = this.newWithKeysValues("0", 0L, "1", 1L);
        map0.removeKey("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map0);
        MutableObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L);
        map1.removeKey("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map1);
        this.map.removeKey("5");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 2L), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0), 1L);
        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals(2L, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(1)));
        this.map.put(null, 3L);
        Assert.assertEquals(3L, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals(0L, this.map.get(null));
    }

    @Test
    public void remove() {
        MutableObjectLongMap<String> map0 = this.newWithKeysValues("0", 0L, "1", 1L);
        map0.remove("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map0);
        MutableObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L);
        map1.remove("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map1);
        this.map.remove("5");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 2L), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0), 1L);
        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1), 2L);
        Assert.assertEquals(1L, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(0)));
        Assert.assertEquals(2L, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(1)));
        this.map.put(null, 3L);
        Assert.assertEquals(3L, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals(0L, this.map.get(null));
    }

    @Test
    public void put() {
        this.map.put("0", 1L);
        this.map.put("1", 2L);
        this.map.put("2", 3L);
        ObjectLongHashMap<String> expected = ObjectLongHashMap.newWithKeysValues("0", 1L, "1", 2L, "2", 3L);
        Assert.assertEquals(expected, this.map);
        this.map.put("5", 6L);
        expected.put("5", 6L);
        Assert.assertEquals(expected, this.map);
        this.map.put(null, 7L);
        expected.put(null, 7L);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void updateValues() {
        MutableObjectLongMap<String> map1 = this.newWithKeysValues("0", 11L, "1", 12L, "2", 13L);
        map1.updateValues((k, v) -> v);
        MutableObjectLongMap<String> expected1 = this.newWithKeysValues("0", 11L, "1", 12L, "2", 13L);
        Assert.assertEquals(expected1, map1);
        MutableObjectLongMap<String> map2 = this.newWithKeysValues("0", 11L, "1", 12L, "2", 13L);
        map2.updateValues((k, v) -> v + 1L);
        MutableObjectLongMap<String> expected2 = this.newWithKeysValues("0", 12L, "1", 13L, "2", 14L);
        Assert.assertEquals(expected2, map2);
        MutableObjectLongMap<String> map3 = this.newWithKeysValues("0", 11L, "1", 12L, "2", 13L);
        map3.updateValues((k, v) -> k.equals("0") ? 10L : v);
        MutableObjectLongMap<String> expected3 = this.newWithKeysValues("0", 10L, "1", 12L, "2", 13L);
        Assert.assertEquals(expected3, map3);
    }

    @Test
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair("0", 1L));
        this.map.putPair(PrimitiveTuples.pair("1", 2L));
        this.map.putPair(PrimitiveTuples.pair("2", 3L));
        ObjectLongHashMap<String> expected = ObjectLongHashMap.newWithKeysValues("0", 1L, "1", 2L, "2", 3L);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair("5", 6L));
        expected.put("5", 6L);
        Assert.assertEquals(expected, this.map);
        this.map.putPair(PrimitiveTuples.pair(null, 7L));
        expected.put(null, 7L);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot() {
        String collision1 = AbstractMutableObjectLongMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectLongMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectLongMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectLongMapTestCase.generateCollisions().get(3);
        MutableObjectLongMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);
        MutableObjectLongMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);
        MutableObjectLongMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
        MutableObjectLongMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, 1L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 1L), hashMap3);
        hashMap3.put(null, 2L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 2L), hashMap3);
    }

    @Override
    @Test
    public void get() {
        super.get();
        Assert.assertEquals(0L, this.map.get("5"));
        this.map.put("0", 1L);
        Assert.assertEquals(1L, this.map.get("0"));
        this.map.put("5", 5L);
        Assert.assertEquals(5L, this.map.get("5"));
        this.map.put(null, 6L);
        Assert.assertEquals(6L, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow() {
        super.getOrThrow();
        this.map.removeKey("0");
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));
        this.map.put("0", 1L);
        Assert.assertEquals(1L, this.map.getOrThrow("0"));
        this.map.put("5", 5L);
        Assert.assertEquals(5L, this.map.getOrThrow("5"));
        this.map.put(null, 6L);
        Assert.assertEquals(6L, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        this.map.removeKey("0");
        Assert.assertEquals(1L, this.map.getIfAbsent("0", 1L));
        Assert.assertEquals(5L, this.map.getIfAbsent("0", 5L));
        this.map.put("0", 1L);
        Assert.assertEquals(1L, this.map.getIfAbsent("0", 5L));
        this.map.put("5", 5L);
        Assert.assertEquals(5L, this.map.getIfAbsent("5", 0L));
        this.map.put(null, 6L);
        Assert.assertEquals(6L, this.map.getIfAbsent(null, 5L));
    }

    @Test
    public void getIfAbsentPut_Value() {
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map1);
        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map2);
        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(null, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(null, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 50L), map3);
    }

    @Test
    public void getAndPut() {
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(20L, map1.getAndPut(Integer.valueOf(5), 100L, 20L));
        Assert.assertEquals(100L, map1.get(Integer.valueOf(5)));
        Assert.assertEquals(100L, map1.getAndPut(Integer.valueOf(5), 70L, 50L));
        Assert.assertEquals(70L, map1.get(Integer.valueOf(5)));
        Assert.assertEquals(70L, map1.getAndPut(Integer.valueOf(5), 77L, 50L));
        Assert.assertEquals(77L, map1.get(Integer.valueOf(5)));
        map1.removeKey(Integer.valueOf(5));
        Assert.assertEquals(20L, map1.getAndPut(Integer.valueOf(5), 100L, 20L));
        Assert.assertEquals(100L, map1.get(Integer.valueOf(5)));
    }

    @Test
    public void getIfAbsentPut_Function() {
        LongFunction0 factory = () -> 100L;
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        LongFunction0 factoryThrows = () -> {
            throw new AssertionError();
        };
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map1);
        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map2);
        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 100L), map3);
    }

    @Test
    public void getIfAbsentPutWith() {
        LongFunction<String> functionLength = (String string) -> string.length();
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        LongFunction<String> functionThrows = (String each) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map1);
        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map2);
        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 9L), map3);
    }

    @Test
    public void getIfAbsentPutWithKey() {
        LongFunction<Integer> function = (Integer anObject) -> anObject == null ? 32L : anObject.intValue();
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        LongFunction<Integer> functionThrows = (Integer longParameter) -> {
            throw new AssertionError();
        };
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map1);
        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map2);
        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 32L), map3);
    }

    @Test
    public void updateValue() {
        LongToLongFunction incrementFunction = (long value) -> value + 1;
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L, 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map1);
        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 1L, 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map2);
        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(null, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(null, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 2L), map3);
    }

    @Test
    public void addToValue() {
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, 1L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 1L), map1);
        Assert.assertEquals(5L, map1.addToValue(0, 4L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 5L), map1);
        Assert.assertEquals(2L, map1.addToValue(1, 2L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 5L, 1, 2L), map1);
        Assert.assertEquals(10L, map1.addToValue(1, 8L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 5L, 1, 10L), map1);
        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.addToValue(null, 1L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 1L), map2);
        Assert.assertEquals(5L, map2.addToValue(null, 4L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 5L), map2);
        MutableObjectLongMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            long v = each + index;
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v));
        });
    }

    @Override
    @Test
    public void containsKey() {
        super.containsKey();
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0L, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0L, this.map.get("0"));
        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals(0L, this.map.get("1"));
        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals(0L, this.map.get("2"));
        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals(0L, this.map.get("3"));
        this.map.put(null, 5L);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue() {
        super.containsValue();
        this.map.put("5", 5L);
        Assert.assertTrue(this.map.containsValue(5L));
        this.map.put(null, 6L);
        Assert.assertTrue(this.map.containsValue(6L));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue(0L));
    }

    @Override
    @Test
    public void size() {
        super.size();
        MutableObjectLongMap<Integer> hashMap1 = this.newWithKeysValues(1, 1L, 0, 0L);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);
        MutableObjectLongMap<Integer> hashMap = this.newWithKeysValues(6, 6L, 5, 5L);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues() {
        MutableObjectLongMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectLongMap<Integer> hashMap = emptyMap.withKeyValue(1, 1L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey() {
        MutableObjectLongMap<Integer> map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        MutableObjectLongMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 2, 2L), mapWithout);
    }

    @Test
    public void withoutAllKeys() {
        MutableObjectLongMap<Integer> map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        MutableObjectLongMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L, 2, 2L), mapWithout);
    }

    @Test
    public void withAllKeyValues() {
        MutableObjectLongMap<String> emptyMap = this.getEmptyMap();
        MutableObjectLongMap<String> partialMap = this.newWithKeysValues("one", 1L, "three", 3L);
        MutableObjectLongMap<String> completeMap = this.newWithKeysValues("one", 1L, "two", 2L, "three", 3L);
        Iterable<ObjectLongPair<String>> emptyIterable = Iterables.iList();
        Iterable<ObjectLongPair<String>> partialIterable = Iterables.iList(PrimitiveTuples.pair("one", 1L), PrimitiveTuples.pair("three", 3L));
        Iterable<ObjectLongPair<String>> completeIterable = Iterables.iList(PrimitiveTuples.pair("one", 1L), PrimitiveTuples.pair("two", 2L), PrimitiveTuples.pair("three", 3L));
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
        this.map.put("5", 5L);
        Assert.assertTrue(this.map.contains(5L));
        this.map.put(null, 6L);
        Assert.assertTrue(this.map.contains(6L));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains(0L));
    }

    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableObjectLongMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectLongMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedObjectLongMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectLongMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues() {
        MutableObjectLongMap<String> map = this.newWithKeysValues("1", 2L, "2", 3L);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(2L, "1", 3L, "2"), map.flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1L, "2", 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractMutableObjectLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableObjectLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableObjectLongMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = AbstractMutableObjectLongMapTestCase::keySet;
            this.payloads.values = AbstractMutableObjectLongMapTestCase::values;
            this.payloads.isEmpty = AbstractMutableObjectLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractMutableObjectLongMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractMutableObjectLongMapTestCase::asLazy;
            this.payloads.testEquals = AbstractMutableObjectLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractMutableObjectLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractMutableObjectLongMapTestCase::testToString;
            this.payloads.longIterator = AbstractMutableObjectLongMapTestCase::longIterator;
            this.payloads.forEach = AbstractMutableObjectLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractMutableObjectLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractMutableObjectLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractMutableObjectLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractMutableObjectLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractMutableObjectLongMapTestCase::makeString;
            this.payloads.appendString = AbstractMutableObjectLongMapTestCase::appendString;
            this.payloads.select = AbstractMutableObjectLongMapTestCase::select;
            this.payloads.reject = AbstractMutableObjectLongMapTestCase::reject;
            this.payloads.tap = AbstractMutableObjectLongMapTestCase::tap;
            this.payloads.count = AbstractMutableObjectLongMapTestCase::count;
            this.payloads.anySatisfy = AbstractMutableObjectLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractMutableObjectLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractMutableObjectLongMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractMutableObjectLongMapTestCase::detectIfNone;
            this.payloads.collect = AbstractMutableObjectLongMapTestCase::collect;
            this.payloads.sum = AbstractMutableObjectLongMapTestCase::sum;
            this.payloads.max = AbstractMutableObjectLongMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectLongMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractMutableObjectLongMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectLongMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractMutableObjectLongMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractMutableObjectLongMapTestCase::minIfEmpty;
            this.payloads.average = AbstractMutableObjectLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractMutableObjectLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableObjectLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractMutableObjectLongMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractMutableObjectLongMapTestCase::toSortedArray;
            this.payloads.containsAll = AbstractMutableObjectLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractMutableObjectLongMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractMutableObjectLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractMutableObjectLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractMutableObjectLongMapTestCase::toSet;
            this.payloads.toBag = AbstractMutableObjectLongMapTestCase::toBag;
            this.payloads.toImmutable = AbstractMutableObjectLongMapTestCase::toImmutable;
            this.payloads.clear = AbstractMutableObjectLongMapTestCase::clear;
            this.payloads.removeKey = AbstractMutableObjectLongMapTestCase::removeKey;
            this.payloads.remove = AbstractMutableObjectLongMapTestCase::remove;
            this.payloads.put = AbstractMutableObjectLongMapTestCase::put;
            this.payloads.updateValues = AbstractMutableObjectLongMapTestCase::updateValues;
            this.payloads.putPair = AbstractMutableObjectLongMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = AbstractMutableObjectLongMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = AbstractMutableObjectLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractMutableObjectLongMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = AbstractMutableObjectLongMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = AbstractMutableObjectLongMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = AbstractMutableObjectLongMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = AbstractMutableObjectLongMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = AbstractMutableObjectLongMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = AbstractMutableObjectLongMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = AbstractMutableObjectLongMapTestCase::updateValue;
            this.payloads.addToValue = AbstractMutableObjectLongMapTestCase::addToValue;
            this.payloads.containsKey = AbstractMutableObjectLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractMutableObjectLongMapTestCase::containsValue;
            this.payloads.size = AbstractMutableObjectLongMapTestCase::size;
            this.payloads.withKeysValues = AbstractMutableObjectLongMapTestCase::withKeysValues;
            this.payloads.withoutKey = AbstractMutableObjectLongMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = AbstractMutableObjectLongMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = AbstractMutableObjectLongMapTestCase::withAllKeyValues;
            this.payloads.contains = AbstractMutableObjectLongMapTestCase::contains;
            this.payloads.asUnmodifiable = AbstractMutableObjectLongMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = AbstractMutableObjectLongMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = AbstractMutableObjectLongMapTestCase::flipUniqueValues;
        }
    }
}
