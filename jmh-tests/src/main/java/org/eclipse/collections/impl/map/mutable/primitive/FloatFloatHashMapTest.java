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
import org.eclipse.collections.impl.factory.primitive.FloatFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class FloatFloatHashMapTest extends AbstractMutableFloatFloatMapTestCase {

    @Override
    protected FloatFloatHashMap classUnderTest() {
        return FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f);
    }

    @Override
    protected FloatFloatHashMap newWithKeysValues(float key1, float value1) {
        return new FloatFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatFloatHashMap newWithKeysValues(float key1, float value1, float key2, float value2) {
        return new FloatFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatFloatHashMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3) {
        return new FloatFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatFloatHashMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4) {
        return new FloatFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatFloatHashMap getEmptyMap() {
        return new FloatFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keysValues = FloatFloatHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        Assert.assertEquals(32L, ((float[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keysValues = FloatFloatHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        FloatFloatHashMap hashMap = new FloatFloatHashMap(3);
        Assert.assertEquals(16L, ((float[]) keysValues.get(hashMap)).length);
        FloatFloatHashMap hashMap2 = new FloatFloatHashMap(15);
        Assert.assertEquals(64L, ((float[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new FloatFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keysValues = FloatFloatHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        Assert.assertEquals(32L, ((float[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new FloatFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (float) i);
        }
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0f, 10.0f);
        hashMap.put(11.0f, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (float) i);
        }
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove(6.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        FloatToFloatFunction function = (float floatParameter) -> floatParameter;
        hashMap.updateValue(2.0f, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, 9.0f);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        hashMap.getIfAbsentPut(2.0f, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        FloatFunction0 function = () -> 5.0f;
        hashMap.getIfAbsentPut(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        FloatFunction<Float> function = Float::floatValue;
        hashMap.getIfAbsentPutWith(2.0f, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0f, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0f, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        Assert.assertEquals(2, hashMap.getAndPut(2.0f, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0f, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0f, 5.0f, 70.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0f, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0f, 11.0f, 60.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0f);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0f, 5.0f, 50.0f), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = FloatFloatHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        FloatToFloatFunction function = (float floatParameter) -> (float) floatParameter;
        hashMap.getIfAbsentPutWithKey(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey(2.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = FloatFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, 3.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableFloatFloatMap copyMap = new FloatFloatHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((float) i));
            copyMap.put((float) i, (float) i);
        }
        Verify.assertSize(8, copyMap);
        MutableFloatFloatMap hashMap = new FloatFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        FloatFloatHashMap hashMap0 = new FloatFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, 1.0f, 2.0f, 2.0f), hashMap0);
        FloatFloatHashMap hashMap1 = new FloatFloatHashMap().withKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f);
        FloatFloatHashMap hashMap2 = new FloatFloatHashMap().withKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f), hashMap0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f), hashMap1);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f), hashMap2);
    }

    @Test
    public void injectInto() {
        FloatFloatHashMap hashMap = new FloatFloatHashMap().withKeysValues(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        MutableFloatFloatMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0f, hashMap.get((float) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((float) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((float) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(FloatFloatMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatFloatHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new FloatFloatHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatFloatHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = FloatFloatHashMapTest::keySet;
            this.payloads.values = FloatFloatHashMapTest::values;
            this.payloads.containsAll = FloatFloatHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = FloatFloatHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = FloatFloatHashMapTest::isEmpty;
            this.payloads.notEmpty = FloatFloatHashMapTest::notEmpty;
            this.payloads.testEquals = FloatFloatHashMapTest::testEquals;
            this.payloads.testHashCode = FloatFloatHashMapTest::testHashCode;
            this.payloads.testToString = FloatFloatHashMapTest::testToString;
            this.payloads.forEach = FloatFloatHashMapTest::forEach;
            this.payloads.forEachValue = FloatFloatHashMapTest::forEachValue;
            this.payloads.forEachKey = FloatFloatHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = FloatFloatHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = FloatFloatHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = FloatFloatHashMapTest::makeString;
            this.payloads.appendString = FloatFloatHashMapTest::appendString;
            this.payloads.select = FloatFloatHashMapTest::select;
            this.payloads.reject = FloatFloatHashMapTest::reject;
            this.payloads.select_value = FloatFloatHashMapTest::select_value;
            this.payloads.reject_value = FloatFloatHashMapTest::reject_value;
            this.payloads.collect = FloatFloatHashMapTest::collect;
            this.payloads.count = FloatFloatHashMapTest::count;
            this.payloads.detectIfNone_value = FloatFloatHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = FloatFloatHashMapTest::anySatisfy;
            this.payloads.allSatisfy = FloatFloatHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = FloatFloatHashMapTest::noneSatisfy;
            this.payloads.max = FloatFloatHashMapTest::max;
            this.payloads.min = FloatFloatHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatFloatHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatFloatHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = FloatFloatHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = FloatFloatHashMapTest::maxIfEmpty;
            this.payloads.sum = FloatFloatHashMapTest::sum;
            this.payloads.average = FloatFloatHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatFloatHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = FloatFloatHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatFloatHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = FloatFloatHashMapTest::toList;
            this.payloads.toSortedList = FloatFloatHashMapTest::toSortedList;
            this.payloads.toSet = FloatFloatHashMapTest::toSet;
            this.payloads.toBag = FloatFloatHashMapTest::toBag;
            this.payloads.floatIterator = FloatFloatHashMapTest::floatIterator;
            this.payloads.asLazy = FloatFloatHashMapTest::asLazy;
            this.payloads.keysView = FloatFloatHashMapTest::keysView;
            this.payloads.keyValuesView = FloatFloatHashMapTest::keyValuesView;
            this.payloads.toSortedArray = FloatFloatHashMapTest::toSortedArray;
            this.payloads.toArray = FloatFloatHashMapTest::toArray;
            this.payloads.toImmutable = FloatFloatHashMapTest::toImmutable;
            this.payloads.chunk = FloatFloatHashMapTest::chunk;
            this.payloads.get = FloatFloatHashMapTest::get;
            this.payloads.getOrThrow = FloatFloatHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = FloatFloatHashMapTest::getIfAbsent;
            this.payloads.containsKey = FloatFloatHashMapTest::containsKey;
            this.payloads.containsValue = FloatFloatHashMapTest::containsValue;
            this.payloads.contains = FloatFloatHashMapTest::contains;
            this.payloads.size = FloatFloatHashMapTest::size;
            this.payloads.clear = FloatFloatHashMapTest::clear;
            this.payloads.removeKey = FloatFloatHashMapTest::removeKey;
            this.payloads.remove = FloatFloatHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = FloatFloatHashMapTest::removeKeyIfAbsent;
            this.payloads.put = FloatFloatHashMapTest::put;
            this.payloads.getAndPut = FloatFloatHashMapTest::getAndPut;
            this.payloads.putPair = FloatFloatHashMapTest::putPair;
            this.payloads.updateValues = FloatFloatHashMapTest::updateValues;
            this.payloads.addToValue = FloatFloatHashMapTest::addToValue;
            this.payloads.put_every_slot = FloatFloatHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = FloatFloatHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = FloatFloatHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = FloatFloatHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = FloatFloatHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = FloatFloatHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = FloatFloatHashMapTest::updateValue;
            this.payloads.freeze = FloatFloatHashMapTest::freeze;
            this.payloads.withoutKey = FloatFloatHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = FloatFloatHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = FloatFloatHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = FloatFloatHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatFloatHashMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = FloatFloatHashMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = FloatFloatHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = FloatFloatHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = FloatFloatHashMapTest::flipUniqueValues;
            this.payloads.serialize = FloatFloatHashMapTest::serialize;
            this.payloads.serializeKeySet = FloatFloatHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = FloatFloatHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = FloatFloatHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatFloatHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = FloatFloatHashMapTest::newMap;
            this.payloads.putWithRehash = FloatFloatHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = FloatFloatHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = FloatFloatHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = FloatFloatHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = FloatFloatHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = FloatFloatHashMapTest::testPutAll;
            this.payloads.withKeysValues = FloatFloatHashMapTest::withKeysValues;
            this.payloads.injectInto = FloatFloatHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = FloatFloatHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = FloatFloatHashMapTest::classIsNonInstantiable;
        }
    }
}
