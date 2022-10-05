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
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharLongHashMapTest extends AbstractMutableCharLongMapTestCase {

    @Override
    protected CharLongHashMap classUnderTest() {
        return CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1) {
        return new CharLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1, char key2, long value2) {
        return new CharLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3) {
        return new CharLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4) {
        return new CharLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharLongHashMap getEmptyMap() {
        return new CharLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((long[]) values.get(hashMap)).length);
        CharLongHashMap hashMap2 = new CharLongHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((long[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        CharLongHashMap hashMap = new CharLongHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (long) i);
        }
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        Field values = CharLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, 10L);
        hashMap.put((char) 11, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        CharLongHashMap hashMap = new CharLongHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, (long) i);
        }
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        Field values = CharLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove((char) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove((char) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L);
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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        LongToLongFunction function = (long longParameter) -> longParameter;
        hashMap.updateValue((char) 2, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((char) 5, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((char) 2, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((char) 2, 9L);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        hashMap.getIfAbsentPut((char) 2, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((char) 5, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((char) 2, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        LongFunction0 function = () -> 5L;
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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        LongFunction<Long> function = Long::longValue;
        hashMap.getIfAbsentPutWith((char) 2, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((char) 5, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((char) 2, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        Assert.assertEquals(2, hashMap.getAndPut((char) 2, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 0, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((char) 0, 5L, 70L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 1, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((char) 1, 11L, 60L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((char) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 2, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        CharToLongFunction function = (char charParameter) -> (long) charParameter;
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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((char) 2, 3L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableCharLongMap copyMap = new CharLongHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (long) i);
        }
        Verify.assertSize(8, copyMap);
        MutableCharLongMap hashMap = new CharLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        CharLongHashMap hashMap0 = new CharLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, 1L, (char) 2, 2L), hashMap0);
        CharLongHashMap hashMap1 = new CharLongHashMap().withKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        CharLongHashMap hashMap2 = new CharLongHashMap().withKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L), hashMap0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L), hashMap1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L), hashMap2);
    }

    @Test
    public void injectInto() {
        CharLongHashMap hashMap = new CharLongHashMap().withKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableCharLongMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((char) i));
            Assert.assertEquals(1L, hashMap.updateValue((char) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((char) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharLongMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharLongHashMapTest instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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
        public void benchmark_longIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new CharLongHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharLongHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = CharLongHashMapTest::keySet;
            this.payloads.values = CharLongHashMapTest::values;
            this.payloads.containsAll = CharLongHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = CharLongHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = CharLongHashMapTest::isEmpty;
            this.payloads.notEmpty = CharLongHashMapTest::notEmpty;
            this.payloads.testEquals = CharLongHashMapTest::testEquals;
            this.payloads.testHashCode = CharLongHashMapTest::testHashCode;
            this.payloads.testToString = CharLongHashMapTest::testToString;
            this.payloads.forEach = CharLongHashMapTest::forEach;
            this.payloads.forEachValue = CharLongHashMapTest::forEachValue;
            this.payloads.forEachKey = CharLongHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = CharLongHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = CharLongHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = CharLongHashMapTest::makeString;
            this.payloads.appendString = CharLongHashMapTest::appendString;
            this.payloads.select = CharLongHashMapTest::select;
            this.payloads.reject = CharLongHashMapTest::reject;
            this.payloads.select_value = CharLongHashMapTest::select_value;
            this.payloads.reject_value = CharLongHashMapTest::reject_value;
            this.payloads.collect = CharLongHashMapTest::collect;
            this.payloads.count = CharLongHashMapTest::count;
            this.payloads.detectIfNone_value = CharLongHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = CharLongHashMapTest::anySatisfy;
            this.payloads.allSatisfy = CharLongHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = CharLongHashMapTest::noneSatisfy;
            this.payloads.max = CharLongHashMapTest::max;
            this.payloads.min = CharLongHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharLongHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharLongHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharLongHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharLongHashMapTest::maxIfEmpty;
            this.payloads.sum = CharLongHashMapTest::sum;
            this.payloads.average = CharLongHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharLongHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CharLongHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharLongHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = CharLongHashMapTest::toList;
            this.payloads.toSortedList = CharLongHashMapTest::toSortedList;
            this.payloads.toSet = CharLongHashMapTest::toSet;
            this.payloads.toBag = CharLongHashMapTest::toBag;
            this.payloads.longIterator = CharLongHashMapTest::longIterator;
            this.payloads.asLazy = CharLongHashMapTest::asLazy;
            this.payloads.keysView = CharLongHashMapTest::keysView;
            this.payloads.keyValuesView = CharLongHashMapTest::keyValuesView;
            this.payloads.toSortedArray = CharLongHashMapTest::toSortedArray;
            this.payloads.toArray = CharLongHashMapTest::toArray;
            this.payloads.toImmutable = CharLongHashMapTest::toImmutable;
            this.payloads.chunk = CharLongHashMapTest::chunk;
            this.payloads.get = CharLongHashMapTest::get;
            this.payloads.getOrThrow = CharLongHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = CharLongHashMapTest::getIfAbsent;
            this.payloads.containsKey = CharLongHashMapTest::containsKey;
            this.payloads.containsValue = CharLongHashMapTest::containsValue;
            this.payloads.contains = CharLongHashMapTest::contains;
            this.payloads.size = CharLongHashMapTest::size;
            this.payloads.clear = CharLongHashMapTest::clear;
            this.payloads.removeKey = CharLongHashMapTest::removeKey;
            this.payloads.remove = CharLongHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = CharLongHashMapTest::removeKeyIfAbsent;
            this.payloads.put = CharLongHashMapTest::put;
            this.payloads.getAndPut = CharLongHashMapTest::getAndPut;
            this.payloads.putPair = CharLongHashMapTest::putPair;
            this.payloads.updateValues = CharLongHashMapTest::updateValues;
            this.payloads.addToValue = CharLongHashMapTest::addToValue;
            this.payloads.put_every_slot = CharLongHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = CharLongHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = CharLongHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = CharLongHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = CharLongHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = CharLongHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = CharLongHashMapTest::updateValue;
            this.payloads.freeze = CharLongHashMapTest::freeze;
            this.payloads.withoutKey = CharLongHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = CharLongHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = CharLongHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = CharLongHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = CharLongHashMapTest::asUnmodifiable;
            this.payloads.longIterator_with_remove = CharLongHashMapTest::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = CharLongHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = CharLongHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = CharLongHashMapTest::flipUniqueValues;
            this.payloads.serialize = CharLongHashMapTest::serialize;
            this.payloads.serializeKeySet = CharLongHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = CharLongHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = CharLongHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharLongHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = CharLongHashMapTest::newMap;
            this.payloads.putWithRehash = CharLongHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = CharLongHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = CharLongHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = CharLongHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = CharLongHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = CharLongHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = CharLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = CharLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = CharLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = CharLongHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = CharLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = CharLongHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = CharLongHashMapTest::testPutAll;
            this.payloads.withKeysValues = CharLongHashMapTest::withKeysValues;
            this.payloads.injectInto = CharLongHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = CharLongHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = CharLongHashMapTest::classIsNonInstantiable;
        }
    }
}
