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
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectFloatHashMapTestCase extends AbstractMutableObjectFloatMapTestCase {

    private final MutableObjectFloatMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectFloatMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectFloatMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);
        MutableObjectFloatMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
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
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f);
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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        FloatToFloatFunction function = (float parameter) -> parameter;
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (float) i);
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
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
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        FloatFunction<Integer> function = (Integer object) -> (float) object.intValue();
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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);
        FloatFunction<Float> function = (Float floatParameter) -> (float) floatParameter.floatValue();
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
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (float) i);
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
    public void removeKeyIfAbsent() {
        MutableObjectFloatMap<String> map0 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("0", 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent("0", 100.0f), 0.0f);
        MutableObjectFloatMap<String> map1 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("1", 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("5", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("50", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f), this.map);
        Assert.assertEquals(0.0f, this.map.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("1", 1.0f, "2", 2.0f), this.map);
        Assert.assertEquals(1.0f, this.map.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("2", 2.0f), this.map);
        Assert.assertEquals(2.0f, this.map.removeKeyIfAbsent("2", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("2", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0), 1.0f);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1), 2.0f);
        Assert.assertEquals(1.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0)), 0.0f);
        Assert.assertEquals(1.0f, this.map.removeKeyIfAbsent(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0)), 0.0f);
        Assert.assertEquals(2.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1)), 0.0f);
        Assert.assertEquals(2.0f, this.map.removeKeyIfAbsent(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1)), 0.0f);
        this.map.put(null, 3.0f);
        Assert.assertEquals(3.0f, this.map.get(null), 0.0f);
        Assert.assertEquals(3.0f, this.map.removeKeyIfAbsent(null, 100.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.get(null), 0.0f);
    }

    @Test
    public void putWithRehash() throws Exception {
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        for (float each = 2; each < 10; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }
        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (float each = 2; each < 10; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put(10.0f, 10.0f);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll() {
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        MutableObjectFloatMap<Float> copyMap = this.getEmptyMap();
        for (float each = 1; each < 11; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (float each = 1; each < 11; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto() {
        MutableObjectFloatMap<Integer> hashMap = this.newWithKeysValues(1, 2.0f, 2, 3.0f, 3, 4.0f, 4, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void put_every_slot() {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void remove_iterator_every_slot() {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        FloatFunction<String> functionLength = (String string) -> string.length();
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            Assert.assertEquals(9.0f, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"), 0.0f);
            Assert.assertEquals(9.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        FloatFunction<Float> function = Float::floatValue;
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(each), 0.0f);
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function), 0.0f);
            Assert.assertEquals(each, hashMap.get(each), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        FloatFunction0 factory = () -> 100.0f;
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            Assert.assertEquals(100.0f, hashMap.getIfAbsentPut(String.valueOf(each), factory), 0.0f);
            Assert.assertEquals(100.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void updateValue_every_slot() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1;
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction), 0.0f);
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectFloatMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectFloatHashMapTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
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
        public void benchmark_getIfAbsentPut_Value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
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
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occupiedWithSentinelsOnPutRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occupiedWithSentinelsOnPutRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_iterator_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_iterator_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectFloatHashMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectFloatHashMapTestCase> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectFloatHashMapTestCase::keySet;
            this.payloads.values = ObjectFloatHashMapTestCase::values;
            this.payloads.isEmpty = ObjectFloatHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ObjectFloatHashMapTestCase::notEmpty;
            this.payloads.asLazy = ObjectFloatHashMapTestCase::asLazy;
            this.payloads.testEquals = ObjectFloatHashMapTestCase::testEquals;
            this.payloads.testHashCode = ObjectFloatHashMapTestCase::testHashCode;
            this.payloads.testToString = ObjectFloatHashMapTestCase::testToString;
            this.payloads.floatIterator = ObjectFloatHashMapTestCase::floatIterator;
            this.payloads.forEach = ObjectFloatHashMapTestCase::forEach;
            this.payloads.forEachValue = ObjectFloatHashMapTestCase::forEachValue;
            this.payloads.forEachKey = ObjectFloatHashMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = ObjectFloatHashMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectFloatHashMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = ObjectFloatHashMapTestCase::makeString;
            this.payloads.appendString = ObjectFloatHashMapTestCase::appendString;
            this.payloads.select = ObjectFloatHashMapTestCase::select;
            this.payloads.reject = ObjectFloatHashMapTestCase::reject;
            this.payloads.tap = ObjectFloatHashMapTestCase::tap;
            this.payloads.count = ObjectFloatHashMapTestCase::count;
            this.payloads.anySatisfy = ObjectFloatHashMapTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectFloatHashMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectFloatHashMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = ObjectFloatHashMapTestCase::detectIfNone;
            this.payloads.collect = ObjectFloatHashMapTestCase::collect;
            this.payloads.sum = ObjectFloatHashMapTestCase::sum;
            this.payloads.max = ObjectFloatHashMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectFloatHashMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectFloatHashMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectFloatHashMapTestCase::minIfEmpty;
            this.payloads.average = ObjectFloatHashMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectFloatHashMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectFloatHashMapTestCase::toArray;
            this.payloads.toSortedArray = ObjectFloatHashMapTestCase::toSortedArray;
            this.payloads.containsAll = ObjectFloatHashMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = ObjectFloatHashMapTestCase::containsAll_Iterable;
            this.payloads.toList = ObjectFloatHashMapTestCase::toList;
            this.payloads.toSortedList = ObjectFloatHashMapTestCase::toSortedList;
            this.payloads.toSet = ObjectFloatHashMapTestCase::toSet;
            this.payloads.toBag = ObjectFloatHashMapTestCase::toBag;
            this.payloads.toImmutable = ObjectFloatHashMapTestCase::toImmutable;
            this.payloads.clear = ObjectFloatHashMapTestCase::clear;
            this.payloads.removeKey = ObjectFloatHashMapTestCase::removeKey;
            this.payloads.remove = ObjectFloatHashMapTestCase::remove;
            this.payloads.put = ObjectFloatHashMapTestCase::put;
            this.payloads.updateValues = ObjectFloatHashMapTestCase::updateValues;
            this.payloads.putPair = ObjectFloatHashMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectFloatHashMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectFloatHashMapTestCase::get;
            this.payloads.getOrThrow = ObjectFloatHashMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = ObjectFloatHashMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectFloatHashMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectFloatHashMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectFloatHashMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectFloatHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectFloatHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectFloatHashMapTestCase::updateValue;
            this.payloads.addToValue = ObjectFloatHashMapTestCase::addToValue;
            this.payloads.containsKey = ObjectFloatHashMapTestCase::containsKey;
            this.payloads.containsValue = ObjectFloatHashMapTestCase::containsValue;
            this.payloads.size = ObjectFloatHashMapTestCase::size;
            this.payloads.withKeysValues = ObjectFloatHashMapTestCase::withKeysValues;
            this.payloads.withoutKey = ObjectFloatHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ObjectFloatHashMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectFloatHashMapTestCase::withAllKeyValues;
            this.payloads.contains = ObjectFloatHashMapTestCase::contains;
            this.payloads.asUnmodifiable = ObjectFloatHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ObjectFloatHashMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = ObjectFloatHashMapTestCase::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectFloatHashMapTestCase::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectFloatHashMapTestCase::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectFloatHashMapTestCase::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectFloatHashMapTestCase::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectFloatHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectFloatHashMapTestCase::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectFloatHashMapTestCase::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectFloatHashMapTestCase::putWithRehash;
            this.payloads.testPutAll = ObjectFloatHashMapTestCase::testPutAll;
            this.payloads.injectInto = ObjectFloatHashMapTestCase::injectInto;
            this.payloads.put_every_slot = ObjectFloatHashMapTestCase::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectFloatHashMapTestCase::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectFloatHashMapTestCase::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectFloatHashMapTestCase::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectFloatHashMapTestCase::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectFloatHashMapTestCase::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectFloatHashMapTestCase::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectFloatHashMapTestCase::classIsNonInstantiable;
        }
    }
}
