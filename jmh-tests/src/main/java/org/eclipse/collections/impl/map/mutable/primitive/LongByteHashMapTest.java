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
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.LongToByteFunction;
import org.eclipse.collections.impl.factory.primitive.LongByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongByteHashMapTest extends AbstractMutableLongByteMapTestCase {

    @Override
    protected LongByteHashMap classUnderTest() {
        return LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1) {
        return new LongByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1, long key2, byte value2) {
        return new LongByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3) {
        return new LongByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3, long key4, byte value4) {
        return new LongByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongByteHashMap getEmptyMap() {
        return new LongByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);
        LongByteHashMap hashMap2 = new LongByteHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new LongByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        LongByteHashMap hashMap = new LongByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (byte) i);
        }
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        Field values = LongByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, (byte) 10);
        hashMap.put(11L, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        LongByteHashMap hashMap = new LongByteHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, (byte) i);
        }
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        Field values = LongByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3);
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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ByteToByteFunction function = (byte byteParameter) -> byteParameter;
        hashMap.updateValue(2L, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5L, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2L, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2L, (byte) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        hashMap.getIfAbsentPut(2L, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5L, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2L, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        ByteFunction0 function = () -> (byte) 5;
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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        ByteFunction<Byte> function = Byte::byteValue;
        hashMap.getIfAbsentPutWith(2L, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5L, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2L, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        Assert.assertEquals(2, hashMap.getAndPut(2L, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0L, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0L, (byte) 5, (byte) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1L, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1L, (byte) 11, (byte) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2L);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2L, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        LongToByteFunction function = (long longParameter) -> (byte) longParameter;
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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2L, (byte) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableLongByteMap copyMap = new LongByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (byte) i);
        }
        Verify.assertSize(8, copyMap);
        MutableLongByteMap hashMap = new LongByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        LongByteHashMap hashMap0 = new LongByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, (byte) 1, 2L, (byte) 2), hashMap0);
        LongByteHashMap hashMap1 = new LongByteHashMap().withKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3);
        LongByteHashMap hashMap2 = new LongByteHashMap().withKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2), hashMap0);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3), hashMap1);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        LongByteHashMap hashMap = new LongByteHashMap().withKeysValues(1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableLongByteMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongByteMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongByteHashMapTest instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new LongByteHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongByteHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = LongByteHashMapTest::keySet;
            this.payloads.values = LongByteHashMapTest::values;
            this.payloads.containsAll = LongByteHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = LongByteHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = LongByteHashMapTest::isEmpty;
            this.payloads.notEmpty = LongByteHashMapTest::notEmpty;
            this.payloads.testEquals = LongByteHashMapTest::testEquals;
            this.payloads.testHashCode = LongByteHashMapTest::testHashCode;
            this.payloads.testToString = LongByteHashMapTest::testToString;
            this.payloads.forEach = LongByteHashMapTest::forEach;
            this.payloads.forEachValue = LongByteHashMapTest::forEachValue;
            this.payloads.forEachKey = LongByteHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = LongByteHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = LongByteHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = LongByteHashMapTest::makeString;
            this.payloads.appendString = LongByteHashMapTest::appendString;
            this.payloads.select = LongByteHashMapTest::select;
            this.payloads.reject = LongByteHashMapTest::reject;
            this.payloads.select_value = LongByteHashMapTest::select_value;
            this.payloads.reject_value = LongByteHashMapTest::reject_value;
            this.payloads.collect = LongByteHashMapTest::collect;
            this.payloads.count = LongByteHashMapTest::count;
            this.payloads.detectIfNone_value = LongByteHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = LongByteHashMapTest::anySatisfy;
            this.payloads.allSatisfy = LongByteHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = LongByteHashMapTest::noneSatisfy;
            this.payloads.max = LongByteHashMapTest::max;
            this.payloads.min = LongByteHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongByteHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongByteHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongByteHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongByteHashMapTest::maxIfEmpty;
            this.payloads.sum = LongByteHashMapTest::sum;
            this.payloads.average = LongByteHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongByteHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LongByteHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongByteHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = LongByteHashMapTest::toList;
            this.payloads.toSortedList = LongByteHashMapTest::toSortedList;
            this.payloads.toSet = LongByteHashMapTest::toSet;
            this.payloads.toBag = LongByteHashMapTest::toBag;
            this.payloads.byteIterator = LongByteHashMapTest::byteIterator;
            this.payloads.asLazy = LongByteHashMapTest::asLazy;
            this.payloads.keysView = LongByteHashMapTest::keysView;
            this.payloads.keyValuesView = LongByteHashMapTest::keyValuesView;
            this.payloads.toSortedArray = LongByteHashMapTest::toSortedArray;
            this.payloads.toArray = LongByteHashMapTest::toArray;
            this.payloads.toImmutable = LongByteHashMapTest::toImmutable;
            this.payloads.chunk = LongByteHashMapTest::chunk;
            this.payloads.get = LongByteHashMapTest::get;
            this.payloads.getOrThrow = LongByteHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = LongByteHashMapTest::getIfAbsent;
            this.payloads.containsKey = LongByteHashMapTest::containsKey;
            this.payloads.containsValue = LongByteHashMapTest::containsValue;
            this.payloads.contains = LongByteHashMapTest::contains;
            this.payloads.size = LongByteHashMapTest::size;
            this.payloads.clear = LongByteHashMapTest::clear;
            this.payloads.removeKey = LongByteHashMapTest::removeKey;
            this.payloads.remove = LongByteHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = LongByteHashMapTest::removeKeyIfAbsent;
            this.payloads.put = LongByteHashMapTest::put;
            this.payloads.getAndPut = LongByteHashMapTest::getAndPut;
            this.payloads.putPair = LongByteHashMapTest::putPair;
            this.payloads.updateValues = LongByteHashMapTest::updateValues;
            this.payloads.addToValue = LongByteHashMapTest::addToValue;
            this.payloads.put_every_slot = LongByteHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = LongByteHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = LongByteHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = LongByteHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = LongByteHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = LongByteHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = LongByteHashMapTest::updateValue;
            this.payloads.freeze = LongByteHashMapTest::freeze;
            this.payloads.withoutKey = LongByteHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = LongByteHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = LongByteHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = LongByteHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = LongByteHashMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = LongByteHashMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = LongByteHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = LongByteHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = LongByteHashMapTest::flipUniqueValues;
            this.payloads.serialize = LongByteHashMapTest::serialize;
            this.payloads.serializeKeySet = LongByteHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = LongByteHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = LongByteHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongByteHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = LongByteHashMapTest::newMap;
            this.payloads.putWithRehash = LongByteHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = LongByteHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = LongByteHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = LongByteHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = LongByteHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = LongByteHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = LongByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = LongByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = LongByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = LongByteHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = LongByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = LongByteHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = LongByteHashMapTest::testPutAll;
            this.payloads.withKeysValues = LongByteHashMapTest::withKeysValues;
            this.payloads.injectInto = LongByteHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = LongByteHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = LongByteHashMapTest::classIsNonInstantiable;
        }
    }
}
