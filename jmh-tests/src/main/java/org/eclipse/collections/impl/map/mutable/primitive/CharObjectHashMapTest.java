/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.lang.reflect.Field;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class CharObjectHashMapTest extends AbstractMutableCharObjectMapTestCase {

    @Override
    protected CharObjectHashMap<String> classUnderTest() {
        return CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo");
    }

    @Override
    protected <T> CharObjectHashMap<T> newWithKeysValues(char key1, T value1) {
        return CharObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> CharObjectHashMap<T> newWithKeysValues(char key1, T value1, char key2, T value2) {
        return CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> CharObjectHashMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3) {
        return CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> CharObjectHashMap<T> getEmptyMap() {
        return new CharObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharObjectHashMap<Object> hashMap = new CharObjectHashMap<>();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharObjectHashMap<Object> hashMap = new CharObjectHashMap<>(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);
        CharObjectHashMap<?> hashMap2 = new CharObjectHashMap<>(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharObjectHashMap<Object> hashMap = CharObjectHashMap.newMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithCharObjectMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharObjectHashMap<Object> map = CharObjectHashMap.newMap();
        CharObjectHashMap<Object> hashMap = CharObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);
        map.put((char) 1, "one");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), CharObjectHashMap.newMap(map));
        map.put((char) 2, "two");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two"), CharObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException {
        CharObjectHashMap<String> hashMap = CharObjectHashMap.newMap();
        for (char i = (char) 2; i < (char) 10; i++) {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (char i = (char) 2; i < (char) 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertNull(hashMap.put((char) 10, "10"));
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception {
        CharObjectHashMap<Integer> hashMap = CharObjectHashMap.newMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, i);
        }
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove((char) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove((char) 6);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((char) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function<Float, Float> function = Functions.getPassThru();
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValue((char) 2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((char) 5, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((char) 2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValueWith((char) 2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValueWith((char) 5, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValueWith((char) 2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = new CharObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (char i = 2; i < 10; i++) {
            hashMap.put((char) i, (float) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((char) 2, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        hashMap.getIfAbsentPut((char) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((char) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((char) 2, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Function0<Float> function = Functions0.value(5.0f);
        hashMap.getIfAbsentPut((char) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((char) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((char) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Function<Float, Float> function = Functions.getPassThru();
        hashMap.getIfAbsentPutWith((char) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((char) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((char) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        CharToObjectFunction<Float> function = (char charParameter) -> (float) charParameter;
        hashMap.getIfAbsentPutWithKey((char) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey((char) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey((char) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = new CharObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (char i = 2; i < 10; i++) {
            hashMap.put((char) i, (float) i);
        }
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((char) 2, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        CharObjectHashMap<String> hashMap0 = new CharObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, "one", (char) 2, "two"), hashMap0);
        CharObjectHashMap<String> hashMap1 = new CharObjectHashMap<String>().withKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three");
        CharObjectHashMap<String> hashMap2 = new CharObjectHashMap<String>().withKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three", (char) 4, "four");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two"), hashMap0);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three"), hashMap1);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three").withKeyValue((char) 4, "four"), hashMap2);
    }

    @Test
    public void put_every_slot() {
        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        for (char i = (char) 2; i < (char) 100; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        for (char i = (char) 2; i < (char) 100; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        Function<String, String> toUpperCase = String::toUpperCase;
        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        MutableCharObjectMap<Character> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Character.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Character::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.fromTo(Character.MIN_VALUE, Character.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0);
        final MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put((char) i.intValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.0823232337616622, result, 1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.fromTo(Character.MIN_VALUE, Character.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0);
        final MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put((char) i.intValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));
        Assert.assertEquals(1.082323233711138, result, 1.0e-15);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharObjectHashMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
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
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithCharObjectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithCharObjectMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnClear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new CharObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> newMapWithCharObjectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> updateValueWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharObjectHashMapTest> sumOfDoubleConsistentRounding;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = CharObjectHashMapTest::keySet;
            this.payloads.values = CharObjectHashMapTest::values;
            this.payloads.select = CharObjectHashMapTest::select;
            this.payloads.selectWith = CharObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = CharObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = CharObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = CharObjectHashMapTest::collect;
            this.payloads.collectBoolean = CharObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = CharObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = CharObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = CharObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = CharObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = CharObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = CharObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = CharObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = CharObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = CharObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = CharObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = CharObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = CharObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = CharObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = CharObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = CharObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = CharObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = CharObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = CharObjectHashMapTest::collectIf;
            this.payloads.flatCollect = CharObjectHashMapTest::flatCollect;
            this.payloads.detect = CharObjectHashMapTest::detect;
            this.payloads.detectWith = CharObjectHashMapTest::detectWith;
            this.payloads.detectOptional = CharObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = CharObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = CharObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = CharObjectHashMapTest::detectWithIfNone;
            this.payloads.count = CharObjectHashMapTest::count;
            this.payloads.countWith = CharObjectHashMapTest::countWith;
            this.payloads.anySatisfy = CharObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = CharObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = CharObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = CharObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = CharObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = CharObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = CharObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = CharObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = CharObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = CharObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = CharObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = CharObjectHashMapTest::toList;
            this.payloads.toSortedList = CharObjectHashMapTest::toSortedList;
            this.payloads.toSet = CharObjectHashMapTest::toSet;
            this.payloads.toSortedSet = CharObjectHashMapTest::toSortedSet;
            this.payloads.toBag = CharObjectHashMapTest::toBag;
            this.payloads.toMap = CharObjectHashMapTest::toMap;
            this.payloads.toMapTarget = CharObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = CharObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = CharObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = CharObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = CharObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = CharObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = CharObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = CharObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = CharObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = CharObjectHashMapTest::toArray;
            this.payloads.min = CharObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = CharObjectHashMapTest::maxBy;
            this.payloads.max = CharObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = CharObjectHashMapTest::minBy;
            this.payloads.sumOfInt = CharObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = CharObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = CharObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = CharObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = CharObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = CharObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = CharObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = CharObjectHashMapTest::sumByDouble;
            this.payloads.keysView = CharObjectHashMapTest::keysView;
            this.payloads.reject = CharObjectHashMapTest::reject;
            this.payloads.rejectWith = CharObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = CharObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = CharObjectHashMapTest::partition;
            this.payloads.partitionWith = CharObjectHashMapTest::partitionWith;
            this.payloads.forEachValue = CharObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = CharObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = CharObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = CharObjectHashMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = CharObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = CharObjectHashMapTest::notEmpty;
            this.payloads.getFirst = CharObjectHashMapTest::getFirst;
            this.payloads.getLast = CharObjectHashMapTest::getLast;
            this.payloads.getOnly = CharObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = CharObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = CharObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = CharObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = CharObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = CharObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = CharObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = CharObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = CharObjectHashMapTest::testEquals;
            this.payloads.testHashCode = CharObjectHashMapTest::testHashCode;
            this.payloads.testToString = CharObjectHashMapTest::testToString;
            this.payloads.zip = CharObjectHashMapTest::zip;
            this.payloads.zipWithIndex = CharObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = CharObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = CharObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = CharObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = CharObjectHashMapTest::groupBy;
            this.payloads.groupByEach = CharObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = CharObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = CharObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = CharObjectHashMapTest::makeString;
            this.payloads.appendString = CharObjectHashMapTest::appendString;
            this.payloads.tap = CharObjectHashMapTest::tap;
            this.payloads.forEach = CharObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = CharObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = CharObjectHashMapTest::forEachWith;
            this.payloads.toImmutable = CharObjectHashMapTest::toImmutable;
            this.payloads.toSortedBag = CharObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = CharObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = CharObjectHashMapTest::stream;
            this.payloads.parallelStream = CharObjectHashMapTest::parallelStream;
            this.payloads.clear = CharObjectHashMapTest::clear;
            this.payloads.removeKey = CharObjectHashMapTest::removeKey;
            this.payloads.remove = CharObjectHashMapTest::remove;
            this.payloads.put = CharObjectHashMapTest::put;
            this.payloads.putPair = CharObjectHashMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = CharObjectHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = CharObjectHashMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = CharObjectHashMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = CharObjectHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = CharObjectHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = CharObjectHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = CharObjectHashMapTest::updateValue;
            this.payloads.updateValueWith = CharObjectHashMapTest::updateValueWith;
            this.payloads.freeze = CharObjectHashMapTest::freeze;
            this.payloads.withoutKey = CharObjectHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = CharObjectHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = CharObjectHashMapTest::withAllKeyValues;
            this.payloads.get = CharObjectHashMapTest::get;
            this.payloads.getIfAbsent = CharObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = CharObjectHashMapTest::containsKey;
            this.payloads.containsValue = CharObjectHashMapTest::containsValue;
            this.payloads.size = CharObjectHashMapTest::size;
            this.payloads.contains = CharObjectHashMapTest::contains;
            this.payloads.iterator = CharObjectHashMapTest::iterator;
            this.payloads.asUnmodifiable = CharObjectHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = CharObjectHashMapTest::asSynchronized;
            this.payloads.flipUniqueValues = CharObjectHashMapTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = CharObjectHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = CharObjectHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharObjectHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = CharObjectHashMapTest::newMap;
            this.payloads.newMapWithCharObjectMap = CharObjectHashMapTest::newMapWithCharObjectMap;
            this.payloads.putWithRehash = CharObjectHashMapTest::putWithRehash;
            this.payloads.removeWithRehash = CharObjectHashMapTest::removeWithRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValueWith = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValueWith;
            this.payloads.occupiedWithDataAndSentinelsOnPut = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = CharObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = CharObjectHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.withKeysValues = CharObjectHashMapTest::withKeysValues;
            this.payloads.put_every_slot = CharObjectHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = CharObjectHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = CharObjectHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = CharObjectHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.updateValue_every_slot = CharObjectHashMapTest::updateValue_every_slot;
            this.payloads.updateValueWith_every_slot = CharObjectHashMapTest::updateValueWith_every_slot;
            this.payloads.classIsNonInstantiable = CharObjectHashMapTest::classIsNonInstantiable;
            this.payloads.sumOfFloatConsistentRounding = CharObjectHashMapTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = CharObjectHashMapTest::sumOfDoubleConsistentRounding;
        }
    }
}
