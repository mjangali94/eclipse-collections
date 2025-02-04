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
import org.eclipse.collections.api.block.function.primitive.CharToIntFunction;
import org.eclipse.collections.impl.factory.primitive.CharIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharIntHashMapTest extends AbstractMutableCharIntMapTestCase {

    @Override
    protected CharIntHashMap classUnderTest() {
        return CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32);
    }

    @Override
    protected CharIntHashMap newWithKeysValues(char key1, int value1) {
        return new CharIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharIntHashMap newWithKeysValues(char key1, int value1, char key2, int value2) {
        return new CharIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharIntHashMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3) {
        return new CharIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharIntHashMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3, char key4, int value4) {
        return new CharIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharIntHashMap getEmptyMap() {
        return new CharIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = CharIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharIntHashMap hashMap = new CharIntHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = CharIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharIntHashMap hashMap = new CharIntHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);
        CharIntHashMap hashMap2 = new CharIntHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = CharIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharIntHashMap hashMap = new CharIntHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        CharIntHashMap hashMap = new CharIntHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, i);
        }
        Field keys = CharIntHashMap.class.getDeclaredField("keys");
        Field values = CharIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, 10);
        hashMap.put((char) 11, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception {
        CharIntHashMap hashMap = new CharIntHashMap();
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, i);
        }
        Field keys = CharIntHashMap.class.getDeclaredField("keys");
        Field values = CharIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3);
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
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
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
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        IntToIntFunction function = (int intParameter) -> intParameter;
        hashMap.updateValue((char) 2, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue((char) 5, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue((char) 2, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = new CharIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((char) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put((char) 2, 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
        hashMap.getIfAbsentPut((char) 2, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut((char) 5, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut((char) 2, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
        IntFunction0 function = () -> 5;
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
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
        IntFunction<Integer> function = Integer::intValue;
        hashMap.getIfAbsentPutWith((char) 2, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith((char) 5, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith((char) 2, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsGetAndPut() throws Exception {
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
        Assert.assertEquals(2, hashMap.getAndPut((char) 2, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 0, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((char) 0, 5, 70));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 1, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(5, hashMap.getAndPut((char) 1, 11, 60));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.removeKey((char) 2);
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(50, hashMap.getAndPut((char) 2, 5, 50));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = CharIntHashMap.newWithKeysValues((char) 2, 2, (char) 3, 3, (char) 4, 4);
        CharToIntFunction function = (char charParameter) -> (int) charParameter;
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
        Field occupiedWithData = CharIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharIntHashMap hashMap = new CharIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }
        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put((char) 2, 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll() {
        MutableCharIntMap copyMap = new CharIntHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, i);
        }
        Verify.assertSize(8, copyMap);
        MutableCharIntMap hashMap = new CharIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }
        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        CharIntHashMap hashMap0 = new CharIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, 1, (char) 2, 2), hashMap0);
        CharIntHashMap hashMap1 = new CharIntHashMap().withKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        CharIntHashMap hashMap2 = new CharIntHashMap().withKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3, (char) 4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2), hashMap0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3), hashMap1);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3, (char) 4, 4), hashMap2);
    }

    @Test
    public void injectInto() {
        CharIntHashMap hashMap = new CharIntHashMap().withKeysValues((char) 1, 2, (char) 2, 3, (char) 3, 4, (char) 4, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableCharIntMap hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++) {
            Assert.assertEquals(0, hashMap.get((char) i));
            Assert.assertEquals(1L, hashMap.updateValue((char) i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get((char) i));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(CharIntMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharIntHashMapTest instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new CharIntHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> removeWithoutRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsGetAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharIntHashMapTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = CharIntHashMapTest::keySet;
            this.payloads.values = CharIntHashMapTest::values;
            this.payloads.containsAll = CharIntHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = CharIntHashMapTest::containsAll_Iterable;
            this.payloads.isEmpty = CharIntHashMapTest::isEmpty;
            this.payloads.notEmpty = CharIntHashMapTest::notEmpty;
            this.payloads.testEquals = CharIntHashMapTest::testEquals;
            this.payloads.testHashCode = CharIntHashMapTest::testHashCode;
            this.payloads.testToString = CharIntHashMapTest::testToString;
            this.payloads.forEach = CharIntHashMapTest::forEach;
            this.payloads.forEachValue = CharIntHashMapTest::forEachValue;
            this.payloads.forEachKey = CharIntHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = CharIntHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = CharIntHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = CharIntHashMapTest::makeString;
            this.payloads.appendString = CharIntHashMapTest::appendString;
            this.payloads.select = CharIntHashMapTest::select;
            this.payloads.reject = CharIntHashMapTest::reject;
            this.payloads.select_value = CharIntHashMapTest::select_value;
            this.payloads.reject_value = CharIntHashMapTest::reject_value;
            this.payloads.collect = CharIntHashMapTest::collect;
            this.payloads.count = CharIntHashMapTest::count;
            this.payloads.detectIfNone_value = CharIntHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = CharIntHashMapTest::anySatisfy;
            this.payloads.allSatisfy = CharIntHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = CharIntHashMapTest::noneSatisfy;
            this.payloads.max = CharIntHashMapTest::max;
            this.payloads.min = CharIntHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = CharIntHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = CharIntHashMapTest::maxIfEmpty;
            this.payloads.sum = CharIntHashMapTest::sum;
            this.payloads.average = CharIntHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = CharIntHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = CharIntHashMapTest::toList;
            this.payloads.toSortedList = CharIntHashMapTest::toSortedList;
            this.payloads.toSet = CharIntHashMapTest::toSet;
            this.payloads.toBag = CharIntHashMapTest::toBag;
            this.payloads.intIterator = CharIntHashMapTest::intIterator;
            this.payloads.asLazy = CharIntHashMapTest::asLazy;
            this.payloads.keysView = CharIntHashMapTest::keysView;
            this.payloads.keyValuesView = CharIntHashMapTest::keyValuesView;
            this.payloads.toSortedArray = CharIntHashMapTest::toSortedArray;
            this.payloads.toArray = CharIntHashMapTest::toArray;
            this.payloads.toImmutable = CharIntHashMapTest::toImmutable;
            this.payloads.chunk = CharIntHashMapTest::chunk;
            this.payloads.get = CharIntHashMapTest::get;
            this.payloads.getOrThrow = CharIntHashMapTest::getOrThrow;
            this.payloads.getIfAbsent = CharIntHashMapTest::getIfAbsent;
            this.payloads.containsKey = CharIntHashMapTest::containsKey;
            this.payloads.containsValue = CharIntHashMapTest::containsValue;
            this.payloads.contains = CharIntHashMapTest::contains;
            this.payloads.size = CharIntHashMapTest::size;
            this.payloads.clear = CharIntHashMapTest::clear;
            this.payloads.removeKey = CharIntHashMapTest::removeKey;
            this.payloads.remove = CharIntHashMapTest::remove;
            this.payloads.removeKeyIfAbsent = CharIntHashMapTest::removeKeyIfAbsent;
            this.payloads.put = CharIntHashMapTest::put;
            this.payloads.getAndPut = CharIntHashMapTest::getAndPut;
            this.payloads.putPair = CharIntHashMapTest::putPair;
            this.payloads.updateValues = CharIntHashMapTest::updateValues;
            this.payloads.addToValue = CharIntHashMapTest::addToValue;
            this.payloads.put_every_slot = CharIntHashMapTest::put_every_slot;
            this.payloads.putDuplicateWithRemovedSlot = CharIntHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.getIfAbsentPut = CharIntHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = CharIntHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = CharIntHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = CharIntHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = CharIntHashMapTest::updateValue;
            this.payloads.freeze = CharIntHashMapTest::freeze;
            this.payloads.withoutKey = CharIntHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = CharIntHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = CharIntHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = CharIntHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = CharIntHashMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = CharIntHashMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = CharIntHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = CharIntHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = CharIntHashMapTest::flipUniqueValues;
            this.payloads.serialize = CharIntHashMapTest::serialize;
            this.payloads.serializeKeySet = CharIntHashMapTest::serializeKeySet;
            this.payloads.defaultInitialCapacity = CharIntHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = CharIntHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharIntHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = CharIntHashMapTest::newMap;
            this.payloads.putWithRehash = CharIntHashMapTest::putWithRehash;
            this.payloads.removeWithoutRehash = CharIntHashMapTest::removeWithoutRehash;
            this.payloads.occupiedWithDataAndSentinelsOnClear = CharIntHashMapTest::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = CharIntHashMapTest::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = CharIntHashMapTest::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = CharIntHashMapTest::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = CharIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = CharIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = CharIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsGetAndPut = CharIntHashMapTest::occupiedWithDataAndSentinelsGetAndPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = CharIntHashMapTest::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = CharIntHashMapTest::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.testPutAll = CharIntHashMapTest::testPutAll;
            this.payloads.withKeysValues = CharIntHashMapTest::withKeysValues;
            this.payloads.injectInto = CharIntHashMapTest::injectInto;
            this.payloads.updateValue_every_slot = CharIntHashMapTest::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = CharIntHashMapTest::classIsNonInstantiable;
        }
    }
}
