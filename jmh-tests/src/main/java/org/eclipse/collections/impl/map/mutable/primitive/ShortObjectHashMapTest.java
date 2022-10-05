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
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.ShortObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class ShortObjectHashMapTest extends AbstractMutableShortObjectMapTestCase {

    @Override
    protected ShortObjectHashMap<String> classUnderTest() {
        return ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo");
    }

    @Override
    protected <T> ShortObjectHashMap<T> newWithKeysValues(short key1, T value1) {
        return ShortObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ShortObjectHashMap<T> newWithKeysValues(short key1, T value1, short key2, T value2) {
        return ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ShortObjectHashMap<T> newWithKeysValues(short key1, T value1, short key2, T value2, short key3, T value3) {
        return ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ShortObjectHashMap<T> getEmptyMap() {
        return new ShortObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = ShortObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortObjectHashMap<Object> hashMap = new ShortObjectHashMap<>();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = ShortObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortObjectHashMap<Object> hashMap = new ShortObjectHashMap<>(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);
        ShortObjectHashMap<?> hashMap2 = new ShortObjectHashMap<>(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ShortObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = ShortObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortObjectHashMap<Object> hashMap = ShortObjectHashMap.newMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithShortObjectMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = ShortObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortObjectHashMap<Object> map = ShortObjectHashMap.newMap();
        ShortObjectHashMap<Object> hashMap = ShortObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortObjectHashMap<>(), hashMap);
        map.put((short) 1, "one");
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one"), ShortObjectHashMap.newMap(map));
        map.put((short) 2, "two");
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two"), ShortObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException {
        ShortObjectHashMap<String> hashMap = ShortObjectHashMap.newMap();
        for (short i = (short) 2; i < (short) 10; i++) {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }
        Field keys = ShortObjectHashMap.class.getDeclaredField("keys");
        Field values = ShortObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (short i = (short) 2; i < (short) 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertNull(hashMap.put((short) 10, "10"));
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception {
        ShortObjectHashMap<Integer> hashMap = ShortObjectHashMap.newMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((short) i, i);
        }
        Field keys = ShortObjectHashMap.class.getDeclaredField("keys");
        Field values = ShortObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove((short) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove((short) 6);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((short) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function<Float, Float> function = Functions.getPassThru();
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValue((short) 2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((short) 5, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((short) 2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValueWith((short) 2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValueWith((short) 5, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValueWith((short) 2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = new ShortObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (short i = 2; i < 10; i++) {
            hashMap.put((short) i, (float) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((short) 2, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        hashMap.getIfAbsentPut((short) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((short) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((short) 2, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Function0<Float> function = Functions0.value(5.0f);
        hashMap.getIfAbsentPut((short) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((short) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((short) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Function<Float, Float> function = Functions.getPassThru();
        hashMap.getIfAbsentPutWith((short) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((short) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((short) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = ShortObjectHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        ShortToObjectFunction<Float> function = (short shortParameter) -> (float) shortParameter;
        hashMap.getIfAbsentPutWithKey((short) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey((short) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey((short) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = ShortObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortObjectHashMap<Float> hashMap = new ShortObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (short i = 2; i < 10; i++) {
            hashMap.put((short) i, (float) i);
        }
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((short) 2, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ShortObjectHashMap<String> hashMap0 = new ShortObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, "one", (short) 2, "two"), hashMap0);
        ShortObjectHashMap<String> hashMap1 = new ShortObjectHashMap<String>().withKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three");
        ShortObjectHashMap<String> hashMap2 = new ShortObjectHashMap<String>().withKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three", (short) 4, "four");
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two"), hashMap0);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three"), hashMap1);
        Assert.assertEquals(ShortObjectHashMap.newWithKeysValues((short) 1, "one", (short) 2, "two", (short) 3, "three").withKeyValue((short) 4, "four"), hashMap2);
    }

    @Test
    public void put_every_slot() {
        MutableShortObjectMap<String> hashMap = this.getEmptyMap();
        for (short i = (short) 2; i < (short) 100; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableShortObjectMap<String> hashMap = this.getEmptyMap();
        for (short i = (short) 2; i < (short) 100; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        Function<String, String> toUpperCase = String::toUpperCase;
        MutableShortObjectMap<String> hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        MutableShortObjectMap<Short> hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Short.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Short::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        MutableShortObjectMap<Integer> hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        MutableShortObjectMap<Integer> hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.fromTo(Short.MIN_VALUE, Short.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0);
        final MutableShortObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.shortValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(2.1646464675233075, result, 1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.fromTo(Short.MIN_VALUE, Short.MAX_VALUE).toList().shuffleThis().reject(i -> i == 0);
        final MutableShortObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.shortValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));
        Assert.assertEquals(2.1646464674222576, result, 1.0e-15);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableShortObjectMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::defaultInitialCapacity, this.description("defaultInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithInitialCapacity, this.description("newWithInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::newWithInitialCapacity_negative_throws, this.description("newWithInitialCapacity_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMap, this.description("newMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithShortObjectMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMapWithShortObjectMap, this.description("newMapWithShortObjectMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putWithRehash, this.description("putWithRehash"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithRehash() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::removeWithRehash, this.description("removeWithRehash"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnClear() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnClear, this.description("occupiedWithDataAndSentinelsOnClear"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnRemove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnRemove, this.description("occupiedWithDataAndSentinelsOnRemove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnUpdateValue, this.description("occupiedWithDataAndSentinelsOnUpdateValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValueWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnUpdateValueWith, this.description("occupiedWithDataAndSentinelsOnUpdateValueWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnPut, this.description("occupiedWithDataAndSentinelsOnPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnGetIfAbsentPut, this.description("occupiedWithDataAndSentinelsOnGetIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction, this.description("occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith, this.description("occupiedWithDataAndSentinelsOnGetIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey, this.description("occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::occupiedWithSentinelsOnPutRemovedSlot, this.description("occupiedWithSentinelsOnPutRemovedSlot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_every_slot, this.description("put_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_every_slot, this.description("getIfAbsentPut_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith_every_slot, this.description("getIfAbsentPutWith_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithKey_every_slot, this.description("getIfAbsentPutWithKey_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue_every_slot, this.description("updateValue_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValueWith_every_slot, this.description("updateValueWith_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::classIsNonInstantiable, this.description("classIsNonInstantiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfFloatConsistentRounding, this.description("sumOfFloatConsistentRounding"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumOfDoubleConsistentRounding, this.description("sumOfDoubleConsistentRounding"));
        }

        private ShortObjectHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ShortObjectHashMapTest();
        }

        @java.lang.Override
        public ShortObjectHashMapTest implementation() {
            return this.implementation;
        }
    }
}
