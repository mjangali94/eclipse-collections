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
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToByteFunction;
import org.eclipse.collections.impl.factory.primitive.ShortByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortByteHashMapTest extends AbstractMutableShortByteMapTestCase {

    @Override
    protected ShortByteHashMap classUnderTest() {
        return ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32);
    }

    @Override
    protected ShortByteHashMap newWithKeysValues(short key1, byte value1) {
        return new ShortByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortByteHashMap newWithKeysValues(short key1, byte value1, short key2, byte value2) {
        return new ShortByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortByteHashMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3) {
        return new ShortByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortByteHashMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3, short key4, byte value4) {
        return new ShortByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortByteHashMap getEmptyMap() {
        return new ShortByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ShortByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortByteHashMap hashMap = new ShortByteHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ShortByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortByteHashMap hashMap = new ShortByteHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);
        ShortByteHashMap hashMap2 = new ShortByteHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ShortByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ShortByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortByteHashMap hashMap = new ShortByteHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ShortByteHashMap hashMap = new ShortByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (byte) i);
        }
        Field keys = ShortByteHashMap.class.getDeclaredField("keys");
        Field values = ShortByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, (byte) 10);
        hashMap.put((short) 11, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        ShortByteHashMap hashMap = new ShortByteHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((short) i, (byte) i);
        }
        Field keys = ShortByteHashMap.class.getDeclaredField("keys");
        Field values = ShortByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3);
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
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
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
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ByteToByteFunction function = (byte byteParameter) -> byteParameter;
        hashMap.updateValue((short) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((short) 5, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((short) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = new ShortByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((short) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((short) 2, (byte) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        hashMap.getIfAbsentPut((short) 2, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((short) 5, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((short) 2, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        ByteFunction0 function = () -> (byte) 5;
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
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        ByteFunction<Byte> function = Byte::byteValue;
        hashMap.getIfAbsentPutWith((short) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((short) 5, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((short) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        Assert.assertEquals(2, hashMap.getAndPut((short) 2, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((short) 0, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((short) 0, (byte) 5, (byte) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((short) 1, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((short) 1, (byte) 11, (byte) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((short) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((short) 2, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = ShortByteHashMap.newWithKeysValues((short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        ShortToByteFunction function = (short shortParameter) -> (byte) shortParameter;
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
        Field occupiedWithData = ShortByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortByteHashMap hashMap = new ShortByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((short) 2, (byte) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableShortByteMap copyMap = new ShortByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (byte) i);
        }
        Verify.assertSize(8, copyMap);
        MutableShortByteMap hashMap = new ShortByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ShortByteHashMap hashMap0 = new ShortByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2), hashMap0);
        ShortByteHashMap hashMap1 = new ShortByteHashMap().withKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3);
        ShortByteHashMap hashMap2 = new ShortByteHashMap().withKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2), hashMap0);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3), hashMap1);
        Assert.assertEquals(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        ShortByteHashMap hashMap = new ShortByteHashMap().withKeysValues((short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableShortByteMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((short) i));
            Assert.assertEquals(1L, hashMap.updateValue((short) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((short) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ShortByteMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortByteHashMapTest instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ShortByteHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortByteHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ShortByteHashMapTest::keySet;
            this.payloads.values = ShortByteHashMapTest::values;
            this.payloads.containsAll = ShortByteHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ShortByteHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ShortByteHashMapTest::isEmpty;
            this.payloads.notEmpty = ShortByteHashMapTest::notEmpty;
            this.payloads.testEquals = ShortByteHashMapTest::testEquals;
            this.payloads.testHashCode = ShortByteHashMapTest::testHashCode;
            this.payloads.testToString = ShortByteHashMapTest::testToString;
            this.payloads.forEach = ShortByteHashMapTest::forEach;
            this.payloads.forEachValue = ShortByteHashMapTest::forEachValue;
            this.payloads.forEachKey = ShortByteHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ShortByteHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ShortByteHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ShortByteHashMapTest::makeString;
            this.payloads.appendString = ShortByteHashMapTest::appendString;
            this.payloads.select = ShortByteHashMapTest::select;
            this.payloads.reject = ShortByteHashMapTest::reject;
            this.payloads.select_value = ShortByteHashMapTest::select_value;
            this.payloads.reject_value = ShortByteHashMapTest::reject_value;
            this.payloads.collect = ShortByteHashMapTest::collect;
            this.payloads.count = ShortByteHashMapTest::count;
            this.payloads.detectIfNone_value = ShortByteHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ShortByteHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ShortByteHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ShortByteHashMapTest::noneSatisfy;
            this.payloads.max = ShortByteHashMapTest::max;
            this.payloads.min = ShortByteHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortByteHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortByteHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ShortByteHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ShortByteHashMapTest::maxIfEmpty;
            this.payloads.sum = ShortByteHashMapTest::sum;
            this.payloads.average = ShortByteHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortByteHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ShortByteHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortByteHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ShortByteHashMapTest::toList;
            this.payloads.toSortedList = ShortByteHashMapTest::toSortedList;
            this.payloads.toSet = ShortByteHashMapTest::toSet;
            this.payloads.toBag = ShortByteHashMapTest::toBag;
            this.payloads.byteIterator = ShortByteHashMapTest::byteIterator;
            this.payloads.asLazy = ShortByteHashMapTest::asLazy;
            this.payloads.keysView = ShortByteHashMapTest::keysView;
            this.payloads.keyValuesView = ShortByteHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ShortByteHashMapTest::toSortedArray;
            this.payloads.toArray = ShortByteHashMapTest::toArray;
            this.payloads.toImmutable = ShortByteHashMapTest::toImmutable;
            this.payloads.chunk = ShortByteHashMapTest::chunk;
            this.payloads.get = ShortByteHashMapTest::get;
            this.payloads.getOrThrow = ShortByteHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ShortByteHashMapTest::getIfAbsent;
            this.payloads.containsKey = ShortByteHashMapTest::containsKey;
            this.payloads.containsValue = ShortByteHashMapTest::containsValue;
            this.payloads.contains = ShortByteHashMapTest::contains;
            this.payloads.size = ShortByteHashMapTest::size;
            this.payloads.clear = ShortByteHashMapTest::clear;
            this.payloads.removeKey = ShortByteHashMapTest::removeKey;
            this.payloads.remove = ShortByteHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = ShortByteHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ShortByteHashMapTest::put;
            this.payloads.getAndPut = ShortByteHashMapTest::getAndPut;
            this.payloads.putPair = ShortByteHashMapTest::putPair;
            this.payloads.updateValues = ShortByteHashMapTest::updateValues;
            this.payloads.addToValue = ShortByteHashMapTest::addToValue;
            this.payloads.put_every_slot = ShortByteHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = ShortByteHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = ShortByteHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ShortByteHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ShortByteHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ShortByteHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ShortByteHashMapTest::updateValue;
            this.payloads.freeze = ShortByteHashMapTest::freeze;
            this.payloads.withoutKey = ShortByteHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ShortByteHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ShortByteHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ShortByteHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortByteHashMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = ShortByteHashMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ShortByteHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ShortByteHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = ShortByteHashMapTest::flipUniqueValues;
            this.payloads.serialize = ShortByteHashMapTest::serialize;
            this.payloads.serializeKeySet = ShortByteHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = ShortByteHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ShortByteHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortByteHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ShortByteHashMapTest::newMap;
            this.payloads.putWithRehash = ShortByteHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = ShortByteHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = ShortByteHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ShortByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ShortByteHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = ShortByteHashMapTest::testPutAll;
            this.payloads.withKeysValues = ShortByteHashMapTest::withKeysValues;
            this.payloads.injectInto = ShortByteHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = ShortByteHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ShortByteHashMapTest::classIsNonInstantiable;
        }
    }
}
