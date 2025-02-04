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
import org.eclipse.collections.api.block.function.primitive.DoubleToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleFloatHashMapTest extends AbstractMutableDoubleFloatMapTestCase {

    @Override
    protected DoubleFloatHashMap classUnderTest() {
        return DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1) {
        return new DoubleFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2) {
        return new DoubleFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3) {
        return new DoubleFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3, double key4, float value4) {
        return new DoubleFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleFloatHashMap getEmptyMap() {
        return new DoubleFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);
        DoubleFloatHashMap hashMap2 = new DoubleFloatHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (float) i);
        }
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10.0f);
        hashMap.put(11.0, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, (float) i);
        }
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f);
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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        FloatToFloatFunction function = (float floatParameter) -> floatParameter;
        hashMap.updateValue(2.0, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        hashMap.getIfAbsentPut(2.0, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        FloatFunction0 function = () -> 5.0f;
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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        FloatFunction<Float> function = Float::floatValue;
        hashMap.getIfAbsentPutWith(2.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(2, hashMap.getAndPut(2.0, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0, 5.0f, 70.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0, 11.0f, 60.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        DoubleToFloatFunction function = (double doubleParameter) -> (float) doubleParameter;
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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableDoubleFloatMap copyMap = new DoubleFloatHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (float) i);
        }
        Verify.assertSize(8, copyMap);
        MutableDoubleFloatMap hashMap = new DoubleFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        DoubleFloatHashMap hashMap0 = new DoubleFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1.0f, 2.0, 2.0f), hashMap0);
        DoubleFloatHashMap hashMap1 = new DoubleFloatHashMap().withKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f);
        DoubleFloatHashMap hashMap2 = new DoubleFloatHashMap().withKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f), hashMap0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f), hashMap1);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f), hashMap2);
    }

    @Test
    public void injectInto() {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap().withKeysValues(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableDoubleFloatMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((double) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((double) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((double) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleFloatMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleFloatHashMapTest instance;

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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleFloatHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleFloatHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = DoubleFloatHashMapTest::keySet;
            this.payloads.values = DoubleFloatHashMapTest::values;
            this.payloads.containsAll = DoubleFloatHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = DoubleFloatHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = DoubleFloatHashMapTest::isEmpty;
            this.payloads.notEmpty = DoubleFloatHashMapTest::notEmpty;
            this.payloads.testEquals = DoubleFloatHashMapTest::testEquals;
            this.payloads.testHashCode = DoubleFloatHashMapTest::testHashCode;
            this.payloads.testToString = DoubleFloatHashMapTest::testToString;
            this.payloads.forEach = DoubleFloatHashMapTest::forEach;
            this.payloads.forEachValue = DoubleFloatHashMapTest::forEachValue;
            this.payloads.forEachKey = DoubleFloatHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = DoubleFloatHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = DoubleFloatHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = DoubleFloatHashMapTest::makeString;
            this.payloads.appendString = DoubleFloatHashMapTest::appendString;
            this.payloads.select = DoubleFloatHashMapTest::select;
            this.payloads.reject = DoubleFloatHashMapTest::reject;
            this.payloads.select_value = DoubleFloatHashMapTest::select_value;
            this.payloads.reject_value = DoubleFloatHashMapTest::reject_value;
            this.payloads.collect = DoubleFloatHashMapTest::collect;
            this.payloads.count = DoubleFloatHashMapTest::count;
            this.payloads.detectIfNone_value = DoubleFloatHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = DoubleFloatHashMapTest::anySatisfy;
            this.payloads.allSatisfy = DoubleFloatHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleFloatHashMapTest::noneSatisfy;
            this.payloads.max = DoubleFloatHashMapTest::max;
            this.payloads.min = DoubleFloatHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleFloatHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleFloatHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleFloatHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleFloatHashMapTest::maxIfEmpty;
            this.payloads.sum = DoubleFloatHashMapTest::sum;
            this.payloads.average = DoubleFloatHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleFloatHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = DoubleFloatHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleFloatHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = DoubleFloatHashMapTest::toList;
            this.payloads.toSortedList = DoubleFloatHashMapTest::toSortedList;
            this.payloads.toSet = DoubleFloatHashMapTest::toSet;
            this.payloads.toBag = DoubleFloatHashMapTest::toBag;
            this.payloads.floatIterator = DoubleFloatHashMapTest::floatIterator;
            this.payloads.asLazy = DoubleFloatHashMapTest::asLazy;
            this.payloads.keysView = DoubleFloatHashMapTest::keysView;
            this.payloads.keyValuesView = DoubleFloatHashMapTest::keyValuesView;
            this.payloads.toSortedArray = DoubleFloatHashMapTest::toSortedArray;
            this.payloads.toArray = DoubleFloatHashMapTest::toArray;
            this.payloads.toImmutable = DoubleFloatHashMapTest::toImmutable;
            this.payloads.chunk = DoubleFloatHashMapTest::chunk;
            this.payloads.get = DoubleFloatHashMapTest::get;
            this.payloads.getOrThrow = DoubleFloatHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = DoubleFloatHashMapTest::getIfAbsent;
            this.payloads.containsKey = DoubleFloatHashMapTest::containsKey;
            this.payloads.containsValue = DoubleFloatHashMapTest::containsValue;
            this.payloads.contains = DoubleFloatHashMapTest::contains;
            this.payloads.size = DoubleFloatHashMapTest::size;
            this.payloads.clear = DoubleFloatHashMapTest::clear;
            this.payloads.removeKey = DoubleFloatHashMapTest::removeKey;
            this.payloads.remove = DoubleFloatHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = DoubleFloatHashMapTest::removeKeyIfAbsent;
            this.payloads.put = DoubleFloatHashMapTest::put;
            this.payloads.getAndPut = DoubleFloatHashMapTest::getAndPut;
            this.payloads.putPair = DoubleFloatHashMapTest::putPair;
            this.payloads.updateValues = DoubleFloatHashMapTest::updateValues;
            this.payloads.addToValue = DoubleFloatHashMapTest::addToValue;
            this.payloads.put_every_slot = DoubleFloatHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = DoubleFloatHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = DoubleFloatHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = DoubleFloatHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = DoubleFloatHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = DoubleFloatHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = DoubleFloatHashMapTest::updateValue;
            this.payloads.freeze = DoubleFloatHashMapTest::freeze;
            this.payloads.withoutKey = DoubleFloatHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubleFloatHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = DoubleFloatHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = DoubleFloatHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleFloatHashMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = DoubleFloatHashMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = DoubleFloatHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = DoubleFloatHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = DoubleFloatHashMapTest::flipUniqueValues;
            this.payloads.serialize = DoubleFloatHashMapTest::serialize;
            this.payloads.serializeKeySet = DoubleFloatHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = DoubleFloatHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleFloatHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleFloatHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = DoubleFloatHashMapTest::newMap;
            this.payloads.putWithRehash = DoubleFloatHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = DoubleFloatHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = DoubleFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = DoubleFloatHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = DoubleFloatHashMapTest::testPutAll;
            this.payloads.withKeysValues = DoubleFloatHashMapTest::withKeysValues;
            this.payloads.injectInto = DoubleFloatHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = DoubleFloatHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = DoubleFloatHashMapTest::classIsNonInstantiable;
        }
    }
}
