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
import org.eclipse.collections.api.block.function.primitive.ByteToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableByteBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class ByteBooleanHashMapTest extends AbstractMutableByteBooleanMapTestCase {

    @Override
    protected ByteBooleanHashMap classUnderTest() {
        return ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true);
    }

    @Override
    protected ByteBooleanHashMap newWithKeysValues(byte key1, boolean value1) {
        return new ByteBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteBooleanHashMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2) {
        return new ByteBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteBooleanHashMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3) {
        return new ByteBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteBooleanHashMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4) {
        return new ByteBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteBooleanHashMap getEmptyMap() {
        return new ByteBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ByteBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ByteBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        ByteBooleanHashMap hashMap2 = new ByteBooleanHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ByteBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ByteBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new ByteBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        for (byte i = (byte) 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (byte) 0);
        }
        Field keys = ByteBooleanHashMap.class.getDeclaredField("keys");
        Field values = ByteBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (byte i = (byte) 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put((byte) 10, true);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (byte i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (byte) 0);
        }
        Assert.assertEquals(256L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        MutableByteBooleanMap copyMap = new ByteBooleanHashMap();
        for (byte i = (byte) 1; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == (byte) 0);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (byte i = (byte) 1; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ByteBooleanHashMap hashMap0 = new ByteBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, false, (byte) 2, true), hashMap0);
        ByteBooleanHashMap hashMap1 = new ByteBooleanHashMap().withKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false);
        ByteBooleanHashMap hashMap2 = new ByteBooleanHashMap().withKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false, (byte) 4, true);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 2, true), hashMap0);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false), hashMap1);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false, (byte) 4, true), hashMap2);
    }

    @Test
    public void injectInto() {
        ByteBooleanHashMap hashMap0 = new ByteBooleanHashMap().withKeysValues((byte) 1, false, (byte) 2, true, (byte) 3, false, (byte) 4, false);
        Byte total = hashMap0.injectInto(Byte.valueOf((byte) 0), (Byte result, boolean value) -> value ? result : Byte.valueOf((byte) (result + (byte) 2)));
        Assert.assertEquals(Byte.valueOf((byte) 6), total);
    }

    @Test
    public void put_every_slot() {
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableByteBooleanMap hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        ByteToBooleanFunction function = (byte each) -> each % 2 == 0;
        MutableByteBooleanMap hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableByteBooleanMap hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        ByteBooleanHashMap hashMap = new ByteBooleanHashMap();
        for (byte each = (byte) 2; each < (byte) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableByteBooleanMapTestCase._Benchmark {

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

        private ByteBooleanHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ByteBooleanHashMapTest();
        }

        @java.lang.Override
        public ByteBooleanHashMapTest implementation() {
            return this.implementation;
        }
    }
}
