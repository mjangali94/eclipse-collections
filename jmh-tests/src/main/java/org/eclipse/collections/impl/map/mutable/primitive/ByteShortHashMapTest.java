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
import org.eclipse.collections.api.block.function.primitive.ByteToShortFunction;
import org.eclipse.collections.impl.factory.primitive.ByteShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteShortHashMapTest extends AbstractMutableByteShortMapTestCase {

    @Override
    protected ByteShortHashMap classUnderTest() {
        return ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1) {
        return new ByteShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2) {
        return new ByteShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3) {
        return new ByteShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4) {
        return new ByteShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteShortHashMap getEmptyMap() {
        return new ByteShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);
        ByteShortHashMap hashMap2 = new ByteShortHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ByteShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ByteShortHashMap hashMap = new ByteShortHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (short) i);
        }
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, (short) 10);
        hashMap.put((byte) 11, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        ByteShortHashMap hashMap = new ByteShortHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (short) i);
        }
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove((byte) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove((byte) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ShortToShortFunction function = (short shortParameter) -> shortParameter;
        hashMap.updateValue((byte) 2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((byte) 5, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((byte) 2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((byte) 2, (short) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        hashMap.getIfAbsentPut((byte) 2, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((byte) 5, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((byte) 2, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        ShortFunction0 function = () -> (short) 5;
        hashMap.getIfAbsentPut((byte) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((byte) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((byte) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        ShortFunction<Short> function = Short::shortValue;
        hashMap.getIfAbsentPutWith((byte) 2, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((byte) 5, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((byte) 2, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        Assert.assertEquals(2, hashMap.getAndPut((byte) 2, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 0, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 0, (short) 5, (short) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 1, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 1, (short) 11, (short) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((byte) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 2, (short) 5, (short) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        ByteToShortFunction function = (byte byteParameter) -> (short) byteParameter;
        hashMap.getIfAbsentPutWithKey((byte) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey((byte) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey((byte) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((byte) 2, (short) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableByteShortMap copyMap = new ByteShortHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (short) i);
        }
        Verify.assertSize(8, copyMap);
        MutableByteShortMap hashMap = new ByteShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ByteShortHashMap hashMap0 = new ByteShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2), hashMap0);
        ByteShortHashMap hashMap1 = new ByteShortHashMap().withKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3);
        ByteShortHashMap hashMap2 = new ByteShortHashMap().withKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2), hashMap0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3), hashMap1);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        ByteShortHashMap hashMap = new ByteShortHashMap().withKeysValues((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        MutableByteShortMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((short) 0, hashMap.get((byte) i));
            Assert.assertEquals(1L, hashMap.updateValue((byte) i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get((byte) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteShortMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteShortHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ByteShortHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteShortHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ByteShortHashMapTest::keySet;
            this.payloads.values = ByteShortHashMapTest::values;
            this.payloads.containsAll = ByteShortHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ByteShortHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ByteShortHashMapTest::isEmpty;
            this.payloads.notEmpty = ByteShortHashMapTest::notEmpty;
            this.payloads.testEquals = ByteShortHashMapTest::testEquals;
            this.payloads.testHashCode = ByteShortHashMapTest::testHashCode;
            this.payloads.testToString = ByteShortHashMapTest::testToString;
            this.payloads.forEach = ByteShortHashMapTest::forEach;
            this.payloads.forEachValue = ByteShortHashMapTest::forEachValue;
            this.payloads.forEachKey = ByteShortHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ByteShortHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ByteShortHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ByteShortHashMapTest::makeString;
            this.payloads.appendString = ByteShortHashMapTest::appendString;
            this.payloads.select = ByteShortHashMapTest::select;
            this.payloads.reject = ByteShortHashMapTest::reject;
            this.payloads.select_value = ByteShortHashMapTest::select_value;
            this.payloads.reject_value = ByteShortHashMapTest::reject_value;
            this.payloads.collect = ByteShortHashMapTest::collect;
            this.payloads.count = ByteShortHashMapTest::count;
            this.payloads.detectIfNone_value = ByteShortHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ByteShortHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ByteShortHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ByteShortHashMapTest::noneSatisfy;
            this.payloads.max = ByteShortHashMapTest::max;
            this.payloads.min = ByteShortHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteShortHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteShortHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteShortHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteShortHashMapTest::maxIfEmpty;
            this.payloads.sum = ByteShortHashMapTest::sum;
            this.payloads.average = ByteShortHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteShortHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ByteShortHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteShortHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ByteShortHashMapTest::toList;
            this.payloads.toSortedList = ByteShortHashMapTest::toSortedList;
            this.payloads.toSet = ByteShortHashMapTest::toSet;
            this.payloads.toBag = ByteShortHashMapTest::toBag;
            this.payloads.shortIterator = ByteShortHashMapTest::shortIterator;
            this.payloads.asLazy = ByteShortHashMapTest::asLazy;
            this.payloads.keysView = ByteShortHashMapTest::keysView;
            this.payloads.keyValuesView = ByteShortHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ByteShortHashMapTest::toSortedArray;
            this.payloads.toArray = ByteShortHashMapTest::toArray;
            this.payloads.toImmutable = ByteShortHashMapTest::toImmutable;
            this.payloads.chunk = ByteShortHashMapTest::chunk;
            this.payloads.get = ByteShortHashMapTest::get;
            this.payloads.getOrThrow = ByteShortHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ByteShortHashMapTest::getIfAbsent;
            this.payloads.containsKey = ByteShortHashMapTest::containsKey;
            this.payloads.containsValue = ByteShortHashMapTest::containsValue;
            this.payloads.contains = ByteShortHashMapTest::contains;
            this.payloads.size = ByteShortHashMapTest::size;
            this.payloads.clear = ByteShortHashMapTest::clear;
            this.payloads.removeKey = ByteShortHashMapTest::removeKey;
            this.payloads.remove = ByteShortHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = ByteShortHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ByteShortHashMapTest::put;
            this.payloads.getAndPut = ByteShortHashMapTest::getAndPut;
            this.payloads.putPair = ByteShortHashMapTest::putPair;
            this.payloads.updateValues = ByteShortHashMapTest::updateValues;
            this.payloads.addToValue = ByteShortHashMapTest::addToValue;
            this.payloads.put_every_slot = ByteShortHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = ByteShortHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = ByteShortHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ByteShortHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ByteShortHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ByteShortHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ByteShortHashMapTest::updateValue;
            this.payloads.freeze = ByteShortHashMapTest::freeze;
            this.payloads.withoutKey = ByteShortHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ByteShortHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ByteShortHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ByteShortHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteShortHashMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = ByteShortHashMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ByteShortHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ByteShortHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = ByteShortHashMapTest::flipUniqueValues;
            this.payloads.serialize = ByteShortHashMapTest::serialize;
            this.payloads.serializeKeySet = ByteShortHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = ByteShortHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ByteShortHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteShortHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ByteShortHashMapTest::newMap;
            this.payloads.putWithRehash = ByteShortHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = ByteShortHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = ByteShortHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ByteShortHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ByteShortHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = ByteShortHashMapTest::testPutAll;
            this.payloads.withKeysValues = ByteShortHashMapTest::withKeysValues;
            this.payloads.injectInto = ByteShortHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = ByteShortHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ByteShortHashMapTest::classIsNonInstantiable;
        }
    }
}
