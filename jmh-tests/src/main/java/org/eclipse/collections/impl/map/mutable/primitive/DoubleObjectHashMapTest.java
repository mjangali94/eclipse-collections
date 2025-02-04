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
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableDoubleObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class DoubleObjectHashMapTest extends AbstractMutableDoubleObjectMapTestCase {

    @Override
    protected DoubleObjectHashMap<String> classUnderTest() {
        return DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo");
    }

    @Override
    protected <T> DoubleObjectHashMap<T> newWithKeysValues(double key1, T value1) {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> DoubleObjectHashMap<T> newWithKeysValues(double key1, T value1, double key2, T value2) {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> DoubleObjectHashMap<T> newWithKeysValues(double key1, T value1, double key2, T value2, double key3, T value3) {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> DoubleObjectHashMap<T> getEmptyMap() {
        return new DoubleObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = DoubleObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleObjectHashMap<Object> hashMap = new DoubleObjectHashMap<>();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = DoubleObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleObjectHashMap<Object> hashMap = new DoubleObjectHashMap<>(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);
        DoubleObjectHashMap<?> hashMap2 = new DoubleObjectHashMap<>(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = DoubleObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleObjectHashMap<Object> hashMap = DoubleObjectHashMap.newMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithDoubleObjectMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = DoubleObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleObjectHashMap<Object> map = DoubleObjectHashMap.newMap();
        DoubleObjectHashMap<Object> hashMap = DoubleObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleObjectHashMap<>(), hashMap);
        map.put(1.0, "one");
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one"), DoubleObjectHashMap.newMap(map));
        map.put(2.0, "two");
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two"), DoubleObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException {
        DoubleObjectHashMap<String> hashMap = DoubleObjectHashMap.newMap();
        for (double i = 2.0; i < 10.0; i++) {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }
        Field keys = DoubleObjectHashMap.class.getDeclaredField("keys");
        Field values = DoubleObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (double i = 2.0; i < 10.0; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertNull(hashMap.put(10.0, "10"));
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception {
        DoubleObjectHashMap<Integer> hashMap = DoubleObjectHashMap.newMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, i);
        }
        Field keys = DoubleObjectHashMap.class.getDeclaredField("keys");
        Field values = DoubleObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6.0);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function<Float, Float> function = Functions.getPassThru();
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValue(2.0, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValueWith(2.0, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValueWith(5.0, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValueWith(2.0, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = new DoubleObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (double i = 2; i < 10; i++) {
            hashMap.put((double) i, (float) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        hashMap.getIfAbsentPut(2.0, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Function0<Float> function = Functions0.value(5.0f);
        hashMap.getIfAbsentPut(2.0, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Function<Float, Float> function = Functions.getPassThru();
        hashMap.getIfAbsentPutWith(2.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = DoubleObjectHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        DoubleToObjectFunction<Float> function = (double doubleParameter) -> (float) doubleParameter;
        hashMap.getIfAbsentPutWithKey(2.0, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey(5.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey(2.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = DoubleObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleObjectHashMap<Float> hashMap = new DoubleObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (double i = 2; i < 10; i++) {
            hashMap.put((double) i, (float) i);
        }
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        DoubleObjectHashMap<String> hashMap0 = new DoubleObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues(1.0, "one", 2.0, "two"), hashMap0);
        DoubleObjectHashMap<String> hashMap1 = new DoubleObjectHashMap<String>().withKeysValues(1.0, "one", 2.0, "two", 3.0, "three");
        DoubleObjectHashMap<String> hashMap2 = new DoubleObjectHashMap<String>().withKeysValues(1.0, "one", 2.0, "two", 3.0, "three", 4.0, "four");
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two"), hashMap0);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three"), hashMap1);
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "one", 2.0, "two", 3.0, "three").withKeyValue(4.0, "four"), hashMap2);
    }

    @Test
    public void put_every_slot() {
        MutableDoubleObjectMap<String> hashMap = this.getEmptyMap();
        for (double i = 2.0; i < 100.0; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableDoubleObjectMap<String> hashMap = this.getEmptyMap();
        for (double i = 2.0; i < 100.0; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        Function<String, String> toUpperCase = String::toUpperCase;
        MutableDoubleObjectMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        MutableDoubleObjectMap<Double> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Double.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Double::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        MutableDoubleObjectMap<Integer> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        MutableDoubleObjectMap<Integer> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableDoubleObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.doubleValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, result, 1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableDoubleObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.doubleValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));
        Assert.assertEquals(1.082323233711138, result, 1.0e-15);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleObjectHashMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBoolean_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByte_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectChar_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDouble_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloat_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectInt_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLong_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShort_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_longInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatInjectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_doubleInjectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleInjectInto);
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
        public void benchmark_toSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumByDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumByDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_withTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_withTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_negative_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_negative_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_throws_zero_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_throws_zero_size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateInPlaceBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateInPlaceBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_3() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_3);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream);
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
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_NaN() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_NaN);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_POSITIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_POSITIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_NEGATIVE_INFINITY() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_NEGATIVE_INFINITY);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_zero() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_zero);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
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
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.defaultInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithInitialCapacity_negative_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMapWithDoubleObjectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithDoubleObjectMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnClear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnClear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnUpdateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnUpdateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfFloatConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfFloatConsistentRounding);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumOfDoubleConsistentRounding() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumOfDoubleConsistentRounding);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> put_NaN;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> put_POSITIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> put_NEGATIVE_INFINITY;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> put_zero;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> newMapWithDoubleObjectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> updateValueWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleObjectHashMapTest> sumOfDoubleConsistentRounding;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = DoubleObjectHashMapTest::keySet;
            this.payloads.values = DoubleObjectHashMapTest::values;
            this.payloads.select = DoubleObjectHashMapTest::select;
            this.payloads.selectWith = DoubleObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = DoubleObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = DoubleObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = DoubleObjectHashMapTest::collect;
            this.payloads.collectBoolean = DoubleObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = DoubleObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = DoubleObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = DoubleObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = DoubleObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = DoubleObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = DoubleObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = DoubleObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = DoubleObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = DoubleObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = DoubleObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = DoubleObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = DoubleObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = DoubleObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = DoubleObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = DoubleObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = DoubleObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = DoubleObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = DoubleObjectHashMapTest::collectIf;
            this.payloads.flatCollect = DoubleObjectHashMapTest::flatCollect;
            this.payloads.detect = DoubleObjectHashMapTest::detect;
            this.payloads.detectWith = DoubleObjectHashMapTest::detectWith;
            this.payloads.detectOptional = DoubleObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = DoubleObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = DoubleObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = DoubleObjectHashMapTest::detectWithIfNone;
            this.payloads.count = DoubleObjectHashMapTest::count;
            this.payloads.countWith = DoubleObjectHashMapTest::countWith;
            this.payloads.anySatisfy = DoubleObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = DoubleObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = DoubleObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = DoubleObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = DoubleObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = DoubleObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = DoubleObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = DoubleObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = DoubleObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = DoubleObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = DoubleObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = DoubleObjectHashMapTest::toList;
            this.payloads.toSortedList = DoubleObjectHashMapTest::toSortedList;
            this.payloads.toSet = DoubleObjectHashMapTest::toSet;
            this.payloads.toSortedSet = DoubleObjectHashMapTest::toSortedSet;
            this.payloads.toBag = DoubleObjectHashMapTest::toBag;
            this.payloads.toMap = DoubleObjectHashMapTest::toMap;
            this.payloads.toMapTarget = DoubleObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = DoubleObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = DoubleObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = DoubleObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = DoubleObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = DoubleObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = DoubleObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = DoubleObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = DoubleObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = DoubleObjectHashMapTest::toArray;
            this.payloads.min = DoubleObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = DoubleObjectHashMapTest::maxBy;
            this.payloads.max = DoubleObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = DoubleObjectHashMapTest::minBy;
            this.payloads.sumOfInt = DoubleObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = DoubleObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = DoubleObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = DoubleObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = DoubleObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = DoubleObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = DoubleObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = DoubleObjectHashMapTest::sumByDouble;
            this.payloads.keysView = DoubleObjectHashMapTest::keysView;
            this.payloads.reject = DoubleObjectHashMapTest::reject;
            this.payloads.rejectWith = DoubleObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = DoubleObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = DoubleObjectHashMapTest::partition;
            this.payloads.partitionWith = DoubleObjectHashMapTest::partitionWith;
            this.payloads.forEachValue = DoubleObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = DoubleObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = DoubleObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = DoubleObjectHashMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = DoubleObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = DoubleObjectHashMapTest::notEmpty;
            this.payloads.getFirst = DoubleObjectHashMapTest::getFirst;
            this.payloads.getLast = DoubleObjectHashMapTest::getLast;
            this.payloads.getOnly = DoubleObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = DoubleObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = DoubleObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = DoubleObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = DoubleObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = DoubleObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = DoubleObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = DoubleObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = DoubleObjectHashMapTest::testEquals;
            this.payloads.testHashCode = DoubleObjectHashMapTest::testHashCode;
            this.payloads.testToString = DoubleObjectHashMapTest::testToString;
            this.payloads.zip = DoubleObjectHashMapTest::zip;
            this.payloads.zipWithIndex = DoubleObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = DoubleObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = DoubleObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = DoubleObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = DoubleObjectHashMapTest::groupBy;
            this.payloads.groupByEach = DoubleObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = DoubleObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = DoubleObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = DoubleObjectHashMapTest::makeString;
            this.payloads.appendString = DoubleObjectHashMapTest::appendString;
            this.payloads.tap = DoubleObjectHashMapTest::tap;
            this.payloads.forEach = DoubleObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = DoubleObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = DoubleObjectHashMapTest::forEachWith;
            this.payloads.toImmutable = DoubleObjectHashMapTest::toImmutable;
            this.payloads.toSortedBag = DoubleObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = DoubleObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = DoubleObjectHashMapTest::stream;
            this.payloads.parallelStream = DoubleObjectHashMapTest::parallelStream;
            this.payloads.clear = DoubleObjectHashMapTest::clear;
            this.payloads.removeKey = DoubleObjectHashMapTest::removeKey;
            this.payloads.remove = DoubleObjectHashMapTest::remove;
            this.payloads.put = DoubleObjectHashMapTest::put;
            this.payloads.putPair = DoubleObjectHashMapTest::putPair;
            this.payloads.put_NaN = DoubleObjectHashMapTest::put_NaN;
            this.payloads.put_POSITIVE_INFINITY = DoubleObjectHashMapTest::put_POSITIVE_INFINITY;
            this.payloads.put_NEGATIVE_INFINITY = DoubleObjectHashMapTest::put_NEGATIVE_INFINITY;
            this.payloads.put_zero = DoubleObjectHashMapTest::put_zero;
            this.payloads.putDuplicateWithRemovedSlot = DoubleObjectHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = DoubleObjectHashMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = DoubleObjectHashMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = DoubleObjectHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = DoubleObjectHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = DoubleObjectHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = DoubleObjectHashMapTest::updateValue;
            this.payloads.updateValueWith = DoubleObjectHashMapTest::updateValueWith;
            this.payloads.freeze = DoubleObjectHashMapTest::freeze;
            this.payloads.withoutKey = DoubleObjectHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubleObjectHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = DoubleObjectHashMapTest::withAllKeyValues;
            this.payloads.get = DoubleObjectHashMapTest::get;
            this.payloads.getIfAbsent = DoubleObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = DoubleObjectHashMapTest::containsKey;
            this.payloads.containsValue = DoubleObjectHashMapTest::containsValue;
            this.payloads.size = DoubleObjectHashMapTest::size;
            this.payloads.contains = DoubleObjectHashMapTest::contains;
            this.payloads.iterator = DoubleObjectHashMapTest::iterator;
            this.payloads.asUnmodifiable = DoubleObjectHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = DoubleObjectHashMapTest::asSynchronized;
            this.payloads.flipUniqueValues = DoubleObjectHashMapTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = DoubleObjectHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleObjectHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleObjectHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = DoubleObjectHashMapTest::newMap;
            this.payloads.newMapWithDoubleObjectMap = DoubleObjectHashMapTest::newMapWithDoubleObjectMap;
            this.payloads.putWithRehash = DoubleObjectHashMapTest::putWithRehash;
            this.payloads.removeWithRehash = DoubleObjectHashMapTest::removeWithRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValueWith = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValueWith;
            this.payloads.occupiedWithDataAndSentinelsOnPut = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = DoubleObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = DoubleObjectHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.withKeysValues = DoubleObjectHashMapTest::withKeysValues;
            this.payloads.put_every_slot = DoubleObjectHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = DoubleObjectHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = DoubleObjectHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = DoubleObjectHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.updateValue_every_slot = DoubleObjectHashMapTest::updateValue_every_slot;
            this.payloads.updateValueWith_every_slot = DoubleObjectHashMapTest::updateValueWith_every_slot;
            this.payloads.classIsNonInstantiable = DoubleObjectHashMapTest::classIsNonInstantiable;
            this.payloads.sumOfFloatConsistentRounding = DoubleObjectHashMapTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = DoubleObjectHashMapTest::sumOfDoubleConsistentRounding;
        }
    }
}
