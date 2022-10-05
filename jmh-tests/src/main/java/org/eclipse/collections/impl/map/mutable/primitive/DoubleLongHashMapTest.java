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
import org.eclipse.collections.api.block.function.primitive.DoubleToLongFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleLongHashMapTest extends AbstractMutableDoubleLongMapTestCase {

    @Override
    protected DoubleLongHashMap classUnderTest() {
        return DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1) {
        return new DoubleLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1, double key2, long value2) {
        return new DoubleLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3) {
        return new DoubleLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3, double key4, long value4) {
        return new DoubleLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleLongHashMap getEmptyMap() {
        return new DoubleLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((long[]) values.get(hashMap)).length);
        DoubleLongHashMap hashMap2 = new DoubleLongHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((long[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (long) i);
        }
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10L);
        hashMap.put(11.0, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, (long) i);
        }
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L);
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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        LongToLongFunction function = (long longParameter) -> longParameter;
        hashMap.updateValue(2.0, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((double) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0, 9L);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
        hashMap.getIfAbsentPut(2.0, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
        LongFunction0 function = () -> 5L;
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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
        LongFunction<Long> function = Long::longValue;
        hashMap.getIfAbsentPutWith(2.0, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
        Assert.assertEquals(2, hashMap.getAndPut(2.0, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(0.0, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(0.0, 5L, 70L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(1.0, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut(1.0, 11L, 60L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey(2.0);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut(2.0, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);
        DoubleToLongFunction function = (double doubleParameter) -> (long) doubleParameter;
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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0, 3L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableDoubleLongMap copyMap = new DoubleLongHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (long) i);
        }
        Verify.assertSize(8, copyMap);
        MutableDoubleLongMap hashMap = new DoubleLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        DoubleLongHashMap hashMap0 = new DoubleLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1L, 2.0, 2L), hashMap0);
        DoubleLongHashMap hashMap1 = new DoubleLongHashMap().withKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L);
        DoubleLongHashMap hashMap2 = new DoubleLongHashMap().withKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L, 4.0, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L), hashMap0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L), hashMap1);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L, 4.0, 4L), hashMap2);
    }

    @Test
    public void injectInto() {
        DoubleLongHashMap hashMap = new DoubleLongHashMap().withKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableDoubleLongMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((double) i));
            Assert.assertEquals(1L, hashMap.updateValue((double) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((double) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(DoubleLongMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleLongHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleLongHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleLongHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = DoubleLongHashMapTest::keySet;
            this.payloads.values = DoubleLongHashMapTest::values;
            this.payloads.containsAll = DoubleLongHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = DoubleLongHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = DoubleLongHashMapTest::isEmpty;
            this.payloads.notEmpty = DoubleLongHashMapTest::notEmpty;
            this.payloads.testEquals = DoubleLongHashMapTest::testEquals;
            this.payloads.testHashCode = DoubleLongHashMapTest::testHashCode;
            this.payloads.testToString = DoubleLongHashMapTest::testToString;
            this.payloads.forEach = DoubleLongHashMapTest::forEach;
            this.payloads.forEachValue = DoubleLongHashMapTest::forEachValue;
            this.payloads.forEachKey = DoubleLongHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = DoubleLongHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = DoubleLongHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = DoubleLongHashMapTest::makeString;
            this.payloads.appendString = DoubleLongHashMapTest::appendString;
            this.payloads.select = DoubleLongHashMapTest::select;
            this.payloads.reject = DoubleLongHashMapTest::reject;
            this.payloads.select_value = DoubleLongHashMapTest::select_value;
            this.payloads.reject_value = DoubleLongHashMapTest::reject_value;
            this.payloads.collect = DoubleLongHashMapTest::collect;
            this.payloads.count = DoubleLongHashMapTest::count;
            this.payloads.detectIfNone_value = DoubleLongHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = DoubleLongHashMapTest::anySatisfy;
            this.payloads.allSatisfy = DoubleLongHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleLongHashMapTest::noneSatisfy;
            this.payloads.max = DoubleLongHashMapTest::max;
            this.payloads.min = DoubleLongHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleLongHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleLongHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = DoubleLongHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = DoubleLongHashMapTest::maxIfEmpty;
            this.payloads.sum = DoubleLongHashMapTest::sum;
            this.payloads.average = DoubleLongHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleLongHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = DoubleLongHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleLongHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = DoubleLongHashMapTest::toList;
            this.payloads.toSortedList = DoubleLongHashMapTest::toSortedList;
            this.payloads.toSet = DoubleLongHashMapTest::toSet;
            this.payloads.toBag = DoubleLongHashMapTest::toBag;
            this.payloads.longIterator = DoubleLongHashMapTest::longIterator;
            this.payloads.asLazy = DoubleLongHashMapTest::asLazy;
            this.payloads.keysView = DoubleLongHashMapTest::keysView;
            this.payloads.keyValuesView = DoubleLongHashMapTest::keyValuesView;
            this.payloads.toSortedArray = DoubleLongHashMapTest::toSortedArray;
            this.payloads.toArray = DoubleLongHashMapTest::toArray;
            this.payloads.toImmutable = DoubleLongHashMapTest::toImmutable;
            this.payloads.chunk = DoubleLongHashMapTest::chunk;
            this.payloads.get = DoubleLongHashMapTest::get;
            this.payloads.getOrThrow = DoubleLongHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = DoubleLongHashMapTest::getIfAbsent;
            this.payloads.containsKey = DoubleLongHashMapTest::containsKey;
            this.payloads.containsValue = DoubleLongHashMapTest::containsValue;
            this.payloads.contains = DoubleLongHashMapTest::contains;
            this.payloads.size = DoubleLongHashMapTest::size;
            this.payloads.clear = DoubleLongHashMapTest::clear;
            this.payloads.removeKey = DoubleLongHashMapTest::removeKey;
            this.payloads.remove = DoubleLongHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = DoubleLongHashMapTest::removeKeyIfAbsent;
            this.payloads.put = DoubleLongHashMapTest::put;
            this.payloads.getAndPut = DoubleLongHashMapTest::getAndPut;
            this.payloads.putPair = DoubleLongHashMapTest::putPair;
            this.payloads.updateValues = DoubleLongHashMapTest::updateValues;
            this.payloads.addToValue = DoubleLongHashMapTest::addToValue;
            this.payloads.put_every_slot = DoubleLongHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = DoubleLongHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = DoubleLongHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = DoubleLongHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = DoubleLongHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = DoubleLongHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = DoubleLongHashMapTest::updateValue;
            this.payloads.freeze = DoubleLongHashMapTest::freeze;
            this.payloads.withoutKey = DoubleLongHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubleLongHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = DoubleLongHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = DoubleLongHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleLongHashMapTest::asUnmodifiable;
            this.payloads.longIterator_with_remove = DoubleLongHashMapTest::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = DoubleLongHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = DoubleLongHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = DoubleLongHashMapTest::flipUniqueValues;
            this.payloads.serialize = DoubleLongHashMapTest::serialize;
            this.payloads.serializeKeySet = DoubleLongHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = DoubleLongHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleLongHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleLongHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = DoubleLongHashMapTest::newMap;
            this.payloads.putWithRehash = DoubleLongHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = DoubleLongHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = DoubleLongHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = DoubleLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = DoubleLongHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = DoubleLongHashMapTest::testPutAll;
            this.payloads.withKeysValues = DoubleLongHashMapTest::withKeysValues;
            this.payloads.injectInto = DoubleLongHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = DoubleLongHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = DoubleLongHashMapTest::classIsNonInstantiable;
        }
    }
}
