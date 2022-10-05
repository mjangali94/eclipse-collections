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
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortObjectHashMapTest instance;

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
        public void benchmark_newMapWithShortObjectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithShortObjectMap);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ShortObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> newMapWithShortObjectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> updateValueWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortObjectHashMapTest> sumOfDoubleConsistentRounding;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ShortObjectHashMapTest::keySet;
            this.payloads.values = ShortObjectHashMapTest::values;
            this.payloads.select = ShortObjectHashMapTest::select;
            this.payloads.selectWith = ShortObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = ShortObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = ShortObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = ShortObjectHashMapTest::collect;
            this.payloads.collectBoolean = ShortObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = ShortObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = ShortObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = ShortObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = ShortObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = ShortObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = ShortObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = ShortObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = ShortObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = ShortObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = ShortObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = ShortObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = ShortObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = ShortObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = ShortObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = ShortObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = ShortObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = ShortObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = ShortObjectHashMapTest::collectIf;
            this.payloads.flatCollect = ShortObjectHashMapTest::flatCollect;
            this.payloads.detect = ShortObjectHashMapTest::detect;
            this.payloads.detectWith = ShortObjectHashMapTest::detectWith;
            this.payloads.detectOptional = ShortObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = ShortObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = ShortObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = ShortObjectHashMapTest::detectWithIfNone;
            this.payloads.count = ShortObjectHashMapTest::count;
            this.payloads.countWith = ShortObjectHashMapTest::countWith;
            this.payloads.anySatisfy = ShortObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = ShortObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = ShortObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = ShortObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = ShortObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = ShortObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = ShortObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = ShortObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = ShortObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = ShortObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = ShortObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = ShortObjectHashMapTest::toList;
            this.payloads.toSortedList = ShortObjectHashMapTest::toSortedList;
            this.payloads.toSet = ShortObjectHashMapTest::toSet;
            this.payloads.toSortedSet = ShortObjectHashMapTest::toSortedSet;
            this.payloads.toBag = ShortObjectHashMapTest::toBag;
            this.payloads.toMap = ShortObjectHashMapTest::toMap;
            this.payloads.toMapTarget = ShortObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = ShortObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = ShortObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = ShortObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = ShortObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = ShortObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = ShortObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = ShortObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = ShortObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = ShortObjectHashMapTest::toArray;
            this.payloads.min = ShortObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = ShortObjectHashMapTest::maxBy;
            this.payloads.max = ShortObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = ShortObjectHashMapTest::minBy;
            this.payloads.sumOfInt = ShortObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = ShortObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = ShortObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = ShortObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = ShortObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = ShortObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = ShortObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = ShortObjectHashMapTest::sumByDouble;
            this.payloads.keysView = ShortObjectHashMapTest::keysView;
            this.payloads.reject = ShortObjectHashMapTest::reject;
            this.payloads.rejectWith = ShortObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = ShortObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = ShortObjectHashMapTest::partition;
            this.payloads.partitionWith = ShortObjectHashMapTest::partitionWith;
            this.payloads.forEachValue = ShortObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = ShortObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ShortObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ShortObjectHashMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = ShortObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = ShortObjectHashMapTest::notEmpty;
            this.payloads.getFirst = ShortObjectHashMapTest::getFirst;
            this.payloads.getLast = ShortObjectHashMapTest::getLast;
            this.payloads.getOnly = ShortObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = ShortObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = ShortObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = ShortObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = ShortObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = ShortObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = ShortObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = ShortObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = ShortObjectHashMapTest::testEquals;
            this.payloads.testHashCode = ShortObjectHashMapTest::testHashCode;
            this.payloads.testToString = ShortObjectHashMapTest::testToString;
            this.payloads.zip = ShortObjectHashMapTest::zip;
            this.payloads.zipWithIndex = ShortObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = ShortObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = ShortObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = ShortObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = ShortObjectHashMapTest::groupBy;
            this.payloads.groupByEach = ShortObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = ShortObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = ShortObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = ShortObjectHashMapTest::makeString;
            this.payloads.appendString = ShortObjectHashMapTest::appendString;
            this.payloads.tap = ShortObjectHashMapTest::tap;
            this.payloads.forEach = ShortObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = ShortObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = ShortObjectHashMapTest::forEachWith;
            this.payloads.toImmutable = ShortObjectHashMapTest::toImmutable;
            this.payloads.toSortedBag = ShortObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = ShortObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = ShortObjectHashMapTest::stream;
            this.payloads.parallelStream = ShortObjectHashMapTest::parallelStream;
            this.payloads.clear = ShortObjectHashMapTest::clear;
            this.payloads.removeKey = ShortObjectHashMapTest::removeKey;
            this.payloads.remove = ShortObjectHashMapTest::remove;
            this.payloads.put = ShortObjectHashMapTest::put;
            this.payloads.putPair = ShortObjectHashMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ShortObjectHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = ShortObjectHashMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = ShortObjectHashMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = ShortObjectHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ShortObjectHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ShortObjectHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ShortObjectHashMapTest::updateValue;
            this.payloads.updateValueWith = ShortObjectHashMapTest::updateValueWith;
            this.payloads.freeze = ShortObjectHashMapTest::freeze;
            this.payloads.withoutKey = ShortObjectHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ShortObjectHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ShortObjectHashMapTest::withAllKeyValues;
            this.payloads.get = ShortObjectHashMapTest::get;
            this.payloads.getIfAbsent = ShortObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = ShortObjectHashMapTest::containsKey;
            this.payloads.containsValue = ShortObjectHashMapTest::containsValue;
            this.payloads.size = ShortObjectHashMapTest::size;
            this.payloads.contains = ShortObjectHashMapTest::contains;
            this.payloads.iterator = ShortObjectHashMapTest::iterator;
            this.payloads.asUnmodifiable = ShortObjectHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = ShortObjectHashMapTest::asSynchronized;
            this.payloads.flipUniqueValues = ShortObjectHashMapTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ShortObjectHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ShortObjectHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortObjectHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ShortObjectHashMapTest::newMap;
            this.payloads.newMapWithShortObjectMap = ShortObjectHashMapTest::newMapWithShortObjectMap;
            this.payloads.putWithRehash = ShortObjectHashMapTest::putWithRehash;
            this.payloads.removeWithRehash = ShortObjectHashMapTest::removeWithRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValueWith = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValueWith;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ShortObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ShortObjectHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.withKeysValues = ShortObjectHashMapTest::withKeysValues;
            this.payloads.put_every_slot = ShortObjectHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ShortObjectHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ShortObjectHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ShortObjectHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.updateValue_every_slot = ShortObjectHashMapTest::updateValue_every_slot;
            this.payloads.updateValueWith_every_slot = ShortObjectHashMapTest::updateValueWith_every_slot;
            this.payloads.classIsNonInstantiable = ShortObjectHashMapTest::classIsNonInstantiable;
            this.payloads.sumOfFloatConsistentRounding = ShortObjectHashMapTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = ShortObjectHashMapTest::sumOfDoubleConsistentRounding;
        }
    }
}
