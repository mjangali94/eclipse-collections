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
import org.eclipse.collections.api.block.function.primitive.CharToByteFunction;
import org.eclipse.collections.impl.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharByteHashMapTest extends AbstractMutableCharByteMapTestCase {

    @Override
    protected CharByteHashMap classUnderTest() {
        return CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1) {
        return new CharByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2) {
        return new CharByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3) {
        return new CharByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3, char key4, byte value4) {
        return new CharByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharByteHashMap getEmptyMap() {
        return new CharByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);
        CharByteHashMap hashMap2 = new CharByteHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        CharByteHashMap hashMap = new CharByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (byte) i);
        }
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        Field values = CharByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, (byte) 10);
        hashMap.put((char) 11, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        CharByteHashMap hashMap = new CharByteHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, (byte) i);
        }
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        Field values = CharByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 0; i < 4; i++) {
            hashMap.remove((char) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }
        hashMap.remove((char) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));
        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove((char) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ByteToByteFunction function = (byte byteParameter) -> byteParameter;
        hashMap.updateValue((char) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((char) 5, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((char) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((char) 2, (byte) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        hashMap.getIfAbsentPut((char) 2, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((char) 5, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((char) 2, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        ByteFunction0 function = () -> (byte) 5;
        hashMap.getIfAbsentPut((char) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((char) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((char) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        ByteFunction<Byte> function = Byte::byteValue;
        hashMap.getIfAbsentPutWith((char) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((char) 5, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((char) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        Assert.assertEquals(2, hashMap.getAndPut((char) 2, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 0, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((char) 0, (byte) 5, (byte) 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 1, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((char) 1, (byte) 11, (byte) 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((char) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 2, (byte) 5, (byte) 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        CharToByteFunction function = (char charParameter) -> (byte) charParameter;
        hashMap.getIfAbsentPutWithKey((char) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWithKey((char) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWithKey((char) 2, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((char) 2, (byte) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableCharByteMap copyMap = new CharByteHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (byte) i);
        }
        Verify.assertSize(8, copyMap);
        MutableCharByteMap hashMap = new CharByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        CharByteHashMap hashMap0 = new CharByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2), hashMap0);
        CharByteHashMap hashMap1 = new CharByteHashMap().withKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3);
        CharByteHashMap hashMap2 = new CharByteHashMap().withKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2), hashMap0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3), hashMap1);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto() {
        CharByteHashMap hashMap = new CharByteHashMap().withKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        MutableCharByteMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals((byte) 0, hashMap.get((char) i));
            Assert.assertEquals(1L, hashMap.updateValue((char) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((char) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharByteMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharByteHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new CharByteHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> byteIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharByteHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = CharByteHashMapTest::keySet;
            this.payloads.values = CharByteHashMapTest::values;
            this.payloads.containsAll = CharByteHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = CharByteHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = CharByteHashMapTest::isEmpty;
            this.payloads.notEmpty = CharByteHashMapTest::notEmpty;
            this.payloads.testEquals = CharByteHashMapTest::testEquals;
            this.payloads.testHashCode = CharByteHashMapTest::testHashCode;
            this.payloads.testToString = CharByteHashMapTest::testToString;
            this.payloads.forEach = CharByteHashMapTest::forEach;
            this.payloads.forEachValue = CharByteHashMapTest::forEachValue;
            this.payloads.forEachKey = CharByteHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = CharByteHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = CharByteHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = CharByteHashMapTest::makeString;
            this.payloads.appendString = CharByteHashMapTest::appendString;
            this.payloads.select = CharByteHashMapTest::select;
            this.payloads.reject = CharByteHashMapTest::reject;
            this.payloads.select_value = CharByteHashMapTest::select_value;
            this.payloads.reject_value = CharByteHashMapTest::reject_value;
            this.payloads.collect = CharByteHashMapTest::collect;
            this.payloads.count = CharByteHashMapTest::count;
            this.payloads.detectIfNone_value = CharByteHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = CharByteHashMapTest::anySatisfy;
            this.payloads.allSatisfy = CharByteHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = CharByteHashMapTest::noneSatisfy;
            this.payloads.max = CharByteHashMapTest::max;
            this.payloads.min = CharByteHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharByteHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharByteHashMapTest::maxIfEmpty;
            this.payloads.sum = CharByteHashMapTest::sum;
            this.payloads.average = CharByteHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CharByteHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = CharByteHashMapTest::toList;
            this.payloads.toSortedList = CharByteHashMapTest::toSortedList;
            this.payloads.toSet = CharByteHashMapTest::toSet;
            this.payloads.toBag = CharByteHashMapTest::toBag;
            this.payloads.byteIterator = CharByteHashMapTest::byteIterator;
            this.payloads.asLazy = CharByteHashMapTest::asLazy;
            this.payloads.keysView = CharByteHashMapTest::keysView;
            this.payloads.keyValuesView = CharByteHashMapTest::keyValuesView;
            this.payloads.toSortedArray = CharByteHashMapTest::toSortedArray;
            this.payloads.toArray = CharByteHashMapTest::toArray;
            this.payloads.toImmutable = CharByteHashMapTest::toImmutable;
            this.payloads.chunk = CharByteHashMapTest::chunk;
            this.payloads.get = CharByteHashMapTest::get;
            this.payloads.getOrThrow = CharByteHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = CharByteHashMapTest::getIfAbsent;
            this.payloads.containsKey = CharByteHashMapTest::containsKey;
            this.payloads.containsValue = CharByteHashMapTest::containsValue;
            this.payloads.contains = CharByteHashMapTest::contains;
            this.payloads.size = CharByteHashMapTest::size;
            this.payloads.clear = CharByteHashMapTest::clear;
            this.payloads.removeKey = CharByteHashMapTest::removeKey;
            this.payloads.remove = CharByteHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = CharByteHashMapTest::removeKeyIfAbsent;
            this.payloads.put = CharByteHashMapTest::put;
            this.payloads.getAndPut = CharByteHashMapTest::getAndPut;
            this.payloads.putPair = CharByteHashMapTest::putPair;
            this.payloads.updateValues = CharByteHashMapTest::updateValues;
            this.payloads.addToValue = CharByteHashMapTest::addToValue;
            this.payloads.put_every_slot = CharByteHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = CharByteHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = CharByteHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = CharByteHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = CharByteHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = CharByteHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = CharByteHashMapTest::updateValue;
            this.payloads.freeze = CharByteHashMapTest::freeze;
            this.payloads.withoutKey = CharByteHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = CharByteHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = CharByteHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = CharByteHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = CharByteHashMapTest::asUnmodifiable;
            this.payloads.byteIterator_with_remove = CharByteHashMapTest::byteIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = CharByteHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = CharByteHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = CharByteHashMapTest::flipUniqueValues;
            this.payloads.serialize = CharByteHashMapTest::serialize;
            this.payloads.serializeKeySet = CharByteHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = CharByteHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = CharByteHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharByteHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = CharByteHashMapTest::newMap;
            this.payloads.putWithRehash = CharByteHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = CharByteHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = CharByteHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = CharByteHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = CharByteHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = CharByteHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = CharByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = CharByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = CharByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = CharByteHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = CharByteHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = CharByteHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = CharByteHashMapTest::testPutAll;
            this.payloads.withKeysValues = CharByteHashMapTest::withKeysValues;
            this.payloads.injectInto = CharByteHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = CharByteHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = CharByteHashMapTest::classIsNonInstantiable;
        }
    }
}
