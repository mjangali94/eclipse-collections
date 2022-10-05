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

import java.lang.reflect.Field;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToShortFunction;
import org.eclipse.collections.impl.factory.primitive.FloatShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableFloatShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class FloatShortHashMapTest extends AbstractMutableFloatShortMapTestCase {

    @Override
    protected FloatShortHashMap classUnderTest() {
        return FloatShortHashMap.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32);
    }

    @Override
    protected FloatShortHashMap newWithKeysValues(float key1, short value1) {
        return new FloatShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatShortHashMap newWithKeysValues(float key1, short value1, float key2, short value2) {
        return new FloatShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatShortHashMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3) {
        return new FloatShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatShortHashMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3, float key4, short value4) {
        return new FloatShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatShortHashMap getEmptyMap() {
        return new FloatShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = FloatShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatShortHashMap hashMap = new FloatShortHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = FloatShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatShortHashMap hashMap = new FloatShortHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);
        FloatShortHashMap hashMap2 = new FloatShortHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new FloatShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = FloatShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatShortHashMap hashMap = new FloatShortHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        FloatShortHashMap hashMap = new FloatShortHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (short) i);
        }
        Field keys = FloatShortHashMap.class.getDeclaredField("keys");
        Field values = FloatShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0f, (short) 10);
        hashMap.put(11.0f, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        FloatShortHashMap hashMap = new FloatShortHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (short) i);
        }
        Field keys = FloatShortHashMap.class.getDeclaredField("keys");
        Field values = FloatShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ShortToShortFunction function = (short shortParameter) -> shortParameter;
        hashMap.updateValue(2.0f, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = new FloatShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, (short) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        hashMap.getIfAbsentPut(2.0f, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        ShortFunction0 function = () -> (short) 5;
        hashMap.getIfAbsentPut(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        ShortFunction<Short> function = Short::shortValue;
        hashMap.getIfAbsentPutWith(2.0f, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0f, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0f, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        Assert.assertEquals(2, hashMap.getAndPut(2.0f, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0f, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0f, (short) 5, (short) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0f, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0f, (short) 11, (short) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0f);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0f, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = FloatShortHashMap.newWithKeysValues(2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        FloatToShortFunction function = (float floatParameter) -> (short) floatParameter;
        hashMap.getIfAbsentPutWithKey(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey(2.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = FloatShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatShortHashMap hashMap = new FloatShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, (short) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableFloatShortMap copyMap = new FloatShortHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((float) i));
            copyMap.put((float) i, (short) i);
        }
        Verify.assertSize(8, copyMap);
        MutableFloatShortMap hashMap = new FloatShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        FloatShortHashMap hashMap0 = new FloatShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, (short) 1, 2.0f, (short) 2), hashMap0);
        FloatShortHashMap hashMap1 = new FloatShortHashMap().withKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3);
        FloatShortHashMap hashMap2 = new FloatShortHashMap().withKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2), hashMap0);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3), hashMap1);
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        FloatShortHashMap hashMap = new FloatShortHashMap().withKeysValues(1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableFloatShortMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((float) i));
            Assert.assertEquals(1L, hashMap.updateValue((float) i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get((float) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatShortMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatShortHashMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
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
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithoutRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithoutRehash);
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
        public void benchmark_occupiedWithDataAndSentinelsGetAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsGetAndPut);
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
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new FloatShortHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatShortHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = FloatShortHashMapTest::keySet;
            this.payloads.values = FloatShortHashMapTest::values;
            this.payloads.containsAll = FloatShortHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = FloatShortHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = FloatShortHashMapTest::isEmpty;
            this.payloads.notEmpty = FloatShortHashMapTest::notEmpty;
            this.payloads.testEquals = FloatShortHashMapTest::testEquals;
            this.payloads.testHashCode = FloatShortHashMapTest::testHashCode;
            this.payloads.testToString = FloatShortHashMapTest::testToString;
            this.payloads.forEach = FloatShortHashMapTest::forEach;
            this.payloads.forEachValue = FloatShortHashMapTest::forEachValue;
            this.payloads.forEachKey = FloatShortHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = FloatShortHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = FloatShortHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = FloatShortHashMapTest::makeString;
            this.payloads.appendString = FloatShortHashMapTest::appendString;
            this.payloads.select = FloatShortHashMapTest::select;
            this.payloads.reject = FloatShortHashMapTest::reject;
            this.payloads.select_value = FloatShortHashMapTest::select_value;
            this.payloads.reject_value = FloatShortHashMapTest::reject_value;
            this.payloads.collect = FloatShortHashMapTest::collect;
            this.payloads.count = FloatShortHashMapTest::count;
            this.payloads.detectIfNone_value = FloatShortHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = FloatShortHashMapTest::anySatisfy;
            this.payloads.allSatisfy = FloatShortHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = FloatShortHashMapTest::noneSatisfy;
            this.payloads.max = FloatShortHashMapTest::max;
            this.payloads.min = FloatShortHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatShortHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatShortHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatShortHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatShortHashMapTest::maxIfEmpty;
            this.payloads.sum = FloatShortHashMapTest::sum;
            this.payloads.average = FloatShortHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatShortHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = FloatShortHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatShortHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = FloatShortHashMapTest::toList;
            this.payloads.toSortedList = FloatShortHashMapTest::toSortedList;
            this.payloads.toSet = FloatShortHashMapTest::toSet;
            this.payloads.toBag = FloatShortHashMapTest::toBag;
            this.payloads.shortIterator = FloatShortHashMapTest::shortIterator;
            this.payloads.asLazy = FloatShortHashMapTest::asLazy;
            this.payloads.keysView = FloatShortHashMapTest::keysView;
            this.payloads.keyValuesView = FloatShortHashMapTest::keyValuesView;
            this.payloads.toSortedArray = FloatShortHashMapTest::toSortedArray;
            this.payloads.toArray = FloatShortHashMapTest::toArray;
            this.payloads.toImmutable = FloatShortHashMapTest::toImmutable;
            this.payloads.chunk = FloatShortHashMapTest::chunk;
            this.payloads.get = FloatShortHashMapTest::get;
            this.payloads.getOrThrow = FloatShortHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = FloatShortHashMapTest::getIfAbsent;
            this.payloads.containsKey = FloatShortHashMapTest::containsKey;
            this.payloads.containsValue = FloatShortHashMapTest::containsValue;
            this.payloads.contains = FloatShortHashMapTest::contains;
            this.payloads.size = FloatShortHashMapTest::size;
            this.payloads.clear = FloatShortHashMapTest::clear;
            this.payloads.removeKey = FloatShortHashMapTest::removeKey;
            this.payloads.remove = FloatShortHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = FloatShortHashMapTest::removeKeyIfAbsent;
            this.payloads.put = FloatShortHashMapTest::put;
            this.payloads.getAndPut = FloatShortHashMapTest::getAndPut;
            this.payloads.putPair = FloatShortHashMapTest::putPair;
            this.payloads.updateValues = FloatShortHashMapTest::updateValues;
            this.payloads.addToValue = FloatShortHashMapTest::addToValue;
            this.payloads.put_every_slot = FloatShortHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = FloatShortHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = FloatShortHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = FloatShortHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = FloatShortHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = FloatShortHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = FloatShortHashMapTest::updateValue;
            this.payloads.freeze = FloatShortHashMapTest::freeze;
            this.payloads.withoutKey = FloatShortHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = FloatShortHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = FloatShortHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = FloatShortHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatShortHashMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = FloatShortHashMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = FloatShortHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = FloatShortHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = FloatShortHashMapTest::flipUniqueValues;
            this.payloads.serialize = FloatShortHashMapTest::serialize;
            this.payloads.serializeKeySet = FloatShortHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = FloatShortHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = FloatShortHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatShortHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = FloatShortHashMapTest::newMap;
            this.payloads.putWithRehash = FloatShortHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = FloatShortHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = FloatShortHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = FloatShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = FloatShortHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = FloatShortHashMapTest::testPutAll;
            this.payloads.withKeysValues = FloatShortHashMapTest::withKeysValues;
            this.payloads.injectInto = FloatShortHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = FloatShortHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = FloatShortHashMapTest::classIsNonInstantiable;
        }
    }
}
