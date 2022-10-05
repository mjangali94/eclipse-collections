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
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToIntFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleIntHashMapTest extends AbstractMutableDoubleIntMapTestCase {

    @Override
    protected DoubleIntHashMap classUnderTest() {
        return DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32);
    }

    @Override
    protected DoubleIntHashMap newWithKeysValues(double key1, int value1) {
        return new DoubleIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleIntHashMap newWithKeysValues(double key1, int value1, double key2, int value2) {
        return new DoubleIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleIntHashMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3) {
        return new DoubleIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleIntHashMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3, double key4, int value4) {
        return new DoubleIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleIntHashMap getEmptyMap() {
        return new DoubleIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = DoubleIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = DoubleIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleIntHashMap hashMap = new DoubleIntHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);
        DoubleIntHashMap hashMap2 = new DoubleIntHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = DoubleIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, i);
        }
        Field keys = DoubleIntHashMap.class.getDeclaredField("keys");
        Field values = DoubleIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10);
        hashMap.put(11.0, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, i);
        }
        Field keys = DoubleIntHashMap.class.getDeclaredField("keys");
        Field values = DoubleIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        IntToIntFunction function = (int intParameter) -> intParameter;
        hashMap.updateValue(2.0, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0, 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        hashMap.getIfAbsentPut(2.0, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        IntFunction0 function = () -> 5;
        hashMap.getIfAbsentPut(2.0, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        IntFunction<Integer> function = Integer::intValue;
        hashMap.getIfAbsentPutWith(2.0, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        Assert.assertEquals(2, hashMap.getAndPut(2.0, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0, 5, 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0, 11, 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = DoubleIntHashMap.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        DoubleToIntFunction function = (double doubleParameter) -> (int) doubleParameter;
        hashMap.getIfAbsentPutWithKey(2.0, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey(5.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey(2.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = DoubleIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0, 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableDoubleIntMap copyMap = new DoubleIntHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, i);
        }
        Verify.assertSize(8, copyMap);
        MutableDoubleIntMap hashMap = new DoubleIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        DoubleIntHashMap hashMap0 = new DoubleIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1, 2.0, 2), hashMap0);
        DoubleIntHashMap hashMap1 = new DoubleIntHashMap().withKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        DoubleIntHashMap hashMap2 = new DoubleIntHashMap().withKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 4.0, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 2.0, 2), hashMap0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3), hashMap1);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 4.0, 4), hashMap2);
    }

    @Test
    public void injectInto() {
        DoubleIntHashMap hashMap = new DoubleIntHashMap().withKeysValues(1.0, 2, 2.0, 3, 3.0, 4, 4.0, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableDoubleIntMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((double) i));
            Assert.assertEquals(1L, hashMap.updateValue((double) i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get((double) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleIntMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleIntHashMapTest instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleIntHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleIntHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = DoubleIntHashMapTest::keySet;
            this.payloads.values = DoubleIntHashMapTest::values;
            this.payloads.containsAll = DoubleIntHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = DoubleIntHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = DoubleIntHashMapTest::isEmpty;
            this.payloads.notEmpty = DoubleIntHashMapTest::notEmpty;
            this.payloads.testEquals = DoubleIntHashMapTest::testEquals;
            this.payloads.testHashCode = DoubleIntHashMapTest::testHashCode;
            this.payloads.testToString = DoubleIntHashMapTest::testToString;
            this.payloads.forEach = DoubleIntHashMapTest::forEach;
            this.payloads.forEachValue = DoubleIntHashMapTest::forEachValue;
            this.payloads.forEachKey = DoubleIntHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = DoubleIntHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = DoubleIntHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = DoubleIntHashMapTest::makeString;
            this.payloads.appendString = DoubleIntHashMapTest::appendString;
            this.payloads.select = DoubleIntHashMapTest::select;
            this.payloads.reject = DoubleIntHashMapTest::reject;
            this.payloads.select_value = DoubleIntHashMapTest::select_value;
            this.payloads.reject_value = DoubleIntHashMapTest::reject_value;
            this.payloads.collect = DoubleIntHashMapTest::collect;
            this.payloads.count = DoubleIntHashMapTest::count;
            this.payloads.detectIfNone_value = DoubleIntHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = DoubleIntHashMapTest::anySatisfy;
            this.payloads.allSatisfy = DoubleIntHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleIntHashMapTest::noneSatisfy;
            this.payloads.max = DoubleIntHashMapTest::max;
            this.payloads.min = DoubleIntHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleIntHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleIntHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleIntHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleIntHashMapTest::maxIfEmpty;
            this.payloads.sum = DoubleIntHashMapTest::sum;
            this.payloads.average = DoubleIntHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleIntHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = DoubleIntHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleIntHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = DoubleIntHashMapTest::toList;
            this.payloads.toSortedList = DoubleIntHashMapTest::toSortedList;
            this.payloads.toSet = DoubleIntHashMapTest::toSet;
            this.payloads.toBag = DoubleIntHashMapTest::toBag;
            this.payloads.intIterator = DoubleIntHashMapTest::intIterator;
            this.payloads.asLazy = DoubleIntHashMapTest::asLazy;
            this.payloads.keysView = DoubleIntHashMapTest::keysView;
            this.payloads.keyValuesView = DoubleIntHashMapTest::keyValuesView;
            this.payloads.toSortedArray = DoubleIntHashMapTest::toSortedArray;
            this.payloads.toArray = DoubleIntHashMapTest::toArray;
            this.payloads.toImmutable = DoubleIntHashMapTest::toImmutable;
            this.payloads.chunk = DoubleIntHashMapTest::chunk;
            this.payloads.get = DoubleIntHashMapTest::get;
            this.payloads.getOrThrow = DoubleIntHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = DoubleIntHashMapTest::getIfAbsent;
            this.payloads.containsKey = DoubleIntHashMapTest::containsKey;
            this.payloads.containsValue = DoubleIntHashMapTest::containsValue;
            this.payloads.contains = DoubleIntHashMapTest::contains;
            this.payloads.size = DoubleIntHashMapTest::size;
            this.payloads.clear = DoubleIntHashMapTest::clear;
            this.payloads.removeKey = DoubleIntHashMapTest::removeKey;
            this.payloads.remove = DoubleIntHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = DoubleIntHashMapTest::removeKeyIfAbsent;
            this.payloads.put = DoubleIntHashMapTest::put;
            this.payloads.getAndPut = DoubleIntHashMapTest::getAndPut;
            this.payloads.putPair = DoubleIntHashMapTest::putPair;
            this.payloads.updateValues = DoubleIntHashMapTest::updateValues;
            this.payloads.addToValue = DoubleIntHashMapTest::addToValue;
            this.payloads.put_every_slot = DoubleIntHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = DoubleIntHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = DoubleIntHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = DoubleIntHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = DoubleIntHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = DoubleIntHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = DoubleIntHashMapTest::updateValue;
            this.payloads.freeze = DoubleIntHashMapTest::freeze;
            this.payloads.withoutKey = DoubleIntHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubleIntHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = DoubleIntHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = DoubleIntHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleIntHashMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = DoubleIntHashMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = DoubleIntHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = DoubleIntHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = DoubleIntHashMapTest::flipUniqueValues;
            this.payloads.serialize = DoubleIntHashMapTest::serialize;
            this.payloads.serializeKeySet = DoubleIntHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = DoubleIntHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleIntHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleIntHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = DoubleIntHashMapTest::newMap;
            this.payloads.putWithRehash = DoubleIntHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = DoubleIntHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = DoubleIntHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = DoubleIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = DoubleIntHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = DoubleIntHashMapTest::testPutAll;
            this.payloads.withKeysValues = DoubleIntHashMapTest::withKeysValues;
            this.payloads.injectInto = DoubleIntHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = DoubleIntHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = DoubleIntHashMapTest::classIsNonInstantiable;
        }
    }
}
