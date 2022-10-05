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
import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortLongHashMapTest extends AbstractMutableShortLongMapTestCase {

    @Override
    protected ShortLongHashMap classUnderTest() {
        return ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1) {
        return new ShortLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2) {
        return new ShortLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3) {
        return new ShortLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4) {
        return new ShortLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortLongHashMap getEmptyMap() {
        return new ShortLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((long[]) values.get(hashMap)).length);
        ShortLongHashMap hashMap2 = new ShortLongHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((long[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ShortLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (long) i);
        }
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, 10L);
        hashMap.put((short) 11, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((short) i, (long) i);
        }
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove((short) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove((short) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((short) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        LongToLongFunction function = (long longParameter) -> longParameter;
        hashMap.updateValue((short) 2, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((short) 5, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((short) 2, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((short) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((short) 2, 9L);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        hashMap.getIfAbsentPut((short) 2, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((short) 5, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((short) 2, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        LongFunction0 function = () -> 5L;
        hashMap.getIfAbsentPut((short) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((short) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((short) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        LongFunction<Long> function = Long::longValue;
        hashMap.getIfAbsentPutWith((short) 2, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((short) 5, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((short) 2, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Assert.assertEquals(2, hashMap.getAndPut((short) 2, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((short) 0, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((short) 0, 5L, 70L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((short) 1, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((short) 1, 11L, 60L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((short) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((short) 2, 5L, 50L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        ShortToLongFunction function = (short shortParameter) -> (long) shortParameter;
        hashMap.getIfAbsentPutWithKey((short) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey((short) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey((short) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((short) 2, 3L);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableShortLongMap copyMap = new ShortLongHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (long) i);
        }
        Verify.assertSize(8, copyMap);
        MutableShortLongMap hashMap = new ShortLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ShortLongHashMap hashMap0 = new ShortLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, 1L, (short) 2, 2L), hashMap0);
        ShortLongHashMap hashMap1 = new ShortLongHashMap().withKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        ShortLongHashMap hashMap2 = new ShortLongHashMap().withKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L), hashMap0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L), hashMap1);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L), hashMap2);
    }

    @Test
    public void injectInto() {
        ShortLongHashMap hashMap = new ShortLongHashMap().withKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot() {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        MutableShortLongMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0L, hashMap.get((short) i));
            Assert.assertEquals(1L, hashMap.updateValue((short) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((short) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortLongMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortLongHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ShortLongHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> longIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortLongHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ShortLongHashMapTest::keySet;
            this.payloads.values = ShortLongHashMapTest::values;
            this.payloads.containsAll = ShortLongHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ShortLongHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ShortLongHashMapTest::isEmpty;
            this.payloads.notEmpty = ShortLongHashMapTest::notEmpty;
            this.payloads.testEquals = ShortLongHashMapTest::testEquals;
            this.payloads.testHashCode = ShortLongHashMapTest::testHashCode;
            this.payloads.testToString = ShortLongHashMapTest::testToString;
            this.payloads.forEach = ShortLongHashMapTest::forEach;
            this.payloads.forEachValue = ShortLongHashMapTest::forEachValue;
            this.payloads.forEachKey = ShortLongHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ShortLongHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ShortLongHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ShortLongHashMapTest::makeString;
            this.payloads.appendString = ShortLongHashMapTest::appendString;
            this.payloads.select = ShortLongHashMapTest::select;
            this.payloads.reject = ShortLongHashMapTest::reject;
            this.payloads.select_value = ShortLongHashMapTest::select_value;
            this.payloads.reject_value = ShortLongHashMapTest::reject_value;
            this.payloads.collect = ShortLongHashMapTest::collect;
            this.payloads.count = ShortLongHashMapTest::count;
            this.payloads.detectIfNone_value = ShortLongHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ShortLongHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ShortLongHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ShortLongHashMapTest::noneSatisfy;
            this.payloads.max = ShortLongHashMapTest::max;
            this.payloads.min = ShortLongHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortLongHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortLongHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ShortLongHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ShortLongHashMapTest::maxIfEmpty;
            this.payloads.sum = ShortLongHashMapTest::sum;
            this.payloads.average = ShortLongHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortLongHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ShortLongHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortLongHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ShortLongHashMapTest::toList;
            this.payloads.toSortedList = ShortLongHashMapTest::toSortedList;
            this.payloads.toSet = ShortLongHashMapTest::toSet;
            this.payloads.toBag = ShortLongHashMapTest::toBag;
            this.payloads.longIterator = ShortLongHashMapTest::longIterator;
            this.payloads.asLazy = ShortLongHashMapTest::asLazy;
            this.payloads.keysView = ShortLongHashMapTest::keysView;
            this.payloads.keyValuesView = ShortLongHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ShortLongHashMapTest::toSortedArray;
            this.payloads.toArray = ShortLongHashMapTest::toArray;
            this.payloads.toImmutable = ShortLongHashMapTest::toImmutable;
            this.payloads.chunk = ShortLongHashMapTest::chunk;
            this.payloads.get = ShortLongHashMapTest::get;
            this.payloads.getOrThrow = ShortLongHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ShortLongHashMapTest::getIfAbsent;
            this.payloads.containsKey = ShortLongHashMapTest::containsKey;
            this.payloads.containsValue = ShortLongHashMapTest::containsValue;
            this.payloads.contains = ShortLongHashMapTest::contains;
            this.payloads.size = ShortLongHashMapTest::size;
            this.payloads.clear = ShortLongHashMapTest::clear;
            this.payloads.removeKey = ShortLongHashMapTest::removeKey;
            this.payloads.remove = ShortLongHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = ShortLongHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ShortLongHashMapTest::put;
            this.payloads.getAndPut = ShortLongHashMapTest::getAndPut;
            this.payloads.putPair = ShortLongHashMapTest::putPair;
            this.payloads.updateValues = ShortLongHashMapTest::updateValues;
            this.payloads.addToValue = ShortLongHashMapTest::addToValue;
            this.payloads.put_every_slot = ShortLongHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = ShortLongHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = ShortLongHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ShortLongHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ShortLongHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ShortLongHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ShortLongHashMapTest::updateValue;
            this.payloads.freeze = ShortLongHashMapTest::freeze;
            this.payloads.withoutKey = ShortLongHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ShortLongHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ShortLongHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ShortLongHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortLongHashMapTest::asUnmodifiable;
            this.payloads.longIterator_with_remove = ShortLongHashMapTest::longIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ShortLongHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ShortLongHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = ShortLongHashMapTest::flipUniqueValues;
            this.payloads.serialize = ShortLongHashMapTest::serialize;
            this.payloads.serializeKeySet = ShortLongHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = ShortLongHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ShortLongHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortLongHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ShortLongHashMapTest::newMap;
            this.payloads.putWithRehash = ShortLongHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = ShortLongHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = ShortLongHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ShortLongHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ShortLongHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = ShortLongHashMapTest::testPutAll;
            this.payloads.withKeysValues = ShortLongHashMapTest::withKeysValues;
            this.payloads.injectInto = ShortLongHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = ShortLongHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ShortLongHashMapTest::classIsNonInstantiable;
        }
    }
}
