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
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteFloatHashMapTest extends AbstractMutableByteFloatMapTestCase {

    @Override
    protected ByteFloatHashMap classUnderTest() {
        return ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1) {
        return new ByteFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2) {
        return new ByteFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3) {
        return new ByteFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3, byte key4, float value4) {
        return new ByteFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteFloatHashMap getEmptyMap() {
        return new ByteFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);
        ByteFloatHashMap hashMap2 = new ByteFloatHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ByteFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (float) i);
        }
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, 10.0f);
        hashMap.put((byte) 11, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (float) i);
        }
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f);
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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        FloatToFloatFunction function = (float floatParameter) -> floatParameter;
        hashMap.updateValue((byte) 2, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((byte) 5, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((byte) 2, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((byte) 2, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        hashMap.getIfAbsentPut((byte) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((byte) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((byte) 2, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        FloatFunction0 function = () -> 5.0f;
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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        FloatFunction<Float> function = Float::floatValue;
        hashMap.getIfAbsentPutWith((byte) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((byte) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((byte) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        Assert.assertEquals(2, hashMap.getAndPut((byte) 2, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 0, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 0, 5.0f, 70.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 1, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 1, 11.0f, 60.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((byte) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 2, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        ByteToFloatFunction function = (byte byteParameter) -> (float) byteParameter;
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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((byte) 2, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableByteFloatMap copyMap = new ByteFloatHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (float) i);
        }
        Verify.assertSize(8, copyMap);
        MutableByteFloatMap hashMap = new ByteFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ByteFloatHashMap hashMap0 = new ByteFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f), hashMap0);
        ByteFloatHashMap hashMap1 = new ByteFloatHashMap().withKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f);
        ByteFloatHashMap hashMap2 = new ByteFloatHashMap().withKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f), hashMap0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f), hashMap1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f), hashMap2);
    }

    @Test
    public void injectInto() {
        ByteFloatHashMap hashMap = new ByteFloatHashMap().withKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableByteFloatMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((byte) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((byte) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteFloatMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteFloatHashMapTest instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ByteFloatHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteFloatHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ByteFloatHashMapTest::keySet;
            this.payloads.values = ByteFloatHashMapTest::values;
            this.payloads.containsAll = ByteFloatHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ByteFloatHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ByteFloatHashMapTest::isEmpty;
            this.payloads.notEmpty = ByteFloatHashMapTest::notEmpty;
            this.payloads.testEquals = ByteFloatHashMapTest::testEquals;
            this.payloads.testHashCode = ByteFloatHashMapTest::testHashCode;
            this.payloads.testToString = ByteFloatHashMapTest::testToString;
            this.payloads.forEach = ByteFloatHashMapTest::forEach;
            this.payloads.forEachValue = ByteFloatHashMapTest::forEachValue;
            this.payloads.forEachKey = ByteFloatHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ByteFloatHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ByteFloatHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ByteFloatHashMapTest::makeString;
            this.payloads.appendString = ByteFloatHashMapTest::appendString;
            this.payloads.select = ByteFloatHashMapTest::select;
            this.payloads.reject = ByteFloatHashMapTest::reject;
            this.payloads.select_value = ByteFloatHashMapTest::select_value;
            this.payloads.reject_value = ByteFloatHashMapTest::reject_value;
            this.payloads.collect = ByteFloatHashMapTest::collect;
            this.payloads.count = ByteFloatHashMapTest::count;
            this.payloads.detectIfNone_value = ByteFloatHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ByteFloatHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ByteFloatHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ByteFloatHashMapTest::noneSatisfy;
            this.payloads.max = ByteFloatHashMapTest::max;
            this.payloads.min = ByteFloatHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteFloatHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteFloatHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteFloatHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteFloatHashMapTest::maxIfEmpty;
            this.payloads.sum = ByteFloatHashMapTest::sum;
            this.payloads.average = ByteFloatHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteFloatHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ByteFloatHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteFloatHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ByteFloatHashMapTest::toList;
            this.payloads.toSortedList = ByteFloatHashMapTest::toSortedList;
            this.payloads.toSet = ByteFloatHashMapTest::toSet;
            this.payloads.toBag = ByteFloatHashMapTest::toBag;
            this.payloads.floatIterator = ByteFloatHashMapTest::floatIterator;
            this.payloads.asLazy = ByteFloatHashMapTest::asLazy;
            this.payloads.keysView = ByteFloatHashMapTest::keysView;
            this.payloads.keyValuesView = ByteFloatHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ByteFloatHashMapTest::toSortedArray;
            this.payloads.toArray = ByteFloatHashMapTest::toArray;
            this.payloads.toImmutable = ByteFloatHashMapTest::toImmutable;
            this.payloads.chunk = ByteFloatHashMapTest::chunk;
            this.payloads.get = ByteFloatHashMapTest::get;
            this.payloads.getOrThrow = ByteFloatHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ByteFloatHashMapTest::getIfAbsent;
            this.payloads.containsKey = ByteFloatHashMapTest::containsKey;
            this.payloads.containsValue = ByteFloatHashMapTest::containsValue;
            this.payloads.contains = ByteFloatHashMapTest::contains;
            this.payloads.size = ByteFloatHashMapTest::size;
            this.payloads.clear = ByteFloatHashMapTest::clear;
            this.payloads.removeKey = ByteFloatHashMapTest::removeKey;
            this.payloads.remove = ByteFloatHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = ByteFloatHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ByteFloatHashMapTest::put;
            this.payloads.getAndPut = ByteFloatHashMapTest::getAndPut;
            this.payloads.putPair = ByteFloatHashMapTest::putPair;
            this.payloads.updateValues = ByteFloatHashMapTest::updateValues;
            this.payloads.addToValue = ByteFloatHashMapTest::addToValue;
            this.payloads.put_every_slot = ByteFloatHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = ByteFloatHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = ByteFloatHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ByteFloatHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ByteFloatHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ByteFloatHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ByteFloatHashMapTest::updateValue;
            this.payloads.freeze = ByteFloatHashMapTest::freeze;
            this.payloads.withoutKey = ByteFloatHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ByteFloatHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ByteFloatHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ByteFloatHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteFloatHashMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = ByteFloatHashMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ByteFloatHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ByteFloatHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = ByteFloatHashMapTest::flipUniqueValues;
            this.payloads.serialize = ByteFloatHashMapTest::serialize;
            this.payloads.serializeKeySet = ByteFloatHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = ByteFloatHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ByteFloatHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteFloatHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ByteFloatHashMapTest::newMap;
            this.payloads.putWithRehash = ByteFloatHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = ByteFloatHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = ByteFloatHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ByteFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ByteFloatHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = ByteFloatHashMapTest::testPutAll;
            this.payloads.withKeysValues = ByteFloatHashMapTest::withKeysValues;
            this.payloads.injectInto = ByteFloatHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = ByteFloatHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ByteFloatHashMapTest::classIsNonInstantiable;
        }
    }
}
