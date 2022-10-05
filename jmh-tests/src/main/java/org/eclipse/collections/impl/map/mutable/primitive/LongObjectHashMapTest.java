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
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.LongObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class LongObjectHashMapTest extends AbstractMutableLongObjectMapTestCase {

    @Override
    protected LongObjectHashMap<String> classUnderTest() {
        return LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo");
    }

    @Override
    protected <T> LongObjectHashMap<T> newWithKeysValues(long key1, T value1) {
        return LongObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> LongObjectHashMap<T> newWithKeysValues(long key1, T value1, long key2, T value2) {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> LongObjectHashMap<T> newWithKeysValues(long key1, T value1, long key2, T value2, long key3, T value3) {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LongObjectHashMap<T> getEmptyMap() {
        return new LongObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = LongObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongObjectHashMap<Object> hashMap = new LongObjectHashMap<>();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field keys = LongObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongObjectHashMap<Object> hashMap = new LongObjectHashMap<>(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);
        LongObjectHashMap<?> hashMap2 = new LongObjectHashMap<>(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new LongObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = LongObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongObjectHashMap<Object> hashMap = LongObjectHashMap.newMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithLongObjectMap() throws NoSuchFieldException, IllegalAccessException {
        Field keys = LongObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongObjectHashMap<Object> map = LongObjectHashMap.newMap();
        LongObjectHashMap<Object> hashMap = LongObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongObjectHashMap<>(), hashMap);
        map.put(1L, "one");
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one"), LongObjectHashMap.newMap(map));
        map.put(2L, "two");
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two"), LongObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException {
        LongObjectHashMap<String> hashMap = LongObjectHashMap.newMap();
        for (long i = 2L; i < 10L; i++) {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }
        Field keys = LongObjectHashMap.class.getDeclaredField("keys");
        Field values = LongObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (long i = 2L; i < 10L; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertNull(hashMap.put(10L, "10"));
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception {
        LongObjectHashMap<Integer> hashMap = LongObjectHashMap.newMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, i);
        }
        Field keys = LongObjectHashMap.class.getDeclaredField("keys");
        Field values = LongObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6L);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function<Float, Float> function = Functions.getPassThru();
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValue(2L, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5L, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2L, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());
        Function0<Float> function0 = Functions0.value(0.0f);
        hashMap.updateValueWith(2L, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValueWith(5L, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValueWith(2L, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = new LongObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (long i = 2; i < 10; i++) {
            hashMap.put((long) i, (float) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2L, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        hashMap.getIfAbsentPut(2L, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5L, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2L, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Function0<Float> function = Functions0.value(5.0f);
        hashMap.getIfAbsentPut(2L, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Function<Float, Float> function = Functions.getPassThru();
        hashMap.getIfAbsentPutWith(2L, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5L, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2L, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = LongObjectHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        LongToObjectFunction<Float> function = (long longParameter) -> (float) longParameter;
        hashMap.getIfAbsentPutWithKey(2L, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey(5L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey(2L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = LongObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongObjectHashMap<Float> hashMap = new LongObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (long i = 2; i < 10; i++) {
            hashMap.put((long) i, (float) i);
        }
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2L, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        LongObjectHashMap<String> hashMap0 = new LongObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues(1L, "one", 2L, "two"), hashMap0);
        LongObjectHashMap<String> hashMap1 = new LongObjectHashMap<String>().withKeysValues(1L, "one", 2L, "two", 3L, "three");
        LongObjectHashMap<String> hashMap2 = new LongObjectHashMap<String>().withKeysValues(1L, "one", 2L, "two", 3L, "three", 4L, "four");
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two"), hashMap0);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two", 3L, "three"), hashMap1);
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "one", 2L, "two", 3L, "three").withKeyValue(4L, "four"), hashMap2);
    }

    @Test
    public void put_every_slot() {
        MutableLongObjectMap<String> hashMap = this.getEmptyMap();
        for (long i = 2L; i < 100L; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableLongObjectMap<String> hashMap = this.getEmptyMap();
        for (long i = 2L; i < 100L; i++) {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        Function<String, String> toUpperCase = String::toUpperCase;
        MutableLongObjectMap<String> hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        MutableLongObjectMap<Long> hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Long.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Long::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot() {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;
        MutableLongObjectMap<Integer> hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot() {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        MutableLongObjectMap<Integer> hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableLongObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.longValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, result, 1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding() {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableLongObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.longValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));
        Assert.assertEquals(1.082323233711138, result, 1.0e-15);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongObjectHashMapTest instance;

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
        public void benchmark_newMapWithLongObjectMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newMapWithLongObjectMap);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new LongObjectHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> selectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectBoolean_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectByte_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectChar_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectDouble_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectFloat_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectInt_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectLong_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectShort_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> intInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> longInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> floatInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> doubleInjectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> min_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> max_throws_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumOfInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumOfLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumOfDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumOfFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> rejectWith_withTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> chunk_throws_negative_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> chunk_throws_zero_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> aggregateInPlaceBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> aggregateBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByUniqueKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByUniqueKey_target_throws_1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByUniqueKey_target_throws_2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> groupByUniqueKey_target_throws_3;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> newMapWithLongObjectMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> removeWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnUpdateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> updateValueWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> classIsNonInstantiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumOfFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongObjectHashMapTest> sumOfDoubleConsistentRounding;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = LongObjectHashMapTest::keySet;
            this.payloads.values = LongObjectHashMapTest::values;
            this.payloads.select = LongObjectHashMapTest::select;
            this.payloads.selectWith = LongObjectHashMapTest::selectWith;
            this.payloads.selectWith_withTarget = LongObjectHashMapTest::selectWith_withTarget;
            this.payloads.selectInstancesOf = LongObjectHashMapTest::selectInstancesOf;
            this.payloads.collect = LongObjectHashMapTest::collect;
            this.payloads.collectBoolean = LongObjectHashMapTest::collectBoolean;
            this.payloads.collectBoolean_withTarget = LongObjectHashMapTest::collectBoolean_withTarget;
            this.payloads.collectByte = LongObjectHashMapTest::collectByte;
            this.payloads.collectByte_withTarget = LongObjectHashMapTest::collectByte_withTarget;
            this.payloads.collectChar = LongObjectHashMapTest::collectChar;
            this.payloads.collectChar_withTarget = LongObjectHashMapTest::collectChar_withTarget;
            this.payloads.collectDouble = LongObjectHashMapTest::collectDouble;
            this.payloads.collectDouble_withTarget = LongObjectHashMapTest::collectDouble_withTarget;
            this.payloads.collectFloat = LongObjectHashMapTest::collectFloat;
            this.payloads.collectFloat_withTarget = LongObjectHashMapTest::collectFloat_withTarget;
            this.payloads.collectInt = LongObjectHashMapTest::collectInt;
            this.payloads.collectInt_withTarget = LongObjectHashMapTest::collectInt_withTarget;
            this.payloads.collectLong = LongObjectHashMapTest::collectLong;
            this.payloads.collectLong_withTarget = LongObjectHashMapTest::collectLong_withTarget;
            this.payloads.collectShort = LongObjectHashMapTest::collectShort;
            this.payloads.collectShort_withTarget = LongObjectHashMapTest::collectShort_withTarget;
            this.payloads.collectWith = LongObjectHashMapTest::collectWith;
            this.payloads.collectWithTarget = LongObjectHashMapTest::collectWithTarget;
            this.payloads.collectIf = LongObjectHashMapTest::collectIf;
            this.payloads.flatCollect = LongObjectHashMapTest::flatCollect;
            this.payloads.detect = LongObjectHashMapTest::detect;
            this.payloads.detectWith = LongObjectHashMapTest::detectWith;
            this.payloads.detectOptional = LongObjectHashMapTest::detectOptional;
            this.payloads.detectWithOptional = LongObjectHashMapTest::detectWithOptional;
            this.payloads.detectIfNone = LongObjectHashMapTest::detectIfNone;
            this.payloads.detectWithIfNone = LongObjectHashMapTest::detectWithIfNone;
            this.payloads.count = LongObjectHashMapTest::count;
            this.payloads.countWith = LongObjectHashMapTest::countWith;
            this.payloads.anySatisfy = LongObjectHashMapTest::anySatisfy;
            this.payloads.anySatisfyWith = LongObjectHashMapTest::anySatisfyWith;
            this.payloads.allSatisfy = LongObjectHashMapTest::allSatisfy;
            this.payloads.allSatisfyWith = LongObjectHashMapTest::allSatisfyWith;
            this.payloads.noneSatisfy = LongObjectHashMapTest::noneSatisfy;
            this.payloads.noneSatisfyWith = LongObjectHashMapTest::noneSatisfyWith;
            this.payloads.injectInto = LongObjectHashMapTest::injectInto;
            this.payloads.intInjectInto = LongObjectHashMapTest::intInjectInto;
            this.payloads.longInjectInto = LongObjectHashMapTest::longInjectInto;
            this.payloads.floatInjectInto = LongObjectHashMapTest::floatInjectInto;
            this.payloads.doubleInjectInto = LongObjectHashMapTest::doubleInjectInto;
            this.payloads.toList = LongObjectHashMapTest::toList;
            this.payloads.toSortedList = LongObjectHashMapTest::toSortedList;
            this.payloads.toSet = LongObjectHashMapTest::toSet;
            this.payloads.toSortedSet = LongObjectHashMapTest::toSortedSet;
            this.payloads.toBag = LongObjectHashMapTest::toBag;
            this.payloads.toMap = LongObjectHashMapTest::toMap;
            this.payloads.toMapTarget = LongObjectHashMapTest::toMapTarget;
            this.payloads.toSortedMap = LongObjectHashMapTest::toSortedMap;
            this.payloads.toImmutableList = LongObjectHashMapTest::toImmutableList;
            this.payloads.toImmutableSortedList = LongObjectHashMapTest::toImmutableSortedList;
            this.payloads.toImmutableSet = LongObjectHashMapTest::toImmutableSet;
            this.payloads.toImmutableSortedSet = LongObjectHashMapTest::toImmutableSortedSet;
            this.payloads.toImmutableBag = LongObjectHashMapTest::toImmutableBag;
            this.payloads.toImmutableSortedBag = LongObjectHashMapTest::toImmutableSortedBag;
            this.payloads.toImmutableSortedBagBy = LongObjectHashMapTest::toImmutableSortedBagBy;
            this.payloads.toArray = LongObjectHashMapTest::toArray;
            this.payloads.min = LongObjectHashMapTest::min;
            this.payloads.min_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::min_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.maxBy = LongObjectHashMapTest::maxBy;
            this.payloads.max = LongObjectHashMapTest::max;
            this.payloads.max_throws_empty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::max_throws_empty, java.util.NoSuchElementException.class);
            this.payloads.minBy = LongObjectHashMapTest::minBy;
            this.payloads.sumOfInt = LongObjectHashMapTest::sumOfInt;
            this.payloads.sumOfLong = LongObjectHashMapTest::sumOfLong;
            this.payloads.sumOfDouble = LongObjectHashMapTest::sumOfDouble;
            this.payloads.sumOfFloat = LongObjectHashMapTest::sumOfFloat;
            this.payloads.sumByInt = LongObjectHashMapTest::sumByInt;
            this.payloads.sumByFloat = LongObjectHashMapTest::sumByFloat;
            this.payloads.sumByLong = LongObjectHashMapTest::sumByLong;
            this.payloads.sumByDouble = LongObjectHashMapTest::sumByDouble;
            this.payloads.keysView = LongObjectHashMapTest::keysView;
            this.payloads.reject = LongObjectHashMapTest::reject;
            this.payloads.rejectWith = LongObjectHashMapTest::rejectWith;
            this.payloads.rejectWith_withTarget = LongObjectHashMapTest::rejectWith_withTarget;
            this.payloads.partition = LongObjectHashMapTest::partition;
            this.payloads.partitionWith = LongObjectHashMapTest::partitionWith;
            this.payloads.forEachValue = LongObjectHashMapTest::forEachValue;
            this.payloads.forEachKey = LongObjectHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = LongObjectHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = LongObjectHashMapTest::injectIntoKeyValue;
            this.payloads.isEmpty = LongObjectHashMapTest::isEmpty;
            this.payloads.notEmpty = LongObjectHashMapTest::notEmpty;
            this.payloads.getFirst = LongObjectHashMapTest::getFirst;
            this.payloads.getLast = LongObjectHashMapTest::getLast;
            this.payloads.getOnly = LongObjectHashMapTest::getOnly;
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.containsAllIterable = LongObjectHashMapTest::containsAllIterable;
            this.payloads.containsAll = LongObjectHashMapTest::containsAll;
            this.payloads.containsAnyIterable = LongObjectHashMapTest::containsAnyIterable;
            this.payloads.containsAny = LongObjectHashMapTest::containsAny;
            this.payloads.containsNoneIterable = LongObjectHashMapTest::containsNoneIterable;
            this.payloads.containsNone = LongObjectHashMapTest::containsNone;
            this.payloads.containsAllArguments = LongObjectHashMapTest::containsAllArguments;
            this.payloads.testEquals = LongObjectHashMapTest::testEquals;
            this.payloads.testHashCode = LongObjectHashMapTest::testHashCode;
            this.payloads.testToString = LongObjectHashMapTest::testToString;
            this.payloads.zip = LongObjectHashMapTest::zip;
            this.payloads.zipWithIndex = LongObjectHashMapTest::zipWithIndex;
            this.payloads.chunk = LongObjectHashMapTest::chunk;
            this.payloads.chunk_throws_negative_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::chunk_throws_negative_size, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_throws_zero_size = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::chunk_throws_zero_size, java.lang.IllegalArgumentException.class);
            this.payloads.aggregateInPlaceBy = LongObjectHashMapTest::aggregateInPlaceBy;
            this.payloads.aggregateBy = LongObjectHashMapTest::aggregateBy;
            this.payloads.groupBy = LongObjectHashMapTest::groupBy;
            this.payloads.groupByEach = LongObjectHashMapTest::groupByEach;
            this.payloads.groupByUniqueKey = LongObjectHashMapTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::groupByUniqueKey_throws, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = LongObjectHashMapTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_1 = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::groupByUniqueKey_target_throws_1, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_2 = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::groupByUniqueKey_target_throws_2, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target_throws_3 = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::groupByUniqueKey_target_throws_3, java.lang.IllegalStateException.class);
            this.payloads.makeString = LongObjectHashMapTest::makeString;
            this.payloads.appendString = LongObjectHashMapTest::appendString;
            this.payloads.tap = LongObjectHashMapTest::tap;
            this.payloads.forEach = LongObjectHashMapTest::forEach;
            this.payloads.forEachWithIndex = LongObjectHashMapTest::forEachWithIndex;
            this.payloads.forEachWith = LongObjectHashMapTest::forEachWith;
            this.payloads.toImmutable = LongObjectHashMapTest::toImmutable;
            this.payloads.toSortedBag = LongObjectHashMapTest::toSortedBag;
            this.payloads.toSortedBagBy = LongObjectHashMapTest::toSortedBagBy;
            this.payloads.stream = LongObjectHashMapTest::stream;
            this.payloads.parallelStream = LongObjectHashMapTest::parallelStream;
            this.payloads.clear = LongObjectHashMapTest::clear;
            this.payloads.removeKey = LongObjectHashMapTest::removeKey;
            this.payloads.remove = LongObjectHashMapTest::remove;
            this.payloads.put = LongObjectHashMapTest::put;
            this.payloads.putPair = LongObjectHashMapTest::putPair;
            this.payloads.putDuplicateWithRemovedSlot = LongObjectHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.putAll = LongObjectHashMapTest::putAll;
            this.payloads.getIfAbsentPut_Value = LongObjectHashMapTest::getIfAbsentPut_Value;
            this.payloads.getIfAbsentPut_Function = LongObjectHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = LongObjectHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = LongObjectHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = LongObjectHashMapTest::updateValue;
            this.payloads.updateValueWith = LongObjectHashMapTest::updateValueWith;
            this.payloads.freeze = LongObjectHashMapTest::freeze;
            this.payloads.withoutKey = LongObjectHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = LongObjectHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = LongObjectHashMapTest::withAllKeyValues;
            this.payloads.get = LongObjectHashMapTest::get;
            this.payloads.getIfAbsent = LongObjectHashMapTest::getIfAbsent;
            this.payloads.containsKey = LongObjectHashMapTest::containsKey;
            this.payloads.containsValue = LongObjectHashMapTest::containsValue;
            this.payloads.size = LongObjectHashMapTest::size;
            this.payloads.contains = LongObjectHashMapTest::contains;
            this.payloads.iterator = LongObjectHashMapTest::iterator;
            this.payloads.asUnmodifiable = LongObjectHashMapTest::asUnmodifiable;
            this.payloads.asSynchronized = LongObjectHashMapTest::asSynchronized;
            this.payloads.flipUniqueValues = LongObjectHashMapTest::flipUniqueValues;
            this.payloads.defaultInitialCapacity = LongObjectHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = LongObjectHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongObjectHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = LongObjectHashMapTest::newMap;
            this.payloads.newMapWithLongObjectMap = LongObjectHashMapTest::newMapWithLongObjectMap;
            this.payloads.putWithRehash = LongObjectHashMapTest::putWithRehash;
            this.payloads.removeWithRehash = LongObjectHashMapTest::removeWithRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValueWith = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnUpdateValueWith;
            this.payloads.occupiedWithDataAndSentinelsOnPut = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = LongObjectHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = LongObjectHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.withKeysValues = LongObjectHashMapTest::withKeysValues;
            this.payloads.put_every_slot = LongObjectHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = LongObjectHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = LongObjectHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = LongObjectHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.updateValue_every_slot = LongObjectHashMapTest::updateValue_every_slot;
            this.payloads.updateValueWith_every_slot = LongObjectHashMapTest::updateValueWith_every_slot;
            this.payloads.classIsNonInstantiable = LongObjectHashMapTest::classIsNonInstantiable;
            this.payloads.sumOfFloatConsistentRounding = LongObjectHashMapTest::sumOfFloatConsistentRounding;
            this.payloads.sumOfDoubleConsistentRounding = LongObjectHashMapTest::sumOfDoubleConsistentRounding;
        }
    }
}
