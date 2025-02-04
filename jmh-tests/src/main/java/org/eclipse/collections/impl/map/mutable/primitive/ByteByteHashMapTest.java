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
import org.eclipse.collections.impl.factory.primitive.ByteByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteByteHashMapTest extends AbstractMutableByteByteMapTestCase {

    @Override
    protected ByteByteHashMap classUnderTest() {
        return ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1) {
        return new ByteByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2) {
        return new ByteByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3) {
        return new ByteByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3, byte key4, byte value4) {
        return new ByteByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteByteHashMap getEmptyMap() {
        return new ByteByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keysValues = ByteByteHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(32L, ((byte[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keysValues = ByteByteHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap(3);
        Assert.assertEquals(16L, ((byte[]) keysValues.get(hashMap)).length);
        ByteByteHashMap hashMap2 = new ByteByteHashMap(15);
        Assert.assertEquals(64L, ((byte[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ByteByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keysValues = ByteByteHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(32L, ((byte[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new ByteByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ByteByteHashMap hashMap = new ByteByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (byte) i);
        }
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, (byte) 10);
        hashMap.put((byte) 11, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        ByteByteHashMap hashMap = new ByteByteHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (byte) i);
        }
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3);
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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ByteToByteFunction function = (byte byteParameter) -> byteParameter;
        hashMap.updateValue((byte) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((byte) 5, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((byte) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((byte) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((byte) 2, (byte) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        hashMap.getIfAbsentPut((byte) 2, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((byte) 5, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((byte) 2, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        ByteFunction0 function = () -> (byte) 5;
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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        ByteFunction<Byte> function = Byte::byteValue;
        hashMap.getIfAbsentPutWith((byte) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((byte) 5, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((byte) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        Assert.assertEquals(2, hashMap.getAndPut((byte) 2, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 0, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 0, (byte) 5, (byte) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 1, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((byte) 1, (byte) 11, (byte) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((byte) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((byte) 2, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        ByteToByteFunction function = (byte byteParameter) -> (byte) byteParameter;
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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((byte) 2, (byte) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableByteByteMap copyMap = new ByteByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (byte) i);
        }
        Verify.assertSize(8, copyMap);
        MutableByteByteMap hashMap = new ByteByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ByteByteHashMap hashMap0 = new ByteByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2), hashMap0);
        ByteByteHashMap hashMap1 = new ByteByteHashMap().withKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteByteHashMap hashMap2 = new ByteByteHashMap().withKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2), hashMap0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3), hashMap1);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        ByteByteHashMap hashMap = new ByteByteHashMap().withKeysValues((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableByteByteMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((byte) i));
            Assert.assertEquals(1L, hashMap.updateValue((byte) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((byte) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ByteByteMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteByteHashMapTest instance;

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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_byteIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ByteByteHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteByteHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ByteByteHashMapTest::keySet;
            this.payloads.values = ByteByteHashMapTest::values;
            this.payloads.containsAll = ByteByteHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ByteByteHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = ByteByteHashMapTest::isEmpty;
            this.payloads.notEmpty = ByteByteHashMapTest::notEmpty;
            this.payloads.testEquals = ByteByteHashMapTest::testEquals;
            this.payloads.testHashCode = ByteByteHashMapTest::testHashCode;
            this.payloads.testToString = ByteByteHashMapTest::testToString;
            this.payloads.forEach = ByteByteHashMapTest::forEach;
            this.payloads.forEachValue = ByteByteHashMapTest::forEachValue;
            this.payloads.forEachKey = ByteByteHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ByteByteHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ByteByteHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ByteByteHashMapTest::makeString;
            this.payloads.appendString = ByteByteHashMapTest::appendString;
            this.payloads.select = ByteByteHashMapTest::select;
            this.payloads.reject = ByteByteHashMapTest::reject;
            this.payloads.select_value = ByteByteHashMapTest::select_value;
            this.payloads.reject_value = ByteByteHashMapTest::reject_value;
            this.payloads.collect = ByteByteHashMapTest::collect;
            this.payloads.count = ByteByteHashMapTest::count;
            this.payloads.detectIfNone_value = ByteByteHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ByteByteHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ByteByteHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ByteByteHashMapTest::noneSatisfy;
            this.payloads.max = ByteByteHashMapTest::max;
            this.payloads.min = ByteByteHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteByteHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteByteHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ByteByteHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ByteByteHashMapTest::maxIfEmpty;
            this.payloads.sum = ByteByteHashMapTest::sum;
            this.payloads.average = ByteByteHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteByteHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ByteByteHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteByteHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ByteByteHashMapTest::toList;
            this.payloads.toSortedList = ByteByteHashMapTest::toSortedList;
            this.payloads.toSet = ByteByteHashMapTest::toSet;
            this.payloads.toBag = ByteByteHashMapTest::toBag;
            this.payloads.byteIterator = ByteByteHashMapTest::byteIterator;
            this.payloads.asLazy = ByteByteHashMapTest::asLazy;
            this.payloads.keysView = ByteByteHashMapTest::keysView;
            this.payloads.keyValuesView = ByteByteHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ByteByteHashMapTest::toSortedArray;
            this.payloads.toArray = ByteByteHashMapTest::toArray;
            this.payloads.toImmutable = ByteByteHashMapTest::toImmutable;
            this.payloads.chunk = ByteByteHashMapTest::chunk;
            this.payloads.get = ByteByteHashMapTest::get;
            this.payloads.getOrThrow = ByteByteHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = ByteByteHashMapTest::getIfAbsent;
            this.payloads.containsKey = ByteByteHashMapTest::containsKey;
            this.payloads.containsValue = ByteByteHashMapTest::containsValue;
            this.payloads.contains = ByteByteHashMapTest::contains;
            this.payloads.size = ByteByteHashMapTest::size;
            this.payloads.clear = ByteByteHashMapTest::clear;
            this.payloads.removeKey = ByteByteHashMapTest::removeKey;
            this.payloads.remove = ByteByteHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = ByteByteHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ByteByteHashMapTest::put;
            this.payloads.getAndPut = ByteByteHashMapTest::getAndPut;
            this.payloads.putPair = ByteByteHashMapTest::putPair;
            this.payloads.updateValues = ByteByteHashMapTest::updateValues;
            this.payloads.addToValue = ByteByteHashMapTest::addToValue;
            this.payloads.put_every_slot = ByteByteHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = ByteByteHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = ByteByteHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ByteByteHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ByteByteHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ByteByteHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ByteByteHashMapTest::updateValue;
            this.payloads.freeze = ByteByteHashMapTest::freeze;
            this.payloads.withoutKey = ByteByteHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ByteByteHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ByteByteHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ByteByteHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteByteHashMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = ByteByteHashMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ByteByteHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ByteByteHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = ByteByteHashMapTest::flipUniqueValues;
            this.payloads.serialize = ByteByteHashMapTest::serialize;
            this.payloads.serializeKeySet = ByteByteHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = ByteByteHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ByteByteHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteByteHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ByteByteHashMapTest::newMap;
            this.payloads.putWithRehash = ByteByteHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = ByteByteHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = ByteByteHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ByteByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ByteByteHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = ByteByteHashMapTest::testPutAll;
            this.payloads.withKeysValues = ByteByteHashMapTest::withKeysValues;
            this.payloads.injectInto = ByteByteHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = ByteByteHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ByteByteHashMapTest::classIsNonInstantiable;
        }
    }
}
