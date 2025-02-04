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
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectCharHashMapTestCase extends AbstractMutableObjectCharMapTestCase {

    private final MutableObjectCharMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectCharMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);
        MutableObjectCharMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);
        MutableObjectCharMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
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
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3);
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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        CharToCharFunction function = (char parameter) -> parameter;
        hashMap.updateValue(2.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        hashMap.updateValue(5.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.updateValue(2.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectCharMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (char) i);
        }
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.put(2.0f, (char) 9);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        hashMap.getIfAbsentPut(2.0f, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.getIfAbsentPut(5.0f, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        // putting in a slot marked REMOVED
        hashMap.getIfAbsentPut(2.0f, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        CharFunction0 function = () -> (char) 5;
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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        CharFunction<Integer> function = (Integer object) -> (char) object.intValue();
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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        CharFunction<Float> function = (Float floatParameter) -> (char) floatParameter.floatValue();
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
        MutableObjectCharMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        for (int i = 2; i < 10; i++) {
            hashMap.put((float) i, (char) i);
        }
        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        // putting in a slot marked as REMOVED
        hashMap.put(2.0f, (char) 3);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent() {
        MutableObjectCharMap<String> map0 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("0", (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent("0", (char) 100));
        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("1", (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("5", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("50", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2), this.map);
        Assert.assertEquals((char) 0, this.map.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("1", (char) 1, "2", (char) 2), this.map);
        Assert.assertEquals((char) 1, this.map.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("2", (char) 2), this.map);
        Assert.assertEquals((char) 2, this.map.removeKeyIfAbsent("2", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("2", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 1);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 2);
        Assert.assertEquals((char) 1, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, this.map.removeKeyIfAbsent(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals((char) 0, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 2, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, this.map.removeKeyIfAbsent(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals((char) 0, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1)));
        this.map.put(null, (char) 3);
        Assert.assertEquals((char) 3, this.map.get(null));
        Assert.assertEquals((char) 3, this.map.removeKeyIfAbsent(null, (char) 100));
        Assert.assertEquals((char) 0, this.map.get(null));
    }

    @Test
    public void putWithRehash() throws Exception {
        MutableObjectCharMap<Character> hashMap = this.getEmptyMap();
        for (char each = 2; each < 10; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }
        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (char each = 2; each < 10; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put((char) 10, (char) 10);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll() {
        MutableObjectCharMap<Character> hashMap = this.getEmptyMap();
        MutableObjectCharMap<Character> copyMap = this.getEmptyMap();
        for (char each = 1; each < 11; each++) {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (char each = 1; each < 11; each++) {
            Assert.assertTrue(hashMap.containsKey(each));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto() {
        MutableObjectCharMap<Integer> hashMap = this.newWithKeysValues(1, (char) 2, 2, (char) 3, 3, (char) 4, 4, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void put_every_slot() {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void remove_iterator_every_slot() {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals((char) 9, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"));
            Assert.assertEquals((char) 9, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        CharFunction<Character> function = Character::charValue;
        MutableObjectCharMap<Character> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(each));
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        CharFunction0 factory = () -> (char) 100;
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals((char) 100, hashMap.getIfAbsentPut(String.valueOf(each), factory));
            Assert.assertEquals((char) 100, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void updateValue_every_slot() {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + 1);
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction));
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(ObjectCharMaps.class);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ObjectCharHashMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ObjectCharHashMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPut_Value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnClear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnUpdateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> occupiedWithSentinelsOnPutRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> remove_iterator_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> updateValue_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ObjectCharHashMapTestCase> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = ObjectCharHashMapTestCase::keySet;
            this.payloads.values = ObjectCharHashMapTestCase::values;
            this.payloads.isEmpty = ObjectCharHashMapTestCase::isEmpty;
            this.payloads.notEmpty = ObjectCharHashMapTestCase::notEmpty;
            this.payloads.asLazy = ObjectCharHashMapTestCase::asLazy;
            this.payloads.testEquals = ObjectCharHashMapTestCase::testEquals;
            this.payloads.testHashCode = ObjectCharHashMapTestCase::testHashCode;
            this.payloads.testToString = ObjectCharHashMapTestCase::testToString;
            this.payloads.charIterator = ObjectCharHashMapTestCase::charIterator;
            this.payloads.forEach = ObjectCharHashMapTestCase::forEach;
            this.payloads.forEachValue = ObjectCharHashMapTestCase::forEachValue;
            this.payloads.forEachKey = ObjectCharHashMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = ObjectCharHashMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ObjectCharHashMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = ObjectCharHashMapTestCase::makeString;
            this.payloads.appendString = ObjectCharHashMapTestCase::appendString;
            this.payloads.select = ObjectCharHashMapTestCase::select;
            this.payloads.reject = ObjectCharHashMapTestCase::reject;
            this.payloads.tap = ObjectCharHashMapTestCase::tap;
            this.payloads.count = ObjectCharHashMapTestCase::count;
            this.payloads.anySatisfy = ObjectCharHashMapTestCase::anySatisfy;
            this.payloads.allSatisfy = ObjectCharHashMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = ObjectCharHashMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = ObjectCharHashMapTestCase::detectIfNone;
            this.payloads.collect = ObjectCharHashMapTestCase::collect;
            this.payloads.sum = ObjectCharHashMapTestCase::sum;
            this.payloads.max = ObjectCharHashMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ObjectCharHashMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ObjectCharHashMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = ObjectCharHashMapTestCase::minIfEmpty;
            this.payloads.average = ObjectCharHashMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ObjectCharHashMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ObjectCharHashMapTestCase::toArray;
            this.payloads.toSortedArray = ObjectCharHashMapTestCase::toSortedArray;
            this.payloads.containsAll = ObjectCharHashMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = ObjectCharHashMapTestCase::containsAll_Iterable;
            this.payloads.toList = ObjectCharHashMapTestCase::toList;
            this.payloads.toSortedList = ObjectCharHashMapTestCase::toSortedList;
            this.payloads.toSet = ObjectCharHashMapTestCase::toSet;
            this.payloads.toBag = ObjectCharHashMapTestCase::toBag;
            this.payloads.toImmutable = ObjectCharHashMapTestCase::toImmutable;
            this.payloads.clear = ObjectCharHashMapTestCase::clear;
            this.payloads.removeKey = ObjectCharHashMapTestCase::removeKey;
            this.payloads.remove = ObjectCharHashMapTestCase::remove;
            this.payloads.put = ObjectCharHashMapTestCase::put;
            this.payloads.updateValues = ObjectCharHashMapTestCase::updateValues;
            this.payloads.putPair = ObjectCharHashMapTestCase::putPair;
            this.payloads.putDuplicateWithRemovedSlot = ObjectCharHashMapTestCase::putDuplicateWithRemovedSlot;
            this.payloads.get = ObjectCharHashMapTestCase::get;
            this.payloads.getOrThrow = ObjectCharHashMapTestCase::getOrThrow;
            this.payloads.getIfAbsent = ObjectCharHashMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentPut_Value = ObjectCharHashMapTestCase::getIfAbsentPut_Value;
            this.payloads.getAndPut = ObjectCharHashMapTestCase::getAndPut;
            this.payloads.getIfAbsentPut_Function = ObjectCharHashMapTestCase::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ObjectCharHashMapTestCase::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ObjectCharHashMapTestCase::getIfAbsentPutWithKey;
            this.payloads.updateValue = ObjectCharHashMapTestCase::updateValue;
            this.payloads.addToValue = ObjectCharHashMapTestCase::addToValue;
            this.payloads.containsKey = ObjectCharHashMapTestCase::containsKey;
            this.payloads.containsValue = ObjectCharHashMapTestCase::containsValue;
            this.payloads.size = ObjectCharHashMapTestCase::size;
            this.payloads.withKeysValues = ObjectCharHashMapTestCase::withKeysValues;
            this.payloads.withoutKey = ObjectCharHashMapTestCase::withoutKey;
            this.payloads.withoutAllKeys = ObjectCharHashMapTestCase::withoutAllKeys;
            this.payloads.withAllKeyValues = ObjectCharHashMapTestCase::withAllKeyValues;
            this.payloads.contains = ObjectCharHashMapTestCase::contains;
            this.payloads.asUnmodifiable = ObjectCharHashMapTestCase::asUnmodifiable;
            this.payloads.asSynchronized = ObjectCharHashMapTestCase::asSynchronized;
            this.payloads.flipUniqueValues = ObjectCharHashMapTestCase::flipUniqueValues;
            this.payloads.defaultInitialCapacity = ObjectCharHashMapTestCase::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ObjectCharHashMapTestCase::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ObjectCharHashMapTestCase::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ObjectCharHashMapTestCase::newMap;
            this.payloads.occupiedWithDataAndSentinelsOnClear = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnClear;
            this.payloads.occupiedWithDataAndSentinelsOnRemove = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnRemove;
            this.payloads.occupiedWithDataAndSentinelsOnUpdateValue = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnUpdateValue;
            this.payloads.occupiedWithDataAndSentinelsOnPut = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPut = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPut;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWith = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWith;
            this.payloads.occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey = ObjectCharHashMapTestCase::occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey;
            this.payloads.occupiedWithSentinelsOnPutRemovedSlot = ObjectCharHashMapTestCase::occupiedWithSentinelsOnPutRemovedSlot;
            this.payloads.removeKeyIfAbsent = ObjectCharHashMapTestCase::removeKeyIfAbsent;
            this.payloads.putWithRehash = ObjectCharHashMapTestCase::putWithRehash;
            this.payloads.testPutAll = ObjectCharHashMapTestCase::testPutAll;
            this.payloads.injectInto = ObjectCharHashMapTestCase::injectInto;
            this.payloads.put_every_slot = ObjectCharHashMapTestCase::put_every_slot;
            this.payloads.remove_iterator_every_slot = ObjectCharHashMapTestCase::remove_iterator_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ObjectCharHashMapTestCase::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ObjectCharHashMapTestCase::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ObjectCharHashMapTestCase::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ObjectCharHashMapTestCase::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ObjectCharHashMapTestCase::updateValue_every_slot;
            this.payloads.classIsNonInstantiable = ObjectCharHashMapTestCase::classIsNonInstantiable;
        }
    }
}
