/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.lang.reflect.Field;
import java.util.Iterator;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.impl.factory.primitive.ObjectByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectByteHashMapTestCase extends AbstractMutableObjectByteMapTestCase {

    private final MutableObjectByteMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectByteMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectByteMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);
        MutableObjectByteMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        this.newMapWithInitialCapacity(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3);
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
        hashMap.remove(1.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        ByteToByteFunction function = (byte parameter) -> parameter;
        hashMap.updateValue(2.0f, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (byte) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, (byte) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        hashMap.getIfAbsentPut(2.0f, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        ByteFunction0 function = () -> (byte) 5;
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        ByteFunction<Integer> function = (Integer object) -> (byte) object.intValue();
        hashMap.getIfAbsentPutWith(2.0f, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPutWith(5.0f, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPutWith(2.0f, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.newWithKeysValues(2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4);
        ByteFunction<Float> function = (Float floatParameter) -> (byte) floatParameter.floatValue();
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectByteMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (byte) i);
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, (byte) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableObjectByteMap<String> map0 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent("1", (byte) 100));
        Assert.assertEquals(this.newWithKeysValues("0", (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent("0", (byte) 100));
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent("1", (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent("0", (byte) 100));
        MutableObjectByteMap<String> map1 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent("0", (byte) 100));
        Assert.assertEquals(this.newWithKeysValues("1", (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent("1", (byte) 100));
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent("0", (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent("1", (byte) 100));
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent("5", (byte) 100));
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent("50", (byte) 100));
        Assert.assertEquals(this.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2), this.map);
        Assert.assertEquals((byte) 0, this.map.removeKeyIfAbsent("0", (byte) 100));
        Assert.assertEquals(this.newWithKeysValues("1", (byte) 1, "2", (byte) 2), this.map);
        Assert.assertEquals((byte) 1, this.map.removeKeyIfAbsent("1", (byte) 100));
        Assert.assertEquals(this.newWithKeysValues("2", (byte) 2), this.map);
        Assert.assertEquals((byte) 2, this.map.removeKeyIfAbsent("2", (byte) 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent("0", (byte) 100));
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent("1", (byte) 100));
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent("2", (byte) 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0), (byte) 1);
        this.map.put(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1), (byte) 2);
        Assert.assertEquals((byte) 1, this.map.get(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, this.map.removeKeyIfAbsent(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals((byte) 0, this.map.get(AbstractMutableObjectByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 2, this.map.get(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, this.map.removeKeyIfAbsent(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals((byte) 0, this.map.get(AbstractMutableObjectByteMapTestCase.generateCollisions().get(1)));
        this.map.put(null, (byte) 3);
        Assert.assertEquals((byte) 3, this.map.get(null));
        Assert.assertEquals((byte) 3, this.map.removeKeyIfAbsent(null, (byte) 100));
        Assert.assertEquals((byte) 0, this.map.get(null));
    }

    @Test
    public void putWithRehash() throws Exception {
        MutableObjectByteMap<Byte> hashMap = this.getEmptyMap();
        for (byte each = 2; each < 10; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }
        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (byte each = 2; each < 10; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put((byte) 10, (byte) 10);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll() {
        MutableObjectByteMap<Byte> hashMap = this.getEmptyMap();
        MutableObjectByteMap<Byte> copyMap = this.getEmptyMap();
        for (byte each = 1; each < 11; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (byte each = 1; each < 11; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto() {
        MutableObjectByteMap<Integer> hashMap = this.newWithKeysValues(1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void put_every_slot() {
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void remove_iterator_every_slot() {
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals((byte) 9, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"));
            Assert.assertEquals((byte) 9, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        ByteFunction<Byte> function = Byte::byteValue;
        MutableObjectByteMap<Byte> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(each));
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        ByteFunction0 factory = () -> (byte) 100;
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals((byte) 100, hashMap.getIfAbsentPut(String.valueOf(each), factory));
            Assert.assertEquals((byte) 100, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void updateValue_every_slot() {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + 1);
        MutableObjectByteMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertEquals((byte) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction));
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectByteMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectByteHashMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_byteIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.byteIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
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
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
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
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_iterator_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_iterator_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectByteHashMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> byteIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectByteHashMapTestCase> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectByteHashMapTestCase::keySet;
            this.payloads.values = ObjectByteHashMapTestCase::values;
            this.payloads.isEmpty = ObjectByteHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ObjectByteHashMapTestCase::notEmpty;
            this.payloads.asLazy = ObjectByteHashMapTestCase::asLazy;
            this.payloads.testEquals = ObjectByteHashMapTestCase::testEquals;
            this.payloads.testHashCode = ObjectByteHashMapTestCase::testHashCode;
            this.payloads.testToString = ObjectByteHashMapTestCase::testToString;
            this.payloads.byteIterator = ObjectByteHashMapTestCase::byteIterator;
            this.payloads.forEach = ObjectByteHashMapTestCase::forEach;
            this.payloads.forEachValue = ObjectByteHashMapTestCase::forEachValue;
            this.payloads.forEachKey = ObjectByteHashMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = ObjectByteHashMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectByteHashMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = ObjectByteHashMapTestCase::makeString;
            this.payloads.appendString = ObjectByteHashMapTestCase::appendString;
            this.payloads.select = ObjectByteHashMapTestCase::select;
            this.payloads.reject = ObjectByteHashMapTestCase::reject;
            this.payloads.tap = ObjectByteHashMapTestCase::tap;
            this.payloads.count = ObjectByteHashMapTestCase::count;
            this.payloads.anySatisfy = ObjectByteHashMapTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectByteHashMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectByteHashMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = ObjectByteHashMapTestCase::detectIfNone;
            this.payloads.collect = ObjectByteHashMapTestCase::collect;
            this.payloads.sum = ObjectByteHashMapTestCase::sum;
            this.payloads.max = ObjectByteHashMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectByteHashMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectByteHashMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectByteHashMapTestCase::minIfEmpty;
            this.payloads.average = ObjectByteHashMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectByteHashMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectByteHashMapTestCase::toArray;
            this.payloads.toSortedArray = ObjectByteHashMapTestCase::toSortedArray;
            this.payloads.containsAll = ObjectByteHashMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = ObjectByteHashMapTestCase::containsAll_Iterable;
            this.payloads.toList = ObjectByteHashMapTestCase::toList;
            this.payloads.toSortedList = ObjectByteHashMapTestCase::toSortedList;
            this.payloads.toSet = ObjectByteHashMapTestCase::toSet;
            this.payloads.toBag = ObjectByteHashMapTestCase::toBag;
            this.payloads.toImmutable = ObjectByteHashMapTestCase::toImmutable;
            this.payloads.clear = ObjectByteHashMapTestCase::clear;
            this.payloads.removeKey = ObjectByteHashMapTestCase::removeKey;
            this.payloads.remove = ObjectByteHashMapTestCase::remove;
            this.payloads.put = ObjectByteHashMapTestCase::put;
            this.payloads.updateValues = ObjectByteHashMapTestCase::updateValues;
            this.payloads.putPair = ObjectByteHashMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectByteHashMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectByteHashMapTestCase::get;
            this.payloads.getOrThrow = ObjectByteHashMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = ObjectByteHashMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectByteHashMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectByteHashMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectByteHashMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectByteHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectByteHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectByteHashMapTestCase::updateValue;
            this.payloads.addToValue = ObjectByteHashMapTestCase::addToValue;
            this.payloads.containsKey = ObjectByteHashMapTestCase::containsKey;
            this.payloads.containsValue = ObjectByteHashMapTestCase::containsValue;
            this.payloads.size = ObjectByteHashMapTestCase::size;
            this.payloads.withKeysValues = ObjectByteHashMapTestCase::withKeysValues;
            this.payloads.withoutKey = ObjectByteHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ObjectByteHashMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectByteHashMapTestCase::withAllKeyValues;
            this.payloads.contains = ObjectByteHashMapTestCase::contains;
            this.payloads.asUnmodifiable = ObjectByteHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ObjectByteHashMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = ObjectByteHashMapTestCase::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectByteHashMapTestCase::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectByteHashMapTestCase::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectByteHashMapTestCase::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectByteHashMapTestCase::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectByteHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectByteHashMapTestCase::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectByteHashMapTestCase::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectByteHashMapTestCase::putWithRehash;
            this.payloads.testPutAll = ObjectByteHashMapTestCase::testPutAll;
            this.payloads.injectInto = ObjectByteHashMapTestCase::injectInto;
            this.payloads.put_every_slot = ObjectByteHashMapTestCase::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectByteHashMapTestCase::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectByteHashMapTestCase::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectByteHashMapTestCase::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectByteHashMapTestCase::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectByteHashMapTestCase::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectByteHashMapTestCase::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectByteHashMapTestCase::classIsNonInstantiable;
        }
    }
}
