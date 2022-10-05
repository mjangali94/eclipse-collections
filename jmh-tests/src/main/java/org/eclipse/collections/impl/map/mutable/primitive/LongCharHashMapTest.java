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
import org.eclipse.collections.api.block.function.primitive.LongToCharFunction;
import org.eclipse.collections.impl.factory.primitive.LongCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongCharHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongCharHashMapTest extends AbstractMutableLongCharMapTestCase {

    @Override
    protected LongCharHashMap classUnderTest() {
        return LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1) {
        return new LongCharHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1, long key2, char value2) {
        return new LongCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3) {
        return new LongCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4) {
        return new LongCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongCharHashMap getEmptyMap() {
        return new LongCharHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);
        LongCharHashMap hashMap2 = new LongCharHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new LongCharHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongCharHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        LongCharHashMap hashMap = new LongCharHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (char) i);
        }
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        Field values = LongCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, (char) 10);
        hashMap.put(11L, (char) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        LongCharHashMap hashMap = new LongCharHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, (char) i);
        }
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        Field values = LongCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3);
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
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
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
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        CharToCharFunction function = (char charParameter) -> charParameter;
        hashMap.updateValue(2L, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5L, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2L, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2L, (char) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        hashMap.getIfAbsentPut(2L, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5L, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2L, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        CharFunction0 function = () -> (char) 5;
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
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        CharFunction<Character> function = Character::charValue;
        hashMap.getIfAbsentPutWith(2L, function, Character.valueOf((char) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5L, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2L, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Assert.assertEquals(2, hashMap.getAndPut(2L, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0L, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0L, (char) 5, (char) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1L, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1L, (char) 11, (char) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2L);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2L, (char) 5, (char) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        LongToCharFunction function = (long longParameter) -> (char) longParameter;
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
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2L, (char) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableLongCharMap copyMap = new LongCharHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (char) i);
        }
        Verify.assertSize(8, copyMap);
        MutableLongCharMap hashMap = new LongCharHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        LongCharHashMap hashMap0 = new LongCharHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, (char) 1, 2L, (char) 2), hashMap0);
        LongCharHashMap hashMap1 = new LongCharHashMap().withKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        LongCharHashMap hashMap2 = new LongCharHashMap().withKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2), hashMap0);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3), hashMap1);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        LongCharHashMap hashMap = new LongCharHashMap().withKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        MutableLongCharMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((char) 0, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, (char) 0, incrementFunction));
            Assert.assertEquals((char) 1, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongCharMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongCharHashMapTest instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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
        public void benchmark_charIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new LongCharHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> charIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongCharHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = LongCharHashMapTest::keySet;
            this.payloads.values = LongCharHashMapTest::values;
            this.payloads.containsAll = LongCharHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = LongCharHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = LongCharHashMapTest::isEmpty;
            this.payloads.notEmpty = LongCharHashMapTest::notEmpty;
            this.payloads.testEquals = LongCharHashMapTest::testEquals;
            this.payloads.testHashCode = LongCharHashMapTest::testHashCode;
            this.payloads.testToString = LongCharHashMapTest::testToString;
            this.payloads.forEach = LongCharHashMapTest::forEach;
            this.payloads.forEachValue = LongCharHashMapTest::forEachValue;
            this.payloads.forEachKey = LongCharHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = LongCharHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = LongCharHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = LongCharHashMapTest::makeString;
            this.payloads.appendString = LongCharHashMapTest::appendString;
            this.payloads.select = LongCharHashMapTest::select;
            this.payloads.reject = LongCharHashMapTest::reject;
            this.payloads.select_value = LongCharHashMapTest::select_value;
            this.payloads.reject_value = LongCharHashMapTest::reject_value;
            this.payloads.collect = LongCharHashMapTest::collect;
            this.payloads.count = LongCharHashMapTest::count;
            this.payloads.detectIfNone_value = LongCharHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = LongCharHashMapTest::anySatisfy;
            this.payloads.allSatisfy = LongCharHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = LongCharHashMapTest::noneSatisfy;
            this.payloads.max = LongCharHashMapTest::max;
            this.payloads.min = LongCharHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongCharHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongCharHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongCharHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongCharHashMapTest::maxIfEmpty;
            this.payloads.sum = LongCharHashMapTest::sum;
            this.payloads.average = LongCharHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongCharHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LongCharHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongCharHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = LongCharHashMapTest::toList;
            this.payloads.toSortedList = LongCharHashMapTest::toSortedList;
            this.payloads.toSet = LongCharHashMapTest::toSet;
            this.payloads.toBag = LongCharHashMapTest::toBag;
            this.payloads.charIterator = LongCharHashMapTest::charIterator;
            this.payloads.asLazy = LongCharHashMapTest::asLazy;
            this.payloads.keysView = LongCharHashMapTest::keysView;
            this.payloads.keyValuesView = LongCharHashMapTest::keyValuesView;
            this.payloads.toSortedArray = LongCharHashMapTest::toSortedArray;
            this.payloads.toArray = LongCharHashMapTest::toArray;
            this.payloads.toImmutable = LongCharHashMapTest::toImmutable;
            this.payloads.chunk = LongCharHashMapTest::chunk;
            this.payloads.get = LongCharHashMapTest::get;
            this.payloads.getOrThrow = LongCharHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = LongCharHashMapTest::getIfAbsent;
            this.payloads.containsKey = LongCharHashMapTest::containsKey;
            this.payloads.containsValue = LongCharHashMapTest::containsValue;
            this.payloads.contains = LongCharHashMapTest::contains;
            this.payloads.size = LongCharHashMapTest::size;
            this.payloads.clear = LongCharHashMapTest::clear;
            this.payloads.removeKey = LongCharHashMapTest::removeKey;
            this.payloads.remove = LongCharHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = LongCharHashMapTest::removeKeyIfAbsent;
            this.payloads.put = LongCharHashMapTest::put;
            this.payloads.getAndPut = LongCharHashMapTest::getAndPut;
            this.payloads.putPair = LongCharHashMapTest::putPair;
            this.payloads.updateValues = LongCharHashMapTest::updateValues;
            this.payloads.addToValue = LongCharHashMapTest::addToValue;
            this.payloads.put_every_slot = LongCharHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = LongCharHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = LongCharHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = LongCharHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = LongCharHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = LongCharHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = LongCharHashMapTest::updateValue;
            this.payloads.freeze = LongCharHashMapTest::freeze;
            this.payloads.withoutKey = LongCharHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = LongCharHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = LongCharHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = LongCharHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = LongCharHashMapTest::asUnmodifiable;
            this.payloads.charIterator_with_remove = LongCharHashMapTest::charIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = LongCharHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = LongCharHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = LongCharHashMapTest::flipUniqueValues;
            this.payloads.serialize = LongCharHashMapTest::serialize;
            this.payloads.serializeKeySet = LongCharHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = LongCharHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = LongCharHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongCharHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = LongCharHashMapTest::newMap;
            this.payloads.putWithRehash = LongCharHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = LongCharHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = LongCharHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = LongCharHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = LongCharHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = LongCharHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = LongCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = LongCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = LongCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = LongCharHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = LongCharHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = LongCharHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = LongCharHashMapTest::testPutAll;
            this.payloads.withKeysValues = LongCharHashMapTest::withKeysValues;
            this.payloads.injectInto = LongCharHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = LongCharHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = LongCharHashMapTest::classIsNonInstantiable;
        }
    }
}
