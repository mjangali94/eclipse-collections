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
import org.eclipse.collections.api.block.function.primitive.FloatToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableFloatBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class FloatBooleanHashMapTest extends AbstractMutableFloatBooleanMapTestCase {

    @Override
    protected FloatBooleanHashMap classUnderTest() {
        return FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1) {
        return new FloatBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2) {
        return new FloatBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3) {
        return new FloatBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3, float key4, boolean value4) {
        return new FloatBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatBooleanHashMap getEmptyMap() {
        return new FloatBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        FloatBooleanHashMap hashMap2 = new FloatBooleanHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new FloatBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new FloatBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float i = 2.0f; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, ((int) i & 1) == 0.0f);
        }
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (float i = 2.0f; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put(10.0f, true);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (float i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, ((int) i & 1) == 0.0f);
        }
        Assert.assertEquals(256L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        MutableFloatBooleanMap copyMap = new FloatBooleanHashMap();
        for (float i = 1.0f; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, ((int) i & 1) == 0.0f);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (float i = 1.0f; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        FloatBooleanHashMap hashMap0 = new FloatBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, false, 2.0f, true), hashMap0);
        FloatBooleanHashMap hashMap1 = new FloatBooleanHashMap().withKeysValues(1.0f, false, 2.0f, true, 3.0f, false);
        FloatBooleanHashMap hashMap2 = new FloatBooleanHashMap().withKeysValues(1.0f, false, 2.0f, true, 3.0f, false, 4.0f, true);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true), hashMap0);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true, 3.0f, false), hashMap1);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true, 3.0f, false, 4.0f, true), hashMap2);
    }

    @Test
    public void injectInto() {
        FloatBooleanHashMap hashMap0 = new FloatBooleanHashMap().withKeysValues(1.0f, false, 2.0f, true, 3.0f, false, 4.0f, false);
        Float total = hashMap0.injectInto(Float.valueOf(0.0f), (Float result, boolean value) -> value ? result : Float.valueOf((float) (result + 2.0f)));
        Assert.assertEquals(Float.valueOf(6.0f), total);
    }

    @Test
    public void put_every_slot() {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableFloatBooleanMap hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        FloatToBooleanFunction function = (float each) -> each % 2 == 0;
        MutableFloatBooleanMap hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableFloatBooleanMap hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float each = 2.0f; each < 100.0f; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private FloatBooleanHashMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
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
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
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
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
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
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_invocation_of_remove_before_next);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws_on_consecutive_invocation_of_remove);
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
        public void benchmark_putWithRehash() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putWithRehash);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new FloatBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<FloatBooleanHashMapTest> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = FloatBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = FloatBooleanHashMapTest::notEmpty;
            this.payloads.testEquals = FloatBooleanHashMapTest::testEquals;
            this.payloads.testHashCode = FloatBooleanHashMapTest::testHashCode;
            this.payloads.testToString = FloatBooleanHashMapTest::testToString;
            this.payloads.forEach = FloatBooleanHashMapTest::forEach;
            this.payloads.forEachValue = FloatBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = FloatBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = FloatBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = FloatBooleanHashMapTest::makeString;
            this.payloads.appendString = FloatBooleanHashMapTest::appendString;
            this.payloads.select = FloatBooleanHashMapTest::select;
            this.payloads.reject = FloatBooleanHashMapTest::reject;
            this.payloads.select_value = FloatBooleanHashMapTest::select_value;
            this.payloads.reject_value = FloatBooleanHashMapTest::reject_value;
            this.payloads.collect = FloatBooleanHashMapTest::collect;
            this.payloads.count = FloatBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = FloatBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = FloatBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = FloatBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = FloatBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = FloatBooleanHashMapTest::toList;
            this.payloads.toSet = FloatBooleanHashMapTest::toSet;
            this.payloads.toBag = FloatBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = FloatBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = FloatBooleanHashMapTest::asLazy;
            this.payloads.keysView = FloatBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = FloatBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = FloatBooleanHashMapTest::toArray;
            this.payloads.toImmutable = FloatBooleanHashMapTest::toImmutable;
            this.payloads.clear = FloatBooleanHashMapTest::clear;
            this.payloads.removeKey = FloatBooleanHashMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = FloatBooleanHashMapTest::removeKeyIfAbsent;
            this.payloads.put = FloatBooleanHashMapTest::put;
            this.payloads.updateValues = FloatBooleanHashMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = FloatBooleanHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = FloatBooleanHashMapTest::get;
            this.payloads.getIfAbsent = FloatBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = FloatBooleanHashMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = FloatBooleanHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = FloatBooleanHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = FloatBooleanHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = FloatBooleanHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = FloatBooleanHashMapTest::updateValue;
            this.payloads.containsKey = FloatBooleanHashMapTest::containsKey;
            this.payloads.containsValue = FloatBooleanHashMapTest::containsValue;
            this.payloads.contains = FloatBooleanHashMapTest::contains;
            this.payloads.containsAll = FloatBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = FloatBooleanHashMapTest::containsAllIterable;
            this.payloads.size = FloatBooleanHashMapTest::size;
            this.payloads.withoutKey = FloatBooleanHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = FloatBooleanHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = FloatBooleanHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = FloatBooleanHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = FloatBooleanHashMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = FloatBooleanHashMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = FloatBooleanHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = FloatBooleanHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.defaultInitialCapacity = FloatBooleanHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = FloatBooleanHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(FloatBooleanHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = FloatBooleanHashMapTest::newMap;
            this.payloads.putWithRehash = FloatBooleanHashMapTest::putWithRehash;
            this.payloads.testPutAll = FloatBooleanHashMapTest::testPutAll;
            this.payloads.withKeysValues = FloatBooleanHashMapTest::withKeysValues;
            this.payloads.injectInto = FloatBooleanHashMapTest::injectInto;
            this.payloads.put_every_slot = FloatBooleanHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = FloatBooleanHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = FloatBooleanHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = FloatBooleanHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = FloatBooleanHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = FloatBooleanHashMapTest::updateValue_every_slot;
        }
    }
}
