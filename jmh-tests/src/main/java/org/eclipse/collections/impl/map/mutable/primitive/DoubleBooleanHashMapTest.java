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
import org.eclipse.collections.api.block.function.primitive.DoubleToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableDoubleBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class DoubleBooleanHashMapTest extends AbstractMutableDoubleBooleanMapTestCase {

    @Override
    protected DoubleBooleanHashMap classUnderTest() {
        return DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false, 32.0, true);
    }

    @Override
    protected DoubleBooleanHashMap newWithKeysValues(double key1, boolean value1) {
        return new DoubleBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleBooleanHashMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2) {
        return new DoubleBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleBooleanHashMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3) {
        return new DoubleBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleBooleanHashMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3, double key4, boolean value4) {
        return new DoubleBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleBooleanHashMap getEmptyMap() {
        return new DoubleBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = DoubleBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = DoubleBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        DoubleBooleanHashMap hashMap2 = new DoubleBooleanHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new DoubleBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = DoubleBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new DoubleBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double i = 2.0; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, ((int) i & 1) == 0.0);
        }
        Field keys = DoubleBooleanHashMap.class.getDeclaredField("keys");
        Field values = DoubleBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (double i = 2.0; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put(10.0, true);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (double i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, ((int) i & 1) == 0.0);
        }
        Assert.assertEquals(256L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        MutableDoubleBooleanMap copyMap = new DoubleBooleanHashMap();
        for (double i = 1.0; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, ((int) i & 1) == 0.0);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (double i = 1.0; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        DoubleBooleanHashMap hashMap0 = new DoubleBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, false, 2.0, true), hashMap0);
        DoubleBooleanHashMap hashMap1 = new DoubleBooleanHashMap().withKeysValues(1.0, false, 2.0, true, 3.0, false);
        DoubleBooleanHashMap hashMap2 = new DoubleBooleanHashMap().withKeysValues(1.0, false, 2.0, true, 3.0, false, 4.0, true);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 2.0, true), hashMap0);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 2.0, true, 3.0, false), hashMap1);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 2.0, true, 3.0, false, 4.0, true), hashMap2);
    }

    @Test
    public void injectInto() {
        DoubleBooleanHashMap hashMap0 = new DoubleBooleanHashMap().withKeysValues(1.0, false, 2.0, true, 3.0, false, 4.0, false);
        Double total = hashMap0.injectInto(Double.valueOf(0.0), (Double result, boolean value) -> value ? result : Double.valueOf((double) (result + 2.0)));
        Assert.assertEquals(Double.valueOf(6.0), total);
    }

    @Test
    public void put_every_slot() {
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableDoubleBooleanMap hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        DoubleToBooleanFunction function = (double each) -> each % 2 == 0;
        MutableDoubleBooleanMap hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableDoubleBooleanMap hashMap = this.getEmptyMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double each = 2.0; each < 100.0; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends org.eclipse.collections.impl.map.mutable.primitive.AbstractMutableDoubleBooleanMapTestCase._Benchmark {

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

        private DoubleBooleanHashMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubleBooleanHashMapTest();
        }

        @java.lang.Override
        public DoubleBooleanHashMapTest implementation() {
            return this.implementation;
        }
    }
}
