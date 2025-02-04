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
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectIntHashMapTestCase extends AbstractMutableObjectIntMapTestCase {

    private final MutableObjectIntMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectIntMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectIntMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);
        MutableObjectIntMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
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
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3);
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
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
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
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        IntToIntFunction function = (int parameter) -> parameter;
        hashMap.updateValue(2.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
        hashMap.getIfAbsentPut(2.0f, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
        IntFunction0 function = () -> 5;
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
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
        IntFunction<Integer> function = (Integer object) -> (int) object.intValue();
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
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);
        IntFunction<Float> function = (Float floatParameter) -> (int) floatParameter.floatValue();
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
        MutableObjectIntMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, i);
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableObjectIntMap<String> map0 = this.newWithKeysValues("0", 0, "1", 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(this.newWithKeysValues("0", 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent("0", 100));
        MutableObjectIntMap<String> map1 = this.newWithKeysValues("0", 0, "1", 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(this.newWithKeysValues("1", 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("5", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("50", 100));
        Assert.assertEquals(this.newWithKeysValues("0", 0, "1", 1, "2", 2), this.map);
        Assert.assertEquals(0, this.map.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(this.newWithKeysValues("1", 1, "2", 2), this.map);
        Assert.assertEquals(1, this.map.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(this.newWithKeysValues("2", 2), this.map);
        Assert.assertEquals(2, this.map.removeKeyIfAbsent("2", 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("2", 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0), 1);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1), 2);
        Assert.assertEquals(1, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, this.map.removeKeyIfAbsent(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(2, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, this.map.removeKeyIfAbsent(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1)));
        this.map.put(null, 3);
        Assert.assertEquals(3, this.map.get(null));
        Assert.assertEquals(3, this.map.removeKeyIfAbsent(null, 100));
        Assert.assertEquals(0, this.map.get(null));
    }

    @Test
    public void putWithRehash() throws Exception {
        MutableObjectIntMap<Integer> hashMap = this.getEmptyMap();
        for (int each = 2; each < 10; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }
        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int each = 2; each < 10; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put(10, 10);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll() {
        MutableObjectIntMap<Integer> hashMap = this.getEmptyMap();
        MutableObjectIntMap<Integer> copyMap = this.getEmptyMap();
        for (int each = 1; each < 11; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (int each = 1; each < 11; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto() {
        MutableObjectIntMap<Integer> hashMap = this.newWithKeysValues(1, 2, 2, 3, 3, 4, 4, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void put_every_slot() {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void remove_iterator_every_slot() {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        IntFunction<String> functionLength = (String string) -> string.length();
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(9, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"));
            Assert.assertEquals(9, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        IntFunction<Integer> function = Integer::intValue;
        MutableObjectIntMap<Integer> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(each));
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        IntFunction0 factory = () -> 100;
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(100, hashMap.getIfAbsentPut(String.valueOf(each), factory));
            Assert.assertEquals(100, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void updateValue_every_slot() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction));
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectIntMaps.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectIntHashMapTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectIntHashMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectIntHashMapTestCase> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectIntHashMapTestCase::keySet;
            this.payloads.values = ObjectIntHashMapTestCase::values;
            this.payloads.isEmpty = ObjectIntHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ObjectIntHashMapTestCase::notEmpty;
            this.payloads.asLazy = ObjectIntHashMapTestCase::asLazy;
            this.payloads.testEquals = ObjectIntHashMapTestCase::testEquals;
            this.payloads.testHashCode = ObjectIntHashMapTestCase::testHashCode;
            this.payloads.testToString = ObjectIntHashMapTestCase::testToString;
            this.payloads.intIterator = ObjectIntHashMapTestCase::intIterator;
            this.payloads.forEach = ObjectIntHashMapTestCase::forEach;
            this.payloads.forEachValue = ObjectIntHashMapTestCase::forEachValue;
            this.payloads.forEachKey = ObjectIntHashMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = ObjectIntHashMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectIntHashMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = ObjectIntHashMapTestCase::makeString;
            this.payloads.appendString = ObjectIntHashMapTestCase::appendString;
            this.payloads.select = ObjectIntHashMapTestCase::select;
            this.payloads.reject = ObjectIntHashMapTestCase::reject;
            this.payloads.tap = ObjectIntHashMapTestCase::tap;
            this.payloads.count = ObjectIntHashMapTestCase::count;
            this.payloads.anySatisfy = ObjectIntHashMapTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectIntHashMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectIntHashMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = ObjectIntHashMapTestCase::detectIfNone;
            this.payloads.collect = ObjectIntHashMapTestCase::collect;
            this.payloads.sum = ObjectIntHashMapTestCase::sum;
            this.payloads.max = ObjectIntHashMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectIntHashMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectIntHashMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectIntHashMapTestCase::minIfEmpty;
            this.payloads.average = ObjectIntHashMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectIntHashMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectIntHashMapTestCase::toArray;
            this.payloads.toSortedArray = ObjectIntHashMapTestCase::toSortedArray;
            this.payloads.containsAll = ObjectIntHashMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = ObjectIntHashMapTestCase::containsAll_Iterable;
            this.payloads.toList = ObjectIntHashMapTestCase::toList;
            this.payloads.toSortedList = ObjectIntHashMapTestCase::toSortedList;
            this.payloads.toSet = ObjectIntHashMapTestCase::toSet;
            this.payloads.toBag = ObjectIntHashMapTestCase::toBag;
            this.payloads.toImmutable = ObjectIntHashMapTestCase::toImmutable;
            this.payloads.clear = ObjectIntHashMapTestCase::clear;
            this.payloads.removeKey = ObjectIntHashMapTestCase::removeKey;
            this.payloads.remove = ObjectIntHashMapTestCase::remove;
            this.payloads.put = ObjectIntHashMapTestCase::put;
            this.payloads.updateValues = ObjectIntHashMapTestCase::updateValues;
            this.payloads.putPair = ObjectIntHashMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectIntHashMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectIntHashMapTestCase::get;
            this.payloads.getOrThrow = ObjectIntHashMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = ObjectIntHashMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectIntHashMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectIntHashMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectIntHashMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectIntHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectIntHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectIntHashMapTestCase::updateValue;
            this.payloads.addToValue = ObjectIntHashMapTestCase::addToValue;
            this.payloads.containsKey = ObjectIntHashMapTestCase::containsKey;
            this.payloads.containsValue = ObjectIntHashMapTestCase::containsValue;
            this.payloads.size = ObjectIntHashMapTestCase::size;
            this.payloads.withKeysValues = ObjectIntHashMapTestCase::withKeysValues;
            this.payloads.withoutKey = ObjectIntHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ObjectIntHashMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectIntHashMapTestCase::withAllKeyValues;
            this.payloads.contains = ObjectIntHashMapTestCase::contains;
            this.payloads.asUnmodifiable = ObjectIntHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ObjectIntHashMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = ObjectIntHashMapTestCase::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectIntHashMapTestCase::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectIntHashMapTestCase::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectIntHashMapTestCase::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectIntHashMapTestCase::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectIntHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectIntHashMapTestCase::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectIntHashMapTestCase::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectIntHashMapTestCase::putWithRehash;
            this.payloads.testPutAll = ObjectIntHashMapTestCase::testPutAll;
            this.payloads.injectInto = ObjectIntHashMapTestCase::injectInto;
            this.payloads.put_every_slot = ObjectIntHashMapTestCase::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectIntHashMapTestCase::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectIntHashMapTestCase::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectIntHashMapTestCase::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectIntHashMapTestCase::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectIntHashMapTestCase::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectIntHashMapTestCase::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectIntHashMapTestCase::classIsNonInstantiable;
        }
    }
*/
}
