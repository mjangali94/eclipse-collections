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
import org.eclipse.collections.api.block.function.primitive.LongToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongDoubleHashMapTest extends AbstractMutableLongDoubleMapTestCase {

    @Override
    protected LongDoubleHashMap classUnderTest() {
        return LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0);
    }

    @Override
    protected LongDoubleHashMap newWithKeysValues(long key1, double value1) {
        return new LongDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongDoubleHashMap newWithKeysValues(long key1, double value1, long key2, double value2) {
        return new LongDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongDoubleHashMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3) {
        return new LongDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongDoubleHashMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3, long key4, double value4) {
        return new LongDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongDoubleHashMap getEmptyMap() {
        return new LongDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = LongDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = LongDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongDoubleHashMap hashMap = new LongDoubleHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);
        LongDoubleHashMap hashMap2 = new LongDoubleHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new LongDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = LongDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (double) i);
        }
        Field keys = LongDoubleHashMap.class.getDeclaredField("keys");
        Field values = LongDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, 10.0);
        hashMap.put(11L, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, (double) i);
        }
        Field keys = LongDoubleHashMap.class.getDeclaredField("keys");
        Field values = LongDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0);
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
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
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
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;
        hashMap.updateValue(2L, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5L, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2L, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((long) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2L, 9.0);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
        hashMap.getIfAbsentPut(2L, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5L, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2L, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
        DoubleFunction0 function = () -> 5.0;
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
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
        DoubleFunction<Double> function = Double::doubleValue;
        hashMap.getIfAbsentPutWith(2L, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5L, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2L, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
        Assert.assertEquals(2, hashMap.getAndPut(2L, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0L, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0L, 5.0, 70.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1L, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1L, 11.0, 60.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2L);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2L, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = LongDoubleHashMap.newWithKeysValues(2L, 2.0, 3L, 3.0, 4L, 4.0);
        LongToDoubleFunction function = (long longParameter) -> (double) longParameter;
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
        Field occupiedWithData = LongDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2L, 3.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableLongDoubleMap copyMap = new LongDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (double) i);
        }
        Verify.assertSize(8, copyMap);
        MutableLongDoubleMap hashMap = new LongDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        LongDoubleHashMap hashMap0 = new LongDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, 1.0, 2L, 2.0), hashMap0);
        LongDoubleHashMap hashMap1 = new LongDoubleHashMap().withKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0);
        LongDoubleHashMap hashMap2 = new LongDoubleHashMap().withKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 2L, 2.0), hashMap0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0), hashMap1);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0), hashMap2);
    }

    @Test
    public void injectInto() {
        LongDoubleHashMap hashMap = new LongDoubleHashMap().withKeysValues(1L, 2.0, 2L, 3.0, 3L, 4.0, 4L, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableLongDoubleMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((long) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((long) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((long) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(LongDoubleMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private LongDoubleHashMapTest instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_doubleIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new LongDoubleHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<LongDoubleHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = LongDoubleHashMapTest::keySet;
            this.payloads.values = LongDoubleHashMapTest::values;
            this.payloads.containsAll = LongDoubleHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = LongDoubleHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = LongDoubleHashMapTest::isEmpty;
            this.payloads.notEmpty = LongDoubleHashMapTest::notEmpty;
            this.payloads.testEquals = LongDoubleHashMapTest::testEquals;
            this.payloads.testHashCode = LongDoubleHashMapTest::testHashCode;
            this.payloads.testToString = LongDoubleHashMapTest::testToString;
            this.payloads.forEach = LongDoubleHashMapTest::forEach;
            this.payloads.forEachValue = LongDoubleHashMapTest::forEachValue;
            this.payloads.forEachKey = LongDoubleHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = LongDoubleHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = LongDoubleHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = LongDoubleHashMapTest::makeString;
            this.payloads.appendString = LongDoubleHashMapTest::appendString;
            this.payloads.select = LongDoubleHashMapTest::select;
            this.payloads.reject = LongDoubleHashMapTest::reject;
            this.payloads.select_value = LongDoubleHashMapTest::select_value;
            this.payloads.reject_value = LongDoubleHashMapTest::reject_value;
            this.payloads.collect = LongDoubleHashMapTest::collect;
            this.payloads.count = LongDoubleHashMapTest::count;
            this.payloads.detectIfNone_value = LongDoubleHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = LongDoubleHashMapTest::anySatisfy;
            this.payloads.allSatisfy = LongDoubleHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = LongDoubleHashMapTest::noneSatisfy;
            this.payloads.max = LongDoubleHashMapTest::max;
            this.payloads.min = LongDoubleHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongDoubleHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongDoubleHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = LongDoubleHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = LongDoubleHashMapTest::maxIfEmpty;
            this.payloads.sum = LongDoubleHashMapTest::sum;
            this.payloads.average = LongDoubleHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongDoubleHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = LongDoubleHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongDoubleHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = LongDoubleHashMapTest::toList;
            this.payloads.toSortedList = LongDoubleHashMapTest::toSortedList;
            this.payloads.toSet = LongDoubleHashMapTest::toSet;
            this.payloads.toBag = LongDoubleHashMapTest::toBag;
            this.payloads.doubleIterator = LongDoubleHashMapTest::doubleIterator;
            this.payloads.asLazy = LongDoubleHashMapTest::asLazy;
            this.payloads.keysView = LongDoubleHashMapTest::keysView;
            this.payloads.keyValuesView = LongDoubleHashMapTest::keyValuesView;
            this.payloads.toSortedArray = LongDoubleHashMapTest::toSortedArray;
            this.payloads.toArray = LongDoubleHashMapTest::toArray;
            this.payloads.toImmutable = LongDoubleHashMapTest::toImmutable;
            this.payloads.chunk = LongDoubleHashMapTest::chunk;
            this.payloads.get = LongDoubleHashMapTest::get;
            this.payloads.getOrThrow = LongDoubleHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = LongDoubleHashMapTest::getIfAbsent;
            this.payloads.containsKey = LongDoubleHashMapTest::containsKey;
            this.payloads.containsValue = LongDoubleHashMapTest::containsValue;
            this.payloads.contains = LongDoubleHashMapTest::contains;
            this.payloads.size = LongDoubleHashMapTest::size;
            this.payloads.clear = LongDoubleHashMapTest::clear;
            this.payloads.removeKey = LongDoubleHashMapTest::removeKey;
            this.payloads.remove = LongDoubleHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = LongDoubleHashMapTest::removeKeyIfAbsent;
            this.payloads.put = LongDoubleHashMapTest::put;
            this.payloads.getAndPut = LongDoubleHashMapTest::getAndPut;
            this.payloads.putPair = LongDoubleHashMapTest::putPair;
            this.payloads.updateValues = LongDoubleHashMapTest::updateValues;
            this.payloads.addToValue = LongDoubleHashMapTest::addToValue;
            this.payloads.put_every_slot = LongDoubleHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = LongDoubleHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = LongDoubleHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = LongDoubleHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = LongDoubleHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = LongDoubleHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = LongDoubleHashMapTest::updateValue;
            this.payloads.freeze = LongDoubleHashMapTest::freeze;
            this.payloads.withoutKey = LongDoubleHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = LongDoubleHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = LongDoubleHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = LongDoubleHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = LongDoubleHashMapTest::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = LongDoubleHashMapTest::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = LongDoubleHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = LongDoubleHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = LongDoubleHashMapTest::flipUniqueValues;
            this.payloads.serialize = LongDoubleHashMapTest::serialize;
            this.payloads.serializeKeySet = LongDoubleHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = LongDoubleHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = LongDoubleHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(LongDoubleHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = LongDoubleHashMapTest::newMap;
            this.payloads.putWithRehash = LongDoubleHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = LongDoubleHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = LongDoubleHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = LongDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = LongDoubleHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = LongDoubleHashMapTest::testPutAll;
            this.payloads.withKeysValues = LongDoubleHashMapTest::withKeysValues;
            this.payloads.injectInto = LongDoubleHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = LongDoubleHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = LongDoubleHashMapTest::classIsNonInstantiable;
        }
    }
}
