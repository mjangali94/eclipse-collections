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
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.impl.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableFloatCharMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatCharHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class FloatCharHashMapTest extends AbstractMutableFloatCharMapTestCase {

    @Override
    protected FloatCharHashMap classUnderTest() {
        return FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1) {
        return new FloatCharHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2) {
        return new FloatCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3) {
        return new FloatCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4) {
        return new FloatCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatCharHashMap getEmptyMap() {
        return new FloatCharHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);
        FloatCharHashMap hashMap2 = new FloatCharHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new FloatCharHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatCharHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (char) i);
        }
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0f, (char) 10);
        hashMap.put(11.0f, (char) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (char) i);
        }
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3);
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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        CharToCharFunction function = (char charParameter) -> charParameter;
        hashMap.updateValue(2.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, (char) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        hashMap.getIfAbsentPut(2.0f, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        CharFunction0 function = () -> (char) 5;
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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        CharFunction<Character> function = Character::charValue;
        hashMap.getIfAbsentPutWith(2.0f, function, Character.valueOf((char) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0f, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0f, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        Assert.assertEquals(2, hashMap.getAndPut(2.0f, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0f, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0f, (char) 5, (char) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0f, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0f, (char) 11, (char) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0f);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0f, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        FloatToCharFunction function = (float floatParameter) -> (char) floatParameter;
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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, (char) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableFloatCharMap copyMap = new FloatCharHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((float) i));
            copyMap.put((float) i, (char) i);
        }
        Verify.assertSize(8, copyMap);
        MutableFloatCharMap hashMap = new FloatCharHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        FloatCharHashMap hashMap0 = new FloatCharHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, (char) 1, 2.0f, (char) 2), hashMap0);
        FloatCharHashMap hashMap1 = new FloatCharHashMap().withKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3);
        FloatCharHashMap hashMap2 = new FloatCharHashMap().withKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2), hashMap0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3), hashMap1);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        FloatCharHashMap hashMap = new FloatCharHashMap().withKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        MutableFloatCharMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((char) 0, hashMap.get((float) i));
            Assert.assertEquals(1L, hashMap.updateValue((float) i, (char) 0, incrementFunction));
            Assert.assertEquals((char) 1, hashMap.get((float) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatCharMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatCharHashMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
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
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeWithoutRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeWithoutRehash);
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
        public void benchmark_occupiedWithDataAndSentinelsGetAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsGetAndPut);
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
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new FloatCharHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatCharHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = FloatCharHashMapTest::keySet;
            this.payloads.values = FloatCharHashMapTest::values;
            this.payloads.containsAll = FloatCharHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = FloatCharHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = FloatCharHashMapTest::isEmpty;
            this.payloads.notEmpty = FloatCharHashMapTest::notEmpty;
            this.payloads.testEquals = FloatCharHashMapTest::testEquals;
            this.payloads.testHashCode = FloatCharHashMapTest::testHashCode;
            this.payloads.testToString = FloatCharHashMapTest::testToString;
            this.payloads.forEach = FloatCharHashMapTest::forEach;
            this.payloads.forEachValue = FloatCharHashMapTest::forEachValue;
            this.payloads.forEachKey = FloatCharHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = FloatCharHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = FloatCharHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = FloatCharHashMapTest::makeString;
            this.payloads.appendString = FloatCharHashMapTest::appendString;
            this.payloads.select = FloatCharHashMapTest::select;
            this.payloads.reject = FloatCharHashMapTest::reject;
            this.payloads.select_value = FloatCharHashMapTest::select_value;
            this.payloads.reject_value = FloatCharHashMapTest::reject_value;
            this.payloads.collect = FloatCharHashMapTest::collect;
            this.payloads.count = FloatCharHashMapTest::count;
            this.payloads.detectIfNone_value = FloatCharHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = FloatCharHashMapTest::anySatisfy;
            this.payloads.allSatisfy = FloatCharHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = FloatCharHashMapTest::noneSatisfy;
            this.payloads.max = FloatCharHashMapTest::max;
            this.payloads.min = FloatCharHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatCharHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatCharHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatCharHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatCharHashMapTest::maxIfEmpty;
            this.payloads.sum = FloatCharHashMapTest::sum;
            this.payloads.average = FloatCharHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatCharHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = FloatCharHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatCharHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = FloatCharHashMapTest::toList;
            this.payloads.toSortedList = FloatCharHashMapTest::toSortedList;
            this.payloads.toSet = FloatCharHashMapTest::toSet;
            this.payloads.toBag = FloatCharHashMapTest::toBag;
            this.payloads.charIterator = FloatCharHashMapTest::charIterator;
            this.payloads.asLazy = FloatCharHashMapTest::asLazy;
            this.payloads.keysView = FloatCharHashMapTest::keysView;
            this.payloads.keyValuesView = FloatCharHashMapTest::keyValuesView;
            this.payloads.toSortedArray = FloatCharHashMapTest::toSortedArray;
            this.payloads.toArray = FloatCharHashMapTest::toArray;
            this.payloads.toImmutable = FloatCharHashMapTest::toImmutable;
            this.payloads.chunk = FloatCharHashMapTest::chunk;
            this.payloads.get = FloatCharHashMapTest::get;
            this.payloads.getOrThrow = FloatCharHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = FloatCharHashMapTest::getIfAbsent;
            this.payloads.containsKey = FloatCharHashMapTest::containsKey;
            this.payloads.containsValue = FloatCharHashMapTest::containsValue;
            this.payloads.contains = FloatCharHashMapTest::contains;
            this.payloads.size = FloatCharHashMapTest::size;
            this.payloads.clear = FloatCharHashMapTest::clear;
            this.payloads.removeKey = FloatCharHashMapTest::removeKey;
            this.payloads.remove = FloatCharHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = FloatCharHashMapTest::removeKeyIfAbsent;
            this.payloads.put = FloatCharHashMapTest::put;
            this.payloads.getAndPut = FloatCharHashMapTest::getAndPut;
            this.payloads.putPair = FloatCharHashMapTest::putPair;
            this.payloads.updateValues = FloatCharHashMapTest::updateValues;
            this.payloads.addToValue = FloatCharHashMapTest::addToValue;
            this.payloads.put_every_slot = FloatCharHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = FloatCharHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = FloatCharHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = FloatCharHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = FloatCharHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = FloatCharHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = FloatCharHashMapTest::updateValue;
            this.payloads.freeze = FloatCharHashMapTest::freeze;
            this.payloads.withoutKey = FloatCharHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = FloatCharHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = FloatCharHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = FloatCharHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatCharHashMapTest::asUnmodifiable;
            this.payloads.charIterator_with_remove = FloatCharHashMapTest::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = FloatCharHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = FloatCharHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = FloatCharHashMapTest::flipUniqueValues;
            this.payloads.serialize = FloatCharHashMapTest::serialize;
            this.payloads.serializeKeySet = FloatCharHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = FloatCharHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = FloatCharHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatCharHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = FloatCharHashMapTest::newMap;
            this.payloads.putWithRehash = FloatCharHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = FloatCharHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = FloatCharHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = FloatCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = FloatCharHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = FloatCharHashMapTest::testPutAll;
            this.payloads.withKeysValues = FloatCharHashMapTest::withKeysValues;
            this.payloads.injectInto = FloatCharHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = FloatCharHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = FloatCharHashMapTest::classIsNonInstantiable;
        }
    }
}
