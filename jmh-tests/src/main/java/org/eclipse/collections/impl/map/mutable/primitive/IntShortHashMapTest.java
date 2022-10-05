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
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.impl.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableIntShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class IntShortHashMapTest extends AbstractMutableIntShortMapTestCase {

    @Override
    protected IntShortHashMap classUnderTest() {
        return IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1) {
        return new IntShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2) {
        return new IntShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3) {
        return new IntShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3, int key4, short value4) {
        return new IntShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntShortHashMap getEmptyMap() {
        return new IntShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap(3);
        Assert.assertEquals(8L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);
        IntShortHashMap hashMap2 = new IntShortHashMap(15);
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new IntShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new IntShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        IntShortHashMap hashMap = new IntShortHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (short) i);
        }
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        Field values = IntShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10, (short) 10);
        hashMap.put(11, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        IntShortHashMap hashMap = new IntShortHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put(i, (short) i);
        }
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        Field values = IntShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ShortToShortFunction function = (short shortParameter) -> shortParameter;
        hashMap.updateValue(2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put(i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2, (short) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        hashMap.getIfAbsentPut(2, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        ShortFunction0 function = () -> (short) 5;
        hashMap.getIfAbsentPut(2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        ShortFunction<Short> function = Short::shortValue;
        hashMap.getIfAbsentPutWith(2, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        Assert.assertEquals(2, hashMap.getAndPut(2, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0, (short) 5, (short) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1, (short) 11, (short) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);
        IntToShortFunction function = (int intParameter) -> (short) intParameter;
        hashMap.getIfAbsentPutWithKey(2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey(5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey(2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2, (short) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableIntShortMap copyMap = new IntShortHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (short) i);
        }
        Verify.assertSize(8, copyMap);
        MutableIntShortMap hashMap = new IntShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        IntShortHashMap hashMap0 = new IntShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1, (short) 1, 2, (short) 2), hashMap0);
        IntShortHashMap hashMap1 = new IntShortHashMap().withKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
        IntShortHashMap hashMap2 = new IntShortHashMap().withKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2), hashMap0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3), hashMap1);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        IntShortHashMap hashMap = new IntShortHashMap().withKeysValues(1, (short) 2, 2, (short) 3, 3, (short) 4, 4, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableIntShortMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get(i));
            Assert.assertEquals(1L, hashMap.updateValue(i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get(i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(IntShortMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntShortHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new IntShortHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntShortHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = IntShortHashMapTest::keySet;
            this.payloads.values = IntShortHashMapTest::values;
            this.payloads.containsAll = IntShortHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = IntShortHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = IntShortHashMapTest::isEmpty;
            this.payloads.notEmpty = IntShortHashMapTest::notEmpty;
            this.payloads.testEquals = IntShortHashMapTest::testEquals;
            this.payloads.testHashCode = IntShortHashMapTest::testHashCode;
            this.payloads.testToString = IntShortHashMapTest::testToString;
            this.payloads.forEach = IntShortHashMapTest::forEach;
            this.payloads.forEachValue = IntShortHashMapTest::forEachValue;
            this.payloads.forEachKey = IntShortHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = IntShortHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = IntShortHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = IntShortHashMapTest::makeString;
            this.payloads.appendString = IntShortHashMapTest::appendString;
            this.payloads.select = IntShortHashMapTest::select;
            this.payloads.reject = IntShortHashMapTest::reject;
            this.payloads.select_value = IntShortHashMapTest::select_value;
            this.payloads.reject_value = IntShortHashMapTest::reject_value;
            this.payloads.collect = IntShortHashMapTest::collect;
            this.payloads.count = IntShortHashMapTest::count;
            this.payloads.detectIfNone_value = IntShortHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = IntShortHashMapTest::anySatisfy;
            this.payloads.allSatisfy = IntShortHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = IntShortHashMapTest::noneSatisfy;
            this.payloads.max = IntShortHashMapTest::max;
            this.payloads.min = IntShortHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntShortHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntShortHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = IntShortHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = IntShortHashMapTest::maxIfEmpty;
            this.payloads.sum = IntShortHashMapTest::sum;
            this.payloads.average = IntShortHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntShortHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = IntShortHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntShortHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = IntShortHashMapTest::toList;
            this.payloads.toSortedList = IntShortHashMapTest::toSortedList;
            this.payloads.toSet = IntShortHashMapTest::toSet;
            this.payloads.toBag = IntShortHashMapTest::toBag;
            this.payloads.shortIterator = IntShortHashMapTest::shortIterator;
            this.payloads.asLazy = IntShortHashMapTest::asLazy;
            this.payloads.keysView = IntShortHashMapTest::keysView;
            this.payloads.keyValuesView = IntShortHashMapTest::keyValuesView;
            this.payloads.toSortedArray = IntShortHashMapTest::toSortedArray;
            this.payloads.toArray = IntShortHashMapTest::toArray;
            this.payloads.toImmutable = IntShortHashMapTest::toImmutable;
            this.payloads.chunk = IntShortHashMapTest::chunk;
            this.payloads.get = IntShortHashMapTest::get;
            this.payloads.getOrThrow = IntShortHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = IntShortHashMapTest::getIfAbsent;
            this.payloads.containsKey = IntShortHashMapTest::containsKey;
            this.payloads.containsValue = IntShortHashMapTest::containsValue;
            this.payloads.contains = IntShortHashMapTest::contains;
            this.payloads.size = IntShortHashMapTest::size;
            this.payloads.clear = IntShortHashMapTest::clear;
            this.payloads.removeKey = IntShortHashMapTest::removeKey;
            this.payloads.remove = IntShortHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = IntShortHashMapTest::removeKeyIfAbsent;
            this.payloads.put = IntShortHashMapTest::put;
            this.payloads.getAndPut = IntShortHashMapTest::getAndPut;
            this.payloads.putPair = IntShortHashMapTest::putPair;
            this.payloads.updateValues = IntShortHashMapTest::updateValues;
            this.payloads.addToValue = IntShortHashMapTest::addToValue;
            this.payloads.put_every_slot = IntShortHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = IntShortHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = IntShortHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = IntShortHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = IntShortHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = IntShortHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = IntShortHashMapTest::updateValue;
            this.payloads.freeze = IntShortHashMapTest::freeze;
            this.payloads.withoutKey = IntShortHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = IntShortHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = IntShortHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = IntShortHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = IntShortHashMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = IntShortHashMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = IntShortHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = IntShortHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = IntShortHashMapTest::flipUniqueValues;
            this.payloads.serialize = IntShortHashMapTest::serialize;
            this.payloads.serializeKeySet = IntShortHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = IntShortHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = IntShortHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntShortHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = IntShortHashMapTest::newMap;
            this.payloads.putWithRehash = IntShortHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = IntShortHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = IntShortHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = IntShortHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = IntShortHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = IntShortHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = IntShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = IntShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = IntShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = IntShortHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = IntShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = IntShortHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = IntShortHashMapTest::testPutAll;
            this.payloads.withKeysValues = IntShortHashMapTest::withKeysValues;
            this.payloads.injectInto = IntShortHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = IntShortHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = IntShortHashMapTest::classIsNonInstantiable;
        }
    }
}
