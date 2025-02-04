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
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectDoubleHashMapTestCase extends AbstractMutableObjectDoubleMapTestCase {

    private final MutableObjectDoubleMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectDoubleMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectDoubleMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);
        MutableObjectDoubleMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
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
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0);
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
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
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
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        DoubleToDoubleFunction function = (double parameter) -> parameter;
        hashMap.updateValue(2.0f, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectDoubleMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (double) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, 9.0);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        hashMap.getIfAbsentPut(2.0f, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        DoubleFunction0 function = () -> 5.0;
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
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        DoubleFunction<Integer> function = (Integer object) -> (double) object.intValue();
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
        MutableObjectDoubleMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        DoubleFunction<Float> function = (Float floatParameter) -> (double) floatParameter.floatValue();
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
        MutableObjectDoubleMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (double) i);
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, 3.0);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableObjectDoubleMap<String> map0 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent("1", 100.0), 0.0);
        Assert.assertEquals(this.newWithKeysValues("0", 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent("0", 100.0), 0.0);
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent("1", 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent("0", 100.0), 0.0);
        MutableObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent("0", 100.0), 0.0);
        Assert.assertEquals(this.newWithKeysValues("1", 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent("1", 100.0), 0.0);
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent("0", 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent("1", 100.0), 0.0);
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent("5", 100.0), 0.0);
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent("50", 100.0), 0.0);
        Assert.assertEquals(this.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0), this.map);
        Assert.assertEquals(0.0, this.map.removeKeyIfAbsent("0", 100.0), 0.0);
        Assert.assertEquals(this.newWithKeysValues("1", 1.0, "2", 2.0), this.map);
        Assert.assertEquals(1.0, this.map.removeKeyIfAbsent("1", 100.0), 0.0);
        Assert.assertEquals(this.newWithKeysValues("2", 2.0), this.map);
        Assert.assertEquals(2.0, this.map.removeKeyIfAbsent("2", 100.0), 0.0);
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent("0", 100.0), 0.0);
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent("1", 100.0), 0.0);
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent("2", 100.0), 0.0);
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0), 1.0);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1), 2.0);
        Assert.assertEquals(1.0, this.map.get(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, this.map.removeKeyIfAbsent(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(2.0, this.map.get(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, this.map.removeKeyIfAbsent(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        this.map.put(null, 3.0);
        Assert.assertEquals(3.0, this.map.get(null), 0.0);
        Assert.assertEquals(3.0, this.map.removeKeyIfAbsent(null, 100.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(null), 0.0);
    }

    @Test
    public void putWithRehash() throws Exception {
        MutableObjectDoubleMap<Double> hashMap = this.getEmptyMap();
        for (double each = 2; each < 10; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }
        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (double each = 2; each < 10; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put(10.0, 10.0);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll() {
        MutableObjectDoubleMap<Double> hashMap = this.getEmptyMap();
        MutableObjectDoubleMap<Double> copyMap = this.getEmptyMap();
        for (double each = 1; each < 11; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (double each = 1; each < 11; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto() {
        MutableObjectDoubleMap<Integer> hashMap = this.newWithKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void put_every_slot() {
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)), 0.0);
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
        }
    }

    @Test
    public void remove_iterator_every_slot() {
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)), 0.0);
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        DoubleFunction<String> functionLength = (String string) -> string.length();
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
            Assert.assertEquals(9.0, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"), 0.0);
            Assert.assertEquals(9.0, hashMap.get(String.valueOf(each)), 0.0);
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        DoubleFunction<Double> function = Double::doubleValue;
        MutableObjectDoubleMap<Double> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(each), 0.0);
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function), 0.0);
            Assert.assertEquals(each, hashMap.get(each), 0.0);
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        DoubleFunction0 factory = () -> 100.0;
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
            Assert.assertEquals(100.0, hashMap.getIfAbsentPut(String.valueOf(each), factory), 0.0);
            Assert.assertEquals(100.0, hashMap.get(String.valueOf(each)), 0.0);
        }
    }

    @Test
    public void updateValue_every_slot() {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1;
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertEquals(0.0, hashMap.get(String.valueOf(each)), 0.0);
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction), 0.0);
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectDoubleMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectDoubleHashMapTestCase instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectDoubleHashMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectDoubleHashMapTestCase> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectDoubleHashMapTestCase::keySet;
            this.payloads.values = ObjectDoubleHashMapTestCase::values;
            this.payloads.isEmpty = ObjectDoubleHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ObjectDoubleHashMapTestCase::notEmpty;
            this.payloads.asLazy = ObjectDoubleHashMapTestCase::asLazy;
            this.payloads.testEquals = ObjectDoubleHashMapTestCase::testEquals;
            this.payloads.testHashCode = ObjectDoubleHashMapTestCase::testHashCode;
            this.payloads.testToString = ObjectDoubleHashMapTestCase::testToString;
            this.payloads.doubleIterator = ObjectDoubleHashMapTestCase::doubleIterator;
            this.payloads.forEach = ObjectDoubleHashMapTestCase::forEach;
            this.payloads.forEachValue = ObjectDoubleHashMapTestCase::forEachValue;
            this.payloads.forEachKey = ObjectDoubleHashMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = ObjectDoubleHashMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectDoubleHashMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = ObjectDoubleHashMapTestCase::makeString;
            this.payloads.appendString = ObjectDoubleHashMapTestCase::appendString;
            this.payloads.select = ObjectDoubleHashMapTestCase::select;
            this.payloads.reject = ObjectDoubleHashMapTestCase::reject;
            this.payloads.tap = ObjectDoubleHashMapTestCase::tap;
            this.payloads.count = ObjectDoubleHashMapTestCase::count;
            this.payloads.anySatisfy = ObjectDoubleHashMapTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectDoubleHashMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectDoubleHashMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = ObjectDoubleHashMapTestCase::detectIfNone;
            this.payloads.collect = ObjectDoubleHashMapTestCase::collect;
            this.payloads.sum = ObjectDoubleHashMapTestCase::sum;
            this.payloads.max = ObjectDoubleHashMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectDoubleHashMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectDoubleHashMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectDoubleHashMapTestCase::minIfEmpty;
            this.payloads.average = ObjectDoubleHashMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectDoubleHashMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectDoubleHashMapTestCase::toArray;
            this.payloads.toSortedArray = ObjectDoubleHashMapTestCase::toSortedArray;
            this.payloads.containsAll = ObjectDoubleHashMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = ObjectDoubleHashMapTestCase::containsAll_Iterable;
            this.payloads.toList = ObjectDoubleHashMapTestCase::toList;
            this.payloads.toSortedList = ObjectDoubleHashMapTestCase::toSortedList;
            this.payloads.toSet = ObjectDoubleHashMapTestCase::toSet;
            this.payloads.toBag = ObjectDoubleHashMapTestCase::toBag;
            this.payloads.toImmutable = ObjectDoubleHashMapTestCase::toImmutable;
            this.payloads.clear = ObjectDoubleHashMapTestCase::clear;
            this.payloads.removeKey = ObjectDoubleHashMapTestCase::removeKey;
            this.payloads.remove = ObjectDoubleHashMapTestCase::remove;
            this.payloads.put = ObjectDoubleHashMapTestCase::put;
            this.payloads.updateValues = ObjectDoubleHashMapTestCase::updateValues;
            this.payloads.putPair = ObjectDoubleHashMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectDoubleHashMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectDoubleHashMapTestCase::get;
            this.payloads.getOrThrow = ObjectDoubleHashMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = ObjectDoubleHashMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectDoubleHashMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectDoubleHashMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectDoubleHashMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectDoubleHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectDoubleHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectDoubleHashMapTestCase::updateValue;
            this.payloads.addToValue = ObjectDoubleHashMapTestCase::addToValue;
            this.payloads.containsKey = ObjectDoubleHashMapTestCase::containsKey;
            this.payloads.containsValue = ObjectDoubleHashMapTestCase::containsValue;
            this.payloads.size = ObjectDoubleHashMapTestCase::size;
            this.payloads.withKeysValues = ObjectDoubleHashMapTestCase::withKeysValues;
            this.payloads.withoutKey = ObjectDoubleHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ObjectDoubleHashMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectDoubleHashMapTestCase::withAllKeyValues;
            this.payloads.contains = ObjectDoubleHashMapTestCase::contains;
            this.payloads.asUnmodifiable = ObjectDoubleHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ObjectDoubleHashMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = ObjectDoubleHashMapTestCase::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectDoubleHashMapTestCase::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectDoubleHashMapTestCase::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectDoubleHashMapTestCase::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectDoubleHashMapTestCase::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectDoubleHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectDoubleHashMapTestCase::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectDoubleHashMapTestCase::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectDoubleHashMapTestCase::putWithRehash;
            this.payloads.testPutAll = ObjectDoubleHashMapTestCase::testPutAll;
            this.payloads.injectInto = ObjectDoubleHashMapTestCase::injectInto;
            this.payloads.put_every_slot = ObjectDoubleHashMapTestCase::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectDoubleHashMapTestCase::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectDoubleHashMapTestCase::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectDoubleHashMapTestCase::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectDoubleHashMapTestCase::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectDoubleHashMapTestCase::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectDoubleHashMapTestCase::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectDoubleHashMapTestCase::classIsNonInstantiable;
        }
    }
}
