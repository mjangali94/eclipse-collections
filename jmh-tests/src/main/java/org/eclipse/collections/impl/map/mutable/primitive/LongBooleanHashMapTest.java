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
import java.util.BitSet;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.LongToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableLongBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class LongBooleanHashMapTest extends AbstractMutableLongBooleanMapTestCase {

    @Override
    protected LongBooleanHashMap classUnderTest() {
        return LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false, 32L, true);
    }

    @Override
    protected LongBooleanHashMap newWithKeysValues(long key1, boolean value1) {
        return new LongBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongBooleanHashMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2) {
        return new LongBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongBooleanHashMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3) {
        return new LongBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongBooleanHashMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3, long key4, boolean value4) {
        return new LongBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongBooleanHashMap getEmptyMap() {
        return new LongBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = LongBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = LongBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongBooleanHashMap hashMap = new LongBooleanHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        LongBooleanHashMap hashMap2 = new LongBooleanHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new LongBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = LongBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new LongBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        for (long i = 2L; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == 0L);
        }
        Field keys = LongBooleanHashMap.class.getDeclaredField("keys");
        Field values = LongBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (long i = 2L; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put(10L, true);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (long i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == 0L);
        }
        Assert.assertEquals(256L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        MutableLongBooleanMap copyMap = new LongBooleanHashMap();
        for (long i = 1L; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == 0L);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (long i = 1L; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        LongBooleanHashMap hashMap0 = new LongBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, false, 2L, true), hashMap0);
        LongBooleanHashMap hashMap1 = new LongBooleanHashMap().withKeysValues(1L, false, 2L, true, 3L, false);
        LongBooleanHashMap hashMap2 = new LongBooleanHashMap().withKeysValues(1L, false, 2L, true, 3L, false, 4L, true);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true), hashMap0);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true, 3L, false), hashMap1);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 2L, true, 3L, false, 4L, true), hashMap2);
    }

    @Test
    public void injectInto() {
        LongBooleanHashMap hashMap0 = new LongBooleanHashMap().withKeysValues(1L, false, 2L, true, 3L, false, 4L, false);
        Long total = hashMap0.injectInto(Long.valueOf(0L), (Long result, boolean value) -> value ? result : Long.valueOf((long) (result + 2L)));
        Assert.assertEquals(Long.valueOf(6L), total);
    }

    @Test
    public void put_every_slot() {
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableLongBooleanMap hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        LongToBooleanFunction function = (long each) -> each % 2 == 0;
        MutableLongBooleanMap hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableLongBooleanMap hashMap = this.getEmptyMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        for (long each = 2L; each < 100L; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableLongBooleanMapTestCase._Benchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_defaultInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::defaultInitialCapacity, this.description("defaultInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newWithInitialCapacity, this.description("newWithInitialCapacity"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithInitialCapacity_negative_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::newWithInitialCapacity_negative_throws, this.description("newWithInitialCapacity_negative_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::newMap, this.description("newMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::putWithRehash, this.description("putWithRehash"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testPutAll, this.description("testPutAll"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::withKeysValues, this.description("withKeysValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::put_every_slot, this.description("put_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_every_slot, this.description("getIfAbsentPut_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith_every_slot, this.description("getIfAbsentPutWith_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWithKey_every_slot, this.description("getIfAbsentPutWithKey_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut_Function_every_slot, this.description("getIfAbsentPut_Function_every_slot"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue_every_slot() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::updateValue_every_slot, this.description("updateValue_every_slot"));
        }

        private LongBooleanHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new LongBooleanHashMapTest();
        }

        @java.lang.Override
        public LongBooleanHashMapTest implementation() {
            return this.implementation;
        }
    }
}
