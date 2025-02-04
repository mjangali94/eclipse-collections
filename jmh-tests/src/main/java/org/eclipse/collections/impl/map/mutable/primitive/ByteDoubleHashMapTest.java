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
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteDoubleHashMapTest extends AbstractMutableByteDoubleMapTestCase {

    @Override
    protected ByteDoubleHashMap classUnderTest() {
        return ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1) {
        return new ByteDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2) {
        return new ByteDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3) {
        return new ByteDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4) {
        return new ByteDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteDoubleHashMap getEmptyMap() {
        return new ByteDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);
        ByteDoubleHashMap hashMap2 = new ByteDoubleHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ByteDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (double) i);
        }
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, 10.0);
        hashMap.put((byte) 11, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (double) i);
        }
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0);
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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;
        hashMap.updateValue((byte) 2, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((byte) 5, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((byte) 2, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((byte) 2, 9.0);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        hashMap.getIfAbsentPut((byte) 2, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((byte) 5, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((byte) 2, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        DoubleFunction0 function = () -> 5.0;
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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        DoubleFunction<Double> function = Double::doubleValue;
        hashMap.getIfAbsentPutWith((byte) 2, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((byte) 5, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((byte) 2, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        Assert.assertEquals(2, hashMap.getAndPut((byte) 2, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 0, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 0, 5.0, 70.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 1, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 1, 11.0, 60.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((byte) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 2, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        ByteToDoubleFunction function = (byte byteParameter) -> (double) byteParameter;
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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((byte) 2, 3.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableByteDoubleMap copyMap = new ByteDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (double) i);
        }
        Verify.assertSize(8, copyMap);
        MutableByteDoubleMap hashMap = new ByteDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ByteDoubleHashMap hashMap0 = new ByteDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, 1.0, (byte) 2, 2.0), hashMap0);
        ByteDoubleHashMap hashMap1 = new ByteDoubleHashMap().withKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        ByteDoubleHashMap hashMap2 = new ByteDoubleHashMap().withKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0), hashMap0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0), hashMap1);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0), hashMap2);
    }

    @Test
    public void injectInto() {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap().withKeysValues((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableByteDoubleMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((byte) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((byte) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteDoubleMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteDoubleHashMapTest instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ByteDoubleHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteDoubleHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ByteDoubleHashMapTest::keySet;
            this.payloads.values = ByteDoubleHashMapTest::values;
            this.payloads.containsAll = ByteDoubleHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ByteDoubleHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ByteDoubleHashMapTest::isEmpty;
            this.payloads.notEmpty = ByteDoubleHashMapTest::notEmpty;
            this.payloads.testEquals = ByteDoubleHashMapTest::testEquals;
            this.payloads.testHashCode = ByteDoubleHashMapTest::testHashCode;
            this.payloads.testToString = ByteDoubleHashMapTest::testToString;
            this.payloads.forEach = ByteDoubleHashMapTest::forEach;
            this.payloads.forEachValue = ByteDoubleHashMapTest::forEachValue;
            this.payloads.forEachKey = ByteDoubleHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ByteDoubleHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ByteDoubleHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ByteDoubleHashMapTest::makeString;
            this.payloads.appendString = ByteDoubleHashMapTest::appendString;
            this.payloads.select = ByteDoubleHashMapTest::select;
            this.payloads.reject = ByteDoubleHashMapTest::reject;
            this.payloads.select_value = ByteDoubleHashMapTest::select_value;
            this.payloads.reject_value = ByteDoubleHashMapTest::reject_value;
            this.payloads.collect = ByteDoubleHashMapTest::collect;
            this.payloads.count = ByteDoubleHashMapTest::count;
            this.payloads.detectIfNone_value = ByteDoubleHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ByteDoubleHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ByteDoubleHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ByteDoubleHashMapTest::noneSatisfy;
            this.payloads.max = ByteDoubleHashMapTest::max;
            this.payloads.min = ByteDoubleHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteDoubleHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteDoubleHashMapTest::maxIfEmpty;
            this.payloads.sum = ByteDoubleHashMapTest::sum;
            this.payloads.average = ByteDoubleHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ByteDoubleHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ByteDoubleHashMapTest::toList;
            this.payloads.toSortedList = ByteDoubleHashMapTest::toSortedList;
            this.payloads.toSet = ByteDoubleHashMapTest::toSet;
            this.payloads.toBag = ByteDoubleHashMapTest::toBag;
            this.payloads.doubleIterator = ByteDoubleHashMapTest::doubleIterator;
            this.payloads.asLazy = ByteDoubleHashMapTest::asLazy;
            this.payloads.keysView = ByteDoubleHashMapTest::keysView;
            this.payloads.keyValuesView = ByteDoubleHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ByteDoubleHashMapTest::toSortedArray;
            this.payloads.toArray = ByteDoubleHashMapTest::toArray;
            this.payloads.toImmutable = ByteDoubleHashMapTest::toImmutable;
            this.payloads.chunk = ByteDoubleHashMapTest::chunk;
            this.payloads.get = ByteDoubleHashMapTest::get;
            this.payloads.getOrThrow = ByteDoubleHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ByteDoubleHashMapTest::getIfAbsent;
            this.payloads.containsKey = ByteDoubleHashMapTest::containsKey;
            this.payloads.containsValue = ByteDoubleHashMapTest::containsValue;
            this.payloads.contains = ByteDoubleHashMapTest::contains;
            this.payloads.size = ByteDoubleHashMapTest::size;
            this.payloads.clear = ByteDoubleHashMapTest::clear;
            this.payloads.removeKey = ByteDoubleHashMapTest::removeKey;
            this.payloads.remove = ByteDoubleHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = ByteDoubleHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ByteDoubleHashMapTest::put;
            this.payloads.getAndPut = ByteDoubleHashMapTest::getAndPut;
            this.payloads.putPair = ByteDoubleHashMapTest::putPair;
            this.payloads.updateValues = ByteDoubleHashMapTest::updateValues;
            this.payloads.addToValue = ByteDoubleHashMapTest::addToValue;
            this.payloads.put_every_slot = ByteDoubleHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = ByteDoubleHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = ByteDoubleHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ByteDoubleHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ByteDoubleHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ByteDoubleHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ByteDoubleHashMapTest::updateValue;
            this.payloads.freeze = ByteDoubleHashMapTest::freeze;
            this.payloads.withoutKey = ByteDoubleHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ByteDoubleHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ByteDoubleHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ByteDoubleHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteDoubleHashMapTest::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = ByteDoubleHashMapTest::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ByteDoubleHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ByteDoubleHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = ByteDoubleHashMapTest::flipUniqueValues;
            this.payloads.serialize = ByteDoubleHashMapTest::serialize;
            this.payloads.serializeKeySet = ByteDoubleHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = ByteDoubleHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ByteDoubleHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteDoubleHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ByteDoubleHashMapTest::newMap;
            this.payloads.putWithRehash = ByteDoubleHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = ByteDoubleHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ByteDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ByteDoubleHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = ByteDoubleHashMapTest::testPutAll;
            this.payloads.withKeysValues = ByteDoubleHashMapTest::withKeysValues;
            this.payloads.injectInto = ByteDoubleHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = ByteDoubleHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ByteDoubleHashMapTest::classIsNonInstantiable;
        }
    }
}
