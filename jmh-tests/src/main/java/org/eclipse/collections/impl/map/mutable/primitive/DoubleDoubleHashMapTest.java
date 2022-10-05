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
import org.eclipse.collections.impl.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleDoubleHashMapTest extends AbstractMutableDoubleDoubleMapTestCase {

    @Override
    protected DoubleDoubleHashMap classUnderTest() {
        return DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1) {
        return new DoubleDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1, double key2, double value2) {
        return new DoubleDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3) {
        return new DoubleDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3, double key4, double value4) {
        return new DoubleDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleDoubleHashMap getEmptyMap() {
        return new DoubleDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keysValues = DoubleDoubleHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(32L, ((double[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keysValues = DoubleDoubleHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap(3);
        Assert.assertEquals(16L, ((double[]) keysValues.get(hashMap)).length);
        DoubleDoubleHashMap hashMap2 = new DoubleDoubleHashMap(15);
        Assert.assertEquals(64L, ((double[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keysValues = DoubleDoubleHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(32L, ((double[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new DoubleDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (double) i);
        }
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10.0);
        hashMap.put(11.0, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, (double) i);
        }
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0);
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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;
        hashMap.updateValue(2.0, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0, 9.0);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        hashMap.getIfAbsentPut(2.0, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        DoubleFunction0 function = () -> 5.0;
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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        DoubleFunction<Double> function = Double::doubleValue;
        hashMap.getIfAbsentPutWith(2.0, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        Assert.assertEquals(2, hashMap.getAndPut(2.0, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0, 5.0, 70.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0, 11.0, 60.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0, 5.0, 50.0), 0.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        DoubleToDoubleFunction function = (double doubleParameter) -> (double) doubleParameter;
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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0, 3.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableDoubleDoubleMap copyMap = new DoubleDoubleHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (double) i);
        }
        Verify.assertSize(8, copyMap);
        MutableDoubleDoubleMap hashMap = new DoubleDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        DoubleDoubleHashMap hashMap0 = new DoubleDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1.0, 2.0, 2.0), hashMap0);
        DoubleDoubleHashMap hashMap1 = new DoubleDoubleHashMap().withKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0);
        DoubleDoubleHashMap hashMap2 = new DoubleDoubleHashMap().withKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0), hashMap0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0), hashMap1);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0), hashMap2);
    }

    @Test
    public void injectInto() {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap().withKeysValues(1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        MutableDoubleDoubleMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0.0, hashMap.get((double) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((double) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((double) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleDoubleMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleDoubleHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleDoubleHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> doubleIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleDoubleHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = DoubleDoubleHashMapTest::keySet;
            this.payloads.values = DoubleDoubleHashMapTest::values;
            this.payloads.containsAll = DoubleDoubleHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = DoubleDoubleHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = DoubleDoubleHashMapTest::isEmpty;
            this.payloads.notEmpty = DoubleDoubleHashMapTest::notEmpty;
            this.payloads.testEquals = DoubleDoubleHashMapTest::testEquals;
            this.payloads.testHashCode = DoubleDoubleHashMapTest::testHashCode;
            this.payloads.testToString = DoubleDoubleHashMapTest::testToString;
            this.payloads.forEach = DoubleDoubleHashMapTest::forEach;
            this.payloads.forEachValue = DoubleDoubleHashMapTest::forEachValue;
            this.payloads.forEachKey = DoubleDoubleHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = DoubleDoubleHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = DoubleDoubleHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = DoubleDoubleHashMapTest::makeString;
            this.payloads.appendString = DoubleDoubleHashMapTest::appendString;
            this.payloads.select = DoubleDoubleHashMapTest::select;
            this.payloads.reject = DoubleDoubleHashMapTest::reject;
            this.payloads.select_value = DoubleDoubleHashMapTest::select_value;
            this.payloads.reject_value = DoubleDoubleHashMapTest::reject_value;
            this.payloads.collect = DoubleDoubleHashMapTest::collect;
            this.payloads.count = DoubleDoubleHashMapTest::count;
            this.payloads.detectIfNone_value = DoubleDoubleHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = DoubleDoubleHashMapTest::anySatisfy;
            this.payloads.allSatisfy = DoubleDoubleHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleDoubleHashMapTest::noneSatisfy;
            this.payloads.max = DoubleDoubleHashMapTest::max;
            this.payloads.min = DoubleDoubleHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleDoubleHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleDoubleHashMapTest::maxIfEmpty;
            this.payloads.sum = DoubleDoubleHashMapTest::sum;
            this.payloads.average = DoubleDoubleHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = DoubleDoubleHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = DoubleDoubleHashMapTest::toList;
            this.payloads.toSortedList = DoubleDoubleHashMapTest::toSortedList;
            this.payloads.toSet = DoubleDoubleHashMapTest::toSet;
            this.payloads.toBag = DoubleDoubleHashMapTest::toBag;
            this.payloads.doubleIterator = DoubleDoubleHashMapTest::doubleIterator;
            this.payloads.asLazy = DoubleDoubleHashMapTest::asLazy;
            this.payloads.keysView = DoubleDoubleHashMapTest::keysView;
            this.payloads.keyValuesView = DoubleDoubleHashMapTest::keyValuesView;
            this.payloads.toSortedArray = DoubleDoubleHashMapTest::toSortedArray;
            this.payloads.toArray = DoubleDoubleHashMapTest::toArray;
            this.payloads.toImmutable = DoubleDoubleHashMapTest::toImmutable;
            this.payloads.chunk = DoubleDoubleHashMapTest::chunk;
            this.payloads.get = DoubleDoubleHashMapTest::get;
            this.payloads.getOrThrow = DoubleDoubleHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = DoubleDoubleHashMapTest::getIfAbsent;
            this.payloads.containsKey = DoubleDoubleHashMapTest::containsKey;
            this.payloads.containsValue = DoubleDoubleHashMapTest::containsValue;
            this.payloads.contains = DoubleDoubleHashMapTest::contains;
            this.payloads.size = DoubleDoubleHashMapTest::size;
            this.payloads.clear = DoubleDoubleHashMapTest::clear;
            this.payloads.removeKey = DoubleDoubleHashMapTest::removeKey;
            this.payloads.remove = DoubleDoubleHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = DoubleDoubleHashMapTest::removeKeyIfAbsent;
            this.payloads.put = DoubleDoubleHashMapTest::put;
            this.payloads.getAndPut = DoubleDoubleHashMapTest::getAndPut;
            this.payloads.putPair = DoubleDoubleHashMapTest::putPair;
            this.payloads.updateValues = DoubleDoubleHashMapTest::updateValues;
            this.payloads.addToValue = DoubleDoubleHashMapTest::addToValue;
            this.payloads.put_every_slot = DoubleDoubleHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = DoubleDoubleHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = DoubleDoubleHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = DoubleDoubleHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = DoubleDoubleHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = DoubleDoubleHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = DoubleDoubleHashMapTest::updateValue;
            this.payloads.freeze = DoubleDoubleHashMapTest::freeze;
            this.payloads.withoutKey = DoubleDoubleHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubleDoubleHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = DoubleDoubleHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = DoubleDoubleHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleDoubleHashMapTest::asUnmodifiable;
            this.payloads.doubleIterator_with_remove = DoubleDoubleHashMapTest::doubleIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = DoubleDoubleHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = DoubleDoubleHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = DoubleDoubleHashMapTest::flipUniqueValues;
            this.payloads.serialize = DoubleDoubleHashMapTest::serialize;
            this.payloads.serializeKeySet = DoubleDoubleHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = DoubleDoubleHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleDoubleHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleDoubleHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = DoubleDoubleHashMapTest::newMap;
            this.payloads.putWithRehash = DoubleDoubleHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = DoubleDoubleHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = DoubleDoubleHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = DoubleDoubleHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = DoubleDoubleHashMapTest::testPutAll;
            this.payloads.withKeysValues = DoubleDoubleHashMapTest::withKeysValues;
            this.payloads.injectInto = DoubleDoubleHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = DoubleDoubleHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = DoubleDoubleHashMapTest::classIsNonInstantiable;
        }
    }
}
